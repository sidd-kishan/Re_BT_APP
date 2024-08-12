/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.FragmentTransition
 */
package androidx.fragment.app;

import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentTransition;
import java.util.ArrayList;

class DefaultSpecialEffectsController.8
implements Runnable {
    final DefaultSpecialEffectsController this$0;
    final ArrayList val$transitioningViews;

    DefaultSpecialEffectsController.8(DefaultSpecialEffectsController defaultSpecialEffectsController, ArrayList arrayList) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$transitioningViews = arrayList;
    }

    @Override
    public void run() {
        FragmentTransition.setViewVisibility((ArrayList)this.val$transitioningViews, (int)4);
    }
}
