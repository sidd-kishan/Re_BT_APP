/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.MethodInvocation
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zaab
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zaab;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

public class TelemetryData
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new zaab();
    private final int zaa;
    @Nullable
    private List<MethodInvocation> zab;

    public TelemetryData(int n, @Nullable List<MethodInvocation> list) {
        this.zaa = n;
        this.zab = list;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeTypedList((Parcel)parcel, (int)2, this.zab, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }

    public final int zaa() {
        return this.zaa;
    }

    public final List<MethodInvocation> zab() {
        return this.zab;
    }

    public final void zac(MethodInvocation methodInvocation) {
        if (this.zab == null) {
            this.zab = new ArrayList<MethodInvocation>();
        }
        this.zab.add(methodInvocation);
    }
}
