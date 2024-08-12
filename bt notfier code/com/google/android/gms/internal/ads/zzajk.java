/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajj
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajj;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzajk
extends zzajx {
    public static final Parcelable.Creator<zzajk> CREATOR = new zzajj();
    public final byte[] zza;

    zzajk(Parcel parcel) {
        String string = parcel.readString();
        int n = zzamq.zza;
        super(string);
        this.zza = (byte[])zzamq.zzd((Object)parcel.createByteArray());
    }

    public zzajk(String string, byte[] byArray) {
        super(string);
        this.zza = byArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzajk)((Object)object);
        if (!this.zzf.equals(((zzajk)((Object)object)).zzf)) return false;
        if (!Arrays.equals(this.zza, ((zzajk)((Object)object)).zza)) return false;
        return true;
    }

    public final int hashCode() {
        return (this.zzf.hashCode() + 527) * 31 + Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zzf);
        parcel.writeByteArray(this.zza);
    }
}
