/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency
 *  androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

class BaselineDimensionDependency
extends DimensionDependency {
    public BaselineDimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
    }

    public void update(DependencyNode dependencyNode) {
        ((VerticalWidgetRun)this.run).baseline.margin = this.run.widget.getBaselineDistance();
        this.resolved = true;
    }
}
