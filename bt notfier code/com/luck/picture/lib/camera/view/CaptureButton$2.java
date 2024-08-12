/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.luck.picture.lib.camera.view.CaptureButton
 *  com.luck.picture.lib.tools.DoubleUtils
 */
package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luck.picture.lib.camera.view.CaptureButton;
import com.luck.picture.lib.tools.DoubleUtils;

/*
 * Exception performing whole class analysis ignored.
 */
class CaptureButton.2
extends AnimatorListenerAdapter {
    final CaptureButton this$0;

    CaptureButton.2(CaptureButton captureButton) {
        this.this$0 = captureButton;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (DoubleUtils.isFastDoubleClick()) {
            return;
        }
        if (CaptureButton.access$200((CaptureButton)this.this$0) == 3) {
            if (CaptureButton.access$100((CaptureButton)this.this$0) != null) {
                CaptureButton.access$100((CaptureButton)this.this$0).recordStart();
            }
            CaptureButton.access$202((CaptureButton)this.this$0, (int)4);
            CaptureButton.access$300((CaptureButton)this.this$0).start();
        } else {
            CaptureButton.access$202((CaptureButton)this.this$0, (int)1);
        }
    }
}
