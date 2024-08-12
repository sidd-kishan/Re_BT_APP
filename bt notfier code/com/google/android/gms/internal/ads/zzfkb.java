/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzfkc
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzfkc;
import java.util.Arrays;

public final class zzfkb
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfkb> CREATOR = new zzfkc();
    public final int zza;
    public final byte[] zzb;
    public final int zzc;

    zzfkb(int n, byte[] object, int n2) {
        this.zza = n;
        object = object == null ? null : Arrays.copyOf(object, ((byte[])object).length);
        this.zzb = object;
        this.zzc = n2;
    }

    public zzfkb(byte[] byArray, int n) {
        this(1, null, 1);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeByteArray((Parcel)parcel, (int)2, (byte[])this.zzb, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
