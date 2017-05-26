package com.poc.twitter.persistence;

import com.poc.twitter.model.UserConnection;
import com.poc.twitter.model.User;

import java.util.List;

public interface UserConnectionsDataService {
    boolean addFollowee(UserConnection userUserConnection) throws Exception;
    List<User> getFollowers(String userName) throws  Exception;
    List<User> getFollowees(String userName) throws Exception;
}
