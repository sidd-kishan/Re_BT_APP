/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzajb
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzajb;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzajc
implements zzaiu {
    public static final Parcelable.Creator<zzajc> CREATOR = new zzajb();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzajc(int n, String string, String string2, int n2, int n3, int n4, int n5, byte[] byArray) {
        this.zza = n;
        this.zzb = string;
        this.zzc = string2;
        this.zzd = n2;
        this.zze = n3;
        this.zzf = n4;
        this.zzg = n5;
        this.zzh = byArray;
    }

    zzajc(Parcel parcel) {
        this.zza = parcel.readInt();
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zzb = string;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = (byte[])zzamq.zzd((Object)parcel.createByteArray());
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
        object = (zzajc)object;
        if (this.zza != ((zzajc)object).zza) return false;
        if (!this.zzb.equals(((zzajc)object).zzb)) return false;
        if (!this.zzc.equals(((zzajc)object).zzc)) return false;
        if (this.zzd != ((zzajc)object).zzd) return false;
        if (this.zze != ((zzajc)object).zze) return false;
        if (this.zzf != ((zzajc)object).zzf) return false;
        if (this.zzg != ((zzajc)object).zzg) return false;
        if (!Arrays.equals(this.zzh, ((zzajc)object).zzh)) return false;
        return true;
    }

    public final int hashCode() {
        return (((((((this.zza + 527) * 31 + this.zzb.hashCode()) * 31 + this.zzc.hashCode()) * 31 + this.zzd) * 31 + this.zze) * 31 + this.zzf) * 31 + this.zzg) * 31 + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        String string = this.zzb;
        String string2 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 32 + String.valueOf(string2).length());
        stringBuilder.append("Picture: mimeType=");
        stringBuilder.append(string);
        stringBuilder.append(", description=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzagm zzagm2) {
        zzagm2.zzx(this.zzh, this.zza);
    }
}
