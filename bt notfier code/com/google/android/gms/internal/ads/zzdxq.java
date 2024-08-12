/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbdp
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcbj
 *  com.google.android.gms.internal.ads.zzcxg
 *  com.google.android.gms.internal.ads.zzdav
 *  com.google.android.gms.internal.ads.zzdbf
 *  com.google.android.gms.internal.ads.zzdcu
 *  com.google.android.gms.internal.ads.zzddx
 *  com.google.android.gms.internal.ads.zzdxp
 *  com.google.android.gms.internal.ads.zzdyc
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfal
 *  com.google.android.gms.internal.ads.zzfar
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcbj;
import com.google.android.gms.internal.ads.zzcxg;
import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzdbf;
import com.google.android.gms.internal.ads.zzdcu;
import com.google.android.gms.internal.ads.zzddx;
import com.google.android.gms.internal.ads.zzdxp;
import com.google.android.gms.internal.ads.zzdyc;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfal;
import com.google.android.gms.internal.ads.zzfar;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdxq
implements zzdbf,
zzddx,
zzdcu {
    private final zzdyc zza;
    private final String zzb;
    private int zzc;
    private zzdxp zzd;
    private zzdav zze;
    private zzbcz zzf;

    zzdxq(zzdyc zzdyc2, zzfar zzfar2) {
        this.zza = zzdyc2;
        this.zzb = zzfar2.zzf;
        this.zzc = 0;
        this.zzd = zzdxp.zza;
    }

    private static JSONObject zze(zzdav object) throws JSONException {
        String string;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("winningAdapterClassName", (Object)object.zze());
        jSONObject.put("responseSecsSinceEpoch", object.zzc());
        jSONObject.put("responseId", (Object)object.zzf());
        Object object2 = zzbjl.zzgG;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object2)).booleanValue() && !TextUtils.isEmpty((CharSequence)(string = object.zzd()))) {
            object2 = String.valueOf(string);
            object2 = ((String)object2).length() != 0 ? "Bidding data: ".concat((String)object2) : new String("Bidding data: ");
            com.google.android.gms.ads.internal.util.zze.zzd((String)object2);
            jSONObject.put("biddingData", (Object)new JSONObject(string));
        }
        object2 = new JSONArray();
        if ((object = object.zzg()) != null) {
            Iterator iterator = object.iterator();
            while (iterator.hasNext()) {
                object = (zzbdp)iterator.next();
                string = new JSONObject();
                string.put("adapterClassName", (Object)((zzbdp)object).zza);
                string.put("latencyMillis", ((zzbdp)object).zzb);
                object = ((zzbdp)object).zzc;
                object = object == null ? null : zzdxq.zzf((zzbcz)object);
                string.put("error", object);
                object2.put((Object)string);
            }
        }
        jSONObject.put("adNetworks", object2);
        return jSONObject;
    }

    private static JSONObject zzf(zzbcz object) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", (Object)object.zzc);
        jSONObject.put("errorCode", object.zza);
        jSONObject.put("errorDescription", (Object)object.zzb);
        object = object.zzd;
        object = object == null ? null : zzdxq.zzf(object);
        jSONObject.put("underlyingError", object);
        return jSONObject;
    }

    public final void zza(zzcxg zzcxg2) {
        this.zze = zzcxg2.zzm();
        this.zzd = zzdxp.zzb;
    }

    public final void zzbD(zzbcz zzbcz2) {
        this.zzd = zzdxp.zzc;
        this.zzf = zzbcz2;
    }

    public final void zzbG(zzcbj zzcbj2) {
        this.zza.zzj(this.zzb, this);
    }

    public final boolean zzc() {
        if (this.zzd == zzdxp.zza) return false;
        return true;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("state", (Object)this.zzd);
        jSONObject.put("format", (Object)zzezz.zza((int)this.zzc));
        zzdav zzdav2 = this.zze;
        JSONObject jSONObject2 = null;
        if (zzdav2 != null) {
            zzdav2 = zzdxq.zze(zzdav2);
        } else {
            Object object = this.zzf;
            zzdav2 = jSONObject2;
            if (object != null) {
                object = ((zzbcz)object).zze;
                zzdav2 = jSONObject2;
                if (object != null) {
                    zzdav2 = (zzdav)object;
                    jSONObject2 = zzdxq.zze(zzdav2);
                    object = zzdav2.zzg();
                    zzdav2 = jSONObject2;
                    if (object != null) {
                        zzdav2 = jSONObject2;
                        if (object.isEmpty()) {
                            zzdav2 = new JSONArray();
                            zzdav2.put((Object)zzdxq.zzf(this.zzf));
                            jSONObject2.put("errors", (Object)zzdav2);
                            zzdav2 = jSONObject2;
                        }
                    }
                }
            }
        }
        jSONObject.put("responseInfo", (Object)zzdav2);
        return jSONObject;
    }

    public final void zzq(zzfal zzfal2) {
        if (zzfal2.zzb.zza.isEmpty()) return;
        this.zzc = ((zzezz)zzfal2.zzb.zza.get((int)0)).zzb;
    }
}
