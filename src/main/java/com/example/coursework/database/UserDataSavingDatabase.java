package com.example.coursework.database;

import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.database.utility.SqlCommandUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDataSavingDatabase {
    public static void dataUsers() {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement createTableStatement =
                     connection.prepareStatement("create table if not exists users_data ("
                             + "id serial,"
                             + "authorization_email varchar (50) primary key,"
                             + "authorization_password varchar (50)"
                             + ")")
        ) {
            createTableStatement.execute();
            SqlCommandUtility.insertDataAboutUser(
                    "admin",
                    "admin"
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
