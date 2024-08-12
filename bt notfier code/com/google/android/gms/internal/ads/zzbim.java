/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.RequestConfiguration
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbin
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbin;

public final class zzbim
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbim> CREATOR = new zzbin();
    public final int zza;
    public final int zzb;

    public zzbim(int n, int n2) {
        this.zza = n;
        this.zzb = n2;
    }

    public zzbim(RequestConfiguration requestConfiguration) {
        this.zza = requestConfiguration.getTagForChildDirectedTreatment();
        this.zzb = requestConfiguration.getTagForUnderAgeOfConsent();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzb);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
