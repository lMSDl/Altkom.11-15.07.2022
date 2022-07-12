package InnerClasses;

import Interfaces.CashRegisterService;
import Models.Product;

public class OuterClass {

    private OuterClass() {

    }

    public OuterClass(int x) {
        publicInt = privateInt = staticPrivateInt = x;
    }

    public final int finalInt = 10;
    public static final int staticFinalInt = 10;
    public int publicInt = 20;
    private int privateInt = 20;
    private static  int staticPrivateInt = 20;

    public class MemberClass {

        public int test() {
            return calculate(finalInt + staticFinalInt, publicInt, privateInt + staticPrivateInt);
        }
    }

    public static class StaticInnerClass {

        public int test() {
            var outer = new OuterClass();
            return outer.calculate(outer.finalInt + staticFinalInt, outer.publicInt, outer.privateInt + staticPrivateInt);
        }
    }

    public int calculate(int a, int b, int c) {

        class LocalClass {
            int[] values;

            int execute() {
                var test = finalInt + staticFinalInt + publicInt + privateInt + staticPrivateInt;
                var sum = 0;
                for (var value: values) {
                    sum += value;
                }
                return  sum;
            }
        }

        var calc = new LocalClass();
        calc.values = new int[] {a, b, c};
        return calc.execute();
    }

    public void someMethod(CashRegisterService service, Product product) {
        service.readSku(product);
    }
}
