/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzfka
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfka;

public final class zzfjz
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfjz> CREATOR = new zzfka();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final String zzd;
    public final int zze;

    zzfjz(int n, int n2, int n3, String string, String string2) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = string;
        this.zzd = string2;
        this.zze = n3;
    }

    public zzfjz(int n, int n2, String string, String string2) {
        this(1, 1, n2 - 1, string, string2);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzb);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzd, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)5, (int)this.zze);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
