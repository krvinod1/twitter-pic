package com.poc.twitter.persistence.h2db;

import com.poc.twitter.model.UserConnection;
import com.poc.twitter.model.User;
import com.poc.twitter.persistence.UserConnectionsDataService;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component("userConnectionsService")
public class H2UserConnectionsDataService implements UserConnectionsDataService {

    @Override
    public boolean addFollowee(UserConnection userUserConnection) throws Exception {
        Connection connection = null;
        PreparedStatement stmt = null;

        try {
            connection = H2DatabaseManager.getInstance().getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("insert into CONNECTIONS (follower, followee) values(?,?)");
            stmt.setString(1, userUserConnection.getFollower());
            stmt.setString(2, userUserConnection.getFollowee());
            stmt.executeUpdate();
            connection.commit();
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("Error occured adding followee " + e.getMessage());
            return false;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if ( stmt != null) {
                stmt.close();
            }
        }
        return true;
    }

    @Override
    public List<User> getFollowers(String userName) throws Exception{
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = H2DatabaseManager.getInstance().getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("select user_name, first_name, last_name, description from USERS " +
                    "where user_name IN ( select follower from CONNECTIONS where followee = ?)" );
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("user_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setDescription(rs.getString("description"));
                users.add(user);
            }
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("Error occured while fetching followers " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
            if ( stmt != null) {
                stmt.close();
            }
        }
        return users;
    }

    @Override
    public List<User> getFollowees(String userName) throws Exception {
        List<User> users = new ArrayList<User>();
        Connection connection = null;
        PreparedStatement stmt = null;
        try {
            connection = H2DatabaseManager.getInstance().getConnection();
            connection.setAutoCommit(false);
            stmt = connection.prepareStatement("select user_name, first_name, last_name, description from USERS " +
                    "where user_name IN ( select followee from CONNECTIONS where follower = ?)" );
            stmt.setString(1, userName);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setUserName(rs.getString("user_name"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setDescription(rs.getString("description"));
                users.add(user);
            }
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("Error occured while fetching followers " + e.getMessage());
        } finally {
            if (connection != null) {
                connection.close();
            }
            if ( stmt != null) {
                stmt.close();
            }
        }
        return users;
    }
}
