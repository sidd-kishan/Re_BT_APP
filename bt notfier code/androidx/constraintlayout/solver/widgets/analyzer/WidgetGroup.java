/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.widgets.Chain
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup$MeasureResult
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Chain;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Iterator;

public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int count;
    boolean authoritative = false;
    int id = -1;
    private int moveTo = -1;
    int orientation = 0;
    ArrayList<MeasureResult> results = null;
    ArrayList<ConstraintWidget> widgets = new ArrayList();

    public WidgetGroup(int n) {
        int n2 = count;
        count = n2 + 1;
        this.id = n2;
        this.orientation = n;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.widgets.contains(constraintWidget);
    }

    private String getOrientationString() {
        int n = this.orientation;
        if (n == 0) {
            return "Horizontal";
        }
        if (n == 1) {
            return "Vertical";
        }
        if (n != 2) return "Unknown";
        return "Both";
    }

    private int measureWrap(int n, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(n);
        if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.MATCH_PARENT) {
            if (dimensionBehaviour != ConstraintWidget.DimensionBehaviour.FIXED) return -1;
        }
        n = n == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight();
        return n;
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int n) {
        int n2;
        int n3 = 0;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer)arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (n2 = 0; n2 < arrayList.size(); ++n2) {
            arrayList.get(n2).addToSolver(linearSystem, false);
        }
        if (n == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints((ConstraintWidgetContainer)constraintWidgetContainer, (LinearSystem)linearSystem, arrayList, (int)0);
        }
        if (n == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints((ConstraintWidgetContainer)constraintWidgetContainer, (LinearSystem)linearSystem, arrayList, (int)1);
        }
        try {
            linearSystem.minimize();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.results = new ArrayList();
        for (n2 = n3; n2 < arrayList.size(); ++n2) {
            MeasureResult measureResult = new MeasureResult(this, arrayList.get(n2), linearSystem, n);
            this.results.add(measureResult);
        }
        if (n == 0) {
            n = linearSystem.getObjectVariableValue((Object)constraintWidgetContainer.mLeft);
            n2 = linearSystem.getObjectVariableValue((Object)constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            n = linearSystem.getObjectVariableValue((Object)constraintWidgetContainer.mTop);
            n2 = linearSystem.getObjectVariableValue((Object)constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return n2 - n;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.widgets.contains(constraintWidget)) {
            return false;
        }
        this.widgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.results == null) {
            return;
        }
        if (!this.authoritative) {
            return;
        }
        int n = 0;
        while (n < this.results.size()) {
            this.results.get(n).apply();
            ++n;
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int n = this.widgets.size();
        if (this.moveTo != -1 && n > 0) {
            for (int i = 0; i < arrayList.size(); ++i) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.moveTo != widgetGroup.id) continue;
                this.moveTo(this.orientation, widgetGroup);
            }
        }
        if (n != 0) return;
        arrayList.remove(this);
    }

    public void clear() {
        this.widgets.clear();
    }

    public int getId() {
        return this.id;
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        int n = 0;
        while (n < this.widgets.size()) {
            if (widgetGroup.contains(this.widgets.get(n))) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.authoritative;
    }

    public int measureWrap(LinearSystem linearSystem, int n) {
        if (this.widgets.size() != 0) return this.solverMeasure(linearSystem, this.widgets, n);
        return 0;
    }

    public void moveTo(int n, WidgetGroup widgetGroup) {
        Iterator<ConstraintWidget> iterator = this.widgets.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.moveTo = widgetGroup.id;
                return;
            }
            ConstraintWidget constraintWidget = iterator.next();
            widgetGroup.add(constraintWidget);
            if (n == 0) {
                constraintWidget.horizontalGroup = widgetGroup.getId();
                continue;
            }
            constraintWidget.verticalGroup = widgetGroup.getId();
        }
    }

    public void setAuthoritative(boolean bl) {
        this.authoritative = bl;
    }

    public void setOrientation(int n) {
        this.orientation = n;
    }

    public int size() {
        return this.widgets.size();
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append(this.getOrientationString());
        charSequence.append(" [");
        charSequence.append(this.id);
        charSequence.append("] <");
        charSequence = charSequence.toString();
        Object object = this.widgets.iterator();
        while (true) {
            if (!object.hasNext()) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(" >");
                return ((StringBuilder)object).toString();
            }
            ConstraintWidget constraintWidget = object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append(" ");
            stringBuilder.append(constraintWidget.getDebugName());
            charSequence = stringBuilder.toString();
        }
    }
}
