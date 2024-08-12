/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.fragment.app.ListFragment
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.ListFragment;

class ListFragment.1
implements Runnable {
    final ListFragment this$0;

    ListFragment.1(ListFragment listFragment) {
        this.this$0 = listFragment;
    }

    @Override
    public void run() {
        this.this$0.mList.focusableViewAvailable((View)this.this$0.mList);
    }
}
