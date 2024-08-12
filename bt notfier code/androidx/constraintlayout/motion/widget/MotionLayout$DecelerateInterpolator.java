/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.widget.MotionInterpolator
 *  androidx.constraintlayout.motion.widget.MotionLayout
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;

class MotionLayout.DecelerateInterpolator
extends MotionInterpolator {
    float currentP;
    float initalV;
    float maxA;
    final MotionLayout this$0;

    MotionLayout.DecelerateInterpolator(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
        this.initalV = 0.0f;
        this.currentP = 0.0f;
    }

    public void config(float f, float f2, float f3) {
        this.initalV = f;
        this.currentP = f2;
        this.maxA = f3;
    }

    public float getInterpolation(float f) {
        float f2;
        float f3 = this.initalV;
        if (f3 > 0.0f) {
            float f4 = this.maxA;
            f2 = f;
            if (f3 / f4 < f) {
                f2 = f3 / f4;
            }
            this.this$0.mLastVelocity = this.initalV - this.maxA * f2;
            f2 = this.initalV * f2 - this.maxA * f2 * f2 / 2.0f;
            f = this.currentP;
        } else {
            float f5 = -f3;
            float f6 = this.maxA;
            f2 = f;
            if (f5 / f6 < f) {
                f2 = -f3 / f6;
            }
            this.this$0.mLastVelocity = this.initalV + this.maxA * f2;
            f2 = this.initalV * f2 + this.maxA * f2 * f2 / 2.0f;
            f = this.currentP;
        }
        return f2 + f;
    }

    public float getVelocity() {
        return this.this$0.mLastVelocity;
    }
}
