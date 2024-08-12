/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.ExifData;

public final class CameraCaptureResult$_CC {
    public static void $default$populateExifData(CameraCaptureResult cameraCaptureResult, ExifData.Builder builder) {
        builder.setFlashState(cameraCaptureResult.getFlashState());
    }
}
