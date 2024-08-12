/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableSource
 *  io.reactivex.Observer
 *  io.reactivex.internal.operators.observable.AbstractObservableWithUpstream
 *  io.reactivex.internal.operators.observable.ObservableElementAt$ElementAtObserver
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.internal.operators.observable.AbstractObservableWithUpstream;
import io.reactivex.internal.operators.observable.ObservableElementAt;

public final class ObservableElementAt<T>
extends AbstractObservableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    public ObservableElementAt(ObservableSource<T> observableSource, long l, T t, boolean bl) {
        super(observableSource);
        this.index = l;
        this.defaultValue = t;
        this.errorOnFewer = bl;
    }

    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe((Observer)new ElementAtObserver(observer, this.index, this.defaultValue, this.errorOnFewer));
    }
}
