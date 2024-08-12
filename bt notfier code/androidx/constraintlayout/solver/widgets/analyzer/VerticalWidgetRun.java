/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.Helper
 *  androidx.constraintlayout.solver.widgets.analyzer.BaselineDimensionDependency
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type
 *  androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency
 *  androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun$1
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.BaselineDimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.DimensionDependency;
import androidx.constraintlayout.solver.widgets.analyzer.VerticalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class VerticalWidgetRun
extends WidgetRun {
    public DependencyNode baseline = new DependencyNode((WidgetRun)this);
    DimensionDependency baselineDimension = null;

    public VerticalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.TOP;
        this.end.type = DependencyNode.Type.BOTTOM;
        this.baseline.type = DependencyNode.Type.BASELINE;
        this.orientation = 1;
    }

    void apply() {
        ConstraintWidget constraintWidget;
        if (this.widget.measured) {
            this.dimension.resolve(this.widget.getHeight());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getVerticalDimensionBehaviour();
            if (this.widget.hasBaseline()) {
                this.baselineDimension = new BaselineDimensionDependency((WidgetRun)this);
            }
            if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget = this.widget.getParent()) != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
                    int n = constraintWidget.getHeight();
                    int n2 = this.widget.mTop.getMargin();
                    int n3 = this.widget.mBottom.getMargin();
                    this.addTarget(this.start, constraintWidget.verticalRun.start, this.widget.mTop.getMargin());
                    this.addTarget(this.end, constraintWidget.verticalRun.end, -this.widget.mBottom.getMargin());
                    this.dimension.resolve(n - n2 - n3);
                    return;
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getHeight());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && (constraintWidget = this.widget.getParent()) != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED) {
            this.addTarget(this.start, constraintWidget.verticalRun.start, this.widget.mTop.getMargin());
            this.addTarget(this.end, constraintWidget.verticalRun.end, -this.widget.mBottom.getMargin());
            return;
        }
        if (this.dimension.resolved && this.widget.measured) {
            if (this.widget.mListAnchors[2].mTarget != null && this.widget.mListAnchors[3].mTarget != null) {
                if (this.widget.isInVerticalChain()) {
                    this.start.margin = this.widget.mListAnchors[2].getMargin();
                    this.end.margin = -this.widget.mListAnchors[3].getMargin();
                } else {
                    constraintWidget = this.getTarget(this.widget.mListAnchors[2]);
                    if (constraintWidget != null) {
                        this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.mListAnchors[2].getMargin());
                    }
                    if ((constraintWidget = this.getTarget(this.widget.mListAnchors[3])) != null) {
                        this.addTarget(this.end, (DependencyNode)constraintWidget, -this.widget.mListAnchors[3].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                }
                if (!this.widget.hasBaseline()) return;
                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
            } else if (this.widget.mListAnchors[2].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[2]);
                if (constraintWidget == null) return;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.mListAnchors[2].getMargin());
                this.addTarget(this.end, this.start, this.dimension.value);
                if (!this.widget.hasBaseline()) return;
                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
            } else if (this.widget.mListAnchors[3].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[3]);
                if (constraintWidget != null) {
                    this.addTarget(this.end, (DependencyNode)constraintWidget, -this.widget.mListAnchors[3].getMargin());
                    this.addTarget(this.start, this.end, -this.dimension.value);
                }
                if (!this.widget.hasBaseline()) return;
                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
            } else if (this.widget.mListAnchors[4].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[4]);
                if (constraintWidget == null) return;
                this.addTarget(this.baseline, (DependencyNode)constraintWidget, 0);
                this.addTarget(this.start, this.baseline, -this.widget.getBaselineDistance());
                this.addTarget(this.end, this.start, this.dimension.value);
            } else {
                if (this.widget instanceof Helper) return;
                if (this.widget.getParent() == null) return;
                if (this.widget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.CENTER).mTarget != null) return;
                constraintWidget = this.widget.getParent().verticalRun.start;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.getY());
                this.addTarget(this.end, this.start, this.dimension.value);
                if (!this.widget.hasBaseline()) return;
                this.addTarget(this.baseline, this.start, this.widget.getBaselineDistance());
            }
        } else {
            if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int n = this.widget.mMatchConstraintDefaultHeight;
                if (n != 2) {
                    if (n == 3 && !this.widget.isInVerticalChain() && this.widget.mMatchConstraintDefaultWidth != 3) {
                        constraintWidget = this.widget.horizontalRun.dimension;
                        this.dimension.targets.add(constraintWidget);
                        constraintWidget.dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                } else {
                    constraintWidget = this.widget.getParent();
                    if (constraintWidget != null) {
                        constraintWidget = constraintWidget.verticalRun.dimension;
                        this.dimension.targets.add(constraintWidget);
                        constraintWidget.dependencies.add(this.dimension);
                        this.dimension.delegateToWidgetRun = true;
                        this.dimension.dependencies.add(this.start);
                        this.dimension.dependencies.add(this.end);
                    }
                }
            } else {
                this.dimension.addDependency((Dependency)this);
            }
            if (this.widget.mListAnchors[2].mTarget != null && this.widget.mListAnchors[3].mTarget != null) {
                if (this.widget.isInVerticalChain()) {
                    this.start.margin = this.widget.mListAnchors[2].getMargin();
                    this.end.margin = -this.widget.mListAnchors[3].getMargin();
                } else {
                    constraintWidget = this.getTarget(this.widget.mListAnchors[2]);
                    DependencyNode dependencyNode = this.getTarget(this.widget.mListAnchors[3]);
                    constraintWidget.addDependency((Dependency)this);
                    dependencyNode.addDependency((Dependency)this);
                    this.mRunType = WidgetRun.RunType.CENTER;
                }
                if (this.widget.hasBaseline()) {
                    this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
            } else if (this.widget.mListAnchors[2].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[2]);
                if (constraintWidget != null) {
                    this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.mListAnchors[2].getMargin());
                    this.addTarget(this.end, this.start, 1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                    if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.getDimensionRatio() > 0.0f && this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
                        this.dimension.targets.add(this.widget.horizontalRun.dimension);
                        this.dimension.updateDelegate = this;
                    }
                }
            } else if (this.widget.mListAnchors[3].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[3]);
                if (constraintWidget != null) {
                    this.addTarget(this.end, (DependencyNode)constraintWidget, -this.widget.mListAnchors[3].getMargin());
                    this.addTarget(this.start, this.end, -1, this.dimension);
                    if (this.widget.hasBaseline()) {
                        this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                    }
                }
            } else if (this.widget.mListAnchors[4].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[4]);
                if (constraintWidget != null) {
                    this.addTarget(this.baseline, (DependencyNode)constraintWidget, 0);
                    this.addTarget(this.start, this.baseline, -1, this.baselineDimension);
                    this.addTarget(this.end, this.start, 1, this.dimension);
                }
            } else if (!(this.widget instanceof Helper) && this.widget.getParent() != null) {
                constraintWidget = this.widget.getParent().verticalRun.start;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.getY());
                this.addTarget(this.end, this.start, 1, this.dimension);
                if (this.widget.hasBaseline()) {
                    this.addTarget(this.baseline, this.start, 1, this.baselineDimension);
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.getDimensionRatio() > 0.0f && this.widget.horizontalRun.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.widget.horizontalRun.dimension.dependencies.add(this.dimension);
                    this.dimension.targets.add(this.widget.horizontalRun.dimension);
                    this.dimension.updateDelegate = this;
                }
            }
            if (this.dimension.targets.size() != 0) return;
            this.dimension.readyToSolve = true;
        }
    }

    public void applyToWidget() {
        if (!this.start.resolved) return;
        this.widget.setY(this.start.value);
    }

    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.baseline.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.baseline.clear();
        this.baseline.resolved = false;
        this.dimension.resolved = false;
    }

    boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) return true;
        if (this.widget.mMatchConstraintDefaultHeight != 0) return false;
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("VerticalRun ");
        stringBuilder.append(this.widget.getDebugName());
        return stringBuilder.toString();
    }

    public void update(Dependency dependency) {
        int n;
        DependencyNode dependencyNode;
        float f;
        int n2;
        block13: {
            block14: {
                block18: {
                    block20: {
                        float f2;
                        block19: {
                            block15: {
                                block16: {
                                    block17: {
                                        n2 = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
                                        if (n2 != 1) {
                                            if (n2 != 2) {
                                                if (n2 == 3) {
                                                    this.updateRunCenter(dependency, this.widget.mTop, this.widget.mBottom, 1);
                                                    return;
                                                }
                                            } else {
                                                this.updateRunEnd(dependency);
                                            }
                                        } else {
                                            this.updateRunStart(dependency);
                                        }
                                        if (!this.dimension.readyToSolve || this.dimension.resolved || this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) break block13;
                                        n2 = this.widget.mMatchConstraintDefaultHeight;
                                        if (n2 == 2) break block14;
                                        if (n2 != 3 || !this.widget.horizontalRun.dimension.resolved) break block13;
                                        n2 = this.widget.getDimensionRatioSide();
                                        if (n2 == -1) break block15;
                                        if (n2 == 0) break block16;
                                        if (n2 == 1) break block17;
                                        n2 = 0;
                                        break block18;
                                    }
                                    f2 = this.widget.horizontalRun.dimension.value;
                                    f = this.widget.getDimensionRatio();
                                    break block19;
                                }
                                f = (float)this.widget.horizontalRun.dimension.value * this.widget.getDimensionRatio();
                                break block20;
                            }
                            f2 = this.widget.horizontalRun.dimension.value;
                            f = this.widget.getDimensionRatio();
                        }
                        f = f2 / f;
                    }
                    n2 = (int)(f + 0.5f);
                }
                this.dimension.resolve(n2);
                break block13;
            }
            dependency = this.widget.getParent();
            if (dependency != null && dependency.verticalRun.dimension.resolved) {
                f = this.widget.mMatchConstraintPercentHeight;
                n2 = (int)((float)dependency.verticalRun.dimension.value * f + 0.5f);
                this.dimension.resolve(n2);
            }
        }
        if (!this.start.readyToSolve) return;
        if (!this.end.readyToSolve) return;
        if (this.start.resolved && this.end.resolved && this.dimension.resolved) {
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.mMatchConstraintDefaultWidth == 0 && !this.widget.isInVerticalChain()) {
            dependency = (DependencyNode)this.start.targets.get(0);
            DependencyNode dependencyNode2 = (DependencyNode)this.end.targets.get(0);
            n2 = dependency.value + this.start.margin;
            int n3 = dependencyNode2.value + this.end.margin;
            this.start.resolve(n2);
            this.end.resolve(n3);
            this.dimension.resolve(n3 - n2);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
            dependencyNode = (DependencyNode)this.start.targets.get(0);
            dependency = (DependencyNode)this.end.targets.get(0);
            n = dependencyNode.value;
            n2 = this.start.margin;
            if ((n2 = dependency.value + this.end.margin - (n + n2)) < this.dimension.wrapValue) {
                this.dimension.resolve(n2);
            } else {
                this.dimension.resolve(this.dimension.wrapValue);
            }
        }
        if (!this.dimension.resolved) {
            return;
        }
        if (this.start.targets.size() <= 0) return;
        if (this.end.targets.size() <= 0) return;
        dependencyNode = (DependencyNode)this.start.targets.get(0);
        dependency = (DependencyNode)this.end.targets.get(0);
        n = dependencyNode.value + this.start.margin;
        n2 = dependency.value + this.end.margin;
        f = this.widget.getVerticalBiasPercent();
        if (dependencyNode == dependency) {
            n = dependencyNode.value;
            n2 = dependency.value;
            f = 0.5f;
        }
        int n4 = this.dimension.value;
        this.start.resolve((int)((float)n + 0.5f + (float)(n2 - n - n4) * f));
        this.end.resolve(this.start.value + this.dimension.value);
    }
}
