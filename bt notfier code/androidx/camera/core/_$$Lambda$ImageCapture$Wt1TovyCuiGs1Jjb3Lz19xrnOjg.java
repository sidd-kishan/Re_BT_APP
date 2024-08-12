/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$TakePictureState
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public final class _$$Lambda$ImageCapture$Wt1TovyCuiGs1Jjb3Lz19xrnOjg
implements AsyncFunction {
    private final ImageCapture f$0;
    private final ImageCapture.TakePictureState f$1;

    public /* synthetic */ _$$Lambda$ImageCapture$Wt1TovyCuiGs1Jjb3Lz19xrnOjg(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState) {
        this.f$0 = imageCapture;
        this.f$1 = takePictureState;
    }

    public final ListenableFuture apply(Object object) {
        return this.f$0.lambda$preTakePicture$12$ImageCapture(this.f$1, (Void)object);
    }
}
