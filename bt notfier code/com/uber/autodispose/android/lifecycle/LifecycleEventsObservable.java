/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleObserver
 *  com.uber.autodispose.android.internal.AutoDisposeAndroidUtil
 *  com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$1
 *  com.uber.autodispose.android.lifecycle.LifecycleEventsObservable$ArchLifecycleObserver
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.subjects.BehaviorSubject
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import com.uber.autodispose.android.internal.AutoDisposeAndroidUtil;
import com.uber.autodispose.android.lifecycle.LifecycleEventsObservable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;

class LifecycleEventsObservable
extends Observable<Lifecycle.Event> {
    private final BehaviorSubject<Lifecycle.Event> eventsObservable = BehaviorSubject.create();
    private final Lifecycle lifecycle;

    LifecycleEventsObservable(Lifecycle lifecycle) {
        this.lifecycle = lifecycle;
    }

    void backfillEvents() {
        int n = 1.$SwitchMap$android$arch$lifecycle$Lifecycle$State[this.lifecycle.getCurrentState().ordinal()];
        Lifecycle.Event event = n != 1 ? (n != 2 ? (n != 3 && n != 4 ? Lifecycle.Event.ON_DESTROY : Lifecycle.Event.ON_RESUME) : Lifecycle.Event.ON_START) : Lifecycle.Event.ON_CREATE;
        this.eventsObservable.onNext((Object)event);
    }

    Lifecycle.Event getValue() {
        return (Lifecycle.Event)this.eventsObservable.getValue();
    }

    protected void subscribeActual(Observer<? super Lifecycle.Event> observer) {
        ArchLifecycleObserver archLifecycleObserver = new ArchLifecycleObserver(this.lifecycle, observer, this.eventsObservable);
        observer.onSubscribe((Disposable)archLifecycleObserver);
        if (!AutoDisposeAndroidUtil.isMainThread()) {
            observer.onError((Throwable)new IllegalStateException("Lifecycles can only be bound to on the main thread!"));
            return;
        }
        this.lifecycle.addObserver((LifecycleObserver)archLifecycleObserver);
        if (!archLifecycleObserver.isDisposed()) return;
        this.lifecycle.removeObserver((LifecycleObserver)archLifecycleObserver);
    }
}
