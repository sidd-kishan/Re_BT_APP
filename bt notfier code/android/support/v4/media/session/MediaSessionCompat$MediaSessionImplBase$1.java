/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.support.v4.media.session.MediaSessionCompat$MediaSessionImplBase
 *  android.support.v4.media.session.ParcelableVolumeInfo
 *  androidx.media.VolumeProviderCompat
 *  androidx.media.VolumeProviderCompat$Callback
 */
package android.support.v4.media.session;

import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import androidx.media.VolumeProviderCompat;

class MediaSessionCompat.MediaSessionImplBase.1
extends VolumeProviderCompat.Callback {
    final MediaSessionCompat.MediaSessionImplBase this$0;

    MediaSessionCompat.MediaSessionImplBase.1(MediaSessionCompat.MediaSessionImplBase mediaSessionImplBase) {
        this.this$0 = mediaSessionImplBase;
    }

    public void onVolumeChanged(VolumeProviderCompat volumeProviderCompat) {
        if (this.this$0.mVolumeProvider != volumeProviderCompat) {
            return;
        }
        volumeProviderCompat = new ParcelableVolumeInfo(this.this$0.mVolumeType, this.this$0.mLocalStream, volumeProviderCompat.getVolumeControl(), volumeProviderCompat.getMaxVolume(), volumeProviderCompat.getCurrentVolume());
        this.this$0.sendVolumeInfoChanged((ParcelableVolumeInfo)volumeProviderCompat);
    }
}
