/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Canvas
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowManager
 *  android.webkit.DownloadListener
 *  android.webkit.ValueCallback
 *  android.webkit.WebSettings
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zzcl
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zza
 *  com.google.android.gms.ads.internal.zzl
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.common.util.Predicate
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzawc
 *  com.google.android.gms.internal.ads.zzaxq
 *  com.google.android.gms.internal.ads.zzaza
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbjs
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbjy
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzbkk
 *  com.google.android.gms.internal.ads.zzblq
 *  com.google.android.gms.internal.ads.zzblt
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbyp
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzciq
 *  com.google.android.gms.internal.ads.zzcjb
 *  com.google.android.gms.internal.ads.zzcla
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcms
 *  com.google.android.gms.internal.ads.zzcnb
 *  com.google.android.gms.internal.ads.zzcnc
 *  com.google.android.gms.internal.ads.zzcnd
 *  com.google.android.gms.internal.ads.zzcnh
 *  com.google.android.gms.internal.ads.zzcnj
 *  com.google.android.gms.internal.ads.zzcnl
 *  com.google.android.gms.internal.ads.zzcnm
 *  com.google.android.gms.internal.ads.zzcnn
 *  com.google.android.gms.internal.ads.zzcns
 *  com.google.android.gms.internal.ads.zzcoa
 *  com.google.android.gms.internal.ads.zzcob
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzezz
 *  com.google.android.gms.internal.ads.zzfac
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzfla
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zzcl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzawc;
import com.google.android.gms.internal.ads.zzaxq;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjs;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbjy;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbkk;
import com.google.android.gms.internal.ads.zzblq;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbyp;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzciq;
import com.google.android.gms.internal.ads.zzcjb;
import com.google.android.gms.internal.ads.zzcla;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcms;
import com.google.android.gms.internal.ads.zzcnb;
import com.google.android.gms.internal.ads.zzcnc;
import com.google.android.gms.internal.ads.zzcnd;
import com.google.android.gms.internal.ads.zzcnh;
import com.google.android.gms.internal.ads.zzcnj;
import com.google.android.gms.internal.ads.zzcnl;
import com.google.android.gms.internal.ads.zzcnm;
import com.google.android.gms.internal.ads.zzcnn;
import com.google.android.gms.internal.ads.zzcns;
import com.google.android.gms.internal.ads.zzcoa;
import com.google.android.gms.internal.ads.zzcob;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzezz;
import com.google.android.gms.internal.ads.zzfac;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzfla;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
final class zzcne
extends WebView
implements DownloadListener,
ViewTreeObserver.OnGlobalLayoutListener,
zzcml {
    public static final int zza = 0;
    private boolean zzA;
    private boolean zzB;
    private zzblt zzC;
    private zzblq zzD;
    private zzaxq zzE;
    private int zzF;
    private int zzG;
    private zzbjx zzH;
    private final zzbjx zzI;
    private zzbjx zzJ;
    private final zzbjy zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    private zzl zzO;
    private boolean zzP;
    private final zzcl zzQ;
    private int zzR = -1;
    private int zzS = -1;
    private int zzT = -1;
    private int zzU = -1;
    private Map<String, zzcla> zzV;
    private final WindowManager zzW;
    private final zzazb zzX;
    private final zzcoa zzb;
    private final zzaas zzc;
    private final zzbkk zzd;
    private final zzcgz zze;
    private com.google.android.gms.ads.internal.zzl zzf;
    private final zza zzg;
    private final DisplayMetrics zzh;
    private final float zzi;
    private zzezz zzj;
    private zzfac zzk;
    private boolean zzl = false;
    private boolean zzm = false;
    private zzcms zzn;
    private zzl zzo;
    private IObjectWrapper zzp;
    private zzcob zzq;
    private final String zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private Boolean zzw;
    private boolean zzx = true;
    private final String zzy;
    private zzcnh zzz;

    protected zzcne(zzcoa zzcoa2, zzcob zzcob2, String string, boolean bl, boolean bl2, zzaas zzaas2, zzbkk zzbkk2, zzcgz zzcgz2, zzbka zzbka2, com.google.android.gms.ads.internal.zzl zzl2, zza zza2, zzazb zzazb2, zzezz zzezz2, zzfac zzfac2) {
        super((Context)zzcoa2);
        this.zzy = "";
        this.zzb = zzcoa2;
        this.zzq = zzcob2;
        this.zzr = string;
        this.zzu = bl;
        this.zzc = zzaas2;
        this.zzd = zzbkk2;
        this.zze = zzcgz2;
        this.zzf = zzl2;
        this.zzg = zza2;
        this.zzW = (WindowManager)this.getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzt.zzc();
        zzcob2 = com.google.android.gms.ads.internal.util.zzs.zzy((WindowManager)this.zzW);
        this.zzh = zzcob2;
        this.zzi = zzcob2.density;
        this.zzX = zzazb2;
        this.zzj = zzezz2;
        this.zzk = zzfac2;
        this.zzQ = new zzcl(this.zzb.zza(), (View)this, (ViewTreeObserver.OnGlobalLayoutListener)this, null);
        this.setBackgroundColor(0);
        zzcob2 = this.getSettings();
        zzcob2.setAllowFileAccess(false);
        try {
            zzcob2.setJavaScriptEnabled(true);
        }
        catch (NullPointerException nullPointerException) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Unable to enable Javascript.", (Throwable)nullPointerException);
        }
        zzcob2.setSavePassword(false);
        zzcob2.setSupportMultipleWindows(true);
        zzcob2.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            zzcob2.setMixedContentMode(2);
        }
        zzcob2.setUserAgentString(com.google.android.gms.ads.internal.zzt.zzc().zzi((Context)zzcoa2, zzcgz2.zza));
        com.google.android.gms.ads.internal.zzt.zze().zza(this.getContext(), (WebSettings)zzcob2);
        this.setDownloadListener(this);
        this.zzaX();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            this.addJavascriptInterface(new zzcnm((zzcnn)this, (zzcnl)new zzcnj((zzcml)this)), "googleAdsJsInterface");
        }
        this.removeJavascriptInterface("accessibility");
        this.removeJavascriptInterface("accessibilityTraversal");
        this.zzbc();
        zzcob2 = new zzbjy(new zzbka(true, "make_wv", this.zzr));
        this.zzK = zzcob2;
        zzcob2.zzc().zza(null);
        zzcob2 = zzbjl.zzbl;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)zzcob2)).booleanValue() && (zzcob2 = this.zzk) != null && zzcob2.zzb != null) {
            this.zzK.zzc().zzd("gqi", this.zzk.zzb);
        }
        this.zzK.zzc();
        zzcob2 = zzbka.zzf();
        this.zzI = zzcob2;
        this.zzK.zza("native:view_create", (zzbjx)zzcob2);
        this.zzJ = null;
        this.zzH = null;
        com.google.android.gms.ads.internal.zzt.zze().zzc((Context)zzcoa2);
        com.google.android.gms.ads.internal.zzt.zzg().zzm();
    }

    static /* synthetic */ int zzaK(zzcne zzcne2) {
        return zzcne2.zzG;
    }

    static /* synthetic */ int zzaL(zzcne zzcne2, int n) {
        zzcne2.zzG = n;
        return n;
    }

    static /* synthetic */ void zzaT(zzcne zzcne2) {
        super.destroy();
    }

    private final void zzaU(String string) {
        synchronized (this) {
            try {
                super.loadUrl("about:blank");
                return;
            }
            catch (Throwable throwable) {
                com.google.android.gms.ads.internal.zzt.zzg().zzk(throwable, "AdWebViewImpl.loadUrlUnsafe");
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Could not call loadUrl in destroy(). ", (Throwable)throwable);
                return;
            }
        }
    }

    private final void zzaV() {
        synchronized (this) {
            Boolean bl;
            this.zzw = bl = com.google.android.gms.ads.internal.zzt.zzg().zzg();
            if (bl != null) return;
            try {
                this.evaluateJavascript("(function(){})()", null);
                this.zzaQ(true);
                return;
            }
            catch (IllegalStateException illegalStateException) {
                this.zzaQ(false);
                return;
            }
        }
    }

    private final void zzaW() {
        zzbjs.zza((zzbka)this.zzK.zzc(), (zzbjx)this.zzI, (String[])new String[]{"aeh2"});
    }

    private final void zzaX() {
        synchronized (this) {
            zzezz zzezz2 = this.zzj;
            if (zzezz2 != null && zzezz2.zzaj) {
                com.google.android.gms.ads.internal.util.zze.zzd((String)"Disabling hardware acceleration on an overlay.");
                this.zzaY();
                return;
            }
            if (!this.zzu && !this.zzq.zzg()) {
                if (Build.VERSION.SDK_INT < 18) {
                    com.google.android.gms.ads.internal.util.zze.zzd((String)"Disabling hardware acceleration on an AdView.");
                    this.zzaY();
                    return;
                }
                com.google.android.gms.ads.internal.util.zze.zzd((String)"Enabling hardware acceleration on an AdView.");
                this.zzaZ();
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Enabling hardware acceleration on an overlay.");
            this.zzaZ();
            return;
        }
    }

    private final void zzaY() {
        synchronized (this) {
            if (!this.zzv) {
                this.setLayerType(1, null);
            }
            this.zzv = true;
            return;
        }
    }

    private final void zzaZ() {
        synchronized (this) {
            if (this.zzv) {
                this.setLayerType(0, null);
            }
            this.zzv = false;
            return;
        }
    }

    private final void zzba() {
        synchronized (this) {
            if (this.zzP) return;
            this.zzP = true;
            com.google.android.gms.ads.internal.zzt.zzg().zzn();
            return;
        }
    }

    private final void zzbb() {
        synchronized (this) {
            try {
                Object object = this.zzV;
                if (object != null) {
                    object = object.values().iterator();
                    while (object.hasNext()) {
                        ((zzcla)object.next()).release();
                    }
                }
                this.zzV = null;
                return;
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    private final void zzbc() {
        zzbjy zzbjy2 = this.zzK;
        if (zzbjy2 == null) {
            return;
        }
        zzbka zzbka2 = zzbjy2.zzc();
        zzbjy2 = com.google.android.gms.ads.internal.zzt.zzg().zze();
        if (zzbjy2 == null) return;
        zzbjy2.zzb(zzbka2);
    }

    private final void zzbd(boolean bl) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        String string = true != bl ? "0" : "1";
        hashMap.put("isVisible", string);
        this.zze("onAdVisibilityChanged", hashMap);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void destroy() {
        synchronized (this) {
            this.zzbc();
            this.zzQ.zzc();
            zzl zzl2 = this.zzo;
            if (zzl2 != null) {
                zzl2.zzb();
                this.zzo.zzq();
                this.zzo = null;
            }
            this.zzp = null;
            this.zzn.zzx();
            this.zzE = null;
            this.zzf = null;
            this.setOnClickListener(null);
            this.setOnTouchListener(null);
            boolean bl = this.zzt;
            if (bl) {
                return;
            }
            com.google.android.gms.ads.internal.zzt.zzy().zza((zzcjb)this);
            this.zzbb();
            this.zzt = true;
            zzl2 = zzbjl.zzhc;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)zzl2)).booleanValue()) {
                com.google.android.gms.ads.internal.util.zze.zza((String)"Initiating WebView self destruct sequence in 3...");
                com.google.android.gms.ads.internal.util.zze.zza((String)"Loading blank page in WebView, 2...");
                this.zzaU("about:blank");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza((String)"Destroying the WebView immediately...");
            this.zzY();
            return;
        }
    }

    public final void evaluateJavascript(String string, ValueCallback<String> valueCallback) {
        synchronized (this) {
            if (this.zzX()) {
                zzcgt.zzl((String)"#004 The webview is destroyed. Ignoring action.", null);
                if (valueCallback == null) return;
                valueCallback.onReceiveValue(null);
                return;
            }
            super.evaluateJavascript(string, valueCallback);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected final void finalize() throws Throwable {
        block6: {
            try {
                synchronized (this) {
                    if (this.zzt) break block6;
                }
            }
            catch (Throwable throwable) {
                super.finalize();
                throw throwable;
            }
            {
                this.zzn.zzx();
                com.google.android.gms.ads.internal.zzt.zzy().zza((zzcjb)this);
                this.zzbb();
                this.zzba();
            }
        }
        super.finalize();
    }

    public final void loadData(String string, String string2, String string3) {
        synchronized (this) {
            if (!this.zzX()) {
                super.loadData(string, string2, string3);
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzi((String)"#004 The webview is destroyed. Ignoring action.");
            return;
        }
    }

    public final void loadDataWithBaseURL(String string, String string2, String string3, String string4, String string5) {
        synchronized (this) {
            if (!this.zzX()) {
                super.loadDataWithBaseURL(string, string2, string3, string4, string5);
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzi((String)"#004 The webview is destroyed. Ignoring action.");
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void loadUrl(String string) {
        synchronized (this) {
            boolean bl = this.zzX();
            if (bl) {
                com.google.android.gms.ads.internal.util.zze.zzi((String)"#004 The webview is destroyed. Ignoring action.");
                return;
            }
            try {
                super.loadUrl(string);
                return;
            }
            catch (Throwable throwable) {
                com.google.android.gms.ads.internal.zzt.zzg().zzk(throwable, "AdWebViewImpl.loadUrl");
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Could not call loadUrl. ", (Throwable)throwable);
                return;
            }
        }
    }

    public final void onAdClicked() {
        zzcms zzcms2 = this.zzn;
        if (zzcms2 == null) return;
        zzcms2.onAdClicked();
    }

    protected final void onAttachedToWindow() {
        synchronized (this) {
            super.onAttachedToWindow();
            if (!this.zzX()) {
                this.zzQ.zzd();
            }
            boolean bl = this.zzA;
            zzcms zzcms2 = this.zzn;
            boolean bl2 = bl;
            if (zzcms2 != null) {
                bl2 = bl;
                if (zzcms2.zze()) {
                    if (!this.zzB) {
                        this.zzn.zzg();
                        this.zzn.zzh();
                        this.zzB = true;
                    }
                    this.zzaM();
                    bl2 = true;
                }
            }
            this.zzbd(bl2);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            zzcms zzcms2;
            if (!this.zzX()) {
                this.zzQ.zze();
            }
            super.onDetachedFromWindow();
            if (this.zzB && (zzcms2 = this.zzn) != null && zzcms2.zze() && this.getViewTreeObserver() != null && this.getViewTreeObserver().isAlive()) {
                this.zzn.zzg();
                this.zzn.zzh();
                this.zzB = false;
            }
        }
        this.zzbd(false);
    }

    public final void onDownloadStart(String string, String string2, String string3, String string4, long l) {
        try {
            string2 = new Intent("android.intent.action.VIEW");
            string2.setDataAndType(Uri.parse((String)string), string4);
            com.google.android.gms.ads.internal.zzt.zzc();
            com.google.android.gms.ads.internal.util.zzs.zzP((Context)this.getContext(), (Intent)string2);
            return;
        }
        catch (ActivityNotFoundException activityNotFoundException) {
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 51 + String.valueOf(string4).length());
            stringBuilder.append("Couldn't find an Activity to view url/mimetype: ");
            stringBuilder.append(string);
            stringBuilder.append(" / ");
            stringBuilder.append(string4);
            com.google.android.gms.ads.internal.util.zze.zzd((String)stringBuilder.toString());
            return;
        }
    }

    protected final void onDraw(Canvas canvas) {
        if (this.zzX()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !this.isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f = motionEvent.getAxisValue(9);
        float f2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() != 8) return super.onGenericMotionEvent(motionEvent);
        if (f > 0.0f) {
            if (!this.canScrollVertically(-1)) return false;
        }
        if (f < 0.0f) {
            if (!this.canScrollVertically(1)) return false;
        }
        if (f2 > 0.0f) {
            if (!this.canScrollHorizontally(-1)) return false;
        }
        if (!(f2 < 0.0f)) return super.onGenericMotionEvent(motionEvent);
        if (this.canScrollHorizontally(1)) return super.onGenericMotionEvent(motionEvent);
        return false;
    }

    public final void onGlobalLayout() {
        boolean bl = this.zzaM();
        zzl zzl2 = this.zzN();
        if (zzl2 == null) return;
        if (!bl) return;
        zzl2.zzB();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     */
    protected final void onMeasure(int var1_1, int var2_2) {
        synchronized (this) {
            block20: {
                block18: {
                    block19: {
                        var8_3 = this.zzX();
                        var6_4 = 0;
                        if (var8_3) {
                            this.setMeasuredDimension(0, 0);
                            return;
                        }
                        if (this.isInEditMode() || this.zzu || this.zzq.zzh()) ** GOTO lbl129
                        if (this.zzq.zzj()) {
                            super.onMeasure(var1_1, var2_2);
                            return;
                        }
                        if (!this.zzq.zzi()) ** GOTO lbl54
                        var9_5 = zzbjl.zzco;
                        if (((Boolean)zzbet.zzc().zzc((zzbjd)var9_5)).booleanValue()) {
                            super.onMeasure(var1_1, var2_2);
                            return;
                        }
                        var9_5 = this.zzh();
                        var3_7 = var9_5 != null ? var9_5.zzm() : 0.0f;
                        if (var3_7 == 0.0f) {
                        }
                        ** GOTO lbl26
                        {
                            super.onMeasure(var1_1, var2_2);
                            return;
lbl26:
                            // 1 sources

                            var1_1 = View.MeasureSpec.getSize((int)var1_1);
                            var7_10 = View.MeasureSpec.getSize((int)var2_2);
                        }
                        var4_12 = (int)((float)var7_10 * var3_7);
                        var5_15 = (int)((float)var1_1 / var3_7);
                        var2_2 = var7_10;
                        if (var7_10 != 0) break block18;
                        if (var5_15 == 0) break block19;
                        var6_4 = (int)((float)var5_15 * var3_7);
                        var7_10 = var5_15;
                        ** GOTO lbl-1000
                    }
                    var2_2 = 0;
                }
                if (var1_1 != 0) break block20;
                var1_1 = var6_4;
                var6_4 = var4_12;
                var7_10 = var2_2;
                if (var4_12 != 0) {
                    var5_15 = (int)((float)var4_12 / var3_7);
                    var1_1 = var4_12;
                    var6_4 = var4_12;
                    var7_10 = var2_2;
                }
                ** GOTO lbl-1000
            }
            var7_10 = var2_2;
            var6_4 = var4_12;
lbl-1000:
            // 3 sources

            {
                this.setMeasuredDimension(Math.min(var6_4, var1_1), Math.min(var5_15, var7_10));
                return;
lbl54:
                // 1 sources

                if (!this.zzq.zzf()) ** GOTO lbl68
                var9_5 = zzbjl.zzcs;
                if (((Boolean)zzbet.zzc().zzc((zzbjd)var9_5)).booleanValue() || !PlatformVersion.isAtLeastJellyBeanMR1()) ** GOTO lbl66
                var9_5 = new zzcnc(this);
                this.zzab("/contentHeight", (zzbpr<? super zzcml>)var9_5);
                this.zzaP("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                var3_8 = this.zzh.density;
                var4_13 = View.MeasureSpec.getSize((int)var1_1);
                var1_1 = this.zzG;
                var1_1 = var1_1 != -1 ? (int)((float)var1_1 * var3_8) : View.MeasureSpec.getSize((int)var2_2);
            }
            {
                this.setMeasuredDimension(var4_13, var1_1);
                return;
lbl66:
                // 1 sources

                super.onMeasure(var1_1, var2_2);
                return;
lbl68:
                // 1 sources

                if (this.zzq.zzg()) {
                    this.setMeasuredDimension(this.zzh.widthPixels, this.zzh.heightPixels);
                    return;
                }
                var5_16 = View.MeasureSpec.getMode((int)var1_1);
                var6_4 = View.MeasureSpec.getSize((int)var1_1);
                var1_1 = View.MeasureSpec.getMode((int)var2_2);
                var7_11 = View.MeasureSpec.getSize((int)var2_2);
                var4_14 = 0x7FFFFFFF;
                var2_2 = var5_16 != -2147483648 && var5_16 != 0x40000000 ? 0x7FFFFFFF : var6_4;
                if (var1_1 == -2147483648 || var1_1 == 0x40000000) {
                    var4_14 = var7_11;
                }
                var9_5 = this.zzq;
                var1_1 = var9_5.zzb <= var2_2 && var9_5.zza <= var4_14 ? 0 : 1;
                var9_5 = zzbjl.zzdK;
                var5_16 = var1_1;
                if (!((Boolean)zzbet.zzc().zzc((zzbjd)var9_5)).booleanValue()) ** GOTO lbl89
                var9_5 = this.zzq;
            }
            {
                var5_16 = var9_5.zzb;
                var3_9 = this.zzi;
                var2_2 = !((float)var5_16 / var3_9 > (float)var2_2 / var3_9) && !((float)var9_5.zza / var3_9 > (float)var4_14 / var3_9) ? 1 : 0;
                var5_16 = 1 != var1_1 ? var1_1 : var2_2;
lbl89:
                // 2 sources

                if (var5_16 != 0) {
                    var9_5 = this.zzq;
                    var2_2 = var9_5.zzb;
                    var3_9 = this.zzi;
                    var1_1 = var9_5.zza;
                    var9_5 = new StringBuilder(103);
                    var9_5.append("Not enough space to show ad. Needs ");
                    var9_5.append((int)((float)var2_2 / var3_9));
                    var9_5.append("x");
                    var9_5.append((int)((float)var1_1 / var3_9));
                    var9_5.append(" dp, but only has ");
                    var9_5.append((int)((float)var6_4 / var3_9));
                    var9_5.append("x");
                    var9_5.append((int)((float)var7_11 / var3_9));
                    var9_5.append(" dp.");
                    com.google.android.gms.ads.internal.util.zze.zzi((String)var9_5.toString());
                    if (this.getVisibility() != 8) {
                        this.setVisibility(4);
                    }
                    this.setMeasuredDimension(0, 0);
                    if (this.zzl != false) return;
                    this.zzX.zzc(10001);
                    this.zzl = true;
                    return;
                }
                if (this.getVisibility() != 8) {
                    this.setVisibility(0);
                }
                if (!this.zzm) {
                    this.zzX.zzc(10002);
                    this.zzm = true;
                }
                var9_5 = this.zzq;
                this.setMeasuredDimension(var9_5.zzb, var9_5.zza);
                return;
lbl129:
                // 1 sources

                super.onMeasure(var1_1, var2_2);
                return;
            }
        }
    }

    public final void onPause() {
        if (this.zzX()) {
            return;
        }
        try {
            super.onPause();
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Could not pause webview.", (Throwable)exception);
            return;
        }
    }

    public final void onResume() {
        if (this.zzX()) {
            return;
        }
        try {
            super.onResume();
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Could not resume webview.", (Throwable)exception);
            return;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.zzn.zze() && !this.zzn.zzf()) {
            synchronized (this) {
                zzblt zzblt2 = this.zzC;
                if (zzblt2 != null) {
                    zzblt2.zzb(motionEvent);
                }
            }
        } else {
            zzaas zzaas2 = this.zzc;
            if (zzaas2 != null) {
                zzaas2.zzd(motionEvent);
            }
            if ((zzaas2 = this.zzd) != null) {
                zzaas2.zza(motionEvent);
            }
        }
        if (!this.zzX()) return super.onTouchEvent(motionEvent);
        return false;
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (!(webViewClient instanceof zzcms)) return;
        this.zzn = (zzcms)webViewClient;
    }

    public final void stopLoading() {
        if (this.zzX()) {
            return;
        }
        try {
            super.stopLoading();
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Could not stop loading webview.", (Throwable)exception);
            return;
        }
    }

    public final void zzA() {
        synchronized (this) {
            zzblq zzblq2 = this.zzD;
            if (zzblq2 == null) return;
            zzblq2.zza();
            return;
        }
    }

    public final void zzB(int n) {
        this.zzM = n;
    }

    public final void zzC(int n) {
        this.zzN = n;
    }

    public final int zzD() {
        return this.zzM;
    }

    public final int zzE() {
        return this.zzN;
    }

    public final zzezz zzF() {
        return this.zzj;
    }

    public final WebView zzG() {
        return this;
    }

    public final View zzH() {
        return this;
    }

    public final void zzI() {
        this.zzaW();
        HashMap<String, String> hashMap = new HashMap<String, String>(1);
        hashMap.put("version", this.zze.zza);
        this.zze("onhide", hashMap);
    }

    public final void zzJ(int n) {
        if (n == 0) {
            zzbjs.zza((zzbka)this.zzK.zzc(), (zzbjx)this.zzI, (String[])new String[]{"aebb2"});
        }
        this.zzaW();
        this.zzK.zzc();
        this.zzK.zzc().zzd("close_type", String.valueOf(n));
        HashMap<String, String> hashMap = new HashMap<String, String>(2);
        hashMap.put("closetype", String.valueOf(n));
        hashMap.put("version", this.zze.zza);
        this.zze("onhide", hashMap);
    }

    public final void zzK() {
        zzbjx zzbjx2;
        if (this.zzH == null) {
            zzbjs.zza((zzbka)this.zzK.zzc(), (zzbjx)this.zzI, (String[])new String[]{"aes2"});
            this.zzK.zzc();
            this.zzH = zzbjx2 = zzbka.zzf();
            this.zzK.zza("native:view_show", zzbjx2);
        }
        zzbjx2 = new HashMap(1);
        zzbjx2.put("version", this.zze.zza);
        this.zze("onshow", (Map<String, ?>)zzbjx2);
    }

    public final void zzL() {
        throw null;
    }

    public final Context zzM() {
        return this.zzb.zzb();
    }

    public final zzl zzN() {
        synchronized (this) {
            zzl zzl2 = this.zzo;
            return zzl2;
        }
    }

    public final zzl zzO() {
        synchronized (this) {
            zzl zzl2 = this.zzO;
            return zzl2;
        }
    }

    public final zzcob zzP() {
        synchronized (this) {
            zzcob zzcob2 = this.zzq;
            return zzcob2;
        }
    }

    public final String zzQ() {
        synchronized (this) {
            String string = this.zzr;
            return string;
        }
    }

    public final WebViewClient zzS() {
        return this.zzn;
    }

    public final boolean zzT() {
        synchronized (this) {
            boolean bl = this.zzs;
            return bl;
        }
    }

    public final zzaas zzU() {
        return this.zzc;
    }

    public final IObjectWrapper zzV() {
        synchronized (this) {
            IObjectWrapper iObjectWrapper = this.zzp;
            return iObjectWrapper;
        }
    }

    public final boolean zzW() {
        synchronized (this) {
            boolean bl = this.zzu;
            return bl;
        }
    }

    public final boolean zzX() {
        synchronized (this) {
            boolean bl = this.zzt;
            return bl;
        }
    }

    public final void zzY() {
        synchronized (this) {
            com.google.android.gms.ads.internal.util.zze.zza((String)"Destroying WebView!");
            this.zzba();
            zzfla zzfla2 = com.google.android.gms.ads.internal.util.zzs.zza;
            zzcnd zzcnd2 = new zzcnd(this);
            zzfla2.post((Runnable)zzcnd2);
            return;
        }
    }

    public final boolean zzZ() {
        synchronized (this) {
            boolean bl = this.zzx;
            return bl;
        }
    }

    public final void zza(String string) {
        throw null;
    }

    public final boolean zzaA() {
        return false;
    }

    public final zzfac zzaB() {
        return this.zzk;
    }

    public final void zzaC(zzezz zzezz2, zzfac zzfac2) {
        this.zzj = zzezz2;
        this.zzk = zzfac2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzaD(boolean bl) {
        synchronized (this) {
            zzl zzl2;
            if (bl) {
                this.setBackgroundColor(0);
            }
            if ((zzl2 = this.zzo) == null) return;
            zzl2.zzu(bl);
            return;
        }
    }

    public final zzfsm<String> zzaE() {
        zzbkk zzbkk2 = this.zzd;
        if (zzbkk2 != null) return zzbkk2.zzb();
        return zzfsd.zza(null);
    }

    public final void zzaF(zzc zzc2, boolean bl) {
        this.zzn.zzo(zzc2, bl);
    }

    public final void zzaG(boolean bl, int n, boolean bl2) {
        this.zzn.zzq(bl, n, bl2);
    }

    public final void zzaH(boolean bl, int n, String string, boolean bl2) {
        this.zzn.zzr(bl, n, string, bl2);
    }

    public final void zzaI(boolean bl, int n, String string, String string2, boolean bl2) {
        this.zzn.zzs(bl, n, string, string2, bl2);
    }

    public final void zzaJ(zzbu zzbu2, zzedq zzedq2, zzdvi zzdvi2, zzffc zzffc2, String string, String string2, int n) {
        this.zzn.zzp(zzbu2, zzedq2, zzdvi2, zzffc2, string, string2, n);
    }

    public final boolean zzaM() {
        int n;
        int n2;
        boolean bl = this.zzn.zzd();
        boolean bl2 = false;
        if (!bl) {
            if (!this.zzn.zze()) return false;
        }
        zzber.zza();
        Object object = this.zzh;
        int n3 = zzcgm.zzq((DisplayMetrics)object, (int)object.widthPixels);
        zzber.zza();
        object = this.zzh;
        int n4 = zzcgm.zzq((DisplayMetrics)object, (int)object.heightPixels);
        object = this.zzb.zza();
        if (object != null && object.getWindow() != null) {
            com.google.android.gms.ads.internal.zzt.zzc();
            object = com.google.android.gms.ads.internal.util.zzs.zzT((Activity)object);
            zzber.zza();
            n2 = zzcgm.zzq((DisplayMetrics)this.zzh, (int)object[0]);
            zzber.zza();
            n = zzcgm.zzq((DisplayMetrics)this.zzh, (int)object[1]);
        } else {
            n2 = n3;
            n = n4;
        }
        int n5 = this.zzS;
        if (n5 == n3 && this.zzR == n4 && this.zzT == n2) {
            if (this.zzU == n) return false;
        }
        if (n5 != n3 || this.zzR != n4) {
            bl2 = true;
        }
        this.zzS = n3;
        this.zzR = n4;
        this.zzT = n2;
        this.zzU = n;
        new zzbyp((zzcml)this, "").zzk(n3, n4, n2, n, this.zzh.density, this.zzW.getDefaultDisplay().getRotation());
        return bl2;
    }

    protected final void zzaN(String string) {
        synchronized (this) {
            if (!this.zzX()) {
                this.loadUrl(string);
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzi((String)"#004 The webview is destroyed. Ignoring action.");
            return;
        }
    }

    protected final void zzaO(String string, ValueCallback<String> valueCallback) {
        synchronized (this) {
            if (!this.zzX()) {
                this.evaluateJavascript(string, null);
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zzi((String)"#004 The webview is destroyed. Ignoring action.");
            return;
        }
    }

    protected final void zzaP(String string) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (this.zzaR() == null) {
                this.zzaV();
            }
            if (this.zzaR().booleanValue()) {
                this.zzaO(string, null);
                return;
            }
            string = string.length() != 0 ? "javascript:".concat(string) : new String("javascript:");
            this.zzaN(string);
            return;
        }
        string = string.length() != 0 ? "javascript:".concat(string) : new String("javascript:");
        this.zzaN(string);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    final void zzaQ(Boolean bl) {
        synchronized (this) {
            this.zzw = bl;
        }
        com.google.android.gms.ads.internal.zzt.zzg().zzf(bl);
    }

    final Boolean zzaR() {
        synchronized (this) {
            Boolean bl = this.zzw;
            return bl;
        }
    }

    public final zzcms zzaS() {
        return this.zzn;
    }

    public final boolean zzaa() {
        synchronized (this) {
            int n = this.zzF;
            boolean bl = n > 0;
            return bl;
        }
    }

    public final void zzab(String string, zzbpr<? super zzcml> zzbpr2) {
        zzcms zzcms2 = this.zzn;
        if (zzcms2 == null) return;
        zzcms2.zzu(string, zzbpr2);
    }

    public final void zzac(String string, zzbpr<? super zzcml> zzbpr2) {
        zzcms zzcms2 = this.zzn;
        if (zzcms2 == null) return;
        zzcms2.zzv(string, zzbpr2);
    }

    public final void zzad(String string, Predicate<zzbpr<? super zzcml>> predicate) {
        zzcms zzcms2 = this.zzn;
        if (zzcms2 == null) return;
        zzcms2.zzw(string, predicate);
    }

    public final void zzae(zzl zzl2) {
        synchronized (this) {
            this.zzo = zzl2;
            return;
        }
    }

    public final void zzaf(zzcob zzcob2) {
        synchronized (this) {
            this.zzq = zzcob2;
            this.requestLayout();
            return;
        }
    }

    public final void zzag(boolean bl) {
        synchronized (this) {
            boolean bl2 = this.zzu;
            this.zzu = bl;
            this.zzaX();
            if (bl == bl2) return;
            Object object = zzbjl.zzL;
            if (((Boolean)zzbet.zzc().zzc(object)).booleanValue()) {
                if (this.zzq.zzg()) return;
            }
            zzbyp zzbyp2 = new zzbyp((zzcml)this, "");
            object = true != bl ? "default" : "expanded";
            zzbyp2.zzj((String)object);
            return;
        }
    }

    public final void zzah() {
        this.zzQ.zzb();
    }

    public final void zzai(Context context) {
        this.zzb.setBaseContext(context);
        this.zzQ.zza(this.zzb.zza());
    }

    public final void zzaj(boolean bl) {
        synchronized (this) {
            zzl zzl2 = this.zzo;
            if (zzl2 != null) {
                zzl2.zzt(this.zzn.zzd(), bl);
                return;
            }
            this.zzs = bl;
            return;
        }
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        synchronized (this) {
            this.zzp = iObjectWrapper;
            return;
        }
    }

    public final void zzal(int n) {
        synchronized (this) {
            zzl zzl2 = this.zzo;
            if (zzl2 == null) return;
            zzl2.zzw(n);
            return;
        }
    }

    public final void zzam(zzl zzl2) {
        synchronized (this) {
            this.zzO = zzl2;
            return;
        }
    }

    public final void zzan(boolean bl) {
        synchronized (this) {
            this.zzx = bl;
            return;
        }
    }

    public final void zzao() {
        zzbjx zzbjx2;
        if (this.zzJ != null) return;
        this.zzK.zzc();
        this.zzJ = zzbjx2 = zzbka.zzf();
        this.zzK.zza("native:view_load", zzbjx2);
    }

    public final void zzap(zzblt zzblt2) {
        synchronized (this) {
            this.zzC = zzblt2;
            return;
        }
    }

    public final zzblt zzaq() {
        synchronized (this) {
            zzblt zzblt2 = this.zzC;
            return zzblt2;
        }
    }

    public final void zzar(boolean bl) {
        synchronized (this) {
            int n = this.zzF;
            int n2 = 1;
            if (!bl) {
                n2 = -1;
            }
            this.zzF = n2 = n + n2;
            if (n2 > 0) return;
            zzl zzl2 = this.zzo;
            if (zzl2 == null) return;
            zzl2.zzE();
            return;
        }
    }

    public final void zzas() {
        this.setBackgroundColor(0);
    }

    public final void zzat(String string, String string2, String string3) {
        synchronized (this) {
            block6: {
                if (this.zzX()) {
                    com.google.android.gms.ads.internal.util.zze.zzi((String)"#004 The webview is destroyed. Ignoring action.");
                    return;
                }
                string3 = zzbjl.zzK;
                CharSequence charSequence = (String)zzbet.zzc().zzc((zzbjd)string3);
                string3 = new JSONObject();
                try {
                    string3.put("version", (Object)charSequence);
                    string3.put("sdk", (Object)"Google Mobile Ads");
                    string3.put("sdkVersion", (Object)"12.4.51-000");
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return ");
                }
                catch (JSONException jSONException) {
                    com.google.android.gms.ads.internal.util.zze.zzj((String)"Unable to build MRAID_ENV", (Throwable)jSONException);
                    string3 = null;
                    break block6;
                }
                ((StringBuilder)charSequence).append(string3.toString());
                ((StringBuilder)charSequence).append("}});</script>");
                string3 = ((StringBuilder)charSequence).toString();
            }
            super.loadDataWithBaseURL(string, zzcns.zza((String)string2, (String[])new String[]{string3}), "text/html", "UTF-8", null);
            return;
        }
    }

    public final void zzau() {
        throw null;
    }

    public final void zzav(boolean bl) {
        this.zzn.zzD(bl);
    }

    public final void zzaw(zzblq zzblq2) {
        synchronized (this) {
            this.zzD = zzblq2;
            return;
        }
    }

    public final void zzax(zzaxq zzaxq2) {
        synchronized (this) {
            this.zzE = zzaxq2;
            return;
        }
    }

    public final zzaxq zzay() {
        synchronized (this) {
            zzaxq zzaxq2 = this.zzE;
            return zzaxq2;
        }
    }

    public final boolean zzaz(boolean bl, int n) {
        this.destroy();
        this.zzX.zzb((zzaza)new zzcnb(bl, n));
        this.zzX.zzc(10003);
        return true;
    }

    public final void zzb() {
        zzcms zzcms2 = this.zzn;
        if (zzcms2 == null) return;
        zzcms2.zzb();
    }

    public final void zzbl(String string, String string2) {
        int n = String.valueOf(string2).length();
        StringBuilder stringBuilder = new StringBuilder(string.length() + 3 + n);
        stringBuilder.append(string);
        stringBuilder.append("(");
        stringBuilder.append(string2);
        stringBuilder.append(");");
        this.zzaP(stringBuilder.toString());
    }

    public final void zzbm() {
        synchronized (this) {
            com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
            if (zzl2 == null) return;
            zzl2.zzbm();
            return;
        }
    }

    public final void zzbn() {
        synchronized (this) {
            com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
            if (zzl2 == null) return;
            zzl2.zzbn();
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzc(zzawc zzawc2) {
        synchronized (this) {
            this.zzA = zzawc2.zzj;
        }
        this.zzbd(zzawc2.zzj);
    }

    public final void zzd(String string, JSONObject object) {
        Object object2 = object;
        if (object == null) {
            object2 = new JSONObject();
        }
        object2 = object2.toString();
        object = new StringBuilder();
        ((StringBuilder)object).append("(window.AFMA_ReceiveMessage || function() {})('");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append("',");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(");");
        string = ((StringBuilder)object).toString();
        string = string.length() != 0 ? "Dispatching AFMA event: ".concat(string) : new String("Dispatching AFMA event: ");
        com.google.android.gms.ads.internal.util.zze.zzd((String)string);
        this.zzaP(((StringBuilder)object).toString());
    }

    public final void zze(String string, Map<String, ?> jSONObject) {
        try {
            jSONObject = com.google.android.gms.ads.internal.zzt.zzc().zzj(jSONObject);
            this.zzd(string, jSONObject);
            return;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzi((String)"Could not convert parameters to JSON.");
            return;
        }
    }

    public final zzciq zzf() {
        return null;
    }

    public final void zzg(boolean bl) {
        this.zzn.zzB(false);
    }

    public final zzcnh zzh() {
        synchronized (this) {
            zzcnh zzcnh2 = this.zzz;
            return zzcnh2;
        }
    }

    public final zzbjx zzi() {
        return this.zzI;
    }

    public final Activity zzj() {
        return this.zzb.zza();
    }

    public final zza zzk() {
        return this.zzg;
    }

    public final void zzl() {
        zzl zzl2 = this.zzN();
        if (zzl2 == null) return;
        zzl2.zzD();
    }

    public final String zzm() {
        synchronized (this) {
            String string = this.zzy;
            return string;
        }
    }

    public final String zzn() {
        synchronized (this) {
            Object object = this.zzk;
            if (object == null) return null;
            object = object.zzb;
            return object;
        }
    }

    public final void zzo(int n) {
        synchronized (this) {
            this.zzL = n;
            return;
        }
    }

    public final int zzp() {
        synchronized (this) {
            int n = this.zzL;
            return n;
        }
    }

    public final zzbjy zzq() {
        return this.zzK;
    }

    public final void zzr(String string, JSONObject jSONObject) {
        this.zzbl(string, jSONObject.toString());
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final zzcla zzs(String string) {
        synchronized (this) {
            Map<String, zzcla> map = this.zzV;
            if (map != null) return map.get(string);
            return null;
        }
    }

    public final zzcgz zzt() {
        return this.zze;
    }

    public final void zzu(String string, zzcla zzcla2) {
        synchronized (this) {
            if (this.zzV == null) {
                HashMap<String, zzcla> hashMap = new HashMap<String, zzcla>();
                this.zzV = hashMap;
            }
            this.zzV.put(string, zzcla2);
            return;
        }
    }

    public final void zzv(boolean bl, long l) {
        HashMap<String, String> hashMap = new HashMap<String, String>(2);
        String string = true != bl ? "0" : "1";
        hashMap.put("success", string);
        hashMap.put("duration", Long.toString(l));
        this.zze("onCacheAccessComplete", hashMap);
    }

    public final void zzw(int n) {
    }

    public final void zzx(zzcnh zzcnh2) {
        synchronized (this) {
            if (this.zzz != null) {
                com.google.android.gms.ads.internal.util.zze.zzf((String)"Attempt to create multiple AdWebViewVideoControllers.");
                return;
            }
            this.zzz = zzcnh2;
            return;
        }
    }

    public final int zzy() {
        return this.getMeasuredHeight();
    }

    public final int zzz() {
        return this.getMeasuredWidth();
    }
}
