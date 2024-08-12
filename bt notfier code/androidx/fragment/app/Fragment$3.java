/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.SpecialEffectsController
 */
package androidx.fragment.app;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.SpecialEffectsController;

class Fragment.3
implements Runnable {
    final Fragment this$0;
    final SpecialEffectsController val$controller;

    Fragment.3(Fragment fragment, SpecialEffectsController specialEffectsController) {
        this.this$0 = fragment;
        this.val$controller = specialEffectsController;
    }

    @Override
    public void run() {
        this.val$controller.executePendingOperations();
    }
}
