/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.media.VolumeProviderCompat
 *  androidx.media.VolumeProviderCompatApi21$Delegate
 */
package androidx.media;

import androidx.media.VolumeProviderCompat;
import androidx.media.VolumeProviderCompatApi21;

class VolumeProviderCompat.1
implements VolumeProviderCompatApi21.Delegate {
    final VolumeProviderCompat this$0;

    VolumeProviderCompat.1(VolumeProviderCompat volumeProviderCompat) {
        this.this$0 = volumeProviderCompat;
    }

    public void onAdjustVolume(int n) {
        this.this$0.onAdjustVolume(n);
    }

    public void onSetVolumeTo(int n) {
        this.this$0.onSetVolumeTo(n);
    }
}
