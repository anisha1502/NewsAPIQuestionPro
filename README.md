<h1 align="center">README</h1>
<h2>Introduction</h2>
The NewsAPI Spring Boot application uses restful web services to consume data from the <strong>"https://hacker-news.firebaseio.com/v0/newstories.json?print=pretty"</strong> Firebase API and display top stories, top comments, and past stories. It uses a cache manager that is configured with a Time-to-Live (TTL) of 15 minutes to cache data after the user hits the API.

<h2>Features</h2>
The NewsAPI Spring Boot application provides the following features:

<strong>Top stories</strong>: Displays the top ten stories that have been posted in the last 15 minutes sorted by the order of their score.

<strong>Top comments</strong>: Displays the top ten comments of a given story that has been sorted based on the number of child comments.

<strong>Past stories</strong>: Displays past stories that have been posted from the endpoint of top stories.

<strong>Cache Manager</strong>: To implement fast access of data rather fetching it and recalculating .
<h2>Requirements</h2>
The fully-fledged server uses the following:

Spring Framework
Spring Boot
Docker
Postman
<h2>Dependencies</h2>
There are a number of third-party dependencies used in the project. Browse the Maven <strong>pom.xml</strong> file for details of libraries and versions used.

<h2>Building the project</h2>
To build the project, you will need:

Java JDK 8 or higher
Maven 3.1.1 or higher
Git
Follow these steps to build the server:

Clone the project.<br>
Open a terminal window and navigate to the project root directory.<br>
Run the following command to build the server:<br>
$ mvn clean install
<h2>Testing with Docker</h2>
Follow these steps to test the NewsAPI Spring Boot application in a Docker container:

Refer to the <strong>Dockerfile</strong>.
Run the following command to create a Docker image:<br>
$ docker build -t spring-boot-docker.jar .<br>
Run the following command to start a Docker container:<br>
$ docker run -p 9000:9000 spring-boot-docker.jar
<h2>Conclusion</h2>
The NewsAPI Spring Boot application is a useful tool for developers who want to consume data from the Hacker News Firebase API. With its cache manager and intuitive user interface, this application provides developers with the ability to quickly and easily access the latest news stories and comments.
