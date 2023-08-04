package service;

import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserSevice {
    public List<User> users = new ArrayList<>();

    public UserSevice() {
        users.add(new User(1, "admin", "1", "admin"));
        users.add(new User(2, "user", "1", "user"));
    }

    public void add(User user) {
        this.users.add(user);
    }

    public boolean checkUser(String username, String password) {
        return getUserByUserAndPass(username, password) != null;
    }


    public int getIdUser(String user, String password) {
        for (User use : users) {
            if (user.equals(use.getUser()) && password.equals(use.getPassword())) {
                return use.getId();
            }
        }
        return -1;
    }

    public User getUserByUserAndPass(String username, String password) {
        for (User user : users) {
            if (username.equals(user.getUser()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}

