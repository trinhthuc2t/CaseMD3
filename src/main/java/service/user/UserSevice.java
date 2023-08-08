package service.user;

import model.product.Brand;
import model.product.Category;
import model.product.Product;
import model.user.User;
import service.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSevice {
    Connection connection = ConnectionToMySQL.getConnection();



    public void add(User user) {
        String sql = "insert into user (user,pass,fullName,phoneNumber, address,sex,role) value (?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getUser());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setString(4, user.getPhoneNumber());
            statement.setString(5, user.getAddress());
            statement.setString(6, user.getSex());
            statement.setString(7, user.getRole());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean checkUser(String username, String password) {
        return getUserByUserAndPass(username, password) != null;
    }


    public int getIdUser(String user, String password) {
        List<User> users = getAll();
        for (User use : users) {
            if (user.equals(use.getUser()) && password.equals(use.getPassword())) {
                return use.getId();
            }
        }
        return -1;
    }

    public User getUserByUserAndPass(String username, String password) {
        List<User> users =getAll();
        for (User user : users) {
            if (username.equals(user.getUser()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String sql = "select * from user";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String userName= resultSet.getString("user");
                String pass = resultSet.getString("pass");
                String fullName = resultSet.getString("fullName");
                String phone = resultSet.getString("phoneNumber");
                String address = resultSet.getString("address");
                String sex = resultSet.getString("sex");
                String role = resultSet.getString("role");
                User user = new User(id, userName,pass,fullName,phone, address,sex,role);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}

