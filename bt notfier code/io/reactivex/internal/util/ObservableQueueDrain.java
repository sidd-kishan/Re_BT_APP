/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observer
 */
package io.reactivex.internal.util;

import io.reactivex.Observer;

public interface ObservableQueueDrain<T, U> {
    public void accept(Observer<? super U> var1, T var2);

    public boolean cancelled();

    public boolean done();

    public boolean enter();

    public Throwable error();

    public int leave(int var1);
}
