/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Observable
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl.StateObservable$ErrorWrapper
 *  androidx.camera.core.impl.StateObservable$ObserverWrapper
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class StateObservable<T>
implements Observable<T> {
    private static final int INITIAL_VERSION = 0;
    private final Object mLock = new Object();
    private final CopyOnWriteArraySet<ObserverWrapper<T>> mNotifySet;
    private final AtomicReference<Object> mState;
    private boolean mUpdating = false;
    private int mVersion = 0;
    private final Map<Observable.Observer<? super T>, ObserverWrapper<T>> mWrapperMap = new HashMap<Observable.Observer<? super T>, ObserverWrapper<T>>();

    StateObservable(Object object, boolean bl) {
        this.mNotifySet = new CopyOnWriteArraySet();
        if (bl) {
            Preconditions.checkArgument((boolean)(object instanceof Throwable), (Object)"Initial errors must be Throwable");
            this.mState = new AtomicReference<ErrorWrapper>(ErrorWrapper.wrap((Throwable)((Throwable)object)));
        } else {
            this.mState = new AtomicReference<Object>(object);
        }
    }

    private void removeObserverLocked(Observable.Observer<? super T> observer) {
        if ((observer = this.mWrapperMap.remove(observer)) == null) return;
        observer.close();
        this.mNotifySet.remove(observer);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private void updateStateInternal(Object iterator) {
        int n;
        Object object = this.mLock;
        synchronized (object) {
            if (Objects.equals(this.mState.getAndSet(iterator), iterator)) {
                return;
            }
            this.mVersion = n = this.mVersion + 1;
            if (this.mUpdating) {
                return;
            }
            this.mUpdating = true;
            iterator = this.mNotifySet.iterator();
            {
                catch (Throwable throwable) {}
                {
                    throw throwable;
                }
            }
        }
        while (true) {
            if (iterator.hasNext()) {
                iterator.next().update(n);
                continue;
            }
            object = this.mLock;
            synchronized (object) {
                if (this.mVersion == n) {
                    this.mUpdating = false;
                    return;
                }
                iterator = this.mNotifySet.iterator();
                n = this.mVersion;
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void addObserver(Executor executor, Observable.Observer<? super T> observer) {
        ObserverWrapper observerWrapper;
        Object object = this.mLock;
        synchronized (object) {
            this.removeObserverLocked(observer);
            observerWrapper = new ObserverWrapper(this.mState, executor, observer);
            this.mWrapperMap.put(observer, observerWrapper);
            this.mNotifySet.add(observerWrapper);
        }
        observerWrapper.update(0);
    }

    public ListenableFuture<T> fetchData() {
        Object object = this.mState.get();
        if (!(object instanceof ErrorWrapper)) return Futures.immediateFuture((Object)object);
        return Futures.immediateFailedFuture((Throwable)((ErrorWrapper)object).getError());
    }

    public void removeObserver(Observable.Observer<? super T> observer) {
        Object object = this.mLock;
        synchronized (object) {
            this.removeObserverLocked(observer);
            return;
        }
    }

    void updateState(T t) {
        this.updateStateInternal(t);
    }

    void updateStateAsError(Throwable throwable) {
        this.updateStateInternal(ErrorWrapper.wrap((Throwable)throwable));
    }
}
