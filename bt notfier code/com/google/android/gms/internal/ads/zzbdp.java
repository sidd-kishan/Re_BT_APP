/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbdq
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbdq;

public final class zzbdp
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbdp> CREATOR = new zzbdq();
    public final String zza;
    public long zzb;
    public zzbcz zzc;
    public final Bundle zzd;

    public zzbdp(String string, long l, zzbcz zzbcz2, Bundle bundle) {
        this.zza = string;
        this.zzb = l;
        this.zzc = zzbcz2;
        this.zzd = bundle;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)2, (long)this.zzb);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zzc, (int)n, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)4, (Bundle)this.zzd, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
