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
import java.util.Arrays;

/*
 * Exception performing whole class analysis ignored.
 */
class PriorityGoalRow.GoalVariableAccessor
implements Comparable {
    PriorityGoalRow row;
    final PriorityGoalRow this$0;
    SolverVariable variable;

    public PriorityGoalRow.GoalVariableAccessor(PriorityGoalRow priorityGoalRow, PriorityGoalRow priorityGoalRow2) {
        this.this$0 = priorityGoalRow;
        this.row = priorityGoalRow2;
    }

    public void add(SolverVariable solverVariable) {
        int n = 0;
        while (n < 9) {
            float[] fArray = this.variable.goalStrengthVector;
            fArray[n] = fArray[n] + solverVariable.goalStrengthVector[n];
            if (Math.abs(this.variable.goalStrengthVector[n]) < 1.0E-4f) {
                this.variable.goalStrengthVector[n] = 0.0f;
            }
            ++n;
        }
    }

    public boolean addToGoal(SolverVariable solverVariable, float f) {
        boolean bl = this.variable.inGoal;
        boolean bl2 = true;
        int n = 0;
        if (bl) {
            n = 0;
            while (true) {
                if (n >= 9) {
                    if (!bl2) return false;
                    PriorityGoalRow.access$000((PriorityGoalRow)this.this$0, (SolverVariable)this.variable);
                    return false;
                }
                float[] fArray = this.variable.goalStrengthVector;
                fArray[n] = fArray[n] + solverVariable.goalStrengthVector[n] * f;
                if (Math.abs(this.variable.goalStrengthVector[n]) < 1.0E-4f) {
                    this.variable.goalStrengthVector[n] = 0.0f;
                } else {
                    bl2 = false;
                }
                ++n;
            }
        }
        while (n < 9) {
            float f2 = solverVariable.goalStrengthVector[n];
            if (f2 != 0.0f) {
                float f3;
                f2 = f3 = f2 * f;
                if (Math.abs(f3) < 1.0E-4f) {
                    f2 = 0.0f;
                }
                this.variable.goalStrengthVector[n] = f2;
            } else {
                this.variable.goalStrengthVector[n] = 0.0f;
            }
            ++n;
        }
        return true;
    }

    public int compareTo(Object object) {
        object = (SolverVariable)object;
        return this.variable.id - ((SolverVariable)object).id;
    }

    public void init(SolverVariable solverVariable) {
        this.variable = solverVariable;
    }

    public final boolean isNegative() {
        int n = 8;
        while (n >= 0) {
            float f = this.variable.goalStrengthVector[n];
            if (f > 0.0f) {
                return false;
            }
            if (f < 0.0f) {
                return true;
            }
            --n;
        }
        return false;
    }

    public final boolean isNull() {
        int n = 0;
        while (n < 9) {
            if (this.variable.goalStrengthVector[n] != 0.0f) {
                return false;
            }
            ++n;
        }
        return true;
    }

    public final boolean isSmallerThan(SolverVariable solverVariable) {
        int n = 8;
        while (n >= 0) {
            float f = this.variable.goalStrengthVector[n];
            float f2 = solverVariable.goalStrengthVector[n];
            if (f != f2) {
                if (!(f < f2)) return false;
                return true;
            }
            --n;
        }
        return false;
    }

    public void reset() {
        Arrays.fill(this.variable.goalStrengthVector, 0.0f);
    }

    public String toString() {
        CharSequence charSequence;
        SolverVariable solverVariable = this.variable;
        CharSequence charSequence2 = charSequence = "[ ";
        if (solverVariable != null) {
            int n = 0;
            while (true) {
                charSequence2 = charSequence;
                if (n >= 9) break;
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(this.variable.goalStrengthVector[n]);
                ((StringBuilder)charSequence2).append(" ");
                charSequence = ((StringBuilder)charSequence2).toString();
                ++n;
            }
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append("] ");
        ((StringBuilder)charSequence).append(this.variable);
        return ((StringBuilder)charSequence).toString();
    }
}
