package com.poc.twitter.core.impl;

import com.poc.twitter.core.UserConnectionService;
import com.poc.twitter.model.UserConnection;
import com.poc.twitter.model.User;
import com.poc.twitter.persistence.UserConnectionsDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConnectionServiceImpl implements UserConnectionService {

    @Autowired
    private UserConnectionsDataService userConnectionsDataService;

    @Override
    public List<User> getFollowers(String userName) {
        List<User> users = new ArrayList<User>();
        try {
            users = userConnectionsDataService.getFollowers(userName);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("error occurred while getting followers " + e.getMessage());
        }
        return users;
    }

    @Override
    public List<User> getFollowees(String userName) {
        List<User> users = new ArrayList<User>();
        try {
            users = userConnectionsDataService.getFollowees(userName);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("error occurred while getting followers " + e.getMessage());
        }
        return users;
    }

    @Override
    public boolean addFollowee(UserConnection userUserConnection) {
        boolean added = false;
        try {
            added = userConnectionsDataService.addFollowee(userUserConnection);
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("error occurred while added followee " + e.getMessage());
        }
        return added;
    }
}
