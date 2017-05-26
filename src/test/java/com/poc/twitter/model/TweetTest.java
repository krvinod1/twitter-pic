package com.poc.twitter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TweetTest {

    private Tweet tweet = new Tweet();

    @Test
    public void userName() {
        String value ="username";
        tweet.setUserName(value);
        assertEquals(value, tweet.getUserName());
    }

    @Test
    public void content() {
        String value ="content";
        tweet.setContent(value);
        assertEquals(value, tweet.getContent());
    }
}