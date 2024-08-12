/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.VideoOptions
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbit
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbit;

public final class zzbis
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbis> CREATOR = new zzbit();
    public final boolean zza;
    public final boolean zzb;
    public final boolean zzc;

    public zzbis(VideoOptions videoOptions) {
        this(videoOptions.getStartMuted(), videoOptions.getCustomControlsRequested(), videoOptions.getClickToExpandRequested());
    }

    public zzbis(boolean bl, boolean bl2, boolean bl3) {
        this.zza = bl;
        this.zzb = bl2;
        this.zzc = bl3;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.zza);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)3, (boolean)this.zzb);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)4, (boolean)this.zzc);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
