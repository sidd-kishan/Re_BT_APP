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
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
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

public final class VideoCaptureConfig
implements UseCaseConfig<VideoCapture>,
ImageOutputConfig,
ThreadConfig {
    public static final Config.Option<Integer> OPTION_AUDIO_BIT_RATE;
    public static final Config.Option<Integer> OPTION_AUDIO_CHANNEL_COUNT;
    public static final Config.Option<Integer> OPTION_AUDIO_MIN_BUFFER_SIZE;
    public static final Config.Option<Integer> OPTION_AUDIO_RECORD_SOURCE;
    public static final Config.Option<Integer> OPTION_AUDIO_SAMPLE_RATE;
    public static final Config.Option<Integer> OPTION_BIT_RATE;
    public static final Config.Option<Integer> OPTION_INTRA_FRAME_INTERVAL;
    public static final Config.Option<Integer> OPTION_VIDEO_FRAME_RATE;
    private final OptionsBundle mConfig;

    static {
        OPTION_VIDEO_FRAME_RATE = Config.Option.create((String)"camerax.core.videoCapture.recordingFrameRate", Integer.TYPE);
        OPTION_BIT_RATE = Config.Option.create((String)"camerax.core.videoCapture.bitRate", Integer.TYPE);
        OPTION_INTRA_FRAME_INTERVAL = Config.Option.create((String)"camerax.core.videoCapture.intraFrameInterval", Integer.TYPE);
        OPTION_AUDIO_BIT_RATE = Config.Option.create((String)"camerax.core.videoCapture.audioBitRate", Integer.TYPE);
        OPTION_AUDIO_SAMPLE_RATE = Config.Option.create((String)"camerax.core.videoCapture.audioSampleRate", Integer.TYPE);
        OPTION_AUDIO_CHANNEL_COUNT = Config.Option.create((String)"camerax.core.videoCapture.audioChannelCount", Integer.TYPE);
        OPTION_AUDIO_RECORD_SOURCE = Config.Option.create((String)"camerax.core.videoCapture.audioRecordSource", Integer.TYPE);
        OPTION_AUDIO_MIN_BUFFER_SIZE = Config.Option.create((String)"camerax.core.videoCapture.audioMinBufferSize", Integer.TYPE);
    }

    public VideoCaptureConfig(OptionsBundle optionsBundle) {
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

    public int getAudioBitRate() {
        return this.retrieveOption(OPTION_AUDIO_BIT_RATE);
    }

    public int getAudioBitRate(int n) {
        return this.retrieveOption(OPTION_AUDIO_BIT_RATE, n);
    }

    public int getAudioChannelCount() {
        return this.retrieveOption(OPTION_AUDIO_CHANNEL_COUNT);
    }

    public int getAudioChannelCount(int n) {
        return this.retrieveOption(OPTION_AUDIO_CHANNEL_COUNT, n);
    }

    public int getAudioMinBufferSize() {
        return this.retrieveOption(OPTION_AUDIO_MIN_BUFFER_SIZE);
    }

    public int getAudioMinBufferSize(int n) {
        return this.retrieveOption(OPTION_AUDIO_MIN_BUFFER_SIZE, n);
    }

    public int getAudioRecordSource() {
        return this.retrieveOption(OPTION_AUDIO_RECORD_SOURCE);
    }

    public int getAudioRecordSource(int n) {
        return this.retrieveOption(OPTION_AUDIO_RECORD_SOURCE, n);
    }

    public int getAudioSampleRate() {
        return this.retrieveOption(OPTION_AUDIO_SAMPLE_RATE);
    }

    public int getAudioSampleRate(int n) {
        return this.retrieveOption(OPTION_AUDIO_SAMPLE_RATE, n);
    }

    public /* synthetic */ Executor getBackgroundExecutor() {
        return ThreadConfig._CC.$default$getBackgroundExecutor((ThreadConfig)this);
    }

    public /* synthetic */ Executor getBackgroundExecutor(Executor executor) {
        return ThreadConfig._CC.$default$getBackgroundExecutor((ThreadConfig)this, (Executor)executor);
    }

    public int getBitRate() {
        return this.retrieveOption(OPTION_BIT_RATE);
    }

    public int getBitRate(int n) {
        return this.retrieveOption(OPTION_BIT_RATE, n);
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

    public int getIFrameInterval() {
        return this.retrieveOption(OPTION_INTRA_FRAME_INTERVAL);
    }

    public int getIFrameInterval(int n) {
        return this.retrieveOption(OPTION_INTRA_FRAME_INTERVAL, n);
    }

    public int getInputFormat() {
        return 34;
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

    public int getVideoFrameRate() {
        return this.retrieveOption(OPTION_VIDEO_FRAME_RATE);
    }

    public int getVideoFrameRate(int n) {
        return this.retrieveOption(OPTION_VIDEO_FRAME_RATE, n);
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
