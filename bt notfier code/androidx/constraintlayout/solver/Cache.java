/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.Pools$Pool
 *  androidx.constraintlayout.solver.Pools$SimplePool
 *  androidx.constraintlayout.solver.SolverVariable
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Pools;
import androidx.constraintlayout.solver.SolverVariable;

public class Cache {
    Pools.Pool<ArrayRow> arrayRowPool;
    SolverVariable[] mIndexedVariables;
    Pools.Pool<ArrayRow> optimizedArrayRowPool = new Pools.SimplePool(256);
    Pools.Pool<SolverVariable> solverVariablePool;

    public Cache() {
        this.arrayRowPool = new Pools.SimplePool(256);
        this.solverVariablePool = new Pools.SimplePool(256);
        this.mIndexedVariables = new SolverVariable[32];
    }
}
