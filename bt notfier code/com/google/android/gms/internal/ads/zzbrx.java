/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbry
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbry;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbrx
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbrx> CREATOR = new zzbry();
    public final int zza;
    public final int zzb;
    public final String zzc;
    public final int zzd;

    public zzbrx(int n, int n2, String string, int n3) {
        this.zza = n;
        this.zzb = n2;
        this.zzc = string;
        this.zzd = n3;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zzb);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zzc, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzd);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1000, (int)this.zza);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
