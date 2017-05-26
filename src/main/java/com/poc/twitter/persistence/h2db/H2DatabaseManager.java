package com.poc.twitter.persistence.h2db;

import org.h2.jdbcx.JdbcConnectionPool;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class H2DatabaseManager {

    private static final String DATABASE_PROPERTIES = "db/database.properties";
    private static String DB_DRIVER = "org.h2.Driver;";
    private static String DB_CONNECTION =  "jdbc:h2:mem:twitter;DB_CLOSE_DELAY=-1";
    private static String DB_USER = "";
    private static String DB_PASSWORD = "";
    private static H2DatabaseManager instance = new H2DatabaseManager();
    private static JdbcConnectionPool jdbcConnectionPool;

    static {
        try {
            loadProperties();
            try {
                Class.forName(DB_DRIVER);
            } catch (ClassNotFoundException e) {
                //ToDo Change with logger
                System.out.println(e.getMessage());
            }
            jdbcConnectionPool = JdbcConnectionPool.create(DB_CONNECTION, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            throw new RuntimeException("Exception occured in setting up database manager " + e.getMessage());
        }
    }

    private H2DatabaseManager() {}

    public static H2DatabaseManager getInstance() {
        return instance;
    }

    public JdbcConnectionPool getConnectionPool() {
        return jdbcConnectionPool;
    }

    public Connection getConnection() throws Exception {
        return jdbcConnectionPool.getConnection();
    }

    private static void loadProperties() throws Exception {
        Properties prop = new Properties();
        InputStream input = null;

        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            input = classloader.getResourceAsStream(DATABASE_PROPERTIES);
            // load a properties file
            prop.load(input);
            // set properties value
            DB_DRIVER = prop.getProperty("DB_DRIVER");
            DB_CONNECTION = prop.getProperty("DB_CONNECTION");
            DB_USER = prop.getProperty("DB_USER");
            DB_PASSWORD = prop.getProperty("DB_PASSWORD");
            System.out.println("data base driver: " + DB_DRIVER + " connection: " + DB_CONNECTION);
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
