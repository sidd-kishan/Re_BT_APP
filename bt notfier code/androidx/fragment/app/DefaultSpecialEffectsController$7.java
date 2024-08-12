/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.fragment.app.DefaultSpecialEffectsController
 *  androidx.fragment.app.FragmentTransitionImpl
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.FragmentTransitionImpl;

class DefaultSpecialEffectsController.7
implements Runnable {
    final DefaultSpecialEffectsController this$0;
    final FragmentTransitionImpl val$impl;
    final Rect val$lastInEpicenterRect;
    final View val$lastInEpicenterView;

    DefaultSpecialEffectsController.7(DefaultSpecialEffectsController defaultSpecialEffectsController, FragmentTransitionImpl fragmentTransitionImpl, View view, Rect rect) {
        this.this$0 = defaultSpecialEffectsController;
        this.val$impl = fragmentTransitionImpl;
        this.val$lastInEpicenterView = view;
        this.val$lastInEpicenterRect = rect;
    }

    @Override
    public void run() {
        this.val$impl.getBoundsOnScreen(this.val$lastInEpicenterView, this.val$lastInEpicenterRect);
    }
}
