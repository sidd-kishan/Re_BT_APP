/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Completable
 *  io.reactivex.CompletableObserver
 *  io.reactivex.CompletableSource
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.completable.CompletableDelay$Delay
 */
package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableSource;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.completable.CompletableDelay;
import java.util.concurrent.TimeUnit;

public final class CompletableDelay
extends Completable {
    final long delay;
    final boolean delayError;
    final Scheduler scheduler;
    final CompletableSource source;
    final TimeUnit unit;

    public CompletableDelay(CompletableSource completableSource, long l, TimeUnit timeUnit, Scheduler scheduler, boolean bl) {
        this.source = completableSource;
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
        this.delayError = bl;
    }

    protected void subscribeActual(CompletableObserver completableObserver) {
        this.source.subscribe((CompletableObserver)new Delay(completableObserver, this.delay, this.unit, this.scheduler, this.delayError));
    }
}
