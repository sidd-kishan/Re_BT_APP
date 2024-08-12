/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzdiz
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzdsb
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefz
 *  com.google.android.gms.internal.ads.zzeir
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzdiz;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzdsb;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefz;
import com.google.android.gms.internal.ads.zzeir;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.concurrent.Executor;

public final class zzeit
implements zzeek<zzdrw, zzfbi, zzefz> {
    private final Context zza;
    private final Executor zzb;
    private final zzdsb zzc;

    public zzeit(Context context, Executor executor, zzdsb zzdsb2) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdsb2;
    }

    static /* synthetic */ Executor zzc(zzeit zzeit2) {
        return zzeit2.zzb;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzd(zzeit zzeit2, zzfal zzfal2, zzezz zzezz2, zzeef zzeef2) {
        zzeit.zze(zzfal2, zzezz2, (zzeef<zzfbi, zzefz>)zzeef2);
    }

    private static final void zze(zzfal object, zzezz zzezz2, zzeef<zzfbi, zzefz> zzeef2) {
        try {
            ((zzfbi)zzeef2.zzb).zzl(((zzfal)object).zza.zza.zzd, zzezz2.zzv.toString());
            return;
        }
        catch (Exception exception) {
            object = String.valueOf(zzeef2.zza);
            object = ((String)object).length() != 0 ? "Fail to load ad from adapter ".concat((String)object) : new String("Fail to load ad from adapter ");
            zze.zzj((String)object, (Throwable)exception);
            return;
        }
    }

    public final void zza(zzfal zzfal2, zzezz zzezz2, zzeef<zzfbi, zzefz> zzeef2) throws zzfaw {
        if (!((zzfbi)zzeef2.zzb).zzn()) {
            zzeir zzeir2 = new zzeir(this, zzfal2, zzezz2, zzeef2);
            ((zzefz)zzeef2.zzc).zzd((zzdiz)zzeir2);
            ((zzfbi)zzeef2.zzb).zzk(this.zza, zzfal2.zza.zza.zzd, null, (zzcck)zzeef2.zzc, zzezz2.zzv.toString());
            return;
        }
        zzeit.zze(zzfal2, zzezz2, zzeef2);
    }
}
