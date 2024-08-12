/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.View
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$animator
 *  com.google.android.material.animation.MotionSpec
 *  com.google.android.material.animation.Positioning
 *  com.google.android.material.transformation.FabTransformationBehavior
 *  com.google.android.material.transformation.FabTransformationBehavior$FabTransformationSpec
 *  com.google.android.material.transformation.FabTransformationScrimBehavior
 */
package com.google.android.material.transformation;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.animation.Positioning;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.google.android.material.transformation.FabTransformationScrimBehavior;
import java.util.HashMap;
import java.util.Map;

public class FabTransformationSheetBehavior
extends FabTransformationBehavior {
    private Map<View, Integer> importantForAccessibilityMap;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void updateImportantForAccessibility(View view, boolean bl) {
        Object object = view.getParent();
        if (!(object instanceof CoordinatorLayout)) {
            return;
        }
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout)object;
        int n = coordinatorLayout.getChildCount();
        if (Build.VERSION.SDK_INT >= 16 && bl) {
            this.importantForAccessibilityMap = new HashMap<View, Integer>(n);
        }
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                if (bl) return;
                this.importantForAccessibilityMap = null;
                return;
            }
            View view2 = coordinatorLayout.getChildAt(n2);
            boolean bl2 = view2.getLayoutParams() instanceof CoordinatorLayout.LayoutParams && ((CoordinatorLayout.LayoutParams)view2.getLayoutParams()).getBehavior() instanceof FabTransformationScrimBehavior;
            if (view2 != view && !bl2) {
                if (!bl) {
                    object = this.importantForAccessibilityMap;
                    if (object != null && object.containsKey(view2)) {
                        ViewCompat.setImportantForAccessibility((View)view2, (int)this.importantForAccessibilityMap.get(view2));
                    }
                } else {
                    if (Build.VERSION.SDK_INT >= 16) {
                        this.importantForAccessibilityMap.put(view2, view2.getImportantForAccessibility());
                    }
                    ViewCompat.setImportantForAccessibility((View)view2, (int)4);
                }
            }
            ++n2;
        }
    }

    protected FabTransformationBehavior.FabTransformationSpec onCreateMotionSpec(Context context, boolean bl) {
        int n = bl ? R.animator.mtrl_fab_transformation_sheet_expand_spec : R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        FabTransformationBehavior.FabTransformationSpec fabTransformationSpec = new FabTransformationBehavior.FabTransformationSpec();
        fabTransformationSpec.timings = MotionSpec.createFromResource((Context)context, (int)n);
        fabTransformationSpec.positioning = new Positioning(17, 0.0f, 0.0f);
        return fabTransformationSpec;
    }

    protected boolean onExpandedStateChange(View view, View view2, boolean bl, boolean bl2) {
        this.updateImportantForAccessibility(view2, bl);
        return super.onExpandedStateChange(view, view2, bl, bl2);
    }
}
