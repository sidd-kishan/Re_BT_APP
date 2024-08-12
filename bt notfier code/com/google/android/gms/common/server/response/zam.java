/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 *  com.google.android.gms.common.server.response.zak
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.zak;

public final class zam
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new zak();
    final int zaa;
    final String zab;
    final FastJsonResponse.Field<?, ?> zac;

    zam(int n, String string, FastJsonResponse.Field<?, ?> field) {
        this.zaa = n;
        this.zab = string;
        this.zac = field;
    }

    zam(String string, FastJsonResponse.Field<?, ?> field) {
        this.zaa = 1;
        this.zab = string;
        this.zac = field;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zab, (boolean)false);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)3, this.zac, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }
}
