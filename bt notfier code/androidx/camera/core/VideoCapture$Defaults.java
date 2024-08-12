/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Size
 *  androidx.camera.core.VideoCapture$Builder
 *  androidx.camera.core.impl.ConfigProvider
 *  androidx.camera.core.impl.VideoCaptureConfig
 */
package androidx.camera.core;

import android.util.Size;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.ConfigProvider;
import androidx.camera.core.impl.VideoCaptureConfig;

public static final class VideoCapture.Defaults
implements ConfigProvider<VideoCaptureConfig> {
    private static final int DEFAULT_ASPECT_RATIO = 1;
    private static final int DEFAULT_AUDIO_BIT_RATE = 64000;
    private static final int DEFAULT_AUDIO_CHANNEL_COUNT = 1;
    private static final int DEFAULT_AUDIO_MIN_BUFFER_SIZE = 1024;
    private static final int DEFAULT_AUDIO_RECORD_SOURCE = 1;
    private static final int DEFAULT_AUDIO_SAMPLE_RATE = 8000;
    private static final int DEFAULT_BIT_RATE = 0x800000;
    private static final VideoCaptureConfig DEFAULT_CONFIG;
    private static final int DEFAULT_INTRA_FRAME_INTERVAL = 1;
    private static final Size DEFAULT_MAX_RESOLUTION;
    private static final int DEFAULT_SURFACE_OCCUPANCY_PRIORITY = 3;
    private static final int DEFAULT_VIDEO_FRAME_RATE = 30;

    static {
        DEFAULT_MAX_RESOLUTION = new Size(1920, 1080);
        DEFAULT_CONFIG = new VideoCapture.Builder().setVideoFrameRate(30).setBitRate(0x800000).setIFrameInterval(1).setAudioBitRate(64000).setAudioSampleRate(8000).setAudioChannelCount(1).setAudioRecordSource(1).setAudioMinBufferSize(1024).setMaxResolution(DEFAULT_MAX_RESOLUTION).setSurfaceOccupancyPriority(3).setTargetAspectRatio(1).getUseCaseConfig();
    }

    public VideoCaptureConfig getConfig() {
        return DEFAULT_CONFIG;
    }
}
