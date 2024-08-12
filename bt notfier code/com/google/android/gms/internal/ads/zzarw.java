/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzarv
 *  com.google.android.gms.internal.ads.zzasa
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzarv;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzave;
import java.util.Arrays;

public final class zzarw
extends zzasa {
    public static final Parcelable.Creator<zzarw> CREATOR = new zzarv();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zzarw(Parcel parcel) {
        super("APIC");
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public zzarw(String string, String string2, int n, byte[] byArray) {
        super("APIC");
        this.zza = string;
        this.zzb = null;
        this.zzc = 3;
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
        object = (zzarw)((Object)object);
        if (this.zzc != ((zzarw)((Object)object)).zzc) return false;
        if (!zzave.zza((Object)this.zza, (Object)((zzarw)((Object)object)).zza)) return false;
        if (!zzave.zza((Object)this.zzb, (Object)((zzarw)((Object)object)).zzb)) return false;
        if (!Arrays.equals(this.zzd, ((zzarw)((Object)object)).zzd)) return false;
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

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }
}
