package com.poc.twitter.core;

import com.poc.twitter.Application;
import com.poc.twitter.core.impl.TweetServiceImpl;
import com.poc.twitter.model.Tweet;
import com.poc.twitter.persistence.TweetDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(Application.class)
public class TweetServiceTest {

    @Mock
    TweetDataService tweetDataServiceMock;
    @InjectMocks
    TweetService tweetService = new TweetServiceImpl(); ;

    @Test
    public void getTweets() throws Exception {
        tweetService.getTweets("foo");
        verify(tweetDataServiceMock, times(1)).getTweets("foo");
    }

    @Test
    public void addTweet() throws Exception {
        Tweet tweet = new Tweet();
        tweetService.addTweet(tweet);
        verify(tweetDataServiceMock, times(1)).addTweet(tweet);
    }
}