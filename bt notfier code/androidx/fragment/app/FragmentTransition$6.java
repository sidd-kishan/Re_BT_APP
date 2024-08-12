/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  androidx.collection.ArrayMap
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.FragmentTransition$FragmentContainerTransition
 *  androidx.fragment.app.FragmentTransitionImpl
 */
package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentTransition.6
implements Runnable {
    final Object val$enterTransition;
    final Object val$finalSharedElementTransition;
    final FragmentTransition.FragmentContainerTransition val$fragments;
    final FragmentTransitionImpl val$impl;
    final Rect val$inEpicenter;
    final Fragment val$inFragment;
    final boolean val$inIsPop;
    final ArrayMap val$nameOverrides;
    final View val$nonExistentView;
    final Fragment val$outFragment;
    final ArrayList val$sharedElementsIn;
    final ArrayList val$sharedElementsOut;

    FragmentTransition.6(FragmentTransitionImpl fragmentTransitionImpl, ArrayMap arrayMap, Object object, FragmentTransition.FragmentContainerTransition fragmentContainerTransition, ArrayList arrayList, View view, Fragment fragment, Fragment fragment2, boolean bl, ArrayList arrayList2, Object object2, Rect rect) {
        this.val$impl = fragmentTransitionImpl;
        this.val$nameOverrides = arrayMap;
        this.val$finalSharedElementTransition = object;
        this.val$fragments = fragmentContainerTransition;
        this.val$sharedElementsIn = arrayList;
        this.val$nonExistentView = view;
        this.val$inFragment = fragment;
        this.val$outFragment = fragment2;
        this.val$inIsPop = bl;
        this.val$sharedElementsOut = arrayList2;
        this.val$enterTransition = object2;
        this.val$inEpicenter = rect;
    }

    @Override
    public void run() {
        ArrayMap arrayMap = FragmentTransition.captureInSharedElements((FragmentTransitionImpl)this.val$impl, (ArrayMap)this.val$nameOverrides, (Object)this.val$finalSharedElementTransition, (FragmentTransition.FragmentContainerTransition)this.val$fragments);
        if (arrayMap != null) {
            this.val$sharedElementsIn.addAll(arrayMap.values());
            this.val$sharedElementsIn.add(this.val$nonExistentView);
        }
        FragmentTransition.callSharedElementStartEnd((Fragment)this.val$inFragment, (Fragment)this.val$outFragment, (boolean)this.val$inIsPop, (ArrayMap)arrayMap, (boolean)false);
        Object object = this.val$finalSharedElementTransition;
        if (object == null) return;
        this.val$impl.swapSharedElementTargets(object, this.val$sharedElementsOut, this.val$sharedElementsIn);
        arrayMap = FragmentTransition.getInEpicenterView((ArrayMap)arrayMap, (FragmentTransition.FragmentContainerTransition)this.val$fragments, (Object)this.val$enterTransition, (boolean)this.val$inIsPop);
        if (arrayMap == null) return;
        this.val$impl.getBoundsOnScreen((View)arrayMap, this.val$inEpicenter);
    }
}
