/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.ReflectedParcelable
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.zaa
 */
package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.zaa;

public class FavaDiagnosticsEntity
extends AbstractSafeParcelable
implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new zaa();
    final int zaa;
    public final String zab;
    public final int zac;

    public FavaDiagnosticsEntity(int n, String string, int n2) {
        this.zaa = n;
        this.zab = string;
        this.zac = n2;
    }

    public FavaDiagnosticsEntity(String string, int n) {
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
