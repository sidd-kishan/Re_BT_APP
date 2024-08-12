/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzeqz
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONArray
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeqz;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

final class zzeqx
implements Callable {
    private final List zza;

    zzeqx(List list) {
        this.zza = list;
    }

    public final Object call() {
        Object object = this.zza;
        JSONArray jSONArray = new JSONArray();
        object = object.iterator();
        while (true) {
            if (!object.hasNext()) {
                if (jSONArray.length() != 0) return new zzeqz(jSONArray.toString());
                return null;
            }
            zzfsm zzfsm2 = (zzfsm)object.next();
            if ((JSONObject)zzfsm2.get() == null) continue;
            jSONArray.put(zzfsm2.get());
        }
    }
}
