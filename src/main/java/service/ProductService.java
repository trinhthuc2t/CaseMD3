package service;

import model.product.Brand;
import model.product.Category;
import model.product.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService<Product> {
    Connection connection = ConnectionToMySQL.getConnection();

    @Override
    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from product";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img = resultSet.getString("img");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                boolean status = resultSet.getBoolean("status");
                String description = resultSet.getString("description");
                int idCategory = resultSet.getInt("categoryId");
                String nameCategory = resultSet.getString("name");
                int idBrand = resultSet.getInt("brandId");
                String nameBrand = resultSet.getString("name");
                Brand brand = new Brand(idBrand, nameBrand);
                Category category = new Category(idCategory, nameCategory);
                Product product = new Product(id, name, img, price, quantity, status, description, category, brand);
                products.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public void add(Product product) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Product product) {

    }
}
