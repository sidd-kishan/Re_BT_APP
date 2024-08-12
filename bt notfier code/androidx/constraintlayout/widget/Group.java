/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;

public class Group
extends ConstraintHelper {
    public Group(Context context) {
        super(context);
    }

    public Group(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public Group(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
    }

    protected void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.mUseViewMeasure = false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.applyLayoutFeatures();
    }

    public void setElevation(float f) {
        super.setElevation(f);
        this.applyLayoutFeatures();
    }

    public void setVisibility(int n) {
        super.setVisibility(n);
        this.applyLayoutFeatures();
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
        constraintLayout = (ConstraintLayout.LayoutParams)this.getLayoutParams();
        constraintLayout.widget.setWidth(0);
        constraintLayout.widget.setHeight(0);
    }
}
