/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.internal.CameraCaptureResultImageInfo
 */
package androidx.camera.core.impl;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.internal.CameraCaptureResultImageInfo;

public final class CameraCaptureResults {
    private CameraCaptureResults() {
    }

    public static CameraCaptureResult retrieveCameraCaptureResult(ImageInfo imageInfo) {
        if (!(imageInfo instanceof CameraCaptureResultImageInfo)) return null;
        return ((CameraCaptureResultImageInfo)imageInfo).getCameraCaptureResult();
    }
}
