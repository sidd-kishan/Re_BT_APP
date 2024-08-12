/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CameraFilter
 *  androidx.camera.core.impl.UseCaseConfigFactory
 */
package androidx.camera.core.impl;

import androidx.camera.core.CameraFilter;
import androidx.camera.core.impl.UseCaseConfigFactory;

public static interface CameraConfig.Builder<B> {
    public B setCameraFilter(CameraFilter var1);

    public B setUseCaseConfigFactory(UseCaseConfigFactory var1);
}
