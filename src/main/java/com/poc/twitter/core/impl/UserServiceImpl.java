package com.poc.twitter.core.impl;

import com.poc.twitter.core.UserService;
import com.poc.twitter.model.UserFeeds;
import com.poc.twitter.persistence.UserDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDataService userDataService;

    @Override
    public UserFeeds getUserFeeds(String userName)  {
        UserFeeds userFeeds = new UserFeeds();
        try {
            userFeeds = userDataService.getFeeds(userName);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("error occurred while getting user feeds " + e.getMessage());
        }
        return userFeeds;
    }
}
