/*
 * Decompiled with CFR 0.152.
 */
package androidx.core.util;

public static interface Pools.Pool<T> {
    public T acquire();

    public boolean release(T var1);
}
