package Models;

public class Cashier {
    private CashRegister cashRegister;

    public void setCashRegister(CashRegister cashRegister) {
        this.cashRegister = cashRegister;
    }

    public void Checkout(Product product) {
        cashRegister.AddProduct(product);
    }

}
