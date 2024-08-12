/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzait
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzamq
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzait;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzamq;
import java.util.Arrays;
import java.util.List;

public final class zzaiv
implements Parcelable {
    public static final Parcelable.Creator<zzaiv> CREATOR = new zzait();
    private final zzaiu[] zza;

    zzaiv(Parcel parcel) {
        zzaiu[] zzaiuArray;
        this.zza = new zzaiu[parcel.readInt()];
        int n = 0;
        while (n < (zzaiuArray = this.zza).length) {
            zzaiuArray[n] = (zzaiu)parcel.readParcelable(zzaiu.class.getClassLoader());
            ++n;
        }
    }

    public zzaiv(List<? extends zzaiu> list) {
        this.zza = list.toArray(new zzaiu[0]);
    }

    public zzaiv(zzaiu ... zzaiuArray) {
        this.zza = zzaiuArray;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzaiv)object;
        return Arrays.equals(this.zza, ((zzaiv)object).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        String string = String.valueOf(Arrays.toString(this.zza));
        string = string.length() != 0 ? "entries=".concat(string) : new String("entries=");
        return string;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.zza.length);
        zzaiu[] zzaiuArray = this.zza;
        int n2 = zzaiuArray.length;
        n = 0;
        while (n < n2) {
            parcel.writeParcelable((Parcelable)zzaiuArray[n], 0);
            ++n;
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzaiu zzb(int n) {
        return this.zza[n];
    }

    public final zzaiv zzc(zzaiv zzaiv2) {
        if (zzaiv2 != null) return this.zzd(zzaiv2.zza);
        return this;
    }

    public final zzaiv zzd(zzaiu ... zzaiuArray) {
        if (zzaiuArray.length != 0) return new zzaiv((zzaiu[])zzamq.zzg((Object[])this.zza, (Object[])zzaiuArray));
        return this;
    }
}
