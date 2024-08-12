/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewParent
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;

public abstract class VirtualLayout
extends ConstraintHelper {
    private boolean mApplyElevationOnAttach;
    private boolean mApplyVisibilityOnAttach;

    public VirtualLayout(Context context) {
        super(context);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VirtualLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    protected void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet == null) return;
        attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
        int n = attributeSet.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                attributeSet.recycle();
                return;
            }
            int n3 = attributeSet.getIndex(n2);
            if (n3 == R.styleable.ConstraintLayout_Layout_android_visibility) {
                this.mApplyVisibilityOnAttach = true;
            } else if (n3 == R.styleable.ConstraintLayout_Layout_android_elevation) {
                this.mApplyElevationOnAttach = true;
            }
            ++n2;
        }
    }

    public void onAttachedToWindow() {
        ViewParent viewParent;
        super.onAttachedToWindow();
        if (!this.mApplyVisibilityOnAttach) {
            if (!this.mApplyElevationOnAttach) return;
        }
        if ((viewParent = this.getParent()) == null) return;
        if (!(viewParent instanceof ConstraintLayout)) return;
        viewParent = (ConstraintLayout)viewParent;
        int n = this.getVisibility();
        float f = Build.VERSION.SDK_INT >= 21 ? this.getElevation() : 0.0f;
        int n2 = 0;
        while (n2 < this.mCount) {
            View view = viewParent.getViewById(this.mIds[n2]);
            if (view != null) {
                if (this.mApplyVisibilityOnAttach) {
                    view.setVisibility(n);
                }
                if (this.mApplyElevationOnAttach && f > 0.0f && Build.VERSION.SDK_INT >= 21) {
                    view.setTranslationZ(view.getTranslationZ() + f);
                }
            }
            ++n2;
        }
    }

    public void onMeasure(androidx.constraintlayout.solver.widgets.VirtualLayout virtualLayout, int n, int n2) {
    }

    public void setElevation(float f) {
        super.setElevation(f);
        this.applyLayoutFeatures();
    }

    public void setVisibility(int n) {
        super.setVisibility(n);
        this.applyLayoutFeatures();
    }
}
