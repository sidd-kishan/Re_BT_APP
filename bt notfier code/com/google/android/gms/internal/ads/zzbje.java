/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.SharedPreferences$Editor
 *  android.text.TextUtils
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjm
 *  com.google.android.gms.internal.ads.zzcgt
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjm;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public final class zzbje {
    private final Collection<zzbjd<?>> zza = new ArrayList();
    private final Collection<zzbjd<String>> zzb = new ArrayList<zzbjd<String>>();
    private final Collection<zzbjd<String>> zzc = new ArrayList<zzbjd<String>>();

    public final void zza(zzbjd zzbjd2) {
        this.zza.add(zzbjd2);
    }

    public final void zzb(zzbjd<String> zzbjd2) {
        this.zzb.add(zzbjd2);
    }

    public final void zzc(SharedPreferences.Editor editor, int n, JSONObject jSONObject) {
        for (zzbjd<?> zzbjd2 : this.zza) {
            if (zzbjd2.zzm() != 1) continue;
            zzbjd2.zzb(editor, zzbjd2.zzc(jSONObject));
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
            return;
        }
        zzcgt.zzf((String)"Flag Json is null.");
    }

    public final List<String> zzd() {
        ArrayList<String> arrayList = new ArrayList<String>();
        Iterator<zzbjd<String>> iterator = this.zzb.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                arrayList.addAll(zzbjm.zza());
                return arrayList;
            }
            Object object = iterator.next();
            object = (String)zzbet.zzc().zzc(object);
            if (TextUtils.isEmpty(object)) continue;
            arrayList.add((String)object);
        }
    }

    public final List<String> zze() {
        List<String> list = this.zzd();
        Iterator<zzbjd<String>> iterator = this.zzc.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                list.addAll(zzbjm.zzb());
                return list;
            }
            Object object = iterator.next();
            object = (String)zzbet.zzc().zzc(object);
            if (TextUtils.isEmpty(object)) continue;
            list.add((String)object);
        }
    }
}
