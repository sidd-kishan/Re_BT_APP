/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.uber.autodispose.AutoDisposePlugins
 *  com.uber.autodispose.OutsideScopeException
 *  com.uber.autodispose.lifecycle.LifecycleEndedException
 *  com.uber.autodispose.lifecycle.LifecycleNotStartedException
 *  com.uber.autodispose.lifecycle.LifecycleScopeProvider
 *  com.uber.autodispose.lifecycle._$$Lambda$LifecycleScopes$G1LKlBOCt1oQBQl4AgpxLOoK0Lo
 *  com.uber.autodispose.lifecycle._$$Lambda$LifecycleScopes$QjBSMVQrZjtPM9ygkYg0RoZmuAw
 *  com.uber.autodispose.lifecycle._$$Lambda$rF8UpyPO5WNLy__kM5ijr_r552c
 *  io.reactivex.Completable
 *  io.reactivex.CompletableSource
 *  io.reactivex.Observable
 */
package com.uber.autodispose.lifecycle;

import com.uber.autodispose.AutoDisposePlugins;
import com.uber.autodispose.OutsideScopeException;
import com.uber.autodispose.lifecycle.LifecycleEndedException;
import com.uber.autodispose.lifecycle.LifecycleNotStartedException;
import com.uber.autodispose.lifecycle.LifecycleScopeProvider;
import com.uber.autodispose.lifecycle._$;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import java.util.Comparator;

public final class LifecycleScopes {
    private static final Comparator<Comparable<Object>> COMPARABLE_COMPARATOR = _$.Lambda.rF8UpyPO5WNLy__kM5ijr_r552c.INSTANCE;

    private LifecycleScopes() {
        throw new InstantiationError();
    }

    static /* synthetic */ boolean lambda$resolveScopeFromLifecycle$0(Comparator comparator, Object object, Object object2) throws Exception {
        boolean bl = comparator.compare(object2, object) >= 0;
        return bl;
    }

    static /* synthetic */ boolean lambda$resolveScopeFromLifecycle$1(Object object, Object object2) throws Exception {
        return object2.equals(object);
    }

    public static <E> CompletableSource resolveScopeFromLifecycle(LifecycleScopeProvider<E> lifecycleScopeProvider) throws OutsideScopeException {
        return LifecycleScopes.resolveScopeFromLifecycle(lifecycleScopeProvider, true);
    }

    public static <E> CompletableSource resolveScopeFromLifecycle(LifecycleScopeProvider<E> lifecycleScopeProvider, boolean bl) throws OutsideScopeException {
        Object object = lifecycleScopeProvider.peekLifecycle();
        Object object2 = lifecycleScopeProvider.correspondingEvents();
        if (object == null) throw new LifecycleNotStartedException();
        try {
            object2 = object2.apply(object);
        }
        catch (Exception exception) {
            if (!bl) return Completable.error((Throwable)exception);
            if (!(exception instanceof LifecycleEndedException)) return Completable.error((Throwable)exception);
            object2 = AutoDisposePlugins.getOutsideScopeHandler();
            if (object2 == null) throw exception;
            try {
                object2.accept((Object)((LifecycleEndedException)exception));
                Completable completable = Completable.complete();
                return completable;
            }
            catch (Exception exception2) {
                return Completable.error((Throwable)exception2);
            }
        }
        return LifecycleScopes.resolveScopeFromLifecycle(lifecycleScopeProvider.lifecycle(), object2);
    }

    public static <E> CompletableSource resolveScopeFromLifecycle(Observable<E> observable, E e) {
        Comparator<Comparable<Object>> comparator = e instanceof Comparable ? COMPARABLE_COMPARATOR : null;
        return LifecycleScopes.resolveScopeFromLifecycle(observable, e, comparator);
    }

    public static <E> CompletableSource resolveScopeFromLifecycle(Observable<E> observable, E object, Comparator<E> comparator) {
        object = comparator != null ? new _$.Lambda.LifecycleScopes.G1LKlBOCt1oQBQl4AgpxLOoK0Lo(comparator, object) : new _$.Lambda.LifecycleScopes.QjBSMVQrZjtPM9ygkYg0RoZmuAw(object);
        return observable.skip(1L).takeUntil(object).ignoreElements();
    }
}
