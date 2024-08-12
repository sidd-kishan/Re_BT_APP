/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnx
 */
package com.google.android.gms.ads.internal.overlay;

import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnx;

final class zzd
implements zzcnx {
    private final zzl zza;

    zzd(zzl zzl2) {
        this.zza = zzl2;
    }

    public final void zza(boolean bl) {
        zzcml zzcml2 = this.zza.zzd;
        if (zzcml2 == null) return;
        zzcml2.zzK();
    }
}
