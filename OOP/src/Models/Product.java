package Models;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.Objects;

public class Product extends  Entity implements Comparable {
    public final float MIN_PRICE = 0.01f;

    private final String name;
    private float price;
    private LocalDateTime createdAt;
    private LocalDate expirationDate;
    String sku;

    public Product(String name) {
        this.name = name.toUpperCase();
        createdAt = LocalDateTime.now();
    }
    public String getName() {
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


    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public  void showTimeToExpire() {
        System.out.println(Period.between(LocalDate.now(), expirationDate).toTotalMonths());
        //Duration.ofDays(15).toMinutes();
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

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
