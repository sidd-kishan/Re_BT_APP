/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.observers.BaseTestConsumer$TestWaitStrategy
 */
package io.reactivex.observers;

import io.reactivex.observers.BaseTestConsumer;

static final class BaseTestConsumer.TestWaitStrategy.6
extends BaseTestConsumer.TestWaitStrategy {
    BaseTestConsumer.TestWaitStrategy.6() {
        super(string, n, null);
    }

    public void run() {
        BaseTestConsumer.TestWaitStrategy.6.sleep((int)1000);
    }
}