/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.observers.BaseTestConsumer$TestWaitStrategy
 */
package io.reactivex.observers;

import io.reactivex.observers.BaseTestConsumer;

static final class BaseTestConsumer.TestWaitStrategy.2
extends BaseTestConsumer.TestWaitStrategy {
    BaseTestConsumer.TestWaitStrategy.2() {
        super(string, n, null);
    }

    public void run() {
        Thread.yield();
    }
}