/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ImageInputConfig
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.internal.TargetConfig
 *  androidx.camera.core.internal.UseCaseEventConfig
 *  androidx.core.util.Consumer
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ImageInputConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.Collection;

public interface UseCaseConfig<T extends UseCase>
extends TargetConfig<T>,
UseCaseEventConfig,
ImageInputConfig {
    public static final Config.Option<Consumer<Collection<UseCase>>> OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER;
    public static final Config.Option<CameraSelector> OPTION_CAMERA_SELECTOR;
    public static final Config.Option<CaptureConfig.OptionUnpacker> OPTION_CAPTURE_CONFIG_UNPACKER;
    public static final Config.Option<CaptureConfig> OPTION_DEFAULT_CAPTURE_CONFIG;
    public static final Config.Option<SessionConfig> OPTION_DEFAULT_SESSION_CONFIG;
    public static final Config.Option<SessionConfig.OptionUnpacker> OPTION_SESSION_CONFIG_UNPACKER;
    public static final Config.Option<Integer> OPTION_SURFACE_OCCUPANCY_PRIORITY;

    static {
        OPTION_DEFAULT_SESSION_CONFIG = Config.Option.create((String)"camerax.core.useCase.defaultSessionConfig", SessionConfig.class);
        OPTION_DEFAULT_CAPTURE_CONFIG = Config.Option.create((String)"camerax.core.useCase.defaultCaptureConfig", CaptureConfig.class);
        OPTION_SESSION_CONFIG_UNPACKER = Config.Option.create((String)"camerax.core.useCase.sessionConfigUnpacker", SessionConfig.OptionUnpacker.class);
        OPTION_CAPTURE_CONFIG_UNPACKER = Config.Option.create((String)"camerax.core.useCase.captureConfigUnpacker", CaptureConfig.OptionUnpacker.class);
        OPTION_SURFACE_OCCUPANCY_PRIORITY = Config.Option.create((String)"camerax.core.useCase.surfaceOccupancyPriority", Integer.TYPE);
        OPTION_CAMERA_SELECTOR = Config.Option.create((String)"camerax.core.useCase.cameraSelector", CameraSelector.class);
        OPTION_ATTACHED_USE_CASES_UPDATE_LISTENER = Config.Option.create((String)"camerax.core.useCase.attachedUseCasesUpdateListener", Consumer.class);
    }

    public Consumer<Collection<UseCase>> getAttachedUseCasesUpdateListener();

    public Consumer<Collection<UseCase>> getAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> var1);

    public CameraSelector getCameraSelector();

    public CameraSelector getCameraSelector(CameraSelector var1);

    public CaptureConfig.OptionUnpacker getCaptureOptionUnpacker();

    public CaptureConfig.OptionUnpacker getCaptureOptionUnpacker(CaptureConfig.OptionUnpacker var1);

    public CaptureConfig getDefaultCaptureConfig();

    public CaptureConfig getDefaultCaptureConfig(CaptureConfig var1);

    public SessionConfig getDefaultSessionConfig();

    public SessionConfig getDefaultSessionConfig(SessionConfig var1);

    public SessionConfig.OptionUnpacker getSessionOptionUnpacker();

    public SessionConfig.OptionUnpacker getSessionOptionUnpacker(SessionConfig.OptionUnpacker var1);

    public int getSurfaceOccupancyPriority();

    public int getSurfaceOccupancyPriority(int var1);
}
