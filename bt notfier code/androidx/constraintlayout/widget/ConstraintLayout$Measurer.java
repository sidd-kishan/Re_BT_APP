/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Optimizer
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 *  androidx.constraintlayout.widget.ConstraintHelper
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$1
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.Placeholder
 *  androidx.constraintlayout.widget.VirtualLayout
 */
package androidx.constraintlayout.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Optimizer;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;
import androidx.constraintlayout.widget.VirtualLayout;

/*
 * Exception performing whole class analysis ignored.
 */
class ConstraintLayout.Measurer
implements BasicMeasure.Measurer {
    ConstraintLayout layout;
    int layoutHeightSpec;
    int layoutWidthSpec;
    int paddingBottom;
    int paddingHeight;
    int paddingTop;
    int paddingWidth;
    final ConstraintLayout this$0;

    public ConstraintLayout.Measurer(ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2) {
        this.this$0 = constraintLayout;
        this.layout = constraintLayout2;
    }

    private boolean isSimilarSpec(int n, int n2, int n3) {
        if (n == n2) {
            return true;
        }
        int n4 = View.MeasureSpec.getMode((int)n);
        View.MeasureSpec.getSize((int)n);
        n = View.MeasureSpec.getMode((int)n2);
        n2 = View.MeasureSpec.getSize((int)n2);
        if (n != 0x40000000) return false;
        if (n4 != Integer.MIN_VALUE) {
            if (n4 != 0) return false;
        }
        if (n3 != n2) return false;
        return true;
    }

    public void captureLayoutInfos(int n, int n2, int n3, int n4, int n5, int n6) {
        this.paddingTop = n3;
        this.paddingBottom = n4;
        this.paddingWidth = n5;
        this.paddingHeight = n6;
        this.layoutWidthSpec = n;
        this.layoutHeightSpec = n2;
    }

    public final void didMeasures() {
        int n;
        int n2 = this.layout.getChildCount();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            View view = this.layout.getChildAt(n);
            if (!(view instanceof Placeholder)) continue;
            ((Placeholder)view).updatePostMeasure(this.layout);
        }
        n2 = ConstraintLayout.access$100((ConstraintLayout)this.layout).size();
        if (n2 <= 0) return;
        n = n3;
        while (n < n2) {
            ((ConstraintHelper)ConstraintLayout.access$100((ConstraintLayout)this.layout).get(n)).updatePostMeasure(this.layout);
            ++n;
        }
    }

    public final void measure(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
        int n;
        int n2;
        View view;
        int n3;
        int n4;
        int n5;
        int n6;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2;
        block39: {
            block36: {
                block32: {
                    block37: {
                        block33: {
                            block34: {
                                block38: {
                                    block35: {
                                        block31: {
                                            block28: {
                                                block24: {
                                                    block29: {
                                                        block25: {
                                                            block26: {
                                                                block30: {
                                                                    block27: {
                                                                        if (constraintWidget == null) {
                                                                            return;
                                                                        }
                                                                        if (constraintWidget.getVisibility() == 8 && !constraintWidget.isInPlaceholder()) {
                                                                            measure.measuredWidth = 0;
                                                                            measure.measuredHeight = 0;
                                                                            measure.measuredBaseline = 0;
                                                                            return;
                                                                        }
                                                                        dimensionBehaviour2 = measure.horizontalBehavior;
                                                                        dimensionBehaviour = measure.verticalBehavior;
                                                                        n6 = measure.horizontalDimension;
                                                                        n5 = measure.verticalDimension;
                                                                        n4 = this.paddingTop + this.paddingBottom;
                                                                        n3 = this.paddingWidth;
                                                                        view = (View)constraintWidget.getCompanionWidget();
                                                                        n2 = ConstraintLayout.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour2.ordinal()];
                                                                        if (n2 == 1) break block24;
                                                                        if (n2 == 2) break block25;
                                                                        if (n2 == 3) break block26;
                                                                        if (n2 == 4) break block27;
                                                                        n3 = 0;
                                                                        break block28;
                                                                    }
                                                                    n = ViewGroup.getChildMeasureSpec((int)this.layoutWidthSpec, (int)n3, (int)-2);
                                                                    n3 = constraintWidget.mMatchConstraintDefaultWidth == 1 ? 1 : 0;
                                                                    constraintWidget.wrapMeasure[2] = 0;
                                                                    n6 = n;
                                                                    if (!measure.useCurrentDimensions) break block29;
                                                                    n2 = n3 != 0 && constraintWidget.wrapMeasure[3] != 0 && constraintWidget.wrapMeasure[0] != constraintWidget.getWidth() || view instanceof Placeholder ? 1 : 0;
                                                                    if (n3 == 0) break block30;
                                                                    n6 = n;
                                                                    if (n2 == 0) break block29;
                                                                }
                                                                n3 = View.MeasureSpec.makeMeasureSpec((int)constraintWidget.getWidth(), (int)0x40000000);
                                                                break block28;
                                                            }
                                                            n3 = ViewGroup.getChildMeasureSpec((int)this.layoutWidthSpec, (int)(n3 + constraintWidget.getHorizontalMargin()), (int)-1);
                                                            constraintWidget.wrapMeasure[2] = -1;
                                                            break block28;
                                                        }
                                                        n6 = ViewGroup.getChildMeasureSpec((int)this.layoutWidthSpec, (int)n3, (int)-2);
                                                        constraintWidget.wrapMeasure[2] = -2;
                                                    }
                                                    n2 = 1;
                                                    break block31;
                                                }
                                                n3 = View.MeasureSpec.makeMeasureSpec((int)n6, (int)0x40000000);
                                                constraintWidget.wrapMeasure[2] = n6;
                                            }
                                            n2 = 0;
                                            n6 = n3;
                                        }
                                        n3 = ConstraintLayout.1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintWidget$DimensionBehaviour[dimensionBehaviour.ordinal()];
                                        if (n3 == 1) break block32;
                                        if (n3 == 2) break block33;
                                        if (n3 == 3) break block34;
                                        if (n3 == 4) break block35;
                                        n3 = 0;
                                        break block36;
                                    }
                                    n4 = ViewGroup.getChildMeasureSpec((int)this.layoutHeightSpec, (int)n4, (int)-2);
                                    n = constraintWidget.mMatchConstraintDefaultHeight == 1 ? 1 : 0;
                                    constraintWidget.wrapMeasure[3] = 0;
                                    n3 = n4;
                                    if (!measure.useCurrentDimensions) break block37;
                                    n5 = n != 0 && constraintWidget.wrapMeasure[2] != 0 && constraintWidget.wrapMeasure[1] != constraintWidget.getHeight() || view instanceof Placeholder ? 1 : 0;
                                    if (n == 0) break block38;
                                    n3 = n4;
                                    if (n5 == 0) break block37;
                                }
                                n3 = View.MeasureSpec.makeMeasureSpec((int)constraintWidget.getHeight(), (int)0x40000000);
                                break block36;
                            }
                            n3 = ViewGroup.getChildMeasureSpec((int)this.layoutHeightSpec, (int)(n4 + constraintWidget.getVerticalMargin()), (int)-1);
                            constraintWidget.wrapMeasure[3] = -1;
                            break block36;
                        }
                        n3 = ViewGroup.getChildMeasureSpec((int)this.layoutHeightSpec, (int)n4, (int)-2);
                        constraintWidget.wrapMeasure[3] = -2;
                    }
                    n = 1;
                    break block39;
                }
                n3 = View.MeasureSpec.makeMeasureSpec((int)n5, (int)0x40000000);
                constraintWidget.wrapMeasure[3] = n5;
            }
            n = 0;
        }
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer)constraintWidget.getParent();
        if (constraintWidgetContainer != null && Optimizer.enabled((int)ConstraintLayout.access$000((ConstraintLayout)this.this$0), (int)256) && view.getMeasuredWidth() == constraintWidget.getWidth() && view.getMeasuredWidth() < constraintWidgetContainer.getWidth() && view.getMeasuredHeight() == constraintWidget.getHeight() && view.getMeasuredHeight() < constraintWidgetContainer.getHeight() && view.getBaseline() == constraintWidget.getBaselineDistance() && !constraintWidget.isMeasureRequested() && (n5 = this.isSimilarSpec(constraintWidget.getLastHorizontalMeasureSpec(), n6, constraintWidget.getWidth()) && this.isSimilarSpec(constraintWidget.getLastVerticalMeasureSpec(), n3, constraintWidget.getHeight()) ? 1 : 0) != 0) {
            measure.measuredWidth = constraintWidget.getWidth();
            measure.measuredHeight = constraintWidget.getHeight();
            measure.measuredBaseline = constraintWidget.getBaselineDistance();
            return;
        }
        n5 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        n4 = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
        boolean bl = dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
        boolean bl2 = dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
        boolean bl3 = n5 != 0 && constraintWidget.mDimensionRatio > 0.0f;
        boolean bl4 = n4 != 0 && constraintWidget.mDimensionRatio > 0.0f;
        dimensionBehaviour = (ConstraintLayout.LayoutParams)view.getLayoutParams();
        if (!measure.useCurrentDimensions && n5 != 0 && constraintWidget.mMatchConstraintDefaultWidth == 0 && n4 != 0 && constraintWidget.mMatchConstraintDefaultHeight == 0) {
            n2 = 0;
            n6 = 0;
            n3 = 0;
        } else {
            if (view instanceof VirtualLayout && constraintWidget instanceof androidx.constraintlayout.solver.widgets.VirtualLayout) {
                constraintWidgetContainer = (androidx.constraintlayout.solver.widgets.VirtualLayout)constraintWidget;
                ((VirtualLayout)view).onMeasure((androidx.constraintlayout.solver.widgets.VirtualLayout)constraintWidgetContainer, n6, n3);
            } else {
                view.measure(n6, n3);
                constraintWidget.setLastMeasureSpec(n6, n3);
            }
            int n7 = view.getMeasuredWidth();
            int n8 = view.getMeasuredHeight();
            int n9 = view.getBaseline();
            if (n2 != 0) {
                constraintWidget.wrapMeasure[0] = n7;
                constraintWidget.wrapMeasure[2] = n8;
            } else {
                constraintWidget.wrapMeasure[0] = 0;
                constraintWidget.wrapMeasure[2] = 0;
            }
            if (n != 0) {
                constraintWidget.wrapMeasure[1] = n8;
                constraintWidget.wrapMeasure[3] = n7;
            } else {
                constraintWidget.wrapMeasure[1] = 0;
                constraintWidget.wrapMeasure[3] = 0;
            }
            n = constraintWidget.mMatchConstraintMinWidth > 0 ? Math.max(constraintWidget.mMatchConstraintMinWidth, n7) : n7;
            n2 = n;
            if (constraintWidget.mMatchConstraintMaxWidth > 0) {
                n2 = Math.min(constraintWidget.mMatchConstraintMaxWidth, n);
            }
            n = constraintWidget.mMatchConstraintMinHeight > 0 ? Math.max(constraintWidget.mMatchConstraintMinHeight, n8) : n8;
            n5 = n;
            if (constraintWidget.mMatchConstraintMaxHeight > 0) {
                n5 = Math.min(constraintWidget.mMatchConstraintMaxHeight, n);
            }
            n4 = n2;
            n = n5;
            if (!Optimizer.enabled((int)ConstraintLayout.access$000((ConstraintLayout)this.this$0), (int)1)) {
                if (bl3 && bl) {
                    float f = constraintWidget.mDimensionRatio;
                    n4 = (int)((float)n5 * f + 0.5f);
                    n = n5;
                } else {
                    n4 = n2;
                    n = n5;
                    if (bl4) {
                        n4 = n2;
                        n = n5;
                        if (bl2) {
                            float f = constraintWidget.mDimensionRatio;
                            n = (int)((float)n2 / f + 0.5f);
                            n4 = n2;
                        }
                    }
                }
            }
            if (n7 == n4 && n8 == n) {
                n2 = n4;
                n6 = n;
                n3 = n9;
            } else {
                if (n7 != n4) {
                    n6 = View.MeasureSpec.makeMeasureSpec((int)n4, (int)0x40000000);
                }
                if (n8 != n) {
                    n3 = View.MeasureSpec.makeMeasureSpec((int)n, (int)0x40000000);
                }
                view.measure(n6, n3);
                constraintWidget.setLastMeasureSpec(n6, n3);
                n2 = view.getMeasuredWidth();
                n6 = view.getMeasuredHeight();
                n3 = view.getBaseline();
            }
        }
        boolean bl5 = n3 != -1;
        boolean bl6 = n2 != measure.horizontalDimension || n6 != measure.verticalDimension;
        measure.measuredNeedsSolverPass = bl6;
        if (dimensionBehaviour.needsBaseline) {
            bl5 = true;
        }
        if (bl5 && n3 != -1 && constraintWidget.getBaselineDistance() != n3) {
            measure.measuredNeedsSolverPass = true;
        }
        measure.measuredWidth = n2;
        measure.measuredHeight = n6;
        measure.measuredHasBaseline = bl5;
        measure.measuredBaseline = n3;
    }
}
