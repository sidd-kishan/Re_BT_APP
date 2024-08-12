/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.gms.common.api.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zabf
implements Executor {
    private final Handler zaa;

    private zabf(Handler handler) {
        this.zaa = handler;
    }

    static Executor zaa(Handler handler) {
        return new zabf(handler);
    }

    @Override
    public final void execute(Runnable runnable) {
        this.zaa.post(runnable);
    }
}
