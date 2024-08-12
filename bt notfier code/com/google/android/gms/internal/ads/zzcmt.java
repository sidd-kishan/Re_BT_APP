/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchk
 *  com.google.android.gms.internal.ads.zzcmv
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzfrj
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzcmv;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzfrj;
import com.google.android.gms.internal.ads.zzfsm;

final class zzcmt
implements zzfrj {
    private final Context zza;
    private final zzaas zzb;
    private final zzcgz zzc;
    private final zza zzd;
    private final String zze;

    zzcmt(Context context, zzaas zzaas2, zzcgz zzcgz2, zza zza2, String string) {
        this.zza = context;
        this.zzb = zzaas2;
        this.zzc = zzcgz2;
        this.zzd = zza2;
        this.zze = string;
    }

    public final zzfsm zza() {
        Context context = this.zza;
        zzaas zzaas2 = this.zzb;
        zzcgz zzcgz2 = this.zzc;
        zza zza2 = this.zzd;
        String string = this.zze;
        zzt.zzd();
        zzaas2 = zzcmx.zza((Context)context, (zzcob)zzcob.zzb(), (String)"", (boolean)false, (boolean)false, (zzaas)zzaas2, null, (zzcgz)zzcgz2, null, null, (zza)zza2, (zzazb)zzazb.zza(), null, null);
        context = zzchk.zza((Object)zzaas2);
        zzaas2.zzR().zzy((zzcnx)new zzcmv((zzchk)context));
        zzaas2.loadUrl(string);
        return context;
    }
}
