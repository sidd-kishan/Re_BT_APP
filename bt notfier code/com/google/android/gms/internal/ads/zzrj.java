/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzox
 *  com.google.android.gms.internal.ads.zzrf
 *  com.google.android.gms.internal.ads.zzrv
 *  com.google.android.gms.internal.ads.zzrw
 *  com.google.android.gms.internal.ads.zzrx
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzox;
import com.google.android.gms.internal.ads.zzrf;
import com.google.android.gms.internal.ads.zzrv;
import com.google.android.gms.internal.ads.zzrw;
import com.google.android.gms.internal.ads.zzrx;

final class zzrj {
    public final zzox zza;
    public final zzrw zzb;
    public final zzamf zzc;
    public zzrx zzd;
    public zzrf zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzamf zzj;
    private final zzamf zzk;
    private boolean zzl;

    public zzrj(zzox zzox2, zzrx zzrx2, zzrf zzrf2) {
        this.zza = zzox2;
        this.zzd = zzrx2;
        this.zze = zzrf2;
        this.zzb = new zzrw();
        this.zzc = new zzamf();
        this.zzj = new zzamf(1);
        this.zzk = new zzamf();
        this.zzc(zzrx2, zzrf2);
    }

    static /* synthetic */ boolean zza(zzrj zzrj2, boolean bl) {
        zzrj2.zzl = true;
        return true;
    }

    static /* synthetic */ boolean zzb(zzrj zzrj2) {
        return zzrj2.zzl;
    }

    public final void zzc(zzrx zzrx2, zzrf zzrf2) {
        this.zzd = zzrx2;
        this.zze = zzrf2;
        this.zza.zzs(zzrx2.zza.zzf);
        this.zzd();
    }

    public final void zzd() {
        zzrw zzrw2 = this.zzb;
        zzrw2.zzd = 0;
        zzrw2.zzq = 0L;
        zzrw2.zzr = false;
        zzrw2.zzl = false;
        zzrw2.zzp = false;
        zzrw2.zzn = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzl = false;
    }

    public final long zze() {
        long l = !this.zzl ? this.zzd.zzf[this.zzf] : this.zzb.zzb(this.zzf);
        return l;
    }

    public final long zzf() {
        long l = !this.zzl ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
        return l;
    }

    public final int zzg() {
        int n = !this.zzl ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
        return n;
    }

    public final int zzh() {
        int n = !this.zzl ? this.zzd.zzg[this.zzf] : (this.zzb.zzk[this.zzf] ? 1 : 0);
        int n2 = n;
        if (this.zzk() == null) return n2;
        n2 = n | 0x40000000;
        return n2;
    }

    public final boolean zzi() {
        int n;
        ++this.zzf;
        if (!this.zzl) {
            return false;
        }
        this.zzg = n = this.zzg + 1;
        int[] nArray = this.zzb.zzg;
        int n2 = this.zzh;
        if (n != nArray[n2]) return true;
        this.zzh = n2 + 1;
        this.zzg = 0;
        return false;
    }

    public final int zzj(int n, int n2) {
        Object object;
        Object object2 = this.zzk();
        if (object2 == null) {
            return 0;
        }
        int n3 = object2.zzd;
        if (n3 != 0) {
            object2 = this.zzb.zzo;
        } else {
            object = (byte[])zzamq.zzd((Object)object2.zze);
            object2 = this.zzk;
            n3 = ((byte[])object).length;
            object2.zzb(object, n3);
            object2 = this.zzk;
        }
        boolean bl = this.zzb.zzc(this.zzf);
        boolean bl2 = bl || n2 != 0;
        object = this.zzj.zzi();
        int n4 = true != bl2 ? 0 : 128;
        object[0] = (byte)(n4 | n3);
        this.zzj.zzh(0);
        this.zza.zzu(this.zzj, 1, 1);
        this.zza.zzu((zzamf)object2, n3, 1);
        if (!bl2) {
            return n3 + 1;
        }
        if (!bl) {
            this.zzc.zza(8);
            object2 = this.zzc.zzi();
            object2[0] = (zzrv)false;
            object2[1] = (zzrv)true;
            object2[2] = (zzrv)false;
            object2[3] = (zzrv)((byte)n2);
            object2[4] = (zzrv)((byte)(n >> 24 & 0xFF));
            object2[5] = (zzrv)((byte)(n >> 16 & 0xFF));
            object2[6] = (zzrv)((byte)(n >> 8 & 0xFF));
            object2[7] = (zzrv)((byte)(n & 0xFF));
            this.zza.zzu(this.zzc, 8, 1);
            return n3 + 9;
        }
        object = this.zzb.zzo;
        n = object.zzo();
        object.zzk(-2);
        n = n * 6 + 2;
        object2 = object;
        if (n2 != 0) {
            this.zzc.zza(n);
            object2 = this.zzc.zzi();
            object.zzm((byte[])object2, 0, n);
            n2 = ((object2[2] & 0xFF) << 8 | object2[3] & 0xFF) + n2;
            object2[2] = (zzrv)((byte)(n2 >> 8 & 0xFF));
            object2[3] = (zzrv)((byte)(n2 & 0xFF));
            object2 = this.zzc;
        }
        this.zza.zzu((zzamf)object2, n, 1);
        return n3 + 1 + n;
    }

    public final zzrv zzk() {
        if (!this.zzl) {
            return null;
        }
        zzrw zzrw2 = this.zzb;
        zzrf zzrf2 = zzrw2.zza;
        int n = zzamq.zza;
        n = zzrf2.zza;
        zzrw2 = zzrw2.zzn;
        if (zzrw2 == null) {
            zzrw2 = this.zzd.zza.zza(n);
        }
        if (zzrw2 == null) return null;
        if (!zzrw2.zza) return null;
        return zzrw2;
    }
}
