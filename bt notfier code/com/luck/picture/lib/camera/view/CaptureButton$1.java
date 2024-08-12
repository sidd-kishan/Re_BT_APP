/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.luck.picture.lib.camera.view.CaptureButton
 */
package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luck.picture.lib.camera.view.CaptureButton;

/*
 * Exception performing whole class analysis ignored.
 */
class CaptureButton.1
extends AnimatorListenerAdapter {
    final CaptureButton this$0;

    CaptureButton.1(CaptureButton captureButton) {
        this.this$0 = captureButton;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        if (CaptureButton.access$100((CaptureButton)this.this$0) != null) {
            CaptureButton.access$100((CaptureButton)this.this$0).takePictures();
        }
        CaptureButton.access$202((CaptureButton)this.this$0, (int)5);
    }
}
