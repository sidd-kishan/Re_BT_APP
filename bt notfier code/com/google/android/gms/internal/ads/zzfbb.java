/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzeds
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzffu
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzeds;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzffu;
import java.util.List;

public final class zzfbb {
    private final zzezz zza;
    private final zzfac zzb;
    private final zzedq zzc;
    private final zzffu zzd;

    public zzfbb(zzedq zzedq2, zzffu zzffu2, zzezz zzezz2, zzfac zzfac2) {
        this.zza = zzezz2;
        this.zzb = zzfac2;
        this.zzc = zzedq2;
        this.zzd = zzffu2;
    }

    public final void zza(List<String> object) {
        object = object.iterator();
        while (object.hasNext()) {
            this.zzc((String)object.next(), 2);
        }
    }

    public final void zzb(List<String> object, int n) {
        object = object.iterator();
        while (object.hasNext()) {
            this.zzc((String)object.next(), n);
        }
    }

    public final void zzc(String string, int n) {
        if (!this.zza.zzaf) {
            this.zzd.zzb(string);
            return;
        }
        string = new zzeds(zzt.zzj().currentTimeMillis(), this.zzb.zzb, string, n);
        this.zzc.zze((zzeds)string);
    }
}
