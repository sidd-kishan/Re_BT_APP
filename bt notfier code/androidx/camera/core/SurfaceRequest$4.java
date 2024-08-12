/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$RequestCancelledException
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.core.util.Consumer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.core;

import android.view.Surface;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;

/*
 * Exception performing whole class analysis ignored.
 */
class SurfaceRequest.4
implements FutureCallback<Void> {
    final SurfaceRequest this$0;
    final Consumer val$resultListener;
    final Surface val$surface;

    SurfaceRequest.4(SurfaceRequest surfaceRequest, Consumer consumer, Surface surface) {
        this.this$0 = surfaceRequest;
        this.val$resultListener = consumer;
        this.val$surface = surface;
    }

    public void onFailure(Throwable throwable) {
        boolean bl = throwable instanceof SurfaceRequest.RequestCancelledException;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Camera surface session should only fail with request cancellation. Instead failed due to:\n");
        stringBuilder.append(throwable);
        Preconditions.checkState((boolean)bl, (String)stringBuilder.toString());
        this.val$resultListener.accept((Object)SurfaceRequest.Result.of((int)1, (Surface)this.val$surface));
    }

    public void onSuccess(Void void_) {
        this.val$resultListener.accept((Object)SurfaceRequest.Result.of((int)0, (Surface)this.val$surface));
    }
}
