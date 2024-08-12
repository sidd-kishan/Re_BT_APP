/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.Animation$AnimationListener
 *  androidx.collection.ArrayMap
 *  androidx.core.os.CancellationSignal
 *  androidx.core.os.CancellationSignal$OnCancelListener
 *  androidx.core.util.Preconditions
 *  androidx.core.view.OneShotPreDrawListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.ViewGroupCompat
 *  androidx.fragment.app.DefaultSpecialEffectsController$10
 *  androidx.fragment.app.DefaultSpecialEffectsController$AnimationInfo
 *  androidx.fragment.app.DefaultSpecialEffectsController$TransitionInfo
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentAnim$AnimationOrAnimator
 *  androidx.fragment.app.FragmentAnim$EndViewTransitionAnimation
 *  androidx.fragment.app.FragmentManager
 *  androidx.fragment.app.FragmentTransition
 *  androidx.fragment.app.FragmentTransitionImpl
 *  androidx.fragment.app.SpecialEffectsController
 *  androidx.fragment.app.SpecialEffectsController$Operation
 *  androidx.fragment.app.SpecialEffectsController$Operation$State
 */
package androidx.fragment.app;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class DefaultSpecialEffectsController
extends SpecialEffectsController {
    DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(List<AnimationInfo> animationInfo, List<SpecialEffectsController.Operation> object, boolean bl, Map<SpecialEffectsController.Operation, Boolean> object2) {
        ViewGroup viewGroup = this.getContainer();
        Context context = viewGroup.getContext();
        Fragment fragment = new ArrayList();
        Animation animation = animationInfo.iterator();
        boolean bl2 = false;
        while (animation.hasNext()) {
            animationInfo = animation.next();
            if (animationInfo.isVisibilityUnchanged()) {
                animationInfo.completeSpecialEffect();
                continue;
            }
            FragmentAnim.AnimationOrAnimator animationOrAnimator = animationInfo.getAnimation(context);
            if (animationOrAnimator == null) {
                animationInfo.completeSpecialEffect();
                continue;
            }
            Object object3 = animationOrAnimator.animator;
            if (object3 == null) {
                fragment.add(animationInfo);
                continue;
            }
            SpecialEffectsController.Operation operation = animationInfo.getOperation();
            animationOrAnimator = operation.getFragment();
            if (Boolean.TRUE.equals(object2.get(operation))) {
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Ignoring Animator set on ");
                    ((StringBuilder)object3).append(animationOrAnimator);
                    ((StringBuilder)object3).append(" as this Fragment was involved in a Transition.");
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object3).toString());
                }
                animationInfo.completeSpecialEffect();
                continue;
            }
            boolean bl3 = operation.getFinalState() == SpecialEffectsController.Operation.State.GONE;
            if (bl3) {
                object.remove(operation);
            }
            animationOrAnimator = animationOrAnimator.mView;
            viewGroup.startViewTransition((View)animationOrAnimator);
            object3.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            object3.setTarget((Object)animationOrAnimator);
            object3.start();
            animationInfo.getSignal().setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
            bl2 = true;
        }
        object = fragment.iterator();
        while (object.hasNext()) {
            animationInfo = (AnimationInfo)object.next();
            object2 = animationInfo.getOperation();
            fragment = object2.getFragment();
            if (bl) {
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Ignoring Animation set on ");
                    ((StringBuilder)object2).append(fragment);
                    ((StringBuilder)object2).append(" as Animations cannot run alongside Transitions.");
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
                }
                animationInfo.completeSpecialEffect();
                continue;
            }
            if (bl2) {
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Ignoring Animation set on ");
                    ((StringBuilder)object2).append(fragment);
                    ((StringBuilder)object2).append(" as Animations cannot run alongside Animators.");
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object2).toString());
                }
                animationInfo.completeSpecialEffect();
                continue;
            }
            fragment = fragment.mView;
            animation = (Animation)Preconditions.checkNotNull((Object)((FragmentAnim.AnimationOrAnimator)Preconditions.checkNotNull((Object)animationInfo.getAnimation((Context)context))).animation);
            if (object2.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                fragment.startAnimation(animation);
                animationInfo.completeSpecialEffect();
            } else {
                viewGroup.startViewTransition((View)fragment);
                object2 = new FragmentAnim.EndViewTransitionAnimation(animation, viewGroup, (View)fragment);
                object2.setAnimationListener((Animation.AnimationListener)new /* Unavailable Anonymous Inner Class!! */);
                fragment.startAnimation((Animation)object2);
            }
            animationInfo.getSignal().setOnCancelListener((CancellationSignal.OnCancelListener)new /* Unavailable Anonymous Inner Class!! */);
        }
    }

    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> object, List<SpecialEffectsController.Operation> object2, boolean bl, SpecialEffectsController.Operation object3, SpecialEffectsController.Operation object4) {
        Object object5;
        ArrayMap arrayMap;
        ArrayList arrayList;
        int n;
        Object object6;
        Object object7;
        DefaultSpecialEffectsController defaultSpecialEffectsController = this;
        Object object8 = object3;
        Object object9 = object4;
        Object object10 = new HashMap();
        Object object11 = object.iterator();
        FragmentTransitionImpl fragmentTransitionImpl = null;
        while (object11.hasNext()) {
            object7 = object11.next();
            if (object7.isVisibilityUnchanged()) continue;
            object6 = object7.getHandlingImpl();
            if (fragmentTransitionImpl == null) {
                fragmentTransitionImpl = object6;
                continue;
            }
            if (object6 == null || fragmentTransitionImpl == object6) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            ((StringBuilder)object).append(object7.getOperation().getFragment());
            ((StringBuilder)object).append(" returned Transition ");
            ((StringBuilder)object).append(object7.getTransition());
            ((StringBuilder)object).append(" which uses a different Transition  type than other Fragments.");
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        if (fragmentTransitionImpl == null) {
            object = object.iterator();
            while (object.hasNext()) {
                object2 = (TransitionInfo)object.next();
                object10.put((SpecialEffectsController.Operation)object2.getOperation(), false);
                object2.completeSpecialEffect();
            }
            return object10;
        }
        Object object12 = new View(this.getContainer().getContext());
        Rect rect = new Rect();
        object11 = new ArrayList();
        object7 = new ArrayList();
        ArrayMap arrayMap2 = new ArrayMap();
        Object object13 = object.iterator();
        Object object14 = null;
        object6 = null;
        boolean bl2 = false;
        FragmentTransitionImpl fragmentTransitionImpl2 = fragmentTransitionImpl;
        fragmentTransitionImpl = object12;
        while (true) {
            block44: {
                block43: {
                    block42: {
                        block39: {
                            block40: {
                                block41: {
                                    int n2;
                                    if (!object13.hasNext()) break block39;
                                    object12 = (TransitionInfo)object13.next();
                                    if (!object12.hasSharedElementTransition() || object8 == null || object9 == null) break block40;
                                    object12 = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(object12.getSharedElementTransition()));
                                    object8 = object4.getFragment().getSharedElementSourceNames();
                                    object14 = object3.getFragment().getSharedElementSourceNames();
                                    object9 = object3.getFragment().getSharedElementTargetNames();
                                    for (n = 0; n < ((ArrayList)object9).size(); ++n) {
                                        n2 = ((ArrayList)object8).indexOf(((ArrayList)object9).get(n));
                                        if (n2 == -1) continue;
                                        ((ArrayList)object8).set(n2, ((ArrayList)object14).get(n));
                                    }
                                    arrayList = object4.getFragment().getSharedElementTargetNames();
                                    if (!bl) {
                                        object14 = object3.getFragment().getExitTransitionCallback();
                                        object9 = object4.getFragment().getEnterTransitionCallback();
                                    } else {
                                        object14 = object3.getFragment().getEnterTransitionCallback();
                                        object9 = object4.getFragment().getExitTransitionCallback();
                                    }
                                    n = ((ArrayList)object8).size();
                                    for (n2 = 0; n2 < n; ++n2) {
                                        arrayMap2.put((Object)((String)((ArrayList)object8).get(n2)), (Object)((String)arrayList.get(n2)));
                                    }
                                    arrayMap = new ArrayMap();
                                    defaultSpecialEffectsController.findNamedViews((Map<String, View>)arrayMap, object3.getFragment().mView);
                                    arrayMap.retainAll((Collection)object8);
                                    if (object14 == null) break block41;
                                    object14.onMapSharedElements((List)object8, (Map)arrayMap);
                                    break block42;
                                }
                                arrayMap2.retainAll((Collection)arrayMap.keySet());
                                break block43;
                            }
                            object12 = object9;
                            object9 = fragmentTransitionImpl;
                            object9 = object8;
                            object8 = object12;
                            break block44;
                        }
                        object3 = object6;
                        bl = false;
                        object12 = object7;
                        object4 = object10;
                        object10 = fragmentTransitionImpl;
                        object6 = object11;
                        arrayMap = new ArrayList();
                        object13 = object.iterator();
                        fragmentTransitionImpl = null;
                        arrayList = null;
                        object7 = object3;
                        object11 = object4;
                        object4 = arrayList;
                        object3 = fragmentTransitionImpl;
                        fragmentTransitionImpl = object12;
                        object12 = object13;
                        break;
                    }
                    for (n = ((ArrayList)object8).size() - 1; n >= 0; --n) {
                        object5 = (String)((ArrayList)object8).get(n);
                        object14 = (View)arrayMap.get(object5);
                        if (object14 == null) {
                            arrayMap2.remove(object5);
                            continue;
                        }
                        if (((String)object5).equals(ViewCompat.getTransitionName((View)object14))) continue;
                        object5 = (String)arrayMap2.remove(object5);
                        arrayMap2.put((Object)ViewCompat.getTransitionName((View)object14), object5);
                    }
                }
                object14 = new ArrayMap();
                defaultSpecialEffectsController.findNamedViews((Map<String, View>)object14, object4.getFragment().mView);
                object14.retainAll((Collection)arrayList);
                object14.retainAll(arrayMap2.values());
                if (object9 == null) {
                    FragmentTransition.retainValues((ArrayMap)arrayMap2, (ArrayMap)object14);
                } else {
                    object9.onMapSharedElements((List)arrayList, (Map)object14);
                    for (n = arrayList.size() - 1; n >= 0; --n) {
                        object5 = (String)arrayList.get(n);
                        object9 = (View)object14.get(object5);
                        if (object9 == null) {
                            object9 = FragmentTransition.findKeyForValue((ArrayMap)arrayMap2, (String)object5);
                            if (object9 == null) continue;
                            arrayMap2.remove(object9);
                            continue;
                        }
                        if (((String)object5).equals(ViewCompat.getTransitionName((View)object9)) || (object5 = FragmentTransition.findKeyForValue((ArrayMap)arrayMap2, (String)object5)) == null) continue;
                        arrayMap2.put(object5, (Object)ViewCompat.getTransitionName((View)object9));
                    }
                }
                defaultSpecialEffectsController.retainMatchingViews((ArrayMap<String, View>)arrayMap, arrayMap2.keySet());
                defaultSpecialEffectsController.retainMatchingViews((ArrayMap<String, View>)object14, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    ((ArrayList)object11).clear();
                    ((ArrayList)object7).clear();
                    object8 = fragmentTransitionImpl;
                    object14 = null;
                    object8 = object4;
                    object9 = object3;
                } else {
                    FragmentTransition.callSharedElementStartEnd((Fragment)object4.getFragment(), (Fragment)object3.getFragment(), (boolean)bl, (ArrayMap)arrayMap, (boolean)true);
                    defaultSpecialEffectsController = this.getContainer();
                    OneShotPreDrawListener.add((View)defaultSpecialEffectsController, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
                    ((ArrayList)object11).addAll(arrayMap.values());
                    if (!((ArrayList)object8).isEmpty()) {
                        object6 = (View)arrayMap.get((Object)((String)((ArrayList)object8).get(0)));
                        fragmentTransitionImpl2.setEpicenter(object12, (View)object6);
                    }
                    ((ArrayList)object7).addAll(object14.values());
                    if (!arrayList.isEmpty() && (defaultSpecialEffectsController = (View)object14.get((Object)((String)arrayList.get(0)))) != null) {
                        OneShotPreDrawListener.add((View)this.getContainer(), (Runnable)new /* Unavailable Anonymous Inner Class!! */);
                        bl2 = true;
                    }
                    defaultSpecialEffectsController = this;
                    fragmentTransitionImpl2.setSharedElementTargets(object12, (View)fragmentTransitionImpl, (ArrayList)object11);
                    object8 = fragmentTransitionImpl;
                    fragmentTransitionImpl2.scheduleRemoveTargets(object12, null, null, null, null, object12, (ArrayList)object7);
                    object9 = object3;
                    object10.put(object9, true);
                    object8 = object4;
                    object10.put(object8, true);
                    object14 = object12;
                }
            }
            object12 = object10;
            object10 = object8;
            object8 = object9;
            object9 = object10;
            object10 = object12;
        }
        while (object12.hasNext()) {
            arrayList = (TransitionInfo)object12.next();
            if (arrayList.isVisibilityUnchanged()) {
                object11.put(arrayList.getOperation(), bl);
                arrayList.completeSpecialEffect();
                continue;
            }
            object13 = fragmentTransitionImpl2.cloneTransition(arrayList.getTransition());
            SpecialEffectsController.Operation operation = arrayList.getOperation();
            n = object14 != null && (operation == object8 || operation == object9) ? 1 : 0;
            if (object13 == null) {
                if (n == 0) {
                    object11.put(operation, bl);
                    arrayList.completeSpecialEffect();
                }
            } else {
                object5 = new ArrayList<View>();
                defaultSpecialEffectsController.captureTransitioningViews((ArrayList<View>)object5, operation.getFragment().mView);
                if (n != 0) {
                    if (operation == object8) {
                        ((ArrayList)object5).removeAll((Collection<?>)object6);
                    } else {
                        ((ArrayList)object5).removeAll((Collection<?>)fragmentTransitionImpl);
                    }
                }
                if (((ArrayList)object5).isEmpty()) {
                    fragmentTransitionImpl2.addTarget(object13, (View)object10);
                } else {
                    fragmentTransitionImpl2.addTargets(object13, object5);
                    fragmentTransitionImpl2.scheduleRemoveTargets(object13, object13, object5, null, null, null, null);
                    if (operation.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                        object2.remove(operation);
                        ArrayList arrayList2 = new ArrayList(object5);
                        arrayList2.remove(operation.getFragment().mView);
                        fragmentTransitionImpl2.scheduleHideFragmentView(object13, operation.getFragment().mView, arrayList2);
                        OneShotPreDrawListener.add((View)this.getContainer(), (Runnable)new /* Unavailable Anonymous Inner Class!! */);
                    }
                }
                if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                    arrayMap.addAll(object5);
                    if (bl2) {
                        fragmentTransitionImpl2.setEpicenter(object13, rect);
                    }
                } else {
                    fragmentTransitionImpl2.setEpicenter(object13, (View)object7);
                }
                object11.put(operation, true);
                if (arrayList.isOverlapAllowed()) {
                    object4 = fragmentTransitionImpl2.mergeTransitionsTogether(object4, object13, null);
                } else {
                    object3 = fragmentTransitionImpl2.mergeTransitionsTogether(object3, object13, null);
                }
            }
            bl = false;
        }
        object2 = fragmentTransitionImpl2.mergeTransitionsInSequence(object4, object3, object14);
        object = object.iterator();
        while (object.hasNext()) {
            object4 = (TransitionInfo)object.next();
            if (object4.isVisibilityUnchanged()) continue;
            object10 = object4.getTransition();
            object3 = object4.getOperation();
            bl2 = object14 != null && (object3 == object8 || object3 == object9);
            if (object10 == null && !bl2) continue;
            if (!ViewCompat.isLaidOut((View)this.getContainer())) {
                if (FragmentManager.isLoggingEnabled((int)2)) {
                    object10 = new StringBuilder();
                    ((StringBuilder)object10).append("SpecialEffectsController: Container ");
                    ((StringBuilder)object10).append(this.getContainer());
                    ((StringBuilder)object10).append(" has not been laid out. Completing operation ");
                    ((StringBuilder)object10).append(object3);
                    Log.v((String)"FragmentManager", (String)((StringBuilder)object10).toString());
                }
                object4.completeSpecialEffect();
                continue;
            }
            fragmentTransitionImpl2.setListenerForTransitionEnd(object4.getOperation().getFragment(), object2, object4.getSignal(), (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (!ViewCompat.isLaidOut((View)this.getContainer())) {
            return object11;
        }
        FragmentTransition.setViewVisibility(arrayMap, (int)4);
        object = fragmentTransitionImpl2.prepareSetNameOverridesReordered((ArrayList)fragmentTransitionImpl);
        fragmentTransitionImpl2.beginDelayedTransition(this.getContainer(), object2);
        fragmentTransitionImpl2.setNameOverridesReordered((View)this.getContainer(), (ArrayList)object6, (ArrayList)fragmentTransitionImpl, (ArrayList)object, (Map)arrayMap2);
        FragmentTransition.setViewVisibility((ArrayList)arrayMap, (int)0);
        fragmentTransitionImpl2.swapSharedElementTargets(object14, (ArrayList)object6, (ArrayList)fragmentTransitionImpl);
        return object11;
    }

    void applyContainerChanges(SpecialEffectsController.Operation operation) {
        View view = operation.getFragment().mView;
        operation.getFinalState().applyState(view);
    }

    /*
     * Enabled force condition propagation
     */
    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) return;
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup)view;
        if (ViewGroupCompat.isTransitionGroup((ViewGroup)viewGroup)) {
            if (arrayList.contains(view)) return;
            arrayList.add((View)viewGroup);
            return;
        }
        int n = viewGroup.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            view = viewGroup.getChildAt(n2);
            if (view.getVisibility() == 0) {
                this.captureTransitioningViews(arrayList, view);
            }
            ++n2;
        }
    }

    void executeOperations(List<SpecialEffectsController.Operation> object, boolean bl) {
        SpecialEffectsController.Operation.State state;
        Object object2;
        Object object3 = object.iterator();
        Object object4 = null;
        Object object5 = null;
        while (object3.hasNext()) {
            object2 = object3.next();
            state = SpecialEffectsController.Operation.State.from((View)object2.getFragment().mView);
            int n = 10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[object2.getFinalState().ordinal()];
            if (n != 1 && n != 2 && n != 3) {
                if (n != 4 || state == SpecialEffectsController.Operation.State.VISIBLE) continue;
                object5 = object2;
                continue;
            }
            if (state != SpecialEffectsController.Operation.State.VISIBLE || object4 != null) continue;
            object4 = object2;
        }
        object3 = new ArrayList();
        state = new ArrayList();
        object2 = new ArrayList<SpecialEffectsController.Operation>((Collection<SpecialEffectsController.Operation>)object);
        object = object.iterator();
        while (object.hasNext()) {
            SpecialEffectsController.Operation operation = (SpecialEffectsController.Operation)object.next();
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation.markStartedSpecialEffect(cancellationSignal);
            object3.add(new AnimationInfo(operation, cancellationSignal, bl));
            cancellationSignal = new CancellationSignal();
            operation.markStartedSpecialEffect(cancellationSignal);
            boolean bl2 = false;
            if (bl ? operation == object4 : operation == object5) {
                bl2 = true;
            }
            state.add(new TransitionInfo(operation, cancellationSignal, bl, bl2));
            operation.addCompletionListener((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
        object = this.startTransitions((List<TransitionInfo>)state, (List<SpecialEffectsController.Operation>)object2, bl, (SpecialEffectsController.Operation)object4, (SpecialEffectsController.Operation)object5);
        this.startAnimations((List<AnimationInfo>)object3, (List<SpecialEffectsController.Operation>)object2, object.containsValue(true), (Map<SpecialEffectsController.Operation, Boolean>)object);
        object = object2.iterator();
        while (true) {
            if (!object.hasNext()) {
                object2.clear();
                return;
            }
            this.applyContainerChanges((SpecialEffectsController.Operation)object.next());
        }
    }

    void findNamedViews(Map<String, View> map, View view) {
        String string = ViewCompat.getTransitionName((View)view);
        if (string != null) {
            map.put(string, view);
        }
        if (!(view instanceof ViewGroup)) return;
        view = (ViewGroup)view;
        int n = view.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            string = view.getChildAt(n2);
            if (string.getVisibility() == 0) {
                this.findNamedViews(map, (View)string);
            }
            ++n2;
        }
    }

    void retainMatchingViews(ArrayMap<String, View> object, Collection<String> collection) {
        object = object.entrySet().iterator();
        while (object.hasNext()) {
            if (collection.contains(ViewCompat.getTransitionName((View)((View)((Map.Entry)object.next()).getValue())))) continue;
            object.remove();
        }
    }
}
