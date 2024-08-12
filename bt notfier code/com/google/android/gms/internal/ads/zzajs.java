/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajr
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajr;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzajs
extends zzajx {
    public static final Parcelable.Creator<zzajs> CREATOR = new zzajr();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    zzajs(Parcel parcel) {
        super("GEOB");
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = (byte[])zzamq.zzd((Object)parcel.createByteArray());
    }

    public zzajs(String string, String string2, String string3, byte[] byArray) {
        super("GEOB");
        this.zza = string;
        this.zzb = string2;
        this.zzc = string3;
        this.zzd = byArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzajs)((Object)object);
        if (!zzamq.zzc((Object)this.zza, (Object)((zzajs)((Object)object)).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzajs)((Object)object)).zzb)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzajs)((Object)object)).zzc)) return false;
        if (!Arrays.equals(this.zzd, ((zzajs)((Object)object)).zzd)) return false;
        return true;
    }

    public final int hashCode() {
        String string = this.zza;
        int n = 0;
        int n2 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzc;
        if (string == null) return (((n2 + 527) * 31 + n3) * 31 + n) * 31 + Arrays.hashCode(this.zzd);
        n = string.hashCode();
        return (((n2 + 527) * 31 + n3) * 31 + n) * 31 + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        String string = this.zzf;
        String string2 = this.zza;
        String string3 = this.zzb;
        String string4 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 36 + String.valueOf(string2).length() + String.valueOf(string3).length() + String.valueOf(string4).length());
        stringBuilder.append(string);
        stringBuilder.append(": mimeType=");
        stringBuilder.append(string2);
        stringBuilder.append(", filename=");
        stringBuilder.append(string3);
        stringBuilder.append(", description=");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }
}
