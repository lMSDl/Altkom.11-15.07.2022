package Models;

import java.security.PublicKey;

public class Order {

    private Product[] products;

    public Order(Product[] products) {
        this.products = products;
    }

    public Product[] getProducts() {
        return products;
    }

    public float getPrice() {
        var sum = 0f;
        for (var product: products) {
            sum += product.getPrice();
        }
        return  sum;
    }

    public void add(Product product) {

    }

    public void add(Clock clock) {

    }

}
