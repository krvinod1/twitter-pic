package com.poc.twitter.model;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserFeedsTest {

    private UserFeeds userFeeds = new UserFeeds();

    @Test
    public void userName() {
        String  value = "username";
        userFeeds.setName(value);
        assertEquals(value, userFeeds.getName());
    }

    @Test
    public void userFeeds() {
        String value = "followee";
        List<Tweet>  tweets = new ArrayList<Tweet>();
        Tweet tweet = new Tweet();
        tweet.setUserName("foo");
        tweet.setContent("foo conent");
        tweets.add(tweet);
        userFeeds.setFeeds(tweets);
        assertNotNull(userFeeds.getFeeds());
        assertEquals(1, userFeeds.getFeeds().size());
    }
}