/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.RootTelemetryConfiguration
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zzk
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzk;

public class ConnectionTelemetryConfiguration
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ConnectionTelemetryConfiguration> CREATOR = new zzk();
    private final RootTelemetryConfiguration zza;
    private final boolean zzb;
    private final boolean zzc;
    private final int[] zzd;
    private final int zze;
    private final int[] zzf;

    public ConnectionTelemetryConfiguration(RootTelemetryConfiguration rootTelemetryConfiguration, boolean bl, boolean bl2, int[] nArray, int n, int[] nArray2) {
        this.zza = rootTelemetryConfiguration;
        this.zzb = bl;
        this.zzc = bl2;
        this.zzd = nArray;
        this.zze = n;
        this.zzf = nArray2;
    }

    public int getMaxMethodInvocationsLogged() {
        return this.zze;
    }

    public int[] getMethodInvocationMethodKeyAllowlist() {
        return this.zzd;
    }

    public int[] getMethodInvocationMethodKeyDisallowlist() {
        return this.zzf;
    }

    public boolean getMethodInvocationTelemetryEnabled() {
        return this.zzb;
    }

    public boolean getMethodTimingTelemetryEnabled() {
        return this.zzc;
    }

    public RootTelemetryConfiguration getRootTelemetryConfiguration() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)1, (Parcelable)this.getRootTelemetryConfiguration(), (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.getMethodInvocationTelemetryEnabled());
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.getMethodTimingTelemetryEnabled());
        SafeParcelWriter.writeIntArray((Parcel)parcel, (int)4, (int[])this.getMethodInvocationMethodKeyAllowlist(), (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)5, (int)this.getMaxMethodInvocationsLogged());
        SafeParcelWriter.writeIntArray((Parcel)parcel, (int)6, (int[])this.getMethodInvocationMethodKeyDisallowlist(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
