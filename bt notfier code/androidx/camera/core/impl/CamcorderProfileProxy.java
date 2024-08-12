/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.CamcorderProfile
 *  androidx.camera.core.impl.AutoValue_CamcorderProfileProxy
 */
package androidx.camera.core.impl;

import android.media.CamcorderProfile;
import androidx.camera.core.impl.AutoValue_CamcorderProfileProxy;

public abstract class CamcorderProfileProxy {
    public static CamcorderProfileProxy create(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        return new AutoValue_CamcorderProfileProxy(n, n2, n3, n4, n5, n6, n7, n8, n9, n10, n11, n12);
    }

    public static CamcorderProfileProxy fromCamcorderProfile(CamcorderProfile camcorderProfile) {
        return new AutoValue_CamcorderProfileProxy(camcorderProfile.duration, camcorderProfile.quality, camcorderProfile.fileFormat, camcorderProfile.videoCodec, camcorderProfile.videoBitRate, camcorderProfile.videoFrameRate, camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.audioCodec, camcorderProfile.audioBitRate, camcorderProfile.audioSampleRate, camcorderProfile.audioChannels);
    }

    public abstract int getAudioBitRate();

    public abstract int getAudioChannels();

    public abstract int getAudioCodec();

    public abstract int getAudioSampleRate();

    public abstract int getDuration();

    public abstract int getFileFormat();

    public abstract int getQuality();

    public abstract int getVideoBitRate();

    public abstract int getVideoCodec();

    public abstract int getVideoFrameHeight();

    public abstract int getVideoFrameRate();

    public abstract int getVideoFrameWidth();
}
