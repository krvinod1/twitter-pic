package com.poc.twitter.model;

import static org.junit.Assert.*;
import org.junit.Test;

public class UserConnectionTest {

    private UserConnection userConnection = new UserConnection();

    @Test
    public void follower() {
        String  value = "follower";
        userConnection.setFollower(value);
        assertEquals(value, userConnection.getFollower());
    }

    @Test
    public void followee() {
        String value = "followee";
        userConnection.setFollowee(value);
        assertEquals(value, userConnection.getFollowee());
    }
}