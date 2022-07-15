package Interfaces;

import Models.Product;

@FunctionalInterface
public interface CashRegisterService {
    void readSku(Product product);
}
