import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {
    //method to push value to the top of the stack
    void pushValue(int val) throws RemoteException;
    //method to push string with operator to the stack
    void pushOperation(String operator) throws RemoteException;
    //method to pop value from the stack and return it to the client
    int pop() throws RemoteException;
    //method to return true if the stack is empty
    boolean isEmpty() throws RemoteException;
    //method to wait before pop operation
    int delayPop(int millis) throws RemoteException;

}
