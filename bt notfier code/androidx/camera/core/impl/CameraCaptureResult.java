/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureMetaData$AeState
 *  androidx.camera.core.impl.CameraCaptureMetaData$AfMode
 *  androidx.camera.core.impl.CameraCaptureMetaData$AfState
 *  androidx.camera.core.impl.CameraCaptureMetaData$AwbState
 *  androidx.camera.core.impl.CameraCaptureMetaData$FlashState
 *  androidx.camera.core.impl.TagBundle
 *  androidx.camera.core.impl.utils.ExifData$Builder
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.utils.ExifData;

public interface CameraCaptureResult {
    public CameraCaptureMetaData.AeState getAeState();

    public CameraCaptureMetaData.AfMode getAfMode();

    public CameraCaptureMetaData.AfState getAfState();

    public CameraCaptureMetaData.AwbState getAwbState();

    public CameraCaptureMetaData.FlashState getFlashState();

    public TagBundle getTagBundle();

    public long getTimestamp();

    public void populateExifData(ExifData.Builder var1);
}
