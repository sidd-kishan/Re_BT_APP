/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type
 *  androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DependencyNode
implements Dependency {
    public boolean delegateToWidgetRun = false;
    List<Dependency> dependencies;
    int margin;
    DimensionDependency marginDependency = null;
    int marginFactor = 1;
    public boolean readyToSolve = false;
    public boolean resolved = false;
    WidgetRun run;
    List<DependencyNode> targets;
    Type type = Type.UNKNOWN;
    public Dependency updateDelegate = null;
    public int value;

    public DependencyNode(WidgetRun widgetRun) {
        this.dependencies = new ArrayList<Dependency>();
        this.targets = new ArrayList<DependencyNode>();
        this.run = widgetRun;
    }

    public void addDependency(Dependency dependency) {
        this.dependencies.add(dependency);
        if (!this.resolved) return;
        dependency.update(dependency);
    }

    public void clear() {
        this.targets.clear();
        this.dependencies.clear();
        this.resolved = false;
        this.value = 0;
        this.readyToSolve = false;
        this.delegateToWidgetRun = false;
    }

    public String name() {
        StringBuilder stringBuilder;
        String string = this.run.widget.getDebugName();
        if (this.type != Type.LEFT && this.type != Type.RIGHT) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("_VERTICAL");
            string = stringBuilder.toString();
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("_HORIZONTAL");
            string = stringBuilder.toString();
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(":");
        stringBuilder.append(this.type.name());
        return stringBuilder.toString();
    }

    public void resolve(int n) {
        if (this.resolved) {
            return;
        }
        this.resolved = true;
        this.value = n;
        Iterator<Dependency> iterator = this.dependencies.iterator();
        while (iterator.hasNext()) {
            Dependency dependency = iterator.next();
            dependency.update(dependency);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.run.widget.getDebugName());
        stringBuilder.append(":");
        stringBuilder.append(this.type);
        stringBuilder.append("(");
        Object object = this.resolved ? Integer.valueOf(this.value) : "unresolved";
        stringBuilder.append(object);
        stringBuilder.append(") <t=");
        stringBuilder.append(this.targets.size());
        stringBuilder.append(":d=");
        stringBuilder.append(this.dependencies.size());
        stringBuilder.append(">");
        return stringBuilder.toString();
    }

    public void update(Dependency object) {
        object = this.targets.iterator();
        while (object.hasNext()) {
            if (((DependencyNode)object.next()).resolved) continue;
            return;
        }
        this.readyToSolve = true;
        object = this.updateDelegate;
        if (object != null) {
            object.update((Dependency)this);
        }
        if (this.delegateToWidgetRun) {
            this.run.update((Dependency)this);
            return;
        }
        object = null;
        int n = 0;
        for (DependencyNode dependencyNode : this.targets) {
            if (dependencyNode instanceof DimensionDependency) continue;
            ++n;
            object = dependencyNode;
        }
        if (object != null && n == 1 && ((DependencyNode)object).resolved) {
            DependencyNode dependencyNode;
            dependencyNode = this.marginDependency;
            if (dependencyNode != null) {
                if (!((DimensionDependency)dependencyNode).resolved) return;
                this.margin = this.marginFactor * this.marginDependency.value;
            }
            this.resolve(((DependencyNode)object).value + this.margin);
        }
        if ((object = this.updateDelegate) == null) return;
        object.update((Dependency)this);
    }
}
