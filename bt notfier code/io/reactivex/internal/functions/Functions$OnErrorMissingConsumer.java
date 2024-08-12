/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.exceptions.OnErrorNotImplementedException
 *  io.reactivex.functions.Consumer
 *  io.reactivex.plugins.RxJavaPlugins
 */
package io.reactivex.internal.functions;

import io.reactivex.exceptions.OnErrorNotImplementedException;
import io.reactivex.functions.Consumer;
import io.reactivex.plugins.RxJavaPlugins;

static final class Functions.OnErrorMissingConsumer
implements Consumer<Throwable> {
    Functions.OnErrorMissingConsumer() {
    }

    public void accept(Throwable throwable) {
        RxJavaPlugins.onError((Throwable)new OnErrorNotImplementedException(throwable));
    }
}
