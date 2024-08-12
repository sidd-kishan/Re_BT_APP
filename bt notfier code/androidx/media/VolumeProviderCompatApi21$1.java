/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.VolumeProvider
 *  androidx.media.VolumeProviderCompatApi21$Delegate
 */
package androidx.media;

import android.media.VolumeProvider;
import androidx.media.VolumeProviderCompatApi21;

static final class VolumeProviderCompatApi21.1
extends VolumeProvider {
    final VolumeProviderCompatApi21.Delegate val$delegate;

    VolumeProviderCompatApi21.1(int n, int n2, int n3, VolumeProviderCompatApi21.Delegate delegate) {
        this.val$delegate = delegate;
        super(n, n2, n3);
    }

    public void onAdjustVolume(int n) {
        this.val$delegate.onAdjustVolume(n);
    }

    public void onSetVolumeTo(int n) {
        this.val$delegate.onSetVolumeTo(n);
    }
}
