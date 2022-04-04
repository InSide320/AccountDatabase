package com.example.coursework.database.file;

import com.example.coursework.user.User;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializableObject {
    private static final Logger logger = Logger.getGlobal();

    private static final Path projectPath = Paths.get(System.getProperty("user.dir"));
    public static final Path filePath = projectPath.resolve(projectPath + "/src/main/resources/com/example/coursework/file/txt/saveObject.txt");
    public static final File createFile = new File(String.valueOf(filePath));

    public static void setFileValues(List<User> userList) throws IOException {

        creatFileInResources();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(createFile, false))) {
            outputStream.writeObject(userList);
        }
    }

    public static List<User> userList = new ArrayList<>();


    public static void getFileValues() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(createFile))) {
            userList = (List<User>) inputStream.readObject();
            for (int i = 0; i < userList.size(); i++) {
                logger.log(Level.INFO, String.valueOf(userList.get(i)));
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }

    }

    private static void creatFileInResources() throws IOException {
        if (createFile.createNewFile()) logger.log(Level.INFO, "File created!");
        else logger.log(Level.INFO, "File not created or exists");
    }
}
