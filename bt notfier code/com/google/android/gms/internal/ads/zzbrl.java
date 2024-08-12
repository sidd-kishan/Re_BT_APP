/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbrm
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbrm;

public final class zzbrl
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbrl> CREATOR = new zzbrm();
    public final String zza;
    public final boolean zzb;
    public final int zzc;
    public final String zzd;

    public zzbrl(String string, boolean bl, int n, String string2) {
        this.zza = string;
        this.zzb = bl;
        this.zzc = n;
        this.zzd = string2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.zzb);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.writeString((Parcel)parcel, (int)4, (String)this.zzd, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
