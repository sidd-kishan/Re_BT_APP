/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.CaptureBundles$CaptureBundleImpl
 *  androidx.camera.core.impl.CaptureBundle
 *  androidx.camera.core.impl.CaptureStage
 *  androidx.camera.core.impl.CaptureStage$DefaultCaptureStage
 */
package androidx.camera.core;

import androidx.camera.core.CaptureBundles;
import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.Arrays;
import java.util.List;

final class CaptureBundles {
    private CaptureBundles() {
    }

    static CaptureBundle createCaptureBundle(List<CaptureStage> list) {
        return new CaptureBundleImpl(list);
    }

    static CaptureBundle createCaptureBundle(CaptureStage ... captureStageArray) {
        return new CaptureBundleImpl(Arrays.asList(captureStageArray));
    }

    static CaptureBundle singleDefaultCaptureBundle() {
        return CaptureBundles.createCaptureBundle(new CaptureStage[]{new CaptureStage.DefaultCaptureStage()});
    }
}
