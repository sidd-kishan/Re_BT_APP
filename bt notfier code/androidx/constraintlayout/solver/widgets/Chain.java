/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.widgets.ChainHead
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 */
package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ChainHead;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;

public class Chain {
    private static final boolean DEBUG = false;
    public static final boolean USE_CHAIN_OPTIMIZATION = false;

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    static void applyChainConstraints(ConstraintWidgetContainer var0, LinearSystem var1_1, int var2_2, int var3_3, ChainHead var4_4) {
        block65: {
            block68: {
                block67: {
                    block66: {
                        block64: {
                            block63: {
                                var26_5 = var4_4 /* !! */ .mFirst;
                                var23_6 = var4_4 /* !! */ .mLast;
                                var20_7 = var4_4 /* !! */ .mFirstVisibleWidget;
                                var24_8 = var4_4 /* !! */ .mLastVisibleWidget;
                                var18_9 /* !! */  = var4_4 /* !! */ .mHead;
                                var5_10 = var4_4 /* !! */ .mTotalWeight;
                                var17_11 = var4_4 /* !! */ .mFirstMatchConstraintWidget;
                                var17_11 = var4_4 /* !! */ .mLastMatchConstraintWidget;
                                var12_12 = var0.mListDimensionBehaviors[var2_2] == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT ? 1 : 0;
                                if (var2_2 != 0) break block63;
                                var8_13 = var18_9 /* !! */ .mHorizontalChainStyle == 0 ? 1 : 0;
                                var9_14 = var18_9 /* !! */ .mHorizontalChainStyle == 1 ? 1 : 0;
                                var10_15 = var8_13;
                                var11_16 = var9_14;
                                if (var18_9 /* !! */ .mHorizontalChainStyle != 2) ** GOTO lbl-1000
                                ** GOTO lbl-1000
                            }
                            var8_13 = var18_9 /* !! */ .mVerticalChainStyle == 0 ? 1 : 0;
                            var9_14 = var18_9 /* !! */ .mVerticalChainStyle == 1 ? 1 : 0;
                            var10_15 = var8_13;
                            var11_16 = var9_14;
                            if (var18_9 /* !! */ .mVerticalChainStyle == 2) lbl-1000:
                            // 2 sources

                            {
                                var13_17 = 1;
                                var10_15 = var8_13;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var13_17 = 0;
                                var9_14 = var11_16;
                            }
                            var19_18 /* !! */  = var26_5;
                            var8_13 = 0;
                            var11_16 = var9_14;
                            while (true) {
                                var25_24 = null;
                                var21_22 = null;
                                if (var8_13 != 0) break;
                                var17_11 = var19_18 /* !! */ .mListAnchors[var3_3];
                                var9_14 = var13_17 != 0 ? 1 : 4;
                                var16_21 = var17_11.getMargin();
                                var15_20 = var19_18 /* !! */ .mListDimensionBehaviors[var2_2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var19_18 /* !! */ .mResolvedMatchConstraintDefault[var2_2] == 0;
                                var14_19 = var16_21;
                                if (var17_11.mTarget != null) {
                                    var14_19 = var16_21;
                                    if (var19_18 /* !! */  != var26_5) {
                                        var14_19 = var16_21 + var17_11.mTarget.getMargin();
                                    }
                                }
                                if (var13_17 != 0 && var19_18 /* !! */  != var26_5 && var19_18 /* !! */  != var20_7) {
                                    var9_14 = 8;
                                }
                                if (var17_11.mTarget != null) {
                                    if (var19_18 /* !! */  == var20_7) {
                                        var1_1.addGreaterThan(var17_11.mSolverVariable, var17_11.mTarget.mSolverVariable, var14_19, 6);
                                    } else {
                                        var1_1.addGreaterThan(var17_11.mSolverVariable, var17_11.mTarget.mSolverVariable, var14_19, 8);
                                    }
                                    if (var15_20 && var13_17 == 0) {
                                        var9_14 = 5;
                                    }
                                    var1_1.addEquality(var17_11.mSolverVariable, var17_11.mTarget.mSolverVariable, var14_19, var9_14);
                                }
                                if (var12_12 != 0) {
                                    if (var19_18 /* !! */ .getVisibility() != 8 && var19_18 /* !! */ .mListDimensionBehaviors[var2_2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                                        var1_1.addGreaterThan(var19_18 /* !! */ .mListAnchors[var3_3 + 1].mSolverVariable, var19_18 /* !! */ .mListAnchors[var3_3].mSolverVariable, 0, 5);
                                    }
                                    var1_1.addGreaterThan(var19_18 /* !! */ .mListAnchors[var3_3].mSolverVariable, var0.mListAnchors[var3_3].mSolverVariable, 0, 8);
                                }
                                var22_23 = var19_18 /* !! */ .mListAnchors[var3_3 + 1].mTarget;
                                var17_11 = var21_22;
                                if (var22_23 != null) {
                                    var22_23 = var22_23.mOwner;
                                    var17_11 = var21_22;
                                    if (var22_23.mListAnchors[var3_3].mTarget != null) {
                                        var17_11 = var22_23.mListAnchors[var3_3].mTarget.mOwner != var19_18 /* !! */  ? var21_22 : var22_23;
                                    }
                                }
                                if (var17_11 != null) {
                                    var19_18 /* !! */  = var17_11;
                                    continue;
                                }
                                var8_13 = 1;
                            }
                            if (var24_8 != null) {
                                var17_11 = var23_6.mListAnchors;
                                var9_14 = var3_3 + 1;
                                if (var17_11[var9_14].mTarget != null) {
                                    var17_11 = var24_8.mListAnchors[var9_14];
                                    var8_13 = var24_8.mListDimensionBehaviors[var2_2] == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && var24_8.mResolvedMatchConstraintDefault[var2_2] == 0 ? 1 : 0;
                                    if (var8_13 != 0 && var13_17 == 0 && var17_11.mTarget.mOwner == var0) {
                                        var1_1.addEquality(var17_11.mSolverVariable, var17_11.mTarget.mSolverVariable, -var17_11.getMargin(), 5);
                                    } else if (var13_17 != 0 && var17_11.mTarget.mOwner == var0) {
                                        var1_1.addEquality(var17_11.mSolverVariable, var17_11.mTarget.mSolverVariable, -var17_11.getMargin(), 4);
                                    }
                                    var1_1.addLowerThan(var17_11.mSolverVariable, var23_6.mListAnchors[var9_14].mTarget.mSolverVariable, -var17_11.getMargin(), 6);
                                }
                            }
                            if (var12_12 != 0) {
                                var0 = var0.mListAnchors;
                                var8_13 = var3_3 + 1;
                                var1_1.addGreaterThan(var0[var8_13].mSolverVariable, var23_6.mListAnchors[var8_13].mSolverVariable, var23_6.mListAnchors[var8_13].getMargin(), 8);
                            }
                            if ((var0 = var4_4 /* !! */ .mWeightedMatchConstraintsWidgets) != null && (var8_13 = var0.size()) > 1) {
                                var6_25 = var4_4 /* !! */ .mHasUndefinedWeights != false && var4_4 /* !! */ .mHasComplexMatchWeights == false ? (float)var4_4 /* !! */ .mWidgetsMatchCount : var5_10;
                                var17_11 = null;
                                var7_26 = 0.0f;
                                for (var9_14 = 0; var9_14 < var8_13; ++var9_14) {
                                    var19_18 /* !! */  = (ConstraintWidget)var0.get(var9_14);
                                    var5_10 = var19_18 /* !! */ .mWeight[var2_2];
                                    if (var5_10 < 0.0f) {
                                        if (var4_4 /* !! */ .mHasComplexMatchWeights) {
                                            var1_1.addEquality(var19_18 /* !! */ .mListAnchors[var3_3 + 1].mSolverVariable, var19_18 /* !! */ .mListAnchors[var3_3].mSolverVariable, 0, 4);
                                            continue;
                                        }
                                        var5_10 = 1.0f;
                                    }
                                    if (var5_10 == 0.0f) {
                                        var1_1.addEquality(var19_18 /* !! */ .mListAnchors[var3_3 + 1].mSolverVariable, var19_18 /* !! */ .mListAnchors[var3_3].mSolverVariable, 0, 8);
                                        continue;
                                    }
                                    if (var17_11 != null) {
                                        var21_22 = var17_11.mListAnchors[var3_3].mSolverVariable;
                                        var17_11 = var17_11.mListAnchors;
                                        var12_12 = var3_3 + 1;
                                        var27_27 = var17_11[var12_12].mSolverVariable;
                                        var22_23 = var19_18 /* !! */ .mListAnchors[var3_3].mSolverVariable;
                                        var28_28 = var19_18 /* !! */ .mListAnchors[var12_12].mSolverVariable;
                                        var17_11 = var1_1.createRow();
                                        var17_11.createRowEqualMatchDimensions(var7_26, var6_25, var5_10, (SolverVariable)var21_22, var27_27, (SolverVariable)var22_23, var28_28);
                                        var1_1.addConstraint((ArrayRow)var17_11);
                                    }
                                    var17_11 = var19_18 /* !! */ ;
                                    var7_26 = var5_10;
                                }
                            }
                            if (var20_7 == null || var20_7 != var24_8 && var13_17 == 0) break block64;
                            var0 = var26_5.mListAnchors[var3_3];
                            var4_4 /* !! */  = var23_6.mListAnchors;
                            var8_13 = var3_3 + 1;
                            var4_4 /* !! */  = var4_4 /* !! */ [var8_13];
                            var0 = var0.mTarget != null ? var0.mTarget.mSolverVariable : null;
                            var4_4 /* !! */  = var4_4 /* !! */ .mTarget != null ? var4_4 /* !! */ .mTarget.mSolverVariable : null;
                            var19_18 /* !! */  = var20_7.mListAnchors[var3_3];
                            var17_11 = var24_8.mListAnchors[var8_13];
                            if (var0 != null && var4_4 /* !! */  != null) {
                                var5_10 = var2_2 == 0 ? var18_9 /* !! */ .mHorizontalBiasPercent : var18_9 /* !! */ .mVerticalBiasPercent;
                                var8_13 = var19_18 /* !! */ .getMargin();
                                var2_2 = var17_11.getMargin();
                                var1_1.addCentering(var19_18 /* !! */ .mSolverVariable, (SolverVariable)var0, var8_13, var5_10, (SolverVariable)var4_4 /* !! */ , var17_11.mSolverVariable, var2_2, 7);
                            }
                            break block65;
                        }
                        if (var10_15 == 0 || var20_7 == null) break block66;
                        var12_12 = var4_4 /* !! */ .mWidgetsMatchCount > 0 && var4_4 /* !! */ .mWidgetsCount == var4_4 /* !! */ .mWidgetsMatchCount ? 1 : 0;
                        var4_4 /* !! */  = var20_7;
                        var19_18 /* !! */  = var4_4 /* !! */ ;
                        break block67;
                    }
                    if (var11_16 == 0 || var20_7 == null) break block65;
                    var8_13 = var4_4 /* !! */ .mWidgetsMatchCount > 0 && var4_4 /* !! */ .mWidgetsCount == var4_4 /* !! */ .mWidgetsMatchCount ? 1 : 0;
                    var17_11 = var20_7;
                    var4_4 /* !! */  = var17_11;
                    break block68;
                }
                while (var4_4 /* !! */  != null) {
                    var17_11 = var4_4 /* !! */ .mNextChainWidget[var2_2];
                    while (var17_11 != null && var17_11.getVisibility() == 8) {
                        var17_11 = var17_11.mNextChainWidget[var2_2];
                    }
                    if (var17_11 != null || var4_4 /* !! */  == var24_8) {
                        var21_22 = var4_4 /* !! */ .mListAnchors[var3_3];
                        var27_27 = var21_22.mSolverVariable;
                        var18_9 /* !! */  = var21_22.mTarget != null ? var21_22.mTarget.mSolverVariable : null;
                        if (var19_18 /* !! */  != var4_4 /* !! */ ) {
                            var0 = var19_18 /* !! */ .mListAnchors[var3_3 + 1].mSolverVariable;
                        } else {
                            var0 = var18_9 /* !! */ ;
                            if (var4_4 /* !! */  == var20_7) {
                                var0 = var18_9 /* !! */ ;
                                if (var19_18 /* !! */  == var4_4 /* !! */ ) {
                                    var0 = var26_5.mListAnchors[var3_3].mTarget != null ? var26_5.mListAnchors[var3_3].mTarget.mSolverVariable : null;
                                }
                            }
                        }
                        var13_17 = var21_22.getMargin();
                        var18_9 /* !! */  = var4_4 /* !! */ .mListAnchors;
                        var14_19 = var3_3 + 1;
                        var9_14 = var18_9 /* !! */ [var14_19].getMargin();
                        if (var17_11 != null) {
                            var21_22 = var17_11.mListAnchors[var3_3];
                            var18_9 /* !! */  = var21_22.mSolverVariable;
                            var22_23 = var4_4 /* !! */ .mListAnchors[var14_19].mSolverVariable;
                        } else {
                            var21_22 = var23_6.mListAnchors[var14_19].mTarget;
                            var18_9 /* !! */  = var21_22 != null ? var21_22.mSolverVariable : null;
                            var22_23 = var4_4 /* !! */ .mListAnchors[var14_19].mSolverVariable;
                        }
                        var8_13 = var9_14;
                        if (var21_22 != null) {
                            var8_13 = var9_14 + var21_22.getMargin();
                        }
                        var9_14 = var13_17;
                        if (var19_18 /* !! */  != null) {
                            var9_14 = var13_17 + var19_18 /* !! */ .mListAnchors[var14_19].getMargin();
                        }
                        if (var27_27 != null && var0 != null && var18_9 /* !! */  != null && var22_23 != null) {
                            if (var4_4 /* !! */  == var20_7) {
                                var9_14 = var20_7.mListAnchors[var3_3].getMargin();
                            }
                            if (var4_4 /* !! */  == var24_8) {
                                var8_13 = var24_8.mListAnchors[var14_19].getMargin();
                            }
                            var13_17 = var12_12 != 0 ? 8 : 5;
                            var1_1.addCentering(var27_27, (SolverVariable)var0, var9_14, 0.5f, (SolverVariable)var18_9 /* !! */ , (SolverVariable)var22_23, var8_13, var13_17);
                        }
                    }
                    if (var4_4 /* !! */ .getVisibility() != 8) {
                        var19_18 /* !! */  = var4_4 /* !! */ ;
                    }
                    var4_4 /* !! */  = var17_11;
                }
                break block65;
            }
            while (var17_11 != null) {
                var0 = var17_11.mNextChainWidget[var2_2];
                while (var0 != null && var0.getVisibility() == 8) {
                    var0 = var0.mNextChainWidget[var2_2];
                }
                if (var17_11 != var20_7 && var17_11 != var24_8 && var0 != null) {
                    if (var0 == var24_8) {
                        var0 = null;
                    }
                    var18_9 /* !! */  = var17_11.mListAnchors[var3_3];
                    var22_23 = var18_9 /* !! */ .mSolverVariable;
                    if (var18_9 /* !! */ .mTarget != null) {
                        var19_18 /* !! */  = var18_9 /* !! */ .mTarget.mSolverVariable;
                    }
                    var19_18 /* !! */  = var4_4 /* !! */ .mListAnchors;
                    var14_19 = var3_3 + 1;
                    var27_27 = var19_18 /* !! */ [var14_19].mSolverVariable;
                    var13_17 = var18_9 /* !! */ .getMargin();
                    var12_12 = var17_11.mListAnchors[var14_19].getMargin();
                    if (var0 != null) {
                        var21_22 = var0.mListAnchors[var3_3];
                        var19_18 /* !! */  = var21_22.mSolverVariable;
                        var18_9 /* !! */  = var21_22.mTarget != null ? var21_22.mTarget.mSolverVariable : null;
                    } else {
                        var21_22 = var24_8.mListAnchors[var3_3];
                        var19_18 /* !! */  = var21_22 != null ? var21_22.mSolverVariable : null;
                        var18_9 /* !! */  = var17_11.mListAnchors[var14_19].mSolverVariable;
                    }
                    var9_14 = var12_12;
                    if (var21_22 != null) {
                        var9_14 = var12_12 + var21_22.getMargin();
                    }
                    var12_12 = var13_17;
                    if (var4_4 /* !! */  != null) {
                        var12_12 = var13_17 + var4_4 /* !! */ .mListAnchors[var14_19].getMargin();
                    }
                    var13_17 = var8_13 != 0 ? 8 : 4;
                    if (var22_23 != null && var27_27 != null && var19_18 /* !! */  != null && var18_9 /* !! */  != null) {
                        var1_1.addCentering((SolverVariable)var22_23, var27_27, var12_12, 0.5f, var19_18 /* !! */ , (SolverVariable)var18_9 /* !! */ , var9_14, var13_17);
                    }
                }
                if (var17_11.getVisibility() == 8) {
                    var17_11 = var4_4 /* !! */ ;
                }
                var4_4 /* !! */  = var17_11;
                var17_11 = var0;
            }
            var0 = var20_7.mListAnchors[var3_3];
            var4_4 /* !! */  = var26_5.mListAnchors[var3_3].mTarget;
            var17_11 = var24_8.mListAnchors;
            var2_2 = var3_3 + 1;
            var17_11 = var17_11[var2_2];
            var18_9 /* !! */  = var23_6.mListAnchors[var2_2].mTarget;
            if (var4_4 /* !! */  != null) {
                if (var20_7 != var24_8) {
                    var1_1.addEquality(var0.mSolverVariable, var4_4 /* !! */ .mSolverVariable, var0.getMargin(), 5);
                } else if (var18_9 /* !! */  != null) {
                    var1_1.addCentering(var0.mSolverVariable, var4_4 /* !! */ .mSolverVariable, var0.getMargin(), 0.5f, var17_11.mSolverVariable, var18_9 /* !! */ .mSolverVariable, var17_11.getMargin(), 5);
                }
            }
            if (var18_9 /* !! */  != null && var20_7 != var24_8) {
                var1_1.addEquality(var17_11.mSolverVariable, var18_9 /* !! */ .mSolverVariable, -var17_11.getMargin(), 5);
            }
        }
        if (var10_15 == 0) {
            if (var11_16 == 0) return;
        }
        if (var20_7 == null) return;
        if (var20_7 == var24_8) return;
        var17_11 = var20_7.mListAnchors[var3_3];
        var0 = var24_8.mListAnchors;
        var2_2 = var3_3 + 1;
        var18_9 /* !! */  = var0[var2_2];
        var4_4 /* !! */  = var17_11.mTarget != null ? var17_11.mTarget.mSolverVariable : null;
        var0 = var18_9 /* !! */ .mTarget != null ? var18_9 /* !! */ .mTarget.mSolverVariable : null;
        if (var23_6 != var24_8) {
            var19_18 /* !! */  = var23_6.mListAnchors[var2_2];
            var0 = var25_24;
            if (var19_18 /* !! */ .mTarget != null) {
                var0 = var19_18 /* !! */ .mTarget.mSolverVariable;
            }
        }
        if (var20_7 == var24_8) {
            var17_11 = var20_7.mListAnchors[var3_3];
            var18_9 /* !! */  = var20_7.mListAnchors[var2_2];
        }
        if (var4_4 /* !! */  == null) return;
        if (var0 == null) return;
        var3_3 = var17_11.getMargin();
        var19_18 /* !! */  = var24_8 == null ? var23_6 : var24_8;
        var2_2 = var19_18 /* !! */ .mListAnchors[var2_2].getMargin();
        var1_1.addCentering(var17_11.mSolverVariable, (SolverVariable)var4_4 /* !! */ , var3_3, 0.5f, (SolverVariable)var0, var18_9 /* !! */ .mSolverVariable, var2_2, 5);
    }

    public static void applyChainConstraints(ConstraintWidgetContainer constraintWidgetContainer, LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int n) {
        int n2;
        ChainHead[] chainHeadArray;
        int n3;
        int n4 = 0;
        if (n == 0) {
            n3 = constraintWidgetContainer.mHorizontalChainsSize;
            chainHeadArray = constraintWidgetContainer.mHorizontalChainsArray;
            n2 = 0;
        } else {
            n3 = constraintWidgetContainer.mVerticalChainsSize;
            chainHeadArray = constraintWidgetContainer.mVerticalChainsArray;
            n2 = 2;
        }
        while (n4 < n3) {
            ChainHead chainHead = chainHeadArray[n4];
            chainHead.define();
            if (arrayList == null || arrayList != null && arrayList.contains(chainHead.mFirst)) {
                Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, n, n2, chainHead);
            }
            ++n4;
        }
    }
}
