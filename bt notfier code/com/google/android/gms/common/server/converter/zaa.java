/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.converter.StringToIntConverter
 *  com.google.android.gms.common.server.converter.zab
 *  com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
 */
package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zab;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zaa
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    final int zaa;
    private final StringToIntConverter zab;

    zaa(int n, StringToIntConverter stringToIntConverter) {
        this.zaa = n;
        this.zab = stringToIntConverter;
    }

    private zaa(StringToIntConverter stringToIntConverter) {
        this.zaa = 1;
        this.zab = stringToIntConverter;
    }

    public static zaa zaa(FastJsonResponse.FieldConverter<?, ?> fieldConverter) {
        if (!(fieldConverter instanceof StringToIntConverter)) throw new IllegalArgumentException("Unsupported safe parcelable field converter class.");
        return new zaa((StringToIntConverter)fieldConverter);
    }

    public final void writeToParcel(Parcel parcel, int n) {
        int n2 = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeParcelable((Parcel)parcel, (int)2, (Parcelable)this.zab, (int)n, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n2);
    }

    public final FastJsonResponse.FieldConverter<?, ?> zab() {
        StringToIntConverter stringToIntConverter = this.zab;
        if (stringToIntConverter == null) throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
        return stringToIntConverter;
    }
}
