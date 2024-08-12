/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.PriorityGoalRow
 *  androidx.constraintlayout.solver.SolverVariable
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Comparator;

class PriorityGoalRow.1
implements Comparator<SolverVariable> {
    final PriorityGoalRow this$0;

    PriorityGoalRow.1(PriorityGoalRow priorityGoalRow) {
        this.this$0 = priorityGoalRow;
    }

    @Override
    public int compare(SolverVariable solverVariable, SolverVariable solverVariable2) {
        return solverVariable.id - solverVariable2.id;
    }
}
