package com.example.coursework.database.hikaricp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class HikariCpConfig {
    Properties properties = new Properties();

    private static final String DATA_SOURCE_JDBC_URL = "JdbcUrl";
    private static final String DATA_SOURCE_USER = "dataSource.user";
    private static final String DATA_SOURCE_PASS = "dataSource.password";
    private static final String DATA_SOURCE_SERVER_NAME = "dataSource.serverName";
    private static final String DATA_SOURCE_DATABASE_NAME = "dataSource.dataSource.databaseName";
    private static final String DATA_SOURCE_PORT_NUMBER = "dataSource.portNumber";
    private static final String DATA_SOURCE_CACHE_LIMIT = "dataSource.cachePrepStmts";
    private static final String DATA_SOURCE_CACHE_SIZE = "dataSource.prepStmtCacheSize";
    private static final String DATA_SOURCE_CACHE_STMTS = "dataSource.prepStmtCacheSqlLimit";

    public static final Path userDir = Paths.get(System.getProperty("user.dir"));
    public static final Path propertiesFile = userDir.resolve(
            userDir + "/src/main/resources/com/example/coursework/"
                    + "file/properties/application.properties"
    );

    public static final File filePath = new File(String.valueOf(propertiesFile));

    public void setFileProperties() throws IOException {
        properties.setProperty(DATA_SOURCE_JDBC_URL, "jdbc:postgresql://localhost:5432/users_cppc");
        properties.setProperty(DATA_SOURCE_USER, "InSide320");
        properties.setProperty(DATA_SOURCE_PASS, "pass");
        properties.setProperty(DATA_SOURCE_SERVER_NAME, "localhost");
        properties.setProperty(DATA_SOURCE_DATABASE_NAME, "users_cppc");
        properties.setProperty(DATA_SOURCE_PORT_NUMBER, "5432");
        properties.setProperty(DATA_SOURCE_CACHE_STMTS, "true");
        properties.setProperty(DATA_SOURCE_CACHE_SIZE, "250");
        properties.setProperty(DATA_SOURCE_CACHE_LIMIT, "2048");
        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath, false)) {
            properties.store(fileOutputStream, "dataSourceConfig");
        }
        properties.clear();

    }
}
