/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzdll
 *  com.google.android.gms.internal.ads.zzdlm
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzdll;
import com.google.android.gms.internal.ads.zzdlm;
import java.lang.ref.WeakReference;
import java.util.Map;

final class zzdlk
implements zzbpr<Object> {
    private final WeakReference<zzdlm> zza;

    /* synthetic */ zzdlk(zzdlm zzdlm2, zzdll zzdll2) {
        this.zza = new WeakReference<zzdlm>(zzdlm2);
    }

    public final void zza(Object object, Map<String, String> map) {
        object = (zzdlm)this.zza.get();
        if (object == null) {
            return;
        }
        zzdlm.zza((zzdlm)object).zza();
    }
}
