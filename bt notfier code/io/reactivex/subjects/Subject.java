/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.subjects.SerializedSubject
 */
package io.reactivex.subjects;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.subjects.SerializedSubject;

public abstract class Subject<T>
extends Observable<T>
implements Observer<T> {
    public abstract Throwable getThrowable();

    public abstract boolean hasComplete();

    public abstract boolean hasObservers();

    public abstract boolean hasThrowable();

    public final Subject<T> toSerialized() {
        if (!(this instanceof SerializedSubject)) return new SerializedSubject(this);
        return this;
    }
}
