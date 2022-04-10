package com.example.coursework.database;

import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.database.utility.SqlCommandUtility;
import com.example.coursework.user.type.RoleType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RegistrationUsersCreateTable {
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
            + "role_human varchar (250),"
            + "auth_email varchar (50),"
            + "auth_pass varchar (50)"
            + ")";

    public static final Logger logger = Logger.getGlobal();

    private RegistrationUsersCreateTable() {

    }

    public static void createDataBase() {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_TABLE_SQL_DATABASE);
             ) {

            preparedStatement.executeUpdate();

            SqlCommandUtility.executeCommandToInsertValues(
                    "Denis", "Kud",
                    "dekud2109@gmail.com",
                    "+(380)983981415",
                    "Кудь", "Денис",
                    "Олександрович",
                    LocalDate.now(), LocalDate.now(),
                    "ПС4-1",
                    "PS4-1",
                    RoleType.STUDENT,
                    "admin", "admin"
            );

        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getSQLState());
        }
    }

}
