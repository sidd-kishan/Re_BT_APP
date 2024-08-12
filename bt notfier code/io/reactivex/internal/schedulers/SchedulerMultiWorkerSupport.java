/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport$WorkerCallback
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.SchedulerMultiWorkerSupport;

public interface SchedulerMultiWorkerSupport {
    public void createWorkers(int var1, WorkerCallback var2);
}
