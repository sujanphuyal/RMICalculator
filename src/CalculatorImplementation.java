import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Stack;

public class CalculatorImplementation extends UnicastRemoteObject implements Calculator {
    public CalculatorImplementation () throws RemoteException
    {
        super();
    }
    Stack<Integer> stack = new Stack<>();
    @Override
    public void pushValue(int val) throws RemoteException {
        stack.push(val);
    }

    @Override
    public void pushOperation(String operator) throws RemoteException {
        switch (operator){
            case "min" -> {
                int min = Integer.MAX_VALUE;
                while (!stack.isEmpty()){
                    int val = stack.pop();
                    if (val<min){
                        min = val;
                    }
                }
                stack.push(min);
            }
            case "max" -> {
                int max = Integer.MIN_VALUE;
                while (!stack.isEmpty()){
                    int val = stack.pop();
                    if(val>max){
                        max=val;
                    }
                }
                stack.push(max);
            }
            case "gcd" -> {
                int gcd = stack.pop();
                while (!stack.isEmpty()){
                    int val = stack.pop();
                    gcd = gcd(gcd,val);
                }
                stack.push(gcd);
            }
            case "lcm" -> {
                int lcm = 1;
                while (!stack.isEmpty()){
                    int val = stack.pop();
                    lcm = lcm * val / gcd(lcm, val);
                }
                stack.push(lcm);
            }
        }
    }
    int gcd(int val1, int val2){
        if (val2 == 0){
            return val1;
        }else {
            return gcd(val2, val1 % val2);
        }
    }

    @Override
    public int pop() throws RemoteException {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() throws RemoteException {
        return stack.isEmpty();
    }

    @Override
    public int delayPop(int millis) throws RemoteException {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return pop();
    }
}
