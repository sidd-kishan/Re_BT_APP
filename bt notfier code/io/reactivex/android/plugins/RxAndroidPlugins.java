/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.exceptions.Exceptions
 *  io.reactivex.functions.Function
 */
package io.reactivex.android.plugins;

import io.reactivex.Scheduler;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.Function;
import java.util.concurrent.Callable;

public final class RxAndroidPlugins {
    private static volatile Function<Callable<Scheduler>, Scheduler> onInitMainThreadHandler;
    private static volatile Function<Scheduler, Scheduler> onMainThreadHandler;

    private RxAndroidPlugins() {
        throw new AssertionError((Object)"No instances.");
    }

    static <T, R> R apply(Function<T, R> object, T t) {
        try {
            object = object.apply(t);
        }
        catch (Throwable throwable) {
            throw Exceptions.propagate((Throwable)throwable);
        }
        return (R)object;
    }

    static Scheduler applyRequireNonNull(Function<Callable<Scheduler>, Scheduler> scheduler, Callable<Scheduler> callable) {
        if ((scheduler = RxAndroidPlugins.apply(scheduler, callable)) == null) throw new NullPointerException("Scheduler Callable returned null");
        return scheduler;
    }

    static Scheduler callRequireNonNull(Callable<Scheduler> object) {
        try {
            object = object.call();
            if (object != null) {
                return object;
            }
            object = new NullPointerException("Scheduler Callable returned null");
            throw object;
        }
        catch (Throwable throwable) {
            throw Exceptions.propagate((Throwable)throwable);
        }
    }

    public static Function<Callable<Scheduler>, Scheduler> getInitMainThreadSchedulerHandler() {
        return onInitMainThreadHandler;
    }

    public static Function<Scheduler, Scheduler> getOnMainThreadSchedulerHandler() {
        return onMainThreadHandler;
    }

    public static Scheduler initMainThreadScheduler(Callable<Scheduler> callable) {
        if (callable == null) throw new NullPointerException("scheduler == null");
        Function<Callable<Scheduler>, Scheduler> function = onInitMainThreadHandler;
        if (function != null) return RxAndroidPlugins.applyRequireNonNull(function, callable);
        return RxAndroidPlugins.callRequireNonNull(callable);
    }

    public static Scheduler onMainThreadScheduler(Scheduler scheduler) {
        if (scheduler == null) throw new NullPointerException("scheduler == null");
        Function<Scheduler, Scheduler> function = onMainThreadHandler;
        if (function != null) return RxAndroidPlugins.apply(function, scheduler);
        return scheduler;
    }

    public static void reset() {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(null);
        RxAndroidPlugins.setMainThreadSchedulerHandler(null);
    }

    public static void setInitMainThreadSchedulerHandler(Function<Callable<Scheduler>, Scheduler> function) {
        onInitMainThreadHandler = function;
    }

    public static void setMainThreadSchedulerHandler(Function<Scheduler, Scheduler> function) {
        onMainThreadHandler = function;
    }
}
