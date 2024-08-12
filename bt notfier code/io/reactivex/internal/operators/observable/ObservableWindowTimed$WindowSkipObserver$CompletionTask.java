/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.subjects.UnicastSubject;

final class ObservableWindowTimed.WindowSkipObserver.CompletionTask
implements Runnable {
    final ObservableWindowTimed.WindowSkipObserver this$0;
    private final UnicastSubject<T> w;

    ObservableWindowTimed.WindowSkipObserver.CompletionTask(ObservableWindowTimed.WindowSkipObserver windowSkipObserver, UnicastSubject<T> unicastSubject) {
        this.this$0 = windowSkipObserver;
        this.w = unicastSubject;
    }

    @Override
    public void run() {
        this.this$0.complete(this.w);
    }
}
