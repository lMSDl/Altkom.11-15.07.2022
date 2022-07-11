package Models;

import java.util.Objects;

public class Product /*extends Object*/ {
    private String name;
    private float price;
    String sku;
    protected String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name.toUpperCase();
    }
    public float getPrice() {
        return price;
    }

    public void addToPrice(float valueToAdd) {
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
