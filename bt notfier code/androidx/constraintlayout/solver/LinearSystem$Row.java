/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.SolverVariable
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;

static interface LinearSystem.Row {
    public void addError(SolverVariable var1);

    public void clear();

    public SolverVariable getKey();

    public SolverVariable getPivotCandidate(LinearSystem var1, boolean[] var2);

    public void initFromRow(LinearSystem.Row var1);

    public boolean isEmpty();

    public void updateFromFinalVariable(LinearSystem var1, SolverVariable var2, boolean var3);

    public void updateFromRow(LinearSystem var1, ArrayRow var2, boolean var3);

    public void updateFromSystem(LinearSystem var1);
}
