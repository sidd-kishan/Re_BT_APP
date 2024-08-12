/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.ImageAnalysis
 *  androidx.camera.core.ImageReaderProxyProvider
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.ImageAnalysisConfig
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.ImageOutputConfig$Builder
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.ThreadConfig
 *  androidx.camera.core.internal.ThreadConfig$Builder
 *  androidx.core.util.Consumer
 */
package androidx.camera.core;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageAnalysisConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.core.util.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public static final class ImageAnalysis.Builder
implements ImageOutputConfig.Builder<ImageAnalysis.Builder>,
ThreadConfig.Builder<ImageAnalysis.Builder>,
UseCaseConfig.Builder<ImageAnalysis, ImageAnalysisConfig, ImageAnalysis.Builder> {
    private final MutableOptionsBundle mMutableConfig;

    public ImageAnalysis.Builder() {
        this(MutableOptionsBundle.create());
    }

    private ImageAnalysis.Builder(MutableOptionsBundle object) {
        this.mMutableConfig = object;
        object = (Class)object.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (object != null && !object.equals(ImageAnalysis.class)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid target class configuration for ");
            stringBuilder.append(this);
            stringBuilder.append(": ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.setTargetClass((Class)ImageAnalysis.class);
    }

    static ImageAnalysis.Builder fromConfig(Config config) {
        return new ImageAnalysis.Builder(MutableOptionsBundle.from((Config)config));
    }

    public static ImageAnalysis.Builder fromConfig(ImageAnalysisConfig imageAnalysisConfig) {
        return new ImageAnalysis.Builder(MutableOptionsBundle.from((Config)imageAnalysisConfig));
    }

    public ImageAnalysis build() {
        if (this.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, null) == null) return new ImageAnalysis(this.getUseCaseConfig());
        if (this.getMutableConfig().retrieveOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, null) != null) throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        return new ImageAnalysis(this.getUseCaseConfig());
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public ImageAnalysisConfig getUseCaseConfig() {
        return new ImageAnalysisConfig(OptionsBundle.from((Config)this.mMutableConfig));
    }

    public ImageAnalysis.Builder setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
        return this;
    }

    public ImageAnalysis.Builder setBackgroundExecutor(Executor executor) {
        this.getMutableConfig().insertOption(ThreadConfig.OPTION_BACKGROUND_EXECUTOR, (Object)executor);
        return this;
    }

    public ImageAnalysis.Builder setBackpressureStrategy(int n) {
        this.getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_BACKPRESSURE_STRATEGY, (Object)n);
        return this;
    }

    public ImageAnalysis.Builder setCameraSelector(CameraSelector cameraSelector) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, (Object)cameraSelector);
        return this;
    }

    public ImageAnalysis.Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public ImageAnalysis.Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, (Object)captureConfig);
        return this;
    }

    public ImageAnalysis.Builder setDefaultResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, (Object)size);
        return this;
    }

    public ImageAnalysis.Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, (Object)sessionConfig);
        return this;
    }

    public ImageAnalysis.Builder setImageQueueDepth(int n) {
        this.getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_QUEUE_DEPTH, (Object)n);
        return this;
    }

    public ImageAnalysis.Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
        this.getMutableConfig().insertOption(ImageAnalysisConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, (Object)imageReaderProxyProvider);
        return this;
    }

    public ImageAnalysis.Builder setMaxResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_MAX_RESOLUTION, (Object)size);
        return this;
    }

    public ImageAnalysis.Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public ImageAnalysis.Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
        return this;
    }

    public ImageAnalysis.Builder setSurfaceOccupancyPriority(int n) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, (Object)n);
        return this;
    }

    public ImageAnalysis.Builder setTargetAspectRatio(int n) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ASPECT_RATIO, (Object)n);
        return this;
    }

    public ImageAnalysis.Builder setTargetClass(Class<ImageAnalysis> clazz) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_CLASS, clazz);
        if (this.getMutableConfig().retrieveOption(UseCaseConfig.OPTION_TARGET_NAME, null) != null) return this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getCanonicalName());
        stringBuilder.append("-");
        stringBuilder.append(UUID.randomUUID());
        this.setTargetName(stringBuilder.toString());
        return this;
    }

    public ImageAnalysis.Builder setTargetName(String string) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_TARGET_NAME, (Object)string);
        return this;
    }

    public ImageAnalysis.Builder setTargetResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, (Object)size);
        return this;
    }

    public ImageAnalysis.Builder setTargetRotation(int n) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_ROTATION, (Object)n);
        return this;
    }

    public ImageAnalysis.Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_USE_CASE_EVENT_CALLBACK, (Object)eventCallback);
        return this;
    }
}
