/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzakg
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzakg;
import com.google.android.gms.internal.ads.zzamq;

public final class zzakh
extends zzajx {
    public static final Parcelable.Creator<zzakh> CREATOR = new zzakg();
    public final String zza;
    public final String zzb;

    zzakh(Parcel parcel) {
        String string = parcel.readString();
        int n = zzamq.zza;
        super(string);
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public zzakh(String string, String string2, String string3) {
        super(string);
        this.zza = string2;
        this.zzb = string3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzakh)((Object)object);
        if (!this.zzf.equals(((zzakh)((Object)object)).zzf)) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzakh)((Object)object)).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzakh)((Object)object)).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzf.hashCode();
        String string = this.zza;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        if (string == null) return ((n + 527) * 31 + n3) * 31 + n2;
        n2 = string.hashCode();
        return ((n + 527) * 31 + n3) * 31 + n2;
    }

    public final String toString() {
        String string = this.zzf;
        String string2 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 6 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append(": url=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }
}
