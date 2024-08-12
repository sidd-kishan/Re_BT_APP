/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.observers.BaseTestConsumer$TestWaitStrategy
 */
package io.reactivex.observers;

import io.reactivex.observers.BaseTestConsumer;

static final class BaseTestConsumer.TestWaitStrategy.5
extends BaseTestConsumer.TestWaitStrategy {
    BaseTestConsumer.TestWaitStrategy.5() {
        super(string, n, null);
    }

    public void run() {
        BaseTestConsumer.TestWaitStrategy.5.sleep((int)100);
    }
}
