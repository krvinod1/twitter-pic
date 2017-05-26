package com.poc.twitter.model;

public class Tweet {
    private String content;
    private String userName;
    private String createdDate;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tweet tweet = (Tweet) o;

        if (userName != tweet.userName) return false;
        if (!content.equals(tweet.content)) return false;
        return createdDate.equals(tweet.createdDate);
    }

    @Override
    public int hashCode() {
        int result = 31 * content.hashCode();
        result = 31 * result + userName.hashCode();
        result = 31 * result + createdDate.hashCode();
        return result;
    }
}
