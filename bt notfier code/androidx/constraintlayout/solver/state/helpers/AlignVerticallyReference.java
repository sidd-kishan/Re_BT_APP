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

public class AlignVerticallyReference
extends HelperReference {
    private float mBias = 0.5f;
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
    }

    public void apply() {
        Iterator iterator = this.mReferences.iterator();
        while (iterator.hasNext()) {
            float f;
            Object object = iterator.next();
            object = this.mState.constraints(object);
            object.clearVertical();
            Object object2 = this.mTopToTop;
            if (object2 != null) {
                object.topToTop(object2);
            } else {
                object2 = this.mTopToBottom;
                if (object2 != null) {
                    object.topToBottom(object2);
                } else {
                    object.topToTop((Object)State.PARENT);
                }
            }
            object2 = this.mBottomToTop;
            if (object2 != null) {
                object.bottomToTop(object2);
            } else {
                object2 = this.mBottomToBottom;
                if (object2 != null) {
                    object.bottomToBottom(object2);
                } else {
                    object.bottomToBottom((Object)State.PARENT);
                }
            }
            if ((f = this.mBias) == 0.5f) continue;
            object.verticalBias(f);
        }
    }

    public void bias(float f) {
        this.mBias = f;
    }

    public void bottomToBottom(Object object) {
        this.mBottomToBottom = object;
    }

    public void bottomToTop(Object object) {
        this.mBottomToTop = object;
    }

    public void topToBottom(Object object) {
        this.mTopToBottom = object;
    }

    public void topToTop(Object object) {
        this.mTopToTop = object;
    }
}
