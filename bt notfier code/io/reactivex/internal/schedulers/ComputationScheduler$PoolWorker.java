/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.NewThreadWorker
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.NewThreadWorker;
import java.util.concurrent.ThreadFactory;

static final class ComputationScheduler.PoolWorker
extends NewThreadWorker {
    ComputationScheduler.PoolWorker(ThreadFactory threadFactory) {
        super(threadFactory);
    }
}
