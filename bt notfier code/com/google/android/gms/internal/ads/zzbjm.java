/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbkn
 *  com.google.android.gms.internal.ads.zzbkw
 *  com.google.android.gms.internal.ads.zzblh
 */
package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbkn;
import com.google.android.gms.internal.ads.zzbkw;
import com.google.android.gms.internal.ads.zzblh;
import java.util.ArrayList;
import java.util.List;

public final class zzbjm {
    static List<String> zza() {
        ArrayList<String> arrayList = new ArrayList<String>();
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkn.zzd((String)"gad:dynamite_module:experiment_id", (String)""));
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zza);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzb);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzc);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzd);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zze);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzk);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzf);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzg);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzh);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzi);
        zzbjm.zzc(arrayList, (zzbkn<String>)zzbkw.zzj);
        return arrayList;
    }

    static List<String> zzb() {
        ArrayList<String> arrayList = new ArrayList<String>();
        zzbjm.zzc(arrayList, (zzbkn<String>)zzblh.zza);
        return arrayList;
    }

    private static void zzc(List<String> list, zzbkn<String> object) {
        if (TextUtils.isEmpty(object = (String)object.zze())) return;
        list.add((String)object);
    }
}
