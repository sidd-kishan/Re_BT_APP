/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzerx
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzerx;
import org.json.JSONException;
import org.json.JSONObject;

final class zzeud
implements zzerx {
    static final zzerx zza = new zzeud();

    private zzeud() {
    }

    /*
     * Enabled force condition propagation
     */
    public final void zzf(Object object) {
        object = (JSONObject)object;
        try {
            object.getJSONObject("sdk_env").put("container_version", 12451000);
            return;
        }
        catch (JSONException jSONException) {
            return;
        }
    }
}
