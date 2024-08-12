/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  com.luck.picture.lib.camera.view.CaptureLayout
 */
package com.luck.picture.lib.camera.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luck.picture.lib.camera.view.CaptureLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class CaptureLayout.1
extends AnimatorListenerAdapter {
    final CaptureLayout this$0;

    CaptureLayout.1(CaptureLayout captureLayout) {
        this.this$0 = captureLayout;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CaptureLayout.access$000((CaptureLayout)this.this$0).setClickable(true);
        CaptureLayout.access$100((CaptureLayout)this.this$0).setClickable(true);
    }
}
