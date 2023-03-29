package com.newsData.newsDataAPI.service;

import com.newsData.newsDataAPI.entity.comment;
import com.newsData.newsDataAPI.entity.items;

import java.util.Comparator;

public class childCommentComparator implements Comparator<comment> {

    @Override
    public int compare(comment o1, comment o2) {
        if(o1.getCount()==o2.getCount())
        {
            return 0;
        }
        else if(o1.getCount()<o2.getCount())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
}
