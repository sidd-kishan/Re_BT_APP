/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  com.google.android.gms.internal.ads.zzafv
 *  com.google.android.gms.internal.ads.zzamq
 *  com.google.android.gms.internal.ads.zzaz
 *  com.google.android.gms.internal.ads.zzba
 *  com.google.android.gms.internal.ads.zzdf
 *  com.google.android.gms.internal.ads.zzdg
 *  com.google.android.gms.internal.ads.zzdh
 *  com.google.android.gms.internal.ads.zzdi
 *  com.google.android.gms.internal.ads.zzdj
 *  com.google.android.gms.internal.ads.zzdk
 *  com.google.android.gms.internal.ads.zzdl
 *  com.google.android.gms.internal.ads.zzdm
 *  com.google.android.gms.internal.ads.zzdn
 *  com.google.android.gms.internal.ads.zzdo
 *  com.google.android.gms.internal.ads.zzdq
 */
package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.internal.ads.zzafv;
import com.google.android.gms.internal.ads.zzamq;
import com.google.android.gms.internal.ads.zzaz;
import com.google.android.gms.internal.ads.zzba;
import com.google.android.gms.internal.ads.zzdf;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzdh;
import com.google.android.gms.internal.ads.zzdi;
import com.google.android.gms.internal.ads.zzdj;
import com.google.android.gms.internal.ads.zzdk;
import com.google.android.gms.internal.ads.zzdl;
import com.google.android.gms.internal.ads.zzdm;
import com.google.android.gms.internal.ads.zzdn;
import com.google.android.gms.internal.ads.zzdo;
import com.google.android.gms.internal.ads.zzdq;

public final class zzdp {
    private final Handler zza;
    private final zzdq zzb;

    public zzdp(Handler handler, zzdq zzdq2) {
        if (zzdq2 == null) {
            handler = null;
        }
        this.zza = handler;
        this.zzb = zzdq2;
    }

    public final void zza(zzaz zzaz2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdf(this, zzaz2));
    }

    public final void zzb(String string, long l, long l2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdg(this, string, l, l2));
    }

    public final void zzc(zzafv zzafv2, zzba zzba2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdh(this, zzafv2, zzba2));
    }

    public final void zzd(long l) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdi(this, l));
    }

    public final void zze(int n, long l, long l2) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdj(this, n, l, l2));
    }

    public final void zzf(String string) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdk(this, string));
    }

    public final void zzg(zzaz zzaz2) {
        zzaz2.zza();
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdl(this, zzaz2));
    }

    public final void zzh(boolean bl) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdm(this, bl));
    }

    public final void zzi(Exception exception) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdn(this, exception));
    }

    public final void zzj(Exception exception) {
        Handler handler = this.zza;
        if (handler == null) return;
        handler.post((Runnable)new zzdo(this, exception));
    }

    final /* synthetic */ void zzk(Exception exception) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzp(exception);
    }

    final /* synthetic */ void zzl(Exception exception) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzo(exception);
    }

    final /* synthetic */ void zzm(boolean bl) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzn(bl);
    }

    final /* synthetic */ void zzn(zzaz zzaz2) {
        zzaz2.zza();
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzm(zzaz2);
    }

    final /* synthetic */ void zzo(String string) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzl(string);
    }

    final /* synthetic */ void zzp(int n, long l, long l2) {
        zzdq zzdq2 = this.zzb;
        int n2 = zzamq.zza;
        zzdq2.zzk(n, l, l2);
    }

    final /* synthetic */ void zzq(long l) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzj(l);
    }

    final /* synthetic */ void zzr(zzafv zzafv2, zzba zzba2) {
        int n = zzamq.zza;
        this.zzb.zzi(zzafv2, zzba2);
    }

    final /* synthetic */ void zzs(String string, long l, long l2) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzh(string, l, l2);
    }

    final /* synthetic */ void zzt(zzaz zzaz2) {
        zzdq zzdq2 = this.zzb;
        int n = zzamq.zza;
        zzdq2.zzg(zzaz2);
    }
}
