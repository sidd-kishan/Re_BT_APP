/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.os.SystemClock
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 *  android.widget.ListAdapter
 *  android.widget.ListView
 *  androidx.collection.LongSparseArray
 *  androidx.core.view.ViewCompat
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$Manipulator
 *  com.qmuiteam.qmui.widget.QMUIAnimationListView$WrapperAdapter
 */
package com.qmuiteam.qmui.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.collection.LongSparseArray;
import androidx.core.view.ViewCompat;
import com.qmuiteam.qmui.widget.QMUIAnimationListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class QMUIAnimationListView
extends ListView {
    private static final float DEFAULT_OFFSET_DURATION_UNIT = 0.5f;
    private static final long DURATION_ALPHA = 300L;
    private static final long DURATION_OFFSET_MAX = 1000L;
    private static final long DURATION_OFFSET_MIN = 0L;
    private static final String TAG = "QMUIAnimationListView";
    protected final Set<Long> mAfterVisible;
    private int mAnimationManipulateDurationLimit = 0;
    protected final Set<Long> mBeforeVisible;
    private ValueAnimator mChangeDisappearAnimator;
    private long mChangeDisappearPlayTime = 0L;
    protected final LongSparseArray<View> mDetachViewsMap;
    private boolean mIsAnimating = false;
    private long mLastManipulateTime = 0L;
    private float mOffsetDurationUnit = 0.5f;
    private Interpolator mOffsetInterpolator;
    private boolean mOpenChangeDisappearAnimation = false;
    private final List<Manipulator> mPendingManipulations;
    private final List<Manipulator> mPendingManipulationsWithoutAnimation;
    protected final LongSparseArray<Integer> mPositionMap;
    private ListAdapter mRealAdapter;
    protected final LongSparseArray<Integer> mTopMap = new LongSparseArray();
    private WrapperAdapter mWrapperAdapter;

    public QMUIAnimationListView(Context context) {
        this(context, null);
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPositionMap = new LongSparseArray();
        this.mDetachViewsMap = new LongSparseArray();
        this.mBeforeVisible = new HashSet<Long>();
        this.mAfterVisible = new HashSet<Long>();
        this.mPendingManipulations = new ArrayList<Manipulator>();
        this.mPendingManipulationsWithoutAnimation = new ArrayList<Manipulator>();
        this.mOffsetInterpolator = new LinearInterpolator();
        this.init();
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mPositionMap = new LongSparseArray();
        this.mDetachViewsMap = new LongSparseArray();
        this.mBeforeVisible = new HashSet<Long>();
        this.mAfterVisible = new HashSet<Long>();
        this.mPendingManipulations = new ArrayList<Manipulator>();
        this.mPendingManipulationsWithoutAnimation = new ArrayList<Manipulator>();
        this.mOffsetInterpolator = new LinearInterpolator();
        this.init();
    }

    public QMUIAnimationListView(Context context, AttributeSet attributeSet, int n, int n2) {
        super(context, attributeSet, n, n2);
        this.mPositionMap = new LongSparseArray();
        this.mDetachViewsMap = new LongSparseArray();
        this.mBeforeVisible = new HashSet<Long>();
        this.mAfterVisible = new HashSet<Long>();
        this.mPendingManipulations = new ArrayList<Manipulator>();
        this.mPendingManipulationsWithoutAnimation = new ArrayList<Manipulator>();
        this.mOffsetInterpolator = new LinearInterpolator();
        this.init();
    }

    static /* synthetic */ WrapperAdapter access$100(QMUIAnimationListView qMUIAnimationListView) {
        return qMUIAnimationListView.mWrapperAdapter;
    }

    static /* synthetic */ void access$200(QMUIAnimationListView qMUIAnimationListView) {
        qMUIAnimationListView.doPostLayoutAnimation();
    }

    static /* synthetic */ long access$302(QMUIAnimationListView qMUIAnimationListView, long l) {
        qMUIAnimationListView.mChangeDisappearPlayTime = l;
        return l;
    }

    static /* synthetic */ void access$400(QMUIAnimationListView qMUIAnimationListView) {
        qMUIAnimationListView.finishAnimation();
    }

    static /* synthetic */ boolean access$502(QMUIAnimationListView qMUIAnimationListView, boolean bl) {
        qMUIAnimationListView.mIsAnimating = bl;
        return bl;
    }

    static /* synthetic */ void access$600(QMUIAnimationListView qMUIAnimationListView) {
        qMUIAnimationListView.manipulatePending();
    }

    private void doAnimation() {
        this.setEnabled(false);
        this.setClickable(false);
        this.doPreLayoutAnimation((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    /*
     * Unable to fully structure code
     */
    private void doPostLayoutAnimation() {
        var13_1 = new AnimatorSet();
        var8_2 = this.getChildCount();
        var7_3 = this.getFirstVisiblePosition();
        var9_4 = this.mOpenChangeDisappearAnimation;
        var4_5 = 0;
        if (var9_4) {
            for (var1_6 = 0; var1_6 < this.mDetachViewsMap.size(); ++var1_6) {
                ViewCompat.setHasTransientState((View)((View)this.mDetachViewsMap.valueAt(var1_6)), (boolean)false);
            }
        }
        var12_7 = null;
        var2_8 = -1;
        var1_6 = -1;
        while (var4_5 < var8_2) {
            block11: {
                block10: {
                    var14_13 = this.getChildAt(var4_5);
                    var14_13.setAlpha(1.0f);
                    var5_10 = var14_13.getTop();
                    var6_11 = var7_3 + var4_5;
                    var10_12 = this.mWrapperAdapter.getItemId(var6_11);
                    if (this.mTopMap.indexOfKey(var10_12) <= -1) break block10;
                    var2_8 = (Integer)this.mTopMap.get(var10_12);
                    this.mTopMap.remove(var10_12);
                    this.mPositionMap.remove(var10_12);
                    if (this.mOpenChangeDisappearAnimation) {
                        this.mDetachViewsMap.remove(var10_12);
                    }
                    if (var2_8 != var5_10) {
                        var12_7 = this.getOffsetAnimator(var14_13, var2_8, var5_10);
                    }
                    ** GOTO lbl35
                }
                if (!this.mBeforeVisible.contains(var10_12)) break block11;
                var12_7 = this.getOffsetAnimator(var14_13, -var14_13.getHeight(), var5_10);
                ** GOTO lbl35
            }
            if (this.mAfterVisible.contains(var10_12)) {
                var12_7 = this.getOffsetAnimator(var14_13, this.getHeight(), var5_10);
lbl35:
                // 3 sources

                var2_8 = -1;
            } else {
                var3_9 = var2_8;
                if (var2_8 == -1) {
                    var3_9 = var5_10;
                    var1_6 = var6_11;
                }
                var12_7 = this.getAddAnimator(var14_13, var5_10, var6_11, var3_9, var1_6);
                var2_8 = var3_9;
            }
            if (var12_7 != null) {
                var13_1.play((Animator)var12_7);
            }
            ++var4_5;
        }
        if (this.mOpenChangeDisappearAnimation && this.mDetachViewsMap.size() > 0) {
            this.mChangeDisappearAnimator = var12_7 = ValueAnimator.ofFloat((float[])new float[]{0.0f, 1.0f});
            var12_7.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
            this.mChangeDisappearAnimator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            this.mChangeDisappearAnimator.setDuration(this.getChangeDisappearDuration());
            this.mChangeDisappearAnimator.start();
        }
        var13_1.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        var13_1.start();
    }

    private void doPreLayoutAnimation(Animator.AnimatorListener animatorListener) {
        Animator animator;
        int n;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList<Long> arrayList = new ArrayList<Long>();
        int n2 = 0;
        for (n = 0; n < this.mTopMap.size(); ++n) {
            long l = this.mTopMap.keyAt(n);
            if (this.getPositionForId(l) >= 0) continue;
            animator = this.getDeleteAnimator(this.getChildAt((Integer)this.mPositionMap.get(l)));
            this.mPositionMap.remove(l);
            animatorSet.play(animator);
            arrayList.add(l);
        }
        for (n = 0; n < arrayList.size(); ++n) {
            this.mTopMap.remove(((Long)arrayList.get(n)).longValue());
        }
        if (this.mOpenChangeDisappearAnimation) {
            for (n = n2; n < this.mPositionMap.size(); ++n) {
                animator = this.getChildAt((Integer)this.mPositionMap.valueAt(n));
                ViewCompat.setHasTransientState((View)animator, (boolean)true);
                this.mDetachViewsMap.put(this.mPositionMap.keyAt(n), (Object)animator);
            }
        }
        if (!animatorSet.getChildAnimations().isEmpty()) {
            animatorSet.addListener(animatorListener);
            animatorSet.start();
        } else {
            animatorListener.onAnimationEnd((Animator)animatorSet);
        }
    }

    private void finishAnimation() {
        this.mWrapperAdapter.setShouldNotifyChange(true);
        this.mChangeDisappearAnimator = null;
        if (this.mOpenChangeDisappearAnimation) {
            for (int i = 0; i < this.mDetachViewsMap.size(); ++i) {
                ((View)this.mDetachViewsMap.valueAt(i)).setAlpha(1.0f);
            }
            this.mDetachViewsMap.clear();
        }
        this.mIsAnimating = false;
        this.setEnabled(true);
        this.setClickable(true);
        this.manipulatePending();
    }

    private long getOffsetDuration(int n, int n2) {
        return Math.max(0L, Math.min((long)((float)Math.abs(n - n2) * this.mOffsetDurationUnit), 1000L));
    }

    private void init() {
        this.setWillNotDraw(false);
    }

    private void manipulatePending() {
        if (!this.mPendingManipulationsWithoutAnimation.isEmpty()) {
            this.mIsAnimating = true;
            Iterator<Manipulator> iterator = this.mPendingManipulationsWithoutAnimation.iterator();
            while (iterator.hasNext()) {
                iterator.next().manipulate(this.mRealAdapter);
            }
            this.mPendingManipulationsWithoutAnimation.clear();
            this.mWrapperAdapter.notifyDataSetChanged();
            this.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
        } else {
            if (this.mPendingManipulations.isEmpty()) {
                return;
            }
            this.mIsAnimating = true;
            this.prepareAnimation();
            Iterator<Manipulator> iterator = this.mPendingManipulations.iterator();
            while (iterator.hasNext()) {
                iterator.next().manipulate(this.mRealAdapter);
            }
            this.mPendingManipulations.clear();
            this.doAnimation();
        }
    }

    private void prepareAnimation() {
        int n;
        long l;
        this.mTopMap.clear();
        this.mPositionMap.clear();
        this.mBeforeVisible.clear();
        this.mAfterVisible.clear();
        this.mDetachViewsMap.clear();
        WrapperAdapter wrapperAdapter = this.mWrapperAdapter;
        int n2 = 0;
        wrapperAdapter.setShouldNotifyChange(false);
        int n3 = this.getChildCount();
        int n4 = this.getFirstVisiblePosition();
        int n5 = 0;
        while (true) {
            if (n5 >= n3) break;
            wrapperAdapter = this.getChildAt(n5);
            l = this.mWrapperAdapter.getItemId(n4 + n5);
            this.mTopMap.put(l, (Object)wrapperAdapter.getTop());
            this.mPositionMap.put(l, (Object)n5);
            ++n5;
        }
        for (n = n2; n < n4; ++n) {
            l = this.mWrapperAdapter.getItemId(n);
            this.mBeforeVisible.add(l);
        }
        n5 = this.mWrapperAdapter.getCount();
        n = n4 + n3;
        while (n < n5) {
            l = this.mWrapperAdapter.getItemId(n);
            this.mAfterVisible.add(l);
            ++n;
        }
    }

    protected ObjectAnimator alphaObjectAnimator(View view, boolean bl, long l, boolean bl2) {
        Object object = new float[2];
        if (bl) {
            object[0] = 0.0f;
            object[1] = 1.0f;
        } else {
            object[0] = 1.0f;
            object[1] = 0.0f;
        }
        object = ObjectAnimator.ofFloat((Object)view, (String)"alpha", (float[])object);
        object.setDuration(l);
        if (!bl2) return object;
        object.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        return object;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        boolean bl = this.isEnabled() && super.dispatchTouchEvent(motionEvent);
        return bl;
    }

    protected Animator getAddAnimator(View view, int n, int n2, int n3, int n4) {
        view.setAlpha(0.0f);
        view.clearAnimation();
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play((Animator)this.alphaObjectAnimator(view, true, 50L, false));
        if (n3 != n) {
            animatorSet.play(this.getOffsetAnimator(view, n3, n));
        }
        animatorSet.setStartDelay((long)((float)view.getHeight() * this.mOffsetDurationUnit));
        return animatorSet;
    }

    protected long getChangeDisappearDuration() {
        return (long)((float)this.getHeight() * this.mOffsetDurationUnit);
    }

    protected Animator getDeleteAnimator(View view) {
        return this.alphaObjectAnimator(view, false, 300L, true);
    }

    protected Animator getOffsetAnimator(View view, int n, int n2) {
        return this.getOffsetAnimator(view, n, n2, this.getOffsetDuration(n, n2));
    }

    protected Animator getOffsetAnimator(View view, int n, int n2, long l) {
        view = ObjectAnimator.ofFloat((Object)view, (String)"translationY", (float[])new float[]{n - n2, 0.0f});
        view.setDuration(l);
        view.setInterpolator((TimeInterpolator)this.mOffsetInterpolator);
        return view;
    }

    public float getOffsetDurationUnit() {
        return this.mOffsetDurationUnit;
    }

    protected int getPositionForId(long l) {
        int n = 0;
        while (n < this.mWrapperAdapter.getCount()) {
            if (this.mWrapperAdapter.getItemId(n) == l) {
                return n;
            }
            ++n;
        }
        return -1;
    }

    public ListAdapter getRealAdapter() {
        return this.mRealAdapter;
    }

    public <T extends ListAdapter> void manipulate(Manipulator<T> manipulator) {
        Log.i((String)TAG, (String)"manipulate");
        if (!this.mWrapperAdapter.isAnimationEnabled()) {
            this.manipulateWithoutAnimation(manipulator);
            return;
        }
        long l = SystemClock.uptimeMillis();
        boolean bl = l - this.mLastManipulateTime > (long)this.mAnimationManipulateDurationLimit;
        this.mLastManipulateTime = l;
        if (!this.mIsAnimating) {
            if (bl) {
                this.mIsAnimating = true;
                this.prepareAnimation();
                manipulator.manipulate(this.mRealAdapter);
                this.doAnimation();
            } else {
                manipulator.manipulate(this.mRealAdapter);
                this.mWrapperAdapter.notifyDataSetChanged();
            }
        } else if (bl) {
            this.mPendingManipulations.add(manipulator);
        } else {
            this.mPendingManipulationsWithoutAnimation.add(manipulator);
        }
    }

    public <T extends ListAdapter> void manipulateWithoutAnimation(Manipulator<T> manipulator) {
        Log.i((String)TAG, (String)"manipulateWithoutAnimation");
        if (!this.mIsAnimating) {
            manipulator.manipulate(this.mRealAdapter);
            this.mWrapperAdapter.notifyDataSetChanged();
        } else {
            this.mPendingManipulationsWithoutAnimation.add(manipulator);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.mOpenChangeDisappearAnimation) return;
        ValueAnimator valueAnimator = this.mChangeDisappearAnimator;
        if (valueAnimator == null) return;
        if (!valueAnimator.isStarted()) return;
        if (this.mDetachViewsMap.size() <= 0) return;
        if (!this.mIsAnimating) return;
        int n = 0;
        while (n < this.mDetachViewsMap.size()) {
            block5: {
                int n2;
                block4: {
                    int n3;
                    long l;
                    block3: {
                        l = this.mDetachViewsMap.keyAt(n);
                        valueAnimator = (View)this.mDetachViewsMap.valueAt(n);
                        n3 = this.getPositionForId(l);
                        n2 = (int)((float)this.mChangeDisappearPlayTime / this.mOffsetDurationUnit);
                        if (n3 >= this.getFirstVisiblePosition()) break block3;
                        n2 = n3 = (Integer)this.mTopMap.get(l) - n2;
                        if (n3 >= -valueAnimator.getHeight()) break block4;
                        break block5;
                    }
                    n2 = n3 = (Integer)this.mTopMap.get(l) + n2;
                    if (n3 > this.getHeight()) break block5;
                }
                valueAnimator.layout(0, n2, valueAnimator.getWidth(), valueAnimator.getHeight() + n2);
                valueAnimator.setAlpha(1.0f - (float)this.mChangeDisappearPlayTime * 1.0f / (float)this.getChangeDisappearDuration());
                this.drawChild(canvas, (View)valueAnimator, this.getDrawingTime());
            }
            ++n;
        }
    }

    public void setAdapter(ListAdapter object) {
        this.mRealAdapter = object;
        object = object != null ? new WrapperAdapter(this.mRealAdapter) : null;
        this.mWrapperAdapter = object;
        super.setAdapter(object);
    }

    public void setAnimationManipulateDurationLimit(int n) {
        this.mAnimationManipulateDurationLimit = n;
    }

    public void setOffsetDurationUnit(float f) {
        this.mOffsetDurationUnit = f;
    }

    public void setOffsetInterpolator(Interpolator interpolator) {
        this.mOffsetInterpolator = interpolator;
    }

    public void setOpenChangeDisappearAnimation(boolean bl) {
        this.mOpenChangeDisappearAnimation = bl;
    }
}
