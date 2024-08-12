/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzakc
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzakc;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzakd
extends zzajx {
    public static final Parcelable.Creator<zzakd> CREATOR = new zzakc();
    public final String zza;
    public final byte[] zzb;

    zzakd(Parcel parcel) {
        super("PRIV");
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = (byte[])zzamq.zzd((Object)parcel.createByteArray());
    }

    public zzakd(String string, byte[] byArray) {
        super("PRIV");
        this.zza = string;
        this.zzb = byArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzakd)((Object)object);
        if (!zzamq.zzc((Object)this.zza, (Object)((zzakd)((Object)object)).zza)) return false;
        if (!Arrays.equals(this.zzb, ((zzakd)((Object)object)).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        String string = this.zza;
        int n = string != null ? string.hashCode() : 0;
        return (n + 527) * 31 + Arrays.hashCode(this.zzb);
    }

    public final String toString() {
        String string = this.zzf;
        String string2 = this.zza;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 8 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append(": owner=");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }
}
