/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CaptureBundle
 *  androidx.camera.core.impl.CaptureStage
 */
package androidx.camera.core;

import androidx.camera.core.impl.CaptureBundle;
import androidx.camera.core.impl.CaptureStage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

static final class CaptureBundles.CaptureBundleImpl
implements CaptureBundle {
    final List<CaptureStage> mCaptureStageList;

    CaptureBundles.CaptureBundleImpl(List<CaptureStage> list) {
        if (list == null) throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
        if (list.isEmpty()) throw new IllegalArgumentException("Cannot set an empty CaptureStage list.");
        this.mCaptureStageList = Collections.unmodifiableList(new ArrayList<CaptureStage>(list));
    }

    public List<CaptureStage> getCaptureStages() {
        return this.mCaptureStageList;
    }
}
