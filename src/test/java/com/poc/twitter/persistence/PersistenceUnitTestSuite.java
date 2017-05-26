package com.poc.twitter.persistence;

import com.poc.twitter.persistence.h2db.H2DatabaseInitializer;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(value = Suite.class)
@Suite.SuiteClasses(value = { UserDataServiceTest.class, TweetDataServiceTest.class,
        UserConnectionsDataServiceTest.class })
public class PersistenceUnitTestSuite {

    @BeforeClass
    public static void setUpClass() {
        System.out.println("Starting database");
        try {
            DatabaseInitializer databaseInitializer = new H2DatabaseInitializer();
            databaseInitializer.initialize();
            Thread.currentThread().sleep(4000);
        } catch (Exception e) {
            System.out.println( "Unable to start database " + e.getMessage());
            System.exit(0);
        }
    }
}
