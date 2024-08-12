/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  com.google.android.gms.internal.ads.zzbcz
 *  com.google.android.gms.internal.ads.zzbdp
 *  com.google.android.gms.internal.ads.zzdav
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  org.json.JSONException
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzbcz;
import com.google.android.gms.internal.ads.zzbdp;
import com.google.android.gms.internal.ads.zzdav;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;

public final class zzeeh {
    private final List<zzbdp> zza;
    private final Map<String, zzbdp> zzb = Collections.synchronizedMap(new HashMap());
    private zzfac zzc = null;
    private zzezz zzd = null;

    public zzeeh() {
        this.zza = Collections.synchronizedList(new ArrayList());
    }

    public final void zza(zzfac zzfac2) {
        this.zzc = zzfac2;
    }

    public final void zzb(zzezz zzezz2) {
        String string = zzezz2.zzw;
        if (this.zzb.containsKey(string)) {
            return;
        }
        Bundle bundle = new Bundle();
        Iterator iterator = zzezz2.zzv.keys();
        while (true) {
            if (!iterator.hasNext()) {
                zzezz2 = new zzbdp(zzezz2.zzE, 0L, null, bundle);
                this.zza.add((zzbdp)zzezz2);
                this.zzb.put(string, (zzbdp)zzezz2);
                return;
            }
            String string2 = (String)iterator.next();
            try {
                bundle.putString(string2, zzezz2.zzv.getString(string2));
            }
            catch (JSONException jSONException) {
            }
        }
    }

    public final void zzc(zzezz zzezz2, long l, zzbcz zzbcz2) {
        String string = zzezz2.zzw;
        if (!this.zzb.containsKey(string)) {
            return;
        }
        if (this.zzd == null) {
            this.zzd = zzezz2;
        }
        zzezz2 = this.zzb.get(string);
        zzezz2.zzb = l;
        zzezz2.zzc = zzbcz2;
    }

    public final zzdav zzd() {
        return new zzdav(this.zzd, "", this, this.zzc);
    }

    public final List<zzbdp> zze() {
        return this.zza;
    }
}
