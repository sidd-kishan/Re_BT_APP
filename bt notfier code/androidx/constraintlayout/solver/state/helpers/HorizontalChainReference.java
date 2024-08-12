/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State
 *  androidx.constraintlayout.solver.state.State$Helper
 *  androidx.constraintlayout.solver.state.helpers.ChainReference
 *  androidx.constraintlayout.solver.state.helpers.HorizontalChainReference$1
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.helpers.ChainReference;
import androidx.constraintlayout.solver.state.helpers.HorizontalChainReference;
import java.util.Iterator;

public class HorizontalChainReference
extends ChainReference {
    private Object mEndToEnd;
    private Object mEndToStart;
    private Object mStartToEnd;
    private Object mStartToStart;

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    public void apply() {
        int n;
        Object object;
        Object e2;
        for (Object e2 : this.mReferences) {
            this.mState.constraints(e2).clearHorizontal();
        }
        Iterator iterator = this.mReferences.iterator();
        e2 = null;
        Object object2 = null;
        while (iterator.hasNext()) {
            object = iterator.next();
            object = this.mState.constraints(object);
            Object object3 = object2;
            if (object2 == null) {
                object2 = this.mStartToStart;
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
                object3 = object;
            }
            if (e2 != null) {
                e2.endToStart(object.getKey());
                object.startToEnd(e2.getKey());
            }
            e2 = object;
            object2 = object3;
        }
        if (e2 != null) {
            object = this.mEndToStart;
            if (object != null) {
                e2.endToStart(object);
            } else {
                object = this.mEndToEnd;
                if (object != null) {
                    e2.endToEnd(object);
                } else {
                    e2.endToEnd((Object)State.PARENT);
                }
            }
        }
        if (object2 != null && this.mBias != 0.5f) {
            object2.horizontalBias(this.mBias);
        }
        if ((n = 1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()]) != 1) {
            if (n != 2) {
                if (n != 3) return;
                object2.setHorizontalChainStyle(2);
            } else {
                object2.setHorizontalChainStyle(1);
            }
        } else {
            object2.setHorizontalChainStyle(0);
        }
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
