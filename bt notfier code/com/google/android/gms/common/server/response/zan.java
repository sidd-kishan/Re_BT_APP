/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable
 *  com.google.android.gms.common.internal.safeparcel.SafeParcelWriter
 *  com.google.android.gms.common.server.response.FastJsonResponse
 *  com.google.android.gms.common.server.response.FastJsonResponse$Field
 *  com.google.android.gms.common.server.response.zal
 *  com.google.android.gms.common.server.response.zam
 *  com.google.android.gms.common.server.response.zao
 */
package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import com.google.android.gms.common.server.response.zao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zan
extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new zao();
    final int zaa;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zab;
    private final String zac;

    zan(int n, ArrayList<zal> arrayList, String string) {
        this.zaa = n;
        HashMap hashMap = new HashMap();
        int n2 = arrayList.size();
        n = 0;
        while (true) {
            if (n >= n2) {
                this.zab = hashMap;
                this.zac = (String)Preconditions.checkNotNull((Object)string);
                this.zaa();
                return;
            }
            zal zal2 = arrayList.get(n);
            String string2 = zal2.zab;
            HashMap<String, FastJsonResponse.Field> hashMap2 = new HashMap<String, FastJsonResponse.Field>();
            int n3 = ((ArrayList)Preconditions.checkNotNull((Object)zal2.zac)).size();
            for (int i = 0; i < n3; ++i) {
                zam zam2 = (zam)zal2.zac.get(i);
                hashMap2.put(zam2.zab, zam2.zac);
            }
            hashMap.put(string2, hashMap2);
            ++n;
        }
    }

    public zan(Class<? extends FastJsonResponse> clazz) {
        this.zaa = 1;
        this.zab = new HashMap();
        this.zac = (String)Preconditions.checkNotNull((Object)clazz.getCanonicalName());
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<String> iterator = this.zab.keySet().iterator();
        block0: while (iterator.hasNext()) {
            String string = iterator.next();
            stringBuilder.append(string);
            stringBuilder.append(":\n");
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zab.get(string);
            Iterator<String> iterator2 = map.keySet().iterator();
            while (true) {
                if (!iterator2.hasNext()) continue block0;
                string = iterator2.next();
                stringBuilder.append("  ");
                stringBuilder.append(string);
                stringBuilder.append(": ");
                stringBuilder.append(map.get(string));
            }
            break;
        }
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n) {
        n = SafeParcelWriter.beginObjectHeader((Parcel)parcel);
        SafeParcelWriter.writeInt((Parcel)parcel, (int)1, (int)this.zaa);
        ArrayList<zal> arrayList = new ArrayList<zal>();
        Iterator<String> iterator = this.zab.keySet().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                SafeParcelWriter.writeTypedList((Parcel)parcel, (int)2, arrayList, (boolean)false);
                SafeParcelWriter.writeString((Parcel)parcel, (int)3, (String)this.zac, (boolean)false);
                SafeParcelWriter.finishObjectHeader((Parcel)parcel, (int)n);
                return;
            }
            String string = iterator.next();
            arrayList.add(new zal(string, this.zab.get(string)));
        }
    }

    public final void zaa() {
        Iterator<String> iterator = this.zab.keySet().iterator();
        block0: while (iterator.hasNext()) {
            Object object = iterator.next();
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zab.get(object);
            object = map.keySet().iterator();
            while (true) {
                if (!object.hasNext()) continue block0;
                map.get((String)object.next()).zad(this);
            }
            break;
        }
        return;
    }

    public final void zab() {
        Iterator<String> iterator = this.zab.keySet().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            Map<String, FastJsonResponse.Field<?, ?>> map = this.zab.get(string);
            HashMap<String, FastJsonResponse.Field> hashMap = new HashMap<String, FastJsonResponse.Field>();
            for (String string2 : map.keySet()) {
                hashMap.put(string2, map.get(string2).zaa());
            }
            this.zab.put(string, hashMap);
        }
    }

    public final void zac(Class<? extends FastJsonResponse> clazz, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zab.put((String)Preconditions.checkNotNull((Object)clazz.getCanonicalName()), map);
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zad(String string) {
        return this.zab.get(string);
    }

    public final boolean zae(Class<? extends FastJsonResponse> clazz) {
        return this.zab.containsKey(Preconditions.checkNotNull((Object)clazz.getCanonicalName()));
    }

    public final String zaf() {
        return this.zac;
    }
}
