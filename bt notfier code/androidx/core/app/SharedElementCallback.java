/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.Matrix
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.ImageView$ScaleType
 *  androidx.core.app.SharedElementCallback$OnSharedElementsReadyListener
 */
package androidx.core.app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.SharedElementCallback;
import java.util.List;
import java.util.Map;

public abstract class SharedElementCallback {
    private static final String BUNDLE_SNAPSHOT_BITMAP = "sharedElement:snapshot:bitmap";
    private static final String BUNDLE_SNAPSHOT_IMAGE_MATRIX = "sharedElement:snapshot:imageMatrix";
    private static final String BUNDLE_SNAPSHOT_IMAGE_SCALETYPE = "sharedElement:snapshot:imageScaleType";
    private static final int MAX_IMAGE_SIZE = 0x100000;
    private Matrix mTempMatrix;

    private static Bitmap createDrawableBitmap(Drawable drawable) {
        int n = drawable.getIntrinsicWidth();
        int n2 = drawable.getIntrinsicHeight();
        if (n <= 0) return null;
        if (n2 <= 0) {
            return null;
        }
        float f = Math.min(1.0f, 1048576.0f / (float)(n * n2));
        if (drawable instanceof BitmapDrawable && f == 1.0f) {
            return ((BitmapDrawable)drawable).getBitmap();
        }
        n = (int)((float)n * f);
        int n3 = (int)((float)n2 * f);
        Bitmap bitmap = Bitmap.createBitmap((int)n, (int)n3, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Rect rect = drawable.getBounds();
        int n4 = rect.left;
        n2 = rect.top;
        int n5 = rect.right;
        int n6 = rect.bottom;
        drawable.setBounds(0, 0, n, n3);
        drawable.draw(canvas);
        drawable.setBounds(n4, n2, n5, n6);
        return bitmap;
    }

    public Parcelable onCaptureSharedElementSnapshot(View view, Matrix object, RectF rectF) {
        Drawable drawable;
        ImageView imageView;
        if (view instanceof ImageView) {
            imageView = (ImageView)view;
            drawable = imageView.getDrawable();
            Drawable drawable2 = imageView.getBackground();
            if (drawable != null && drawable2 == null && (drawable = SharedElementCallback.createDrawableBitmap(drawable)) != null) {
                view = new Bundle();
                view.putParcelable(BUNDLE_SNAPSHOT_BITMAP, (Parcelable)drawable);
                view.putString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE, imageView.getScaleType().toString());
                if (imageView.getScaleType() != ImageView.ScaleType.MATRIX) return view;
                rectF = imageView.getImageMatrix();
                object = new float[9];
                rectF.getValues((float[])object);
                view.putFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX, (float[])object);
                return view;
            }
        }
        int n = Math.round(rectF.width());
        int n2 = Math.round(rectF.height());
        drawable = null;
        imageView = drawable;
        if (n <= 0) return imageView;
        imageView = drawable;
        if (n2 <= 0) return imageView;
        float f = Math.min(1.0f, 1048576.0f / (float)(n * n2));
        n = (int)((float)n * f);
        n2 = (int)((float)n2 * f);
        if (this.mTempMatrix == null) {
            this.mTempMatrix = new Matrix();
        }
        this.mTempMatrix.set(object);
        this.mTempMatrix.postTranslate(-rectF.left, -rectF.top);
        this.mTempMatrix.postScale(f, f);
        imageView = Bitmap.createBitmap((int)n, (int)n2, (Bitmap.Config)Bitmap.Config.ARGB_8888);
        object = new Canvas((Bitmap)imageView);
        object.concat(this.mTempMatrix);
        view.draw((Canvas)object);
        return imageView;
    }

    public View onCreateSnapshotView(Context context, Parcelable parcelable) {
        boolean bl = parcelable instanceof Bundle;
        Object object = null;
        if (bl) {
            object = (Bitmap)(parcelable = (Bundle)parcelable).getParcelable(BUNDLE_SNAPSHOT_BITMAP);
            if (object == null) {
                return null;
            }
            context = new ImageView(context);
            context.setImageBitmap(object);
            context.setScaleType(ImageView.ScaleType.valueOf((String)parcelable.getString(BUNDLE_SNAPSHOT_IMAGE_SCALETYPE)));
            object = context;
            if (context.getScaleType() != ImageView.ScaleType.MATRIX) return object;
            object = parcelable.getFloatArray(BUNDLE_SNAPSHOT_IMAGE_MATRIX);
            parcelable = new Matrix();
            parcelable.setValues((float[])object);
            context.setImageMatrix((Matrix)parcelable);
            object = context;
        } else {
            if (!(parcelable instanceof Bitmap)) return object;
            parcelable = (Bitmap)parcelable;
            object = new ImageView(context);
            object.setImageBitmap((Bitmap)parcelable);
        }
        return object;
    }

    public void onMapSharedElements(List<String> list, Map<String, View> map) {
    }

    public void onRejectSharedElements(List<View> list) {
    }

    public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
    }

    public void onSharedElementsArrived(List<String> list, List<View> list2, OnSharedElementsReadyListener onSharedElementsReadyListener) {
        onSharedElementsReadyListener.onSharedElementsReady();
    }
}
