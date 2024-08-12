/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.formats.MediaView
 *  com.google.android.gms.ads.formats.NativeAd$Image
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd
 *  com.google.android.gms.ads.formats.NativeCustomTemplateAd$DisplayOpenMeasurement
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbmb
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbmi
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbmb;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbmi;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.List;

public final class zzbnc
implements NativeCustomTemplateAd {
    private final zzbnb zza;
    private final MediaView zzb;
    private final VideoController zzc;
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzd;

    public zzbnc(zzbnb zzbnb2) {
        MediaView mediaView;
        block7: {
            this.zzc = new VideoController();
            this.zza = zzbnb2;
            mediaView = null;
            try {
                zzbnb2 = (Context)ObjectWrapper.unwrap((IObjectWrapper)zzbnb2.zzm());
                break block7;
            }
            catch (RemoteException remoteException) {
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
            zzcgt.zzg((String)"", (Throwable)zzbnb2);
            zzbnb2 = null;
        }
        MediaView mediaView2 = mediaView;
        if (zzbnb2 != null) {
            mediaView2 = new MediaView((Context)zzbnb2);
            try {
                boolean bl = this.zza.zzn(ObjectWrapper.wrap((Object)mediaView2));
                if (!bl) {
                    mediaView2 = mediaView;
                }
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"", (Throwable)remoteException);
                mediaView2 = mediaView;
            }
        }
        this.zzb = mediaView2;
    }

    public final void destroy() {
        try {
            this.zza.zzl();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final List<String> getAvailableAssetNames() {
        try {
            List list = this.zza.zzg();
            return list;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final String getCustomTemplateId() {
        try {
            String string = this.zza.zzh();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzd != null) return this.zzd;
            if (!this.zza.zzo()) return this.zzd;
            zzbmb zzbmb2 = new zzbmb(this.zza);
            this.zzd = zzbmb2;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        return this.zzd;
    }

    public final NativeAd.Image getImage(String string) {
        try {
            string = this.zza.zzf(string);
            if (string == null) return null;
            string = new zzbmi((zzbmh)string);
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        return null;
    }

    public final CharSequence getText(String string) {
        try {
            string = this.zza.zze(string);
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final VideoController getVideoController() {
        try {
            zzbhc zzbhc2 = this.zza.zzk();
            if (zzbhc2 == null) return this.zzc;
            this.zzc.zza(zzbhc2);
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Exception occurred while getting video controller", (Throwable)remoteException);
        }
        return this.zzc;
    }

    public final MediaView getVideoMediaView() {
        return this.zzb;
    }

    public final void performClick(String string) {
        try {
            this.zza.zzi(string);
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final void recordImpression() {
        try {
            this.zza.zzj();
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final zzbnb zza() {
        return this.zza;
    }
}
