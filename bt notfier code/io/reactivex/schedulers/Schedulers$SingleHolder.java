/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.schedulers.SingleScheduler
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.SingleScheduler;

static final class Schedulers.SingleHolder {
    static final Scheduler DEFAULT = new SingleScheduler();

    Schedulers.SingleHolder() {
    }
}
