/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.solver.state.HelperReference
 *  androidx.constraintlayout.solver.state.State
 *  androidx.constraintlayout.solver.state.State$Direction
 *  androidx.constraintlayout.solver.state.State$Helper
 *  androidx.constraintlayout.solver.state.helpers.BarrierReference$1
 *  androidx.constraintlayout.solver.widgets.Barrier
 *  androidx.constraintlayout.solver.widgets.HelperWidget
 */
package androidx.constraintlayout.solver.state.helpers;

import androidx.constraintlayout.solver.state.HelperReference;
import androidx.constraintlayout.solver.state.State;
import androidx.constraintlayout.solver.state.helpers.BarrierReference;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.HelperWidget;

public class BarrierReference
extends HelperReference {
    private Barrier mBarrierWidget;
    private State.Direction mDirection;
    private int mMargin;

    public BarrierReference(State state) {
        super(state, State.Helper.BARRIER);
    }

    public void apply() {
        int n;
        this.getHelperWidget();
        int n2 = 1.$SwitchMap$androidx$constraintlayout$solver$state$State$Direction[this.mDirection.ordinal()];
        int n3 = n = 0;
        switch (n2) {
            default: {
                n3 = n;
                break;
            }
            case 6: {
                n3 = 3;
                break;
            }
            case 5: {
                n3 = 2;
                break;
            }
            case 3: 
            case 4: {
                n3 = 1;
                break;
            }
            case 1: 
            case 2: 
        }
        this.mBarrierWidget.setBarrierType(n3);
        this.mBarrierWidget.setMargin(this.mMargin);
    }

    public HelperWidget getHelperWidget() {
        if (this.mBarrierWidget != null) return this.mBarrierWidget;
        this.mBarrierWidget = new Barrier();
        return this.mBarrierWidget;
    }

    public void margin(int n) {
        this.mMargin = n;
    }

    public void margin(Object object) {
        this.margin(this.mState.convertDimension(object));
    }

    public void setBarrierDirection(State.Direction direction) {
        this.mDirection = direction;
    }
}
