/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzeod
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzewv
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzeod;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzewv;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzeoe
implements zzery<zzerx<Bundle>> {
    private final zzewv zza;

    zzeoe(zzewv zzewv2) {
        this.zza = zzewv2;
    }

    public final zzfsm<zzerx<Bundle>> zza() {
        zzeod zzeod2;
        zzewv zzewv2 = this.zza;
        zzeod zzeod3 = zzeod2 = null;
        if (zzewv2 == null) return zzfsd.zza(zzeod3);
        zzeod3 = zzeod2;
        if (zzewv2.zza() == null) return zzfsd.zza(zzeod3);
        zzeod3 = zzeod2;
        if (this.zza.zza().isEmpty()) return zzfsd.zza(zzeod3);
        zzeod3 = new zzeod(this);
        return zzfsd.zza(zzeod3);
    }

    final /* synthetic */ void zzb(Bundle bundle) {
        bundle.putString("key_schema", this.zza.zza());
    }
}
