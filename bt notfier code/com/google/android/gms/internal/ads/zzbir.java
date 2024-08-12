/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoController$VideoLifecycleCallbacks
 *  com.google.android.gms.internal.ads.zzbhe
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzbhe;

public final class zzbir
extends zzbhe {
    private final VideoController.VideoLifecycleCallbacks zza;

    public zzbir(VideoController.VideoLifecycleCallbacks videoLifecycleCallbacks) {
        this.zza = videoLifecycleCallbacks;
    }

    public final void zze() {
        this.zza.onVideoStart();
    }

    public final void zzf() {
        this.zza.onVideoPlay();
    }

    public final void zzg() {
        this.zza.onVideoPause();
    }

    public final void zzh() {
        this.zza.onVideoEnd();
    }

    public final void zzi(boolean bl) {
        this.zza.onVideoMute(bl);
    }
}
