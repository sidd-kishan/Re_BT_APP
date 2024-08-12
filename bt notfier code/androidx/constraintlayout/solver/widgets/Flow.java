/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Flow$WidgetsList
 *  androidx.constraintlayout.solver.widgets.VirtualLayout
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Flow
extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private int[] mAlignedDimensions = null;
    private ArrayList<WidgetsList> mChainList = new ArrayList();
    private ConstraintWidget[] mDisplayedWidgets;
    private int mDisplayedWidgetsCount = 0;
    private float mFirstHorizontalBias = 0.5f;
    private int mFirstHorizontalStyle = -1;
    private float mFirstVerticalBias = 0.5f;
    private int mFirstVerticalStyle = -1;
    private int mHorizontalAlign = 2;
    private float mHorizontalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mHorizontalStyle = -1;
    private float mLastHorizontalBias = 0.5f;
    private int mLastHorizontalStyle = -1;
    private float mLastVerticalBias = 0.5f;
    private int mLastVerticalStyle = -1;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private int mVerticalAlign = 2;
    private float mVerticalBias = 0.5f;
    private int mVerticalGap = 0;
    private int mVerticalStyle = -1;
    private int mWrapMode = 0;

    static /* synthetic */ int access$000(Flow flow) {
        return flow.mHorizontalGap;
    }

    static /* synthetic */ int access$100(Flow flow) {
        return flow.mVerticalGap;
    }

    static /* synthetic */ int access$1000(Flow flow) {
        return flow.mFirstHorizontalStyle;
    }

    static /* synthetic */ float access$1100(Flow flow) {
        return flow.mFirstHorizontalBias;
    }

    static /* synthetic */ int access$1200(Flow flow) {
        return flow.mLastHorizontalStyle;
    }

    static /* synthetic */ float access$1300(Flow flow) {
        return flow.mLastHorizontalBias;
    }

    static /* synthetic */ float access$1400(Flow flow) {
        return flow.mVerticalBias;
    }

    static /* synthetic */ int access$1500(Flow flow) {
        return flow.mFirstVerticalStyle;
    }

    static /* synthetic */ float access$1600(Flow flow) {
        return flow.mFirstVerticalBias;
    }

    static /* synthetic */ int access$1700(Flow flow) {
        return flow.mLastVerticalStyle;
    }

    static /* synthetic */ float access$1800(Flow flow) {
        return flow.mLastVerticalBias;
    }

    static /* synthetic */ int access$1900(Flow flow) {
        return flow.mHorizontalAlign;
    }

    static /* synthetic */ int access$200(Flow flow, ConstraintWidget constraintWidget, int n) {
        return flow.getWidgetWidth(constraintWidget, n);
    }

    static /* synthetic */ int access$300(Flow flow, ConstraintWidget constraintWidget, int n) {
        return flow.getWidgetHeight(constraintWidget, n);
    }

    static /* synthetic */ int access$400(Flow flow) {
        return flow.mDisplayedWidgetsCount;
    }

    static /* synthetic */ ConstraintWidget[] access$500(Flow flow) {
        return flow.mDisplayedWidgets;
    }

    static /* synthetic */ int access$600(Flow flow) {
        return flow.mVerticalStyle;
    }

    static /* synthetic */ int access$700(Flow flow) {
        return flow.mVerticalAlign;
    }

    static /* synthetic */ int access$800(Flow flow) {
        return flow.mHorizontalStyle;
    }

    static /* synthetic */ float access$900(Flow flow) {
        return flow.mHorizontalBias;
    }

    private void createAlignedConstraints(boolean bl) {
        Object object;
        ConstraintWidget constraintWidget;
        int n;
        int n2;
        if (this.mAlignedDimensions == null) return;
        if (this.mAlignedBiggestElementsInCols == null) return;
        if (this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (n2 = 0; n2 < this.mDisplayedWidgetsCount; ++n2) {
            this.mDisplayedWidgets[n2].resetAnchors();
        }
        Object object2 = this.mAlignedDimensions;
        int n3 = object2[0];
        int n4 = object2[1];
        object2 = null;
        for (n2 = 0; n2 < n3; ++n2) {
            n = bl ? n3 - n2 - 1 : n2;
            constraintWidget = this.mAlignedBiggestElementsInCols[n];
            object = object2;
            if (constraintWidget != null) {
                if (constraintWidget.getVisibility() == 8) {
                    object = object2;
                } else {
                    if (n2 == 0) {
                        constraintWidget.connect(constraintWidget.mLeft, this.mLeft, this.getPaddingLeft());
                        constraintWidget.setHorizontalChainStyle(this.mHorizontalStyle);
                        constraintWidget.setHorizontalBiasPercent(this.mHorizontalBias);
                    }
                    if (n2 == n3 - 1) {
                        constraintWidget.connect(constraintWidget.mRight, this.mRight, this.getPaddingRight());
                    }
                    if (n2 > 0) {
                        constraintWidget.connect(constraintWidget.mLeft, object2.mRight, this.mHorizontalGap);
                        object2.connect(object2.mRight, constraintWidget.mLeft, 0);
                    }
                    object = constraintWidget;
                }
            }
            object2 = object;
        }
        for (n2 = 0; n2 < n4; ++n2) {
            constraintWidget = this.mAlignedBiggestElementsInRows[n2];
            object = object2;
            if (constraintWidget != null) {
                if (constraintWidget.getVisibility() == 8) {
                    object = object2;
                } else {
                    if (n2 == 0) {
                        constraintWidget.connect(constraintWidget.mTop, this.mTop, this.getPaddingTop());
                        constraintWidget.setVerticalChainStyle(this.mVerticalStyle);
                        constraintWidget.setVerticalBiasPercent(this.mVerticalBias);
                    }
                    if (n2 == n4 - 1) {
                        constraintWidget.connect(constraintWidget.mBottom, this.mBottom, this.getPaddingBottom());
                    }
                    if (n2 > 0) {
                        constraintWidget.connect(constraintWidget.mTop, object2.mBottom, this.mVerticalGap);
                        object2.connect(object2.mBottom, constraintWidget.mTop, 0);
                    }
                    object = constraintWidget;
                }
            }
            object2 = object;
        }
        n2 = 0;
        while (n2 < n3) {
            for (n = 0; n < n4; ++n) {
                int n5 = n * n3 + n2;
                if (this.mOrientation == 1) {
                    n5 = n2 * n4 + n;
                }
                if (n5 >= ((int[])(object2 = (Object)this.mDisplayedWidgets)).length || (object2 = (Object)object2[n5]) == null || object2.getVisibility() == 8) continue;
                object = this.mAlignedBiggestElementsInCols[n2];
                constraintWidget = this.mAlignedBiggestElementsInRows[n];
                if (object2 != object) {
                    object2.connect(object2.mLeft, object.mLeft, 0);
                    object2.connect(object2.mRight, object.mRight, 0);
                }
                if (object2 == constraintWidget) continue;
                object2.connect(object2.mTop, constraintWidget.mTop, 0);
                object2.connect(object2.mBottom, constraintWidget.mBottom, 0);
            }
            ++n2;
        }
    }

    private final int getWidgetHeight(ConstraintWidget constraintWidget, int n) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) return constraintWidget.getHeight();
        if (constraintWidget.mMatchConstraintDefaultHeight == 0) {
            return 0;
        }
        if (constraintWidget.mMatchConstraintDefaultHeight == 2) {
            if ((n = (int)(constraintWidget.mMatchConstraintPercentHeight * (float)n)) == constraintWidget.getHeight()) return n;
            constraintWidget.setMeasureRequested(true);
            this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, n);
            return n;
        }
        if (constraintWidget.mMatchConstraintDefaultHeight == 1) {
            return constraintWidget.getHeight();
        }
        if (constraintWidget.mMatchConstraintDefaultHeight != 3) return constraintWidget.getHeight();
        return (int)((float)constraintWidget.getWidth() * constraintWidget.mDimensionRatio + 0.5f);
    }

    private final int getWidgetWidth(ConstraintWidget constraintWidget, int n) {
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) return constraintWidget.getWidth();
        if (constraintWidget.mMatchConstraintDefaultWidth == 0) {
            return 0;
        }
        if (constraintWidget.mMatchConstraintDefaultWidth == 2) {
            if ((n = (int)(constraintWidget.mMatchConstraintPercentWidth * (float)n)) == constraintWidget.getWidth()) return n;
            constraintWidget.setMeasureRequested(true);
            this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, n, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
            return n;
        }
        if (constraintWidget.mMatchConstraintDefaultWidth == 1) {
            return constraintWidget.getWidth();
        }
        if (constraintWidget.mMatchConstraintDefaultWidth != 3) return constraintWidget.getWidth();
        return (int)((float)constraintWidget.getHeight() * constraintWidget.mDimensionRatio + 0.5f);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void measureAligned(ConstraintWidget[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        block40: {
            block41: {
                block39: {
                    block38: {
                        block36: {
                            block37: {
                                block34: {
                                    block35: {
                                        block33: {
                                            if (var3_3 != 0) break block33;
                                            var8_7 = var6_6 = this.mMaxElementsWrap;
                                            if (var6_6 > 0) break block34;
                                            break block35;
                                        }
                                        var8_7 = var6_6 = this.mMaxElementsWrap;
                                        if (var6_6 > 0) break block36;
                                        break block37;
                                    }
                                    var6_6 = 0;
                                    var9_8 = 0;
                                    var7_9 = 0;
                                    while (true) {
                                        var8_7 = var6_6;
                                        if (var9_8 >= var2_2) break;
                                        var8_7 = var7_9;
                                        if (var9_8 > 0) {
                                            var8_7 = var7_9 + this.mHorizontalGap;
                                        }
                                        if ((var13_10 = var1_1 /* !! */ [var9_8]) == null) {
                                            var7_9 = var8_7;
                                        } else {
                                            var7_9 = var8_7 + this.getWidgetWidth(var13_10, var4_4);
                                            if (var7_9 > var4_4) {
                                                var8_7 = var6_6;
                                                break;
                                            }
                                            ++var6_6;
                                        }
                                        ++var9_8;
                                    }
                                }
                                var7_9 = var8_7;
                                var6_6 = 0;
                                break block38;
                            }
                            var6_6 = 0;
                            var9_8 = 0;
                            var7_9 = 0;
                            while (true) {
                                var8_7 = var6_6;
                                if (var9_8 >= var2_2) break;
                                var8_7 = var7_9;
                                if (var9_8 > 0) {
                                    var8_7 = var7_9 + this.mVerticalGap;
                                }
                                if ((var13_10 = var1_1 /* !! */ [var9_8]) == null) {
                                    var7_9 = var8_7;
                                } else {
                                    var7_9 = var8_7 + this.getWidgetHeight(var13_10, var4_4);
                                    if (var7_9 > var4_4) {
                                        var8_7 = var6_6;
                                        break;
                                    }
                                    ++var6_6;
                                }
                                ++var9_8;
                            }
                        }
                        var7_9 = 0;
                        var6_6 = var8_7;
                    }
                    if (this.mAlignedDimensions == null) {
                        this.mAlignedDimensions = new int[2];
                    }
                    if (var6_6 != 0) break block39;
                    var11_11 = var6_6;
                    var10_12 = var7_9;
                    if (var3_3 == 1) break block40;
                }
                if (var7_9 == 0 && var3_3 == 0) break block41;
                var12_13 = false;
                ** GOTO lbl75
            }
            var10_12 = var7_9;
            var11_11 = var6_6;
        }
        block2: while (true) {
            var12_13 = true;
            var6_6 = var11_11;
            var7_9 = var10_12;
lbl75:
            // 2 sources

            block3: while (true) {
                if (var12_13) {
                    var1_1 /* !! */  = (ConstraintWidget[])this.mAlignedDimensions;
                    var1_1 /* !! */ [0] = (ConstraintWidget)var7_9;
                    var1_1 /* !! */ [1] = (ConstraintWidget)var6_6;
                    return;
                }
                if (var3_3 == 0) {
                    var6_6 = (int)Math.ceil((float)var2_2 / (float)var7_9);
                } else {
                    var7_9 = (int)Math.ceil((float)var2_2 / (float)var6_6);
                }
                var13_10 = this.mAlignedBiggestElementsInCols;
                if (var13_10 != null && ((ConstraintWidget[])var13_10).length >= var7_9) {
                    Arrays.fill((Object[])var13_10, null);
                } else {
                    this.mAlignedBiggestElementsInCols = new ConstraintWidget[var7_9];
                }
                var13_10 = this.mAlignedBiggestElementsInRows;
                if (var13_10 != null && ((Object[])var13_10).length >= var6_6) {
                    Arrays.fill((Object[])var13_10, null);
                } else {
                    this.mAlignedBiggestElementsInRows = new ConstraintWidget[var6_6];
                }
                var8_7 = 0;
                while (true) {
                    if (var8_7 < var7_9) {
                    } else {
                        var8_7 = 0;
                        for (var9_8 = 0; var9_8 < var7_9; ++var9_8) {
                            var13_10 = this.mAlignedBiggestElementsInCols[var9_8];
                            var10_12 = var8_7;
                            if (var13_10 != null) {
                                var10_12 = var8_7;
                                if (var9_8 > 0) {
                                    var10_12 = var8_7 + this.mHorizontalGap;
                                }
                                var10_12 += this.getWidgetWidth(var13_10, var4_4);
                            }
                            var8_7 = var10_12;
                        }
                        var9_8 = 0;
                        for (var10_12 = 0; var10_12 < var6_6; ++var10_12) {
                            var13_10 = this.mAlignedBiggestElementsInRows[var10_12];
                            var11_11 = var9_8;
                            if (var13_10 != null) {
                                var11_11 = var9_8;
                                if (var10_12 > 0) {
                                    var11_11 = var9_8 + this.mVerticalGap;
                                }
                                var11_11 += this.getWidgetHeight(var13_10, var4_4);
                            }
                            var9_8 = var11_11;
                        }
                        var5_5[0] = var8_7;
                        var5_5[1] = var9_8;
                        if (var3_3 == 0) {
                            var11_11 = var6_6;
                            var10_12 = var7_9;
                            if (var8_7 <= var4_4) continue block2;
                            var11_11 = var6_6;
                            var10_12 = var7_9;
                            if (var7_9 <= 1) continue block2;
                            --var7_9;
                            continue block3;
                        }
                        var11_11 = var6_6;
                        var10_12 = var7_9;
                        if (var9_8 <= var4_4) continue block2;
                        var11_11 = var6_6;
                        var10_12 = var7_9;
                        if (var6_6 <= 1) ** break;
                        --var6_6;
                        continue block3;
                    }
                    for (var9_8 = 0; var9_8 < var6_6; ++var9_8) {
                        var10_12 = var9_8 * var7_9 + var8_7;
                        if (var3_3 == 1) {
                            var10_12 = var8_7 * var6_6 + var9_8;
                        }
                        if (var10_12 >= var1_1 /* !! */ .length || (var13_10 = var1_1 /* !! */ [var10_12]) == null) continue;
                        var10_12 = this.getWidgetWidth(var13_10, var4_4);
                        var14_14 = this.mAlignedBiggestElementsInCols;
                        if (var14_14[var8_7] == null || var14_14[var8_7].getWidth() < var10_12) {
                            this.mAlignedBiggestElementsInCols[var8_7] = var13_10;
                        }
                        var10_12 = this.getWidgetHeight(var13_10, var4_4);
                        var14_14 = this.mAlignedBiggestElementsInRows;
                        if (var14_14[var9_8] != null && var14_14[var9_8].getHeight() >= var10_12) continue;
                        this.mAlignedBiggestElementsInRows[var9_8] = var13_10;
                    }
                    ++var8_7;
                }
                break;
            }
            break;
        }
    }

    /*
     * Unable to fully structure code
     */
    private void measureChainWrap(ConstraintWidget[] var1_1, int var2_2, int var3_3, int var4_4, int[] var5_5) {
        block30: {
            block31: {
                if (var2_2 == 0) {
                    return;
                }
                this.mChainList.clear();
                var14_6 = new WidgetsList(this, var3_3, this.mLeft, this.mTop, this.mRight, this.mBottom, var4_4);
                this.mChainList.add(var14_6);
                if (var3_3 != 0) break block31;
                var6_7 = 0;
                var8_8 = 0;
                var9_9 = 0;
                while (true) {
                    block32: {
                        var7_10 = var6_7;
                        if (var9_9 >= var2_2) break block30;
                        var16_15 = var1_1[var9_9];
                        var11_12 = this.getWidgetWidth(var16_15, var4_4);
                        var7_10 = var6_7;
                        if (var16_15.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                            var7_10 = var6_7 + 1;
                        }
                        var6_7 = (var8_8 == var4_4 || this.mHorizontalGap + var8_8 + var11_12 > var4_4) && WidgetsList.access$2000((WidgetsList)var14_6) != null ? 1 : 0;
                        var10_11 = var6_7;
                        if (var6_7 == 0) {
                            var10_11 = var6_7;
                            if (var9_9 > 0) {
                                var12_13 = this.mMaxElementsWrap;
                                var10_11 = var6_7;
                                if (var12_13 > 0) {
                                    var10_11 = var6_7;
                                    if (var9_9 % var12_13 == 0) {
                                        var10_11 = 1;
                                    }
                                }
                            }
                        }
                        if (var10_11 == 0) break block32;
                        var15_14 = new WidgetsList(this, var3_3, this.mLeft, this.mTop, this.mRight, this.mBottom, var4_4);
                        var15_14.setStartIndex(var9_9);
                        this.mChainList.add(var15_14);
                        ** GOTO lbl-1000
                    }
                    var15_14 = var14_6;
                    if (var9_9 > 0) {
                        var8_8 += this.mHorizontalGap + var11_12;
                    } else lbl-1000:
                    // 2 sources

                    {
                        var8_8 = var11_12;
                        var14_6 = var15_14;
                    }
                    var14_6.add(var16_15);
                    ++var9_9;
                    var6_7 = var7_10;
                }
            }
            var6_7 = 0;
            var8_8 = 0;
            var9_9 = 0;
            var15_14 = var14_6;
            while (true) {
                block33: {
                    var7_10 = var6_7;
                    if (var9_9 >= var2_2) break;
                    var16_15 = var1_1[var9_9];
                    var11_12 = this.getWidgetHeight(var16_15, var4_4);
                    var7_10 = var6_7;
                    if (var16_15.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                        var7_10 = var6_7 + 1;
                    }
                    var6_7 = (var8_8 == var4_4 || this.mVerticalGap + var8_8 + var11_12 > var4_4) && WidgetsList.access$2000((WidgetsList)var15_14) != null ? 1 : 0;
                    var10_11 = var6_7;
                    if (var6_7 == 0) {
                        var10_11 = var6_7;
                        if (var9_9 > 0) {
                            var12_13 = this.mMaxElementsWrap;
                            var10_11 = var6_7;
                            if (var12_13 > 0) {
                                var10_11 = var6_7;
                                if (var9_9 % var12_13 == 0) {
                                    var10_11 = 1;
                                }
                            }
                        }
                    }
                    if (var10_11 == 0) break block33;
                    var14_6 = new WidgetsList(this, var3_3, this.mLeft, this.mTop, this.mRight, this.mBottom, var4_4);
                    var14_6.setStartIndex(var9_9);
                    this.mChainList.add(var14_6);
                    ** GOTO lbl-1000
                }
                var14_6 = var15_14;
                if (var9_9 > 0) {
                    var8_8 += this.mVerticalGap + var11_12;
                    var14_6 = var15_14;
                } else lbl-1000:
                // 2 sources

                {
                    var8_8 = var11_12;
                }
                var14_6.add(var16_15);
                ++var9_9;
                var6_7 = var7_10;
                var15_14 = var14_6;
            }
        }
        var13_16 = this.mChainList.size();
        var1_1 = this.mLeft;
        var16_15 = this.mTop;
        var14_6 = this.mRight;
        var15_14 = this.mBottom;
        var8_8 = this.getPaddingLeft();
        var9_9 = this.getPaddingTop();
        var11_12 = this.getPaddingRight();
        var10_11 = this.getPaddingBottom();
        var2_2 = this.getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT && this.getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 0 : 1;
        if (var7_10 > 0 && var2_2 != 0) {
            for (var2_2 = 0; var2_2 < var13_16; ++var2_2) {
                var17_17 = this.mChainList.get(var2_2);
                if (var3_3 == 0) {
                    var17_17.measureMatchConstraints(var4_4 - var17_17.getWidth());
                    continue;
                }
                var17_17.measureMatchConstraints(var4_4 - var17_17.getHeight());
            }
        }
        var6_7 = 0;
        var12_13 = 0;
        var7_10 = 0;
        while (true) {
            if (var7_10 >= var13_16) {
                var5_5[0] = var12_13;
                var5_5[1] = var6_7;
                return;
            }
            var18_18 = this.mChainList.get(var7_10);
            if (var3_3 == 0) {
                if (var7_10 < var13_16 - 1) {
                    var15_14 = WidgetsList.access$2000((WidgetsList)this.mChainList.get((int)(var7_10 + 1))).mTop;
                    var2_2 = 0;
                } else {
                    var15_14 = this.mBottom;
                    var2_2 = this.getPaddingBottom();
                }
                var17_17 = WidgetsList.access$2000((WidgetsList)var18_18).mBottom;
                var18_18.setup(var3_3, var1_1, (ConstraintAnchor)var16_15, (ConstraintAnchor)var14_6, (ConstraintAnchor)var15_14, var8_8, var9_9, var11_12, var2_2, var4_4);
                var9_9 = Math.max(var12_13, var18_18.getWidth());
                var6_7 = var10_11 = var6_7 + var18_18.getHeight();
                if (var7_10 > 0) {
                    var6_7 = var10_11 + this.mVerticalGap;
                }
                var16_15 = var17_17;
                var12_13 = 0;
                var10_11 = var2_2;
                var2_2 = var9_9;
                var9_9 = var12_13;
            } else {
                if (var7_10 < var13_16 - 1) {
                    var14_6 = WidgetsList.access$2000((WidgetsList)this.mChainList.get((int)(var7_10 + 1))).mLeft;
                    var2_2 = 0;
                } else {
                    var14_6 = this.mRight;
                    var2_2 = this.getPaddingRight();
                }
                var17_17 = WidgetsList.access$2000((WidgetsList)var18_18).mRight;
                var18_18.setup(var3_3, var1_1, (ConstraintAnchor)var16_15, (ConstraintAnchor)var14_6, (ConstraintAnchor)var15_14, var8_8, var9_9, var2_2, var10_11, var4_4);
                var11_12 = var12_13 + var18_18.getWidth();
                var8_8 = Math.max(var6_7, var18_18.getHeight());
                var6_7 = var11_12;
                if (var7_10 > 0) {
                    var6_7 = var11_12 + this.mHorizontalGap;
                }
                var11_12 = var2_2;
                var1_1 = var17_17;
                var12_13 = 0;
                var2_2 = var6_7;
                var6_7 = var8_8;
                var8_8 = var12_13;
            }
            ++var7_10;
            var12_13 = var2_2;
        }
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArray, int n, int n2, int n3, int[] nArray) {
        WidgetsList widgetsList;
        if (n == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(this, n2, this.mLeft, this.mTop, this.mRight, this.mBottom, n3);
            this.mChainList.add(widgetsList);
        } else {
            widgetsList = this.mChainList.get(0);
            widgetsList.clear();
            ConstraintAnchor constraintAnchor = this.mLeft;
            ConstraintAnchor constraintAnchor2 = this.mTop;
            ConstraintAnchor constraintAnchor3 = this.mRight;
            ConstraintAnchor constraintAnchor4 = this.mBottom;
            int n4 = this.getPaddingLeft();
            int n5 = this.getPaddingTop();
            int n6 = this.getPaddingRight();
            int n7 = this.getPaddingBottom();
            widgetsList.setup(n2, constraintAnchor, constraintAnchor2, constraintAnchor3, constraintAnchor4, n4, n5, n6, n7, n3);
        }
        n2 = 0;
        while (true) {
            if (n2 >= n) {
                nArray[0] = widgetsList.getWidth();
                nArray[1] = widgetsList.getHeight();
                return;
            }
            widgetsList.add(constraintWidgetArray[n2]);
            ++n2;
        }
    }

    public void addToSolver(LinearSystem linearSystem, boolean bl) {
        block4: {
            int n;
            int n2;
            block5: {
                block2: {
                    block3: {
                        super.addToSolver(linearSystem, bl);
                        bl = this.getParent() != null ? ((ConstraintWidgetContainer)this.getParent()).isRtl() : false;
                        n2 = this.mWrapMode;
                        if (n2 == 0) break block2;
                        if (n2 == 1) break block3;
                        if (n2 == 2) {
                            this.createAlignedConstraints(bl);
                        }
                        break block4;
                    }
                    n = this.mChainList.size();
                    break block5;
                }
                if (this.mChainList.size() <= 0) break block4;
                this.mChainList.get(0).createConstraints(bl, 0, true);
                break block4;
            }
            for (n2 = 0; n2 < n; ++n2) {
                linearSystem = this.mChainList.get(n2);
                boolean bl2 = n2 == n - 1;
                linearSystem.createConstraints(bl, n2, bl2);
            }
        }
        this.needsCallbackFromSolver(false);
    }

    public void copy(ConstraintWidget object, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(object, hashMap);
        object = (Flow)((Object)object);
        this.mHorizontalStyle = object.mHorizontalStyle;
        this.mVerticalStyle = object.mVerticalStyle;
        this.mFirstHorizontalStyle = object.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = object.mFirstVerticalStyle;
        this.mLastHorizontalStyle = object.mLastHorizontalStyle;
        this.mLastVerticalStyle = object.mLastVerticalStyle;
        this.mHorizontalBias = object.mHorizontalBias;
        this.mVerticalBias = object.mVerticalBias;
        this.mFirstHorizontalBias = object.mFirstHorizontalBias;
        this.mFirstVerticalBias = object.mFirstVerticalBias;
        this.mLastHorizontalBias = object.mLastHorizontalBias;
        this.mLastVerticalBias = object.mLastVerticalBias;
        this.mHorizontalGap = object.mHorizontalGap;
        this.mVerticalGap = object.mVerticalGap;
        this.mHorizontalAlign = object.mHorizontalAlign;
        this.mVerticalAlign = object.mVerticalAlign;
        this.mWrapMode = object.mWrapMode;
        this.mMaxElementsWrap = object.mMaxElementsWrap;
        this.mOrientation = object.mOrientation;
    }

    public void measure(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        if (this.mWidgetsCount > 0 && !this.measureChildren()) {
            this.setMeasure(0, 0);
            this.needsCallbackFromSolver(false);
            return;
        }
        int n7 = this.getPaddingLeft();
        int n8 = this.getPaddingRight();
        int n9 = this.getPaddingTop();
        int n10 = this.getPaddingBottom();
        int[] nArray = new int[2];
        int n11 = n2 - n7 - n8;
        if (this.mOrientation == 1) {
            n11 = n4 - n9 - n10;
        }
        if (this.mOrientation == 0) {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (this.mHorizontalStyle == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArray = this.mWidgets;
        int n12 = 0;
        for (n6 = 0; n6 < this.mWidgetsCount; ++n6) {
            n5 = n12;
            if (this.mWidgets[n6].getVisibility() == 8) {
                n5 = n12 + 1;
            }
            n12 = n5;
        }
        n5 = this.mWidgetsCount;
        if (n12 > 0) {
            constraintWidgetArray = new ConstraintWidget[this.mWidgetsCount - n12];
            n12 = 0;
            for (n5 = 0; n5 < this.mWidgetsCount; ++n5) {
                ConstraintWidget constraintWidget = this.mWidgets[n5];
                n6 = n12;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArray[n12] = constraintWidget;
                    n6 = n12 + 1;
                }
                n12 = n6;
            }
            n5 = n12;
        }
        this.mDisplayedWidgets = constraintWidgetArray;
        this.mDisplayedWidgetsCount = n5;
        n12 = this.mWrapMode;
        if (n12 != 0) {
            if (n12 != 1) {
                if (n12 == 2) {
                    this.measureAligned(constraintWidgetArray, n5, this.mOrientation, n11, nArray);
                }
            } else {
                this.measureChainWrap(constraintWidgetArray, n5, this.mOrientation, n11, nArray);
            }
        } else {
            this.measureNoWrap(constraintWidgetArray, n5, this.mOrientation, n11, nArray);
        }
        boolean bl = true;
        n11 = nArray[0] + n7 + n8;
        n12 = nArray[1] + n9 + n10;
        n = n == 0x40000000 ? n2 : (n == Integer.MIN_VALUE ? Math.min(n11, n2) : (n == 0 ? n11 : 0));
        n2 = n3 == 0x40000000 ? n4 : (n3 == Integer.MIN_VALUE ? Math.min(n12, n4) : (n3 == 0 ? n12 : 0));
        this.setMeasure(n, n2);
        this.setWidth(n);
        this.setHeight(n2);
        if (this.mWidgetsCount <= 0) {
            bl = false;
        }
        this.needsCallbackFromSolver(bl);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int n) {
        this.mFirstHorizontalStyle = n;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int n) {
        this.mFirstVerticalStyle = n;
    }

    public void setHorizontalAlign(int n) {
        this.mHorizontalAlign = n;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int n) {
        this.mHorizontalGap = n;
    }

    public void setHorizontalStyle(int n) {
        this.mHorizontalStyle = n;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int n) {
        this.mLastHorizontalStyle = n;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int n) {
        this.mLastVerticalStyle = n;
    }

    public void setMaxElementsWrap(int n) {
        this.mMaxElementsWrap = n;
    }

    public void setOrientation(int n) {
        this.mOrientation = n;
    }

    public void setVerticalAlign(int n) {
        this.mVerticalAlign = n;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int n) {
        this.mVerticalGap = n;
    }

    public void setVerticalStyle(int n) {
        this.mVerticalStyle = n;
    }

    public void setWrapMode(int n) {
        this.mWrapMode = n;
    }
}
