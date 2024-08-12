/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzdpp
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdpp;
import com.google.android.gms.internal.ads.zzfln;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzdpn
implements zzfln {
    static final zzfln zza = new zzdpn();

    private zzdpn() {
    }

    public final Object apply(Object arrayList) {
        List list = arrayList;
        arrayList = new ArrayList<List>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list = (zzdpp)iterator.next();
            if (list == null) continue;
            arrayList.add(list);
        }
        return arrayList;
    }
}
