/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzars
 *  com.google.android.gms.internal.ads.zzart
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzars;
import com.google.android.gms.internal.ads.zzart;
import java.util.Arrays;
import java.util.List;

public final class zzaru
implements Parcelable {
    public static final Parcelable.Creator<zzaru> CREATOR = new zzars();
    private final zzart[] zza;

    zzaru(Parcel parcel) {
        zzart[] zzartArray;
        this.zza = new zzart[parcel.readInt()];
        int n = 0;
        while (n < (zzartArray = this.zza).length) {
            zzartArray[n] = (zzart)parcel.readParcelable(zzart.class.getClassLoader());
            ++n;
        }
    }

    public zzaru(List<? extends zzart> list) {
        zzart[] zzartArray = new zzart[list.size()];
        this.zza = zzartArray;
        list.toArray(zzartArray);
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
        object = (zzaru)object;
        return Arrays.equals(this.zza, ((zzaru)object).zza);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeInt(this.zza.length);
        zzart[] zzartArray = this.zza;
        int n2 = zzartArray.length;
        n = 0;
        while (n < n2) {
            parcel.writeParcelable((Parcelable)zzartArray[n], 0);
            ++n;
        }
    }

    public final int zza() {
        return this.zza.length;
    }

    public final zzart zzb(int n) {
        return this.zza[n];
    }
}
