/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzmj
 *  com.google.android.gms.internal.ads.zzmk
 *  com.google.android.gms.internal.ads.zzml
 *  com.google.android.gms.internal.ads.zzmm
 *  com.google.android.gms.internal.ads.zzmn
 *  com.google.android.gms.internal.ads.zzmo
 *  com.google.android.gms.internal.ads.zzmp
 *  com.google.android.gms.internal.ads.zzmq
 *  com.google.android.gms.internal.ads.zzmr
 *  com.google.android.gms.internal.ads.zzms
 *  com.google.android.gms.internal.ads.zzmu
 *  com.google.android.gms.internal.ads.zzy
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzmj;
import com.google.android.gms.internal.ads.zzmk;
import com.google.android.gms.internal.ads.zzml;
import com.google.android.gms.internal.ads.zzmm;
import com.google.android.gms.internal.ads.zzmn;
import com.google.android.gms.internal.ads.zzmo;
import com.google.android.gms.internal.ads.zzmp;
import com.google.android.gms.internal.ads.zzmq;
import com.google.android.gms.internal.ads.zzmr;
import com.google.android.gms.internal.ads.zzms;
import com.google.android.gms.internal.ads.zzmu;
import com.google.android.gms.internal.ads.zzy;

public final class zzmt {
    private final Handler zza;
    private final zzmu zzb;

    public zzmt(Handler handler, zzmu zzmu2) {
        if (zzmu2 == null) {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzmu2;
    }

    public final void zza(zzaz zzaz2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmj(this, zzaz2));
    }

    public final void zzb(String string, long l, long l2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmk(this, string, l, l2));
    }

    public final void zzc(zzafv zzafv2, zzba zzba2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzml(this, zzafv2, zzba2));
    }

    public final void zzd(int n, long l) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmm(this, n, l));
    }

    public final void zze(long l, int n) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmn(this, l, n));
    }

    public final void zzf(zzy zzy2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmo(this, zzy2));
    }

    public final void zzg(Object object) {
        if (this.zza == null) return;
        long l = SystemClock.elapsedRealtime();
        this.zza.post((Runnable)new zzmp(this, object, l));
    }

    public final void zzh(String string) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmq(this, string));
    }

    public final void zzi(zzaz zzaz2) {
        zzaz2.zza();
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzmr(this, zzaz2));
    }

    public final void zzj(Exception exception) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzms(this, exception));
    }

    final /* synthetic */ void zzk(Exception exception) {
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzA(exception);
    }

    final /* synthetic */ void zzl(zzaz zzaz2) {
        zzaz2.zza();
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzw(zzaz2);
    }

    final /* synthetic */ void zzm(String string) {
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzv(string);
    }

    final /* synthetic */ void zzn(Object object, long l) {
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzy(object, l);
    }

    final /* synthetic */ void zzo(zzy zzy2) {
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzx(zzy2);
    }

    final /* synthetic */ void zzp(long l, int n) {
        zzmu zzmu2 = this.zzb;
        int n2 = zzamq.zza;
        zzmu2.zzz(l, n);
    }

    final /* synthetic */ void zzq(int n, long l) {
        zzmu zzmu2 = this.zzb;
        int n2 = zzamq.zza;
        zzmu2.zzu(n, l);
    }

    final /* synthetic */ void zzr(zzafv zzafv2, zzba zzba2) {
        int n = zzamq.zza;
        this.zzb.zzt(zzafv2, zzba2);
    }

    final /* synthetic */ void zzs(String string, long l, long l2) {
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzs(string, l, l2);
    }

    final /* synthetic */ void zzt(zzaz zzaz2) {
        zzmu zzmu2 = this.zzb;
        int n = zzamq.zza;
        zzmu2.zzr(zzaz2);
    }
}
