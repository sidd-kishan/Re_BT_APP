/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageInfo
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core.internal;

import androidx.camera.core.ImageInfo;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

public final class CameraCaptureResultImageInfo
implements ImageInfo {
    private final CameraCaptureResult mCameraCaptureResult;

    public CameraCaptureResultImageInfo(CameraCaptureResult cameraCaptureResult) {
        this.mCameraCaptureResult = cameraCaptureResult;
    }

    public CameraCaptureResult getCameraCaptureResult() {
        return this.mCameraCaptureResult;
    }

    public int getRotationDegrees() {
        return 0;
    }

    public TagBundle getTagBundle() {
        return this.mCameraCaptureResult.getTagBundle();
    }

    public long getTimestamp() {
        return this.mCameraCaptureResult.getTimestamp();
    }

    public void populateExifData(ExifData.Builder builder) {
        this.mCameraCaptureResult.populateExifData(builder);
    }
}
