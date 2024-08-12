/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzfdw
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzfdw;
import org.json.JSONObject;

final class zzebf
implements zzfdw {
    static final zzfdw zza = new zzebf();

    private zzebf() {
    }

    public final Object zza(Object object) {
        object = (JSONObject)object;
        zze.zza((String)"Ad request signals:");
        zze.zza((String)object.toString(2));
        return object;
    }
}
