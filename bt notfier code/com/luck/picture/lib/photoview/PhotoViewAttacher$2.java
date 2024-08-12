/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.GestureDetector$SimpleOnGestureListener
 *  android.view.MotionEvent
 *  android.view.View
 *  com.luck.picture.lib.photoview.PhotoViewAttacher
 */
package com.luck.picture.lib.photoview;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.luck.picture.lib.photoview.PhotoViewAttacher;

/*
 * Exception performing whole class analysis ignored.
 */
class PhotoViewAttacher.2
extends GestureDetector.SimpleOnGestureListener {
    final PhotoViewAttacher this$0;

    PhotoViewAttacher.2(PhotoViewAttacher photoViewAttacher) {
        this.this$0 = photoViewAttacher;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (PhotoViewAttacher.access$1500((PhotoViewAttacher)this.this$0) == null) return false;
        if (this.this$0.getScale() > PhotoViewAttacher.access$1600()) {
            return false;
        }
        if (motionEvent.getPointerCount() > PhotoViewAttacher.access$1700()) return false;
        if (motionEvent2.getPointerCount() <= PhotoViewAttacher.access$1700()) return PhotoViewAttacher.access$1500((PhotoViewAttacher)this.this$0).onFling(motionEvent, motionEvent2, f, f2);
        return false;
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (PhotoViewAttacher.access$1400((PhotoViewAttacher)this.this$0) == null) return;
        PhotoViewAttacher.access$1400((PhotoViewAttacher)this.this$0).onLongClick((View)PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0));
    }
}
