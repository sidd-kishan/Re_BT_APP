/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.measurement.zzaa
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.measurement.zzaa;

public final class zzz
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    public final long zza;
    public final long zzb;
    public final boolean zzc;
    public final String zzd;
    public final String zze;
    public final String zzf;
    public final Bundle zzg;
    public final String zzh;

    public zzz(long l, long l2, boolean bl, String string, String string2, String string3, Bundle bundle, String string4) {
        this.zza = l;
        this.zzb = l2;
        this.zzc = bl;
        this.zzd = string;
        this.zze = string2;
        this.zzf = string3;
        this.zzg = bundle;
        this.zzh = string4;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)1, (long)this.zza);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)2, (long)this.zzb);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.zzc);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzd, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)5, (String)this.zze, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)6, (String)this.zzf, (boolean)false);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)7, (Bundle)this.zzg, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)8, (String)this.zzh, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
