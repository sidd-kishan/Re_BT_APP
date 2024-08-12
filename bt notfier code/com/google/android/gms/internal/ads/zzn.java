/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzk
 *  com.google.android.gms.internal.ads.zzm
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzk;
import com.google.android.gms.internal.ads.zzm;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class zzn
implements Comparator<zzm>,
Parcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new zzk();
    public final String zza;
    private final zzm[] zzb;
    private int zzc;

    zzn(Parcel zzmArray) {
        this.zza = zzmArray.readString();
        zzmArray = (zzm[])zzamq.zzd((Object)((zzm[])zzmArray.createTypedArray(zzm.CREATOR)));
        this.zzb = zzmArray;
        int n = zzmArray.length;
    }

    private zzn(String zzmArray, boolean bl, zzm ... zzmArray2) {
        this.zza = zzmArray;
        zzmArray = zzmArray2;
        if (bl) {
            zzmArray = (zzm[])zzmArray2.clone();
        }
        this.zzb = zzmArray;
        int n = zzmArray.length;
        Arrays.sort(zzmArray, this);
    }

    public zzn(String string, zzm ... zzmArray) {
        this(null, true, zzmArray);
    }

    public zzn(List<zzm> list) {
        this(null, false, list.toArray(new zzm[0]));
    }

    public final int describeContents() {
        return 0;
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (zzn)object;
        if (!zzamq.zzc((Object)this.zza, (Object)((zzn)object).zza)) return false;
        if (!Arrays.equals(this.zzb, ((zzn)object).zzb)) return false;
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzc;
        if (n != 0) return n2;
        String string = this.zza;
        n2 = string == null ? 0 : string.hashCode();
        this.zzc = n2 = n2 * 31 + Arrays.hashCode(this.zzb);
        return n2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeString(this.zza);
        parcel.writeTypedArray((Parcelable[])this.zzb, 0);
    }

    public final zzn zza(String string) {
        if (!zzamq.zzc((Object)this.zza, (Object)string)) return new zzn(string, false, this.zzb);
        return this;
    }
}
