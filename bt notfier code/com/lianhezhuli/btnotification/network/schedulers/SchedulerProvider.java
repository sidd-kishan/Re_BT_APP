/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.lianhezhuli.btnotification.network.schedulers.BaseSchedulerProvider
 *  io.reactivex.ObservableTransformer
 *  io.reactivex.Scheduler
 *  io.reactivex.android.schedulers.AndroidSchedulers
 *  io.reactivex.schedulers.Schedulers
 */
package com.lianhezhuli.btnotification.network.schedulers;

import com.lianhezhuli.btnotification.network.schedulers.BaseSchedulerProvider;
import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class SchedulerProvider
implements BaseSchedulerProvider {
    private static SchedulerProvider INSTANCE;

    private SchedulerProvider() {
    }

    public static SchedulerProvider getInstance() {
        synchronized (SchedulerProvider.class) {
            SchedulerProvider schedulerProvider;
            if (INSTANCE == null) {
                INSTANCE = schedulerProvider = new SchedulerProvider();
            }
            schedulerProvider = INSTANCE;
            return schedulerProvider;
        }
    }

    public <T> ObservableTransformer<T, T> applySchedulers() {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public Scheduler computation() {
        return Schedulers.computation();
    }

    public Scheduler io() {
        return Schedulers.io();
    }

    public Scheduler ui() {
        return AndroidSchedulers.mainThread();
    }
}
