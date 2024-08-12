/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzajn
 *  com.google.android.gms.internal.ads.zzajx
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzajn;
import com.google.android.gms.internal.ads.zzajx;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;

public final class zzajo
extends zzajx {
    public static final Parcelable.Creator<zzajo> CREATOR = new zzajn();
    public final String zza;
    public final boolean zzb;
    public final boolean zzc;
    public final String[] zzd;
    private final zzajx[] zze;

    zzajo(Parcel parcel) {
        super("CTOC");
        String string = parcel.readString();
        int n = zzamq.zza;
        this.zza = string;
        int n2 = parcel.readByte();
        boolean bl = true;
        n = 0;
        boolean bl2 = n2 != 0;
        this.zzb = bl2;
        bl2 = parcel.readByte() != 0 ? bl : false;
        this.zzc = bl2;
        this.zzd = (String[])zzamq.zzd((Object)parcel.createStringArray());
        n2 = parcel.readInt();
        this.zze = new zzajx[n2];
        while (n < n2) {
            this.zze[n] = (zzajx)parcel.readParcelable(zzajx.class.getClassLoader());
            ++n;
        }
    }

    public zzajo(String string, boolean bl, boolean bl2, String[] stringArray, zzajx[] zzajxArray) {
        super("CTOC");
        this.zza = string;
        this.zzb = bl;
        this.zzc = bl2;
        this.zzd = stringArray;
        this.zze = zzajxArray;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzajo)((Object)object);
        if (this.zzb != ((zzajo)((Object)object)).zzb) return false;
        if (this.zzc != ((zzajo)((Object)object)).zzc) return false;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzajo)((Object)object)).zza)) return false;
        if (!Arrays.equals(this.zzd, ((zzajo)((Object)object)).zzd)) return false;
        if (!Arrays.equals(this.zze, ((zzajo)((Object)object)).zze)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zzb;
        int n2 = this.zzc;
        String string = this.zza;
        int n3 = string != null ? string.hashCode() : 0;
        return ((n + 527) * 31 + n2) * 31 + n3;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeByte((byte)(this.zzb ? 1 : 0));
        parcel.writeByte((byte)(this.zzc ? 1 : 0));
        parcel.writeStringArray(this.zzd);
        parcel.writeInt(this.zze.length);
        zzajx[] zzajxArray = this.zze;
        int n2 = zzajxArray.length;
        n = 0;
        while (n < n2) {
            parcel.writeParcelable((Parcelable)zzajxArray[n], 0);
            ++n;
        }
    }
}
