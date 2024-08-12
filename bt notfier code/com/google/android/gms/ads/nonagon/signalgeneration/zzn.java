/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzfln
 *  org.json.JSONObject
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzfln;
import org.json.JSONObject;

final class zzn
implements zzfln {
    static final zzfln zza = new zzn();

    private zzn() {
    }

    public final Object apply(Object object) {
        object = (JSONObject)object;
        int n = zzv.zze;
        return object.optString("nas");
    }
}
