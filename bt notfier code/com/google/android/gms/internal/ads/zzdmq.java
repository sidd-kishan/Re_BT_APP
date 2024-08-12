/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zzbx
 *  com.google.android.gms.internal.ads.zzdmr
 *  com.google.android.gms.internal.ads.zzezz
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbx;
import com.google.android.gms.internal.ads.zzdmr;
import com.google.android.gms.internal.ads.zzezz;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzdmq
extends zzdmr {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;

    public zzdmq(zzezz zzezz2, JSONObject jSONObject) {
        super(zzezz2);
        this.zzb = zzbx.zzh((JSONObject)jSONObject, (String[])new String[]{"tracking_urls_and_actions", "active_view"});
        boolean bl = false;
        this.zzc = zzbx.zzi((boolean)false, (JSONObject)jSONObject, (String[])new String[]{"allow_pub_owned_ad_view"});
        this.zzd = zzbx.zzi((boolean)false, (JSONObject)jSONObject, (String[])new String[]{"attribution", "allow_pub_rendering"});
        this.zze = zzbx.zzi((boolean)false, (JSONObject)jSONObject, (String[])new String[]{"enable_omid"});
        this.zzg = zzbx.zzj((String)"", (JSONObject)jSONObject, (String[])new String[]{"watermark_overlay_png_base64"});
        if (jSONObject.optJSONObject("overlay") != null) {
            bl = true;
        }
        this.zzf = bl;
    }

    public final JSONObject zza() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            jSONObject = new JSONObject(this.zza.zzz);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            return null;
        }
    }

    public final boolean zzb() {
        return this.zzf;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzd;
    }

    public final String zzf() {
        return this.zzg;
    }
}
