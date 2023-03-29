package com.newsData.newsDataAPI.dataAccessLayer;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class topStoriesData {

    private static final Logger logger= LoggerFactory.getLogger(topStoriesData.class);
    public JSONArray getTopUserStories() {
        JSONArray dataObject = null;
        try {
            URL url = new URL("https://hacker-news.firebaseio.com/v0/newstories.json?print=pretty");

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            logger.info("fetching top User Stories from api"+url);

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

                //JSON simple library Setup with Maven is used to convert strings to JSON
                JSONParser parse = new JSONParser();
                dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dataObject;
    }
}
