/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Matrix
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.View$OnClickListener
 *  android.view.View$OnLongClickListener
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.appcompat.widget.AppCompatImageView
 *  com.luck.picture.lib.photoview.OnMatrixChangedListener
 *  com.luck.picture.lib.photoview.OnOutsidePhotoTapListener
 *  com.luck.picture.lib.photoview.OnPhotoTapListener
 *  com.luck.picture.lib.photoview.OnScaleChangedListener
 *  com.luck.picture.lib.photoview.OnSingleFlingListener
 *  com.luck.picture.lib.photoview.OnViewDragListener
 *  com.luck.picture.lib.photoview.OnViewTapListener
 *  com.luck.picture.lib.photoview.PhotoViewAttacher
 */
package com.luck.picture.lib.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.luck.picture.lib.photoview.OnMatrixChangedListener;
import com.luck.picture.lib.photoview.OnOutsidePhotoTapListener;
import com.luck.picture.lib.photoview.OnPhotoTapListener;
import com.luck.picture.lib.photoview.OnScaleChangedListener;
import com.luck.picture.lib.photoview.OnSingleFlingListener;
import com.luck.picture.lib.photoview.OnViewDragListener;
import com.luck.picture.lib.photoview.OnViewTapListener;
import com.luck.picture.lib.photoview.PhotoViewAttacher;

public class PhotoView
extends AppCompatImageView {
    private PhotoViewAttacher attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init();
    }

    private void init() {
        this.attacher = new PhotoViewAttacher((ImageView)this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType == null) return;
        this.setScaleType(scaleType);
        this.pendingScaleType = null;
    }

    public PhotoViewAttacher getAttacher() {
        return this.attacher;
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.attacher.getDisplayMatrix(matrix);
    }

    public RectF getDisplayRect() {
        return this.attacher.getDisplayRect();
    }

    public Matrix getImageMatrix() {
        return this.attacher.getImageMatrix();
    }

    public float getMaximumScale() {
        return this.attacher.getMaximumScale();
    }

    public float getMediumScale() {
        return this.attacher.getMediumScale();
    }

    public float getMinimumScale() {
        return this.attacher.getMinimumScale();
    }

    public float getScale() {
        return this.attacher.getScale();
    }

    public ImageView.ScaleType getScaleType() {
        return this.attacher.getScaleType();
    }

    public void getSuppMatrix(Matrix matrix) {
        this.attacher.getSuppMatrix(matrix);
    }

    public boolean isZoomable() {
        return this.attacher.isZoomable();
    }

    public void setAllowParentInterceptOnEdge(boolean bl) {
        this.attacher.setAllowParentInterceptOnEdge(bl);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    protected boolean setFrame(int n, int n2, int n3, int n4) {
        boolean bl = super.setFrame(n, n2, n3, n4);
        if (!bl) return bl;
        this.attacher.update();
        return bl;
    }

    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        drawable = this.attacher;
        if (drawable == null) return;
        drawable.update();
    }

    public void setImageResource(int n) {
        super.setImageResource(n);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) return;
        photoViewAttacher.update();
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        uri = this.attacher;
        if (uri == null) return;
        uri.update();
    }

    public void setMaximumScale(float f) {
        this.attacher.setMaximumScale(f);
    }

    public void setMediumScale(float f) {
        this.attacher.setMediumScale(f);
    }

    public void setMinimumScale(float f) {
        this.attacher.setMinimumScale(f);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.attacher.setOnClickListener(onClickListener);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.attacher.setOnLongClickListener(onLongClickListener);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.attacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.attacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.attacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.attacher.setOnSingleFlingListener(onSingleFlingListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.attacher.setOnViewDragListener(onViewDragListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.attacher.setOnViewTapListener(onViewTapListener);
    }

    public void setRotationBy(float f) {
        this.attacher.setRotationBy(f);
    }

    public void setRotationTo(float f) {
        this.attacher.setRotationTo(f);
    }

    public void setScale(float f) {
        this.attacher.setScale(f);
    }

    public void setScale(float f, float f2, float f3, boolean bl) {
        this.attacher.setScale(f, f2, f3, bl);
    }

    public void setScale(float f, boolean bl) {
        this.attacher.setScale(f, bl);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.attacher.setScaleLevels(f, f2, f3);
    }

    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) {
            this.pendingScaleType = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    public void setZoomTransitionDuration(int n) {
        this.attacher.setZoomTransitionDuration(n);
    }

    public void setZoomable(boolean bl) {
        this.attacher.setZoomable(bl);
    }
}
