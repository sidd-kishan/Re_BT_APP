/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzalf
 *  com.google.android.gms.internal.ads.zzalg
 *  com.google.android.gms.internal.ads.zzamk
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzalf;
import com.google.android.gms.internal.ads.zzalg;
import com.google.android.gms.internal.ads.zzamk;
import java.util.ArrayList;
import java.util.List;

final class zzaml
implements zzalg {
    private static final List<zzamk> zza = new ArrayList<zzamk>(50);
    private final Handler zzb;

    public zzaml(Handler handler) {
        this.zzb = handler;
    }

    static /* synthetic */ void zzk(zzamk zzamk2) {
        List<zzamk> list = zza;
        synchronized (list) {
            if (zza.size() >= 50) return;
            zza.add(zzamk2);
            return;
        }
    }

    private static zzamk zzl() {
        List<zzamk> list = zza;
        synchronized (list) {
            zzamk zzamk2 = zza.isEmpty() ? new zzamk(null) : zza.remove(zza.size() - 1);
            return zzamk2;
        }
    }

    public final boolean zza(int n) {
        return this.zzb.hasMessages(0);
    }

    public final zzalf zzb(int n) {
        zzamk zzamk2 = zzaml.zzl();
        zzamk2.zzb(this.zzb.obtainMessage(n), this);
        return zzamk2;
    }

    public final zzalf zzc(int n, Object object) {
        zzamk zzamk2 = zzaml.zzl();
        zzamk2.zzb(this.zzb.obtainMessage(n, object), this);
        return zzamk2;
    }

    public final zzalf zzd(int n, int n2, int n3) {
        zzamk zzamk2 = zzaml.zzl();
        zzamk2.zzb(this.zzb.obtainMessage(1, n2, n3), this);
        return zzamk2;
    }

    public final boolean zze(zzalf zzalf2) {
        Handler handler = this.zzb;
        return ((zzamk)zzalf2).zzc(handler);
    }

    public final boolean zzf(int n) {
        return this.zzb.sendEmptyMessage(n);
    }

    public final boolean zzg(int n, long l) {
        return this.zzb.sendEmptyMessageAtTime(2, l);
    }

    public final void zzh(int n) {
        this.zzb.removeMessages(2);
    }

    public final void zzi(Object object) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    public final boolean zzj(Runnable runnable) {
        return this.zzb.post(runnable);
    }
}
