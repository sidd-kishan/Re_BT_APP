/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.ads.internal.util.zzbd
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzfbm
 *  com.google.android.gms.internal.ads.zzfmi
 */
package com.google.android.gms.ads.internal.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzbd;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzfbm;
import com.google.android.gms.internal.ads.zzfmi;

public final class zzbc
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    public final String zza;
    public final int zzb;

    zzbc(String string, int n) {
        String string2 = string;
        if (string == null) {
            string2 = "";
        }
        this.zza = string2;
        this.zzb = n;
    }

    public static zzbc zza(Throwable object) {
        zzbcz zzbcz2 = zzfbm.zza((Throwable)object);
        object = zzfmi.zzc((String)((Throwable)object).getMessage()) ? zzbcz2.zzb : ((Throwable)object).getMessage();
        return new zzbc((String)object, zzbcz2.zza);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.zza, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzb);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
