/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzvt
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzvt;
import java.util.concurrent.Executor;

final class zzvr
implements Executor {
    final Handler zza;

    zzvr(zzvt zzvt2, Handler handler) {
        this.zza = handler;
    }

    @Override
    public final void execute(Runnable runnable) {
        this.zza.post(runnable);
    }
}
