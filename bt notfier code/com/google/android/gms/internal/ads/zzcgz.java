/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzcha
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzcha;

public final class zzcgz
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcgz> CREATOR = new zzcha();
    public String zza;
    public int zzb;
    public int zzc;
    public boolean zzd;
    public boolean zze;

    public zzcgz(int n, int n2, boolean bl, boolean bl2) {
        this(213806000, n2, true, false, false);
    }

    public zzcgz(int n, int n2, boolean bl, boolean bl2, boolean bl3) {
        String string = bl ? "0" : "1";
        StringBuilder stringBuilder = new StringBuilder(string.length() + 36);
        stringBuilder.append("afma-sdk-a-v");
        stringBuilder.append(n);
        stringBuilder.append(".");
        stringBuilder.append(n2);
        stringBuilder.append(".");
        stringBuilder.append(string);
        this(stringBuilder.toString(), n, n2, bl, false);
    }

    zzcgz(String string, int n, int n2, boolean bl, boolean bl2) {
        this.zza = string;
        this.zzb = n;
        this.zzc = n2;
        this.zzd = bl;
        this.zze = bl2;
    }

    public static zzcgz zza() {
        return new zzcgz(12451000, 12451000, true, false, false);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzb);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)4, (int)this.zzc);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zzd);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)6, (boolean)this.zze);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
