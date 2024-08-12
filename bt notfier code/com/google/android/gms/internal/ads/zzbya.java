/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.mediation.VersionInfo
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbyb
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbyb;
import java.util.Arrays;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbya
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbya> CREATOR = new zzbyb();
    public final int zza;
    public final int zzb;
    public final int zzc;

    zzbya(int n, int n2, int n3) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = n3;
    }

    public static zzbya zza(VersionInfo versionInfo) {
        return new zzbya(versionInfo.getMajorVersion(), versionInfo.getMinorVersion(), versionInfo.getMicroVersion());
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (!(object instanceof zzbya)) return false;
        object = (zzbya)((Object)object);
        if (((zzbya)((Object)object)).zzc != this.zzc) return false;
        if (((zzbya)((Object)object)).zzb != this.zzb) return false;
        if (((zzbya)((Object)object)).zza != this.zza) return false;
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new int[]{this.zza, this.zzb, this.zzc});
    }

    public final String toString() {
        int n = this.zza;
        int n2 = this.zzb;
        int n3 = this.zzc;
        StringBuilder stringBuilder = new StringBuilder(35);
        stringBuilder.append(n);
        stringBuilder.append(".");
        stringBuilder.append(n2);
        stringBuilder.append(".");
        stringBuilder.append(n3);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzb);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
