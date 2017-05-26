package com.poc.twitter.core;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { UserServiceTest.class, TweetServiceTest.class, UserConnectionServiceTest.class })
public class CoreTestSuite {}
