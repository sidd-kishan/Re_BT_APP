/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbdo
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbdo;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzbdn
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdn> CREATOR = new zzbdo();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final long zzd;

    public zzbdn(int n, int n2, String string, long l) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = string;
        this.zzd = l;
    }

    public static zzbdn zza(JSONObject jSONObject) throws JSONException {
        return new zzbdn(jSONObject.getInt("type_num"), jSONObject.getInt("precision_num"), jSONObject.getString("currency"), jSONObject.getLong("value"));
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzb);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)4, (long)this.zzd);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
