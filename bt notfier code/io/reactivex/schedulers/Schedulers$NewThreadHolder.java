/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.schedulers.NewThreadScheduler
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.NewThreadScheduler;

static final class Schedulers.NewThreadHolder {
    static final Scheduler DEFAULT = new NewThreadScheduler();

    Schedulers.NewThreadHolder() {
    }
}
