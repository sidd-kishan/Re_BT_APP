/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzbkx
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbkx;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzfln;

final class zzboy
implements zzfln {
    static final zzfln zza = new zzboy();

    private zzboy() {
    }

    public final Object apply(Object object) {
        Throwable throwable = (Throwable)object;
        object = zzbpq.zza;
        if ((Boolean)zzbkx.zzk.zze() == false) return "failure_click_attok";
        zzt.zzg().zzk(throwable, "prepareClickUrl.attestation1");
        return "failure_click_attok";
    }
}
