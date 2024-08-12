/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Rational
 *  android.util.Size
 *  androidx.camera.core.Camera
 *  androidx.camera.core.CameraInfoUnavailableException
 *  androidx.camera.core.CameraSelector
 *  androidx.camera.core.CameraSelector$Builder
 *  androidx.camera.core.ImageCapture
 *  androidx.camera.core.ImageCapture$Builder
 *  androidx.camera.core.ImageCapture$Metadata
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.Logger
 *  androidx.camera.core.Preview
 *  androidx.camera.core.Preview$Builder
 *  androidx.camera.core.UseCase
 *  androidx.camera.core.VideoCapture
 *  androidx.camera.core.VideoCapture$Builder
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.VideoCapture$OutputFileOptions
 *  androidx.camera.core.ZoomState
 *  androidx.camera.core.impl.LensFacingConverter
 *  androidx.camera.core.impl.utils.CameraOrientationUtil
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.lifecycle.ProcessCameraProvider
 *  androidx.camera.view.CameraView
 *  androidx.camera.view.CameraView$CaptureMode
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleObserver
 *  androidx.lifecycle.LifecycleOwner
 */
package androidx.camera.view;

import android.content.Context;
import android.util.Rational;
import android.util.Size;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraInfoUnavailableException;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.ZoomState;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.CameraOrientationUtil;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.CameraView;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

@Deprecated
final class CameraXModule {
    private static final Rational ASPECT_RATIO_16_9 = new Rational(16, 9);
    private static final Rational ASPECT_RATIO_3_4;
    private static final Rational ASPECT_RATIO_4_3;
    private static final Rational ASPECT_RATIO_9_16;
    public static final String TAG = "CameraXModule";
    private static final float UNITY_ZOOM_SCALE = 1.0f;
    private static final float ZOOM_NOT_SUPPORTED = 1.0f;
    Camera mCamera;
    Integer mCameraLensFacing = 1;
    ProcessCameraProvider mCameraProvider;
    private final CameraView mCameraView;
    private CameraView.CaptureMode mCaptureMode;
    LifecycleOwner mCurrentLifecycle;
    private final LifecycleObserver mCurrentLifecycleObserver;
    private int mFlash = 2;
    private ImageCapture mImageCapture;
    private final ImageCapture.Builder mImageCaptureBuilder;
    private long mMaxVideoDuration = -1L;
    private long mMaxVideoSize = -1L;
    private LifecycleOwner mNewLifecycle;
    Preview mPreview;
    private final Preview.Builder mPreviewBuilder;
    private VideoCapture mVideoCapture;
    private final VideoCapture.Builder mVideoCaptureBuilder;
    final AtomicBoolean mVideoIsRecording = new AtomicBoolean(false);

    static {
        ASPECT_RATIO_4_3 = new Rational(4, 3);
        ASPECT_RATIO_9_16 = new Rational(9, 16);
        ASPECT_RATIO_3_4 = new Rational(3, 4);
    }

    CameraXModule(CameraView cameraView) {
        this.mCaptureMode = CameraView.CaptureMode.IMAGE;
        this.mCurrentLifecycleObserver = new /* Unavailable Anonymous Inner Class!! */;
        this.mCameraView = cameraView;
        Futures.addCallback((ListenableFuture)ProcessCameraProvider.getInstance((Context)cameraView.getContext()), (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.mainThreadExecutor());
        this.mPreviewBuilder = new Preview.Builder().setTargetName("Preview");
        this.mImageCaptureBuilder = new ImageCapture.Builder().setTargetName("ImageCapture");
        this.mVideoCaptureBuilder = new VideoCapture.Builder().setTargetName("VideoCapture");
    }

    private Set<Integer> getAvailableCameraLensFacing() {
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<Integer>(Arrays.asList(LensFacingConverter.values()));
        if (this.mCurrentLifecycle == null) return linkedHashSet;
        if (!this.hasCameraWithLensFacing(1)) {
            linkedHashSet.remove(1);
        }
        if (this.hasCameraWithLensFacing(0)) return linkedHashSet;
        linkedHashSet.remove(0);
        return linkedHashSet;
    }

    private int getMeasuredHeight() {
        return this.mCameraView.getMeasuredHeight();
    }

    private int getMeasuredWidth() {
        return this.mCameraView.getMeasuredWidth();
    }

    private void rebindToLifecycle() {
        LifecycleOwner lifecycleOwner = this.mCurrentLifecycle;
        if (lifecycleOwner == null) return;
        this.bindToLifecycle(lifecycleOwner);
    }

    private void updateViewInfo() {
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture != null) {
            imageCapture.setCropAspectRatio(new Rational(this.getWidth(), this.getHeight()));
            this.mImageCapture.setTargetRotation(this.getDisplaySurfaceRotation());
        }
        if ((imageCapture = this.mVideoCapture) == null) return;
        imageCapture.setTargetRotation(this.getDisplaySurfaceRotation());
    }

    void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mNewLifecycle = lifecycleOwner;
        if (this.getMeasuredWidth() <= 0) return;
        if (this.getMeasuredHeight() <= 0) return;
        this.bindToLifecycleAfterViewMeasured();
    }

    void bindToLifecycleAfterViewMeasured() {
        Serializable serializable;
        if (this.mNewLifecycle == null) {
            return;
        }
        this.clearCurrentLifecycle();
        if (this.mNewLifecycle.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            this.mNewLifecycle = null;
            return;
        }
        this.mCurrentLifecycle = this.mNewLifecycle;
        this.mNewLifecycle = null;
        if (this.mCameraProvider == null) {
            return;
        }
        Object object = this.getAvailableCameraLensFacing();
        if (object.isEmpty()) {
            Logger.w((String)TAG, (String)"Unable to bindToLifeCycle since no cameras available");
            this.mCameraLensFacing = null;
        }
        if ((serializable = this.mCameraLensFacing) != null && !object.contains(serializable)) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Camera does not exist with direction ");
            ((StringBuilder)serializable).append(this.mCameraLensFacing);
            Logger.w((String)TAG, (String)((StringBuilder)serializable).toString());
            this.mCameraLensFacing = (Integer)object.iterator().next();
            object = new StringBuilder();
            ((StringBuilder)object).append("Defaulting to primary camera with direction ");
            ((StringBuilder)object).append(this.mCameraLensFacing);
            Logger.w((String)TAG, (String)((StringBuilder)object).toString());
        }
        if (this.mCameraLensFacing == null) {
            return;
        }
        int n = this.getDisplayRotationDegrees() != 0 && this.getDisplayRotationDegrees() != 180 ? 0 : 1;
        if (this.getCaptureMode() == CameraView.CaptureMode.IMAGE) {
            object = n != 0 ? ASPECT_RATIO_3_4 : ASPECT_RATIO_4_3;
        } else {
            this.mImageCaptureBuilder.setTargetAspectRatio(1);
            this.mVideoCaptureBuilder.setTargetAspectRatio(1);
            object = n != 0 ? ASPECT_RATIO_9_16 : ASPECT_RATIO_16_9;
        }
        this.mImageCaptureBuilder.setTargetRotation(this.getDisplaySurfaceRotation());
        this.mImageCapture = this.mImageCaptureBuilder.build();
        this.mVideoCaptureBuilder.setTargetRotation(this.getDisplaySurfaceRotation());
        this.mVideoCapture = this.mVideoCaptureBuilder.build();
        n = (int)((float)this.getMeasuredWidth() / object.floatValue());
        this.mPreviewBuilder.setTargetResolution(new Size(this.getMeasuredWidth(), n));
        object = this.mPreviewBuilder.build();
        this.mPreview = object;
        object.setSurfaceProvider(this.mCameraView.getPreviewView().getSurfaceProvider());
        object = new CameraSelector.Builder().requireLensFacing(this.mCameraLensFacing.intValue()).build();
        this.mCamera = this.getCaptureMode() == CameraView.CaptureMode.IMAGE ? this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, (CameraSelector)object, new UseCase[]{this.mImageCapture, this.mPreview}) : (this.getCaptureMode() == CameraView.CaptureMode.VIDEO ? this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, (CameraSelector)object, new UseCase[]{this.mVideoCapture, this.mPreview}) : this.mCameraProvider.bindToLifecycle(this.mCurrentLifecycle, (CameraSelector)object, new UseCase[]{this.mImageCapture, this.mVideoCapture, this.mPreview}));
        this.setZoomRatio(1.0f);
        this.mCurrentLifecycle.getLifecycle().addObserver(this.mCurrentLifecycleObserver);
        this.setFlash(this.getFlash());
    }

    void clearCurrentLifecycle() {
        if (this.mCurrentLifecycle != null && this.mCameraProvider != null) {
            Preview preview = new ArrayList();
            ImageCapture imageCapture = this.mImageCapture;
            if (imageCapture != null && this.mCameraProvider.isBound((UseCase)imageCapture)) {
                preview.add(this.mImageCapture);
            }
            if ((imageCapture = this.mVideoCapture) != null && this.mCameraProvider.isBound((UseCase)imageCapture)) {
                preview.add(this.mVideoCapture);
            }
            if ((imageCapture = this.mPreview) != null && this.mCameraProvider.isBound((UseCase)imageCapture)) {
                preview.add(this.mPreview);
            }
            if (!preview.isEmpty()) {
                this.mCameraProvider.unbind(preview.toArray(new UseCase[0]));
            }
            if ((preview = this.mPreview) != null) {
                preview.setSurfaceProvider(null);
            }
        }
        this.mCamera = null;
        this.mCurrentLifecycle = null;
    }

    public void close() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void enableTorch(boolean bl) {
        Camera camera = this.mCamera;
        if (camera == null) {
            return;
        }
        Futures.addCallback((ListenableFuture)camera.getCameraControl().enableTorch(bl), (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
    }

    public Camera getCamera() {
        return this.mCamera;
    }

    public CameraView.CaptureMode getCaptureMode() {
        return this.mCaptureMode;
    }

    public Context getContext() {
        return this.mCameraView.getContext();
    }

    public int getDisplayRotationDegrees() {
        return CameraOrientationUtil.surfaceRotationToDegrees((int)this.getDisplaySurfaceRotation());
    }

    protected int getDisplaySurfaceRotation() {
        return this.mCameraView.getDisplaySurfaceRotation();
    }

    public int getFlash() {
        return this.mFlash;
    }

    public int getHeight() {
        return this.mCameraView.getHeight();
    }

    public Integer getLensFacing() {
        return this.mCameraLensFacing;
    }

    public long getMaxVideoDuration() {
        return this.mMaxVideoDuration;
    }

    public long getMaxVideoSize() {
        return this.mMaxVideoSize;
    }

    public float getMaxZoomRatio() {
        Camera camera = this.mCamera;
        if (camera == null) return 1.0f;
        return ((ZoomState)camera.getCameraInfo().getZoomState().getValue()).getMaxZoomRatio();
    }

    public float getMinZoomRatio() {
        Camera camera = this.mCamera;
        if (camera == null) return 1.0f;
        return ((ZoomState)camera.getCameraInfo().getZoomState().getValue()).getMinZoomRatio();
    }

    int getRelativeCameraOrientation(boolean bl) {
        int n;
        Camera camera = this.mCamera;
        if (camera != null) {
            int n2;
            n = n2 = camera.getCameraInfo().getSensorRotationDegrees(this.getDisplaySurfaceRotation());
            if (!bl) return n;
            n = (360 - n2) % 360;
        } else {
            n = 0;
        }
        return n;
    }

    public int getWidth() {
        return this.mCameraView.getWidth();
    }

    public float getZoomRatio() {
        Camera camera = this.mCamera;
        if (camera == null) return 1.0f;
        return ((ZoomState)camera.getCameraInfo().getZoomState().getValue()).getZoomRatio();
    }

    public boolean hasCameraWithLensFacing(int n) {
        ProcessCameraProvider processCameraProvider = this.mCameraProvider;
        if (processCameraProvider == null) {
            return false;
        }
        try {
            CameraSelector.Builder builder = new CameraSelector.Builder();
            boolean bl = processCameraProvider.hasCamera(builder.requireLensFacing(n).build());
            return bl;
        }
        catch (CameraInfoUnavailableException cameraInfoUnavailableException) {
            return false;
        }
    }

    public void invalidateView() {
        this.updateViewInfo();
    }

    boolean isBoundToLifecycle() {
        boolean bl = this.mCamera != null;
        return bl;
    }

    public boolean isPaused() {
        return false;
    }

    public boolean isRecording() {
        return this.mVideoIsRecording.get();
    }

    public boolean isTorchOn() {
        Camera camera = this.mCamera;
        boolean bl = false;
        if (camera == null) {
            return false;
        }
        if ((Integer)camera.getCameraInfo().getTorchState().getValue() != 1) return bl;
        bl = true;
        return bl;
    }

    public boolean isZoomSupported() {
        boolean bl = this.getMaxZoomRatio() != 1.0f;
        return bl;
    }

    public void open() {
        throw new UnsupportedOperationException("Explicit open/close of camera not yet supported. Use bindtoLifecycle() instead.");
    }

    public void setCameraLensFacing(Integer n) {
        if (Objects.equals(this.mCameraLensFacing, n)) return;
        this.mCameraLensFacing = n;
        n = this.mCurrentLifecycle;
        if (n == null) return;
        this.bindToLifecycle((LifecycleOwner)n);
    }

    public void setCaptureMode(CameraView.CaptureMode captureMode) {
        this.mCaptureMode = captureMode;
        this.rebindToLifecycle();
    }

    public void setFlash(int n) {
        this.mFlash = n;
        ImageCapture imageCapture = this.mImageCapture;
        if (imageCapture == null) {
            return;
        }
        imageCapture.setFlashMode(n);
    }

    public void setMaxVideoDuration(long l) {
        this.mMaxVideoDuration = l;
    }

    public void setMaxVideoSize(long l) {
        this.mMaxVideoSize = l;
    }

    public void setZoomRatio(float f) {
        Camera camera = this.mCamera;
        if (camera != null) {
            Futures.addCallback((ListenableFuture)camera.getCameraControl().setZoomRatio(f), (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
        } else {
            Logger.e((String)TAG, (String)"Failed to set zoom ratio");
        }
    }

    public void startRecording(VideoCapture.OutputFileOptions outputFileOptions, Executor executor, VideoCapture.OnVideoSavedCallback onVideoSavedCallback) {
        if (this.mVideoCapture == null) {
            return;
        }
        if (this.getCaptureMode() == CameraView.CaptureMode.IMAGE) throw new IllegalStateException("Can not record video under IMAGE capture mode.");
        if (onVideoSavedCallback == null) throw new IllegalArgumentException("OnVideoSavedCallback should not be empty");
        this.mVideoIsRecording.set(true);
        this.mVideoCapture.startRecording(outputFileOptions, executor, (VideoCapture.OnVideoSavedCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void stopRecording() {
        VideoCapture videoCapture = this.mVideoCapture;
        if (videoCapture == null) {
            return;
        }
        videoCapture.stopRecording();
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        if (this.mImageCapture == null) {
            return;
        }
        if (this.getCaptureMode() == CameraView.CaptureMode.VIDEO) throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
        if (onImageSavedCallback == null) throw new IllegalArgumentException("OnImageSavedCallback should not be empty");
        ImageCapture.Metadata metadata = outputFileOptions.getMetadata();
        Integer n = this.mCameraLensFacing;
        boolean bl = n != null && n == 0;
        metadata.setReversedHorizontal(bl);
        this.mImageCapture.takePicture(outputFileOptions, executor, onImageSavedCallback);
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        if (this.mImageCapture == null) {
            return;
        }
        if (this.getCaptureMode() == CameraView.CaptureMode.VIDEO) throw new IllegalStateException("Can not take picture under VIDEO capture mode.");
        if (onImageCapturedCallback == null) throw new IllegalArgumentException("OnImageCapturedCallback should not be empty");
        this.mImageCapture.takePicture(executor, onImageCapturedCallback);
    }

    public void toggleCamera() {
        Set<Integer> set = this.getAvailableCameraLensFacing();
        if (set.isEmpty()) {
            return;
        }
        Integer n = this.mCameraLensFacing;
        if (n == null) {
            this.setCameraLensFacing(set.iterator().next());
            return;
        }
        if (n == 1 && set.contains(0)) {
            this.setCameraLensFacing(0);
            return;
        }
        if (this.mCameraLensFacing != 0) return;
        if (!set.contains(1)) return;
        this.setCameraLensFacing(1);
    }
}
