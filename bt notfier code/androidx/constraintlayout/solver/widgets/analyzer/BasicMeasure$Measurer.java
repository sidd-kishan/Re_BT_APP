/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure$Measure
 */
package androidx.constraintlayout.solver.widgets.analyzer;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;

public static interface BasicMeasure.Measurer {
    public void didMeasures();

    public void measure(ConstraintWidget var1, BasicMeasure.Measure var2);
}
