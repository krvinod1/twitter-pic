package com.poc.twitter.persistence;

import com.poc.twitter.model.Tweet;

import java.util.List;

public interface TweetDataService {
    List<Tweet> getTweets(String userName) throws  Exception;
    boolean addTweet(Tweet tweet) throws Exception;
}
