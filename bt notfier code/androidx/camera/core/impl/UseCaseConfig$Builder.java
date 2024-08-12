/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.ExtendableBuilder
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$OptionUnpacker
 *  androidx.camera.core.impl.SessionConfig
 *  androidx.camera.core.impl.SessionConfig$OptionUnpacker
 *  androidx.camera.core.impl.UseCaseConfig
 *  androidx.camera.core.internal.TargetConfig$Builder
 *  androidx.camera.core.internal.UseCaseEventConfig$Builder
 *  androidx.core.util.Consumer
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExtendableBuilder;
import androidx.camera.core.UseCase;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.internal.TargetConfig;
import androidx.camera.core.internal.UseCaseEventConfig;
import androidx.core.util.Consumer;
import java.util.Collection;

public static interface UseCaseConfig.Builder<T extends UseCase, C extends UseCaseConfig<T>, B>
extends TargetConfig.Builder<T, B>,
ExtendableBuilder<T>,
UseCaseEventConfig.Builder<B> {
    public C getUseCaseConfig();

    public B setAttachedUseCasesUpdateListener(Consumer<Collection<UseCase>> var1);

    public B setCameraSelector(CameraSelector var1);

    public B setCaptureOptionUnpacker(CaptureConfig.OptionUnpacker var1);

    public B setDefaultCaptureConfig(CaptureConfig var1);

    public B setDefaultSessionConfig(SessionConfig var1);

    public B setSessionOptionUnpacker(SessionConfig.OptionUnpacker var1);

    public B setSurfaceOccupancyPriority(int var1);
}
