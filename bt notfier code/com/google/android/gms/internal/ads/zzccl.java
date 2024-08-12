/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzccm
 *  org.json.JSONArray
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzccm;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzccl
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzccl> CREATOR = new zzccm();
    public final String zza;
    public final int zzb;

    public zzccl(String string, int n) {
        this.zza = string;
        this.zzb = n;
    }

    public static zzccl zza(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null) return null;
        if (jSONArray.length() != 0) return new zzccl(jSONArray.getJSONObject(0).optString("rb_type"), jSONArray.getJSONObject(0).optInt("rb_amount"));
        return null;
    }

    public final boolean equals(Object object) {
        if (object == null) return false;
        if (!(object instanceof zzccl)) {
            return false;
        }
        object = (zzccl)((Object)object);
        if (!Objects.equal((Object)this.zza, (Object)((zzccl)((Object)object)).zza)) return false;
        if (!Objects.equal((Object)this.zzb, (Object)((zzccl)((Object)object)).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.zza, this.zzb});
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzb);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
