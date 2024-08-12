/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.schedulers.ExecutorScheduler
 *  io.reactivex.internal.schedulers.SchedulerPoolFactory
 *  io.reactivex.internal.schedulers.TrampolineScheduler
 *  io.reactivex.plugins.RxJavaPlugins
 *  io.reactivex.schedulers.Schedulers$ComputationTask
 *  io.reactivex.schedulers.Schedulers$IOTask
 *  io.reactivex.schedulers.Schedulers$NewThreadTask
 *  io.reactivex.schedulers.Schedulers$SingleTask
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import io.reactivex.internal.schedulers.SchedulerPoolFactory;
import io.reactivex.internal.schedulers.TrampolineScheduler;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class Schedulers {
    static final Scheduler COMPUTATION;
    static final Scheduler IO;
    static final Scheduler NEW_THREAD;
    static final Scheduler SINGLE;
    static final Scheduler TRAMPOLINE;

    static {
        SINGLE = RxJavaPlugins.initSingleScheduler((Callable)new SingleTask());
        COMPUTATION = RxJavaPlugins.initComputationScheduler((Callable)new ComputationTask());
        IO = RxJavaPlugins.initIoScheduler((Callable)new IOTask());
        TRAMPOLINE = TrampolineScheduler.instance();
        NEW_THREAD = RxJavaPlugins.initNewThreadScheduler((Callable)new NewThreadTask());
    }

    private Schedulers() {
        throw new IllegalStateException("No instances!");
    }

    public static Scheduler computation() {
        return RxJavaPlugins.onComputationScheduler((Scheduler)COMPUTATION);
    }

    public static Scheduler from(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    public static Scheduler from(Executor executor, boolean bl) {
        return new ExecutorScheduler(executor, bl);
    }

    public static Scheduler io() {
        return RxJavaPlugins.onIoScheduler((Scheduler)IO);
    }

    public static Scheduler newThread() {
        return RxJavaPlugins.onNewThreadScheduler((Scheduler)NEW_THREAD);
    }

    public static void shutdown() {
        Schedulers.computation().shutdown();
        Schedulers.io().shutdown();
        Schedulers.newThread().shutdown();
        Schedulers.single().shutdown();
        Schedulers.trampoline().shutdown();
        SchedulerPoolFactory.shutdown();
    }

    public static Scheduler single() {
        return RxJavaPlugins.onSingleScheduler((Scheduler)SINGLE);
    }

    public static void start() {
        Schedulers.computation().start();
        Schedulers.io().start();
        Schedulers.newThread().start();
        Schedulers.single().start();
        Schedulers.trampoline().start();
        SchedulerPoolFactory.start();
    }

    public static Scheduler trampoline() {
        return TRAMPOLINE;
    }
}
