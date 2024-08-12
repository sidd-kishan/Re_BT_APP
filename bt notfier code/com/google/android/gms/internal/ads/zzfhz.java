/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfgg
 *  com.google.android.gms.internal.ads.zzfgr
 *  com.google.android.gms.internal.ads.zzfho
 *  com.google.android.gms.internal.ads.zzfhv
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfgg;
import com.google.android.gms.internal.ads.zzfgr;
import com.google.android.gms.internal.ads.zzfho;
import com.google.android.gms.internal.ads.zzfhv;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;

public final class zzfhz
extends zzfhv {
    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public zzfhz(zzfho zzfho2, HashSet hashSet, JSONObject jSONObject, long l, byte[] byArray) {
        super(zzfho2, hashSet, jSONObject, l, null);
    }

    private final void zzc(String string) {
        zzfgr zzfgr2 = zzfgr.zza();
        if (zzfgr2 == null) return;
        Iterator iterator = zzfgr2.zze().iterator();
        while (iterator.hasNext()) {
            zzfgr2 = (zzfgg)iterator.next();
            if (!this.zza.contains(zzfgr2.zzh())) continue;
            zzfgr2.zzg().zzg(string, this.zzc);
        }
    }

    protected final void zza(String string) {
        this.zzc(string);
        super.zza(string);
    }
}
