/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.ConstraintReference
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.ConstraintReference;
import java.util.ArrayList;

class ConstraintReference.IncorrectConstraintException
extends Exception {
    private final ArrayList<String> mErrors;
    final ConstraintReference this$0;

    public ConstraintReference.IncorrectConstraintException(ConstraintReference constraintReference, ArrayList<String> arrayList) {
        this.this$0 = constraintReference;
        this.mErrors = arrayList;
    }

    public ArrayList<String> getErrors() {
        return this.mErrors;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("IncorrectConstraintException: ");
        stringBuilder.append(this.mErrors.toString());
        return stringBuilder.toString();
    }
}
