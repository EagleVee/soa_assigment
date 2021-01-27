package week2_rmi.client;

import week2_rmi.pair.PairMethods;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PairClient {
    private static final int PORT = 1099;


    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("192.168.1.98", PORT);
        System.out.println(registry.toString());
        PairMethods stub = (PairMethods) registry.lookup("Pair");
        System.out.println(stub.getHello());
        Integer[] numberArray = {1, 2, 3, 4, 5, 11, -22};
        int minResponse = stub.getMin(numberArray);
        System.out.println("getMin response: " + minResponse);

        int maxResponse = stub.getMax(numberArray);
        System.out.println("getMax response: " + maxResponse);
    }
}

