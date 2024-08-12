/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzcdw
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzcdw;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcdv
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcdv> CREATOR = new zzcdw();
    public final String zza;
    public final String zzb;
    public final boolean zzc;
    public final boolean zzd;
    public final List<String> zze;
    public final boolean zzf;
    public final boolean zzg;
    public final List<String> zzh;

    public zzcdv(String arrayList, String string, boolean bl, boolean bl2, List<String> list, boolean bl3, boolean bl4, List<String> list2) {
        this.zza = arrayList;
        this.zzb = string;
        this.zzc = bl;
        this.zzd = bl2;
        this.zze = list;
        this.zzf = bl3;
        this.zzg = bl4;
        arrayList = list2;
        if (list2 == null) {
            arrayList = new ArrayList();
        }
        this.zzh = arrayList;
    }

    public static zzcdv zza(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.optString("click_string", "");
        String string2 = jSONObject.optString("report_url", "");
        boolean bl = jSONObject.optBoolean("rendered_ad_enabled", false);
        boolean bl2 = jSONObject.optBoolean("non_malicious_reporting_enabled", false);
        List list = zzbx.zza((JSONArray)jSONObject.optJSONArray("allowed_headers"), null);
        List list2 = zzbx.zza((JSONArray)jSONObject.optJSONArray("webview_permissions"), null);
        return new zzcdv(string, string2, bl, bl2, list, jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), list2);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzb, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)4, (boolean)this.zzc);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zzd);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)6, this.zze, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)7, (boolean)this.zzf);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)8, (boolean)this.zzg);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)9, this.zzh, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
