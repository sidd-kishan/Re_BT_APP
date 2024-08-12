/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.Objects$ToStringHelper
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.zzc
 */
package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.zzc;

public class Feature
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new zzc();
    private final String zza;
    @Deprecated
    private final int zzb;
    private final long zzc;

    public Feature(String string, int n, long l) {
        this.zza = string;
        this.zzb = n;
        this.zzc = l;
    }

    public Feature(String string, long l) {
        this.zza = string;
        this.zzc = l;
        this.zzb = -1;
    }

    public final boolean equals(Object object) {
        if (!(object instanceof Feature)) return false;
        object = (Feature)((Object)object);
        if (this.getName() == null || !this.getName().equals(((Feature)((Object)object)).getName())) {
            if (this.getName() != null) return false;
            if (((Feature)((Object)object)).getName() != null) return false;
        }
        if (this.getVersion() != ((Feature)((Object)object)).getVersion()) return false;
        return true;
    }

    public String getName() {
        return this.zza;
    }

    public long getVersion() {
        long l;
        long l2 = l = this.zzc;
        if (l != -1L) return l2;
        l2 = this.zzb;
        return l2;
    }

    public final int hashCode() {
        return Objects.hashCode((Object[])new Object[]{this.getName(), this.getVersion()});
    }

    public final String toString() {
        Objects.ToStringHelper toStringHelper = Objects.toStringHelper((Object)((Object)this));
        toStringHelper.add("name", (Object)this.getName());
        toStringHelper.add("version", (Object)this.getVersion());
        return toStringHelper.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeString((Parcel)parcel, (int)1, (String)this.getName(), (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zzb);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)3, (long)this.getVersion());
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
