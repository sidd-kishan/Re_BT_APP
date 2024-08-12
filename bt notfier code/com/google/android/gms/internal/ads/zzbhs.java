/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  android.webkit.WebView
 *  com.google.android.gms.ads.AdInspectorError
 *  com.google.android.gms.ads.OnAdInspectorClosedListener
 *  com.google.android.gms.ads.RequestConfiguration
 *  com.google.android.gms.ads.RequestConfiguration$Builder
 *  com.google.android.gms.ads.initialization.AdapterStatus$State
 *  com.google.android.gms.ads.initialization.InitializationStatus
 *  com.google.android.gms.ads.initialization.OnInitializationCompleteListener
 *  com.google.android.gms.ads.mediation.rtb.RtbAdapter
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbej
 *  com.google.android.gms.internal.ads.zzber
 *  com.google.android.gms.internal.ads.zzbet
 *  com.google.android.gms.internal.ads.zzbge
 *  com.google.android.gms.internal.ads.zzbgq
 *  com.google.android.gms.internal.ads.zzbhm
 *  com.google.android.gms.internal.ads.zzbhn
 *  com.google.android.gms.internal.ads.zzbhq
 *  com.google.android.gms.internal.ads.zzbhr
 *  com.google.android.gms.internal.ads.zzbim
 *  com.google.android.gms.internal.ads.zzbjd
 *  com.google.android.gms.internal.ads.zzbjl
 *  com.google.android.gms.internal.ads.zzbrl
 *  com.google.android.gms.internal.ads.zzbrs
 *  com.google.android.gms.internal.ads.zzbrt
 *  com.google.android.gms.internal.ads.zzbru
 *  com.google.android.gms.internal.ads.zzbuz
 *  com.google.android.gms.internal.ads.zzbvd
 *  com.google.android.gms.internal.ads.zzbvg
 *  com.google.android.gms.internal.ads.zzcah
 *  com.google.android.gms.internal.ads.zzcfn
 *  com.google.android.gms.internal.ads.zzcgm
 *  com.google.android.gms.internal.ads.zzcgt
 *  com.google.android.gms.internal.ads.zzfmi
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.webkit.WebView;
import com.google.android.gms.ads.AdInspectorError;
import com.google.android.gms.ads.OnAdInspectorClosedListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbej;
import com.google.android.gms.internal.ads.zzber;
import com.google.android.gms.internal.ads.zzbet;
import com.google.android.gms.internal.ads.zzbge;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzbhn;
import com.google.android.gms.internal.ads.zzbhq;
import com.google.android.gms.internal.ads.zzbhr;
import com.google.android.gms.internal.ads.zzbim;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbjl;
import com.google.android.gms.internal.ads.zzbrl;
import com.google.android.gms.internal.ads.zzbrs;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbru;
import com.google.android.gms.internal.ads.zzbuz;
import com.google.android.gms.internal.ads.zzbvd;
import com.google.android.gms.internal.ads.zzbvg;
import com.google.android.gms.internal.ads.zzcah;
import com.google.android.gms.internal.ads.zzcfn;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgt;
import com.google.android.gms.internal.ads.zzfmi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public final class zzbhs {
    private static zzbhs zzc;
    private final ArrayList<OnInitializationCompleteListener> zza;
    private final Object zzb = new Object();
    private zzbge zzd;
    private boolean zze = false;
    private boolean zzf = false;
    @Nullable
    private OnAdInspectorClosedListener zzg = null;
    private RequestConfiguration zzh = new RequestConfiguration.Builder().build();
    private InitializationStatus zzi;

    private zzbhs() {
        this.zza = new ArrayList();
    }

    static /* synthetic */ ArrayList zza(zzbhs zzbhs2) {
        return zzbhs2.zza;
    }

    static /* synthetic */ boolean zzb(zzbhs zzbhs2, boolean bl) {
        zzbhs2.zze = false;
        return false;
    }

    static /* synthetic */ boolean zzc(zzbhs zzbhs2, boolean bl) {
        zzbhs2.zzf = true;
        return true;
    }

    static /* synthetic */ OnAdInspectorClosedListener zzd(zzbhs zzbhs2) {
        return zzbhs2.zzg;
    }

    public static zzbhs zze() {
        synchronized (zzbhs.class) {
            zzbhs zzbhs2;
            if (zzc == null) {
                zzc = zzbhs2 = new zzbhs();
            }
            zzbhs2 = zzc;
            return zzbhs2;
        }
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    static /* synthetic */ InitializationStatus zzq(zzbhs zzbhs2, List list) {
        return zzbhs.zzx(list);
    }

    private final void zzv(RequestConfiguration requestConfiguration) {
        try {
            zzbge zzbge2 = this.zzd;
            zzbim zzbim2 = new zzbim(requestConfiguration);
            zzbge2.zzr(zzbim2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Unable to set request configuration parcel.", (Throwable)remoteException);
            return;
        }
    }

    private final void zzw(Context context) {
        if (this.zzd != null) return;
        this.zzd = (zzbge)new zzbej(zzber.zzb(), context).zzd(context, false);
    }

    private static final InitializationStatus zzx(List<zzbrl> state) {
        HashMap<String, zzbrt> hashMap = new HashMap<String, zzbrt>();
        Iterator<zzbrl> iterator = state.iterator();
        while (iterator.hasNext()) {
            zzbrl zzbrl2 = iterator.next();
            String string = zzbrl2.zza;
            state = zzbrl2.zzb ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY;
            hashMap.put(string, new zzbrt(state, zzbrl2.zzd, zzbrl2.zzc));
        }
        return new zzbru(hashMap);
    }

    public final void zzf(Context object, @Nullable String object2, @Nullable OnInitializationCompleteListener onInitializationCompleteListener) {
        object2 = this.zzb;
        synchronized (object2) {
            if (this.zze) {
                if (onInitializationCompleteListener == null) return;
                zzbhs.zze().zza.add(onInitializationCompleteListener);
                return;
            }
            if (this.zzf) {
                if (onInitializationCompleteListener == null) return;
                onInitializationCompleteListener.onInitializationComplete(this.zzn());
                return;
            }
            this.zze = true;
            if (onInitializationCompleteListener != null) {
                zzbhs.zze().zza.add(onInitializationCompleteListener);
            }
            if (object == null) {
                object = new IllegalArgumentException("Context cannot be null.");
                throw object;
            }
            try {
                zzbge zzbge2;
                zzbge zzbge3;
                zzbuz.zza().zzb(object, null);
                this.zzw((Context)object);
                if (onInitializationCompleteListener != null) {
                    zzbge3 = this.zzd;
                    zzbge2 = new zzbhr(this, null);
                    zzbge3.zzp((zzbrs)zzbge2);
                }
                zzbge2 = this.zzd;
                zzbge3 = new zzbvd();
                zzbge2.zzo((zzbvg)zzbge3);
                this.zzd.zze();
                this.zzd.zzj(null, ObjectWrapper.wrap(null));
                if (this.zzh.getTagForChildDirectedTreatment() != -1 || this.zzh.getTagForUnderAgeOfConsent() != -1) {
                    this.zzv(this.zzh);
                }
                zzbjl.zza((Context)object);
                object = zzbjl.zzdI;
                if ((Boolean)zzbet.zzc().zzc((zzbjd)object) != false) return;
                if (this.zzl().endsWith("0")) return;
                zzcgt.zzf((String)"Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.");
                object = new zzbhn(this);
                this.zzi = object;
                if (onInitializationCompleteListener == null) return;
                object = zzcgm.zza;
                zzbge3 = new zzbhm(this, onInitializationCompleteListener);
                object.post((Runnable)zzbge3);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzj((String)"MobileAdsSettingManager initialization failed", (Throwable)remoteException);
            }
            return;
        }
    }

    public final void zzg(float f) {
        boolean bl = true;
        boolean bl2 = !(f < 0.0f) && f <= 1.0f;
        Preconditions.checkArgument((boolean)bl2, (Object)"The app volume must be a value between 0 and 1 inclusive.");
        Object object = this.zzb;
        synchronized (object) {
            bl2 = this.zzd != null ? bl : false;
            Preconditions.checkState((boolean)bl2, (Object)"MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzd.zzf(f);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to set app volume.", (Throwable)remoteException);
            }
            return;
        }
    }

    public final float zzh() {
        Object object = this.zzb;
        synchronized (object) {
            zzbge zzbge2 = this.zzd;
            float f = 1.0f;
            if (zzbge2 == null) {
                return 1.0f;
            }
            try {
                float f2;
                f = f2 = zzbge2.zzk();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to get app volume.", (Throwable)remoteException);
            }
            return f;
        }
    }

    public final void zzi(boolean bl) {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl2 = this.zzd != null;
            Preconditions.checkState((boolean)bl2, (Object)"MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzd.zzh(bl);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to set app mute state.", (Throwable)remoteException);
            }
            return;
        }
    }

    public final boolean zzj() {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl;
            zzbge zzbge2 = this.zzd;
            boolean bl2 = false;
            if (zzbge2 == null) {
                return false;
            }
            try {
                bl = zzbge2.zzl();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to get app mute state.", (Throwable)remoteException);
                bl = bl2;
            }
            return bl;
        }
    }

    public final void zzk(Context context, String string) {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl = this.zzd != null;
            Preconditions.checkState((boolean)bl, (Object)"MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzd.zzi(ObjectWrapper.wrap((Object)context), string);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to open debug menu.", (Throwable)remoteException);
            }
            return;
        }
    }

    public final String zzl() {
        Object object = this.zzb;
        synchronized (object) {
            boolean bl = this.zzd != null;
            Preconditions.checkState((boolean)bl, (Object)"MobileAds.initialize() must be called prior to getting version string.");
            try {
                String string = zzfmi.zza((String)this.zzd.zzm());
                return string;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to get version string.", (Throwable)remoteException);
                return "";
            }
        }
    }

    public final void zzm(Class<? extends RtbAdapter> clazz) {
        Object object = this.zzb;
        synchronized (object) {
            try {
                try {
                    this.zzd.zzn(clazz.getCanonicalName());
                }
                catch (RemoteException remoteException) {
                    zzcgt.zzg((String)"Unable to register RtbAdapter", (Throwable)remoteException);
                }
                return;
            }
            catch (Throwable throwable) {}
            throw throwable;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled force condition propagation
     */
    public final InitializationStatus zzn() {
        Object object = this.zzb;
        synchronized (object) {
            InitializationStatus initializationStatus;
            boolean bl = this.zzd != null;
            Preconditions.checkState((boolean)bl, (Object)"MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                initializationStatus = this.zzi;
                if (initializationStatus == null) return zzbhs.zzx(this.zzd.zzq());
            }
            catch (RemoteException remoteException) {
                zzcgt.zzf((String)"Unable to get Initialization status.");
                return new zzbhn(this);
            }
            return initializationStatus;
        }
    }

    public final void zzo(Context context) {
        Object object = this.zzb;
        synchronized (object) {
            this.zzw(context);
            try {
                this.zzd.zzs();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzf((String)"Unable to disable mediation adapter initialization.");
            }
            return;
        }
    }

    public final void zzp(Context context, OnAdInspectorClosedListener onAdInspectorClosedListener) {
        Object object = this.zzb;
        synchronized (object) {
            this.zzw(context);
            zzbhs.zze().zzg = onAdInspectorClosedListener;
            try {
                zzbge zzbge2 = this.zzd;
                context = new zzbhq(null);
                zzbge2.zzt((zzbgq)context);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzf((String)"Unable to open the ad inspector.");
                if (onAdInspectorClosedListener == null) return;
                AdInspectorError adInspectorError = new AdInspectorError(0, "Ad inspector had an internal error.", "com.google.android.gms.ads");
                onAdInspectorClosedListener.onAdInspectorClosed(adInspectorError);
            }
            return;
        }
    }

    public final RequestConfiguration zzr() {
        return this.zzh;
    }

    public final void zzs(RequestConfiguration requestConfiguration) {
        boolean bl = requestConfiguration != null;
        Preconditions.checkArgument((boolean)bl, (Object)"Null passed to setRequestConfiguration.");
        Object object = this.zzb;
        synchronized (object) {
            RequestConfiguration requestConfiguration2 = this.zzh;
            this.zzh = requestConfiguration;
            if (this.zzd == null) {
                return;
            }
            if (requestConfiguration2.getTagForChildDirectedTreatment() == requestConfiguration.getTagForChildDirectedTreatment()) {
                if (requestConfiguration2.getTagForUnderAgeOfConsent() == requestConfiguration.getTagForUnderAgeOfConsent()) return;
            }
            this.zzv(requestConfiguration);
            return;
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public final void zzt(WebView webView) {
        Preconditions.checkMainThread((String)"#008 Must be called on the main UI thread.");
        Object object = this.zzb;
        synchronized (object) {
            if (webView == null) {
                zzcgt.zzf((String)"The webview to be registered cannot be null.");
                return;
            }
            zzcfn zzcfn2 = zzcah.zza((Context)webView.getContext());
            if (zzcfn2 == null) {
                zzcgt.zzi((String)"Internal error, query info generator is null.");
                return;
            }
            try {
                zzcfn2.zzj(ObjectWrapper.wrap((Object)webView));
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"", (Throwable)remoteException);
            }
            return;
        }
    }

    final /* synthetic */ void zzu(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzi);
    }
}
