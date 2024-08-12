/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.ArrayRow
 *  androidx.constraintlayout.solver.LinearSystem
 *  androidx.constraintlayout.solver.SolverVariable$1
 *  androidx.constraintlayout.solver.SolverVariable$Type
 */
package androidx.constraintlayout.solver;

import androidx.constraintlayout.solver.ArrayRow;
import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.SolverVariable;
import java.util.Arrays;
import java.util.HashSet;

public class SolverVariable {
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int uniqueConstantId = 1;
    private static int uniqueErrorId = 1;
    private static int uniqueId = 1;
    private static int uniqueSlackId = 1;
    private static int uniqueUnrestrictedId = 1;
    public float computedValue;
    int definitionId = -1;
    float[] goalStrengthVector;
    public int id = -1;
    public boolean inGoal;
    HashSet<ArrayRow> inRows = null;
    public boolean isFinalValue = false;
    boolean isSynonym = false;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount = 0;
    private String mName;
    Type mType;
    public int strength = 0;
    float[] strengthVector = new float[9];
    int synonym = -1;
    float synonymDelta = 0.0f;
    public int usageInRowCount = 0;

    public SolverVariable(Type type, String string) {
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mType = type;
    }

    public SolverVariable(String string, Type type) {
        this.goalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mName = string;
        this.mType = type;
    }

    private static String getUniqueName(Type object, String string) {
        if (string != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(uniqueErrorId);
            return ((StringBuilder)object).toString();
        }
        int n = 1.$SwitchMap$androidx$constraintlayout$solver$SolverVariable$Type[object.ordinal()];
        if (n == 1) {
            object = new StringBuilder();
            ((StringBuilder)object).append("U");
            uniqueUnrestrictedId = n = uniqueUnrestrictedId + 1;
            ((StringBuilder)object).append(n);
            return ((StringBuilder)object).toString();
        }
        if (n == 2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("C");
            uniqueConstantId = n = uniqueConstantId + 1;
            ((StringBuilder)object).append(n);
            return ((StringBuilder)object).toString();
        }
        if (n == 3) {
            object = new StringBuilder();
            ((StringBuilder)object).append("S");
            uniqueSlackId = n = uniqueSlackId + 1;
            ((StringBuilder)object).append(n);
            return ((StringBuilder)object).toString();
        }
        if (n != 4) {
            if (n != 5) throw new AssertionError((Object)object.name());
            object = new StringBuilder();
            ((StringBuilder)object).append("V");
            uniqueId = n = uniqueId + 1;
            ((StringBuilder)object).append(n);
            return ((StringBuilder)object).toString();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("e");
        uniqueErrorId = n = uniqueErrorId + 1;
        ((StringBuilder)object).append(n);
        return ((StringBuilder)object).toString();
    }

    static void increaseErrorId() {
        ++uniqueErrorId;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int n;
        int n2;
        for (n2 = 0; n2 < (n = this.mClientEquationsCount); ++n2) {
            if (this.mClientEquations[n2] != arrayRow) continue;
            return;
        }
        ArrayRow[] arrayRowArray = this.mClientEquations;
        if (n >= arrayRowArray.length) {
            this.mClientEquations = Arrays.copyOf(arrayRowArray, arrayRowArray.length * 2);
        }
        arrayRowArray = this.mClientEquations;
        n2 = this.mClientEquationsCount;
        arrayRowArray[n2] = arrayRow;
        this.mClientEquationsCount = n2 + 1;
    }

    void clearStrengths() {
        int n = 0;
        while (n < 9) {
            this.strengthVector[n] = 0.0f;
            ++n;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRowArray) {
        int n = this.mClientEquationsCount;
        int n2 = 0;
        while (n2 < n) {
            if (this.mClientEquations[n2] == arrayRowArray) {
                while (true) {
                    if (n2 >= n - 1) {
                        --this.mClientEquationsCount;
                        return;
                    }
                    arrayRowArray = this.mClientEquations;
                    int n3 = n2 + 1;
                    arrayRowArray[n2] = arrayRowArray[n3];
                    n2 = n3;
                }
            }
            ++n2;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.definitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int n = this.mClientEquationsCount;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mClientEquationsCount = 0;
                this.usageInRowCount = 0;
                this.inGoal = false;
                Arrays.fill(this.goalStrengthVector, 0.0f);
                return;
            }
            this.mClientEquations[n2] = null;
            ++n2;
        }
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.isSynonym = false;
        this.synonym = -1;
        this.synonymDelta = 0.0f;
        int n = this.mClientEquationsCount;
        this.definitionId = -1;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mClientEquationsCount = 0;
                return;
            }
            this.mClientEquations[n2].updateFromFinalVariable(linearSystem, this, false);
            ++n2;
        }
    }

    public void setName(String string) {
        this.mName = string;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.isSynonym = true;
        this.synonym = solverVariable.id;
        this.synonymDelta = f;
        int n = this.mClientEquationsCount;
        this.definitionId = -1;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mClientEquationsCount = 0;
                linearSystem.displayReadableRows();
                return;
            }
            this.mClientEquations[n2].updateFromSynonymVariable(linearSystem, this, false);
            ++n2;
        }
    }

    public void setType(Type type, String string) {
        this.mType = type;
    }

    String strengthsToString() {
        Object object;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(this);
        ((StringBuilder)charSequence).append("[");
        charSequence = ((StringBuilder)charSequence).toString();
        boolean bl = false;
        boolean bl2 = true;
        for (int i = 0; i < this.strengthVector.length; ++i) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(this.strengthVector[i]);
            charSequence = ((StringBuilder)object).toString();
            object = this.strengthVector;
            if (object[i] > 0.0f) {
                bl = false;
            } else if (object[i] < 0.0f) {
                bl = true;
            }
            if (this.strengthVector[i] != 0.0f) {
                bl2 = false;
            }
            if (i < this.strengthVector.length - 1) {
                object = new StringBuilder();
                ((StringBuilder)object).append((String)charSequence);
                ((StringBuilder)object).append(", ");
                charSequence = ((StringBuilder)object).toString();
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append("] ");
            charSequence = ((StringBuilder)object).toString();
        }
        object = charSequence;
        if (bl) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append(" (-)");
            object = ((StringBuilder)object).toString();
        }
        charSequence = object;
        if (!bl2) return charSequence;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(" (*)");
        charSequence = ((StringBuilder)charSequence).toString();
        return charSequence;
    }

    public String toString() {
        CharSequence charSequence;
        if (this.mName != null) {
            charSequence = new StringBuilder();
            charSequence.append("");
            charSequence.append(this.mName);
            charSequence = charSequence.toString();
        } else {
            charSequence = new StringBuilder();
            charSequence.append("");
            charSequence.append(this.id);
            charSequence = charSequence.toString();
        }
        return charSequence;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int n = this.mClientEquationsCount;
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                this.mClientEquationsCount = 0;
                return;
            }
            this.mClientEquations[n2].updateFromRow(linearSystem, arrayRow, false);
            ++n2;
        }
    }
}
