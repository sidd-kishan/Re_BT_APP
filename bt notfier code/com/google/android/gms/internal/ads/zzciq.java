/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbjs
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzcip
 *  com.google.android.gms.internal.ads.zzcja
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbjs;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzcip;
import com.google.android.gms.internal.ads.zzcja;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcml;

public final class zzciq {
    private final Context zza;
    private final zzcjb zzb;
    private final ViewGroup zzc;
    private zzcip zzd;

    public zzciq(Context context, ViewGroup viewGroup, zzcml zzcml2) {
        Context context2 = context;
        if (context.getApplicationContext() != null) {
            context2 = context.getApplicationContext();
        }
        this.zza = context2;
        this.zzc = viewGroup;
        this.zzb = zzcml2;
        this.zzd = null;
    }

    public final void zza(int n, int n2, int n3, int n4) {
        Preconditions.checkMainThread((String)"The underlay may only be modified from the UI thread.");
        zzcip zzcip2 = this.zzd;
        if (zzcip2 == null) return;
        zzcip2.zzm(n, n2, n3, n4);
    }

    public final void zzb(int n, int n2, int n3, int n4, int n5, boolean bl, zzcja zzcja2) {
        if (this.zzd != null) {
            return;
        }
        zzbjs.zza((zzbka)this.zzb.zzq().zzc(), (zzbjx)this.zzb.zzi(), (String[])new String[]{"vpr2"});
        Context context = this.zza;
        zzcjb zzcjb2 = this.zzb;
        zzcja2 = new zzcip(context, zzcjb2, n5, bl, zzcjb2.zzq().zzc(), zzcja2);
        this.zzd = zzcja2;
        this.zzc.addView((View)zzcja2, 0, new ViewGroup.LayoutParams(-1, -1));
        this.zzd.zzm(n, n2, n3, n4);
        this.zzb.zzg(false);
    }

    public final zzcip zzc() {
        Preconditions.checkMainThread((String)"getAdVideoUnderlay must be called from the UI thread.");
        return this.zzd;
    }

    public final void zzd() {
        Preconditions.checkMainThread((String)"onPause must be called from the UI thread.");
        zzcip zzcip2 = this.zzd;
        if (zzcip2 == null) return;
        zzcip2.zzq();
    }

    public final void zze() {
        Preconditions.checkMainThread((String)"onDestroy must be called from the UI thread.");
        zzcip zzcip2 = this.zzd;
        if (zzcip2 == null) return;
        zzcip2.zzD();
        this.zzc.removeView((View)this.zzd);
        this.zzd = null;
    }

    public final void zzf(int n) {
        Preconditions.checkMainThread((String)"setPlayerBackgroundColor must be called from the UI thread.");
        zzcip zzcip2 = this.zzd;
        if (zzcip2 == null) return;
        zzcip2.zzl(n);
    }
}
