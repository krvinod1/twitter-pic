package com.poc.twitter.model;

public class UserConnection {

    private String follower;
    private String followee;
    private String createdDate;

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowee() {
        return followee;
    }

    public void setFollowee(String followee) {
        this.followee = followee;
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

        UserConnection that = (UserConnection) o;

        if (!follower.equals(that.follower)) return false;
        if (!followee.equals(that.followee)) return false;
        return createdDate.equals(that.createdDate);
    }

    @Override
    public int hashCode() {
        int result = follower.hashCode();
        result = 31 * result + followee.hashCode();
        result = 31 * result + createdDate.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "UserConnection{" +
                "follower='" + follower + '\'' +
                ", followee='" + followee + '\'' +
                ", createdDate='" + createdDate + '\'' +
                '}';
    }
}
