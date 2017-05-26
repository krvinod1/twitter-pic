package com.poc.twitter.persistence.h2db;

import com.poc.twitter.model.Tweet;
import com.poc.twitter.model.UserFeeds;
import com.poc.twitter.persistence.UserDataService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("userDataService")
public class H2UserDataService implements UserDataService {

    @Override
    public UserFeeds getFeeds(String userName) throws Exception {
        UserFeeds userFeeds = new UserFeeds();
        PreparedStatement  stmt = null;
        try {
            Connection connection = H2DatabaseManager.getInstance().getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement(" select u.user_name, t.content, t.created_at" +
                    " from TWEETS t INNER JOIN USERS u on u.user_name = t.user_id and u.user_name " +
                    " in (select followee from CONNECTIONS where follower  =  ? )");
            stmt.setString(1, userName);
            List<Tweet> tweets = new ArrayList<Tweet>();
            ResultSet rs = stmt.executeQuery();
            userFeeds.setName(userName);
            while (rs.next()) {
                Tweet tweet = new Tweet();
                tweet.setContent(rs.getString("content"));
                tweet.setCreatedDate(rs.getString("created_at"));
                tweet.setUserName(rs.getString("user_name"));
                tweets.add(tweet);
            }
            userFeeds.setFeeds(tweets);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("Error occured during get userFeeds " + e.getMessage());
        }
        return userFeeds;
    }
}
