import java.rmi.Naming;

public class CalculatorClient {
    public static void main(String[] args) {
        try {
            String ip = "rmi://localhost/Calculator";
            Calculator obj = (Calculator) Naming.lookup(ip);
            //populate stack with some values
            obj.pushValue(5);
            obj.pushValue(3);
            obj.pushValue(8);

            System.out.println("The top of the stack is:"+obj.pop());

            //push some operations in the stack
            obj.pushOperation("lcm");
            System.out.println("The lcm of the values in the stack is:"+obj.pop());

            //wait for some time before performing another operation
            obj.delayPop(1000);
            obj.pushOperation("min");
            System.out.println("The minimum among all the values in the stack is"+obj.pop());
            obj.delayPop(1000);

            System.out.println("The top of the stack is:"+obj.pop());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
