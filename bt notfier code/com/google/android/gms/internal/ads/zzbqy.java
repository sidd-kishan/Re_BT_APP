/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbqz
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbqz;

public final class zzbqy
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbqy> CREATOR = new zzbqz();
    public final String zza;
    public final String[] zzb;
    public final String[] zzc;

    zzbqy(String string, String[] stringArray, String[] stringArray2) {
        this.zza = string;
        this.zzb = stringArray;
        this.zzc = stringArray2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeStringArray((Parcel)parcel, (int)2, (String[])this.zzb, (boolean)false);
        SafeParcelWriter.writeStringArray((Parcel)parcel, (int)3, (String[])this.zzc, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
