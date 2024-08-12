/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.work.impl.constraints.ConstraintListener
 *  androidx.work.impl.constraints.trackers.ConstraintTracker
 */
package androidx.work.impl.constraints.trackers;

import androidx.work.impl.constraints.ConstraintListener;
import androidx.work.impl.constraints.trackers.ConstraintTracker;
import java.util.Iterator;
import java.util.List;

class ConstraintTracker.1
implements Runnable {
    final ConstraintTracker this$0;
    final List val$listenersList;

    ConstraintTracker.1(ConstraintTracker constraintTracker, List list) {
        this.this$0 = constraintTracker;
        this.val$listenersList = list;
    }

    @Override
    public void run() {
        Iterator iterator = this.val$listenersList.iterator();
        while (iterator.hasNext()) {
            ((ConstraintListener)iterator.next()).onConstraintChanged(this.this$0.mCurrentState);
        }
    }
}
