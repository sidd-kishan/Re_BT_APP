/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.VideoController$VideoLifecycleCallbacks
 *  com.google.android.gms.internal.ads.zzdgm
 *  com.google.android.gms.internal.ads.zzdih
 *  com.google.android.gms.internal.ads.zzdja
 *  com.google.android.gms.internal.ads.zzdjb
 *  com.google.android.gms.internal.ads.zzdjc
 *  com.google.android.gms.internal.ads.zzdjd
 *  com.google.android.gms.internal.ads.zzdje
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import com.google.android.gms.internal.ads.zzdgm;
import com.google.android.gms.internal.ads.zzdih;
import com.google.android.gms.internal.ads.zzdja;
import com.google.android.gms.internal.ads.zzdjb;
import com.google.android.gms.internal.ads.zzdjc;
import com.google.android.gms.internal.ads.zzdjd;
import com.google.android.gms.internal.ads.zzdje;
import java.util.Set;

public final class zzdjf
extends zzdgm<VideoController.VideoLifecycleCallbacks> {
    private boolean zzb;

    protected zzdjf(Set<zzdih<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void zza() {
        this.zzk(zzdja.zza);
    }

    public final void zzb() {
        this.zzk(zzdjb.zza);
    }

    public final void zzc() {
        synchronized (this) {
            this.zzk(zzdjc.zza);
            this.zzb = true;
            return;
        }
    }

    public final void zzd() {
        synchronized (this) {
            if (!this.zzb) {
                this.zzk(zzdjd.zza);
                this.zzb = true;
            }
            this.zzk(zzdje.zza);
            return;
        }
    }
}
