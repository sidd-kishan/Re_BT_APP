/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.admanager.AppEventListener
 *  com.google.android.gms.internal.ads.zzbft
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.internal.ads.zzbft;

public final class zzawr
extends zzbft {
    private final AppEventListener zza;

    public zzawr(AppEventListener appEventListener) {
        this.zza = appEventListener;
    }

    public final void zzb(String string, String string2) {
        this.zza.onAppEvent(string, string2);
    }

    public final AppEventListener zzc() {
        return this.zza;
    }
}
