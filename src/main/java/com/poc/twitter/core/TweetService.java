package com.poc.twitter.core;

import com.poc.twitter.model.Tweet;

import java.util.List;

public interface TweetService {
    List<Tweet> getTweets(String userName);
    boolean addTweet(Tweet tweet);
}
