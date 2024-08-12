/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.collection.ArrayMap
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.SpecialEffectsController$Operation
 */
package androidx.fragment.app;

import androidx.collection.ArrayMap;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.SpecialEffectsController;

class DefaultSpecialEffectsController.6
implements Runnable {
    final DefaultSpecialEffectsController this$0;
    final SpecialEffectsController.Operation val$firstOut;
    final boolean val$isPop;
    final SpecialEffectsController.Operation val$lastIn;
    final ArrayMap val$lastInViews;

    DefaultSpecialEffectsController.6(DefaultSpecialEffectsController defaultSpecialEffectsController, SpecialEffectsController.Operation operation, SpecialEffectsController.Operation operation2, boolean bl, ArrayMap arrayMap) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$lastIn = operation;
        this.val$firstOut = operation2;
        this.val$isPop = bl;
        this.val$lastInViews = arrayMap;
    }

    @Override
    public void run() {
        FragmentTransition.callSharedElementStartEnd((Fragment)this.val$lastIn.getFragment(), (Fragment)this.val$firstOut.getFragment(), (boolean)this.val$isPop, (ArrayMap)this.val$lastInViews, (boolean)false);
    }
}
