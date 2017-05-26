package com.poc.twitter.controller;

import com.poc.twitter.core.UserService;
import com.poc.twitter.model.UserFeeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/{userName}")
    public ResponseEntity<UserFeeds> getUserFeeds(@PathVariable("userName") String userName) {
        return new ResponseEntity<UserFeeds>(userService.getUserFeeds(userName), HttpStatus.OK);
    }
}
