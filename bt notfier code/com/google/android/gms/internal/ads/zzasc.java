/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzasa
 *  com.google.android.gms.internal.ads.zzasb
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzasa;
import com.google.android.gms.internal.ads.zzasb;
import com.google.android.gms.internal.ads.zzave;

public final class zzasc
extends zzasa {
    public static final Parcelable.Creator<zzasc> CREATOR = new zzasb();
    public final String zza;
    public final String zzb;

    zzasc(Parcel parcel) {
        super(parcel.readString());
        this.zza = parcel.readString();
        this.zzb = parcel.readString();
    }

    public zzasc(String string, String string2, String string3) {
        super(string);
        this.zza = null;
        this.zzb = string3;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (((Object)((Object)this)).getClass() != object.getClass()) {
            return false;
        }
        object = (zzasc)((Object)object);
        if (!this.zze.equals(((zzasc)((Object)object)).zze)) return false;
        if (!zzave.zza((Object)this.zza, (Object)((zzasc)((Object)object)).zza)) return false;
        if (!zzave.zza((Object)this.zzb, (Object)((zzasc)((Object)object)).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n = this.zze.hashCode();
        String string = this.zza;
        int n2 = 0;
        int n3 = string != null ? string.hashCode() : 0;
        string = this.zzb;
        if (string == null) return ((n + 527) * 31 + n3) * 31 + n2;
        n2 = string.hashCode();
        return ((n + 527) * 31 + n3) * 31 + n2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zze);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }
}
