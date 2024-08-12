/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.MaybeObserver
 *  io.reactivex.MaybeSource
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream
 *  io.reactivex.internal.operators.maybe.MaybeDelay$DelayMaybeObserver
 */
package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;
import io.reactivex.Scheduler;
import io.reactivex.internal.operators.maybe.AbstractMaybeWithUpstream;
import io.reactivex.internal.operators.maybe.MaybeDelay;
import java.util.concurrent.TimeUnit;

public final class MaybeDelay<T>
extends AbstractMaybeWithUpstream<T, T> {
    final long delay;
    final Scheduler scheduler;
    final TimeUnit unit;

    public MaybeDelay(MaybeSource<T> maybeSource, long l, TimeUnit timeUnit, Scheduler scheduler) {
        super(maybeSource);
        this.delay = l;
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        this.source.subscribe((MaybeObserver)new DelayMaybeObserver(maybeObserver, this.delay, this.unit, this.scheduler));
    }
}
