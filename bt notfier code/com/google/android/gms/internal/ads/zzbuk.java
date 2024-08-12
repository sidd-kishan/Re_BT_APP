/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbqe
 *  com.google.android.gms.internal.ads.zzbqf
 *  com.google.android.gms.internal.ads.zzbtm
 *  com.google.android.gms.internal.ads.zzbts
 *  com.google.android.gms.internal.ads.zzbtt
 *  com.google.android.gms.internal.ads.zzbtw
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbtz
 *  com.google.android.gms.internal.ads.zzbuh
 *  com.google.android.gms.internal.ads.zzbui
 *  com.google.android.gms.internal.ads.zzbuj
 *  com.google.android.gms.internal.ads.zzchl
 *  com.google.android.gms.internal.ads.zzchn
 *  com.google.android.gms.internal.ads.zzchp
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbqe;
import com.google.android.gms.internal.ads.zzbqf;
import com.google.android.gms.internal.ads.zzbtm;
import com.google.android.gms.internal.ads.zzbts;
import com.google.android.gms.internal.ads.zzbtt;
import com.google.android.gms.internal.ads.zzbtw;
import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbtz;
import com.google.android.gms.internal.ads.zzbuh;
import com.google.android.gms.internal.ads.zzbui;
import com.google.android.gms.internal.ads.zzbuj;
import com.google.android.gms.internal.ads.zzchl;
import com.google.android.gms.internal.ads.zzchn;
import com.google.android.gms.internal.ads.zzchp;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbuk<I, O>
implements zzbtw<I, O> {
    private final zzbty<O> zza;
    private final zzbtz<I> zzb;
    private final zzbts zzc;
    private final String zzd;

    zzbuk(zzbts zzbts2, String string, zzbtz<I> zzbtz2, zzbty<O> zzbty2) {
        this.zzc = zzbts2;
        this.zzd = string;
        this.zzb = zzbtz2;
        this.zza = zzbty2;
    }

    static /* synthetic */ zzbty zzc(zzbuk zzbuk2) {
        return zzbuk2.zza;
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzd(zzbuk zzbuk2, zzbtm zzbtm2, zzbtt zzbtt2, Object object, zzchl zzchl2) {
        try {
            zzt.zzc();
            String string = UUID.randomUUID().toString();
            zzbqf zzbqf2 = zzbpq.zzo;
            zzbuj zzbuj2 = new zzbuj(zzbuk2, zzbtm2, zzchl2);
            zzbqf2.zzb(string, (zzbqe)zzbuj2);
            zzbqf2 = new JSONObject();
            zzbqf2.put("id", (Object)string);
            zzbqf2.put("args", (Object)zzbuk2.zzb.zzb(object));
            zzbtt2.zzr(zzbuk2.zzd, (JSONObject)zzbqf2);
            return;
        }
        catch (Exception exception) {
            try {
                zzchl2.zzd((Throwable)exception);
                zze.zzg((String)"Unable to invokeJavascript", (Throwable)exception);
                return;
            }
            finally {
                zzbtm2.zzb();
            }
        }
    }

    public final zzfsm<O> zza(I i) throws Exception {
        return this.zzb(i);
    }

    public final zzfsm<O> zzb(I i) {
        zzchl zzchl2 = new zzchl();
        zzbtm zzbtm2 = this.zzc.zzg(null);
        zzbtm2.zzf((zzchp)new zzbuh(this, zzbtm2, i, zzchl2), (zzchn)new zzbui(this, zzchl2, zzbtm2));
        return zzchl2;
    }
}
