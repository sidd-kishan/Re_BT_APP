/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureCallbacks$ComboCameraCaptureCallback
 *  androidx.camera.core.impl.CameraCaptureCallbacks$NoOpCameraCaptureCallback
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks;
import java.util.Arrays;
import java.util.List;

public final class CameraCaptureCallbacks {
    private CameraCaptureCallbacks() {
    }

    static CameraCaptureCallback createComboCallback(List<CameraCaptureCallback> list) {
        if (list.isEmpty()) {
            return CameraCaptureCallbacks.createNoOpCallback();
        }
        if (list.size() != 1) return new ComboCameraCaptureCallback(list);
        return list.get(0);
    }

    public static CameraCaptureCallback createComboCallback(CameraCaptureCallback ... cameraCaptureCallbackArray) {
        return CameraCaptureCallbacks.createComboCallback(Arrays.asList(cameraCaptureCallbackArray));
    }

    public static CameraCaptureCallback createNoOpCallback() {
        return new NoOpCameraCaptureCallback();
    }
}
