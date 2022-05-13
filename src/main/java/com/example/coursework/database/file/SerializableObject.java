package com.example.coursework.database.file;

import com.example.coursework.user.User;
import com.example.coursework.user.UserController;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    static UserController userController = UserController.getInstance();


    public static void getFileValues() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(createFile))) {
            userController = new UserController((List<User>) inputStream.readObject());
            for (int i = 0; i < userController.userList().size(); i++) {
                logger.log(Level.INFO, String.valueOf(userController.userList().get(i)));
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
