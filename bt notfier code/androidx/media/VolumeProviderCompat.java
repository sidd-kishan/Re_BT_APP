/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  androidx.media.VolumeProviderCompat$Callback
 *  androidx.media.VolumeProviderCompatApi21
 *  androidx.media.VolumeProviderCompatApi21$Delegate
 */
package androidx.media;

import android.os.Build;
import androidx.media.VolumeProviderCompat;
import androidx.media.VolumeProviderCompatApi21;

public abstract class VolumeProviderCompat {
    public static final int VOLUME_CONTROL_ABSOLUTE = 2;
    public static final int VOLUME_CONTROL_FIXED = 0;
    public static final int VOLUME_CONTROL_RELATIVE = 1;
    private Callback mCallback;
    private final int mControlType;
    private int mCurrentVolume;
    private final int mMaxVolume;
    private Object mVolumeProviderObj;

    public VolumeProviderCompat(int n, int n2, int n3) {
        this.mControlType = n;
        this.mMaxVolume = n2;
        this.mCurrentVolume = n3;
    }

    public final int getCurrentVolume() {
        return this.mCurrentVolume;
    }

    public final int getMaxVolume() {
        return this.mMaxVolume;
    }

    public final int getVolumeControl() {
        return this.mControlType;
    }

    public Object getVolumeProvider() {
        if (this.mVolumeProviderObj != null) return this.mVolumeProviderObj;
        if (Build.VERSION.SDK_INT < 21) return this.mVolumeProviderObj;
        this.mVolumeProviderObj = VolumeProviderCompatApi21.createVolumeProvider((int)this.mControlType, (int)this.mMaxVolume, (int)this.mCurrentVolume, (VolumeProviderCompatApi21.Delegate)new /* Unavailable Anonymous Inner Class!! */);
        return this.mVolumeProviderObj;
    }

    public void onAdjustVolume(int n) {
    }

    public void onSetVolumeTo(int n) {
    }

    public void setCallback(Callback callback) {
        this.mCallback = callback;
    }

    public final void setCurrentVolume(int n) {
        this.mCurrentVolume = n;
        Object object = this.getVolumeProvider();
        if (object != null && Build.VERSION.SDK_INT >= 21) {
            VolumeProviderCompatApi21.setCurrentVolume((Object)object, (int)n);
        }
        if ((object = this.mCallback) == null) return;
        object.onVolumeChanged(this);
    }
}
