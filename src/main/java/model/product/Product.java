package model.product;

public class Product {
    private int id;
    private String name;
    private String img;
    private double price;

    private int quantity;
    private boolean status;
    private String description;
    private Category category;
    private Brand brand;

    public Product(int id, String name, String img, double price, int quantity, boolean status, String description, Category category, Brand brand) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.category = category;
        this.brand = brand;
    }

    public Product(String name, String img, double price, int quantity, boolean status, String description, Category category, Brand brand) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
        this.status = status;
        this.description = description;
        this.category = category;
        this.brand = brand;
    } public Product(String name, String img, double price, int quantity) {
        this.name = name;
        this.img = img;
        this.price = price;
        this.quantity = quantity;
    }

    public Product(int id) {
        this.id = id;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
