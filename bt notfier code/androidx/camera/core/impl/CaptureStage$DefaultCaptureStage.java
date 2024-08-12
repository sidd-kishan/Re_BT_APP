/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CaptureConfig
 *  androidx.camera.core.impl.CaptureConfig$Builder
 *  androidx.camera.core.impl.CaptureStage
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.CaptureStage;

public static final class CaptureStage.DefaultCaptureStage
implements CaptureStage {
    private final CaptureConfig mCaptureConfig = new CaptureConfig.Builder().build();

    public CaptureConfig getCaptureConfig() {
        return this.mCaptureConfig;
    }

    public int getId() {
        return 0;
    }
}
