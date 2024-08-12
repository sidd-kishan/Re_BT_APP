/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.HelperReference
 *  androidx.constraintlayout.solver.state.State
 *  androidx.constraintlayout.solver.state.State$Helper
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import java.util.Iterator;

public class AlignHorizontallyReference
extends HelperReference {
    private float mBias = 0.5f;
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public AlignHorizontallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    public void apply() {
        Iterator iterator = this.mReferences.iterator();
        while (iterator.hasNext()) {
            float f;
            Object object = iterator.next();
            object = this.mState.constraints(object);
            object.clearHorizontal();
            Object object2 = this.mStartToStart;
            if (object2 != null) {
                object.startToStart(object2);
            } else {
                object2 = this.mStartToEnd;
                if (object2 != null) {
                    object.startToEnd(object2);
                } else {
                    object.startToStart((Object)State.PARENT);
                }
            }
            object2 = this.mEndToStart;
            if (object2 != null) {
                object.endToStart(object2);
            } else {
                object2 = this.mEndToEnd;
                if (object2 != null) {
                    object.endToEnd(object2);
                } else {
                    object.endToEnd((Object)State.PARENT);
                }
            }
            if ((f = this.mBias) == 0.5f) continue;
            object.horizontalBias(f);
        }
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public void endToEnd(Object object) {
        this.mEndToEnd = object;
    }

    public void endToStart(Object object) {
        this.mEndToStart = object;
    }

    public void startToEnd(Object object) {
        this.mStartToEnd = object;
    }

    public void startToStart(Object object) {
        this.mStartToStart = object;
    }
}
