/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsj
 *  com.google.android.gms.internal.ads.zzbsk
 *  com.google.android.gms.internal.ads.zzbtt
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsj;
import com.google.android.gms.internal.ads.zzbsk;
import com.google.android.gms.internal.ads.zzbtt;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

public final class zzbtu
implements zzbsk,
zzbtt {
    private final zzbtt zza;
    private final HashSet<AbstractMap.SimpleEntry<String, zzbpr<? super zzbtt>>> zzb;

    public zzbtu(zzbtt zzbtt2) {
        this.zza = zzbtt2;
        this.zzb = new HashSet();
    }

    public final void zza(String string) {
        this.zza.zza(string);
    }

    public final void zzbl(String string, String string2) {
        zzbsj.zzb((zzbsk)this, (String)string, (String)string2);
    }

    public final void zzc() {
        Iterator<AbstractMap.SimpleEntry<String, zzbpr<? super zzbtt>>> iterator = this.zzb.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.zzb.clear();
                return;
            }
            AbstractMap.SimpleEntry<String, zzbpr<? super zzbtt>> simpleEntry = iterator.next();
            String string = String.valueOf(simpleEntry.getValue().toString());
            string = string.length() != 0 ? "Unregistering eventhandler: ".concat(string) : new String("Unregistering eventhandler: ");
            zze.zza((String)string);
            this.zza.zzm(simpleEntry.getKey(), simpleEntry.getValue());
        }
    }

    public final void zzd(String string, JSONObject jSONObject) {
        zzbsj.zzc((zzbsk)this, (String)string, (JSONObject)jSONObject);
    }

    public final void zze(String string, Map map) {
        zzbsj.zzd((zzbsk)this, (String)string, (Map)map);
    }

    public final void zzl(String string, zzbpr<? super zzbtt> zzbpr2) {
        this.zza.zzl(string, zzbpr2);
        this.zzb.add(new AbstractMap.SimpleEntry<String, zzbpr<? super zzbtt>>(string, zzbpr2));
    }

    public final void zzm(String string, zzbpr<? super zzbtt> zzbpr2) {
        this.zza.zzm(string, zzbpr2);
        this.zzb.remove(new AbstractMap.SimpleEntry<String, zzbpr<? super zzbtt>>(string, zzbpr2));
    }

    public final void zzr(String string, JSONObject jSONObject) {
        zzbsj.zza((zzbsk)this, (String)string, (JSONObject)jSONObject);
    }
}
