package com.example.coursework.user;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public record UserController(List<User> userList) {
    private static UserController instance;

    public static UserController getInstance() {
        if (instance == null) {
            instance = new UserController(new ArrayList<>());
        }
        return instance;
    }

    private static final Logger logger = Logger.getGlobal();

    public Boolean addNewUserByList(User user) {
        return userList().add(user);
    }

    public void addAuthorizationDataUsers(){
        for(User user : userList()){
//            user.setAuthEmail();
        }
    }

    private void getIdUser() {
        for (User user : userList()) {
            String lineIdUsers = user.getId()
                    + ") "
                    + user.getLastNameTranslit();

            logger.log(Level.INFO, lineIdUsers);
        }
    }

    public User getUserById(int id) throws IllegalArgumentException {
        getIdUser();
        if (id <= userList().size() && id > 0)
            return userList().get(id);
        else
            throw new IllegalArgumentException("id cannot be larger");
    }
}
