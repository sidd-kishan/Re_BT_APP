/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Size
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  androidx.camera.core.Logger
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$Result
 *  androidx.camera.view.SurfaceViewImplementation
 *  androidx.camera.view._$$Lambda$SurfaceViewImplementation$SurfaceRequestCallback$81WMgLrawbdolK1M9hchPAqvUhI
 *  androidx.core.content.ContextCompat
 *  androidx.core.util.Consumer
 */
package androidx.camera.view;

import android.content.Context;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.camera.view._$;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;

class SurfaceViewImplementation.SurfaceRequestCallback
implements SurfaceHolder.Callback {
    private Size mCurrentSurfaceSize;
    private SurfaceRequest mSurfaceRequest;
    private Size mTargetSize;
    private boolean mWasSurfaceProvided;
    final SurfaceViewImplementation this$0;

    SurfaceViewImplementation.SurfaceRequestCallback(SurfaceViewImplementation surfaceViewImplementation) {
        this.this$0 = surfaceViewImplementation;
        this.mWasSurfaceProvided = false;
    }

    private boolean canProvideSurface() {
        Size size;
        boolean bl = !this.mWasSurfaceProvided && this.mSurfaceRequest != null && (size = this.mTargetSize) != null && size.equals((Object)this.mCurrentSurfaceSize);
        return bl;
    }

    private void cancelPreviousRequest() {
        if (this.mSurfaceRequest == null) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Request canceled: ");
        stringBuilder.append(this.mSurfaceRequest);
        Logger.d((String)"SurfaceViewImpl", (String)stringBuilder.toString());
        this.mSurfaceRequest.willNotProvideSurface();
    }

    private void invalidateSurface() {
        if (this.mSurfaceRequest == null) return;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Surface invalidated ");
        stringBuilder.append(this.mSurfaceRequest);
        Logger.d((String)"SurfaceViewImpl", (String)stringBuilder.toString());
        this.mSurfaceRequest.getDeferrableSurface().close();
    }

    private boolean tryToComplete() {
        Surface surface = this.this$0.mSurfaceView.getHolder().getSurface();
        if (!this.canProvideSurface()) return false;
        Logger.d((String)"SurfaceViewImpl", (String)"Surface set on Preview.");
        this.mSurfaceRequest.provideSurface(surface, ContextCompat.getMainExecutor((Context)this.this$0.mSurfaceView.getContext()), (Consumer)new _$.Lambda.SurfaceViewImplementation.SurfaceRequestCallback.81WMgLrawbdolK1M9hchPAqvUhI(this));
        this.mWasSurfaceProvided = true;
        this.this$0.onSurfaceProvided();
        return true;
    }

    public /* synthetic */ void lambda$tryToComplete$0$SurfaceViewImplementation$SurfaceRequestCallback(SurfaceRequest.Result result) {
        Logger.d((String)"SurfaceViewImpl", (String)"Safe to release surface.");
        this.this$0.notifySurfaceNotInUse();
    }

    void setSurfaceRequest(SurfaceRequest surfaceRequest) {
        this.cancelPreviousRequest();
        this.mSurfaceRequest = surfaceRequest;
        surfaceRequest = surfaceRequest.getResolution();
        this.mTargetSize = surfaceRequest;
        this.mWasSurfaceProvided = false;
        if (this.tryToComplete()) return;
        Logger.d((String)"SurfaceViewImpl", (String)"Wait for new Surface creation.");
        this.this$0.mSurfaceView.getHolder().setFixedSize(surfaceRequest.getWidth(), surfaceRequest.getHeight());
    }

    public void surfaceChanged(SurfaceHolder object, int n, int n2, int n3) {
        object = new StringBuilder();
        ((StringBuilder)object).append("Surface changed. Size: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append("x");
        ((StringBuilder)object).append(n3);
        Logger.d((String)"SurfaceViewImpl", (String)((StringBuilder)object).toString());
        this.mCurrentSurfaceSize = new Size(n2, n3);
        this.tryToComplete();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Logger.d((String)"SurfaceViewImpl", (String)"Surface created.");
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Logger.d((String)"SurfaceViewImpl", (String)"Surface destroyed.");
        if (this.mWasSurfaceProvided) {
            this.invalidateSurface();
        } else {
            this.cancelPreviousRequest();
        }
        this.mWasSurfaceProvided = false;
        this.mSurfaceRequest = null;
        this.mCurrentSurfaceSize = null;
        this.mTargetSize = null;
    }
}
