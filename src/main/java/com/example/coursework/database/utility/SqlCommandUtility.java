package com.example.coursework.database.utility;

import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.user.type.RoleType;
import javafx.scene.control.Toggle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class SqlCommandUtility {
    public static final String SQL_INSERT_TO_TABLE_A_DATA = ""
            + "insert into registration_users("
            + "first_name_translit,"
            + " last_name_translit,"
            + " email_backup,"
            + " phone_number,"
            + " last_name_uk,"
            + " first_name_uk,"
            + " midl_name_uk,"
            + " date_enter,"
            + " release_date,"
            + " group_uk,"
            + " group_translit,"
            + " role_human) values (?, ?, ?, ? ,? ,?, ?, ?, ?, ?, ? ,?)"
            + " on conflict (phone_number) do nothing";

    public static void executeCommandToInsertValues(
            String firstNameTranslit, String lastNameTranslit, String emailBackup, String phoneNumber,
            String lastNameUk, String firstNameUk, String midlNameUk,
            LocalDate dataEnter, LocalDate releaseDate,
            String groupUk, String groupTranslit, Toggle toggle
    ) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SQL_INSERT_TO_TABLE_A_DATA)
        ) {

            preparedStatement.setString(1, firstNameTranslit);
            preparedStatement.setString(2, lastNameTranslit);

            preparedStatement.setString(3, emailBackup);
            preparedStatement.setString(4, phoneNumber);

            preparedStatement.setString(5, lastNameUk);
            preparedStatement.setString(6, firstNameUk);
            preparedStatement.setString(7, midlNameUk);

            preparedStatement.setDate(8, Date.valueOf(dataEnter));
            preparedStatement.setDate(9, Date.valueOf(releaseDate));

            preparedStatement.setString(10, groupUk);
            preparedStatement.setString(11, groupTranslit);

            preparedStatement.setString(12, String.valueOf(toggle));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
