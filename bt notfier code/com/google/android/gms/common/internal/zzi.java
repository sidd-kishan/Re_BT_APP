/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.Feature
 *  com.google.android.gms.common.internal.ConnectionTelemetryConfiguration
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zzj
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzj;

public final class zzi
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    Bundle zza;
    Feature[] zzb;
    int zzc;
    ConnectionTelemetryConfiguration zzd;

    public zzi() {
    }

    zzi(Bundle bundle, Feature[] featureArray, int n, ConnectionTelemetryConfiguration connectionTelemetryConfiguration) {
        this.zza = bundle;
        this.zzb = featureArray;
        this.zzc = n;
        this.zzd = connectionTelemetryConfiguration;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBundle((Parcel)parcel, (int)1, (Bundle)this.zza, (boolean)false);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)2, (Parcelable[])this.zzb, (int)n, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)4, (Parcelable)this.zzd, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
