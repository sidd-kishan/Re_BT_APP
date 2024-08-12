/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzaft
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzaiy
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaft;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzaiy;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzaiz
implements zzaiu {
    public static final Parcelable.Creator<zzaiz> CREATOR;
    private static final zzafv zzf;
    private static final zzafv zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzh;

    static {
        zzaft zzaft2 = new zzaft();
        zzaft2.zzN("application/id3");
        zzf = zzaft2.zzah();
        zzaft2 = new zzaft();
        zzaft2.zzN("application/x-scte35");
        zzg = zzaft2.zzah();
        CREATOR = new zzaiy();
    }

    zzaiz(Parcel parcel) {
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = (byte[])zzamq.zzd((Object)parcel.createByteArray());
    }

    public zzaiz(String string, String string2, long l, long l2, byte[] byArray) {
        this.zza = string;
        this.zzb = string2;
        this.zzc = l;
        this.zzd = l2;
        this.zze = byArray;
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
        object = (zzaiz)object;
        if (this.zzc != ((zzaiz)object).zzc) return false;
        if (this.zzd != ((zzaiz)object).zzd) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzaiz)object).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzaiz)object).zzb)) return false;
        if (!Arrays.equals(this.zze, ((zzaiz)object).zze)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzh;
        if (n != 0) return n2;
        String string = this.zza;
        n = 0;
        n2 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        if (string != null) {
            n = string.hashCode();
        }
        long l = this.zzc;
        long l2 = this.zzd;
        this.zzh = n2 = ((((n2 + 527) * 31 + n) * 31 + (int)(l ^ l >>> 32)) * 31 + (int)(l2 >>> 32 ^ l2)) * 31 + Arrays.hashCode(this.zze);
        return n2;
    }

    public final String toString() {
        String string = this.zza;
        long l = this.zzd;
        long l2 = this.zzc;
        String string2 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 79 + String.valueOf(string2).length());
        stringBuilder.append("EMSG: scheme=");
        stringBuilder.append(string);
        stringBuilder.append(", id=");
        stringBuilder.append(l);
        stringBuilder.append(", durationMs=");
        stringBuilder.append(l2);
        stringBuilder.append(", value=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final void zza(zzagm zzagm2) {
    }
}
