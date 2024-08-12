/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfh
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfh;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghk;
import java.io.IOException;
import java.util.Arrays;

public final class zzgip {
    private static final zzgip zza = new zzgip(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze = -1;
    private boolean zzf;

    private zzgip() {
        this(0, new int[8], new Object[8], true);
    }

    private zzgip(int n, int[] nArray, Object[] objectArray, boolean bl) {
        this.zzb = n;
        this.zzc = nArray;
        this.zzd = objectArray;
        this.zzf = bl;
    }

    public static zzgip zza() {
        return zza;
    }

    static zzgip zzb() {
        return new zzgip(0, new int[8], new Object[8], true);
    }

    static zzgip zzc(zzgip zzgip2, zzgip zzgip3) {
        int n = zzgip2.zzb + zzgip3.zzb;
        int[] nArray = Arrays.copyOf(zzgip2.zzc, n);
        System.arraycopy(zzgip3.zzc, 0, nArray, zzgip2.zzb, zzgip3.zzb);
        Object[] objectArray = Arrays.copyOf(zzgip2.zzd, n);
        System.arraycopy(zzgip3.zzd, 0, objectArray, zzgip2.zzb, zzgip3.zzb);
        return new zzgip(n, nArray, objectArray, true);
    }

    public final boolean equals(Object objectArray) {
        int n;
        if (this == objectArray) {
            return true;
        }
        if (objectArray == null) {
            return false;
        }
        if (!(objectArray instanceof zzgip)) {
            return false;
        }
        objectArray = (zzgip)objectArray;
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
        n = n4;
        while (n3 < n6) {
            n = n * 31 + objectArray[n3].hashCode();
            ++n3;
        }
        return ((n2 + 527) * 31 + n5) * 31 + n;
    }

    public final void zzd() {
        this.zzf = false;
    }

    public final int zze() {
        int n = this.zze;
        if (n != -1) return n;
        n = 0;
        int n2 = 0;
        while (true) {
            if (n >= this.zzb) {
                this.zze = n2;
                return n2;
            }
            int n3 = this.zzc[n];
            zzgex zzgex2 = (zzgex)this.zzd[n];
            int n4 = zzgfh.zzx((int)8);
            int n5 = zzgex2.zzc();
            n2 += n4 + n4 + (zzgfh.zzx((int)16) + zzgfh.zzx((int)(n3 >>> 3))) + (zzgfh.zzx((int)24) + (zzgfh.zzx((int)n5) + n5));
            ++n;
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
                                        if (n4 != 5) throw new IllegalStateException((Throwable)zzggm.zzi());
                                        ((Integer)this.zzd[n2]).intValue();
                                        n = zzgfh.zzx((int)(n << 3)) + 4;
                                        break block6;
                                    }
                                    n = zzgfh.zzv((int)n);
                                    n4 = n + n;
                                    n = ((zzgip)this.zzd[n2]).zzf();
                                    break block7;
                                }
                                zzgex zzgex2 = (zzgex)this.zzd[n2];
                                n4 = zzgfh.zzx((int)(n << 3));
                                n = zzgex2.zzc();
                                n = n3 + (n4 + (zzgfh.zzx((int)n) + n));
                                break block8;
                            }
                            ((Long)this.zzd[n2]).longValue();
                            n = zzgfh.zzx((int)(n << 3)) + 8;
                            break block6;
                        }
                        long l = (Long)this.zzd[n2];
                        n4 = zzgfh.zzx((int)(n << 3));
                        n = zzgfh.zzy((long)l);
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
            zzghk.zzb((StringBuilder)stringBuilder, (int)n, (String)String.valueOf(this.zzc[n2] >>> 3), (Object)this.zzd[n2]);
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

    public final void zzi(zzgfi zzgfi2) throws IOException {
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
                            if (n2 != 5) throw new RuntimeException((Throwable)zzggm.zzi());
                            zzgfi2.zzk(n3, ((Integer)object).intValue());
                        } else {
                            zzgfi2.zzt(n3);
                            ((zzgip)object).zzi(zzgfi2);
                            zzgfi2.zzu(n3);
                        }
                    } else {
                        zzgfi2.zzn(n3, (zzgex)object);
                    }
                } else {
                    zzgfi2.zzj(n3, ((Long)object).longValue());
                }
            } else {
                zzgfi2.zzc(n3, ((Long)object).longValue());
            }
            ++n;
        }
    }
}
