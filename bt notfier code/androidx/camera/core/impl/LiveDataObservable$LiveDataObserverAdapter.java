/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.LiveDataObservable$Result
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl._$$Lambda$LiveDataObservable$LiveDataObserverAdapter$BwSPpp5UumdKUg6VO_EGS78cZ_Y
 *  androidx.core.util.Preconditions
 *  androidx.lifecycle.Observer
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl._$;
import androidx.core.util.Preconditions;
import androidx.lifecycle.Observer;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

private static final class LiveDataObservable.LiveDataObserverAdapter<T>
implements Observer<LiveDataObservable.Result<T>> {
    final AtomicBoolean mActive = new AtomicBoolean(true);
    final Executor mExecutor;
    final Observable.Observer<? super T> mObserver;

    LiveDataObservable.LiveDataObserverAdapter(Executor executor, Observable.Observer<? super T> observer) {
        this.mExecutor = executor;
        this.mObserver = observer;
    }

    void disable() {
        this.mActive.set(false);
    }

    public /* synthetic */ void lambda$onChanged$0$LiveDataObservable$LiveDataObserverAdapter(LiveDataObservable.Result result) {
        if (!this.mActive.get()) {
            return;
        }
        if (result.completedSuccessfully()) {
            this.mObserver.onNewData(result.getValue());
        } else {
            Preconditions.checkNotNull((Object)result.getError());
            this.mObserver.onError(result.getError());
        }
    }

    public void onChanged(LiveDataObservable.Result<T> result) {
        this.mExecutor.execute((Runnable)new _$.Lambda.LiveDataObservable.LiveDataObserverAdapter.BwSPpp5UumdKUg6VO_EGS78cZ_Y(this, result));
    }
}
