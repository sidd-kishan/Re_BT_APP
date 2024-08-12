/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.util.SparseArray
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.converter.zac
 *  com.google.android.gms.common.server.converter.zad
 *  com.google.android.gms.common.server.response.FastJsonResponse$FieldConverter
 */
package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zac;
import com.google.android.gms.common.server.converter.zad;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter
extends AbstractSafeParcelable
implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zad();
    final int zaa;
    private final HashMap<String, Integer> zab;
    private final SparseArray<String> zac;

    public StringToIntConverter() {
        this.zaa = 1;
        this.zab = new HashMap();
        this.zac = new SparseArray();
    }

    StringToIntConverter(int n, ArrayList<zac> arrayList) {
        this.zaa = n;
        this.zab = new HashMap();
        this.zac = new SparseArray();
        int n2 = arrayList.size();
        n = 0;
        while (n < n2) {
            zac zac2 = (zac)arrayList.get(n);
            this.add(zac2.zab, zac2.zac);
            ++n;
        }
    }

    public StringToIntConverter add(String string, int n) {
        this.zab.put(string, n);
        this.zac.put(n, (Object)string);
        return this;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        ArrayList<zac> arrayList = new ArrayList<zac>();
        Iterator<String> iterator = this.zab.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                SafeParcelWriter.writeTypedList((Parcel)parcel, (int)2, arrayList, (boolean)false);
                SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
                return;
            }
            String string = iterator.next();
            arrayList.add(new zac(string, this.zab.get(string).intValue()));
        }
    }

    public final int zaa() {
        return 7;
    }

    public final int zab() {
        return 0;
    }
}
