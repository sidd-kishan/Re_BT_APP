/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.observers.BaseTestConsumer$TestWaitStrategy$6
 */
package io.reactivex.observers;

import io.reactivex.observers.BaseTestConsumer;

public static abstract class BaseTestConsumer.TestWaitStrategy
extends Enum<BaseTestConsumer.TestWaitStrategy>
implements Runnable {
    private static final BaseTestConsumer.TestWaitStrategy[] $VALUES;
    public static final /* enum */ BaseTestConsumer.TestWaitStrategy SLEEP_1000MS;
    public static final /* enum */ BaseTestConsumer.TestWaitStrategy SLEEP_100MS;
    public static final /* enum */ BaseTestConsumer.TestWaitStrategy SLEEP_10MS;
    public static final /* enum */ BaseTestConsumer.TestWaitStrategy SLEEP_1MS;
    public static final /* enum */ BaseTestConsumer.TestWaitStrategy SPIN;
    public static final /* enum */ BaseTestConsumer.TestWaitStrategy YIELD;

    static {
        SPIN = new /* Unavailable Anonymous Inner Class!! */;
        YIELD = new /* Unavailable Anonymous Inner Class!! */;
        SLEEP_1MS = new /* Unavailable Anonymous Inner Class!! */;
        SLEEP_10MS = new /* Unavailable Anonymous Inner Class!! */;
        SLEEP_100MS = new /* Unavailable Anonymous Inner Class!! */;
        6 var0 = new /* Unavailable Anonymous Inner Class!! */;
        SLEEP_1000MS = var0;
        $VALUES = new BaseTestConsumer.TestWaitStrategy[]{SPIN, YIELD, SLEEP_1MS, SLEEP_10MS, SLEEP_100MS, var0};
    }

    static void sleep(int n) {
        long l = n;
        try {
            Thread.sleep(l);
            return;
        }
        catch (InterruptedException interruptedException) {
            throw new RuntimeException(interruptedException);
        }
    }

    public static BaseTestConsumer.TestWaitStrategy valueOf(String string) {
        return Enum.valueOf(BaseTestConsumer.TestWaitStrategy.class, string);
    }

    public static BaseTestConsumer.TestWaitStrategy[] values() {
        return (BaseTestConsumer.TestWaitStrategy[])$VALUES.clone();
    }

    @Override
    public abstract void run();
}
