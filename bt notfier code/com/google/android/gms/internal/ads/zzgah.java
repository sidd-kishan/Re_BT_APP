/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgag
 *  com.google.android.gms.internal.ads.zzgai
 *  com.google.android.gms.internal.ads.zzgao
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgag;
import com.google.android.gms.internal.ads.zzgai;
import com.google.android.gms.internal.ads.zzgao;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgah
extends zzgfw<zzgai, zzgah>
implements zzghj {
    private zzgah() {
        super((zzgga)zzgai.zzh());
    }

    /* synthetic */ zzgah(zzgag zzgag2) {
        super((zzgga)zzgai.zzh());
    }

    public final zzgah zza(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgai.zzi((zzgai)((zzgai)this.zza), (int)0);
        return this;
    }

    public final zzgah zzb(zzgao zzgao2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgai.zzj((zzgai)((zzgai)this.zza), (zzgao)zzgao2);
        return this;
    }

    public final zzgah zzc(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgai.zzk((zzgai)((zzgai)this.zza), (zzgex)zzgex2);
        return this;
    }
}
