/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Display
 *  androidx.arch.core.util.Function
 *  androidx.camera.core.Camera
 *  androidx.camera.core.CameraInfo
 *  androidx.camera.core.CameraInfoUnavailableException
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.FocusMeteringAction$Builder
 *  androidx.camera.core.ImageAnalysis
 *  androidx.camera.core.ImageAnalysis$Analyzer
 *  androidx.camera.core.ImageAnalysis$Builder
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$Builder
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.Logger
 *  androidx.camera.core.MeteringPoint
 *  androidx.camera.core.MeteringPointFactory
 *  androidx.camera.core.Preview
 *  androidx.camera.core.Preview$Builder
 *  androidx.camera.core.Preview$SurfaceProvider
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.UseCaseGroup
 *  androidx.camera.core.UseCaseGroup$Builder
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.VideoCapture$Builder
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.ViewPort
 *  androidx.camera.core.ZoomState
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.lifecycle.ProcessCameraProvider
 *  androidx.camera.view.CameraController$DisplayRotationListener
 *  androidx.camera.view.ForwardingLiveData
 *  androidx.camera.view.SensorRotationListener
 *  androidx.camera.view._$$Lambda$CameraController$2dQ_Gy8ZeNh5laRN69rrAYUolQg
 *  androidx.camera.view._$$Lambda$CameraController$R5yuSoRWAGX1Z8E19_LL_4Qx0w8
 *  androidx.camera.view._$$Lambda$CameraController$l_HSlFR4puXBnuhCNXpZ33ygiFk
 *  androidx.camera.view.video.OnVideoSavedCallback
 *  androidx.camera.view.video.OutputFileOptions
 *  androidx.core.util.Preconditions
 *  androidx.lifecycle.LiveData
 */
package androidx.camera.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import androidx.arch.core.util.Function;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.UseCaseGroup;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.ViewPort;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraController;
import androidx.camera.view.ForwardingLiveData;
import androidx.camera.view.SensorRotationListener;
import androidx.camera.view._$;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.core.util.Preconditions;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CameraController {
    private static final float AE_SIZE = 0.25f;
    private static final float AF_SIZE = 0.16666667f;
    private static final String CAMERA_NOT_ATTACHED = "Use cases not attached to camera.";
    private static final String CAMERA_NOT_INITIALIZED = "Camera not initialized.";
    public static final int IMAGE_ANALYSIS = 2;
    public static final int IMAGE_CAPTURE = 1;
    private static final String IMAGE_CAPTURE_DISABLED = "ImageCapture disabled.";
    private static final String PREVIEW_VIEW_NOT_ATTACHED = "PreviewView not attached.";
    private static final String TAG = "CameraController";
    public static final int VIDEO_CAPTURE = 4;
    private static final String VIDEO_CAPTURE_DISABLED = "VideoCapture disabled.";
    private ImageAnalysis.Analyzer mAnalysisAnalyzer;
    private Executor mAnalysisExecutor;
    private final Context mAppContext;
    Camera mCamera;
    ProcessCameraProvider mCameraProvider;
    CameraSelector mCameraSelector = CameraSelector.DEFAULT_BACK_CAMERA;
    private final DisplayRotationListener mDisplayRotationListener;
    private int mEnabledUseCases = 3;
    private ImageAnalysis mImageAnalysis;
    final ImageCapture mImageCapture;
    private final ListenableFuture<Void> mInitializationFuture;
    private boolean mPinchToZoomEnabled = true;
    final Preview mPreview;
    Display mPreviewDisplay;
    final SensorRotationListener mSensorRotationListener;
    Preview.SurfaceProvider mSurfaceProvider;
    private boolean mTapToFocusEnabled = true;
    private final ForwardingLiveData<Integer> mTorchState;
    final VideoCapture mVideoCapture;
    final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);
    ViewPort mViewPort;
    private final ForwardingLiveData<ZoomState> mZoomState = new ForwardingLiveData();

    CameraController(Context context) {
        this.mTorchState = new ForwardingLiveData();
        this.mAppContext = context.getApplicationContext();
        this.mPreview = new Preview.Builder().build();
        this.mImageCapture = new ImageCapture.Builder().build();
        this.mImageAnalysis = new ImageAnalysis.Builder().build();
        this.mVideoCapture = new VideoCapture.Builder().build();
        this.mInitializationFuture = Futures.transform((ListenableFuture)ProcessCameraProvider.getInstance((Context)this.mAppContext), (Function)new _$.Lambda.CameraController.l_HSlFR4puXBnuhCNXpZ33ygiFk(this), (Executor)CameraXExecutors.mainThreadExecutor());
        this.mDisplayRotationListener = new DisplayRotationListener(this);
        this.mSensorRotationListener = new /* Unavailable Anonymous Inner Class!! */;
    }

    private DisplayManager getDisplayManager() {
        return (DisplayManager)this.mAppContext.getSystemService("display");
    }

    private boolean isCameraAttached() {
        boolean bl = this.mCamera != null;
        return bl;
    }

    private boolean isCameraInitialized() {
        boolean bl = this.mCameraProvider != null;
        return bl;
    }

    private boolean isPreviewViewAttached() {
        boolean bl = this.mSurfaceProvider != null && this.mViewPort != null && this.mPreviewDisplay != null;
        return bl;
    }

    private boolean isUseCaseEnabled(int n) {
        boolean bl = (n & this.mEnabledUseCases) != 0;
        return bl;
    }

    private boolean isVideoCaptureEnabledInternal() {
        return this.isVideoCaptureEnabled();
    }

    private float speedUpZoomBy2X(float f) {
        if (!(f > 1.0f)) return 1.0f - (1.0f - f) * 2.0f;
        return (f - 1.0f) * 2.0f + 1.0f;
    }

    private void startListeningToRotationEvents() {
        this.getDisplayManager().registerDisplayListener((DisplayManager.DisplayListener)this.mDisplayRotationListener, new Handler(Looper.getMainLooper()));
        if (!this.mSensorRotationListener.canDetectOrientation()) return;
        this.mSensorRotationListener.enable();
    }

    private void stopListeningToRotationEvents() {
        this.getDisplayManager().unregisterDisplayListener((DisplayManager.DisplayListener)this.mDisplayRotationListener);
        this.mSensorRotationListener.disable();
    }

    private void unbindImageAnalysisAndRecreate(int n, int n2) {
        ImageAnalysis imageAnalysis;
        if (this.isCameraInitialized()) {
            this.mCameraProvider.unbind(new UseCase[]{this.mImageAnalysis});
        }
        this.mImageAnalysis = imageAnalysis = new ImageAnalysis.Builder().setBackpressureStrategy(n).setImageQueueDepth(n2).build();
        Executor executor = this.mAnalysisExecutor;
        if (executor == null) return;
        ImageAnalysis.Analyzer analyzer = this.mAnalysisAnalyzer;
        if (analyzer == null) return;
        imageAnalysis.setAnalyzer(executor, analyzer);
    }

    void attachPreviewSurface(Preview.SurfaceProvider surfaceProvider, ViewPort viewPort, Display display) {
        Threads.checkMainThread();
        if (this.mSurfaceProvider != surfaceProvider) {
            this.mSurfaceProvider = surfaceProvider;
            this.mPreview.setSurfaceProvider(surfaceProvider);
        }
        this.mViewPort = viewPort;
        this.mPreviewDisplay = display;
        this.startListeningToRotationEvents();
        this.startCameraAndTrackStates();
    }

    public void clearImageAnalysisAnalyzer() {
        Threads.checkMainThread();
        this.mAnalysisExecutor = null;
        this.mAnalysisAnalyzer = null;
        this.mImageAnalysis.clearAnalyzer();
    }

    void clearPreviewSurface() {
        Threads.checkMainThread();
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider != null) {
            processCameraProvider.unbindAll();
        }
        this.mPreview.setSurfaceProvider(null);
        this.mCamera = null;
        this.mSurfaceProvider = null;
        this.mViewPort = null;
        this.mPreviewDisplay = null;
        this.stopListeningToRotationEvents();
    }

    protected UseCaseGroup createUseCaseGroup() {
        if (!this.isCameraInitialized()) {
            Logger.d((String)TAG, (String)CAMERA_NOT_INITIALIZED);
            return null;
        }
        if (!this.isPreviewViewAttached()) {
            Logger.d((String)TAG, (String)PREVIEW_VIEW_NOT_ATTACHED);
            return null;
        }
        UseCaseGroup.Builder builder = new UseCaseGroup.Builder().addUseCase((UseCase)this.mPreview);
        if (this.isImageCaptureEnabled()) {
            builder.addUseCase((UseCase)this.mImageCapture);
        } else {
            this.mCameraProvider.unbind(new UseCase[]{this.mImageCapture});
        }
        if (this.isImageAnalysisEnabled()) {
            builder.addUseCase((UseCase)this.mImageAnalysis);
        } else {
            this.mCameraProvider.unbind(new UseCase[]{this.mImageAnalysis});
        }
        if (this.isVideoCaptureEnabledInternal()) {
            builder.addUseCase((UseCase)this.mVideoCapture);
        } else {
            this.mCameraProvider.unbind(new UseCase[]{this.mVideoCapture});
        }
        builder.setViewPort(this.mViewPort);
        return builder.build();
    }

    public ListenableFuture<Void> enableTorch(boolean bl) {
        Threads.checkMainThread();
        if (this.isCameraAttached()) return this.mCamera.getCameraControl().enableTorch(bl);
        Logger.w((String)TAG, (String)CAMERA_NOT_ATTACHED);
        return Futures.immediateFuture(null);
    }

    public CameraInfo getCameraInfo() {
        Threads.checkMainThread();
        Object object = this.mCamera;
        object = object == null ? null : object.getCameraInfo();
        return object;
    }

    public CameraSelector getCameraSelector() {
        Threads.checkMainThread();
        return this.mCameraSelector;
    }

    public int getImageAnalysisBackpressureStrategy() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getBackpressureStrategy();
    }

    public int getImageAnalysisImageQueueDepth() {
        Threads.checkMainThread();
        return this.mImageAnalysis.getImageQueueDepth();
    }

    public int getImageCaptureFlashMode() {
        Threads.checkMainThread();
        return this.mImageCapture.getFlashMode();
    }

    public ListenableFuture<Void> getInitializationFuture() {
        return this.mInitializationFuture;
    }

    public LiveData<Integer> getTorchState() {
        Threads.checkMainThread();
        return this.mTorchState;
    }

    public LiveData<ZoomState> getZoomState() {
        Threads.checkMainThread();
        return this.mZoomState;
    }

    public boolean hasCamera(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        Preconditions.checkNotNull((Object)cameraSelector);
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider == null) throw new IllegalStateException("Camera not initialized. Please wait for the initialization future to finish. See #getInitializationFuture().");
        try {
            boolean bl = processCameraProvider.hasCamera(cameraSelector);
            return bl;
        }
        catch (CameraInfoUnavailableException cameraInfoUnavailableException) {
            Logger.w((String)TAG, (String)"Failed to check camera availability", (Throwable)cameraInfoUnavailableException);
            return false;
        }
    }

    public boolean isImageAnalysisEnabled() {
        Threads.checkMainThread();
        return this.isUseCaseEnabled(2);
    }

    public boolean isImageCaptureEnabled() {
        Threads.checkMainThread();
        return this.isUseCaseEnabled(1);
    }

    public boolean isPinchToZoomEnabled() {
        Threads.checkMainThread();
        return this.mPinchToZoomEnabled;
    }

    public boolean isRecording() {
        Threads.checkMainThread();
        return this.mVideoIsRecording.get();
    }

    public boolean isTapToFocusEnabled() {
        Threads.checkMainThread();
        return this.mTapToFocusEnabled;
    }

    public boolean isVideoCaptureEnabled() {
        Threads.checkMainThread();
        return this.isUseCaseEnabled(4);
    }

    public /* synthetic */ Void lambda$new$0$CameraController(ProcessCameraProvider processCameraProvider) {
        this.mCameraProvider = processCameraProvider;
        this.startCameraAndTrackStates();
        return null;
    }

    public /* synthetic */ void lambda$setCameraSelector$2$CameraController(CameraSelector cameraSelector) {
        this.mCameraSelector = cameraSelector;
    }

    public /* synthetic */ void lambda$setEnabledUseCases$1$CameraController(int n) {
        this.mEnabledUseCases = n;
    }

    void onPinchToZoom(float f) {
        if (!this.isCameraAttached()) {
            Logger.w((String)TAG, (String)CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mPinchToZoomEnabled) {
            Logger.d((String)TAG, (String)"Pinch to zoom disabled.");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Pinch to zoom with scale: ");
        stringBuilder.append(f);
        Logger.d((String)TAG, (String)stringBuilder.toString());
        stringBuilder = (ZoomState)this.getZoomState().getValue();
        if (stringBuilder == null) {
            return;
        }
        this.setZoomRatio(Math.min(Math.max(stringBuilder.getZoomRatio() * this.speedUpZoomBy2X(f), stringBuilder.getMinZoomRatio()), stringBuilder.getMaxZoomRatio()));
    }

    void onTapToFocus(MeteringPointFactory meteringPointFactory, float f, float f2) {
        if (!this.isCameraAttached()) {
            Logger.w((String)TAG, (String)CAMERA_NOT_ATTACHED);
            return;
        }
        if (!this.mTapToFocusEnabled) {
            Logger.d((String)TAG, (String)"Tap to focus disabled. ");
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Tap to focus: ");
        stringBuilder.append(f);
        stringBuilder.append(", ");
        stringBuilder.append(f2);
        Logger.d((String)TAG, (String)stringBuilder.toString());
        stringBuilder = meteringPointFactory.createPoint(f, f2, 0.16666667f);
        meteringPointFactory = meteringPointFactory.createPoint(f, f2, 0.25f);
        this.mCamera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder((MeteringPoint)stringBuilder, 1).addPoint((MeteringPoint)meteringPointFactory, 2).build());
    }

    public void setCameraSelector(CameraSelector cameraSelector) {
        Threads.checkMainThread();
        CameraSelector cameraSelector2 = this.mCameraSelector;
        if (cameraSelector2 == cameraSelector) {
            return;
        }
        this.mCameraSelector = cameraSelector;
        cameraSelector = this.mCameraProvider;
        if (cameraSelector == null) {
            return;
        }
        cameraSelector.unbindAll();
        this.startCameraAndTrackStates((Runnable)new _$.Lambda.CameraController.R5yuSoRWAGX1Z8E19_LL_4Qx0w8(this, cameraSelector2));
    }

    public void setEnabledUseCases(int n) {
        Threads.checkMainThread();
        int n2 = this.mEnabledUseCases;
        if (n == n2) {
            return;
        }
        this.mEnabledUseCases = n;
        if (!this.isVideoCaptureEnabled()) {
            this.stopRecording();
        }
        this.startCameraAndTrackStates((Runnable)new _$.Lambda.CameraController.2dQ_Gy8ZeNh5laRN69rrAYUolQg(this, n2));
    }

    public void setImageAnalysisAnalyzer(Executor executor, ImageAnalysis.Analyzer analyzer) {
        Threads.checkMainThread();
        if (this.mAnalysisAnalyzer == analyzer && this.mAnalysisExecutor == executor) {
            return;
        }
        this.mAnalysisExecutor = executor;
        this.mAnalysisAnalyzer = analyzer;
        this.mImageAnalysis.setAnalyzer(executor, analyzer);
    }

    public void setImageAnalysisBackpressureStrategy(int n) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getBackpressureStrategy() == n) {
            return;
        }
        this.unbindImageAnalysisAndRecreate(n, this.mImageAnalysis.getImageQueueDepth());
        this.startCameraAndTrackStates();
    }

    public void setImageAnalysisImageQueueDepth(int n) {
        Threads.checkMainThread();
        if (this.mImageAnalysis.getImageQueueDepth() == n) {
            return;
        }
        this.unbindImageAnalysisAndRecreate(this.mImageAnalysis.getBackpressureStrategy(), n);
        this.startCameraAndTrackStates();
    }

    public void setImageCaptureFlashMode(int n) {
        Threads.checkMainThread();
        this.mImageCapture.setFlashMode(n);
    }

    public ListenableFuture<Void> setLinearZoom(float f) {
        Threads.checkMainThread();
        if (this.isCameraAttached()) return this.mCamera.getCameraControl().setLinearZoom(f);
        Logger.w((String)TAG, (String)CAMERA_NOT_ATTACHED);
        return Futures.immediateFuture(null);
    }

    public void setPinchToZoomEnabled(boolean bl) {
        Threads.checkMainThread();
        this.mPinchToZoomEnabled = bl;
    }

    public void setTapToFocusEnabled(boolean bl) {
        Threads.checkMainThread();
        this.mTapToFocusEnabled = bl;
    }

    public ListenableFuture<Void> setZoomRatio(float f) {
        Threads.checkMainThread();
        if (this.isCameraAttached()) return this.mCamera.getCameraControl().setZoomRatio(f);
        Logger.w((String)TAG, (String)CAMERA_NOT_ATTACHED);
        return Futures.immediateFuture(null);
    }

    abstract Camera startCamera();

    void startCameraAndTrackStates() {
        this.startCameraAndTrackStates(null);
    }

    void startCameraAndTrackStates(Runnable runnable) {
        try {
            this.mCamera = this.startCamera();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            if (runnable == null) throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", illegalArgumentException);
            runnable.run();
            throw new IllegalStateException("The selected camera does not support the enabled use cases. Please disable use case and/or select a different camera. e.g. #setVideoCaptureEnabled(false)", illegalArgumentException);
        }
        if (!this.isCameraAttached()) {
            Logger.d((String)TAG, (String)CAMERA_NOT_ATTACHED);
            return;
        }
        this.mZoomState.setSource(this.mCamera.getCameraInfo().getZoomState());
        this.mTorchState.setSource(this.mCamera.getCameraInfo().getTorchState());
    }

    public void startRecording(OutputFileOptions outputFileOptions, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState((boolean)this.isCameraInitialized(), (String)CAMERA_NOT_INITIALIZED);
        Preconditions.checkState((boolean)this.isVideoCaptureEnabled(), (String)VIDEO_CAPTURE_DISABLED);
        this.mVideoCapture.startRecording(outputFileOptions.toVideoCaptureOutputFileOptions(), executor, (VideoCapture.OnVideoSavedCallback)new /* Unavailable Anonymous Inner Class!! */);
        this.mVideoIsRecording.set(true);
    }

    public void stopRecording() {
        Threads.checkMainThread();
        if (!this.mVideoIsRecording.get()) return;
        this.mVideoCapture.stopRecording();
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState((boolean)this.isCameraInitialized(), (String)CAMERA_NOT_INITIALIZED);
        Preconditions.checkState((boolean)this.isImageCaptureEnabled(), (String)IMAGE_CAPTURE_DISABLED);
        this.updateMirroringFlagInOutputFileOptions(outputFileOptions);
        this.mImageCapture.takePicture(outputFileOptions, executor, onImageSavedCallback);
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        Threads.checkMainThread();
        Preconditions.checkState((boolean)this.isCameraInitialized(), (String)CAMERA_NOT_INITIALIZED);
        Preconditions.checkState((boolean)this.isImageCaptureEnabled(), (String)IMAGE_CAPTURE_DISABLED);
        this.mImageCapture.takePicture(executor, onImageCapturedCallback);
    }

    void updateMirroringFlagInOutputFileOptions(ImageCapture.OutputFileOptions outputFileOptions) {
        if (this.mCameraSelector.getLensFacing() == null) return;
        if (outputFileOptions.getMetadata().isReversedHorizontalSet()) return;
        outputFileOptions = outputFileOptions.getMetadata();
        boolean bl = this.mCameraSelector.getLensFacing() == 0;
        outputFileOptions.setReversedHorizontal(bl);
    }
}
