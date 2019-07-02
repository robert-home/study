package concurrent;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {

    private final AtomicInteger atomicInteger = new AtomicInteger(50);

    public AtomicInteger getAtomicInteger() {
        atomicInteger.doubleValue();
        return atomicInteger;
    }


}
