/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.AbstractDirectTask
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.AbstractDirectTask;
import io.reactivex.plugins.RxJavaPlugins;

public final class ScheduledDirectPeriodicTask
extends AbstractDirectTask
implements Runnable {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectPeriodicTask(Runnable runnable) {
        super(runnable);
    }

    @Override
    public void run() {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            this.runner = null;
        }
        catch (Throwable throwable) {
            this.runner = null;
            this.lazySet(FINISHED);
            RxJavaPlugins.onError((Throwable)throwable);
        }
    }
}
