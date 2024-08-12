/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzcbk
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzfcj
 */
package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzcbk;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzfcj;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcbj
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcbj> CREATOR = new zzcbk();
    public final Bundle zza;
    public final zzcgz zzb;
    public final ApplicationInfo zzc;
    public final String zzd;
    public final List<String> zze;
    public final PackageInfo zzf;
    public final String zzg;
    public final String zzh;
    public zzfcj zzi;
    public String zzj;

    public zzcbj(Bundle bundle, zzcgz zzcgz2, ApplicationInfo applicationInfo, String string, List<String> list, PackageInfo packageInfo, String string2, String string3, zzfcj zzfcj2, String string4) {
        this.zza = bundle;
        this.zzb = zzcgz2;
        this.zzd = string;
        this.zzc = applicationInfo;
        this.zze = list;
        this.zzf = packageInfo;
        this.zzg = string2;
        this.zzh = string3;
        this.zzi = zzfcj2;
        this.zzj = string4;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)1, (Bundle)this.zza, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zzb, (int)n, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zzc, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzd, (boolean)false);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)5, this.zze, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)6, (Parcelable)this.zzf, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)7, (String)this.zzg, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)9, (String)this.zzh, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)10, (Parcelable)this.zzi, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)11, (String)this.zzj, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
