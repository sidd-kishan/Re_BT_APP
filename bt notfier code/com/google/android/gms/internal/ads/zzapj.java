/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzapi
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzapi;
import com.google.android.gms.internal.ads.zzave;
import java.util.Arrays;
import java.util.UUID;

public final class zzapj
implements Parcelable {
    public static final Parcelable.Creator<zzapj> CREATOR = new zzapi();
    public final String zza;
    public final byte[] zzb;
    public final boolean zzc;
    private int zzd;
    private final UUID zze;

    zzapj(Parcel parcel) {
        this.zze = new UUID(parcel.readLong(), parcel.readLong());
        this.zza = parcel.readString();
        this.zzb = parcel.createByteArray();
        boolean bl = parcel.readByte() != 0;
        this.zzc = bl;
    }

    public zzapj(UUID uUID, String string, byte[] byArray, boolean bl) {
        if (uUID == null) throw null;
        this.zze = uUID;
        this.zza = string;
        if (byArray == null) throw null;
        this.zzb = byArray;
        this.zzc = false;
    }

    static /* synthetic */ UUID zza(zzapj zzapj2) {
        return zzapj2.zze;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzapj)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        object = (zzapj)object;
        if (!this.zza.equals(((zzapj)object).zza)) return false;
        if (!zzave.zza((Object)this.zze, (Object)((zzapj)object).zze)) return false;
        if (!Arrays.equals(this.zzb, ((zzapj)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzd;
        if (n != 0) return n2;
        this.zzd = n2 = (this.zze.hashCode() * 31 + this.zza.hashCode()) * 31 + Arrays.hashCode(this.zzb);
        return n2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeLong(this.zze.getMostSignificantBits());
        parcel.writeLong(this.zze.getLeastSignificantBits());
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
        parcel.writeByte((byte)(this.zzc ? 1 : 0));
    }
}
