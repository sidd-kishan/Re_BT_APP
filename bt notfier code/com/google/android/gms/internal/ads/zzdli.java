/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzdll
 *  com.google.android.gms.internal.ads.zzdlm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzdll;
import com.google.android.gms.internal.ads.zzdlm;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdli
implements zzbpr<Object> {
    private final WeakReference<zzdlm> zza;

    /* synthetic */ zzdli(zzdlm zzdlm2, zzdll zzdll2) {
        this.zza = new WeakReference<zzdlm>(zzdlm2);
    }

    public final void zza(Object object, Map<String, String> zzbjd2) {
        object = (zzdlm)this.zza.get();
        if (object == null) {
            return;
        }
        if (!"_ac".equals(zzbjd2.get("eventName"))) return;
        zzdlm.zzb((zzdlm)object).onAdClicked();
        zzbjd2 = zzbjl.zzhb;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        zzdlm.zzc((zzdlm)object).zzb();
    }
}
