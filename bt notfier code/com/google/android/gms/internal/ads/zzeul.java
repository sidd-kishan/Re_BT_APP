/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  com.google.android.gms.ads.internal.util.zzck
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzeun
 */
package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzck;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzeun;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

final class zzeul
implements Callable {
    static final Callable zza = new zzeul();

    private zzeul() {
    }

    public final Object call() {
        HashMap<Object, List> hashMap = new HashMap<Object, List>();
        Object object = zzbjl.zzF;
        object = (String)zzbet.zzc().zzc((zzbjd)object);
        if (object == null) return new zzeun(hashMap);
        if (((String)object).isEmpty()) return new zzeun(hashMap);
        int n = Build.VERSION.SDK_INT;
        String[] stringArray = zzbjl.zzG;
        if (n < (Integer)zzbet.zzc().zzc((zzbjd)stringArray)) return new zzeun(hashMap);
        stringArray = ((String)object).split(",", -1);
        int n2 = stringArray.length;
        n = 0;
        while (n < n2) {
            object = stringArray[n];
            hashMap.put(object, zzck.zza((String)object));
            ++n;
        }
        return new zzeun(hashMap);
    }
}
