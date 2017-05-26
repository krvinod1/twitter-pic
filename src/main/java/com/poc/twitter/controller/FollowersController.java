package com.poc.twitter.controller;

import com.poc.twitter.core.UserConnectionService;
import com.poc.twitter.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FollowersController {

    @Autowired
    private UserConnectionService userConnectionService;

    @RequestMapping(value = "/users/{userName}/followers")
    public ResponseEntity<List<User>> getFolllowers(@PathVariable("userName") String userName) {
        return new ResponseEntity<List<User>>(userConnectionService.getFollowers(userName), HttpStatus.OK);
    }
}
