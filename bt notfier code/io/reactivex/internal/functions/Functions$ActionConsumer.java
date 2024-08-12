/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Action
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

static final class Functions.ActionConsumer<T>
implements Consumer<T> {
    final Action action;

    Functions.ActionConsumer(Action action) {
        this.action = action;
    }

    public void accept(T t) throws Exception {
        this.action.run();
    }
}
