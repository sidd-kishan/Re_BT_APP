/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.hardware.Camera
 *  android.hardware.Camera$AutoFocusCallback
 *  android.hardware.Camera$Parameters
 *  android.hardware.Camera$PreviewCallback
 *  android.hardware.Camera$Size
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.View
 *  android.view.ViewGroup
 *  com.lianhezhuli.btnotification.function.device.remotecamera.Preview$AutoFocusCallback
 *  com.lianhezhuli.btnotification.function.device.remotecamera.Preview$TakePictureCallback
 */
package com.lianhezhuli.btnotification.function.device.remotecamera;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.lianhezhuli.btnotification.function.device.remotecamera.Preview;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

class Preview
extends ViewGroup
implements SurfaceHolder.Callback {
    private final String TAG;
    Activity mAcitivity;
    private final AutoFocusCallback mAutoFocusCallback;
    private Camera mCamera;
    byte[] mCaptureJpegData;
    private final Context mContext;
    private long mCurrentTime;
    private final SurfaceHolder mHolder;
    private Camera.Size mPictureSize;
    byte[] mPreviewJpegData;
    private Camera.Size mPreviewSize;
    private List<Camera.Size> mSupportedPictureSizes;
    private List<Camera.Size> mSupportedPreviewSizes;
    private final SurfaceView mSurfaceView;
    private final TakePictureCallback mTakePictureCallback = new TakePictureCallback(this, null);
    private int ratation;

    Preview(Context context) {
        super(context);
        this.TAG = "REMOTECAMERAService";
        this.mAutoFocusCallback = new AutoFocusCallback(this, null);
        this.mContext = context;
        context = new SurfaceView(context);
        this.mSurfaceView = context;
        this.addView((View)context);
        this.mCurrentTime = 0L;
        context = this.mSurfaceView.getHolder();
        this.mHolder = context;
        context.addCallback((SurfaceHolder.Callback)this);
    }

    static /* synthetic */ TakePictureCallback access$200(Preview preview) {
        return preview.mTakePictureCallback;
    }

    static /* synthetic */ int access$300(Preview preview) {
        return preview.ratation;
    }

    static /* synthetic */ int access$302(Preview preview, int n) {
        preview.ratation = n;
        return n;
    }

    static /* synthetic */ Context access$400(Preview preview) {
        return preview.mContext;
    }

    static /* synthetic */ long access$500(Preview preview) {
        return preview.mCurrentTime;
    }

    static /* synthetic */ long access$502(Preview preview, long l) {
        preview.mCurrentTime = l;
        return l;
    }

    private Camera.Size getOptimalPreviewSize(List<Camera.Size> size, int n, int n2) {
        Camera.Size size2;
        double d = n;
        double d2 = n2;
        Double.isNaN(d);
        Double.isNaN(d2);
        double d3 = d / d2;
        Camera.Size size3 = null;
        if (size == null) {
            return null;
        }
        double d4 = Double.MAX_VALUE;
        d2 = Double.MAX_VALUE;
        for (n = size.size() - 1; n > 0; --n) {
            size2 = size.get(n);
            d = size2.width;
            double d5 = size2.height;
            Double.isNaN(d);
            Double.isNaN(d5);
            if (Math.abs(d / d5 - d3) > 0.1) {
                d = d2;
            } else {
                d = d2;
                if ((double)Math.abs(size2.height - n2) < d2) {
                    d = Math.abs(size2.height - n2);
                    size3 = size2;
                }
            }
            d2 = d;
        }
        size2 = size3;
        if (size3 != null) return size2;
        Iterator<Camera.Size> iterator = size.iterator();
        d2 = d4;
        while (true) {
            size2 = size3;
            if (!iterator.hasNext()) return size2;
            size = iterator.next();
            if (!((double)Math.abs(size.height - n2) < d2)) continue;
            d2 = Math.abs(size.height - n2);
            size3 = size;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        if (!bl) return;
        if (this.getChildCount() <= 0) return;
        View view = this.getChildAt(0);
        n3 -= n;
        n4 -= n2;
        Camera.Size size = this.mPreviewSize;
        if (size != null) {
            n2 = size.width;
            n = this.mPreviewSize.height;
        } else {
            n2 = n3;
            n = n4;
        }
        int n5 = n3 * n;
        int n6 = n4 * n2;
        if (n5 > n6) {
            n = n6 / n;
            view.layout((n3 - n) / 2, 0, (n3 + n) / 2, n4);
        } else {
            n = n5 / n2;
            view.layout(0, (n4 - n) / 2, n3, (n4 + n) / 2);
        }
    }

    protected void onMeasure(int n, int n2) {
        n = Preview.resolveSize((int)this.getSuggestedMinimumWidth(), (int)n);
        n2 = Preview.resolveSize((int)this.getSuggestedMinimumHeight(), (int)n2);
        this.setMeasuredDimension(n, n2);
        List<Camera.Size> list = this.mSupportedPreviewSizes;
        if (list != null) {
            this.mPreviewSize = this.getOptimalPreviewSize(list, n, n2);
        }
        if ((list = this.mSupportedPictureSizes) == null) return;
        this.mPictureSize = this.getOptimalPreviewSize(list, n, n2);
    }

    public void setCamera(Camera camera) {
        this.mCamera = camera;
        if (camera == null) return;
        this.mSupportedPreviewSizes = camera.getParameters().getSupportedPreviewSizes();
        this.mSupportedPictureSizes = this.mCamera.getParameters().getSupportedPictureSizes();
        this.requestLayout();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n, int n2, int n3) {
        if (this.mCamera == null) {
            return;
        }
        Log.i((String)"REMOTECAMERAService", (String)"surfaceChanged");
        surfaceHolder = this.mCamera.getParameters();
        surfaceHolder.setPreviewSize(this.mPreviewSize.width, this.mPreviewSize.height);
        surfaceHolder.setPictureSize(this.mPictureSize.width, this.mPictureSize.height);
        this.requestLayout();
        this.mCamera.setParameters((Camera.Parameters)surfaceHolder);
        this.mCamera.setPreviewCallback((Camera.PreviewCallback)new /* Unavailable Anonymous Inner Class!! */);
        this.mCamera.startPreview();
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        Log.i((String)"REMOTECAMERAService", (String)"surfaceCreated");
        try {
            if (this.mCamera == null) return;
            this.mCamera.setPreviewDisplay(surfaceHolder);
        }
        catch (IOException iOException) {
            Log.e((String)"REMOTECAMERAService", (String)"IOException caused by setPreviewDisplay()", (Throwable)iOException);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Log.i((String)"REMOTECAMERAService", (String)"surfaceDestroyed");
        surfaceHolder = this.mCamera;
        if (surfaceHolder == null) return;
        surfaceHolder.setPreviewCallback(null);
        this.mCamera.stopPreview();
        this.mCamera.release();
        this.mCamera = null;
    }

    public void takePicture(int n) {
        Camera camera = this.mCamera;
        if (camera == null) return;
        this.ratation = n;
        camera.autoFocus((Camera.AutoFocusCallback)this.mAutoFocusCallback);
    }
}
