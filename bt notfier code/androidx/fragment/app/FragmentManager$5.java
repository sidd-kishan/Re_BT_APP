/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.FragmentManager
 */
package androidx.fragment.app;

import androidx.fragment.app.FragmentManager;

class FragmentManager.5
implements Runnable {
    final FragmentManager this$0;

    FragmentManager.5(FragmentManager fragmentManager) {
        this.this$0 = fragmentManager;
    }

    @Override
    public void run() {
        this.this$0.execPendingActions(true);
    }
}
