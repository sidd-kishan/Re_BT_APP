/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.collection.ArrayMap
 *  androidx.core.os.CancellationSignal
 *  androidx.core.view.OneShotPreDrawListener
 *  androidx.core.view.ViewCompat
 *  androidx.fragment.app.BackStackRecord
 *  androidx.fragment.app.Fragment
 *  androidx.fragment.app.FragmentContainer
 *  androidx.fragment.app.FragmentTransaction$Op
 *  androidx.fragment.app.FragmentTransition$Callback
 *  androidx.fragment.app.FragmentTransition$FragmentContainerTransition
 *  androidx.fragment.app.FragmentTransitionCompat21
 *  androidx.fragment.app.FragmentTransitionImpl
 */
package androidx.fragment.app;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.BackStackRecord;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentTransition;
import androidx.fragment.app.FragmentTransitionCompat21;
import androidx.fragment.app.FragmentTransitionImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

class FragmentTransition {
    private static final int[] INVERSE_OPS = new int[]{0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};
    static final FragmentTransitionImpl PLATFORM_IMPL;
    static final FragmentTransitionImpl SUPPORT_IMPL;

    static {
        FragmentTransitionCompat21 fragmentTransitionCompat21 = Build.VERSION.SDK_INT >= 21 ? new FragmentTransitionCompat21() : null;
        PLATFORM_IMPL = fragmentTransitionCompat21;
        SUPPORT_IMPL = FragmentTransition.resolveSupportImpl();
    }

    private FragmentTransition() {
    }

    private static void addSharedElementsWithMatchingNames(ArrayList<View> arrayList, ArrayMap<String, View> arrayMap, Collection<String> collection) {
        int n = arrayMap.size() - 1;
        while (n >= 0) {
            View view = (View)arrayMap.valueAt(n);
            if (collection.contains(ViewCompat.getTransitionName((View)view))) {
                arrayList.add(view);
            }
            --n;
        }
    }

    /*
     * Unable to fully structure code
     */
    private static void addToFirstInLastOut(BackStackRecord var0, FragmentTransaction.Op var1_1, SparseArray<FragmentContainerTransition> var2_2, boolean var3_3, boolean var4_4) {
        block23: {
            block24: {
                block22: {
                    block19: {
                        block21: {
                            block15: {
                                block16: {
                                    block17: {
                                        block20: {
                                            block18: {
                                                var12_5 = var1_1.mFragment;
                                                if (var12_5 == null) {
                                                    return;
                                                }
                                                var8_6 = var12_5.mContainerId;
                                                if (var8_6 == 0) {
                                                    return;
                                                }
                                                var5_7 = var3_3 != false ? FragmentTransition.INVERSE_OPS[var1_1.mCmd] : var1_1.mCmd;
                                                var9_8 = false;
                                                var10_9 = false;
                                                var6_10 = 1;
                                                if (var5_7 == 1) break block15;
                                                if (var5_7 == 3) break block16;
                                                if (var5_7 == 4) break block17;
                                                if (var5_7 == 5) break block18;
                                                if (var5_7 == 6) break block16;
                                                if (var5_7 == 7) break block15;
                                                var5_7 = 0;
                                                var9_8 = var10_9;
                                                break block19;
                                            }
                                            if (!var4_4) break block20;
                                            if (!var12_5.mHiddenChanged || var12_5.mHidden || !var12_5.mAdded) ** GOTO lbl-1000
                                            ** GOTO lbl-1000
                                        }
                                        var9_8 = var12_5.mHidden;
                                        break block21;
                                    }
                                    if (!(var4_4 != false ? var12_5.mHiddenChanged != false && var12_5.mAdded != false && var12_5.mHidden != false : var12_5.mAdded != false && var12_5.mHidden == false)) ** GOTO lbl-1000
                                    ** GOTO lbl-1000
                                }
                                if (var4_4 != false ? var12_5.mAdded == false && var12_5.mView != null && var12_5.mView.getVisibility() == 0 && var12_5.mPostponedAlpha >= 0.0f : var12_5.mAdded != false && var12_5.mHidden == false) lbl-1000:
                                // 2 sources

                                {
                                    var5_7 = 1;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var5_7 = 0;
                                }
                                var6_10 = var5_7;
                                var7_11 = true;
                                var5_7 = 0;
                                break block22;
                            }
                            if (var4_4) {
                                var9_8 = var12_5.mIsNewlyAdded;
                            } else if (!var12_5.mAdded && !var12_5.mHidden) lbl-1000:
                            // 2 sources

                            {
                                var9_8 = true;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var9_8 = false;
                            }
                        }
                        var5_7 = var6_10;
                    }
                    var7_11 = false;
                    var6_10 = 0;
                }
                var11_12 = (FragmentContainerTransition)var2_2.get(var8_6);
                var1_1 = var11_12;
                if (var9_8) {
                    var1_1 = FragmentTransition.ensureContainer(var11_12, var2_2, var8_6);
                    var1_1.lastIn = var12_5;
                    var1_1.lastInIsPop = var3_3;
                    var1_1.lastInTransaction = var0;
                }
                if (!var4_4 && var5_7 != 0) {
                    if (var1_1 != null && var1_1.firstOut == var12_5) {
                        var1_1.firstOut = null;
                    }
                    if (!var0.mReorderingAllowed) {
                        var11_12 = var0.mManager;
                        var13_13 = var11_12.createOrGetFragmentStateManager(var12_5);
                        var11_12.getFragmentStore().makeActive(var13_13);
                        var11_12.moveToState(var12_5);
                    }
                }
                var11_12 = var1_1;
                if (var6_10 == 0) break block23;
                if (var1_1 == null) break block24;
                var11_12 = var1_1;
                if (var1_1.firstOut != null) break block23;
            }
            var11_12 = FragmentTransition.ensureContainer((FragmentContainerTransition)var1_1, var2_2, var8_6);
            var11_12.firstOut = var12_5;
            var11_12.firstOutIsPop = var3_3;
            var11_12.firstOutTransaction = var0;
        }
        if (var4_4 != false) return;
        if (var7_11 == false) return;
        if (var11_12 == null) return;
        if (var11_12.lastIn != var12_5) return;
        var11_12.lastIn = null;
    }

    public static void calculateFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean bl) {
        int n = backStackRecord.mOps.size();
        int n2 = 0;
        while (n2 < n) {
            FragmentTransition.addToFirstInLastOut(backStackRecord, (FragmentTransaction.Op)backStackRecord.mOps.get(n2), sparseArray, false, bl);
            ++n2;
        }
    }

    private static ArrayMap<String, String> calculateNameOverrides(int n, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n2, int n3) {
        ArrayMap arrayMap = new ArrayMap();
        --n3;
        while (n3 >= n2) {
            Object object = arrayList.get(n3);
            if (object.interactsWith(n)) {
                boolean bl = arrayList2.get(n3);
                if (object.mSharedElementSourceNames != null) {
                    ArrayList arrayList3;
                    ArrayList arrayList4;
                    int n4 = object.mSharedElementSourceNames.size();
                    if (bl) {
                        arrayList4 = object.mSharedElementSourceNames;
                        arrayList3 = object.mSharedElementTargetNames;
                    } else {
                        arrayList3 = object.mSharedElementSourceNames;
                        arrayList4 = object.mSharedElementTargetNames;
                    }
                    for (int i = 0; i < n4; ++i) {
                        String string = (String)arrayList3.get(i);
                        String string2 = (String)arrayList4.get(i);
                        object = (String)arrayMap.remove((Object)string2);
                        if (object != null) {
                            arrayMap.put((Object)string, object);
                            continue;
                        }
                        arrayMap.put((Object)string, (Object)string2);
                    }
                }
            }
            --n3;
        }
        return arrayMap;
    }

    public static void calculatePopFragments(BackStackRecord backStackRecord, SparseArray<FragmentContainerTransition> sparseArray, boolean bl) {
        if (!backStackRecord.mManager.getContainer().onHasView()) {
            return;
        }
        int n = backStackRecord.mOps.size() - 1;
        while (n >= 0) {
            FragmentTransition.addToFirstInLastOut(backStackRecord, (FragmentTransaction.Op)backStackRecord.mOps.get(n), sparseArray, true, bl);
            --n;
        }
    }

    static void callSharedElementStartEnd(Fragment fragment, Fragment object, boolean bl, ArrayMap<String, View> arrayMap, boolean bl2) {
        fragment = bl ? object.getEnterTransitionCallback() : fragment.getEnterTransitionCallback();
        if (fragment == null) return;
        object = new ArrayList();
        ArrayList<Object> arrayList = new ArrayList<Object>();
        int n = arrayMap == null ? 0 : arrayMap.size();
        for (int i = 0; i < n; ++i) {
            arrayList.add(arrayMap.keyAt(i));
            ((ArrayList)object).add(arrayMap.valueAt(i));
        }
        if (bl2) {
            fragment.onSharedElementStart(arrayList, (List)object, null);
        } else {
            fragment.onSharedElementEnd(arrayList, (List)object, null);
        }
    }

    private static boolean canHandleAll(FragmentTransitionImpl fragmentTransitionImpl, List<Object> list) {
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            if (!fragmentTransitionImpl.canHandle(list.get(n2))) {
                return false;
            }
            ++n2;
        }
        return true;
    }

    static ArrayMap<String, View> captureInSharedElements(FragmentTransitionImpl object, ArrayMap<String, String> arrayMap, Object object2, FragmentContainerTransition object3) {
        ArrayMap arrayMap2;
        Fragment fragment = ((FragmentContainerTransition)object3).lastIn;
        View view = fragment.getView();
        if (!arrayMap.isEmpty() && object2 != null && view != null) {
            arrayMap2 = new ArrayMap();
            object.findNamedViews((Map)arrayMap2, view);
            object = ((FragmentContainerTransition)object3).lastInTransaction;
            if (((FragmentContainerTransition)object3).lastInIsPop) {
                object2 = fragment.getExitTransitionCallback();
                object = ((BackStackRecord)object).mSharedElementSourceNames;
            } else {
                object2 = fragment.getEnterTransitionCallback();
                object = ((BackStackRecord)object).mSharedElementTargetNames;
            }
            if (object != null) {
                arrayMap2.retainAll((Collection)object);
                arrayMap2.retainAll(arrayMap.values());
            }
            if (object2 == null) {
                FragmentTransition.retainValues(arrayMap, (ArrayMap<String, View>)arrayMap2);
                return arrayMap2;
            }
        } else {
            arrayMap.clear();
            return null;
        }
        object2.onMapSharedElements((List)object, (Map)arrayMap2);
        int n = ((ArrayList)object).size() - 1;
        while (n >= 0) {
            object3 = (String)((ArrayList)object).get(n);
            object2 = (View)arrayMap2.get(object3);
            if (object2 == null) {
                object2 = FragmentTransition.findKeyForValue(arrayMap, (String)object3);
                if (object2 != null) {
                    arrayMap.remove(object2);
                }
            } else if (!((String)object3).equals(ViewCompat.getTransitionName((View)object2)) && (object3 = FragmentTransition.findKeyForValue(arrayMap, (String)object3)) != null) {
                arrayMap.put(object3, (Object)ViewCompat.getTransitionName((View)object2));
            }
            --n;
        }
        return arrayMap2;
    }

    private static ArrayMap<String, View> captureOutSharedElements(FragmentTransitionImpl object, ArrayMap<String, String> arrayMap, Object object2, FragmentContainerTransition object3) {
        ArrayMap arrayMap2;
        if (!arrayMap.isEmpty() && object2 != null) {
            object2 = ((FragmentContainerTransition)object3).firstOut;
            arrayMap2 = new ArrayMap();
            object.findNamedViews((Map)arrayMap2, object2.requireView());
            object = ((FragmentContainerTransition)object3).firstOutTransaction;
            if (((FragmentContainerTransition)object3).firstOutIsPop) {
                object2 = object2.getEnterTransitionCallback();
                object = ((BackStackRecord)object).mSharedElementTargetNames;
            } else {
                object2 = object2.getExitTransitionCallback();
                object = ((BackStackRecord)object).mSharedElementSourceNames;
            }
            if (object != null) {
                arrayMap2.retainAll((Collection)object);
            }
            if (object2 == null) {
                arrayMap.retainAll((Collection)arrayMap2.keySet());
                return arrayMap2;
            }
        } else {
            arrayMap.clear();
            return null;
        }
        object2.onMapSharedElements((List)object, (Map)arrayMap2);
        int n = ((ArrayList)object).size() - 1;
        while (n >= 0) {
            object3 = (String)((ArrayList)object).get(n);
            object2 = (View)arrayMap2.get(object3);
            if (object2 == null) {
                arrayMap.remove(object3);
            } else if (!((String)object3).equals(ViewCompat.getTransitionName((View)object2))) {
                object3 = (String)arrayMap.remove(object3);
                arrayMap.put((Object)ViewCompat.getTransitionName((View)object2), object3);
            }
            --n;
        }
        return arrayMap2;
    }

    private static FragmentTransitionImpl chooseImpl(Fragment object, Fragment fragment) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (object != null) {
            Object object2 = object.getExitTransition();
            if (object2 != null) {
                arrayList.add(object2);
            }
            if ((object2 = object.getReturnTransition()) != null) {
                arrayList.add(object2);
            }
            if ((object = object.getSharedElementReturnTransition()) != null) {
                arrayList.add(object);
            }
        }
        if (fragment != null) {
            object = fragment.getEnterTransition();
            if (object != null) {
                arrayList.add(object);
            }
            if ((object = fragment.getReenterTransition()) != null) {
                arrayList.add(object);
            }
            if ((object = fragment.getSharedElementEnterTransition()) != null) {
                arrayList.add(object);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        object = PLATFORM_IMPL;
        if (object != null && FragmentTransition.canHandleAll((FragmentTransitionImpl)object, arrayList)) {
            return PLATFORM_IMPL;
        }
        object = SUPPORT_IMPL;
        if (object != null && FragmentTransition.canHandleAll((FragmentTransitionImpl)object, arrayList)) {
            return SUPPORT_IMPL;
        }
        if (PLATFORM_IMPL != null) throw new IllegalArgumentException("Invalid Transition types");
        if (SUPPORT_IMPL != null) throw new IllegalArgumentException("Invalid Transition types");
        return null;
    }

    static ArrayList<View> configureEnteringExitingViews(FragmentTransitionImpl fragmentTransitionImpl, Object object, Fragment object2, ArrayList<View> arrayList, View view) {
        if (object != null) {
            ArrayList<View> arrayList2 = new ArrayList<View>();
            if ((object2 = object2.getView()) != null) {
                fragmentTransitionImpl.captureTransitioningViews(arrayList2, (View)object2);
            }
            if (arrayList != null) {
                arrayList2.removeAll(arrayList);
            }
            object2 = arrayList2;
            if (arrayList2.isEmpty()) return object2;
            arrayList2.add(view);
            fragmentTransitionImpl.addTargets(object, arrayList2);
            object2 = arrayList2;
        } else {
            object2 = null;
        }
        return object2;
    }

    private static Object configureSharedElementsOrdered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> arrayMap, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object object, Object object2) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment == null) return null;
        if (fragment2 == null) {
            return null;
        }
        boolean bl = fragmentContainerTransition.lastInIsPop;
        Object object3 = arrayMap.isEmpty() ? null : FragmentTransition.getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, bl);
        ArrayMap<String, View> arrayMap2 = FragmentTransition.captureOutSharedElements(fragmentTransitionImpl, arrayMap, object3, fragmentContainerTransition);
        if (arrayMap.isEmpty()) {
            object3 = null;
        } else {
            arrayList.addAll(arrayMap2.values());
        }
        if (object == null && object2 == null && object3 == null) {
            return null;
        }
        FragmentTransition.callSharedElementStartEnd(fragment, fragment2, bl, arrayMap2, true);
        if (object3 != null) {
            Rect rect = new Rect();
            fragmentTransitionImpl.setSharedElementTargets(object3, view, arrayList);
            FragmentTransition.setOutEpicenter(fragmentTransitionImpl, object3, object2, arrayMap2, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            object2 = rect;
            if (object != null) {
                fragmentTransitionImpl.setEpicenter(object, rect);
                object2 = rect;
            }
        } else {
            object2 = null;
        }
        OneShotPreDrawListener.add((View)viewGroup, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return object3;
    }

    private static Object configureSharedElementsReordered(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, View view, ArrayMap<String, String> object, FragmentContainerTransition fragmentContainerTransition, ArrayList<View> arrayList, ArrayList<View> arrayList2, Object object2, Object object3) {
        Fragment fragment = fragmentContainerTransition.lastIn;
        Fragment fragment2 = fragmentContainerTransition.firstOut;
        if (fragment != null) {
            fragment.requireView().setVisibility(0);
        }
        if (fragment == null) return null;
        if (fragment2 == null) {
            return null;
        }
        boolean bl = fragmentContainerTransition.lastInIsPop;
        Object object4 = object.isEmpty() ? null : FragmentTransition.getSharedElementTransition(fragmentTransitionImpl, fragment, fragment2, bl);
        ArrayMap<String, View> arrayMap = FragmentTransition.captureOutSharedElements(fragmentTransitionImpl, object, object4, fragmentContainerTransition);
        ArrayMap<String, View> arrayMap2 = FragmentTransition.captureInSharedElements(fragmentTransitionImpl, object, object4, fragmentContainerTransition);
        if (object.isEmpty()) {
            if (arrayMap != null) {
                arrayMap.clear();
            }
            if (arrayMap2 != null) {
                arrayMap2.clear();
            }
            object = null;
        } else {
            FragmentTransition.addSharedElementsWithMatchingNames(arrayList, arrayMap, object.keySet());
            FragmentTransition.addSharedElementsWithMatchingNames(arrayList2, arrayMap2, object.values());
            object = object4;
        }
        if (object2 == null && object3 == null && object == null) {
            return null;
        }
        FragmentTransition.callSharedElementStartEnd(fragment, fragment2, bl, arrayMap, true);
        if (object != null) {
            arrayList2.add(view);
            fragmentTransitionImpl.setSharedElementTargets(object, view, arrayList);
            FragmentTransition.setOutEpicenter(fragmentTransitionImpl, object, object3, arrayMap, fragmentContainerTransition.firstOutIsPop, fragmentContainerTransition.firstOutTransaction);
            view = new Rect();
            fragmentContainerTransition = FragmentTransition.getInEpicenterView(arrayMap2, fragmentContainerTransition, object2, bl);
            if (fragmentContainerTransition != null) {
                fragmentTransitionImpl.setEpicenter(object2, (Rect)view);
            }
        } else {
            fragmentContainerTransition = null;
            view = null;
        }
        OneShotPreDrawListener.add((View)viewGroup, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        return object;
    }

    private static void configureTransitionsOrdered(ViewGroup viewGroup, FragmentContainerTransition object, View view, ArrayMap<String, String> arrayMap, Callback object2) {
        Fragment fragment = object.firstOut;
        Fragment fragment2 = object.lastIn;
        FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.chooseImpl(fragment, fragment2);
        if (fragmentTransitionImpl == null) {
            return;
        }
        boolean bl = object.lastInIsPop;
        boolean bl2 = object.firstOutIsPop;
        Object object3 = FragmentTransition.getEnterTransition(fragmentTransitionImpl, fragment2, bl);
        Object object4 = FragmentTransition.getExitTransition(fragmentTransitionImpl, fragment, bl2);
        CancellationSignal cancellationSignal = new ArrayList();
        ArrayList<View> arrayList = new ArrayList<View>();
        Object object5 = FragmentTransition.configureSharedElementsOrdered(fragmentTransitionImpl, viewGroup, view, arrayMap, object, cancellationSignal, arrayList, object3, object4);
        if (object3 == null && object5 == null && object4 == null) {
            return;
        }
        ArrayList<View> arrayList2 = FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl, object4, fragment, cancellationSignal, view);
        if (arrayList2 == null || arrayList2.isEmpty()) {
            object4 = null;
        }
        fragmentTransitionImpl.addTarget(object3, view);
        object = FragmentTransition.mergeTransitions(fragmentTransitionImpl, object3, object4, object5, fragment2, object.lastInIsPop);
        if (fragment != null && arrayList2 != null && (arrayList2.size() > 0 || cancellationSignal.size() > 0)) {
            cancellationSignal = new CancellationSignal();
            object2.onStart(fragment, cancellationSignal);
            fragmentTransitionImpl.setListenerForTransitionEnd(fragment, object, cancellationSignal, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (object == null) return;
        object2 = new ArrayList();
        fragmentTransitionImpl.scheduleRemoveTargets(object, object3, (ArrayList)object2, object4, arrayList2, object5, arrayList);
        FragmentTransition.scheduleTargetChange(fragmentTransitionImpl, viewGroup, fragment2, view, arrayList, object3, (ArrayList<View>)object2, object4, arrayList2);
        fragmentTransitionImpl.setNameOverridesOrdered((View)viewGroup, arrayList, arrayMap);
        fragmentTransitionImpl.beginDelayedTransition(viewGroup, object);
        fragmentTransitionImpl.scheduleNameReset(viewGroup, arrayList, arrayMap);
    }

    private static void configureTransitionsReordered(ViewGroup viewGroup, FragmentContainerTransition object, View object2, ArrayMap<String, String> arrayMap, Callback object3) {
        Fragment fragment = object.firstOut;
        Object object4 = object.lastIn;
        FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.chooseImpl(fragment, object4);
        if (fragmentTransitionImpl == null) {
            return;
        }
        boolean bl = object.lastInIsPop;
        boolean bl2 = object.firstOutIsPop;
        ArrayList<View> arrayList = new ArrayList<View>();
        ArrayList<View> arrayList2 = new ArrayList<View>();
        Object object5 = FragmentTransition.getEnterTransition(fragmentTransitionImpl, object4, bl);
        Object object6 = FragmentTransition.getExitTransition(fragmentTransitionImpl, fragment, bl2);
        object = FragmentTransition.configureSharedElementsReordered(fragmentTransitionImpl, viewGroup, object2, arrayMap, object, arrayList2, arrayList, object5, object6);
        if (object5 == null && object == null && object6 == null) {
            return;
        }
        ArrayList<View> arrayList3 = FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl, object6, fragment, arrayList2, object2);
        object2 = FragmentTransition.configureEnteringExitingViews(fragmentTransitionImpl, object5, object4, arrayList, object2);
        FragmentTransition.setViewVisibility((ArrayList<View>)object2, 4);
        object4 = FragmentTransition.mergeTransitions(fragmentTransitionImpl, object5, object6, object, object4, bl);
        if (fragment != null && arrayList3 != null && (arrayList3.size() > 0 || arrayList2.size() > 0)) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            object3.onStart(fragment, cancellationSignal);
            fragmentTransitionImpl.setListenerForTransitionEnd(fragment, object4, cancellationSignal, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
        }
        if (object4 == null) return;
        FragmentTransition.replaceHide(fragmentTransitionImpl, object6, fragment, arrayList3);
        object3 = fragmentTransitionImpl.prepareSetNameOverridesReordered(arrayList);
        fragmentTransitionImpl.scheduleRemoveTargets(object4, object5, (ArrayList)object2, object6, arrayList3, object, arrayList);
        fragmentTransitionImpl.beginDelayedTransition(viewGroup, object4);
        fragmentTransitionImpl.setNameOverridesReordered((View)viewGroup, arrayList2, arrayList, (ArrayList)object3, arrayMap);
        FragmentTransition.setViewVisibility((ArrayList<View>)object2, 0);
        fragmentTransitionImpl.swapSharedElementTargets(object, arrayList2, arrayList);
    }

    private static FragmentContainerTransition ensureContainer(FragmentContainerTransition fragmentContainerTransition, SparseArray<FragmentContainerTransition> sparseArray, int n) {
        FragmentContainerTransition fragmentContainerTransition2 = fragmentContainerTransition;
        if (fragmentContainerTransition != null) return fragmentContainerTransition2;
        fragmentContainerTransition2 = new FragmentContainerTransition();
        sparseArray.put(n, (Object)fragmentContainerTransition2);
        return fragmentContainerTransition2;
    }

    static String findKeyForValue(ArrayMap<String, String> arrayMap, String string) {
        int n = arrayMap.size();
        int n2 = 0;
        while (n2 < n) {
            if (string.equals(arrayMap.valueAt(n2))) {
                return (String)arrayMap.keyAt(n2);
            }
            ++n2;
        }
        return null;
    }

    private static Object getEnterTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment object, boolean bl) {
        if (object == null) {
            return null;
        }
        object = bl ? object.getReenterTransition() : object.getEnterTransition();
        return fragmentTransitionImpl.cloneTransition(object);
    }

    private static Object getExitTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment object, boolean bl) {
        if (object == null) {
            return null;
        }
        object = bl ? object.getReturnTransition() : object.getExitTransition();
        return fragmentTransitionImpl.cloneTransition(object);
    }

    static View getInEpicenterView(ArrayMap<String, View> arrayMap, FragmentContainerTransition object, Object object2, boolean bl) {
        object = object.lastInTransaction;
        if (object2 == null) return null;
        if (arrayMap == null) return null;
        if (object.mSharedElementSourceNames == null) return null;
        if (object.mSharedElementSourceNames.isEmpty()) return null;
        object = bl ? (String)object.mSharedElementSourceNames.get(0) : (String)object.mSharedElementTargetNames.get(0);
        return (View)arrayMap.get(object);
    }

    private static Object getSharedElementTransition(FragmentTransitionImpl fragmentTransitionImpl, Fragment object, Fragment fragment, boolean bl) {
        if (object == null) return null;
        if (fragment == null) {
            return null;
        }
        object = bl ? fragment.getSharedElementReturnTransition() : object.getSharedElementEnterTransition();
        return fragmentTransitionImpl.wrapTransitionInSet(fragmentTransitionImpl.cloneTransition(object));
    }

    private static Object mergeTransitions(FragmentTransitionImpl object, Object object2, Object object3, Object object4, Fragment fragment, boolean bl) {
        bl = object2 != null && object3 != null && fragment != null ? (bl ? fragment.getAllowReturnTransitionOverlap() : fragment.getAllowEnterTransitionOverlap()) : true;
        object = bl ? object.mergeTransitionsTogether(object3, object2, object4) : object.mergeTransitionsInSequence(object3, object2, object4);
        return object;
    }

    private static void replaceHide(FragmentTransitionImpl fragmentTransitionImpl, Object object, Fragment fragment, ArrayList<View> arrayList) {
        if (fragment == null) return;
        if (object == null) return;
        if (!fragment.mAdded) return;
        if (!fragment.mHidden) return;
        if (!fragment.mHiddenChanged) return;
        fragment.setHideReplaced(true);
        fragmentTransitionImpl.scheduleHideFragmentView(object, fragment.getView(), arrayList);
        OneShotPreDrawListener.add((View)fragment.mContainer, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            FragmentTransitionImpl fragmentTransitionImpl = (FragmentTransitionImpl)Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            return fragmentTransitionImpl;
        }
        catch (Exception exception) {
            return null;
        }
    }

    static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        int n = arrayMap.size() - 1;
        while (n >= 0) {
            if (!arrayMap2.containsKey((Object)((String)arrayMap.valueAt(n)))) {
                arrayMap.removeAt(n);
            }
            --n;
        }
    }

    private static void scheduleTargetChange(FragmentTransitionImpl fragmentTransitionImpl, ViewGroup viewGroup, Fragment fragment, View view, ArrayList<View> arrayList, Object object, ArrayList<View> arrayList2, Object object2, ArrayList<View> arrayList3) {
        OneShotPreDrawListener.add((View)viewGroup, (Runnable)new /* Unavailable Anonymous Inner Class!! */);
    }

    private static void setOutEpicenter(FragmentTransitionImpl fragmentTransitionImpl, Object object, Object object2, ArrayMap<String, View> view, boolean bl, BackStackRecord object3) {
        if (object3.mSharedElementSourceNames == null) return;
        if (object3.mSharedElementSourceNames.isEmpty()) return;
        object3 = bl ? (String)object3.mSharedElementTargetNames.get(0) : (String)object3.mSharedElementSourceNames.get(0);
        view = (View)view.get(object3);
        fragmentTransitionImpl.setEpicenter(object, view);
        if (object2 == null) return;
        fragmentTransitionImpl.setEpicenter(object2, view);
    }

    static void setViewVisibility(ArrayList<View> arrayList, int n) {
        if (arrayList == null) {
            return;
        }
        int n2 = arrayList.size() - 1;
        while (n2 >= 0) {
            arrayList.get(n2).setVisibility(n);
            --n2;
        }
    }

    static void startTransitions(Context arrayMap, FragmentContainer fragmentContainer, ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int n, int n2, boolean bl, Callback callback) {
        BackStackRecord backStackRecord;
        int n3;
        SparseArray sparseArray = new SparseArray();
        for (n3 = n; n3 < n2; ++n3) {
            backStackRecord = arrayList.get(n3);
            if (arrayList2.get(n3).booleanValue()) {
                FragmentTransition.calculatePopFragments(backStackRecord, (SparseArray<FragmentContainerTransition>)sparseArray, bl);
                continue;
            }
            FragmentTransition.calculateFragments(backStackRecord, (SparseArray<FragmentContainerTransition>)sparseArray, bl);
        }
        if (sparseArray.size() == 0) return;
        View view = new View((Context)arrayMap);
        int n4 = sparseArray.size();
        n3 = 0;
        while (n3 < n4) {
            int n5 = sparseArray.keyAt(n3);
            arrayMap = FragmentTransition.calculateNameOverrides(n5, arrayList, arrayList2, n, n2);
            FragmentContainerTransition fragmentContainerTransition = (FragmentContainerTransition)sparseArray.valueAt(n3);
            if (fragmentContainer.onHasView() && (backStackRecord = (ViewGroup)fragmentContainer.onFindViewById(n5)) != null) {
                if (bl) {
                    FragmentTransition.configureTransitionsReordered((ViewGroup)backStackRecord, fragmentContainerTransition, view, arrayMap, callback);
                } else {
                    FragmentTransition.configureTransitionsOrdered((ViewGroup)backStackRecord, fragmentContainerTransition, view, arrayMap, callback);
                }
            }
            ++n3;
        }
    }

    static boolean supportsTransition() {
        boolean bl = PLATFORM_IMPL != null || SUPPORT_IMPL != null;
        return bl;
    }
}
