/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzfft
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzfft;
import java.util.List;
import java.util.concurrent.Executor;

public final class zzffu {
    private final Executor zza;
    private final zzcgy zzb;

    public zzffu(Executor executor, zzcgy zzcgy2) {
        this.zza = executor;
        this.zzb = zzcgy2;
    }

    public final void zza(List<String> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.zzb((String)object.next());
        }
    }

    public final void zzb(String string) {
        this.zza.execute((Runnable)new zzfft(this, string));
    }

    final /* synthetic */ void zzc(String string) {
        this.zzb.zza(string);
    }
}
