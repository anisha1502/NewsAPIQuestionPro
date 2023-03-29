package com.newsData.newsDataAPI.service;
import com.newsData.newsDataAPI.dataAccessLayer.StoryDetailsData;
import com.newsData.newsDataAPI.dataAccessLayer.topStoriesData;
import com.newsData.newsDataAPI.entity.items;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;



@Service
public class pastStoriesService {

    @Autowired
    StoryDetailsData storyDetailsData;

    @Autowired
    topStoriesData topStoriesData;
    @Cacheable(cacheNames = "pastStories",key ="#root.methodName",value = "pastStories")
    public ArrayList<items> getPastStories()
    {
        JSONArray LIST=topStoriesData.getTopUserStories();
       return  getStoriesFromEndpoint(LIST);

    }

    private ArrayList<items> getStoriesFromEndpoint(JSONArray list) {
        ArrayList<items> pastUserStories=new ArrayList<items>();
        if (list != null) {
            int len = 11;
            for (int i=len;i<50;i++){
                pastUserStories.add(storyDetailsData.getStoryDetails(new Integer(list.get(i).toString())));
            }
        }
       return pastUserStories;

    }
}
