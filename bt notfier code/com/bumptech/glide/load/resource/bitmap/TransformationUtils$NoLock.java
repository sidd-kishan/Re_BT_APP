/*
 * Decompiled with CFR 0.152.
 */
package com.bumptech.glide.load.resource.bitmap;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

private static final class TransformationUtils.NoLock
implements Lock {
    TransformationUtils.NoLock() {
    }

    @Override
    public void lock() {
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
    }

    @Override
    public Condition newCondition() {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override
    public boolean tryLock() {
        return true;
    }

    @Override
    public boolean tryLock(long l, TimeUnit timeUnit) throws InterruptedException {
        return true;
    }

    @Override
    public void unlock() {
    }
}
