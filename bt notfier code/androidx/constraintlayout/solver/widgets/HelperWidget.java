/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Helper
 *  androidx.constraintlayout.solver.widgets.analyzer.Grouping
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.Grouping;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HelperWidget
extends ConstraintWidget
implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget == this) return;
        if (constraintWidget == null) return;
        int n = this.mWidgetsCount;
        ConstraintWidget[] constraintWidgetArray = this.mWidgets;
        if (n + 1 > constraintWidgetArray.length) {
            this.mWidgets = Arrays.copyOf(constraintWidgetArray, constraintWidgetArray.length * 2);
        }
        constraintWidgetArray = this.mWidgets;
        n = this.mWidgetsCount;
        constraintWidgetArray[n] = constraintWidget;
        this.mWidgetsCount = n + 1;
    }

    public void addDependents(ArrayList<WidgetGroup> arrayList, int n, WidgetGroup widgetGroup) {
        int n2 = 0;
        int n3 = 0;
        while (true) {
            int n4 = n2;
            if (n3 >= this.mWidgetsCount) {
                while (n4 < this.mWidgetsCount) {
                    Grouping.findDependents((ConstraintWidget)this.mWidgets[n4], (int)n, arrayList, (WidgetGroup)widgetGroup);
                    ++n4;
                }
                return;
            }
            widgetGroup.add(this.mWidgets[n3]);
            ++n3;
        }
    }

    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        constraintWidget = (HelperWidget)constraintWidget;
        int n = 0;
        this.mWidgetsCount = 0;
        int n2 = constraintWidget.mWidgetsCount;
        while (n < n2) {
            this.add(hashMap.get(constraintWidget.mWidgets[n]));
            ++n;
        }
    }

    public int findGroupInDependents(int n) {
        int n2 = 0;
        while (n2 < this.mWidgetsCount) {
            ConstraintWidget constraintWidget = this.mWidgets[n2];
            if (n == 0 && constraintWidget.horizontalGroup != -1) {
                return constraintWidget.horizontalGroup;
            }
            if (n == 1 && constraintWidget.verticalGroup != -1) {
                return constraintWidget.verticalGroup;
            }
            ++n2;
        }
        return -1;
    }

    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, null);
    }

    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
