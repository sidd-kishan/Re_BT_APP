/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.DefaultItemAnimator
 *  androidx.recyclerview.widget.RecyclerView$ViewHolder
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator.3
implements Runnable {
    final DefaultItemAnimator this$0;
    final ArrayList val$additions;

    DefaultItemAnimator.3(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$additions = arrayList;
    }

    @Override
    public void run() {
        Iterator iterator = this.val$additions.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.val$additions.clear();
                this.this$0.mAdditionsList.remove(this.val$additions);
                return;
            }
            RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder)iterator.next();
            this.this$0.animateAddImpl(viewHolder);
        }
    }
}
