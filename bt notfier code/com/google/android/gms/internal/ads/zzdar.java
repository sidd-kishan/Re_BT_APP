/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzcyt
 *  com.google.android.gms.internal.ads.zzdao
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgli
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcyt;
import com.google.android.gms.internal.ads.zzdao;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgli;
import com.google.android.gms.internal.ads.zzgln;

public final class zzdar
implements zzgla<String> {
    private final zzdao zza;
    private final zzgln<zzcyt> zzb;

    public zzdar(zzdao zzdao2, zzgln<zzcyt> zzgln2) {
        this.zza = zzdao2;
        this.zzb = zzgln2;
    }

    public final String zza() {
        String string = ((zzcyt)this.zzb.zzb()).zzr();
        zzgli.zzb((Object)string);
        return string;
    }
}
