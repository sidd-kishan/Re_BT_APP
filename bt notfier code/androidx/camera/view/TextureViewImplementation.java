/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.TextureView$SurfaceTextureListener
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.view.PreviewTransformation
 *  androidx.camera.view.PreviewViewImplementation
 *  androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener
 *  androidx.camera.view._$$Lambda$K8R1nxorC__fhJS80SsYrGI5qJg
 *  androidx.camera.view._$$Lambda$TextureViewImplementation$Hl0YGRNVRzSkOIexKiob_cdd3zk
 *  androidx.camera.view._$$Lambda$TextureViewImplementation$e4Dscbpskcjz_esSSILSDR5pW44
 *  androidx.camera.view._$$Lambda$TextureViewImplementation$ibNE93jRGx1y4qAjVgRiccRc54U
 *  androidx.camera.view._$$Lambda$TextureViewImplementation$wCD6ilTjRIgpgUn9gSmCeAFq7P4
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.core.content.ContextCompat
 *  androidx.core.util.Consumer
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view._$;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

final class TextureViewImplementation
extends PreviewViewImplementation {
    private static final String TAG = "TextureViewImpl";
    SurfaceTexture mDetachedSurfaceTexture;
    boolean mIsSurfaceTextureDetachedFromView = false;
    AtomicReference<CallbackToFutureAdapter.Completer<Void>> mNextFrameCompleter = new AtomicReference();
    PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    ListenableFuture<SurfaceRequest.Result> mSurfaceReleaseFuture;
    SurfaceRequest mSurfaceRequest;
    SurfaceTexture mSurfaceTexture;
    TextureView mTextureView;

    TextureViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
    }

    private void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (onSurfaceNotInUseListener == null) return;
        onSurfaceNotInUseListener.onSurfaceNotInUse();
        this.mOnSurfaceNotInUseListener = null;
    }

    private void reattachSurfaceTexture() {
        SurfaceTexture surfaceTexture;
        if (!this.mIsSurfaceTextureDetachedFromView) return;
        if (this.mDetachedSurfaceTexture == null) return;
        SurfaceTexture surfaceTexture2 = this.mTextureView.getSurfaceTexture();
        if (surfaceTexture2 == (surfaceTexture = this.mDetachedSurfaceTexture)) return;
        this.mTextureView.setSurfaceTexture(surfaceTexture);
        this.mDetachedSurfaceTexture = null;
        this.mIsSurfaceTextureDetachedFromView = false;
    }

    View getPreview() {
        return this.mTextureView;
    }

    Bitmap getPreviewBitmap() {
        TextureView textureView = this.mTextureView;
        if (textureView == null) return null;
        if (textureView.isAvailable()) return this.mTextureView.getBitmap();
        return null;
    }

    public void initializePreview() {
        TextureView textureView;
        Preconditions.checkNotNull((Object)this.mParent);
        Preconditions.checkNotNull((Object)this.mResolution);
        this.mTextureView = textureView = new TextureView(this.mParent.getContext());
        textureView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mTextureView.setSurfaceTextureListener((TextureView.SurfaceTextureListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mParent.removeAllViews();
        this.mParent.addView((View)this.mTextureView);
    }

    public /* synthetic */ void lambda$onSurfaceRequested$0$TextureViewImplementation(SurfaceRequest surfaceRequest) {
        SurfaceRequest surfaceRequest2 = this.mSurfaceRequest;
        if (surfaceRequest2 != null && surfaceRequest2 == surfaceRequest) {
            this.mSurfaceRequest = null;
            this.mSurfaceReleaseFuture = null;
        }
        this.notifySurfaceNotInUse();
    }

    public /* synthetic */ Object lambda$tryToProvidePreviewSurface$1$TextureViewImplementation(Surface surface, CallbackToFutureAdapter.Completer object) throws Exception {
        Logger.d((String)TAG, (String)"Surface set on Preview.");
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        Executor executor = CameraXExecutors.directExecutor();
        Objects.requireNonNull(object);
        surfaceRequest.provideSurface(surface, executor, (Consumer)new _$.Lambda.K8R1nxorC__fhJS80SsYrGI5qJg((CallbackToFutureAdapter.Completer)object));
        object = new StringBuilder();
        ((StringBuilder)object).append("provideSurface[request=");
        ((StringBuilder)object).append(this.mSurfaceRequest);
        ((StringBuilder)object).append(" surface=");
        ((StringBuilder)object).append(surface);
        ((StringBuilder)object).append("]");
        return ((StringBuilder)object).toString();
    }

    public /* synthetic */ void lambda$tryToProvidePreviewSurface$2$TextureViewImplementation(Surface surface, ListenableFuture listenableFuture, SurfaceRequest surfaceRequest) {
        Logger.d((String)TAG, (String)"Safe to release surface.");
        this.notifySurfaceNotInUse();
        surface.release();
        if (this.mSurfaceReleaseFuture == listenableFuture) {
            this.mSurfaceReleaseFuture = null;
        }
        if (this.mSurfaceRequest != surfaceRequest) return;
        this.mSurfaceRequest = null;
    }

    public /* synthetic */ Object lambda$waitForNextFrame$3$TextureViewImplementation(CallbackToFutureAdapter.Completer completer) throws Exception {
        this.mNextFrameCompleter.set((CallbackToFutureAdapter.Completer<Void>)completer);
        return "textureViewImpl_waitForNextFrame";
    }

    void onAttachedToWindow() {
        this.reattachSurfaceTexture();
    }

    void onDetachedFromWindow() {
        this.mIsSurfaceTextureDetachedFromView = true;
    }

    void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.mResolution = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
        this.initializePreview();
        onSurfaceNotInUseListener = this.mSurfaceRequest;
        if (onSurfaceNotInUseListener != null) {
            onSurfaceNotInUseListener.willNotProvideSurface();
        }
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor((Context)this.mTextureView.getContext()), (Runnable)new _$.Lambda.TextureViewImplementation.ibNE93jRGx1y4qAjVgRiccRc54U(this, surfaceRequest));
        this.tryToProvidePreviewSurface();
    }

    void tryToProvidePreviewSurface() {
        if (this.mResolution == null) return;
        Object object = this.mSurfaceTexture;
        if (object == null) return;
        if (this.mSurfaceRequest == null) return;
        object.setDefaultBufferSize(this.mResolution.getWidth(), this.mResolution.getHeight());
        Surface surface = new Surface(this.mSurfaceTexture);
        SurfaceRequest surfaceRequest = this.mSurfaceRequest;
        this.mSurfaceReleaseFuture = object = CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.TextureViewImplementation.Hl0YGRNVRzSkOIexKiob_cdd3zk(this, surface));
        object.addListener((Runnable)new _$.Lambda.TextureViewImplementation.e4Dscbpskcjz_esSSILSDR5pW44(this, surface, (ListenableFuture)object, surfaceRequest), ContextCompat.getMainExecutor((Context)this.mTextureView.getContext()));
        this.onSurfaceProvided();
    }

    ListenableFuture<Void> waitForNextFrame() {
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.TextureViewImplementation.wCD6ilTjRIgpgUn9gSmCeAFq7P4(this));
    }
}
