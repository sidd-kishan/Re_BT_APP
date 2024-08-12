/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzafy
 *  com.google.android.gms.internal.ads.zzahv
 *  com.google.android.gms.internal.ads.zzjg
 *  com.google.android.gms.internal.ads.zzko
 *  com.google.android.gms.internal.ads.zzs
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzafy;
import com.google.android.gms.internal.ads.zzahv;
import com.google.android.gms.internal.ads.zzjg;
import com.google.android.gms.internal.ads.zzko;
import com.google.android.gms.internal.ads.zzs;

public final class zzclm
implements zzafy {
    private final zzko zza = new zzko(true, 65536);
    private long zzb = 15000000L;
    private long zzc = 30000000L;
    private long zzd = 2500000L;
    private long zze = 5000000L;
    private int zzf;
    private boolean zzg;

    zzclm() {
    }

    public final void zza() {
        this.zzn(false);
    }

    public final void zzb() {
        this.zzn(true);
    }

    public final void zzc() {
        this.zzn(true);
    }

    public final long zzd() {
        return 0L;
    }

    public final boolean zze() {
        return false;
    }

    public final boolean zzf(long l, long l2, float f) {
        l = this.zzc;
        boolean bl = true;
        int n = l2 > l ? 0 : (l2 < this.zzb ? 2 : 1);
        int n2 = this.zza.zzg();
        int n3 = this.zzf;
        boolean bl2 = bl;
        if (n != 2) {
            bl2 = n == 1 && this.zzg && n2 < n3 ? bl : false;
        }
        this.zzg = bl2;
        return bl2;
    }

    public final boolean zzg(long l, float f, boolean bl, long l2) {
        l2 = bl ? this.zze : this.zzd;
        if (l2 <= 0L) return true;
        if (l < l2) return false;
        return true;
    }

    public final zzko zzh() {
        return this.zza;
    }

    public final void zzi(zzahv[] zzahvArray, zzs zzs2, zzjg[] zzjgArray) {
        int n = 0;
        this.zzf = 0;
        while (true) {
            if (n >= 2) {
                this.zza.zzb(this.zzf);
                return;
            }
            if (zzjgArray[n] != null) {
                int n2 = this.zzf;
                int n3 = zzahvArray[n].zzac() != 1 ? 0x7D00000 : 0xC80000;
                this.zzf = n2 + n3;
            }
            ++n;
        }
    }

    public final void zzj(int n) {
        synchronized (this) {
            long l = n;
            this.zzb = l * 1000L;
            return;
        }
    }

    public final void zzk(int n) {
        synchronized (this) {
            long l = n;
            this.zzc = l * 1000L;
            return;
        }
    }

    public final void zzl(int n) {
        synchronized (this) {
            long l = n;
            this.zzd = l * 1000L;
            return;
        }
    }

    public final void zzm(int n) {
        synchronized (this) {
            long l = n;
            this.zze = l * 1000L;
            return;
        }
    }

    final void zzn(boolean bl) {
        this.zzf = 0;
        this.zzg = false;
        if (!bl) return;
        this.zza.zza();
    }
}
