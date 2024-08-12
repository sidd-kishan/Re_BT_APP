/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.Helper
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode$Type
 *  androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun$1
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun$RunType
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.HorizontalWidgetRun;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;

public class HorizontalWidgetRun
extends WidgetRun {
    private static int[] tempDimensions = new int[2];

    public HorizontalWidgetRun(ConstraintWidget constraintWidget) {
        super(constraintWidget);
        this.start.type = DependencyNode.Type.LEFT;
        this.end.type = DependencyNode.Type.RIGHT;
        this.orientation = 0;
    }

    private void computeInsetRatio(int[] nArray, int n, int n2, int n3, int n4, float f, int n5) {
        n = n2 - n;
        n2 = n4 - n3;
        if (n5 != -1) {
            if (n5 != 0) {
                if (n5 != 1) return;
                n2 = (int)((float)n * f + 0.5f);
                nArray[0] = n;
                nArray[1] = n2;
            } else {
                nArray[0] = (int)((float)n2 * f + 0.5f);
                nArray[1] = n2;
            }
        } else {
            n3 = (int)((float)n2 * f + 0.5f);
            n4 = (int)((float)n / f + 0.5f);
            if (n3 <= n) {
                nArray[0] = n3;
                nArray[1] = n2;
            } else {
                if (n4 > n2) return;
                nArray[0] = n;
                nArray[1] = n4;
            }
        }
    }

    void apply() {
        ConstraintWidget constraintWidget;
        if (this.widget.measured) {
            this.dimension.resolve(this.widget.getWidth());
        }
        if (!this.dimension.resolved) {
            this.dimensionBehavior = this.widget.getHorizontalDimensionBehaviour();
            if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && ((constraintWidget = this.widget.getParent()) != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
                    int n = constraintWidget.getWidth();
                    int n2 = this.widget.mLeft.getMargin();
                    int n3 = this.widget.mRight.getMargin();
                    this.addTarget(this.start, constraintWidget.horizontalRun.start, this.widget.mLeft.getMargin());
                    this.addTarget(this.end, constraintWidget.horizontalRun.end, -this.widget.mRight.getMargin());
                    this.dimension.resolve(n - n2 - n3);
                    return;
                }
                if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.FIXED) {
                    this.dimension.resolve(this.widget.getWidth());
                }
            }
        } else if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && ((constraintWidget = this.widget.getParent()) != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.FIXED || constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_PARENT)) {
            this.addTarget(this.start, constraintWidget.horizontalRun.start, this.widget.mLeft.getMargin());
            this.addTarget(this.end, constraintWidget.horizontalRun.end, -this.widget.mRight.getMargin());
            return;
        }
        if (this.dimension.resolved && this.widget.measured) {
            if (this.widget.mListAnchors[0].mTarget != null && this.widget.mListAnchors[1].mTarget != null) {
                if (this.widget.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                } else {
                    constraintWidget = this.getTarget(this.widget.mListAnchors[0]);
                    if (constraintWidget != null) {
                        this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.mListAnchors[0].getMargin());
                    }
                    if ((constraintWidget = this.getTarget(this.widget.mListAnchors[1])) != null) {
                        this.addTarget(this.end, (DependencyNode)constraintWidget, -this.widget.mListAnchors[1].getMargin());
                    }
                    this.start.delegateToWidgetRun = true;
                    this.end.delegateToWidgetRun = true;
                }
            } else if (this.widget.mListAnchors[0].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[0]);
                if (constraintWidget == null) return;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.mListAnchors[0].getMargin());
                this.addTarget(this.end, this.start, this.dimension.value);
            } else if (this.widget.mListAnchors[1].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[1]);
                if (constraintWidget == null) return;
                this.addTarget(this.end, (DependencyNode)constraintWidget, -this.widget.mListAnchors[1].getMargin());
                this.addTarget(this.start, this.end, -this.dimension.value);
            } else {
                if (this.widget instanceof Helper) return;
                if (this.widget.getParent() == null) return;
                if (this.widget.getAnchor((ConstraintAnchor.Type)ConstraintAnchor.Type.CENTER).mTarget != null) return;
                constraintWidget = this.widget.getParent().horizontalRun.start;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.getX());
                this.addTarget(this.end, this.start, this.dimension.value);
            }
        } else {
            if (this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                int n = this.widget.mMatchConstraintDefaultWidth;
                if (n != 2) {
                    if (n == 3) {
                        if (this.widget.mMatchConstraintDefaultHeight == 3) {
                            this.start.updateDelegate = this;
                            this.end.updateDelegate = this;
                            this.widget.verticalRun.start.updateDelegate = this;
                            this.widget.verticalRun.end.updateDelegate = this;
                            this.dimension.updateDelegate = this;
                            if (this.widget.isInVerticalChain()) {
                                this.dimension.targets.add(this.widget.verticalRun.dimension);
                                this.widget.verticalRun.dimension.dependencies.add(this.dimension);
                                this.widget.verticalRun.dimension.updateDelegate = this;
                                this.dimension.targets.add(this.widget.verticalRun.start);
                                this.dimension.targets.add(this.widget.verticalRun.end);
                                this.widget.verticalRun.start.dependencies.add(this.dimension);
                                this.widget.verticalRun.end.dependencies.add(this.dimension);
                            } else if (this.widget.isInHorizontalChain()) {
                                this.widget.verticalRun.dimension.targets.add(this.dimension);
                                this.dimension.dependencies.add(this.widget.verticalRun.dimension);
                            } else {
                                this.widget.verticalRun.dimension.targets.add(this.dimension);
                            }
                        } else {
                            constraintWidget = this.widget.verticalRun.dimension;
                            this.dimension.targets.add(constraintWidget);
                            constraintWidget.dependencies.add(this.dimension);
                            this.widget.verticalRun.start.dependencies.add(this.dimension);
                            this.widget.verticalRun.end.dependencies.add(this.dimension);
                            this.dimension.delegateToWidgetRun = true;
                            this.dimension.dependencies.add(this.start);
                            this.dimension.dependencies.add(this.end);
                            this.start.targets.add(this.dimension);
                            this.end.targets.add(this.dimension);
                        }
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
            }
            if (this.widget.mListAnchors[0].mTarget != null && this.widget.mListAnchors[1].mTarget != null) {
                if (this.widget.isInHorizontalChain()) {
                    this.start.margin = this.widget.mListAnchors[0].getMargin();
                    this.end.margin = -this.widget.mListAnchors[1].getMargin();
                } else {
                    DependencyNode dependencyNode = this.getTarget(this.widget.mListAnchors[0]);
                    constraintWidget = this.getTarget(this.widget.mListAnchors[1]);
                    dependencyNode.addDependency((Dependency)this);
                    constraintWidget.addDependency((Dependency)this);
                    this.mRunType = WidgetRun.RunType.CENTER;
                }
            } else if (this.widget.mListAnchors[0].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[0]);
                if (constraintWidget == null) return;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.mListAnchors[0].getMargin());
                this.addTarget(this.end, this.start, 1, this.dimension);
            } else if (this.widget.mListAnchors[1].mTarget != null) {
                constraintWidget = this.getTarget(this.widget.mListAnchors[1]);
                if (constraintWidget == null) return;
                this.addTarget(this.end, (DependencyNode)constraintWidget, -this.widget.mListAnchors[1].getMargin());
                this.addTarget(this.start, this.end, -1, this.dimension);
            } else {
                if (this.widget instanceof Helper) return;
                if (this.widget.getParent() == null) return;
                constraintWidget = this.widget.getParent().horizontalRun.start;
                this.addTarget(this.start, (DependencyNode)constraintWidget, this.widget.getX());
                this.addTarget(this.end, this.start, 1, this.dimension);
            }
        }
    }

    public void applyToWidget() {
        if (!this.start.resolved) return;
        this.widget.setX(this.start.value);
    }

    void clear() {
        this.runGroup = null;
        this.start.clear();
        this.end.clear();
        this.dimension.clear();
        this.resolved = false;
    }

    void reset() {
        this.resolved = false;
        this.start.clear();
        this.start.resolved = false;
        this.end.clear();
        this.end.resolved = false;
        this.dimension.resolved = false;
    }

    boolean supportsWrapComputation() {
        if (this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) return true;
        if (this.widget.mMatchConstraintDefaultWidth != 0) return false;
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("HorizontalRun ");
        stringBuilder.append(this.widget.getDebugName());
        return stringBuilder.toString();
    }

    public void update(Dependency dependency) {
        int n;
        int n2;
        DependencyNode dependencyNode;
        float f;
        int n3;
        block25: {
            block26: {
                block36: {
                    block37: {
                        int n4;
                        int n5;
                        block35: {
                            block34: {
                                int n6;
                                int n7;
                                int n8;
                                int n9;
                                block27: {
                                    block31: {
                                        block33: {
                                            float f2;
                                            block32: {
                                                block28: {
                                                    block29: {
                                                        block30: {
                                                            n3 = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$analyzer$WidgetRun$RunType[this.mRunType.ordinal()];
                                                            if (n3 != 1) {
                                                                if (n3 != 2) {
                                                                    if (n3 == 3) {
                                                                        this.updateRunCenter(dependency, this.widget.mLeft, this.widget.mRight, 0);
                                                                        return;
                                                                    }
                                                                } else {
                                                                    this.updateRunEnd(dependency);
                                                                }
                                                            } else {
                                                                this.updateRunStart(dependency);
                                                            }
                                                            if (this.dimension.resolved || this.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) break block25;
                                                            n3 = this.widget.mMatchConstraintDefaultWidth;
                                                            if (n3 == 2) break block26;
                                                            if (n3 != 3) break block25;
                                                            if (this.widget.mMatchConstraintDefaultHeight == 0 || this.widget.mMatchConstraintDefaultHeight == 3) break block27;
                                                            n3 = this.widget.getDimensionRatioSide();
                                                            if (n3 == -1) break block28;
                                                            if (n3 == 0) break block29;
                                                            if (n3 == 1) break block30;
                                                            n3 = 0;
                                                            break block31;
                                                        }
                                                        f2 = this.widget.verticalRun.dimension.value;
                                                        f = this.widget.getDimensionRatio();
                                                        break block32;
                                                    }
                                                    f = (float)this.widget.verticalRun.dimension.value / this.widget.getDimensionRatio();
                                                    break block33;
                                                }
                                                f2 = this.widget.verticalRun.dimension.value;
                                                f = this.widget.getDimensionRatio();
                                            }
                                            f = f2 * f;
                                        }
                                        n3 = (int)(f + 0.5f);
                                    }
                                    this.dimension.resolve(n3);
                                    break block25;
                                }
                                dependency = this.widget.verticalRun.start;
                                dependencyNode = this.widget.verticalRun.end;
                                n3 = this.widget.mLeft.mTarget != null ? 1 : 0;
                                n2 = this.widget.mTop.mTarget != null ? 1 : 0;
                                n = this.widget.mRight.mTarget != null ? 1 : 0;
                                n5 = this.widget.mBottom.mTarget != null ? 1 : 0;
                                n4 = this.widget.getDimensionRatioSide();
                                if (n3 == 0 || n2 == 0 || n == 0 || n5 == 0) break block34;
                                f = this.widget.getDimensionRatio();
                                if (dependency.resolved && dependencyNode.resolved) {
                                    if (!this.start.readyToSolve) return;
                                    if (!this.end.readyToSolve) return;
                                    int n10 = ((DependencyNode)this.start.targets.get((int)0)).value;
                                    n = this.start.margin;
                                    int n11 = ((DependencyNode)this.end.targets.get((int)0)).value;
                                    n2 = this.end.margin;
                                    n3 = dependency.value;
                                    int n12 = dependency.margin;
                                    int n13 = dependencyNode.value;
                                    n5 = dependencyNode.margin;
                                    this.computeInsetRatio(tempDimensions, n10 + n, n11 - n2, n3 + n12, n13 - n5, f, n4);
                                    this.dimension.resolve(tempDimensions[0]);
                                    this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                    return;
                                }
                                if (this.start.resolved && this.end.resolved) {
                                    if (!dependency.readyToSolve) return;
                                    if (!dependencyNode.readyToSolve) {
                                        return;
                                    }
                                    n9 = this.start.value;
                                    n5 = this.start.margin;
                                    n8 = this.end.value;
                                    n7 = this.end.margin;
                                    n3 = ((DependencyNode)dependency.targets.get((int)0)).value;
                                    n2 = dependency.margin;
                                    n = ((DependencyNode)dependencyNode.targets.get((int)0)).value;
                                    n6 = dependencyNode.margin;
                                    this.computeInsetRatio(tempDimensions, n9 + n5, n8 - n7, n3 + n2, n - n6, f, n4);
                                    this.dimension.resolve(tempDimensions[0]);
                                    this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                }
                                if (!this.start.readyToSolve) return;
                                if (!this.end.readyToSolve) return;
                                if (!dependency.readyToSolve) return;
                                if (!dependencyNode.readyToSolve) {
                                    return;
                                }
                                n7 = ((DependencyNode)this.start.targets.get((int)0)).value;
                                n = this.start.margin;
                                n8 = ((DependencyNode)this.end.targets.get((int)0)).value;
                                n2 = this.end.margin;
                                n9 = ((DependencyNode)dependency.targets.get((int)0)).value;
                                n3 = dependency.margin;
                                n6 = ((DependencyNode)dependencyNode.targets.get((int)0)).value;
                                n5 = dependencyNode.margin;
                                this.computeInsetRatio(tempDimensions, n7 + n, n8 - n2, n9 + n3, n6 - n5, f, n4);
                                this.dimension.resolve(tempDimensions[0]);
                                this.widget.verticalRun.dimension.resolve(tempDimensions[1]);
                                break block25;
                            }
                            if (n3 == 0 || n == 0) break block35;
                            if (!this.start.readyToSolve) return;
                            if (!this.end.readyToSolve) {
                                return;
                            }
                            f = this.widget.getDimensionRatio();
                            n2 = ((DependencyNode)this.start.targets.get((int)0)).value + this.start.margin;
                            n3 = ((DependencyNode)this.end.targets.get((int)0)).value - this.end.margin;
                            if (n4 != -1 && n4 != 0) {
                                if (n4 == 1) {
                                    n = (int)((float)(n3 = this.getLimitedDimension(n3 - n2, 0)) / f + 0.5f);
                                    if (n != (n2 = this.getLimitedDimension(n, 1))) {
                                        n3 = (int)((float)n2 * f + 0.5f);
                                    }
                                    this.dimension.resolve(n3);
                                    this.widget.verticalRun.dimension.resolve(n2);
                                }
                            } else {
                                n = (int)((float)(n3 = this.getLimitedDimension(n3 - n2, 0)) * f + 0.5f);
                                if (n != (n2 = this.getLimitedDimension(n, 1))) {
                                    n3 = (int)((float)n2 / f + 0.5f);
                                }
                                this.dimension.resolve(n3);
                                this.widget.verticalRun.dimension.resolve(n2);
                            }
                            break block25;
                        }
                        if (n2 == 0 || n5 == 0) break block25;
                        if (!dependency.readyToSolve) return;
                        if (!dependencyNode.readyToSolve) {
                            return;
                        }
                        f = this.widget.getDimensionRatio();
                        n2 = ((DependencyNode)dependency.targets.get((int)0)).value + dependency.margin;
                        n3 = ((DependencyNode)dependencyNode.targets.get((int)0)).value - dependencyNode.margin;
                        if (n4 == -1) break block36;
                        if (n4 == 0) break block37;
                        if (n4 == 1) break block36;
                        break block25;
                    }
                    n = (int)((float)(n3 = this.getLimitedDimension(n3 - n2, 1)) * f + 0.5f);
                    if (n != (n2 = this.getLimitedDimension(n, 0))) {
                        n3 = (int)((float)n2 / f + 0.5f);
                    }
                    this.dimension.resolve(n2);
                    this.widget.verticalRun.dimension.resolve(n3);
                    break block25;
                }
                if ((n = (int)((float)(n3 = this.getLimitedDimension(n3 - n2, 1)) / f + 0.5f)) != (n2 = this.getLimitedDimension(n, 0))) {
                    n3 = (int)((float)n2 * f + 0.5f);
                }
                this.dimension.resolve(n2);
                this.widget.verticalRun.dimension.resolve(n3);
                break block25;
            }
            dependency = this.widget.getParent();
            if (dependency != null && dependency.horizontalRun.dimension.resolved) {
                f = this.widget.mMatchConstraintPercentWidth;
                n3 = (int)((float)dependency.horizontalRun.dimension.value * f + 0.5f);
                this.dimension.resolve(n3);
            }
        }
        if (!this.start.readyToSolve) return;
        if (!this.end.readyToSolve) return;
        if (this.start.resolved && this.end.resolved && this.dimension.resolved) {
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.widget.mMatchConstraintDefaultWidth == 0 && !this.widget.isInHorizontalChain()) {
            dependency = (DependencyNode)this.start.targets.get(0);
            dependencyNode = (DependencyNode)this.end.targets.get(0);
            n2 = dependency.value + this.start.margin;
            n3 = dependencyNode.value + this.end.margin;
            this.start.resolve(n2);
            this.end.resolve(n3);
            this.dimension.resolve(n3 - n2);
            return;
        }
        if (!this.dimension.resolved && this.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && this.matchConstraintsType == 1 && this.start.targets.size() > 0 && this.end.targets.size() > 0) {
            dependencyNode = (DependencyNode)this.start.targets.get(0);
            dependency = (DependencyNode)this.end.targets.get(0);
            n3 = dependencyNode.value;
            n2 = this.start.margin;
            n3 = Math.min(dependency.value + this.end.margin - (n3 + n2), this.dimension.wrapValue);
            n = this.widget.mMatchConstraintMaxWidth;
            n3 = n2 = Math.max(this.widget.mMatchConstraintMinWidth, n3);
            if (n > 0) {
                n3 = Math.min(n, n2);
            }
            this.dimension.resolve(n3);
        }
        if (!this.dimension.resolved) {
            return;
        }
        dependency = (DependencyNode)this.start.targets.get(0);
        dependencyNode = (DependencyNode)this.end.targets.get(0);
        n3 = dependency.value + this.start.margin;
        n2 = dependencyNode.value + this.end.margin;
        f = this.widget.getHorizontalBiasPercent();
        if (dependency == dependencyNode) {
            n3 = dependency.value;
            n2 = dependencyNode.value;
            f = 0.5f;
        }
        n = this.dimension.value;
        this.start.resolve((int)((float)n3 + 0.5f + (float)(n2 - n3 - n) * f));
        this.end.resolve(this.start.value + this.dimension.value);
    }
}
