/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzdrw
 *  com.google.android.gms.internal.ads.zzdsb
 *  com.google.android.gms.internal.ads.zzeef
 *  com.google.android.gms.internal.ads.zzeek
 *  com.google.android.gms.internal.ads.zzefy
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzfaw
 *  com.google.android.gms.internal.ads.zzfbi
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzdrw;
import com.google.android.gms.internal.ads.zzdsb;
import com.google.android.gms.internal.ads.zzeef;
import com.google.android.gms.internal.ads.zzeek;
import com.google.android.gms.internal.ads.zzefy;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzfaw;
import com.google.android.gms.internal.ads.zzfbi;
import java.util.concurrent.Executor;

public final class zzehx
implements zzeek<zzdrw, zzfbi, zzefy> {
    private final Context zza;
    private final Executor zzb;
    private final zzdsb zzc;

    public zzehx(Context context, Executor executor, zzdsb zzdsb2) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzdsb2;
    }

    public final void zza(zzfal object, zzezz zzezz2, zzeef<zzfbi, zzefy> zzeef2) throws zzfaw {
        try {
            object = ((zzfal)object).zza.zza;
            if (((zzfar)object).zzo.zza == 3) {
                ((zzfbi)zzeef2.zzb).zzx(this.zza, ((zzfar)object).zzd, zzezz2.zzv.toString(), (zzbvm)zzeef2.zzc);
                return;
            }
            ((zzfbi)zzeef2.zzb).zzv(this.zza, ((zzfar)object).zzd, zzezz2.zzv.toString(), (zzbvm)zzeef2.zzc);
            return;
        }
        catch (Exception exception) {
            object = String.valueOf(zzeef2.zza);
            object = ((String)object).length() != 0 ? "Fail to load ad from adapter ".concat((String)object) : new String("Fail to load ad from adapter ");
            zze.zzj((String)object, (Throwable)exception);
            return;
        }
    }
}
