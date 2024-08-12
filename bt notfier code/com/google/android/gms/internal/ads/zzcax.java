/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.internal.ads.zzcay
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.ads.zzcay;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzcax
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcax> CREATOR = new zzcay();
    public final boolean zza;
    public final List<String> zzb;

    public zzcax() {
        this(false, Collections.emptyList());
    }

    public zzcax(boolean bl, List<String> list) {
        this.zza = bl;
        this.zzb = list;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)2, (boolean)this.zza);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)3, this.zzb, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
