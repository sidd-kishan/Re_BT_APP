/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 *  com.google.android.gms.common.server.response.zam
 *  com.google.android.gms.common.server.response.zap
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class zal
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zap();
    final int zaa;
    final String zab;
    final ArrayList<zam> zac;

    zal(int n, String string, ArrayList<zam> arrayList) {
        this.zaa = n;
        this.zab = string;
        this.zac = arrayList;
    }

    zal(String object, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zaa = 1;
        this.zab = object;
        if (map == null) {
            object = null;
        } else {
            ArrayList<zam> arrayList = new ArrayList<zam>();
            Iterator<String> iterator = map.keySet().iterator();
            while (true) {
                object = arrayList;
                if (!iterator.hasNext()) break;
                object = iterator.next();
                arrayList.add(new zam((String)object, map.get(object)));
            }
        }
        this.zac = object;
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        SafeParcelWriter.writeString((Parcel)parcel, (int)2, (String)this.zab, (boolean)false);
        SafeParcelWriter.writeTypedList((Parcel)parcel, (int)3, this.zac, (boolean)false);
        SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
    }
}
