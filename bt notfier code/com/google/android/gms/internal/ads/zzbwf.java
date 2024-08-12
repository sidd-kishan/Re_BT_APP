/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  android.view.View
 *  com.google.ads.mediation.admob.AdMobAdapter
 *  com.google.android.gms.ads.AdFormat
 *  com.google.android.gms.ads.AdSize
 *  com.google.android.gms.ads.mediation.Adapter
 *  com.google.android.gms.ads.mediation.InitializationCompleteCallback
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationAdRequest
 *  com.google.android.gms.ads.mediation.MediationAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationBannerAdapter
 *  com.google.android.gms.ads.mediation.MediationBannerListener
 *  com.google.android.gms.ads.mediation.MediationConfiguration
 *  com.google.android.gms.ads.mediation.MediationInterscrollerAd
 *  com.google.android.gms.ads.mediation.MediationInterstitialAd
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdapter
 *  com.google.android.gms.ads.mediation.MediationInterstitialListener
 *  com.google.android.gms.ads.mediation.MediationNativeAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationNativeAdapter
 *  com.google.android.gms.ads.mediation.MediationNativeListener
 *  com.google.android.gms.ads.mediation.MediationRewardedAd
 *  com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration
 *  com.google.android.gms.ads.mediation.NativeMediationAdRequest
 *  com.google.android.gms.ads.mediation.OnContextChangedListener
 *  com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener
 *  com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
 *  com.google.android.gms.ads.mediation.VersionInfo
 *  com.google.android.gms.ads.mediation.zzb
 *  com.google.android.gms.ads.zza
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbnc
 *  com.google.android.gms.internal.ads.zzbrp
 *  com.google.android.gms.internal.ads.zzbrv
 *  com.google.android.gms.internal.ads.zzbvi
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvp
 *  com.google.android.gms.internal.ads.zzbvr
 *  com.google.android.gms.internal.ads.zzbvs
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzbvy
 *  com.google.android.gms.internal.ads.zzbvz
 *  com.google.android.gms.internal.ads.zzbwa
 *  com.google.android.gms.internal.ads.zzbwb
 *  com.google.android.gms.internal.ads.zzbwc
 *  com.google.android.gms.internal.ads.zzbwe
 *  com.google.android.gms.internal.ads.zzbwg
 *  com.google.android.gms.internal.ads.zzbwh
 *  com.google.android.gms.internal.ads.zzbwi
 *  com.google.android.gms.internal.ads.zzbwj
 *  com.google.android.gms.internal.ads.zzbwy
 *  com.google.android.gms.internal.ads.zzbya
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzcoh
 *  com.google.android.gms.internal.ads.zzcoi
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbnc;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzbvi;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbvr;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbvy;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbwa;
import com.google.android.gms.internal.ads.zzbwb;
import com.google.android.gms.internal.ads.zzbwc;
import com.google.android.gms.internal.ads.zzbwe;
import com.google.android.gms.internal.ads.zzbwg;
import com.google.android.gms.internal.ads.zzbwh;
import com.google.android.gms.internal.ads.zzbwi;
import com.google.android.gms.internal.ads.zzbwj;
import com.google.android.gms.internal.ads.zzbwy;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzcoh;
import com.google.android.gms.internal.ads.zzcoi;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbwf
extends zzbvi {
    private final Object zza;
    private zzbwh zzb;
    private zzcck zzc;
    private IObjectWrapper zzd;
    private View zze;
    private MediationInterstitialAd zzf;
    private UnifiedNativeAdMapper zzg;
    private MediationRewardedAd zzh;
    private MediationInterscrollerAd zzi;
    private final String zzj;

    public zzbwf(Adapter adapter) {
        this.zzj = "";
        this.zza = adapter;
    }

    public zzbwf(MediationAdapter mediationAdapter) {
        this.zzj = "";
        this.zza = mediationAdapter;
    }

    static /* synthetic */ UnifiedNativeAdMapper zzO(zzbwf zzbwf2, UnifiedNativeAdMapper unifiedNativeAdMapper) {
        zzbwf2.zzg = unifiedNativeAdMapper;
        return unifiedNativeAdMapper;
    }

    static /* synthetic */ MediationRewardedAd zzP(zzbwf zzbwf2, MediationRewardedAd mediationRewardedAd) {
        zzbwf2.zzh = mediationRewardedAd;
        return mediationRewardedAd;
    }

    static /* synthetic */ MediationInterscrollerAd zzQ(zzbwf zzbwf2, MediationInterscrollerAd mediationInterscrollerAd) {
        zzbwf2.zzi = mediationInterscrollerAd;
        return mediationInterscrollerAd;
    }

    private final Bundle zzR(String object, zzbdg zzbdg2, String string) throws RemoteException {
        String string2 = String.valueOf(object);
        string2 = string2.length() != 0 ? "Server parameters: ".concat(string2) : new String("Server parameters: ");
        zzcgt.zzd((String)string2);
        try {
            string2 = new Bundle();
            if (object != null) {
                JSONObject jSONObject = new JSONObject((String)object);
                string2 = new Bundle();
                object = jSONObject.keys();
                while (object.hasNext()) {
                    String string3 = (String)object.next();
                    string2.putString(string3, jSONObject.getString(string3));
                }
            }
            if (this.zza instanceof AdMobAdapter) {
                string2.putString("adJson", string);
                if (zzbdg2 != null) {
                    string2.putInt("tagForChildDirectedTreatment", zzbdg2.zzg);
                }
            }
            string2.remove("max_ad_content_rating");
            return string2;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            RemoteException remoteException = new RemoteException();
            throw remoteException;
        }
    }

    private final Bundle zzS(zzbdg zzbdg2) {
        zzbdg2 = zzbdg2.zzm;
        if (zzbdg2 == null) return new Bundle();
        if ((zzbdg2 = zzbdg2.getBundle(this.zza.getClass().getName())) == null) return new Bundle();
        return zzbdg2;
    }

    private static final boolean zzT(zzbdg zzbdg2) {
        if (zzbdg2.zzf) return true;
        zzber.zza();
        if (!zzcgm.zzm()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private static final String zzU(String string, zzbdg object) {
        String string2 = object.zzu;
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject.getString("max_ad_content_rating");
        }
        catch (JSONException jSONException) {
            return string2;
        }
    }

    static /* synthetic */ Object zzb(zzbwf zzbwf2) {
        return zzbwf2.zza;
    }

    static /* synthetic */ View zzc(zzbwf zzbwf2, View view) {
        zzbwf2.zze = view;
        return view;
    }

    static /* synthetic */ MediationInterstitialAd zzd(zzbwf zzbwf2, MediationInterstitialAd mediationInterstitialAd) {
        zzbwf2.zzf = mediationInterstitialAd;
        return mediationInterstitialAd;
    }

    public final void zzA(boolean bl) throws RemoteException {
        Object object = this.zza;
        if (!(object instanceof OnImmersiveModeUpdatedListener)) {
            String string = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            object = this.zza.getClass().getCanonicalName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(object).length());
            stringBuilder.append(string);
            stringBuilder.append(" #009 Class mismatch: ");
            stringBuilder.append((String)object);
            zzcgt.zzd((String)stringBuilder.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener)object).onImmersiveModeUpdated(bl);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            return;
        }
    }

    public final zzbhc zzB() {
        Object object = this.zza;
        if (!(object instanceof zzb)) return null;
        try {
            object = ((zzb)object).getVideoController();
            return object;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
        }
        return null;
    }

    public final zzbvv zzC() {
        Object object = this.zza;
        if (object instanceof MediationNativeAdapter) {
            object = this.zzb;
            if (object == null) return null;
            if ((object = object.zzd()) == null) return null;
            return new zzbwy((UnifiedNativeAdMapper)object);
        }
        if (!(object instanceof Adapter)) return null;
        object = this.zzg;
        if (object == null) return null;
        return new zzbwy((UnifiedNativeAdMapper)object);
    }

    public final void zzD(IObjectWrapper object, zzbdg object2, String string, zzbvm zzbvm2) throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            object2 = Adapter.class.getCanonicalName();
            string = this.zza.getClass().getCanonicalName();
            object = new StringBuilder(String.valueOf(object2).length() + 22 + String.valueOf(string).length());
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" #009 Class mismatch: ");
            ((StringBuilder)object).append(string);
            zzcgt.zzi((String)((StringBuilder)object).toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting rewarded ad from adapter.");
        try {
            Adapter adapter = (Adapter)this.zza;
            zzbwe zzbwe2 = new zzbwe(this, zzbvm2);
            zzbvm2 = new MediationRewardedAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)object), "", this.zzR(string, (zzbdg)object2, null), this.zzS((zzbdg)object2), zzbwf.zzT(object2), object2.zzk, object2.zzg, object2.zzt, zzbwf.zzU(string, object2), "");
            adapter.loadRewardedAd((MediationRewardedAdConfiguration)zzbvm2, (MediationAdLoadCallback)zzbwe2);
            return;
        }
        catch (Exception exception) {
            zzcgt.zzg((String)"", (Throwable)exception);
            throw new RemoteException();
        }
    }

    public final void zzE(IObjectWrapper object) throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            object = Adapter.class.getCanonicalName();
            String string = this.zza.getClass().getCanonicalName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 22 + String.valueOf(string).length());
            stringBuilder.append((String)object);
            stringBuilder.append(" #009 Class mismatch: ");
            stringBuilder.append(string);
            zzcgt.zzi((String)stringBuilder.toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Show rewarded ad from adapter.");
        MediationRewardedAd mediationRewardedAd = this.zzh;
        if (mediationRewardedAd != null) {
            mediationRewardedAd.showAd((Context)ObjectWrapper.unwrap((IObjectWrapper)object));
            return;
        }
        zzcgt.zzf((String)"Can not show null mediation rewarded ad.");
        throw new RemoteException();
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzbrp object, List<zzbrv> zzbrv2) throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            iObjectWrapper = new RemoteException();
            throw iObjectWrapper;
        }
        zzbwa zzbwa2 = new zzbwa(this, (zzbrp)object);
        ArrayList<MediationConfiguration> arrayList = new ArrayList<MediationConfiguration>();
        Iterator<zzbrv> iterator = zzbrv2.iterator();
        while (true) {
            int n;
            block10: {
                if (!iterator.hasNext()) {
                    ((Adapter)this.zza).initialize((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), (InitializationCompleteCallback)zzbwa2, arrayList);
                    return;
                }
                zzbrv2 = iterator.next();
                object = zzbrv2.zza;
                switch (((String)object).hashCode()) {
                    default: {
                        break;
                    }
                    case 1911491517: {
                        if (!((String)object).equals("rewarded_interstitial")) break;
                        n = 3;
                        break block10;
                    }
                    case 604727084: {
                        if (!((String)object).equals("interstitial")) break;
                        n = 1;
                        break block10;
                    }
                    case -239580146: {
                        if (!((String)object).equals("rewarded")) break;
                        n = 2;
                        break block10;
                    }
                    case -1052618729: {
                        if (!((String)object).equals("native")) break;
                        n = 4;
                        break block10;
                    }
                    case -1396342996: {
                        if (!((String)object).equals("banner")) break;
                        n = 0;
                        break block10;
                    }
                }
                n = -1;
            }
            object = n != 0 ? (n != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? null : AdFormat.NATIVE) : AdFormat.REWARDED_INTERSTITIAL) : AdFormat.REWARDED) : AdFormat.INTERSTITIAL) : AdFormat.BANNER;
            if (object == null) continue;
            arrayList.add(new MediationConfiguration((AdFormat)object, zzbrv2.zzb));
        }
    }

    public final void zzG(IObjectWrapper object, zzbdg object2, String string, zzbvm zzbvm2) throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            object2 = Adapter.class.getCanonicalName();
            string = this.zza.getClass().getCanonicalName();
            object = new StringBuilder(String.valueOf(object2).length() + 22 + String.valueOf(string).length());
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" #009 Class mismatch: ");
            ((StringBuilder)object).append(string);
            zzcgt.zzi((String)((StringBuilder)object).toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting rewarded interstitial ad from adapter.");
        try {
            Adapter adapter = (Adapter)this.zza;
            zzbwe zzbwe2 = new zzbwe(this, zzbvm2);
            zzbvm2 = new MediationRewardedAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)object), "", this.zzR(string, (zzbdg)object2, null), this.zzS((zzbdg)object2), zzbwf.zzT(object2), object2.zzk, object2.zzg, object2.zzt, zzbwf.zzU(string, object2), "");
            adapter.loadRewardedInterstitialAd((MediationRewardedAdConfiguration)zzbvm2, (MediationAdLoadCallback)zzbwe2);
            return;
        }
        catch (Exception exception) {
            zzcgt.zzg((String)"", (Throwable)exception);
            throw new RemoteException();
        }
    }

    public final zzbya zzH() {
        Object object = this.zza;
        if (object instanceof Adapter) return zzbya.zza((VersionInfo)((Adapter)object).getVersionInfo());
        return null;
    }

    public final zzbya zzI() {
        Object object = this.zza;
        if (object instanceof Adapter) return zzbya.zza((VersionInfo)((Adapter)object).getSDKVersionInfo());
        return null;
    }

    public final void zzJ(IObjectWrapper object, zzbdl object2, zzbdg object3, String string, String string2, zzbvm zzbvm2) throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            object3 = Adapter.class.getCanonicalName();
            object2 = this.zza.getClass().getCanonicalName();
            object = new StringBuilder(String.valueOf(object3).length() + 22 + String.valueOf(object2).length());
            ((StringBuilder)object).append((String)object3);
            ((StringBuilder)object).append(" #009 Class mismatch: ");
            ((StringBuilder)object).append((String)object2);
            zzcgt.zzi((String)((StringBuilder)object).toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting interscroller ad from adapter.");
        try {
            Adapter adapter = (Adapter)this.zza;
            zzbvz zzbvz2 = new zzbvz(this, zzbvm2, adapter);
            zzbvm2 = new MediationBannerAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)object), "", this.zzR(string, (zzbdg)object3, string2), this.zzS((zzbdg)object3), zzbwf.zzT(object3), object3.zzk, object3.zzg, object3.zzt, zzbwf.zzU(string, object3), com.google.android.gms.ads.zza.zzc((int)object2.zze, (int)object2.zzb), "");
            adapter.loadInterscrollerAd((MediationBannerAdConfiguration)zzbvm2, (MediationAdLoadCallback)zzbvz2);
            return;
        }
        catch (Exception exception) {
            zzcgt.zzg((String)"", (Throwable)exception);
            throw new RemoteException();
        }
    }

    public final zzbvp zzK() {
        MediationInterscrollerAd mediationInterscrollerAd = this.zzi;
        if (mediationInterscrollerAd == null) return null;
        return new zzbwg(mediationInterscrollerAd);
    }

    public final void zzL(IObjectWrapper object) throws RemoteException {
        Object object2 = this.zza;
        if (!(object2 instanceof Adapter) && !(object2 instanceof MediationInterstitialAdapter)) {
            object2 = MediationInterstitialAdapter.class.getCanonicalName();
            String string = Adapter.class.getCanonicalName();
            String string2 = this.zza.getClass().getCanonicalName();
            object = new StringBuilder(String.valueOf(object2).length() + 26 + String.valueOf(string).length() + String.valueOf(string2).length());
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(" or ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" #009 Class mismatch: ");
            ((StringBuilder)object).append(string2);
            zzcgt.zzi((String)((StringBuilder)object).toString());
            throw new RemoteException();
        }
        if (object2 instanceof MediationInterstitialAdapter) {
            this.zzh();
            return;
        }
        zzcgt.zzd((String)"Show interstitial ad from adapter.");
        object2 = this.zzf;
        if (object2 != null) {
            object2.showAd((Context)ObjectWrapper.unwrap((IObjectWrapper)object));
            return;
        }
        zzcgt.zzf((String)"Can not show null mediation interstitial ad.");
        throw new RemoteException();
    }

    public final zzbvr zzM() {
        return null;
    }

    public final zzbvs zzN() {
        return null;
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        this.zzj(iObjectWrapper, zzbdl2, zzbdg2, string, null, zzbvm2);
    }

    public final IObjectWrapper zzf() throws RemoteException {
        Object object = this.zza;
        if (object instanceof MediationBannerAdapter) {
            try {
                object = ObjectWrapper.wrap((Object)((MediationBannerAdapter)object).getBannerView());
                return object;
            }
            catch (Throwable throwable) {
                zzcgt.zzg((String)"", (Throwable)throwable);
                throw new RemoteException();
            }
        }
        if (object instanceof Adapter) {
            return ObjectWrapper.wrap((Object)this.zze);
        }
        object = MediationBannerAdapter.class.getCanonicalName();
        String string = Adapter.class.getCanonicalName();
        String string2 = this.zza.getClass().getCanonicalName();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(object).length() + 26 + String.valueOf(string).length() + String.valueOf(string2).length());
        stringBuilder.append((String)object);
        stringBuilder.append(" or ");
        stringBuilder.append(string);
        stringBuilder.append(" #009 Class mismatch: ");
        stringBuilder.append(string2);
        zzcgt.zzi((String)stringBuilder.toString());
        throw new RemoteException();
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        this.zzk(iObjectWrapper, zzbdg2, string, null, zzbvm2);
    }

    public final void zzh() throws RemoteException {
        if (!(this.zza instanceof MediationInterstitialAdapter)) {
            String string = MediationInterstitialAdapter.class.getCanonicalName();
            String string2 = this.zza.getClass().getCanonicalName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(string2).length());
            stringBuilder.append(string);
            stringBuilder.append(" #009 Class mismatch: ");
            stringBuilder.append(string2);
            zzcgt.zzi((String)stringBuilder.toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Showing interstitial from adapter.");
        try {
            ((MediationInterstitialAdapter)this.zza).showInterstitial();
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzi() throws RemoteException {
        Object object = this.zza;
        if (!(object instanceof MediationAdapter)) {
            return;
        }
        try {
            ((MediationAdapter)object).onDestroy();
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzj(IObjectWrapper object, zzbdl object2, zzbdg object3, String charSequence, String string, zzbvm zzbvm2) throws RemoteException {
        Object object4 = this.zza;
        if (!(object4 instanceof MediationBannerAdapter) && !(object4 instanceof Adapter)) {
            object = MediationBannerAdapter.class.getCanonicalName();
            object3 = Adapter.class.getCanonicalName();
            object2 = this.zza.getClass().getCanonicalName();
            charSequence = new StringBuilder(String.valueOf(object).length() + 26 + String.valueOf(object3).length() + String.valueOf(object2).length());
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(" or ");
            ((StringBuilder)charSequence).append((String)object3);
            ((StringBuilder)charSequence).append(" #009 Class mismatch: ");
            ((StringBuilder)charSequence).append((String)object2);
            zzcgt.zzi((String)((StringBuilder)charSequence).toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting banner ad from adapter.");
        object2 = object2.zzn ? com.google.android.gms.ads.zza.zzb((int)object2.zze, (int)object2.zzb) : com.google.android.gms.ads.zza.zza((int)object2.zze, (int)object2.zzb, (String)object2.zza);
        object4 = this.zza;
        if (object4 instanceof MediationBannerAdapter) {
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter)object4;
                Object object5 = object3.zze;
                object4 = object5 != null ? new HashSet(object5) : null;
                long l = object3.zzb;
                object5 = l == -1L ? null : new Date(l);
                zzbvy zzbvy2 = new zzbvy((Date)object5, object3.zzd, object4, object3.zzk, zzbwf.zzT(object3), object3.zzg, object3.zzr, object3.zzt, zzbwf.zzU((String)charSequence, object3));
                object4 = object3.zzm;
                object4 = object4 != null ? object4.getBundle(mediationBannerAdapter.getClass().getName()) : null;
                object5 = (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
                object = new zzbwh(zzbvm2);
                mediationBannerAdapter.requestBannerAd((Context)object5, (MediationBannerListener)object, this.zzR((String)charSequence, (zzbdg)object3, string), (AdSize)object2, (MediationAdRequest)zzbvy2, object4);
                return;
            }
            catch (Throwable throwable) {
                zzcgt.zzg((String)"", (Throwable)throwable);
                throw new RemoteException();
            }
        }
        if (!(object4 instanceof Adapter)) return;
        try {
            Adapter adapter = (Adapter)object4;
            object4 = new zzbwb(this, zzbvm2);
            zzbvm2 = new MediationBannerAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)object), "", this.zzR((String)charSequence, (zzbdg)object3, string), this.zzS((zzbdg)object3), zzbwf.zzT(object3), object3.zzk, object3.zzg, object3.zzt, zzbwf.zzU((String)charSequence, object3), (AdSize)object2, this.zzj);
            adapter.loadBannerAd((MediationBannerAdConfiguration)zzbvm2, (MediationAdLoadCallback)object4);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzk(IObjectWrapper object, zzbdg object2, String string, String string2, zzbvm zzbvm2) throws RemoteException {
        Object object3 = this.zza;
        if (!(object3 instanceof MediationInterstitialAdapter) && !(object3 instanceof Adapter)) {
            string2 = MediationInterstitialAdapter.class.getCanonicalName();
            string = Adapter.class.getCanonicalName();
            object = this.zza.getClass().getCanonicalName();
            object2 = new StringBuilder(String.valueOf(string2).length() + 26 + String.valueOf(string).length() + String.valueOf(object).length());
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" or ");
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append(" #009 Class mismatch: ");
            ((StringBuilder)object2).append((String)object);
            zzcgt.zzi((String)((StringBuilder)object2).toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting interstitial ad from adapter.");
        object3 = this.zza;
        if (object3 instanceof MediationInterstitialAdapter) {
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter)object3;
                Object object4 = ((zzbdg)object2).zze;
                object3 = object4 != null ? new HashSet(object4) : null;
                long l = ((zzbdg)object2).zzb;
                object4 = l == -1L ? null : new Date(l);
                zzbvy zzbvy2 = new zzbvy((Date)object4, ((zzbdg)object2).zzd, object3, ((zzbdg)object2).zzk, zzbwf.zzT((zzbdg)object2), ((zzbdg)object2).zzg, ((zzbdg)object2).zzr, ((zzbdg)object2).zzt, zzbwf.zzU(string, (zzbdg)object2));
                object3 = ((zzbdg)object2).zzm;
                object3 = object3 != null ? object3.getBundle(mediationInterstitialAdapter.getClass().getName()) : null;
                object4 = (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
                object = new zzbwh(zzbvm2);
                mediationInterstitialAdapter.requestInterstitialAd((Context)object4, (MediationInterstitialListener)object, this.zzR(string, (zzbdg)object2, string2), (MediationAdRequest)zzbvy2, object3);
                return;
            }
            catch (Throwable throwable) {
                zzcgt.zzg((String)"", (Throwable)throwable);
                throw new RemoteException();
            }
        }
        if (!(object3 instanceof Adapter)) return;
        try {
            object3 = (Adapter)object3;
            zzbwc zzbwc2 = new zzbwc(this, zzbvm2);
            zzbvm2 = new MediationInterstitialAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)object), "", this.zzR(string, (zzbdg)object2, string2), this.zzS((zzbdg)object2), zzbwf.zzT((zzbdg)object2), ((zzbdg)object2).zzk, ((zzbdg)object2).zzg, ((zzbdg)object2).zzt, zzbwf.zzU(string, (zzbdg)object2), this.zzj);
            object3.loadInterstitialAd((MediationInterstitialAdConfiguration)zzbvm2, (MediationAdLoadCallback)zzbwc2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzl() throws RemoteException {
        Object object = this.zza;
        if (!(object instanceof MediationAdapter)) {
            return;
        }
        try {
            ((MediationAdapter)object).onPause();
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzm() throws RemoteException {
        Object object = this.zza;
        if (!(object instanceof MediationAdapter)) {
            return;
        }
        try {
            ((MediationAdapter)object).onResume();
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzn(IObjectWrapper object, zzbdg object2, String charSequence, zzcck zzcck2, String string) throws RemoteException {
        object2 = this.zza;
        if (object2 instanceof Adapter) {
            this.zzd = object;
            this.zzc = zzcck2;
            zzcck2.zze(ObjectWrapper.wrap((Object)object2));
            return;
        }
        object = Adapter.class.getCanonicalName();
        object2 = this.zza.getClass().getCanonicalName();
        charSequence = new StringBuilder(String.valueOf(object).length() + 22 + String.valueOf(object2).length());
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" #009 Class mismatch: ");
        ((StringBuilder)charSequence).append((String)object2);
        zzcgt.zzi((String)((StringBuilder)charSequence).toString());
        throw new RemoteException();
    }

    public final void zzo(zzbdg zzbdg2, String string) throws RemoteException {
        this.zzv(zzbdg2, string, null);
    }

    public final void zzp() throws RemoteException {
        if (!(this.zza instanceof Adapter)) {
            String string = Adapter.class.getCanonicalName();
            String string2 = this.zza.getClass().getCanonicalName();
            StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(string2).length());
            stringBuilder.append(string);
            stringBuilder.append(" #009 Class mismatch: ");
            stringBuilder.append(string2);
            zzcgt.zzi((String)stringBuilder.toString());
            throw new RemoteException();
        }
        MediationRewardedAd mediationRewardedAd = this.zzh;
        if (mediationRewardedAd != null) {
            mediationRewardedAd.showAd((Context)ObjectWrapper.unwrap((IObjectWrapper)this.zzd));
            return;
        }
        zzcgt.zzf((String)"Can not show null mediated rewarded ad.");
        throw new RemoteException();
    }

    public final boolean zzq() throws RemoteException {
        if (this.zza instanceof Adapter) {
            if (this.zzc == null) return false;
            return true;
        }
        String string = Adapter.class.getCanonicalName();
        String string2 = this.zza.getClass().getCanonicalName();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(string2).length());
        stringBuilder.append(string);
        stringBuilder.append(" #009 Class mismatch: ");
        stringBuilder.append(string2);
        zzcgt.zzi((String)stringBuilder.toString());
        throw new RemoteException();
    }

    public final void zzr(IObjectWrapper object, zzbdg object2, String string, String charSequence, zzbvm zzbvm2, zzblv object3, List<String> adapter) throws RemoteException {
        HashSet hashSet = this.zza;
        if (!(hashSet instanceof MediationNativeAdapter) && !(hashSet instanceof Adapter)) {
            string = MediationNativeAdapter.class.getCanonicalName();
            object = Adapter.class.getCanonicalName();
            object2 = this.zza.getClass().getCanonicalName();
            charSequence = new StringBuilder(String.valueOf(string).length() + 26 + String.valueOf(object).length() + String.valueOf(object2).length());
            ((StringBuilder)charSequence).append(string);
            ((StringBuilder)charSequence).append(" or ");
            ((StringBuilder)charSequence).append((String)object);
            ((StringBuilder)charSequence).append(" #009 Class mismatch: ");
            ((StringBuilder)charSequence).append((String)object2);
            zzcgt.zzi((String)((StringBuilder)charSequence).toString());
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting native ad from adapter.");
        hashSet = this.zza;
        if (hashSet instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter)hashSet;
                Object object4 = object2.zze;
                hashSet = object4 != null ? new HashSet(object4) : null;
                long l = object2.zzb;
                object4 = l == -1L ? null : new Date(l);
                zzbwj zzbwj2 = new zzbwj((Date)object4, object2.zzd, hashSet, object2.zzk, zzbwf.zzT(object2), object2.zzg, object3, (List)adapter, object2.zzr, object2.zzt, zzbwf.zzU(string, object2));
                object3 = object2.zzm;
                object3 = object3 != null ? object3.getBundle(mediationNativeAdapter.getClass().getName()) : null;
                adapter = new zzbwh(zzbvm2);
                this.zzb = adapter;
                mediationNativeAdapter.requestNativeAd((Context)ObjectWrapper.unwrap((IObjectWrapper)object), (MediationNativeListener)this.zzb, this.zzR(string, (zzbdg)object2, (String)charSequence), (NativeMediationAdRequest)zzbwj2, (Bundle)object3);
                return;
            }
            catch (Throwable throwable) {
                zzcgt.zzg((String)"", (Throwable)throwable);
                throw new RemoteException();
            }
        }
        if (!(hashSet instanceof Adapter)) return;
        try {
            adapter = (Adapter)hashSet;
            hashSet = new HashSet(this, zzbvm2);
            zzbvm2 = new MediationNativeAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)object), "", this.zzR(string, (zzbdg)object2, (String)charSequence), this.zzS((zzbdg)object2), zzbwf.zzT(object2), object2.zzk, object2.zzg, object2.zzt, zzbwf.zzU(string, object2), this.zzj, object3);
            adapter.loadNativeAd((MediationNativeAdConfiguration)zzbvm2, hashSet);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final Bundle zzs() {
        Object object = this.zza;
        if (object instanceof zzcoh) return ((zzcoh)object).zza();
        String string = zzcoh.class.getCanonicalName();
        object = this.zza.getClass().getCanonicalName();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(object).length());
        stringBuilder.append(string);
        stringBuilder.append(" #009 Class mismatch: ");
        stringBuilder.append((String)object);
        zzcgt.zzi((String)stringBuilder.toString());
        return new Bundle();
    }

    public final Bundle zzt() {
        Object object = this.zza;
        if (object instanceof zzcoi) return ((zzcoi)object).getInterstitialAdapterInfo();
        String string = zzcoi.class.getCanonicalName();
        object = this.zza.getClass().getCanonicalName();
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(string).length() + 22 + String.valueOf(object).length());
        stringBuilder.append(string);
        stringBuilder.append(" #009 Class mismatch: ");
        stringBuilder.append((String)object);
        zzcgt.zzi((String)stringBuilder.toString());
        return new Bundle();
    }

    public final Bundle zzu() {
        return new Bundle();
    }

    public final void zzv(zzbdg object, String string, String object2) throws RemoteException {
        object2 = this.zza;
        if (object2 instanceof Adapter) {
            this.zzD(this.zzd, (zzbdg)object, string, (zzbvm)new zzbwi((Adapter)object2, this.zzc));
            return;
        }
        object = Adapter.class.getCanonicalName();
        string = this.zza.getClass().getCanonicalName();
        object2 = new StringBuilder(String.valueOf(object).length() + 22 + String.valueOf(string).length());
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" #009 Class mismatch: ");
        ((StringBuilder)object2).append(string);
        zzcgt.zzi((String)((StringBuilder)object2).toString());
        throw new RemoteException();
    }

    public final void zzw(IObjectWrapper object) throws RemoteException {
        Context context = (Context)ObjectWrapper.unwrap((IObjectWrapper)object);
        object = this.zza;
        if (!(object instanceof OnContextChangedListener)) return;
        ((OnContextChangedListener)object).onContextChanged(context);
    }

    public final boolean zzx() {
        return false;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzcck zzcck2, List<String> list) throws RemoteException {
        zzcgt.zzi((String)"Could not initialize rewarded video adapter.");
        throw new RemoteException();
    }

    public final zzbnb zzz() {
        zzbwh zzbwh2 = this.zzb;
        if (zzbwh2 == null) return null;
        if (!((zzbwh2 = zzbwh2.zze()) instanceof zzbnc)) return null;
        return ((zzbnc)zzbwh2).zza();
    }
}
