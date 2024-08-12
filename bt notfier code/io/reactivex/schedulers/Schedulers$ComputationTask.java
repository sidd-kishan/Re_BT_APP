/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.schedulers.Schedulers$ComputationHolder
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;

static final class Schedulers.ComputationTask
implements Callable<Scheduler> {
    Schedulers.ComputationTask() {
    }

    @Override
    public Scheduler call() throws Exception {
        return Schedulers.ComputationHolder.DEFAULT;
    }
}
