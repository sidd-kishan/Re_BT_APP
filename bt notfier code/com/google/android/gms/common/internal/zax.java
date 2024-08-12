/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Scope
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zay
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zay;

public final class zax
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zax> CREATOR = new zay();
    final int zaa;
    private final int zab;
    private final int zac;
    @Deprecated
    private final Scope[] zad;

    zax(int n, int n2, int n3, Scope[] scopeArray) {
        this.zaa = n;
        this.zab = n2;
        this.zac = n3;
        this.zad = scopeArray;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zab);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zac);
        SafeParcelWriter.writeTypedArray((Parcel)parcel, (int)4, (Parcelable[])this.zad, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
