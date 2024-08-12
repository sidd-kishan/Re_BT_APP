/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  com.luck.picture.lib.photoview.CustomGestureDetector
 */
package com.luck.picture.lib.photoview;

import android.view.ScaleGestureDetector;
import com.luck.picture.lib.photoview.CustomGestureDetector;

/*
 * Exception performing whole class analysis ignored.
 */
class CustomGestureDetector.1
implements ScaleGestureDetector.OnScaleGestureListener {
    final CustomGestureDetector this$0;

    CustomGestureDetector.1(CustomGestureDetector customGestureDetector) {
        this.this$0 = customGestureDetector;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float f = scaleGestureDetector.getScaleFactor();
        if (Float.isNaN(f)) return false;
        if (Float.isInfinite(f)) {
            return false;
        }
        if (!(f >= 0.0f)) return true;
        CustomGestureDetector.access$000((CustomGestureDetector)this.this$0).onScale(f, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}
