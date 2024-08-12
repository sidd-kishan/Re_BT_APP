/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.appset.AppSetIdInfo
 *  com.google.android.gms.internal.ads.zzenq
 *  com.google.android.gms.internal.ads.zzfln
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.internal.ads.zzenq;
import com.google.android.gms.internal.ads.zzfln;

final class zzeno
implements zzfln {
    static final zzfln zza = new zzeno();

    private zzeno() {
    }

    public final Object apply(Object object) {
        object = (AppSetIdInfo)object;
        return new zzenq(object.getId(), object.getScope());
    }
}
