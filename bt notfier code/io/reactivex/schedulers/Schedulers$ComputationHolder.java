/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.schedulers.ComputationScheduler
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.ComputationScheduler;

static final class Schedulers.ComputationHolder {
    static final Scheduler DEFAULT = new ComputationScheduler();

    Schedulers.ComputationHolder() {
    }
}
