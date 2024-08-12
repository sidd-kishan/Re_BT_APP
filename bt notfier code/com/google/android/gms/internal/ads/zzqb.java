/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzaha
 *  com.google.android.gms.internal.ads.zzakt
 *  com.google.android.gms.internal.ads.zznp
 *  com.google.android.gms.internal.ads.zznv
 *  com.google.android.gms.internal.ads.zzpz
 *  com.google.android.gms.internal.ads.zzqc
 *  com.google.android.gms.internal.ads.zzqe
 *  com.google.android.gms.internal.ads.zzqi
 *  com.google.android.gms.internal.ads.zzqk
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzaha;
import com.google.android.gms.internal.ads.zzakt;
import com.google.android.gms.internal.ads.zznp;
import com.google.android.gms.internal.ads.zznv;
import com.google.android.gms.internal.ads.zzpz;
import com.google.android.gms.internal.ads.zzqc;
import com.google.android.gms.internal.ads.zzqe;
import com.google.android.gms.internal.ads.zzqi;
import com.google.android.gms.internal.ads.zzqk;
import java.io.IOException;
import java.util.ArrayDeque;

final class zzqb {
    private final byte[] zza = new byte[8];
    private final ArrayDeque<zzpz> zzb = new ArrayDeque();
    private final zzqk zzc = new zzqk();
    private zzqc zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zznv zznv2, int n) throws IOException {
        byte[] byArray = this.zza;
        zznv2 = (zznp)zznv2;
        int n2 = 0;
        zznv2.zza(byArray, 0, n, false);
        long l = 0L;
        while (n2 < n) {
            l = l << 8 | (long)(this.zza[n2] & 0xFF);
            ++n2;
        }
        return l;
    }

    public final void zza(zzqc zzqc2) {
        this.zzd = zzqc2;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zza();
    }

    public final boolean zzc(zznv object) throws IOException {
        zzakt.zze((Object)this.zzd);
        while (true) {
            int n;
            Object object2;
            long l;
            long l2;
            int n2;
            zzpz zzpz2;
            block20: {
                block21: {
                    block18: {
                        block19: {
                            block17: {
                                if ((zzpz2 = this.zzb.peek()) != null && object.zzn() >= zzpz.zzb((zzpz)zzpz2)) {
                                    object = this.zzd;
                                    n2 = zzpz.zza((zzpz)this.zzb.pop());
                                    ((zzqe)object).zza.zzi(n2);
                                    return true;
                                }
                                n2 = this.zze;
                                if (n2 != 0) break block17;
                                l = l2 = this.zzc.zzb((zznv)object, true, false, 4);
                                if (l2 != -2L) break block18;
                                break block19;
                            }
                            if (n2 != 1) break block20;
                            break block21;
                        }
                        object.zzl();
                        while (true) {
                            object2 = this.zza;
                            zzpz2 = (zznp)object;
                            zzpz2.zzh(object2, 0, 4, false);
                            n2 = zzqk.zzd((int)this.zza[0]);
                            if (n2 != -1 && n2 <= 4) {
                                n = (int)zzqk.zze((byte[])this.zza, (int)n2, (boolean)false);
                                object2 = ((zzqe)this.zzd).zza;
                                if (zzqi.zzo((int)n)) {
                                    zzpz2.zzd(n2, false);
                                    l = n;
                                    break;
                                }
                            }
                            zzpz2.zzd(1, false);
                        }
                    }
                    if (l == -1L) {
                        return false;
                    }
                    this.zzf = (int)l;
                    this.zze = 1;
                }
                this.zzg = this.zzc.zzb((zznv)object, false, true, 8);
                this.zze = 2;
            }
            zzpz2 = this.zzd;
            n2 = this.zzf;
            zzpz2 = ((zzqe)zzpz2).zza;
            if ((n2 = zzqi.zzn((int)n2)) != 0) {
                if (n2 == 1) {
                    l = object.zzn();
                    l2 = this.zzg;
                    this.zzb.push(new zzpz(this.zzf, l2 + l, null));
                    object = this.zzd;
                    n2 = this.zzf;
                    l2 = this.zzg;
                    ((zzqe)object).zza.zzh(n2, l, l2);
                    this.zze = 0;
                    return true;
                }
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            zzpz2 = this.zzd;
                            n2 = this.zzf;
                            l = this.zzg;
                            ((zzqe)zzpz2).zza.zzm(n2, (int)l, (zznv)object);
                            this.zze = 0;
                            return true;
                        }
                        l = this.zzg;
                        if (l != 4L && l != 8L) {
                            object = new StringBuilder(40);
                            ((StringBuilder)object).append("Invalid float size: ");
                            ((StringBuilder)object).append(l);
                            throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
                        }
                        zzpz2 = this.zzd;
                        n2 = this.zzf;
                        n = (int)l;
                        l = this.zzd((zznv)object, n);
                        double d = n == 4 ? (double)Float.intBitsToFloat((int)l) : Double.longBitsToDouble(l);
                        ((zzqe)zzpz2).zza.zzk(n2, d);
                        this.zze = 0;
                        return true;
                    }
                    l = this.zzg;
                    if (l > Integer.MAX_VALUE) {
                        object = new StringBuilder(41);
                        ((StringBuilder)object).append("String element size: ");
                        ((StringBuilder)object).append(l);
                        throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
                    }
                    zzpz2 = this.zzd;
                    int n3 = this.zzf;
                    n2 = (int)l;
                    if (n2 == 0) {
                        object = "";
                    } else {
                        object2 = new byte[n2];
                        ((zznp)object).zza(object2, 0, n2, false);
                        while (n2 > 0 && object2[n = n2 - 1] == 0) {
                            n2 = n;
                        }
                        object = new String((byte[])object2, 0, n2);
                    }
                    ((zzqe)zzpz2).zza.zzl(n3, (String)object);
                    this.zze = 0;
                    return true;
                }
                l = this.zzg;
                if (l <= 8L) {
                    zzpz2 = this.zzd;
                    n2 = this.zzf;
                    l = this.zzd((zznv)object, (int)l);
                    ((zzqe)zzpz2).zza.zzj(n2, l);
                    this.zze = 0;
                    return true;
                }
                object = new StringBuilder(42);
                ((StringBuilder)object).append("Invalid integer size: ");
                ((StringBuilder)object).append(l);
                throw zzaha.zzb((String)((StringBuilder)object).toString(), null);
            }
            l = this.zzg;
            ((zznp)object).zzd((int)l, false);
            this.zze = 0;
        }
    }
}
