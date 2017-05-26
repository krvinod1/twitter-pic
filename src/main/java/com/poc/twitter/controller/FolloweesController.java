package com.poc.twitter.controller;

import com.poc.twitter.core.UserConnectionService;
import com.poc.twitter.model.User;
import com.poc.twitter.model.UserConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FolloweesController {

    @Autowired
    private UserConnectionService userConnectionService;

    @RequestMapping(value = "/users/{userName}/followees")
    public ResponseEntity<List<User>> getFolllowees(@PathVariable("userName") String userName) {
        return new ResponseEntity<List<User>>(userConnectionService.getFollowees(userName), HttpStatus.OK);
    }

    @RequestMapping(value = "/users/{userName}/followees", method = RequestMethod.POST)
    public ResponseEntity<Void> addTweet(@PathVariable("userName") String userName,
                                         @RequestBody UserConnection userConnection) {
        userConnection.setFollower(userName);
        userConnectionService.addFollowee(userConnection);
        return new ResponseEntity<Void>(new HttpHeaders(), HttpStatus.CREATED);
    }
}
