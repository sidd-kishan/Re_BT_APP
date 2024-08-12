/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;
import java.util.concurrent.Executor;

final class zzbm
implements Executor {
    private final Handler zza;

    private zzbm(Handler handler) {
        this.zza = handler;
    }

    static Executor zza(Handler handler) {
        return new zzbm(handler);
    }

    @Override
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
