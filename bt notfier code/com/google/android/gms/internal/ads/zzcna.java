/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zzae
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.Predicate
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbjy
 *  com.google.android.gms.internal.ads.zzblq
 *  com.google.android.gms.internal.ads.zzblt
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzciq
 *  com.google.android.gms.internal.ads.zzcla
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmy
 *  com.google.android.gms.internal.ads.zzcmz
 *  com.google.android.gms.internal.ads.zzcne
 *  com.google.android.gms.internal.ads.zzcnh
 *  com.google.android.gms.internal.ads.zzcnz
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzae;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbjy;
import com.google.android.gms.internal.ads.zzblq;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzciq;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmy;
import com.google.android.gms.internal.ads.zzcmz;
import com.google.android.gms.internal.ads.zzcne;
import com.google.android.gms.internal.ads.zzcnh;
import com.google.android.gms.internal.ads.zzcnz;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzcna
extends FrameLayout
implements zzcml {
    private final zzcml zza;
    private final zzciq zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcna(zzcml zzcml2) {
        super(zzcml2.getContext());
        this.zza = zzcml2;
        this.zzb = new zzciq(zzcml2.zzM(), (ViewGroup)this, (zzcml)this);
        this.addView((View)this.zza);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        IObjectWrapper iObjectWrapper = this.zzV();
        if (iObjectWrapper != null) {
            zzs.zza.post((Runnable)new zzcmy(iObjectWrapper));
            iObjectWrapper = zzs.zza;
            zzcml zzcml2 = this.zza;
            zzcml2.getClass();
            Runnable runnable = zzcmz.zza((zzcml)zzcml2);
            zzcml2 = zzbjl.zzdv;
            iObjectWrapper.postDelayed(runnable, (long)((Integer)zzbet.zzc().zzc((zzbjd)zzcml2)).intValue());
            return;
        }
        this.zza.destroy();
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String string, String string2, String string3) {
        this.zza.loadData(string, "text/html", string3);
    }

    public final void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        this.zza.loadDataWithBaseURL(string, string2, "text/html", "UTF-8", null);
    }

    public final void loadUrl(String string) {
        this.zza.loadUrl(string);
    }

    public final void onAdClicked() {
        zzcml zzcml2 = this.zza;
        if (zzcml2 == null) return;
        zzcml2.onAdClicked();
    }

    public final void onPause() {
        this.zzb.zzd();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA() {
        this.zza.zzA();
    }

    public final void zzB(int n) {
        this.zza.zzB(n);
    }

    public final void zzC(int n) {
        this.zza.zzC(n);
    }

    public final int zzD() {
        return this.zza.zzD();
    }

    public final int zzE() {
        return this.zza.zzE();
    }

    public final zzezz zzF() {
        return this.zza.zzF();
    }

    public final WebView zzG() {
        return (WebView)this.zza;
    }

    public final View zzH() {
        return this;
    }

    public final void zzI() {
        this.zza.zzI();
    }

    public final void zzJ(int n) {
        this.zza.zzJ(n);
    }

    public final void zzK() {
        this.zza.zzK();
    }

    public final void zzL() {
        zzcml zzcml2 = this.zza;
        HashMap<String, String> hashMap = new HashMap<String, String>(3);
        hashMap.put("app_muted", String.valueOf(zzt.zzh().zzd()));
        hashMap.put("app_volume", String.valueOf(zzt.zzh().zzb()));
        zzcml2 = (zzcne)zzcml2;
        hashMap.put("device_volume", String.valueOf(zzae.zze((Context)zzcml2.getContext())));
        zzcml2.zze("volume", hashMap);
    }

    public final Context zzM() {
        return this.zza.zzM();
    }

    public final zzl zzN() {
        return this.zza.zzN();
    }

    public final zzl zzO() {
        return this.zza.zzO();
    }

    public final zzcob zzP() {
        return this.zza.zzP();
    }

    public final String zzQ() {
        return this.zza.zzQ();
    }

    public final zzcnz zzR() {
        return ((zzcne)this.zza).zzaS();
    }

    public final WebViewClient zzS() {
        return this.zza.zzS();
    }

    public final boolean zzT() {
        return this.zza.zzT();
    }

    public final zzaas zzU() {
        return this.zza.zzU();
    }

    public final IObjectWrapper zzV() {
        return this.zza.zzV();
    }

    public final boolean zzW() {
        return this.zza.zzW();
    }

    public final boolean zzX() {
        return this.zza.zzX();
    }

    public final void zzY() {
        this.zzb.zze();
        this.zza.zzY();
    }

    public final boolean zzZ() {
        return this.zza.zzZ();
    }

    public final void zza(String string) {
        ((zzcne)this.zza).zzaP(string);
    }

    public final boolean zzaA() {
        return this.zzc.get();
    }

    public final zzfac zzaB() {
        return this.zza.zzaB();
    }

    public final void zzaC(zzezz zzezz2, zzfac zzfac2) {
        this.zza.zzaC(zzezz2, zzfac2);
    }

    public final void zzaD(boolean bl) {
        this.zza.zzaD(bl);
    }

    public final zzfsm<String> zzaE() {
        return this.zza.zzaE();
    }

    public final void zzaF(zzc zzc2, boolean bl) {
        this.zza.zzaF(zzc2, bl);
    }

    public final void zzaG(boolean bl, int n, boolean bl2) {
        this.zza.zzaG(bl, n, bl2);
    }

    public final void zzaH(boolean bl, int n, String string, boolean bl2) {
        this.zza.zzaH(bl, n, string, bl2);
    }

    public final void zzaI(boolean bl, int n, String string, String string2, boolean bl2) {
        this.zza.zzaI(bl, n, string, string2, bl2);
    }

    public final void zzaJ(zzbu zzbu2, zzedq zzedq2, zzdvi zzdvi2, zzffc zzffc2, String string, String string2, int n) {
        this.zza.zzaJ(zzbu2, zzedq2, zzdvi2, zzffc2, string, string2, n);
    }

    public final boolean zzaa() {
        return this.zza.zzaa();
    }

    public final void zzab(String string, zzbpr<? super zzcml> zzbpr2) {
        this.zza.zzab(string, zzbpr2);
    }

    public final void zzac(String string, zzbpr<? super zzcml> zzbpr2) {
        this.zza.zzac(string, zzbpr2);
    }

    public final void zzad(String string, Predicate<zzbpr<? super zzcml>> predicate) {
        this.zza.zzad(string, predicate);
    }

    public final void zzae(zzl zzl2) {
        this.zza.zzae(zzl2);
    }

    public final void zzaf(zzcob zzcob2) {
        this.zza.zzaf(zzcob2);
    }

    public final void zzag(boolean bl) {
        this.zza.zzag(bl);
    }

    public final void zzah() {
        this.zza.zzah();
    }

    public final void zzai(Context context) {
        this.zza.zzai(context);
    }

    public final void zzaj(boolean bl) {
        this.zza.zzaj(bl);
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zza.zzak(iObjectWrapper);
    }

    public final void zzal(int n) {
        this.zza.zzal(n);
    }

    public final void zzam(zzl zzl2) {
        this.zza.zzam(zzl2);
    }

    public final void zzan(boolean bl) {
        this.zza.zzan(bl);
    }

    public final void zzao() {
        this.zza.zzao();
    }

    public final void zzap(zzblt zzblt2) {
        this.zza.zzap(zzblt2);
    }

    public final zzblt zzaq() {
        return this.zza.zzaq();
    }

    public final void zzar(boolean bl) {
        this.zza.zzar(bl);
    }

    public final void zzas() {
        this.setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzat(String string, String string2, String string3) {
        this.zza.zzat(string, string2, null);
    }

    public final void zzau() {
        TextView textView = new TextView(this.getContext());
        zzt.zzc();
        textView.setText((CharSequence)zzs.zzC());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground((Drawable)gradientDrawable);
        this.addView((View)textView, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-2, -2, 49));
        this.bringChildToFront((View)textView);
    }

    public final void zzav(boolean bl) {
        this.zza.zzav(bl);
    }

    public final void zzaw(zzblq zzblq2) {
        this.zza.zzaw(zzblq2);
    }

    public final void zzax(zzaxq zzaxq2) {
        this.zza.zzax(zzaxq2);
    }

    public final zzaxq zzay() {
        return this.zza.zzay();
    }

    public final boolean zzaz(boolean bl, int n) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        zzbjd zzbjd2 = zzbjl.zzax;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup)this.zza.getParent()).removeView((View)this.zza);
        }
        this.zza.zzaz(bl, n);
        return true;
    }

    public final void zzb() {
        zzcml zzcml2 = this.zza;
        if (zzcml2 == null) return;
        zzcml2.zzb();
    }

    public final void zzbl(String string, String string2) {
        this.zza.zzbl("window.inspectorInfo", string2);
    }

    public final void zzbm() {
        this.zza.zzbm();
    }

    public final void zzbn() {
        this.zza.zzbn();
    }

    public final void zzc(zzawc zzawc2) {
        this.zza.zzc(zzawc2);
    }

    public final void zzd(String string, JSONObject jSONObject) {
        this.zza.zzd(string, jSONObject);
    }

    public final void zze(String string, Map<String, ?> map) {
        this.zza.zze(string, map);
    }

    public final zzciq zzf() {
        return this.zzb;
    }

    public final void zzg(boolean bl) {
        this.zza.zzg(false);
    }

    public final zzcnh zzh() {
        return this.zza.zzh();
    }

    public final zzbjx zzi() {
        return this.zza.zzi();
    }

    public final Activity zzj() {
        return this.zza.zzj();
    }

    public final zza zzk() {
        return this.zza.zzk();
    }

    public final void zzl() {
        this.zza.zzl();
    }

    public final String zzm() {
        return this.zza.zzm();
    }

    public final String zzn() {
        return this.zza.zzn();
    }

    public final void zzo(int n) {
        this.zza.zzo(n);
    }

    public final int zzp() {
        return this.zza.zzp();
    }

    public final zzbjy zzq() {
        return this.zza.zzq();
    }

    public final void zzr(String string, JSONObject object) {
        zzcml zzcml2 = this.zza;
        object = object.toString();
        ((zzcne)zzcml2).zzbl(string, (String)object);
    }

    public final zzcla zzs(String string) {
        return this.zza.zzs(string);
    }

    public final zzcgz zzt() {
        return this.zza.zzt();
    }

    public final void zzu(String string, zzcla zzcla2) {
        this.zza.zzu(string, zzcla2);
    }

    public final void zzv(boolean bl, long l) {
        this.zza.zzv(bl, l);
    }

    public final void zzw(int n) {
        this.zzb.zzf(n);
    }

    public final void zzx(zzcnh zzcnh2) {
        this.zza.zzx(zzcnh2);
    }

    public final int zzy() {
        zzbjd zzbjd2 = zzbjl.zzcp;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return this.getMeasuredHeight();
        return this.zza.getMeasuredHeight();
    }

    public final int zzz() {
        zzbjd zzbjd2 = zzbjl.zzcp;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return this.getMeasuredWidth();
        return this.zza.getMeasuredWidth();
    }
}
