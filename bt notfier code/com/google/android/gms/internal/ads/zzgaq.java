/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgap
 *  com.google.android.gms.internal.ads.zzgar
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfw
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzghj
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgap;
import com.google.android.gms.internal.ads.zzgar;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfw;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzghj;

public final class zzgaq
extends zzgfw<zzgar, zzgaq>
implements zzghj {
    private zzgaq() {
        super((zzgga)zzgar.zzf());
    }

    /* synthetic */ zzgaq(zzgap zzgap2) {
        super((zzgga)zzgar.zzf());
    }

    public final zzgaq zza(String string) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgar.zzg((zzgar)((zzgar)this.zza), (String)string);
        return this;
    }

    public final zzgaq zzb(zzgex zzgex2) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgar.zzh((zzgar)((zzgar)this.zza), (zzgex)zzgex2);
        return this;
    }

    public final zzgaq zzc(int n) {
        if (this.zzb) {
            this.zzae();
            this.zzb = false;
        }
        zzgar.zzj((zzgar)((zzgar)this.zza), (int)n);
        return this;
    }
}
