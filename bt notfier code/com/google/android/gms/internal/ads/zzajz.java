/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzajy
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzajy;
import com.google.android.gms.internal.ads.zzamq;

public final class zzajz
extends zzajx {
    public static final Parcelable.Creator<zzajz> CREATOR = new zzajy();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zzajz(Parcel parcel) {
        super("----");
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public zzajz(String string, String string2, String string3) {
        super("----");
        this.zza = string;
        this.zzb = string2;
        this.zzc = string3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzajz)((Object)object);
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzajz)((Object)object)).zzb)) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzajz)((Object)object)).zza)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzajz)((Object)object)).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        String string = this.zza;
        int n = 0;
        int n2 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzc;
        if (string == null) return ((n2 + 527) * 31 + n3) * 31 + n;
        n = string.hashCode();
        return ((n2 + 527) * 31 + n3) * 31 + n;
    }

    public final String toString() {
        String string = this.zzf;
        String string2 = this.zza;
        String string3 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 23 + String.valueOf(string2).length() + String.valueOf(string3).length());
        stringBuilder.append(string);
        stringBuilder.append(": domain=");
        stringBuilder.append(string2);
        stringBuilder.append(", description=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }
}
