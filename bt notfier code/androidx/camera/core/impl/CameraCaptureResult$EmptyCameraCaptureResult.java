/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureMetaData$AeState
 *  androidx.camera.core.impl.CameraCaptureMetaData$AfMode
 *  androidx.camera.core.impl.CameraCaptureMetaData$AfState
 *  androidx.camera.core.impl.CameraCaptureMetaData$AwbState
 *  androidx.camera.core.impl.CameraCaptureMetaData$FlashState
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.CameraCaptureResult$_CC
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

/*
 * Exception performing whole class analysis ignored.
 */
public static final class CameraCaptureResult.EmptyCameraCaptureResult
implements CameraCaptureResult {
    public static CameraCaptureResult create() {
        return new CameraCaptureResult.EmptyCameraCaptureResult();
    }

    public CameraCaptureMetaData.AeState getAeState() {
        return CameraCaptureMetaData.AeState.UNKNOWN;
    }

    public CameraCaptureMetaData.AfMode getAfMode() {
        return CameraCaptureMetaData.AfMode.UNKNOWN;
    }

    public CameraCaptureMetaData.AfState getAfState() {
        return CameraCaptureMetaData.AfState.UNKNOWN;
    }

    public CameraCaptureMetaData.AwbState getAwbState() {
        return CameraCaptureMetaData.AwbState.UNKNOWN;
    }

    public CameraCaptureMetaData.FlashState getFlashState() {
        return CameraCaptureMetaData.FlashState.UNKNOWN;
    }

    public TagBundle getTagBundle() {
        return TagBundle.emptyBundle();
    }

    public long getTimestamp() {
        return -1L;
    }

    public /* synthetic */ void populateExifData(ExifData.Builder builder) {
        CameraCaptureResult._CC.$default$populateExifData((CameraCaptureResult)this, (ExifData.Builder)builder);
    }
}
