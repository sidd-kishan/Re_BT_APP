/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzfjr
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfjr;

public final class zzfjq
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfjq> CREATOR = new zzfjr();
    public final int zza;
    public final String zzb;
    public final String zzc;

    zzfjq(int n, String string, String string2) {
        this.zza = n;
        this.zzb = string;
        this.zzc = string2;
    }

    public zzfjq(String string, String string2) {
        this(1, string, string2);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zzb, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzc, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
