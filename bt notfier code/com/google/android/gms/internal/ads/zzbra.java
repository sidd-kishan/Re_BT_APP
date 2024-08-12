/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbrb
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbrb;

public final class zzbra
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbra> CREATOR = new zzbrb();
    public final boolean zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;
    public final String[] zze;
    public final String[] zzf;
    public final boolean zzg;
    public final long zzh;

    zzbra(boolean bl, String string, int n, byte[] byArray, String[] stringArray, String[] stringArray2, boolean bl2, long l) {
        this.zza = bl;
        this.zzb = string;
        this.zzc = n;
        this.zzd = byArray;
        this.zze = stringArray;
        this.zzf = stringArray2;
        this.zzg = bl2;
        this.zzh = l;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)1, (boolean)this.zza);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zzb, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.writeByteArray((Parcel)parcel, (int)4, (byte[])this.zzd, (boolean)false);
        SafeParcelWriter.writeStringArray((Parcel)parcel, (int)5, (String[])this.zze, (boolean)false);
        SafeParcelWriter.writeStringArray((Parcel)parcel, (int)6, (String[])this.zzf, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)7, (boolean)this.zzg);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)8, (long)this.zzh);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
