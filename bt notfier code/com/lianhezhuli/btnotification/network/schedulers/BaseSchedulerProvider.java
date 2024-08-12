/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.ObservableTransformer
 *  io.reactivex.Scheduler
 */
package com.lianhezhuli.btnotification.network.schedulers;

import io.reactivex.ObservableTransformer;
import io.reactivex.Scheduler;

public interface BaseSchedulerProvider {
    public <T> ObservableTransformer<T, T> applySchedulers();

    public Scheduler computation();

    public Scheduler io();

    public Scheduler ui();
}
