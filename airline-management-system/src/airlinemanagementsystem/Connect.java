/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlinemanagementsystem;

import java.sql.*;

/**
 *
 * @author REFAT KHAN
 */
public class Connect {
    // create object
    Connection connect;
    Statement statement;

    public Connect() {
        try {
            // for my database connection driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            connect = DriverManager.getConnection("jdbc:mysql:///airlinemanagementsystem", "root", "");
            statement = connect.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
