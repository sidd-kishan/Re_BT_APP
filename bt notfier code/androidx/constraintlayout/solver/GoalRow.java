/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.SolverVariable
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;

public class GoalRow
extends ArrayRow {
    public GoalRow(Cache cache) {
        super(cache);
    }

    public void addError(SolverVariable solverVariable) {
        super.addError(solverVariable);
        --solverVariable.usageInRowCount;
    }
}
