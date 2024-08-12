/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.constraints.ConstraintListener
 *  androidx.work.impl.constraints.controllers.ConstraintController$OnConstraintUpdatedCallback
 *  androidx.work.impl.constraints.trackers.ConstraintTracker
 *  androidx.work.impl.model.WorkSpec
 */
package androidx.work.impl.constraints.controllers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.List;

public abstract class ConstraintController<T>
implements ConstraintListener<T> {
    private OnConstraintUpdatedCallback mCallback;
    private T mCurrentValue;
    private final List<String> mMatchingWorkSpecIds = new ArrayList<String>();
    private ConstraintTracker<T> mTracker;

    ConstraintController(ConstraintTracker<T> constraintTracker) {
        this.mTracker = constraintTracker;
    }

    private void updateCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback, T t) {
        if (this.mMatchingWorkSpecIds.isEmpty()) return;
        if (onConstraintUpdatedCallback == null) return;
        if (t != null && !this.isConstrained(t)) {
            onConstraintUpdatedCallback.onConstraintMet(this.mMatchingWorkSpecIds);
        } else {
            onConstraintUpdatedCallback.onConstraintNotMet(this.mMatchingWorkSpecIds);
        }
    }

    abstract boolean hasConstraint(WorkSpec var1);

    abstract boolean isConstrained(T var1);

    public boolean isWorkSpecConstrained(String string) {
        T t = this.mCurrentValue;
        boolean bl = t != null && this.isConstrained(t) && this.mMatchingWorkSpecIds.contains(string);
        return bl;
    }

    public void onConstraintChanged(T t) {
        this.mCurrentValue = t;
        this.updateCallback(this.mCallback, t);
    }

    public void replace(Iterable<WorkSpec> object) {
        this.mMatchingWorkSpecIds.clear();
        object = object.iterator();
        while (object.hasNext()) {
            WorkSpec workSpec = (WorkSpec)object.next();
            if (!this.hasConstraint(workSpec)) continue;
            this.mMatchingWorkSpecIds.add(workSpec.id);
        }
        if (this.mMatchingWorkSpecIds.isEmpty()) {
            this.mTracker.removeListener((ConstraintListener)this);
        } else {
            this.mTracker.addListener((ConstraintListener)this);
        }
        this.updateCallback(this.mCallback, this.mCurrentValue);
    }

    public void reset() {
        if (this.mMatchingWorkSpecIds.isEmpty()) return;
        this.mMatchingWorkSpecIds.clear();
        this.mTracker.removeListener((ConstraintListener)this);
    }

    public void setCallback(OnConstraintUpdatedCallback onConstraintUpdatedCallback) {
        if (this.mCallback == onConstraintUpdatedCallback) return;
        this.mCallback = onConstraintUpdatedCallback;
        this.updateCallback(onConstraintUpdatedCallback, this.mCurrentValue);
    }
}
