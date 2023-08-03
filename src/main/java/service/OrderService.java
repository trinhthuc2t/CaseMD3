package service;

import model.Order.Order;
import model.product.Brand;
import model.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    Connection connection = ConnectionToMySQL.getConnection();
    public List<Order> getAll() {
        List<Order> orders = new ArrayList<>();
        String sql = "select * from order";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Order order = new Order(id, name);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orders;
    }
    public void add(Product product) {
        String sql = "insert into product (name,img,price,quantity,status,description, categoryId,brandId) value (?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, product.getName());
            statement.setString(2, product.getImg());
            statement.setDouble(3, product.getPrice());
            statement.setInt(4, product.getQuantity());
            statement.setBoolean(5, product.isStatus());
            statement.setString(6, product.getDescription());
            statement.setInt(7, product.getCategory().getId());
            statement.setInt(8, product.getBrand().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
