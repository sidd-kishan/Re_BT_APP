/*
 * Decompiled with CFR 0.152.
 */
package io.reactivex.internal.fuseable;

public interface SimpleQueue<T> {
    public void clear();

    public boolean isEmpty();

    public boolean offer(T var1);

    public boolean offer(T var1, T var2);

    public T poll() throws Exception;
}
