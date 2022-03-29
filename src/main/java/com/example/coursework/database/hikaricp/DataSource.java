package com.example.coursework.database.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static HikariConfig config = new HikariConfig(String.valueOf(HikariCPConfig.filePath));
    private static HikariDataSource dataSource;

    static {
        dataSource = new HikariDataSource(config);
        dataSource.setLeakDetectionThreshold(5000);
    }

    public DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}