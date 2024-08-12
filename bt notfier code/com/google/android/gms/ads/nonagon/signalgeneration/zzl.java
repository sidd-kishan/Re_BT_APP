/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.nonagon.signalgeneration.zzv
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.ads.nonagon.signalgeneration.zzv;
import com.google.android.gms.internal.ads.zzfln;
import java.util.List;

final class zzl
implements zzfln {
    private final zzv zza;
    private final List zzb;

    zzl(zzv zzv2, List list) {
        this.zza = zzv2;
        this.zzb = list;
    }

    public final Object apply(Object object) {
        return zzv.zzG((List)this.zzb, (String)((String)object));
    }
}
