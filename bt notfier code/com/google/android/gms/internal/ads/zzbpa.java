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

final class zzbpa
implements zzfln {
    private final String zza;

    zzbpa(String string) {
        this.zza = string;
    }

    public final Object apply(Object object) {
        String string = this.zza;
        Throwable throwable = (Throwable)object;
        object = zzbpq.zza;
        if ((Boolean)zzbkx.zzk.zze() == false) return string;
        zzt.zzg().zzk(throwable, "prepareClickUrl.attestation2");
        return string;
    }
}
