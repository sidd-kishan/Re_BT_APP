/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.Lifecycle$Event
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.OnLifecycleEvent
 *  com.uber.autodispose.android.internal.MainThreadDisposable
 *  io.reactivex.Observer
 *  io.reactivex.subjects.BehaviorSubject
 */
package com.uber.autodispose.android.lifecycle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import com.uber.autodispose.android.internal.MainThreadDisposable;
import io.reactivex.Observer;
import io.reactivex.subjects.BehaviorSubject;

static final class LifecycleEventsObservable.ArchLifecycleObserver
extends MainThreadDisposable
implements LifecycleObserver {
    private final BehaviorSubject<Lifecycle.Event> eventsObservable;
    private final Lifecycle lifecycle;
    private final Observer<? super Lifecycle.Event> observer;

    LifecycleEventsObservable.ArchLifecycleObserver(Lifecycle lifecycle, Observer<? super Lifecycle.Event> observer, BehaviorSubject<Lifecycle.Event> behaviorSubject) {
        this.lifecycle = lifecycle;
        this.observer = observer;
        this.eventsObservable = behaviorSubject;
    }

    protected void onDispose() {
        this.lifecycle.removeObserver((LifecycleObserver)this);
    }

    @OnLifecycleEvent(value=Lifecycle.Event.ON_ANY)
    void onStateChange(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        if (this.isDisposed()) return;
        if (event != Lifecycle.Event.ON_CREATE || this.eventsObservable.getValue() != event) {
            this.eventsObservable.onNext((Object)event);
        }
        this.observer.onNext((Object)event);
    }
}
