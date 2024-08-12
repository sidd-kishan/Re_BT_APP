/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State
 *  androidx.constraintlayout.solver.state.State$Helper
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 */
package androidx.constraintlayout.solver.state;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import java.util.ArrayList;

public class HelperReference {
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences = new ArrayList();
    protected final State mState;
    final State.Helper mType;

    public HelperReference(State state, State.Helper helper) {
        this.mState = state;
        this.mType = helper;
    }

    public HelperReference add(Object ... objectArray) {
        int n = objectArray.length;
        int n2 = 0;
        while (n2 < n) {
            Object object = objectArray[n2];
            this.mReferences.add(object);
            ++n2;
        }
        return this;
    }

    public void apply() {
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }
}
