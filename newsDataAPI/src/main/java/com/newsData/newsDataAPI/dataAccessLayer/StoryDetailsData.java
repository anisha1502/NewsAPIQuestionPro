package com.newsData.newsDataAPI.dataAccessLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.newsData.newsDataAPI.controller.newsAPIController;
import com.newsData.newsDataAPI.entity.items;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class StoryDetailsData {

    private static final Logger logger=LoggerFactory.getLogger(StoryDetailsData.class);
    public items getStoryDetails(int id) {
        JSONObject dataObject = null;
        items item = null;
        try {
            URL url = new URL("https://hacker-news.firebaseio.com/v0/item/" + id + ".json?print=pretty");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            logger.info("fetching StoryDetails from api"+url);
            //Check if connect is made
            int responseCode = conn.getResponseCode();

            // 200 OK
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {
                logger.info("data has been fetched with httpresponsecode:200 from "+url);
                StringBuilder informationString = new StringBuilder();
                try(Scanner scanner = new Scanner(url.openStream())) {

                    while (scanner.hasNext()) {
                        informationString.append(scanner.nextLine());
                    }
                }
                // JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                dataObject = (JSONObject) parse.parse(String.valueOf(informationString));
                ObjectMapper mapper = new ObjectMapper();
                item = mapper.readValue(dataObject.toString(), items.class);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return item;

    }
}
