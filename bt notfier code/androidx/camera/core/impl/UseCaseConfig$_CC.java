/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.core.util.Consumer
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.core.util.Consumer;
import java.util.Collection;

public final class UseCaseConfig$_CC {
    public static Consumer<Collection<UseCase>> $default$getAttachedUseCasesUpdateListener(UseCaseConfig useCaseConfig) {
        return (Consumer)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER);
    }

    public static Consumer<Collection<UseCase>> $default$getAttachedUseCasesUpdateListener(UseCaseConfig useCaseConfig, Consumer<Collection<UseCase>> consumer) {
        return (Consumer)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER, consumer);
    }

    public static CameraSelector $default$getCameraSelector(UseCaseConfig useCaseConfig) {
        return (CameraSelector)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR);
    }

    public static CameraSelector $default$getCameraSelector(UseCaseConfig useCaseConfig, CameraSelector cameraSelector) {
        return (CameraSelector)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAMERA_SELECTOR, (Object)cameraSelector);
    }

    public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig useCaseConfig) {
        return (CaptureConfig.OptionUnpacker)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER);
    }

    public static CaptureConfig.OptionUnpacker $default$getCaptureOptionUnpacker(UseCaseConfig useCaseConfig, CaptureConfig.OptionUnpacker optionUnpacker) {
        return (CaptureConfig.OptionUnpacker)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_CAPTURE_CONFIG_UNPACKER, (Object)optionUnpacker);
    }

    public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig useCaseConfig) {
        return (CaptureConfig)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG);
    }

    public static CaptureConfig $default$getDefaultCaptureConfig(UseCaseConfig useCaseConfig, CaptureConfig captureConfig) {
        return (CaptureConfig)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_CAPTURE_CONFIG, (Object)captureConfig);
    }

    public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig useCaseConfig) {
        return (SessionConfig)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG);
    }

    public static SessionConfig $default$getDefaultSessionConfig(UseCaseConfig useCaseConfig, SessionConfig sessionConfig) {
        return (SessionConfig)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_DEFAULT_SESSION_CONFIG, (Object)sessionConfig);
    }

    public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig useCaseConfig) {
        return (SessionConfig.OptionUnpacker)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER);
    }

    public static SessionConfig.OptionUnpacker $default$getSessionOptionUnpacker(UseCaseConfig useCaseConfig, SessionConfig.OptionUnpacker optionUnpacker) {
        return (SessionConfig.OptionUnpacker)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SESSION_CONFIG_UNPACKER, (Object)optionUnpacker);
    }

    public static int $default$getSurfaceOccupancyPriority(UseCaseConfig useCaseConfig) {
        return (Integer)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY);
    }

    public static int $default$getSurfaceOccupancyPriority(UseCaseConfig useCaseConfig, int n) {
        return (Integer)useCaseConfig.retrieveOption(UseCaseConfig.OPTION_SURFACE_OCCUPANCY_PRIORITY, (Object)n);
    }
}
