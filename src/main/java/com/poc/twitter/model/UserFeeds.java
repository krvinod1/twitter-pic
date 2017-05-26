package com.poc.twitter.model;

import java.util.List;

public class UserFeeds {
    private String name;
    private List<Tweet> feeds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Tweet> getFeeds() {
        return feeds;
    }

    public void setFeeds(List<Tweet> feeds) {
        this.feeds = feeds;
    }
}
