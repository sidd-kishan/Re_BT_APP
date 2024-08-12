/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzfaa
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzfaa;
import java.util.ArrayList;
import java.util.List;

public final class zzfav {
    public static zzfaa zza(List<zzfaa> list, zzfaa zzfaa2) {
        return list.get(0);
    }

    public static zzbdl zzb(Context context, List<zzfaa> object) {
        ArrayList<AdSize> arrayList = new ArrayList<AdSize>();
        object = object.iterator();
        while (object.hasNext()) {
            zzfaa zzfaa2 = (zzfaa)object.next();
            if (zzfaa2.zzc) {
                arrayList.add(AdSize.FLUID);
                continue;
            }
            arrayList.add(new AdSize(zzfaa2.zza, zzfaa2.zzb));
        }
        return new zzbdl(context, arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzfaa zzc(zzbdl zzbdl2) {
        if (!zzbdl2.zzi) return new zzfaa(zzbdl2.zze, zzbdl2.zzb, false);
        return new zzfaa(-3, 0, true);
    }
}
