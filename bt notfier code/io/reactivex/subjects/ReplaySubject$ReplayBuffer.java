/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.subjects.ReplaySubject$ReplayDisposable
 */
package io.reactivex.subjects;

import io.reactivex.subjects.ReplaySubject;

static interface ReplaySubject.ReplayBuffer<T> {
    public void add(T var1);

    public void addFinal(Object var1);

    public boolean compareAndSet(Object var1, Object var2);

    public Object get();

    public T getValue();

    public T[] getValues(T[] var1);

    public void replay(ReplaySubject.ReplayDisposable<T> var1);

    public int size();

    public void trimHead();
}
