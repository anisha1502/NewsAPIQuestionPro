package com.newsData.newsDataAPI.controller;
import com.newsData.newsDataAPI.entity.comment;
import com.newsData.newsDataAPI.entity.items;
import com.newsData.newsDataAPI.service.pastStoriesService;
import com.newsData.newsDataAPI.service.topCommentsService;
import com.newsData.newsDataAPI.service.topUserStoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class newsAPIController {
    private static final Logger logger=LoggerFactory.getLogger(newsAPIController.class);

    @Autowired
    private  pastStoriesService pastStoriesService;
    @Autowired
    private topUserStoriesService topUserStoriesservice;
    @Autowired
    private topCommentsService commentsService;

    @GetMapping("/top-stories")
    public ArrayList<items> findTopStories() {
        ArrayList<items> topUserStoriesOutput=new ArrayList<>();
        try {
            topUserStoriesOutput = topUserStoriesservice.getTopUserStoriesDetails();
        }
        catch(Exception e)
        {
            logger.error("Service Retrieval Exception at topUserStoriesservice",e);
        }
        return topUserStoriesOutput;
    }

    @GetMapping("/past-stories")
    public ArrayList<items> findPastStories() {
        ArrayList<items> pastUserStoriesOutput=new ArrayList<>();
        try {
            pastUserStoriesOutput = pastStoriesService.getPastStories();
        }
        catch(Exception e)
        {
            logger.error("Service Retrieval Exception at pastStoriesservice",e);
        }
        return pastUserStoriesOutput;
    }

    @GetMapping("/comments/{storyId}")
    public ArrayList<comment> findTopComments(@PathVariable Integer storyId)
    {
        ArrayList<comment> topCommentsOutput=new ArrayList<>();
        try {
            topCommentsOutput = commentsService.getTopComments(storyId);
        }
        catch(Exception e)
        {
            logger.error("Service Retrieval Exception at getTopComments",e);
        }
        return topCommentsOutput;
    }


}
