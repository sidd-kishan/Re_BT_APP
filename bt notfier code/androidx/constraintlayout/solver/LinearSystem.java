/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.LinearSystem$Row
 *  androidx.constraintlayout.solver.LinearSystem$ValuesRow
 *  androidx.constraintlayout.solver.Metrics
 *  androidx.constraintlayout.solver.PriorityGoalRow
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.SolverVariable$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor
 *  androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.PriorityGoalRow;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0L;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    public static final boolean FULL_DEBUG = false;
    public static final boolean MEASURE = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0L;
    public static boolean OPTIMIZED_ENGINE = false;
    private static int POOL_SIZE = 1000;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    private int TABLE_SIZE = 32;
    public boolean graphOptimizer = false;
    public boolean hasSimpleDefinition = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    final Cache mCache;
    private Row mGoal;
    private int mMaxColumns = 32;
    private int mMaxRows = 32;
    int mNumColumns = 1;
    int mNumRows = 0;
    private SolverVariable[] mPoolVariables = new SolverVariable[POOL_SIZE];
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = new ArrayRow[32];
    private Row mTempGoal;
    private HashMap<String, SolverVariable> mVariables = null;
    int mVariablesID = 0;
    public boolean newgraphOptimizer = false;

    public LinearSystem() {
        Cache cache;
        this.releaseRows();
        this.mCache = cache = new Cache();
        this.mGoal = new PriorityGoalRow(cache);
        this.mTempGoal = OPTIMIZED_ENGINE ? new ValuesRow(this, this.mCache) : new ArrayRow(this.mCache);
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String solverVariableArray) {
        SolverVariable solverVariable = (SolverVariable)this.mCache.solverVariablePool.acquire();
        if (solverVariable == null) {
            solverVariable = new SolverVariable(type, (String)solverVariableArray);
            solverVariable.setType(type, (String)solverVariableArray);
            type = solverVariable;
        } else {
            solverVariable.reset();
            solverVariable.setType(type, (String)solverVariableArray);
            type = solverVariable;
        }
        int n = this.mPoolVariablesCount;
        int n2 = POOL_SIZE;
        if (n >= n2) {
            POOL_SIZE = n = n2 * 2;
            this.mPoolVariables = Arrays.copyOf(this.mPoolVariables, n);
        }
        solverVariableArray = this.mPoolVariables;
        n = this.mPoolVariablesCount;
        this.mPoolVariablesCount = n + 1;
        solverVariableArray[n] = type;
        return type;
    }

    private void addError(ArrayRow arrayRow) {
        arrayRow.addError(this, 0);
    }

    private final void addRow(ArrayRow arrayRowArray) {
        if (SIMPLIFY_SYNONYMS && arrayRowArray.isSimpleDefinition) {
            arrayRowArray.variable.setFinalValue(this, arrayRowArray.constantValue);
        } else {
            this.mRows[this.mNumRows] = arrayRowArray;
            arrayRowArray.variable.definitionId = this.mNumRows++;
            arrayRowArray.variable.updateReferencesWithNewDefinition(this, (ArrayRow)arrayRowArray);
        }
        if (!SIMPLIFY_SYNONYMS) return;
        if (!this.hasSimpleDefinition) return;
        int n = 0;
        while (true) {
            if (n >= this.mNumRows) {
                this.hasSimpleDefinition = false;
                return;
            }
            if (this.mRows[n] == null) {
                System.out.println("WTF");
            }
            arrayRowArray = this.mRows;
            int n2 = n;
            if (arrayRowArray[n] != null) {
                n2 = n;
                if (arrayRowArray[n].isSimpleDefinition) {
                    int n3;
                    arrayRowArray = this.mRows[n];
                    arrayRowArray.variable.setFinalValue(this, arrayRowArray.constantValue);
                    if (OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release((Object)arrayRowArray);
                    } else {
                        this.mCache.arrayRowPool.release((Object)arrayRowArray);
                    }
                    this.mRows[n] = null;
                    int n4 = n2 = n + 1;
                    while (n2 < (n3 = this.mNumRows)) {
                        arrayRowArray = this.mRows;
                        n4 = n2 - 1;
                        arrayRowArray[n4] = arrayRowArray[n2];
                        if (arrayRowArray[n4].variable.definitionId == n2) {
                            this.mRows[n4].variable.definitionId = n4;
                        }
                        n4 = n2++;
                    }
                    if (n4 < n3) {
                        this.mRows[n4] = null;
                    }
                    --this.mNumRows;
                    n2 = n - 1;
                }
            }
            n = n2 + 1;
        }
    }

    private void addSingleError(ArrayRow arrayRow, int n) {
        this.addSingleError(arrayRow, n, 0);
    }

    private void computeValues() {
        int n = 0;
        while (n < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[n];
            arrayRow.variable.computedValue = arrayRow.constantValue;
            ++n;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String string, SolverVariable.Type type) {
        int n;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.variables;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        type = this.acquireSolverVariable(type, null);
        type.setName(string);
        this.mVariablesID = n = this.mVariablesID + 1;
        ++this.mNumColumns;
        type.id = n;
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        this.mVariables.put(string, (SolverVariable)type);
        this.mCache.mIndexedVariables[this.mVariablesID] = type;
        return type;
    }

    private void displayRows() {
        this.displaySolverVariables();
        CharSequence charSequence = "";
        int n = 0;
        while (true) {
            CharSequence charSequence2;
            if (n >= this.mNumRows) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(this.mGoal);
                ((StringBuilder)charSequence2).append("\n");
                charSequence = ((StringBuilder)charSequence2).toString();
                System.out.println((String)charSequence);
                return;
            }
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append(this.mRows[n]);
            charSequence2 = ((StringBuilder)charSequence2).toString();
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("\n");
            charSequence = ((StringBuilder)charSequence).toString();
            ++n;
        }
    }

    private void displaySolverVariables() {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Display Rows (");
        charSequence.append(this.mNumRows);
        charSequence.append("x");
        charSequence.append(this.mNumColumns);
        charSequence.append(")\n");
        charSequence = charSequence.toString();
        System.out.println((String)charSequence);
    }

    private int enforceBFS(Row row) throws Exception {
        int n;
        block18: {
            for (n = 0; n < this.mNumRows; ++n) {
                if (this.mRows[n].variable.mType == SolverVariable.Type.UNRESTRICTED || !(this.mRows[n].constantValue < 0.0f)) continue;
                n = 1;
                break block18;
            }
            n = 0;
        }
        if (n == 0) {
            n = 0;
            return n;
        }
        boolean bl = false;
        n = 0;
        block1: while (!bl) {
            row = sMetrics;
            if (row != null) {
                ++row.bfs;
            }
            int n2 = n + 1;
            float f = Float.MAX_VALUE;
            n = 0;
            int n3 = -1;
            int n4 = -1;
            int n5 = 0;
            while (true) {
                int n6;
                int n7;
                int n8;
                float f2;
                block19: {
                    float f3;
                    int n9;
                    int n10;
                    ArrayRow arrayRow;
                    block24: {
                        block23: {
                            block20: {
                                block22: {
                                    block21: {
                                        if (n >= this.mNumRows) break block20;
                                        row = this.mRows[n];
                                        if (row.variable.mType != SolverVariable.Type.UNRESTRICTED) break block21;
                                        f2 = f;
                                        n8 = n3;
                                        n7 = n4;
                                        n6 = n5;
                                        break block19;
                                    }
                                    if (!row.isSimpleDefinition) break block22;
                                    f2 = f;
                                    n8 = n3;
                                    n7 = n4;
                                    n6 = n5;
                                    break block19;
                                }
                                f2 = f;
                                n8 = n3;
                                n7 = n4;
                                n6 = n5;
                                if (!(row.constantValue < 0.0f)) break block19;
                                if (SKIP_COLUMNS) break block23;
                                break block24;
                            }
                            if (n3 != -1) {
                                arrayRow = this.mRows[n3];
                                arrayRow.variable.definitionId = -1;
                                row = sMetrics;
                                if (row != null) {
                                    ++row.pivots;
                                }
                                arrayRow.pivot(this.mCache.mIndexedVariables[n4]);
                                arrayRow.variable.definitionId = n3;
                                arrayRow.variable.updateReferencesWithNewDefinition(this, arrayRow);
                            } else {
                                bl = true;
                            }
                            n = n2;
                            if (n2 <= this.mNumColumns / 2) continue block1;
                            bl = true;
                            n = n2;
                            continue block1;
                        }
                        int n11 = row.variables.getCurrentSize();
                        n10 = 0;
                        n9 = n4;
                        while (true) {
                            block26: {
                                block25: {
                                    f2 = f;
                                    n8 = n3;
                                    n7 = n9;
                                    n6 = n5;
                                    if (n10 >= n11) break block19;
                                    arrayRow = row.variables.getVariable(n10);
                                    f3 = row.variables.get((SolverVariable)arrayRow);
                                    if (!(f3 <= 0.0f)) break block25;
                                    f2 = f;
                                    n7 = n3;
                                    n8 = n9;
                                    n6 = n5;
                                    break block26;
                                }
                                n8 = 0;
                                n4 = n5;
                                n5 = n8;
                                while (true) {
                                    block28: {
                                        block27: {
                                            f2 = f;
                                            n7 = n3;
                                            n8 = n9;
                                            n6 = n4;
                                            if (n5 >= 9) break;
                                            f2 = arrayRow.strengthVector[n5] / f3;
                                            if (f2 < f && n5 == n4) break block27;
                                            n8 = n4;
                                            if (n5 <= n4) break block28;
                                        }
                                        n9 = arrayRow.id;
                                        n8 = n5;
                                        n3 = n;
                                        f = f2;
                                    }
                                    ++n5;
                                    n4 = n8;
                                }
                            }
                            ++n10;
                            f = f2;
                            n3 = n7;
                            n9 = n8;
                            n5 = n6;
                        }
                    }
                    n8 = 1;
                    n9 = n5;
                    n5 = n4;
                    n4 = n8;
                    while (true) {
                        block30: {
                            block29: {
                                f2 = f;
                                n8 = n3;
                                n7 = n5;
                                n6 = n9;
                                if (n4 >= this.mNumColumns) break;
                                arrayRow = this.mCache.mIndexedVariables[n4];
                                f3 = row.variables.get((SolverVariable)arrayRow);
                                if (!(f3 <= 0.0f)) break block29;
                                f2 = f;
                                n10 = n3;
                                n6 = n5;
                                n7 = n9;
                                break block30;
                            }
                            n7 = 0;
                            n8 = n5;
                            n5 = n7;
                            while (true) {
                                block32: {
                                    block31: {
                                        f2 = f;
                                        n10 = n3;
                                        n6 = n8;
                                        n7 = n9;
                                        if (n5 >= 9) break;
                                        f2 = arrayRow.strengthVector[n5] / f3;
                                        if (f2 < f && n5 == n9) break block31;
                                        n7 = n9;
                                        if (n5 <= n9) break block32;
                                    }
                                    n8 = n4;
                                    n7 = n5;
                                    n3 = n;
                                    f = f2;
                                }
                                ++n5;
                                n9 = n7;
                            }
                        }
                        ++n4;
                        f = f2;
                        n3 = n10;
                        n5 = n6;
                        n9 = n7;
                    }
                }
                ++n;
                f = f2;
                n3 = n8;
                n4 = n7;
                n5 = n6;
            }
            break;
        }
        return n;
    }

    private String getDisplaySize(int n) {
        int n2 = (n *= 4) / 1024;
        int n3 = n2 / 1024;
        if (n3 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(n3);
            stringBuilder.append(" Mb");
            return stringBuilder.toString();
        }
        if (n2 > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("");
            stringBuilder.append(n2);
            stringBuilder.append(" Kb");
            return stringBuilder.toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("");
        stringBuilder.append(n);
        stringBuilder.append(" bytes");
        return stringBuilder.toString();
    }

    private String getDisplayStrength(int n) {
        if (n == 1) {
            return "LOW";
        }
        if (n == 2) {
            return "MEDIUM";
        }
        if (n == 3) {
            return "HIGH";
        }
        if (n == 4) {
            return "HIGHEST";
        }
        if (n == 5) {
            return "EQUALITY";
        }
        if (n == 8) {
            return "FIXED";
        }
        if (n != 6) return "NONE";
        return "BARRIER";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int n;
        this.TABLE_SIZE = n = this.TABLE_SIZE * 2;
        this.mRows = Arrays.copyOf(this.mRows, n);
        Cache cache = this.mCache;
        cache.mIndexedVariables = Arrays.copyOf(cache.mIndexedVariables, this.TABLE_SIZE);
        n = this.TABLE_SIZE;
        this.mAlreadyTestedCandidates = new boolean[n];
        this.mMaxColumns = n;
        this.mMaxRows = n;
        cache = sMetrics;
        if (cache == null) return;
        ++cache.tableSizeIncrease;
        cache = sMetrics;
        cache.maxTableSize = Math.max(cache.maxTableSize, (long)this.TABLE_SIZE);
        cache = sMetrics;
        cache.lastTableSize = cache.maxTableSize;
    }

    private final int optimize(Row row, boolean bl) {
        int n;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.optimize;
        }
        for (n = 0; n < this.mNumColumns; ++n) {
            this.mAlreadyTestedCandidates[n] = false;
        }
        boolean bl2 = false;
        n = 0;
        while (!bl2) {
            ArrayRow arrayRow;
            int n2;
            float f;
            int n3;
            metrics = sMetrics;
            if (metrics != null) {
                ++metrics.iterations;
            }
            if ((n3 = n + 1) >= this.mNumColumns * 2) {
                return n3;
            }
            if (row.getKey() != null) {
                this.mAlreadyTestedCandidates[row.getKey().id] = true;
            }
            if ((metrics = row.getPivotCandidate(this, this.mAlreadyTestedCandidates)) != null) {
                if (this.mAlreadyTestedCandidates[metrics.id]) {
                    return n3;
                }
                this.mAlreadyTestedCandidates[metrics.id] = true;
            }
            if (metrics != null) {
                f = Float.MAX_VALUE;
                n2 = -1;
            } else {
                bl2 = true;
                n = n3;
                continue;
            }
            for (n = 0; n < this.mNumRows; ++n) {
                int n4;
                float f2;
                arrayRow = this.mRows[n];
                if (arrayRow.variable.mType == SolverVariable.Type.UNRESTRICTED) {
                    f2 = f;
                    n4 = n2;
                } else if (arrayRow.isSimpleDefinition) {
                    f2 = f;
                    n4 = n2;
                } else {
                    f2 = f;
                    n4 = n2;
                    if (arrayRow.hasVariable((SolverVariable)metrics)) {
                        float f3 = arrayRow.variables.get((SolverVariable)metrics);
                        f2 = f;
                        n4 = n2;
                        if (f3 < 0.0f) {
                            f3 = -arrayRow.constantValue / f3;
                            f2 = f;
                            n4 = n2;
                            if (f3 < f) {
                                n4 = n;
                                f2 = f3;
                            }
                        }
                    }
                }
                f = f2;
                n2 = n4;
            }
            n = n3;
            if (n2 <= -1) continue;
            ArrayRow arrayRow2 = this.mRows[n2];
            arrayRow2.variable.definitionId = -1;
            arrayRow = sMetrics;
            if (arrayRow != null) {
                ++arrayRow.pivots;
            }
            arrayRow2.pivot((SolverVariable)metrics);
            arrayRow2.variable.definitionId = n2;
            arrayRow2.variable.updateReferencesWithNewDefinition(this, arrayRow2);
            n = n3;
        }
        return n;
    }

    private void releaseRows() {
        boolean bl = OPTIMIZED_ENGINE;
        int n = 0;
        int n2 = 0;
        if (bl) {
            n = n2;
            while (n < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[n];
                if (arrayRow != null) {
                    this.mCache.optimizedArrayRowPool.release((Object)arrayRow);
                }
                this.mRows[n] = null;
                ++n;
            }
            return;
        }
        while (n < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[n];
            if (arrayRow != null) {
                this.mCache.arrayRowPool.release((Object)arrayRow);
            }
            this.mRows[n] = null;
            ++n;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int n) {
        SolverVariable solverVariable = this.createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariable2 = this.createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.TOP));
        SolverVariable solverVariable3 = this.createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariable4 = this.createObjectVariable(constraintWidget.getAnchor(ConstraintAnchor.Type.BOTTOM));
        SolverVariable solverVariable5 = this.createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT));
        SolverVariable solverVariable6 = this.createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP));
        constraintWidget = this.createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT));
        SolverVariable solverVariable7 = this.createObjectVariable(constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM));
        constraintWidget2 = this.createRow();
        double d = f;
        double d2 = Math.sin(d);
        double d3 = n;
        Double.isNaN(d3);
        constraintWidget2.createRowWithAngle(solverVariable2, solverVariable4, solverVariable6, solverVariable7, (float)(d2 * d3));
        this.addConstraint((ArrayRow)constraintWidget2);
        constraintWidget2 = this.createRow();
        d = Math.cos(d);
        Double.isNaN(d3);
        constraintWidget2.createRowWithAngle(solverVariable, solverVariable3, solverVariable5, (SolverVariable)constraintWidget, (float)(d * d3));
        this.addConstraint((ArrayRow)constraintWidget2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int n, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int n2, int n3) {
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowCentering(solverVariable, solverVariable2, n, f, solverVariable3, solverVariable4, n2);
        if (n3 != 8) {
            arrayRow.addError(this, n3);
        }
        this.addConstraint(arrayRow);
    }

    /*
     * Unable to fully structure code
     */
    public void addConstraint(ArrayRow var1_1) {
        block14: {
            if (var1_1 == null) {
                return;
            }
            var4_2 = LinearSystem.sMetrics;
            if (var4_2 != null) {
                ++var4_2.constraints;
                if (var1_1.isSimpleDefinition) {
                    var4_2 = LinearSystem.sMetrics;
                    ++var4_2.simpleconstraints;
                }
            }
            var2_3 = this.mNumRows;
            var3_4 = 1;
            if (var2_3 + 1 >= this.mMaxRows || this.mNumColumns + 1 >= this.mMaxColumns) {
                this.increaseTableSize();
            }
            var2_3 = 0;
            if (var1_1.isSimpleDefinition) break block14;
            var1_1.updateFromSystem(this);
            if (var1_1.isEmpty()) {
                return;
            }
            var1_1.ensurePositiveConstant();
            if (!var1_1.chooseSubject(this)) ** GOTO lbl-1000
            var4_2 = this.createExtraVariable();
            var1_1.variable = var4_2;
            var2_3 = this.mNumRows;
            this.addRow(var1_1);
            if (this.mNumRows == var2_3 + 1) {
                this.mTempGoal.initFromRow((Row)var1_1);
                this.optimize(this.mTempGoal, true);
                var2_3 = var3_4;
                if (var4_2.definitionId == -1) {
                    if (var1_1.variable == var4_2 && (var5_5 = var1_1.pickPivot((SolverVariable)var4_2)) != null) {
                        var4_2 = LinearSystem.sMetrics;
                        if (var4_2 != null) {
                            ++var4_2.pivots;
                        }
                        var1_1.pivot(var5_5);
                    }
                    if (!var1_1.isSimpleDefinition) {
                        var1_1.variable.updateReferencesWithNewDefinition(this, var1_1);
                    }
                    if (LinearSystem.OPTIMIZED_ENGINE) {
                        this.mCache.optimizedArrayRowPool.release((Object)var1_1);
                    } else {
                        this.mCache.arrayRowPool.release((Object)var1_1);
                    }
                    --this.mNumRows;
                    var2_3 = var3_4;
                }
            } else lbl-1000:
            // 2 sources

            {
                var2_3 = 0;
            }
            if (!var1_1.hasKeyVariable()) {
                return;
            }
        }
        if (var2_3 != 0) return;
        this.addRow(var1_1);
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int n, int n2) {
        if (USE_BASIC_SYNONYMS && n2 == 8 && solverVariable2.isFinalValue && solverVariable.definitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + (float)n);
            return null;
        }
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowEquals(solverVariable, solverVariable2, n);
        if (n2 != 8) {
            arrayRow.addError(this, n2);
        }
        this.addConstraint(arrayRow);
        return arrayRow;
    }

    public void addEquality(SolverVariable solverVariable, int n) {
        if (USE_BASIC_SYNONYMS && solverVariable.definitionId == -1) {
            float f = n;
            solverVariable.setFinalValue(this, f);
            n = 0;
            while (n < this.mVariablesID + 1) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[n];
                if (solverVariable2 != null && solverVariable2.isSynonym && solverVariable2.synonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.synonymDelta + f);
                }
                ++n;
            }
            return;
        }
        int n2 = solverVariable.definitionId;
        if (solverVariable.definitionId != -1) {
            ArrayRow arrayRow = this.mRows[n2];
            if (arrayRow.isSimpleDefinition) {
                arrayRow.constantValue = n;
            } else if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
                arrayRow.constantValue = n;
            } else {
                arrayRow = this.createRow();
                arrayRow.createRowEquals(solverVariable, n);
                this.addConstraint(arrayRow);
            }
        } else {
            ArrayRow arrayRow = this.createRow();
            arrayRow.createRowDefinition(solverVariable, n);
            this.addConstraint(arrayRow);
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int n, boolean bl) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariable3, n);
        this.addConstraint(arrayRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int n, int n2) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowGreaterThan(solverVariable, solverVariable2, solverVariable3, n);
        if (n2 != 8) {
            this.addSingleError(arrayRow, (int)(arrayRow.variables.get(solverVariable3) * -1.0f), n2);
        }
        this.addConstraint(arrayRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int n, boolean bl) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowLowerThan(solverVariable, solverVariable2, solverVariable3, n);
        this.addConstraint(arrayRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int n, int n2) {
        ArrayRow arrayRow = this.createRow();
        SolverVariable solverVariable3 = this.createSlackVariable();
        solverVariable3.strength = 0;
        arrayRow.createRowLowerThan(solverVariable, solverVariable2, solverVariable3, n);
        if (n2 != 8) {
            this.addSingleError(arrayRow, (int)(arrayRow.variables.get(solverVariable3) * -1.0f), n2);
        }
        this.addConstraint(arrayRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int n) {
        ArrayRow arrayRow = this.createRow();
        arrayRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (n != 8) {
            arrayRow.addError(this, n);
        }
        this.addConstraint(arrayRow);
    }

    void addSingleError(ArrayRow arrayRow, int n, int n2) {
        arrayRow.addSingleError(this.createErrorVariable(n2, null), n);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int n) {
        if (solverVariable.definitionId == -1 && n == 0) {
            float f;
            SolverVariable solverVariable3 = solverVariable2;
            if (solverVariable2.isSynonym) {
                f = solverVariable2.synonymDelta;
                solverVariable3 = this.mCache.mIndexedVariables[solverVariable2.synonym];
            }
            if (solverVariable.isSynonym) {
                f = solverVariable.synonymDelta;
                solverVariable = this.mCache.mIndexedVariables[solverVariable.synonym];
            } else {
                solverVariable.setSynonym(this, solverVariable3, 0.0f);
            }
        } else {
            this.addEquality(solverVariable, solverVariable2, n, 8);
        }
    }

    final void cleanupRows() {
        int n = 0;
        while (n < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[n];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.isSimpleDefinition = true;
            }
            int n2 = n;
            if (arrayRow.isSimpleDefinition) {
                int n3;
                arrayRow.variable.computedValue = arrayRow.constantValue;
                arrayRow.variable.removeFromRow(arrayRow);
                n2 = n;
                while (n2 < (n3 = this.mNumRows) - 1) {
                    ArrayRow[] arrayRowArray = this.mRows;
                    n3 = n2 + 1;
                    arrayRowArray[n2] = arrayRowArray[n3];
                    n2 = n3;
                }
                this.mRows[n3 - 1] = null;
                this.mNumRows = n3 - 1;
                n2 = n - 1;
                if (OPTIMIZED_ENGINE) {
                    this.mCache.optimizedArrayRowPool.release((Object)arrayRow);
                } else {
                    this.mCache.arrayRowPool.release((Object)arrayRow);
                }
            }
            n = n2 + 1;
        }
    }

    public SolverVariable createErrorVariable(int n, String string) {
        int n2;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.errors;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        string = this.acquireSolverVariable(SolverVariable.Type.ERROR, string);
        this.mVariablesID = n2 = this.mVariablesID + 1;
        ++this.mNumColumns;
        ((SolverVariable)string).id = n2;
        ((SolverVariable)string).strength = n;
        this.mCache.mIndexedVariables[this.mVariablesID] = string;
        this.mGoal.addError((SolverVariable)string);
        return string;
    }

    public SolverVariable createExtraVariable() {
        int n;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.extravariables;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        metrics = this.acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID = n = this.mVariablesID + 1;
        ++this.mNumColumns;
        metrics.id = n;
        this.mCache.mIndexedVariables[this.mVariablesID] = metrics;
        return metrics;
    }

    public SolverVariable createObjectVariable(Object object) {
        int n;
        Object object2 = null;
        if (object == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        if (!(object instanceof ConstraintAnchor)) return object2;
        ConstraintAnchor constraintAnchor = (ConstraintAnchor)object;
        object2 = constraintAnchor.getSolverVariable();
        object = object2;
        if (object2 == null) {
            constraintAnchor.resetSolverVariable(this.mCache);
            object = constraintAnchor.getSolverVariable();
        }
        if (((SolverVariable)object).id != -1 && ((SolverVariable)object).id <= this.mVariablesID) {
            object2 = object;
            if (this.mCache.mIndexedVariables[((SolverVariable)object).id] != null) return object2;
        }
        if (((SolverVariable)object).id != -1) {
            object.reset();
        }
        this.mVariablesID = n = this.mVariablesID + 1;
        ++this.mNumColumns;
        ((SolverVariable)object).id = n;
        ((SolverVariable)object).mType = SolverVariable.Type.UNRESTRICTED;
        this.mCache.mIndexedVariables[this.mVariablesID] = object;
        object2 = object;
        return object2;
    }

    public ArrayRow createRow() {
        ArrayRow arrayRow;
        if (OPTIMIZED_ENGINE) {
            arrayRow = (ArrayRow)this.mCache.optimizedArrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ValuesRow(this, this.mCache);
                ++OPTIMIZED_ARRAY_ROW_CREATION;
            } else {
                arrayRow.reset();
            }
        } else {
            arrayRow = (ArrayRow)this.mCache.arrayRowPool.acquire();
            if (arrayRow == null) {
                arrayRow = new ArrayRow(this.mCache);
                ++ARRAY_ROW_CREATION;
            } else {
                arrayRow.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return arrayRow;
    }

    public SolverVariable createSlackVariable() {
        int n;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.slackvariables;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            this.increaseTableSize();
        }
        metrics = this.acquireSolverVariable(SolverVariable.Type.SLACK, null);
        this.mVariablesID = n = this.mVariablesID + 1;
        ++this.mNumColumns;
        metrics.id = n;
        this.mCache.mIndexedVariables[this.mVariablesID] = metrics;
        return metrics;
    }

    public void displayReadableRows() {
        CharSequence charSequence;
        SolverVariable solverVariable;
        int n;
        this.displaySolverVariables();
        CharSequence charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append(" num vars ");
        ((StringBuilder)charSequence2).append(this.mVariablesID);
        ((StringBuilder)charSequence2).append("\n");
        charSequence2 = ((StringBuilder)charSequence2).toString();
        int n2 = 0;
        for (n = 0; n < this.mVariablesID + 1; ++n) {
            solverVariable = this.mCache.mIndexedVariables[n];
            charSequence = charSequence2;
            if (solverVariable != null) {
                charSequence = charSequence2;
                if (solverVariable.isFinalValue) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(" $[");
                    ((StringBuilder)charSequence).append(n);
                    ((StringBuilder)charSequence).append("] => ");
                    ((StringBuilder)charSequence).append(solverVariable);
                    ((StringBuilder)charSequence).append(" = ");
                    ((StringBuilder)charSequence).append(solverVariable.computedValue);
                    ((StringBuilder)charSequence).append("\n");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            }
            charSequence2 = charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append("\n");
        charSequence2 = ((StringBuilder)charSequence).toString();
        for (n = 0; n < this.mVariablesID + 1; ++n) {
            solverVariable = this.mCache.mIndexedVariables[n];
            charSequence = charSequence2;
            if (solverVariable != null) {
                charSequence = charSequence2;
                if (solverVariable.isSynonym) {
                    SolverVariable solverVariable2 = this.mCache.mIndexedVariables[solverVariable.synonym];
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(" ~[");
                    ((StringBuilder)charSequence).append(n);
                    ((StringBuilder)charSequence).append("] => ");
                    ((StringBuilder)charSequence).append(solverVariable);
                    ((StringBuilder)charSequence).append(" = ");
                    ((StringBuilder)charSequence).append(solverVariable2);
                    ((StringBuilder)charSequence).append(" + ");
                    ((StringBuilder)charSequence).append(solverVariable.synonymDelta);
                    ((StringBuilder)charSequence).append("\n");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
            }
            charSequence2 = charSequence;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append("\n\n #  ");
        charSequence2 = ((StringBuilder)charSequence).toString();
        for (n = n2; n < this.mNumRows; charSequence = ((StringBuilder)charSequence).toString(), charSequence2 = ((StringBuilder)charSequence2).toString(), ++n) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append(this.mRows[n].toReadableString());
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("\n #  ");
        }
        charSequence = charSequence2;
        if (this.mGoal != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("Goal: ");
            ((StringBuilder)charSequence).append(this.mGoal);
            ((StringBuilder)charSequence).append("\n");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        System.out.println((String)charSequence);
    }

    void displaySystemInformations() {
        int n;
        Object object;
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < this.TABLE_SIZE; ++n2) {
            object = this.mRows;
            n = n3;
            if (object[n2] != null) {
                n = n3 + object[n2].sizeInBytes();
            }
            n3 = n;
        }
        int n4 = 0;
        n = 0;
        while (true) {
            if (n4 >= this.mNumRows) {
                object = System.out;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Linear System -> Table size: ");
                stringBuilder.append(this.TABLE_SIZE);
                stringBuilder.append(" (");
                n2 = this.TABLE_SIZE;
                stringBuilder.append(this.getDisplaySize(n2 * n2));
                stringBuilder.append(") -- row sizes: ");
                stringBuilder.append(this.getDisplaySize(n3));
                stringBuilder.append(", actual size: ");
                stringBuilder.append(this.getDisplaySize(n));
                stringBuilder.append(" rows: ");
                stringBuilder.append(this.mNumRows);
                stringBuilder.append("/");
                stringBuilder.append(this.mMaxRows);
                stringBuilder.append(" cols: ");
                stringBuilder.append(this.mNumColumns);
                stringBuilder.append("/");
                stringBuilder.append(this.mMaxColumns);
                stringBuilder.append(" ");
                stringBuilder.append(0);
                stringBuilder.append(" occupied cells, ");
                stringBuilder.append(this.getDisplaySize(0));
                ((PrintStream)object).println(stringBuilder.toString());
                return;
            }
            object = this.mRows;
            n2 = n;
            if (object[n4] != null) {
                n2 = n + object[n4].sizeInBytes();
            }
            ++n4;
            n = n2;
        }
    }

    public void displayVariablesReadableRows() {
        this.displaySolverVariables();
        CharSequence charSequence = "";
        int n = 0;
        while (true) {
            CharSequence charSequence2;
            if (n >= this.mNumRows) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(this.mGoal);
                ((StringBuilder)charSequence2).append("\n");
                charSequence = ((StringBuilder)charSequence2).toString();
                System.out.println((String)charSequence);
                return;
            }
            charSequence2 = charSequence;
            if (this.mRows[n].variable.mType == SolverVariable.Type.UNRESTRICTED) {
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(this.mRows[n].toReadableString());
                charSequence = ((StringBuilder)charSequence2).toString();
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append("\n");
                charSequence2 = ((StringBuilder)charSequence2).toString();
            }
            ++n;
            charSequence = charSequence2;
        }
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int n = 0;
        int n2 = 0;
        while (n < this.mNumRows) {
            ArrayRow[] arrayRowArray = this.mRows;
            int n3 = n2;
            if (arrayRowArray[n] != null) {
                n3 = n2 + arrayRowArray[n].sizeInBytes();
            }
            ++n;
            n2 = n3;
        }
        return n2;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object object) {
        if ((object = ((ConstraintAnchor)object).getSolverVariable()) == null) return 0;
        return (int)(((SolverVariable)object).computedValue + 0.5f);
    }

    ArrayRow getRow(int n) {
        return this.mRows[n];
    }

    float getValueFor(String string) {
        if ((string = this.getVariable(string, SolverVariable.Type.UNRESTRICTED)) != null) return ((SolverVariable)string).computedValue;
        return 0.0f;
    }

    SolverVariable getVariable(String string, SolverVariable.Type type) {
        SolverVariable solverVariable;
        if (this.mVariables == null) {
            this.mVariables = new HashMap();
        }
        SolverVariable solverVariable2 = solverVariable = this.mVariables.get(string);
        if (solverVariable != null) return solverVariable2;
        solverVariable2 = this.createVariable(string, type);
        return solverVariable2;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.minimize;
        }
        if (this.mGoal.isEmpty()) {
            this.computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            this.minimizeGoal(this.mGoal);
        } else {
            int n;
            block9: {
                metrics = sMetrics;
                if (metrics != null) {
                    ++metrics.graphOptimizer;
                }
                int n2 = 0;
                for (n = 0; n < this.mNumRows; ++n) {
                    if (this.mRows[n].isSimpleDefinition) continue;
                    n = n2;
                    break block9;
                }
                n = 1;
            }
            if (n == 0) {
                this.minimizeGoal(this.mGoal);
            } else {
                metrics = sMetrics;
                if (metrics != null) {
                    ++metrics.fullySolved;
                }
                this.computeValues();
            }
        }
    }

    void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            ++metrics.minimizeGoal;
            metrics = sMetrics;
            metrics.maxVariables = Math.max(metrics.maxVariables, (long)this.mNumColumns);
            metrics = sMetrics;
            metrics.maxRows = Math.max(metrics.maxRows, (long)this.mNumRows);
        }
        this.enforceBFS(row);
        this.optimize(row, false);
        this.computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        if (!arrayRow.isSimpleDefinition) return;
        if (arrayRow.variable == null) return;
        if (arrayRow.variable.definitionId != -1) {
            int n;
            int n2 = arrayRow.variable.definitionId;
            while (n2 < (n = this.mNumRows) - 1) {
                ArrayRow[] arrayRowArray = this.mRows;
                n = n2 + 1;
                arrayRowArray = arrayRowArray[n].variable;
                if (arrayRowArray.definitionId == n) {
                    arrayRowArray.definitionId = n2;
                }
                arrayRowArray = this.mRows;
                arrayRowArray[n2] = arrayRowArray[n];
                n2 = n;
            }
            this.mNumRows = n - 1;
        }
        if (!arrayRow.variable.isFinalValue) {
            arrayRow.variable.setFinalValue(this, arrayRow.constantValue);
        }
        if (OPTIMIZED_ENGINE) {
            this.mCache.optimizedArrayRowPool.release((Object)arrayRow);
        } else {
            this.mCache.arrayRowPool.release((Object)arrayRow);
        }
    }

    public void reset() {
        Object object;
        int n;
        for (n = 0; n < this.mCache.mIndexedVariables.length; ++n) {
            object = this.mCache.mIndexedVariables[n];
            if (object == null) continue;
            object.reset();
        }
        this.mCache.solverVariablePool.releaseAll((Object[])this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, null);
        object = this.mVariables;
        if (object != null) {
            ((HashMap)object).clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (n = 0; n < this.mNumRows; ++n) {
            object = this.mRows;
            if (object[n] == null) continue;
            ((ArrayRow)object[n]).used = false;
        }
        this.releaseRows();
        this.mNumRows = 0;
        this.mTempGoal = OPTIMIZED_ENGINE ? new ValuesRow(this, this.mCache) : new ArrayRow(this.mCache);
    }
}
