/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.view.TextureView$SurfaceTextureListener
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.view.TextureViewImplementation
 *  androidx.core.content.ContextCompat
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.TextureView;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.TextureViewImplementation;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

class TextureViewImplementation.1
implements TextureView.SurfaceTextureListener {
    final TextureViewImplementation this$0;

    TextureViewImplementation.1(TextureViewImplementation textureViewImplementation) {
        this.this$0 = textureViewImplementation;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture object, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("SurfaceTexture available. Size: ");
        stringBuilder.append(n);
        stringBuilder.append("x");
        stringBuilder.append(n2);
        Logger.d((String)"TextureViewImpl", (String)stringBuilder.toString());
        this.this$0.mSurfaceTexture = object;
        if (this.this$0.mSurfaceReleaseFuture != null) {
            Preconditions.checkNotNull((Object)this.this$0.mSurfaceRequest);
            object = new StringBuilder();
            ((StringBuilder)object).append("Surface invalidated ");
            ((StringBuilder)object).append(this.this$0.mSurfaceRequest);
            Logger.d((String)"TextureViewImpl", (String)((StringBuilder)object).toString());
            this.this$0.mSurfaceRequest.getDeferrableSurface().close();
        } else {
            this.this$0.tryToProvidePreviewSurface();
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.this$0.mSurfaceTexture = null;
        if (this.this$0.mSurfaceReleaseFuture != null) {
            Futures.addCallback((ListenableFuture)this.this$0.mSurfaceReleaseFuture, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)ContextCompat.getMainExecutor((Context)this.this$0.mTextureView.getContext()));
            this.this$0.mDetachedSurfaceTexture = surfaceTexture;
            return false;
        }
        Logger.d((String)"TextureViewImpl", (String)"SurfaceTexture about to be destroyed");
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture object, int n, int n2) {
        object = new StringBuilder();
        ((StringBuilder)object).append("SurfaceTexture size changed: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n2);
        Logger.d((String)"TextureViewImpl", (String)((StringBuilder)object).toString());
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        surfaceTexture = this.this$0.mNextFrameCompleter.getAndSet(null);
        if (surfaceTexture == null) return;
        surfaceTexture.set(null);
    }
}
