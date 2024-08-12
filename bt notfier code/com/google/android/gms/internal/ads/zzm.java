/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzl
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzl;
import java.util.Arrays;
import java.util.UUID;

public final class zzm
implements Parcelable {
    public static final Parcelable.Creator<zzm> CREATOR = new zzl();
    public final UUID zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;
    private int zze;

    zzm(Parcel parcel) {
        this.zza = new UUID(parcel.readLong(), parcel.readLong());
        this.zzb = parcel.readString();
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zzc = string;
        this.zzd = parcel.createByteArray();
    }

    public zzm(UUID uUID, String string, String string2, byte[] byArray) {
        if (uUID == null) throw null;
        this.zza = uUID;
        this.zzb = null;
        this.zzc = string2;
        this.zzd = byArray;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof zzm)) {
            return false;
        }
        if (object == this) {
            return true;
        }
        object = (zzm)object;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzm)object).zzb)) return false;
        if (!zzamq.zzc((Object)this.zzc, (Object)((zzm)object).zzc)) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzm)object).zza)) return false;
        if (!Arrays.equals(this.zzd, ((zzm)object).zzd)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zze;
        if (n != 0) return n2;
        n = this.zza.hashCode();
        String string = this.zzb;
        n2 = string == null ? 0 : string.hashCode();
        this.zze = n2 = ((n * 31 + n2) * 31 + this.zzc.hashCode()) * 31 + Arrays.hashCode(this.zzd);
        return n2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeLong(this.zza.getMostSignificantBits());
        parcel.writeLong(this.zza.getLeastSignificantBits());
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }
}
