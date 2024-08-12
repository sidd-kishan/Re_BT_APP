/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzavg
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzavg;
import java.util.Arrays;

public final class zzavh
implements Parcelable {
    public static final Parcelable.Creator<zzavh> CREATOR = new zzavg();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final byte[] zzd;
    private int zze;

    public zzavh(int n, int n2, int n3, byte[] byArray) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = byArray;
    }

    zzavh(Parcel object) {
        this.zza = object.readInt();
        this.zzb = object.readInt();
        this.zzc = object.readInt();
        object = object.readInt() != 0 ? (Object)object.createByteArray() : null;
        this.zzd = (byte[])object;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) return false;
        object = (zzavh)object;
        if (this.zza != ((zzavh)object).zza) return false;
        if (this.zzb != ((zzavh)object).zzb) return false;
        if (this.zzc != ((zzavh)object).zzc) return false;
        if (Arrays.equals(this.zzd, ((zzavh)object).zzd)) return true;
        return false;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zze;
        if (n != 0) return n2;
        this.zze = n2 = (((this.zza + 527) * 31 + this.zzb) * 31 + this.zzc) * 31 + Arrays.hashCode(this.zzd);
        return n2;
    }

    public final String toString() {
        int n = this.zza;
        int n2 = this.zzb;
        int n3 = this.zzc;
        boolean bl = this.zzd != null;
        StringBuilder stringBuilder = new StringBuilder(55);
        stringBuilder.append("ColorInfo(");
        stringBuilder.append(n);
        stringBuilder.append(", ");
        stringBuilder.append(n2);
        stringBuilder.append(", ");
        stringBuilder.append(n3);
        stringBuilder.append(", ");
        stringBuilder.append(bl);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        n = this.zzd != null ? 1 : 0;
        parcel.writeInt(n);
        byte[] byArray = this.zzd;
        if (byArray == null) return;
        parcel.writeByteArray(byArray);
    }
}
