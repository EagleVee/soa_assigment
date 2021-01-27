package week2_rmi.pair;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collections;

public class PairMethods implements Pair, Serializable {

    public PairMethods() {

    }

    @Override
    public Integer getMin(Integer[] array) {
        return Collections.min(Arrays.asList(array));
    }

    @Override
    public String getHello() throws RemoteException {
        return "Hello worlds!";
    }

    @Override
    public Integer getMax(Integer[] array) {
        return Collections.max(Arrays.asList(array));
    }
}
