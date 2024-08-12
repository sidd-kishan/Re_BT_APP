/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.GapWorker$Task
 *  androidx.recyclerview.widget.RecyclerView
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;

class GapWorker.1
implements Comparator<GapWorker.Task> {
    GapWorker.1() {
    }

    @Override
    public int compare(GapWorker.Task task, GapWorker.Task task2) {
        int n;
        RecyclerView recyclerView = task.view;
        int n2 = 1;
        int n3 = 1;
        int n4 = recyclerView == null ? 1 : 0;
        if (n4 != (n = task2.view == null)) {
            n4 = task.view == null ? n3 : -1;
            return n4;
        }
        if (task.immediate != task2.immediate) {
            n4 = n2;
            if (!task.immediate) return n4;
            n4 = -1;
            return n4;
        }
        n4 = task2.viewVelocity - task.viewVelocity;
        if (n4 != 0) {
            return n4;
        }
        n4 = task.distanceToItem - task2.distanceToItem;
        if (n4 == 0) return 0;
        return n4;
    }
}
