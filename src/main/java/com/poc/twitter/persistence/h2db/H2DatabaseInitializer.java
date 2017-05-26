package com.poc.twitter.persistence.h2db;

import com.poc.twitter.persistence.DatabaseInitializer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class H2DatabaseInitializer implements DatabaseInitializer{

    private static final String SCRIPT_DIRECTIORY = "db/sql";

    public void initialize() throws Exception {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        File directory = new File(classloader.getResource(SCRIPT_DIRECTIORY).getFile());
        File[] fList = directory.listFiles();
        Connection connection = H2DatabaseManager.getInstance().getConnection();
        try {
            for (File file : fList) {
                //ToDo Change with logger
                System.out.println(" Running script " + file.getAbsolutePath());
                runScript(connection, file);
            }
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println(" error for setting up datatbase " + e.getMessage());
        } finally {
            connection.close();
        }
    }

    private void runScript(Connection connection, File file) throws Exception {
        String s = new String();
        StringBuffer sb = new StringBuffer();
        BufferedReader br = null;
        PreparedStatement st = null;
        try {
            br = new BufferedReader(new FileReader(file));
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
            br.close();
            //split the statement
            String[] commands = sb.toString().split(";");
            for (String command : commands) {
                st = connection.prepareStatement(command);
                st.executeUpdate();
                //ToDo Change with logger
                System.out.println("Executing statement" + command);
            }
        } catch (Exception e) {
            //ToDo Change with logger
            System.out.println("*** Error : " + e.toString());
            throw new Exception("DatabaseInitializater", e.getCause());
        } finally {
            if (st != null) {
                st.close();
            }
            if (br != null) {
                br.close();
            }
        }
    }
}

