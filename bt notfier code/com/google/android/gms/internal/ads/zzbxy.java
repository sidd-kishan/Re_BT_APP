/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.android.gms.ads.AdFormat
 *  com.google.android.gms.ads.mediation.MediationAdLoadCallback
 *  com.google.android.gms.ads.mediation.MediationBannerAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationConfiguration
 *  com.google.android.gms.ads.mediation.MediationInterstitialAd
 *  com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationNativeAdConfiguration
 *  com.google.android.gms.ads.mediation.MediationRewardedAd
 *  com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration
 *  com.google.android.gms.ads.mediation.VersionInfo
 *  com.google.android.gms.ads.mediation.rtb.RtbAdapter
 *  com.google.android.gms.ads.mediation.rtb.RtbSignalData
 *  com.google.android.gms.ads.mediation.rtb.SignalCallbacks
 *  com.google.android.gms.ads.mediation.zzb
 *  com.google.android.gms.ads.zza
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbxb
 *  com.google.android.gms.internal.ads.zzbxe
 *  com.google.android.gms.internal.ads.zzbxh
 *  com.google.android.gms.internal.ads.zzbxk
 *  com.google.android.gms.internal.ads.zzbxm
 *  com.google.android.gms.internal.ads.zzbxq
 *  com.google.android.gms.internal.ads.zzbxs
 *  com.google.android.gms.internal.ads.zzbxt
 *  com.google.android.gms.internal.ads.zzbxu
 *  com.google.android.gms.internal.ads.zzbxv
 *  com.google.android.gms.internal.ads.zzbxw
 *  com.google.android.gms.internal.ads.zzbxx
 *  com.google.android.gms.internal.ads.zzbya
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.google.android.gms.ads.mediation.zzb;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbxb;
import com.google.android.gms.internal.ads.zzbxe;
import com.google.android.gms.internal.ads.zzbxh;
import com.google.android.gms.internal.ads.zzbxk;
import com.google.android.gms.internal.ads.zzbxm;
import com.google.android.gms.internal.ads.zzbxq;
import com.google.android.gms.internal.ads.zzbxs;
import com.google.android.gms.internal.ads.zzbxt;
import com.google.android.gms.internal.ads.zzbxu;
import com.google.android.gms.internal.ads.zzbxv;
import com.google.android.gms.internal.ads.zzbxw;
import com.google.android.gms.internal.ads.zzbxx;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbxy
extends zzbxm {
    private final RtbAdapter zza;
    private MediationInterstitialAd zzb;
    private MediationRewardedAd zzc;
    private String zzd = "";

    public zzbxy(RtbAdapter rtbAdapter) {
        this.zza = rtbAdapter;
    }

    static /* synthetic */ MediationInterstitialAd zzc(zzbxy zzbxy2, MediationInterstitialAd mediationInterstitialAd) {
        zzbxy2.zzb = mediationInterstitialAd;
        return mediationInterstitialAd;
    }

    static /* synthetic */ MediationRewardedAd zzd(zzbxy zzbxy2, MediationRewardedAd mediationRewardedAd) {
        zzbxy2.zzc = mediationRewardedAd;
        return mediationRewardedAd;
    }

    private final Bundle zzs(zzbdg zzbdg2) {
        zzbdg2 = zzbdg2.zzm;
        if (zzbdg2 == null) return new Bundle();
        if ((zzbdg2 = zzbdg2.getBundle(this.zza.getClass().getName())) == null) return new Bundle();
        return zzbdg2;
    }

    private static final Bundle zzt(String object) throws RemoteException {
        String string = String.valueOf(object);
        string = string.length() != 0 ? "Server parameters: ".concat(string) : new String("Server parameters: ");
        zzcgt.zzi((String)string);
        try {
            string = new Bundle();
            if (object == null) return string;
            JSONObject jSONObject = new JSONObject((String)object);
            string = new Bundle();
            object = jSONObject.keys();
            while (object.hasNext()) {
                String string2 = (String)object.next();
                string.putString(string2, jSONObject.getString(string2));
            }
            return string;
        }
        catch (JSONException jSONException) {
            zzcgt.zzg((String)"", (Throwable)jSONException);
            RemoteException remoteException = new RemoteException();
            throw remoteException;
        }
    }

    private static final boolean zzu(zzbdg zzbdg2) {
        if (zzbdg2.zzf) return true;
        zzber.zza();
        if (!zzcgm.zzm()) return false;
        return true;
    }

    /*
     * Enabled force condition propagation
     */
    private static final String zzv(String string, zzbdg object) {
        String string2 = object.zzu;
        try {
            JSONObject jSONObject = new JSONObject(string);
            return jSONObject.getString("max_ad_content_rating");
        }
        catch (JSONException jSONException) {
            return string2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zze(IObjectWrapper var1_1, String var2_3, Bundle var3_4, Bundle var4_5, zzbdl var5_6, zzbxq var6_7) throws RemoteException {
        block10: {
            try {
                var8_8 = new zzbxw(this, var6_7);
                var6_7 = this.zza;
                var7_10 = var2_3.hashCode();
            }
            catch (Throwable var1_2) {
                zzcgt.zzg((String)"Error generating signals for RTB", (Throwable)var1_2);
                throw new RemoteException();
            }
            switch (var7_10) {
                default: {
                    break;
                }
                case 1911491517: {
                    if (!var2_3.equals("rewarded_interstitial")) break;
                    var7_10 = 3;
                    break block10;
                }
                case 604727084: {
                    if (!var2_3.equals("interstitial")) break;
                    var7_10 = 1;
                    break block10;
                }
                case -239580146: {
                    if (!var2_3.equals("rewarded")) break;
                    var7_10 = 2;
                    break block10;
                }
                case -1052618729: {
                    if (!var2_3.equals("native")) break;
                    var7_10 = 4;
                    break block10;
                }
                case -1396342996: {
                    if (!var2_3.equals("banner")) break;
                    var7_10 = 0;
                    break block10;
                }
            }
            var7_10 = -1;
        }
        if (var7_10 == 0) ** GOTO lbl49
        if (var7_10 == 1) ** GOTO lbl47
        if (var7_10 == 2) ** GOTO lbl45
        if (var7_10 == 3) ** GOTO lbl43
        if (var7_10 != 4) ** GOTO lbl41
        {
            block11: {
                var2_3 = AdFormat.NATIVE;
                break block11;
lbl41:
                // 1 sources

                var1_1 /* !! */  = new IllegalArgumentException("Internal Error");
                throw var1_1 /* !! */ ;
lbl43:
                // 1 sources

                var2_3 = AdFormat.REWARDED_INTERSTITIAL;
                break block11;
lbl45:
                // 1 sources

                var2_3 = AdFormat.REWARDED;
                break block11;
lbl47:
                // 1 sources

                var2_3 = AdFormat.INTERSTITIAL;
                break block11;
lbl49:
                // 1 sources

                var2_3 = AdFormat.BANNER;
            }
            var9_9 = new MediationConfiguration(var2_3, var4_5);
            var2_3 = new ArrayList();
            var2_3.add(var9_9);
            var4_5 = new RtbSignalData((Context)ObjectWrapper.unwrap((IObjectWrapper)var1_1 /* !! */ ), (List)var2_3, var3_4, com.google.android.gms.ads.zza.zza((int)var5_6.zze, (int)var5_6.zzb, (String)var5_6.zza));
            var6_7.collectSignals((RtbSignalData)var4_5, (SignalCallbacks)var8_8);
            return;
        }
    }

    public final zzbya zzf() throws RemoteException {
        return zzbya.zza((VersionInfo)this.zza.getVersionInfo());
    }

    public final zzbya zzg() throws RemoteException {
        return zzbya.zza((VersionInfo)this.zza.getSDKVersionInfo());
    }

    public final zzbhc zzh() {
        RtbAdapter rtbAdapter = this.zza;
        if (!(rtbAdapter instanceof zzb)) return null;
        try {
            rtbAdapter = ((zzb)rtbAdapter).getVideoController();
            return rtbAdapter;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
        }
        return null;
    }

    public final void zzi(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxb zzbxb2, zzbvm zzbvm2, zzbdl zzbdl2) throws RemoteException {
        try {
            zzbxs zzbxs2 = new zzbxs(this, zzbxb2, zzbvm2);
            zzbxb2 = this.zza;
            zzbvm2 = new MediationBannerAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), string, zzbxy.zzt(string2), this.zzs(zzbdg2), zzbxy.zzu(zzbdg2), zzbdg2.zzk, zzbdg2.zzg, zzbdg2.zzt, zzbxy.zzv(string2, zzbdg2), com.google.android.gms.ads.zza.zza((int)zzbdl2.zze, (int)zzbdl2.zzb, (String)zzbdl2.zza), this.zzd);
            zzbxb2.loadRtbBannerAd((MediationBannerAdConfiguration)zzbvm2, (MediationAdLoadCallback)zzbxs2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Adapter failed to render banner ad.", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzj(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxe zzbxe2, zzbvm zzbvm2) throws RemoteException {
        try {
            zzbxu zzbxu2 = new zzbxu(this, zzbxe2, zzbvm2);
            zzbvm2 = this.zza;
            zzbxe2 = new MediationInterstitialAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), string, zzbxy.zzt(string2), this.zzs(zzbdg2), zzbxy.zzu(zzbdg2), zzbdg2.zzk, zzbdg2.zzg, zzbdg2.zzt, zzbxy.zzv(string2, zzbdg2), this.zzd);
            zzbvm2.loadRtbInterstitialAd((MediationInterstitialAdConfiguration)zzbxe2, (MediationAdLoadCallback)zzbxu2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Adapter failed to render interstitial ad.", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final boolean zzk(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationInterstitialAd mediationInterstitialAd = this.zzb;
        if (mediationInterstitialAd == null) return false;
        try {
            mediationInterstitialAd.showAd((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
        }
        return true;
    }

    public final void zzl(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxk zzbxk2, zzbvm zzbvm2) throws RemoteException {
        try {
            zzbxx zzbxx2 = new zzbxx(this, zzbxk2, zzbvm2);
            zzbvm2 = this.zza;
            zzbxk2 = new MediationRewardedAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), string, zzbxy.zzt(string2), this.zzs(zzbdg2), zzbxy.zzu(zzbdg2), zzbdg2.zzk, zzbdg2.zzg, zzbdg2.zzt, zzbxy.zzv(string2, zzbdg2), this.zzd);
            zzbvm2.loadRtbRewardedAd((MediationRewardedAdConfiguration)zzbxk2, (MediationAdLoadCallback)zzbxx2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Adapter failed to render rewarded ad.", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final boolean zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        MediationRewardedAd mediationRewardedAd = this.zzc;
        if (mediationRewardedAd == null) return false;
        try {
            mediationRewardedAd.showAd((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper));
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
        }
        return true;
    }

    public final void zzn(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxh zzbxh2, zzbvm zzbvm2) throws RemoteException {
        this.zzr(string, string2, zzbdg2, iObjectWrapper, zzbxh2, zzbvm2, null);
    }

    public final void zzo(String string) {
        this.zzd = string;
    }

    public final void zzp(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxk zzbxk2, zzbvm zzbvm2) throws RemoteException {
        try {
            zzbxx zzbxx2 = new zzbxx(this, zzbxk2, zzbvm2);
            zzbxk2 = this.zza;
            zzbvm2 = new MediationRewardedAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), string, zzbxy.zzt(string2), this.zzs(zzbdg2), zzbxy.zzu(zzbdg2), zzbdg2.zzk, zzbdg2.zzg, zzbdg2.zzt, zzbxy.zzv(string2, zzbdg2), this.zzd);
            zzbxk2.loadRtbRewardedInterstitialAd((MediationRewardedAdConfiguration)zzbvm2, (MediationAdLoadCallback)zzbxx2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Adapter failed to render rewarded interstitial ad.", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzq(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxb zzbxb2, zzbvm zzbvm2, zzbdl zzbdl2) throws RemoteException {
        try {
            zzbxt zzbxt2 = new zzbxt(this, zzbxb2, zzbvm2);
            zzbvm2 = this.zza;
            zzbxb2 = new MediationBannerAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), string, zzbxy.zzt(string2), this.zzs(zzbdg2), zzbxy.zzu(zzbdg2), zzbdg2.zzk, zzbdg2.zzg, zzbdg2.zzt, zzbxy.zzv(string2, zzbdg2), com.google.android.gms.ads.zza.zza((int)zzbdl2.zze, (int)zzbdl2.zzb, (String)zzbdl2.zza), this.zzd);
            zzbvm2.loadRtbInterscrollerAd((MediationBannerAdConfiguration)zzbxb2, (MediationAdLoadCallback)zzbxt2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Adapter failed to render interscroller ad.", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzr(String string, String string2, zzbdg zzbdg2, IObjectWrapper iObjectWrapper, zzbxh zzbxh2, zzbvm zzbvm2, zzblv zzblv2) throws RemoteException {
        try {
            zzbxv zzbxv2 = new zzbxv(this, zzbxh2, zzbvm2);
            zzbvm2 = this.zza;
            zzbxh2 = new MediationNativeAdConfiguration((Context)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper), string, zzbxy.zzt(string2), this.zzs(zzbdg2), zzbxy.zzu(zzbdg2), zzbdg2.zzk, zzbdg2.zzg, zzbdg2.zzt, zzbxy.zzv(string2, zzbdg2), this.zzd, zzblv2);
            zzbvm2.loadRtbNativeAd((MediationNativeAdConfiguration)zzbxh2, (MediationAdLoadCallback)zzbxv2);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"Adapter failed to render native ad.", (Throwable)throwable);
            throw new RemoteException();
        }
    }
}
