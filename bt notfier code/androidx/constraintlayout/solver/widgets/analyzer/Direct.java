/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ChainHead
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import java.util.ArrayList;

public class Direct {
    private static final boolean APPLY_MATCH_PARENT = false;
    private static final boolean DEBUG = false;
    private static BasicMeasure.Measure measure = new BasicMeasure.Measure();

    private static boolean canMeasure(ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidget.getVerticalDimensionBehaviour();
        ConstraintWidgetContainer constraintWidgetContainer = constraintWidget.getParent() != null ? (ConstraintWidgetContainer)constraintWidget.getParent() : null;
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getHorizontalDimensionBehaviour();
            ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        if (constraintWidgetContainer != null) {
            constraintWidgetContainer.getVerticalDimensionBehaviour();
            constraintWidgetContainer = ConstraintWidget.DimensionBehaviour.FIXED;
        }
        constraintWidgetContainer = ConstraintWidget.DimensionBehaviour.FIXED;
        boolean bl = false;
        boolean bl2 = dimensionBehaviour == constraintWidgetContainer || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(0) || constraintWidget.isResolvedHorizontally();
        boolean bl3 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0 && constraintWidget.mDimensionRatio == 0.0f && constraintWidget.hasDanglingDimension(1) || constraintWidget.isResolvedVertically();
        if (constraintWidget.mDimensionRatio > 0.0f) {
            if (bl2) return true;
            if (bl3) {
                return true;
            }
        }
        boolean bl4 = bl;
        if (!bl2) return bl4;
        bl4 = bl;
        if (!bl3) return bl4;
        bl4 = true;
        return bl4;
    }

    private static void horizontalSolvingPass(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer) {
        int n;
        boolean bl;
        if (!(constraintWidget instanceof ConstraintWidgetContainer) && constraintWidget.isMeasureRequested() && Direct.canMeasure(constraintWidget)) {
            ConstraintWidgetContainer.measure((ConstraintWidget)constraintWidget, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
        }
        Object object = constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT);
        ConstraintAnchor constraintAnchor = constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT);
        int n2 = object.getFinalValue();
        int n3 = constraintAnchor.getFinalValue();
        if (object.getDependents() != null && object.hasFinalValue()) {
            for (ConstraintAnchor constraintAnchor2 : object.getDependents()) {
                object = constraintAnchor2.mOwner;
                bl = Direct.canMeasure((ConstraintWidget)object);
                if (object.isMeasureRequested() && bl) {
                    ConstraintWidgetContainer.measure((ConstraintWidget)object, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
                }
                if (object.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !bl) {
                    if (object.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || object.getVisibility() != 8 && (((ConstraintWidget)object).mMatchConstraintDefaultWidth != 0 || object.getDimensionRatio() != 0.0f) || object.isInHorizontalChain() || object.isInVirtualLayout() || (n = constraintAnchor2 == ((ConstraintWidget)object).mLeft && ((ConstraintWidget)object).mRight.mTarget != null && ((ConstraintWidget)object).mRight.mTarget.hasFinalValue() || constraintAnchor2 == ((ConstraintWidget)object).mRight && ((ConstraintWidget)object).mLeft.mTarget != null && ((ConstraintWidget)object).mLeft.mTarget.hasFinalValue() ? 1 : 0) == 0 || object.isInHorizontalChain()) continue;
                    Direct.solveHorizontalMatchConstraint(constraintWidget, measurer, (ConstraintWidget)object);
                    continue;
                }
                if (object.isMeasureRequested()) continue;
                if (constraintAnchor2 == ((ConstraintWidget)object).mLeft && ((ConstraintWidget)object).mRight.mTarget == null) {
                    n = ((ConstraintWidget)object).mLeft.getMargin() + n2;
                    object.setFinalHorizontal(n, object.getWidth() + n);
                    Direct.horizontalSolvingPass((ConstraintWidget)object, measurer);
                    continue;
                }
                if (constraintAnchor2 == ((ConstraintWidget)object).mRight && ((ConstraintWidget)object).mLeft.mTarget == null) {
                    n = n2 - ((ConstraintWidget)object).mRight.getMargin();
                    object.setFinalHorizontal(n - object.getWidth(), n);
                    Direct.horizontalSolvingPass((ConstraintWidget)object, measurer);
                    continue;
                }
                if (constraintAnchor2 != ((ConstraintWidget)object).mLeft || ((ConstraintWidget)object).mRight.mTarget == null || !((ConstraintWidget)object).mRight.mTarget.hasFinalValue() || object.isInHorizontalChain()) continue;
                Direct.solveHorizontalCenterConstraints(measurer, (ConstraintWidget)object);
            }
        }
        if (constraintWidget instanceof Guideline) {
            return;
        }
        if (constraintAnchor.getDependents() == null) return;
        if (!constraintAnchor.hasFinalValue()) return;
        object = constraintAnchor.getDependents().iterator();
        while (object.hasNext()) {
            constraintAnchor = (ConstraintAnchor)object.next();
            ConstraintWidget constraintWidget2 = constraintAnchor.mOwner;
            bl = Direct.canMeasure(constraintWidget2);
            if (constraintWidget2.isMeasureRequested() && bl) {
                ConstraintWidgetContainer.measure((ConstraintWidget)constraintWidget2, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
            }
            n = constraintAnchor == constraintWidget2.mLeft && constraintWidget2.mRight.mTarget != null && constraintWidget2.mRight.mTarget.hasFinalValue() || constraintAnchor == constraintWidget2.mRight && constraintWidget2.mLeft.mTarget != null && constraintWidget2.mLeft.mTarget.hasFinalValue() ? 1 : 0;
            if (constraintWidget2.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !bl) {
                if (constraintWidget2.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget2.getVisibility() != 8 && (constraintWidget2.mMatchConstraintDefaultWidth != 0 || constraintWidget2.getDimensionRatio() != 0.0f) || constraintWidget2.isInHorizontalChain() || constraintWidget2.isInVirtualLayout() || n == 0 || constraintWidget2.isInHorizontalChain()) continue;
                Direct.solveHorizontalMatchConstraint(constraintWidget, measurer, constraintWidget2);
                continue;
            }
            if (constraintWidget2.isMeasureRequested()) continue;
            if (constraintAnchor == constraintWidget2.mLeft && constraintWidget2.mRight.mTarget == null) {
                n = constraintWidget2.mLeft.getMargin() + n3;
                constraintWidget2.setFinalHorizontal(n, constraintWidget2.getWidth() + n);
                Direct.horizontalSolvingPass(constraintWidget2, measurer);
                continue;
            }
            if (constraintAnchor == constraintWidget2.mRight && constraintWidget2.mLeft.mTarget == null) {
                n = n3 - constraintWidget2.mRight.getMargin();
                constraintWidget2.setFinalHorizontal(n - constraintWidget2.getWidth(), n);
                Direct.horizontalSolvingPass(constraintWidget2, measurer);
                continue;
            }
            if (n == 0 || constraintWidget2.isInHorizontalChain()) continue;
            Direct.solveHorizontalCenterConstraints(measurer, constraintWidget2);
        }
    }

    private static void solveBarrier(Barrier barrier, BasicMeasure.Measurer measurer, int n) {
        if (!barrier.allSolved()) return;
        if (n == 0) {
            Direct.horizontalSolvingPass((ConstraintWidget)barrier, measurer);
        } else {
            Direct.verticalSolvingPass((ConstraintWidget)barrier, measurer);
        }
    }

    public static boolean solveChain(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, int n, int n2, ChainHead chainHead, boolean bl, boolean bl2, boolean bl3) {
        block38: {
            block42: {
                int n3;
                int n4;
                int n5;
                int n6;
                int n7;
                int n8;
                ConstraintAnchor constraintAnchor;
                Object object;
                block41: {
                    ConstraintWidget constraintWidget;
                    ConstraintWidget constraintWidget2;
                    ConstraintWidget constraintWidget3;
                    boolean bl4;
                    block40: {
                        boolean bl5;
                        block39: {
                            block37: {
                                bl5 = false;
                                bl4 = false;
                                if (bl3) {
                                    return false;
                                }
                                if (n == 0 ? !constraintWidgetContainer.isResolvedHorizontally() : !constraintWidgetContainer.isResolvedVertically()) {
                                    return false;
                                }
                                object = chainHead.getFirst();
                                constraintAnchor = chainHead.getLast();
                                constraintWidget3 = chainHead.getFirstVisibleWidget();
                                constraintWidget2 = chainHead.getLastVisibleWidget();
                                constraintWidget = chainHead.getHead();
                                chainHead = object.mListAnchors[n2];
                                constraintAnchor = constraintAnchor.mListAnchors;
                                n8 = n2 + 1;
                                constraintAnchor = constraintAnchor[n8];
                                bl3 = bl5;
                                if (chainHead.mTarget == null) return bl3;
                                if (constraintAnchor.mTarget != null) break block37;
                                bl3 = bl5;
                                break block38;
                            }
                            bl3 = bl5;
                            if (!chainHead.mTarget.hasFinalValue()) return bl3;
                            if (constraintAnchor.mTarget.hasFinalValue()) break block39;
                            bl3 = bl5;
                            break block38;
                        }
                        bl3 = bl5;
                        if (constraintWidget3 == null) return bl3;
                        if (constraintWidget2 != null) break block40;
                        bl3 = bl5;
                        break block38;
                    }
                    n7 = chainHead.mTarget.getFinalValue() + constraintWidget3.mListAnchors[n2].getMargin();
                    int n9 = constraintAnchor.mTarget.getFinalValue() - constraintWidget2.mListAnchors[n8].getMargin();
                    int n10 = n9 - n7;
                    if (n10 <= 0) {
                        return false;
                    }
                    BasicMeasure.Measure measure = new BasicMeasure.Measure();
                    constraintAnchor = object;
                    n6 = 0;
                    n5 = 0;
                    n4 = 0;
                    n3 = 0;
                    chainHead = object;
                    while (true) {
                        Object var23_26 = null;
                        if (n6 != 0) break;
                        object = constraintAnchor.mListAnchors[n2];
                        if (!Direct.canMeasure((ConstraintWidget)constraintAnchor)) {
                            return false;
                        }
                        if (constraintAnchor.mListDimensionBehaviors[n] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            return false;
                        }
                        if (constraintAnchor.isMeasureRequested()) {
                            ConstraintWidgetContainer.measure((ConstraintWidget)constraintAnchor, (BasicMeasure.Measurer)constraintWidgetContainer.getMeasurer(), (BasicMeasure.Measure)measure, (boolean)false);
                        }
                        int n11 = constraintAnchor.mListAnchors[n2].getMargin();
                        int n12 = n == 0 ? constraintAnchor.getWidth() : constraintAnchor.getHeight();
                        n12 = n3 + n11 + n12 + constraintAnchor.mListAnchors[n8].getMargin();
                        ++n4;
                        n3 = n5;
                        if (constraintAnchor.getVisibility() != 8) {
                            n3 = n5 + 1;
                        }
                        ConstraintAnchor constraintAnchor2 = constraintAnchor.mListAnchors[n8].mTarget;
                        object = var23_26;
                        if (constraintAnchor2 != null) {
                            constraintAnchor2 = constraintAnchor2.mOwner;
                            object = var23_26;
                            if (constraintAnchor2.mListAnchors[n2].mTarget != null) {
                                object = constraintAnchor2.mListAnchors[n2].mTarget.mOwner != constraintAnchor ? var23_26 : constraintAnchor2;
                            }
                        }
                        if (object != null) {
                            constraintAnchor = object;
                        } else {
                            n6 = 1;
                        }
                        n5 = n3;
                        n3 = n12;
                    }
                    if (n5 == 0) {
                        return false;
                    }
                    if (n5 != n4) {
                        return false;
                    }
                    if (n10 < n3) {
                        return false;
                    }
                    n3 = n10 - n3;
                    if (bl) {
                        n6 = n3 / (n5 + 1);
                    } else {
                        n6 = n3;
                        if (bl2) {
                            n6 = n3;
                            if (n5 > 2) {
                                n6 = n3 / n5 - 1;
                            }
                        }
                    }
                    if (n5 == 1) {
                        float f = n == 0 ? constraintWidget.getHorizontalBiasPercent() : constraintWidget.getVerticalBiasPercent();
                        n2 = (int)((float)n7 + 0.5f + (float)n6 * f);
                        if (n == 0) {
                            constraintWidget3.setFinalHorizontal(n2, constraintWidget3.getWidth() + n2);
                        } else {
                            constraintWidget3.setFinalVertical(n2, constraintWidget3.getHeight() + n2);
                        }
                        Direct.horizontalSolvingPass(constraintWidget3, constraintWidgetContainer.getMeasurer());
                        return true;
                    }
                    if (bl) break block41;
                    if (bl2) {
                        bl = bl4;
                        if (n5 != 2) return bl;
                        if (n == 0) {
                            constraintWidget3.setFinalHorizontal(n7, constraintWidget3.getWidth() + n7);
                            constraintWidget2.setFinalHorizontal(n9 - constraintWidget2.getWidth(), n9);
                            Direct.horizontalSolvingPass(constraintWidget3, constraintWidgetContainer.getMeasurer());
                            Direct.horizontalSolvingPass(constraintWidget2, constraintWidgetContainer.getMeasurer());
                        } else {
                            constraintWidget3.setFinalVertical(n7, constraintWidget3.getHeight() + n7);
                            constraintWidget2.setFinalVertical(n9 - constraintWidget2.getHeight(), n9);
                            Direct.verticalSolvingPass(constraintWidget3, constraintWidgetContainer.getMeasurer());
                            Direct.verticalSolvingPass(constraintWidget2, constraintWidgetContainer.getMeasurer());
                        }
                        bl = true;
                        return bl;
                    }
                    break block42;
                }
                n3 = n7 + n6;
                n5 = 0;
                object = chainHead;
                while (n5 == 0) {
                    block44: {
                        block43: {
                            chainHead = object.mListAnchors[n2];
                            if (object.getVisibility() == 8) {
                                if (n == 0) {
                                    object.setFinalHorizontal(n3, n3);
                                    Direct.horizontalSolvingPass(object, constraintWidgetContainer.getMeasurer());
                                } else {
                                    object.setFinalVertical(n3, n3);
                                    Direct.verticalSolvingPass(object, constraintWidgetContainer.getMeasurer());
                                }
                            } else {
                                n4 = n3 + object.mListAnchors[n2].getMargin();
                                if (n == 0) {
                                    object.setFinalHorizontal(n4, object.getWidth() + n4);
                                    Direct.horizontalSolvingPass(object, constraintWidgetContainer.getMeasurer());
                                    n3 = object.getWidth();
                                } else {
                                    object.setFinalVertical(n4, object.getHeight() + n4);
                                    Direct.verticalSolvingPass(object, constraintWidgetContainer.getMeasurer());
                                    n3 = object.getHeight();
                                }
                                n3 = n4 + n3 + object.mListAnchors[n8].getMargin() + n6;
                            }
                            object.addToSolver(linearSystem, false);
                            chainHead = object.mListAnchors[n8].mTarget;
                            if (chainHead == null) break block43;
                            constraintAnchor = chainHead.mOwner;
                            if (constraintAnchor.mListAnchors[n2].mTarget == null) break block43;
                            chainHead = constraintAnchor;
                            if (constraintAnchor.mListAnchors[n2].mTarget.mOwner == object) break block44;
                        }
                        chainHead = null;
                    }
                    if (chainHead != null) {
                        object = chainHead;
                        continue;
                    }
                    n5 = 1;
                }
            }
            bl3 = true;
        }
        return bl3;
    }

    private static void solveHorizontalCenterConstraints(BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float f = constraintWidget.getHorizontalBiasPercent();
        int n = constraintWidget.mLeft.mTarget.getFinalValue();
        int n2 = constraintWidget.mRight.mTarget.getFinalValue();
        int n3 = constraintWidget.mLeft.getMargin();
        int n4 = constraintWidget.mRight.getMargin();
        if (n == n2) {
            f = 0.5f;
        } else {
            n = n3 + n;
            n2 -= n4;
        }
        n3 = constraintWidget.getWidth();
        n4 = n2 - n - n3;
        if (n > n2) {
            n4 = n - n2 - n3;
        }
        float f2 = f;
        if (((ConstraintWidgetContainer)constraintWidget.getParent()).isRtl()) {
            f2 = 1.0f - f;
        }
        int n5 = (int)(f2 * (float)n4 + 0.5f) + n;
        n4 = n5 + n3;
        if (n > n2) {
            n4 = n5 - n3;
        }
        constraintWidget.setFinalHorizontal(n5, n4);
        Direct.horizontalSolvingPass(constraintWidget, measurer);
    }

    private static void solveHorizontalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int n;
        float f = constraintWidget2.getHorizontalBiasPercent();
        int n2 = constraintWidget2.mLeft.mTarget.getFinalValue() + constraintWidget2.mLeft.getMargin();
        int n3 = constraintWidget2.mRight.mTarget.getFinalValue() - constraintWidget2.mRight.getMargin();
        if (n3 < n2) return;
        int n4 = n = constraintWidget2.getWidth();
        if (constraintWidget2.getVisibility() != 8) {
            if (constraintWidget2.mMatchConstraintDefaultWidth == 2) {
                n4 = constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.getWidth() : constraintWidget.getParent().getWidth();
                n4 = (int)(constraintWidget2.getHorizontalBiasPercent() * 0.5f * (float)n4);
            } else {
                n4 = n;
                if (constraintWidget2.mMatchConstraintDefaultWidth == 0) {
                    n4 = n3 - n2;
                }
            }
            n4 = n = Math.max(constraintWidget2.mMatchConstraintMinWidth, n4);
            if (constraintWidget2.mMatchConstraintMaxWidth > 0) {
                n4 = Math.min(constraintWidget2.mMatchConstraintMaxWidth, n);
            }
        }
        n = n2 + (int)(f * (float)(n3 - n2 - n4) + 0.5f);
        constraintWidget2.setFinalHorizontal(n, n4 + n);
        Direct.horizontalSolvingPass(constraintWidget2, measurer);
    }

    private static void solveVerticalCenterConstraints(BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget) {
        float f = constraintWidget.getVerticalBiasPercent();
        int n = constraintWidget.mTop.mTarget.getFinalValue();
        int n2 = constraintWidget.mBottom.mTarget.getFinalValue();
        int n3 = constraintWidget.mTop.getMargin();
        int n4 = constraintWidget.mBottom.getMargin();
        if (n == n2) {
            f = 0.5f;
        } else {
            n = n3 + n;
            n2 -= n4;
        }
        int n5 = constraintWidget.getHeight();
        n4 = n2 - n - n5;
        if (n > n2) {
            n4 = n - n2 - n5;
        }
        int n6 = (int)(f * (float)n4 + 0.5f);
        n4 = n + n6;
        n3 = n4 + n5;
        if (n > n2) {
            n4 = n - n6;
            n3 = n4 - n5;
        }
        constraintWidget.setFinalVertical(n4, n3);
        Direct.verticalSolvingPass(constraintWidget, measurer);
    }

    private static void solveVerticalMatchConstraint(ConstraintWidget constraintWidget, BasicMeasure.Measurer measurer, ConstraintWidget constraintWidget2) {
        int n;
        float f = constraintWidget2.getVerticalBiasPercent();
        int n2 = constraintWidget2.mTop.mTarget.getFinalValue() + constraintWidget2.mTop.getMargin();
        int n3 = constraintWidget2.mBottom.mTarget.getFinalValue() - constraintWidget2.mBottom.getMargin();
        if (n3 < n2) return;
        int n4 = n = constraintWidget2.getHeight();
        if (constraintWidget2.getVisibility() != 8) {
            if (constraintWidget2.mMatchConstraintDefaultHeight == 2) {
                n4 = constraintWidget instanceof ConstraintWidgetContainer ? constraintWidget.getHeight() : constraintWidget.getParent().getHeight();
                n4 = (int)(f * 0.5f * (float)n4);
            } else {
                n4 = n;
                if (constraintWidget2.mMatchConstraintDefaultHeight == 0) {
                    n4 = n3 - n2;
                }
            }
            n4 = n = Math.max(constraintWidget2.mMatchConstraintMinHeight, n4);
            if (constraintWidget2.mMatchConstraintMaxHeight > 0) {
                n4 = Math.min(constraintWidget2.mMatchConstraintMaxHeight, n);
            }
        }
        n = n2 + (int)(f * (float)(n3 - n2 - n4) + 0.5f);
        constraintWidget2.setFinalVertical(n, n4 + n);
        Direct.verticalSolvingPass(constraintWidget2, measurer);
    }

    public static void solvingPass(ConstraintWidgetContainer constraintWidgetContainer, BasicMeasure.Measurer measurer) {
        int n;
        int n2;
        int n3;
        int n4;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidgetContainer.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = constraintWidgetContainer.getVerticalDimensionBehaviour();
        constraintWidgetContainer.resetFinalResolution();
        ArrayList arrayList = constraintWidgetContainer.getChildren();
        int n5 = arrayList.size();
        for (n4 = 0; n4 < n5; ++n4) {
            ((ConstraintWidget)arrayList.get(n4)).resetFinalResolution();
        }
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalHorizontal(0, constraintWidgetContainer.getWidth());
        } else {
            constraintWidgetContainer.setFinalLeft(0);
        }
        int n6 = 0;
        n4 = 0;
        for (n3 = 0; n3 < n5; ++n3) {
            dimensionBehaviour = (ConstraintWidget)arrayList.get(n3);
            if (dimensionBehaviour instanceof Guideline) {
                dimensionBehaviour = (Guideline)dimensionBehaviour;
                n2 = n6;
                n = n4;
                if (dimensionBehaviour.getOrientation() == 1) {
                    if (dimensionBehaviour.getRelativeBegin() != -1) {
                        dimensionBehaviour.setFinalValue(dimensionBehaviour.getRelativeBegin());
                    } else if (dimensionBehaviour.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedHorizontally()) {
                        dimensionBehaviour.setFinalValue(constraintWidgetContainer.getWidth() - dimensionBehaviour.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedHorizontally()) {
                        dimensionBehaviour.setFinalValue((int)(dimensionBehaviour.getRelativePercent() * (float)constraintWidgetContainer.getWidth() + 0.5f));
                    }
                    n2 = 1;
                    n = n4;
                }
            } else {
                n2 = n6;
                n = n4;
                if (dimensionBehaviour instanceof Barrier) {
                    n2 = n6;
                    n = n4;
                    if (((Barrier)dimensionBehaviour).getOrientation() == 0) {
                        n = 1;
                        n2 = n6;
                    }
                }
            }
            n6 = n2;
            n4 = n;
        }
        if (n6 != 0) {
            for (n6 = 0; n6 < n5; ++n6) {
                dimensionBehaviour = (ConstraintWidget)arrayList.get(n6);
                if (!(dimensionBehaviour instanceof Guideline) || (dimensionBehaviour = (Guideline)dimensionBehaviour).getOrientation() != 1) continue;
                Direct.horizontalSolvingPass((ConstraintWidget)dimensionBehaviour, measurer);
            }
        }
        Direct.horizontalSolvingPass((ConstraintWidget)constraintWidgetContainer, measurer);
        if (n4 != 0) {
            for (n4 = 0; n4 < n5; ++n4) {
                dimensionBehaviour = (ConstraintWidget)arrayList.get(n4);
                if (!(dimensionBehaviour instanceof Barrier) || (dimensionBehaviour = (Barrier)dimensionBehaviour).getOrientation() != 0) continue;
                Direct.solveBarrier((Barrier)dimensionBehaviour, measurer, 0);
            }
        }
        if (dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED) {
            constraintWidgetContainer.setFinalVertical(0, constraintWidgetContainer.getHeight());
        } else {
            constraintWidgetContainer.setFinalTop(0);
        }
        n3 = 0;
        n4 = 0;
        for (n6 = 0; n6 < n5; ++n6) {
            dimensionBehaviour2 = (ConstraintWidget)arrayList.get(n6);
            if (dimensionBehaviour2 instanceof Guideline) {
                dimensionBehaviour2 = (Guideline)dimensionBehaviour2;
                n = n3;
                n2 = n4;
                if (dimensionBehaviour2.getOrientation() == 0) {
                    if (dimensionBehaviour2.getRelativeBegin() != -1) {
                        dimensionBehaviour2.setFinalValue(dimensionBehaviour2.getRelativeBegin());
                    } else if (dimensionBehaviour2.getRelativeEnd() != -1 && constraintWidgetContainer.isResolvedVertically()) {
                        dimensionBehaviour2.setFinalValue(constraintWidgetContainer.getHeight() - dimensionBehaviour2.getRelativeEnd());
                    } else if (constraintWidgetContainer.isResolvedVertically()) {
                        dimensionBehaviour2.setFinalValue((int)(dimensionBehaviour2.getRelativePercent() * (float)constraintWidgetContainer.getHeight() + 0.5f));
                    }
                    n = 1;
                    n2 = n4;
                }
            } else {
                n = n3;
                n2 = n4;
                if (dimensionBehaviour2 instanceof Barrier) {
                    n = n3;
                    n2 = n4;
                    if (((Barrier)dimensionBehaviour2).getOrientation() == 1) {
                        n2 = 1;
                        n = n3;
                    }
                }
            }
            n3 = n;
            n4 = n2;
        }
        if (n3 != 0) {
            for (n6 = 0; n6 < n5; ++n6) {
                dimensionBehaviour2 = (ConstraintWidget)arrayList.get(n6);
                if (!(dimensionBehaviour2 instanceof Guideline) || (dimensionBehaviour2 = (Guideline)dimensionBehaviour2).getOrientation() != 0) continue;
                Direct.verticalSolvingPass((ConstraintWidget)dimensionBehaviour2, measurer);
            }
        }
        Direct.verticalSolvingPass((ConstraintWidget)constraintWidgetContainer, measurer);
        if (n4 != 0) {
            for (n4 = 0; n4 < n5; ++n4) {
                constraintWidgetContainer = (ConstraintWidget)arrayList.get(n4);
                if (!(constraintWidgetContainer instanceof Barrier) || (constraintWidgetContainer = (Barrier)constraintWidgetContainer).getOrientation() != 1) continue;
                Direct.solveBarrier((Barrier)constraintWidgetContainer, measurer, 1);
            }
        }
        n4 = 0;
        while (n4 < n5) {
            constraintWidgetContainer = (ConstraintWidget)arrayList.get(n4);
            if (constraintWidgetContainer.isMeasureRequested() && Direct.canMeasure((ConstraintWidget)constraintWidgetContainer)) {
                ConstraintWidgetContainer.measure((ConstraintWidget)constraintWidgetContainer, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)measure, (boolean)false);
                Direct.horizontalSolvingPass((ConstraintWidget)constraintWidgetContainer, measurer);
                Direct.verticalSolvingPass((ConstraintWidget)constraintWidgetContainer, measurer);
            }
            ++n4;
        }
    }

    private static void verticalSolvingPass(ConstraintWidget object, BasicMeasure.Measurer measurer) {
        int n;
        boolean bl;
        if (!(object instanceof ConstraintWidgetContainer) && object.isMeasureRequested() && Direct.canMeasure((ConstraintWidget)object)) {
            ConstraintWidgetContainer.measure((ConstraintWidget)object, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
        }
        ConstraintAnchor constraintAnchor2 = object.getAnchor(ConstraintAnchor.Type.TOP);
        Object object2 = object.getAnchor(ConstraintAnchor.Type.BOTTOM);
        int n2 = constraintAnchor2.getFinalValue();
        int n3 = object2.getFinalValue();
        if (constraintAnchor2.getDependents() != null && constraintAnchor2.hasFinalValue()) {
            for (ConstraintAnchor constraintAnchor2 : constraintAnchor2.getDependents()) {
                ConstraintWidget constraintWidget = constraintAnchor2.mOwner;
                bl = Direct.canMeasure(constraintWidget);
                if (constraintWidget.isMeasureRequested() && bl) {
                    ConstraintWidgetContainer.measure((ConstraintWidget)constraintWidget, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
                }
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !bl) {
                    if (constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintWidget.getVisibility() != 8 && (constraintWidget.mMatchConstraintDefaultHeight != 0 || constraintWidget.getDimensionRatio() != 0.0f) || constraintWidget.isInVerticalChain() || constraintWidget.isInVirtualLayout() || (n = constraintAnchor2 == constraintWidget.mTop && constraintWidget.mBottom.mTarget != null && constraintWidget.mBottom.mTarget.hasFinalValue() || constraintAnchor2 == constraintWidget.mBottom && constraintWidget.mTop.mTarget != null && constraintWidget.mTop.mTarget.hasFinalValue() ? 1 : 0) == 0 || constraintWidget.isInVerticalChain()) continue;
                    Direct.solveVerticalMatchConstraint((ConstraintWidget)object, measurer, constraintWidget);
                    continue;
                }
                if (constraintWidget.isMeasureRequested()) continue;
                if (constraintAnchor2 == constraintWidget.mTop && constraintWidget.mBottom.mTarget == null) {
                    n = constraintWidget.mTop.getMargin() + n2;
                    constraintWidget.setFinalVertical(n, constraintWidget.getHeight() + n);
                    Direct.verticalSolvingPass(constraintWidget, measurer);
                    continue;
                }
                if (constraintAnchor2 == constraintWidget.mBottom && constraintWidget.mBottom.mTarget == null) {
                    n = n2 - constraintWidget.mBottom.getMargin();
                    constraintWidget.setFinalVertical(n - constraintWidget.getHeight(), n);
                    Direct.verticalSolvingPass(constraintWidget, measurer);
                    continue;
                }
                if (constraintAnchor2 != constraintWidget.mTop || constraintWidget.mBottom.mTarget == null || !constraintWidget.mBottom.mTarget.hasFinalValue()) continue;
                Direct.solveVerticalCenterConstraints(measurer, constraintWidget);
            }
        }
        if (object instanceof Guideline) {
            return;
        }
        if (object2.getDependents() != null && object2.hasFinalValue()) {
            for (ConstraintWidget constraintWidget : object2.getDependents()) {
                constraintAnchor2 = constraintWidget.mOwner;
                bl = Direct.canMeasure((ConstraintWidget)constraintAnchor2);
                if (constraintAnchor2.isMeasureRequested() && bl) {
                    ConstraintWidgetContainer.measure((ConstraintWidget)constraintAnchor2, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
                }
                n = constraintWidget == constraintAnchor2.mTop && constraintAnchor2.mBottom.mTarget != null && constraintAnchor2.mBottom.mTarget.hasFinalValue() || constraintWidget == constraintAnchor2.mBottom && constraintAnchor2.mTop.mTarget != null && constraintAnchor2.mTop.mTarget.hasFinalValue() ? 1 : 0;
                if (constraintAnchor2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !bl) {
                    if (constraintAnchor2.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT || constraintAnchor2.getVisibility() != 8 && (constraintAnchor2.mMatchConstraintDefaultHeight != 0 || constraintAnchor2.getDimensionRatio() != 0.0f) || constraintAnchor2.isInVerticalChain() || constraintAnchor2.isInVirtualLayout() || n == 0 || constraintAnchor2.isInVerticalChain()) continue;
                    Direct.solveVerticalMatchConstraint((ConstraintWidget)object, measurer, (ConstraintWidget)constraintAnchor2);
                    continue;
                }
                if (constraintAnchor2.isMeasureRequested()) continue;
                if (constraintWidget == constraintAnchor2.mTop && constraintAnchor2.mBottom.mTarget == null) {
                    n = constraintAnchor2.mTop.getMargin() + n3;
                    constraintAnchor2.setFinalVertical(n, constraintAnchor2.getHeight() + n);
                    Direct.verticalSolvingPass((ConstraintWidget)constraintAnchor2, measurer);
                    continue;
                }
                if (constraintWidget == constraintAnchor2.mBottom && constraintAnchor2.mTop.mTarget == null) {
                    n = n3 - constraintAnchor2.mBottom.getMargin();
                    constraintAnchor2.setFinalVertical(n - constraintAnchor2.getHeight(), n);
                    Direct.verticalSolvingPass((ConstraintWidget)constraintAnchor2, measurer);
                    continue;
                }
                if (n == 0 || constraintAnchor2.isInVerticalChain()) continue;
                Direct.solveVerticalCenterConstraints(measurer, (ConstraintWidget)constraintAnchor2);
            }
        }
        if ((object = object.getAnchor(ConstraintAnchor.Type.BASELINE)).getDependents() == null) return;
        if (!object.hasFinalValue()) return;
        n = object.getFinalValue();
        object = object.getDependents().iterator();
        while (object.hasNext()) {
            constraintAnchor2 = (ConstraintAnchor)object.next();
            object2 = constraintAnchor2.mOwner;
            bl = Direct.canMeasure((ConstraintWidget)object2);
            if (object2.isMeasureRequested() && bl) {
                ConstraintWidgetContainer.measure((ConstraintWidget)object2, (BasicMeasure.Measurer)measurer, (BasicMeasure.Measure)new BasicMeasure.Measure(), (boolean)false);
            }
            if (object2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !bl || object2.isMeasureRequested() || constraintAnchor2 != ((ConstraintWidget)object2).mBaseline) continue;
            object2.setFinalBaseline(n);
            Direct.verticalSolvingPass((ConstraintWidget)object2, measurer);
        }
    }
}
