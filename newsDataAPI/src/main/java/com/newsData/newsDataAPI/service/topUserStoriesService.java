package com.newsData.newsDataAPI.service;
import com.newsData.newsDataAPI.dataAccessLayer.StoryDetailsData;
import com.newsData.newsDataAPI.dataAccessLayer.topStoriesData;
import com.newsData.newsDataAPI.entity.items;
import org.json.simple.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;

@Service
public class topUserStoriesService {
@Autowired
    topStoriesData topStoriesData;
@Autowired
StoryDetailsData storyDetailsData;
    @Cacheable(cacheNames = "topStories",key ="#root.methodName",value = "topStories")
    public ArrayList<items> getTopUserStoriesDetails()
    {
        JSONArray LIST=topStoriesData.getTopUserStories();
        ArrayList<String> topTenList=getTopTenUserStories(LIST);
        ArrayList<items> topTenUserStories=new ArrayList<items>();
        for(String i:topTenList)
        {
            topTenUserStories.add(storyDetailsData.getStoryDetails(new Integer(i)));
        }
        Collections.sort(topTenUserStories,new scoreComparator());
        return topTenUserStories;
    }

    private ArrayList<String> getTopTenUserStories(JSONArray list) {
        ArrayList<String> topTenUserStories=new ArrayList<String>();
        if (list != null) {
            int len = 10;
            for (int i=0;i<len;i++){
                topTenUserStories.add(list.get(i).toString());
            }
        }
        return topTenUserStories;

    }


}
