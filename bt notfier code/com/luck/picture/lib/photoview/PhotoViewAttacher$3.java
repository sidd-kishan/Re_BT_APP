/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.view.GestureDetector$OnDoubleTapListener
 *  android.view.MotionEvent
 *  android.view.View
 *  com.luck.picture.lib.photoview.PhotoViewAttacher
 */
package com.luck.picture.lib.photoview;

import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.luck.picture.lib.photoview.PhotoViewAttacher;

/*
 * Exception performing whole class analysis ignored.
 */
class PhotoViewAttacher.3
implements GestureDetector.OnDoubleTapListener {
    final PhotoViewAttacher this$0;

    PhotoViewAttacher.3(PhotoViewAttacher photoViewAttacher) {
        this.this$0 = photoViewAttacher;
    }

    /*
     * Enabled force condition propagation
     */
    public boolean onDoubleTap(MotionEvent motionEvent) {
        try {
            float f = this.this$0.getScale();
            float f2 = motionEvent.getX();
            float f3 = motionEvent.getY();
            if (f < this.this$0.getMediumScale()) {
                this.this$0.setScale(this.this$0.getMediumScale(), f2, f3, true);
                return true;
            }
            if (f >= this.this$0.getMediumScale() && f < this.this$0.getMaximumScale()) {
                this.this$0.setScale(this.this$0.getMaximumScale(), f2, f3, true);
                return true;
            }
            this.this$0.setScale(this.this$0.getMinimumScale(), f2, f3, true);
            return true;
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            return true;
        }
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (PhotoViewAttacher.access$1800((PhotoViewAttacher)this.this$0) != null) {
            PhotoViewAttacher.access$1800((PhotoViewAttacher)this.this$0).onClick((View)PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0));
        }
        RectF rectF = this.this$0.getDisplayRect();
        float f = motionEvent.getX();
        float f2 = motionEvent.getY();
        if (PhotoViewAttacher.access$1900((PhotoViewAttacher)this.this$0) != null) {
            PhotoViewAttacher.access$1900((PhotoViewAttacher)this.this$0).onViewTap((View)PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0), f, f2);
        }
        if (rectF == null) return false;
        if (rectF.contains(f, f2)) {
            f = (f - rectF.left) / rectF.width();
            f2 = (f2 - rectF.top) / rectF.height();
            if (PhotoViewAttacher.access$2000((PhotoViewAttacher)this.this$0) == null) return true;
            PhotoViewAttacher.access$2000((PhotoViewAttacher)this.this$0).onPhotoTap(PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0), f, f2);
            return true;
        }
        if (PhotoViewAttacher.access$2100((PhotoViewAttacher)this.this$0) == null) return false;
        PhotoViewAttacher.access$2100((PhotoViewAttacher)this.this$0).onOutsidePhotoTap(PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0));
        return false;
    }
}
