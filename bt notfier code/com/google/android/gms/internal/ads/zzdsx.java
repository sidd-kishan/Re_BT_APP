/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzdbx
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzdbx;

public final class zzdsx
implements zzdbx {
    private final zzcml zza;

    zzdsx(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    public final void zza(Context context) {
        context = this.zza;
        if (context == null) return;
        context.onPause();
    }

    public final void zzb(Context context) {
        context = this.zza;
        if (context == null) return;
        context.onResume();
    }

    public final void zzbo(Context context) {
        context = this.zza;
        if (context == null) return;
        context.destroy();
    }
}
