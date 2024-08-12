/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzblr
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzblr;
import com.google.android.gms.internal.ads.zzfln;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class zzdpa
implements zzfln {
    static final zzfln zza = new zzdpa();

    private zzdpa() {
    }

    public final Object apply(Object arrayList) {
        List list = arrayList;
        arrayList = new ArrayList<List>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            list = (zzblr)iterator.next();
            if (list == null) continue;
            arrayList.add(list);
        }
        return arrayList;
    }
}
