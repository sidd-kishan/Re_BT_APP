/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.internal.ads.zzagm
 *  com.google.android.gms.internal.ads.zzaiu
 *  com.google.android.gms.internal.ads.zzako
 *  com.google.android.gms.internal.ads.zzakp
 */
package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.ads.zzagm;
import com.google.android.gms.internal.ads.zzaiu;
import com.google.android.gms.internal.ads.zzako;
import com.google.android.gms.internal.ads.zzakp;

public final class zzakq
implements zzaiu {
    public static final Parcelable.Creator<zzakq> CREATOR = new zzako();
    public final float zza;
    public final int zzb;

    public zzakq(float f, int n) {
        this.zza = f;
        this.zzb = n;
    }

    /* synthetic */ zzakq(Parcel parcel, zzakp zzakp2) {
        this.zza = parcel.readFloat();
        this.zzb = parcel.readInt();
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
        object = (zzakq)object;
        if (this.zza != ((zzakq)object).zza) return false;
        if (this.zzb != ((zzakq)object).zzb) return false;
        return true;
    }

    public final int hashCode() {
        return (Float.valueOf(this.zza).hashCode() + 527) * 31 + this.zzb;
    }

    public final String toString() {
        float f = this.zza;
        int n = this.zzb;
        StringBuilder stringBuilder = new StringBuilder(73);
        stringBuilder.append("smta: captureFrameRate=");
        stringBuilder.append(f);
        stringBuilder.append(", svcTemporalLayerCount=");
        stringBuilder.append(n);
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        parcel.writeFloat(this.zza);
        parcel.writeInt(this.zzb);
    }

    public final void zza(zzagm zzagm2) {
    }
}
