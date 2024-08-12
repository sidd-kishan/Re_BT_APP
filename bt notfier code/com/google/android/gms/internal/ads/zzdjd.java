/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoController$VideoLifecycleCallbacks
 *  com.google.android.gms.internal.ads.zzdgl
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzdgl;

final class zzdjd
implements zzdgl {
    static final zzdgl zza = new zzdjd();

    private zzdjd() {
    }

    public final void zza(Object object) {
        ((VideoController.VideoLifecycleCallbacks)object).onVideoStart();
    }
}
