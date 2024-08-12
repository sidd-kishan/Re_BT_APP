/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.analyzer.ChainRun
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.HelperReferences
 *  androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.ChainRun;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HelperReferences;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

class RunGroup {
    public static final int BASELINE = 2;
    public static final int END = 1;
    public static final int START = 0;
    public static int index;
    int direction;
    public boolean dual = false;
    WidgetRun firstRun = null;
    int groupIndex = 0;
    WidgetRun lastRun = null;
    public int position = 0;
    ArrayList<WidgetRun> runs = new ArrayList();

    public RunGroup(WidgetRun widgetRun, int n) {
        int n2;
        this.groupIndex = n2 = index;
        index = n2 + 1;
        this.firstRun = widgetRun;
        this.lastRun = widgetRun;
        this.direction = n;
    }

    private boolean defineTerminalWidget(WidgetRun widgetRun, int n) {
        Object object;
        if (!widgetRun.widget.isTerminalWidget[n]) {
            return false;
        }
        for (Object object2 : widgetRun.start.dependencies) {
            if (!(object2 instanceof DependencyNode)) continue;
            object = (DependencyNode)object2;
            if (((DependencyNode)object).run == widgetRun || object != ((DependencyNode)object).run.start) continue;
            if (widgetRun instanceof ChainRun) {
                object2 = ((ChainRun)widgetRun).widgets.iterator();
                while (object2.hasNext()) {
                    this.defineTerminalWidget((WidgetRun)object2.next(), n);
                }
            } else if (!(widgetRun instanceof HelperReferences)) {
                widgetRun.widget.isTerminalWidget[n] = false;
            }
            this.defineTerminalWidget(((DependencyNode)object).run, n);
        }
        Iterator iterator = widgetRun.end.dependencies.iterator();
        while (iterator.hasNext()) {
            Object object2;
            object2 = (Dependency)iterator.next();
            if (!(object2 instanceof DependencyNode)) continue;
            object2 = (DependencyNode)object2;
            if (((DependencyNode)object2).run == widgetRun || object2 != ((DependencyNode)object2).run.start) continue;
            if (widgetRun instanceof ChainRun) {
                object = ((ChainRun)widgetRun).widgets.iterator();
                while (object.hasNext()) {
                    this.defineTerminalWidget((WidgetRun)object.next(), n);
                }
            } else if (!(widgetRun instanceof HelperReferences)) {
                widgetRun.widget.isTerminalWidget[n] = false;
            }
            this.defineTerminalWidget(((DependencyNode)object2).run, n);
        }
        return false;
    }

    private long traverseEnd(DependencyNode dependencyNode, long l) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return l;
        }
        int n = dependencyNode.dependencies.size();
        int n2 = 0;
        long l2 = l;
        while (true) {
            long l3;
            if (n2 >= n) {
                l3 = l2;
                if (dependencyNode != widgetRun.end) return l3;
                l3 = widgetRun.getWrapDimension();
                dependencyNode = widgetRun.start;
                l -= l3;
                l3 = Math.min(Math.min(l2, this.traverseEnd(dependencyNode, l)), l - (long)widgetRun.start.margin);
                return l3;
            }
            Dependency dependency = (Dependency)dependencyNode.dependencies.get(n2);
            l3 = l2;
            if (dependency instanceof DependencyNode) {
                dependency = (DependencyNode)dependency;
                l3 = dependency.run == widgetRun ? l2 : Math.min(l2, this.traverseEnd((DependencyNode)dependency, (long)dependency.margin + l));
            }
            ++n2;
            l2 = l3;
        }
    }

    private long traverseStart(DependencyNode dependencyNode, long l) {
        WidgetRun widgetRun = dependencyNode.run;
        if (widgetRun instanceof HelperReferences) {
            return l;
        }
        int n = dependencyNode.dependencies.size();
        int n2 = 0;
        long l2 = l;
        while (true) {
            long l3;
            if (n2 >= n) {
                l3 = l2;
                if (dependencyNode != widgetRun.start) return l3;
                l3 = widgetRun.getWrapDimension();
                dependencyNode = widgetRun.end;
                l += l3;
                l3 = Math.max(Math.max(l2, this.traverseStart(dependencyNode, l)), l - (long)widgetRun.end.margin);
                return l3;
            }
            Dependency dependency = (Dependency)dependencyNode.dependencies.get(n2);
            l3 = l2;
            if (dependency instanceof DependencyNode) {
                dependency = (DependencyNode)dependency;
                l3 = dependency.run == widgetRun ? l2 : Math.max(l2, this.traverseStart((DependencyNode)dependency, (long)dependency.margin + l));
            }
            ++n2;
            l2 = l3;
        }
    }

    public void add(WidgetRun widgetRun) {
        this.runs.add(widgetRun);
        this.lastRun = widgetRun;
    }

    /*
     * Enabled force condition propagation
     */
    public long computeWrapSize(ConstraintWidgetContainer constraintWidgetContainer, int n) {
        long l;
        WidgetRun widgetRun = this.firstRun;
        boolean bl = widgetRun instanceof ChainRun;
        long l2 = 0L;
        if (bl ? ((ChainRun)widgetRun).orientation != n : (n == 0 ? !(widgetRun instanceof HorizontalWidgetRun) : !(widgetRun instanceof VerticalWidgetRun))) {
            return 0L;
        }
        widgetRun = n == 0 ? constraintWidgetContainer.horizontalRun.start : constraintWidgetContainer.verticalRun.start;
        constraintWidgetContainer = n == 0 ? constraintWidgetContainer.horizontalRun.end : constraintWidgetContainer.verticalRun.end;
        boolean bl2 = this.firstRun.start.targets.contains(widgetRun);
        bl = this.firstRun.end.targets.contains(constraintWidgetContainer);
        long l3 = this.firstRun.getWrapDimension();
        if (bl2 && bl) {
            float f;
            long l4;
            l = this.traverseStart(this.firstRun.start, 0L);
            long l5 = this.traverseEnd(this.firstRun.end, 0L);
            l = l4 = l - l3;
            if (l4 >= (long)(-this.firstRun.end.margin)) {
                l = l4 + (long)this.firstRun.end.margin;
            }
            l4 = l5 = -l5 - l3 - (long)this.firstRun.start.margin;
            if (l5 >= (long)this.firstRun.start.margin) {
                l4 = l5 - (long)this.firstRun.start.margin;
            }
            if ((f = this.firstRun.widget.getBiasPercent(n)) > 0.0f) {
                l2 = (long)((float)l4 / f + (float)l / (1.0f - f));
            }
            float f2 = l2;
            l = (long)(f2 * f + 0.5f);
            l4 = (long)(f2 * (1.0f - f) + 0.5f);
            l = (long)this.firstRun.start.margin + (l + l3 + l4);
            n = this.firstRun.end.margin;
        } else {
            if (bl2) {
                return Math.max(this.traverseStart(this.firstRun.start, this.firstRun.start.margin), (long)this.firstRun.start.margin + l3);
            }
            if (bl) {
                l = this.traverseEnd(this.firstRun.end, this.firstRun.end.margin);
                long l6 = -this.firstRun.end.margin;
                return Math.max(-l, l6 + l3);
            }
            l = (long)this.firstRun.start.margin + this.firstRun.getWrapDimension();
            n = this.firstRun.end.margin;
        }
        l -= (long)n;
        return l;
    }

    public void defineTerminalWidgets(boolean bl, boolean bl2) {
        WidgetRun widgetRun;
        if (bl && (widgetRun = this.firstRun) instanceof HorizontalWidgetRun) {
            this.defineTerminalWidget(widgetRun, 0);
        }
        if (!bl2) return;
        widgetRun = this.firstRun;
        if (!(widgetRun instanceof VerticalWidgetRun)) return;
        this.defineTerminalWidget(widgetRun, 1);
    }
}
