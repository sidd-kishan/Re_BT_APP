/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.animation.Interpolator
 *  androidx.constraintlayout.motion.utils.Easing
 *  androidx.constraintlayout.motion.widget.MotionScene
 */
package androidx.constraintlayout.motion.widget;

import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.widget.MotionScene;

class MotionScene.1
implements Interpolator {
    final MotionScene this$0;
    final Easing val$easing;

    MotionScene.1(MotionScene motionScene, Easing easing) {
        this.this$0 = motionScene;
        this.val$easing = easing;
    }

    public float getInterpolation(float f) {
        return (float)this.val$easing.get((double)f);
    }
}
