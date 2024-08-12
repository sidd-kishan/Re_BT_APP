/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.internal.ads.zzdai
 *  com.google.android.gms.internal.ads.zzdaj
 *  com.google.android.gms.internal.ads.zzecq
 *  com.google.android.gms.internal.ads.zzecr
 *  com.google.android.gms.internal.ads.zzecu
 *  com.google.android.gms.internal.ads.zzedb
 *  com.google.android.gms.internal.ads.zzfbu
 *  com.google.android.gms.internal.ads.zzfbv
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.internal.ads.zzdai;
import com.google.android.gms.internal.ads.zzdaj;
import com.google.android.gms.internal.ads.zzecq;
import com.google.android.gms.internal.ads.zzecr;
import com.google.android.gms.internal.ads.zzecu;
import com.google.android.gms.internal.ads.zzedb;
import com.google.android.gms.internal.ads.zzfbu;
import com.google.android.gms.internal.ads.zzfbv;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;

public final class zzedc
implements zzgla<zzedb> {
    private final zzgln<Context> zza;
    private final zzgln<zzdai> zzb;
    private final zzgln<zzecu> zzc;
    private final zzgln<zzecq> zzd;
    private final zzgln<zzg> zze;

    public zzedc(zzgln<Context> zzgln2, zzgln<zzdai> zzgln3, zzgln<zzecu> zzgln4, zzgln<zzecq> zzgln5, zzgln<zzg> zzgln6) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
    }

    public final zzedb zza() {
        return new zzedb(((zzfbv)this.zza).zza(), ((zzdaj)this.zzb).zza(), (zzecu)this.zzc.zzb(), ((zzecr)this.zzd).zza(), ((zzfbu)this.zze).zza());
    }
}
