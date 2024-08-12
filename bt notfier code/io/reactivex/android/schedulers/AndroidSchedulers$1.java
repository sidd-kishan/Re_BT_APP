/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.android.schedulers.AndroidSchedulers$MainHolder
 */
package io.reactivex.android.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.concurrent.Callable;

static final class AndroidSchedulers.1
implements Callable<Scheduler> {
    AndroidSchedulers.1() {
    }

    @Override
    public Scheduler call() throws Exception {
        return AndroidSchedulers.MainHolder.DEFAULT;
    }
}
