package week2_rmi.server;

import week2_rmi.pair.PairMethods;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class PairServer {
    private static final int PORT = 1099;
    private static Registry registry;

    public static void register() throws RemoteException {
        registry = LocateRegistry.createRegistry(PORT);
    }

    public static void bind() throws RemoteException {
        registry.rebind("Pair", new PairMethods());
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Server starting...");
        register();
        bind();
        System.out.println("Server ready!");
        Thread.sleep(1000000);
    }
}
