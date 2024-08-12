/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzvr
 *  com.google.android.gms.internal.ads.zzvs
 *  com.google.android.gms.internal.ads.zzwc
 *  com.google.android.gms.internal.ads.zzwi
 *  com.google.android.gms.internal.ads.zzwl
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzvr;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzwc;
import com.google.android.gms.internal.ads.zzwi;
import com.google.android.gms.internal.ads.zzwl;
import java.util.concurrent.Executor;

public final class zzvt {
    private final Executor zza;

    public zzvt(Handler handler) {
        this.zza = new zzvr(this, handler);
    }

    public final void zza(zzwc<?> zzvs2, zzwi<?> zzwi2, Runnable runnable) {
        zzvs2.zzq();
        zzvs2.zzd("post-response");
        Executor executor = this.zza;
        zzvs2 = new zzvs(zzvs2, zzwi2, runnable);
        ((zzvr)executor).zza.post((Runnable)zzvs2);
    }

    public final void zzb(zzwc<?> zzvs2, zzwl object) {
        zzvs2.zzd("post-error");
        zzwi zzwi2 = zzwi.zzb((zzwl)object);
        object = this.zza;
        zzvs2 = new zzvs(zzvs2, zzwi2, null);
        ((zzvr)object).zza.post((Runnable)zzvs2);
    }
}
