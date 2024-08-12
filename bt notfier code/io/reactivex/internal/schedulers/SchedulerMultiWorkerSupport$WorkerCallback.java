/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler$Worker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.Scheduler;

public static interface SchedulerMultiWorkerSupport.WorkerCallback {
    public void onWorker(int var1, Scheduler.Worker var2);
}
