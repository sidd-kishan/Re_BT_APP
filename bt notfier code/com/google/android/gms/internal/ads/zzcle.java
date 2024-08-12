/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcla
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcla;

public final class zzcle
extends zzcla {
    public zzcle(zzcjb zzcjb2) {
        super(zzcjb2);
    }

    public final boolean zzd(String string) {
        String string2 = zzcgm.zzd((String)string);
        zzcjb zzcjb2 = (zzcjb)this.zzc.get();
        if (zzcjb2 != null && string2 != null) {
            zzcjb2.zzu(string2, (zzcla)this);
        }
        zze.zzi((String)"VideoStreamNoopCache is doing nothing.");
        this.zzr(string, string2, "noop", "Noop cache is a noop.");
        return false;
    }

    public final void zzm() {
    }
}
