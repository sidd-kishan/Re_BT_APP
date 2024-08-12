/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.UseCaseConfig;

public static interface CaptureConfig.OptionUnpacker {
    public void unpack(UseCaseConfig<?> var1, CaptureConfig.Builder var2);
}
