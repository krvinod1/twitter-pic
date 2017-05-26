package com.poc.twitter.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserTest {

    private User user = new User();

    @Test
    public void userName() {
        String value ="username";
        user.setUserName(value);
        assertEquals(value, user.getUserName());
    }

    @Test
    public void firstName() {
        String value ="firstname";
        user.setFirstName(value);
        assertEquals(value, user.getFirstName());
    }

    @Test
    public void lastName() {
        String value ="lastname";
        user.setLastName(value);
        assertEquals(value, user.getLastName());
    }

    @Test
    public void description() {
        String value ="description";
        user.setDescription(value);
        assertEquals(value, user.getDescription());
    }
}
