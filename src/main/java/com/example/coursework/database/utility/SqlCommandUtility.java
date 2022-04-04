package com.example.coursework.database.utility;

import com.example.coursework.database.file.SerializableObject;
import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.user.User;
import com.example.coursework.user.type.RoleType;
import javafx.scene.control.Toggle;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public static final String SQL_SELECT_FOR_TABLE_VALUE = "SELECT * from registration_users";

    private static Logger logger = Logger.getGlobal();
    static List<User> userList = new ArrayList<>();

    public static void selectTableValueAll() {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(SQL_SELECT_FOR_TABLE_VALUE)
        ) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("last_name_translit"),
                        rs.getString("first_name_translit"),
                        rs.getString("group_translit"),
                        rs.getString("last_name_uk"),
                        rs.getString("first_name_uk"),
                        rs.getString("midl_name_uk"),
                        rs.getString("group_uk"),
                        rs.getString("phone_number"),
                        RoleType.valueOf(rs.getString("role_human")),
                        rs.getString("email_backup"),
                        rs.getDate("date_enter").toLocalDate(),
                        rs.getDate("release_date").toLocalDate());
                userList.add(user);

            }
            SerializableObject.setFileValues(userList);
        } catch (SQLException | IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getStackTrace());
        }
    }

    public static void executeCommandToInsertValues(
            String firstNameTranslit, String lastNameTranslit,
            String emailBackup, String phoneNumber,
            String lastNameUk, String firstNameUk, String midlNameUk,
            LocalDate dataEnter, LocalDate releaseDate,
            String groupUk, String groupTranslit, RoleType roleType
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

            preparedStatement.setString(12, String.valueOf(roleType));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getStackTrace());
        }
    }


}