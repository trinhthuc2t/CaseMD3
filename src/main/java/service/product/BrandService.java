package service.product;

import model.product.Brand;
import model.product.Category;
import service.ConnectionToMySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandService {
    Connection connection = ConnectionToMySQL.getConnection();
    public List<Brand> getAll() {
        List<Brand> brands = new ArrayList<>();
        String sql = "select * from brand";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Brand brand = new Brand(id, name);
                brands.add(brand);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brands;
    }
}
