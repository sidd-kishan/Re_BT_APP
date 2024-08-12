/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ConstraintSet.PropertySet {
    public float alpha = 1.0f;
    public boolean mApply = false;
    public float mProgress = Float.NaN;
    public int mVisibilityMode = 0;
    public int visibility = 0;

    public void copyFrom(ConstraintSet.PropertySet propertySet) {
        this.mApply = propertySet.mApply;
        this.visibility = propertySet.visibility;
        this.alpha = propertySet.alpha;
        this.mProgress = propertySet.mProgress;
        this.mVisibilityMode = propertySet.mVisibilityMode;
    }

    void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.PropertySet);
        this.mApply = true;
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                return;
            }
            int n3 = context.getIndex(n2);
            if (n3 == R.styleable.PropertySet_android_alpha) {
                this.alpha = context.getFloat(n3, this.alpha);
            } else if (n3 == R.styleable.PropertySet_android_visibility) {
                this.visibility = context.getInt(n3, this.visibility);
                this.visibility = ConstraintSet.access$200()[this.visibility];
            } else if (n3 == R.styleable.PropertySet_visibilityMode) {
                this.mVisibilityMode = context.getInt(n3, this.mVisibilityMode);
            } else if (n3 == R.styleable.PropertySet_motionProgress) {
                this.mProgress = context.getFloat(n3, this.mProgress);
            }
            ++n2;
        }
    }
}
