/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.luck.picture.lib.camera.listener.CaptureListener
 *  com.luck.picture.lib.camera.view.CaptureLayout
 */
package com.luck.picture.lib.camera.view;

import com.luck.picture.lib.camera.listener.CaptureListener;
import com.luck.picture.lib.camera.view.CaptureLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CaptureLayout.2
implements CaptureListener {
    final CaptureLayout this$0;

    CaptureLayout.2(CaptureLayout captureLayout) {
        this.this$0 = captureLayout;
    }

    public void recordEnd(long l) {
        if (CaptureLayout.access$200((CaptureLayout)this.this$0) != null) {
            CaptureLayout.access$200((CaptureLayout)this.this$0).recordEnd(l);
        }
        this.this$0.startTypeBtnAnimator();
    }

    public void recordError() {
        if (CaptureLayout.access$200((CaptureLayout)this.this$0) == null) return;
        CaptureLayout.access$200((CaptureLayout)this.this$0).recordError();
    }

    public void recordShort(long l) {
        if (CaptureLayout.access$200((CaptureLayout)this.this$0) == null) return;
        CaptureLayout.access$200((CaptureLayout)this.this$0).recordShort(l);
    }

    public void recordStart() {
        if (CaptureLayout.access$200((CaptureLayout)this.this$0) != null) {
            CaptureLayout.access$200((CaptureLayout)this.this$0).recordStart();
        }
        this.this$0.startAlphaAnimation();
    }

    public void recordZoom(float f) {
        if (CaptureLayout.access$200((CaptureLayout)this.this$0) == null) return;
        CaptureLayout.access$200((CaptureLayout)this.this$0).recordZoom(f);
    }

    public void takePictures() {
        if (CaptureLayout.access$200((CaptureLayout)this.this$0) != null) {
            CaptureLayout.access$200((CaptureLayout)this.this$0).takePictures();
        }
        this.this$0.startAlphaAnimation();
    }
}
