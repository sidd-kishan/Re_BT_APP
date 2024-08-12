/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.api.Result
 *  com.google.android.gms.common.api.Status
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.signin.internal.zah
 */
package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.signin.internal.zah;
import java.util.List;

public final class zag
extends AbstractSafeParcelable
implements Result {
    public static final Parcelable.Creator<zag> CREATOR = new zah();
    private final List<String> zaa;
    private final String zab;

    public zag(List<String> list, String string) {
        this.zaa = list;
        this.zab = string;
    }

    public final Status getStatus() {
        if (this.zab == null) return Status.RESULT_CANCELED;
        return Status.RESULT_SUCCESS;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeStringList((Parcel)parcel, (int)1, this.zaa, (boolean)false);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zab, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
