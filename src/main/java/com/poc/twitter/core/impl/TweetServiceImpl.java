package com.poc.twitter.core.impl;

import com.poc.twitter.core.TweetService;
import com.poc.twitter.model.Tweet;
import com.poc.twitter.persistence.TweetDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetDataService tweetDataService;

    @Override
    public List<Tweet> getTweets(String userName) {
        List<Tweet> tweets = new ArrayList<Tweet>();
        try {
            tweets = tweetDataService.getTweets(userName);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("error occurred while getting user tweets " + e.getMessage());
        }
        return tweets;
    }

    @Override
    public boolean addTweet(Tweet tweet) {
        boolean added = false;
        try {
            added = tweetDataService.addTweet(tweet);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("error occurred while added tweet " + e.getMessage());
        }
        return added;
    }
}
