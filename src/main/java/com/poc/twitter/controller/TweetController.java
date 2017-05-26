package com.poc.twitter.controller;

import com.poc.twitter.core.TweetService;
import com.poc.twitter.model.Tweet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TweetController {

    @Autowired
    private TweetService tweetService;

    @RequestMapping(value = "/users/{userName}/tweets")
    public ResponseEntity<List<Tweet>> getTweets(@PathVariable("userName") String userName) {
        return new ResponseEntity<List<Tweet>>(tweetService.getTweets(userName), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userName}/tweets", method = RequestMethod.POST)
    public ResponseEntity<Void> addTweet(@PathVariable("userName") String userName, @RequestBody Tweet tweet) {
        tweet.setUserName(userName);
        tweetService.addTweet(tweet);
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }
}
