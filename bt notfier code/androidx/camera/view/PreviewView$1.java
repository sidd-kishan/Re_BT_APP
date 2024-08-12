/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.widget.FrameLayout
 *  androidx.camera.core.Logger
 *  androidx.camera.core.Preview$SurfaceProvider
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.SurfaceRequest$TransformationInfo
 *  androidx.camera.core.SurfaceRequest$TransformationInfoListener
 *  androidx.camera.core.impl.CameraInternal
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.view.PreviewStreamStateObserver
 *  androidx.camera.view.PreviewView
 *  androidx.camera.view.PreviewView$ImplementationMode
 *  androidx.camera.view.PreviewView$StreamState
 *  androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener
 *  androidx.camera.view.SurfaceViewImplementation
 *  androidx.camera.view.TextureViewImplementation
 *  androidx.camera.view._$$Lambda$PreviewView$1$1XvBs2i3px62OYclw3Zc4CpIOyM
 *  androidx.camera.view._$$Lambda$PreviewView$1$3YsXKxxMa6O4k_ovRCC9NgcsPak
 *  androidx.camera.view._$$Lambda$PreviewView$1$dkzZ5Z1dLMlKv674CZMfvlMrNGM
 *  androidx.core.content.ContextCompat
 */
package androidx.camera.view;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.SurfaceViewImplementation;
import androidx.camera.view.TextureViewImplementation;
import androidx.camera.view._$;
import androidx.core.content.ContextCompat;

/*
 * Exception performing whole class analysis ignored.
 */
class PreviewView.1
implements Preview.SurfaceProvider {
    final PreviewView this$0;

    PreviewView.1(PreviewView previewView) {
        this.this$0 = previewView;
    }

    public /* synthetic */ void lambda$onSurfaceRequested$0$PreviewView$1(SurfaceRequest surfaceRequest) {
        this.this$0.mSurfaceProvider.onSurfaceRequested(surfaceRequest);
    }

    public /* synthetic */ void lambda$onSurfaceRequested$1$PreviewView$1(CameraInternal cameraInternal, SurfaceRequest surfaceRequest, SurfaceRequest.TransformationInfo transformationInfo) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Preview transformation info updated. ");
        stringBuilder.append(transformationInfo);
        Logger.d((String)"PreviewView", (String)stringBuilder.toString());
        boolean bl = cameraInternal.getCameraInfoInternal().getLensFacing() == 0;
        this.this$0.mPreviewTransform.setTransformationInfo(transformationInfo, surfaceRequest.getResolution(), bl);
        this.this$0.redrawPreview();
    }

    public /* synthetic */ void lambda$onSurfaceRequested$2$PreviewView$1(PreviewStreamStateObserver previewStreamStateObserver, CameraInternal cameraInternal) {
        if (this.this$0.mActiveStreamStateObserver.compareAndSet(previewStreamStateObserver, null)) {
            previewStreamStateObserver.updatePreviewStreamState(PreviewView.StreamState.IDLE);
        }
        previewStreamStateObserver.clear();
        cameraInternal.getCameraState().removeObserver((Observable.Observer)previewStreamStateObserver);
    }

    public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        PreviewView previewView;
        if (!Threads.isMainThread()) {
            ContextCompat.getMainExecutor((Context)this.this$0.getContext()).execute((Runnable)new _$.Lambda.PreviewView.1.1XvBs2i3px62OYclw3Zc4CpIOyM(this, surfaceRequest));
            return;
        }
        Logger.d((String)"PreviewView", (String)"Surface requested by Preview.");
        CameraInternal cameraInternal = surfaceRequest.getCamera();
        surfaceRequest.setTransformationInfoListener(ContextCompat.getMainExecutor((Context)this.this$0.getContext()), (SurfaceRequest.TransformationInfoListener)new _$.Lambda.PreviewView.1.dkzZ5Z1dLMlKv674CZMfvlMrNGM(this, cameraInternal, surfaceRequest));
        PreviewView previewView2 = this.this$0;
        if (PreviewView.shouldUseTextureView((SurfaceRequest)surfaceRequest, (PreviewView.ImplementationMode)previewView2.mImplementationMode)) {
            previewView = this.this$0;
            previewView = new TextureViewImplementation((FrameLayout)previewView, previewView.mPreviewTransform);
        } else {
            previewView = this.this$0;
            previewView = new SurfaceViewImplementation((FrameLayout)previewView, previewView.mPreviewTransform);
        }
        previewView2.mImplementation = previewView;
        previewView = new PreviewStreamStateObserver(cameraInternal.getCameraInfoInternal(), this.this$0.mPreviewStreamStateLiveData, this.this$0.mImplementation);
        this.this$0.mActiveStreamStateObserver.set(previewView);
        cameraInternal.getCameraState().addObserver(ContextCompat.getMainExecutor((Context)this.this$0.getContext()), (Observable.Observer)previewView);
        this.this$0.mImplementation.onSurfaceRequested(surfaceRequest, (PreviewViewImplementation.OnSurfaceNotInUseListener)new _$.Lambda.PreviewView.1.3YsXKxxMa6O4k_ovRCC9NgcsPak(this, (PreviewStreamStateObserver)previewView, cameraInternal));
    }
}
