/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CamcorderProfileProxy
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CamcorderProfileProxy;

final class AutoValue_CamcorderProfileProxy
extends CamcorderProfileProxy {
    private final int audioBitRate;
    private final int audioChannels;
    private final int audioCodec;
    private final int audioSampleRate;
    private final int duration;
    private final int fileFormat;
    private final int quality;
    private final int videoBitRate;
    private final int videoCodec;
    private final int videoFrameHeight;
    private final int videoFrameRate;
    private final int videoFrameWidth;

    AutoValue_CamcorderProfileProxy(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        this.duration = n;
        this.quality = n2;
        this.fileFormat = n3;
        this.videoCodec = n4;
        this.videoBitRate = n5;
        this.videoFrameRate = n6;
        this.videoFrameWidth = n7;
        this.videoFrameHeight = n8;
        this.audioCodec = n9;
        this.audioBitRate = n10;
        this.audioSampleRate = n11;
        this.audioChannels = n12;
    }

    public boolean equals(Object object) {
        boolean bl = true;
        if (object == this) {
            return true;
        }
        if (!(object instanceof CamcorderProfileProxy)) return false;
        if (this.duration == (object = (CamcorderProfileProxy)object).getDuration() && this.quality == object.getQuality() && this.fileFormat == object.getFileFormat() && this.videoCodec == object.getVideoCodec() && this.videoBitRate == object.getVideoBitRate() && this.videoFrameRate == object.getVideoFrameRate() && this.videoFrameWidth == object.getVideoFrameWidth() && this.videoFrameHeight == object.getVideoFrameHeight() && this.audioCodec == object.getAudioCodec() && this.audioBitRate == object.getAudioBitRate() && this.audioSampleRate == object.getAudioSampleRate() && this.audioChannels == object.getAudioChannels()) return bl;
        bl = false;
        return bl;
    }

    public int getAudioBitRate() {
        return this.audioBitRate;
    }

    public int getAudioChannels() {
        return this.audioChannels;
    }

    public int getAudioCodec() {
        return this.audioCodec;
    }

    public int getAudioSampleRate() {
        return this.audioSampleRate;
    }

    public int getDuration() {
        return this.duration;
    }

    public int getFileFormat() {
        return this.fileFormat;
    }

    public int getQuality() {
        return this.quality;
    }

    public int getVideoBitRate() {
        return this.videoBitRate;
    }

    public int getVideoCodec() {
        return this.videoCodec;
    }

    public int getVideoFrameHeight() {
        return this.videoFrameHeight;
    }

    public int getVideoFrameRate() {
        return this.videoFrameRate;
    }

    public int getVideoFrameWidth() {
        return this.videoFrameWidth;
    }

    public int hashCode() {
        return (((((((((((this.duration ^ 0xF4243) * 1000003 ^ this.quality) * 1000003 ^ this.fileFormat) * 1000003 ^ this.videoCodec) * 1000003 ^ this.videoBitRate) * 1000003 ^ this.videoFrameRate) * 1000003 ^ this.videoFrameWidth) * 1000003 ^ this.videoFrameHeight) * 1000003 ^ this.audioCodec) * 1000003 ^ this.audioBitRate) * 1000003 ^ this.audioSampleRate) * 1000003 ^ this.audioChannels;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CamcorderProfileProxy{duration=");
        stringBuilder.append(this.duration);
        stringBuilder.append(", quality=");
        stringBuilder.append(this.quality);
        stringBuilder.append(", fileFormat=");
        stringBuilder.append(this.fileFormat);
        stringBuilder.append(", videoCodec=");
        stringBuilder.append(this.videoCodec);
        stringBuilder.append(", videoBitRate=");
        stringBuilder.append(this.videoBitRate);
        stringBuilder.append(", videoFrameRate=");
        stringBuilder.append(this.videoFrameRate);
        stringBuilder.append(", videoFrameWidth=");
        stringBuilder.append(this.videoFrameWidth);
        stringBuilder.append(", videoFrameHeight=");
        stringBuilder.append(this.videoFrameHeight);
        stringBuilder.append(", audioCodec=");
        stringBuilder.append(this.audioCodec);
        stringBuilder.append(", audioBitRate=");
        stringBuilder.append(this.audioBitRate);
        stringBuilder.append(", audioSampleRate=");
        stringBuilder.append(this.audioSampleRate);
        stringBuilder.append(", audioChannels=");
        stringBuilder.append(this.audioChannels);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
