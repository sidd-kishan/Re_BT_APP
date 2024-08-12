/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.solver.widgets.Flow
 *  androidx.constraintlayout.solver.widgets.Guideline
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measurer
 *  androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.constraintlayout.solver.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;

public class Grouping {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_GROUPING = false;

    public static WidgetGroup findDependents(ConstraintWidget constraintWidget, int n, ArrayList<WidgetGroup> arrayList, WidgetGroup widgetGroup) {
        int n2;
        WidgetGroup widgetGroup2;
        int n3 = n == 0 ? constraintWidget.horizontalGroup : constraintWidget.verticalGroup;
        int n4 = 0;
        if (n3 == -1 || widgetGroup != null && n3 == widgetGroup.id) {
            widgetGroup2 = widgetGroup;
            if (n3 != -1) {
                return widgetGroup;
            }
        } else {
            n2 = 0;
            while (true) {
                widgetGroup2 = widgetGroup;
                if (n2 >= arrayList.size()) break;
                widgetGroup2 = arrayList.get(n2);
                if (widgetGroup2.getId() == n3) {
                    if (widgetGroup == null) break;
                    widgetGroup.moveTo(n, widgetGroup2);
                    arrayList.remove(widgetGroup);
                    break;
                }
                ++n2;
            }
        }
        widgetGroup = widgetGroup2;
        if (widgetGroup2 == null) {
            widgetGroup = widgetGroup2;
            if (constraintWidget instanceof HelperWidget) {
                n2 = ((HelperWidget)constraintWidget).findGroupInDependents(n);
                widgetGroup = widgetGroup2;
                if (n2 != -1) {
                    n3 = 0;
                    while (true) {
                        widgetGroup = widgetGroup2;
                        if (n3 >= arrayList.size() || (widgetGroup = arrayList.get(n3)).getId() == n2) break;
                        ++n3;
                    }
                }
            }
            widgetGroup2 = widgetGroup;
            if (widgetGroup == null) {
                widgetGroup2 = new WidgetGroup(n);
            }
            arrayList.add(widgetGroup2);
            widgetGroup = widgetGroup2;
        }
        if (!widgetGroup.add(constraintWidget)) return widgetGroup;
        if (constraintWidget instanceof Guideline) {
            Guideline guideline = (Guideline)constraintWidget;
            widgetGroup2 = guideline.getAnchor();
            n3 = n4;
            if (guideline.getOrientation() == 0) {
                n3 = 1;
            }
            widgetGroup2.findDependents(n3, arrayList, widgetGroup);
        }
        if (n == 0) {
            constraintWidget.horizontalGroup = widgetGroup.getId();
            constraintWidget.mLeft.findDependents(n, arrayList, widgetGroup);
            constraintWidget.mRight.findDependents(n, arrayList, widgetGroup);
        } else {
            constraintWidget.verticalGroup = widgetGroup.getId();
            constraintWidget.mTop.findDependents(n, arrayList, widgetGroup);
            constraintWidget.mBaseline.findDependents(n, arrayList, widgetGroup);
            constraintWidget.mBottom.findDependents(n, arrayList, widgetGroup);
        }
        constraintWidget.mCenter.findDependents(n, arrayList, widgetGroup);
        return widgetGroup;
    }

    private static WidgetGroup findGroup(ArrayList<WidgetGroup> arrayList, int n) {
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            WidgetGroup widgetGroup = arrayList.get(n3);
            if (n == widgetGroup.id) {
                return widgetGroup;
            }
            ++n3;
        }
        return null;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static boolean simpleSolvingPass(ConstraintWidgetContainer var0, BasicMeasure.Measurer var1_1) {
        var16_2 = var0 /* !! */ .getChildren();
        var3_3 = var16_2.size();
        for (var2_4 = 0; var2_4 < var3_3; ++var2_4) {
            var5_5 = (ConstraintWidget)var16_2.get(var2_4);
            if (!Grouping.validInGroup(var0 /* !! */ .getHorizontalDimensionBehaviour(), var0 /* !! */ .getVerticalDimensionBehaviour(), var5_5.getHorizontalDimensionBehaviour(), var5_5.getVerticalDimensionBehaviour())) {
                return false;
            }
            if (!(var5_5 instanceof Flow)) continue;
            return false;
        }
        if (var0 /* !! */ .mMetrics != null) {
            var5_5 = var0 /* !! */ .mMetrics;
            ++var5_5.grouping;
        }
        var11_6 = null;
        var5_5 = null;
        var7_7 = null;
        var6_8 = null;
        var9_9 = null;
        var8_10 = null;
        for (var2_4 = 0; var2_4 < var3_3; ++var2_4) {
            var17_17 = (ConstraintWidget)var16_2.get(var2_4);
            if (!Grouping.validInGroup(var0 /* !! */ .getHorizontalDimensionBehaviour(), var0 /* !! */ .getVerticalDimensionBehaviour(), var17_17.getHorizontalDimensionBehaviour(), var17_17.getVerticalDimensionBehaviour())) {
                ConstraintWidgetContainer.measure((ConstraintWidget)var17_17, (BasicMeasure.Measurer)var1_1, (BasicMeasure.Measure)var0 /* !! */ .mMeasure, (boolean)false);
            }
            var4_11 = var17_17 instanceof Guideline;
            var13_14 /* !! */  = var11_6;
            var12_13 = var7_7;
            if (var4_11) {
                var14_15 /* !! */  = (Guideline)var17_17;
                var10_12 = var7_7;
                if (var14_15 /* !! */ .getOrientation() == 0) {
                    var10_12 = var7_7;
                    if (var7_7 == null) {
                        var10_12 = new ArrayList<E>();
                    }
                    var10_12.add(var14_15 /* !! */ );
                }
                var13_14 /* !! */  = var11_6;
                var12_13 = var10_12;
                if (var14_15 /* !! */ .getOrientation() == 1) {
                    var7_7 = var11_6;
                    if (var11_6 == null) {
                        var7_7 = new ArrayList<E>();
                    }
                    var7_7.add(var14_15 /* !! */ );
                    var12_13 = var10_12;
                    var13_14 /* !! */  = var7_7;
                }
            }
            var7_7 = var5_5;
            var10_12 = var6_8;
            if (var17_17 instanceof HelperWidget) {
                if (var17_17 instanceof Barrier) {
                    var14_15 /* !! */  = (Barrier)var17_17;
                    var11_6 = var5_5;
                    if (var14_15 /* !! */ .getOrientation() == 0) {
                        var11_6 = var5_5;
                        if (var5_5 == null) {
                            var11_6 = new ArrayList<E>();
                        }
                        var11_6.add(var14_15 /* !! */ );
                    }
                    var7_7 = var11_6;
                    var10_12 = var6_8;
                    if (var14_15 /* !! */ .getOrientation() == 1) {
                        var10_12 = var6_8;
                        if (var6_8 == null) {
                            var10_12 = new ArrayList<E>();
                        }
                        var10_12.add(var14_15 /* !! */ );
                        var7_7 = var11_6;
                    }
                } else {
                    var11_6 = (HelperWidget)var17_17;
                    var7_7 = var5_5;
                    if (var5_5 == null) {
                        var7_7 = new ArrayList<E>();
                    }
                    var7_7.add(var11_6);
                    var10_12 = var6_8;
                    if (var6_8 == null) {
                        var10_12 = new ArrayList<E>();
                    }
                    var10_12.add(var11_6);
                }
            }
            var14_15 /* !! */  = var9_9;
            if (var17_17.mLeft.mTarget == null) {
                var14_15 /* !! */  = var9_9;
                if (var17_17.mRight.mTarget == null) {
                    var14_15 /* !! */  = var9_9;
                    if (!var4_11) {
                        var14_15 /* !! */  = var9_9;
                        if (!(var17_17 instanceof Barrier)) {
                            var5_5 = var9_9;
                            if (var9_9 == null) {
                                var5_5 = new ArrayList<E>();
                            }
                            var5_5.add(var17_17);
                            var14_15 /* !! */  = var5_5;
                        }
                    }
                }
            }
            var15_16 = var8_10;
            if (var17_17.mTop.mTarget == null) {
                var15_16 = var8_10;
                if (var17_17.mBottom.mTarget == null) {
                    var15_16 = var8_10;
                    if (var17_17.mBaseline.mTarget == null) {
                        var15_16 = var8_10;
                        if (!var4_11) {
                            var15_16 = var8_10;
                            if (!(var17_17 instanceof Barrier)) {
                                var5_5 = var8_10;
                                if (var8_10 == null) {
                                    var5_5 = new ArrayList<E>();
                                }
                                var5_5.add(var17_17);
                                var15_16 = var5_5;
                            }
                        }
                    }
                }
            }
            var11_6 = var13_14 /* !! */ ;
            var5_5 = var7_7;
            var7_7 = var12_13;
            var6_8 = var10_12;
            var9_9 = var14_15 /* !! */ ;
            var8_10 = var15_16;
        }
        var10_12 = new ArrayList();
        if (var11_6 != null) {
            var1_1 = var11_6.iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents((ConstraintWidget)((Guideline)var1_1.next()), 0, var10_12, null);
            }
        }
        if (var5_5 != null) {
            var1_1 = var5_5.iterator();
            while (var1_1.hasNext()) {
                var11_6 = (HelperWidget)var1_1.next();
                var5_5 = Grouping.findDependents((ConstraintWidget)var11_6, 0, var10_12, null);
                var11_6.addDependents((ArrayList)var10_12, 0, (WidgetGroup)var5_5);
                var5_5.cleanup((ArrayList)var10_12);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.LEFT)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 0, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.RIGHT)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 0, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.CENTER)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 0, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if (var9_9 != null) {
            var1_1 = var9_9.iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents((ConstraintWidget)var1_1.next(), 0, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if (var7_7 != null) {
            var1_1 = var7_7.iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents((ConstraintWidget)((Guideline)var1_1.next()), 1, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if (var6_8 != null) {
            var1_1 = var6_8.iterator();
            while (var1_1.hasNext()) {
                var5_5 = (HelperWidget)var1_1.next();
                var6_8 = Grouping.findDependents((ConstraintWidget)var5_5, 1, (ArrayList<WidgetGroup>)var10_12, null);
                var5_5.addDependents((ArrayList)var10_12, 1, (WidgetGroup)var6_8);
                var6_8.cleanup((ArrayList)var10_12);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.TOP)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 1, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.BASELINE)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 1, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.BOTTOM)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 1, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if ((var1_1 = var0 /* !! */ .getAnchor(ConstraintAnchor.Type.CENTER)).getDependents() != null) {
            var1_1 = var1_1.getDependents().iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents(((ConstraintAnchor)var1_1.next()).mOwner, 1, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        if (var8_10 != null) {
            var1_1 = var8_10.iterator();
            while (var1_1.hasNext()) {
                Grouping.findDependents((ConstraintWidget)var1_1.next(), 1, (ArrayList<WidgetGroup>)var10_12, null);
            }
        }
        for (var2_4 = 0; var2_4 < var3_3; ++var2_4) {
            var5_5 = (ConstraintWidget)var16_2.get(var2_4);
            if (!var5_5.oppositeDimensionsTied()) continue;
            var1_1 = Grouping.findGroup((ArrayList<WidgetGroup>)var10_12, var5_5.horizontalGroup);
            var5_5 = Grouping.findGroup((ArrayList<WidgetGroup>)var10_12, var5_5.verticalGroup);
            if (var1_1 == null || var5_5 == null) continue;
            var1_1.moveTo(0, (WidgetGroup)var5_5);
            var5_5.setOrientation(2);
            var10_12.remove(var1_1);
        }
        if (var10_12.size() <= 1) {
            return false;
        }
        if (var0 /* !! */ .getHorizontalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) ** GOTO lbl-1000
        var6_8 = var10_12.iterator();
        var1_1 = null;
        var2_4 = 0;
        while (var6_8.hasNext()) {
            var5_5 = (WidgetGroup)var6_8.next();
            if (var5_5.getOrientation() == 1) continue;
            var5_5.setAuthoritative(false);
            var3_3 = var5_5.measureWrap(var0 /* !! */ .getSystem(), 0);
            if (var3_3 <= var2_4) continue;
            var1_1 = var5_5;
            var2_4 = var3_3;
        }
        if (var1_1 != null) {
            var0 /* !! */ .setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            var0 /* !! */ .setWidth(var2_4);
            var1_1.setAuthoritative(true);
            var5_5 = var1_1;
        } else lbl-1000:
        // 2 sources

        {
            var5_5 = null;
        }
        if (var0 /* !! */ .getVerticalDimensionBehaviour() != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT) ** GOTO lbl-1000
        var7_7 = var10_12.iterator();
        var1_1 = null;
        var2_4 = 0;
        while (var7_7.hasNext()) {
            var6_8 = (WidgetGroup)var7_7.next();
            if (var6_8.getOrientation() == 0) continue;
            var6_8.setAuthoritative(false);
            var3_3 = var6_8.measureWrap(var0 /* !! */ .getSystem(), 1);
            if (var3_3 <= var2_4) continue;
            var1_1 = var6_8;
            var2_4 = var3_3;
        }
        if (var1_1 != null) {
            var0 /* !! */ .setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.FIXED);
            var0 /* !! */ .setHeight(var2_4);
            var1_1.setAuthoritative(true);
            var0 /* !! */  = var1_1;
        } else lbl-1000:
        // 2 sources

        {
            var0 /* !! */  = null;
        }
        var4_11 = var5_5 != null || var0 /* !! */  != null;
        return var4_11;
    }

    public static boolean validInGroup(ConstraintWidget.DimensionBehaviour dimensionBehaviour, ConstraintWidget.DimensionBehaviour dimensionBehaviour2, ConstraintWidget.DimensionBehaviour dimensionBehaviour3, ConstraintWidget.DimensionBehaviour dimensionBehaviour4) {
        boolean bl = dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour3 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean bl2 = dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.FIXED || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour4 == ConstraintWidget.DimensionBehaviour.MATCH_PARENT && dimensionBehaviour2 != ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        if (bl) return true;
        if (!bl2) return false;
        return true;
    }
}
