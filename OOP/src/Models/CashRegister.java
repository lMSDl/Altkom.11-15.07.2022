package Models;

import Interfaces.CashRegisterService;

public class CashRegister implements CashRegisterService {

    @Override
    public void readSku(Product product) {
        System.out.println(product.sku);
    }
}
