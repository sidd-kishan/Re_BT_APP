/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzek
implements Executor {
    private final Handler zza;

    private zzek(Handler handler) {
        this.zza = handler;
    }

    static Executor zza(Handler handler) {
        return new zzek(handler);
    }

    @Override
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
