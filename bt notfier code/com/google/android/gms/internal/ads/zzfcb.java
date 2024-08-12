/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzfcl
 *  com.google.android.gms.internal.ads.zzfcz
 *  com.google.android.gms.internal.ads.zzfda
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzfcl;
import com.google.android.gms.internal.ads.zzfcz;
import com.google.android.gms.internal.ads.zzfda;
import java.util.LinkedList;

final class zzfcb {
    private final LinkedList<zzfcl<?, ?>> zza = new LinkedList();
    private final int zzb;
    private final int zzc;
    private final zzfda zzd;

    public zzfcb(int n, int n2) {
        this.zzb = n;
        this.zzc = n2;
        this.zzd = new zzfda();
    }

    private final void zzi() {
        while (!this.zza.isEmpty()) {
            zzfcl<?, ?> zzfcl2 = this.zza.getFirst();
            if (zzt.zzj().currentTimeMillis() - zzfcl2.zzd < (long)this.zzc) return;
            this.zzd.zzc();
            this.zza.remove();
        }
    }

    public final boolean zza(zzfcl<?, ?> zzfcl2) {
        this.zzd.zza();
        this.zzi();
        if (this.zza.size() == this.zzb) {
            return false;
        }
        this.zza.add(zzfcl2);
        return true;
    }

    public final zzfcl<?, ?> zzb() {
        this.zzd.zza();
        this.zzi();
        if (this.zza.isEmpty()) {
            return null;
        }
        zzfcl<?, ?> zzfcl2 = this.zza.remove();
        if (zzfcl2 == null) return zzfcl2;
        this.zzd.zzb();
        return zzfcl2;
    }

    public final int zzc() {
        this.zzi();
        return this.zza.size();
    }

    public final long zzd() {
        return this.zzd.zzd();
    }

    public final long zze() {
        return this.zzd.zze();
    }

    public final int zzf() {
        return this.zzd.zzf();
    }

    public final String zzg() {
        return this.zzd.zzh();
    }

    public final zzfcz zzh() {
        return this.zzd.zzg();
    }
}
