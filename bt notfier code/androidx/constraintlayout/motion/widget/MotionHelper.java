/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.motion.widget.Animatable
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Animatable;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public class MotionHelper
extends ConstraintHelper
implements Animatable,
MotionLayout.TransitionListener {
    private float mProgress;
    private boolean mUseOnHide = false;
    private boolean mUseOnShow = false;
    protected View[] views;

    public MotionHelper(Context context) {
        super(context);
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(attributeSet);
    }

    public float getProgress() {
        return this.mProgress;
    }

    protected void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet == null) return;
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
        int n = attributeSet.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                attributeSet.recycle();
                return;
            }
            int n3 = attributeSet.getIndex(n2);
            if (n3 == R.styleable.MotionHelper_onShow) {
                this.mUseOnShow = attributeSet.getBoolean(n3, this.mUseOnShow);
            } else if (n3 == R.styleable.MotionHelper_onHide) {
                this.mUseOnHide = attributeSet.getBoolean(n3, this.mUseOnHide);
            }
            ++n2;
        }
    }

    public boolean isUseOnHide() {
        return this.mUseOnHide;
    }

    public boolean isUsedOnShow() {
        return this.mUseOnShow;
    }

    public void onTransitionChange(MotionLayout motionLayout, int n, int n2, float f) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int n) {
    }

    public void onTransitionStarted(MotionLayout motionLayout, int n, int n2) {
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int n, boolean bl, float f) {
    }

    public void setProgress(float f) {
        this.mProgress = f;
        int n = this.mCount;
        int n2 = 0;
        int n3 = 0;
        if (n > 0) {
            this.views = this.getViews((ConstraintLayout)this.getParent());
            n2 = n3;
            while (n2 < this.mCount) {
                this.setProgress(this.views[n2], f);
                ++n2;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup)this.getParent();
        n3 = viewGroup.getChildCount();
        while (n2 < n3) {
            View view = viewGroup.getChildAt(n2);
            if (!(view instanceof MotionHelper)) {
                this.setProgress(view, f);
            }
            ++n2;
        }
    }

    public void setProgress(View view, float f) {
    }
}
