package com.poc.twitter.persistence;

import com.poc.twitter.model.UserFeeds;
import com.poc.twitter.persistence.h2db.H2UserDataService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDataServiceTest {

    private UserDataService userDataService = new H2UserDataService();

    @Test
    public void getUserFeed() throws Exception {
        UserFeeds userFeeds = userDataService.getFeeds("foo");
        assertNotNull(userFeeds);
        assertEquals("foo", userFeeds.getName());
        assertNotNull(userFeeds.getFeeds());
        assertTrue(userFeeds.getFeeds().size() > 0);
    }

    @Test
    public void getNonExistUserFeeds() throws Exception {
        UserFeeds userFeeds = userDataService.getFeeds("kkk");
        assertNotNull(userFeeds);
        assertNotNull(userFeeds.getName());
        assertNotNull(userFeeds.getFeeds());
        assertEquals(0, userFeeds.getFeeds().size());
    }

}