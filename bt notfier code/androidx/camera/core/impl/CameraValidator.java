/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraRepository
 *  androidx.camera.core.impl.CameraValidator$CameraIdListIncorrectException
 */
package androidx.camera.core.impl;

import android.content.Context;
import android.os.Build;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraRepository;
import androidx.camera.core.impl.CameraValidator;
import java.io.Serializable;

public final class CameraValidator {
    private static final String TAG = "CameraValidator";

    private CameraValidator() {
    }

    public static void validateCameras(Context object, CameraRepository cameraRepository, CameraSelector cameraSelector) throws CameraIdListIncorrectException {
        Integer n;
        Serializable serializable;
        block8: {
            if (cameraSelector != null) {
                try {
                    serializable = cameraSelector.getLensFacing();
                    n = serializable;
                    if (serializable == null) {
                        Logger.w((String)TAG, (String)"No lens facing info in the availableCamerasSelector, don't verify the camera lens facing.");
                        return;
                    }
                    break block8;
                }
                catch (IllegalStateException illegalStateException) {
                    Logger.e((String)TAG, (String)"Cannot get lens facing from the availableCamerasSelector don't verify the camera lens facing.", (Throwable)illegalStateException);
                    return;
                }
            }
            n = null;
        }
        serializable = new StringBuilder();
        ((StringBuilder)serializable).append("Verifying camera lens facing on ");
        ((StringBuilder)serializable).append(Build.DEVICE);
        ((StringBuilder)serializable).append(", lensFacingInteger: ");
        ((StringBuilder)serializable).append(n);
        Logger.d((String)TAG, (String)((StringBuilder)serializable).toString());
        object = object.getPackageManager();
        try {
            if (object.hasSystemFeature("android.hardware.camera") && (cameraSelector == null || n == 1)) {
                CameraSelector.DEFAULT_BACK_CAMERA.select(cameraRepository.getCameras());
            }
            if (!object.hasSystemFeature("android.hardware.camera.front")) return;
            if (cameraSelector != null) {
                if (n != 0) return;
            }
            CameraSelector.DEFAULT_FRONT_CAMERA.select(cameraRepository.getCameras());
            return;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Camera LensFacing verification failed, existing cameras: ");
            ((StringBuilder)object).append(cameraRepository.getCameras());
            Logger.e((String)TAG, (String)((StringBuilder)object).toString());
            throw new CameraIdListIncorrectException("Expected camera missing from device.", (Throwable)illegalArgumentException);
        }
    }
}
