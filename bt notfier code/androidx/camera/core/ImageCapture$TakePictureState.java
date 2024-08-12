/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.CameraCaptureResult$EmptyCameraCaptureResult
 */
package androidx.camera.core;

import androidx.camera.core.impl.CameraCaptureResult;

static final class ImageCapture.TakePictureState {
    boolean mIsAePrecaptureTriggered = false;
    boolean mIsAfTriggered = false;
    boolean mIsTorchOpened = false;
    CameraCaptureResult mPreCaptureState = CameraCaptureResult.EmptyCameraCaptureResult.create();

    ImageCapture.TakePictureState() {
    }
}
