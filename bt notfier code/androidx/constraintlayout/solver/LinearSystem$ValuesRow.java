/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.SolverVariableValues
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariableValues;

class LinearSystem.ValuesRow
extends ArrayRow {
    final LinearSystem this$0;

    public LinearSystem.ValuesRow(LinearSystem linearSystem, Cache cache) {
        this.this$0 = linearSystem;
        this.variables = new SolverVariableValues((ArrayRow)this, cache);
    }
}
