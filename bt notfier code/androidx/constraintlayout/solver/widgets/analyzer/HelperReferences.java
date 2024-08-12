/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

class HelperReferences
extends WidgetRun {
    public HelperReferences(ConstraintWidget constraintWidget) {
        super(constraintWidget);
    }

    private void addDependency(DependencyNode dependencyNode) {
        this.start.dependencies.add(dependencyNode);
        dependencyNode.targets.add(this.start);
    }

    void apply() {
        block11: {
            int n;
            boolean bl;
            Barrier barrier;
            block10: {
                block9: {
                    block8: {
                        block7: {
                            block4: {
                                block5: {
                                    block6: {
                                        if (!(this.widget instanceof Barrier)) return;
                                        this.start.delegateToWidgetRun = true;
                                        barrier = (Barrier)this.widget;
                                        int n2 = barrier.getBarrierType();
                                        bl = barrier.allowsGoneWidget();
                                        int n3 = 0;
                                        int n4 = 0;
                                        int n5 = 0;
                                        if (n2 == 0) break block4;
                                        if (n2 == 1) break block5;
                                        if (n2 == 2) break block6;
                                        if (n2 != 3) return;
                                        this.start.type = DependencyNode.Type.BOTTOM;
                                        break block7;
                                    }
                                    this.start.type = DependencyNode.Type.TOP;
                                    break block8;
                                }
                                this.start.type = DependencyNode.Type.RIGHT;
                                break block9;
                            }
                            this.start.type = DependencyNode.Type.LEFT;
                            break block10;
                        }
                        for (n = n5; n < barrier.mWidgetsCount; ++n) {
                            ConstraintWidget constraintWidget = barrier.mWidgets[n];
                            if (!bl && constraintWidget.getVisibility() == 8) continue;
                            constraintWidget = constraintWidget.verticalRun.end;
                            constraintWidget.dependencies.add(this.start);
                            this.start.targets.add(constraintWidget);
                        }
                        this.addDependency(this.widget.verticalRun.start);
                        this.addDependency(this.widget.verticalRun.end);
                        break block11;
                    }
                    for (n = n3; n < barrier.mWidgetsCount; ++n) {
                        ConstraintWidget constraintWidget = barrier.mWidgets[n];
                        if (!bl && constraintWidget.getVisibility() == 8) continue;
                        constraintWidget = constraintWidget.verticalRun.start;
                        constraintWidget.dependencies.add(this.start);
                        this.start.targets.add(constraintWidget);
                    }
                    this.addDependency(this.widget.verticalRun.start);
                    this.addDependency(this.widget.verticalRun.end);
                    break block11;
                }
                for (n = n4; n < barrier.mWidgetsCount; ++n) {
                    ConstraintWidget constraintWidget = barrier.mWidgets[n];
                    if (!bl && constraintWidget.getVisibility() == 8) continue;
                    constraintWidget = constraintWidget.horizontalRun.end;
                    constraintWidget.dependencies.add(this.start);
                    this.start.targets.add(constraintWidget);
                }
                this.addDependency(this.widget.horizontalRun.start);
                this.addDependency(this.widget.horizontalRun.end);
                break block11;
            }
            for (n = 0; n < barrier.mWidgetsCount; ++n) {
                ConstraintWidget constraintWidget = barrier.mWidgets[n];
                if (!bl && constraintWidget.getVisibility() == 8) continue;
                constraintWidget = constraintWidget.horizontalRun.start;
                constraintWidget.dependencies.add(this.start);
                this.start.targets.add(constraintWidget);
            }
            this.addDependency(this.widget.horizontalRun.start);
            this.addDependency(this.widget.horizontalRun.end);
        }
    }

    public void applyToWidget() {
        if (!(this.widget instanceof Barrier)) return;
        int n = ((Barrier)this.widget).getBarrierType();
        if (n != 0 && n != 1) {
            this.widget.setY(this.start.value);
        } else {
            this.widget.setX(this.start.value);
        }
    }

    void clear() {
        this.runGroup = null;
        this.start.clear();
    }

    void reset() {
        this.start.resolved = false;
    }

    boolean supportsWrapComputation() {
        return false;
    }

    public void update(Dependency object) {
        Barrier barrier = (Barrier)this.widget;
        int n = barrier.getBarrierType();
        object = this.start.targets.iterator();
        int n2 = 0;
        int n3 = -1;
        while (object.hasNext()) {
            int n4;
            int n5;
            block7: {
                block6: {
                    n5 = ((DependencyNode)object.next()).value;
                    if (n3 == -1) break block6;
                    n4 = n3;
                    if (n5 >= n3) break block7;
                }
                n4 = n5;
            }
            n3 = n4;
            if (n2 >= n5) continue;
            n2 = n5;
            n3 = n4;
        }
        if (n != 0 && n != 2) {
            this.start.resolve(n2 + barrier.getMargin());
        } else {
            this.start.resolve(n3 + barrier.getMargin());
        }
    }
}
