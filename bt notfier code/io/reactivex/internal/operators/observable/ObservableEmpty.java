/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.fuseable.ScalarCallable
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.fuseable.ScalarCallable;

public final class ObservableEmpty
extends Observable<Object>
implements ScalarCallable<Object> {
    public static final Observable<Object> INSTANCE = new ObservableEmpty();

    private ObservableEmpty() {
    }

    public Object call() {
        return null;
    }

    protected void subscribeActual(Observer<? super Object> observer) {
        EmptyDisposable.complete(observer);
    }
}
