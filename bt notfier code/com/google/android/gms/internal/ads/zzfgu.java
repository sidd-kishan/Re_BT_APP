/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.google.android.gms.internal.ads.zzfgi
 *  com.google.android.gms.internal.ads.zzfib
 */
package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.internal.ads.zzfgi;
import com.google.android.gms.internal.ads.zzfib;

public final class zzfgu {
    private final zzfib zza;
    private final String zzb;
    private final zzfgi zzc;
    private final String zzd;

    public zzfgu(View view, zzfgi zzfgi2, String string) {
        this.zza = new zzfib(view);
        this.zzb = view.getClass().getCanonicalName();
        this.zzc = zzfgi2;
        this.zzd = "Ad overlay";
    }

    public final zzfib zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final zzfgi zzc() {
        return this.zzc;
    }

    public final String zzd() {
        return this.zzd;
    }
}
