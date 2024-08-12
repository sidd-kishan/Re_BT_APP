/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.Preview
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.ImageInfoProcessor
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.ImageOutputConfig$Builder
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.PreviewConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.ThreadConfig$Builder
 *  androidx.core.util.Consumer
 */
package androidx.camera.core;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInfoProcessor;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.PreviewConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.core.util.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public static final class Preview.Builder
implements UseCaseConfig.Builder<Preview, PreviewConfig, Preview.Builder>,
ImageOutputConfig.Builder<Preview.Builder>,
ThreadConfig.Builder<Preview.Builder> {
    private final MutableOptionsBundle mMutableConfig;

    public Preview.Builder() {
        this(MutableOptionsBundle.create());
    }

    private Preview.Builder(MutableOptionsBundle object) {
        this.mMutableConfig = object;
        object = (Class)object.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (object != null && !object.equals(Preview.class)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid target class configuration for ");
            stringBuilder.append(this);
            stringBuilder.append(": ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.setTargetClass((Class)Preview.class);
    }

    static Preview.Builder fromConfig(Config config) {
        return new Preview.Builder(MutableOptionsBundle.from((Config)config));
    }

    public static Preview.Builder fromConfig(PreviewConfig previewConfig) {
        return new Preview.Builder(MutableOptionsBundle.from((Config)previewConfig));
    }

    public Preview build() {
        if (this.getMutableConfig().retrieveOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO, null) == null) return new Preview(this.getUseCaseConfig());
        if (this.getMutableConfig().retrieveOption(PreviewConfig.OPTION_TARGET_RESOLUTION, null) != null) throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        return new Preview(this.getUseCaseConfig());
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public PreviewConfig getUseCaseConfig() {
        return new PreviewConfig(OptionsBundle.from((Config)this.mMutableConfig));
    }

    public Preview.Builder setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
        return this;
    }

    public Preview.Builder setBackgroundExecutor(Executor executor) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_BACKGROUND_EXECUTOR, (Object)executor);
        return this;
    }

    public Preview.Builder setCameraSelector(CameraSelector cameraSelector) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, (Object)cameraSelector);
        return this;
    }

    public Preview.Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_CAPTURE_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public Preview.Builder setCaptureProcessor(CaptureProcessor captureProcessor) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_PREVIEW_CAPTURE_PROCESSOR, (Object)captureProcessor);
        return this;
    }

    public Preview.Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_DEFAULT_CAPTURE_CONFIG, (Object)captureConfig);
        return this;
    }

    public Preview.Builder setDefaultResolution(Size size) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_DEFAULT_RESOLUTION, (Object)size);
        return this;
    }

    public Preview.Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_DEFAULT_SESSION_CONFIG, (Object)sessionConfig);
        return this;
    }

    public Preview.Builder setImageInfoProcessor(ImageInfoProcessor imageInfoProcessor) {
        this.getMutableConfig().insertOption(PreviewConfig.IMAGE_INFO_PROCESSOR, (Object)imageInfoProcessor);
        return this;
    }

    public Preview.Builder setMaxResolution(Size size) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_MAX_RESOLUTION, (Object)size);
        return this;
    }

    public Preview.Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_SESSION_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public Preview.Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
        return this;
    }

    public Preview.Builder setSurfaceOccupancyPriority(int n) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, (Object)n);
        return this;
    }

    public Preview.Builder setTargetAspectRatio(int n) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_ASPECT_RATIO, (Object)n);
        return this;
    }

    public Preview.Builder setTargetClass(Class<Preview> clazz) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_CLASS, clazz);
        if (this.getMutableConfig().retrieveOption(PreviewConfig.OPTION_TARGET_NAME, null) != null) return this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getCanonicalName());
        stringBuilder.append("-");
        stringBuilder.append(UUID.randomUUID());
        this.setTargetName(stringBuilder.toString());
        return this;
    }

    public Preview.Builder setTargetName(String string) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_NAME, (Object)string);
        return this;
    }

    public Preview.Builder setTargetResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_TARGET_RESOLUTION, (Object)size);
        return this;
    }

    public Preview.Builder setTargetRotation(int n) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_TARGET_ROTATION, (Object)n);
        return this;
    }

    public Preview.Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        this.getMutableConfig().insertOption(PreviewConfig.OPTION_USE_CASE_EVENT_CALLBACK, (Object)eventCallback);
        return this;
    }
}
