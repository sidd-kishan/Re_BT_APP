/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzac
 *  com.google.android.gms.internal.ads.zzaf
 *  com.google.android.gms.internal.ads.zzah
 *  com.google.android.gms.internal.ads.zzamf
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzim
 *  com.google.android.gms.internal.ads.zziq
 *  com.google.android.gms.internal.ads.zzkb
 *  com.google.android.gms.internal.ads.zzko
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzac;
import com.google.android.gms.internal.ads.zzaf;
import com.google.android.gms.internal.ads.zzah;
import com.google.android.gms.internal.ads.zzamf;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzim;
import com.google.android.gms.internal.ads.zziq;
import com.google.android.gms.internal.ads.zzkb;
import com.google.android.gms.internal.ads.zzko;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

final class zzin {
    private final zzamf zza;
    private zzim zzb;
    private zzim zzc;
    private zzim zzd;
    private long zze;
    private final zzko zzf;

    public zzin(zzko zzko2, byte[] byArray) {
        this.zzf = zzko2;
        this.zza = new zzamf(32);
        zzko2 = new zzim(0L, 65536);
        this.zzb = zzko2;
        this.zzc = zzko2;
        this.zzd = zzko2;
    }

    private final int zzi(int n) {
        zzim zzim2 = this.zzd;
        if (zzim2.zzc) return Math.min(n, (int)(this.zzd.zzb - this.zze));
        zzkb zzkb2 = this.zzf.zzc();
        zzim zzim3 = new zzim(this.zzd.zzb, 65536);
        zzim2.zzd = zzkb2;
        zzim2.zze = zzim3;
        zzim2.zzc = true;
        return Math.min(n, (int)(this.zzd.zzb - this.zze));
    }

    private final void zzj(int n) {
        long l;
        this.zze = l = this.zze + (long)n;
        zzim zzim2 = this.zzd;
        if (l != zzim2.zzb) return;
        this.zzd = zzim2.zze;
    }

    private static zzim zzk(zzim object, zzaf zzaf2, zziq zziq2, zzamf zzamf2) {
        int n;
        block20: {
            long l;
            Object object2;
            int[] nArray;
            zzac zzac2;
            int n2;
            int n3;
            Object[] objectArray;
            long l2;
            block24: {
                block23: {
                    block22: {
                        block21: {
                            if (!zzaf2.zzj()) break block20;
                            l2 = zziq2.zzb;
                            zzamf2.zza(1);
                            object = zzin.zzm(object, l2, zzamf2.zzi(), 1);
                            ++l2;
                            objectArray = zzamf2.zzi();
                            n3 = 0;
                            n = objectArray[0];
                            n2 = n & 0x80;
                            n &= 0x7F;
                            zzac2 = zzaf2.zza;
                            objectArray = zzac2.zza;
                            if (objectArray == null) {
                                zzac2.zza = new byte[16];
                            } else {
                                Arrays.fill(objectArray, (byte)0);
                            }
                            object = zzin.zzm(object, l2, zzac2.zza, n);
                            l2 += (long)n;
                            if (n2 != 0) {
                                zzamf2.zza(2);
                                object = zzin.zzm(object, l2, zzamf2.zzi(), 2);
                                l2 += 2L;
                                n = zzamf2.zzo();
                            } else {
                                n = 1;
                            }
                            nArray = zzac2.zzc;
                            if (nArray == null) break block21;
                            objectArray = nArray;
                            if (nArray.length >= n) break block22;
                        }
                        objectArray = new int[n];
                    }
                    if ((object2 = zzac2.zzd) == null) break block23;
                    nArray = object2;
                    if (((int[])object2).length >= n) break block24;
                }
                nArray = new int[n];
            }
            if (n2 != 0) {
                n2 = n * 6;
                zzamf2.zza(n2);
                object2 = zzin.zzm(object, l2, zzamf2.zzi(), n2);
                l = l2 + (long)n2;
                zzamf2.zzh(0);
                while (true) {
                    l2 = l;
                    object = object2;
                    if (n3 < n) {
                        objectArray[n3] = zzamf2.zzo();
                        nArray[n3] = zzamf2.zzB();
                        ++n3;
                        continue;
                    }
                    break;
                }
            } else {
                objectArray[0] = 0;
                nArray[0] = zziq2.zza - (int)(l2 - zziq2.zzb);
            }
            object2 = zziq2.zzc;
            n3 = zzamq.zza;
            zzac2.zza(n, (int[])objectArray, nArray, object2.zzb, zzac2.zza, object2.zza, object2.zzc, object2.zzd);
            l = zziq2.zzb;
            n = (int)(l2 - l);
            zziq2.zzb = l + (long)n;
            zziq2.zza -= n;
        }
        if (zzaf2.zze()) {
            zzamf2.zza(4);
            object = zzin.zzm(object, zziq2.zzb, zzamf2.zzi(), 4);
            n = zzamf2.zzB();
            zziq2.zzb += 4L;
            zziq2.zza -= 4;
            zzaf2.zzi(n);
            zzamf2 = zzin.zzl(object, zziq2.zzb, zzaf2.zzb, n);
            zziq2.zzb += (long)n;
            zziq2.zza = n = zziq2.zza - n;
            object = zzaf2.zze;
            if (object != null && object.capacity() >= n) {
                zzaf2.zze.clear();
            } else {
                zzaf2.zze = ByteBuffer.allocate(n);
            }
            object = zzin.zzl((zzim)zzamf2, zziq2.zzb, zzaf2.zze, zziq2.zza);
        } else {
            zzaf2.zzi(zziq2.zza);
            object = zzin.zzl(object, zziq2.zzb, zzaf2.zzb, zziq2.zza);
        }
        return object;
    }

    private static zzim zzl(zzim zzim2, long l, ByteBuffer byteBuffer, int n) {
        zzim2 = zzin.zzn(zzim2, l);
        while (n > 0) {
            long l2;
            int n2 = Math.min(n, (int)(zzim2.zzb - l));
            byteBuffer.put(zzim2.zzd.zza, zzim2.zza(l), n2);
            int n3 = n - n2;
            l = l2 = l + (long)n2;
            n = n3;
            if (l2 != zzim2.zzb) continue;
            zzim2 = zzim2.zze;
            l = l2;
            n = n3;
        }
        return zzim2;
    }

    private static zzim zzm(zzim zzim2, long l, byte[] byArray, int n) {
        zzim2 = zzin.zzn(zzim2, l);
        int n2 = n;
        while (n2 > 0) {
            int n3 = Math.min(n2, (int)(zzim2.zzb - l));
            System.arraycopy(zzim2.zzd.zza, zzim2.zza(l), byArray, n - n2, n3);
            int n4 = n2 - n3;
            long l2 = l + (long)n3;
            n2 = n4;
            l = l2;
            if (l2 != zzim2.zzb) continue;
            zzim2 = zzim2.zze;
            n2 = n4;
            l = l2;
        }
        return zzim2;
    }

    private static zzim zzn(zzim zzim2, long l) {
        while (l >= zzim2.zzb) {
            zzim2 = zzim2.zze;
        }
        return zzim2;
    }

    public final void zza() {
        zzim zzim2 = this.zzb;
        if (zzim2.zzc) {
            zzkb[] zzkbArray = this.zzd;
            int n = zzkbArray.zzc + (int)(zzkbArray.zza - zzim2.zza) / 65536;
            zzkbArray = new zzkb[n];
            for (int n2 = 0; n2 < n; zzim2 = zzim2.zzb(), ++n2) {
                zzkbArray[n2] = zzim2.zzd;
            }
            this.zzf.zze(zzkbArray);
        }
        this.zzb = zzim2 = new zzim(0L, 65536);
        this.zzc = zzim2;
        this.zzd = zzim2;
        this.zze = 0L;
        this.zzf.zzf();
    }

    public final void zzb() {
        this.zzc = this.zzb;
    }

    public final void zzc(zzaf zzaf2, zziq zziq2) {
        this.zzc = zzin.zzk(this.zzc, zzaf2, zziq2, this.zza);
    }

    public final void zzd(zzaf zzaf2, zziq zziq2) {
        zzin.zzk(this.zzc, zzaf2, zziq2, this.zza);
    }

    public final void zze(long l) {
        if (l == -1L) return;
        while (true) {
            zzim zzim2 = this.zzb;
            if (l < zzim2.zzb) {
                if (this.zzc.zza >= zzim2.zza) return;
                this.zzc = zzim2;
                return;
            }
            this.zzf.zzd(zzim2.zzd);
            this.zzb = this.zzb.zzb();
        }
    }

    public final long zzf() {
        return this.zze;
    }

    public final int zzg(zzah zzah2, int n, boolean bl) throws IOException {
        n = this.zzi(n);
        zzim zzim2 = this.zzd;
        n = zzah2.zzg(zzim2.zzd.zza, zzim2.zza(this.zze), n);
        if (n == -1) {
            if (!bl) throw new EOFException();
            return -1;
        }
        this.zzj(n);
        return n;
    }

    public final void zzh(zzamf zzamf2, int n) {
        while (n > 0) {
            int n2 = this.zzi(n);
            zzim zzim2 = this.zzd;
            zzamf2.zzm(zzim2.zzd.zza, zzim2.zza(this.zze), n2);
            n -= n2;
            this.zzj(n2);
        }
    }
}
