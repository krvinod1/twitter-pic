package com.poc.twitter.core;

import com.poc.twitter.model.UserFeeds;

public interface UserService {
    UserFeeds getUserFeeds(String userName);
}
