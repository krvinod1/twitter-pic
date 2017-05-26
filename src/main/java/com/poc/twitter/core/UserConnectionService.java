package com.poc.twitter.core;

import com.poc.twitter.model.UserConnection;
import com.poc.twitter.model.User;

import java.util.List;

public interface UserConnectionService {
    boolean addFollowee(UserConnection userUserConnection);
    List<User> getFollowers(String userName);
    List<User> getFollowees(String userName);
}
