/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.util.Log
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.yalantis.ucrop.callback.BitmapLoadCallback
 *  com.yalantis.ucrop.model.ExifInfo
 *  com.yalantis.ucrop.util.BitmapLoadUtils
 *  com.yalantis.ucrop.util.FastBitmapDrawable
 *  com.yalantis.ucrop.util.RectUtils
 *  com.yalantis.ucrop.view.TransformImageView$TransformImageListener
 */
package com.yalantis.ucrop.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.yalantis.ucrop.callback.BitmapLoadCallback;
import com.yalantis.ucrop.model.ExifInfo;
import com.yalantis.ucrop.util.BitmapLoadUtils;
import com.yalantis.ucrop.util.FastBitmapDrawable;
import com.yalantis.ucrop.util.RectUtils;
import com.yalantis.ucrop.view.TransformImageView;

public class TransformImageView
extends AppCompatImageView {
    private static final int MATRIX_VALUES_COUNT = 9;
    private static final int RECT_CENTER_POINT_COORDS = 2;
    private static final int RECT_CORNER_POINTS_COORDS = 8;
    private static final String TAG = "TransformImageView";
    protected boolean mBitmapDecoded = false;
    protected boolean mBitmapLaidOut = false;
    protected final float[] mCurrentImageCenter;
    protected final float[] mCurrentImageCorners = new float[8];
    protected Matrix mCurrentImageMatrix;
    private ExifInfo mExifInfo;
    private String mImageInputPath;
    private String mImageOutputPath;
    private float[] mInitialImageCenter;
    private float[] mInitialImageCorners;
    private final float[] mMatrixValues;
    private int mMaxBitmapSize = 0;
    protected int mThisHeight;
    protected int mThisWidth;
    protected TransformImageListener mTransformImageListener;

    public TransformImageView(Context context) {
        this(context, null);
    }

    public TransformImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TransformImageView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mCurrentImageCenter = new float[2];
        this.mMatrixValues = new float[9];
        this.mCurrentImageMatrix = new Matrix();
        this.init();
    }

    static /* synthetic */ String access$002(TransformImageView transformImageView, String string) {
        transformImageView.mImageInputPath = string;
        return string;
    }

    static /* synthetic */ String access$102(TransformImageView transformImageView, String string) {
        transformImageView.mImageOutputPath = string;
        return string;
    }

    static /* synthetic */ ExifInfo access$202(TransformImageView transformImageView, ExifInfo exifInfo) {
        transformImageView.mExifInfo = exifInfo;
        return exifInfo;
    }

    private void updateCurrentImagePoints() {
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCorners, this.mInitialImageCorners);
        this.mCurrentImageMatrix.mapPoints(this.mCurrentImageCenter, this.mInitialImageCenter);
    }

    public float getCurrentAngle() {
        return this.getMatrixAngle(this.mCurrentImageMatrix);
    }

    public float getCurrentScale() {
        return this.getMatrixScale(this.mCurrentImageMatrix);
    }

    public ExifInfo getExifInfo() {
        return this.mExifInfo;
    }

    public String getImageInputPath() {
        return this.mImageInputPath;
    }

    public String getImageOutputPath() {
        return this.mImageOutputPath;
    }

    public float getMatrixAngle(Matrix matrix) {
        return (float)(-(Math.atan2(this.getMatrixValue(matrix, 1), this.getMatrixValue(matrix, 0)) * 57.29577951308232));
    }

    public float getMatrixScale(Matrix matrix) {
        return (float)Math.sqrt(Math.pow(this.getMatrixValue(matrix, 0), 2.0) + Math.pow(this.getMatrixValue(matrix, 3), 2.0));
    }

    protected float getMatrixValue(Matrix matrix, int n) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[n];
    }

    public int getMaxBitmapSize() {
        if (this.mMaxBitmapSize > 0) return this.mMaxBitmapSize;
        this.mMaxBitmapSize = BitmapLoadUtils.calculateMaxBitmapSize((Context)this.getContext());
        return this.mMaxBitmapSize;
    }

    public Bitmap getViewBitmap() {
        if (this.getDrawable() == null) return null;
        if (this.getDrawable() instanceof FastBitmapDrawable) return ((FastBitmapDrawable)this.getDrawable()).getBitmap();
        return null;
    }

    protected void init() {
        this.setScaleType(ImageView.ScaleType.MATRIX);
    }

    protected void onImageLaidOut() {
        Drawable drawable = this.getDrawable();
        if (drawable == null) {
            return;
        }
        float f = drawable.getIntrinsicWidth();
        float f2 = drawable.getIntrinsicHeight();
        Log.d((String)TAG, (String)String.format("Image size: [%d:%d]", (int)f, (int)f2));
        drawable = new RectF(0.0f, 0.0f, f, f2);
        this.mInitialImageCorners = RectUtils.getCornersFromRect((RectF)drawable);
        this.mInitialImageCenter = RectUtils.getCenterFromRect((RectF)drawable);
        this.mBitmapLaidOut = true;
        drawable = this.mTransformImageListener;
        if (drawable == null) return;
        drawable.onLoadComplete();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        if (!bl) {
            if (!this.mBitmapDecoded) return;
            if (this.mBitmapLaidOut) return;
        }
        n = this.getPaddingLeft();
        n2 = this.getPaddingTop();
        n3 = this.getWidth();
        n4 = this.getPaddingRight();
        int n5 = this.getHeight();
        int n6 = this.getPaddingBottom();
        this.mThisWidth = n3 - n4 - n;
        this.mThisHeight = n5 - n6 - n2;
        this.onImageLaidOut();
    }

    public void postRotate(float f, float f2, float f3) {
        if (f == 0.0f) return;
        this.mCurrentImageMatrix.postRotate(f, f2, f3);
        this.setImageMatrix(this.mCurrentImageMatrix);
        TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener == null) return;
        transformImageListener.onRotate(this.getMatrixAngle(this.mCurrentImageMatrix));
    }

    public void postScale(float f, float f2, float f3) {
        if (f == 0.0f) return;
        this.mCurrentImageMatrix.postScale(f, f, f2, f3);
        this.setImageMatrix(this.mCurrentImageMatrix);
        TransformImageListener transformImageListener = this.mTransformImageListener;
        if (transformImageListener == null) return;
        transformImageListener.onScale(this.getMatrixScale(this.mCurrentImageMatrix));
    }

    public void postTranslate(float f, float f2) {
        if (f == 0.0f) {
            if (f2 == 0.0f) return;
        }
        this.mCurrentImageMatrix.postTranslate(f, f2);
        this.setImageMatrix(this.mCurrentImageMatrix);
    }

    protected void printMatrix(String string, Matrix object) {
        float f = this.getMatrixValue((Matrix)object, 2);
        float f2 = this.getMatrixValue((Matrix)object, 5);
        float f3 = this.getMatrixScale((Matrix)object);
        float f4 = this.getMatrixAngle((Matrix)object);
        object = new StringBuilder();
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(": matrix: { x: ");
        ((StringBuilder)object).append(f);
        ((StringBuilder)object).append(", y: ");
        ((StringBuilder)object).append(f2);
        ((StringBuilder)object).append(", scale: ");
        ((StringBuilder)object).append(f3);
        ((StringBuilder)object).append(", angle: ");
        ((StringBuilder)object).append(f4);
        ((StringBuilder)object).append(" }");
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.setImageDrawable((Drawable)new FastBitmapDrawable(bitmap));
    }

    public void setImageMatrix(Matrix matrix) {
        super.setImageMatrix(matrix);
        this.mCurrentImageMatrix.set(matrix);
        this.updateCurrentImagePoints();
    }

    public void setImageUri(Uri uri, Uri uri2) throws Exception {
        int n = this.getMaxBitmapSize();
        BitmapLoadUtils.decodeBitmapInBackground((Context)this.getContext(), (Uri)uri, (Uri)uri2, (int)n, (int)n, (BitmapLoadCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setMaxBitmapSize(int n) {
        this.mMaxBitmapSize = n;
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX) {
            super.setScaleType(scaleType);
        } else {
            Log.w((String)TAG, (String)"Invalid ScaleType. Only ScaleType.MATRIX can be used");
        }
    }

    public void setTransformImageListener(TransformImageListener transformImageListener) {
        this.mTransformImageListener = transformImageListener;
    }
}
