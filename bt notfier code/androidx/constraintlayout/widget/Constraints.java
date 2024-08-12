/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.Constraints$LayoutParams
 */
package androidx.constraintlayout.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

public class Constraints
extends ViewGroup {
    public static final String TAG = "Constraints";
    ConstraintSet myConstraintSet;

    public Constraints(Context context) {
        super(context);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.init(attributeSet);
        super.setVisibility(8);
    }

    public Constraints(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.init(attributeSet);
        super.setVisibility(8);
    }

    private void init(AttributeSet attributeSet) {
        Log.v((String)TAG, (String)" ################# init");
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ConstraintLayout.LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    public ConstraintSet getConstraintSet() {
        if (this.myConstraintSet == null) {
            this.myConstraintSet = new ConstraintSet();
        }
        this.myConstraintSet.clone(this);
        return this.myConstraintSet;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
    }
}
