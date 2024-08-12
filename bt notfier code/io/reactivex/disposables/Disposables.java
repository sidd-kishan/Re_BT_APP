/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.ActionDisposable
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.FutureDisposable
 *  io.reactivex.disposables.RunnableDisposable
 *  io.reactivex.disposables.SubscriptionDisposable
 *  io.reactivex.functions.Action
 *  io.reactivex.internal.disposables.EmptyDisposable
 *  io.reactivex.internal.functions.Functions
 *  io.reactivex.internal.functions.ObjectHelper
 *  org.reactivestreams.Subscription
 */
package io.reactivex.disposables;

import io.reactivex.disposables.ActionDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.FutureDisposable;
import io.reactivex.disposables.RunnableDisposable;
import io.reactivex.disposables.SubscriptionDisposable;
import io.reactivex.functions.Action;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.concurrent.Future;
import org.reactivestreams.Subscription;

public final class Disposables {
    private Disposables() {
        throw new IllegalStateException("No instances!");
    }

    public static Disposable disposed() {
        return EmptyDisposable.INSTANCE;
    }

    public static Disposable empty() {
        return Disposables.fromRunnable(Functions.EMPTY_RUNNABLE);
    }

    public static Disposable fromAction(Action action) {
        ObjectHelper.requireNonNull((Object)action, (String)"run is null");
        return new ActionDisposable(action);
    }

    public static Disposable fromFuture(Future<?> future) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        return Disposables.fromFuture(future, true);
    }

    public static Disposable fromFuture(Future<?> future, boolean bl) {
        ObjectHelper.requireNonNull(future, (String)"future is null");
        return new FutureDisposable(future, bl);
    }

    public static Disposable fromRunnable(Runnable runnable) {
        ObjectHelper.requireNonNull((Object)runnable, (String)"run is null");
        return new RunnableDisposable(runnable);
    }

    public static Disposable fromSubscription(Subscription subscription) {
        ObjectHelper.requireNonNull((Object)subscription, (String)"subscription is null");
        return new SubscriptionDisposable(subscription);
    }
}
