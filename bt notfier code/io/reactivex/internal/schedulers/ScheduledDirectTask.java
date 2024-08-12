/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.AbstractDirectTask
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.AbstractDirectTask;
import java.util.concurrent.Callable;

public final class ScheduledDirectTask
extends AbstractDirectTask
implements Callable<Void> {
    private static final long serialVersionUID = 1811839108042568751L;

    public ScheduledDirectTask(Runnable runnable) {
        super(runnable);
    }

    @Override
    public Void call() throws Exception {
        this.runner = Thread.currentThread();
        try {
            this.runnable.run();
            return null;
        }
        finally {
            this.lazySet(FINISHED);
            this.runner = null;
        }
    }
}
