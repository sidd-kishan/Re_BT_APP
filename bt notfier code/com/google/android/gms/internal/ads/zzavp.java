/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.WindowManager
 *  com.google.android.gms.internal.ads.zzavo
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.WindowManager;
import com.google.android.gms.internal.ads.zzavo;

public final class zzavp {
    private final zzavo zza;
    private final boolean zzb;
    private final long zzc;
    private final long zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private boolean zzh;
    private long zzi;
    private long zzj;
    private long zzk;

    public zzavp() {
        this(-1.0);
    }

    private zzavp(double d) {
        long l;
        boolean bl = d != -1.0;
        this.zzb = bl;
        if (bl) {
            this.zza = zzavo.zza();
            this.zzc = l = (long)(1.0E9 / d);
            l = l * 80L / 100L;
        } else {
            this.zza = null;
            l = -1L;
            this.zzc = -1L;
        }
        this.zzd = l;
    }

    public zzavp(Context context) {
        double d = (context = (WindowManager)context.getSystemService("window")).getDefaultDisplay() != null ? (double)context.getDefaultDisplay().getRefreshRate() : -1.0;
        this(d);
    }

    private final boolean zzd(long l, long l2) {
        long l3 = this.zzj;
        if (Math.abs(l2 - this.zzi - (l - l3)) <= 20000000L) return false;
        return true;
    }

    public final void zza() {
        this.zzh = false;
        if (!this.zzb) return;
        this.zza.zzb();
    }

    public final void zzb() {
        if (!this.zzb) return;
        this.zza.zzc();
    }

    public final long zzc(long l, long l2) {
        long l3;
        long l4;
        long l5;
        block9: {
            block6: {
                block7: {
                    block8: {
                        l5 = 1000L * l;
                        if (!this.zzh) break block6;
                        if (l != this.zze) {
                            ++this.zzk;
                            this.zzf = this.zzg;
                        }
                        if ((l4 = this.zzk) < 6L) break block7;
                        l3 = this.zzf + (l4 = (l5 - this.zzj) / l4);
                        if (!this.zzd(l3, l2)) break block8;
                        this.zzh = false;
                        break block6;
                    }
                    l4 = this.zzi + l3 - this.zzj;
                    break block9;
                }
                if (this.zzd(l5, l2)) {
                    this.zzh = false;
                }
            }
            l4 = l2;
            l3 = l5;
        }
        if (!this.zzh) {
            this.zzj = l5;
            this.zzi = l2;
            this.zzk = 0L;
            this.zzh = true;
        }
        this.zze = l;
        this.zzg = l3;
        zzavo zzavo2 = this.zza;
        if (zzavo2 == null) return l4;
        if (zzavo2.zza == 0L) {
            return l4;
        }
        l2 = this.zza.zza;
        l = this.zzc;
        if (l4 <= (l2 += (l4 - l2) / l * l)) {
            l = l2 - l;
        } else {
            l3 = l + l2;
            l = l2;
            l2 = l3;
        }
        if (l2 - l4 >= l4 - l) return l - this.zzd;
        l = l2;
        return l - this.zzd;
    }
}
