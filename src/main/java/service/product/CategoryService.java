package service.product;

import model.product.Brand;
import model.product.Category;
import model.product.Product;
import service.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    Connection connection = ConnectionToMySQL.getConnection();
    public List<Category> getAll() {
        List<Category> categories = new ArrayList<>();
        String sql = "select * from category";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category category = new Category(id, name);
                categories.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }
}
