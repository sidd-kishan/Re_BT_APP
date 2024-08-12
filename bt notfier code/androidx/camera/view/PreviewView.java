/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Rational
 *  android.util.Size
 *  android.view.Display
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.View
 *  android.view.View$OnLayoutChangeListener
 *  android.view.ViewConfiguration
 *  android.widget.FrameLayout
 *  androidx.camera.core.Logger
 *  androidx.camera.core.MeteringPointFactory
 *  androidx.camera.core.Preview$SurfaceProvider
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.core.ViewPort
 *  androidx.camera.core.ViewPort$Builder
 *  androidx.camera.core.impl.utils.Threads
 *  androidx.camera.view.CameraController
 *  androidx.camera.view.PreviewStreamStateObserver
 *  androidx.camera.view.PreviewTransformation
 *  androidx.camera.view.PreviewView$2
 *  androidx.camera.view.PreviewView$ImplementationMode
 *  androidx.camera.view.PreviewView$PinchToZoomOnScaleGestureListener
 *  androidx.camera.view.PreviewView$ScaleType
 *  androidx.camera.view.PreviewView$StreamState
 *  androidx.camera.view.PreviewViewImplementation
 *  androidx.camera.view.PreviewViewMeteringPointFactory
 *  androidx.camera.view.R$styleable
 *  androidx.camera.view.TextureViewImplementation
 *  androidx.camera.view.TransformUtils
 *  androidx.camera.view._$$Lambda$PreviewView$44iXgZsE5ySm9nGqWj2dybvzBoc
 *  androidx.camera.view.internal.compat.quirk.DeviceQuirks
 *  androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk
 *  androidx.camera.view.transform.OutputTransform
 *  androidx.core.content.ContextCompat
 *  androidx.lifecycle.LiveData
 *  androidx.lifecycle.MutableLiveData
 */
package androidx.camera.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Rational;
import android.util.Size;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import androidx.camera.core.Logger;
import androidx.camera.core.MeteringPointFactory;
import androidx.camera.core.Preview;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.ViewPort;
import androidx.camera.core.impl.utils.Threads;
import androidx.camera.view.CameraController;
import androidx.camera.view.PreviewStreamStateObserver;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewView;
import androidx.camera.view.PreviewViewImplementation;
import androidx.camera.view.PreviewViewMeteringPointFactory;
import androidx.camera.view.R;
import androidx.camera.view.TextureViewImplementation;
import androidx.camera.view.TransformUtils;
import androidx.camera.view._$;
import androidx.camera.view.internal.compat.quirk.DeviceQuirks;
import androidx.camera.view.internal.compat.quirk.SurfaceViewStretchedQuirk;
import androidx.camera.view.transform.OutputTransform;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.concurrent.atomic.AtomicReference;

/*
 * Exception performing whole class analysis ignored.
 */
public final class PreviewView
extends FrameLayout {
    static final int DEFAULT_BACKGROUND_COLOR = 17170444;
    private static final ImplementationMode DEFAULT_IMPL_MODE = ImplementationMode.PERFORMANCE;
    private static final String TAG = "PreviewView";
    final AtomicReference<PreviewStreamStateObserver> mActiveStreamStateObserver;
    CameraController mCameraController;
    PreviewViewImplementation mImplementation;
    ImplementationMode mImplementationMode = DEFAULT_IMPL_MODE;
    private final View.OnLayoutChangeListener mOnLayoutChangeListener;
    final MutableLiveData<StreamState> mPreviewStreamStateLiveData;
    final PreviewTransformation mPreviewTransform = new PreviewTransformation();
    PreviewViewMeteringPointFactory mPreviewViewMeteringPointFactory;
    private final ScaleGestureDetector mScaleGestureDetector;
    final Preview.SurfaceProvider mSurfaceProvider;
    private MotionEvent mTouchUpEvent;

    public PreviewView(Context context) {
        this(context, null);
    }

    public PreviewView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int n) {
        this(context, attributeSet, n, 0);
    }

    public PreviewView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mPreviewStreamStateLiveData = new MutableLiveData((Object)StreamState.IDLE);
        this.mActiveStreamStateObserver = new AtomicReference();
        this.mPreviewViewMeteringPointFactory = new PreviewViewMeteringPointFactory(this.mPreviewTransform);
        this.mOnLayoutChangeListener = new _$.Lambda.PreviewView.44iXgZsE5ySm9nGqWj2dybvzBoc(this);
        this.mSurfaceProvider = new /* Unavailable Anonymous Inner Class!! */;
        Threads.checkMainThread();
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.PreviewView, n, n2);
        if (Build.VERSION.SDK_INT >= 29) {
            this.saveAttributeDataForStyleable(context, R.styleable.PreviewView, attributeSet, typedArray, n, n2);
        }
        this.setScaleType(ScaleType.fromId((int)typedArray.getInteger(R.styleable.PreviewView_scaleType, this.mPreviewTransform.getScaleType().getId())));
        this.setImplementationMode(ImplementationMode.fromId((int)typedArray.getInteger(R.styleable.PreviewView_implementationMode, DEFAULT_IMPL_MODE.getId())));
        this.mScaleGestureDetector = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)new PinchToZoomOnScaleGestureListener(this));
        if (this.getBackground() != null) return;
        this.setBackgroundColor(ContextCompat.getColor((Context)this.getContext(), (int)17170444));
        return;
        finally {
            typedArray.recycle();
        }
    }

    private void attachToControllerIfReady(boolean bl) {
        Display display = this.getDisplay();
        ViewPort viewPort = this.getViewPort();
        if (this.mCameraController == null) return;
        if (viewPort == null) return;
        if (!this.isAttachedToWindow()) return;
        if (display == null) return;
        try {
            this.mCameraController.attachPreviewSurface(this.getSurfaceProvider(), viewPort, display);
        }
        catch (IllegalStateException illegalStateException) {
            if (!bl) throw illegalStateException;
            Logger.e((String)"PreviewView", (String)illegalStateException.getMessage(), (Throwable)illegalStateException);
        }
    }

    private int getViewPortScaleType() {
        switch (2.$SwitchMap$androidx$camera$view$PreviewView$ScaleType[this.getScaleType().ordinal()]) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unexpected scale type: ");
                stringBuilder.append(this.getScaleType());
                throw new IllegalStateException(stringBuilder.toString());
            }
            case 4: 
            case 5: 
            case 6: {
                return 3;
            }
            case 3: {
                return 0;
            }
            case 2: {
                return 1;
            }
            case 1: 
        }
        return 2;
    }

    static boolean shouldUseTextureView(SurfaceRequest object, ImplementationMode implementationMode) {
        boolean bl = object.getCamera().getCameraInfoInternal().getImplementationType().equals("androidx.camera.camera2.legacy");
        int n = DeviceQuirks.get(SurfaceViewStretchedQuirk.class) != null ? 1 : 0;
        if (object.isRGBA8888Required()) return true;
        if (Build.VERSION.SDK_INT <= 24) return true;
        if (bl) return true;
        if (n != 0) {
            return true;
        }
        n = 2.$SwitchMap$androidx$camera$view$PreviewView$ImplementationMode[implementationMode.ordinal()];
        if (n == 1) return true;
        if (n == 2) {
            return false;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Invalid implementation mode: ");
        ((StringBuilder)object).append(implementationMode);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public Bitmap getBitmap() {
        Threads.checkMainThread();
        Object object = this.mImplementation;
        object = object == null ? null : object.getBitmap();
        return object;
    }

    public CameraController getController() {
        Threads.checkMainThread();
        return this.mCameraController;
    }

    public ImplementationMode getImplementationMode() {
        Threads.checkMainThread();
        return this.mImplementationMode;
    }

    public MeteringPointFactory getMeteringPointFactory() {
        Threads.checkMainThread();
        return this.mPreviewViewMeteringPointFactory;
    }

    public OutputTransform getOutputTransform() {
        Size size;
        PreviewTransformation previewTransformation;
        Threads.checkMainThread();
        try {
            previewTransformation = this.mPreviewTransform;
            size = new Size(this.getWidth(), this.getHeight());
            size = previewTransformation.getSurfaceToPreviewViewMatrix(size, this.getLayoutDirection());
        }
        catch (IllegalStateException illegalStateException) {
            size = null;
        }
        previewTransformation = this.mPreviewTransform.getSurfaceCropRect();
        if (size != null && previewTransformation != null) {
            size.preConcat(TransformUtils.getNormalizedToBuffer((Rect)previewTransformation));
            if (this.mImplementation instanceof TextureViewImplementation) {
                size.postConcat(this.getMatrix());
            } else {
                Logger.w((String)"PreviewView", (String)"PreviewView needs to be in COMPATIBLE mode for the transform to work correctly.");
            }
            return new OutputTransform((Matrix)size, new Size(previewTransformation.width(), previewTransformation.height()));
        }
        Logger.d((String)"PreviewView", (String)"Transform info is not ready");
        return null;
    }

    public LiveData<StreamState> getPreviewStreamState() {
        return this.mPreviewStreamStateLiveData;
    }

    public ScaleType getScaleType() {
        Threads.checkMainThread();
        return this.mPreviewTransform.getScaleType();
    }

    public Preview.SurfaceProvider getSurfaceProvider() {
        Threads.checkMainThread();
        return this.mSurfaceProvider;
    }

    public ViewPort getViewPort() {
        Threads.checkMainThread();
        if (this.getDisplay() != null) return this.getViewPort(this.getDisplay().getRotation());
        return null;
    }

    public ViewPort getViewPort(int n) {
        Threads.checkMainThread();
        if (this.getWidth() == 0) return null;
        if (this.getHeight() != 0) return new ViewPort.Builder(new Rational(this.getWidth(), this.getHeight()), n).setScaleType(this.getViewPortScaleType()).setLayoutDirection(this.getLayoutDirection()).build();
        return null;
    }

    public /* synthetic */ void lambda$new$0$PreviewView(View view, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8) {
        n = n3 - n == n7 - n5 && n4 - n2 == n8 - n6 ? 0 : 1;
        if (n == 0) return;
        this.redrawPreview();
        this.attachToControllerIfReady(true);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.addOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onAttachedToWindow();
        }
        this.attachToControllerIfReady(true);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.removeOnLayoutChangeListener(this.mOnLayoutChangeListener);
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.onDetachedFromWindow();
        }
        if ((previewViewImplementation = this.mCameraController) == null) return;
        previewViewImplementation.clearPreviewSurface();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.mCameraController == null) {
            return super.onTouchEvent(motionEvent);
        }
        int n = motionEvent.getPointerCount();
        boolean bl = false;
        n = n == 1 ? 1 : 0;
        boolean bl2 = motionEvent.getAction() == 1;
        boolean bl3 = motionEvent.getEventTime() - motionEvent.getDownTime() < (long)ViewConfiguration.getLongPressTimeout();
        if (n != 0 && bl2 && bl3) {
            this.mTouchUpEvent = motionEvent;
            this.performClick();
            return true;
        }
        if (!this.mScaleGestureDetector.onTouchEvent(motionEvent)) {
            if (!super.onTouchEvent(motionEvent)) return bl;
        }
        bl = true;
        return bl;
    }

    public boolean performClick() {
        if (this.mCameraController != null) {
            MotionEvent motionEvent = this.mTouchUpEvent;
            float f = motionEvent != null ? motionEvent.getX() : (float)this.getWidth() / 2.0f;
            motionEvent = this.mTouchUpEvent;
            float f2 = motionEvent != null ? motionEvent.getY() : (float)this.getHeight() / 2.0f;
            this.mCameraController.onTapToFocus((MeteringPointFactory)this.mPreviewViewMeteringPointFactory, f, f2);
        }
        this.mTouchUpEvent = null;
        return super.performClick();
    }

    void redrawPreview() {
        PreviewViewImplementation previewViewImplementation = this.mImplementation;
        if (previewViewImplementation != null) {
            previewViewImplementation.redrawPreview();
        }
        this.mPreviewViewMeteringPointFactory.recalculate(new Size(this.getWidth(), this.getHeight()), this.getLayoutDirection());
    }

    public void setController(CameraController cameraController) {
        Threads.checkMainThread();
        CameraController cameraController2 = this.mCameraController;
        if (cameraController2 != null && cameraController2 != cameraController) {
            cameraController2.clearPreviewSurface();
        }
        this.mCameraController = cameraController;
        this.attachToControllerIfReady(false);
    }

    public void setImplementationMode(ImplementationMode implementationMode) {
        Threads.checkMainThread();
        this.mImplementationMode = implementationMode;
    }

    public void setScaleType(ScaleType scaleType) {
        Threads.checkMainThread();
        this.mPreviewTransform.setScaleType(scaleType);
        this.redrawPreview();
        this.attachToControllerIfReady(false);
    }
}
