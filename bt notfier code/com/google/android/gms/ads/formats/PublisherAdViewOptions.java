/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.formats.zzf
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbft
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbnx
 *  com.google.android.gms.internal.ads.zzbny
 */
package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.zzf;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbft;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbny;

@Deprecated
public final class PublisherAdViewOptions
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<PublisherAdViewOptions> CREATOR = new zzf();
    private final boolean zza;
    private final zzbfu zzb;
    private final IBinder zzc;

    PublisherAdViewOptions(boolean bl, IBinder object, IBinder iBinder) {
        this.zza = bl;
        object = object != null ? zzbft.zzd((IBinder)object) : null;
        this.zzb = object;
        this.zzc = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)1, (boolean)this.zza);
        Object object = this.zzb;
        object = object == null ? null : object.asBinder();
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)2, (IBinder)object, (boolean)false);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)3, (IBinder)this.zzc, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }

    public final boolean zza() {
        return this.zza;
    }

    public final zzbfu zzb() {
        return this.zzb;
    }

    public final zzbny zzc() {
        IBinder iBinder = this.zzc;
        if (iBinder != null) return zzbnx.zzc((IBinder)iBinder);
        return null;
    }
}
