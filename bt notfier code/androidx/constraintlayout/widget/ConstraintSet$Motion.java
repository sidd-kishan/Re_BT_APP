/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.SparseIntArray
 *  androidx.constraintlayout.motion.utils.Easing
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;

/*
 * Exception performing whole class analysis ignored.
 */
public static class ConstraintSet.Motion {
    private static final int ANIMATE_RELATIVE_TO = 5;
    private static final int MOTION_DRAW_PATH = 4;
    private static final int MOTION_STAGGER = 6;
    private static final int PATH_MOTION_ARC = 2;
    private static final int TRANSITION_EASING = 3;
    private static final int TRANSITION_PATH_ROTATE = 1;
    private static SparseIntArray mapToConstant;
    public int mAnimateRelativeTo = -1;
    public boolean mApply = false;
    public int mDrawPath = 0;
    public float mMotionStagger = Float.NaN;
    public int mPathMotionArc = -1;
    public float mPathRotate = Float.NaN;
    public String mTransitionEasing = null;

    static {
        SparseIntArray sparseIntArray;
        mapToConstant = sparseIntArray = new SparseIntArray();
        sparseIntArray.append(R.styleable.Motion_motionPathRotate, 1);
        mapToConstant.append(R.styleable.Motion_pathMotionArc, 2);
        mapToConstant.append(R.styleable.Motion_transitionEasing, 3);
        mapToConstant.append(R.styleable.Motion_drawPath, 4);
        mapToConstant.append(R.styleable.Motion_animate_relativeTo, 5);
        mapToConstant.append(R.styleable.Motion_motionStagger, 6);
    }

    public void copyFrom(ConstraintSet.Motion motion) {
        this.mApply = motion.mApply;
        this.mAnimateRelativeTo = motion.mAnimateRelativeTo;
        this.mTransitionEasing = motion.mTransitionEasing;
        this.mPathMotionArc = motion.mPathMotionArc;
        this.mDrawPath = motion.mDrawPath;
        this.mPathRotate = motion.mPathRotate;
        this.mMotionStagger = motion.mMotionStagger;
    }

    void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        context = context.obtainStyledAttributes(attributeSet, R.styleable.Motion);
        this.mApply = true;
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                return;
            }
            int n3 = context.getIndex(n2);
            switch (mapToConstant.get(n3)) {
                default: {
                    break;
                }
                case 6: {
                    this.mMotionStagger = context.getFloat(n3, this.mMotionStagger);
                    break;
                }
                case 5: {
                    this.mAnimateRelativeTo = ConstraintSet.access$100((TypedArray)context, (int)n3, (int)this.mAnimateRelativeTo);
                    break;
                }
                case 4: {
                    this.mDrawPath = context.getInt(n3, 0);
                    break;
                }
                case 3: {
                    if (context.peekValue((int)n3).type == 3) {
                        this.mTransitionEasing = context.getString(n3);
                        break;
                    }
                    this.mTransitionEasing = Easing.NAMED_EASING[context.getInteger(n3, 0)];
                    break;
                }
                case 2: {
                    this.mPathMotionArc = context.getInt(n3, this.mPathMotionArc);
                    break;
                }
                case 1: {
                    this.mPathRotate = context.getFloat(n3, this.mPathRotate);
                }
            }
            ++n2;
        }
    }
}
