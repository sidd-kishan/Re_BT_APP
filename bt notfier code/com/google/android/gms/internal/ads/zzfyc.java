/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzfyb
 *  com.google.android.gms.internal.ads.zzfyd
 *  com.google.android.gms.internal.ads.zzfyj
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzfyb;
import com.google.android.gms.internal.ads.zzfyd;
import com.google.android.gms.internal.ads.zzfyj;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzfyc
extends zzgfw<zzfyd, zzfyc>
implements zzghj {
    private zzfyc() {
        super((zzgga)zzfyd.zzg());
    }

    /* synthetic */ zzfyc(zzfyb zzfyb2) {
        super((zzgga)zzfyd.zzg());
    }

    public final zzfyc zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfyd.zzh((zzfyd)((zzfyd)this.zza), (int)0);
        return this;
    }

    public final zzfyc zzb(zzfyj zzfyj2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfyd.zzi((zzfyd)((zzfyd)this.zza), (zzfyj)zzfyj2);
        return this;
    }

    public final zzfyc zzc(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzfyd.zzj((zzfyd)((zzfyd)this.zza), (zzgex)zzgex2);
        return this;
    }
}
