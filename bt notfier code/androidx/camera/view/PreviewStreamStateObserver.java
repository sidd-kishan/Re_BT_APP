/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.Logger
 *  androidx.camera.core.impl.CameraCaptureCallback
 *  androidx.camera.core.impl.CameraInfoInternal
 *  androidx.camera.core.impl.CameraInternal$State
 *  androidx.camera.core.impl.Observable$Observer
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.AsyncFunction
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.FutureChain
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.view.PreviewView$StreamState
 *  androidx.camera.view.PreviewViewImplementation
 *  androidx.camera.view._$$Lambda$PreviewStreamStateObserver$W_AFYrLTx1dowMs6tBeQNGMvooA
 *  androidx.camera.view._$$Lambda$PreviewStreamStateObserver$Xs_T_8VJ4seWgFRfmLz37L9vi5k
 *  androidx.camera.view._$$Lambda$PreviewStreamStateObserver$e0zfOi9jG0fhpTQVSvkChPeUtgY
 *  androidx.concurrent.futures.CallbackToFutureAdapter
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Completer
 *  androidx.concurrent.futures.CallbackToFutureAdapter$Resolver
 *  androidx.lifecycle.MutableLiveData
 */
package androidx.camera.view;

import androidx.arch.core.util.Function;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.AsyncFunction;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view._$;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.lifecycle.MutableLiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class PreviewStreamStateObserver
implements Observable.Observer<CameraInternal.State> {
    private static final String TAG = "StreamStateObserver";
    private final CameraInfoInternal mCameraInfoInternal;
    ListenableFuture<Void> mFlowFuture;
    private boolean mHasStartedPreviewStreamFlow = false;
    private PreviewView.StreamState mPreviewStreamState;
    private final MutableLiveData<PreviewView.StreamState> mPreviewStreamStateLiveData;
    private final PreviewViewImplementation mPreviewViewImplementation;

    PreviewStreamStateObserver(CameraInfoInternal cameraInfoInternal, MutableLiveData<PreviewView.StreamState> mutableLiveData, PreviewViewImplementation previewViewImplementation) {
        this.mCameraInfoInternal = cameraInfoInternal;
        this.mPreviewStreamStateLiveData = mutableLiveData;
        this.mPreviewViewImplementation = previewViewImplementation;
        synchronized (this) {
            this.mPreviewStreamState = (PreviewView.StreamState)mutableLiveData.getValue();
            return;
        }
    }

    private void cancelFlow() {
        ListenableFuture<Void> listenableFuture = this.mFlowFuture;
        if (listenableFuture == null) return;
        listenableFuture.cancel(false);
        this.mFlowFuture = null;
    }

    private void startPreviewStreamStateFlow(CameraInfo cameraInfo) {
        FutureChain futureChain;
        this.updatePreviewStreamState(PreviewView.StreamState.IDLE);
        ArrayList<CameraCaptureCallback> arrayList = new ArrayList<CameraCaptureCallback>();
        this.mFlowFuture = futureChain = FutureChain.from(this.waitForCaptureResult(cameraInfo, arrayList)).transformAsync((AsyncFunction)new _$.Lambda.PreviewStreamStateObserver.W_AFYrLTx1dowMs6tBeQNGMvooA(this), CameraXExecutors.directExecutor()).transform((Function)new _$.Lambda.PreviewStreamStateObserver.e0zfOi9jG0fhpTQVSvkChPeUtgY(this), CameraXExecutors.directExecutor());
        Futures.addCallback((ListenableFuture)futureChain, (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
    }

    private ListenableFuture<Void> waitForCaptureResult(CameraInfo cameraInfo, List<CameraCaptureCallback> list) {
        return CallbackToFutureAdapter.getFuture((CallbackToFutureAdapter.Resolver)new _$.Lambda.PreviewStreamStateObserver.Xs_T_8VJ4seWgFRfmLz37L9vi5k(this, cameraInfo, list));
    }

    void clear() {
        this.cancelFlow();
    }

    public /* synthetic */ ListenableFuture lambda$startPreviewStreamStateFlow$0$PreviewStreamStateObserver(Void void_) throws Exception {
        return this.mPreviewViewImplementation.waitForNextFrame();
    }

    public /* synthetic */ Void lambda$startPreviewStreamStateFlow$1$PreviewStreamStateObserver(Void void_) {
        this.updatePreviewStreamState(PreviewView.StreamState.STREAMING);
        return null;
    }

    public /* synthetic */ Object lambda$waitForCaptureResult$2$PreviewStreamStateObserver(CameraInfo cameraInfo, List list, CallbackToFutureAdapter.Completer completer) throws Exception {
        completer = new /* Unavailable Anonymous Inner Class!! */;
        list.add(completer);
        ((CameraInfoInternal)cameraInfo).addSessionCaptureCallback(CameraXExecutors.directExecutor(), (CameraCaptureCallback)completer);
        return "waitForCaptureResult";
    }

    public void onError(Throwable throwable) {
        this.clear();
        this.updatePreviewStreamState(PreviewView.StreamState.IDLE);
    }

    public void onNewData(CameraInternal.State state) {
        if (state != CameraInternal.State.CLOSING && state != CameraInternal.State.CLOSED && state != CameraInternal.State.RELEASING && state != CameraInternal.State.RELEASED) {
            if (state != CameraInternal.State.OPENING && state != CameraInternal.State.OPEN) {
                if (state != CameraInternal.State.PENDING_OPEN) return;
            }
            if (this.mHasStartedPreviewStreamFlow) return;
            this.startPreviewStreamStateFlow((CameraInfo)this.mCameraInfoInternal);
            this.mHasStartedPreviewStreamFlow = true;
        } else {
            this.updatePreviewStreamState(PreviewView.StreamState.IDLE);
            if (!this.mHasStartedPreviewStreamFlow) return;
            this.mHasStartedPreviewStreamFlow = false;
            this.cancelFlow();
        }
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void updatePreviewStreamState(PreviewView.StreamState streamState) {
        synchronized (this) {
            if (this.mPreviewStreamState.equals((Object)streamState)) {
                return;
            }
            this.mPreviewStreamState = streamState;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Update Preview stream state to ");
        stringBuilder.append(streamState);
        Logger.d((String)TAG, (String)stringBuilder.toString());
        this.mPreviewStreamStateLiveData.postValue((Object)streamState);
    }
}
