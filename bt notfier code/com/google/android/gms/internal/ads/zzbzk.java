/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.webkit.WebView
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzbzl
 *  com.google.android.gms.internal.ads.zzbzm
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzbzl;
import com.google.android.gms.internal.ads.zzbzm;

public interface zzbzk {
    public boolean zza(Context var1);

    public String zzc(Context var1);

    public IObjectWrapper zzd(String var1, WebView var2, String var3, String var4, String var5, zzbzm var6, zzbzl var7, String var8);

    public IObjectWrapper zze(String var1, WebView var2, String var3, String var4, String var5, String var6, zzbzm var7, zzbzl var8, String var9);

    public void zzf(IObjectWrapper var1);

    public void zzg(IObjectWrapper var1);

    public void zzh(IObjectWrapper var1, View var2);

    public void zzi(IObjectWrapper var1, View var2);
}
