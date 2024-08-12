/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.functions.Function
 *  io.reactivex.schedulers.Timed
 */
package io.reactivex.internal.functions;

import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Timed;
import java.util.concurrent.TimeUnit;

static final class Functions.TimestampFunction<T>
implements Function<T, Timed<T>> {
    final Scheduler scheduler;
    final TimeUnit unit;

    Functions.TimestampFunction(TimeUnit timeUnit, Scheduler scheduler) {
        this.unit = timeUnit;
        this.scheduler = scheduler;
    }

    public Timed<T> apply(T t) throws Exception {
        return new Timed(t, this.scheduler.now(this.unit), this.unit);
    }
}
