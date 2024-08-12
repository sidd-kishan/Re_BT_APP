/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajl
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajl;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzajm
extends zzajx {
    public static final Parcelable.Creator<zzajm> CREATOR = new zzajl();
    public final String zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final long zze;
    private final zzajx[] zzg;

    zzajm(Parcel parcel) {
        super("CHAP");
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
        int n2 = parcel.readInt();
        this.zzg = new zzajx[n2];
        n = 0;
        while (n < n2) {
            this.zzg[n] = (zzajx)parcel.readParcelable(zzajx.class.getClassLoader());
            ++n;
        }
    }

    public zzajm(String string, int n, int n2, long l, long l2, zzajx[] zzajxArray) {
        super("CHAP");
        this.zza = string;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = l;
        this.zze = l2;
        this.zzg = zzajxArray;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzajm)((Object)object);
        if (this.zzb != ((zzajm)((Object)object)).zzb) return false;
        if (this.zzc != ((zzajm)((Object)object)).zzc) return false;
        if (this.zzd != ((zzajm)((Object)object)).zzd) return false;
        if (this.zze != ((zzajm)((Object)object)).zze) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzajm)((Object)object)).zza)) return false;
        if (!Arrays.equals(this.zzg, ((zzajm)((Object)object)).zzg)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzb;
        int n2 = this.zzc;
        int n3 = (int)this.zzd;
        int n4 = (int)this.zze;
        String string = this.zza;
        int n5 = string != null ? string.hashCode() : 0;
        return ((((n + 527) * 31 + n2) * 31 + n3) * 31 + n4) * 31 + n5;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
        parcel.writeInt(this.zzg.length);
        zzajx[] zzajxArray = this.zzg;
        int n2 = zzajxArray.length;
        n = 0;
        while (n < n2) {
            parcel.writeParcelable((Parcelable)zzajxArray[n], 0);
            ++n;
        }
    }
}
