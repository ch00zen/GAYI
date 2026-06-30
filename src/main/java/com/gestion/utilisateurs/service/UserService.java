package com.gestion.utilisateurs.service;

import com.gestion.utilisateurs.dao.UserDao;
import com.gestion.utilisateurs.model.User;

import java.util.List;

public class UserService {
    private final UserDao userDao;

    public UserService() {
        this.userDao = new UserDao();
    }

    public void addUser(User user) {
        userDao.createUser(user);
    }

    public User getUser(int id) {
        return userDao.findUserById(id);
    }

    public List<User> getAllUsers() {
        return userDao.findAllUsers();
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }
}
