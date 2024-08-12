/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzl
 *  com.google.android.gms.common.util.Predicate
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzawd
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbjy
 *  com.google.android.gms.internal.ads.zzblq
 *  com.google.android.gms.internal.ads.zzblt
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbsi
 *  com.google.android.gms.internal.ads.zzbsw
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcla
 *  com.google.android.gms.internal.ads.zzcmc
 *  com.google.android.gms.internal.ads.zzcnh
 *  com.google.android.gms.internal.ads.zzcni
 *  com.google.android.gms.internal.ads.zzcnn
 *  com.google.android.gms.internal.ads.zzcnr
 *  com.google.android.gms.internal.ads.zzcnu
 *  com.google.android.gms.internal.ads.zzcnv
 *  com.google.android.gms.internal.ads.zzcnw
 *  com.google.android.gms.internal.ads.zzcnz
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzfsm
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbjy;
import com.google.android.gms.internal.ads.zzblq;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbsi;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzcmc;
import com.google.android.gms.internal.ads.zzcnh;
import com.google.android.gms.internal.ads.zzcni;
import com.google.android.gms.internal.ads.zzcnn;
import com.google.android.gms.internal.ads.zzcnr;
import com.google.android.gms.internal.ads.zzcnu;
import com.google.android.gms.internal.ads.zzcnv;
import com.google.android.gms.internal.ads.zzcnw;
import com.google.android.gms.internal.ads.zzcnz;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzfsm;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public interface zzcml
extends zzbcv,
zzdio,
zzcmc,
zzbsi,
zzcni,
zzcnn,
zzbsw,
zzawd,
zzcnr,
com.google.android.gms.ads.internal.zzl,
zzcnu,
zzcnv,
zzcjb,
zzcnw {
    public boolean canGoBack();

    public void destroy();

    public Context getContext();

    public int getHeight();

    public ViewGroup.LayoutParams getLayoutParams();

    public void getLocationOnScreen(int[] var1);

    public int getMeasuredHeight();

    public int getMeasuredWidth();

    public ViewParent getParent();

    public int getWidth();

    public void goBack();

    public void loadData(String var1, String var2, String var3);

    public void loadDataWithBaseURL(String var1, String var2, String var3, String var4, String var5);

    public void loadUrl(String var1);

    public void measure(int var1, int var2);

    public void onPause();

    public void onResume();

    public void setBackgroundColor(int var1);

    public void setOnClickListener(View.OnClickListener var1);

    public void setOnTouchListener(View.OnTouchListener var1);

    public void setWebChromeClient(WebChromeClient var1);

    public void setWebViewClient(WebViewClient var1);

    public zzezz zzF();

    public WebView zzG();

    public View zzH();

    public void zzI();

    public void zzJ(int var1);

    public void zzK();

    public void zzL();

    public Context zzM();

    public zzl zzN();

    public zzl zzO();

    public zzcob zzP();

    public String zzQ();

    public zzcnz zzR();

    public WebViewClient zzS();

    public boolean zzT();

    public zzaas zzU();

    public IObjectWrapper zzV();

    public boolean zzW();

    public boolean zzX();

    public void zzY();

    public boolean zzZ();

    public boolean zzaA();

    public zzfac zzaB();

    public void zzaC(zzezz var1, zzfac var2);

    public void zzaD(boolean var1);

    public zzfsm<String> zzaE();

    public boolean zzaa();

    public void zzab(String var1, zzbpr<? super zzcml> var2);

    public void zzac(String var1, zzbpr<? super zzcml> var2);

    public void zzad(String var1, Predicate<zzbpr<? super zzcml>> var2);

    public void zzae(zzl var1);

    public void zzaf(zzcob var1);

    public void zzag(boolean var1);

    public void zzah();

    public void zzai(Context var1);

    public void zzaj(boolean var1);

    public void zzak(IObjectWrapper var1);

    public void zzal(int var1);

    public void zzam(zzl var1);

    public void zzan(boolean var1);

    public void zzao();

    public void zzap(zzblt var1);

    public zzblt zzaq();

    public void zzar(boolean var1);

    public void zzas();

    public void zzat(String var1, String var2, String var3);

    public void zzau();

    public void zzav(boolean var1);

    public void zzaw(zzblq var1);

    public void zzax(zzaxq var1);

    public zzaxq zzay();

    public boolean zzaz(boolean var1, int var2);

    public zzcnh zzh();

    public Activity zzj();

    public zza zzk();

    public zzbjy zzq();

    public zzcgz zzt();

    public void zzu(String var1, zzcla var2);

    public void zzx(zzcnh var1);
}
