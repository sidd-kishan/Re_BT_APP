/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.util.Size
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.ImageAnalysis
 *  androidx.camera.core.ImageAnalysis$BackpressureStrategy
 *  androidx.camera.core.ImageReaderProxyProvider
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCase$EventCallback
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
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
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.TargetConfig$_CC
 *  androidx.camera.core.internal.ThreadConfig
 *  androidx.camera.core.internal.ThreadConfig$_CC
 *  androidx.camera.core.internal.UseCaseEventConfig
 *  androidx.camera.core.internal.UseCaseEventConfig$_CC
 *  androidx.core.util.Consumer
 */
package androidx.camera.core.impl;

import android.util.Pair;
import android.util.Size;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageReaderProxyProvider;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageOutputConfig;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.ThreadConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public final class ImageAnalysisConfig
implements UseCaseConfig<ImageAnalysis>,
ImageOutputConfig,
ThreadConfig {
    public static final Config.Option<Integer> OPTION_BACKPRESSURE_STRATEGY = Config.Option.create((String)"camerax.core.imageAnalysis.backpressureStrategy", ImageAnalysis.BackpressureStrategy.class);
    public static final Config.Option<Integer> OPTION_IMAGE_QUEUE_DEPTH = Config.Option.create((String)"camerax.core.imageAnalysis.imageQueueDepth", Integer.TYPE);
    public static final Config.Option<ImageReaderProxyProvider> OPTION_IMAGE_READER_PROXY_PROVIDER = Config.Option.create((String)"camerax.core.imageAnalysis.imageReaderProxyProvider", ImageReaderProxyProvider.class);
    private final OptionsBundle mConfig;

    public ImageAnalysisConfig(OptionsBundle optionsBundle) {
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

    public /* synthetic */ Executor getBackgroundExecutor() {
        return ThreadConfig._CC.$default$getBackgroundExecutor((ThreadConfig)this);
    }

    public /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return ThreadConfig._CC.$default$getBackgroundExecutor((ThreadConfig)this, (Executor)executor);
    }

    public int getBackpressureStrategy() {
        return this.retrieveOption(OPTION_BACKPRESSURE_STRATEGY);
    }

    public int getBackpressureStrategy(int n) {
        return this.retrieveOption(OPTION_BACKPRESSURE_STRATEGY, n);
    }

    public /* synthetic */ CameraSelector getCameraSelector() {
        return UseCaseConfig._CC.$default$getCameraSelector((UseCaseConfig)this);
    }

    public /* synthetic */ CameraSelector getCameraSelector(CameraSelector cameraSelector) {
        return UseCaseConfig._CC.$default$getCameraSelector((UseCaseConfig)this, (CameraSelector)cameraSelector);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker() {
        return UseCaseConfig._CC.$default$getCaptureOptionUnpacker((UseCaseConfig)this);
    }

    public /* synthetic */ CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker optionUnpacker) {
        return UseCaseConfig._CC.$default$getCaptureOptionUnpacker((UseCaseConfig)this, (CaptureConfig.OptionUnpacker)optionUnpacker);
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

    public int getImageQueueDepth() {
        return this.retrieveOption(OPTION_IMAGE_QUEUE_DEPTH);
    }

    public int getImageQueueDepth(int n) {
        return this.retrieveOption(OPTION_IMAGE_QUEUE_DEPTH, n);
    }

    public ImageReaderProxyProvider getImageReaderProxyProvider() {
        return this.retrieveOption(OPTION_IMAGE_READER_PROXY_PROVIDER, null);
    }

    public int getInputFormat() {
        return 35;
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

    public /* synthetic */ boolean hasTargetAspectRatio() {
        return ImageOutputConfig._CC.$default$hasTargetAspectRatio((ImageOutputConfig)this);
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
