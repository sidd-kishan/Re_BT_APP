/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.RemoteException
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.ads.nativead.MediaView
 *  com.google.android.gms.ads.nativead.NativeAd$Image
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd
 *  com.google.android.gms.ads.nativead.NativeCustomFormatAd$DisplayOpenMeasurement
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbmh
 *  com.google.android.gms.internal.ads.zzbnb
 *  com.google.android.gms.internal.ads.zzbys
 *  com.google.android.gms.internal.ads.zzbyt
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeCustomFormatAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbmh;
import com.google.android.gms.internal.ads.zzbnb;
import com.google.android.gms.internal.ads.zzbys;
import com.google.android.gms.internal.ads.zzbyt;
import com.google.android.gms.internal.ads.zzcgt;
import java.util.List;

public final class zzbyz
implements NativeCustomFormatAd {
    private final zzbnb zza;
    private final MediaView zzb;
    private final VideoController zzc;
    private NativeCustomFormatAd.DisplayOpenMeasurement zzd;

    public zzbyz(zzbnb zzbnb2) {
        Context context;
        Object var4_5;
        block7: {
            this.zzc = new VideoController();
            this.zza = zzbnb2;
            var4_5 = null;
            try {
                context = (Context)ObjectWrapper.unwrap((IObjectWrapper)zzbnb2.zzm());
                break block7;
            }
            catch (RemoteException remoteException) {
            }
            catch (NullPointerException nullPointerException) {
                // empty catch block
            }
            zzcgt.zzg((String)"", (Throwable)zzbnb2);
            context = null;
        }
        zzbnb2 = var4_5;
        if (context != null) {
            zzbnb2 = new MediaView(context);
            try {
                boolean bl = this.zza.zzn(ObjectWrapper.wrap((Object)zzbnb2));
                if (!bl) {
                    zzbnb2 = var4_5;
                }
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"", (Throwable)remoteException);
                zzbnb2 = var4_5;
            }
        }
        this.zzb = zzbnb2;
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

    public final String getCustomFormatId() {
        try {
            String string = this.zza.zzh();
            return string;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return null;
        }
    }

    public final NativeCustomFormatAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzd != null) return this.zzd;
            if (!this.zza.zzo()) return this.zzd;
            zzbys zzbys2 = new zzbys(this.zza);
            this.zzd = zzbys2;
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
            string = new zzbyt((zzbmh)string);
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
}
