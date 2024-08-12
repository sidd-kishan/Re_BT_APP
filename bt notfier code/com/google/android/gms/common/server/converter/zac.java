/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.converter.zae
 */
package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zae;

public final class zac
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zae();
    final int zaa;
    final String zab;
    final int zac;

    zac(int n, String string, int n2) {
        this.zaa = n;
        this.zab = string;
        this.zac = n2;
    }

    zac(String string, int n) {
        this.zaa = 1;
        this.zab = string;
        this.zac = n;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zab, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zac);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
