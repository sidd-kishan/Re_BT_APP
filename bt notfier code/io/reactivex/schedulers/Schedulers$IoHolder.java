/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.Scheduler
 *  io.reactivex.internal.schedulers.IoScheduler
 */
package io.reactivex.schedulers;

import io.reactivex.Scheduler;
import io.reactivex.internal.schedulers.IoScheduler;

static final class Schedulers.IoHolder {
    static final Scheduler DEFAULT = new IoScheduler();

    Schedulers.IoHolder() {
    }
}
