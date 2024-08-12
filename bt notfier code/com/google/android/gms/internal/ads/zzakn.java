/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzakl
 *  com.google.android.gms.internal.ads.zzakm
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzakl;
import com.google.android.gms.internal.ads.zzakm;

public final class zzakn
implements zzaiu {
    public static final Parcelable.Creator<zzakn> CREATOR = new zzakl();
    public final long zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;

    public zzakn(long l, long l2, long l3, long l4, long l5) {
        this.zza = l;
        this.zzb = l2;
        this.zzc = l3;
        this.zzd = l4;
        this.zze = l5;
    }

    /* synthetic */ zzakn(Parcel parcel, zzakm zzakm2) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.readLong();
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
        object = (zzakn)object;
        if (this.zza != ((zzakn)object).zza) return false;
        if (this.zzb != ((zzakn)object).zzb) return false;
        if (this.zzc != ((zzakn)object).zzc) return false;
        if (this.zzd != ((zzakn)object).zzd) return false;
        if (this.zze != ((zzakn)object).zze) return false;
        return true;
    }

    public final int hashCode() {
        long l = this.zza;
        long l2 = this.zzb;
        long l3 = this.zzc;
        long l4 = this.zzd;
        long l5 = this.zze;
        return (((((int)(l ^ l >>> 32) + 527) * 31 + (int)(l2 ^ l2 >>> 32)) * 31 + (int)(l3 >>> 32 ^ l3)) * 31 + (int)(l4 >>> 32 ^ l4)) * 31 + (int)(l5 >>> 32 ^ l5);
    }

    public final String toString() {
        long l = this.zza;
        long l2 = this.zzb;
        long l3 = this.zzc;
        long l4 = this.zzd;
        long l5 = this.zze;
        StringBuilder stringBuilder = new StringBuilder(218);
        stringBuilder.append("Motion photo metadata: photoStartPosition=");
        stringBuilder.append(l);
        stringBuilder.append(", photoSize=");
        stringBuilder.append(l2);
        stringBuilder.append(", photoPresentationTimestampUs=");
        stringBuilder.append(l3);
        stringBuilder.append(", videoStartPosition=");
        stringBuilder.append(l4);
        stringBuilder.append(", videoSize=");
        stringBuilder.append(l5);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeLong(this.zze);
    }

    public final void zza(zzagm zzagm2) {
    }
}
