/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  com.luck.picture.lib.camera.view.CaptureButton
 */
package com.luck.picture.lib.camera.view;

import android.animation.ValueAnimator;
import com.luck.picture.lib.camera.view.CaptureButton;

public final class _$$Lambda$CaptureButton$iiHYE_BWL14LIFcvXf3hzsLEtfs
implements ValueAnimator.AnimatorUpdateListener {
    private final CaptureButton f$0;

    public /* synthetic */ _$$Lambda$CaptureButton$iiHYE_BWL14LIFcvXf3hzsLEtfs(CaptureButton captureButton) {
        this.f$0 = captureButton;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.lambda$startRecordAnimation$2$CaptureButton(valueAnimator);
    }
}
