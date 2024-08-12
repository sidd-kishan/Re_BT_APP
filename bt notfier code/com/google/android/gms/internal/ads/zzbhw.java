/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.RemoteException
 *  com.google.android.gms.ads.MediaContent
 *  com.google.android.gms.ads.VideoController
 *  com.google.android.gms.dynamic.IObjectWrapper
 *  com.google.android.gms.dynamic.ObjectWrapper
 *  com.google.android.gms.internal.ads.zzbme
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzcgt;

public final class zzbhw
implements MediaContent {
    private final zzbme zza;
    private final VideoController zzb = new VideoController();

    public zzbhw(zzbme zzbme2) {
        this.zza = zzbme2;
    }

    public final float getAspectRatio() {
        try {
            float f = this.zza.zze();
            return f;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return 0.0f;
        }
    }

    public final float getCurrentTime() {
        try {
            float f = this.zza.zzi();
            return f;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return 0.0f;
        }
    }

    public final float getDuration() {
        try {
            float f = this.zza.zzh();
            return f;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return 0.0f;
        }
    }

    public final Drawable getMainImage() {
        try {
            IObjectWrapper iObjectWrapper = this.zza.zzg();
            if (iObjectWrapper == null) return null;
            iObjectWrapper = (Drawable)ObjectWrapper.unwrap((IObjectWrapper)iObjectWrapper);
            return iObjectWrapper;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
        }
        return null;
    }

    public final VideoController getVideoController() {
        try {
            if (this.zza.zzj() == null) return this.zzb;
            this.zzb.zza(this.zza.zzj());
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"Exception occurred while getting video controller", (Throwable)remoteException);
        }
        return this.zzb;
    }

    public final boolean hasVideoContent() {
        try {
            boolean bl = this.zza.zzk();
            return bl;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return false;
        }
    }

    public final void setMainImage(Drawable drawable) {
        try {
            this.zza.zzf(ObjectWrapper.wrap((Object)drawable));
            return;
        }
        catch (RemoteException remoteException) {
            zzcgt.zzg((String)"", (Throwable)remoteException);
            return;
        }
    }

    public final zzbme zza() {
        return this.zza;
    }
}
