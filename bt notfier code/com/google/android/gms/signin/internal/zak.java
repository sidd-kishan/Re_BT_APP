/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zav
 *  com.google.android.gms.signin.internal.zal
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zav;
import com.google.android.gms.signin.internal.zal;

public final class zak
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zal();
    final int zaa;
    private final ConnectionResult zab;
    private final zav zac;

    zak(int n, ConnectionResult connectionResult, zav zav2) {
        this.zaa = n;
        this.zab = connectionResult;
        this.zac = zav2;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zab, (int)n, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zac, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final ConnectionResult zaa() {
        return this.zab;
    }

    public final zav zab() {
        return this.zac;
    }
}
