package com.example.coursework.database.hikaricp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {

    private static final HikariConfig config = new HikariConfig(String.valueOf(HikariCPConfig.filePath));
    private static final HikariDataSource dataSources;

    static {
        dataSources = new HikariDataSource(config);
        dataSources.setLeakDetectionThreshold(5000);
    }

    private DataSource() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSources.getConnection();
    }
}