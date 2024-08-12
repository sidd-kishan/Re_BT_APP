/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.util.Size
 *  android.view.View
 *  android.widget.FrameLayout
 *  androidx.camera.core.SurfaceRequest
 *  androidx.camera.view.PreviewTransformation
 *  androidx.camera.view.PreviewViewImplementation$OnSurfaceNotInUseListener
 */
package androidx.camera.view;

import android.graphics.Bitmap;
import android.util.Size;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.view.PreviewTransformation;
import androidx.camera.view.PreviewViewImplementation;
import com.google.common.util.concurrent.ListenableFuture;

abstract class PreviewViewImplementation {
    FrameLayout mParent;
    private final PreviewTransformation mPreviewTransform;
    Size mResolution;

    PreviewViewImplementation(FrameLayout frameLayout, PreviewTransformation previewTransformation) {
        this.mParent = frameLayout;
        this.mPreviewTransform = previewTransformation;
    }

    Bitmap getBitmap() {
        Bitmap bitmap = this.getPreviewBitmap();
        if (bitmap != null) return this.mPreviewTransform.createTransformedBitmap(bitmap, new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection());
        return null;
    }

    abstract View getPreview();

    abstract Bitmap getPreviewBitmap();

    abstract void initializePreview();

    abstract void onAttachedToWindow();

    abstract void onDetachedFromWindow();

    void onSurfaceProvided() {
        this.redrawPreview();
    }

    abstract void onSurfaceRequested(SurfaceRequest var1, OnSurfaceNotInUseListener var2);

    void redrawPreview() {
        View view = this.getPreview();
        if (view == null) {
            return;
        }
        this.mPreviewTransform.transformView(new Size(this.mParent.getWidth(), this.mParent.getHeight()), this.mParent.getLayoutDirection(), view);
    }

    abstract ListenableFuture<Void> waitForNextFrame();
}
