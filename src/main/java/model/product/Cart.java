package model.product;

public class Cart {
    private int idCart;
    private Product product;

    public Cart(int idCart, Product product) {
        this.idCart = idCart;
        this.product = product;
    }

    public Cart(Product product) {

        this.product = product;
    }

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


}
