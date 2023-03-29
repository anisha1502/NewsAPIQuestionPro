package com.newsData.newsDataAPI;
import com.newsData.newsDataAPI.dataAccessLayer.topStoriesData;
import com.newsData.newsDataAPI.service.topUserStoriesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import static org.springframework.boot.SpringApplication.run;

@EnableCaching
@SpringBootApplication
public class NewsDataApiApplication {

	public static void main(String[] args) {
		run(NewsDataApiApplication.class, args);

	}


}
