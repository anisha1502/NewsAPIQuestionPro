package com.newsData.newsDataAPI.service;

import com.newsData.newsDataAPI.entity.items;

import java.util.Comparator;

public class scoreComparator implements Comparator<items> {
    @Override
    public int compare(items o1, items o2) {
        if(o2.getScore()==o1.getScore())
        {
            return 0;
        }
        else if(o2.getScore()>o1.getScore())
        {
            return 1;
        }
        else {
            return -1;
        }
    }
}
