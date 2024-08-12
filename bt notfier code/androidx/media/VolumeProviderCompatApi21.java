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

class VolumeProviderCompatApi21 {
    private VolumeProviderCompatApi21() {
    }

    public static Object createVolumeProvider(int n, int n2, int n3, Delegate delegate) {
        return new /* Unavailable Anonymous Inner Class!! */;
    }

    public static void setCurrentVolume(Object object, int n) {
        ((VolumeProvider)object).setCurrentVolume(n);
    }
}
