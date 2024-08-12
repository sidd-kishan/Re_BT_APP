/*
 * Decompiled with CFR 0.152.
 */
package androidx.constraintlayout.solver;

static interface Pools.Pool<T> {
    public T acquire();

    public boolean release(T var1);

    public void releaseAll(T[] var1, int var2);
}
