/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentTransitionImpl
 *  androidx.transition.Transition
 *  androidx.transition.Transition$EpicenterCallback
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionManager
 *  androidx.transition.TransitionSet
 */
package androidx.transition;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import java.util.ArrayList;
import java.util.List;

public class FragmentTransitionSupport
extends FragmentTransitionImpl {
    private static boolean hasSimpleTarget(Transition transition) {
        boolean bl = !(FragmentTransitionSupport.isNullOrEmpty((List)transition.getTargetIds()) && FragmentTransitionSupport.isNullOrEmpty((List)transition.getTargetNames()) && FragmentTransitionSupport.isNullOrEmpty((List)transition.getTargetTypes()));
        return bl;
    }

    public void addTarget(Object object, View view) {
        if (object == null) return;
        ((Transition)object).addTarget(view);
    }

    public void addTargets(Object object, ArrayList<View> arrayList) {
        if ((object = (Transition)object) == null) {
            return;
        }
        boolean bl = object instanceof TransitionSet;
        int n = 0;
        int n2 = 0;
        if (bl) {
            object = (TransitionSet)object;
            n = object.getTransitionCount();
            while (n2 < n) {
                this.addTargets(object.getTransitionAt(n2), arrayList);
                ++n2;
            }
            return;
        }
        if (FragmentTransitionSupport.hasSimpleTarget((Transition)object)) return;
        if (!FragmentTransitionSupport.isNullOrEmpty((List)object.getTargets())) return;
        int n3 = arrayList.size();
        n2 = n;
        while (n2 < n3) {
            object.addTarget(arrayList.get(n2));
            ++n2;
        }
    }

    public void beginDelayedTransition(ViewGroup viewGroup, Object object) {
        TransitionManager.beginDelayedTransition((ViewGroup)viewGroup, (Transition)((Transition)object));
    }

    public boolean canHandle(Object object) {
        return object instanceof Transition;
    }

    public Object cloneTransition(Object object) {
        object = object != null ? ((Transition)object).clone() : null;
        return object;
    }

    public Object mergeTransitionsInSequence(Object object, Object object2, Object object3) {
        object = (Transition)object;
        object2 = (Transition)object2;
        object3 = (Transition)object3;
        if (object != null && object2 != null) {
            object = new TransitionSet().addTransition((Transition)object).addTransition((Transition)object2).setOrdering(1);
        } else if (object == null) {
            object = object2 != null ? object2 : null;
        }
        if (object3 == null) return object;
        object2 = new TransitionSet();
        if (object != null) {
            object2.addTransition((Transition)object);
        }
        object2.addTransition((Transition)object3);
        return object2;
    }

    public Object mergeTransitionsTogether(Object object, Object object2, Object object3) {
        TransitionSet transitionSet = new TransitionSet();
        if (object != null) {
            transitionSet.addTransition((Transition)object);
        }
        if (object2 != null) {
            transitionSet.addTransition((Transition)object2);
        }
        if (object3 == null) return transitionSet;
        transitionSet.addTransition((Transition)object3);
        return transitionSet;
    }

    public void removeTarget(Object object, View view) {
        if (object == null) return;
        ((Transition)object).removeTarget(view);
    }

    public void replaceTargets(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int n;
        Transition transition = (Transition)object;
        boolean bl = transition instanceof TransitionSet;
        int n2 = 0;
        if (bl) {
            object = (TransitionSet)transition;
            n = object.getTransitionCount();
            while (n2 < n) {
                this.replaceTargets(object.getTransitionAt(n2), arrayList, arrayList2);
                ++n2;
            }
            return;
        }
        if (FragmentTransitionSupport.hasSimpleTarget(transition)) return;
        object = transition.getTargets();
        if (object.size() != arrayList.size()) return;
        if (!object.containsAll(arrayList)) return;
        n2 = arrayList2 == null ? 0 : arrayList2.size();
        for (n = 0; n < n2; ++n) {
            transition.addTarget(arrayList2.get(n));
        }
        n2 = arrayList.size() - 1;
        while (n2 >= 0) {
            transition.removeTarget(arrayList.get(n2));
            --n2;
        }
    }

    public void scheduleHideFragmentView(Object object, View view, ArrayList<View> arrayList) {
        ((Transition)object).addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void scheduleRemoveTargets(Object object, Object object2, ArrayList<View> arrayList, Object object3, ArrayList<View> arrayList2, Object object4, ArrayList<View> arrayList3) {
        ((Transition)object).addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setEpicenter(Object object, Rect rect) {
        if (object == null) return;
        ((Transition)object).setEpicenterCallback((Transition.EpicenterCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setEpicenter(Object object, View view) {
        if (view == null) return;
        object = (Transition)object;
        Rect rect = new Rect();
        this.getBoundsOnScreen(view, rect);
        object.setEpicenterCallback((Transition.EpicenterCallback)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setListenerForTransitionEnd(Fragment fragment, Object object, CancellationSignal cancellationSignal, Runnable runnable) {
        fragment = (Transition)object;
        cancellationSignal.setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
        fragment.addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    public void setSharedElementTargets(Object object, View view, ArrayList<View> arrayList) {
        object = (TransitionSet)object;
        List list = object.getTargets();
        list.clear();
        int n = arrayList.size();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                list.add(view);
                arrayList.add(view);
                this.addTargets(object, arrayList);
                return;
            }
            FragmentTransitionSupport.bfsAddViewChildren((List)list, (View)arrayList.get(n2));
            ++n2;
        }
    }

    public void swapSharedElementTargets(Object object, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if ((object = (TransitionSet)object) == null) return;
        object.getTargets().clear();
        object.getTargets().addAll(arrayList2);
        this.replaceTargets(object, arrayList, arrayList2);
    }

    public Object wrapTransitionInSet(Object object) {
        if (object == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition)object);
        return transitionSet;
    }
}
