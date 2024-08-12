/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewParent
 *  android.widget.ImageView
 *  com.luck.picture.lib.photoview.OnGestureListener
 *  com.luck.picture.lib.photoview.PhotoViewAttacher
 *  com.luck.picture.lib.photoview.PhotoViewAttacher$FlingRunnable
 */
package com.luck.picture.lib.photoview;

import android.view.ViewParent;
import android.widget.ImageView;
import com.luck.picture.lib.photoview.OnGestureListener;
import com.luck.picture.lib.photoview.PhotoViewAttacher;

/*
 * Exception performing whole class analysis ignored.
 */
class PhotoViewAttacher.1
implements OnGestureListener {
    final PhotoViewAttacher this$0;

    PhotoViewAttacher.1(PhotoViewAttacher photoViewAttacher) {
        this.this$0 = photoViewAttacher;
    }

    public void onDrag(float f, float f2) {
        if (PhotoViewAttacher.access$000((PhotoViewAttacher)this.this$0).isScaling()) {
            return;
        }
        if (PhotoViewAttacher.access$100((PhotoViewAttacher)this.this$0) != null) {
            PhotoViewAttacher.access$100((PhotoViewAttacher)this.this$0).onDrag(f, f2);
        }
        PhotoViewAttacher.access$200((PhotoViewAttacher)this.this$0).postTranslate(f, f2);
        PhotoViewAttacher.access$300((PhotoViewAttacher)this.this$0);
        ViewParent viewParent = PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0).getParent();
        if (PhotoViewAttacher.access$500((PhotoViewAttacher)this.this$0) && !PhotoViewAttacher.access$000((PhotoViewAttacher)this.this$0).isScaling() && !PhotoViewAttacher.access$600((PhotoViewAttacher)this.this$0)) {
            if (!(PhotoViewAttacher.access$700((PhotoViewAttacher)this.this$0) == 2 || PhotoViewAttacher.access$700((PhotoViewAttacher)this.this$0) == 0 && f >= 1.0f || PhotoViewAttacher.access$700((PhotoViewAttacher)this.this$0) == 1 && f <= -1.0f || PhotoViewAttacher.access$800((PhotoViewAttacher)this.this$0) == 0 && f2 >= 1.0f)) {
                if (PhotoViewAttacher.access$800((PhotoViewAttacher)this.this$0) != 1) return;
                if (!(f2 <= -1.0f)) return;
            }
            if (viewParent == null) return;
            viewParent.requestDisallowInterceptTouchEvent(false);
        } else {
            if (viewParent == null) return;
            viewParent.requestDisallowInterceptTouchEvent(true);
        }
    }

    public void onFling(float f, float f2, float f3, float f4) {
        PhotoViewAttacher photoViewAttacher = this.this$0;
        PhotoViewAttacher.access$902((PhotoViewAttacher)photoViewAttacher, (PhotoViewAttacher.FlingRunnable)new PhotoViewAttacher.FlingRunnable(photoViewAttacher, PhotoViewAttacher.access$400((PhotoViewAttacher)photoViewAttacher).getContext()));
        photoViewAttacher = PhotoViewAttacher.access$900((PhotoViewAttacher)this.this$0);
        PhotoViewAttacher photoViewAttacher2 = this.this$0;
        int n = PhotoViewAttacher.access$1000((PhotoViewAttacher)photoViewAttacher2, (ImageView)PhotoViewAttacher.access$400((PhotoViewAttacher)photoViewAttacher2));
        photoViewAttacher2 = this.this$0;
        photoViewAttacher.fling(n, PhotoViewAttacher.access$1100((PhotoViewAttacher)photoViewAttacher2, (ImageView)PhotoViewAttacher.access$400((PhotoViewAttacher)photoViewAttacher2)), (int)f3, (int)f4);
        PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0).post((Runnable)PhotoViewAttacher.access$900((PhotoViewAttacher)this.this$0));
    }

    public void onScale(float f, float f2, float f3) {
        if (!(this.this$0.getScale() < PhotoViewAttacher.access$1200((PhotoViewAttacher)this.this$0))) {
            if (!(f < 1.0f)) return;
        }
        if (PhotoViewAttacher.access$1300((PhotoViewAttacher)this.this$0) != null) {
            PhotoViewAttacher.access$1300((PhotoViewAttacher)this.this$0).onScaleChange(f, f2, f3);
        }
        PhotoViewAttacher.access$200((PhotoViewAttacher)this.this$0).postScale(f, f, f2, f3);
        PhotoViewAttacher.access$300((PhotoViewAttacher)this.this$0);
    }
}
