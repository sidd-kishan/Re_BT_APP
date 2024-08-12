/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzarx
 *  com.google.android.gms.internal.ads.zzasa
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzarx;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzave;

public final class zzary
extends zzasa {
    public static final Parcelable.Creator<zzary> CREATOR = new zzarx();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zzary(Parcel parcel) {
        super("COMM");
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public zzary(String string, String string2, String string3) {
        super("COMM");
        this.zza = "und";
        this.zzb = string2;
        this.zzc = string3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzary)((Object)object);
        if (!zzave.zza((Object)this.zzb, (Object)((zzary)((Object)object)).zzb)) return false;
        if (!zzave.zza((Object)this.zza, (Object)((zzary)((Object)object)).zza)) return false;
        if (!zzave.zza((Object)this.zzc, (Object)((zzary)((Object)object)).zzc)) return false;
        return true;
    }

    public final int hashCode() {
        String string = this.zza;
        int n = 0;
        int n2 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzc;
        if (string == null) return ((n2 + 527) * 31 + n3) * 31 + n;
        n = string.hashCode();
        return ((n2 + 527) * 31 + n3) * 31 + n;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }
}
