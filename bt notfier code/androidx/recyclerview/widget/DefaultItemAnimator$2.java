/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.recyclerview.widget.DefaultItemAnimator
 *  androidx.recyclerview.widget.DefaultItemAnimator$ChangeInfo
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DefaultItemAnimator;
import java.util.ArrayList;
import java.util.Iterator;

class DefaultItemAnimator.2
implements Runnable {
    final DefaultItemAnimator this$0;
    final ArrayList val$changes;

    DefaultItemAnimator.2(DefaultItemAnimator defaultItemAnimator, ArrayList arrayList) {
        this.this$0 = defaultItemAnimator;
        this.val$changes = arrayList;
    }

    @Override
    public void run() {
        Iterator iterator = this.val$changes.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.val$changes.clear();
                this.this$0.mChangesList.remove(this.val$changes);
                return;
            }
            DefaultItemAnimator.ChangeInfo changeInfo = (DefaultItemAnimator.ChangeInfo)iterator.next();
            this.this$0.animateChangeImpl(changeInfo);
        }
    }
}
