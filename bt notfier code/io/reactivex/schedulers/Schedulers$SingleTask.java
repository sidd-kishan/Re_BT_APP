/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.schedulers.Schedulers$SingleHolder
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;

static final class Schedulers.SingleTask
implements Callable<Scheduler> {
    Schedulers.SingleTask() {
    }

    @Override
    public Scheduler call() throws Exception {
        return Schedulers.SingleHolder.DEFAULT;
    }
}
