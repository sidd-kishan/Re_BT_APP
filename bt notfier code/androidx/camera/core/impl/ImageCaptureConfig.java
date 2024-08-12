/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
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
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.Config$OptionMatcher
 *  androidx.camera.core.impl.Config$OptionPriority
 *  androidx.camera.core.impl.ImageOutputConfig
 *  androidx.camera.core.impl.ImageOutputConfig$_CC
 *  androidx.camera.core.impl.OptionsBundle
 *  androidx.camera.core.impl.ReadableConfig
 *  androidx.camera.core.impl.ReadableConfig$_CC
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.impl.UseCaseConfig$_CC
 *  androidx.camera.core.internal.IoConfig
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.TargetConfig$_CC
 *  androidx.camera.core.internal.UseCaseEventConfig
 *  androidx.camera.core.internal.UseCaseEventConfig$_CC
 *  androidx.core.util.Consumer
 */
package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureProcessor;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.IoConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ImageCaptureConfig
implements UseCaseConfig<ImageCapture>,
ImageOutputConfig,
IoConfig {
    public static final Config.Option<Integer> OPTION_BUFFER_FORMAT;
    public static final Config.Option<CaptureBundle> OPTION_CAPTURE_BUNDLE;
    public static final Config.Option<CaptureProcessor> OPTION_CAPTURE_PROCESSOR;
    public static final Config.Option<Integer> OPTION_FLASH_MODE;
    public static final Config.Option<Integer> OPTION_IMAGE_CAPTURE_MODE;
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER;
    public static final Config.Option<Integer> OPTION_MAX_CAPTURE_STAGES;
    public static final Config.Option<Boolean> OPTION_USE_SOFTWARE_JPEG_ENCODER;
    private final OptionsBundle mConfig;

    static {
        OPTION_IMAGE_CAPTURE_MODE = Config.Option.create((String)"camerax.core.imageCapture.captureMode", Integer.TYPE);
        OPTION_FLASH_MODE = Config.Option.create((String)"camerax.core.imageCapture.flashMode", Integer.TYPE);
        OPTION_CAPTURE_BUNDLE = Config.Option.create((String)"camerax.core.imageCapture.captureBundle", CaptureBundle.class);
        OPTION_CAPTURE_PROCESSOR = Config.Option.create((String)"camerax.core.imageCapture.captureProcessor", CaptureProcessor.class);
        OPTION_BUFFER_FORMAT = Config.Option.create((String)"camerax.core.imageCapture.bufferFormat", Integer.class);
        OPTION_MAX_CAPTURE_STAGES = Config.Option.create((String)"camerax.core.imageCapture.maxCaptureStages", Integer.class);
        OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create((String)"camerax.core.imageCapture.imageReaderProxyProvider", ImageReaderProxyProvider.class);
        OPTION_USE_SOFTWARE_JPEG_ENCODER = Config.Option.create((String)"camerax.core.imageCapture.useSoftwareJpegEncoder", Boolean.TYPE);
    }

    public ImageCaptureConfig(OptionsBundle optionsBundle) {
        this.mConfig = optionsBundle;
    }

    public /* synthetic */ boolean containsOption(Config.Option<?> option) {
        return ReadableConfig._CC.$default$containsOption((ReadableConfig)this, option);
    }

    public /* synthetic */ void findOptions(String string, Config.OptionMatcher optionMatcher) {
        ReadableConfig._CC.$default$findOptions((ReadableConfig)this, (String)string, (Config.OptionMatcher)optionMatcher);
    }

    public /* synthetic */ Consumer<Collection<UseCase>> getAttachedUseCasesUpdateListener() {
        return UseCaseConfig._CC.$default$getAttachedUseCasesUpdateListener((UseCaseConfig)this);
    }

    public /* synthetic */ Consumer<Collection<UseCase>> getAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> consumer) {
        return UseCaseConfig._CC.$default$getAttachedUseCasesUpdateListener((UseCaseConfig)this, consumer);
    }

    public Integer getBufferFormat() {
        return this.retrieveOption(OPTION_BUFFER_FORMAT);
    }

    public Integer getBufferFormat(Integer n) {
        return this.retrieveOption(OPTION_BUFFER_FORMAT, n);
    }

    public /* synthetic */ CameraSelector getCameraSelector() {
        return UseCaseConfig._CC.$default$getCameraSelector((UseCaseConfig)this);
    }

    public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
        return UseCaseConfig._CC.$default$getCameraSelector((UseCaseConfig)this, (CameraSelector)cameraSelector);
    }

    public CaptureBundle getCaptureBundle() {
        return this.retrieveOption(OPTION_CAPTURE_BUNDLE);
    }

    public CaptureBundle getCaptureBundle(CaptureBundle captureBundle) {
        return this.retrieveOption(OPTION_CAPTURE_BUNDLE, captureBundle);
    }

    public int getCaptureMode() {
        return this.retrieveOption(OPTION_IMAGE_CAPTURE_MODE);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return UseCaseConfig._CC.$default$getCaptureOptionUnpacker((UseCaseConfig)this);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig._CC.$default$getCaptureOptionUnpacker((UseCaseConfig)this, (CaptureConfig.OptionUnpacker)optionUnpacker);
    }

    public CaptureProcessor getCaptureProcessor() {
        return this.retrieveOption(OPTION_CAPTURE_PROCESSOR);
    }

    public CaptureProcessor getCaptureProcessor(CaptureProcessor captureProcessor) {
        return this.retrieveOption(OPTION_CAPTURE_PROCESSOR, captureProcessor);
    }

    public Config getConfig() {
        return this.mConfig;
    }

    public /* synthetic */ CaptureConfig getDefaultCaptureConfig() {
        return UseCaseConfig._CC.$default$getDefaultCaptureConfig((UseCaseConfig)this);
    }

    public /* synthetic */ CaptureConfig getDefaultCaptureConfig(CaptureConfig captureConfig) {
        return UseCaseConfig._CC.$default$getDefaultCaptureConfig((UseCaseConfig)this, (CaptureConfig)captureConfig);
    }

    public /* synthetic */ Size getDefaultResolution() {
        return ImageOutputConfig._CC.$default$getDefaultResolution((ImageOutputConfig)this);
    }

    public /* synthetic */ Size getDefaultResolution(Size size) {
        return ImageOutputConfig._CC.$default$getDefaultResolution((ImageOutputConfig)this, (Size)size);
    }

    public /* synthetic */ SessionConfig getDefaultSessionConfig() {
        return UseCaseConfig._CC.$default$getDefaultSessionConfig((UseCaseConfig)this);
    }

    public /* synthetic */ SessionConfig getDefaultSessionConfig(SessionConfig sessionConfig) {
        return UseCaseConfig._CC.$default$getDefaultSessionConfig((UseCaseConfig)this, (SessionConfig)sessionConfig);
    }

    public int getFlashMode() {
        return this.retrieveOption(OPTION_FLASH_MODE);
    }

    public int getFlashMode(int n) {
        return this.retrieveOption(OPTION_FLASH_MODE, n);
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.retrieveOption(OPTION_IMAGE_READER_PROXY_PROVIDER, null);
    }

    public int getInputFormat() {
        return (Integer)this.retrieveOption(OPTION_INPUT_FORMAT);
    }

    public Executor getIoExecutor() {
        return (Executor)this.retrieveOption(OPTION_IO_EXECUTOR);
    }

    public Executor getIoExecutor(Executor executor) {
        return this.retrieveOption(OPTION_IO_EXECUTOR, executor);
    }

    public int getMaxCaptureStages() {
        return this.retrieveOption(OPTION_MAX_CAPTURE_STAGES);
    }

    public int getMaxCaptureStages(int n) {
        return this.retrieveOption(OPTION_MAX_CAPTURE_STAGES, n);
    }

    public /* synthetic */ Size getMaxResolution() {
        return ImageOutputConfig._CC.$default$getMaxResolution((ImageOutputConfig)this);
    }

    public /* synthetic */ Size getMaxResolution(Size size) {
        return ImageOutputConfig._CC.$default$getMaxResolution((ImageOutputConfig)this, (Size)size);
    }

    public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option<?> option) {
        return ReadableConfig._CC.$default$getOptionPriority((ReadableConfig)this, option);
    }

    public /* synthetic */ Set<Config.OptionPriority> getPriorities(Config.Option<?> option) {
        return ReadableConfig._CC.$default$getPriorities((ReadableConfig)this, option);
    }

    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker() {
        return UseCaseConfig._CC.$default$getSessionOptionUnpacker((UseCaseConfig)this);
    }

    public /* synthetic */ SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig._CC.$default$getSessionOptionUnpacker((UseCaseConfig)this, (SessionConfig.OptionUnpacker)optionUnpacker);
    }

    public /* synthetic */ List<Pair<Integer, Size[]>> getSupportedResolutions() {
        return ImageOutputConfig._CC.$default$getSupportedResolutions((ImageOutputConfig)this);
    }

    public /* synthetic */ List<Pair<Integer, Size[]>> getSupportedResolutions(List<Pair<Integer, Size[]>> list) {
        return ImageOutputConfig._CC.$default$getSupportedResolutions((ImageOutputConfig)this, list);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority() {
        return UseCaseConfig._CC.$default$getSurfaceOccupancyPriority((UseCaseConfig)this);
    }

    public /* synthetic */ int getSurfaceOccupancyPriority(int n) {
        return UseCaseConfig._CC.$default$getSurfaceOccupancyPriority((UseCaseConfig)this, (int)n);
    }

    public /* synthetic */ int getTargetAspectRatio() {
        return ImageOutputConfig._CC.$default$getTargetAspectRatio((ImageOutputConfig)this);
    }

    public /* synthetic */ Class<T> getTargetClass() {
        return TargetConfig._CC.$default$getTargetClass((TargetConfig)this);
    }

    public /* synthetic */ Class<T> getTargetClass(Class<T> clazz) {
        return TargetConfig._CC.$default$getTargetClass((TargetConfig)this, clazz);
    }

    public /* synthetic */ String getTargetName() {
        return TargetConfig._CC.$default$getTargetName((TargetConfig)this);
    }

    public /* synthetic */ String getTargetName(String string) {
        return TargetConfig._CC.$default$getTargetName((TargetConfig)this, (String)string);
    }

    public /* synthetic */ Size getTargetResolution() {
        return ImageOutputConfig._CC.$default$getTargetResolution((ImageOutputConfig)this);
    }

    public /* synthetic */ Size getTargetResolution(Size size) {
        return ImageOutputConfig._CC.$default$getTargetResolution((ImageOutputConfig)this, (Size)size);
    }

    public /* synthetic */ int getTargetRotation() {
        return ImageOutputConfig._CC.$default$getTargetRotation((ImageOutputConfig)this);
    }

    public /* synthetic */ int getTargetRotation(int n) {
        return ImageOutputConfig._CC.$default$getTargetRotation((ImageOutputConfig)this, (int)n);
    }

    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback() {
        return UseCaseEventConfig._CC.$default$getUseCaseEventCallback((UseCaseEventConfig)this);
    }

    public /* synthetic */ UseCase.EventCallback getUseCaseEventCallback(UseCase.EventCallback eventCallback) {
        return UseCaseEventConfig._CC.$default$getUseCaseEventCallback((UseCaseEventConfig)this, (UseCase.EventCallback)eventCallback);
    }

    public boolean hasCaptureMode() {
        return this.containsOption(OPTION_IMAGE_CAPTURE_MODE);
    }

    public /* synthetic */ boolean hasTargetAspectRatio() {
        return ImageOutputConfig._CC.$default$hasTargetAspectRatio((ImageOutputConfig)this);
    }

    public boolean isSoftwareJpegEncoderRequested() {
        return this.retrieveOption(OPTION_USE_SOFTWARE_JPEG_ENCODER, false);
    }

    public /* synthetic */ Set<Config.Option<?>> listOptions() {
        return ReadableConfig._CC.$default$listOptions((ReadableConfig)this);
    }

    public /* synthetic */ <ValueT> ValueT retrieveOption(Config.Option<ValueT> option) {
        return (ValueT)ReadableConfig._CC.$default$retrieveOption((ReadableConfig)this, option);
    }

    public /* synthetic */ <ValueT> ValueT retrieveOption(Config.Option<ValueT> option, ValueT ValueT) {
        return (ValueT)ReadableConfig._CC.$default$retrieveOption((ReadableConfig)this, option, ValueT);
    }

    public /* synthetic */ <ValueT> ValueT retrieveOptionWithPriority(Config.Option<ValueT> option, Config.OptionPriority optionPriority) {
        return (ValueT)ReadableConfig._CC.$default$retrieveOptionWithPriority((ReadableConfig)this, option, (Config.OptionPriority)optionPriority);
    }
}
