/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.view.TextureViewImplementation$1
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view;

import android.graphics.SurfaceTexture;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.view.TextureViewImplementation;
import androidx.core.util.Preconditions;

class TextureViewImplementation.1
implements FutureCallback<SurfaceRequest.Result> {
    final TextureViewImplementation.1 this$1;
    final SurfaceTexture val$surfaceTexture;

    TextureViewImplementation.1(TextureViewImplementation.1 var1_1, SurfaceTexture surfaceTexture) {
        this.this$1 = var1_1;
        this.val$surfaceTexture = surfaceTexture;
    }

    public void onFailure(Throwable throwable) {
        throw new IllegalStateException("SurfaceReleaseFuture did not complete nicely.", throwable);
    }

    public void onSuccess(SurfaceRequest.Result result) {
        boolean bl = result.getResultCode() != 3;
        Preconditions.checkState((boolean)bl, (String)"Unexpected result from SurfaceRequest. Surface was provided twice.");
        Logger.d((String)"TextureViewImpl", (String)"SurfaceTexture about to manually be destroyed");
        this.val$surfaceTexture.release();
        if (this.this$1.this$0.mDetachedSurfaceTexture == null) return;
        this.this$1.this$0.mDetachedSurfaceTexture = null;
    }
}
