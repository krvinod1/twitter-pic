package com.poc.twitter.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { UserTest.class, TweetTest.class, UserConnectionTest.class, UserFeedsTest.class })
public class ModelUnitTestSuite {}
