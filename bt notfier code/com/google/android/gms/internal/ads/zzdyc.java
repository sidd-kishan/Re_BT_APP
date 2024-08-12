/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbps
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzdxm
 *  com.google.android.gms.internal.ads.zzdxn
 *  com.google.android.gms.internal.ads.zzdxo
 *  com.google.android.gms.internal.ads.zzdxq
 *  com.google.android.gms.internal.ads.zzdxx
 *  com.google.android.gms.internal.ads.zzdxy
 *  com.google.android.gms.internal.ads.zzdyb
 *  com.google.android.gms.internal.ads.zzdyj
 *  com.google.android.gms.internal.ads.zzdyk
 *  com.google.android.gms.internal.ads.zzdyl
 *  com.google.android.gms.internal.ads.zzfbm
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbps;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzdxm;
import com.google.android.gms.internal.ads.zzdxn;
import com.google.android.gms.internal.ads.zzdxo;
import com.google.android.gms.internal.ads.zzdxq;
import com.google.android.gms.internal.ads.zzdxx;
import com.google.android.gms.internal.ads.zzdxy;
import com.google.android.gms.internal.ads.zzdyb;
import com.google.android.gms.internal.ads.zzdyj;
import com.google.android.gms.internal.ads.zzdyk;
import com.google.android.gms.internal.ads.zzdyl;
import com.google.android.gms.internal.ads.zzfbm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdyc
implements zzdyk,
zzdxn {
    private final zzdyj zza;
    private final zzdyl zzb;
    private final zzdxo zzc;
    private final zzdxx zzd;
    private final zzdxm zze;
    private final String zzf;
    private final Map<String, List<zzdxq>> zzg;
    private String zzh = "{}";
    private String zzi = "";
    private long zzj = Long.MAX_VALUE;
    private zzdxy zzk = zzdxy.zza;
    private boolean zzl;
    private int zzm;
    private boolean zzn;
    private zzdyb zzo = zzdyb.zza;

    zzdyc(zzdyj zzdyj2, zzdyl zzdyl2, zzdxo zzdxo2, Context context, zzcgz zzcgz2, zzdxx zzdxx2) {
        this.zza = zzdyj2;
        this.zzb = zzdyl2;
        this.zzc = zzdxo2;
        this.zzg = new HashMap<String, List<zzdxq>>();
        this.zze = new zzdxm(context);
        this.zzf = zzcgz2.zza;
        this.zzd = zzdxx2;
        zzt.zzm().zza(this);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    private final void zzo(boolean var1_1, boolean var2_2) {
        synchronized (this) {
            var3_3 = this.zzl;
            if (var3_3 == var1_1) {
            }
            ** GOTO lbl-1000
            return;
lbl-1000:
            // 1 sources

            {
                this.zzl = var1_1;
                if (!var1_1) ** GOTO lbl-1000
                var4_4 = zzbjl.zzgE;
                if (!((Boolean)zzbet.zzc().zzc(var4_4)).booleanValue() || !zzt.zzm().zzk()) {
                    this.zzs();
                } else if (!this.zzn()) {
                    this.zzt();
                }
                if (var2_2 == false) return;
                this.zzu();
                return;
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private final void zzp(zzdxy zzdxy2, boolean bl) {
        synchronized (this) {
            void var2_2;
            zzdxy zzdxy3 = this.zzk;
            if (zzdxy3 == zzdxy2) {
                return;
            }
            if (this.zzn()) {
                this.zzt();
            }
            this.zzk = zzdxy2;
            if (this.zzn()) {
                this.zzs();
            }
            if (var2_2 == false) return;
            this.zzu();
            return;
        }
    }

    private final JSONObject zzq() throws JSONException {
        synchronized (this) {
            try {
                JSONObject jSONObject = new JSONObject();
                Iterator<Map.Entry<String, List<zzdxq>>> iterator = this.zzg.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry<String, List<zzdxq>> entry = iterator.next();
                    JSONArray jSONArray = new JSONArray();
                    for (zzdxq zzdxq2 : entry.getValue()) {
                        if (!zzdxq2.zzc()) continue;
                        jSONArray.put((Object)zzdxq2.zzd());
                    }
                    if (jSONArray.length() <= 0) continue;
                    jSONObject.put(entry.getKey(), (Object)jSONArray);
                }
                return jSONObject;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private final void zzr() {
        this.zzn = true;
        this.zzd.zza();
        this.zza.zzg(this);
        this.zzb.zza((zzdyk)this);
        this.zzc.zza((zzdxn)this);
        this.zzv(zzt.zzg().zzp().zzG());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzs() {
        synchronized (this) {
            zzdxy zzdxy2 = zzdxy.zza;
            int n = this.zzk.ordinal();
            if (n == 1) {
                this.zzb.zzb();
                return;
            }
            if (n != 2) {
                return;
            }
            this.zzc.zzb();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzt() {
        synchronized (this) {
            zzdxy zzdxy2 = zzdxy.zza;
            int n = this.zzk.ordinal();
            if (n == 1) {
                this.zzb.zzc();
                return;
            }
            if (n != 2) {
                return;
            }
            this.zzc.zzc();
            return;
        }
    }

    private final void zzu() {
        zzt.zzg().zzp().zzH(this.zzh());
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private final void zzv(String string) {
        synchronized (this) {
            boolean bl = TextUtils.isEmpty((CharSequence)string);
            if (bl) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.zzo(jSONObject.optBoolean("isTestMode", false), false);
                this.zzp(zzdxy.zza((String)jSONObject.optString("gesture", "NONE")), false);
                this.zzh = jSONObject.optString("networkExtras", "{}");
                this.zzj = jSONObject.optLong("networkExtrasExpirationSecs", Long.MAX_VALUE);
                return;
            }
            catch (JSONException jSONException) {
                return;
            }
        }
    }

    /*
     * Enabled force condition propagation
     */
    public final void zza() {
        zzbjd zzbjd2 = zzbjl.zzgp;
        if (!((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return;
        }
        zzbjd2 = zzbjl.zzgE;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && zzt.zzg().zzp().zzI()) {
            this.zzr();
            return;
        }
        String string = zzt.zzg().zzp().zzG();
        if (TextUtils.isEmpty((CharSequence)string)) {
            return;
        }
        try {
            zzbjd2 = new JSONObject(string);
            if (!zzbjd2.optBoolean("isTestMode", false)) return;
            this.zzr();
            return;
        }
        catch (JSONException jSONException) {
            return;
        }
    }

    public final void zzb(boolean bl) {
        block5: {
            block6: {
                block4: {
                    if (this.zzn) break block4;
                    if (!bl) break block5;
                    this.zzr();
                    break block6;
                }
                if (!bl) break block5;
            }
            if (!this.zzl) {
                this.zzs();
                return;
            }
        }
        if (this.zzn()) return;
        this.zzt();
    }

    public final void zzc(boolean bl) {
        if (!this.zzn && bl) {
            this.zzr();
        }
        this.zzo(bl, true);
    }

    public final boolean zzd() {
        synchronized (this) {
            boolean bl = this.zzl;
            return bl;
        }
    }

    public final void zze(zzdxy zzdxy2) {
        this.zzp(zzdxy2, true);
    }

    public final zzdxy zzf() {
        return this.zzk;
    }

    public final String zzg() {
        synchronized (this) {
            Object object = zzbjl.zzgp;
            if ((Boolean)zzbet.zzc().zzc(object) == false) return "";
            if (!this.zzn()) {
                return "";
            }
            if (this.zzj < zzt.zzj().currentTimeMillis() / 1000L) {
                this.zzh = "{}";
                this.zzj = Long.MAX_VALUE;
                return "";
            }
            if (this.zzh.equals("{}")) {
                return "";
            }
            object = this.zzh;
            return object;
        }
    }

    public final String zzh() {
        synchronized (this) {
            Object object = new JSONObject();
            try {
                object.put("isTestMode", this.zzl);
                object.put("gesture", (Object)this.zzk);
                if (this.zzj > zzt.zzj().currentTimeMillis() / 1000L) {
                    object.put("networkExtras", (Object)this.zzh);
                    object.put("networkExtrasExpirationSecs", this.zzj);
                }
            }
            catch (JSONException jSONException) {}
            object = object.toString();
            return object;
        }
    }

    public final void zzi(String string, long l) {
        synchronized (this) {
            this.zzh = string;
            this.zzj = l;
            this.zzu();
            return;
        }
    }

    public final void zzj(String string, zzdxq zzdxq2) {
        synchronized (this) {
            Object object = zzbjl.zzgp;
            if ((Boolean)zzbet.zzc().zzc(object) == false) return;
            if (!this.zzn()) {
                return;
            }
            int n = this.zzm;
            object = zzbjl.zzgr;
            if (n >= (Integer)zzbet.zzc().zzc(object)) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Maximum number of ad requests stored reached. Dropping the current request.");
                return;
            }
            if (!this.zzg.containsKey(string)) {
                Map<String, List<zzdxq>> map = this.zzg;
                object = new ArrayList();
                map.put(string, (List<zzdxq>)object);
            }
            ++this.zzm;
            this.zzg.get(string).add(zzdxq2);
            return;
        }
    }

    public final void zzk(zzbgq zzbgq2, zzdyb zzdyb2) {
        synchronized (this) {
            boolean bl = this.zzn();
            if (!bl) {
                try {
                    zzbgq2.zze(zzfbm.zzd((int)18, null, null));
                    return;
                }
                catch (RemoteException remoteException) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"Ad inspector cannot be opened because the device is not in test mode. See https://developers.google.com/admob/android/test-ads#enable_test_devices for more information.");
                    return;
                }
            }
            zzbjd zzbjd2 = zzbjl.zzgp;
            bl = (Boolean)zzbet.zzc().zzc(zzbjd2);
            if (bl) {
                this.zzo = zzdyb2;
                zzbjd2 = this.zza;
                zzdyb2 = new zzbps(this);
                zzbjd2.zzh(zzbgq2, (zzbps)zzdyb2);
                return;
            }
            try {
                zzbgq2.zze(zzfbm.zzd((int)1, null, null));
                return;
            }
            catch (RemoteException remoteException) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Ad inspector had an internal error.");
                return;
            }
        }
    }

    public final void zzl(String string) {
        synchronized (this) {
            this.zzi = string;
            return;
        }
    }

    public final JSONObject zzm() {
        synchronized (this) {
            JSONObject jSONObject = new JSONObject();
            try {
                Object object;
                jSONObject.put("platform", (Object)"ANDROID");
                jSONObject.put("internalSdkVersion", (Object)this.zzf);
                jSONObject.put("adapters", (Object)this.zzd.zzb());
                if (this.zzj < zzt.zzj().currentTimeMillis() / 1000L) {
                    this.zzh = "{}";
                }
                jSONObject.put("networkExtras", (Object)this.zzh);
                jSONObject.put("adSlots", (Object)this.zzq());
                jSONObject.put("appInfo", (Object)this.zze.zza());
                String string = zzt.zzg().zzp().zzn().zzd();
                if (!TextUtils.isEmpty((CharSequence)string)) {
                    object = new JSONObject(string);
                    jSONObject.put("cld", object);
                }
                object = zzbjl.zzgF;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue() && !TextUtils.isEmpty((CharSequence)this.zzi)) {
                    object = String.valueOf(this.zzi);
                    object = ((String)object).length() != 0 ? "Policy violation data: ".concat((String)object) : new String("Policy violation data: ");
                    com.google.android.gms.ads.internal.util.zze.zzd((String)object);
                    object = new JSONObject(this.zzi);
                    jSONObject.put("policyViolations", object);
                }
                object = zzbjl.zzgE;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return jSONObject;
                jSONObject.put("openAction", (Object)this.zzo);
                jSONObject.put("gesture", (Object)this.zzk);
            }
            catch (JSONException jSONException) {
                zzt.zzg().zzl((Throwable)jSONException, "Inspector.toJson");
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Ad inspector encountered an error", (Throwable)jSONException);
            }
            return jSONObject;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final boolean zzn() {
        synchronized (this) {
            zzbjd zzbjd2 = zzbjl.zzgE;
            if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return this.zzl;
            if (this.zzl) return true;
            boolean bl = zzt.zzm().zzk();
            if (!bl) return false;
            return true;
        }
    }
}
