/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.StaggeredGridLayoutManager
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

class StaggeredGridLayoutManager.1
implements Runnable {
    final StaggeredGridLayoutManager this$0;

    StaggeredGridLayoutManager.1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
    }

    @Override
    public void run() {
        this.this$0.checkForGaps();
    }
}
