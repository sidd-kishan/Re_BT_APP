/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.google.android.gms.internal.ads.zzamy
 *  com.google.android.gms.internal.ads.zzanr
 *  com.google.android.gms.internal.ads.zzans
 *  com.google.android.gms.internal.ads.zzasp
 *  com.google.android.gms.internal.ads.zzasr
 *  com.google.android.gms.internal.ads.zzatb
 *  com.google.android.gms.internal.ads.zzats
 *  com.google.android.gms.internal.ads.zzatu
 *  com.google.android.gms.internal.ads.zzatv
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzcjy
 */
package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzamy;
import com.google.android.gms.internal.ads.zzanr;
import com.google.android.gms.internal.ads.zzans;
import com.google.android.gms.internal.ads.zzasp;
import com.google.android.gms.internal.ads.zzasr;
import com.google.android.gms.internal.ads.zzatb;
import com.google.android.gms.internal.ads.zzats;
import com.google.android.gms.internal.ads.zzatu;
import com.google.android.gms.internal.ads.zzatv;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzcjy;

final class zzang {
    public final zzasp zza;
    public final Object zzb;
    public final int zzc;
    public final zzatb[] zzd;
    public final boolean[] zze;
    public final long zzf;
    public int zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    public boolean zzk;
    public zzang zzl;
    public zzatv zzm;
    private final zzanr[] zzn;
    private final zzans[] zzo;
    private final zzatu zzp;
    private final zzasr zzq;
    private zzatv zzr;
    private final zzcjy zzs;

    public zzang(zzanr[] zzanrArray, zzans[] zzansArray, long l, zzatu zzatu2, zzcjy zzcjy2, zzasr zzasr2, Object object, int n, int n2, boolean bl, long l2, byte[] byArray) {
        this.zzn = zzanrArray;
        this.zzo = zzansArray;
        this.zzf = l;
        this.zzp = zzatu2;
        this.zzs = zzcjy2;
        this.zzq = zzasr2;
        if (object == null) throw null;
        this.zzb = object;
        this.zzc = n;
        this.zzg = n2;
        this.zzi = bl;
        this.zzh = l2;
        this.zzd = new zzatb[2];
        this.zze = new boolean[2];
        this.zza = zzasr2.zze(n2, zzcjy2.zzl());
    }

    public final boolean zza() {
        boolean bl = this.zzj;
        boolean bl2 = true;
        if (bl) {
            if (!this.zzk) return bl2;
            if (this.zza.zzq() == Long.MIN_VALUE) return true;
        }
        bl2 = false;
        return bl2;
    }

    public final boolean zzb() throws zzamy {
        zzatv zzatv2;
        block3: {
            zzatv2 = this.zzp.zzd(this.zzo, this.zza.zzn());
            zzatv zzatv3 = this.zzr;
            if (zzatv3 != null) {
                int n = 0;
                while (n < 2) {
                    if (zzatv2.zza(zzatv3, n)) {
                        ++n;
                        continue;
                    }
                    break block3;
                }
                return false;
            }
        }
        this.zzm = zzatv2;
        return true;
    }

    public final long zzc(long l, boolean bl) {
        return this.zzd(l, false, new boolean[2]);
    }

    public final long zzd(long l, boolean bl, boolean[] objectArray) {
        zzats zzats2 = this.zzm.zzb;
        int n = 0;
        while (true) {
            boolean bl2 = true;
            if (n >= 2) break;
            boolean[] blArray = this.zze;
            if (bl || !this.zzm.zza(this.zzr, n)) {
                bl2 = false;
            }
            blArray[n] = bl2;
            ++n;
        }
        l = this.zza.zzB(zzats2.zzb(), this.zze, this.zzd, objectArray, l);
        this.zzr = this.zzm;
        this.zzk = false;
        n = 0;
        while (true) {
            objectArray = this.zzd;
            if (n >= 2) {
                this.zzs.zzb(this.zzn, this.zzm.zza, zzats2);
                return l;
            }
            if (objectArray[n] != null) {
                bl = zzats2.zza(n) != null;
                zzaup.zzd((boolean)bl);
                this.zzk = true;
            } else {
                bl = zzats2.zza(n) == null;
                zzaup.zzd((boolean)bl);
            }
            ++n;
        }
    }

    public final void zze() {
        try {
            this.zzq.zzc(this.zza);
            return;
        }
        catch (RuntimeException runtimeException) {
            Log.e((String)"ExoPlayerImplInternal", (String)"Period release failed.", (Throwable)runtimeException);
            return;
        }
    }
}
