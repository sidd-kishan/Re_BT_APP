/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.Flowable
 *  io.reactivex.Scheduler
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.disposables.Disposables
 *  io.reactivex.functions.Function
 *  io.reactivex.internal.schedulers.SchedulerWhen$CreateWorkerFunction
 *  io.reactivex.internal.schedulers.SchedulerWhen$QueueWorker
 *  io.reactivex.internal.schedulers.SchedulerWhen$SubscribedDisposable
 *  io.reactivex.internal.util.ExceptionHelper
 *  io.reactivex.processors.FlowableProcessor
 *  io.reactivex.processors.UnicastProcessor
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Function;
import io.reactivex.internal.schedulers.SchedulerWhen;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.processors.FlowableProcessor;
import io.reactivex.processors.UnicastProcessor;

public class SchedulerWhen
extends Scheduler
implements Disposable {
    static final Disposable DISPOSED;
    static final Disposable SUBSCRIBED;
    private final Scheduler actualScheduler;
    private Disposable disposable;
    private final FlowableProcessor<Flowable<Completable>> workerProcessor;

    static {
        SUBSCRIBED = new SubscribedDisposable();
        DISPOSED = Disposables.disposed();
    }

    public SchedulerWhen(Function<Flowable<Flowable<Completable>>, Completable> function, Scheduler scheduler) {
        this.actualScheduler = scheduler;
        this.workerProcessor = scheduler = UnicastProcessor.create().toSerialized();
        try {
            this.disposable = ((Completable)function.apply((Object)scheduler)).subscribe();
            return;
        }
        catch (Throwable throwable) {
            throw ExceptionHelper.wrapOrThrow((Throwable)throwable);
        }
    }

    public Scheduler.Worker createWorker() {
        Scheduler.Worker worker = this.actualScheduler.createWorker();
        FlowableProcessor flowableProcessor = UnicastProcessor.create().toSerialized();
        Flowable flowable = flowableProcessor.map((Function)new CreateWorkerFunction(worker));
        worker = new QueueWorker(flowableProcessor, worker);
        this.workerProcessor.onNext((Object)flowable);
        return worker;
    }

    public void dispose() {
        this.disposable.dispose();
    }

    public boolean isDisposed() {
        return this.disposable.isDisposed();
    }
}
