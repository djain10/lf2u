package com.cs445.lf2u.IdGenreator;

import java.util.concurrent.atomic.AtomicInteger;

public class UniqueIdGenerator {
    static AtomicInteger atomicInteger = new AtomicInteger();
    public static String getUniqueID() {
        return Integer.toString(atomicInteger.incrementAndGet());
    }
}
