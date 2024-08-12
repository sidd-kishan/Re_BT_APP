/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.analyzer.Dependency
 *  androidx.constraintlayout.solver.widgets.analyzer.DependencyNode
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetRun
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.analyzer.Dependency;
import androidx.constraintlayout.solver.widgets.analyzer.DependencyNode;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetRun;
import java.util.ArrayList;
import java.util.Iterator;

public class ChainRun
extends WidgetRun {
    private int chainStyle;
    ArrayList<WidgetRun> widgets = new ArrayList();

    public ChainRun(ConstraintWidget constraintWidget, int n) {
        super(constraintWidget);
        this.orientation = n;
        this.build();
    }

    /*
     * WARNING - void declaration
     */
    private void build() {
        void var2_6;
        void var2_3;
        Object object = this.widget;
        ConstraintWidget object22 = object.getPreviousChainMember(this.orientation);
        while (var2_3 != null) {
            ConstraintWidget constraintWidget = var2_3.getPreviousChainMember(this.orientation);
            object = var2_3;
            ConstraintWidget constraintWidget2 = constraintWidget;
        }
        this.widget = object;
        this.widgets.add(object.getRun(this.orientation));
        ConstraintWidget constraintWidget = object.getNextChainMember(this.orientation);
        while (var2_6 != null) {
            this.widgets.add(var2_6.getRun(this.orientation));
            ConstraintWidget constraintWidget3 = var2_6.getNextChainMember(this.orientation);
        }
        for (WidgetRun widgetRun : this.widgets) {
            if (this.orientation == 0) {
                widgetRun.widget.horizontalChainRun = this;
                continue;
            }
            if (this.orientation != 1) continue;
            widgetRun.widget.verticalChainRun = this;
        }
        int n = this.orientation == 0 && ((ConstraintWidgetContainer)this.widget.getParent()).isRtl() ? 1 : 0;
        if (n != 0 && this.widgets.size() > 1) {
            ArrayList<WidgetRun> arrayList = this.widgets;
            this.widget = arrayList.get((int)(arrayList.size() - 1)).widget;
        }
        n = this.orientation == 0 ? this.widget.getHorizontalChainStyle() : this.widget.getVerticalChainStyle();
        this.chainStyle = n;
    }

    private ConstraintWidget getFirstVisibleWidget() {
        int n = 0;
        while (n < this.widgets.size()) {
            WidgetRun widgetRun = this.widgets.get(n);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
            ++n;
        }
        return null;
    }

    private ConstraintWidget getLastVisibleWidget() {
        int n = this.widgets.size() - 1;
        while (n >= 0) {
            WidgetRun widgetRun = this.widgets.get(n);
            if (widgetRun.widget.getVisibility() != 8) {
                return widgetRun.widget;
            }
            --n;
        }
        return null;
    }

    void apply() {
        ConstraintWidget constraintWidget = this.widgets.iterator();
        while (constraintWidget.hasNext()) {
            constraintWidget.next().apply();
        }
        int n = this.widgets.size();
        if (n < 1) {
            return;
        }
        ConstraintWidget constraintWidget2 = this.widgets.get((int)0).widget;
        constraintWidget = this.widgets.get((int)(n - 1)).widget;
        if (this.orientation == 0) {
            ConstraintAnchor constraintAnchor = constraintWidget2.mLeft;
            constraintWidget = constraintWidget.mRight;
            constraintWidget2 = this.getTarget(constraintAnchor, 0);
            n = constraintAnchor.getMargin();
            constraintAnchor = this.getFirstVisibleWidget();
            if (constraintAnchor != null) {
                n = constraintAnchor.mLeft.getMargin();
            }
            if (constraintWidget2 != null) {
                this.addTarget(this.start, (DependencyNode)constraintWidget2, n);
            }
            constraintWidget2 = this.getTarget((ConstraintAnchor)constraintWidget, 0);
            n = constraintWidget.getMargin();
            constraintWidget = this.getLastVisibleWidget();
            if (constraintWidget != null) {
                n = constraintWidget.mRight.getMargin();
            }
            if (constraintWidget2 != null) {
                this.addTarget(this.end, (DependencyNode)constraintWidget2, -n);
            }
        } else {
            ConstraintAnchor constraintAnchor = constraintWidget2.mTop;
            constraintWidget = constraintWidget.mBottom;
            constraintWidget2 = this.getTarget(constraintAnchor, 1);
            n = constraintAnchor.getMargin();
            constraintAnchor = this.getFirstVisibleWidget();
            if (constraintAnchor != null) {
                n = constraintAnchor.mTop.getMargin();
            }
            if (constraintWidget2 != null) {
                this.addTarget(this.start, (DependencyNode)constraintWidget2, n);
            }
            constraintWidget2 = this.getTarget((ConstraintAnchor)constraintWidget, 1);
            n = constraintWidget.getMargin();
            constraintWidget = this.getLastVisibleWidget();
            if (constraintWidget != null) {
                n = constraintWidget.mBottom.getMargin();
            }
            if (constraintWidget2 != null) {
                this.addTarget(this.end, (DependencyNode)constraintWidget2, -n);
            }
        }
        this.start.updateDelegate = this;
        this.end.updateDelegate = this;
    }

    public void applyToWidget() {
        int n = 0;
        while (n < this.widgets.size()) {
            this.widgets.get(n).applyToWidget();
            ++n;
        }
    }

    void clear() {
        this.runGroup = null;
        Iterator<WidgetRun> iterator = this.widgets.iterator();
        while (iterator.hasNext()) {
            iterator.next().clear();
        }
    }

    public long getWrapDimension() {
        int n = this.widgets.size();
        long l = 0L;
        int n2 = 0;
        while (n2 < n) {
            WidgetRun widgetRun = this.widgets.get(n2);
            l = l + (long)widgetRun.start.margin + widgetRun.getWrapDimension() + (long)widgetRun.end.margin;
            ++n2;
        }
        return l;
    }

    void reset() {
        this.start.resolved = false;
        this.end.resolved = false;
    }

    boolean supportsWrapComputation() {
        int n = this.widgets.size();
        int n2 = 0;
        while (n2 < n) {
            if (!this.widgets.get(n2).supportsWrapComputation()) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    public String toString() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("ChainRun ");
        String string = this.orientation == 0 ? "horizontal : " : "vertical : ";
        ((StringBuilder)object).append(string);
        string = ((StringBuilder)object).toString();
        object = this.widgets.iterator();
        while (object.hasNext()) {
            Object object2 = (WidgetRun)object.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("<");
            string = stringBuilder.toString();
            stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(object2);
            string = stringBuilder.toString();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append(string);
            ((StringBuilder)object2).append("> ");
            string = ((StringBuilder)object2).toString();
        }
        return string;
    }

    public void update(Dependency dependency) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        int n7;
        boolean bl;
        block100: {
            int n8;
            int n9;
            block99: {
                block97: {
                    float f;
                    float f2;
                    int n10;
                    block98: {
                        int n11;
                        block96: {
                            int n12;
                            int n13;
                            int n14;
                            int n15;
                            block89: {
                                block88: {
                                    block87: {
                                        if (!this.start.resolved) return;
                                        if (!this.end.resolved) {
                                            return;
                                        }
                                        dependency = this.widget.getParent();
                                        bl = dependency != null && dependency instanceof ConstraintWidgetContainer ? ((ConstraintWidgetContainer)dependency).isRtl() : false;
                                        n10 = this.end.value - this.start.value;
                                        n7 = this.widgets.size();
                                        n6 = 0;
                                        while (true) {
                                            n5 = -1;
                                            if (n6 >= n7) break;
                                            n4 = n6;
                                            if (this.widgets.get((int)n6).widget.getVisibility() == 8) {
                                                ++n6;
                                                continue;
                                            }
                                            break block87;
                                            break;
                                        }
                                        n4 = -1;
                                    }
                                    n6 = n3 = n7 - 1;
                                    while (true) {
                                        n2 = n5;
                                        if (n6 < 0) break block88;
                                        if (this.widgets.get((int)n6).widget.getVisibility() != 8) break;
                                        --n6;
                                    }
                                    n2 = n6;
                                }
                                n9 = 0;
                                while (true) {
                                    if (n9 >= 2) {
                                        n11 = 0;
                                        n = 0;
                                        n5 = 0;
                                        f2 = 0.0f;
                                        break block89;
                                    }
                                    n = 0;
                                    n6 = 0;
                                    n8 = 0;
                                    f2 = 0.0f;
                                    for (n15 = 0; n15 < n7; ++n15) {
                                        block91: {
                                            block93: {
                                                block95: {
                                                    block94: {
                                                        block92: {
                                                            block90: {
                                                                dependency = this.widgets.get(n15);
                                                                if (dependency.widget.getVisibility() != 8) break block90;
                                                                n5 = n;
                                                                n14 = n6;
                                                                break block91;
                                                            }
                                                            n11 = n8 + 1;
                                                            n5 = n;
                                                            if (n15 > 0) {
                                                                n5 = n;
                                                                if (n15 >= n4) {
                                                                    n5 = n + dependency.start.margin;
                                                                }
                                                            }
                                                            n14 = dependency.dimension.value;
                                                            n8 = dependency.dimensionBehavior != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT ? 1 : 0;
                                                            if (n8 == 0) break block92;
                                                            if (this.orientation == 0 && !dependency.widget.horizontalRun.dimension.resolved) {
                                                                return;
                                                            }
                                                            n13 = n8;
                                                            n12 = n14;
                                                            n = n6;
                                                            if (this.orientation == 1) {
                                                                n13 = n8;
                                                                n12 = n14;
                                                                n = n6;
                                                                if (!dependency.widget.verticalRun.dimension.resolved) {
                                                                    return;
                                                                }
                                                            }
                                                            break block93;
                                                        }
                                                        if (dependency.matchConstraintsType != 1 || n9 != 0) break block94;
                                                        n8 = dependency.dimension.wrapValue;
                                                        n = n6 + 1;
                                                        n6 = n8;
                                                        break block95;
                                                    }
                                                    n13 = n8;
                                                    n12 = n14;
                                                    n = n6;
                                                    if (!dependency.dimension.resolved) break block93;
                                                    n = n6;
                                                    n6 = n14;
                                                }
                                                n13 = 1;
                                                n12 = n6;
                                            }
                                            if (n13 == 0) {
                                                n8 = n + 1;
                                                float f3 = dependency.widget.mWeight[this.orientation];
                                                n6 = n5;
                                                n = n8;
                                                f = f2;
                                                if (f3 >= 0.0f) {
                                                    f = f2 + f3;
                                                    n6 = n5;
                                                    n = n8;
                                                }
                                            } else {
                                                n6 = n5 + n12;
                                                f = f2;
                                            }
                                            n5 = n6;
                                            n14 = n;
                                            n8 = n11;
                                            f2 = f;
                                            if (n15 < n3) {
                                                n5 = n6;
                                                n14 = n;
                                                n8 = n11;
                                                f2 = f;
                                                if (n15 < n2) {
                                                    n5 = n6 + -dependency.end.margin;
                                                    f2 = f;
                                                    n8 = n11;
                                                    n14 = n;
                                                }
                                            }
                                        }
                                        n = n5;
                                        n6 = n14;
                                    }
                                    if (n < n10 || n6 == 0) break;
                                    ++n9;
                                }
                                n11 = n8;
                                n5 = n6;
                            }
                            n8 = this.start.value;
                            if (bl) {
                                n8 = this.end.value;
                            }
                            n6 = n8;
                            if (n > n10) {
                                n6 = bl ? n8 + (int)((float)(n - n10) / 2.0f + 0.5f) : n8 - (int)((float)(n - n10) / 2.0f + 0.5f);
                            }
                            if (n5 <= 0) {
                                n9 = n5;
                            } else {
                                f = n10 - n;
                                n14 = (int)(f / (float)n5 + 0.5f);
                                n8 = 0;
                                n9 = n;
                                n15 = n6;
                                for (int i = 0; i < n7; ++i) {
                                    dependency = this.widgets.get(i);
                                    if (dependency.widget.getVisibility() != 8 && dependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && !dependency.dimension.resolved) {
                                        n6 = f2 > 0.0f ? (int)(dependency.widget.mWeight[this.orientation] * f / f2 + 0.5f) : n14;
                                        if (this.orientation == 0) {
                                            n13 = dependency.widget.mMatchConstraintMaxWidth;
                                            n12 = dependency.widget.mMatchConstraintMinWidth;
                                            n = dependency.matchConstraintsType == 1 ? Math.min(n6, dependency.dimension.wrapValue) : n6;
                                            n12 = n = Math.max(n12, n);
                                            if (n13 > 0) {
                                                n12 = Math.min(n13, n);
                                            }
                                            n13 = n6;
                                            n = n8;
                                            if (n12 != n6) {
                                                n = n8 + 1;
                                                n13 = n12;
                                            }
                                        } else {
                                            n13 = dependency.widget.mMatchConstraintMaxHeight;
                                            n12 = dependency.widget.mMatchConstraintMinHeight;
                                            n = dependency.matchConstraintsType == 1 ? Math.min(n6, dependency.dimension.wrapValue) : n6;
                                            n12 = n = Math.max(n12, n);
                                            if (n13 > 0) {
                                                n12 = Math.min(n13, n);
                                            }
                                            n13 = n6;
                                            n = n8;
                                            if (n12 != n6) {
                                                n = n8 + 1;
                                                n13 = n12;
                                            }
                                        }
                                        dependency.dimension.resolve(n13);
                                    } else {
                                        n = n8;
                                    }
                                    n8 = n;
                                }
                                if (n8 <= 0) {
                                    n6 = n9;
                                } else {
                                    n9 = n5 - n8;
                                    n6 = 0;
                                    for (n5 = 0; n5 < n7; ++n5) {
                                        dependency = this.widgets.get(n5);
                                        if (dependency.widget.getVisibility() == 8) continue;
                                        n = n6;
                                        if (n5 > 0) {
                                            n = n6;
                                            if (n5 >= n4) {
                                                n = n6 + dependency.start.margin;
                                            }
                                        }
                                        n6 = n += dependency.dimension.value;
                                        if (n5 >= n3) continue;
                                        n6 = n;
                                        if (n5 >= n2) continue;
                                        n6 = n + -dependency.end.margin;
                                    }
                                    n5 = n9;
                                }
                                if (this.chainStyle == 2 && n8 == 0) {
                                    this.chainStyle = 0;
                                    n = n6;
                                    n9 = n5;
                                    n6 = n15;
                                } else {
                                    n = n6;
                                    n9 = n5;
                                    n6 = n15;
                                }
                            }
                            if (n > n10) {
                                this.chainStyle = 2;
                            }
                            if (n11 > 0 && n9 == 0 && n4 == n2) {
                                this.chainStyle = 2;
                            }
                            if ((n5 = this.chainStyle) != 1) break block96;
                            n5 = n11 > 1 ? (n10 - n) / (n11 - 1) : (n11 == 1 ? (n10 - n) / 2 : 0);
                            n8 = n5;
                            if (n9 > 0) {
                                n8 = 0;
                            }
                            break block97;
                        }
                        if (n5 != 0) break block98;
                        n8 = (n10 - n) / (n11 + 1);
                        if (n9 > 0) {
                            n8 = 0;
                        }
                        break block99;
                    }
                    if (n5 != 2) return;
                    f2 = this.orientation == 0 ? this.widget.getHorizontalBiasPercent() : this.widget.getVerticalBiasPercent();
                    f = f2;
                    if (bl) {
                        f = 1.0f - f2;
                    }
                    if ((n5 = (int)((float)(n10 - n) * f + 0.5f)) < 0 || n9 > 0) {
                        n5 = 0;
                    }
                    n6 = bl ? (n6 -= n5) : (n6 += n5);
                    break block100;
                }
                n5 = 0;
                n = n6;
                while (n5 < n7) {
                    n6 = bl ? n7 - (n5 + 1) : n5;
                    dependency = this.widgets.get(n6);
                    if (dependency.widget.getVisibility() == 8) {
                        dependency.start.resolve(n);
                        dependency.end.resolve(n);
                        n6 = n;
                    } else {
                        n6 = n;
                        if (n5 > 0) {
                            n6 = bl ? n - n8 : n + n8;
                        }
                        n = n6;
                        if (n5 > 0) {
                            n = n6;
                            if (n5 >= n4) {
                                n = bl ? n6 - dependency.start.margin : n6 + dependency.start.margin;
                            }
                        }
                        if (bl) {
                            dependency.end.resolve(n);
                        } else {
                            dependency.start.resolve(n);
                        }
                        n6 = n9 = dependency.dimension.value;
                        if (dependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            n6 = n9;
                            if (dependency.matchConstraintsType == 1) {
                                n6 = dependency.dimension.wrapValue;
                            }
                        }
                        n = bl ? (n -= n6) : (n += n6);
                        if (bl) {
                            dependency.start.resolve(n);
                        } else {
                            dependency.end.resolve(n);
                        }
                        dependency.resolved = true;
                        n6 = n;
                        if (n5 < n3) {
                            n6 = n;
                            if (n5 < n2) {
                                n6 = bl ? n - -dependency.end.margin : n + -dependency.end.margin;
                            }
                        }
                    }
                    ++n5;
                    n = n6;
                }
                return;
            }
            n5 = 0;
            while (n5 < n7) {
                n = bl ? n7 - (n5 + 1) : n5;
                dependency = this.widgets.get(n);
                if (dependency.widget.getVisibility() == 8) {
                    dependency.start.resolve(n6);
                    dependency.end.resolve(n6);
                } else {
                    n = bl ? n6 - n8 : n6 + n8;
                    n6 = n;
                    if (n5 > 0) {
                        n6 = n;
                        if (n5 >= n4) {
                            n6 = bl ? n - dependency.start.margin : n + dependency.start.margin;
                        }
                    }
                    if (bl) {
                        dependency.end.resolve(n6);
                    } else {
                        dependency.start.resolve(n6);
                    }
                    n = n9 = dependency.dimension.value;
                    if (dependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        n = n9;
                        if (dependency.matchConstraintsType == 1) {
                            n = Math.min(n9, dependency.dimension.wrapValue);
                        }
                    }
                    n = bl ? n6 - n : n6 + n;
                    if (bl) {
                        dependency.start.resolve(n);
                    } else {
                        dependency.end.resolve(n);
                    }
                    n6 = n;
                    if (n5 < n3) {
                        n6 = n;
                        if (n5 < n2) {
                            n6 = bl ? n - -dependency.end.margin : n + -dependency.end.margin;
                        }
                    }
                }
                ++n5;
            }
            return;
        }
        n5 = 0;
        while (n5 < n7) {
            n = bl ? n7 - (n5 + 1) : n5;
            dependency = this.widgets.get(n);
            if (dependency.widget.getVisibility() == 8) {
                dependency.start.resolve(n6);
                dependency.end.resolve(n6);
            } else {
                n = n6;
                if (n5 > 0) {
                    n = n6;
                    if (n5 >= n4) {
                        n = bl ? n6 - dependency.start.margin : n6 + dependency.start.margin;
                    }
                }
                if (bl) {
                    dependency.end.resolve(n);
                } else {
                    dependency.start.resolve(n);
                }
                n6 = dependency.dimension.value;
                if (dependency.dimensionBehavior == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && dependency.matchConstraintsType == 1) {
                    n6 = dependency.dimension.wrapValue;
                }
                n = bl ? (n -= n6) : (n += n6);
                if (bl) {
                    dependency.start.resolve(n);
                } else {
                    dependency.end.resolve(n);
                }
                n6 = n;
                if (n5 < n3) {
                    n6 = n;
                    if (n5 < n2) {
                        n6 = bl ? n - -dependency.end.margin : n + -dependency.end.margin;
                    }
                }
            }
            ++n5;
        }
    }
}
