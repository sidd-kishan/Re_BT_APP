/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzjk
 *  com.google.android.gms.internal.measurement.zzjr
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjk;
import com.google.android.gms.internal.measurement.zzjr;
import java.util.Iterator;
import java.util.Map;

final class zzjp
implements Iterator<Map.Entry> {
    final zzjr zza;
    private int zzb;
    private boolean zzc;
    private Iterator<Map.Entry> zzd;

    /* synthetic */ zzjp(zzjr zzjr2, zzjk zzjk2) {
        this.zza = zzjr2;
        this.zzb = -1;
    }

    private final Iterator<Map.Entry> zza() {
        if (this.zzd != null) return this.zzd;
        this.zzd = zzjr.zzi((zzjr)this.zza).entrySet().iterator();
        return this.zzd;
    }

    @Override
    public final boolean hasNext() {
        boolean bl;
        int n = this.zzb;
        boolean bl2 = bl = true;
        if (n + 1 < zzjr.zzh((zzjr)this.zza).size()) return bl2;
        if (!zzjr.zzi((zzjr)this.zza).isEmpty()) {
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
        zzjr.zzg((zzjr)this.zza);
        if (this.zzb < zzjr.zzh((zzjr)this.zza).size()) {
            zzjr zzjr2 = this.zza;
            int n = this.zzb;
            this.zzb = n - 1;
            zzjr.zzj((zzjr)zzjr2, (int)n);
            return;
        }
        this.zza().remove();
    }
}
