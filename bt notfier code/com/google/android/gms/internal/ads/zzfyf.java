/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfye
 *  com.google.android.gms.internal.ads.zzfyg
 *  com.google.android.gms.internal.ads.zzfyj
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfye;
import com.google.android.gms.internal.ads.zzfyg;
import com.google.android.gms.internal.ads.zzfyj;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyf
extends zzgfw<zzfyg, zzfyf>
implements zzghj {
    private zzfyf() {
        super((zzgga)zzfyg.zzf());
    }

    /* synthetic */ zzfyf(zzfye zzfye2) {
        super((zzgga)zzfyg.zzf());
    }

    public final zzfyf zza(zzfyj zzfyj2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfyg.zzg((zzfyg)((zzfyg)this.zza), (zzfyj)zzfyj2);
        return this;
    }

    public final zzfyf zzb(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfyg.zzh((zzfyg)((zzfyg)this.zza), (int)n);
        return this;
    }
}
