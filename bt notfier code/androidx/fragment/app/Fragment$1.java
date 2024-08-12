/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;

class Fragment.1
implements Runnable {
    final Fragment this$0;

    Fragment.1(Fragment fragment) {
        this.this$0 = fragment;
    }

    @Override
    public void run() {
        this.this$0.startPostponedEnterTransition();
    }
}
