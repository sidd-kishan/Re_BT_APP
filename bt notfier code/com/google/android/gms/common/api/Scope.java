/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.zza
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 */
package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Scope
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zza();
    final int zza;
    private final String zzb;

    Scope(int n, String string) {
        Preconditions.checkNotEmpty((String)string, (Object)"scopeUri must not be null or empty");
        this.zza = n;
        this.zzb = string;
    }

    public Scope(String string) {
        this(1, string);
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object instanceof Scope) return this.zzb.equals(((Scope)((Object)object)).zzb);
        return false;
    }

    public String getScopeUri() {
        return this.zzb;
    }

    public int hashCode() {
        return this.zzb.hashCode();
    }

    public String toString() {
        return this.zzb;
    }

    public void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zza);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.getScopeUri(), (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
