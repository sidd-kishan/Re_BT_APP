/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.schedulers.Schedulers$NewThreadHolder
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;

static final class Schedulers.NewThreadTask
implements Callable<Scheduler> {
    Schedulers.NewThreadTask() {
    }

    @Override
    public Scheduler call() throws Exception {
        return Schedulers.NewThreadHolder.DEFAULT;
    }
}
