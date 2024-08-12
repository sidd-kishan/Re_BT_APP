/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfgh
 *  com.google.android.gms.internal.ads.zzfgj
 *  com.google.android.gms.internal.ads.zzfgk
 *  com.google.android.gms.internal.ads.zzfhi
 *  com.google.android.gms.internal.ads.zzfhk
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfgh;
import com.google.android.gms.internal.ads.zzfgj;
import com.google.android.gms.internal.ads.zzfgk;
import com.google.android.gms.internal.ads.zzfhi;
import com.google.android.gms.internal.ads.zzfhk;
import org.json.JSONObject;

public final class zzfgd {
    private final zzfgk zza;
    private final zzfgk zzb;
    private final zzfgh zzc;
    private final zzfgj zzd;

    private zzfgd(zzfgh zzfgh2, zzfgj zzfgj2, zzfgk zzfgk2, zzfgk zzfgk3, boolean bl) {
        this.zzc = zzfgh2;
        this.zzd = zzfgj2;
        this.zza = zzfgk2;
        if (zzfgk3 == null) {
            this.zzb = zzfgk.zzc;
            return;
        }
        this.zzb = zzfgk3;
    }

    public static zzfgd zza(zzfgh zzfgh2, zzfgj zzfgj2, zzfgk zzfgk2, zzfgk zzfgk3, boolean bl) {
        zzfhk.zza((Object)zzfgj2, (String)"ImpressionType is null");
        zzfhk.zza((Object)zzfgk2, (String)"Impression owner is null");
        if (zzfgk2 == zzfgk.zzc) throw new IllegalArgumentException("Impression owner is none");
        if (zzfgh2 == zzfgh.zza) {
            if (zzfgk2 == zzfgk.zza) throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        }
        if (zzfgj2 != zzfgj.zza) return new zzfgd(zzfgh2, zzfgj2, zzfgk2, zzfgk3, true);
        if (zzfgk2 == zzfgk.zza) throw new IllegalArgumentException("ImpressionType/CreativeType can only be defined as DEFINED_BY_JAVASCRIPT if Impression Owner is JavaScript");
        return new zzfgd(zzfgh2, zzfgj2, zzfgk2, zzfgk3, true);
    }

    public final JSONObject zzb() {
        JSONObject jSONObject = new JSONObject();
        zzfhi.zzc((JSONObject)jSONObject, (String)"impressionOwner", (Object)this.zza);
        if (this.zzd != null) {
            zzfhi.zzc((JSONObject)jSONObject, (String)"mediaEventsOwner", (Object)this.zzb);
            zzfhi.zzc((JSONObject)jSONObject, (String)"creativeType", (Object)this.zzc);
            zzfhi.zzc((JSONObject)jSONObject, (String)"impressionType", (Object)this.zzd);
        } else {
            zzfhi.zzc((JSONObject)jSONObject, (String)"videoEventsOwner", (Object)this.zzb);
        }
        zzfhi.zzc((JSONObject)jSONObject, (String)"isolateVerificationScripts", (Object)true);
        return jSONObject;
    }
}
