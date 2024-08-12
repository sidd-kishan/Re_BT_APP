/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbpr
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbpr;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzboq
implements zzbpr<Object> {
    private final zzbor zza;

    public zzboq(zzbor zzbor2) {
        this.zza = zzbor2;
    }

    public final void zza(Object object, Map<String, String> map) {
        if (this.zza == null) {
            return;
        }
        String string = map.get("name");
        object = string;
        if (string == null) {
            zze.zzh((String)"Ad metadata with no name parameter.");
            object = "";
        }
        boolean bl = map.containsKey("info");
        Object var5_6 = null;
        string = var5_6;
        if (bl) {
            try {
                string = new JSONObject(map.get("info"));
                string = zzbx.zzk((JSONObject)string);
            }
            catch (JSONException jSONException) {
                zze.zzg((String)"Failed to convert ad metadata to JSON.", (Throwable)jSONException);
                string = var5_6;
            }
        }
        if (string == null) {
            zze.zzf((String)"Failed to convert ad metadata to Bundle.");
            return;
        }
        this.zza.zza((String)object, (Bundle)string);
    }
}
