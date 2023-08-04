package service;

import model.product.Cart;
import model.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CartService {
    Connection connection = ConnectionToMySQL.getConnection();
    List<Product> products = new ArrayList<>();

    public void addCart(Cart cart) throws SQLException {
        String sql = "insert into cart(productId) value (?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, cart.getProduct().getId());
        statement.executeUpdate();
    }

    public List<Cart> getAll() {
        List<Cart> carts = new ArrayList<>();
        String sql = "select * from cart join product p on p.id = cart.productId;";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                Product product = new Product(name, img, price, quantity);
                carts.add(new Cart(id, product));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carts;
    }

    public double getSumPrice() {
        String sql = "select sum(p.price) as sum from cart c join product p on c.productId = p.id";
        double sum;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                sum = resultSet.getDouble("sum");
                return sum;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public void delete(int id) {
        String sql = "delete from cart where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
