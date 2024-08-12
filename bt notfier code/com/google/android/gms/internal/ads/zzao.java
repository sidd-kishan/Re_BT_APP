/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzai
 *  com.google.android.gms.internal.ads.zzaq
 *  com.google.android.gms.internal.ads.zzav
 *  com.google.android.gms.internal.ads.zzay
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzaq;
import com.google.android.gms.internal.ads.zzav;
import com.google.android.gms.internal.ads.zzay;

public final class zzao
implements zzai {
    private final zzav zza = new zzav();
    private zzay zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzao zzb(String string) {
        this.zzc = string;
        return this;
    }

    public final zzao zzc(int n) {
        this.zzd = n;
        return this;
    }

    public final zzao zzd(int n) {
        this.zze = n;
        return this;
    }

    public final zzao zze(boolean bl) {
        this.zzf = true;
        return this;
    }

    public final zzao zzf(zzay zzay2) {
        this.zzb = zzay2;
        return this;
    }

    public final zzaq zzg() {
        zzaq zzaq2 = new zzaq(this.zzc, this.zzd, this.zze, this.zzf, this.zza, null, false, null);
        zzay zzay2 = this.zzb;
        if (zzay2 == null) return zzaq2;
        zzaq2.zza(zzay2);
        return zzaq2;
    }
}
