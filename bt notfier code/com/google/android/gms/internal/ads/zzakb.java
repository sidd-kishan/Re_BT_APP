/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzaka
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzaka;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzakb
extends zzajx {
    public static final Parcelable.Creator<zzakb> CREATOR = new zzaka();
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int[] zzd;
    public final int[] zze;

    public zzakb(int n, int n2, int n3, int[] nArray, int[] nArray2) {
        super("MLLT");
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
        this.zzd = nArray;
        this.zze = nArray2;
    }

    zzakb(Parcel parcel) {
        super("MLLT");
        this.zza = parcel.readInt();
        this.zzb = parcel.readInt();
        this.zzc = parcel.readInt();
        this.zzd = (int[])zzamq.zzd((Object)parcel.createIntArray());
        this.zze = (int[])zzamq.zzd((Object)parcel.createIntArray());
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
        object = (zzakb)((Object)object);
        if (this.zza != ((zzakb)((Object)object)).zza) return false;
        if (this.zzb != ((zzakb)((Object)object)).zzb) return false;
        if (this.zzc != ((zzakb)((Object)object)).zzc) return false;
        if (!Arrays.equals(this.zzd, ((zzakb)((Object)object)).zzd)) return false;
        if (!Arrays.equals(this.zze, ((zzakb)((Object)object)).zze)) return false;
        return true;
    }

    public final int hashCode() {
        return ((((this.zza + 527) * 31 + this.zzb) * 31 + this.zzc) * 31 + Arrays.hashCode(this.zzd)) * 31 + Arrays.hashCode(this.zze);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.zza);
        parcel.writeInt(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeIntArray(this.zzd);
        parcel.writeIntArray(this.zze);
    }
}
