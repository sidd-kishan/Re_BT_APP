/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzanm
 *  com.google.android.gms.internal.ads.zzann
 *  com.google.android.gms.internal.ads.zzapg
 *  com.google.android.gms.internal.ads.zzapw
 *  com.google.android.gms.internal.ads.zzasw
 *  com.google.android.gms.internal.ads.zzaup
 *  com.google.android.gms.internal.ads.zzave
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzanm;
import com.google.android.gms.internal.ads.zzann;
import com.google.android.gms.internal.ads.zzapg;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzasw;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzave;

final class zzasx {
    private int zza = 1000;
    private int[] zzb = new int[1000];
    private long[] zzc = new long[1000];
    private int[] zzd;
    private int[] zze;
    private long[] zzf = new long[1000];
    private zzapw[] zzg;
    private zzanm[] zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private boolean zzo = true;
    private boolean zzp = true;
    private zzanm zzq;

    public zzasx() {
        this.zze = new int[1000];
        this.zzd = new int[1000];
        this.zzg = new zzapw[1000];
        this.zzh = new zzanm[1000];
        this.zzm = Long.MIN_VALUE;
        this.zzn = Long.MIN_VALUE;
    }

    public final void zza() {
        this.zzj = 0;
        this.zzk = 0;
        this.zzl = 0;
        this.zzi = 0;
        this.zzo = true;
    }

    public final void zzb() {
        this.zzm = Long.MIN_VALUE;
        this.zzn = Long.MIN_VALUE;
    }

    public final int zzc() {
        return this.zzj + this.zzi;
    }

    public final boolean zzd() {
        synchronized (this) {
            int n = this.zzi;
            boolean bl = n != 0;
            return bl;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final zzanm zze() {
        synchronized (this) {
            boolean bl = this.zzp;
            if (!bl) return this.zzq;
            return null;
        }
    }

    public final long zzf() {
        synchronized (this) {
            long l = Math.max(this.zzm, this.zzn);
            return l;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final int zzg(zzann object, zzapg zzapg2, boolean bl, boolean bl2, zzanm zzanm2, zzasw zzasw2) {
        synchronized (this) {
            int n;
            zzanm[] zzanmArray;
            if (!this.zzd()) {
                if (bl2) {
                    zzapg2.zze(4);
                    return -4;
                }
                zzapg2 = this.zzq;
                if (zzapg2 == null) return -3;
                if (!bl) {
                    if (zzapg2 == zzanm2) return -3;
                }
                object.zza = zzapg2;
                return -5;
            }
            if (!bl && (zzanmArray = this.zzh)[n = this.zzk] == zzanm2) {
                int n2;
                int n3;
                if (zzapg2.zzb == null) return -3;
                zzapg2.zzc = this.zzf[n];
                zzapg2.zze(this.zze[n]);
                int[] nArray = this.zzd;
                n = this.zzk;
                zzasw2.zza = nArray[n];
                zzasw2.zzb = this.zzc[n];
                zzasw2.zzd = this.zzg[n];
                this.zzm = Math.max(this.zzm, zzapg2.zzc);
                this.zzi = n3 = this.zzi - 1;
                this.zzk = n2 = this.zzk + 1;
                ++this.zzj;
                n = n2;
                if (n2 == this.zza) {
                    this.zzk = 0;
                    n = 0;
                }
                long l = n3 > 0 ? this.zzc[n] : zzasw2.zzb + (long)zzasw2.zza;
                zzasw2.zzc = l;
                return -4;
            }
            object.zza = this.zzh[this.zzk];
            return -5;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzh() {
        synchronized (this) {
            boolean bl = this.zzd();
            if (!bl) {
                return -1L;
            }
            int n = this.zzk;
            int n2 = this.zzi;
            int n3 = this.zza;
            int n4 = ((n += n2) - 1) % n3;
            this.zzk = n % n3;
            this.zzj += n2;
            this.zzi = 0;
            long l = this.zzc[n4];
            n2 = this.zzd[n4];
            long l2 = n2;
            return l + l2;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final long zzi(long l, boolean bl) {
        synchronized (this) {
            if (!this.zzd()) return -1L;
            long[] lArray = this.zzf;
            int n = this.zzk;
            if (l < lArray[n]) {
                return -1L;
            }
            try {
                long l2 = this.zzn;
                int n2 = 0;
                if (l > l2) {
                    if (!bl) return -1L;
                }
                int n3 = -1;
                while (n != this.zzl && this.zzf[n] <= l) {
                    if (1 == (this.zze[n] & 1)) {
                        n3 = n2;
                    }
                    n = (n + 1) % this.zza;
                    ++n2;
                }
                if (n3 == -1) {
                    return -1L;
                }
                this.zzk = n2 = (this.zzk + n3) % this.zza;
                this.zzj += n3;
                this.zzi -= n3;
                l = this.zzc[n2];
                return l;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
            finally {
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final boolean zzj(zzanm zzanm2) {
        synchronized (this) {
            if (zzanm2 == null) {
                this.zzp = true;
                return false;
            }
            this.zzp = false;
            boolean bl = zzave.zza((Object)zzanm2, (Object)this.zzq);
            if (bl) {
                return false;
            }
            this.zzq = zzanm2;
            return true;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzk(long l, int n, long l2, int n2, zzapw object) {
        synchronized (this) {
            boolean bl = this.zzo;
            if (bl) {
                if ((n & 1) == 0) {
                    return;
                }
                this.zzo = false;
            }
            zzaup.zzd((boolean)(this.zzp ^ true));
            this.zzl(l);
            long[] lArray = this.zzf;
            int n3 = this.zzl;
            lArray[n3] = l;
            lArray = this.zzc;
            lArray[n3] = l2;
            this.zzd[n3] = n2;
            this.zze[n3] = n;
            this.zzg[n3] = object;
            this.zzh[n3] = this.zzq;
            this.zzb[n3] = 0;
            this.zzi = n2 = this.zzi + 1;
            n = this.zza;
            if (n2 == n) {
                n2 = n + 1000;
                int[] nArray = new int[n2];
                long[] lArray2 = new long[n2];
                long[] lArray3 = new long[n2];
                int[] nArray2 = new int[n2];
                int[] nArray3 = new int[n2];
                zzapw[] zzapwArray = new zzapw[n2];
                zzanm[] zzanmArray = new zzanm[n2];
                n3 = this.zzk;
                System.arraycopy(lArray, n3, lArray2, 0, n -= n3);
                System.arraycopy(this.zzf, this.zzk, lArray3, 0, n);
                System.arraycopy(this.zze, this.zzk, nArray2, 0, n);
                System.arraycopy(this.zzd, this.zzk, nArray3, 0, n);
                System.arraycopy(this.zzg, this.zzk, zzapwArray, 0, n);
                System.arraycopy(this.zzh, this.zzk, zzanmArray, 0, n);
                System.arraycopy(this.zzb, this.zzk, nArray, 0, n);
                n3 = this.zzk;
                System.arraycopy(this.zzc, 0, lArray2, n, n3);
                System.arraycopy(this.zzf, 0, lArray3, n, n3);
                System.arraycopy(this.zze, 0, nArray2, n, n3);
                System.arraycopy(this.zzd, 0, nArray3, n, n3);
                System.arraycopy(this.zzg, 0, zzapwArray, n, n3);
                System.arraycopy(this.zzh, 0, zzanmArray, n, n3);
                System.arraycopy(this.zzb, 0, nArray, n, n3);
                this.zzc = lArray2;
                this.zzf = lArray3;
                this.zze = nArray2;
                this.zzd = nArray3;
                this.zzg = zzapwArray;
                this.zzh = zzanmArray;
                this.zzb = nArray;
                this.zzk = 0;
                this.zzl = n = this.zza;
                this.zzi = n;
                this.zza = n2;
                return;
            }
            this.zzl = n2 = n3 + 1;
            if (n2 != n) return;
            this.zzl = 0;
            return;
        }
    }

    public final void zzl(long l) {
        synchronized (this) {
            this.zzn = Math.max(this.zzn, l);
            return;
        }
    }
}
