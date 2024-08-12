/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Handler
 *  android.view.PixelCopy
 *  android.view.PixelCopy$OnPixelCopyFinishedListener
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.view.PreviewTransformation
 *  androidx.camera.view.PreviewViewImplementation
 *  androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener
 *  androidx.camera.view.SurfaceViewImplementation$SurfaceRequestCallback
 *  androidx.camera.view._$$Lambda$SurfaceViewImplementation$5eZhJM3kno_gCDPwBLaHikLYv30
 *  androidx.camera.view._$$Lambda$SurfaceViewImplementation$AfczykelZ3G5A9yZzYzRueR5eGc
 *  androidx.camera.view._$$Lambda$z_SNMRjphPUVSN0L2ch7MX_D73Q
 *  androidx.core.content.ContextCompat
 *  androidx.core.util.Preconditions
 */
package androidx.camera.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.view.PixelCopy;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.camera.view._$;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;

final class SurfaceViewImplementation
extends PreviewViewImplementation {
    private static final String TAG = "SurfaceViewImpl";
    private PreviewViewImplementation.OnSurfaceNotInUseListener mOnSurfaceNotInUseListener;
    final SurfaceRequestCallback mSurfaceRequestCallback = new SurfaceRequestCallback(this);
    SurfaceView mSurfaceView;

    SurfaceViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        super(frameLayout, previewTransformation);
    }

    static /* synthetic */ void lambda$getPreviewBitmap$1(int n) {
        if (n == 0) {
            Logger.d((String)TAG, (String)"PreviewView.SurfaceViewImplementation.getBitmap() succeeded");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("PreviewView.SurfaceViewImplementation.getBitmap() failed with error ");
            stringBuilder.append(n);
            Logger.e((String)TAG, (String)stringBuilder.toString());
        }
    }

    View getPreview() {
        return this.mSurfaceView;
    }

    Bitmap getPreviewBitmap() {
        SurfaceView surfaceView = this.mSurfaceView;
        if (surfaceView == null) return null;
        if (surfaceView.getHolder().getSurface() == null) return null;
        if (!this.mSurfaceView.getHolder().getSurface().isValid()) {
            return null;
        }
        surfaceView = Bitmap.createBitmap((int)this.mSurfaceView.getWidth(), (int)this.mSurfaceView.getHeight(), (Bitmap.Config)Bitmap.Config.ARGB_8888);
        PixelCopy.request((SurfaceView)this.mSurfaceView, (Bitmap)surfaceView, (PixelCopy.OnPixelCopyFinishedListener)_$.Lambda.SurfaceViewImplementation.5eZhJM3kno_gCDPwBLaHikLYv30.INSTANCE, (Handler)this.mSurfaceView.getHandler());
        return surfaceView;
    }

    void initializePreview() {
        SurfaceView surfaceView;
        Preconditions.checkNotNull((Object)this.mParent);
        Preconditions.checkNotNull((Object)this.mResolution);
        this.mSurfaceView = surfaceView = new SurfaceView(this.mParent.getContext());
        surfaceView.setLayoutParams((ViewGroup.LayoutParams)new FrameLayout.LayoutParams(this.mResolution.getWidth(), this.mResolution.getHeight()));
        this.mParent.removeAllViews();
        this.mParent.addView((View)this.mSurfaceView);
        this.mSurfaceView.getHolder().addCallback((SurfaceHolder.Callback)this.mSurfaceRequestCallback);
    }

    public /* synthetic */ void lambda$onSurfaceRequested$0$SurfaceViewImplementation(SurfaceRequest surfaceRequest) {
        this.mSurfaceRequestCallback.setSurfaceRequest(surfaceRequest);
    }

    void notifySurfaceNotInUse() {
        PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener = this.mOnSurfaceNotInUseListener;
        if (onSurfaceNotInUseListener == null) return;
        onSurfaceNotInUseListener.onSurfaceNotInUse();
        this.mOnSurfaceNotInUseListener = null;
    }

    void onAttachedToWindow() {
    }

    void onDetachedFromWindow() {
    }

    void onSurfaceRequested(SurfaceRequest surfaceRequest, PreviewViewImplementation.OnSurfaceNotInUseListener onSurfaceNotInUseListener) {
        this.mResolution = surfaceRequest.getResolution();
        this.mOnSurfaceNotInUseListener = onSurfaceNotInUseListener;
        this.initializePreview();
        surfaceRequest.addRequestCancellationListener(ContextCompat.getMainExecutor((Context)this.mSurfaceView.getContext()), (Runnable)new _$.Lambda.z_SNMRjphPUVSN0L2ch7MX_D73Q(this));
        this.mSurfaceView.post((Runnable)new _$.Lambda.SurfaceViewImplementation.AfczykelZ3G5A9yZzYzRueR5eGc(this, surfaceRequest));
    }

    ListenableFuture<Void> waitForNextFrame() {
        return Futures.immediateFuture(null);
    }
}
