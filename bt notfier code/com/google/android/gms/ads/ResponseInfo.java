/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdapterResponseInfo
 *  com.google.android.gms.internal.ads.zzbdp
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzcgt
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdapterResponseInfo;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class ResponseInfo {
    private final zzbgz zza;
    private final List<AdapterResponseInfo> zzb;

    /*
     * Enabled force condition propagation
     */
    private ResponseInfo(zzbgz object) {
        this.zza = object;
        this.zzb = new ArrayList<AdapterResponseInfo>();
        object = zzbjl.zzfX;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        object = this.zza;
        if (object == null) {
            return;
        }
        try {
            object = object.zzg();
            if (object == null) return;
            object = object.iterator();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Could not forward getAdapterResponseInfo to ResponseInfo.", (Throwable)remoteException);
            return;
        }
        while (object.hasNext()) {
            AdapterResponseInfo adapterResponseInfo = AdapterResponseInfo.zza((zzbdp)((zzbdp)object.next()));
            if (adapterResponseInfo == null) continue;
            this.zzb.add(adapterResponseInfo);
        }
    }

    public static ResponseInfo zzb(zzbgz zzbgz2) {
        if (zzbgz2 == null) return null;
        return new ResponseInfo(zzbgz2);
    }

    public static ResponseInfo zzc(zzbgz zzbgz2) {
        return new ResponseInfo(zzbgz2);
    }

    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzb;
    }

    public String getMediationAdapterClassName() {
        try {
            Object object = this.zza;
            if (object == null) return null;
            object = object.zze();
            return object;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Could not forward getMediationAdapterClassName to ResponseInfo.", (Throwable)remoteException);
        }
        return null;
    }

    public String getResponseId() {
        try {
            Object object = this.zza;
            if (object == null) return null;
            object = object.zzf();
            return object;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Could not forward getResponseId to ResponseInfo.", (Throwable)remoteException);
        }
        return null;
    }

    public String toString() {
        String string;
        try {
            string = this.zza().toString(2);
        }
        catch (JSONException jSONException) {
            string = "Error forming toString output.";
        }
        return string;
    }

    public final JSONObject zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Object object = this.getResponseId();
        if (object == null) {
            jSONObject.put("Response ID", (Object)"null");
        } else {
            jSONObject.put("Response ID", object);
        }
        object = this.getMediationAdapterClassName();
        if (object == null) {
            jSONObject.put("Mediation Adapter Class Name", (Object)"null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", object);
        }
        JSONArray jSONArray = new JSONArray();
        object = this.zzb.iterator();
        while (true) {
            if (!object.hasNext()) {
                jSONObject.put("Adapter Responses", (Object)jSONArray);
                return jSONObject;
            }
            jSONArray.put((Object)((AdapterResponseInfo)object.next()).zzb());
        }
    }
}
