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

    @Override
    public void delete(int id) {
        String sql = "delete from product where id = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void edit(int id, Product product) {
        String sql = "update product set name = ?, img = ?, price = ?, quantity = ?, " +
                "status = ?, description = ?, categoryId = ?, brandId =?";

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

    @Override
    public Product findIndexById(int id) {
        String sql = "select * from product where id = ?";
        Product product = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                boolean status = resultSet.getBoolean("status");
                String description = resultSet.getString("description");
                String img = resultSet.getString("img");
                int categoryId = resultSet.getInt("categoryId");
                int brandId = resultSet.getInt("brandId");
                Category category = new Category(categoryId);
                Brand brand = new Brand(brandId);
                product = new Product(id, name, img, price, quantity, status, description, category, brand);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }
}
