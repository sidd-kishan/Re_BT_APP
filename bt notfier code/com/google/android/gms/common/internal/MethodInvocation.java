/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.internal.zan
 */
package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zan;

public class MethodInvocation
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new zan();
    private final int zaa;
    private final int zab;
    private final int zac;
    private final long zad;
    private final long zae;
    private final String zaf;
    private final String zag;
    private final int zah;

    public MethodInvocation(int n, int n2, int n3, long l, long l2, String string, String string2, int n4) {
        this.zaa = n;
        this.zab = n2;
        this.zac = n3;
        this.zad = l;
        this.zae = l2;
        this.zaf = string;
        this.zag = string2;
        this.zah = n4;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)2, (int)this.zab);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)3, (int)this.zac);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)4, (long)this.zad);
        SafeParcelWriter.writeLong((Parcel)parcel, (int)5, (long)this.zae);
        SafeParcelWriter.writeString((Parcel)parcel, (int)6, (String)this.zaf, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)7, (String)this.zag, (boolean)false);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)8, (int)this.zah);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
