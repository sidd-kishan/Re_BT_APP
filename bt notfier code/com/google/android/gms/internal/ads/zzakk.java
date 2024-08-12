/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaki
 *  com.google.android.gms.internal.ads.zzakj
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaki;
import com.google.android.gms.internal.ads.zzakj;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzakk
implements zzaiu {
    public static final Parcelable.Creator<zzakk> CREATOR = new zzaki();
    public final String zza;
    public final byte[] zzb;
    public final int zzc;
    public final int zzd;

    /* synthetic */ zzakk(Parcel parcel, zzakj object) {
        object = parcel.readString();
        int n = zzamq.zza;
        this.zza = object;
        this.zzb = (byte[])zzamq.zzd((Object)parcel.createByteArray());
        this.zzc = parcel.readInt();
        this.zzd = parcel.readInt();
    }

    public zzakk(String string, byte[] byArray, int n, int n2) {
        this.zza = string;
        this.zzb = byArray;
        this.zzc = n;
        this.zzd = n2;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzakk)object;
        if (!this.zza.equals(((zzakk)object).zza)) return false;
        if (!Arrays.equals(this.zzb, ((zzakk)object).zzb)) return false;
        if (this.zzc != ((zzakk)object).zzc) return false;
        if (this.zzd != ((zzakk)object).zzd) return false;
        return true;
    }

    public final int hashCode() {
        return (((this.zza.hashCode() + 527) * 31 + Arrays.hashCode(this.zzb)) * 31 + this.zzc) * 31 + this.zzd;
    }

    public final String toString() {
        String string = String.valueOf(this.zza);
        string = string.length() != 0 ? "mdta: key=".concat(string) : new String("mdta: key=");
        return string;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeInt(this.zzd);
    }

    public final void zza(zzagm zzagm2) {
    }
}
