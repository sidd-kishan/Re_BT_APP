/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.FragmentTransitionImpl
 */
package androidx.fragment.app;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
class FragmentTransition.4
implements Runnable {
    final Object val$enterTransition;
    final ArrayList val$enteringViews;
    final Object val$exitTransition;
    final ArrayList val$exitingViews;
    final FragmentTransitionImpl val$impl;
    final Fragment val$inFragment;
    final View val$nonExistentView;
    final ArrayList val$sharedElementsIn;

    FragmentTransition.4(Object object, FragmentTransitionImpl fragmentTransitionImpl, View view, Fragment fragment, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, Object object2) {
        this.val$enterTransition = object;
        this.val$impl = fragmentTransitionImpl;
        this.val$nonExistentView = view;
        this.val$inFragment = fragment;
        this.val$sharedElementsIn = arrayList;
        this.val$enteringViews = arrayList2;
        this.val$exitingViews = arrayList3;
        this.val$exitTransition = object2;
    }

    @Override
    public void run() {
        ArrayList arrayList = this.val$enterTransition;
        if (arrayList != null) {
            this.val$impl.removeTarget((Object)arrayList, this.val$nonExistentView);
            arrayList = FragmentTransition.configureEnteringExitingViews((FragmentTransitionImpl)this.val$impl, (Object)this.val$enterTransition, (Fragment)this.val$inFragment, (ArrayList)this.val$sharedElementsIn, (View)this.val$nonExistentView);
            this.val$enteringViews.addAll(arrayList);
        }
        if (this.val$exitingViews == null) return;
        if (this.val$exitTransition != null) {
            arrayList = new ArrayList();
            arrayList.add(this.val$nonExistentView);
            this.val$impl.replaceTargets(this.val$exitTransition, this.val$exitingViews, arrayList);
        }
        this.val$exitingViews.clear();
        this.val$exitingViews.add(this.val$nonExistentView);
    }
}
