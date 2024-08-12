/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.widgets.ConstraintWidget;

public interface Reference {
    public void apply();

    public ConstraintWidget getConstraintWidget();

    public Object getKey();

    public void setConstraintWidget(ConstraintWidget var1);

    public void setKey(Object var1);
}
