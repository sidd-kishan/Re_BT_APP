/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.collection.ArrayMap
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionManager
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import java.util.ArrayList;

/*
 * Exception performing whole class analysis ignored.
 */
private static class TransitionManager.MultiListener
implements ViewTreeObserver.OnPreDrawListener,
View.OnAttachStateChangeListener {
    ViewGroup mSceneRoot;
    Transition mTransition;

    TransitionManager.MultiListener(Transition transition, ViewGroup viewGroup) {
        this.mTransition = transition;
        this.mSceneRoot = viewGroup;
    }

    private void removeListeners() {
        this.mSceneRoot.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
        this.mSceneRoot.removeOnAttachStateChangeListener((View.OnAttachStateChangeListener)this);
    }

    public boolean onPreDraw() {
        Object object;
        this.removeListeners();
        if (!TransitionManager.sPendingTransitions.remove(this.mSceneRoot)) {
            return true;
        }
        ArrayMap arrayMap = TransitionManager.getRunningTransitions();
        ArrayList<Transition> arrayList = (ArrayList<Transition>)arrayMap.get((Object)this.mSceneRoot);
        ArrayList arrayList2 = null;
        if (arrayList == null) {
            object = new ArrayList<Transition>();
            arrayMap.put((Object)this.mSceneRoot, object);
        } else {
            object = arrayList;
            if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
                object = arrayList;
            }
        }
        ((ArrayList)object).add(this.mTransition);
        this.mTransition.addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
        this.mTransition.captureValues(this.mSceneRoot, false);
        if (arrayList2 != null) {
            object = arrayList2.iterator();
            while (object.hasNext()) {
                ((Transition)object.next()).resume((View)this.mSceneRoot);
            }
        }
        this.mTransition.playTransition(this.mSceneRoot);
        return true;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View object) {
        this.removeListeners();
        TransitionManager.sPendingTransitions.remove(this.mSceneRoot);
        object = (ArrayList)TransitionManager.getRunningTransitions().get((Object)this.mSceneRoot);
        if (object != null && ((ArrayList)object).size() > 0) {
            object = ((ArrayList)object).iterator();
            while (object.hasNext()) {
                ((Transition)object.next()).resume((View)this.mSceneRoot);
            }
        }
        this.mTransition.clearValues(true);
    }
}
