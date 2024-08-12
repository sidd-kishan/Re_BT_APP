/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzajh
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzajh;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzaji
extends zzajx {
    public static final Parcelable.Creator<zzaji> CREATOR = new zzajh();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zzaji(Parcel parcel) {
        super("APIC");
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = (byte[])zzamq.zzd((Object)parcel.createByteArray());
    }

    public zzaji(String string, String string2, int n, byte[] byArray) {
        super("APIC");
        this.zza = string;
        this.zzb = string2;
        this.zzc = n;
        this.zzd = byArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzaji)((Object)object);
        if (this.zzc != ((zzaji)((Object)object)).zzc) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzaji)((Object)object)).zza)) return false;
        if (!zzamq.zzc((Object)this.zzb, (Object)((zzaji)((Object)object)).zzb)) return false;
        if (!Arrays.equals(this.zzd, ((zzaji)((Object)object)).zzd)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzc;
        String string = this.zza;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        if (string == null) return (((n + 527) * 31 + n3) * 31 + n2) * 31 + Arrays.hashCode(this.zzd);
        n2 = string.hashCode();
        return (((n + 527) * 31 + n3) * 31 + n2) * 31 + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        String string = this.zzf;
        String string2 = this.zza;
        String string3 = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 25 + String.valueOf(string2).length() + String.valueOf(string3).length());
        stringBuilder.append(string);
        stringBuilder.append(": mimeType=");
        stringBuilder.append(string2);
        stringBuilder.append(", description=");
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzagm zzagm2) {
        zzagm2.zzx(this.zzd, this.zzc);
    }
}
