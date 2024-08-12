/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgij
 *  com.google.android.gms.internal.ads.zzgik
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgij;
import com.google.android.gms.internal.ads.zzgik;
import java.util.Iterator;
import java.util.Map;

final class zzgih
implements Iterator<Map.Entry> {
    final zzgik zza;
    private int zzb;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* synthetic */ zzgih(zzgik zzgik2, zzgij zzgij2) {
        this.zza = zzgik2;
        this.zzb = -1;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd != null) return this.zzd;
        this.zzd = zzgik.zzc((zzgik)this.zza).entrySet().iterator();
        return this.zzd;
    }

    @Override
    public final boolean hasNext() {
        boolean bl;
        int n = this.zzb;
        boolean bl2 = bl = true;
        if (n + 1 < zzgik.zzb((zzgik)this.zza).size()) return bl2;
        if (!zzgik.zzc((zzgik)this.zza).isEmpty()) {
            if (!this.zza().hasNext()) return false;
            bl2 = bl;
        } else {
            bl2 = false;
        }
        return bl2;
    }

    @Override
    public final void remove() {
        if (!this.zzc) throw new IllegalStateException("remove() was called before next()");
        this.zzc = false;
        zzgik.zzj((zzgik)this.zza);
        if (this.zzb < zzgik.zzb((zzgik)this.zza).size()) {
            zzgik zzgik2 = this.zza;
            int n = this.zzb;
            this.zzb = n - 1;
            zzgik.zzi((zzgik)zzgik2, (int)n);
            return;
        }
        this.zza().remove();
    }
}
