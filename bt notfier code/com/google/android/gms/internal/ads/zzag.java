/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaj
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzan
 *  com.google.android.gms.internal.ads.zzay
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaj;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzan;
import com.google.android.gms.internal.ads.zzay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public abstract class zzag
implements zzaj {
    private final boolean zza;
    private final ArrayList<zzay> zzb;
    private int zzc;
    private zzan zzd;

    protected zzag(boolean bl) {
        this.zza = bl;
        this.zzb = new ArrayList(1);
    }

    public final void zza(zzay zzay2) {
        if (zzay2 == null) throw null;
        if (this.zzb.contains(zzay2)) return;
        this.zzb.add(zzay2);
        ++this.zzc;
    }

    protected final void zzb(zzan zzan2) {
        int n = 0;
        while (n < this.zzc) {
            this.zzb.get(n).zza((zzaj)this, zzan2, this.zza);
            ++n;
        }
    }

    protected final void zzc(zzan zzan2) {
        this.zzd = zzan2;
        int n = 0;
        while (n < this.zzc) {
            this.zzb.get(n).zzb((zzaj)this, zzan2, this.zza);
            ++n;
        }
    }

    protected final void zzd(int n) {
        zzan zzan2 = this.zzd;
        int n2 = zzamq.zza;
        n2 = 0;
        while (n2 < this.zzc) {
            this.zzb.get(n2).zzc((zzaj)this, zzan2, this.zza, n);
            ++n2;
        }
    }

    protected final void zze() {
        zzan zzan2 = this.zzd;
        int n = zzamq.zza;
        n = 0;
        while (true) {
            if (n >= this.zzc) {
                this.zzd = null;
                return;
            }
            this.zzb.get(n).zzd((zzaj)this, zzan2, this.zza);
            ++n;
        }
    }

    public Map zzf() {
        return Collections.emptyMap();
    }
}
