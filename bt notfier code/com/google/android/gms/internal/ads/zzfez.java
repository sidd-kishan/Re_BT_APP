/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzfey
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzfey;
import java.util.concurrent.Executor;

public final class zzfez {
    private final Executor zza;
    private final zzcgy zzb;

    public zzfez(Executor executor, zzcgy zzcgy2) {
        this.zza = executor;
        this.zzb = zzcgy2;
    }

    public final void zza(String string) {
        this.zza.execute((Runnable)new zzfey(this, string));
    }

    final /* synthetic */ void zzb(String string) {
        this.zzb.zza(string);
    }
}
