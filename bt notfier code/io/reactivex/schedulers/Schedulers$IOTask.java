/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.schedulers.Schedulers$IoHolder
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import java.util.concurrent.Callable;

static final class Schedulers.IOTask
implements Callable<Scheduler> {
    Schedulers.IOTask() {
    }

    @Override
    public Scheduler call() throws Exception {
        return Schedulers.IoHolder.DEFAULT;
    }
}
