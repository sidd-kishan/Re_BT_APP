/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.Rect
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.InflateException
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AnimationUtils
 *  android.widget.ListView
 *  androidx.collection.ArrayMap
 *  androidx.collection.LongSparseArray
 *  androidx.collection.SimpleArrayMap
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.core.view.ViewCompat
 *  androidx.transition.AnimatorUtils
 *  androidx.transition.PathMotion
 *  androidx.transition.Styleable
 *  androidx.transition.Transition$AnimationInfo
 *  androidx.transition.Transition$ArrayListManager
 *  androidx.transition.Transition$EpicenterCallback
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionPropagation
 *  androidx.transition.TransitionSet
 *  androidx.transition.TransitionValues
 *  androidx.transition.TransitionValuesMaps
 *  androidx.transition.ViewUtils
 *  androidx.transition.WindowIdImpl
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import androidx.transition.AnimatorUtils;
import androidx.transition.PathMotion;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionSet;
import androidx.transition.TransitionValues;
import androidx.transition.TransitionValuesMaps;
import androidx.transition.ViewUtils;
import androidx.transition.WindowIdImpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class Transition
implements Cloneable {
    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new /* Unavailable Anonymous Inner Class!! */;
    private static ThreadLocal<ArrayMap<Animator, AnimationInfo>> sRunningAnimators = new ThreadLocal();
    private ArrayList<Animator> mAnimators;
    boolean mCanRemoveViews = false;
    ArrayList<Animator> mCurrentAnimators;
    long mDuration = -1L;
    private TransitionValuesMaps mEndValues;
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<TransitionListener> mListeners = null;
    private int[] mMatchOrder;
    private String mName = this.getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    TransitionSet mParent = null;
    private PathMotion mPathMotion;
    private boolean mPaused = false;
    TransitionPropagation mPropagation;
    private long mStartDelay = -1L;
    private TransitionValuesMaps mStartValues;
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    ArrayList<Integer> mTargetIds = new ArrayList();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    ArrayList<View> mTargets = new ArrayList();

    public Transition() {
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
    }

    public Transition(Context object, AttributeSet attributeSet) {
        int n;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mMatchOrder = DEFAULT_MATCH_ORDER;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimators = new ArrayList();
        this.mPathMotion = STRAIGHT_PATH_MOTION;
        TypedArray typedArray = object.obtainStyledAttributes(attributeSet, Styleable.TRANSITION);
        attributeSet = (XmlResourceParser)attributeSet;
        long l = TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)((Object)attributeSet), (String)"duration", (int)1, (int)-1);
        if (l >= 0L) {
            this.setDuration(l);
        }
        if ((l = (long)TypedArrayUtils.getNamedInt((TypedArray)typedArray, (XmlPullParser)((Object)attributeSet), (String)"startDelay", (int)2, (int)-1)) > 0L) {
            this.setStartDelay(l);
        }
        if ((n = TypedArrayUtils.getNamedResourceId((TypedArray)typedArray, (XmlPullParser)((Object)attributeSet), (String)"interpolator", (int)0, (int)0)) > 0) {
            this.setInterpolator((TimeInterpolator)AnimationUtils.loadInterpolator((Context)object, (int)n));
        }
        if ((object = TypedArrayUtils.getNamedString((TypedArray)typedArray, (XmlPullParser)((Object)attributeSet), (String)"matchOrder", (int)3)) != null) {
            this.setMatchOrder(Transition.parseMatchOrder((String)object));
        }
        typedArray.recycle();
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> transitionValues, ArrayMap<View, TransitionValues> arrayMap) {
        int n;
        int n2 = 0;
        int n3 = 0;
        while (true) {
            n = n2;
            if (n3 >= transitionValues.size()) break;
            TransitionValues transitionValues2 = (TransitionValues)transitionValues.valueAt(n3);
            if (this.isValidTarget(transitionValues2.view)) {
                this.mStartValuesList.add(transitionValues2);
                this.mEndValuesList.add(null);
            }
            ++n3;
        }
        while (n < arrayMap.size()) {
            transitionValues = (TransitionValues)arrayMap.valueAt(n);
            if (this.isValidTarget(transitionValues.view)) {
                this.mEndValuesList.add(transitionValues);
                this.mStartValuesList.add(null);
            }
            ++n;
        }
    }

    private static void addViewValues(TransitionValuesMaps transitionValuesMaps, View view, TransitionValues object) {
        transitionValuesMaps.mViewValues.put((Object)view, object);
        int n = view.getId();
        if (n >= 0) {
            if (transitionValuesMaps.mIdValues.indexOfKey(n) >= 0) {
                transitionValuesMaps.mIdValues.put(n, null);
            } else {
                transitionValuesMaps.mIdValues.put(n, (Object)view);
            }
        }
        if ((object = ViewCompat.getTransitionName((View)view)) != null) {
            if (transitionValuesMaps.mNameValues.containsKey(object)) {
                transitionValuesMaps.mNameValues.put(object, null);
            } else {
                transitionValuesMaps.mNameValues.put(object, (Object)view);
            }
        }
        if (!(view.getParent() instanceof ListView)) return;
        object = (ListView)view.getParent();
        if (!object.getAdapter().hasStableIds()) return;
        long l = object.getItemIdAtPosition(object.getPositionForView(view));
        if (transitionValuesMaps.mItemIdValues.indexOfKey(l) >= 0) {
            view = (View)transitionValuesMaps.mItemIdValues.get(l);
            if (view == null) return;
            ViewCompat.setHasTransientState((View)view, (boolean)false);
            transitionValuesMaps.mItemIdValues.put(l, null);
        } else {
            ViewCompat.setHasTransientState((View)view, (boolean)true);
            transitionValuesMaps.mItemIdValues.put(l, (Object)view);
        }
    }

    private static boolean alreadyContains(int[] nArray, int n) {
        int n2 = nArray[n];
        int n3 = 0;
        while (n3 < n) {
            if (nArray[n3] == n2) {
                return true;
            }
            ++n3;
        }
        return false;
    }

    private void captureHierarchy(View view, boolean bl) {
        int n;
        int n2;
        if (view == null) {
            return;
        }
        int n3 = view.getId();
        ArrayList<Serializable> arrayList = this.mTargetIdExcludes;
        if (arrayList != null && arrayList.contains(n3)) {
            return;
        }
        arrayList = this.mTargetExcludes;
        if (arrayList != null && arrayList.contains(view)) {
            return;
        }
        arrayList = this.mTargetTypeExcludes;
        int n4 = 0;
        if (arrayList != null) {
            n2 = arrayList.size();
            for (n = 0; n < n2; ++n) {
                if (!this.mTargetTypeExcludes.get(n).isInstance(view)) continue;
                return;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            arrayList = new TransitionValues(view);
            if (bl) {
                this.captureStartValues((TransitionValues)arrayList);
            } else {
                this.captureEndValues((TransitionValues)arrayList);
            }
            ((TransitionValues)arrayList).mTargetedTransitions.add(this);
            this.capturePropagationValues((TransitionValues)arrayList);
            if (bl) {
                Transition.addViewValues(this.mStartValues, view, arrayList);
            } else {
                Transition.addViewValues(this.mEndValues, view, arrayList);
            }
        }
        if (!(view instanceof ViewGroup)) return;
        arrayList = this.mTargetIdChildExcludes;
        if (arrayList != null && arrayList.contains(n3)) {
            return;
        }
        arrayList = this.mTargetChildExcludes;
        if (arrayList != null && arrayList.contains(view)) {
            return;
        }
        arrayList = this.mTargetTypeChildExcludes;
        if (arrayList != null) {
            n2 = arrayList.size();
            for (n = 0; n < n2; ++n) {
                if (!this.mTargetTypeChildExcludes.get(n).isInstance(view)) continue;
                return;
            }
        }
        view = (ViewGroup)view;
        n = n4;
        while (n < view.getChildCount()) {
            this.captureHierarchy(view.getChildAt(n), bl);
            ++n;
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int n, boolean bl) {
        ArrayList arrayList2 = arrayList;
        if (n <= 0) return arrayList2;
        arrayList2 = bl ? ArrayListManager.add(arrayList, (Object)n) : ArrayListManager.remove(arrayList, (Object)n);
        return arrayList2;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean bl) {
        ArrayList arrayList2 = arrayList;
        if (t == null) return arrayList2;
        arrayList2 = bl ? ArrayListManager.add(arrayList, t) : ArrayListManager.remove(arrayList, t);
        return arrayList2;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> clazz, boolean bl) {
        ArrayList arrayList2 = arrayList;
        if (clazz == null) return arrayList2;
        arrayList2 = bl ? ArrayListManager.add(arrayList, clazz) : ArrayListManager.remove(arrayList, clazz);
        return arrayList2;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean bl) {
        ArrayList arrayList2 = arrayList;
        if (view == null) return arrayList2;
        arrayList2 = bl ? ArrayListManager.add(arrayList, (Object)view) : ArrayListManager.remove(arrayList, (Object)view);
        return arrayList2;
    }

    private static ArrayMap<Animator, AnimationInfo> getRunningAnimators() {
        ArrayMap arrayMap;
        ArrayMap arrayMap2 = arrayMap = sRunningAnimators.get();
        if (arrayMap != null) return arrayMap2;
        arrayMap2 = new ArrayMap();
        sRunningAnimators.set((ArrayMap<Animator, AnimationInfo>)arrayMap2);
        return arrayMap2;
    }

    private static boolean isValidMatch(int n) {
        boolean bl = true;
        if (n >= 1 && n <= 4) return bl;
        bl = false;
        return bl;
    }

    private static boolean isValueChanged(TransitionValues object, TransitionValues object2, String string) {
        boolean bl;
        object = ((TransitionValues)object).values.get(string);
        object2 = object2.values.get(string);
        boolean bl2 = true;
        if (object == null && object2 == null) {
            bl = false;
        } else {
            bl = bl2;
            if (object == null) return bl;
            bl = object2 == null ? bl2 : true ^ object.equals(object2);
        }
        return bl;
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        int n = sparseArray.size();
        int n2 = 0;
        while (n2 < n) {
            View view;
            View view2 = (View)sparseArray.valueAt(n2);
            if (view2 != null && this.isValidTarget(view2) && (view = (View)sparseArray2.get(sparseArray.keyAt(n2))) != null && this.isValidTarget(view)) {
                TransitionValues transitionValues = (TransitionValues)arrayMap.get((Object)view2);
                TransitionValues transitionValues2 = (TransitionValues)arrayMap2.get((Object)view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove((Object)view2);
                    arrayMap2.remove((Object)view);
                }
            }
            ++n2;
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        int n = arrayMap.size() - 1;
        while (n >= 0) {
            View view = (View)arrayMap.keyAt(n);
            if (view != null && this.isValidTarget(view) && (view = (TransitionValues)arrayMap2.remove((Object)view)) != null && this.isValidTarget(view.view)) {
                TransitionValues transitionValues = (TransitionValues)arrayMap.removeAt(n);
                this.mStartValuesList.add(transitionValues);
                this.mEndValuesList.add((TransitionValues)view);
            }
            --n;
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        int n = longSparseArray.size();
        int n2 = 0;
        while (n2 < n) {
            View view;
            View view2 = (View)longSparseArray.valueAt(n2);
            if (view2 != null && this.isValidTarget(view2) && (view = (View)longSparseArray2.get(longSparseArray.keyAt(n2))) != null && this.isValidTarget(view)) {
                TransitionValues transitionValues = (TransitionValues)arrayMap.get((Object)view2);
                TransitionValues transitionValues2 = (TransitionValues)arrayMap2.get((Object)view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove((Object)view2);
                    arrayMap2.remove((Object)view);
                }
            }
            ++n2;
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        int n = arrayMap3.size();
        int n2 = 0;
        while (n2 < n) {
            View view;
            View view2 = (View)arrayMap3.valueAt(n2);
            if (view2 != null && this.isValidTarget(view2) && (view = (View)arrayMap4.get(arrayMap3.keyAt(n2))) != null && this.isValidTarget(view)) {
                TransitionValues transitionValues = (TransitionValues)arrayMap.get((Object)view2);
                TransitionValues transitionValues2 = (TransitionValues)arrayMap2.get((Object)view);
                if (transitionValues != null && transitionValues2 != null) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove((Object)view2);
                    arrayMap2.remove((Object)view);
                }
            }
            ++n2;
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap)transitionValuesMaps.mViewValues);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap)transitionValuesMaps2.mViewValues);
        int n = 0;
        while (true) {
            int[] nArray;
            if (n >= (nArray = this.mMatchOrder).length) {
                this.addUnmatched((ArrayMap<View, TransitionValues>)arrayMap, (ArrayMap<View, TransitionValues>)arrayMap2);
                return;
            }
            int n2 = nArray[n];
            if (n2 != 1) {
                if (n2 != 2) {
                    if (n2 != 3) {
                        if (n2 == 4) {
                            this.matchItemIds((ArrayMap<View, TransitionValues>)arrayMap, (ArrayMap<View, TransitionValues>)arrayMap2, (LongSparseArray<View>)transitionValuesMaps.mItemIdValues, (LongSparseArray<View>)transitionValuesMaps2.mItemIdValues);
                        }
                    } else {
                        this.matchIds((ArrayMap<View, TransitionValues>)arrayMap, (ArrayMap<View, TransitionValues>)arrayMap2, (SparseArray<View>)transitionValuesMaps.mIdValues, (SparseArray<View>)transitionValuesMaps2.mIdValues);
                    }
                } else {
                    this.matchNames((ArrayMap<View, TransitionValues>)arrayMap, (ArrayMap<View, TransitionValues>)arrayMap2, (ArrayMap<String, View>)transitionValuesMaps.mNameValues, (ArrayMap<String, View>)transitionValuesMaps2.mNameValues);
                }
            } else {
                this.matchInstances((ArrayMap<View, TransitionValues>)arrayMap, (ArrayMap<View, TransitionValues>)arrayMap2);
            }
            ++n;
        }
    }

    private static int[] parseMatchOrder(String object) {
        StringTokenizer stringTokenizer = new StringTokenizer((String)object, ",");
        object = new int[stringTokenizer.countTokens()];
        int n = 0;
        while (stringTokenizer.hasMoreTokens()) {
            Object object2 = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase((String)object2)) {
                object[n] = 3;
            } else if ("instance".equalsIgnoreCase((String)object2)) {
                object[n] = true;
            } else if ("name".equalsIgnoreCase((String)object2)) {
                object[n] = 2;
            } else if ("itemId".equalsIgnoreCase((String)object2)) {
                object[n] = 4;
            } else {
                if (!((String)object2).isEmpty()) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("Unknown match type in matchOrder: '");
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append("'");
                    throw new InflateException(((StringBuilder)object).toString());
                }
                object2 = new int[((Object)object).length - 1];
                System.arraycopy(object, 0, object2, 0, n);
                --n;
                object = object2;
            }
            ++n;
        }
        return object;
    }

    private void runAnimator(Animator animator, ArrayMap<Animator, AnimationInfo> arrayMap) {
        if (animator == null) return;
        animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.animate(animator);
    }

    public Transition addListener(TransitionListener transitionListener) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        this.mListeners.add(transitionListener);
        return this;
    }

    public Transition addTarget(int n) {
        if (n == 0) return this;
        this.mTargetIds.add(n);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public Transition addTarget(Class<?> clazz) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList();
        }
        this.mTargetTypes.add(clazz);
        return this;
    }

    public Transition addTarget(String string) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList();
        }
        this.mTargetNames.add(string);
        return this;
    }

    protected void animate(Animator animator) {
        if (animator == null) {
            this.end();
        } else {
            if (this.getDuration() >= 0L) {
                animator.setDuration(this.getDuration());
            }
            if (this.getStartDelay() >= 0L) {
                animator.setStartDelay(this.getStartDelay() + animator.getStartDelay());
            }
            if (this.getInterpolator() != null) {
                animator.setInterpolator(this.getInterpolator());
            }
            animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            animator.start();
        }
    }

    protected void cancel() {
        int n;
        for (n = this.mCurrentAnimators.size() - 1; n >= 0; --n) {
            this.mCurrentAnimators.get(n).cancel();
        }
        ArrayList arrayList = this.mListeners;
        if (arrayList == null) return;
        if (arrayList.size() <= 0) return;
        arrayList = (ArrayList)this.mListeners.clone();
        int n2 = arrayList.size();
        n = 0;
        while (n < n2) {
            ((TransitionListener)arrayList.get(n)).onTransitionCancel(this);
            ++n;
        }
    }

    public abstract void captureEndValues(TransitionValues var1);

    void capturePropagationValues(TransitionValues transitionValues) {
        int n;
        block2: {
            if (this.mPropagation == null) return;
            if (transitionValues.values.isEmpty()) return;
            String[] stringArray = this.mPropagation.getPropagationProperties();
            if (stringArray == null) {
                return;
            }
            int n2 = 0;
            for (n = 0; n < stringArray.length; ++n) {
                if (transitionValues.values.containsKey(stringArray[n])) continue;
                n = n2;
                break block2;
            }
            n = 1;
        }
        if (n != 0) return;
        this.mPropagation.captureValues(transitionValues);
    }

    public abstract void captureStartValues(TransitionValues var1);

    void captureValues(ViewGroup arrayMap, boolean bl) {
        Object object;
        Object object2;
        this.clearValues(bl);
        int n = this.mTargetIds.size();
        int n2 = 0;
        if (n <= 0 && this.mTargets.size() <= 0 || (object2 = this.mTargetNames) != null && !((ArrayList)object2).isEmpty() || (object2 = this.mTargetTypes) != null && !((ArrayList)object2).isEmpty()) {
            this.captureHierarchy((View)arrayMap, bl);
        } else {
            for (n = 0; n < this.mTargetIds.size(); ++n) {
                object2 = arrayMap.findViewById(this.mTargetIds.get(n).intValue());
                if (object2 == null) continue;
                object = new TransitionValues(object2);
                if (bl) {
                    this.captureStartValues((TransitionValues)object);
                } else {
                    this.captureEndValues((TransitionValues)object);
                }
                object.mTargetedTransitions.add(this);
                this.capturePropagationValues((TransitionValues)object);
                if (bl) {
                    Transition.addViewValues(this.mStartValues, (View)object2, object);
                    continue;
                }
                Transition.addViewValues(this.mEndValues, (View)object2, object);
            }
            for (n = 0; n < this.mTargets.size(); ++n) {
                arrayMap = this.mTargets.get(n);
                object2 = new TransitionValues((View)arrayMap);
                if (bl) {
                    this.captureStartValues((TransitionValues)object2);
                } else {
                    this.captureEndValues((TransitionValues)object2);
                }
                ((TransitionValues)object2).mTargetedTransitions.add(this);
                this.capturePropagationValues((TransitionValues)object2);
                if (bl) {
                    Transition.addViewValues(this.mStartValues, (View)arrayMap, (TransitionValues)object2);
                    continue;
                }
                Transition.addViewValues(this.mEndValues, (View)arrayMap, (TransitionValues)object2);
            }
        }
        if (bl) return;
        arrayMap = this.mNameOverrides;
        if (arrayMap == null) return;
        int n3 = arrayMap.size();
        arrayMap = new ArrayList(n3);
        int n4 = 0;
        while (true) {
            n = n2;
            if (n4 >= n3) break;
            object2 = (String)this.mNameOverrides.keyAt(n4);
            arrayMap.add(this.mStartValues.mNameValues.remove(object2));
            ++n4;
        }
        while (n < n3) {
            object2 = (View)arrayMap.get(n);
            if (object2 != null) {
                object = (String)this.mNameOverrides.valueAt(n);
                this.mStartValues.mNameValues.put(object, object2);
            }
            ++n;
        }
    }

    void clearValues(boolean bl) {
        if (bl) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
        } else {
            this.mEndValues.mViewValues.clear();
            this.mEndValues.mIdValues.clear();
            this.mEndValues.mItemIdValues.clear();
        }
    }

    public Transition clone() {
        try {
            Transition transition = (Transition)super.clone();
            TransitionValuesMaps transitionValuesMaps = new ArrayList();
            transition.mAnimators = transitionValuesMaps;
            transition.mStartValues = transitionValuesMaps = new TransitionValuesMaps();
            transition.mEndValues = transitionValuesMaps = new TransitionValuesMaps();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    protected void createAnimators(ViewGroup viewGroup, TransitionValuesMaps transitionValuesMaps, TransitionValuesMaps transitionValuesMaps2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int n;
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int n2 = arrayList.size();
        long l = Long.MAX_VALUE;
        int n3 = 0;
        while (n3 < n2) {
            long l2;
            block17: {
                TransitionValues transitionValues;
                View view;
                TransitionValuesMaps transitionValuesMaps3;
                TransitionValues transitionValues2;
                TransitionValues transitionValues3;
                block19: {
                    block13: {
                        int n4;
                        block18: {
                            block15: {
                                block16: {
                                    block12: {
                                        block14: {
                                            transitionValues3 = arrayList.get(n3);
                                            transitionValuesMaps = arrayList2.get(n3);
                                            transitionValues2 = transitionValues3;
                                            if (transitionValues3 != null) {
                                                transitionValues2 = transitionValues3;
                                                if (!transitionValues3.mTargetedTransitions.contains(this)) {
                                                    transitionValues2 = null;
                                                }
                                            }
                                            transitionValuesMaps3 = transitionValuesMaps;
                                            if (transitionValuesMaps != null) {
                                                transitionValuesMaps3 = transitionValuesMaps;
                                                if (!transitionValuesMaps.mTargetedTransitions.contains(this)) {
                                                    transitionValuesMaps3 = null;
                                                }
                                            }
                                            if (transitionValues2 == null && transitionValuesMaps3 == null) break block14;
                                            n = transitionValues2 != null && transitionValuesMaps3 != null && !this.isTransitionRequired(transitionValues2, (TransitionValues)transitionValuesMaps3) ? 0 : 1;
                                            if (n == 0 || (transitionValuesMaps = this.createAnimator(viewGroup, transitionValues2, (TransitionValues)transitionValuesMaps3)) == null) break block14;
                                            if (transitionValuesMaps3 == null) break block15;
                                            view = transitionValuesMaps3.view;
                                            String[] stringArray = this.getTransitionProperties();
                                            if (stringArray == null || stringArray.length <= 0) break block16;
                                            transitionValues = new TransitionValues(view);
                                            transitionValues3 = (TransitionValues)transitionValuesMaps2.mViewValues.get((Object)view);
                                            n = n3;
                                            if (transitionValues3 != null) {
                                                n4 = 0;
                                                while (true) {
                                                    n = n3;
                                                    if (n4 < stringArray.length) {
                                                        transitionValues.values.put(stringArray[n4], transitionValues3.values.get(stringArray[n4]));
                                                        ++n4;
                                                        continue;
                                                    }
                                                    break block12;
                                                    break;
                                                }
                                            }
                                            break block12;
                                        }
                                        l2 = l;
                                        n = n3;
                                        break block17;
                                    }
                                    n3 = n;
                                    n4 = arrayMap.size();
                                    break block18;
                                }
                                transitionValues3 = null;
                                break block13;
                            }
                            view = transitionValues2.view;
                            transitionValues3 = transitionValuesMaps;
                            transitionValues = null;
                            transitionValuesMaps = view;
                            break block19;
                        }
                        for (n = 0; n < n4; ++n) {
                            transitionValues3 = (AnimationInfo)arrayMap.get((Object)((Animator)arrayMap.keyAt(n)));
                            if (transitionValues3.mValues == null || transitionValues3.mView != view || !transitionValues3.mName.equals(this.getName()) || !transitionValues3.mValues.equals((Object)transitionValues)) continue;
                            transitionValuesMaps = null;
                            transitionValues3 = transitionValues;
                            break block13;
                        }
                        transitionValues3 = transitionValues;
                    }
                    transitionValues = transitionValues3;
                    transitionValues3 = transitionValuesMaps;
                    transitionValuesMaps = view;
                }
                l2 = l;
                n = n3;
                if (transitionValues3 != null) {
                    view = this.mPropagation;
                    l2 = l;
                    if (view != null) {
                        l2 = view.getStartDelay(viewGroup, this, transitionValues2, (TransitionValues)transitionValuesMaps3);
                        sparseIntArray.put(this.mAnimators.size(), (int)l2);
                        l2 = Math.min(l2, l);
                    }
                    arrayMap.put((Object)transitionValues3, (Object)new AnimationInfo((View)transitionValuesMaps, this.getName(), this, ViewUtils.getWindowId((View)viewGroup), transitionValues));
                    this.mAnimators.add((Animator)transitionValues3);
                    n = n3;
                }
            }
            n3 = n + 1;
            l = l2;
        }
        if (sparseIntArray.size() == 0) return;
        n3 = 0;
        while (n3 < sparseIntArray.size()) {
            n = sparseIntArray.keyAt(n3);
            viewGroup = this.mAnimators.get(n);
            viewGroup.setStartDelay((long)sparseIntArray.valueAt(n3) - l + viewGroup.getStartDelay());
            ++n3;
        }
    }

    protected void end() {
        int n;
        this.mNumInstances = n = this.mNumInstances - 1;
        if (n != 0) return;
        ArrayList arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            arrayList = (ArrayList)this.mListeners.clone();
            int n2 = arrayList.size();
            for (n = 0; n < n2; ++n) {
                ((TransitionListener)arrayList.get(n)).onTransitionEnd(this);
            }
        }
        for (n = 0; n < this.mStartValues.mItemIdValues.size(); ++n) {
            arrayList = (View)this.mStartValues.mItemIdValues.valueAt(n);
            if (arrayList == null) continue;
            ViewCompat.setHasTransientState((View)arrayList, (boolean)false);
        }
        n = 0;
        while (true) {
            if (n >= this.mEndValues.mItemIdValues.size()) {
                this.mEnded = true;
                return;
            }
            arrayList = (View)this.mEndValues.mItemIdValues.valueAt(n);
            if (arrayList != null) {
                ViewCompat.setHasTransientState((View)arrayList, (boolean)false);
            }
            ++n;
        }
    }

    public Transition excludeChildren(int n, boolean bl) {
        this.mTargetIdChildExcludes = this.excludeId(this.mTargetIdChildExcludes, n, bl);
        return this;
    }

    public Transition excludeChildren(View view, boolean bl) {
        this.mTargetChildExcludes = this.excludeView(this.mTargetChildExcludes, view, bl);
        return this;
    }

    public Transition excludeChildren(Class<?> clazz, boolean bl) {
        this.mTargetTypeChildExcludes = this.excludeType(this.mTargetTypeChildExcludes, clazz, bl);
        return this;
    }

    public Transition excludeTarget(int n, boolean bl) {
        this.mTargetIdExcludes = this.excludeId(this.mTargetIdExcludes, n, bl);
        return this;
    }

    public Transition excludeTarget(View view, boolean bl) {
        this.mTargetExcludes = this.excludeView(this.mTargetExcludes, view, bl);
        return this;
    }

    public Transition excludeTarget(Class<?> clazz, boolean bl) {
        this.mTargetTypeExcludes = this.excludeType(this.mTargetTypeExcludes, clazz, bl);
        return this;
    }

    public Transition excludeTarget(String string, boolean bl) {
        this.mTargetNameExcludes = Transition.excludeObject(this.mTargetNameExcludes, string, bl);
        return this;
    }

    void forceToEnd(ViewGroup viewGroup) {
        AnimationInfo animationInfo = Transition.getRunningAnimators();
        int n = animationInfo.size();
        if (viewGroup == null) return;
        if (n == 0) {
            return;
        }
        WindowIdImpl windowIdImpl = ViewUtils.getWindowId((View)viewGroup);
        viewGroup = new ArrayMap(animationInfo);
        animationInfo.clear();
        --n;
        while (n >= 0) {
            animationInfo = (AnimationInfo)viewGroup.valueAt(n);
            if (animationInfo.mView != null && windowIdImpl != null && windowIdImpl.equals(animationInfo.mWindowId)) {
                ((Animator)viewGroup.keyAt(n)).end();
            }
            --n;
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback != null) return epicenterCallback.onGetEpicenter(this);
        return null;
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    TransitionValues getMatchedTransitionValues(View object, boolean bl) {
        int n;
        Object object2 = this.mParent;
        if (object2 != null) {
            return object2.getMatchedTransitionValues((View)object, bl);
        }
        object2 = bl ? this.mStartValuesList : this.mEndValuesList;
        Object var8_4 = null;
        if (object2 == null) {
            return null;
        }
        int n2 = ((ArrayList)object2).size();
        int n3 = -1;
        int n4 = 0;
        while (true) {
            n = n3;
            if (n4 >= n2) break;
            TransitionValues transitionValues = (TransitionValues)((ArrayList)object2).get(n4);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.view == object) {
                n = n4;
                break;
            }
            ++n4;
        }
        object = var8_4;
        if (n < 0) return object;
        object = bl ? this.mEndValuesList : this.mStartValuesList;
        object = (TransitionValues)((ArrayList)object).get(n);
        return object;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean bl) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, bl);
        }
        transitionSet = bl ? this.mStartValues : this.mEndValues;
        return (TransitionValues)transitionSet.mViewValues.get((Object)view);
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        boolean bl;
        boolean bl2 = bl = false;
        if (transitionValues == null) return bl2;
        bl2 = bl;
        if (transitionValues2 == null) return bl2;
        Object object = this.getTransitionProperties();
        if (object == null) {
            object = transitionValues.values.keySet().iterator();
            do {
                bl2 = bl;
                if (!object.hasNext()) return bl2;
            } while (!Transition.isValueChanged(transitionValues, transitionValues2, (String)object.next()));
        } else {
            int n = ((String[])object).length;
            int n2 = 0;
            while (true) {
                bl2 = bl;
                if (n2 >= n) return bl2;
                if (Transition.isValueChanged(transitionValues, transitionValues2, (String)object[n2])) break;
                ++n2;
            }
        }
        bl2 = true;
        return bl2;
    }

    boolean isValidTarget(View view) {
        int n;
        int n2 = view.getId();
        ArrayList<Object> arrayList = this.mTargetIdExcludes;
        if (arrayList != null && arrayList.contains(n2)) {
            return false;
        }
        arrayList = this.mTargetExcludes;
        if (arrayList != null && arrayList.contains(view)) {
            return false;
        }
        arrayList = this.mTargetTypeExcludes;
        if (arrayList != null) {
            int n3 = arrayList.size();
            for (n = 0; n < n3; ++n) {
                if (!this.mTargetTypeExcludes.get(n).isInstance(view)) continue;
                return false;
            }
        }
        if (this.mTargetNameExcludes != null && ViewCompat.getTransitionName((View)view) != null && this.mTargetNameExcludes.contains(ViewCompat.getTransitionName((View)view))) {
            return false;
        }
        if (this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && ((arrayList = this.mTargetTypes) == null || arrayList.isEmpty())) {
            arrayList = this.mTargetNames;
            if (arrayList == null) return true;
            if (arrayList.isEmpty()) {
                return true;
            }
        }
        if (this.mTargetIds.contains(n2)) return true;
        if (this.mTargets.contains(view)) {
            return true;
        }
        arrayList = this.mTargetNames;
        if (arrayList != null && arrayList.contains(ViewCompat.getTransitionName((View)view))) {
            return true;
        }
        if (this.mTargetTypes == null) return false;
        n = 0;
        while (n < this.mTargetTypes.size()) {
            if (this.mTargetTypes.get(n).isInstance(view)) {
                return true;
            }
            ++n;
        }
        return false;
    }

    public void pause(View object) {
        int n;
        if (this.mEnded) return;
        for (n = this.mCurrentAnimators.size() - 1; n >= 0; --n) {
            AnimatorUtils.pause((Animator)this.mCurrentAnimators.get(n));
        }
        object = this.mListeners;
        if (object != null && ((ArrayList)object).size() > 0) {
            object = (ArrayList)this.mListeners.clone();
            int n2 = ((ArrayList)object).size();
            for (n = 0; n < n2; ++n) {
                ((TransitionListener)((ArrayList)object).get(n)).onTransitionPause(this);
            }
        }
        this.mPaused = true;
    }

    void playTransition(ViewGroup viewGroup) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        this.matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        int n = arrayMap.size();
        WindowIdImpl windowIdImpl = ViewUtils.getWindowId((View)viewGroup);
        --n;
        while (true) {
            AnimationInfo animationInfo;
            if (n < 0) {
                this.createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
                this.runAnimators();
                return;
            }
            Animator animator = (Animator)arrayMap.keyAt(n);
            if (animator != null && (animationInfo = (AnimationInfo)arrayMap.get((Object)animator)) != null && animationInfo.mView != null && windowIdImpl.equals(animationInfo.mWindowId)) {
                boolean bl;
                TransitionValues transitionValues;
                TransitionValues transitionValues2 = animationInfo.mValues;
                View view = animationInfo.mView;
                TransitionValues transitionValues3 = this.getTransitionValues(view, true);
                TransitionValues transitionValues4 = transitionValues = this.getMatchedTransitionValues(view, true);
                if (transitionValues3 == null) {
                    transitionValues4 = transitionValues;
                    if (transitionValues == null) {
                        transitionValues4 = (TransitionValues)this.mEndValues.mViewValues.get((Object)view);
                    }
                }
                if (bl = (transitionValues3 != null || transitionValues4 != null) && animationInfo.mTransition.isTransitionRequired(transitionValues2, transitionValues4)) {
                    if (!animator.isRunning() && !animator.isStarted()) {
                        arrayMap.remove((Object)animator);
                    } else {
                        animator.cancel();
                    }
                }
            }
            --n;
        }
    }

    public Transition removeListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(transitionListener);
        if (this.mListeners.size() != 0) return this;
        this.mListeners = null;
        return this;
    }

    public Transition removeTarget(int n) {
        if (n == 0) return this;
        this.mTargetIds.remove((Object)n);
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public Transition removeTarget(Class<?> clazz) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList == null) return this;
        arrayList.remove(clazz);
        return this;
    }

    public Transition removeTarget(String string) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList == null) return this;
        arrayList.remove(string);
        return this;
    }

    public void resume(View object) {
        if (!this.mPaused) return;
        if (!this.mEnded) {
            int n;
            for (n = this.mCurrentAnimators.size() - 1; n >= 0; --n) {
                AnimatorUtils.resume((Animator)this.mCurrentAnimators.get(n));
            }
            object = this.mListeners;
            if (object != null && ((ArrayList)object).size() > 0) {
                object = (ArrayList)this.mListeners.clone();
                int n2 = ((ArrayList)object).size();
                for (n = 0; n < n2; ++n) {
                    ((TransitionListener)((ArrayList)object).get(n)).onTransitionResume(this);
                }
            }
        }
        this.mPaused = false;
    }

    protected void runAnimators() {
        this.start();
        ArrayMap<Animator, AnimationInfo> arrayMap = Transition.getRunningAnimators();
        Iterator<Animator> iterator = this.mAnimators.iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.mAnimators.clear();
                this.end();
                return;
            }
            Animator animator = iterator.next();
            if (!arrayMap.containsKey((Object)animator)) continue;
            this.start();
            this.runAnimator(animator, arrayMap);
        }
    }

    void setCanRemoveViews(boolean bl) {
        this.mCanRemoveViews = bl;
    }

    public Transition setDuration(long l) {
        this.mDuration = l;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int ... nArray) {
        if (nArray != null && nArray.length != 0) {
            for (int i = 0; i < nArray.length; ++i) {
                if (!Transition.isValidMatch(nArray[i])) throw new IllegalArgumentException("matches contains invalid value");
                if (Transition.alreadyContains(nArray, i)) throw new IllegalArgumentException("matches contains a duplicate value");
            }
            this.mMatchOrder = (int[])nArray.clone();
        } else {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
        }
    }

    public void setPathMotion(PathMotion pathMotion) {
        this.mPathMotion = pathMotion == null ? STRAIGHT_PATH_MOTION : pathMotion;
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public Transition setStartDelay(long l) {
        this.mStartDelay = l;
        return this;
    }

    protected void start() {
        if (this.mNumInstances == 0) {
            ArrayList arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                arrayList = (ArrayList)this.mListeners.clone();
                int n = arrayList.size();
                for (int i = 0; i < n; ++i) {
                    ((TransitionListener)arrayList.get(i)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        ++this.mNumInstances;
    }

    public String toString() {
        return this.toString("");
    }

    String toString(String charSequence) {
        CharSequence charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append(this.getClass().getSimpleName());
        ((StringBuilder)charSequence2).append("@");
        ((StringBuilder)charSequence2).append(Integer.toHexString(this.hashCode()));
        ((StringBuilder)charSequence2).append(": ");
        charSequence2 = ((StringBuilder)charSequence2).toString();
        charSequence = charSequence2;
        if (this.mDuration != -1L) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("dur(");
            ((StringBuilder)charSequence).append(this.mDuration);
            ((StringBuilder)charSequence).append(") ");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        charSequence2 = charSequence;
        if (this.mStartDelay != -1L) {
            charSequence2 = new StringBuilder();
            ((StringBuilder)charSequence2).append((String)charSequence);
            ((StringBuilder)charSequence2).append("dly(");
            ((StringBuilder)charSequence2).append(this.mStartDelay);
            ((StringBuilder)charSequence2).append(") ");
            charSequence2 = ((StringBuilder)charSequence2).toString();
        }
        charSequence = charSequence2;
        if (this.mInterpolator != null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append((String)charSequence2);
            ((StringBuilder)charSequence).append("interp(");
            ((StringBuilder)charSequence).append(this.mInterpolator);
            ((StringBuilder)charSequence).append(") ");
            charSequence = ((StringBuilder)charSequence).toString();
        }
        if (this.mTargetIds.size() <= 0) {
            charSequence2 = charSequence;
            if (this.mTargets.size() <= 0) return charSequence2;
        }
        charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append((String)charSequence);
        ((StringBuilder)charSequence2).append("tgts(");
        charSequence2 = ((StringBuilder)charSequence2).toString();
        int n = this.mTargetIds.size();
        int n2 = 0;
        charSequence = charSequence2;
        if (n > 0) {
            n = 0;
            while (true) {
                charSequence = charSequence2;
                if (n >= this.mTargetIds.size()) break;
                charSequence = charSequence2;
                if (n > 0) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append((String)charSequence2);
                    ((StringBuilder)charSequence).append(", ");
                    charSequence = ((StringBuilder)charSequence).toString();
                }
                charSequence2 = new StringBuilder();
                ((StringBuilder)charSequence2).append((String)charSequence);
                ((StringBuilder)charSequence2).append(this.mTargetIds.get(n));
                charSequence2 = ((StringBuilder)charSequence2).toString();
                ++n;
            }
        }
        charSequence2 = charSequence;
        if (this.mTargets.size() > 0) {
            n = n2;
            while (true) {
                charSequence2 = charSequence;
                if (n >= this.mTargets.size()) break;
                charSequence2 = charSequence;
                if (n > 0) {
                    charSequence2 = new StringBuilder();
                    ((StringBuilder)charSequence2).append((String)charSequence);
                    ((StringBuilder)charSequence2).append(", ");
                    charSequence2 = ((StringBuilder)charSequence2).toString();
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append((String)charSequence2);
                ((StringBuilder)charSequence).append(this.mTargets.get(n));
                charSequence = ((StringBuilder)charSequence).toString();
                ++n;
            }
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append((String)charSequence2);
        ((StringBuilder)charSequence).append(")");
        charSequence2 = ((StringBuilder)charSequence).toString();
        return charSequence2;
    }
}
