/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.Uri
 *  android.net.Uri$Builder
 *  android.os.AsyncTask
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  com.google.android.gms.ads.internal.util.zze
 *  com.google.android.gms.ads.internal.zzm
 *  com.google.android.gms.ads.internal.zzn
 *  com.google.android.gms.ads.internal.zzo
 *  com.google.android.gms.ads.internal.zzp
 *  com.google.android.gms.ads.internal.zzr
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzaas
 *  com.google.android.gms.internal.ads.zzaat
 *  com.google.android.gms.internal.ads.zzaxz
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzbdr
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbex
 *  com.google.android.gms.internal.ads.zzbfa
 *  com.google.android.gms.internal.ads.zzbfd
 *  com.google.android.gms.internal.ads.zzbfm
 *  com.google.android.gms.internal.ads.zzbfr
 *  com.google.android.gms.internal.ads.zzbfu
 *  com.google.android.gms.internal.ads.zzbfy
 *  com.google.android.gms.internal.ads.zzbgb
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhg
 *  com.google.android.gms.internal.ads.zzbis
 *  com.google.android.gms.internal.ads.zzbkg
 *  com.google.android.gms.internal.ads.zzbkp
 *  com.google.android.gms.internal.ads.zzbzz
 *  com.google.android.gms.internal.ads.zzcac
 *  com.google.android.gms.internal.ads.zzccf
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgz
 *  com.google.android.gms.internal.ads.zzchg
 */
package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzm;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.ads.internal.zzo;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.internal.zzr;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaas;
import com.google.android.gms.internal.ads.zzaat;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzbdr;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbex;
import com.google.android.gms.internal.ads.zzbfa;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfm;
import com.google.android.gms.internal.ads.zzbfr;
import com.google.android.gms.internal.ads.zzbfu;
import com.google.android.gms.internal.ads.zzbfy;
import com.google.android.gms.internal.ads.zzbgb;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhg;
import com.google.android.gms.internal.ads.zzbis;
import com.google.android.gms.internal.ads.zzbkg;
import com.google.android.gms.internal.ads.zzbkp;
import com.google.android.gms.internal.ads.zzbzz;
import com.google.android.gms.internal.ads.zzcac;
import com.google.android.gms.internal.ads.zzccf;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgz;
import com.google.android.gms.internal.ads.zzchg;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzs
extends zzbfm {
    private final zzcgz zza;
    private final zzbdl zzb;
    private final Future<zzaas> zzc;
    private final Context zzd;
    private final zzr zze;
    private WebView zzf;
    private zzbfa zzg;
    private zzaas zzh;
    private AsyncTask<Void, Void, String> zzi;

    public zzs(Context context, zzbdl zzbdl2, String string, zzcgz zzcgz2) {
        this.zzd = context;
        this.zza = zzcgz2;
        this.zzb = zzbdl2;
        this.zzf = new WebView(this.zzd);
        this.zzc = zzchg.zza.zzb((Callable)new zzo(this));
        this.zze = new zzr(context, string);
        this.zzS(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient((WebViewClient)new zzm(this));
        this.zzf.setOnTouchListener((View.OnTouchListener)new zzn(this));
    }

    static /* synthetic */ String zzV(zzs object, String string) {
        if (object.zzh == null) return string;
        string = Uri.parse((String)string);
        try {
            object = object.zzh.zze((Uri)string, object.zzd, null, null);
        }
        catch (zzaat zzaat2) {
            com.google.android.gms.ads.internal.util.zze.zzj((String)"Unable to process ad data", (Throwable)zzaat2);
            object = string;
        }
        string = object.toString();
        return string;
    }

    static /* synthetic */ void zzW(zzs zzs2, String string) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse((String)string));
        zzs2.zzd.startActivity(intent);
    }

    static /* synthetic */ zzcgz zzb(zzs zzs2) {
        return zzs2.zza;
    }

    static /* synthetic */ Future zzc(zzs zzs2) {
        return zzs2.zzc;
    }

    static /* synthetic */ Context zzd(zzs zzs2) {
        return zzs2.zzd;
    }

    static /* synthetic */ WebView zze(zzs zzs2) {
        return zzs2.zzf;
    }

    static /* synthetic */ zzbfa zzf(zzs zzs2) {
        return zzs2.zzg;
    }

    static /* synthetic */ zzaas zzg(zzs zzs2) {
        return zzs2.zzh;
    }

    static /* synthetic */ zzaas zzh(zzs zzs2, zzaas zzaas2) {
        zzs2.zzh = zzaas2;
        return zzaas2;
    }

    public final zzbgz zzA() {
        return null;
    }

    public final String zzB() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final zzbfu zzC() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzbfa zzD() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final void zzE(zzbkg zzbkg2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzF(zzbex zzbex2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzG(boolean bl) throws RemoteException {
    }

    public final boolean zzH() throws RemoteException {
        return false;
    }

    public final void zzI(zzccf zzccf2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(String string) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzK(String string) {
        throw new IllegalStateException("Unused method");
    }

    public final zzbhc zzL() {
        return null;
    }

    public final void zzM(zzbis zzbis2) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzN(zzbhg zzbhg2) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzO(zzbdr zzbdr2) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzP(zzaxz zzaxz2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzQ(boolean bl) {
        throw new IllegalStateException("Unused method");
    }

    final int zzR(String string) {
        if (TextUtils.isEmpty((CharSequence)(string = Uri.parse((String)string).getQueryParameter("height")))) {
            return 0;
        }
        try {
            zzber.zza();
            int n = zzcgm.zzs((Context)this.zzd, (int)Integer.parseInt(string));
            return n;
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    final void zzS(int n) {
        if (this.zzf == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, n);
        this.zzf.setLayoutParams(layoutParams);
    }

    final String zzT() {
        CharSequence charSequence2;
        Object object = new Uri.Builder();
        object.scheme("https://").appendEncodedPath((String)zzbkp.zzd.zze());
        object.appendQueryParameter("query", this.zze.zzb());
        object.appendQueryParameter("pubId", this.zze.zzc());
        object.appendQueryParameter("mappver", this.zze.zzd());
        Map map = this.zze.zze();
        for (CharSequence charSequence2 : map.keySet()) {
            object.appendQueryParameter((String)charSequence2, (String)map.get(charSequence2));
        }
        object = object.build();
        charSequence2 = this.zzh;
        Object object2 = object;
        if (charSequence2 != null) {
            try {
                object2 = charSequence2.zzc((Uri)object, this.zzd);
            }
            catch (zzaat zzaat2) {
                com.google.android.gms.ads.internal.util.zze.zzj((String)"Unable to process ad data", (Throwable)zzaat2);
                object2 = object;
            }
        }
        object = this.zzU();
        object2 = object2.getEncodedQuery();
        int n = String.valueOf(object2).length();
        charSequence2 = new StringBuilder(((String)object).length() + 1 + n);
        ((StringBuilder)charSequence2).append((String)object);
        ((StringBuilder)charSequence2).append("#");
        ((StringBuilder)charSequence2).append((String)object2);
        return ((StringBuilder)charSequence2).toString();
    }

    final String zzU() {
        String string;
        String string2 = string = this.zze.zza();
        if (TextUtils.isEmpty((CharSequence)string)) {
            string2 = "www.google.com";
        }
        string = (String)zzbkp.zzd.zze();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string2).length() + 8 + String.valueOf(string).length());
        stringBuilder.append("https://");
        stringBuilder.append(string2);
        stringBuilder.append(string);
        return stringBuilder.toString();
    }

    public final void zzX(zzbgw zzbgw2) {
    }

    public final void zzY(zzbdg zzbdg2, zzbfd zzbfd2) {
    }

    public final void zzZ(IObjectWrapper iObjectWrapper) {
    }

    public final void zzaa(zzbgb zzbgb2) {
    }

    public final void zzab(zzbfy zzbfy2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final IObjectWrapper zzi() throws RemoteException {
        Preconditions.checkMainThread((String)"getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap((Object)this.zzf);
    }

    public final void zzj() throws RemoteException {
        Preconditions.checkMainThread((String)"destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(true);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final boolean zzk() throws RemoteException {
        return false;
    }

    public final boolean zzl(zzbdg zzbdg2) throws RemoteException {
        Preconditions.checkNotNull((Object)this.zzf, (Object)"This Search Ad has already been torn down");
        this.zze.zzf(zzbdg2, this.zza);
        this.zzi = new zzp(this, null).execute((Object[])new Void[0]);
        return true;
    }

    public final void zzm() throws RemoteException {
        Preconditions.checkMainThread((String)"pause must be called on the main UI thread.");
    }

    public final void zzn() throws RemoteException {
        Preconditions.checkMainThread((String)"resume must be called on the main UI thread.");
    }

    public final void zzo(zzbfa zzbfa2) throws RemoteException {
        this.zzg = zzbfa2;
    }

    public final void zzp(zzbfu zzbfu2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzq(zzbfr zzbfr2) {
        throw new IllegalStateException("Unused method");
    }

    public final Bundle zzr() {
        throw new IllegalStateException("Unused method");
    }

    public final void zzs() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzt() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final zzbdl zzu() throws RemoteException {
        return this.zzb;
    }

    public final void zzv(zzbdl zzbdl2) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzw(zzbzz zzbzz2) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzx(zzcac zzcac2, String string) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final String zzy() throws RemoteException {
        return null;
    }

    public final String zzz() throws RemoteException {
        return null;
    }
}
