/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayLinkedVariables
 *  androidx.constraintlayout.solver.ArrayRow$ArrayRowVariables
 *  androidx.constraintlayout.solver.Cache
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.LinearSystem$Row
 *  androidx.constraintlayout.solver.SolverVariable
 *  androidx.constraintlayout.solver.SolverVariable$Type
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayLinkedVariables;
import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.ArrayList;

public class ArrayRow
implements LinearSystem.Row {
    private static final boolean DEBUG = false;
    private static final boolean FULL_NEW_CHECK = false;
    float constantValue = 0.0f;
    boolean isSimpleDefinition = false;
    boolean used = false;
    SolverVariable variable = null;
    public ArrayRowVariables variables;
    ArrayList<SolverVariable> variablesToUpdate = new ArrayList();

    public ArrayRow() {
    }

    public ArrayRow(Cache cache) {
        this.variables = new ArrayLinkedVariables(this, cache);
    }

    private boolean isNew(SolverVariable solverVariable, LinearSystem linearSystem) {
        int n = solverVariable.usageInRowCount;
        boolean bl = true;
        if (n <= 1) return bl;
        bl = false;
        return bl;
    }

    private SolverVariable pickPivotInVariables(boolean[] blArray, SolverVariable solverVariable) {
        int n = this.variables.getCurrentSize();
        SolverVariable solverVariable2 = null;
        int n2 = 0;
        float f = 0.0f;
        while (n2 < n) {
            float f2;
            SolverVariable solverVariable3;
            block5: {
                SolverVariable solverVariable4;
                float f3;
                block7: {
                    block6: {
                        f3 = this.variables.getVariableValue(n2);
                        solverVariable3 = solverVariable2;
                        f2 = f;
                        if (!(f3 < 0.0f)) break block5;
                        solverVariable4 = this.variables.getVariable(n2);
                        if (blArray == null) break block6;
                        solverVariable3 = solverVariable2;
                        f2 = f;
                        if (blArray[solverVariable4.id]) break block5;
                    }
                    solverVariable3 = solverVariable2;
                    f2 = f;
                    if (solverVariable4 == solverVariable) break block5;
                    if (solverVariable4.mType == SolverVariable.Type.SLACK) break block7;
                    solverVariable3 = solverVariable2;
                    f2 = f;
                    if (solverVariable4.mType != SolverVariable.Type.ERROR) break block5;
                }
                solverVariable3 = solverVariable2;
                f2 = f;
                if (f3 < f) {
                    f2 = f3;
                    solverVariable3 = solverVariable4;
                }
            }
            ++n2;
            solverVariable2 = solverVariable3;
            f = f2;
        }
        return solverVariable2;
    }

    public ArrayRow addError(LinearSystem linearSystem, int n) {
        this.variables.put(linearSystem.createErrorVariable(n, "ep"), 1.0f);
        this.variables.put(linearSystem.createErrorVariable(n, "em"), -1.0f);
        return this;
    }

    public void addError(SolverVariable solverVariable) {
        int n = solverVariable.strength;
        float f = 1.0f;
        if (n != 1) {
            if (solverVariable.strength == 2) {
                f = 1000.0f;
            } else if (solverVariable.strength == 3) {
                f = 1000000.0f;
            } else if (solverVariable.strength == 4) {
                f = 1.0E9f;
            } else if (solverVariable.strength == 5) {
                f = 1.0E12f;
            }
        }
        this.variables.put(solverVariable, f);
    }

    ArrayRow addSingleError(SolverVariable solverVariable, int n) {
        this.variables.put(solverVariable, (float)n);
        return this;
    }

    boolean chooseSubject(LinearSystem linearSystem) {
        boolean bl;
        if ((linearSystem = this.chooseSubjectInVariables(linearSystem)) == null) {
            bl = true;
        } else {
            this.pivot((SolverVariable)linearSystem);
            bl = false;
        }
        if (this.variables.getCurrentSize() != 0) return bl;
        this.isSimpleDefinition = true;
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    SolverVariable chooseSubjectInVariables(LinearSystem var1_1) {
        var8_2 = this.variables.getCurrentSize();
        var17_3 = null;
        var16_4 = null;
        var7_5 = 0;
        var12_6 = false;
        var11_7 = false;
        var6_8 = 0.0f;
        var5_9 = 0.0f;
        while (true) {
            block12: {
                block13: {
                    block10: {
                        block11: {
                            if (var7_5 >= var8_2) {
                                if (var17_3 == null) return var16_4;
                                return var17_3;
                            }
                            var2_10 = this.variables.getVariableValue(var7_5);
                            var13_15 = this.variables.getVariable(var7_5);
                            if (var13_15.mType != SolverVariable.Type.UNRESTRICTED) break block10;
                            if (var17_3 != null) break block11;
                            var9_13 = this.isNew(var13_15, var1_1);
                            ** GOTO lbl22
                        }
                        if (var6_8 > var2_10) {
                            var9_13 = this.isNew(var13_15, var1_1);
lbl22:
                            // 2 sources

                            var14_16 = var13_15;
                            var15_17 = var16_4;
                            var10_14 = var11_7;
                            var3_11 = var2_10;
                            var4_12 = var5_9;
                        } else {
                            var14_16 = var17_3;
                            var15_17 = var16_4;
                            var9_13 = var12_6;
                            var10_14 = var11_7;
                            var3_11 = var6_8;
                            var4_12 = var5_9;
                            if (!var12_6) {
                                var14_16 = var17_3;
                                var15_17 = var16_4;
                                var9_13 = var12_6;
                                var10_14 = var11_7;
                                var3_11 = var6_8;
                                var4_12 = var5_9;
                                if (this.isNew(var13_15, var1_1)) {
                                    var9_13 = true;
                                    var14_16 = var13_15;
                                    var15_17 = var16_4;
                                    var10_14 = var11_7;
                                    var3_11 = var2_10;
                                    var4_12 = var5_9;
                                }
                            }
                        }
                        break block12;
                    }
                    var14_16 = var17_3;
                    var15_17 = var16_4;
                    var9_13 = var12_6;
                    var10_14 = var11_7;
                    var3_11 = var6_8;
                    var4_12 = var5_9;
                    if (var17_3 != null) break block12;
                    var14_16 = var17_3;
                    var15_17 = var16_4;
                    var9_13 = var12_6;
                    var10_14 = var11_7;
                    var3_11 = var6_8;
                    var4_12 = var5_9;
                    if (!(var2_10 < 0.0f)) break block12;
                    if (var16_4 != null) break block13;
                    var9_13 = this.isNew(var13_15, var1_1);
                    ** GOTO lbl70
                }
                if (var5_9 > var2_10) {
                    var9_13 = this.isNew(var13_15, var1_1);
lbl70:
                    // 2 sources

                    var10_14 = var9_13;
                    var14_16 = var17_3;
                    var15_17 = var13_15;
                    var9_13 = var12_6;
                    var3_11 = var6_8;
                    var4_12 = var2_10;
                } else {
                    var14_16 = var17_3;
                    var15_17 = var16_4;
                    var9_13 = var12_6;
                    var10_14 = var11_7;
                    var3_11 = var6_8;
                    var4_12 = var5_9;
                    if (!var11_7) {
                        var14_16 = var17_3;
                        var15_17 = var16_4;
                        var9_13 = var12_6;
                        var10_14 = var11_7;
                        var3_11 = var6_8;
                        var4_12 = var5_9;
                        if (this.isNew(var13_15, var1_1)) {
                            var10_14 = true;
                            var4_12 = var2_10;
                            var3_11 = var6_8;
                            var9_13 = var12_6;
                            var15_17 = var13_15;
                            var14_16 = var17_3;
                        }
                    }
                }
            }
            ++var7_5;
            var17_3 = var14_16;
            var16_4 = var15_17;
            var12_6 = var9_13;
            var11_7 = var10_14;
            var6_8 = var3_11;
            var5_9 = var4_12;
        }
    }

    public void clear() {
        this.variables.clear();
        this.variable = null;
        this.constantValue = 0.0f;
    }

    ArrayRow createRowCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int n, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int n2) {
        if (solverVariable2 == solverVariable3) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable2, -2.0f);
            return this;
        }
        if (f == 0.5f) {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            if (n <= 0) {
                if (n2 <= 0) return this;
            }
            this.constantValue = -n + n2;
        } else if (f <= 0.0f) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.constantValue = n;
        } else if (f >= 1.0f) {
            this.variables.put(solverVariable4, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
            this.constantValue = -n2;
        } else {
            ArrayRowVariables arrayRowVariables = this.variables;
            float f2 = 1.0f - f;
            arrayRowVariables.put(solverVariable, f2 * 1.0f);
            this.variables.put(solverVariable2, f2 * -1.0f);
            this.variables.put(solverVariable3, -1.0f * f);
            this.variables.put(solverVariable4, 1.0f * f);
            if (n <= 0) {
                if (n2 <= 0) return this;
            }
            this.constantValue = (float)(-n) * f2 + (float)n2 * f;
        }
        return this;
    }

    ArrayRow createRowDefinition(SolverVariable solverVariable, int n) {
        float f;
        this.variable = solverVariable;
        solverVariable.computedValue = f = (float)n;
        this.constantValue = f;
        this.isSimpleDefinition = true;
        return this;
    }

    ArrayRow createRowDimensionPercent(SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, f);
        return this;
    }

    public ArrayRow createRowDimensionRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable, -1.0f);
        this.variables.put(solverVariable2, 1.0f);
        this.variables.put(solverVariable3, f);
        this.variables.put(solverVariable4, -f);
        return this;
    }

    public ArrayRow createRowEqualDimension(float f, float f2, float f3, SolverVariable solverVariable, int n, SolverVariable solverVariable2, int n2, SolverVariable solverVariable3, int n3, SolverVariable solverVariable4, int n4) {
        if (f2 != 0.0f && f != f3) {
            f = f / f2 / (f3 / f2);
            this.constantValue = (float)(-n - n2) + (float)n3 * f + (float)n4 * f;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, f);
            this.variables.put(solverVariable3, -f);
        } else {
            this.constantValue = -n - n2 + n3 + n4;
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEqualMatchDimensions(float f, float f2, float f3, SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4) {
        this.constantValue = 0.0f;
        if (f2 != 0.0f && f != f3) {
            if (f == 0.0f) {
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
            } else if (f3 == 0.0f) {
                this.variables.put(solverVariable3, 1.0f);
                this.variables.put(solverVariable4, -1.0f);
            } else {
                f = f / f2 / (f3 / f2);
                this.variables.put(solverVariable, 1.0f);
                this.variables.put(solverVariable2, -1.0f);
                this.variables.put(solverVariable4, f);
                this.variables.put(solverVariable3, -f);
            }
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable4, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, int n) {
        if (n < 0) {
            this.constantValue = n * -1;
            this.variables.put(solverVariable, 1.0f);
        } else {
            this.constantValue = n;
            this.variables.put(solverVariable, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowEquals(SolverVariable solverVariable, SolverVariable solverVariable2, int n) {
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            n2 = n3;
            n3 = n;
            if (n < 0) {
                n3 = n * -1;
                n2 = 1;
            }
            this.constantValue = n3;
        }
        if (n2 == 0) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, int n, SolverVariable solverVariable2) {
        this.constantValue = n;
        this.variables.put(solverVariable, -1.0f);
        return this;
    }

    public ArrayRow createRowGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int n) {
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            n2 = n3;
            n3 = n;
            if (n < 0) {
                n3 = n * -1;
                n2 = 1;
            }
            this.constantValue = n3;
        }
        if (n2 == 0) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, 1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, -1.0f);
        }
        return this;
    }

    public ArrayRow createRowLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, int n) {
        int n2 = 0;
        int n3 = 0;
        if (n != 0) {
            n2 = n3;
            n3 = n;
            if (n < 0) {
                n3 = n * -1;
                n2 = 1;
            }
            this.constantValue = n3;
        }
        if (n2 == 0) {
            this.variables.put(solverVariable, -1.0f);
            this.variables.put(solverVariable2, 1.0f);
            this.variables.put(solverVariable3, -1.0f);
        } else {
            this.variables.put(solverVariable, 1.0f);
            this.variables.put(solverVariable2, -1.0f);
            this.variables.put(solverVariable3, 1.0f);
        }
        return this;
    }

    public ArrayRow createRowWithAngle(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f) {
        this.variables.put(solverVariable3, 0.5f);
        this.variables.put(solverVariable4, 0.5f);
        this.variables.put(solverVariable, -0.5f);
        this.variables.put(solverVariable2, -0.5f);
        this.constantValue = -f;
        return this;
    }

    void ensurePositiveConstant() {
        float f = this.constantValue;
        if (!(f < 0.0f)) return;
        this.constantValue = f * -1.0f;
        this.variables.invert();
    }

    public SolverVariable getKey() {
        return this.variable;
    }

    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] blArray) {
        return this.pickPivotInVariables(blArray, null);
    }

    boolean hasKeyVariable() {
        SolverVariable solverVariable = this.variable;
        boolean bl = !(solverVariable == null || solverVariable.mType != SolverVariable.Type.UNRESTRICTED && this.constantValue < 0.0f);
        return bl;
    }

    boolean hasVariable(SolverVariable solverVariable) {
        return this.variables.contains(solverVariable);
    }

    public void initFromRow(LinearSystem.Row row) {
        if (!(row instanceof ArrayRow)) return;
        ArrayRow arrayRow = (ArrayRow)row;
        this.variable = null;
        this.variables.clear();
        int n = 0;
        while (n < arrayRow.variables.getCurrentSize()) {
            row = arrayRow.variables.getVariable(n);
            float f = arrayRow.variables.getVariableValue(n);
            this.variables.add((SolverVariable)row, f, true);
            ++n;
        }
    }

    public boolean isEmpty() {
        boolean bl = this.variable == null && this.constantValue == 0.0f && this.variables.getCurrentSize() == 0;
        return bl;
    }

    public SolverVariable pickPivot(SolverVariable solverVariable) {
        return this.pickPivotInVariables(null, solverVariable);
    }

    void pivot(SolverVariable solverVariable) {
        SolverVariable solverVariable2 = this.variable;
        if (solverVariable2 != null) {
            this.variables.put(solverVariable2, -1.0f);
            this.variable.definitionId = -1;
            this.variable = null;
        }
        float f = this.variables.remove(solverVariable, true) * -1.0f;
        this.variable = solverVariable;
        if (f == 1.0f) {
            return;
        }
        this.constantValue /= f;
        this.variables.divideByAmount(f);
    }

    public void reset() {
        this.variable = null;
        this.variables.clear();
        this.constantValue = 0.0f;
        this.isSimpleDefinition = false;
    }

    int sizeInBytes() {
        int n = this.variable != null ? 4 : 0;
        return n + 4 + 4 + this.variables.sizeInBytes();
    }

    /*
     * Unable to fully structure code
     */
    String toReadableString() {
        if (this.variable == null) {
            var6_1 = "0";
        } else {
            var6_1 = new StringBuilder();
            var6_1.append("");
            var6_1.append(this.variable);
            var6_1 = var6_1.toString();
        }
        var7_2 = new StringBuilder();
        var7_2.append((String)var6_1);
        var7_2.append(" = ");
        var6_1 = var7_2.toString();
        var1_3 = this.constantValue;
        var4_4 = 0;
        if (var1_3 != 0.0f) {
            var7_2 = new StringBuilder();
            var7_2.append((String)var6_1);
            var7_2.append(this.constantValue);
            var6_1 = var7_2.toString();
            var3_5 = true;
        } else {
            var3_5 = false;
        }
        var5_6 = this.variables.getCurrentSize();
        while (true) {
            block10: {
                block12: {
                    block11: {
                        if (var4_4 >= var5_6) {
                            var7_2 = var6_1;
                            if (var3_5 != false) return var7_2;
                            var7_2 = new StringBuilder();
                            var7_2.append((String)var6_1);
                            var7_2.append("0.0");
                            var7_2 = var7_2.toString();
                            return var7_2;
                        }
                        var7_2 = this.variables.getVariable(var4_4);
                        if (var7_2 == null || (var2_7 = this.variables.getVariableValue(var4_4)) == 0.0f) break block10;
                        var8_8 = var7_2.toString();
                        if (var3_5) break block11;
                        var7_2 = var6_1;
                        var1_3 = var2_7;
                        if (!(var2_7 < 0.0f)) break block12;
                        var7_2 = new StringBuilder();
                        var7_2.append((String)var6_1);
                        var7_2.append("- ");
                        var7_2 = var7_2.toString();
                        ** GOTO lbl70
                    }
                    if (var2_7 > 0.0f) {
                        var7_2 = new StringBuilder();
                        var7_2.append((String)var6_1);
                        var7_2.append(" + ");
                        var7_2 = var7_2.toString();
                        var1_3 = var2_7;
                    } else {
                        var7_2 = new StringBuilder();
                        var7_2.append((String)var6_1);
                        var7_2.append(" - ");
                        var7_2 = var7_2.toString();
lbl70:
                        // 2 sources

                        var1_3 = var2_7 * -1.0f;
                    }
                }
                if (var1_3 == 1.0f) {
                    var6_1 = new StringBuilder();
                    var6_1.append((String)var7_2);
                    var6_1.append(var8_8);
                    var6_1 = var6_1.toString();
                } else {
                    var6_1 = new StringBuilder();
                    var6_1.append((String)var7_2);
                    var6_1.append(var1_3);
                    var6_1.append(" ");
                    var6_1.append(var8_8);
                    var6_1 = var6_1.toString();
                }
                var3_5 = true;
            }
            ++var4_4;
        }
    }

    public String toString() {
        return this.toReadableString();
    }

    public void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean bl) {
        if (!solverVariable.isFinalValue) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue += solverVariable.computedValue * f;
        this.variables.remove(solverVariable, bl);
        if (bl) {
            solverVariable.removeFromRow(this);
        }
        if (!LinearSystem.SIMPLIFY_SYNONYMS) return;
        if (solverVariable == null) return;
        if (this.variables.getCurrentSize() != 0) return;
        this.isSimpleDefinition = true;
        linearSystem.hasSimpleDefinition = true;
    }

    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean bl) {
        float f = this.variables.use(arrayRow, bl);
        this.constantValue += arrayRow.constantValue * f;
        if (bl) {
            arrayRow.variable.removeFromRow(this);
        }
        if (!LinearSystem.SIMPLIFY_SYNONYMS) return;
        if (this.variable == null) return;
        if (this.variables.getCurrentSize() != 0) return;
        this.isSimpleDefinition = true;
        linearSystem.hasSimpleDefinition = true;
    }

    public void updateFromSynonymVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean bl) {
        if (!solverVariable.isSynonym) {
            return;
        }
        float f = this.variables.get(solverVariable);
        this.constantValue += solverVariable.synonymDelta * f;
        this.variables.remove(solverVariable, bl);
        if (bl) {
            solverVariable.removeFromRow(this);
        }
        this.variables.add(linearSystem.mCache.mIndexedVariables[solverVariable.synonym], f, bl);
        if (!LinearSystem.SIMPLIFY_SYNONYMS) return;
        if (solverVariable == null) return;
        if (this.variables.getCurrentSize() != 0) return;
        this.isSimpleDefinition = true;
        linearSystem.hasSimpleDefinition = true;
    }

    public void updateFromSystem(LinearSystem linearSystem) {
        if (linearSystem.mRows.length == 0) {
            return;
        }
        boolean bl = false;
        while (true) {
            SolverVariable solverVariable;
            int n;
            if (bl) {
                if (!LinearSystem.SIMPLIFY_SYNONYMS) return;
                if (this.variable == null) return;
                if (this.variables.getCurrentSize() != 0) return;
                this.isSimpleDefinition = true;
                linearSystem.hasSimpleDefinition = true;
                return;
            }
            int n2 = this.variables.getCurrentSize();
            for (n = 0; n < n2; ++n) {
                solverVariable = this.variables.getVariable(n);
                if (solverVariable.definitionId == -1 && !solverVariable.isFinalValue && !solverVariable.isSynonym) continue;
                this.variablesToUpdate.add(solverVariable);
            }
            n2 = this.variablesToUpdate.size();
            if (n2 > 0) {
            } else {
                bl = true;
                continue;
            }
            for (n = 0; n < n2; ++n) {
                solverVariable = this.variablesToUpdate.get(n);
                if (solverVariable.isFinalValue) {
                    this.updateFromFinalVariable(linearSystem, solverVariable, true);
                    continue;
                }
                if (solverVariable.isSynonym) {
                    this.updateFromSynonymVariable(linearSystem, solverVariable, true);
                    continue;
                }
                this.updateFromRow(linearSystem, linearSystem.mRows[solverVariable.definitionId], true);
            }
            this.variablesToUpdate.clear();
        }
    }
}
