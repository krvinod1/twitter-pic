package com.poc.twitter.persistence;

import com.poc.twitter.model.Tweet;
import com.poc.twitter.persistence.h2db.H2TweetDataService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TweetDataServiceTest {

    private TweetDataService tweetDataService = new H2TweetDataService();

    @Test
    public void getTweets() throws Exception {
        List<Tweet> tweets = tweetDataService.getTweets("foo");
        assertNotNull(tweets);
        assertEquals(3, tweets.size());
    }

    @Test
    public void getTweetsForNonExistUser() throws Exception {
        List<Tweet> tweets = tweetDataService.getTweets("kkk");
        assertNotNull(tweets);
        assertEquals(0, tweets.size());
    }

    @Test
    public void addTweet() throws Exception {
        Tweet tweet = new Tweet();
        tweet.setUserName("bar");
        tweet.setContent("latest update");
        tweetDataService.addTweet(tweet);
        List<Tweet> tweets = tweetDataService.getTweets("bar");
        assertNotNull(tweets);
        assertEquals(3, tweets.size());
    }
}