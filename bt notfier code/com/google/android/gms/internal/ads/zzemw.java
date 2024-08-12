/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzemv
 *  com.google.android.gms.internal.ads.zzerx
 *  com.google.android.gms.internal.ads.zzery
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzemv;
import com.google.android.gms.internal.ads.zzerx;
import com.google.android.gms.internal.ads.zzery;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

final class zzemw
implements zzery<zzerx<Bundle>> {
    private final Set<String> zza;

    zzemw(Set<String> set) {
        this.zza = set;
    }

    public final zzfsm<zzerx<Bundle>> zza() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<String> iterator = this.zza.iterator();
        while (iterator.hasNext()) {
            arrayList.add(iterator.next());
        }
        return zzfsd.zza((Object)new zzemv(arrayList));
    }
}
