/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.reactivestreams.Subscriber
 */
package io.reactivex.internal.util;

import org.reactivestreams.Subscriber;

public interface QueueDrain<T, U> {
    public boolean accept(Subscriber<? super U> var1, T var2);

    public boolean cancelled();

    public boolean done();

    public boolean enter();

    public Throwable error();

    public int leave(int var1);

    public long produced(long var1);

    public long requested();
}
