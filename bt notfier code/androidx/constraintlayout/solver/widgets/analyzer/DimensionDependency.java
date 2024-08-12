/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type
 *  androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.Iterator;

class DimensionDependency
extends DependencyNode {
    public int wrapValue;

    public DimensionDependency(WidgetRun widgetRun) {
        super(widgetRun);
        this.type = widgetRun instanceof HorizontalWidgetRun ? DependencyNode.Type.HORIZONTAL_DIMENSION : DependencyNode.Type.VERTICAL_DIMENSION;
    }

    public void resolve(int n) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = n;
        Iterator iterator = this.dependencies.iterator();
        while (iterator.hasNext()) {
            Dependency dependency = (Dependency)iterator.next();
            dependency.update(dependency);
        }
    }
}
