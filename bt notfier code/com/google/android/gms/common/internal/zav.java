/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.ConnectionResult
 *  com.google.android.gms.common.internal.IAccountAccessor
 *  com.google.android.gms.common.internal.IAccountAccessor$Stub
 *  com.google.android.gms.common.internal.Objects
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zaw
 */
package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zaw;

public final class zav
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zav> CREATOR = new zaw();
    final int zaa;
    final IBinder zab;
    private final ConnectionResult zac;
    private final boolean zad;
    private final boolean zae;

    zav(int n, IBinder iBinder, ConnectionResult connectionResult, boolean bl, boolean bl2) {
        this.zaa = n;
        this.zab = iBinder;
        this.zac = connectionResult;
        this.zad = bl;
        this.zae = bl2;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (!(object instanceof zav)) {
            return false;
        }
        object = (zav)((Object)object);
        if (!this.zac.equals((Object)((zav)((Object)object)).zac)) return false;
        if (!Objects.equal((Object)this.zaa(), (Object)((zav)((Object)object)).zaa())) return false;
        return true;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeIBinder((Parcel)parcel, (int)2, (IBinder)this.zab, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zac, (int)n, (boolean)false);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)4, (boolean)this.zad);
        SafeParcelWriter.writeBoolean((Parcel)parcel, (int)5, (boolean)this.zae);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final IAccountAccessor zaa() {
        IBinder iBinder = this.zab;
        if (iBinder != null) return IAccountAccessor.Stub.asInterface((IBinder)iBinder);
        return null;
    }

    public final ConnectionResult zab() {
        return this.zac;
    }

    public final boolean zac() {
        return this.zad;
    }

    public final boolean zad() {
        return this.zae;
    }
}
