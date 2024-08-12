/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.State
 *  androidx.constraintlayout.solver.state.State$Helper
 *  androidx.constraintlayout.solver.state.helpers.ChainReference
 *  androidx.constraintlayout.solver.state.helpers.VerticalChainReference$1
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.helpers.ChainReference;
import androidx.constraintlayout.solver.state.helpers.VerticalChainReference;
import java.util.Iterator;

public class VerticalChainReference
extends ChainReference {
    private Object mBottomToBottom;
    private Object mBottomToTop;
    private Object mTopToBottom;
    private Object mTopToTop;

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    public void apply() {
        int n;
        Object object;
        Object e2;
        for (Object e2 : this.mReferences) {
            this.mState.constraints(e2).clearVertical();
        }
        Iterator iterator = this.mReferences.iterator();
        e2 = null;
        Object object2 = null;
        while (iterator.hasNext()) {
            object = iterator.next();
            object = this.mState.constraints(object);
            Object object3 = object2;
            if (object2 == null) {
                object2 = this.mTopToTop;
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
                object3 = object;
            }
            if (e2 != null) {
                e2.bottomToTop(object.getKey());
                object.topToBottom(e2.getKey());
            }
            e2 = object;
            object2 = object3;
        }
        if (e2 != null) {
            object = this.mBottomToTop;
            if (object != null) {
                e2.bottomToTop(object);
            } else {
                object = this.mBottomToBottom;
                if (object != null) {
                    e2.bottomToBottom(object);
                } else {
                    e2.bottomToBottom((Object)State.PARENT);
                }
            }
        }
        if (object2 != null && this.mBias != 0.5f) {
            object2.verticalBias(this.mBias);
        }
        if ((n = 1.$SwitchMap$androidx$constraintlayout$solver$state$State$Chain[this.mStyle.ordinal()]) != 1) {
            if (n != 2) {
                if (n != 3) return;
                object2.setVerticalChainStyle(2);
            } else {
                object2.setVerticalChainStyle(1);
            }
        } else {
            object2.setVerticalChainStyle(0);
        }
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
