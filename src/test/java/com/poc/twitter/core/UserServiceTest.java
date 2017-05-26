package com.poc.twitter.core;

import com.poc.twitter.Application;
import com.poc.twitter.core.impl.UserServiceImpl;
import com.poc.twitter.persistence.UserDataService;
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
public class UserServiceTest {

    @Mock
    UserDataService userDataServiceMock;
    @InjectMocks
    UserService userService = new UserServiceImpl(); ;

    @Test
    public void getUserFeeds() throws Exception {
        userService.getUserFeeds("foo");
        verify(userDataServiceMock, times(1)).getFeeds("foo");
    }
}
