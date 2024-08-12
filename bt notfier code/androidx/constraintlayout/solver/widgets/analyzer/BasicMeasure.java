/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.Metrics
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.Helper
 *  androidx.constraintlayout.solver.widgets.Optimizer
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;

public class BasicMeasure {
    public static final int AT_MOST = Integer.MIN_VALUE;
    private static final boolean DEBUG = false;
    public static final int EXACTLY = 0x40000000;
    public static final int FIXED = -3;
    public static final int MATCH_PARENT = -1;
    private static final int MODE_SHIFT = 30;
    public static final int UNSPECIFIED = 0;
    public static final int WRAP_CONTENT = -2;
    private ConstraintWidgetContainer constraintWidgetContainer;
    private Measure mMeasure;
    private final ArrayList<ConstraintWidget> mVariableDimensionsWidgets = new ArrayList();

    public BasicMeasure(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mMeasure = new Measure();
        this.constraintWidgetContainer = constraintWidgetContainer;
    }

    private boolean measure(Measurer measurer, ConstraintWidget constraintWidget, boolean bl) {
        this.mMeasure.horizontalBehavior = constraintWidget.getHorizontalDimensionBehaviour();
        this.mMeasure.verticalBehavior = constraintWidget.getVerticalDimensionBehaviour();
        this.mMeasure.horizontalDimension = constraintWidget.getWidth();
        this.mMeasure.verticalDimension = constraintWidget.getHeight();
        this.mMeasure.measuredNeedsSolverPass = false;
        this.mMeasure.useCurrentDimensions = bl;
        boolean bl2 = this.mMeasure.horizontalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        boolean bl3 = this.mMeasure.verticalBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        bl2 = bl2 && constraintWidget.mDimensionRatio > 0.0f;
        bl3 = bl3 && constraintWidget.mDimensionRatio > 0.0f;
        if (bl2 && constraintWidget.mResolvedMatchConstraintDefault[0] == 4) {
            this.mMeasure.horizontalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (bl3 && constraintWidget.mResolvedMatchConstraintDefault[1] == 4) {
            this.mMeasure.verticalBehavior = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        measurer.measure(constraintWidget, this.mMeasure);
        constraintWidget.setWidth(this.mMeasure.measuredWidth);
        constraintWidget.setHeight(this.mMeasure.measuredHeight);
        constraintWidget.setHasBaseline(this.mMeasure.measuredHasBaseline);
        constraintWidget.setBaselineDistance(this.mMeasure.measuredBaseline);
        this.mMeasure.useCurrentDimensions = false;
        return this.mMeasure.measuredNeedsSolverPass;
    }

    /*
     * Unable to fully structure code
     */
    private void measureChildren(ConstraintWidgetContainer var1_1) {
        var7_2 = var1_1.mChildren.size();
        var8_3 = var1_1.optimizeFor(64);
        var9_4 = var1_1.getMeasurer();
        var5_5 = 0;
        while (true) {
            block10: {
                if (var5_5 >= var7_2) {
                    var9_4.didMeasures();
                    return;
                }
                var11_11 = (ConstraintWidget)var1_1.mChildren.get(var5_5);
                if (var11_11 instanceof Guideline || var11_11 instanceof Barrier || var11_11.isInVirtualLayout() || var8_3 && var11_11.horizontalRun != null && var11_11.verticalRun != null && var11_11.horizontalRun.dimension.resolved && var11_11.verticalRun.dimension.resolved) break block10;
                var12_12 = var11_11.getDimensionBehaviour(0);
                var6_9 = true;
                var10_10 = var11_11.getDimensionBehaviour(1);
                var2_6 = var12_12 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var11_11.mMatchConstraintDefaultWidth != 1 && var10_10 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var11_11.mMatchConstraintDefaultHeight != 1;
                var3_7 = var2_6;
                if (var2_6) ** GOTO lbl-1000
                var3_7 = var2_6;
                if (!var1_1.optimizeFor(1)) ** GOTO lbl-1000
                var3_7 = var2_6;
                if (var11_11 instanceof VirtualLayout) ** GOTO lbl-1000
                var4_8 = var2_6;
                if (var12_12 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    var4_8 = var2_6;
                    if (var11_11.mMatchConstraintDefaultWidth == 0) {
                        var4_8 = var2_6;
                        if (var10_10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            var4_8 = var2_6;
                            if (!var11_11.isInHorizontalChain()) {
                                var4_8 = true;
                            }
                        }
                    }
                }
                var3_7 = var4_8;
                if (var10_10 != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) ** GOTO lbl-1000
                var3_7 = var4_8;
                if (var11_11.mMatchConstraintDefaultHeight != 0) ** GOTO lbl-1000
                var3_7 = var4_8;
                if (var12_12 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) ** GOTO lbl-1000
                var3_7 = var4_8;
                if (!var11_11.isInHorizontalChain()) {
                    var2_6 = var6_9;
                } else lbl-1000:
                // 7 sources

                {
                    var2_6 = var3_7;
                }
                if (!var2_6) {
                    this.measure(var9_4, var11_11, false);
                    if (var1_1.mMetrics != null) {
                        var10_10 = var1_1.mMetrics;
                        ++var10_10.measuredWidgets;
                    }
                }
            }
            ++var5_5;
        }
    }

    private void solveLinearSystem(ConstraintWidgetContainer constraintWidgetContainer, String string, int n, int n2) {
        int n3 = constraintWidgetContainer.getMinWidth();
        int n4 = constraintWidgetContainer.getMinHeight();
        constraintWidgetContainer.setMinWidth(0);
        constraintWidgetContainer.setMinHeight(0);
        constraintWidgetContainer.setWidth(n);
        constraintWidgetContainer.setHeight(n2);
        constraintWidgetContainer.setMinWidth(n3);
        constraintWidgetContainer.setMinHeight(n4);
        this.constraintWidgetContainer.layout();
    }

    public long solverMeasure(ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9) {
        Metrics metrics;
        Measurer measurer = constraintWidgetContainer.getMeasurer();
        n9 = constraintWidgetContainer.mChildren.size();
        int n10 = constraintWidgetContainer.getWidth();
        int n11 = constraintWidgetContainer.getHeight();
        boolean bl = Optimizer.enabled((int)n, (int)128);
        n = !bl && !Optimizer.enabled((int)n, (int)64) ? 0 : 1;
        n3 = n;
        if (n != 0) {
            n2 = 0;
            while (true) {
                n3 = n;
                if (n2 >= n9) break;
                metrics = (ConstraintWidget)constraintWidgetContainer.mChildren.get(n2);
                n3 = metrics.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                n8 = metrics.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                n3 = n3 != 0 && n8 != 0 && metrics.getDimensionRatio() > 0.0f ? 1 : 0;
                if (metrics.isInHorizontalChain() && n3 != 0 || metrics.isInVerticalChain() && n3 != 0 || metrics instanceof VirtualLayout || metrics.isInHorizontalChain() || metrics.isInVerticalChain()) {
                    n3 = 0;
                    break;
                }
                ++n2;
            }
        }
        if (n3 != 0 && LinearSystem.sMetrics != null) {
            metrics = LinearSystem.sMetrics;
            ++metrics.measures;
        }
        if ((n8 = n3 & (n = n4 == 0x40000000 && n6 == 0x40000000 || bl ? 1 : 0)) != 0) {
            boolean bl2;
            n = Math.min(constraintWidgetContainer.getMaxWidth(), n5);
            n2 = Math.min(constraintWidgetContainer.getMaxHeight(), n7);
            if (n4 == 0x40000000 && constraintWidgetContainer.getWidth() != n) {
                constraintWidgetContainer.setWidth(n);
                constraintWidgetContainer.invalidateGraph();
            }
            if (n6 == 0x40000000 && constraintWidgetContainer.getHeight() != n2) {
                constraintWidgetContainer.setHeight(n2);
                constraintWidgetContainer.invalidateGraph();
            }
            if (n4 == 0x40000000 && n6 == 0x40000000) {
                bl2 = constraintWidgetContainer.directMeasure(bl);
                n = 2;
            } else {
                bl2 = constraintWidgetContainer.directMeasureSetup(bl);
                if (n4 == 0x40000000) {
                    bl2 &= constraintWidgetContainer.directMeasureWithOrientation(bl, 0);
                    n = 1;
                } else {
                    n = 0;
                }
                if (n6 == 0x40000000) {
                    bl2 = constraintWidgetContainer.directMeasureWithOrientation(bl, 1) & bl2;
                    ++n;
                }
            }
            bl = bl2;
            n2 = n;
            if (bl2) {
                bl = n4 == 0x40000000;
                boolean bl3 = n6 == 0x40000000;
                constraintWidgetContainer.updateFromRuns(bl, bl3);
                bl = bl2;
                n2 = n;
            }
        } else {
            bl = false;
            n2 = 0;
        }
        if (bl) {
            if (n2 == 2) return 0L;
        }
        n4 = constraintWidgetContainer.getOptimizationLevel();
        if (n9 > 0) {
            this.measureChildren(constraintWidgetContainer);
        }
        n7 = this.mVariableDimensionsWidgets.size();
        if (n9 > 0) {
            this.solveLinearSystem(constraintWidgetContainer, "First pass", n10, n11);
        }
        if (n7 > 0) {
            int n12;
            int n13;
            int n14;
            ConstraintWidget constraintWidget;
            n9 = constraintWidgetContainer.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
            boolean bl4 = constraintWidgetContainer.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            n2 = Math.max(constraintWidgetContainer.getWidth(), this.constraintWidgetContainer.getMinWidth());
            n = Math.max(constraintWidgetContainer.getHeight(), this.constraintWidgetContainer.getMinHeight());
            n3 = 0;
            for (n6 = 0; n6 < n7; ++n6) {
                constraintWidget = this.mVariableDimensionsWidgets.get(n6);
                if (!(constraintWidget instanceof VirtualLayout)) {
                    n5 = n3;
                } else {
                    n14 = constraintWidget.getWidth();
                    n13 = constraintWidget.getHeight();
                    n5 = n3 | this.measure(measurer, constraintWidget, true);
                    if (constraintWidgetContainer.mMetrics != null) {
                        metrics = constraintWidgetContainer.mMetrics;
                        ++metrics.measuredMatchWidgets;
                    }
                    n3 = constraintWidget.getWidth();
                    n12 = constraintWidget.getHeight();
                    if (n3 != n14) {
                        constraintWidget.setWidth(n3);
                        n3 = n2;
                        if (n9 != 0) {
                            n3 = n2;
                            if (constraintWidget.getRight() > n2) {
                                n3 = Math.max(n2, constraintWidget.getRight() + constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                            }
                        }
                        n5 = 1;
                        n2 = n3;
                    }
                    n3 = n;
                    if (n12 != n13) {
                        constraintWidget.setHeight(n12);
                        n3 = n;
                        if (bl4) {
                            n3 = n;
                            if (constraintWidget.getBottom() > n) {
                                n3 = Math.max(n, constraintWidget.getBottom() + constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                            }
                        }
                        n5 = 1;
                    }
                    n5 |= ((VirtualLayout)constraintWidget).needSolverPass();
                    n = n3;
                }
                n3 = n5;
            }
            n13 = 0;
            n5 = n8;
            while (true) {
                n14 = n2;
                n8 = n;
                n12 = n3;
                if (n13 >= 2) break;
                n6 = n3;
                n3 = n7;
                for (n12 = 0; n12 < n3; ++n12) {
                    metrics = this.mVariableDimensionsWidgets.get(n12);
                    if (metrics instanceof Helper && !(metrics instanceof VirtualLayout) || metrics instanceof Guideline || metrics.getVisibility() == 8 || n5 != 0 && metrics.horizontalRun.dimension.resolved && metrics.verticalRun.dimension.resolved || metrics instanceof VirtualLayout) {
                        n14 = n2;
                        n7 = n6;
                    } else {
                        n8 = metrics.getWidth();
                        n14 = metrics.getHeight();
                        int n15 = metrics.getBaselineDistance();
                        n7 = n6 | this.measure(measurer, (ConstraintWidget)metrics, true);
                        if (constraintWidgetContainer.mMetrics != null) {
                            constraintWidget = constraintWidgetContainer.mMetrics;
                            ++constraintWidget.measuredMatchWidgets;
                        }
                        int n16 = metrics.getWidth();
                        int n17 = metrics.getHeight();
                        n6 = n2;
                        if (n16 != n8) {
                            metrics.setWidth(n16);
                            n6 = n2;
                            if (n9 != 0) {
                                n6 = n2;
                                if (metrics.getRight() > n2) {
                                    n6 = Math.max(n2, metrics.getRight() + metrics.getAnchor(ConstraintAnchor.Type.RIGHT).getMargin());
                                }
                            }
                            n7 = 1;
                        }
                        n2 = n;
                        n8 = n7;
                        if (n17 != n14) {
                            metrics.setHeight(n17);
                            n2 = n;
                            if (bl4) {
                                n2 = n;
                                if (metrics.getBottom() > n) {
                                    n2 = Math.max(n, metrics.getBottom() + metrics.getAnchor(ConstraintAnchor.Type.BOTTOM).getMargin());
                                }
                            }
                            n8 = 1;
                        }
                        n14 = n6;
                        n = n2;
                        n7 = n8;
                        if (metrics.hasBaseline()) {
                            n14 = n6;
                            n = n2;
                            n7 = n8;
                            if (n15 != metrics.getBaselineDistance()) {
                                n7 = 1;
                                n = n2;
                                n14 = n6;
                            }
                        }
                    }
                    n2 = n14;
                    n6 = n7;
                }
                n14 = n2;
                n8 = n;
                n12 = n6;
                if (n6 == 0) break;
                this.solveLinearSystem(constraintWidgetContainer, "intermediate pass", n10, n11);
                ++n13;
                n6 = 0;
                n7 = n3;
                n3 = n6;
            }
            if (n12 != 0) {
                this.solveLinearSystem(constraintWidgetContainer, "2nd pass", n10, n11);
                if (constraintWidgetContainer.getWidth() < n14) {
                    constraintWidgetContainer.setWidth(n14);
                    n = 1;
                } else {
                    n = 0;
                }
                if (constraintWidgetContainer.getHeight() < n8) {
                    constraintWidgetContainer.setHeight(n8);
                    n = 1;
                }
                if (n != 0) {
                    this.solveLinearSystem(constraintWidgetContainer, "3rd pass", n10, n11);
                }
            }
        }
        constraintWidgetContainer.setOptimizationLevel(n4);
        return 0L;
    }

    public void updateHierarchy(ConstraintWidgetContainer constraintWidgetContainer) {
        this.mVariableDimensionsWidgets.clear();
        int n = constraintWidgetContainer.mChildren.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                constraintWidgetContainer.invalidateGraph();
                return;
            }
            ConstraintWidget constraintWidget = (ConstraintWidget)constraintWidgetContainer.mChildren.get(n2);
            if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                this.mVariableDimensionsWidgets.add(constraintWidget);
            }
            ++n2;
        }
    }
}
