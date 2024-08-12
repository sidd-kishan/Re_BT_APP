/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.functions.Consumer
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.functions;

import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

static final class Functions.ErrorConsumer
implements Consumer<Throwable> {
    Functions.ErrorConsumer() {
    }

    public void accept(Throwable throwable) {
        RxJavaPlugins.onError((Throwable)throwable);
    }
}
