/*
 * Decompiled with CFR 0.152.
 */
package com.luck.picture.lib.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public static class PictureThreadUtils.SyncValue<T> {
    private AtomicBoolean mFlag;
    private CountDownLatch mLatch = new CountDownLatch(1);
    private T mValue;

    public PictureThreadUtils.SyncValue() {
        this.mFlag = new AtomicBoolean();
    }

    public T getValue() {
        if (this.mFlag.get()) return this.mValue;
        try {
            this.mLatch.await();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        return this.mValue;
    }

    public T getValue(long l, TimeUnit timeUnit, T t) {
        if (this.mFlag.get()) return this.mValue;
        try {
            this.mLatch.await(l, timeUnit);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            return t;
        }
        return this.mValue;
    }

    public void setValue(T t) {
        if (!this.mFlag.compareAndSet(false, true)) return;
        this.mValue = t;
        this.mLatch.countDown();
    }
}
