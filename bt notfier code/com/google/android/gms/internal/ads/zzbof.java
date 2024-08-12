/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.RemoteException
 *  com.google.android.gms.ads.MediaContent
 *  com.google.android.gms.ads.MuteThisAdListener
 *  com.google.android.gms.ads.MuteThisAdReason
 *  com.google.android.gms.ads.OnPaidEventListener
 *  com.google.android.gms.ads.ResponseInfo
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.formats.NativeAd$AdChoicesInfo
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  com.google.android.gms.ads.formats.UnifiedNativeAd
 *  com.google.android.gms.ads.formats.UnifiedNativeAd$UnconfirmedClickListener
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbgi
 *  com.google.android.gms.internal.ads.zzbgj
 *  com.google.android.gms.internal.ads.zzbgl
 *  com.google.android.gms.internal.ads.zzbgm
 *  com.google.android.gms.internal.ads.zzbgn
 *  com.google.android.gms.internal.ads.zzbgw
 *  com.google.android.gms.internal.ads.zzbgz
 *  com.google.android.gms.internal.ads.zzbhw
 *  com.google.android.gms.internal.ads.zzbil
 *  com.google.android.gms.internal.ads.zzbmf
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbmi
 *  com.google.android.gms.internal.ads.zzbob
 *  com.google.android.gms.internal.ads.zzboe
 *  com.google.android.gms.internal.ads.zzbop
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.MuteThisAdListener;
import com.google.android.gms.ads.MuteThisAdReason;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbgi;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzbgl;
import com.google.android.gms.internal.ads.zzbgm;
import com.google.android.gms.internal.ads.zzbgn;
import com.google.android.gms.internal.ads.zzbgw;
import com.google.android.gms.internal.ads.zzbgz;
import com.google.android.gms.internal.ads.zzbhw;
import com.google.android.gms.internal.ads.zzbil;
import com.google.android.gms.internal.ads.zzbmf;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbob;
import com.google.android.gms.internal.ads.zzboe;
import com.google.android.gms.internal.ads.zzbop;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.ArrayList;
import java.util.List;

public final class zzbof
extends UnifiedNativeAd {
    private final zzboe zza;
    private final List<NativeAd.Image> zzb;
    private final zzbmi zzc;
    private final VideoController zzd;
    private final NativeAd.AdChoicesInfo zze;
    private final List<MuteThisAdReason> zzf;

    public zzbof(zzboe object3) {
        Object var2_6;
        block14: {
            block13: {
                zzbmi zzbmi2;
                Object object2;
                this.zzb = new ArrayList<NativeAd.Image>();
                this.zzd = new VideoController();
                this.zzf = new ArrayList<MuteThisAdReason>();
                this.zza = object3;
                var2_6 = null;
                try {
                    object3 = object3.zzf();
                    if (object3 != null) {
                        for (Object object3 : object3) {
                            object3 = object3 instanceof IBinder && (object3 = (IBinder)object3) != null ? ((object2 = object3.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdImage")) instanceof zzbmh ? (zzbmh)object2 : new zzbmf((IBinder)object3)) : null;
                            if (object3 == null) continue;
                            object2 = this.zzb;
                            zzbmi2 = new zzbmi((zzbmh)object3);
                            object2.add(zzbmi2);
                        }
                    }
                }
                catch (RemoteException remoteException) {
                    zzcgt.zzg((String)"", (Throwable)remoteException);
                }
                try {
                    object3 = this.zza.zzz();
                    if (object3 != null) {
                        for (Object object3 : object3) {
                            object3 = object3 instanceof IBinder ? zzbgl.zzb((IBinder)((IBinder)object3)) : null;
                            if (object3 == null) continue;
                            object2 = this.zzf;
                            super((zzbgm)object3);
                            object2.add(zzbmi2);
                        }
                    }
                }
                catch (RemoteException remoteException) {
                    zzcgt.zzg((String)"", (Throwable)remoteException);
                }
                try {
                    zzbmh zzbmh2 = this.zza.zzh();
                    if (zzbmh2 == null) break block13;
                    super(zzbmh2);
                    break block14;
                }
                catch (RemoteException remoteException) {
                    zzcgt.zzg((String)"", (Throwable)remoteException);
                }
            }
            object3 = null;
        }
        this.zzc = object3;
        object3 = var2_6;
        try {
            if (this.zza.zzq() != null) {
                super(this.zza.zzq());
            }
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            object3 = var2_6;
        }
        this.zze = object3;
    }

    public final void cancelUnconfirmedClick() {
        try {
            this.zza.zzy();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Failed to cancelUnconfirmedClick", (Throwable)remoteException);
            return;
        }
    }

    public final void destroy() {
        try {
            this.zza.zzp();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void enableCustomClickGesture() {
        try {
            this.zza.zzD();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final NativeAd.AdChoicesInfo getAdChoicesInfo() {
        return this.zze;
    }

    public final String getAdvertiser() {
        try {
            String string = this.zza.zzj();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final String getBody() {
        try {
            String string = this.zza.zzg();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final String getCallToAction() {
        try {
            String string = this.zza.zzi();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final Bundle getExtras() {
        try {
            Bundle bundle = this.zza.zzw();
            if (bundle == null) return new Bundle();
            return bundle;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        return new Bundle();
    }

    public final String getHeadline() {
        try {
            String string = this.zza.zze();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final NativeAd.Image getIcon() {
        return this.zzc;
    }

    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public final MediaContent getMediaContent() {
        try {
            if (this.zza.zzF() == null) return null;
            zzbhw zzbhw2 = new zzbhw(this.zza.zzF());
            return zzbhw2;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        return null;
    }

    public final String getMediationAdapterClassName() {
        try {
            String string = this.zza.zzo();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final List<MuteThisAdReason> getMuteThisAdReasons() {
        return this.zzf;
    }

    public final String getPrice() {
        try {
            String string = this.zza.zzm();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzbgz zzbgz2;
        try {
            zzbgz2 = this.zza.zzH();
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            zzbgz2 = null;
        }
        return ResponseInfo.zzb((zzbgz)zzbgz2);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     */
    public final Double getStarRating() {
        Double d;
        block4: {
            double d2;
            d = null;
            try {
                d2 = this.zza.zzk();
                if (d2 == -1.0) {
                    break block4;
                }
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"", (Throwable)remoteException);
                return null;
            }
            {
                d = d2;
            }
        }
        return d;
    }

    public final String getStore() {
        try {
            String string = this.zza.zzl();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzn() == null) return this.zzd;
            this.zzd.zza(this.zza.zzn());
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Exception occurred while getting video controller", (Throwable)remoteException);
        }
        return this.zzd;
    }

    public final boolean isCustomClickGestureEnabled() {
        try {
            boolean bl = this.zza.zzG();
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return false;
        }
    }

    public final boolean isCustomMuteThisAdEnabled() {
        try {
            boolean bl = this.zza.zzA();
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return false;
        }
    }

    /*
     * Unable to fully structure code
     */
    public final void muteThisAd(MuteThisAdReason var1_1) {
        var2_4 = this.zza.zzA();
        if (!var2_4) ** GOTO lbl18
        if (var1_1 == null) {
        }
        ** GOTO lbl13
        {
            block6: {
                catch (RemoteException var1_2) {
                    zzcgt.zzg((String)"", (Throwable)var1_2);
                    break block6;
                }
                ** try [egrp 1[TRYBLOCK] [1 : 21->75)] { 
lbl11:
                // 1 sources

                this.zza.zzB(null);
                return;
lbl13:
                // 1 sources

                if (var1_1 instanceof zzbgn) {
                    this.zza.zzB(((zzbgn)var1_1).zza());
                    return;
                }
                zzcgt.zzf((String)"Use mute reason from UnifiedNativeAd.getMuteThisAdReasons() or null");
                return;
            }
            zzcgt.zzf((String)"Ad is not custom mute enabled");
            return;
        }
lbl21:
        // 1 sources

        catch (RemoteException var1_3) {
            zzcgt.zzg((String)"", (Throwable)var1_3);
            return;
        }
    }

    public final void performClick(Bundle bundle) {
        try {
            this.zza.zzr(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void recordCustomClickGesture() {
        try {
            this.zza.zzE();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final boolean recordImpression(Bundle bundle) {
        try {
            boolean bl = this.zza.zzs(bundle);
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return false;
        }
    }

    public final void reportTouchEvent(Bundle bundle) {
        try {
            this.zza.zzt(bundle);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void setMuteThisAdListener(MuteThisAdListener muteThisAdListener) {
        try {
            zzboe zzboe2 = this.zza;
            zzbgj zzbgj2 = new zzbgj(muteThisAdListener);
            zzboe2.zzC((zzbgi)zzbgj2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            zzboe zzboe2 = this.zza;
            zzbil zzbil2 = new zzbil(onPaidEventListener);
            zzboe2.zzI((zzbgw)zzbil2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Failed to setOnPaidEventListener", (Throwable)remoteException);
            return;
        }
    }

    public final void setUnconfirmedClickListener(UnifiedNativeAd.UnconfirmedClickListener unconfirmedClickListener) {
        try {
            zzboe zzboe2 = this.zza;
            zzbop zzbop2 = new zzbop(unconfirmedClickListener);
            zzboe2.zzx((zzbob)zzbop2);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Failed to setUnconfirmedClickListener", (Throwable)remoteException);
            return;
        }
    }

    public final Object zza() {
        try {
            Object object = this.zza.zzv();
            if (object == null) return null;
            object = ObjectWrapper.unwrap((IObjectWrapper)object);
            return object;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        return null;
    }
}
