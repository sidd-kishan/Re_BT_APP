/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdht
 *  com.google.android.gms.internal.ads.zzdtf
 *  com.google.android.gms.internal.ads.zzdvr
 *  com.google.android.gms.internal.ads.zzdxk
 *  com.google.android.gms.internal.ads.zzgla
 *  com.google.android.gms.internal.ads.zzgln
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdht;
import com.google.android.gms.internal.ads.zzdtf;
import com.google.android.gms.internal.ads.zzdvr;
import com.google.android.gms.internal.ads.zzdxk;
import com.google.android.gms.internal.ads.zzgla;
import com.google.android.gms.internal.ads.zzgln;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class zzdxl
implements zzgla<zzdxk> {
    private final zzgln<Executor> zza;
    private final zzgln<Context> zzb;
    private final zzgln<WeakReference<Context>> zzc;
    private final zzgln<Executor> zzd;
    private final zzgln<zzdtf> zze;
    private final zzgln<ScheduledExecutorService> zzf;
    private final zzgln<zzdvr> zzg;
    private final zzgln<zzcgz> zzh;
    private final zzgln<zzdht> zzi;

    public zzdxl(zzgln<Executor> zzgln2, zzgln<Context> zzgln3, zzgln<WeakReference<Context>> zzgln4, zzgln<Executor> zzgln5, zzgln<zzdtf> zzgln6, zzgln<ScheduledExecutorService> zzgln7, zzgln<zzdvr> zzgln8, zzgln<zzcgz> zzgln9, zzgln<zzdht> zzgln10) {
        this.zza = zzgln2;
        this.zzb = zzgln3;
        this.zzc = zzgln4;
        this.zzd = zzgln5;
        this.zze = zzgln6;
        this.zzf = zzgln7;
        this.zzg = zzgln8;
        this.zzh = zzgln9;
        this.zzi = zzgln10;
    }
}
