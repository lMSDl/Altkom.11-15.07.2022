package Models;

import java.util.Objects;

public class Product /*extends Object*/ {
    public final float MIN_PRICE = 0.01f;

    private final String name;
    private float price;
    String sku;

    public Product(String name) {
        this.name = name.toUpperCase();
    }
    protected String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }

    public void addToPrice(float valueToAdd) {
        if(valueToAdd < MIN_PRICE || this.price + valueToAdd < MIN_PRICE)
            return;
        this.price += valueToAdd;
    }

    public String getInfo() {
        return String.format("%s: %.2f zł", name, getPrice());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && Objects.equals(name, product.name) && Objects.equals(sku, product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, sku);
    }
}
