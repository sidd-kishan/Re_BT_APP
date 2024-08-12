/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.util.StateSet
 *  androidx.appcompat.graphics.drawable.DrawableContainer
 *  androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState
 *  androidx.appcompat.graphics.drawable.StateListDrawable
 */
package androidx.appcompat.graphics.drawable;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;
import androidx.appcompat.graphics.drawable.DrawableContainer;
import androidx.appcompat.graphics.drawable.StateListDrawable;

static class StateListDrawable.StateListState
extends DrawableContainer.DrawableContainerState {
    int[][] mStateSets;

    StateListDrawable.StateListState(StateListDrawable.StateListState stateListState, StateListDrawable stateListDrawable, Resources resources) {
        super((DrawableContainer.DrawableContainerState)stateListState, (DrawableContainer)stateListDrawable, resources);
        this.mStateSets = stateListState != null ? stateListState.mStateSets : (int[][])new int[this.getCapacity()][];
    }

    int addStateSet(int[] nArray, Drawable drawable) {
        int n = this.addChild(drawable);
        this.mStateSets[n] = nArray;
        return n;
    }

    public void growArray(int n, int n2) {
        super.growArray(n, n2);
        int[][] nArrayArray = new int[n2][];
        System.arraycopy(this.mStateSets, 0, nArrayArray, 0, n);
        this.mStateSets = nArrayArray;
    }

    int indexOfStateSet(int[] nArray) {
        int[][] nArray2 = this.mStateSets;
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            if (StateSet.stateSetMatches((int[])nArray2[n2], (int[])nArray)) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    void mutate() {
        Object object = this.mStateSets;
        int[][] nArrayArray = new int[((int[][])object).length][];
        int n = ((int[][])object).length - 1;
        while (true) {
            if (n < 0) {
                this.mStateSets = nArrayArray;
                return;
            }
            object = this.mStateSets;
            object = object[n] != null ? (Object)((int[])object[n].clone()) : null;
            nArrayArray[n] = (int[])object;
            --n;
        }
    }

    public Drawable newDrawable() {
        return new StateListDrawable(this, null);
    }

    public Drawable newDrawable(Resources resources) {
        return new StateListDrawable(this, resources);
    }
}
