/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 *  androidx.camera.core.impl.LiveDataObservable$LiveDataObserverAdapter
 *  androidx.camera.core.impl.LiveDataObservable$Result
 *  androidx.camera.core.impl.Observable
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl._$$Lambda$LiveDataObservable$h8NBQRzxdCxBjhhUPOMTo5JmO8Q
 *  androidx.camera.core.impl._$$Lambda$LiveDataObservable$j4b4lA5bQBc91r0py9kG1SyQAa4
 *  androidx.camera.core.impl._$$Lambda$LiveDataObservable$qW8U_4iZgDjYfD6HHgt4vQfYPRY
 *  androidx.camera.core.impl._$$Lambda$LiveDataObservable$wtQDCfFf1Ih5nHx5_ovHcE5BosE
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.util.Preconditions
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MutableLiveData
 *  androidx.lifecycle.Observer
 */
package androidx.camera.core.impl;

import android.os.SystemClock;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl._$;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
public final class LiveDataObservable<T>
implements Observable<T> {
    final MutableLiveData<Result<T>> mLiveData = new MutableLiveData();
    private final Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> mObservers = new HashMap<Observable.Observer<? super T>, LiveDataObserverAdapter<T>>();

    public void addObserver(Executor executor, Observable.Observer<? super T> h8NBQRzxdCxBjhhUPOMTo5JmO8Q2) {
        Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> map = this.mObservers;
        synchronized (map) {
            LiveDataObserverAdapter<T> liveDataObserverAdapter = this.mObservers.get(h8NBQRzxdCxBjhhUPOMTo5JmO8Q2);
            if (liveDataObserverAdapter != null) {
                liveDataObserverAdapter.disable();
            }
            LiveDataObserverAdapter liveDataObserverAdapter2 = new LiveDataObserverAdapter(executor, h8NBQRzxdCxBjhhUPOMTo5JmO8Q2);
            this.mObservers.put((Observable.Observer<T>)h8NBQRzxdCxBjhhUPOMTo5JmO8Q2, (LiveDataObserverAdapter<T>)liveDataObserverAdapter2);
            executor = CameraXExecutors.mainThreadExecutor();
            h8NBQRzxdCxBjhhUPOMTo5JmO8Q2 = new _$.Lambda.LiveDataObservable.h8NBQRzxdCxBjhhUPOMTo5JmO8Q(this, liveDataObserverAdapter, liveDataObserverAdapter2);
            executor.execute((Runnable)h8NBQRzxdCxBjhhUPOMTo5JmO8Q2);
            return;
        }
    }

    public ListenableFuture<T> fetchData() {
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.LiveDataObservable.qW8U_4iZgDjYfD6HHgt4vQfYPRY(this));
    }

    public LiveData<Result<T>> getLiveData() {
        return this.mLiveData;
    }

    public /* synthetic */ void lambda$addObserver$2$LiveDataObservable(LiveDataObserverAdapter liveDataObserverAdapter, LiveDataObserverAdapter liveDataObserverAdapter2) {
        if (liveDataObserverAdapter != null) {
            this.mLiveData.removeObserver((Observer)liveDataObserverAdapter);
        }
        this.mLiveData.observeForever((Observer)liveDataObserverAdapter2);
    }

    public /* synthetic */ void lambda$fetchData$0$LiveDataObservable(CallbackToFutureAdapter.Completer completer) {
        Result result = (Result)this.mLiveData.getValue();
        if (result == null) {
            completer.setException((Throwable)new IllegalStateException("Observable has not yet been initialized with a value."));
        } else if (result.completedSuccessfully()) {
            completer.set(result.getValue());
        } else {
            Preconditions.checkNotNull((Object)result.getError());
            completer.setException(result.getError());
        }
    }

    public /* synthetic */ Object lambda$fetchData$1$LiveDataObservable(CallbackToFutureAdapter.Completer object) throws Exception {
        CameraXExecutors.mainThreadExecutor().execute((Runnable)new _$.Lambda.LiveDataObservable.j4b4lA5bQBc91r0py9kG1SyQAa4(this, (CallbackToFutureAdapter.Completer)object));
        object = new StringBuilder();
        ((StringBuilder)object).append(this);
        ((StringBuilder)object).append(" [fetch@");
        ((StringBuilder)object).append(SystemClock.uptimeMillis());
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public /* synthetic */ void lambda$removeObserver$3$LiveDataObservable(LiveDataObserverAdapter liveDataObserverAdapter) {
        this.mLiveData.removeObserver((Observer)liveDataObserverAdapter);
    }

    public void postError(Throwable throwable) {
        this.mLiveData.postValue((Object)Result.fromError((Throwable)throwable));
    }

    public void postValue(T t) {
        this.mLiveData.postValue((Object)Result.fromValue(t));
    }

    public void removeObserver(Observable.Observer<? super T> object) {
        Map<Observable.Observer<? super T>, LiveDataObserverAdapter<T>> map = this.mObservers;
        synchronized (map) {
            LiveDataObserverAdapter<T> liveDataObserverAdapter = this.mObservers.remove(object);
            if (liveDataObserverAdapter == null) return;
            liveDataObserverAdapter.disable();
            object = CameraXExecutors.mainThreadExecutor();
            _$.Lambda.LiveDataObservable.wtQDCfFf1Ih5nHx5_ovHcE5BosE wtQDCfFf1Ih5nHx5_ovHcE5BosE2 = new _$.Lambda.LiveDataObservable.wtQDCfFf1Ih5nHx5_ovHcE5BosE(this, liveDataObserverAdapter);
            object.execute((Runnable)wtQDCfFf1Ih5nHx5_ovHcE5BosE2);
            return;
        }
    }
}
