/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzd
 *  com.google.android.gms.ads.internal.overlay.zze
 *  com.google.android.gms.ads.internal.overlay.zzf
 *  com.google.android.gms.ads.internal.overlay.zzg
 *  com.google.android.gms.ads.internal.overlay.zzh
 *  com.google.android.gms.ads.internal.overlay.zzk
 *  com.google.android.gms.ads.internal.overlay.zzp
 *  com.google.android.gms.ads.internal.overlay.zzq
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.overlay.zzz
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzbyp
 *  com.google.android.gms.internal.ads.zzbzp
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmx
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzedy
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzfla
 */
package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzf;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzh;
import com.google.android.gms.ads.internal.overlay.zzk;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzbzp;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmx;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzedy;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzfla;
import java.util.Collections;

public class zzl
extends zzbzp
implements zzz {
    static final int zza = Color.argb((int)0, (int)0, (int)0, (int)0);
    protected final Activity zzb;
    AdOverlayInfoParcel zzc;
    zzcml zzd;
    zzh zze;
    zzq zzf;
    boolean zzg = false;
    FrameLayout zzh;
    WebChromeClient.CustomViewCallback zzi;
    boolean zzj = false;
    boolean zzk = false;
    zzg zzl;
    boolean zzm = false;
    int zzn = 1;
    private final Object zzo = new Object();
    private Runnable zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs = false;
    private boolean zzt = false;
    private boolean zzu = true;

    public zzl(Activity activity) {
        this.zzb = activity;
    }

    private final void zzG(Configuration configuration) {
        boolean bl;
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        boolean bl2 = true;
        int n = 0;
        int n2 = adOverlayInfoParcel != null && (adOverlayInfoParcel = adOverlayInfoParcel.zzo) != null && adOverlayInfoParcel.zzb ? 1 : 0;
        boolean bl3 = com.google.android.gms.ads.internal.zzt.zze().zzo(this.zzb, configuration);
        if (!(this.zzk && n2 == 0 || bl3)) {
            bl = bl2;
            n2 = n;
            if (Build.VERSION.SDK_INT >= 19) {
                configuration = this.zzc;
                bl = bl2;
                n2 = n;
                if (configuration != null) {
                    configuration = configuration.zzo;
                    bl = bl2;
                    n2 = n;
                    if (configuration != null) {
                        bl = bl2;
                        n2 = n;
                        if (configuration.zzg) {
                            n2 = 1;
                            bl = bl2;
                        }
                    }
                }
            }
        } else {
            bl = false;
            n2 = n;
        }
        adOverlayInfoParcel = this.zzb.getWindow();
        configuration = zzbjl.zzaM;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)configuration)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            configuration = adOverlayInfoParcel.getDecorView();
            n2 = bl ? (n2 != 0 ? 5894 : 5380) : 256;
            configuration.setSystemUiVisibility(n2);
            return;
        }
        if (bl) {
            adOverlayInfoParcel.addFlags(1024);
            adOverlayInfoParcel.clearFlags(2048);
            if (Build.VERSION.SDK_INT < 19) return;
            if (n2 == 0) return;
            adOverlayInfoParcel.getDecorView().setSystemUiVisibility(4098);
            return;
        }
        adOverlayInfoParcel.addFlags(2048);
        adOverlayInfoParcel.clearFlags(1024);
    }

    private static final void zzH(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper == null) return;
        if (view == null) return;
        com.google.android.gms.ads.internal.zzt.zzr().zzh(iObjectWrapper, view);
    }

    final void zzA() {
        if (this.zzt) {
            return;
        }
        this.zzt = true;
        zzcml zzcml2 = this.zzd;
        if (zzcml2 != null) {
            this.zzl.removeView(zzcml2.zzH());
            zzcml2 = this.zze;
            if (zzcml2 != null) {
                this.zzd.zzai(zzcml2.zzd);
                this.zzd.zzag(false);
                ViewGroup viewGroup = this.zze.zzc;
                zzcml2 = this.zzd.zzH();
                zzh zzh2 = this.zze;
                viewGroup.addView((View)zzcml2, zzh2.zza, zzh2.zzb);
                this.zze = null;
            } else if (this.zzb.getApplicationContext() != null) {
                this.zzd.zzai(this.zzb.getApplicationContext());
            }
            this.zzd = null;
        }
        if ((zzcml2 = this.zzc) != null && (zzcml2 = zzcml2.zzc) != null) {
            zzcml2.zzbs(this.zzn);
        }
        if ((zzcml2 = this.zzc) == null) return;
        zzcml2 = zzcml2.zzd;
        if (zzcml2 == null) return;
        com.google.android.gms.ads.internal.overlay.zzl.zzH(zzcml2.zzV(), this.zzc.zzd.zzH());
    }

    public final void zzB() {
        if (!this.zzm) return;
        this.zzm = false;
        this.zzC();
    }

    protected final void zzC() {
        this.zzd.zzK();
    }

    public final void zzD() {
        this.zzl.zzb = true;
    }

    public final void zzE() {
        Object object = this.zzo;
        synchronized (object) {
            this.zzq = true;
            if (this.zzp == null) return;
            com.google.android.gms.ads.internal.util.zzs.zza.removeCallbacks(this.zzp);
            com.google.android.gms.ads.internal.util.zzs.zza.post(this.zzp);
            return;
        }
    }

    public final void zzb() {
        this.zzn = 3;
        this.zzb.finish();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null) return;
        if (adOverlayInfoParcel.zzk != 5) return;
        this.zzb.overridePendingTransition(0, 0);
    }

    public final void zzc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && this.zzg) {
            this.zzw(adOverlayInfoParcel.zzj);
        }
        if (this.zzh != null) {
            this.zzb.setContentView((View)this.zzl);
            this.zzr = true;
            this.zzh.removeAllViews();
            this.zzh = null;
        }
        if ((adOverlayInfoParcel = this.zzi) != null) {
            adOverlayInfoParcel.onCustomViewHidden();
            this.zzi = null;
        }
        this.zzg = false;
    }

    public final void zzd() {
        this.zzn = 2;
        this.zzb.finish();
    }

    public final void zze() {
        this.zzn = 1;
    }

    public final void zzf() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel == null) return;
        adOverlayInfoParcel = adOverlayInfoParcel.zzc;
        if (adOverlayInfoParcel == null) return;
        adOverlayInfoParcel.zze();
    }

    public final boolean zzg() {
        this.zzn = 1;
        if (this.zzd == null) {
            return true;
        }
        zzbjd zzbjd2 = zzbjl.zzgp;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zzd.canGoBack()) {
            this.zzd.goBack();
            return false;
        }
        boolean bl = this.zzd.zzZ();
        if (bl) return bl;
        this.zzd.zze("onbackblocked", Collections.emptyMap());
        return bl;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void zzh(Bundle var1_1) {
        this.zzb.requestWindowFeature(1);
        var3_3 = var1_1 /* !! */  != null && var1_1 /* !! */ .getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false) != false;
        this.zzj = var3_3;
        try {
            block20: {
                block19: {
                    this.zzc = var4_4 = AdOverlayInfoParcel.zza((Intent)this.zzb.getIntent());
                    if (var4_4 == null) {
                        var1_1 /* !! */  = new zzf("Could not get info for ad overlay.");
                        throw var1_1 /* !! */ ;
                    }
                    if (var4_4.zzm.zzc > 7500000) {
                        this.zzn = 4;
                    }
                    if (this.zzb.getIntent() != null) {
                        this.zzu = this.zzb.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                    }
                    var4_4 = this.zzc;
                    var5_5 = var4_4.zzo;
                    if (var5_5 == null) break block19;
                    this.zzk = var3_3 = var5_5.zza;
                    if (!var3_3) break block20;
                    ** GOTO lbl23
                }
                if (var4_4.zzk == 5) {
                    this.zzk = true;
lbl23:
                    // 2 sources

                    if (var4_4.zzk != 5 && var5_5.zzf != -1) {
                        var4_4 = new zzk(this, null);
                        var4_4.zzc();
                    }
                } else {
                    this.zzk = false;
                }
            }
            if (var1_1 /* !! */  == null) {
                if (this.zzu) {
                    var1_1 /* !! */  = this.zzc.zzx;
                    if (var1_1 /* !! */  != null) {
                        var1_1 /* !! */ .zzc();
                    }
                    if ((var1_1 /* !! */  = this.zzc.zzc) != null) {
                        var1_1 /* !! */ .zzbp();
                    }
                }
                var1_1 /* !! */  = this.zzc;
                if (var1_1 /* !! */ .zzk != 1) {
                    var1_1 /* !! */  = var1_1 /* !! */ .zzb;
                    if (var1_1 /* !! */  != null) {
                        var1_1 /* !! */ .onAdClicked();
                    }
                    if ((var1_1 /* !! */  = this.zzc.zzy) != null) {
                        var1_1 /* !! */ .zzb();
                    }
                }
            }
            var5_5 = this.zzb;
            var4_4 = this.zzc;
            var1_1 /* !! */  = new zzg((Context)var5_5, var4_4.zzn, var4_4.zzm.zza, var4_4.zzw);
            this.zzl = var1_1 /* !! */ ;
            var1_1 /* !! */ .setId(1000);
            com.google.android.gms.ads.internal.zzt.zze().zzr(this.zzb);
            var4_4 = this.zzc;
            var2_6 = var4_4.zzk;
            if (var2_6 == 1) {
                this.zzy(false);
                return;
            }
            if (var2_6 == 2) {
                var1_1 /* !! */  = new zzh(var4_4.zzd);
                this.zze = var1_1 /* !! */ ;
                this.zzy(false);
                return;
            }
            if (var2_6 == 3) {
                this.zzy(true);
                return;
            }
            if (var2_6 == 5) {
                this.zzy(false);
                return;
            }
            var1_1 /* !! */  = new zzf("Could not determine ad overlay type.");
            throw var1_1 /* !! */ ;
        }
        catch (zzf var1_2) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)var1_2.getMessage());
            this.zzn = 4;
            this.zzb.finish();
            return;
        }
    }

    public final void zzi() {
    }

    public final void zzj() {
        zzbjd zzbjd2 = zzbjl.zzdl;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return;
        zzbjd2 = this.zzd;
        if (zzbjd2 != null && !zzbjd2.zzX()) {
            this.zzd.onResume();
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zzi((String)"The webview does not exist. Ignoring action.");
    }

    public final void zzk() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (adOverlayInfoParcel = adOverlayInfoParcel.zzc) != null) {
            adOverlayInfoParcel.zzbr();
        }
        this.zzG(this.zzb.getResources().getConfiguration());
        adOverlayInfoParcel = zzbjl.zzdl;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)adOverlayInfoParcel) != false) return;
        adOverlayInfoParcel = this.zzd;
        if (adOverlayInfoParcel != null && !adOverlayInfoParcel.zzX()) {
            this.zzd.onResume();
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zzi((String)"The webview does not exist. Ignoring action.");
    }

    public final void zzl() {
        this.zzc();
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzc;
        if (adOverlayInfoParcel != null && (adOverlayInfoParcel = adOverlayInfoParcel.zzc) != null) {
            adOverlayInfoParcel.zzbq();
        }
        adOverlayInfoParcel = zzbjl.zzdl;
        if (!(((Boolean)zzbet.zzc().zzc((zzbjd)adOverlayInfoParcel)).booleanValue() || this.zzd == null || this.zzb.isFinishing() && this.zze != null)) {
            this.zzd.onPause();
        }
        this.zzz();
    }

    public final void zzm(int n, int n2, Intent intent) {
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        this.zzG((Configuration)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
    }

    public final void zzo(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzj);
    }

    public final void zzp() {
        zzbjd zzbjd2 = zzbjl.zzdl;
        if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zzd != null && (!this.zzb.isFinishing() || this.zze == null)) {
            this.zzd.onPause();
        }
        this.zzz();
    }

    public final void zzq() {
        zzcml zzcml2 = this.zzd;
        if (zzcml2 != null) {
            try {
                this.zzl.removeView(zzcml2.zzH());
            }
            catch (NullPointerException nullPointerException) {}
        }
        this.zzz();
    }

    public final void zzr(boolean bl) {
        zzbjd zzbjd2 = zzbjl.zzdn;
        int n = (Integer)zzbet.zzc().zzc(zzbjd2);
        zzbjd2 = zzbjl.zzaL;
        boolean bl2 = (Boolean)zzbet.zzc().zzc(zzbjd2);
        int n2 = 0;
        boolean bl3 = bl2 || bl;
        zzbjd2 = new zzp();
        zzbjd2.zzd = 50;
        int n3 = true != bl3 ? 0 : n;
        zzbjd2.zza = n3;
        n3 = n2;
        if (!bl3) {
            n3 = n;
        }
        zzbjd2.zzb = n3;
        zzbjd2.zzc = n;
        this.zzf = new zzq((Context)this.zzb, (zzp)zzbjd2, (zzz)this);
        zzbjd2 = new RelativeLayout.LayoutParams(-2, -2);
        zzbjd2.addRule(10);
        n = true != bl3 ? 9 : 11;
        zzbjd2.addRule(n);
        this.zzt(bl, this.zzc.zzg);
        this.zzl.addView((View)this.zzf, (ViewGroup.LayoutParams)zzbjd2);
    }

    public final void zzs() {
        this.zzr = true;
    }

    public final void zzt(boolean bl, boolean bl2) {
        zzbjd zzbjd2 = zzbjl.zzaJ;
        boolean bl3 = (Boolean)zzbet.zzc().zzc(zzbjd2);
        boolean bl4 = true;
        boolean bl5 = bl3 && (zzbjd2 = this.zzc) != null && (zzbjd2 = zzbjd2.zzo) != null && zzbjd2.zzh;
        zzbjd2 = zzbjl.zzaK;
        boolean bl6 = (Boolean)zzbet.zzc().zzc(zzbjd2) != false && (zzbjd2 = this.zzc) != null && (zzbjd2 = zzbjd2.zzo) != null && zzbjd2.zzi;
        if (bl && bl2 && bl5 && !bl6) {
            new zzbyp(this.zzd, "useCustomClose").zzf("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        if ((zzbjd2 = this.zzf) == null) return;
        bl = bl4;
        if (!bl6) {
            bl = bl2 && !bl5 ? bl4 : false;
        }
        zzbjd2.zza(bl);
    }

    public final void zzu(boolean bl) {
        if (bl) {
            this.zzl.setBackgroundColor(0);
            return;
        }
        this.zzl.setBackgroundColor(-16777216);
    }

    public final void zzv() {
        this.zzl.removeView((View)this.zzf);
        this.zzr(true);
    }

    public final void zzw(int n) {
        int n2 = this.zzb.getApplicationInfo().targetSdkVersion;
        zzbjd zzbjd2 = zzbjl.zzem;
        if (n2 >= (Integer)zzbet.zzc().zzc(zzbjd2)) {
            n2 = this.zzb.getApplicationInfo().targetSdkVersion;
            zzbjd2 = zzbjl.zzen;
            if (n2 <= (Integer)zzbet.zzc().zzc(zzbjd2)) {
                n2 = Build.VERSION.SDK_INT;
                zzbjd2 = zzbjl.zzeo;
                if (n2 >= (Integer)zzbet.zzc().zzc(zzbjd2)) {
                    n2 = Build.VERSION.SDK_INT;
                    zzbjd2 = zzbjl.zzep;
                    if (n2 <= (Integer)zzbet.zzc().zzc(zzbjd2)) return;
                }
            }
        }
        try {
            this.zzb.setRequestedOrientation(n);
            return;
        }
        catch (Throwable throwable) {
            com.google.android.gms.ads.internal.zzt.zzg().zzl(throwable, "AdOverlay.setRequestedOrientation");
            return;
        }
    }

    public final void zzx(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        FrameLayout frameLayout;
        this.zzh = frameLayout = new FrameLayout((Context)this.zzb);
        frameLayout.setBackgroundColor(-16777216);
        this.zzh.addView(view, -1, -1);
        this.zzb.setContentView((View)this.zzh);
        this.zzr = true;
        this.zzi = customViewCallback;
        this.zzg = true;
    }

    protected final void zzy(boolean bl) throws zzf {
        Object object;
        if (!this.zzr) {
            this.zzb.requestWindowFeature(1);
        }
        if ((object = this.zzb.getWindow()) == null) throw new zzf("Invalid activity, no window available.");
        Object object2 = this.zzc.zzd;
        Object var11_5 = null;
        object2 = object2 != null ? object2.zzR() : null;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = object2 != null && object2.zzd();
        this.zzm = false;
        boolean bl6 = bl3;
        if (bl5) {
            int n = this.zzc.zzj;
            if (n == 6) {
                bl6 = bl4;
                if (this.zzb.getResources().getConfiguration().orientation == 1) {
                    bl6 = true;
                }
                this.zzm = bl6;
            } else {
                bl6 = bl3;
                if (n == 7) {
                    bl6 = bl2;
                    if (this.zzb.getResources().getConfiguration().orientation == 2) {
                        bl6 = true;
                    }
                    this.zzm = bl6;
                }
            }
        }
        object2 = new StringBuilder(46);
        ((StringBuilder)object2).append("Delay onShow to next orientation change: ");
        ((StringBuilder)object2).append(bl6);
        com.google.android.gms.ads.internal.util.zze.zzd((String)((StringBuilder)object2).toString());
        this.zzw(this.zzc.zzj);
        object.setFlags(0x1000000, 0x1000000);
        com.google.android.gms.ads.internal.util.zze.zzd((String)"Hardware acceleration on the AdActivity window enabled.");
        if (!this.zzk) {
            this.zzl.setBackgroundColor(-16777216);
        } else {
            this.zzl.setBackgroundColor(zza);
        }
        this.zzb.setContentView((View)this.zzl);
        this.zzr = true;
        if (bl) {
            zzcgz zzcgz2;
            Object object3;
            Activity activity;
            try {
                com.google.android.gms.ads.internal.zzt.zzd();
                activity = this.zzb;
                object2 = this.zzc.zzd;
                object2 = object2 != null ? object2.zzP() : null;
                object = this.zzc.zzd;
                object = object != null ? object.zzQ() : null;
                object3 = this.zzc;
                zzcgz2 = object3.zzm;
                object3 = object3.zzd;
                object3 = object3 != null ? object3.zzk() : null;
                object2 = zzcmx.zza((Context)activity, (zzcob)object2, (String)object, (boolean)true, (boolean)bl5, null, null, (zzcgz)zzcgz2, null, null, (zza)object3, (zzazb)zzazb.zza(), null, null);
                this.zzd = object2;
            }
            catch (Exception exception) {
                com.google.android.gms.ads.internal.util.zze.zzg((String)"Error obtaining webview.", (Throwable)exception);
                throw new zzf("Could not obtain webview for the overlay.");
            }
            zzcgz2 = object2.zzR();
            object2 = this.zzc;
            activity = ((AdOverlayInfoParcel)object2).zzp;
            object3 = ((AdOverlayInfoParcel)object2).zze;
            object = ((AdOverlayInfoParcel)object2).zzi;
            zzcml zzcml2 = ((AdOverlayInfoParcel)object2).zzd;
            object2 = var11_5;
            if (zzcml2 != null) {
                object2 = zzcml2.zzR().zzc();
            }
            zzcgz2.zzL(null, (zzbor)activity, null, (zzbot)object3, (zzv)object, true, null, (zzb)object2, null, null, null, null, null, null, null, null);
            this.zzd.zzR().zzy((zzcnx)new zzd(this));
            object2 = this.zzc;
            object = ((AdOverlayInfoParcel)object2).zzl;
            if (object != null) {
                this.zzd.loadUrl((String)object);
            } else {
                object = ((AdOverlayInfoParcel)object2).zzh;
                if (object == null) throw new zzf("No URL or HTML to display in ad overlay.");
                this.zzd.loadDataWithBaseURL(((AdOverlayInfoParcel)object2).zzf, (String)object, "text/html", "UTF-8", null);
            }
            object2 = this.zzc.zzd;
            if (object2 != null) {
                object2.zzam(this);
            }
        } else {
            object2 = this.zzc.zzd;
            this.zzd = object2;
            object2.zzai((Context)this.zzb);
        }
        this.zzd.zzae(this);
        object2 = this.zzc.zzd;
        if (object2 != null) {
            com.google.android.gms.ads.internal.overlay.zzl.zzH(object2.zzV(), (View)this.zzl);
        }
        if (this.zzc.zzk != 5) {
            object2 = this.zzd.getParent();
            if (object2 != null && object2 instanceof ViewGroup) {
                ((ViewGroup)object2).removeView(this.zzd.zzH());
            }
            if (this.zzk) {
                this.zzd.zzas();
            }
            this.zzl.addView(this.zzd.zzH(), -1, -1);
        }
        if (!bl && !this.zzm) {
            this.zzC();
        }
        object2 = this.zzc;
        if (((AdOverlayInfoParcel)object2).zzk != 5) {
            this.zzr(bl5);
            if (!this.zzd.zzT()) return;
            this.zzt(bl5, true);
            return;
        }
        zzedy.zzc((Activity)this.zzb, (zzl)this, (zzbu)((AdOverlayInfoParcel)object2).zzu, (zzedq)((AdOverlayInfoParcel)object2).zzr, (zzdvi)((AdOverlayInfoParcel)object2).zzs, (zzffc)((AdOverlayInfoParcel)object2).zzt, (String)((AdOverlayInfoParcel)object2).zzq, (String)((AdOverlayInfoParcel)object2).zzv);
    }

    protected final void zzz() {
        if (!this.zzb.isFinishing()) return;
        if (this.zzs) return;
        this.zzs = true;
        Object object = this.zzd;
        if (object != null) {
            object.zzJ(this.zzn - 1);
            object = this.zzo;
            synchronized (object) {
                if (!this.zzq && this.zzd.zzaa()) {
                    Object object2 = zzbjl.zzdj;
                    if (((Boolean)zzbet.zzc().zzc(object2)).booleanValue() && !this.zzt && (object2 = this.zzc) != null && (object2 = object2.zzc) != null) {
                        object2.zzd();
                    }
                    object2 = new zze(this);
                    this.zzp = object2;
                    zzfla zzfla2 = com.google.android.gms.ads.internal.util.zzs.zza;
                    object2 = this.zzp;
                    zzbjd zzbjd2 = zzbjl.zzaI;
                    zzfla2.postDelayed((Runnable)object2, ((Long)zzbet.zzc().zzc(zzbjd2)).longValue());
                    return;
                }
            }
        }
        this.zzA();
    }
}
