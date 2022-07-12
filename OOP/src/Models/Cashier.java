package Models;

import Interfaces.CashRegisterService;

public class Cashier {
    private CashRegisterService cashRegister;

    public void setCashRegister(CashRegisterService cashRegister) {
        this.cashRegister = cashRegister;
    }

    public void Checkout(Product product) {
        cashRegister.readSku(product);
        if(product instanceof CraftedProduct) {
            /*var craftedProduct = (CraftedProduct) product;
            craftedProduct.removeSafety();*/
            ((CraftedProduct)product).removeSafety();
        }
    }

}
