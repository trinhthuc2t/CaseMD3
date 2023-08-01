package service;

import model.user.User;

import java.util.ArrayList;
import java.util.List;

public class UserSevice {
    List<User> users = new ArrayList<>();
    public UserSevice(){
        users.add(new User(1, "quan", "1", "user"));
    }
    public void add(User user){
        this.users.add(user);
    }
    public boolean checkUser(int id) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }
}
