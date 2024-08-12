/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbty
 *  com.google.android.gms.internal.ads.zzbua
 *  com.google.android.gms.internal.ads.zzbub
 *  com.google.android.gms.internal.ads.zzbuc
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbty;
import com.google.android.gms.internal.ads.zzbua;
import com.google.android.gms.internal.ads.zzbub;
import com.google.android.gms.internal.ads.zzbuc;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbud {
    public static final zzbua<JSONObject> zza;
    public static final zzbty<InputStream> zzb;
    private static final Charset zzc;

    static {
        zzc = Charset.forName("UTF-8");
        zza = new zzbuc();
        zzb = zzbub.zza;
    }

    static final /* synthetic */ InputStream zza(JSONObject jSONObject) throws JSONException {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(zzc));
    }
}
