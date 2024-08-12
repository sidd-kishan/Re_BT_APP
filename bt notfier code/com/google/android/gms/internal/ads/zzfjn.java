/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzfjo
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfjo;

public final class zzfjn
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfjn> CREATOR = new zzfjo();
    public final int zza;
    public final byte[] zzb;

    zzfjn(int n, byte[] byArray) {
        this.zza = n;
        this.zzb = byArray;
    }

    public zzfjn(byte[] byArray) {
        this(1, byArray);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeByteArray((Parcel)parcel, (int)2, (byte[])this.zzb, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
