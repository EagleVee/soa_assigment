package week2_rmi.pair;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Pair extends Remote {
    Integer getMax(Integer[] numberArray) throws RemoteException;
    Integer getMin(Integer[] numberArray) throws RemoteException;
    String getHello() throws RemoteException;
}
