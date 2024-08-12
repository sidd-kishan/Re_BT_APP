/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.Config
 *  androidx.camera.core.impl.UseCaseConfigFactory$CaptureType
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;

public interface UseCaseConfigFactory {
    public Config getConfig(CaptureType var1);
}
