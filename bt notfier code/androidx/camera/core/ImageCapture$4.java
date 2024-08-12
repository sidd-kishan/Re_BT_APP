/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$TakePictureState
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 */
package androidx.camera.core;

import androidx.camera.core.ImageCapture;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.concurrent.futures.CallbackToFutureAdapter;

class ImageCapture.4
implements FutureCallback<Void> {
    final ImageCapture this$0;
    final CallbackToFutureAdapter.Completer val$completer;
    final ImageCapture.TakePictureState val$state;

    ImageCapture.4(ImageCapture imageCapture, ImageCapture.TakePictureState takePictureState, CallbackToFutureAdapter.Completer completer) {
        this.this$0 = imageCapture;
        this.val$state = takePictureState;
        this.val$completer = completer;
    }

    public void onFailure(Throwable throwable) {
        this.this$0.postTakePicture(this.val$state);
        this.val$completer.setException(throwable);
    }

    public void onSuccess(Void void_) {
        this.this$0.postTakePicture(this.val$state);
    }
}
