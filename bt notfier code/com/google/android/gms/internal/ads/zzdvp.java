/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkt
 *  com.google.android.gms.internal.ads.zzcgy
 *  com.google.android.gms.internal.ads.zzdvo
 *  com.google.android.gms.internal.ads.zzffm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkt;
import com.google.android.gms.internal.ads.zzcgy;
import com.google.android.gms.internal.ads.zzdvo;
import com.google.android.gms.internal.ads.zzffm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

public class zzdvp {
    protected final String zza = (String)zzbkt.zzb.zze();
    protected final Map<String, String> zzb = new HashMap<String, String>();
    protected final Executor zzc;
    protected final zzcgy zzd;
    protected final boolean zze;
    private final zzffm zzf;

    protected zzdvp(Executor executor, zzcgy zzcgy2, zzffm zzffm2) {
        this.zzc = executor;
        this.zzd = zzcgy2;
        executor = zzbjl.zzbl;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)executor)).booleanValue()) {
            executor = zzbjl.zzbp;
            this.zze = (Boolean)zzbet.zzc().zzc((zzbjd)executor);
        } else {
            boolean bl = (double)zzber.zze().nextFloat() <= (Double)zzbkt.zza.zze();
            this.zze = bl;
        }
        this.zzf = zzffm2;
    }

    public final void zzb(Map<String, String> object) {
        object = this.zzf.zza(object);
        if (this.zze) {
            this.zzc.execute((Runnable)new zzdvo(this, (String)object));
        }
        com.google.android.gms.ads.internal.util.zze.zza((String)object);
    }

    protected final String zzc(Map<String, String> map) {
        return this.zzf.zza(map);
    }
}
