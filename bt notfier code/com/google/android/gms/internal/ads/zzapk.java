/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzaph
 *  com.google.android.gms.internal.ads.zzapj
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapj;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public final class zzapk
implements Comparator<zzapj>,
Parcelable {
    public static final Parcelable.Creator<zzapk> CREATOR = new zzaph();
    public final int zza;
    private final zzapj[] zzb;
    private int zzc;

    zzapk(Parcel zzapjArray) {
        zzapjArray = (zzapj[])zzapjArray.createTypedArray(zzapj.CREATOR);
        this.zzb = zzapjArray;
        this.zza = zzapjArray.length;
    }

    public zzapk(List<zzapj> list) {
        this(false, list.toArray(new zzapj[list.size()]));
    }

    private zzapk(boolean bl, zzapj ... object) {
        zzapj[] zzapjArray = object;
        if (bl) {
            zzapjArray = (zzapj[])object.clone();
        }
        Arrays.sort(zzapjArray, this);
        int n = 1;
        while (true) {
            int n2;
            if (n >= (n2 = zzapjArray.length)) {
                this.zzb = zzapjArray;
                this.zza = n2;
                return;
            }
            if (zzapj.zza((zzapj)zzapjArray[n - 1]).equals(zzapj.zza((zzapj)zzapjArray[n]))) {
                object = String.valueOf(zzapj.zza((zzapj)zzapjArray[n]));
                String.valueOf(object).length();
                throw new IllegalArgumentException("Duplicate data for uuid: ".concat(String.valueOf(object)));
            }
            ++n;
        }
    }

    public zzapk(zzapj ... zzapjArray) {
        this(true, zzapjArray);
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
        if (this.getClass() == object.getClass()) return Arrays.equals(this.zzb, ((zzapk)object).zzb);
        return false;
    }

    public final int hashCode() {
        int n;
        int n2 = n = this.zzc;
        if (n != 0) return n2;
        this.zzc = n2 = Arrays.hashCode(this.zzb);
        return n2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeTypedArray((Parcelable[])this.zzb, 0);
    }

    public final zzapj zza(int n) {
        return this.zzb[n];
    }
}
