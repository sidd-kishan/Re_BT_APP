/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.net.Uri
 *  android.text.TextUtils
 *  android.util.Base64
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbhu
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzblo
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzchk
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdou
 *  com.google.android.gms.internal.ads.zzdpa
 *  com.google.android.gms.internal.ads.zzdpb
 *  com.google.android.gms.internal.ads.zzdpc
 *  com.google.android.gms.internal.ads.zzdpd
 *  com.google.android.gms.internal.ads.zzdpe
 *  com.google.android.gms.internal.ads.zzdpf
 *  com.google.android.gms.internal.ads.zzdph
 *  com.google.android.gms.internal.ads.zzdpi
 *  com.google.android.gms.internal.ads.zzdpj
 *  com.google.android.gms.internal.ads.zzdpk
 *  com.google.android.gms.internal.ads.zzdqd
 *  com.google.android.gms.internal.ads.zzdrn
 *  com.google.android.gms.internal.ads.zzdss
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfar
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfoj
 *  com.google.android.gms.internal.ads.zzfrk
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbhu;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzblo;
import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzchk;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdou;
import com.google.android.gms.internal.ads.zzdpa;
import com.google.android.gms.internal.ads.zzdpb;
import com.google.android.gms.internal.ads.zzdpc;
import com.google.android.gms.internal.ads.zzdpd;
import com.google.android.gms.internal.ads.zzdpe;
import com.google.android.gms.internal.ads.zzdpf;
import com.google.android.gms.internal.ads.zzdph;
import com.google.android.gms.internal.ads.zzdpi;
import com.google.android.gms.internal.ads.zzdpj;
import com.google.android.gms.internal.ads.zzdpk;
import com.google.android.gms.internal.ads.zzdqd;
import com.google.android.gms.internal.ads.zzdrn;
import com.google.android.gms.internal.ads.zzdss;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfar;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfoj;
import com.google.android.gms.internal.ads.zzfrk;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdpl {
    private final Context zza;
    private final zzdou zzb;
    private final zzaas zzc;
    private final zzcgz zzd;
    private final zza zze;
    private final zzazb zzf;
    private final Executor zzg;
    private final zzblv zzh;
    private final zzdqd zzi;
    private final zzdss zzj;
    private final ScheduledExecutorService zzk;
    private final zzdrn zzl;
    private final zzdvi zzm;
    private final zzffc zzn;
    private final zzffu zzo;
    private final zzedq zzp;

    public zzdpl(Context context, zzdou zzdou2, zzaas zzaas2, zzcgz zzcgz2, zza zza2, zzazb zzazb2, Executor executor, zzfar zzfar2, zzdqd zzdqd2, zzdss zzdss2, ScheduledExecutorService scheduledExecutorService, zzdvi zzdvi2, zzffc zzffc2, zzffu zzffu2, zzedq zzedq2, zzdrn zzdrn2) {
        this.zza = context;
        this.zzb = zzdou2;
        this.zzc = zzaas2;
        this.zzd = zzcgz2;
        this.zze = zza2;
        this.zzf = zzazb2;
        this.zzg = executor;
        this.zzh = zzfar2.zzi;
        this.zzi = zzdqd2;
        this.zzj = zzdss2;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdvi2;
        this.zzn = zzffc2;
        this.zzo = zzffu2;
        this.zzp = zzedq2;
        this.zzl = zzdrn2;
    }

    public static final zzbhu zzi(JSONObject jSONObject) {
        if ((jSONObject = jSONObject.optJSONObject("mute")) == null) {
            return null;
        }
        if ((jSONObject = jSONObject.optJSONObject("default_reason")) != null) return zzdpl.zzr(jSONObject);
        return null;
    }

    public static final List<zzbhu> zzj(JSONObject object) {
        if ((object = object.optJSONObject("mute")) == null) {
            return zzfoj.zzi();
        }
        JSONArray jSONArray = object.optJSONArray("reasons");
        if (jSONArray == null) return zzfoj.zzi();
        if (jSONArray.length() <= 0) {
            return zzfoj.zzi();
        }
        object = new ArrayList();
        int n = 0;
        while (n < jSONArray.length()) {
            zzbhu zzbhu2 = zzdpl.zzr(jSONArray.optJSONObject(n));
            if (zzbhu2 != null) {
                object.add(zzbhu2);
            }
            ++n;
        }
        return zzfoj.zzp((Collection)object);
    }

    private final zzfsm<List<zzblr>> zzk(JSONArray jSONArray, boolean bl, boolean bl2) {
        if (jSONArray == null) return zzfsd.zza(Collections.emptyList());
        if (jSONArray.length() <= 0) {
            return zzfsd.zza(Collections.emptyList());
        }
        ArrayList<zzfsm<zzblr>> arrayList = new ArrayList<zzfsm<zzblr>>();
        int n = bl2 ? jSONArray.length() : 1;
        int n2 = 0;
        while (n2 < n) {
            arrayList.add(this.zzl(jSONArray.optJSONObject(n2), bl));
            ++n2;
        }
        return zzfsd.zzj((zzfsm)zzfsd.zzk(arrayList), (zzfln)zzdpa.zza, (Executor)this.zzg);
    }

    private final zzfsm<zzblr> zzl(JSONObject jSONObject, boolean bl) {
        if (jSONObject == null) {
            return zzfsd.zza(null);
        }
        String string = jSONObject.optString("url");
        if (TextUtils.isEmpty((CharSequence)string)) {
            return zzfsd.zza(null);
        }
        double d = jSONObject.optDouble("scale", 1.0);
        boolean bl2 = jSONObject.optBoolean("is_transparent", true);
        int n = jSONObject.optInt("width", -1);
        int n2 = jSONObject.optInt("height", -1);
        if (bl) {
            return zzfsd.zza((Object)new zzblr(null, Uri.parse((String)string), d, n, n2));
        }
        string = zzfsd.zzj((zzfsm)this.zzb.zza(string, d, bl2), (zzfln)new zzdpc(string, d, n, n2), (Executor)this.zzg);
        return zzdpl.zzp(jSONObject.optBoolean("require"), string, null);
    }

    private static Integer zzm(JSONObject jSONObject, String string) {
        int n;
        try {
            jSONObject = jSONObject.getJSONObject(string);
            n = Color.rgb((int)jSONObject.getInt("r"), (int)jSONObject.getInt("g"), (int)jSONObject.getInt("b"));
        }
        catch (JSONException jSONException) {
            return null;
        }
        return n;
    }

    private final zzfsm<zzcml> zzn(JSONObject jSONObject, zzezz zzezz2, zzfac zzfac2) {
        String string = jSONObject.optString("base_url");
        String string2 = jSONObject.optString("html");
        jSONObject = this.zzq(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        jSONObject = this.zzi.zzb(string, string2, zzezz2, zzfac2, (zzbdl)jSONObject);
        return zzfsd.zzi((zzfsm)jSONObject, (zzfrk)new zzdph((zzfsm)jSONObject), (Executor)zzchg.zzf);
    }

    private static <T> zzfsm<T> zzo(zzfsm<T> zzfsm2, T t) {
        return zzfsd.zzg(zzfsm2, Exception.class, (zzfrk)new zzdpi(null), (Executor)zzchg.zzf);
    }

    private static <T> zzfsm<T> zzp(boolean bl, zzfsm<T> object, T t) {
        object = bl ? zzfsd.zzi(object, (zzfrk)new zzdpj(object), (Executor)zzchg.zzf) : zzdpl.zzo(object, null);
        return object;
    }

    private final zzbdl zzq(int n, int n2) {
        int n3 = n;
        if (n != 0) return new zzbdl(this.zza, new AdSize(n3, n2));
        if (n2 == 0) return zzbdl.zzb();
        n3 = 0;
        return new zzbdl(this.zza, new AdSize(n3, n2));
    }

    private static final zzbhu zzr(JSONObject object) {
        Object var1_1 = null;
        if (object == null) {
            return null;
        }
        String string = object.optString("reason");
        String string2 = object.optString("ping_url");
        object = var1_1;
        if (TextUtils.isEmpty((CharSequence)string)) return object;
        object = TextUtils.isEmpty((CharSequence)string2) ? var1_1 : new zzbhu(string, string2);
        return object;
    }

    public final zzfsm<zzblr> zza(JSONObject jSONObject, String string) {
        return this.zzl(jSONObject.optJSONObject(string), this.zzh.zzb);
    }

    public final zzfsm<List<zzblr>> zzb(JSONObject jSONObject, String string) {
        jSONObject = jSONObject.optJSONArray("images");
        string = this.zzh;
        return this.zzk((JSONArray)jSONObject, ((zzblv)string).zzb, ((zzblv)string).zzd);
    }

    public final zzfsm<zzcml> zzc(JSONObject object, String string, zzezz zzezz2, zzfac zzfac2) {
        string = zzbjl.zzgO;
        if (!((Boolean)zzbet.zzc().zzc((zzbjd)string)).booleanValue()) {
            return zzfsd.zza(null);
        }
        if ((object = object.optJSONArray("images")) == null) return zzfsd.zza(null);
        if (object.length() <= 0) {
            return zzfsd.zza(null);
        }
        JSONObject jSONObject = object.optJSONObject(0);
        if (jSONObject == null) {
            return zzfsd.zza(null);
        }
        string = jSONObject.optString("base_url");
        object = jSONObject.optString("html");
        jSONObject = this.zzq(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0));
        if (TextUtils.isEmpty((CharSequence)object)) {
            return zzfsd.zza(null);
        }
        object = zzfsd.zzi((zzfsm)zzfsd.zza(null), (zzfrk)new zzdpd(this, (zzbdl)jSONObject, zzezz2, zzfac2, string, (String)object), (Executor)zzchg.zze);
        return zzfsd.zzi((zzfsm)object, (zzfrk)new zzdpe((zzfsm)object), (Executor)zzchg.zzf);
    }

    public final zzfsm<zzblo> zzd(JSONObject object, String string) {
        JSONObject jSONObject = object.optJSONObject("attribution");
        if (jSONObject == null) {
            return zzfsd.zza(null);
        }
        string = jSONObject.optJSONArray("images");
        JSONObject jSONObject2 = jSONObject.optJSONObject("image");
        object = string;
        if (string == null) {
            object = string;
            if (jSONObject2 != null) {
                object = new JSONArray();
                object.put((Object)jSONObject2);
            }
        }
        object = zzfsd.zzj(this.zzk((JSONArray)object, false, true), (zzfln)new zzdpf(this, jSONObject), (Executor)this.zzg);
        return zzdpl.zzp(jSONObject.optBoolean("require"), object, null);
    }

    /*
     * Unable to fully structure code
     */
    public final zzfsm<zzcml> zze(JSONObject var1_1, zzezz var2_2, zzfac var3_3) {
        block5: {
            block6: {
                block4: {
                    var7_4 = zzbx.zzh((JSONObject)var1_1, (String[])new String[]{"html_containers", "instream"});
                    if (var7_4 != null) return this.zzn(var7_4, var2_2, var3_3);
                    if ((var1_1 = var1_1.optJSONObject("video")) != null) break block4;
                    var1_1 = zzfsd.zza(null);
                    break block5;
                }
                var8_5 = var1_1.optString("vast_xml");
                var7_4 = zzbjl.zzgN;
                var6_6 = (Boolean)zzbet.zzc().zzc((zzbjd)var7_4);
                var4_8 = var5_7 = false;
                if (var6_6) {
                    var4_8 = var5_7;
                    if (var1_1.has("html")) {
                        var4_8 = true;
                    }
                }
                if (!TextUtils.isEmpty((CharSequence)var8_5)) break block6;
                if (var4_8) ** GOTO lbl-1000
                com.google.android.gms.ads.internal.util.zze.zzi((String)"Required field 'vast_xml' or 'html' is missing");
                var1_1 = zzfsd.zza(null);
                break block5;
            }
            if (!var4_8) {
                var1_1 = this.zzi.zza((JSONObject)var1_1);
            } else lbl-1000:
            // 2 sources

            {
                var1_1 = this.zzn((JSONObject)var1_1, var2_2, var3_3);
            }
            var2_2 = zzbjl.zzcl;
            var1_1 = zzdpl.zzo(zzfsd.zzh(var1_1, (long)((Integer)zzbet.zzc().zzc((zzbjd)var2_2)).intValue(), (TimeUnit)TimeUnit.SECONDS, (ScheduledExecutorService)this.zzk), null);
        }
        return var1_1;
    }

    final /* synthetic */ zzfsm zzf(String string, Object object) throws Exception {
        zzt.zzd();
        zzcml zzcml2 = zzcmx.zza((Context)this.zza, (zzcob)zzcob.zzb(), (String)"native-omid", (boolean)false, (boolean)false, (zzaas)this.zzc, null, (zzcgz)this.zzd, null, null, (zza)this.zze, (zzazb)this.zzf, null, null);
        zzchk zzchk2 = zzchk.zza((Object)zzcml2);
        zzcml2.zzR().zzy((zzcnx)new zzdpk(zzchk2));
        object = zzbjl.zzdx;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)object)).booleanValue()) {
            zzcml2.loadData(Base64.encodeToString((byte[])string.getBytes(), (int)1), "text/html", "base64");
        } else {
            zzcml2.loadData(string, "text/html", "UTF-8");
        }
        return zzchk2;
    }

    final /* synthetic */ zzblo zzg(JSONObject object, List list) {
        Object object2 = null;
        Object var8_4 = null;
        String string = object2;
        if (list == null) return string;
        if (list.isEmpty()) {
            string = object2;
        } else {
            string = object.optString("text");
            Integer n = zzdpl.zzm(object, "bg_color");
            object2 = zzdpl.zzm(object, "text_color");
            int n2 = object.optInt("text_size", -1);
            boolean bl = object.optBoolean("allow_pub_rendering");
            int n3 = object.optInt("animation_ms", 1000);
            int n4 = object.optInt("presentation_ms", 4000);
            object = var8_4;
            if (n2 > 0) {
                object = n2;
            }
            string = new zzblo(string, list, n, (Integer)object2, (Integer)object, n4 + n3, this.zzh.zze, bl);
        }
        return string;
    }

    final /* synthetic */ zzfsm zzh(zzbdl zzbdl2, zzezz zzezz2, zzfac zzfac2, String string, String string2, Object object) throws Exception {
        zzbdl2 = this.zzj.zzb(zzbdl2, zzezz2, zzfac2);
        zzezz2 = zzchk.zza((Object)zzbdl2);
        zzfac2 = this.zzl.zzb();
        zzbdl2.zzR().zzL((zzbcv)zzfac2, (zzbor)zzfac2, (zzo)zzfac2, (zzbot)zzfac2, (zzv)zzfac2, false, null, new zzb(this.zza, null, null), null, null, this.zzp, this.zzo, this.zzm, this.zzn, null, (zzdio)zzfac2);
        zzfac2 = zzbjl.zzck;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)zzfac2)).booleanValue()) {
            zzbdl2.zzab("/getNativeAdViewSignals", zzbpq.zzs);
        }
        zzbdl2.zzab("/getNativeClickMeta", zzbpq.zzt);
        zzbdl2.zzR().zzy((zzcnx)new zzdpb((zzchk)zzezz2));
        zzbdl2.zzat(string, string2, null);
        return zzezz2;
    }
}
