/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcei
 *  com.google.android.gms.internal.ads.zzcvo
 *  com.google.android.gms.internal.ads.zzdat
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbv
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcei;
import com.google.android.gms.internal.ads.zzcvo;
import com.google.android.gms.internal.ads.zzdat;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbv;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzcvz
implements zzgla<zzcei> {
    private final zzcvo zza;
    private final zzgln<Context> zzb;
    private final zzgln<zzfar> zzc;

    public zzcvz(zzcvo zzcvo2, zzgln<Context> zzgln2, zzgln<zzfar> zzgln3) {
        this.zza = zzcvo2;
        this.zzb = zzgln2;
        this.zzc = zzgln3;
    }

    public final zzcei zza() {
        return new zzcei(((zzfbv)this.zzb).zza(), ((zzdat)this.zzc).zza().zzf);
    }
}
