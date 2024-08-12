/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.collection.ArrayMap
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.FragmentTransitionImpl
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentTransition.5
implements Runnable {
    final Rect val$epicenter;
    final View val$epicenterView;
    final FragmentTransitionImpl val$impl;
    final Fragment val$inFragment;
    final boolean val$inIsPop;
    final ArrayMap val$inSharedElements;
    final Fragment val$outFragment;

    FragmentTransition.5(Fragment fragment, Fragment fragment2, boolean bl, ArrayMap arrayMap, View view, FragmentTransitionImpl fragmentTransitionImpl, Rect rect) {
        this.val$inFragment = fragment;
        this.val$outFragment = fragment2;
        this.val$inIsPop = bl;
        this.val$inSharedElements = arrayMap;
        this.val$epicenterView = view;
        this.val$impl = fragmentTransitionImpl;
        this.val$epicenter = rect;
    }

    @Override
    public void run() {
        FragmentTransition.callSharedElementStartEnd((Fragment)this.val$inFragment, (Fragment)this.val$outFragment, (boolean)this.val$inIsPop, (ArrayMap)this.val$inSharedElements, (boolean)false);
        View view = this.val$epicenterView;
        if (view == null) return;
        this.val$impl.getBoundsOnScreen(view, this.val$epicenter);
    }
}
