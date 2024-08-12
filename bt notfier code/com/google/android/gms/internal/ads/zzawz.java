/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.webkit.ValueCallback
 *  com.google.android.gms.internal.ads.zzaxa
 */
package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import com.google.android.gms.internal.ads.zzaxa;

final class zzawz
implements ValueCallback<String> {
    final zzaxa zza;

    zzawz(zzaxa zzaxa2) {
        this.zza = zzaxa2;
    }

    public final void zza(String string) {
        zzaxa zzaxa2 = this.zza;
        zzaxa2.zze.zzd(zzaxa2.zzb, zzaxa2.zzc, string, zzaxa2.zzd);
    }
}
