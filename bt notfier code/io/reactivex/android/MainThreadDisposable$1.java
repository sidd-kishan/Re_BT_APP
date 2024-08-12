/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.reactivex.android.MainThreadDisposable
 */
package io.reactivex.android;

import io.reactivex.android.MainThreadDisposable;

class MainThreadDisposable.1
implements Runnable {
    final MainThreadDisposable this$0;

    MainThreadDisposable.1(MainThreadDisposable mainThreadDisposable) {
        this.this$0 = mainThreadDisposable;
    }

    @Override
    public void run() {
        this.this$0.onDispose();
    }
}
