/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

class GuidelineReference
extends WidgetRun {
    public GuidelineReference(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        constraintWidget.horizontalRun.clear();
        constraintWidget.verticalRun.clear();
        this.orientation = ((Guideline)constraintWidget).getOrientation();
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.dependencies.add(dependencyNode);
        dependencyNode.targets.add(this.start);
    }

    void apply() {
        Guideline guideline = (Guideline)this.widget;
        int n = guideline.getRelativeBegin();
        int n2 = guideline.getRelativeEnd();
        guideline.getRelativePercent();
        if (guideline.getOrientation() == 1) {
            if (n != -1) {
                this.start.targets.add(this.widget.mParent.horizontalRun.start);
                this.widget.mParent.horizontalRun.start.dependencies.add(this.start);
                this.start.margin = n;
            } else if (n2 != -1) {
                this.start.targets.add(this.widget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
                this.start.margin = -n2;
            } else {
                this.start.delegateToWidgetRun = true;
                this.start.targets.add(this.widget.mParent.horizontalRun.end);
                this.widget.mParent.horizontalRun.end.dependencies.add(this.start);
            }
            this.addDependency(this.widget.horizontalRun.start);
            this.addDependency(this.widget.horizontalRun.end);
        } else {
            if (n != -1) {
                this.start.targets.add(this.widget.mParent.verticalRun.start);
                this.widget.mParent.verticalRun.start.dependencies.add(this.start);
                this.start.margin = n;
            } else if (n2 != -1) {
                this.start.targets.add(this.widget.mParent.verticalRun.end);
                this.widget.mParent.verticalRun.end.dependencies.add(this.start);
                this.start.margin = -n2;
            } else {
                this.start.delegateToWidgetRun = true;
                this.start.targets.add(this.widget.mParent.verticalRun.end);
                this.widget.mParent.verticalRun.end.dependencies.add(this.start);
            }
            this.addDependency(this.widget.verticalRun.start);
            this.addDependency(this.widget.verticalRun.end);
        }
    }

    public void applyToWidget() {
        if (((Guideline)this.widget).getOrientation() == 1) {
            this.widget.setX(this.start.value);
        } else {
            this.widget.setY(this.start.value);
        }
    }

    void clear() {
        this.start.clear();
    }

    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency dependency) {
        if (!this.start.readyToSolve) {
            return;
        }
        if (this.start.resolved) {
            return;
        }
        dependency = (DependencyNode)this.start.targets.get(0);
        Guideline guideline = (Guideline)this.widget;
        int n = (int)((float)dependency.value * guideline.getRelativePercent() + 0.5f);
        this.start.resolve(n);
    }
}
