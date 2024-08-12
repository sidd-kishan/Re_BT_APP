/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  android.webkit.WebResourceError
 *  android.webkit.WebResourceRequest
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzs
 *  com.google.android.gms.internal.ads.zzfbm
 */
package com.google.android.gms.ads.internal;

import android.os.RemoteException;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.internal.ads.zzfbm;

final class zzm
extends WebViewClient {
    final zzs zza;

    zzm(zzs zzs2) {
        this.zza = zzs2;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (zzs.zzf((zzs)this.zza) != null) {
            try {
                zzs.zzf((zzs)this.zza).zzd(zzfbm.zzd((int)1, null, null));
            }
            catch (RemoteException remoteException) {
                zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        if (zzs.zzf((zzs)this.zza) == null) return;
        try {
            zzs.zzf((zzs)this.zza).zzc(0);
            return;
        }
        catch (RemoteException remoteException) {
            zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView object, String string) {
        if (string.startsWith(this.zza.zzU())) {
            return false;
        }
        if (string.startsWith("gmsg://noAdLoaded")) {
            if (zzs.zzf((zzs)this.zza) != null) {
                try {
                    zzs.zzf((zzs)this.zza).zzd(zzfbm.zzd((int)3, null, null));
                }
                catch (RemoteException remoteException) {
                    zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            if (zzs.zzf((zzs)this.zza) != null) {
                try {
                    zzs.zzf((zzs)this.zza).zzc(3);
                }
                catch (RemoteException remoteException) {
                    zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            this.zza.zzS(0);
            return true;
        }
        if (string.startsWith("gmsg://scriptLoadFailed")) {
            if (zzs.zzf((zzs)this.zza) != null) {
                try {
                    zzs.zzf((zzs)this.zza).zzd(zzfbm.zzd((int)1, null, null));
                }
                catch (RemoteException remoteException) {
                    zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            if (zzs.zzf((zzs)this.zza) != null) {
                try {
                    zzs.zzf((zzs)this.zza).zzc(0);
                }
                catch (RemoteException remoteException) {
                    zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            this.zza.zzS(0);
            return true;
        }
        if (string.startsWith("gmsg://adResized")) {
            if (zzs.zzf((zzs)this.zza) != null) {
                try {
                    zzs.zzf((zzs)this.zza).zzf();
                }
                catch (RemoteException remoteException) {
                    zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
                }
            }
            int n = this.zza.zzR(string);
            this.zza.zzS(n);
            return true;
        }
        if (string.startsWith("gmsg://")) {
            return true;
        }
        if (zzs.zzf((zzs)this.zza) != null) {
            try {
                zzs.zzf((zzs)this.zza).zzh();
                zzs.zzf((zzs)this.zza).zze();
            }
            catch (RemoteException remoteException) {
                zze.zzl((String)"#007 Could not call remote method.", (Throwable)remoteException);
            }
        }
        object = zzs.zzV((zzs)this.zza, (String)string);
        zzs.zzW((zzs)this.zza, (String)object);
        return true;
    }
}
