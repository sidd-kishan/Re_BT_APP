/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.google.android.gms.internal.ads.zzgej
 *  com.google.android.gms.internal.ads.zzgex
 *  com.google.android.gms.internal.ads.zzgfi
 *  com.google.android.gms.internal.ads.zzgfm
 *  com.google.android.gms.internal.ads.zzgfn
 *  com.google.android.gms.internal.ads.zzgfr
 *  com.google.android.gms.internal.ads.zzgfx
 *  com.google.android.gms.internal.ads.zzgga
 *  com.google.android.gms.internal.ads.zzggm
 *  com.google.android.gms.internal.ads.zzghi
 *  com.google.android.gms.internal.ads.zzght
 *  com.google.android.gms.internal.ads.zzghz
 *  com.google.android.gms.internal.ads.zzgib
 *  com.google.android.gms.internal.ads.zzgio
 *  com.google.android.gms.internal.ads.zzgip
 */
package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgej;
import com.google.android.gms.internal.ads.zzgex;
import com.google.android.gms.internal.ads.zzgfi;
import com.google.android.gms.internal.ads.zzgfm;
import com.google.android.gms.internal.ads.zzgfn;
import com.google.android.gms.internal.ads.zzgfr;
import com.google.android.gms.internal.ads.zzgfx;
import com.google.android.gms.internal.ads.zzgga;
import com.google.android.gms.internal.ads.zzggm;
import com.google.android.gms.internal.ads.zzghi;
import com.google.android.gms.internal.ads.zzght;
import com.google.android.gms.internal.ads.zzghz;
import com.google.android.gms.internal.ads.zzgib;
import com.google.android.gms.internal.ads.zzgio;
import com.google.android.gms.internal.ads.zzgip;
import java.io.IOException;

final class zzghm<T>
implements zzghz<T> {
    private final zzghi zza;
    private final zzgio<?, ?> zzb;
    private final boolean zzc;
    private final zzgfn<?> zzd;

    private zzghm(zzgio<?, ?> zzgio2, zzgfn<?> zzgfn2, zzghi zzghi2) {
        this.zzb = zzgio2;
        this.zzc = zzgfn2.zza(zzghi2);
        this.zzd = zzgfn2;
        this.zza = zzghi2;
    }

    static <T> zzghm<T> zzg(zzgio<?, ?> zzgio2, zzgfn<?> zzgfn2, zzghi zzghi2) {
        return new zzghm<T>(zzgio2, zzgfn2, zzghi2);
    }

    public final T zza() {
        return (T)this.zza.zzaM().zzak();
    }

    public final boolean zzb(T t, T t2) {
        if (!this.zzb.zzj(t).equals(this.zzb.zzj(t2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zzb(t);
        this.zzd.zzb(t2);
        throw null;
    }

    public final int zzc(T t) {
        int n = this.zzb.zzj(t).hashCode();
        if (!this.zzc) {
            return n;
        }
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzd(T t, T t2) {
        zzgib.zzF(this.zzb, t, t2);
        if (!this.zzc) return;
        zzgib.zzE(this.zzd, t, t2);
    }

    public final int zze(T t) {
        zzgio<?, ?> zzgio2 = this.zzb;
        int n = zzgio2.zzp(zzgio2.zzj(t));
        if (!this.zzc) {
            return n;
        }
        this.zzd.zzb(t);
        throw null;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final void zzf(T t, zzght zzght2, zzgfm zzgfm2) throws IOException {
        zzgio<?, ?> zzgio2 = this.zzb;
        zzgfn<?> zzgfn2 = this.zzd;
        Object object = zzgio2.zzk(t);
        zzgfr zzgfr2 = zzgfn2.zzc(t);
        while (true) {
            Object object2;
            int n;
            block13: {
                block14: {
                    try {
                        while (zzght2.zzb() != Integer.MAX_VALUE) {
                            boolean bl;
                            n = zzght2.zzc();
                            if (n == 11) break block13;
                            if ((n & 7) == 2) {
                                object2 = zzgfn2.zzf(zzgfm2, this.zza, n >>> 3);
                                if (object2 != null) {
                                    zzgfn2.zzg(zzght2, object2, zzgfm2, zzgfr2);
                                    continue;
                                }
                                bl = zzgio2.zzn(object, zzght2);
                            } else {
                                bl = zzght2.zzd();
                            }
                            if (bl) continue;
                            break block14;
                        }
                        break;
                    }
                    catch (Throwable throwable) {
                        zzgio2.zzl(t, object);
                        throw throwable;
                    }
                }
                zzgio2.zzl(t, object);
                return;
            }
            n = 0;
            Object object3 = null;
            object2 = null;
            {
                while (zzght2.zzb() != Integer.MAX_VALUE) {
                    int n2 = zzght2.zzc();
                    if (n2 == 16) {
                        n = zzght2.zzr();
                        object3 = zzgfn2.zzf(zzgfm2, this.zza, n);
                        continue;
                    }
                    if (n2 == 26) {
                        if (object3 != null) {
                            zzgfn2.zzg(zzght2, object3, zzgfm2, zzgfr2);
                            continue;
                        }
                        object2 = zzght2.zzq();
                        continue;
                    }
                    if (zzght2.zzd()) continue;
                }
                if (zzght2.zzc() != 12) throw zzggm.zzh();
                if (object2 == null) continue;
                if (object3 != null) {
                    zzgfn2.zzh((zzgex)object2, object3, zzgfm2, zzgfr2);
                    continue;
                }
                zzgio2.zze(object, n, (zzgex)object2);
                continue;
            }
            break;
        }
        zzgio2.zzl(t, object);
    }

    public final void zzi(T object, byte[] object2, int n, int n2, zzgej zzgej2) throws IOException {
        object2 = (zzgga)object;
        if (object2.zzc == zzgip.zza()) {
            object2.zzc = zzgip.zzb();
        }
        object = (zzgfx)object;
        throw null;
    }

    public final void zzj(T t) {
        this.zzb.zzm(t);
        this.zzd.zzd(t);
    }

    public final boolean zzk(T t) {
        this.zzd.zzb(t);
        throw null;
    }

    public final void zzn(T t, zzgfi zzgfi2) throws IOException {
        this.zzd.zzb(t);
        throw null;
    }
}
