/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  com.google.android.gms.ads.internal.overlay.zzf
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.internal.ads.zzcml;

public final class zzh {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzh(zzcml zzcml2) throws zzf {
        this.zzb = zzcml2.getLayoutParams();
        ViewParent viewParent = zzcml2.getParent();
        this.zzd = zzcml2.zzM();
        if (viewParent == null) throw new zzf("Could not get the parent of the WebView for an overlay.");
        if (!(viewParent instanceof ViewGroup)) throw new zzf("Could not get the parent of the WebView for an overlay.");
        viewParent = (ViewGroup)viewParent;
        this.zzc = viewParent;
        this.zza = viewParent.indexOfChild(zzcml2.zzH());
        this.zzc.removeView(zzcml2.zzH());
        zzcml2.zzag(true);
    }
}
