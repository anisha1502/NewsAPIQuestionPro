package com.newsData.newsDataAPI.service;

import com.newsData.newsDataAPI.dataAccessLayer.StoryDetailsData;
import com.newsData.newsDataAPI.entity.comment;
import com.newsData.newsDataAPI.entity.items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;


@Service
public class topCommentsService {
@Autowired
    private StoryDetailsData storyDetailsData;
    @Cacheable(cacheNames = "topComments",key ="#root.methodName",value =
            "topComments")
    public ArrayList<comment> getTopComments(Integer storyId)
    {
        ArrayList<comment> childComments=new ArrayList<>();
        items storyitem =storyDetailsData.getStoryDetails(storyId);
        for(Integer childList:storyitem.getKids())
        {
            items comment=storyDetailsData.getStoryDetails(childList);
            comment childComment=new comment();
            childComment.setText(comment.getText());
            childComment.setBy(comment.getBy());
            childComment.setDescendents(comment.getDescendants());
            childComment.setCount(comment.getKids()==null?0:comment.getKids().size());
            childComments.add(childComment);
        }
        Collections.sort(childComments,new childCommentComparator());
        return childComments;


    }
}
