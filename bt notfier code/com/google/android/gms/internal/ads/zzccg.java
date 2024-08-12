/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzcch
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzcch;

public final class zzccg
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzccg> CREATOR = new zzcch();
    public final zzbdg zza;
    public final String zzb;

    public zzccg(zzbdg zzbdg2, String string) {
        this.zza = zzbdg2;
        this.zzb = string;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zza, (int)n, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zzb, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
