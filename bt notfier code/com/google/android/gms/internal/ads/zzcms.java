/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.net.Uri
 *  android.view.KeyEvent
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.webkit.RenderProcessGoneDetail
 *  android.webkit.WebResourceResponse
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  androidx.core.view.ViewCompat
 *  com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel
 *  com.google.android.gms.ads.internal.overlay.zzc
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.overlay.zzm
 *  com.google.android.gms.ads.internal.overlay.zzo
 *  com.google.android.gms.ads.internal.overlay.zzv
 *  com.google.android.gms.ads.internal.util.zzbu
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzb
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.Predicate
 *  com.google.android.gms.internal.ads.zzaat
 *  com.google.android.gms.internal.ads.zzayn
 *  com.google.android.gms.internal.ads.zzazb
 *  com.google.android.gms.internal.ads.zzbcv
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbiv
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbjs
 *  com.google.android.gms.internal.ads.zzbjx
 *  com.google.android.gms.internal.ads.zzbka
 *  com.google.android.gms.internal.ads.zzbkv
 *  com.google.android.gms.internal.ads.zzbkz
 *  com.google.android.gms.internal.ads.zzboq
 *  com.google.android.gms.internal.ads.zzbor
 *  com.google.android.gms.internal.ads.zzbos
 *  com.google.android.gms.internal.ads.zzbot
 *  com.google.android.gms.internal.ads.zzbpq
 *  com.google.android.gms.internal.ads.zzbpr
 *  com.google.android.gms.internal.ads.zzbps
 *  com.google.android.gms.internal.ads.zzbpt
 *  com.google.android.gms.internal.ads.zzbpu
 *  com.google.android.gms.internal.ads.zzbpx
 *  com.google.android.gms.internal.ads.zzbpy
 *  com.google.android.gms.internal.ads.zzbqc
 *  com.google.android.gms.internal.ads.zzbyj
 *  com.google.android.gms.internal.ads.zzbyo
 *  com.google.android.gms.internal.ads.zzbyq
 *  com.google.android.gms.internal.ads.zzcdy
 *  com.google.android.gms.internal.ads.zzcfc
 *  com.google.android.gms.internal.ads.zzcgs
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 *  com.google.android.gms.internal.ads.zzclb
 *  com.google.android.gms.internal.ads.zzcml
 *  com.google.android.gms.internal.ads.zzcmm
 *  com.google.android.gms.internal.ads.zzcmn
 *  com.google.android.gms.internal.ads.zzcmo
 *  com.google.android.gms.internal.ads.zzcmp
 *  com.google.android.gms.internal.ads.zzcmq
 *  com.google.android.gms.internal.ads.zzcmr
 *  com.google.android.gms.internal.ads.zzcnx
 *  com.google.android.gms.internal.ads.zzcny
 *  com.google.android.gms.internal.ads.zzcnz
 *  com.google.android.gms.internal.ads.zzdio
 *  com.google.android.gms.internal.ads.zzdvi
 *  com.google.android.gms.internal.ads.zzedq
 *  com.google.android.gms.internal.ads.zzfba
 *  com.google.android.gms.internal.ads.zzffc
 *  com.google.android.gms.internal.ads.zzffu
 *  com.google.android.gms.internal.ads.zzfrz
 *  com.google.android.gms.internal.ads.zzfsd
 *  com.google.android.gms.internal.ads.zzfsm
 *  com.google.android.gms.internal.ads.zzfsn
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzv;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzayn;
import com.google.android.gms.internal.ads.zzazb;
import com.google.android.gms.internal.ads.zzbcv;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbiv;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbjs;
import com.google.android.gms.internal.ads.zzbjx;
import com.google.android.gms.internal.ads.zzbka;
import com.google.android.gms.internal.ads.zzbkv;
import com.google.android.gms.internal.ads.zzbkz;
import com.google.android.gms.internal.ads.zzboq;
import com.google.android.gms.internal.ads.zzbor;
import com.google.android.gms.internal.ads.zzbos;
import com.google.android.gms.internal.ads.zzbot;
import com.google.android.gms.internal.ads.zzbpq;
import com.google.android.gms.internal.ads.zzbpr;
import com.google.android.gms.internal.ads.zzbps;
import com.google.android.gms.internal.ads.zzbpt;
import com.google.android.gms.internal.ads.zzbpu;
import com.google.android.gms.internal.ads.zzbpx;
import com.google.android.gms.internal.ads.zzbpy;
import com.google.android.gms.internal.ads.zzbqc;
import com.google.android.gms.internal.ads.zzbyj;
import com.google.android.gms.internal.ads.zzbyo;
import com.google.android.gms.internal.ads.zzbyq;
import com.google.android.gms.internal.ads.zzcdy;
import com.google.android.gms.internal.ads.zzcfc;
import com.google.android.gms.internal.ads.zzcgs;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import com.google.android.gms.internal.ads.zzclb;
import com.google.android.gms.internal.ads.zzcml;
import com.google.android.gms.internal.ads.zzcmm;
import com.google.android.gms.internal.ads.zzcmn;
import com.google.android.gms.internal.ads.zzcmo;
import com.google.android.gms.internal.ads.zzcmp;
import com.google.android.gms.internal.ads.zzcmq;
import com.google.android.gms.internal.ads.zzcmr;
import com.google.android.gms.internal.ads.zzcnx;
import com.google.android.gms.internal.ads.zzcny;
import com.google.android.gms.internal.ads.zzcnz;
import com.google.android.gms.internal.ads.zzdio;
import com.google.android.gms.internal.ads.zzdvi;
import com.google.android.gms.internal.ads.zzedq;
import com.google.android.gms.internal.ads.zzfba;
import com.google.android.gms.internal.ads.zzffc;
import com.google.android.gms.internal.ads.zzffu;
import com.google.android.gms.internal.ads.zzfrz;
import com.google.android.gms.internal.ads.zzfsd;
import com.google.android.gms.internal.ads.zzfsm;
import com.google.android.gms.internal.ads.zzfsn;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class zzcms
extends WebViewClient
implements zzcnz {
    public static final int zzb = 0;
    private boolean zzA;
    private final HashSet<String> zzB;
    private View.OnAttachStateChangeListener zzC;
    protected zzcdy zza;
    private final zzcml zzc;
    private final zzazb zzd;
    private final HashMap<String, List<zzbpr<? super zzcml>>> zze;
    private final Object zzf;
    private zzbcv zzg;
    private zzo zzh;
    private zzcnx zzi;
    private zzcny zzj;
    private zzbor zzk;
    private zzbot zzl;
    private zzdio zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private zzv zzs;
    private zzbyo zzt;
    private zzb zzu;
    private zzbyj zzv;
    private zzffu zzw;
    private boolean zzx;
    private boolean zzy;
    private int zzz;

    public zzcms(zzcml zzcml2, zzazb zzazb2, boolean bl) {
        zzbyo zzbyo2 = new zzbyo(zzcml2, zzcml2.zzM(), new zzbiv(zzcml2.getContext()));
        this.zze = new HashMap();
        this.zzf = new Object();
        this.zzd = zzazb2;
        this.zzc = zzcml2;
        this.zzp = bl;
        this.zzt = zzbyo2;
        this.zzv = null;
        zzcml2 = zzbjl.zzdU;
        this.zzB = new HashSet<String>(Arrays.asList(((String)zzbet.zzc().zzc((zzbjd)zzcml2)).split(",")));
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ void zzG(zzcms zzcms2, Map map, List list, String string) {
        zzcms2.zzQ(map, list, string);
    }

    private final void zzM(View view, zzcdy zzcdy2, int n) {
        if (!zzcdy2.zzd()) return;
        if (n <= 0) return;
        zzcdy2.zze(view);
        if (!zzcdy2.zzd()) return;
        com.google.android.gms.ads.internal.util.zzs.zza.postDelayed((Runnable)new zzcmm(this, view, zzcdy2, n), 100L);
    }

    private final void zzN() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzC;
        if (onAttachStateChangeListener == null) {
            return;
        }
        ((View)this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
    }

    private static WebResourceResponse zzO() {
        zzbjd zzbjd2 = zzbjl.zzav;
        if ((Boolean)zzbet.zzc().zzc(zzbjd2) == false) return null;
        return new WebResourceResponse("", "", (InputStream)new ByteArrayInputStream(new byte[0]));
    }

    /*
     * Exception decompiling
     */
    private final WebResourceResponse zzP(String var1_1, Map<String, String> var2_3) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[UNCONDITIONALDOLOOP]], but top level block is 4[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private final void zzQ(Map<String, String> map, List<zzbpr<? super zzcml>> object, String charSequence) {
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            charSequence = ((String)charSequence).length() != 0 ? "Received GMSG: ".concat((String)charSequence) : new String("Received GMSG: ");
            com.google.android.gms.ads.internal.util.zze.zza((String)charSequence);
            for (String string : map.keySet()) {
                String string2 = map.get(string);
                charSequence = new StringBuilder(String.valueOf(string).length() + 4 + String.valueOf(string2).length());
                ((StringBuilder)charSequence).append("  ");
                ((StringBuilder)charSequence).append(string);
                ((StringBuilder)charSequence).append(": ");
                ((StringBuilder)charSequence).append(string2);
                com.google.android.gms.ads.internal.util.zze.zza((String)((StringBuilder)charSequence).toString());
            }
        }
        object = object.iterator();
        while (object.hasNext()) {
            ((zzbpr)object.next()).zza((Object)this.zzc, map);
        }
    }

    private static final boolean zzR(boolean bl, zzcml zzcml2) {
        if (!bl) return false;
        if (zzcml2.zzP().zzg()) return false;
        if (zzcml2.zzQ().equals("interstitial_mb")) return false;
        return true;
    }

    static /* synthetic */ void zzi(zzcms zzcms2, View view, zzcdy zzcdy2, int n) {
        zzcms2.zzM(view, zzcdy2, 10);
    }

    public final void onAdClicked() {
        zzbcv zzbcv2 = this.zzg;
        if (zzbcv2 == null) return;
        zzbcv2.onAdClicked();
    }

    public final void onLoadResource(WebView object, String string) {
        object = String.valueOf(string);
        object = ((String)object).length() != 0 ? "Loading resource: ".concat((String)object) : new String("Loading resource: ");
        com.google.android.gms.ads.internal.util.zze.zza((String)object);
        object = Uri.parse((String)string);
        if (!"gmsg".equalsIgnoreCase(object.getScheme())) return;
        if (!"mobileads.google.com".equalsIgnoreCase(object.getHost())) return;
        this.zzF((Uri)object);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void onPageFinished(WebView object, String string) {
        object = this.zzf;
        synchronized (object) {
            if (this.zzc.zzX()) {
                com.google.android.gms.ads.internal.util.zze.zza((String)"Blank page loaded, 1...");
                this.zzc.zzY();
                return;
            }
        }
        this.zzx = true;
        object = this.zzj;
        if (object != null) {
            object.zzb();
            this.zzj = null;
        }
        this.zzn();
    }

    public final void onReceivedError(WebView webView, int n, String string, String string2) {
        this.zzo = true;
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaz(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String string) {
        return this.zzA(string, Collections.<String, String>emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int n = keyEvent.getKeyCode();
        if (n == 79) return true;
        if (n == 222) return true;
        switch (n) {
            default: {
                switch (n) {
                    default: {
                        return false;
                    }
                    case 126: 
                    case 127: 
                    case 128: 
                    case 129: 
                    case 130: 
                }
                break;
            }
            case 85: 
            case 86: 
            case 87: 
            case 88: 
            case 89: 
            case 90: 
            case 91: 
        }
        return true;
    }

    public final boolean shouldOverrideUrlLoading(WebView object, String string) {
        String string2 = String.valueOf(string);
        string2 = string2.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(string2) : new String("AdWebView shouldOverrideUrlLoading: ");
        com.google.android.gms.ads.internal.util.zze.zza((String)string2);
        string2 = Uri.parse((String)string);
        if ("gmsg".equalsIgnoreCase(string2.getScheme()) && "mobileads.google.com".equalsIgnoreCase(string2.getHost())) {
            this.zzF((Uri)string2);
        } else {
            String string3;
            if (this.zzn && object == this.zzc.zzG() && ("http".equalsIgnoreCase(string3 = string2.getScheme()) || "https".equalsIgnoreCase(string3))) {
                string2 = this.zzg;
                if (string2 != null) {
                    string2.onAdClicked();
                    string2 = this.zza;
                    if (string2 != null) {
                        string2.zzc(string);
                    }
                    this.zzg = null;
                }
                if ((string2 = this.zzm) == null) return super.shouldOverrideUrlLoading((WebView)object, string);
                string2.zzb();
                this.zzm = null;
                return super.shouldOverrideUrlLoading((WebView)object, string);
            }
            if (!this.zzc.zzG().willNotDraw()) {
                try {
                    string3 = this.zzc.zzU();
                    object = string2;
                    if (string3 != null) {
                        object = string2;
                        if (string3.zza((Uri)string2)) {
                            Context context = this.zzc.getContext();
                            object = this.zzc;
                            Activity activity = object.zzj();
                            object = string3.zze((Uri)string2, context, (View)object, activity);
                        }
                    }
                }
                catch (zzaat zzaat2) {
                    object = String.valueOf(string);
                    object = ((String)object).length() != 0 ? "Unable to append parameter to URL: ".concat((String)object) : new String("Unable to append parameter to URL: ");
                    com.google.android.gms.ads.internal.util.zze.zzi((String)object);
                    object = string2;
                }
                if ((string2 = this.zzu) != null && !string2.zzb()) {
                    this.zzu.zzc(string);
                } else {
                    this.zzo(new zzc("android.intent.action.VIEW", object.toString(), null, null, null, null, null, null), true);
                }
            } else {
                object = String.valueOf(string);
                object = ((String)object).length() != 0 ? "AdWebView unable to handle URL: ".concat((String)object) : new String("AdWebView unable to handle URL: ");
                com.google.android.gms.ads.internal.util.zze.zzi((String)object);
            }
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    protected final WebResourceResponse zzA(String object, Map<String, String> map) {
        void var1_4;
        try {
            boolean bl = (Boolean)zzbkz.zza.zze();
            if (bl && this.zzw != null && "oda".equals(Uri.parse((String)object).getScheme())) {
                this.zzw.zzb((String)object);
                object = new ByteArrayInputStream(new byte[0]);
                return new WebResourceResponse("", "", (InputStream)object);
            }
            String string = zzcfc.zza((String)object, (Context)this.zzc.getContext(), (boolean)this.zzA);
            if (!string.equals(object)) {
                return this.zzP(string, map);
            }
            string = zzayn.zza((Uri)Uri.parse((String)object));
            if (string != null && (string = com.google.android.gms.ads.internal.zzt.zzi().zzf((zzayn)string)) != null && string.zza()) {
                return new WebResourceResponse("", "", string.zzb());
            }
            if (!zzcgs.zzj()) return null;
            if ((Boolean)zzbkv.zzb.zze() == false) return null;
            object = this.zzP((String)object, map);
            return object;
        }
        catch (NoClassDefFoundError noClassDefFoundError) {
        }
        catch (Exception exception) {
            // empty catch block
        }
        com.google.android.gms.ads.internal.zzt.zzg().zzk((Throwable)var1_4, "AdWebViewClient.interceptRequest");
        return zzcms.zzO();
    }

    public final void zzB(boolean bl) {
        this.zzn = false;
    }

    public final void zzC() {
        Object object = this.zzf;
        synchronized (object) {
            this.zzn = false;
            this.zzp = true;
            zzfsn zzfsn2 = zzchg.zze;
            zzcmn zzcmn2 = new zzcmn(this);
            zzfsn2.execute((Runnable)zzcmn2);
            return;
        }
    }

    public final void zzD(boolean bl) {
        this.zzA = bl;
    }

    public final void zzE(int n, int n2) {
        zzbyj zzbyj2 = this.zzv;
        if (zzbyj2 == null) return;
        zzbyj2.zze(n, n2);
    }

    public final void zzF(Uri object) {
        String string = object.getPath();
        List<zzbpr<? super zzcml>> list = this.zze.get(string);
        if (string != null && list != null) {
            String string2 = object.getEncodedQuery();
            zzbjd zzbjd2 = zzbjl.zzdT;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zzB.contains(string) && string2 != null) {
                zzbjd2 = zzbjl.zzdV;
                if (string2.length() >= (Integer)zzbet.zzc().zzc(zzbjd2)) {
                    string2 = string.length() != 0 ? "Parsing gmsg query params on BG thread: ".concat(string) : new String("Parsing gmsg query params on BG thread: ");
                    com.google.android.gms.ads.internal.util.zze.zza((String)string2);
                    zzfsd.zzp((zzfsm)com.google.android.gms.ads.internal.zzt.zzc().zzm(object), (zzfrz)new zzcmq(this, list, string, object), (Executor)zzchg.zze);
                    return;
                }
            }
            com.google.android.gms.ads.internal.zzt.zzc();
            this.zzQ(com.google.android.gms.ads.internal.util.zzs.zzR((Uri)object), list, string);
            return;
        }
        object = String.valueOf(object);
        String.valueOf(object).length();
        com.google.android.gms.ads.internal.util.zze.zza((String)"No GMSG handler found for GMSG: ".concat(String.valueOf(object)));
        object = zzbjl.zzfa;
        if ((Boolean)zzbet.zzc().zzc((zzbjd)object) == false) return;
        if (com.google.android.gms.ads.internal.zzt.zzg().zze() == null) return;
        object = string != null && string.length() >= 2 ? string.substring(1) : "null";
        zzchg.zza.execute((Runnable)new zzcmo((String)object));
    }

    public final void zzH(boolean bl) {
        Object object = this.zzf;
        synchronized (object) {
            this.zzq = true;
            return;
        }
    }

    public final void zzI(boolean bl) {
        Object object = this.zzf;
        synchronized (object) {
            this.zzr = bl;
            return;
        }
    }

    final /* synthetic */ void zzJ() {
        this.zzc.zzah();
        zzl zzl2 = this.zzc.zzN();
        if (zzl2 == null) return;
        zzl2.zzv();
    }

    final /* synthetic */ void zzK(View view, zzcdy zzcdy2, int n) {
        this.zzM(view, zzcdy2, n - 1);
    }

    public final void zzL(zzbcv zzbcv2, zzbor zzbor2, zzo zzo2, zzbot zzbot2, zzv zzv2, boolean bl, zzbpu zzbpu2, zzb zzb2, zzbyq zzbyq2, zzcdy zzcdy2, zzedq zzedq2, zzffu zzffu2, zzdvi zzdvi2, zzffc zzffc2, zzbps zzbps2, zzdio zzdio2) {
        if (zzb2 == null) {
            zzb2 = new zzb(this.zzc.getContext(), zzcdy2, null);
        }
        this.zzv = new zzbyj(this.zzc, zzbyq2);
        this.zza = zzcdy2;
        zzcdy2 = zzbjl.zzaC;
        if (((Boolean)zzbet.zzc().zzc((zzbjd)zzcdy2)).booleanValue()) {
            this.zzu("/adMetadata", (zzbpr<? super zzcml>)new zzboq(zzbor2));
        }
        if (zzbot2 != null) {
            this.zzu("/appEvent", (zzbpr<? super zzcml>)new zzbos(zzbot2));
        }
        this.zzu("/backButton", (zzbpr<? super zzcml>)zzbpq.zzj);
        this.zzu("/refresh", (zzbpr<? super zzcml>)zzbpq.zzk);
        this.zzu("/canOpenApp", (zzbpr<? super zzcml>)zzbpq.zzb);
        this.zzu("/canOpenURLs", (zzbpr<? super zzcml>)zzbpq.zza);
        this.zzu("/canOpenIntents", (zzbpr<? super zzcml>)zzbpq.zzc);
        this.zzu("/close", (zzbpr<? super zzcml>)zzbpq.zzd);
        this.zzu("/customClose", (zzbpr<? super zzcml>)zzbpq.zze);
        this.zzu("/instrument", (zzbpr<? super zzcml>)zzbpq.zzn);
        this.zzu("/delayPageLoaded", (zzbpr<? super zzcml>)zzbpq.zzp);
        this.zzu("/delayPageClosed", (zzbpr<? super zzcml>)zzbpq.zzq);
        this.zzu("/getLocationInfo", (zzbpr<? super zzcml>)zzbpq.zzr);
        this.zzu("/log", (zzbpr<? super zzcml>)zzbpq.zzg);
        this.zzu("/mraid", (zzbpr<? super zzcml>)new zzbpy(zzb2, this.zzv, zzbyq2));
        zzbyq2 = this.zzt;
        if (zzbyq2 != null) {
            this.zzu("/mraidLoaded", (zzbpr<? super zzcml>)zzbyq2);
        }
        this.zzu("/open", (zzbpr<? super zzcml>)new zzbqc(zzb2, this.zzv, zzedq2, zzdvi2, zzffc2));
        this.zzu("/precache", (zzbpr<? super zzcml>)new zzclb());
        this.zzu("/touch", (zzbpr<? super zzcml>)zzbpq.zzi);
        this.zzu("/video", (zzbpr<? super zzcml>)zzbpq.zzl);
        this.zzu("/videoMeta", (zzbpr<? super zzcml>)zzbpq.zzm);
        if (zzedq2 != null && zzffu2 != null) {
            this.zzu("/click", (zzbpr<? super zzcml>)zzfba.zza((zzedq)zzedq2, (zzffu)zzffu2, (zzdio)zzdio2));
            this.zzu("/httpTrack", (zzbpr<? super zzcml>)zzfba.zzb((zzedq)zzedq2, (zzffu)zzffu2));
        } else {
            this.zzu("/click", (zzbpr<? super zzcml>)zzbpq.zzb((zzdio)zzdio2));
            this.zzu("/httpTrack", (zzbpr<? super zzcml>)zzbpq.zzf);
        }
        if (com.google.android.gms.ads.internal.zzt.zzA().zzb(this.zzc.getContext())) {
            this.zzu("/logScionEvent", (zzbpr<? super zzcml>)new zzbpx(this.zzc.getContext()));
        }
        if (zzbpu2 != null) {
            this.zzu("/setInterstitialProperties", (zzbpr<? super zzcml>)new zzbpt(zzbpu2, null));
        }
        if (zzbps2 != null) {
            zzbpu2 = zzbjl.zzgp;
            if (((Boolean)zzbet.zzc().zzc((zzbjd)zzbpu2)).booleanValue()) {
                this.zzu("/inspectorNetworkExtras", (zzbpr<? super zzcml>)zzbps2);
            }
        }
        this.zzg = zzbcv2;
        this.zzh = zzo2;
        this.zzk = zzbor2;
        this.zzl = zzbot2;
        this.zzs = zzv2;
        this.zzu = zzb2;
        this.zzm = zzdio2;
        this.zzn = bl;
        this.zzw = zzffu2;
    }

    public final void zza(int n, int n2, boolean bl) {
        zzbyo zzbyo2 = this.zzt;
        if (zzbyo2 != null) {
            zzbyo2.zzb(n, n2);
        }
        if ((zzbyo2 = this.zzv) == null) return;
        zzbyo2.zzc(n, n2, false);
    }

    public final void zzb() {
        zzdio zzdio2 = this.zzm;
        if (zzdio2 == null) return;
        zzdio2.zzb();
    }

    public final zzb zzc() {
        return this.zzu;
    }

    public final boolean zzd() {
        Object object = this.zzf;
        synchronized (object) {
            boolean bl = this.zzp;
            return bl;
        }
    }

    public final boolean zze() {
        Object object = this.zzf;
        synchronized (object) {
            boolean bl = this.zzq;
            return bl;
        }
    }

    public final boolean zzf() {
        Object object = this.zzf;
        synchronized (object) {
            boolean bl = this.zzr;
            return bl;
        }
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzg() {
        Object object = this.zzf;
        synchronized (object) {
            return null;
        }
    }

    public final ViewTreeObserver.OnScrollChangedListener zzh() {
        Object object = this.zzf;
        synchronized (object) {
            return null;
        }
    }

    public final void zzj() {
        zzcdy zzcdy2 = this.zza;
        if (zzcdy2 == null) return;
        WebView webView = this.zzc.zzG();
        if (ViewCompat.isAttachedToWindow((View)webView)) {
            this.zzM((View)webView, zzcdy2, 10);
            return;
        }
        this.zzN();
        zzcdy2 = new zzcmp(this, zzcdy2);
        this.zzC = zzcdy2;
        ((View)this.zzc).addOnAttachStateChangeListener((View.OnAttachStateChangeListener)zzcdy2);
    }

    /*
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public final void zzk() {
        Object object = this.zzf;
        // MONITORENTER : object
        // MONITOREXIT : object
        ++this.zzz;
        this.zzn();
    }

    public final void zzl() {
        --this.zzz;
        this.zzn();
    }

    public final void zzm() {
        zzazb zzazb2 = this.zzd;
        if (zzazb2 != null) {
            zzazb2.zzc(10005);
        }
        this.zzy = true;
        this.zzn();
        this.zzc.destroy();
    }

    public final void zzn() {
        if (this.zzi != null && (this.zzx && this.zzz <= 0 || this.zzy || this.zzo)) {
            boolean bl;
            zzbjd zzbjd2 = zzbjl.zzbl;
            if (((Boolean)zzbet.zzc().zzc(zzbjd2)).booleanValue() && this.zzc.zzq() != null) {
                zzbjs.zza((zzbka)this.zzc.zzq().zzc(), (zzbjx)this.zzc.zzi(), (String[])new String[]{"awfllc"});
            }
            zzbjd2 = this.zzi;
            boolean bl2 = this.zzy;
            boolean bl3 = bl = false;
            if (!bl2) {
                bl3 = bl;
                if (!this.zzo) {
                    bl3 = true;
                }
            }
            zzbjd2.zza(bl3);
            this.zzi = null;
        }
        this.zzc.zzao();
    }

    public final void zzo(zzc zzc2, boolean bl) {
        boolean bl2;
        boolean bl3 = this.zzc.zzW();
        boolean bl4 = zzcms.zzR(bl3, this.zzc);
        boolean bl5 = bl2 = true;
        if (!bl4) {
            bl5 = !bl ? bl2 : false;
        }
        zzbcv zzbcv2 = bl4 ? null : this.zzg;
        zzo zzo2 = bl3 ? null : this.zzh;
        zzv zzv2 = this.zzs;
        zzcgz zzcgz2 = this.zzc.zzt();
        zzcml zzcml2 = this.zzc;
        zzdio zzdio2 = bl5 ? null : this.zzm;
        this.zzt(new AdOverlayInfoParcel(zzc2, zzbcv2, zzo2, zzv2, zzcgz2, zzcml2, zzdio2));
    }

    public final void zzp(zzbu zzbu2, zzedq zzedq2, zzdvi zzdvi2, zzffc zzffc2, String string, String string2, int n) {
        zzcml zzcml2 = this.zzc;
        this.zzt(new AdOverlayInfoParcel(zzcml2, zzcml2.zzt(), zzbu2, zzedq2, zzdvi2, zzffc2, string, string2, n));
    }

    public final void zzq(boolean bl, int n, boolean bl2) {
        boolean bl3;
        boolean bl4 = zzcms.zzR(this.zzc.zzW(), this.zzc);
        boolean bl5 = bl3 = true;
        if (!bl4) {
            bl5 = !bl2 ? bl3 : false;
        }
        zzbcv zzbcv2 = bl4 ? null : this.zzg;
        zzo zzo2 = this.zzh;
        zzv zzv2 = this.zzs;
        zzcml zzcml2 = this.zzc;
        zzcgz zzcgz2 = zzcml2.zzt();
        zzdio zzdio2 = bl5 ? null : this.zzm;
        this.zzt(new AdOverlayInfoParcel(zzbcv2, zzo2, zzv2, zzcml2, bl, n, zzcgz2, zzdio2));
    }

    public final void zzr(boolean bl, int n, String string, boolean bl2) {
        boolean bl3;
        boolean bl4 = this.zzc.zzW();
        boolean bl5 = zzcms.zzR(bl4, this.zzc);
        boolean bl6 = bl3 = true;
        if (!bl5) {
            bl6 = !bl2 ? bl3 : false;
        }
        zzbcv zzbcv2 = bl5 ? null : this.zzg;
        zzcmr zzcmr2 = bl4 ? null : new zzcmr(this.zzc, this.zzh);
        zzbor zzbor2 = this.zzk;
        zzbot zzbot2 = this.zzl;
        zzv zzv2 = this.zzs;
        zzcml zzcml2 = this.zzc;
        zzcgz zzcgz2 = zzcml2.zzt();
        zzdio zzdio2 = bl6 ? null : this.zzm;
        this.zzt(new AdOverlayInfoParcel(zzbcv2, (zzo)zzcmr2, zzbor2, zzbot2, zzv2, zzcml2, bl, n, string, zzcgz2, zzdio2));
    }

    public final void zzs(boolean bl, int n, String string, String string2, boolean bl2) {
        boolean bl3;
        boolean bl4 = this.zzc.zzW();
        boolean bl5 = zzcms.zzR(bl4, this.zzc);
        boolean bl6 = bl3 = true;
        if (!bl5) {
            bl6 = !bl2 ? bl3 : false;
        }
        zzbcv zzbcv2 = bl5 ? null : this.zzg;
        zzcmr zzcmr2 = bl4 ? null : new zzcmr(this.zzc, this.zzh);
        zzbor zzbor2 = this.zzk;
        zzbot zzbot2 = this.zzl;
        zzv zzv2 = this.zzs;
        zzcml zzcml2 = this.zzc;
        zzcgz zzcgz2 = zzcml2.zzt();
        zzdio zzdio2 = bl6 ? null : this.zzm;
        this.zzt(new AdOverlayInfoParcel(zzbcv2, (zzo)zzcmr2, zzbor2, zzbot2, zzv2, zzcml2, bl, n, string, string2, zzcgz2, zzdio2));
    }

    public final void zzt(AdOverlayInfoParcel adOverlayInfoParcel) {
        Object object = this.zzv;
        boolean bl = object != null ? object.zzd() : false;
        com.google.android.gms.ads.internal.zzt.zzb();
        com.google.android.gms.ads.internal.overlay.zzm.zza((Context)this.zzc.getContext(), (AdOverlayInfoParcel)adOverlayInfoParcel, (boolean)(bl ^ true));
        zzcdy zzcdy2 = this.zza;
        if (zzcdy2 == null) return;
        String string = adOverlayInfoParcel.zzl;
        object = string;
        if (string == null) {
            adOverlayInfoParcel = adOverlayInfoParcel.zza;
            object = string;
            if (adOverlayInfoParcel != null) {
                object = adOverlayInfoParcel.zzb;
            }
        }
        zzcdy2.zzc((String)object);
    }

    public final void zzu(String string, zzbpr<? super zzcml> zzbpr2) {
        Object object = this.zzf;
        synchronized (object) {
            CopyOnWriteArrayList<zzbpr<? super zzcml>> copyOnWriteArrayList;
            CopyOnWriteArrayList<zzbpr<? super zzcml>> copyOnWriteArrayList2 = copyOnWriteArrayList = this.zze.get(string);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList2 = new CopyOnWriteArrayList<zzbpr<? super zzcml>>();
                this.zze.put(string, copyOnWriteArrayList2);
            }
            copyOnWriteArrayList2.add(zzbpr2);
            return;
        }
    }

    public final void zzv(String object, zzbpr<? super zzcml> zzbpr2) {
        Object object2 = this.zzf;
        synchronized (object2) {
            object = this.zze.get(object);
            if (object == null) {
                return;
            }
            object.remove(zzbpr2);
            return;
        }
    }

    public final void zzw(String object, Predicate<zzbpr<? super zzcml>> predicate) {
        Object object2 = this.zzf;
        synchronized (object2) {
            try {
                object = this.zze.get(object);
                if (object == null) {
                    return;
                }
                ArrayList<zzbpr> arrayList = new ArrayList<zzbpr>();
                Iterator iterator = object.iterator();
                while (true) {
                    if (!iterator.hasNext()) {
                        object.removeAll(arrayList);
                        return;
                    }
                    zzbpr zzbpr2 = (zzbpr)iterator.next();
                    if (!predicate.apply((Object)zzbpr2)) continue;
                    arrayList.add(zzbpr2);
                }
            }
            catch (Throwable throwable) {
                throw throwable;
            }
        }
    }

    public final void zzx() {
        Object object = this.zza;
        if (object != null) {
            object.zzg();
            this.zza = null;
        }
        this.zzN();
        object = this.zzf;
        synchronized (object) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzp = false;
            this.zzq = false;
            this.zzs = null;
            this.zzu = null;
            this.zzt = null;
            zzbyj zzbyj2 = this.zzv;
            if (zzbyj2 != null) {
                zzbyj2.zzb(true);
                this.zzv = null;
            }
            this.zzw = null;
            return;
        }
    }

    public final void zzy(zzcnx zzcnx2) {
        this.zzi = zzcnx2;
    }

    public final void zzz(zzcny zzcny2) {
        this.zzj = zzcny2;
    }
}
