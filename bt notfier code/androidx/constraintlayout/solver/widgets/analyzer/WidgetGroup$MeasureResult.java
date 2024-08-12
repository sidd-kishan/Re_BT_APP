/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.lang.ref.WeakReference;

class WidgetGroup.MeasureResult {
    int baseline;
    int bottom;
    int left;
    int orientation;
    int right;
    final WidgetGroup this$0;
    int top;
    WeakReference<ConstraintWidget> widgetRef;

    public WidgetGroup.MeasureResult(WidgetGroup widgetGroup, ConstraintWidget constraintWidget, LinearSystem linearSystem, int n) {
        this.this$0 = widgetGroup;
        this.widgetRef = new WeakReference<ConstraintWidget>(constraintWidget);
        this.left = linearSystem.getObjectVariableValue((Object)constraintWidget.mLeft);
        this.top = linearSystem.getObjectVariableValue((Object)constraintWidget.mTop);
        this.right = linearSystem.getObjectVariableValue((Object)constraintWidget.mRight);
        this.bottom = linearSystem.getObjectVariableValue((Object)constraintWidget.mBottom);
        this.baseline = linearSystem.getObjectVariableValue((Object)constraintWidget.mBaseline);
        this.orientation = n;
    }

    public void apply() {
        ConstraintWidget constraintWidget = (ConstraintWidget)this.widgetRef.get();
        if (constraintWidget == null) return;
        constraintWidget.setFinalFrame(this.left, this.top, this.right, this.bottom, this.baseline, this.orientation);
    }
}
