/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.measurement.zzgr
 *  com.google.android.gms.internal.measurement.zzgy
 *  com.google.android.gms.internal.measurement.zzgz
 *  com.google.android.gms.internal.measurement.zzib
 *  com.google.android.gms.internal.measurement.zziy
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgr;
import com.google.android.gms.internal.measurement.zzgy;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zziy;
import java.io.IOException;
import java.util.Arrays;

public final class zzjw {
    private static final zzjw zza = new zzjw(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze = -1;
    private boolean zzf;

    private zzjw() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjw(int n, int[] nArray, Object[] objectArray, boolean bl) {
        this.zzb = n;
        this.zzc = nArray;
        this.zzd = objectArray;
        this.zzf = bl;
    }

    public static zzjw zza() {
        return zza;
    }

    static zzjw zzb() {
        return new zzjw(0, new int[8], new Object[8], true);
    }

    static zzjw zzc(zzjw zzjw2, zzjw zzjw3) {
        int n = zzjw2.zzb + zzjw3.zzb;
        int[] nArray = Arrays.copyOf(zzjw2.zzc, n);
        System.arraycopy(zzjw3.zzc, 0, nArray, zzjw2.zzb, zzjw3.zzb);
        Object[] objectArray = Arrays.copyOf(zzjw2.zzd, n);
        System.arraycopy(zzjw3.zzd, 0, objectArray, zzjw2.zzb, zzjw3.zzb);
        return new zzjw(n, nArray, objectArray, true);
    }

    public final boolean equals(Object objectArray) {
        int n;
        if (this == objectArray) {
            return true;
        }
        if (objectArray == null) {
            return false;
        }
        if (!(objectArray instanceof zzjw)) {
            return false;
        }
        objectArray = (zzjw)objectArray;
        int n2 = this.zzb;
        if (n2 != objectArray.zzb) return false;
        Object[] objectArray2 = this.zzc;
        int[] nArray = objectArray.zzc;
        for (n = 0; n < n2; ++n) {
            if (objectArray2[n] == nArray[n]) continue;
            return false;
        }
        objectArray2 = this.zzd;
        objectArray = objectArray.zzd;
        n2 = this.zzb;
        n = 0;
        while (n < n2) {
            if (!objectArray2[n].equals(objectArray[n])) return false;
            ++n;
        }
        return true;
    }

    public final int hashCode() {
        int n;
        int n2 = this.zzb;
        Object[] objectArray = this.zzc;
        int n3 = 0;
        int n4 = 17;
        int n5 = 17;
        for (n = 0; n < n2; ++n) {
            n5 = n5 * 31 + objectArray[n];
        }
        objectArray = this.zzd;
        int n6 = this.zzb;
        n = n3;
        while (n < n6) {
            n4 = n4 * 31 + objectArray[n].hashCode();
            ++n;
        }
        return ((n2 + 527) * 31 + n5) * 31 + n4;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int n = this.zze;
        if (n != -1) return n;
        int n2 = 0;
        n = 0;
        while (true) {
            if (n2 >= this.zzb) {
                this.zze = n;
                return n;
            }
            int n3 = this.zzc[n2];
            zzgr zzgr2 = (zzgr)this.zzd[n2];
            int n4 = zzgy.zzw((int)8);
            int n5 = zzgr2.zzc();
            n += n4 + n4 + (zzgy.zzw((int)16) + zzgy.zzw((int)(n3 >>> 3))) + (zzgy.zzw((int)24) + (zzgy.zzw((int)n5) + n5));
            ++n2;
        }
    }

    public final int zzf() {
        int n = this.zze;
        if (n != -1) return n;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            block8: {
                block6: {
                    int n4;
                    block7: {
                        block2: {
                            block3: {
                                block4: {
                                    block5: {
                                        if (n2 >= this.zzb) {
                                            this.zze = n3;
                                            return n3;
                                        }
                                        n4 = this.zzc[n2];
                                        n = n4 >>> 3;
                                        if ((n4 &= 7) == 0) break block2;
                                        if (n4 == 1) break block3;
                                        if (n4 == 2) break block4;
                                        if (n4 == 3) break block5;
                                        if (n4 != 5) throw new IllegalStateException((Throwable)zzib.zzd());
                                        ((Integer)this.zzd[n2]).intValue();
                                        n = zzgy.zzw((int)(n << 3)) + 4;
                                        break block6;
                                    }
                                    n = zzgy.zzu((int)n);
                                    n4 = n + n;
                                    n = ((zzjw)this.zzd[n2]).zzf();
                                    break block7;
                                }
                                zzgr zzgr2 = (zzgr)this.zzd[n2];
                                n = zzgy.zzw((int)(n << 3));
                                n4 = zzgr2.zzc();
                                n = n3 + (n + (zzgy.zzw((int)n4) + n4));
                                break block8;
                            }
                            ((Long)this.zzd[n2]).longValue();
                            n = zzgy.zzw((int)(n << 3)) + 8;
                            break block6;
                        }
                        long l = (Long)this.zzd[n2];
                        n4 = zzgy.zzw((int)(n << 3));
                        n = zzgy.zzx((long)l);
                    }
                    n = n4 + n;
                }
                n = n3 + n;
            }
            ++n2;
            n3 = n;
        }
    }

    final void zzg(StringBuilder stringBuilder, int n) {
        int n2 = 0;
        while (n2 < this.zzb) {
            zziy.zzb((StringBuilder)stringBuilder, (int)n, (String)String.valueOf(this.zzc[n2] >>> 3), (Object)this.zzd[n2]);
            ++n2;
        }
    }

    final void zzh(int n, Object object) {
        int n2;
        if (!this.zzf) throw new UnsupportedOperationException();
        int n3 = this.zzb;
        int[] nArray = this.zzc;
        if (n3 == nArray.length) {
            n2 = n3 < 4 ? 8 : n3 >> 1;
            n2 = n3 + n2;
            this.zzc = Arrays.copyOf(nArray, n2);
            this.zzd = Arrays.copyOf(this.zzd, n2);
        }
        nArray = this.zzc;
        n2 = this.zzb;
        nArray[n2] = n;
        this.zzd[n2] = object;
        this.zzb = n2 + 1;
    }

    public final void zzi(zzgz zzgz2) throws IOException {
        if (this.zzb == 0) return;
        int n = 0;
        while (n < this.zzb) {
            int n2 = this.zzc[n];
            Object object = this.zzd[n];
            int n3 = n2 >>> 3;
            if ((n2 &= 7) != 0) {
                if (n2 != 1) {
                    if (n2 != 2) {
                        if (n2 != 3) {
                            if (n2 != 5) throw new RuntimeException((Throwable)zzib.zzd());
                            zzgz2.zzk(n3, ((Integer)object).intValue());
                        } else {
                            zzgz2.zzt(n3);
                            ((zzjw)object).zzi(zzgz2);
                            zzgz2.zzu(n3);
                        }
                    } else {
                        zzgz2.zzn(n3, (zzgr)object);
                    }
                } else {
                    zzgz2.zzj(n3, ((Long)object).longValue());
                }
            } else {
                zzgz2.zzc(n3, ((Long)object).longValue());
            }
            ++n;
        }
    }
}
