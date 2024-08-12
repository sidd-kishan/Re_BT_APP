/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Rational
 *  android.util.Size
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageReaderProxyProvider
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.impl.CaptureBundle
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.CaptureProcessor
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.ImageCaptureConfig
 *  androidx.camera.core.impl.ImageInputConfig
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.ImageOutputConfig$Builder
 *  androidx.camera.core.impl.MutableConfig
 *  androidx.camera.core.impl.MutableOptionsBundle
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$Builder
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.internal.IoConfig$Builder
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.core.util.Consumer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.util.Pair;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageCaptureConfig;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.MutableConfig;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public static final class ImageCapture.Builder
implements UseCaseConfig.Builder<ImageCapture, ImageCaptureConfig, ImageCapture.Builder>,
ImageOutputConfig.Builder<ImageCapture.Builder>,
IoConfig.Builder<ImageCapture.Builder> {
    private final MutableOptionsBundle mMutableConfig;

    public ImageCapture.Builder() {
        this(MutableOptionsBundle.create());
    }

    private ImageCapture.Builder(MutableOptionsBundle object) {
        this.mMutableConfig = object;
        object = (Class)object.retrieveOption(TargetConfig.OPTION_TARGET_CLASS, null);
        if (object != null && !object.equals(ImageCapture.class)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid target class configuration for ");
            stringBuilder.append(this);
            stringBuilder.append(": ");
            stringBuilder.append(object);
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        this.setTargetClass((Class)ImageCapture.class);
    }

    public static ImageCapture.Builder fromConfig(Config config) {
        return new ImageCapture.Builder(MutableOptionsBundle.from((Config)config));
    }

    static ImageCapture.Builder fromConfig(ImageCaptureConfig imageCaptureConfig) {
        return new ImageCapture.Builder(MutableOptionsBundle.from((Config)imageCaptureConfig));
    }

    public ImageCapture build() {
        boolean bl;
        if (this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, null) != null) {
            if (this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, null) != null) throw new IllegalArgumentException("Cannot use both setTargetResolution and setTargetAspectRatio on the same config.");
        }
        Serializable serializable = (Integer)this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, null);
        boolean bl2 = false;
        if (serializable != null) {
            bl = this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null) == null;
            Preconditions.checkArgument((boolean)bl, (Object)"Cannot set buffer format with CaptureProcessor defined.");
            this.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)serializable);
        } else if (this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, null) != null) {
            this.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)35);
        } else {
            this.getMutableConfig().insertOption(ImageInputConfig.OPTION_INPUT_FORMAT, (Object)256);
        }
        serializable = new ImageCapture(this.getUseCaseConfig());
        Size size = (Size)this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, null);
        if (size != null) {
            serializable.setCropAspectRatio(new Rational(size.getWidth(), size.getHeight()));
        }
        bl = bl2;
        if ((Integer)this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, (Object)2) >= 1) {
            bl = true;
        }
        Preconditions.checkArgument((boolean)bl, (Object)"Maximum outstanding image count must be at least 1");
        Preconditions.checkNotNull((Object)((Executor)this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, (Object)CameraXExecutors.ioExecutor())), (Object)"The IO executor can't be null");
        if (!this.getMutableConfig().containsOption(ImageCaptureConfig.OPTION_FLASH_MODE)) return serializable;
        int n = (Integer)this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_FLASH_MODE);
        if (n == 0) return serializable;
        if (n == 1) return serializable;
        if (n == 2) {
            return serializable;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("The flash mode is not allowed to set: ");
        ((StringBuilder)serializable).append(n);
        throw new IllegalArgumentException(((StringBuilder)serializable).toString());
    }

    public MutableConfig getMutableConfig() {
        return this.mMutableConfig;
    }

    public ImageCaptureConfig getUseCaseConfig() {
        return new ImageCaptureConfig(OptionsBundle.from((Config)this.mMutableConfig));
    }

    public ImageCapture.Builder setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
        return this;
    }

    public ImageCapture.Builder setBufferFormat(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_BUFFER_FORMAT, (Object)n);
        return this;
    }

    public ImageCapture.Builder setCameraSelector(CameraSelector cameraSelector) {
        this.getMutableConfig().insertOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, (Object)cameraSelector);
        return this;
    }

    public ImageCapture.Builder setCaptureBundle(CaptureBundle captureBundle) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_BUNDLE, (Object)captureBundle);
        return this;
    }

    public ImageCapture.Builder setCaptureMode(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_CAPTURE_MODE, (Object)n);
        return this;
    }

    public ImageCapture.Builder setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public ImageCapture.Builder setCaptureProcessor(CaptureProcessor captureProcessor) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_CAPTURE_PROCESSOR, (Object)captureProcessor);
        return this;
    }

    public ImageCapture.Builder setDefaultCaptureConfig(CaptureConfig captureConfig) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_CAPTURE_CONFIG, (Object)captureConfig);
        return this;
    }

    public ImageCapture.Builder setDefaultResolution(Size size) {
        this.getMutableConfig().insertOption(ImageOutputConfig.OPTION_DEFAULT_RESOLUTION, (Object)size);
        return this;
    }

    public ImageCapture.Builder setDefaultSessionConfig(SessionConfig sessionConfig) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_DEFAULT_SESSION_CONFIG, (Object)sessionConfig);
        return this;
    }

    public ImageCapture.Builder setFlashMode(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_FLASH_MODE, (Object)n);
        return this;
    }

    public ImageCapture.Builder setImageReaderProxyProvider(ImageReaderProxyProvider imageReaderProxyProvider) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IMAGE_READER_PROXY_PROVIDER, (Object)imageReaderProxyProvider);
        return this;
    }

    public ImageCapture.Builder setIoExecutor(Executor executor) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_IO_EXECUTOR, (Object)executor);
        return this;
    }

    public ImageCapture.Builder setMaxCaptureStages(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_CAPTURE_STAGES, (Object)n);
        return this;
    }

    public ImageCapture.Builder setMaxResolution(Size size) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_MAX_RESOLUTION, (Object)size);
        return this;
    }

    public ImageCapture.Builder setSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SESSION_CONFIG_UNPACKER, (Object)optionUnpacker);
        return this;
    }

    public ImageCapture.Builder setSoftwareJpegEncoderRequested(boolean bl) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_SOFTWARE_JPEG_ENCODER, (Object)bl);
        return this;
    }

    public ImageCapture.Builder setSupportedResolutions(List<Pair<Integer, Size[]>> list) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SUPPORTED_RESOLUTIONS, list);
        return this;
    }

    public ImageCapture.Builder setSurfaceOccupancyPriority(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, (Object)n);
        return this;
    }

    public ImageCapture.Builder setTargetAspectRatio(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ASPECT_RATIO, (Object)n);
        return this;
    }

    public ImageCapture.Builder setTargetClass(Class<ImageCapture> clazz) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_CLASS, clazz);
        if (this.getMutableConfig().retrieveOption(ImageCaptureConfig.OPTION_TARGET_NAME, null) != null) return this;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(clazz.getCanonicalName());
        stringBuilder.append("-");
        stringBuilder.append(UUID.randomUUID());
        this.setTargetName(stringBuilder.toString());
        return this;
    }

    public ImageCapture.Builder setTargetName(String string) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_NAME, (Object)string);
        return this;
    }

    public ImageCapture.Builder setTargetResolution(Size size) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_RESOLUTION, (Object)size);
        return this;
    }

    public ImageCapture.Builder setTargetRotation(int n) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_TARGET_ROTATION, (Object)n);
        return this;
    }

    public ImageCapture.Builder setUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        this.getMutableConfig().insertOption(ImageCaptureConfig.OPTION_USE_CASE_EVENT_CALLBACK, (Object)eventCallback);
        return this;
    }
}
