package com.poc.twitter.persistence.h2db;

import com.poc.twitter.model.Tweet;
import com.poc.twitter.persistence.TweetDataService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("userTweetService")
public class H2TweetDataService implements TweetDataService {

    @Override
    public List<Tweet> getTweets(String userName) throws Exception{
        List<Tweet> tweets = new ArrayList<Tweet>();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = H2DatabaseManager.getInstance().getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("select user_id, content, created_at from TWEETS where" +
                    " user_id = ? ORDER BY created_at DESC " );
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Tweet tweet = new Tweet();
                tweet.setContent(rs.getString("content"));
                tweet.setCreatedDate(rs.getString("created_at"));
                tweet.setUserName(rs.getString("user_id"));
                tweets.add(tweet);
            }
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("Error occured while fetching user Tweet " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
            if ( stmt != null) {
                stmt.close();
            }
        }
        return tweets;
    }

    @Override
    public boolean addTweet(Tweet tweet) throws Exception{
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = H2DatabaseManager.getInstance().getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("insert into tweets (user_id, content) values(?,?)");
            stmt.setString(1, tweet.getUserName());
            stmt.setString(2, tweet.getContent());
            stmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("Error occured during addTweet() " + e.getMessage());
            return false;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if ( stmt != null) {
                stmt.close();
            }
        }
        return true;
    }
}
