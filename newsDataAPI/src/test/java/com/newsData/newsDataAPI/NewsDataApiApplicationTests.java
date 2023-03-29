package com.newsData.newsDataAPI;

import com.newsData.newsDataAPI.dataAccessLayer.StoryDetailsData;
import com.newsData.newsDataAPI.entity.comment;
import com.newsData.newsDataAPI.entity.items;
import com.newsData.newsDataAPI.service.pastStoriesService;
import com.newsData.newsDataAPI.service.topCommentsService;
import com.newsData.newsDataAPI.service.topUserStoriesService;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import com.newsData.newsDataAPI.controller.newsAPIController;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import com.newsData.newsDataAPI.dataAccessLayer.topStoriesData;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
class NewsDataApiApplicationTests {

	@InjectMocks
	private newsAPIController newsAPIController;

	@Autowired
	private topStoriesData topStoriesData;

	@Autowired
	private StoryDetailsData storyDetailsData;

	@Autowired
	private MockMvc mockMvc;

	@Mock
	private topUserStoriesService topUserStoriesService;

	@Mock
	private pastStoriesService pastStoriesService;

	@Mock
	private topCommentsService topcommentsService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(newsAPIController).build();
	}

	@Test
	public void testFindTopStoriesController() throws Exception {
		ArrayList<items> expected = new ArrayList<>();
		expected.add(new items(123456, false, "story", "JohnDoe", "2023-03-28 10:30", "This is the text of the story.", false, null, null,new ArrayList<Integer>(),"https://www.example.com", 100, "Sample Title", null, 10));
		expected.add(new items(903456, true, "poll", "Smith John", "2023-03-29 11:45", "This is the text of the poll.", false, null, null,new ArrayList<Integer>(),"https://www.example.com", 145, "Sample Title", null, 13));
		when(topUserStoriesService.getTopUserStoriesDetails()).thenReturn(expected);
		ArrayList<items> actual = newsAPIController.findTopStories();
		assertEquals(expected.size(), actual.size());
		assertEquals(expected, actual);
	}

	@Test
	public void testFindPastStoriesController() throws Exception {
		ArrayList<items> expected = new ArrayList<>();
		expected.add(new items(987689, false, "story", "Mark", "2023-03-28 10:30", "This is the text of the story.", false, null, null,new ArrayList<Integer>(),"https://www.example.com", 100, "Sample Title", null, 10));
		expected.add(new items(783456, true, "poll", "Kate", "2023-03-29 11:45", "This is the text of the poll.", false, null, null,new ArrayList<Integer>(),"https://www.example.com", 145, "Sample Title", null, 13));
		when(pastStoriesService.getPastStories()).thenReturn(expected);
		ArrayList<items> actual = newsAPIController.findPastStories();
		assertEquals(expected.size(), actual.size());
		assertEquals(expected, actual);
	}

	@Test
	public void testFindTopCommentsController() {
		int storyId = 123;
		ArrayList<comment> expectedComments = new ArrayList<>();
		expectedComments.add(new comment("This is the first comment", "John Doe", 5, 10));
		expectedComments.add(new comment("Another comment here", "Jane Smith", 3, 7));
		when(topcommentsService.getTopComments(storyId)).thenReturn(expectedComments);
		ArrayList<comment> actualComments = newsAPIController.findTopComments(storyId);
		assertEquals(expectedComments, actualComments);
	}


	@Test
	void testGetTopUserStories() {
		try {
			// Make HTTP connection to the API endpoint
			URL url = new URL("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			// Check if connection is made
			int responseCode = conn.getResponseCode();
			assertEquals(200, responseCode, "Connection failed with HTTP response code " + responseCode);

			// Parse the response JSON and check for expected results
			org.json.simple.JSONArray result = topStoriesData.getTopUserStories();
			assertNotNull(result, "Response is null");
			assertFalse(result.isEmpty(), "Response is empty");

			// TODO: Add more checks on the response data as needed
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

	@Test
	void testGetStoryDetails() {
		try {
			// Make HTTP connection to the API endpoint

			Integer id=34565;
			URL url = new URL("https://hacker-news.firebaseio.com/v0/item/" + id + ".json?print=pretty");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			// Check if connection is made
			int responseCode = conn.getResponseCode();
			assertEquals(200, responseCode, "Connection failed with HTTP response code " + responseCode);


		    items result = storyDetailsData.getStoryDetails(id);
			assertNotNull(result, "Response is null");

			// Check that the item has the expected ID
			assertEquals(id, result.getId(), "ID does not match");

			// TODO: Add more checks on the item properties as needed
		} catch (Exception e) {
			fail("Exception thrown: " + e.getMessage());
		}
	}

}
