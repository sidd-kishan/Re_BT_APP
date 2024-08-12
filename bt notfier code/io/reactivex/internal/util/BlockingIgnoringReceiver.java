/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.util;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import java.util.concurrent.CountDownLatch;

public final class BlockingIgnoringReceiver
extends CountDownLatch
implements Consumer<Throwable>,
Action {
    public Throwable error;

    public BlockingIgnoringReceiver() {
        super(1);
    }

    public void accept(Throwable throwable) {
        this.error = throwable;
        this.countDown();
    }

    public void run() {
        this.countDown();
    }
}
