/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  com.google.android.gms.internal.ads.zzaku
 *  com.google.android.gms.internal.ads.zzalg
 *  com.google.android.gms.internal.ads.zzaml
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.ads.zzaku;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzaml;

public final class zzami
implements zzaku {
    protected zzami() {
    }

    public final zzalg zza(Looper looper, Handler.Callback callback) {
        return new zzaml(new Handler(looper, callback));
    }
}
