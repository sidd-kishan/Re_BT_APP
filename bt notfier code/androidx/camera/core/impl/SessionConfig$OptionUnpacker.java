/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.SessionConfig$Builder
 *  androidx.camera.core.impl.UseCaseConfig
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.UseCaseConfig;

public static interface SessionConfig.OptionUnpacker {
    public void unpack(UseCaseConfig<?> var1, SessionConfig.Builder var2);
}
