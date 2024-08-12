/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.AdError
 *  com.google.android.gms.ads.LoadAdError
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbda
 *  com.google.android.gms.internal.ads.zzbgx
 *  com.google.android.gms.internal.ads.zzbgz
 */
package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbda;
import com.google.android.gms.internal.ads.zzbgx;
import com.google.android.gms.internal.ads.zzbgz;

public final class zzbcz
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbcz> CREATOR = new zzbda();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public zzbcz zzd;
    public IBinder zze;

    public zzbcz(int n, String string, String string2, zzbcz zzbcz2, IBinder iBinder) {
        this.zza = n;
        this.zzb = string;
        this.zzc = string2;
        this.zzd = zzbcz2;
        this.zze = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zzb, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)4, (Parcelable)this.zzd, (int)n, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)5, (IBinder)this.zze, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final AdError zza() {
        zzbcz zzbcz2 = this.zzd;
        zzbcz2 = zzbcz2 == null ? null : new AdError(zzbcz2.zza, zzbcz2.zzb, zzbcz2.zzc);
        return new AdError(this.zza, this.zzb, this.zzc, (AdError)zzbcz2);
    }

    public final LoadAdError zzb() {
        zzbcz zzbcz2 = this.zzd;
        Object object = null;
        zzbcz2 = zzbcz2 == null ? null : new AdError(zzbcz2.zza, zzbcz2.zzb, zzbcz2.zzc);
        int n = this.zza;
        String string = this.zzb;
        String string2 = this.zzc;
        IBinder iBinder = this.zze;
        if (iBinder == null) return new LoadAdError(n, string, string2, (AdError)zzbcz2, ResponseInfo.zzb((zzbgz)object));
        object = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
        object = object instanceof zzbgz ? (zzbgz)object : new zzbgx(iBinder);
        return new LoadAdError(n, string, string2, (AdError)zzbcz2, ResponseInfo.zzb((zzbgz)object));
    }
}
