/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.NewThreadWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.NewThreadWorker;
import java.util.concurrent.ThreadFactory;

static final class IoScheduler.ThreadWorker
extends NewThreadWorker {
    private long expirationTime = 0L;

    IoScheduler.ThreadWorker(ThreadFactory threadFactory) {
        super(threadFactory);
    }

    public long getExpirationTime() {
        return this.expirationTime;
    }

    public void setExpirationTime(long l) {
        this.expirationTime = l;
    }
}
