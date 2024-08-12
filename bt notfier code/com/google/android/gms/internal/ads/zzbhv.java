/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.text.TextUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbhv {
    private final String zza;
    private final Bundle zzb;
    private final String zzc;

    public zzbhv(String string, Bundle bundle, String string2) {
        this.zza = string;
        this.zzb = bundle;
        this.zzc = string2;
    }

    public final String zza() {
        return this.zza;
    }

    public final String zzb() {
        if (TextUtils.isEmpty((CharSequence)this.zzc)) {
            return "";
        }
        try {
            Object object = new JSONObject(this.zzc);
            object = object.optString("request_id", "");
            return object;
        }
        catch (JSONException jSONException) {
            return "";
        }
    }

    public final Bundle zzc() {
        return this.zzb;
    }

    final String zzd() {
        return this.zzc;
    }
}
