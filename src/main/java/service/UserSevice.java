package service;

import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserSevice {
    List<User> users = new ArrayList<>();

    public UserSevice() {
        users.add(new User(1, "quan", "1", "user"));
    }

    public void add(User user) {
        this.users.add(user);
    }

    public boolean checkUser(String user, String password) {
        for (User use : users) {
            if (user.equals(use.getUser()) && password.equals(use.getPassword())) {
                return true;
            }
        }
        return false;
    }
    public int getIdUser(String user, String password){
        for (User use : users) {
            if (user.equals(use.getUser()) && password.equals(use.getPassword())) {
                return use.getId();
            }
        }
        return -1;
    }
}

