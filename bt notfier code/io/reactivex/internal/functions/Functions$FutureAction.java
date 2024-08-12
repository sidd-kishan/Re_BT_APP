/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Action
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Action;
import java.util.concurrent.Future;

static final class Functions.FutureAction
implements Action {
    final Future<?> future;

    Functions.FutureAction(Future<?> future) {
        this.future = future;
    }

    public void run() throws Exception {
        this.future.get();
    }
}
