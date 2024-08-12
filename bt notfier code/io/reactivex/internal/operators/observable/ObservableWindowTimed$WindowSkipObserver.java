/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Observable
 *  io.reactivex.Observer
 *  io.reactivex.Scheduler$Worker
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.internal.disposables.DisposableHelper
 *  io.reactivex.internal.fuseable.SimplePlainQueue
 *  io.reactivex.internal.observers.QueueDrainObserver
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver$CompletionTask
 *  io.reactivex.internal.operators.observable.ObservableWindowTimed$WindowSkipObserver$SubjectWork
 *  io.reactivex.internal.queue.MpscLinkedQueue
 *  io.reactivex.subjects.UnicastSubject
 */
package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.fuseable.SimplePlainQueue;
import io.reactivex.internal.observers.QueueDrainObserver;
import io.reactivex.internal.operators.observable.ObservableWindowTimed;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.subjects.UnicastSubject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

static final class ObservableWindowTimed.WindowSkipObserver<T>
extends QueueDrainObserver<T, Object, Observable<T>>
implements Disposable,
Runnable {
    final int bufferSize;
    volatile boolean terminated;
    final long timeskip;
    final long timespan;
    final TimeUnit unit;
    Disposable upstream;
    final List<UnicastSubject<T>> windows;
    final Scheduler.Worker worker;

    ObservableWindowTimed.WindowSkipObserver(Observer<? super Observable<T>> observer, long l, long l2, TimeUnit timeUnit, Scheduler.Worker worker, int n) {
        super(observer, (SimplePlainQueue)new MpscLinkedQueue());
        this.timespan = l;
        this.timeskip = l2;
        this.unit = timeUnit;
        this.worker = worker;
        this.bufferSize = n;
        this.windows = new LinkedList<UnicastSubject<T>>();
    }

    void complete(UnicastSubject<T> unicastSubject) {
        this.queue.offer((Object)new SubjectWork(unicastSubject, false));
        if (!this.enter()) return;
        this.drainLoop();
    }

    public void dispose() {
        this.cancelled = true;
    }

    void disposeWorker() {
        this.worker.dispose();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    void drainLoop() {
        var6_1 = (MpscLinkedQueue)this.queue;
        var7_2 /* !! */  = this.downstream;
        var5_3 = this.windows;
        var1_4 = 1;
        block0: while (true) {
            if (this.terminated) {
                this.upstream.dispose();
                this.disposeWorker();
                var6_1.clear();
                var5_3.clear();
                return;
            }
            var3_6 = this.done;
            var8_8 = var6_1.poll();
            var2_5 = var8_8 == null ? 1 : 0;
            var4_7 = var8_8 instanceof SubjectWork;
            if (var3_6 && (var2_5 != 0 || var4_7)) {
                var6_1.clear();
                var7_2 /* !! */  = this.error;
                if (var7_2 /* !! */  != null) {
                    var6_1 = var5_3.iterator();
                    while (var6_1.hasNext()) {
                        ((UnicastSubject)var6_1.next()).onError((Throwable)var7_2 /* !! */ );
                    }
                } else {
                    var6_1 = var5_3.iterator();
                    while (var6_1.hasNext()) {
                        ((UnicastSubject)var6_1.next()).onComplete();
                    }
                }
                this.disposeWorker();
                var5_3.clear();
                return;
            }
            if (var2_5 != 0) {
                var1_4 = var2_5 = this.leave(-var1_4);
                if (var2_5 != 0) continue;
                return;
            }
            if (var4_7) {
                var8_8 = (SubjectWork)var8_8;
                if (var8_8.open) {
                    if (this.cancelled) continue;
                    var8_8 = UnicastSubject.create((int)this.bufferSize);
                    var5_3.add((UnicastSubject<T>)var8_8);
                    var7_2 /* !! */ .onNext(var8_8);
                    this.worker.schedule((Runnable)new CompletionTask(this, (UnicastSubject)var8_8), this.timespan, this.unit);
                    continue;
                }
                var5_3.remove(var8_8.w);
                var8_8.w.onComplete();
                if (!var5_3.isEmpty() || !this.cancelled) continue;
                this.terminated = true;
                continue;
            }
            var9_9 = var5_3.iterator();
            while (true) {
                if (var9_9.hasNext()) ** break;
                continue block0;
                var9_9.next().onNext(var8_8);
            }
            break;
        }
    }

    public boolean isDisposed() {
        return this.cancelled;
    }

    public void onComplete() {
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.downstream.onComplete();
        this.disposeWorker();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        if (this.enter()) {
            this.drainLoop();
        }
        this.downstream.onError(throwable);
        this.disposeWorker();
    }

    public void onNext(T t) {
        if (this.fastEnter()) {
            Iterator<UnicastSubject<T>> iterator = this.windows.iterator();
            while (iterator.hasNext()) {
                iterator.next().onNext(t);
            }
            if (this.leave(-1) == 0) {
                return;
            }
        } else {
            this.queue.offer(t);
            if (!this.enter()) {
                return;
            }
        }
        this.drainLoop();
    }

    public void onSubscribe(Disposable disposable) {
        if (!DisposableHelper.validate((Disposable)this.upstream, (Disposable)disposable)) return;
        this.upstream = disposable;
        this.downstream.onSubscribe((Disposable)this);
        if (this.cancelled) {
            return;
        }
        disposable = UnicastSubject.create((int)this.bufferSize);
        this.windows.add((UnicastSubject<T>)disposable);
        this.downstream.onNext((Object)disposable);
        this.worker.schedule((Runnable)new CompletionTask(this, (UnicastSubject)disposable), this.timespan, this.unit);
        disposable = this.worker;
        long l = this.timeskip;
        disposable.schedulePeriodically((Runnable)this, l, l, this.unit);
    }

    @Override
    public void run() {
        SubjectWork subjectWork = new SubjectWork(UnicastSubject.create((int)this.bufferSize), true);
        if (!this.cancelled) {
            this.queue.offer((Object)subjectWork);
        }
        if (!this.enter()) return;
        this.drainLoop();
    }
}
