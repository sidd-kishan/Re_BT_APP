/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.RemoteException
 *  com.google.android.gms.ads.VideoController$VideoLifecycleCallbacks
 *  com.google.android.gms.common.internal.Preconditions
 *  com.google.android.gms.internal.ads.zzbhc
 *  com.google.android.gms.internal.ads.zzbhf
 *  com.google.android.gms.internal.ads.zzbir
 *  com.google.android.gms.internal.ads.zzcgt
 */
package com.google.android.gms.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhf;
import com.google.android.gms.internal.ads.zzbir;
import com.google.android.gms.internal.ads.zzcgt;

public final class VideoController {
    public static final int PLAYBACK_STATE_ENDED = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_READY = 5;
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object zza = new Object();
    private zzbhc zzb;
    private VideoLifecycleCallbacks zzc;

    public int getPlaybackState() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) {
                return 0;
            }
            try {
                int n = zzbhc2.zzi();
                return n;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call getPlaybackState on video controller.", (Throwable)remoteException);
                return 0;
            }
        }
    }

    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        Object object = this.zza;
        synchronized (object) {
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzc;
            return videoLifecycleCallbacks;
        }
    }

    public boolean hasVideoContent() {
        Object object = this.zza;
        synchronized (object) {
            boolean bl = this.zzb != null;
            return bl;
        }
    }

    public boolean isClickToExpandEnabled() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) {
                return false;
            }
            try {
                boolean bl = zzbhc2.zzp();
                return bl;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call isClickToExpandEnabled.", (Throwable)remoteException);
                return false;
            }
        }
    }

    public boolean isCustomControlsEnabled() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) {
                return false;
            }
            try {
                boolean bl = zzbhc2.zzn();
                return bl;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call isUsingCustomPlayerControls.", (Throwable)remoteException);
                return false;
            }
        }
    }

    public boolean isMuted() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) {
                return true;
            }
            try {
                boolean bl = zzbhc2.zzh();
                return bl;
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call isMuted on video controller.", (Throwable)remoteException);
                return true;
            }
        }
    }

    public void mute(boolean bl) {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return;
            try {
                zzbhc2.zzg(bl);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call mute on video controller.", (Throwable)remoteException);
            }
            return;
        }
    }

    public void pause() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return;
            try {
                zzbhc2.zzf();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call pause on video controller.", (Throwable)remoteException);
            }
            return;
        }
    }

    public void play() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return;
            try {
                zzbhc2.zze();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call play on video controller.", (Throwable)remoteException);
            }
            return;
        }
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull((Object)videoLifecycleCallbacks, (Object)"VideoLifecycleCallbacks may not be null.");
        Object object = this.zza;
        synchronized (object) {
            this.zzc = videoLifecycleCallbacks;
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return;
            try {
                zzbir zzbir2 = new zzbir(videoLifecycleCallbacks);
                zzbhc2.zzl((zzbhf)zzbir2);
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call setVideoLifecycleCallbacks on video controller.", (Throwable)remoteException);
            }
            return;
        }
    }

    public void stop() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            if (zzbhc2 == null) return;
            try {
                zzbhc2.zzq();
            }
            catch (RemoteException remoteException) {
                zzcgt.zzg((String)"Unable to call stop on video controller.", (Throwable)remoteException);
            }
            return;
        }
    }

    public final void zza(zzbhc zzbhc2) {
        Object object = this.zza;
        synchronized (object) {
            this.zzb = zzbhc2;
            zzbhc2 = this.zzc;
            if (zzbhc2 == null) return;
            this.setVideoLifecycleCallbacks((VideoLifecycleCallbacks)zzbhc2);
            return;
        }
    }

    public final zzbhc zzb() {
        Object object = this.zza;
        synchronized (object) {
            zzbhc zzbhc2 = this.zzb;
            return zzbhc2;
        }
    }
}
