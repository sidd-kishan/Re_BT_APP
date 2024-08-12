/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.net.Uri
 *  android.text.TextUtils
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzaat
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbkx
 *  com.google.android.gms.internal.ads.zzbou
 *  com.google.android.gms.internal.ads.zzbov
 *  com.google.android.gms.internal.ads.zzbow
 *  com.google.android.gms.internal.ads.zzbox
 *  com.google.android.gms.internal.ads.zzboy
 *  com.google.android.gms.internal.ads.zzboz
 *  com.google.android.gms.internal.ads.zzbpa
 *  com.google.android.gms.internal.ads.zzbpb
 *  com.google.android.gms.internal.ads.zzbpc
 *  com.google.android.gms.internal.ads.zzbpd
 *  com.google.android.gms.internal.ads.zzbpe
 *  com.google.android.gms.internal.ads.zzbpf
 *  com.google.android.gms.internal.ads.zzbpg
 *  com.google.android.gms.internal.ads.zzbpi
 *  com.google.android.gms.internal.ads.zzbpj
 *  com.google.android.gms.internal.ads.zzbpk
 *  com.google.android.gms.internal.ads.zzbpl
 *  com.google.android.gms.internal.ads.zzbpm
 *  com.google.android.gms.internal.ads.zzbpn
 *  com.google.android.gms.internal.ads.zzbpo
 *  com.google.android.gms.internal.ads.zzbpp
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbqf
 *  com.google.android.gms.internal.ads.zzbsi
 *  com.google.android.gms.internal.ads.zzcfc
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcko
 *  com.google.android.gms.internal.ads.zzckp
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcnn
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzfln
 *  com.google.android.gms.internal.ads.zzfru
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzbou;
import com.google.android.gms.internal.ads.zzbov;
import com.google.android.gms.internal.ads.zzbow;
import com.google.android.gms.internal.ads.zzbox;
import com.google.android.gms.internal.ads.zzboy;
import com.google.android.gms.internal.ads.zzboz;
import com.google.android.gms.internal.ads.zzbpa;
import com.google.android.gms.internal.ads.zzbpb;
import com.google.android.gms.internal.ads.zzbpc;
import com.google.android.gms.internal.ads.zzbpd;
import com.google.android.gms.internal.ads.zzbpe;
import com.google.android.gms.internal.ads.zzbpf;
import com.google.android.gms.internal.ads.zzbpg;
import com.google.android.gms.internal.ads.zzbpi;
import com.google.android.gms.internal.ads.zzbpj;
import com.google.android.gms.internal.ads.zzbpk;
import com.google.android.gms.internal.ads.zzbpl;
import com.google.android.gms.internal.ads.zzbpm;
import com.google.android.gms.internal.ads.zzbpn;
import com.google.android.gms.internal.ads.zzbpo;
import com.google.android.gms.internal.ads.zzbpp;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbqf;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzcfc;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcko;
import com.google.android.gms.internal.ads.zzckp;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcnn;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzfln;
import com.google.android.gms.internal.ads.zzfru;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbpq {
    public static final zzbpr<zzcml> zza = zzbov.zza;
    public static final zzbpr<zzcml> zzb = zzbow.zza;
    public static final zzbpr<zzcml> zzc = zzbox.zza;
    public static final zzbpr<zzcml> zzd = new zzbpi();
    public static final zzbpr<zzcml> zze = new zzbpj();
    public static final zzbpr<zzcml> zzf = zzbpc.zza;
    public static final zzbpr<Object> zzg = new zzbpk();
    public static final zzbpr<zzcml> zzh = new zzbpl();
    public static final zzbpr<zzcml> zzi = zzbpd.zza;
    public static final zzbpr<zzcml> zzj = new zzbpm();
    public static final zzbpr<zzcml> zzk = new zzbpn();
    public static final zzbpr<zzcjb> zzl = new zzcko();
    public static final zzbpr<zzcjb> zzm = new zzckp();
    public static final zzbpr<zzcml> zzn = new zzbou();
    public static final zzbqf zzo = new zzbqf();
    public static final zzbpr<zzcml> zzp = new zzbpo();
    public static final zzbpr<zzcml> zzq = new zzbpp();
    public static final zzbpr<zzcml> zzr = new zzbpe();
    public static final zzbpr<zzcml> zzs = new zzbpf();
    public static final zzbpr<zzcml> zzt = new zzbpg();

    public static zzfsm<String> zza(zzcml zzcml2, String string) {
        Uri uri;
        Uri uri2 = Uri.parse((String)string);
        try {
            zzaas zzaas2 = zzcml2.zzU();
            uri = uri2;
            if (zzaas2 != null) {
                uri = uri2;
                if (zzaas2.zza(uri2)) {
                    uri = zzaas2.zze(uri2, zzcml2.getContext(), zzcml2.zzH(), zzcml2.zzj());
                }
            }
        }
        catch (zzaat zzaat2) {
            string = string.length() != 0 ? "Unable to append parameter to URL: ".concat(string) : new String("Unable to append parameter to URL: ");
            com.google.android.gms.ads.internal.util.zze.zzi((String)string);
            uri = uri2;
        }
        string = zzcfc.zzb((Uri)uri, (Context)zzcml2.getContext());
        long l = (Long)zzbkx.zze.zze();
        if (l <= 0L) return zzfsd.zza((Object)string);
        if (l > 213806100L) return zzfsd.zza((Object)string);
        return zzfsd.zzf((zzfsm)zzfsd.zzj((zzfsm)zzfsd.zzf((zzfsm)zzfru.zzw((zzfsm)zzcml2.zzaE()), Throwable.class, (zzfln)zzboy.zza, (Executor)zzchg.zzf), (zzfln)new zzboz(string), (Executor)zzchg.zzf), Throwable.class, (zzfln)new zzbpa(string), (Executor)zzchg.zzf);
    }

    public static zzbpr<zzcml> zzb(zzdio zzdio2) {
        return new zzbpb(zzdio2);
    }

    public static void zzc(Map<String, String> map, zzdio zzdio2) {
        zzbjd zzbjd2 = zzbjl.zzha;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        if (!map.containsKey("sc")) return;
        if (!map.get("sc").equals("1")) return;
        if (zzdio2 == null) return;
        zzdio2.zzb();
    }

    static final /* synthetic */ void zzd(zzcnn zzcnn2, Map object) {
        JSONArray jSONArray;
        PackageManager packageManager = zzcnn2.getContext().getPackageManager();
        object = (String)object.get("data");
        try {
            object = new JSONObject((String)object);
        }
        catch (JSONException jSONException) {
            ((zzbsi)zzcnn2).zzd("openableIntents", new JSONObject());
            return;
        }
        try {
            jSONArray = object.getJSONArray("intents");
        }
        catch (JSONException jSONException) {
            ((zzbsi)zzcnn2).zzd("openableIntents", new JSONObject());
            return;
        }
        JSONObject jSONObject = new JSONObject();
        int n = 0;
        while (true) {
            block21: {
                Object object2;
                if (n >= jSONArray.length()) {
                    ((zzbsi)zzcnn2).zzd("openableIntents", jSONObject);
                    return;
                }
                try {
                    object = jSONArray.getJSONObject(n);
                }
                catch (JSONException jSONException) {
                    com.google.android.gms.ads.internal.util.zze.zzg((String)"Error parsing the intent data.", (Throwable)jSONException);
                    break block21;
                }
                String string = object.optString("id");
                String string2 = object.optString("u");
                String[] stringArray = object.optString("i");
                String string3 = object.optString("m");
                String string4 = object.optString("p");
                String string5 = object.optString("c");
                String string6 = object.optString("intent_url");
                boolean bl = TextUtils.isEmpty((CharSequence)string6);
                object = object2 = null;
                if (!bl) {
                    try {
                        object = Intent.parseUri((String)string6, (int)0);
                    }
                    catch (URISyntaxException uRISyntaxException) {
                        object = String.valueOf(string6);
                        object = ((String)object).length() != 0 ? "Error parsing the url: ".concat((String)object) : new String("Error parsing the url: ");
                        com.google.android.gms.ads.internal.util.zze.zzg((String)object, (Throwable)uRISyntaxException);
                        object = object2;
                    }
                }
                bl = true;
                object2 = object;
                if (object == null) {
                    object = new Intent();
                    if (!TextUtils.isEmpty((CharSequence)string2)) {
                        object.setData(Uri.parse((String)string2));
                    }
                    if (!TextUtils.isEmpty((CharSequence)stringArray)) {
                        object.setAction((String)stringArray);
                    }
                    if (!TextUtils.isEmpty((CharSequence)string3)) {
                        object.setType(string3);
                    }
                    if (!TextUtils.isEmpty((CharSequence)string4)) {
                        object.setPackage(string4);
                    }
                    object2 = object;
                    if (!TextUtils.isEmpty((CharSequence)string5)) {
                        stringArray = string5.split("/", 2);
                        object2 = object;
                        if (stringArray.length == 2) {
                            object.setComponent(new ComponentName(stringArray[0], stringArray[1]));
                            object2 = object;
                        }
                    }
                }
                if (packageManager.resolveActivity((Intent)object2, 65536) == null) {
                    bl = false;
                }
                try {
                    jSONObject.put(string, bl);
                }
                catch (JSONException jSONException) {
                    com.google.android.gms.ads.internal.util.zze.zzg((String)"Error constructing openable urls response.", (Throwable)jSONException);
                }
            }
            ++n;
        }
    }
}
