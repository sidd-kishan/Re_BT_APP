/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.KeyguardManager
 *  android.content.res.Resources
 *  android.graphics.Rect
 *  android.os.PowerManager
 *  android.os.Process
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.webkit.WebView
 *  android.widget.EditText
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.common.util.PlatformVersion
 *  com.google.android.gms.internal.ads.zzaws
 *  com.google.android.gms.internal.ads.zzawt
 *  com.google.android.gms.internal.ads.zzawy
 *  com.google.android.gms.internal.ads.zzaxa
 *  com.google.android.gms.internal.ads.zzaxb
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbks
 *  com.google.android.gms.internal.ads.zzcml
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzaws;
import com.google.android.gms.internal.ads.zzawt;
import com.google.android.gms.internal.ads.zzawy;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxb;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbks;
import com.google.android.gms.internal.ads.zzcml;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzaxc
extends Thread {
    private boolean zza;
    private boolean zzb;
    private final Object zzc;
    private final zzawt zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzaxc() {
        zzawt zzawt2 = new zzawt();
        this.zza = false;
        this.zzb = false;
        this.zzd = zzawt2;
        this.zzc = new Object();
        this.zzf = ((Long)zzbks.zzd.zze()).intValue();
        this.zzg = ((Long)zzbks.zza.zze()).intValue();
        this.zzh = ((Long)zzbks.zze.zze()).intValue();
        this.zzi = ((Long)zzbks.zzc.zze()).intValue();
        zzawt2 = zzbjl.zzN;
        this.zzj = (Integer)zzbet.zzc().zzc((zzbjd)zzawt2);
        zzawt2 = zzbjl.zzO;
        this.zzk = (Integer)zzbet.zzc().zzc((zzbjd)zzawt2);
        zzawt2 = zzbjl.zzP;
        this.zzl = (Integer)zzbet.zzc().zzc((zzbjd)zzawt2);
        this.zze = ((Long)zzbks.zzf.zze()).intValue();
        zzawt2 = zzbjl.zzR;
        this.zzm = (String)zzbet.zzc().zzc((zzbjd)zzawt2);
        zzawt2 = zzbjl.zzS;
        this.zzn = (Boolean)zzbet.zzc().zzc((zzbjd)zzawt2);
        zzawt2 = zzbjl.zzT;
        this.zzo = (Boolean)zzbet.zzc().zzc((zzbjd)zzawt2);
        zzawt2 = zzbjl.zzU;
        this.zzp = (Boolean)zzbet.zzc().zzc((zzbjd)zzawt2);
        this.setName("ContentFetchTask");
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    @Override
    public final void run() {
        while (true) {
            var3_7 = zzt.zzf().zze();
            if (var3_7 == null) ** GOTO lbl42
            var4_10 = (ActivityManager)var3_7.getSystemService("activity");
            var2_2 /* !! */  = (KeyguardManager)var3_7.getSystemService("keyguard");
            if (var4_10 == null || var2_2 /* !! */  == null || (var4_10 = var4_10.getRunningAppProcesses()) == null) ** GOTO lbl42
            var4_10 = var4_10.iterator();
            while (var4_10.hasNext()) {
                var5_11 = (ActivityManager.RunningAppProcessInfo)var4_10.next();
                if (Process.myPid() != var5_11.pid) continue;
                if (var5_11.importance != 100 || var2_2 /* !! */ .inKeyguardRestrictedInputMode() || (var2_2 /* !! */  = (PowerManager)var3_7.getSystemService("power")) == null || !(var1_1 = var2_2 /* !! */ .isScreenOn())) ** GOTO lbl42
            }
            {
                block19: {
                    var4_10 = zzt.zzf().zzd();
                    if (var4_10 != null) break block19;
                    com.google.android.gms.ads.internal.util.zze.zzd((String)"ContentFetchThread: no activity. Sleeping.");
                    this.zzg();
                    ** GOTO lbl44
                }
                var3_7 = null;
                var2_2 /* !! */  = var3_7;
                try {
                    if (var4_10.getWindow() != null) {
                        var2_2 /* !! */  = var3_7;
                        if (var4_10.getWindow().getDecorView() != null) {
                            var2_2 /* !! */  = var4_10.getWindow().getDecorView().findViewById(0x1020002);
                        }
                    }
                    ** GOTO lbl35
                }
                catch (Exception var2_3) {
                    try {
                        block20: {
                            zzt.zzg().zzk((Throwable)var2_3, "ContentFetchTask.extractContent");
                            com.google.android.gms.ads.internal.util.zze.zzd((String)"Failed getting root view of activity. Content not extracted.");
                            var2_2 /* !! */  = var3_7;
lbl35:
                            // 2 sources

                            if (var2_2 /* !! */  != null) {
                                var3_7 = new zzawy(this, (View)var2_2 /* !! */ );
                                var2_2 /* !! */ .post((Runnable)var3_7);
                            }
                            break block20;
                            catch (Throwable var2_4) {
                                zzt.zzg().zzk(var2_4, "ContentFetchTask.isInForeground");
                            }
lbl42:
                            // 5 sources

                            com.google.android.gms.ads.internal.util.zze.zzd((String)"ContentFetchTask: sleeping");
                            this.zzg();
                        }
                        Thread.sleep(this.zze * 1000);
                        break;
                    }
                    catch (Exception var2_5) {
                        com.google.android.gms.ads.internal.util.zze.zzg((String)"Error in ContentFetchTask", (Throwable)var2_5);
                        zzt.zzg().zzk((Throwable)var2_5, "ContentFetchTask.run");
                        break;
                    }
                    catch (InterruptedException var2_6) {
                        com.google.android.gms.ads.internal.util.zze.zzg((String)"Error in ContentFetchTask", (Throwable)var2_6);
                        break;
                    }
                }
            }
            var2_2 /* !! */  = this.zzc;
            synchronized (var2_2 /* !! */ ) {
                while (true) {
                    if (!(var1_1 = this.zzb)) break;
                    try {
                        com.google.android.gms.ads.internal.util.zze.zzd((String)"ContentFetchTask: waiting");
                        this.zzc.wait();
                        continue;
                    }
                    catch (InterruptedException var3_9) {
                        continue;
                    }
                    break;
                }
            }
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zza() {
        Object object = this.zzc;
        synchronized (object) {
            if (this.zza) {
                com.google.android.gms.ads.internal.util.zze.zzd((String)"Content hash thread already started, quiting...");
                return;
            }
            this.zza = true;
        }
        this.start();
    }

    final void zzb(View view) {
        try {
            zzaws zzaws2 = new zzaws(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Object object = zzt.zzf().zze();
            if (object != null && !TextUtils.isEmpty((CharSequence)this.zzm)) {
                Resources resources = object.getResources();
                zzbjd zzbjd2 = zzbjl.zzQ;
                object = (String)view.getTag(resources.getIdentifier((String)zzbet.zzc().zzc(zzbjd2), "id", object.getPackageName()));
                if (object != null) {
                    if (((String)object).equals(this.zzm)) return;
                }
            }
            view = this.zzc(view, zzaws2);
            zzaws2.zzk();
            if (view.zza == 0) {
                if (view.zzb == 0) return;
            }
            if (view.zzb == 0) {
                if (zzaws2.zzo() == 0) return;
            }
            if (view.zzb == 0) {
                if (this.zzd.zzb(zzaws2)) return;
            }
            this.zzd.zzd(zzaws2);
            return;
        }
        catch (Exception exception) {
            com.google.android.gms.ads.internal.util.zze.zzg((String)"Exception in fetchContentOnUIThread", (Throwable)exception);
            zzt.zzg().zzk((Throwable)exception, "ContentFetchTask.fetchContent");
            return;
        }
    }

    final zzaxb zzc(View view, zzaws zzaws2) {
        int n = 0;
        if (view == null) {
            return new zzaxb(this, 0, 0);
        }
        boolean bl = view.getGlobalVisibleRect(new Rect());
        if (view instanceof TextView && !(view instanceof EditText)) {
            CharSequence charSequence = ((TextView)view).getText();
            if (TextUtils.isEmpty((CharSequence)charSequence)) return new zzaxb(this, 0, 0);
            zzaws2.zzi(charSequence.toString(), bl, view.getX(), view.getY(), (float)view.getWidth(), (float)view.getHeight());
            return new zzaxb(this, 1, 0);
        }
        if (view instanceof WebView && !(view instanceof zzcml)) {
            view = (WebView)view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                return new zzaxb(this, 0, 0);
            }
            zzaws2.zzg();
            view.post((Runnable)new zzaxa(this, zzaws2, (WebView)view, bl));
            return new zzaxb(this, 0, 1);
        }
        if (!(view instanceof ViewGroup)) return new zzaxb(this, 0, 0);
        view = (ViewGroup)view;
        int n2 = 0;
        int n3 = 0;
        while (n < view.getChildCount()) {
            zzaxb zzaxb2 = this.zzc(view.getChildAt(n), zzaws2);
            n2 += zzaxb2.zza;
            n3 += zzaxb2.zzb;
            ++n;
        }
        return new zzaxb(this, n2, n3);
    }

    final void zzd(zzaws zzaws2, WebView webView, String string, boolean bl) {
        zzaws2.zzf();
        try {
            if (!TextUtils.isEmpty((CharSequence)string)) {
                Object object = new JSONObject(string);
                object = object.optString("text");
                if (!this.zzn && !TextUtils.isEmpty((CharSequence)webView.getTitle())) {
                    string = webView.getTitle();
                    int n = String.valueOf(string).length();
                    int n2 = String.valueOf(object).length();
                    StringBuilder stringBuilder = new StringBuilder(n + 1 + n2);
                    stringBuilder.append(string);
                    stringBuilder.append("\n");
                    stringBuilder.append((String)object);
                    zzaws2.zzh(stringBuilder.toString(), bl, webView.getX(), webView.getY(), (float)webView.getWidth(), (float)webView.getHeight());
                } else {
                    zzaws2.zzh((String)object, bl, webView.getX(), webView.getY(), (float)webView.getWidth(), (float)webView.getHeight());
                }
            }
            if (!zzaws2.zza()) return;
            this.zzd.zzc(zzaws2);
            return;
        }
        catch (Throwable throwable) {
            com.google.android.gms.ads.internal.util.zze.zze((String)"Failed to get webview content.", (Throwable)throwable);
            zzt.zzg().zzk(throwable, "ContentFetchTask.processWebViewContent");
            return;
        }
        catch (JSONException jSONException) {
            com.google.android.gms.ads.internal.util.zze.zzd((String)"Json string may be malformed.");
            return;
        }
    }

    public final zzaws zze() {
        return this.zzd.zza(this.zzp);
    }

    public final void zzf() {
        Object object = this.zzc;
        synchronized (object) {
            this.zzb = false;
            this.zzc.notifyAll();
            com.google.android.gms.ads.internal.util.zze.zzd((String)"ContentFetchThread: wakeup");
            return;
        }
    }

    public final void zzg() {
        Object object = this.zzc;
        synchronized (object) {
            this.zzb = true;
            StringBuilder stringBuilder = new StringBuilder(42);
            stringBuilder.append("ContentFetchThread: paused, mPause = ");
            stringBuilder.append(true);
            com.google.android.gms.ads.internal.util.zze.zzd((String)stringBuilder.toString());
            return;
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
