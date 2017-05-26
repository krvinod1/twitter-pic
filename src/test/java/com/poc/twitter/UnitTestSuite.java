package com.poc.twitter;

import com.poc.twitter.core.CoreTestSuite;
import com.poc.twitter.model.ModelUnitTestSuite;
import com.poc.twitter.persistence.PersistenceUnitTestSuite;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ModelUnitTestSuite.class, CoreTestSuite.class, PersistenceUnitTestSuite.class })
public class UnitTestSuite {}
