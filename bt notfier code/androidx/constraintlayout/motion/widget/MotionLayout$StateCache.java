/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.MotionLayout$TransitionState
 */
package androidx.constraintlayout.motion.widget;

import android.os.Bundle;
import androidx.constraintlayout.motion.widget.MotionLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class MotionLayout.StateCache {
    final String KeyEndState;
    final String KeyProgress;
    final String KeyStartState;
    final String KeyVelocity;
    int endState;
    float mProgress;
    float mVelocity;
    int startState;
    final MotionLayout this$0;

    MotionLayout.StateCache(MotionLayout motionLayout) {
        this.this$0 = motionLayout;
        this.mProgress = Float.NaN;
        this.mVelocity = Float.NaN;
        this.startState = -1;
        this.endState = -1;
        this.KeyProgress = "motion.progress";
        this.KeyVelocity = "motion.velocity";
        this.KeyStartState = "motion.StartState";
        this.KeyEndState = "motion.EndState";
    }

    void apply() {
        if (this.startState != -1 || this.endState != -1) {
            int n = this.startState;
            if (n == -1) {
                this.this$0.transitionToState(this.endState);
            } else {
                int n2 = this.endState;
                if (n2 == -1) {
                    this.this$0.setState(n, -1, -1);
                } else {
                    this.this$0.setTransition(n, n2);
                }
            }
            this.this$0.setState(MotionLayout.TransitionState.SETUP);
        }
        if (!Float.isNaN(this.mVelocity)) {
            this.this$0.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = Float.NaN;
            this.mVelocity = Float.NaN;
            this.startState = -1;
            this.endState = -1;
            return;
        }
        if (Float.isNaN(this.mProgress)) {
            return;
        }
        this.this$0.setProgress(this.mProgress);
    }

    public Bundle getTransitionState() {
        Bundle bundle = new Bundle();
        bundle.putFloat("motion.progress", this.mProgress);
        bundle.putFloat("motion.velocity", this.mVelocity);
        bundle.putInt("motion.StartState", this.startState);
        bundle.putInt("motion.EndState", this.endState);
        return bundle;
    }

    public void recordState() {
        this.endState = MotionLayout.access$000((MotionLayout)this.this$0);
        this.startState = MotionLayout.access$100((MotionLayout)this.this$0);
        this.mVelocity = this.this$0.getVelocity();
        this.mProgress = this.this$0.getProgress();
    }

    public void setEndState(int n) {
        this.endState = n;
    }

    public void setProgress(float f) {
        this.mProgress = f;
    }

    public void setStartState(int n) {
        this.startState = n;
    }

    public void setTransitionState(Bundle bundle) {
        this.mProgress = bundle.getFloat("motion.progress");
        this.mVelocity = bundle.getFloat("motion.velocity");
        this.startState = bundle.getInt("motion.StartState");
        this.endState = bundle.getInt("motion.EndState");
    }

    public void setVelocity(float f) {
        this.mVelocity = f;
    }
}
