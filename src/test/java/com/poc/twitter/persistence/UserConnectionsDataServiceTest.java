package com.poc.twitter.persistence;

import com.poc.twitter.model.UserConnection;
import com.poc.twitter.model.User;
import com.poc.twitter.persistence.h2db.H2UserConnectionsDataService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class UserConnectionsDataServiceTest {

    private UserConnectionsDataService userConnectionsDataService = new H2UserConnectionsDataService();

    @Test
    public void getFollowers() throws Exception {
        List<User> users = userConnectionsDataService.getFollowers("mike");
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void getFollowersNonExit() throws Exception {
        List<User> users = userConnectionsDataService.getFollowers("kkk");
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void getFollowees() throws Exception {
        List<User> users = userConnectionsDataService.getFollowees("foo");
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void getFolloweesNonExit() throws Exception {
        List<User> users = userConnectionsDataService.getFollowees("kkk");
        assertNotNull(users);
        assertEquals(0, users.size());
    }

    @Test
    public void addFollowee() throws Exception {
        UserConnection userConnection = new UserConnection();
        userConnection.setFollower("joe");
        userConnection.setFollowee("bar");
        userConnectionsDataService.addFollowee(userConnection);
        List<User> users = userConnectionsDataService.getFollowers("bar");
        assertNotNull(users);
        assertEquals(2, users.size());
        users = userConnectionsDataService.getFollowees("joe");
        assertNotNull(users);
        assertEquals(2, users.size());
    }
}