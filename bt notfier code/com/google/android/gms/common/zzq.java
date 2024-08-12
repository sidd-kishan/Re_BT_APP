/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.zzp
 *  com.google.android.gms.common.zzr
 */
package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.zzp;
import com.google.android.gms.common.zzr;
import javax.annotation.Nullable;

public final class zzq
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    private final boolean zza;
    @Nullable
    private final String zzb;
    private final int zzc;

    zzq(boolean bl, String string, int n) {
        this.zza = bl;
        this.zzb = string;
        this.zzc = zzp.zza((int)n) - 1;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)1, (boolean)this.zza);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zzb, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zzc);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }

    public final boolean zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return zzp.zza((int)this.zzc);
    }
}
