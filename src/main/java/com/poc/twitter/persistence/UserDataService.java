package com.poc.twitter.persistence;

import com.poc.twitter.model.UserFeeds;

public interface UserDataService {
    UserFeeds getFeeds(String userName) throws Exception;
}
