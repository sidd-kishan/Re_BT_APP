/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.webkit.WebView
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbzk
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;

public final class zzeeb
implements zzbzk {
    private final zzbzk zza;
    private final zzbzk zzb;

    public zzeeb(zzbzk zzbzk2, zzbzk zzbzk3) {
        this.zza = zzbzk2;
        this.zzb = zzbzk3;
    }

    private final zzbzk zzb() {
        zzbjd zzbjd2 = zzbjl.zzdw;
        zzbjd2 = (Boolean)zzbet.zzc().zzc(zzbjd2) != false ? this.zza : this.zzb;
        return zzbjd2;
    }

    public final boolean zza(Context context) {
        return this.zzb().zza(context);
    }

    public final String zzc(Context context) {
        return this.zzb().zzc(context);
    }

    public final IObjectWrapper zzd(String string, WebView webView, String string2, String string3, String string4, zzbzm zzbzm2, zzbzl zzbzl2, String string5) {
        return this.zzb().zzd(string, webView, "", "javascript", string4, zzbzm2, zzbzl2, string5);
    }

    public final IObjectWrapper zze(String string, WebView webView, String string2, String string3, String string4, String string5, zzbzm zzbzm2, zzbzl zzbzl2, String string6) {
        return this.zzb().zze(string, webView, "", "javascript", string4, string5, zzbzm2, zzbzl2, string6);
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        this.zzb().zzf(iObjectWrapper);
    }

    public final void zzg(IObjectWrapper iObjectWrapper) {
        this.zzb().zzg(iObjectWrapper);
    }

    public final void zzh(IObjectWrapper iObjectWrapper, View view) {
        this.zzb().zzh(iObjectWrapper, view);
    }

    public final void zzi(IObjectWrapper iObjectWrapper, View view) {
        this.zzb().zzi(iObjectWrapper, view);
    }
}
