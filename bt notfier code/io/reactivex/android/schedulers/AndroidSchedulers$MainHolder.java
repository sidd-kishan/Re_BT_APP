/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  io.reactivex.Scheduler
 *  io.reactivex.android.schedulers.HandlerScheduler
 */
package io.reactivex.android.schedulers;

import android.os.Handler;
import android.os.Looper;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.HandlerScheduler;

private static final class AndroidSchedulers.MainHolder {
    static final Scheduler DEFAULT = new HandlerScheduler(new Handler(Looper.getMainLooper()), false);

    private AndroidSchedulers.MainHolder() {
    }
}
