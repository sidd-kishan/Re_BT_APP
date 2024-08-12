/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor
 *  androidx.constraintlayout.solver.SolverVariable
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;

public class PriorityGoalRow
extends ArrayRow {
    private static final boolean DEBUG = false;
    static final int NOT_FOUND = -1;
    private static final float epsilon = 1.0E-4f;
    private int TABLE_SIZE = 128;
    GoalVariableAccessor accessor;
    private SolverVariable[] arrayGoals = new SolverVariable[128];
    Cache mCache;
    private int numGoals = 0;
    private SolverVariable[] sortArray = new SolverVariable[128];

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.accessor = new GoalVariableAccessor(this, this);
        this.mCache = cache;
    }

    static /* synthetic */ void access$000(PriorityGoalRow priorityGoalRow, SolverVariable solverVariable) {
        priorityGoalRow.removeGoal(solverVariable);
    }

    private final void addToGoal(SolverVariable solverVariable) {
        int n = this.numGoals;
        SolverVariable[] solverVariableArray = this.arrayGoals;
        if (n + 1 > solverVariableArray.length) {
            this.arrayGoals = solverVariableArray = Arrays.copyOf(solverVariableArray, solverVariableArray.length * 2);
            this.sortArray = Arrays.copyOf(solverVariableArray, solverVariableArray.length * 2);
        }
        solverVariableArray = this.arrayGoals;
        n = this.numGoals;
        solverVariableArray[n] = solverVariable;
        this.numGoals = ++n;
        if (n > 1 && solverVariableArray[n - 1].id > solverVariable.id) {
            int n2;
            int n3 = 0;
            for (n = 0; n < (n2 = this.numGoals); ++n) {
                this.sortArray[n] = this.arrayGoals[n];
            }
            Arrays.sort(this.sortArray, 0, n2, new /* Unavailable Anonymous Inner Class!! */);
            for (n = n3; n < this.numGoals; ++n) {
                this.arrayGoals[n] = this.sortArray[n];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow((ArrayRow)this);
    }

    private final void removeGoal(SolverVariable solverVariable) {
        int n = 0;
        while (n < this.numGoals) {
            if (this.arrayGoals[n] == solverVariable) {
                while (true) {
                    int n2;
                    if (n >= (n2 = this.numGoals) - 1) {
                        this.numGoals = n2 - 1;
                        solverVariable.inGoal = false;
                        return;
                    }
                    SolverVariable[] solverVariableArray = this.arrayGoals;
                    n2 = n + 1;
                    solverVariableArray[n] = solverVariableArray[n2];
                    n = n2;
                }
            }
            ++n;
        }
    }

    public void addError(SolverVariable solverVariable) {
        this.accessor.init(solverVariable);
        this.accessor.reset();
        solverVariable.goalStrengthVector[solverVariable.strength] = 1.0f;
        this.addToGoal(solverVariable);
    }

    public void clear() {
        this.numGoals = 0;
        this.constantValue = 0.0f;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] blArray) {
        int n = 0;
        int n2 = -1;
        while (true) {
            int n3;
            block6: {
                block8: {
                    block7: {
                        block5: {
                            if (n >= this.numGoals) {
                                if (n2 != -1) return this.arrayGoals[n2];
                                return null;
                            }
                            linearSystem = this.arrayGoals[n];
                            if (!blArray[linearSystem.id]) break block5;
                            n3 = n2;
                            break block6;
                        }
                        this.accessor.init((SolverVariable)linearSystem);
                        if (n2 != -1) break block7;
                        n3 = n2;
                        if (!this.accessor.isNegative()) break block6;
                        break block8;
                    }
                    n3 = n2;
                    if (!this.accessor.isSmallerThan(this.arrayGoals[n2])) break block6;
                }
                n3 = n;
            }
            ++n;
            n2 = n3;
        }
    }

    public boolean isEmpty() {
        boolean bl = this.numGoals == 0;
        return bl;
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("");
        charSequence.append(" goal -> (");
        charSequence.append(this.constantValue);
        charSequence.append(") : ");
        charSequence = charSequence.toString();
        int n = 0;
        while (n < this.numGoals) {
            Object object = this.arrayGoals[n];
            this.accessor.init((SolverVariable)object);
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(this.accessor);
            ((StringBuilder)object).append(" ");
            charSequence = ((StringBuilder)object).toString();
            ++n;
        }
        return charSequence;
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean bl) {
        SolverVariable solverVariable = arrayRow.variable;
        if (solverVariable == null) {
            return;
        }
        linearSystem = arrayRow.variables;
        int n = linearSystem.getCurrentSize();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.removeGoal(solverVariable);
                return;
            }
            SolverVariable solverVariable2 = linearSystem.getVariable(n2);
            float f = linearSystem.getVariableValue(n2);
            this.accessor.init(solverVariable2);
            if (this.accessor.addToGoal(solverVariable, f)) {
                this.addToGoal(solverVariable2);
            }
            this.constantValue += arrayRow.constantValue * f;
            ++n2;
        }
    }
}
