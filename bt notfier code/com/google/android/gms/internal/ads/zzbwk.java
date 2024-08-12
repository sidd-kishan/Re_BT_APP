/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.os.Bundle
 *  android.os.RemoteException
 *  com.google.ads.AdSize
 *  com.google.ads.mediation.MediationAdapter
 *  com.google.ads.mediation.MediationBannerAdapter
 *  com.google.ads.mediation.MediationBannerListener
 *  com.google.ads.mediation.MediationInterstitialAdapter
 *  com.google.ads.mediation.MediationInterstitialListener
 *  com.google.ads.mediation.MediationServerParameters
 *  com.google.ads.mediation.NetworkExtras
 *  com.google.android.gms.ads.zza
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbdg
 *  com.google.android.gms.internal.ads.zzbdl
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzblv
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbrp
 *  com.google.android.gms.internal.ads.zzbrv
 *  com.google.android.gms.internal.ads.zzbvi
 *  com.google.android.gms.internal.ads.zzbvm
 *  com.google.android.gms.internal.ads.zzbvp
 *  com.google.android.gms.internal.ads.zzbvr
 *  com.google.android.gms.internal.ads.zzbvs
 *  com.google.android.gms.internal.ads.zzbvv
 *  com.google.android.gms.internal.ads.zzbww
 *  com.google.android.gms.internal.ads.zzbwx
 *  com.google.android.gms.internal.ads.zzbya
 *  com.google.android.gms.internal.ads.zzcck
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 *  org.json.JSONObject
 */
package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdapter;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.zza;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbdg;
import com.google.android.gms.internal.ads.zzbdl;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzblv;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbrp;
import com.google.android.gms.internal.ads.zzbrv;
import com.google.android.gms.internal.ads.zzbvi;
import com.google.android.gms.internal.ads.zzbvm;
import com.google.android.gms.internal.ads.zzbvp;
import com.google.android.gms.internal.ads.zzbvr;
import com.google.android.gms.internal.ads.zzbvs;
import com.google.android.gms.internal.ads.zzbvv;
import com.google.android.gms.internal.ads.zzbww;
import com.google.android.gms.internal.ads.zzbwx;
import com.google.android.gms.internal.ads.zzbya;
import com.google.android.gms.internal.ads.zzcck;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class zzbwk<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters>
extends zzbvi {
    private final MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> zza;
    private final NETWORK_EXTRAS zzb;

    public zzbwk(MediationAdapter<NETWORK_EXTRAS, SERVER_PARAMETERS> mediationAdapter, NETWORK_EXTRAS NETWORK_EXTRAS) {
        this.zza = mediationAdapter;
        this.zzb = NETWORK_EXTRAS;
    }

    /*
     * Unable to fully structure code
     */
    private final SERVER_PARAMETERS zzb(String var1_1) throws RemoteException {
        if (var1_1 == null) ** GOTO lbl14
        try {
            block6: {
                var3_4 = new JSONObject((String)var1_1);
                var2_5 = new HashMap(var3_4.length());
                var4_6 = var3_4.keys();
                while (true) {
                    var1_1 = var2_5;
                    if (var4_6.hasNext()) {
                        var1_1 = (String)var4_6.next();
                        var2_5.put(var1_1, var3_4.getString((String)var1_1));
                        continue;
                    }
                    break block6;
                    break;
                }
lbl14:
                // 1 sources

                var1_1 = new HashMap<K, V>(0);
            }
            if ((var2_5 = this.zza.getServerParametersType()) != null) {
                var2_5 = (MediationServerParameters)var2_5.newInstance();
                var2_5.load((Map)var1_1);
                var1_1 = var2_5;
            } else {
                var1_1 = null;
            }
        }
        catch (Throwable var1_2) {
            zzcgt.zzg((String)"", (Throwable)var1_2);
            var1_3 = new RemoteException();
            throw var1_3;
        }
        return (SERVER_PARAMETERS)var1_1;
    }

    private static final boolean zzc(zzbdg zzbdg2) {
        if (zzbdg2.zzf) return true;
        zzber.zza();
        if (!zzcgm.zzm()) return false;
        return true;
    }

    public final void zzA(boolean bl) {
    }

    public final zzbhc zzB() {
        return null;
    }

    public final zzbvv zzC() {
        return null;
    }

    public final void zzD(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
    }

    public final void zzE(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final void zzF(IObjectWrapper iObjectWrapper, zzbrp zzbrp2, List<zzbrv> list) throws RemoteException {
    }

    public final void zzG(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
    }

    public final zzbya zzH() {
        return null;
    }

    public final zzbya zzI() {
        return null;
    }

    public final void zzJ(IObjectWrapper iObjectWrapper, zzbdl zzbdl2, zzbdg zzbdg2, String string, String string2, zzbvm zzbvm2) {
    }

    public final zzbvp zzK() {
        return null;
    }

    public final void zzL(IObjectWrapper iObjectWrapper) {
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
        if (!(object instanceof MediationBannerAdapter)) {
            object = (object = String.valueOf(object.getClass().getCanonicalName())).length() != 0 ? "Not a MediationBannerAdapter: ".concat((String)object) : new String("Not a MediationBannerAdapter: ");
            zzcgt.zzi((String)object);
            throw new RemoteException();
        }
        try {
            object = ObjectWrapper.wrap((Object)((MediationBannerAdapter)object).getBannerView());
            return object;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzbvm zzbvm2) throws RemoteException {
        this.zzk(iObjectWrapper, zzbdg2, string, null, zzbvm2);
    }

    public final void zzh() throws RemoteException {
        Object object = this.zza;
        if (!(object instanceof MediationInterstitialAdapter)) {
            object = ((String)(object = String.valueOf(object.getClass().getCanonicalName()))).length() != 0 ? "Not a MediationInterstitialAdapter: ".concat((String)object) : new String("Not a MediationInterstitialAdapter: ");
            zzcgt.zzi((String)object);
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
        try {
            this.zza.destroy();
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    public final void zzj(IObjectWrapper var1_1, zzbdl var2_4, zzbdg var3_5, String var4_6, String var5_7, zzbvm var6_8) throws RemoteException {
        var5_7 = this.zza;
        if (!(var5_7 instanceof MediationBannerAdapter)) {
            var1_1 = String.valueOf(var5_7.getClass().getCanonicalName());
            var1_1 = var1_1.length() != 0 ? "Not a MediationBannerAdapter: ".concat((String)var1_1) : new String("Not a MediationBannerAdapter: ");
            zzcgt.zzi((String)var1_1);
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting banner ad from adapter.");
        try {
            var8_9 = (MediationBannerAdapter)this.zza;
            var5_7 = new zzbww(var6_8);
            var6_8 = (Activity)ObjectWrapper.unwrap((IObjectWrapper)var1_1);
            var4_6 /* !! */  = this.zzb(var4_6 /* !! */ );
            var9_10 = new AdSize[6];
            var1_1 = AdSize.SMART_BANNER;
            var9_10[0] = var1_1;
            var9_10[1] = AdSize.BANNER;
            var9_10[2] = AdSize.IAB_MRECT;
            var9_10[3] = AdSize.IAB_BANNER;
            var9_10[4] = AdSize.IAB_LEADERBOARD;
            var9_10[5] = AdSize.IAB_WIDE_SKYSCRAPER;
            for (var7_11 = 0; var7_11 < 6; ++var7_11) {
                if (var9_10[var7_11].getWidth() != var2_4.zze || var9_10[var7_11].getHeight() != var2_4.zzb) continue;
            }
        }
        catch (Throwable var1_2) {
            zzcgt.zzg((String)"", (Throwable)var1_2);
            var1_3 = new RemoteException();
            throw var1_3;
        }
        {
            var1_1 = var9_10[var7_11];
            ** GOTO lbl31
        }
        var1_1 = new AdSize(com.google.android.gms.ads.zza.zza((int)var2_4.zze, (int)var2_4.zzb, (String)var2_4.zza));
lbl31:
        // 2 sources

        var8_9.requestBannerAd((MediationBannerListener)var5_7, (Activity)var6_8, (MediationServerParameters)var4_6 /* !! */ , (AdSize)var1_1, zzbwx.zzb((zzbdg)var3_5, (boolean)zzbwk.zzc(var3_5)), this.zzb);
    }

    public final void zzk(IObjectWrapper object, zzbdg zzbdg2, String string, String zzbww2, zzbvm zzbvm2) throws RemoteException {
        zzbww2 = this.zza;
        if (!(zzbww2 instanceof MediationInterstitialAdapter)) {
            object = String.valueOf(zzbww2.getClass().getCanonicalName());
            object = ((String)object).length() != 0 ? "Not a MediationInterstitialAdapter: ".concat((String)object) : new String("Not a MediationInterstitialAdapter: ");
            zzcgt.zzi((String)object);
            throw new RemoteException();
        }
        zzcgt.zzd((String)"Requesting interstitial ad from adapter.");
        try {
            MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter)this.zza;
            zzbww2 = new zzbww(zzbvm2);
            mediationInterstitialAdapter.requestInterstitialAd((MediationInterstitialListener)zzbww2, (Activity)ObjectWrapper.unwrap((IObjectWrapper)object), this.zzb(string), zzbwx.zzb((zzbdg)zzbdg2, (boolean)zzbwk.zzc(zzbdg2)), this.zzb);
            return;
        }
        catch (Throwable throwable) {
            zzcgt.zzg((String)"", (Throwable)throwable);
            throw new RemoteException();
        }
    }

    public final void zzl() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzm() throws RemoteException {
        throw new RemoteException();
    }

    public final void zzn(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, zzcck zzcck2, String string2) throws RemoteException {
    }

    public final void zzo(zzbdg zzbdg2, String string) {
    }

    public final void zzp() {
    }

    public final boolean zzq() {
        return true;
    }

    public final void zzr(IObjectWrapper iObjectWrapper, zzbdg zzbdg2, String string, String string2, zzbvm zzbvm2, zzblv zzblv2, List<String> list) {
    }

    public final Bundle zzs() {
        return new Bundle();
    }

    public final Bundle zzt() {
        return new Bundle();
    }

    public final Bundle zzu() {
        return new Bundle();
    }

    public final void zzv(zzbdg zzbdg2, String string, String string2) {
    }

    public final void zzw(IObjectWrapper iObjectWrapper) throws RemoteException {
    }

    public final boolean zzx() {
        return false;
    }

    public final void zzy(IObjectWrapper iObjectWrapper, zzcck zzcck2, List<String> list) {
    }

    public final zzbnb zzz() {
        return null;
    }
}
