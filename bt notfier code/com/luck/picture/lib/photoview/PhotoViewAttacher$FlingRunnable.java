/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.RectF
 *  android.view.View
 *  android.widget.OverScroller
 *  com.luck.picture.lib.photoview.Compat
 *  com.luck.picture.lib.photoview.PhotoViewAttacher
 */
package com.luck.picture.lib.photoview;

import android.content.Context;
import android.graphics.RectF;
import android.view.View;
import android.widget.OverScroller;
import com.luck.picture.lib.photoview.Compat;
import com.luck.picture.lib.photoview.PhotoViewAttacher;

/*
 * Exception performing whole class analysis ignored.
 */
private class PhotoViewAttacher.FlingRunnable
implements Runnable {
    private int mCurrentX;
    private int mCurrentY;
    private final OverScroller mScroller;
    final PhotoViewAttacher this$0;

    public PhotoViewAttacher.FlingRunnable(PhotoViewAttacher photoViewAttacher, Context context) {
        this.this$0 = photoViewAttacher;
        this.mScroller = new OverScroller(context);
    }

    public void cancelFling() {
        this.mScroller.forceFinished(true);
    }

    public void fling(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        RectF rectF = this.this$0.getDisplayRect();
        if (rectF == null) {
            return;
        }
        int n7 = Math.round(-rectF.left);
        float f = n;
        if (f < rectF.width()) {
            n6 = Math.round(rectF.width() - f);
            n5 = 0;
        } else {
            n6 = n = n7;
            n5 = n;
        }
        int n8 = Math.round(-rectF.top);
        f = n2;
        if (f < rectF.height()) {
            n2 = Math.round(rectF.height() - f);
            n = 0;
        } else {
            n2 = n = n8;
        }
        this.mCurrentX = n7;
        this.mCurrentY = n8;
        if (n7 == n6) {
            if (n8 == n2) return;
        }
        this.mScroller.fling(n7, n8, n3, n4, n5, n6, n, n2, 0, 0);
    }

    @Override
    public void run() {
        if (this.mScroller.isFinished()) {
            return;
        }
        if (!this.mScroller.computeScrollOffset()) return;
        int n = this.mScroller.getCurrX();
        int n2 = this.mScroller.getCurrY();
        PhotoViewAttacher.access$200((PhotoViewAttacher)this.this$0).postTranslate((float)(this.mCurrentX - n), (float)(this.mCurrentY - n2));
        PhotoViewAttacher.access$300((PhotoViewAttacher)this.this$0);
        this.mCurrentX = n;
        this.mCurrentY = n2;
        Compat.postOnAnimation((View)PhotoViewAttacher.access$400((PhotoViewAttacher)this.this$0), (Runnable)this);
    }
}
