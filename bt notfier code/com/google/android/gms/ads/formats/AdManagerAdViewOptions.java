/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.formats.AdManagerAdViewOptions$Builder
 *  com.google.android.gms.ads.formats.zzb
 *  com.google.android.gms.ads.formats.zzc
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbiq
 *  com.google.android.gms.internal.ads.zzbnx
 *  com.google.android.gms.internal.ads.zzbny
 */
package com.google.android.gms.ads.formats;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.formats.AdManagerAdViewOptions;
import com.google.android.gms.ads.formats.zzb;
import com.google.android.gms.ads.formats.zzc;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbiq;
import com.google.android.gms.internal.ads.zzbnx;
import com.google.android.gms.internal.ads.zzbny;

/*
 * Exception performing whole class analysis ignored.
 */
public final class AdManagerAdViewOptions
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AdManagerAdViewOptions> CREATOR = new zzc();
    private final boolean zza;
    private final IBinder zzb;

    /* synthetic */ AdManagerAdViewOptions(Builder object, zzb zzb2) {
        this.zza = Builder.zza((Builder)object);
        object = Builder.zzb((Builder)object) != null ? new zzbiq(Builder.zzb((Builder)object)) : null;
        this.zzb = object;
    }

    AdManagerAdViewOptions(boolean bl, IBinder iBinder) {
        this.zza = bl;
        this.zzb = iBinder;
    }

    public boolean getManualImpressionsEnabled() {
        return this.zza;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)1, (boolean)this.getManualImpressionsEnabled());
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)2, (IBinder)this.zzb, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }

    public final zzbny zza() {
        IBinder iBinder = this.zzb;
        if (iBinder != null) return zzbnx.zzc((IBinder)iBinder);
        return null;
    }
}
