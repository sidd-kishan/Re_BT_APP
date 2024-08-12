/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.signin.internal.zab
 */
package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.signin.internal.zab;

public final class zaa
extends AbstractSafeParcelable
implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    final int zaa;
    private int zab;
    private Intent zac;

    public zaa() {
        this(2, 0, null);
    }

    zaa(int n, int n2, Intent intent) {
        this.zaa = n;
        this.zab = n2;
        this.zac = intent;
    }

    public final Status getStatus() {
        if (this.zab != 0) return Status.RESULT_CANCELED;
        return Status.RESULT_SUCCESS;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zab);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, (Parcelable)this.zac, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
