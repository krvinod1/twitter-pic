package com.poc.twitter.core;

import com.poc.twitter.Application;
import com.poc.twitter.core.impl.UserConnectionServiceImpl;
import com.poc.twitter.model.UserConnection;
import com.poc.twitter.persistence.UserConnectionsDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(Application.class)
public class UserConnectionServiceTest {

    @Mock
    UserConnectionsDataService tweetDataServiceMockMock;
    @InjectMocks
    UserConnectionService userConnectionService  = new UserConnectionServiceImpl();

    @Test
    public void addFollowee() throws Exception {
        userConnectionService.getFollowers("foo");
        verify(tweetDataServiceMockMock, times(1)).getFollowers("foo");
    }

    @Test
    public void getFollowers() throws Exception {
        userConnectionService.getFollowees("foo");
        verify(tweetDataServiceMockMock, times(1)).getFollowees("foo");
    }

    @Test
    public void getFollowees() throws Exception {
        UserConnection userConnection = new UserConnection();
        userConnectionService.addFollowee(userConnection);
        verify(tweetDataServiceMockMock, times(1)).addFollowee(userConnection);
    }
}