/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbcy
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbcy;

public final class zzbcx
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbcx> CREATOR = new zzbcy();
    public final String zza;
    public final String zzb;

    public zzbcx(String string, String string2) {
        this.zza = string;
        this.zzb = string2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zzb, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
