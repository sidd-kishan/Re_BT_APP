/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.impl.Config$Option
 *  androidx.camera.core.impl.ReadableConfig
 *  androidx.camera.core.impl.UseCaseConfigFactory
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.ReadableConfig;
import androidx.camera.core.impl.UseCaseConfigFactory;

public interface CameraConfig
extends ReadableConfig {
    public static final Config.Option<CameraFilter> OPTION_CAMERA_FILTER = Config.Option.create((String)"camerax.core.camera.cameraFilter", CameraFilter.class);
    public static final Config.Option<UseCaseConfigFactory> OPTION_USECASE_CONFIG_FACTORY = Config.Option.create((String)"camerax.core.camera.useCaseConfigFactory", UseCaseConfigFactory.class);

    public CameraFilter getCameraFilter();

    public UseCaseConfigFactory getUseCaseConfigFactory();
}
