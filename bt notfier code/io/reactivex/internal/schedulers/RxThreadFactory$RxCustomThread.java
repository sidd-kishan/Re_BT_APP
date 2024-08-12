/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.internal.schedulers.NonBlockingThread
 */
package io.reactivex.internal.schedulers;

import io.reactivex.internal.schedulers.NonBlockingThread;

static final class RxThreadFactory.RxCustomThread
extends Thread
implements NonBlockingThread {
    RxThreadFactory.RxCustomThread(Runnable runnable, String string) {
        super(runnable, string);
    }
}
