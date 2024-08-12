/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.disposables.Disposable
 *  io.reactivex.functions.Consumer
 */
package io.reactivex.internal.util;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public final class ConnectConsumer
implements Consumer<Disposable> {
    public Disposable disposable;

    public void accept(Disposable disposable) throws Exception {
        this.disposable = disposable;
    }
}
