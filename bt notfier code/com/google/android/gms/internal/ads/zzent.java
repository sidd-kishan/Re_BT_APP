/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zzg
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcyt
 *  com.google.android.gms.internal.ads.zzens
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfbr
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcyt;
import com.google.android.gms.internal.ads.zzens;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfbr;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;

public final class zzent
implements zzery {
    private static final Object zzf = new Object();
    private final String zza;
    private final String zzb;
    private final zzcyt zzc;
    private final zzfbr zzd;
    private final zzfar zze;
    private final zzg zzg;

    public zzent(String string, String string2, zzcyt zzcyt2, zzfbr zzfbr2, zzfar zzfar2) {
        this.zza = string;
        this.zzb = string2;
        this.zzc = zzcyt2;
        this.zzd = zzfbr2;
        this.zze = zzfar2;
        this.zzg = zzt.zzg().zzp();
    }

    public final zzfsm zza() {
        Bundle bundle = new Bundle();
        zzbjd zzbjd2 = zzbjl.zzdS;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return zzfsd.zza((Object)new zzens(this, bundle));
        this.zzc.zza(this.zze.zzd);
        bundle.putAll(this.zzd.zzc());
        return zzfsd.zza((Object)new zzens(this, bundle));
    }

    final /* synthetic */ void zzb(Bundle object, Bundle bundle) {
        zzbjd zzbjd2 = zzbjl.zzdS;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            bundle.putBundle("quality_signals", object);
        } else {
            object = zzbjl.zzdR;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
                object = zzf;
                synchronized (object) {
                    this.zzc.zza(this.zze.zzd);
                    bundle.putBundle("quality_signals", this.zzd.zzc());
                }
            } else {
                this.zzc.zza(this.zze.zzd);
                bundle.putBundle("quality_signals", this.zzd.zzc());
            }
        }
        bundle.putString("seq_num", this.zza);
        object = this.zzg.zzC() ? "" : this.zzb;
        bundle.putString("session_id", (String)object);
    }
}
