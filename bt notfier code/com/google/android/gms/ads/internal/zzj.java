/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.zzk
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 */
package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class zzj
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzj> CREATOR = new zzk();
    public final boolean zza;
    public final boolean zzb;
    public final String zzc;
    public final boolean zzd;
    public final float zze;
    public final int zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    zzj(boolean bl, boolean bl2, String string, boolean bl3, float f, int n, boolean bl4, boolean bl5, boolean bl6) {
        this.zza = bl;
        this.zzb = bl2;
        this.zzc = string;
        this.zzd = bl3;
        this.zze = f;
        this.zzf = n;
        this.zzg = bl4;
        this.zzh = bl5;
        this.zzi = bl6;
    }

    public zzj(boolean bl, boolean bl2, boolean bl3, float f, int n, boolean bl4, boolean bl5, boolean bl6) {
        this(bl, bl2, null, bl3, f, -1, bl4, bl5, bl6);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.zza);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.zzb);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zzd);
        SafeParcelWriter.writeFloat((Parcel)parcel, (int)6, (float)this.zze);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)7, (int)this.zzf);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)8, (boolean)this.zzg);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)9, (boolean)this.zzh);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)10, (boolean)this.zzi);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
