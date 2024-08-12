/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.ImageOutputConfig$Builder
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.VideoCaptureConfig
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.ThreadConfig
 *  androidx.camera.core.internal.ThreadConfig$Builder
 *  androidx.camera.core.internal.UseCaseEventConfig
 *  androidx.core.util.Consumer
 */
package androidx.camera.core;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.VideoCaptureConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public static final class VideoCapture.Builder
implements UseCaseConfig.Builder<VideoCapture, VideoCaptureConfig, VideoCapture.Builder>,
ImageOutputConfig.Builder<VideoCapture.Builder>,
ThreadConfig.Builder<VideoCapture.Builder> {
    private final MutableOptionsBundle mMutableConfig;

    public VideoCapture.Builder() {
        this(MutableOptionsBundle.create());
    }

    private VideoCapture.Builder(MutableOptionsBundle object) {
        this.mMutableConfig = object;
        Class clazz = (Class)object.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (clazz != null && !clazz.equals(VideoCapture.class)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid target class configuration for ");
            ((StringBuilder)object).append(this);
            ((StringBuilder)object).append(": ");
            ((StringBuilder)object).append(clazz);
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        this.setTargetClass((Class)VideoCapture.class);
    }

    static VideoCapture.Builder fromConfig(Config config) {
        return new VideoCapture.Builder(MutableOptionsBundle.from((Config)config));
    }

    public static VideoCapture.Builder fromConfig(VideoCaptureConfig videoCaptureConfig) {
        return new VideoCapture.Builder(MutableOptionsBundle.from((Config)videoCaptureConfig));
    }

    public VideoCapture build() {
        if (this.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null) return new VideoCapture(this.getUseCaseConfig());
        if (this.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) != null) throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        return new VideoCapture(this.getUseCaseConfig());
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public VideoCaptureConfig getUseCaseConfig() {
        return new VideoCaptureConfig(OptionsBundle.from((Config)this.mMutableConfig));
    }

    public VideoCapture.Builder setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
        return this;
    }

    public VideoCapture.Builder setAudioBitRate(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_BIT_RATE, (Object)n);
        return this;
    }

    public VideoCapture.Builder setAudioChannelCount(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_CHANNEL_COUNT, (Object)n);
        return this;
    }

    public VideoCapture.Builder setAudioMinBufferSize(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_MIN_BUFFER_SIZE, (Object)n);
        return this;
    }

    public VideoCapture.Builder setAudioRecordSource(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_RECORD_SOURCE, (Object)n);
        return this;
    }

    public VideoCapture.Builder setAudioSampleRate(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_AUDIO_SAMPLE_RATE, (Object)n);
        return this;
    }

    public VideoCapture.Builder setBackgroundExecutor(Executor executor) {
        this.getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, (Object)executor);
        return this;
    }

    public VideoCapture.Builder setBitRate(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_BIT_RATE, (Object)n);
        return this;
    }

    public VideoCapture.Builder setCameraSelector(CameraSelector cameraSelector) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, (Object)cameraSelector);
        return this;
    }

    public VideoCapture.Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public VideoCapture.Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, (Object)captureConfig);
        return this;
    }

    public VideoCapture.Builder setDefaultResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, (Object)size);
        return this;
    }

    public VideoCapture.Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, (Object)sessionConfig);
        return this;
    }

    public VideoCapture.Builder setIFrameInterval(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_INTRA_FRAME_INTERVAL, (Object)n);
        return this;
    }

    public VideoCapture.Builder setMaxResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, (Object)size);
        return this;
    }

    public VideoCapture.Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public VideoCapture.Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
        return this;
    }

    public VideoCapture.Builder setSurfaceOccupancyPriority(int n) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, (Object)n);
        return this;
    }

    public VideoCapture.Builder setTargetAspectRatio(int n) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, (Object)n);
        return this;
    }

    public VideoCapture.Builder setTargetClass(Class<VideoCapture> clazz) {
        this.getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_CLASS, clazz);
        if (this.getMutableConfig().retrieveOption(TargetConfig.OPTION_TARGET_NAME, null) != null) return this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getCanonicalName());
        stringBuilder.append("-");
        stringBuilder.append(UUID.randomUUID());
        this.setTargetName(stringBuilder.toString());
        return this;
    }

    public VideoCapture.Builder setTargetName(String string) {
        this.getMutableConfig().insertOption(TargetConfig.OPTION_TARGET_NAME, (Object)string);
        return this;
    }

    public VideoCapture.Builder setTargetResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, (Object)size);
        return this;
    }

    public VideoCapture.Builder setTargetRotation(int n) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, (Object)n);
        return this;
    }

    public VideoCapture.Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        this.getMutableConfig().insertOption(UseCaseEventConfig.OPTION_USE_CASE_EVENT_CALLBACK, (Object)eventCallback);
        return this;
    }

    public VideoCapture.Builder setVideoFrameRate(int n) {
        this.getMutableConfig().insertOption(VideoCaptureConfig.OPTION_VIDEO_FRAME_RATE, (Object)n);
        return this;
    }
}
