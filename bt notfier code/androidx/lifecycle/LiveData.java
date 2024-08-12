/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.executor.ArchTaskExecutor
 *  androidx.arch.core.internal.SafeIterableMap
 *  androidx.arch.core.internal.SafeIterableMap$IteratorWithAdditions
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData$AlwaysActiveObserver
 *  androidx.lifecycle.LiveData$LifecycleBoundObserver
 *  androidx.lifecycle.LiveData$ObserverWrapper
 *  androidx.lifecycle.Observer
 */
package androidx.lifecycle;

import androidx.arch.core.executor.ArchTaskExecutor;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    int mActiveCount = 0;
    private boolean mChangingActiveState;
    private volatile Object mData;
    final Object mDataLock = new Object();
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private SafeIterableMap<Observer<? super T>, ObserverWrapper> mObservers = new SafeIterableMap();
    volatile Object mPendingData = NOT_SET;
    private final Runnable mPostValueRunnable = new /* Unavailable Anonymous Inner Class!! */;
    private int mVersion;

    public LiveData() {
        this.mData = NOT_SET;
        this.mVersion = -1;
    }

    public LiveData(T t) {
        this.mData = t;
        this.mVersion = 0;
    }

    static void assertMainThread(String string) {
        if (ArchTaskExecutor.getInstance().isMainThread()) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cannot invoke ");
        stringBuilder.append(string);
        stringBuilder.append(" on a background thread");
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void considerNotify(ObserverWrapper observerWrapper) {
        if (!observerWrapper.mActive) {
            return;
        }
        if (!observerWrapper.shouldBeActive()) {
            observerWrapper.activeStateChanged(false);
            return;
        }
        int n = observerWrapper.mLastVersion;
        int n2 = this.mVersion;
        if (n >= n2) {
            return;
        }
        observerWrapper.mLastVersion = n2;
        observerWrapper.mObserver.onChanged(this.mData);
    }

    void changeActiveCounter(int n) {
        int n2 = this.mActiveCount;
        this.mActiveCount = n + n2;
        if (this.mChangingActiveState) {
            return;
        }
        this.mChangingActiveState = true;
        try {
            while (true) {
                if (n2 == this.mActiveCount) {
                    this.mChangingActiveState = false;
                    return;
                }
                n = n2 == 0 && this.mActiveCount > 0 ? 1 : 0;
                n2 = n2 > 0 && this.mActiveCount == 0 ? 1 : 0;
                int n3 = this.mActiveCount;
                if (n != 0) {
                    this.onActive();
                } else if (n2 != 0) {
                    this.onInactive();
                }
                n2 = n3;
            }
        }
        catch (Throwable throwable) {
            this.mChangingActiveState = false;
            throw throwable;
        }
    }

    void dispatchingValue(ObserverWrapper observerWrapper) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            ObserverWrapper observerWrapper2;
            block5: {
                this.mDispatchInvalidated = false;
                if (observerWrapper != null) {
                    this.considerNotify(observerWrapper);
                    observerWrapper2 = null;
                } else {
                    SafeIterableMap.IteratorWithAdditions iteratorWithAdditions = this.mObservers.iteratorWithAdditions();
                    do {
                        observerWrapper2 = observerWrapper;
                        if (!iteratorWithAdditions.hasNext()) break block5;
                        this.considerNotify((ObserverWrapper)((Map.Entry)iteratorWithAdditions.next()).getValue());
                    } while (!this.mDispatchInvalidated);
                    observerWrapper2 = observerWrapper;
                }
            }
            observerWrapper = observerWrapper2;
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public T getValue() {
        Object object = this.mData;
        if (object == NOT_SET) return null;
        return (T)object;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasActiveObservers() {
        boolean bl = this.mActiveCount > 0;
        return bl;
    }

    public boolean hasObservers() {
        boolean bl = this.mObservers.size() > 0;
        return bl;
    }

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observerWrapper) {
        LiveData.assertMainThread("observe");
        if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(this, lifecycleOwner, observerWrapper);
        if ((observerWrapper = (ObserverWrapper)this.mObservers.putIfAbsent(observerWrapper, (Object)lifecycleBoundObserver)) != null) {
            if (!observerWrapper.isAttachedTo(lifecycleOwner)) throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (observerWrapper != null) {
            return;
        }
        lifecycleOwner.getLifecycle().addObserver((LifecycleObserver)lifecycleBoundObserver);
    }

    public void observeForever(Observer<? super T> observerWrapper) {
        LiveData.assertMainThread("observeForever");
        AlwaysActiveObserver alwaysActiveObserver = new AlwaysActiveObserver(this, observerWrapper);
        observerWrapper = (ObserverWrapper)this.mObservers.putIfAbsent(observerWrapper, (Object)alwaysActiveObserver);
        if (observerWrapper instanceof LifecycleBoundObserver) throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        if (observerWrapper != null) {
            return;
        }
        alwaysActiveObserver.activeStateChanged(true);
    }

    protected void onActive() {
    }

    protected void onInactive() {
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    protected void postValue(T t) {
        Object object = this.mDataLock;
        // MONITORENTER : object
        boolean bl = this.mPendingData == NOT_SET;
        this.mPendingData = t;
        // MONITOREXIT : object
        if (!bl) {
            return;
        }
        ArchTaskExecutor.getInstance().postToMainThread(this.mPostValueRunnable);
    }

    public void removeObserver(Observer<? super T> observerWrapper) {
        LiveData.assertMainThread("removeObserver");
        observerWrapper = (ObserverWrapper)this.mObservers.remove(observerWrapper);
        if (observerWrapper == null) {
            return;
        }
        observerWrapper.detachObserver();
        observerWrapper.activeStateChanged(false);
    }

    public void removeObservers(LifecycleOwner lifecycleOwner) {
        LiveData.assertMainThread("removeObservers");
        Iterator iterator = this.mObservers.iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (!((ObserverWrapper)entry.getValue()).isAttachedTo(lifecycleOwner)) continue;
            this.removeObserver((Observer)entry.getKey());
        }
    }

    protected void setValue(T t) {
        LiveData.assertMainThread("setValue");
        ++this.mVersion;
        this.mData = t;
        this.dispatchingValue(null);
    }
}
