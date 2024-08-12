/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$TakePictureState
 *  androidx.camera.core.impl.CameraCaptureResult
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$ImageCapture$qxiP_lEMHbynOHrJ3C0Tk0bLYJQ
implements AsyncFunction {
    private final ImageCapture f$0;
    private final ImageCapture.TakePictureState f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$qxiP_lEMHbynOHrJ3C0Tk0bLYJQ(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState) {
        this.f$0 = imageCapture;
        this.f$1 = takePictureState;
    }

    public final ListenableFuture apply(Object object) {
        return this.f$0.lambda$preTakePicture$11$ImageCapture(this.f$1, (CameraCaptureResult)object);
    }
}
