package com.example.coursework.database;

import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.database.utility.SqlCommandUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateTableDataBase {
    private static final String CREATE_TABLE_SQL_DATABASE = "CREATE TABLE IF NOT EXISTS registration_users ("
            + "id serial,"
            + "first_name_translit varchar (50),"
            + "last_name_translit varchar (50),"
            + "email_backup varchar (100),"
            + "phone_number varchar (30) default +(380) primary key,"
            + "last_name_uk varchar (50),"
            + "first_name_uk varchar (50),"
            + "midl_name_uk varchar (100),"
            + "date_enter date,"
            + "release_date date,"
            + "group_uk varchar (10),"
            + "group_translit varchar (10),"
            + "role_human varchar (250)"
            + ")";

    public static final Logger logger = Logger.getGlobal();

    private CreateTableDataBase() {

    }

    public static void createDataBase() {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(CREATE_TABLE_SQL_DATABASE);
             PreparedStatement commandInsertToTable =
                     connection.prepareStatement(SqlCommandUtility.SQL_INSERT_TO_TABLE_A_DATA)
        ) {
            preparedStatement.execute();

            commandInsertToTable.setString(1, "Denis");
            commandInsertToTable.setString(2, "Kud");
            commandInsertToTable.setString(3, "dekud2109@gmail.com");
            commandInsertToTable.setInt(4, 983981415);
            commandInsertToTable.setString(5, "Кудь");
            commandInsertToTable.setString(6, "Денис");
            commandInsertToTable.setString(7, "Олександрович");
            commandInsertToTable.setTimestamp(8, Timestamp.valueOf(LocalDateTime.now()));
            commandInsertToTable.setTimestamp(9, Timestamp.valueOf(LocalDateTime.now()));
            commandInsertToTable.setString(10, "ПС4-1");
            commandInsertToTable.setString(11, "PS4-1");
            commandInsertToTable.setString(12, "student");

            commandInsertToTable.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getSQLState());
        }
    }

}
