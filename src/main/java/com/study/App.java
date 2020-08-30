package com.study;

import org.h2.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException, ClassNotFoundException {
        System.out.println( "Hello World!" );
        Class.forName("org.h2.Driver");
        Connection c = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa", "");
        PreparedStatement preparedStatement = c.prepareStatement("CREATE TABLE USERs " +
                "(id varchar(10) PRIMARY KEY , " +
                "name VARCHAR(20) not null," +
                " password VARCHAR(20) not null)");
        preparedStatement.execute();


    }
}
