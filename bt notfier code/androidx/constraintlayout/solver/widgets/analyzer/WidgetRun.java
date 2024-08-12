/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency
 *  androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.RunGroup
 *  androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$1
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.RunGroup;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public abstract class WidgetRun
implements Dependency {
    DimensionDependency dimension = new DimensionDependency(this);
    protected ConstraintWidget.DimensionBehaviour dimensionBehavior;
    public DependencyNode end;
    protected RunType mRunType;
    public int matchConstraintsType;
    public int orientation = 0;
    boolean resolved = false;
    RunGroup runGroup;
    public DependencyNode start = new DependencyNode(this);
    ConstraintWidget widget;

    public WidgetRun(ConstraintWidget constraintWidget) {
        this.end = new DependencyNode(this);
        this.mRunType = RunType.NONE;
        this.widget = constraintWidget;
    }

    private void resolveDimension(int n, int n2) {
        int n3 = this.matchConstraintsType;
        if (n3 != 0) {
            if (n3 != 1) {
                if (n3 != 2) {
                    if (n3 != 3 || this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.horizontalRun.matchConstraintsType == 3 && this.widget.verticalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.verticalRun.matchConstraintsType == 3) return;
                    Object object = this.widget;
                    object = n == 0 ? object.verticalRun : object.horizontalRun;
                    if (!object.dimension.resolved) return;
                    float f = this.widget.getDimensionRatio();
                    n = n == 1 ? (int)((float)object.dimension.value / f + 0.5f) : (int)(f * (float)object.dimension.value + 0.5f);
                    this.dimension.resolve(n);
                } else {
                    Object object = this.widget.getParent();
                    if (object == null) return;
                    object = n == 0 ? object.horizontalRun : object.verticalRun;
                    if (!object.dimension.resolved) return;
                    ConstraintWidget constraintWidget = this.widget;
                    float f = n == 0 ? constraintWidget.mMatchConstraintPercentWidth : constraintWidget.mMatchConstraintPercentHeight;
                    n2 = (int)((float)object.dimension.value * f + 0.5f);
                    this.dimension.resolve(this.getLimitedDimension(n2, n));
                }
            } else {
                n = this.getLimitedDimension(this.dimension.wrapValue, n);
                this.dimension.resolve(Math.min(n, n2));
            }
        } else {
            this.dimension.resolve(this.getLimitedDimension(n2, n));
        }
    }

    protected final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int n) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.margin = n;
        dependencyNode2.dependencies.add(dependencyNode);
    }

    protected final void addTarget(DependencyNode dependencyNode, DependencyNode dependencyNode2, int n, DimensionDependency dimensionDependency) {
        dependencyNode.targets.add(dependencyNode2);
        dependencyNode.targets.add(this.dimension);
        dependencyNode.marginFactor = n;
        dependencyNode.marginDependency = dimensionDependency;
        dependencyNode2.dependencies.add(dependencyNode);
        dimensionDependency.dependencies.add(dependencyNode);
    }

    abstract void apply();

    abstract void applyToWidget();

    abstract void clear();

    protected final int getLimitedDimension(int n, int n2) {
        int n3;
        if (n2 == 0) {
            n3 = this.widget.mMatchConstraintMaxWidth;
            n2 = Math.max(this.widget.mMatchConstraintMinWidth, n);
            if (n3 > 0) {
                n2 = Math.min(n3, n);
            }
            n3 = n;
            if (n2 == n) return n3;
        } else {
            n3 = this.widget.mMatchConstraintMaxHeight;
            n2 = Math.max(this.widget.mMatchConstraintMinHeight, n);
            if (n3 > 0) {
                n2 = Math.min(n3, n);
            }
            n3 = n;
            if (n2 == n) return n3;
        }
        n3 = n2;
        return n3;
    }

    protected final DependencyNode getTarget(ConstraintAnchor object) {
        ConstraintAnchor constraintAnchor = object.mTarget;
        Object var3_3 = null;
        if (constraintAnchor == null) {
            return null;
        }
        constraintAnchor = object.mTarget.mOwner;
        object = object.mTarget.mType;
        int n = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[object.ordinal()];
        object = n != 1 ? (n != 2 ? (n != 3 ? (n != 4 ? (n != 5 ? var3_3 : constraintAnchor.verticalRun.end) : constraintAnchor.verticalRun.baseline) : constraintAnchor.verticalRun.start) : constraintAnchor.horizontalRun.end) : constraintAnchor.horizontalRun.start;
        return object;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     */
    protected final DependencyNode getTarget(ConstraintAnchor constraintAnchor, int n) {
        void var3_7;
        ConstraintAnchor constraintAnchor2 = constraintAnchor.mTarget;
        Object var4_8 = null;
        if (constraintAnchor2 == null) {
            return null;
        }
        ConstraintWidget constraintWidget = constraintAnchor.mTarget.mOwner;
        if (n == 0) {
            HorizontalWidgetRun horizontalWidgetRun = constraintWidget.horizontalRun;
        } else {
            VerticalWidgetRun verticalWidgetRun = constraintWidget.verticalRun;
        }
        constraintAnchor = constraintAnchor.mTarget.mType;
        n = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[constraintAnchor.ordinal()];
        if (n == 1) return var3_7.start;
        if (n == 2) return var3_7.end;
        if (n == 3) return var3_7.start;
        if (n == 5) return var3_7.end;
        return var4_8;
    }

    public long getWrapDimension() {
        if (!this.dimension.resolved) return 0L;
        return this.dimension.value;
    }

    public boolean isCenterConnection() {
        int n;
        int n2;
        int n3 = this.start.targets.size();
        boolean bl = false;
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            n = n4;
            if (((DependencyNode)this.start.targets.get((int)n2)).run != this) {
                n = n4 + 1;
            }
            n4 = n;
        }
        n3 = this.end.targets.size();
        n = 0;
        n2 = n4;
        while (true) {
            if (n >= n3) {
                if (n2 < 2) return bl;
                bl = true;
                return bl;
            }
            n4 = n2;
            if (((DependencyNode)this.end.targets.get((int)n)).run != this) {
                n4 = n2 + 1;
            }
            ++n;
            n2 = n4;
        }
    }

    public boolean isDimensionResolved() {
        return this.dimension.resolved;
    }

    public boolean isResolved() {
        return this.resolved;
    }

    abstract void reset();

    abstract boolean supportsWrapComputation();

    public void update(Dependency dependency) {
    }

    protected void updateRunCenter(Dependency dependency, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, int n) {
        DependencyNode dependencyNode = this.getTarget(constraintAnchor);
        dependency = this.getTarget(constraintAnchor2);
        if (!dependencyNode.resolved) return;
        if (!dependency.resolved) return;
        int n2 = dependencyNode.value + constraintAnchor.getMargin();
        int n3 = dependency.value - constraintAnchor2.getMargin();
        int n4 = n3 - n2;
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            this.resolveDimension(n, n4);
        }
        if (!this.dimension.resolved) {
            return;
        }
        if (this.dimension.value == n4) {
            this.start.resolve(n2);
            this.end.resolve(n3);
            return;
        }
        constraintAnchor = this.widget;
        float f = n == 0 ? constraintAnchor.getHorizontalBiasPercent() : constraintAnchor.getVerticalBiasPercent();
        n = n2;
        if (dependencyNode == dependency) {
            n = dependencyNode.value;
            n3 = dependency.value;
            f = 0.5f;
        }
        n2 = this.dimension.value;
        this.start.resolve((int)((float)n + 0.5f + (float)(n3 - n - n2) * f));
        this.end.resolve(this.start.value + this.dimension.value);
    }

    protected void updateRunEnd(Dependency dependency) {
    }

    protected void updateRunStart(Dependency dependency) {
    }

    /*
     * Enabled force condition propagation
     */
    public long wrapSize(int n) {
        if (!this.dimension.resolved) return 0L;
        long l = this.dimension.value;
        if (this.isCenterConnection()) {
            n = this.start.margin - this.end.margin;
            return l += (long)n;
        } else {
            if (n != 0) {
                l -= (long)this.end.margin;
                return l;
            }
            n = this.start.margin;
        }
        return l += (long)n;
    }
}
