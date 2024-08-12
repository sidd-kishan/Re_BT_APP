/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Message
 *  android.view.View
 *  android.view.WindowManager$BadTokenException
 *  android.webkit.ConsoleMessage
 *  android.webkit.GeolocationPermissions$Callback
 *  android.webkit.JsPromptResult
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebStorage$QuotaUpdater
 *  android.webkit.WebView
 *  android.webkit.WebView$WebViewTransport
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.google.android.gms.ads.internal.overlay.zzl
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.util.zzs
 *  com.google.android.gms.ads.internal.zzt
 *  com.google.android.gms.internal.ads.zzcmd
 *  com.google.android.gms.internal.ads.zzcme
 *  com.google.android.gms.internal.ads.zzcmf
 *  com.google.android.gms.internal.ads.zzcmg
 *  com.google.android.gms.internal.ads.zzcmh
 *  com.google.android.gms.internal.ads.zzcmi
 *  com.google.android.gms.internal.ads.zzcmj
 *  com.google.android.gms.internal.ads.zzcml
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzcmd;
import com.google.android.gms.internal.ads.zzcme;
import com.google.android.gms.internal.ads.zzcmf;
import com.google.android.gms.internal.ads.zzcmg;
import com.google.android.gms.internal.ads.zzcmh;
import com.google.android.gms.internal.ads.zzcmi;
import com.google.android.gms.internal.ads.zzcmj;
import com.google.android.gms.internal.ads.zzcml;

public final class zzcmk
extends WebChromeClient {
    private final zzcml zza;

    public zzcmk(zzcml zzcml2) {
        this.zza = zzcml2;
    }

    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcml)) {
            return webView.getContext();
        }
        Activity activity = (webView = (zzcml)webView).zzj();
        if (activity == null) return webView.getContext();
        return activity;
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcml)) {
            zze.zzi((String)"Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        if ((webView = ((zzcml)webView).zzN()) == null) {
            zze.zzi((String)"Tried to close an AdWebView not associated with an overlay.");
            return;
        }
        webView.zzb();
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String string = consoleMessage.message();
        String string2 = consoleMessage.sourceId();
        int n = consoleMessage.lineNumber();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 19 + String.valueOf(string2).length());
        stringBuilder.append("JS: ");
        stringBuilder.append(string);
        stringBuilder.append(" (");
        stringBuilder.append(string2);
        stringBuilder.append(":");
        stringBuilder.append(n);
        stringBuilder.append(")");
        string2 = stringBuilder.toString();
        if (string2.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        n = zzcmj.zza[consoleMessage.messageLevel().ordinal()];
        if (n != 1) {
            if (n != 2) {
                if (n != 3 && n != 4) {
                    if (n != 5) {
                        zze.zzh((String)string2);
                    } else {
                        zze.zzd((String)string2);
                    }
                } else {
                    zze.zzh((String)string2);
                }
            } else {
                zze.zzi((String)string2);
            }
        } else {
            zze.zzf((String)string2);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean bl, boolean bl2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport)message.obj;
        webView = new WebView(webView.getContext());
        if (this.zza.zzS() != null) {
            webView.setWebViewClient(this.zza.zzS());
        }
        webViewTransport.setWebView(webView);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String string, String string2, long l, long l2, long l3, WebStorage.QuotaUpdater quotaUpdater) {
        long l4 = 0x500000L - l3;
        if (l4 <= 0L) {
            quotaUpdater.updateQuota(l);
            return;
        }
        if (l == 0L) {
            if (l2 > l4 || l2 > 0x100000L) {
                l2 = 0L;
            }
        } else if (l2 == 0L) {
            l2 = Math.min(l + Math.min(131072L, l4), 0x100000L);
        } else {
            l3 = l;
            if (l2 <= Math.min(0x100000L - l, l4)) {
                l3 = l + l2;
            }
            l2 = l3;
        }
        quotaUpdater.updateQuota(l2);
    }

    /*
     * Unable to fully structure code
     */
    public final void onGeolocationPermissionsShowPrompt(String var1_1, GeolocationPermissions.Callback var2_2) {
        if (var2_2 == null) return;
        zzt.zzc();
        if (zzs.zzE((Context)this.zza.getContext(), (String)"android.permission.ACCESS_FINE_LOCATION")) ** GOTO lbl-1000
        zzt.zzc();
        if (!zzs.zzE((Context)this.zza.getContext(), (String)"android.permission.ACCESS_COARSE_LOCATION")) {
            var3_3 = false;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 = true;
        }
        var2_2.invoke(var1_1, var3_3, true);
    }

    public final void onHideCustomView() {
        zzl zzl2 = this.zza.zzN();
        if (zzl2 == null) {
            zze.zzi((String)"Could not get ad overlay when hiding custom view.");
            return;
        }
        zzl2.zzc();
    }

    public final boolean onJsAlert(WebView webView, String string, String string2, JsResult jsResult) {
        return this.zza(zzcmk.zzb(webView), "alert", string, string2, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String string, String string2, JsResult jsResult) {
        return this.zza(zzcmk.zzb(webView), "onBeforeUnload", string, string2, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String string, String string2, JsResult jsResult) {
        return this.zza(zzcmk.zzb(webView), "confirm", string, string2, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String string, String string2, String string3, JsPromptResult jsPromptResult) {
        return this.zza(zzcmk.zzb(webView), "prompt", string, string2, string3, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long l, long l2, WebStorage.QuotaUpdater quotaUpdater) {
        if (0x500000L - l2 < (l += 131072L)) {
            quotaUpdater.updateQuota(0L);
            return;
        }
        quotaUpdater.updateQuota(l);
    }

    @Deprecated
    public final void onShowCustomView(View view, int n, WebChromeClient.CustomViewCallback customViewCallback) {
        zzl zzl2 = this.zza.zzN();
        if (zzl2 == null) {
            zze.zzi((String)"Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzl2.zzx(view, customViewCallback);
        zzl2.zzw(n);
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.onShowCustomView(view, -1, customViewCallback);
    }

    protected final boolean zza(Context object, String string, String string2, String string3, String string4, JsResult jsResult, JsPromptResult jsPromptResult, boolean bl) {
        try {
            zzcml zzcml2 = this.zza;
            if (zzcml2 != null && zzcml2.zzR() != null && this.zza.zzR().zzc() != null && (zzcml2 = this.zza.zzR().zzc()) != null && !zzcml2.zzb()) {
                int n = string.length();
                int n2 = String.valueOf(string3).length();
                object = new StringBuilder(n + 11 + n2);
                ((StringBuilder)object).append("window.");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append("('");
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append("')");
                zzcml2.zzc(((StringBuilder)object).toString());
                return false;
            }
            string = new AlertDialog.Builder((Context)object);
            string.setTitle((CharSequence)string2);
            if (bl) {
                jsResult = new LinearLayout((Context)object);
                jsResult.setOrientation(1);
                zzcml2 = new TextView((Context)object);
                zzcml2.setText((CharSequence)string3);
                string2 = new EditText((Context)object);
                string2.setText((CharSequence)string4);
                jsResult.addView((View)zzcml2);
                jsResult.addView((View)string2);
                object = string.setView((View)jsResult);
                string = new zzcmi(jsPromptResult, (EditText)string2);
                string = object.setPositiveButton(17039370, (DialogInterface.OnClickListener)string);
                object = new zzcmh(jsPromptResult);
                object = string.setNegativeButton(0x1040000, (DialogInterface.OnClickListener)object);
                string = new zzcmg(jsPromptResult);
                object.setOnCancelListener((DialogInterface.OnCancelListener)string).create().show();
            } else {
                string = string.setMessage((CharSequence)string3);
                object = new zzcmf(jsResult);
                object = string.setPositiveButton(17039370, (DialogInterface.OnClickListener)object);
                string = new zzcme(jsResult);
                string = object.setNegativeButton(0x1040000, (DialogInterface.OnClickListener)string);
                object = new zzcmd(jsResult);
                string.setOnCancelListener((DialogInterface.OnCancelListener)object).create().show();
            }
        }
        catch (WindowManager.BadTokenException badTokenException) {
            zze.zzj((String)"Fail to display Dialog.", (Throwable)badTokenException);
        }
        return true;
    }
}
