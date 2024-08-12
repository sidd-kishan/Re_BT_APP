/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  androidx.collection.ArrayMap
 *  androidx.core.view.ViewCompat
 *  androidx.transition.AutoTransition
 *  androidx.transition.Scene
 *  androidx.transition.Transition
 *  androidx.transition.TransitionManager$MultiListener
 */
package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Scene;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";
    private static Transition sDefaultTransition = new AutoTransition();
    static ArrayList<ViewGroup> sPendingTransitions;
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions;
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions;
    private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap();

    static {
        sRunningTransitions = new ThreadLocal();
        sPendingTransitions = new ArrayList();
    }

    public TransitionManager() {
        this.mScenePairTransitions = new ArrayMap();
    }

    public static void beginDelayedTransition(ViewGroup viewGroup) {
        TransitionManager.beginDelayedTransition(viewGroup, null);
    }

    public static void beginDelayedTransition(ViewGroup viewGroup, Transition transition) {
        if (sPendingTransitions.contains(viewGroup)) return;
        if (!ViewCompat.isLaidOut((View)viewGroup)) return;
        sPendingTransitions.add(viewGroup);
        Transition transition2 = transition;
        if (transition == null) {
            transition2 = sDefaultTransition;
        }
        transition = transition2.clone();
        TransitionManager.sceneChangeSetup(viewGroup, transition);
        Scene.setCurrentScene((ViewGroup)viewGroup, null);
        TransitionManager.sceneChangeRunTransition(viewGroup, transition);
    }

    private static void changeScene(Scene scene, Transition transition) {
        ViewGroup viewGroup = scene.getSceneRoot();
        if (sPendingTransitions.contains(viewGroup)) return;
        Scene scene2 = Scene.getCurrentScene((ViewGroup)viewGroup);
        if (transition == null) {
            if (scene2 != null) {
                scene2.exit();
            }
            scene.enter();
        } else {
            sPendingTransitions.add(viewGroup);
            transition = transition.clone();
            if (scene2 != null && scene2.isCreatedFromLayoutResource()) {
                transition.setCanRemoveViews(true);
            }
            TransitionManager.sceneChangeSetup(viewGroup, transition);
            scene.enter();
            TransitionManager.sceneChangeRunTransition(viewGroup, transition);
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        sPendingTransitions.remove(viewGroup);
        ArrayList arrayList = (ArrayList)TransitionManager.getRunningTransitions().get((Object)viewGroup);
        if (arrayList == null) return;
        if (arrayList.isEmpty()) return;
        arrayList = new ArrayList(arrayList);
        int n = arrayList.size() - 1;
        while (n >= 0) {
            ((Transition)arrayList.get(n)).forceToEnd(viewGroup);
            --n;
        }
    }

    static ArrayMap<ViewGroup, ArrayList<Transition>> getRunningTransitions() {
        Object object = sRunningTransitions.get();
        if (object != null && (object = (ArrayMap)object.get()) != null) {
            return object;
        }
        ArrayMap arrayMap = new ArrayMap();
        object = new WeakReference<ArrayMap>(arrayMap);
        sRunningTransitions.set((WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>)object);
        return arrayMap;
    }

    private Transition getTransition(Scene scene) {
        ArrayMap arrayMap;
        ViewGroup viewGroup = scene.getSceneRoot();
        if (viewGroup != null && (viewGroup = Scene.getCurrentScene((ViewGroup)viewGroup)) != null && (arrayMap = (ArrayMap)this.mScenePairTransitions.get((Object)scene)) != null && (viewGroup = (Transition)arrayMap.get((Object)viewGroup)) != null) {
            return viewGroup;
        }
        if ((scene = (Transition)this.mSceneTransitions.get((Object)scene)) != null) return scene;
        scene = sDefaultTransition;
        return scene;
    }

    public static void go(Scene scene) {
        TransitionManager.changeScene(scene, sDefaultTransition);
    }

    public static void go(Scene scene, Transition transition) {
        TransitionManager.changeScene(scene, transition);
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        if (transition == null) return;
        if (viewGroup == null) return;
        transition = new MultiListener(transition, viewGroup);
        viewGroup.addOnAttachStateChangeListener((View.OnAttachStateChangeListener)transition);
        viewGroup.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)transition);
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
        Object object = (ArrayList)TransitionManager.getRunningTransitions().get((Object)viewGroup);
        if (object != null && ((ArrayList)object).size() > 0) {
            object = ((ArrayList)object).iterator();
            while (object.hasNext()) {
                ((Transition)object.next()).pause((View)viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        if ((viewGroup = Scene.getCurrentScene((ViewGroup)viewGroup)) == null) return;
        viewGroup.exit();
    }

    public void setTransition(Scene scene, Scene scene2, Transition transition) {
        ArrayMap arrayMap;
        ArrayMap arrayMap2 = arrayMap = (ArrayMap)this.mScenePairTransitions.get((Object)scene2);
        if (arrayMap == null) {
            arrayMap2 = new ArrayMap();
            this.mScenePairTransitions.put((Object)scene2, (Object)arrayMap2);
        }
        arrayMap2.put((Object)scene, (Object)transition);
    }

    public void setTransition(Scene scene, Transition transition) {
        this.mSceneTransitions.put((Object)scene, (Object)transition);
    }

    public void transitionTo(Scene scene) {
        TransitionManager.changeScene(scene, this.getTransition(scene));
    }
}
