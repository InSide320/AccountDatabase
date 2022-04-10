package com.example.coursework.database.utility;

import com.example.coursework.database.file.SerializableObject;
import com.example.coursework.database.hikaricp.DataSource;
import com.example.coursework.user.User;
import com.example.coursework.user.UserController;
import com.example.coursework.user.type.RoleType;

import java.io.IOException;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SqlCommandUtility {
    public static final String SQL_INSERT_TO_TABLE_A_DATA
            = "" + "insert into registration_users("
            + "first_name_translit," + " last_name_translit,"
            + " email_backup," + " phone_number,"
            + " last_name_uk," + " first_name_uk," + " midl_name_uk,"
            + " date_enter," + " release_date,"
            + " group_uk," + " group_translit,"
            + " role_human,"
            + "auth_email, " + "auth_pass"
            + ") values (?, ?, ?, ? ,? ,?, ?, ?, ?, ?, ? ,?, ?, ?)"
            + " on conflict (phone_number) do nothing";

    public static final String SQL_INSERT_DATA_ABOUT_USER
            = "insert into users_data("
            + "authorization_email," + "authorization_password" + ") "
            + "values (?,?) on conflict (authorization_email) do nothing";

    public static final String SQL_SELECT_FOR_TABLE_VALUE_REGISTRATION_USERS
            = "SELECT * from registration_users";

    public static final String SQL_SELECT_FOR_TABLE_VALUE_USERS_DATA
            = "SELECT * from users_data";

    private static final Logger logger = Logger.getGlobal();

    public static void insertDataAboutUser(String authorizationEmail, String authorizationPassword) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_DATA_ABOUT_USER)) {
            preparedStatement.setString(1, authorizationEmail);
            preparedStatement.setString(2, authorizationPassword);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static final UserController userController = UserController.getInstance();

    public static void selectTableUsersDataAll() {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(SQL_SELECT_FOR_TABLE_VALUE_USERS_DATA)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                resultSet.getString("authorization_email");
                resultSet.getString("authorization_password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void selectTableValueAll() {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(SQL_SELECT_FOR_TABLE_VALUE_REGISTRATION_USERS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User(rs.getInt("id"),
                        rs.getString("last_name_translit"),
                        rs.getString("first_name_translit"),
                        rs.getString("group_translit"),
                        rs.getString("last_name_uk"),
                        rs.getString("first_name_uk"),
                        rs.getString("midl_name_uk"),
                        rs.getString("group_uk"), rs.getString("phone_number"),
                        RoleType.valueOf(rs.getString("role_human")),
                        rs.getString("email_backup"),
                        rs.getDate("date_enter").toLocalDate(),
                        rs.getDate("release_date").toLocalDate(),
                        rs.getString("auth_email"), rs.getString("auth_pass")
                );

                userController.addNewUserByList(user);
            }
            SerializableObject.setFileValues(userController.userList());
        } catch (SQLException | IOException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getStackTrace());
        }
    }

    public static void executeCommandToInsertValues(
            String firstNameTranslit, String lastNameTranslit,
            String emailBackup, String phoneNumber,
            String lastNameUk, String firstNameUk, String midlNameUk,
            LocalDate dataEnter, LocalDate releaseDate,
            String groupUk, String groupTranslit,
            RoleType roleType,
            String auth_email, String auth_pass) {
        try (Connection connection = DataSource.getConnection();
             PreparedStatement preparedStatement
                     = connection.prepareStatement(SQL_INSERT_TO_TABLE_A_DATA)) {

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
            preparedStatement.setString(13, auth_email);
            preparedStatement.setString(14, auth_pass);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.WARNING, e.getMessage(), e.getStackTrace());
        }
    }

}
