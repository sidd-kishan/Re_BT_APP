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
class CaptureLayout.3
extends AnimatorListenerAdapter {
    final CaptureLayout this$0;

    CaptureLayout.3(CaptureLayout captureLayout) {
        this.this$0 = captureLayout;
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        CaptureLayout.access$400((CaptureLayout)this.this$0).setText((CharSequence)CaptureLayout.access$300((CaptureLayout)this.this$0));
        CaptureLayout.access$400((CaptureLayout)this.this$0).setAlpha(1.0f);
    }
}
