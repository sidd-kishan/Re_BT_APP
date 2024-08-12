/*
 * Decompiled with CFR 0.152.
 */
package org.greenrobot.greendao.identityscope;

public interface IdentityScope<K, T> {
    public void clear();

    public boolean detach(K var1, T var2);

    public T get(K var1);

    public T getNoLock(K var1);

    public void lock();

    public void put(K var1, T var2);

    public void putNoLock(K var1, T var2);

    public void remove(Iterable<K> var1);

    public void remove(K var1);

    public void reserveRoom(int var1);

    public void unlock();
}
