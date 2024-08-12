/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.hardware.display.DisplayManager
 *  android.hardware.display.DisplayManager$DisplayListener
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.text.TextUtils
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.camera.core.Camera
 *  androidx.camera.core.FocusMeteringAction$Builder
 *  androidx.camera.core.ImageCapture$OnImageCapturedCallback
 *  androidx.camera.core.ImageCapture$OnImageSavedCallback
 *  androidx.camera.core.ImageCapture$OutputFileOptions
 *  androidx.camera.core.Logger
 *  androidx.camera.core.MeteringPoint
 *  androidx.camera.core.MeteringPointFactory
 *  androidx.camera.core.VideoCapture$OnVideoSavedCallback
 *  androidx.camera.core.impl.LensFacingConverter
 *  androidx.camera.core.impl.utils.executor.CameraXExecutors
 *  androidx.camera.core.impl.utils.futures.FutureCallback
 *  androidx.camera.core.impl.utils.futures.Futures
 *  androidx.camera.view.CameraView$CaptureMode
 *  androidx.camera.view.CameraView$PinchToZoomGestureDetector
 *  androidx.camera.view.CameraXModule
 *  androidx.camera.view.FlashModeConverter
 *  androidx.camera.view.PreviewView
 *  androidx.camera.view.PreviewView$ScaleType
 *  androidx.camera.view.PreviewView$StreamState
 *  androidx.camera.view.R$styleable
 *  androidx.camera.view.video.OnVideoSavedCallback
 *  androidx.camera.view.video.OutputFileOptions
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LiveData
 */
package androidx.camera.view;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.camera.core.Camera;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPoint;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.VideoCapture;
import androidx.camera.core.impl.LensFacingConverter;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.view.CameraView;
import androidx.camera.view.CameraXModule;
import androidx.camera.view.FlashModeConverter;
import androidx.camera.view.PreviewView;
import androidx.camera.view.R;
import androidx.camera.view.video.OnVideoSavedCallback;
import androidx.camera.view.video.OutputFileOptions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.util.concurrent.Executor;

/*
 * Exception performing whole class analysis ignored.
 */
@Deprecated
public final class CameraView
extends FrameLayout {
    private static final String EXTRA_CAMERA_DIRECTION = "camera_direction";
    private static final String EXTRA_CAPTURE_MODE = "captureMode";
    private static final String EXTRA_FLASH = "flash";
    private static final String EXTRA_MAX_VIDEO_DURATION = "max_video_duration";
    private static final String EXTRA_MAX_VIDEO_SIZE = "max_video_size";
    private static final String EXTRA_PINCH_TO_ZOOM_ENABLED = "pinch_to_zoom_enabled";
    private static final String EXTRA_SCALE_TYPE = "scale_type";
    private static final String EXTRA_SUPER = "super";
    private static final String EXTRA_ZOOM_RATIO = "zoom_ratio";
    private static final int FLASH_MODE_AUTO = 1;
    private static final int FLASH_MODE_OFF = 4;
    private static final int FLASH_MODE_ON = 2;
    static final int INDEFINITE_VIDEO_DURATION = -1;
    static final int INDEFINITE_VIDEO_SIZE = -1;
    private static final int LENS_FACING_BACK = 2;
    private static final int LENS_FACING_FRONT = 1;
    private static final int LENS_FACING_NONE = 0;
    static final String TAG = CameraView.class.getSimpleName();
    CameraXModule mCameraModule;
    private final DisplayManager.DisplayListener mDisplayListener = new /* Unavailable Anonymous Inner Class!! */;
    private long mDownEventTimestamp;
    private boolean mIsPinchToZoomEnabled = true;
    private PinchToZoomGestureDetector mPinchToZoomGestureDetector;
    private PreviewView mPreviewView;
    private MotionEvent mUpEvent;

    public CameraView(Context context) {
        this(context, null);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(context, attributeSet);
    }

    public CameraView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.init(context, attributeSet);
    }

    private long delta() {
        return System.currentTimeMillis() - this.mDownEventTimestamp;
    }

    private long getMaxVideoSize() {
        return this.mCameraModule.getMaxVideoSize();
    }

    private void init(Context context, AttributeSet attributeSet) {
        PreviewView previewView;
        this.mPreviewView = previewView = new PreviewView(this.getContext());
        this.addView((View)previewView, 0);
        this.mCameraModule = new CameraXModule(this);
        if (attributeSet != null) {
            attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.CameraView);
            this.setScaleType(PreviewView.ScaleType.fromId((int)attributeSet.getInteger(R.styleable.CameraView_scaleType, this.getScaleType().getId())));
            this.setPinchToZoomEnabled(attributeSet.getBoolean(R.styleable.CameraView_pinchToZoomEnabled, this.isPinchToZoomEnabled()));
            this.setCaptureMode(CaptureMode.fromId((int)attributeSet.getInteger(R.styleable.CameraView_captureMode, this.getCaptureMode().getId())));
            int n = attributeSet.getInt(R.styleable.CameraView_lensFacing, 2);
            if (n != 0) {
                if (n != 1) {
                    if (n == 2) {
                        this.setCameraLensFacing(1);
                    }
                } else {
                    this.setCameraLensFacing(0);
                }
            } else {
                this.setCameraLensFacing(null);
            }
            n = attributeSet.getInt(R.styleable.CameraView_flash, 0);
            if (n != 1) {
                if (n != 2) {
                    if (n == 4) {
                        this.setFlash(2);
                    }
                } else {
                    this.setFlash(1);
                }
            } else {
                this.setFlash(0);
            }
            attributeSet.recycle();
        }
        if (this.getBackground() == null) {
            this.setBackgroundColor(-15658735);
        }
        this.mPinchToZoomGestureDetector = new PinchToZoomGestureDetector(this, context);
    }

    private void setMaxVideoDuration(long l) {
        this.mCameraModule.setMaxVideoDuration(l);
    }

    private void setMaxVideoSize(long l) {
        this.mCameraModule.setMaxVideoSize(l);
    }

    public void bindToLifecycle(LifecycleOwner lifecycleOwner) {
        this.mCameraModule.bindToLifecycle(lifecycleOwner);
    }

    public void enableTorch(boolean bl) {
        this.mCameraModule.enableTorch(bl);
    }

    protected FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public Integer getCameraLensFacing() {
        return this.mCameraModule.getLensFacing();
    }

    public CaptureMode getCaptureMode() {
        return this.mCameraModule.getCaptureMode();
    }

    int getDisplaySurfaceRotation() {
        Display display = this.getDisplay();
        if (display != null) return display.getRotation();
        return 0;
    }

    public int getFlash() {
        return this.mCameraModule.getFlash();
    }

    public long getMaxVideoDuration() {
        return this.mCameraModule.getMaxVideoDuration();
    }

    public float getMaxZoomRatio() {
        return this.mCameraModule.getMaxZoomRatio();
    }

    public float getMinZoomRatio() {
        return this.mCameraModule.getMinZoomRatio();
    }

    public LiveData<PreviewView.StreamState> getPreviewStreamState() {
        return this.mPreviewView.getPreviewStreamState();
    }

    PreviewView getPreviewView() {
        return this.mPreviewView;
    }

    public PreviewView.ScaleType getScaleType() {
        return this.mPreviewView.getScaleType();
    }

    public float getZoomRatio() {
        return this.mCameraModule.getZoomRatio();
    }

    public boolean hasCameraWithLensFacing(int n) {
        return this.mCameraModule.hasCameraWithLensFacing(n);
    }

    public boolean isPinchToZoomEnabled() {
        return this.mIsPinchToZoomEnabled;
    }

    public boolean isRecording() {
        return this.mCameraModule.isRecording();
    }

    public boolean isTorchOn() {
        return this.mCameraModule.isTorchOn();
    }

    public boolean isZoomSupported() {
        return this.mCameraModule.isZoomSupported();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ((DisplayManager)this.getContext().getSystemService("display")).registerDisplayListener(this.mDisplayListener, new Handler(Looper.getMainLooper()));
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ((DisplayManager)this.getContext().getSystemService("display")).unregisterDisplayListener(this.mDisplayListener);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        this.mCameraModule.bindToLifecycleAfterViewMeasured();
        this.mCameraModule.invalidateView();
        super.onLayout(bl, n, n2, n3, n4);
    }

    protected void onMeasure(int n, int n2) {
        if (this.getMeasuredWidth() > 0 && this.getMeasuredHeight() > 0) {
            this.mCameraModule.bindToLifecycleAfterViewMeasured();
        }
        super.onMeasure(n, n2);
    }

    protected void onRestoreInstanceState(Parcelable object) {
        if (object instanceof Bundle) {
            Bundle bundle = (Bundle)object;
            super.onRestoreInstanceState(bundle.getParcelable("super"));
            this.setScaleType(PreviewView.ScaleType.fromId((int)bundle.getInt("scale_type")));
            this.setZoomRatio(bundle.getFloat("zoom_ratio"));
            this.setPinchToZoomEnabled(bundle.getBoolean("pinch_to_zoom_enabled"));
            this.setFlash(FlashModeConverter.valueOf((String)bundle.getString("flash")));
            this.setMaxVideoDuration(bundle.getLong("max_video_duration"));
            this.setMaxVideoSize(bundle.getLong("max_video_size"));
            object = bundle.getString("camera_direction");
            object = TextUtils.isEmpty((CharSequence)object) ? null : Integer.valueOf(LensFacingConverter.valueOf((String)object));
            this.setCameraLensFacing((Integer)object);
            this.setCaptureMode(CaptureMode.fromId((int)bundle.getInt("captureMode")));
        } else {
            super.onRestoreInstanceState(object);
        }
    }

    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", super.onSaveInstanceState());
        bundle.putInt("scale_type", this.getScaleType().getId());
        bundle.putFloat("zoom_ratio", this.getZoomRatio());
        bundle.putBoolean("pinch_to_zoom_enabled", this.isPinchToZoomEnabled());
        bundle.putString("flash", FlashModeConverter.nameOf((int)this.getFlash()));
        bundle.putLong("max_video_duration", this.getMaxVideoDuration());
        bundle.putLong("max_video_size", this.getMaxVideoSize());
        if (this.getCameraLensFacing() != null) {
            bundle.putString("camera_direction", LensFacingConverter.nameOf((int)this.getCameraLensFacing()));
        }
        bundle.putInt("captureMode", this.getCaptureMode().getId());
        return bundle;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCameraModule.isPaused()) {
            return false;
        }
        if (this.isPinchToZoomEnabled()) {
            this.mPinchToZoomGestureDetector.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 2 && this.isPinchToZoomEnabled() && this.isZoomSupported()) {
            return true;
        }
        int n = motionEvent.getAction();
        if (n != 0) {
            if (n != 1) {
                return false;
            }
            if (this.delta() >= (long)ViewConfiguration.getLongPressTimeout()) return true;
            if (!this.mCameraModule.isBoundToLifecycle()) return true;
            this.mUpEvent = motionEvent;
            this.performClick();
        } else {
            this.mDownEventTimestamp = System.currentTimeMillis();
        }
        return true;
    }

    public boolean performClick() {
        super.performClick();
        MotionEvent motionEvent = this.mUpEvent;
        float f = motionEvent != null ? motionEvent.getX() : this.getX() + (float)this.getWidth() / 2.0f;
        motionEvent = this.mUpEvent;
        float f2 = motionEvent != null ? motionEvent.getY() : this.getY() + (float)this.getHeight() / 2.0f;
        this.mUpEvent = null;
        Camera camera = this.mCameraModule.getCamera();
        if (camera != null) {
            MeteringPointFactory meteringPointFactory = this.mPreviewView.getMeteringPointFactory();
            motionEvent = meteringPointFactory.createPoint(f, f2, 0.16666667f);
            meteringPointFactory = meteringPointFactory.createPoint(f, f2, 0.25f);
            Futures.addCallback((ListenableFuture)camera.getCameraControl().startFocusAndMetering(new FocusMeteringAction.Builder((MeteringPoint)motionEvent, 1).addPoint((MeteringPoint)meteringPointFactory, 2).build()), (FutureCallback)new /* Unavailable Anonymous Inner Class!! */, (Executor)CameraXExecutors.directExecutor());
        } else {
            Logger.d((String)TAG, (String)"cannot access camera");
        }
        return true;
    }

    float rangeLimit(float f, float f2, float f3) {
        return Math.min(Math.max(f, f3), f2);
    }

    public void setCameraLensFacing(Integer n) {
        this.mCameraModule.setCameraLensFacing(n);
    }

    public void setCaptureMode(CaptureMode captureMode) {
        this.mCameraModule.setCaptureMode(captureMode);
    }

    public void setFlash(int n) {
        this.mCameraModule.setFlash(n);
    }

    public void setPinchToZoomEnabled(boolean bl) {
        this.mIsPinchToZoomEnabled = bl;
    }

    public void setScaleType(PreviewView.ScaleType scaleType) {
        this.mPreviewView.setScaleType(scaleType);
    }

    public void setZoomRatio(float f) {
        this.mCameraModule.setZoomRatio(f);
    }

    public void startRecording(ParcelFileDescriptor parcelFileDescriptor, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        this.startRecording(OutputFileOptions.builder((ParcelFileDescriptor)parcelFileDescriptor).build(), executor, onVideoSavedCallback);
    }

    public void startRecording(OutputFileOptions outputFileOptions, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        onVideoSavedCallback = new /* Unavailable Anonymous Inner Class!! */;
        this.mCameraModule.startRecording(outputFileOptions.toVideoCaptureOutputFileOptions(), executor, (VideoCapture.OnVideoSavedCallback)onVideoSavedCallback);
    }

    public void startRecording(File file, Executor executor, OnVideoSavedCallback onVideoSavedCallback) {
        this.startRecording(OutputFileOptions.builder((File)file).build(), executor, onVideoSavedCallback);
    }

    public void stopRecording() {
        this.mCameraModule.stopRecording();
    }

    public void takePicture(ImageCapture.OutputFileOptions outputFileOptions, Executor executor, ImageCapture.OnImageSavedCallback onImageSavedCallback) {
        this.mCameraModule.takePicture(outputFileOptions, executor, onImageSavedCallback);
    }

    public void takePicture(Executor executor, ImageCapture.OnImageCapturedCallback onImageCapturedCallback) {
        this.mCameraModule.takePicture(executor, onImageCapturedCallback);
    }

    public void toggleCamera() {
        this.mCameraModule.toggleCamera();
    }
}
