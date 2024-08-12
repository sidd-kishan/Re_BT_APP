/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.Interpolator
 *  androidx.constraintlayout.motion.utils.StopLogic
 *  androidx.constraintlayout.motion.widget.Debug
 *  androidx.constraintlayout.motion.widget.DesignTool
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.MotionController
 *  androidx.constraintlayout.motion.widget.MotionHelper
 *  androidx.constraintlayout.motion.widget.MotionInterpolator
 *  androidx.constraintlayout.motion.widget.MotionLayout$2
 *  androidx.constraintlayout.motion.widget.MotionLayout$DecelerateInterpolator
 *  androidx.constraintlayout.motion.widget.MotionLayout$DevModeDraw
 *  androidx.constraintlayout.motion.widget.MotionLayout$Model
 *  androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
 *  androidx.constraintlayout.motion.widget.MotionLayout$MyTracker
 *  androidx.constraintlayout.motion.widget.MotionLayout$StateCache
 *  androidx.constraintlayout.motion.widget.MotionLayout$TransitionListener
 *  androidx.constraintlayout.motion.widget.MotionLayout$TransitionState
 *  androidx.constraintlayout.motion.widget.MotionScene
 *  androidx.constraintlayout.motion.widget.MotionScene$Transition
 *  androidx.constraintlayout.motion.widget.TouchResponse
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 *  androidx.core.view.NestedScrollingParent3
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.DesignTool;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionInterpolator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.HashMap;

/*
 * Exception performing whole class analysis ignored.
 */
public class MotionLayout
extends ConstraintLayout
implements NestedScrollingParent3 {
    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 1.0E-5f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown = true;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime = 0L;
    private int mBeginState = -1;
    private RectF mBoundsCheck;
    int mCurrentState = -1;
    int mDebugPath = 0;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState = -1;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap<View, MotionController> mFrameArrayList = new HashMap();
    private int mFrames = 0;
    int mHeightMeasureMode;
    private boolean mInLayout = false;
    boolean mInTransition = false;
    boolean mIndirectTransition = false;
    private boolean mInteractionEnabled = true;
    Interpolator mInterpolator;
    boolean mIsAnimating = false;
    private boolean mKeepAnimating = false;
    private KeyCache mKeyCache;
    private long mLastDrawTime = -1L;
    private float mLastFps = 0.0f;
    private int mLastHeightMeasureSpec = 0;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity = 0.0f;
    private int mLastWidthMeasureSpec = 0;
    private float mListenerPosition = 0.0f;
    private int mListenerState = 0;
    protected boolean mMeasureDuringTransition = false;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted = false;
    int mOldHeight;
    int mOldWidth;
    private ArrayList<MotionHelper> mOnHideHelpers = null;
    private ArrayList<MotionHelper> mOnShowHelpers = null;
    float mPostInterpolationPosition;
    private View mRegionView = null;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic = new StopLogic();
    private boolean mTemporalInterpolator = false;
    ArrayList<Integer> mTransitionCompleted;
    private float mTransitionDuration = 1.0f;
    float mTransitionGoalPosition = 0.0f;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition = 0.0f;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList<TransitionListener> mTransitionListeners = null;
    float mTransitionPosition = 0.0f;
    TransitionState mTransitionState;
    boolean mUndergoingMotion = false;
    int mWidthMeasureMode;

    public MotionLayout(Context context) {
        super(context);
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mKeyCache = new KeyCache();
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mBoundsCheck = new RectF();
        this.mTransitionCompleted = new ArrayList();
        this.init(null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mKeyCache = new KeyCache();
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mBoundsCheck = new RectF();
        this.mTransitionCompleted = new ArrayList();
        this.init(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.mKeyCache = new KeyCache();
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mBoundsCheck = new RectF();
        this.mTransitionCompleted = new ArrayList();
        this.init(attributeSet);
    }

    static /* synthetic */ int access$000(MotionLayout motionLayout) {
        return motionLayout.mEndState;
    }

    static /* synthetic */ int access$100(MotionLayout motionLayout) {
        return motionLayout.mBeginState;
    }

    static /* synthetic */ int access$1000(MotionLayout motionLayout) {
        return motionLayout.mLastHeightMeasureSpec;
    }

    static /* synthetic */ void access$1100(MotionLayout motionLayout) {
        motionLayout.setupMotionViews();
    }

    static /* synthetic */ void access$1200(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1300(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1400(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1500(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1600(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1700(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1800(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ void access$1900(MotionLayout motionLayout, ConstraintWidgetContainer constraintWidgetContainer, int n, int n2, int n3) {
        motionLayout.resolveSystem(constraintWidgetContainer, n, n2, n3);
    }

    static /* synthetic */ ConstraintWidgetContainer access$200(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    static /* synthetic */ void access$2000(MotionLayout motionLayout, int n, int n2, int n3, int n4, boolean bl, boolean bl2) {
        motionLayout.resolveMeasuredDimension(n, n2, n3, n4, bl, bl2);
    }

    static /* synthetic */ ConstraintWidgetContainer access$300(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$400(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    static /* synthetic */ ConstraintWidgetContainer access$500(MotionLayout motionLayout) {
        return motionLayout.mLayoutWidget;
    }

    static /* synthetic */ boolean access$600(MotionLayout motionLayout) {
        return motionLayout.isRtl();
    }

    static /* synthetic */ boolean access$700(MotionLayout motionLayout) {
        return motionLayout.isRtl();
    }

    static /* synthetic */ void access$800(MotionLayout motionLayout, boolean bl, View view, ConstraintWidget constraintWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray sparseArray) {
        motionLayout.applyConstraintsFromLayoutParams(bl, view, constraintWidget, layoutParams, sparseArray);
    }

    static /* synthetic */ int access$900(MotionLayout motionLayout) {
        return motionLayout.mLastWidthMeasureSpec;
    }

    private void checkStructure() {
        Object object = this.mScene;
        if (object == null) {
            Log.e((String)"MotionLayout", (String)"CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int n = object.getStartId();
        object = this.mScene;
        this.checkStructure(n, object.getConstraintSet(object.getStartId()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        object = this.mScene.getDefinedTransitions().iterator();
        while (object.hasNext()) {
            StringBuilder stringBuilder;
            Object object2 = (MotionScene.Transition)object.next();
            if (object2 == this.mScene.mCurrentTransition) {
                Log.v((String)"MotionLayout", (String)"CHECK: CURRENT");
            }
            this.checkStructure((MotionScene.Transition)object2);
            n = object2.getStartConstraintSetId();
            int n2 = object2.getEndConstraintSetId();
            object2 = Debug.getName((Context)this.getContext(), (int)n);
            CharSequence charSequence = Debug.getName((Context)this.getContext(), (int)n2);
            if (sparseIntArray.get(n) == n2) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("CHECK: two transitions with the same start and end ");
                stringBuilder.append((String)object2);
                stringBuilder.append("->");
                stringBuilder.append((String)charSequence);
                Log.e((String)"MotionLayout", (String)stringBuilder.toString());
            }
            if (sparseIntArray2.get(n2) == n) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("CHECK: you can't have reverse transitions");
                stringBuilder.append((String)object2);
                stringBuilder.append("->");
                stringBuilder.append((String)charSequence);
                Log.e((String)"MotionLayout", (String)stringBuilder.toString());
            }
            sparseIntArray.put(n, n2);
            sparseIntArray2.put(n2, n);
            if (this.mScene.getConstraintSet(n) == null) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(" no such constraintSetStart ");
                ((StringBuilder)charSequence).append((String)object2);
                Log.e((String)"MotionLayout", (String)((StringBuilder)charSequence).toString());
            }
            if (this.mScene.getConstraintSet(n2) != null) continue;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(" no such constraintSetEnd ");
            ((StringBuilder)charSequence).append((String)object2);
            Log.e((String)"MotionLayout", (String)((StringBuilder)charSequence).toString());
        }
    }

    private void checkStructure(int n, ConstraintSet constraintSet) {
        Object object;
        Object object2;
        String string = Debug.getName((Context)this.getContext(), (int)n);
        int n2 = this.getChildCount();
        int n3 = 0;
        for (n = 0; n < n2; ++n) {
            object2 = this.getChildAt(n);
            int n4 = object2.getId();
            if (n4 == -1) {
                object = new StringBuilder();
                ((StringBuilder)object).append("CHECK: ");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(" ALL VIEWS SHOULD HAVE ID's ");
                ((StringBuilder)object).append(object2.getClass().getName());
                ((StringBuilder)object).append(" does not!");
                Log.w((String)"MotionLayout", (String)((StringBuilder)object).toString());
            }
            if (constraintSet.getConstraint(n4) != null) continue;
            object = new StringBuilder();
            ((StringBuilder)object).append("CHECK: ");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" NO CONSTRAINTS for ");
            ((StringBuilder)object).append(Debug.getName((View)object2));
            Log.w((String)"MotionLayout", (String)((StringBuilder)object).toString());
        }
        object = constraintSet.getKnownIds();
        n = n3;
        while (n < ((int[])object).length) {
            StringBuilder stringBuilder;
            n3 = object[n];
            object2 = Debug.getName((Context)this.getContext(), (int)n3);
            if (this.findViewById((int)object[n]) == null) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("CHECK: ");
                stringBuilder.append(string);
                stringBuilder.append(" NO View matches id ");
                stringBuilder.append((String)object2);
                Log.w((String)"MotionLayout", (String)stringBuilder.toString());
            }
            if (constraintSet.getHeight(n3) == -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("CHECK: ");
                stringBuilder.append(string);
                stringBuilder.append("(");
                stringBuilder.append((String)object2);
                stringBuilder.append(") no LAYOUT_HEIGHT");
                Log.w((String)"MotionLayout", (String)stringBuilder.toString());
            }
            if (constraintSet.getWidth(n3) == -1) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("CHECK: ");
                stringBuilder.append(string);
                stringBuilder.append("(");
                stringBuilder.append((String)object2);
                stringBuilder.append(") no LAYOUT_HEIGHT");
                Log.w((String)"MotionLayout", (String)stringBuilder.toString());
            }
            ++n;
        }
    }

    private void checkStructure(MotionScene.Transition transition) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CHECK: transition = ");
        stringBuilder.append(transition.debugString(this.getContext()));
        Log.v((String)"MotionLayout", (String)stringBuilder.toString());
        stringBuilder = new StringBuilder();
        stringBuilder.append("CHECK: transition.setDuration = ");
        stringBuilder.append(transition.getDuration());
        Log.v((String)"MotionLayout", (String)stringBuilder.toString());
        if (transition.getStartConstraintSetId() != transition.getEndConstraintSetId()) return;
        Log.e((String)"MotionLayout", (String)"CHECK: start and end constraint set should not be the same!");
    }

    private void computeCurrentPositions() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = this.getChildAt(n2);
            MotionController motionController = this.mFrameArrayList.get(view);
            if (motionController != null) {
                motionController.setStartCurrentState(view);
            }
            ++n2;
        }
    }

    private void debugPos() {
        int n = 0;
        while (n < this.getChildCount()) {
            View view = this.getChildAt(n);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" ");
            stringBuilder.append(Debug.getLocation());
            stringBuilder.append(" ");
            stringBuilder.append(Debug.getName((View)this));
            stringBuilder.append(" ");
            stringBuilder.append(Debug.getName((Context)this.getContext(), (int)this.mCurrentState));
            stringBuilder.append(" ");
            stringBuilder.append(Debug.getName((View)view));
            stringBuilder.append(view.getLeft());
            stringBuilder.append(" ");
            stringBuilder.append(view.getTop());
            Log.v((String)"MotionLayout", (String)stringBuilder.toString());
            ++n;
        }
    }

    private void evaluateLayout() {
        Interpolator interpolator;
        int n;
        int n2;
        float f;
        long l;
        block12: {
            block11: {
                float f2 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
                l = this.getNanoTime();
                float f3 = !(this.mInterpolator instanceof StopLogic) ? (float)(l - this.mTransitionLastTime) * f2 * 1.0E-9f / this.mTransitionDuration : 0.0f;
                f = this.mTransitionLastPosition + f3;
                if (this.mTransitionInstantly) {
                    f = this.mTransitionGoalPosition;
                }
                n2 = 0;
                if (f2 > 0.0f && f >= this.mTransitionGoalPosition || f2 <= 0.0f && f <= this.mTransitionGoalPosition) {
                    f = this.mTransitionGoalPosition;
                    n = 1;
                } else {
                    n = 0;
                }
                interpolator = this.mInterpolator;
                f3 = f;
                if (interpolator != null) {
                    f3 = f;
                    if (n == 0) {
                        f3 = this.mTemporalInterpolator ? interpolator.getInterpolation((float)(l - this.mAnimationStartTime) * 1.0E-9f) : interpolator.getInterpolation(f);
                    }
                }
                if (f2 > 0.0f && f3 >= this.mTransitionGoalPosition) break block11;
                f = f3;
                if (!(f2 <= 0.0f)) break block12;
                f = f3;
                if (!(f3 <= this.mTransitionGoalPosition)) break block12;
            }
            f = this.mTransitionGoalPosition;
        }
        this.mPostInterpolationPosition = f;
        int n3 = this.getChildCount();
        l = this.getNanoTime();
        n = n2;
        while (true) {
            if (n >= n3) {
                if (!this.mMeasureDuringTransition) return;
                this.requestLayout();
                return;
            }
            interpolator = this.getChildAt(n);
            MotionController motionController = this.mFrameArrayList.get(interpolator);
            if (motionController != null) {
                motionController.interpolate((View)interpolator, f, l, this.mKeyCache);
            }
            ++n;
        }
    }

    private void fireTransitionChange() {
        float f;
        Object object;
        if (this.mTransitionListener == null) {
            object = this.mTransitionListeners;
            if (object == null) return;
            if (((ArrayList)object).isEmpty()) return;
        }
        if (this.mListenerPosition == this.mTransitionPosition) return;
        if (this.mListenerState != -1) {
            object = this.mTransitionListener;
            if (object != null) {
                object.onTransitionStarted(this, this.mBeginState, this.mEndState);
            }
            if ((object = this.mTransitionListeners) != null) {
                object = ((ArrayList)object).iterator();
                while (object.hasNext()) {
                    ((TransitionListener)object.next()).onTransitionStarted(this, this.mBeginState, this.mEndState);
                }
            }
            this.mIsAnimating = true;
        }
        this.mListenerState = -1;
        this.mListenerPosition = f = this.mTransitionPosition;
        object = this.mTransitionListener;
        if (object != null) {
            object.onTransitionChange(this, this.mBeginState, this.mEndState, f);
        }
        if ((object = this.mTransitionListeners) != null) {
            object = ((ArrayList)object).iterator();
            while (object.hasNext()) {
                ((TransitionListener)object.next()).onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
            }
        }
        this.mIsAnimating = true;
    }

    private void fireTransitionStarted(MotionLayout motionLayout, int n, int n2) {
        Object object = this.mTransitionListener;
        if (object != null) {
            object.onTransitionStarted(this, n, n2);
        }
        if ((object = this.mTransitionListeners) == null) return;
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            ((TransitionListener)object.next()).onTransitionStarted(motionLayout, n, n2);
        }
    }

    private boolean handlesTouchEvent(float f, float f2, View view, MotionEvent motionEvent) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup)view;
            int n = viewGroup.getChildCount();
            for (int i = 0; i < n; ++i) {
                View view2 = viewGroup.getChildAt(i);
                if (!this.handlesTouchEvent((float)view.getLeft() + f, (float)view.getTop() + f2, view2, motionEvent)) continue;
                return true;
            }
        }
        this.mBoundsCheck.set((float)view.getLeft() + f, (float)view.getTop() + f2, f + (float)view.getRight(), f2 + (float)view.getBottom());
        if (motionEvent.getAction() == 0) {
            if (!this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY())) return false;
            if (!view.onTouchEvent(motionEvent)) return false;
            return true;
        }
        if (!view.onTouchEvent(motionEvent)) return false;
        return true;
    }

    private void init(AttributeSet attributeSet) {
        IS_IN_EDIT_MODE = this.isInEditMode();
        if (attributeSet != null) {
            attributeSet = this.getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int n = attributeSet.getIndexCount();
            boolean bl = true;
            for (int i = 0; i < n; ++i) {
                boolean bl2;
                int n2 = attributeSet.getIndex(i);
                if (n2 == R.styleable.MotionLayout_layoutDescription) {
                    n2 = attributeSet.getResourceId(n2, -1);
                    this.mScene = new MotionScene(this.getContext(), this, n2);
                    bl2 = bl;
                } else if (n2 == R.styleable.MotionLayout_currentState) {
                    this.mCurrentState = attributeSet.getResourceId(n2, -1);
                    bl2 = bl;
                } else if (n2 == R.styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = attributeSet.getFloat(n2, 0.0f);
                    this.mInTransition = true;
                    bl2 = bl;
                } else if (n2 == R.styleable.MotionLayout_applyMotionScene) {
                    bl2 = attributeSet.getBoolean(n2, bl);
                } else if (n2 == R.styleable.MotionLayout_showPaths) {
                    bl2 = bl;
                    if (this.mDebugPath == 0) {
                        n2 = attributeSet.getBoolean(n2, false) ? 2 : 0;
                        this.mDebugPath = n2;
                        bl2 = bl;
                    }
                } else {
                    bl2 = bl;
                    if (n2 == R.styleable.MotionLayout_motionDebug) {
                        this.mDebugPath = attributeSet.getInt(n2, 0);
                        bl2 = bl;
                    }
                }
                bl = bl2;
            }
            attributeSet.recycle();
            if (this.mScene == null) {
                Log.e((String)"MotionLayout", (String)"WARNING NO app:layoutDescription tag");
            }
            if (!bl) {
                this.mScene = null;
            }
        }
        if (this.mDebugPath != 0) {
            this.checkStructure();
        }
        if (this.mCurrentState != -1) return;
        attributeSet = this.mScene;
        if (attributeSet == null) return;
        this.mCurrentState = attributeSet.getStartId();
        this.mBeginState = this.mScene.getStartId();
        this.mEndState = this.mScene.getEndId();
    }

    /*
     * Unable to fully structure code
     */
    private void processTransitionCompleted() {
        if (this.mTransitionListener == null) {
            var1_1 = this.mTransitionListeners;
            if (var1_1 == null) return;
            if (var1_1.isEmpty()) {
                return;
            }
        }
        this.mIsAnimating = false;
        var2_2 = this.mTransitionCompleted.iterator();
        block0: while (true) {
            if (!var2_2.hasNext()) {
                this.mTransitionCompleted.clear();
                return;
            }
            var1_1 = var2_2.next();
            var3_3 = this.mTransitionListener;
            if (var3_3 != null) {
                var3_3.onTransitionCompleted(this, var1_1.intValue());
            }
            if ((var3_3 = this.mTransitionListeners) == null) continue;
            var3_3 = var3_3.iterator();
            while (true) {
                if (var3_3.hasNext()) ** break;
                continue block0;
                ((TransitionListener)var3_3.next()).onTransitionCompleted(this, var1_1.intValue());
            }
            break;
        }
    }

    private void setupMotionViews() {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        MotionController motionController;
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        block11: {
            n5 = this.getChildCount();
            this.mModel.build();
            int n6 = 1;
            this.mInTransition = true;
            int n7 = this.getWidth();
            n4 = this.getHeight();
            int n8 = this.mScene.gatPathMotionArc();
            n3 = 0;
            n2 = 0;
            if (n8 != -1) {
                for (n = 0; n < n5; ++n) {
                    motionController = this.mFrameArrayList.get(this.getChildAt(n));
                    if (motionController == null) continue;
                    motionController.setPathMotionArc(n8);
                }
            }
            for (n = 0; n < n5; ++n) {
                motionController = this.mFrameArrayList.get(this.getChildAt(n));
                if (motionController == null) continue;
                this.mScene.getKeyFrames(motionController);
                motionController.setup(n7, n4, this.mTransitionDuration, this.getNanoTime());
            }
            f6 = this.mScene.getStaggered();
            if (f6 == 0.0f) return;
            n = (double)f6 < 0.0 ? 1 : 0;
            f5 = Math.abs(f6);
            f4 = -3.4028235E38f;
            f3 = Float.MAX_VALUE;
            f2 = Float.MAX_VALUE;
            f6 = -3.4028235E38f;
            for (n4 = 0; n4 < n5; ++n4) {
                motionController = this.mFrameArrayList.get(this.getChildAt(n4));
                if (!Float.isNaN(motionController.mMotionStagger)) {
                    n4 = n6;
                    break block11;
                }
                float f7 = motionController.getFinalX();
                f = motionController.getFinalY();
                f = n != 0 ? (f -= f7) : (f += f7);
                f2 = Math.min(f2, f);
                f6 = Math.max(f6, f);
            }
            n4 = 0;
        }
        if (n4 != 0) {
            n3 = 0;
            f = f3;
            f2 = f4;
            while (true) {
                n4 = n2;
                if (n3 >= n5) break;
                motionController = this.mFrameArrayList.get(this.getChildAt(n3));
                f4 = f2;
                f6 = f;
                if (!Float.isNaN(motionController.mMotionStagger)) {
                    f6 = Math.min(f, motionController.mMotionStagger);
                    f4 = Math.max(f2, motionController.mMotionStagger);
                }
                ++n3;
                f2 = f4;
                f = f6;
            }
            while (n4 < n5) {
                motionController = this.mFrameArrayList.get(this.getChildAt(n4));
                if (!Float.isNaN(motionController.mMotionStagger)) {
                    motionController.mStaggerScale = 1.0f / (1.0f - f5);
                    motionController.mStaggerOffset = n != 0 ? f5 - (f2 - motionController.mMotionStagger) / (f2 - f) * f5 : f5 - (motionController.mMotionStagger - f) * f5 / (f2 - f);
                }
                ++n4;
            }
            return;
        }
        while (n3 < n5) {
            motionController = this.mFrameArrayList.get(this.getChildAt(n3));
            f4 = motionController.getFinalX();
            f = motionController.getFinalY();
            f = n != 0 ? (f -= f4) : (f += f4);
            motionController.mStaggerScale = 1.0f / (1.0f - f5);
            motionController.mStaggerOffset = f5 - (f - f2) * f5 / (f6 - f2);
            ++n3;
        }
    }

    private static boolean willJump(float f, float f2, float f3) {
        boolean bl = true;
        boolean bl2 = true;
        if (f > 0.0f) {
            float f4 = f / f3;
            if (f2 + (f * f4 - f3 * f4 * f4 / 2.0f) > 1.0f) return bl2;
            bl2 = false;
            return bl2;
        }
        float f5 = -f / f3;
        bl2 = f2 + (f * f5 + f3 * f5 * f5 / 2.0f) < 0.0f ? bl : false;
        return bl2;
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList();
        }
        this.mTransitionListeners.add(transitionListener);
    }

    void animateTo(float f) {
        if (this.mScene == null) {
            return;
        }
        float f2 = this.mTransitionLastPosition;
        float f3 = this.mTransitionPosition;
        if (f2 != f3 && this.mTransitionInstantly) {
            this.mTransitionLastPosition = f3;
        }
        if ((f3 = this.mTransitionLastPosition) == f) {
            return;
        }
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = f;
        this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        this.setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = this.getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = f3;
        this.mTransitionLastPosition = f3;
        this.invalidate();
    }

    void disableAutoTransition(boolean bl) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(bl);
    }

    protected void dispatchDraw(Canvas canvas) {
        this.evaluate(false);
        super.dispatchDraw(canvas);
        if (this.mScene == null) {
            return;
        }
        if ((this.mDebugPath & 1) == 1 && !this.isInEditMode()) {
            ++this.mFrames;
            long l = this.getNanoTime();
            long l2 = this.mLastDrawTime;
            if (l2 != -1L) {
                if ((l2 = l - l2) > 200000000L) {
                    this.mLastFps = (float)((int)((float)this.mFrames / ((float)l2 * 1.0E-9f) * 100.0f)) / 100.0f;
                    this.mFrames = 0;
                    this.mLastDrawTime = l;
                }
            } else {
                this.mLastDrawTime = l;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            float f = (float)((int)(this.getProgress() * 1000.0f)) / 10.0f;
            CharSequence charSequence = new StringBuilder();
            charSequence.append(this.mLastFps);
            charSequence.append(" fps ");
            charSequence.append(Debug.getState((MotionLayout)this, (int)this.mBeginState));
            charSequence.append(" -> ");
            charSequence = charSequence.toString();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append(Debug.getState((MotionLayout)this, (int)this.mEndState));
            stringBuilder.append(" (progress: ");
            stringBuilder.append(f);
            stringBuilder.append(" ) state=");
            int n = this.mCurrentState;
            charSequence = n == -1 ? "undefined" : Debug.getState((MotionLayout)this, (int)n);
            stringBuilder.append((String)charSequence);
            charSequence = stringBuilder.toString();
            paint.setColor(-16777216);
            canvas.drawText((String)charSequence, 11.0f, (float)(this.getHeight() - 29), paint);
            paint.setColor(-7864184);
            canvas.drawText((String)charSequence, 10.0f, (float)(this.getHeight() - 30), paint);
        }
        if (this.mDebugPath <= 1) return;
        if (this.mDevModeDraw == null) {
            this.mDevModeDraw = new DevModeDraw(this);
        }
        this.mDevModeDraw.draw(canvas, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
    }

    public void enableTransition(int n, boolean bl) {
        MotionScene.Transition transition = this.getTransition(n);
        if (bl) {
            transition.setEnable(true);
            return;
        }
        if (transition == this.mScene.mCurrentTransition) {
            for (MotionScene.Transition transition2 : this.mScene.getTransitionsWithState(this.mCurrentState)) {
                if (!transition2.isEnabled()) continue;
                this.mScene.mCurrentTransition = transition2;
                break;
            }
        }
        transition.setEnable(false);
    }

    void evaluate(boolean bl) {
        int n;
        block55: {
            int n2;
            block54: {
                int n3;
                float f;
                block53: {
                    int n4;
                    block49: {
                        block52: {
                            Interpolator interpolator;
                            float f2;
                            long l;
                            float f3;
                            int n5;
                            block51: {
                                block50: {
                                    float f4;
                                    block48: {
                                        if (this.mTransitionLastTime == -1L) {
                                            this.mTransitionLastTime = this.getNanoTime();
                                        }
                                        if ((f = this.mTransitionLastPosition) > 0.0f && f < 1.0f) {
                                            this.mCurrentState = -1;
                                        }
                                        boolean bl2 = this.mKeepAnimating;
                                        n3 = 1;
                                        n4 = 1;
                                        n5 = 0;
                                        n = 0;
                                        if (bl2) break block48;
                                        n2 = n5;
                                        if (!this.mInTransition) break block49;
                                        if (bl) break block48;
                                        n2 = n5;
                                        if (this.mTransitionGoalPosition == this.mTransitionLastPosition) break block49;
                                    }
                                    f3 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
                                    l = this.getNanoTime();
                                    if (!(this.mInterpolator instanceof MotionInterpolator)) {
                                        this.mLastVelocity = f4 = (float)(l - this.mTransitionLastTime) * f3 * 1.0E-9f / this.mTransitionDuration;
                                    } else {
                                        f4 = 0.0f;
                                    }
                                    f2 = this.mTransitionLastPosition + f4;
                                    if (this.mTransitionInstantly) {
                                        f2 = this.mTransitionGoalPosition;
                                    }
                                    if (f3 > 0.0f && f2 >= this.mTransitionGoalPosition || f3 <= 0.0f && f2 <= this.mTransitionGoalPosition) {
                                        f2 = this.mTransitionGoalPosition;
                                        this.mInTransition = false;
                                        n2 = 1;
                                    } else {
                                        n2 = 0;
                                    }
                                    this.mTransitionLastPosition = f2;
                                    this.mTransitionPosition = f2;
                                    this.mTransitionLastTime = l;
                                    interpolator = this.mInterpolator;
                                    f = f2;
                                    if (interpolator != null) {
                                        f = f2;
                                        if (n2 == 0) {
                                            if (this.mTemporalInterpolator) {
                                                this.mTransitionLastPosition = f4 = interpolator.getInterpolation((float)(l - this.mAnimationStartTime) * 1.0E-9f);
                                                this.mTransitionLastTime = l;
                                                interpolator = this.mInterpolator;
                                                f = f4;
                                                if (interpolator instanceof MotionInterpolator) {
                                                    float f5;
                                                    this.mLastVelocity = f5 = ((MotionInterpolator)interpolator).getVelocity();
                                                    if (Math.abs(f5) * this.mTransitionDuration <= 1.0E-5f) {
                                                        this.mInTransition = false;
                                                    }
                                                    f2 = f4;
                                                    if (f5 > 0.0f) {
                                                        f2 = f4;
                                                        if (f4 >= 1.0f) {
                                                            this.mTransitionLastPosition = 1.0f;
                                                            this.mInTransition = false;
                                                            f2 = 1.0f;
                                                        }
                                                    }
                                                    f = f2;
                                                    if (f5 < 0.0f) {
                                                        f = f2;
                                                        if (f2 <= 0.0f) {
                                                            this.mTransitionLastPosition = 0.0f;
                                                            this.mInTransition = false;
                                                            f = 0.0f;
                                                        }
                                                    }
                                                }
                                            } else {
                                                f = interpolator.getInterpolation(f2);
                                                interpolator = this.mInterpolator;
                                                this.mLastVelocity = interpolator instanceof MotionInterpolator ? ((MotionInterpolator)interpolator).getVelocity() : (interpolator.getInterpolation(f2 + f4) - f) * f3 / f4;
                                            }
                                        }
                                    }
                                    if (Math.abs(this.mLastVelocity) > 1.0E-5f) {
                                        this.setState(TransitionState.MOVING);
                                    }
                                    if (f3 > 0.0f && f >= this.mTransitionGoalPosition) break block50;
                                    f2 = f;
                                    if (!(f3 <= 0.0f)) break block51;
                                    f2 = f;
                                    if (!(f <= this.mTransitionGoalPosition)) break block51;
                                }
                                f2 = this.mTransitionGoalPosition;
                                this.mInTransition = false;
                            }
                            if (f2 >= 1.0f || f2 <= 0.0f) {
                                this.mInTransition = false;
                                this.setState(TransitionState.FINISHED);
                            }
                            n5 = this.getChildCount();
                            this.mKeepAnimating = false;
                            l = this.getNanoTime();
                            this.mPostInterpolationPosition = f2;
                            for (n2 = 0; n2 < n5; ++n2) {
                                interpolator = this.getChildAt(n2);
                                MotionController motionController = this.mFrameArrayList.get(interpolator);
                                if (motionController == null) continue;
                                this.mKeepAnimating |= motionController.interpolate((View)interpolator, f2, l, this.mKeyCache);
                            }
                            n2 = f3 > 0.0f && f2 >= this.mTransitionGoalPosition || f3 <= 0.0f && f2 <= this.mTransitionGoalPosition ? 1 : 0;
                            if (!this.mKeepAnimating && !this.mInTransition && n2 != 0) {
                                this.setState(TransitionState.FINISHED);
                            }
                            if (this.mMeasureDuringTransition) {
                                this.requestLayout();
                            }
                            this.mKeepAnimating = n2 ^ 1 | this.mKeepAnimating;
                            n2 = n;
                            if (f2 <= 0.0f) {
                                n5 = this.mBeginState;
                                n2 = n;
                                if (n5 != -1) {
                                    n2 = n;
                                    if (this.mCurrentState != n5) {
                                        this.mCurrentState = n5;
                                        this.mScene.getConstraintSet(n5).applyCustomAttributes((ConstraintLayout)this);
                                        this.setState(TransitionState.FINISHED);
                                        n2 = 1;
                                    }
                                }
                            }
                            n = n2;
                            if ((double)f2 >= 1.0) {
                                int n6 = this.mCurrentState;
                                n5 = this.mEndState;
                                n = n2;
                                if (n6 != n5) {
                                    this.mCurrentState = n5;
                                    this.mScene.getConstraintSet(n5).applyCustomAttributes((ConstraintLayout)this);
                                    this.setState(TransitionState.FINISHED);
                                    n = 1;
                                }
                            }
                            if (!this.mKeepAnimating && !this.mInTransition) {
                                if (f3 > 0.0f && f2 == 1.0f || f3 < 0.0f && f2 == 0.0f) {
                                    this.setState(TransitionState.FINISHED);
                                }
                            } else {
                                this.invalidate();
                            }
                            if (!this.mKeepAnimating && this.mInTransition && f3 > 0.0f && f2 == 1.0f) break block52;
                            n2 = n;
                            if (!(f3 < 0.0f)) break block49;
                            n2 = n;
                            if (f2 != 0.0f) break block49;
                        }
                        this.onNewStateAttachHandlers();
                        n2 = n;
                    }
                    if (!((f = this.mTransitionLastPosition) >= 1.0f)) break block53;
                    if (this.mCurrentState != this.mEndState) {
                        n2 = n4;
                    }
                    this.mCurrentState = this.mEndState;
                    break block54;
                }
                n = n2;
                if (!(f <= 0.0f)) break block55;
                if (this.mCurrentState != this.mBeginState) {
                    n2 = n3;
                }
                this.mCurrentState = this.mBeginState;
            }
            n = n2;
        }
        this.mNeedsFireTransitionCompleted |= n;
        if (n != 0 && !this.mInLayout) {
            this.requestLayout();
        }
        this.mTransitionPosition = this.mTransitionLastPosition;
    }

    protected void fireTransitionCompleted() {
        ArrayList<Object> arrayList;
        if ((this.mTransitionListener != null || (arrayList = this.mTransitionListeners) != null && !arrayList.isEmpty()) && this.mListenerState == -1) {
            int n;
            this.mListenerState = this.mCurrentState;
            if (!this.mTransitionCompleted.isEmpty()) {
                arrayList = this.mTransitionCompleted;
                n = (Integer)arrayList.get(arrayList.size() - 1);
            } else {
                n = -1;
            }
            int n2 = this.mCurrentState;
            if (n != n2 && n2 != -1) {
                this.mTransitionCompleted.add(n2);
            }
        }
        this.processTransitionCompleted();
    }

    public void fireTrigger(int n, boolean bl, float f) {
        Object object = this.mTransitionListener;
        if (object != null) {
            object.onTransitionTrigger(this, n, bl, f);
        }
        if ((object = this.mTransitionListeners) == null) return;
        object = ((ArrayList)object).iterator();
        while (object.hasNext()) {
            ((TransitionListener)object.next()).onTransitionTrigger(this, n, bl, f);
        }
    }

    void getAnchorDpDt(int n, float f, float f2, float f3, float[] object) {
        MotionController motionController = this.mFrameArrayList;
        Object object2 = this.getViewById(n);
        if ((motionController = motionController.get(object2)) != null) {
            motionController.getDpDt(f, f2, f3, (float[])object);
            f3 = object2.getY();
            f2 = this.lastPos;
            this.lastPos = f;
            this.lastY = f3;
        } else {
            if (object2 == null) {
                object = new StringBuilder();
                ((StringBuilder)object).append("");
                ((StringBuilder)object).append(n);
                object = ((StringBuilder)object).toString();
            } else {
                object = object2.getContext().getResources().getResourceName(n);
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("WARNING could not find view id ");
            ((StringBuilder)object2).append((String)object);
            Log.w((String)"MotionLayout", (String)((StringBuilder)object2).toString());
        }
    }

    public ConstraintSet getConstraintSet(int n) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) return motionScene.getConstraintSet(n);
        return null;
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) return motionScene.getConstraintSetIds();
        return null;
    }

    String getConstraintSetNames(int n) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) return motionScene.lookUpConstraintName(n);
        return null;
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean bl) {
        int n = bl ? 2 : 1;
        this.mDebugPath = n;
        this.invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) return motionScene.getDefinedTransitions();
        return null;
    }

    public DesignTool getDesignTool() {
        if (this.mDesignTool != null) return this.mDesignTool;
        this.mDesignTool = new DesignTool(this);
        return this.mDesignTool;
    }

    public int getEndState() {
        return this.mEndState;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public MotionScene.Transition getTransition(int n) {
        return this.mScene.getTransitionById(n);
    }

    public Bundle getTransitionState() {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) return (long)(this.mTransitionDuration * 1000.0f);
        this.mTransitionDuration = (float)motionScene.getDuration() / 1000.0f;
        return (long)(this.mTransitionDuration * 1000.0f);
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArray, int n) {
        Interpolator interpolator;
        float f3 = this.mLastVelocity;
        float f4 = this.mTransitionLastPosition;
        if (this.mInterpolator != null) {
            f3 = Math.signum(this.mTransitionGoalPosition - f4);
            float f5 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 1.0E-5f);
            f4 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            f3 = f3 * ((f5 - f4) / 1.0E-5f) / this.mTransitionDuration;
        }
        if ((interpolator = this.mInterpolator) instanceof MotionInterpolator) {
            f3 = ((MotionInterpolator)interpolator).getVelocity();
        }
        interpolator = this.mFrameArrayList.get(view);
        if ((n & 1) == 0) {
            interpolator.getPostLayoutDvDp(f4, view.getWidth(), view.getHeight(), f, f2, fArray);
        } else {
            interpolator.getDpDt(f4, f, f2, fArray);
        }
        if (n >= 2) return;
        fArray[0] = fArray[0] * f3;
        fArray[1] = fArray[1] * f3;
    }

    public boolean isAttachedToWindow() {
        if (Build.VERSION.SDK_INT >= 19) {
            return super.isAttachedToWindow();
        }
        boolean bl = this.getWindowToken() != null;
        return bl;
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public void loadLayoutDescription(int n) {
        if (n != 0) {
            try {
                MotionScene motionScene;
                this.mScene = motionScene = new MotionScene(this.getContext(), this, n);
                if (Build.VERSION.SDK_INT >= 19) {
                    if (!this.isAttachedToWindow()) return;
                }
                this.mScene.readFallback(this);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                this.rebuildScene();
                this.mScene.setRtl(this.isRtl());
            }
            catch (Exception exception) {
                throw new IllegalArgumentException("unable to parse MotionScene file", exception);
            }
        } else {
            this.mScene = null;
        }
    }

    int lookUpConstraintId(String string) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) return motionScene.lookUpConstraintId(string);
        return 0;
    }

    protected MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    protected void onAttachedToWindow() {
        int n;
        super.onAttachedToWindow();
        MotionScene motionScene = this.mScene;
        if (motionScene != null && (n = this.mCurrentState) != -1) {
            motionScene = motionScene.getConstraintSet(n);
            this.mScene.readFallback(this);
            if (motionScene != null) {
                motionScene.applyTo((ConstraintLayout)this);
            }
            this.mBeginState = this.mCurrentState;
        }
        this.onNewStateAttachHandlers();
        motionScene = this.mStateCache;
        if (motionScene != null) {
            motionScene.apply();
        } else {
            if (this.mScene.mCurrentTransition.getAutoTransition() != 4) return;
            this.transitionToEnd();
            this.setState(TransitionState.SETUP);
            this.setState(TransitionState.MOVING);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) return false;
        if (!this.mInteractionEnabled) {
            return false;
        }
        motionScene = motionScene.mCurrentTransition;
        if (motionScene == null) return false;
        if (!motionScene.isEnabled()) return false;
        TouchResponse touchResponse = motionScene.getTouchResponse();
        if (touchResponse == null) return false;
        if (motionEvent.getAction() == 0 && (motionScene = touchResponse.getTouchRegion((ViewGroup)this, new RectF())) != null && !motionScene.contains(motionEvent.getX(), motionEvent.getY())) {
            return false;
        }
        int n = touchResponse.getTouchRegionId();
        if (n == -1) return false;
        motionScene = this.mRegionView;
        if (motionScene == null || motionScene.getId() != n) {
            this.mRegionView = this.findViewById(n);
        }
        if ((motionScene = this.mRegionView) == null) return false;
        this.mBoundsCheck.set((float)motionScene.getLeft(), (float)this.mRegionView.getTop(), (float)this.mRegionView.getRight(), (float)this.mRegionView.getBottom());
        if (!this.mBoundsCheck.contains(motionEvent.getX(), motionEvent.getY())) return false;
        if (this.handlesTouchEvent(0.0f, 0.0f, this.mRegionView, motionEvent)) return false;
        return this.onTouchEvent(motionEvent);
    }

    /*
     * Enabled unnecessary exception pruning
     */
    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        this.mInLayout = true;
        if (this.mScene == null) {
            super.onLayout(bl, n, n2, n3, n4);
            this.mInLayout = false;
            return;
        }
        n = n3 - n;
        n2 = n4 - n2;
        if (this.mLastLayoutWidth != n || this.mLastLayoutHeight != n2) {
            this.rebuildScene();
            this.evaluate(true);
        }
        this.mLastLayoutWidth = n;
        this.mLastLayoutHeight = n2;
        this.mOldWidth = n;
        this.mOldHeight = n2;
        return;
    }

    protected void onMeasure(int n, int n2) {
        if (this.mScene == null) {
            super.onMeasure(n, n2);
            return;
        }
        int n3 = this.mLastWidthMeasureSpec;
        int n4 = 0;
        n3 = n3 == n && this.mLastHeightMeasureSpec == n2 ? 0 : 1;
        if (this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            this.onNewStateAttachHandlers();
            this.processTransitionCompleted();
            n3 = 1;
        }
        if (this.mDirtyHierarchy) {
            n3 = 1;
        }
        this.mLastWidthMeasureSpec = n;
        this.mLastHeightMeasureSpec = n2;
        int n5 = this.mScene.getStartId();
        int n6 = this.mScene.getEndId();
        if ((n3 != 0 || this.mModel.isNotConfiguredWith(n5, n6)) && this.mBeginState != -1) {
            super.onMeasure(n, n2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(n5), this.mScene.getConstraintSet(n6));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(n5, n6);
            n = n4;
        } else {
            n = 1;
        }
        if (this.mMeasureDuringTransition || n != 0) {
            n3 = this.getPaddingTop();
            n2 = this.getPaddingBottom();
            n = this.getPaddingLeft();
            n4 = this.getPaddingRight();
            n = this.mLayoutWidget.getWidth() + (n + n4);
            n2 = this.mLayoutWidget.getHeight() + (n3 + n2);
            n3 = this.mWidthMeasureMode;
            if (n3 == Integer.MIN_VALUE || n3 == 0) {
                n = this.mStartWrapWidth;
                n = (int)((float)n + this.mPostInterpolationPosition * (float)(this.mEndWrapWidth - n));
                this.requestLayout();
            }
            if ((n3 = this.mHeightMeasureMode) == Integer.MIN_VALUE || n3 == 0) {
                n2 = this.mStartWrapHeight;
                n2 = (int)((float)n2 + this.mPostInterpolationPosition * (float)(this.mEndWrapHeight - n2));
                this.requestLayout();
            }
            this.setMeasuredDimension(n, n2);
        }
        this.evaluateLayout();
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        return false;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        float f;
        float f2;
        MotionScene motionScene;
        MotionScene motionScene2 = this.mScene;
        if (motionScene2 == null) return;
        if (motionScene2.mCurrentTransition == null) return;
        if (!this.mScene.mCurrentTransition.isEnabled()) {
            return;
        }
        motionScene2 = this.mScene.mCurrentTransition;
        if (motionScene2 != null && motionScene2.isEnabled() && (motionScene = motionScene2.getTouchResponse()) != null && (n3 = motionScene.getTouchRegionId()) != -1 && view.getId() != n3) {
            return;
        }
        motionScene = this.mScene;
        if (motionScene != null && motionScene.getMoveWhenScrollAtTop() && ((f2 = this.mTransitionPosition) == 1.0f || f2 == 0.0f) && view.canScrollVertically(-1)) {
            return;
        }
        if (motionScene2.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
            f2 = this.mScene.getProgressDirection((float)n, (float)n2);
            if (this.mTransitionLastPosition <= 0.0f && f2 < 0.0f || this.mTransitionLastPosition >= 1.0f && f2 > 0.0f) {
                if (Build.VERSION.SDK_INT < 21) return;
                view.setNestedScrollingEnabled(false);
                view.post((Runnable)new /* Unavailable Anonymous Inner Class!! */);
                return;
            }
        }
        float f3 = this.mTransitionPosition;
        long l = this.getNanoTime();
        this.mScrollTargetDX = f2 = (float)n;
        this.mScrollTargetDY = f = (float)n2;
        double d = l - this.mScrollTargetTime;
        Double.isNaN(d);
        this.mScrollTargetDT = (float)(d * 1.0E-9);
        this.mScrollTargetTime = l;
        this.mScene.processScrollMove(f2, f);
        if (f3 != this.mTransitionPosition) {
            nArray[0] = n;
            nArray[1] = n2;
        }
        this.evaluate(false);
        if (nArray[0] == 0) {
            if (nArray[1] == 0) return;
        }
        this.mUndergoingMotion = true;
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        if (this.mUndergoingMotion || n != 0 || n2 != 0) {
            nArray[0] = nArray[0] + n3;
            nArray[1] = nArray[1] + n4;
        }
        this.mUndergoingMotion = false;
    }

    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
    }

    void onNewStateAttachHandlers() {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            return;
        }
        if (motionScene.autoTransition(this, this.mCurrentState)) {
            this.requestLayout();
            return;
        }
        int n = this.mCurrentState;
        if (n != -1) {
            this.mScene.addOnClickListeners(this, n);
        }
        if (!this.mScene.supportTouch()) return;
        this.mScene.setupTouch();
    }

    public void onRtlPropertiesChanged(int n) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) return;
        motionScene.setRtl(this.isRtl());
    }

    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        view = this.mScene;
        if (view == null) return false;
        if (view.mCurrentTransition == null) return false;
        if (this.mScene.mCurrentTransition.getTouchResponse() == null) return false;
        if ((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) == 0) return true;
        return false;
    }

    public void onStopNestedScroll(View view, int n) {
        view = this.mScene;
        if (view == null) {
            return;
        }
        float f = this.mScrollTargetDX;
        float f2 = this.mScrollTargetDT;
        view.processScrollUp(f / f2, this.mScrollTargetDY / f2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) return super.onTouchEvent(motionEvent);
        if (!this.mInteractionEnabled) return super.onTouchEvent(motionEvent);
        if (!motionScene.supportTouch()) return super.onTouchEvent(motionEvent);
        motionScene = this.mScene.mCurrentTransition;
        if (motionScene != null && !motionScene.isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        this.mScene.processTouchEvent(motionEvent, this.getCurrentState(), this);
        return true;
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (!(view instanceof MotionHelper)) return;
        view = (MotionHelper)view;
        if (this.mTransitionListeners == null) {
            this.mTransitionListeners = new ArrayList();
        }
        this.mTransitionListeners.add((TransitionListener)view);
        if (view.isUsedOnShow()) {
            if (this.mOnShowHelpers == null) {
                this.mOnShowHelpers = new ArrayList();
            }
            this.mOnShowHelpers.add((MotionHelper)view);
        }
        if (!view.isUseOnHide()) return;
        if (this.mOnHideHelpers == null) {
            this.mOnHideHelpers = new ArrayList();
        }
        this.mOnHideHelpers.add((MotionHelper)view);
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        if ((arrayList = this.mOnHideHelpers) == null) return;
        arrayList.remove(view);
    }

    protected void parseLayoutDescription(int n) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e((String)"MotionLayout", (String)"This method is deprecated. Please call rebuildScene() instead.");
        this.rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        this.invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        ArrayList<TransitionListener> arrayList = this.mTransitionListeners;
        if (arrayList != null) return arrayList.remove(transitionListener);
        return false;
    }

    public void requestLayout() {
        MotionScene motionScene;
        if (!this.mMeasureDuringTransition && this.mCurrentState == -1 && (motionScene = this.mScene) != null && motionScene.mCurrentTransition != null && this.mScene.mCurrentTransition.getLayoutDuringTransition() == 0) {
            return;
        }
        super.requestLayout();
    }

    public void setDebugMode(int n) {
        this.mDebugPath = n;
        this.invalidate();
    }

    public void setInteractionEnabled(boolean bl) {
        this.mInteractionEnabled = bl;
    }

    public void setInterpolatedProgress(float f) {
        if (this.mScene != null) {
            this.setState(TransitionState.MOVING);
            Interpolator interpolator = this.mScene.getInterpolator();
            if (interpolator != null) {
                this.setProgress(interpolator.getInterpolation(f));
                return;
            }
        }
        this.setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.mOnHideHelpers;
        if (arrayList == null) return;
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            this.mOnHideHelpers.get(n2).setProgress(f);
            ++n2;
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.mOnShowHelpers;
        if (arrayList == null) return;
        int n = arrayList.size();
        int n2 = 0;
        while (n2 < n) {
            this.mOnShowHelpers.get(n2).setProgress(f);
            ++n2;
        }
    }

    public void setProgress(float f) {
        if (f < 0.0f || f > 1.0f) {
            Log.w((String)"MotionLayout", (String)"Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!this.isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setProgress(f);
            return;
        }
        if (f <= 0.0f) {
            this.mCurrentState = this.mBeginState;
            if (this.mTransitionLastPosition == 0.0f) {
                this.setState(TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            this.mCurrentState = this.mEndState;
            if (this.mTransitionLastPosition == 1.0f) {
                this.setState(TransitionState.FINISHED);
            }
        } else {
            this.mCurrentState = -1;
            this.setState(TransitionState.MOVING);
        }
        if (this.mScene == null) {
            return;
        }
        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = f;
        this.mTransitionPosition = f;
        this.mTransitionLastTime = -1L;
        this.mAnimationStartTime = -1L;
        this.mInterpolator = null;
        this.mInTransition = true;
        this.invalidate();
    }

    public void setProgress(float f, float f2) {
        if (this.isAttachedToWindow()) {
            this.setProgress(f);
            this.setState(TransitionState.MOVING);
            this.mLastVelocity = f2;
            this.animateTo(1.0f);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.setProgress(f);
        this.mStateCache.setVelocity(f2);
    }

    public void setScene(MotionScene motionScene) {
        this.mScene = motionScene;
        motionScene.setRtl(this.isRtl());
        this.rebuildScene();
    }

    public void setState(int n, int n2, int n3) {
        this.setState(TransitionState.SETUP);
        this.mCurrentState = n;
        this.mBeginState = -1;
        this.mEndState = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.updateConstraints(n, (float)n2, (float)n3);
        } else {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) return;
            motionScene.getConstraintSet(n).applyTo((ConstraintLayout)this);
        }
    }

    void setState(TransitionState transitionState) {
        int n;
        if (transitionState == TransitionState.FINISHED && this.mCurrentState == -1) {
            return;
        }
        TransitionState transitionState2 = this.mTransitionState;
        this.mTransitionState = transitionState;
        if (transitionState2 == TransitionState.MOVING && transitionState == TransitionState.MOVING) {
            this.fireTransitionChange();
        }
        if ((n = 2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[transitionState2.ordinal()]) != 1 && n != 2) {
            if (n != 3) return;
            if (transitionState != TransitionState.FINISHED) return;
            this.fireTransitionCompleted();
        } else {
            if (transitionState == TransitionState.MOVING) {
                this.fireTransitionChange();
            }
            if (transitionState != TransitionState.FINISHED) return;
            this.fireTransitionCompleted();
        }
    }

    public void setTransition(int n) {
        if (this.mScene == null) return;
        Object object = this.getTransition(n);
        this.mBeginState = object.getStartConstraintSetId();
        this.mEndState = object.getEndConstraintSetId();
        if (!this.isAttachedToWindow()) {
            if (this.mStateCache == null) {
                this.mStateCache = new StateCache(this);
            }
            this.mStateCache.setStartState(this.mBeginState);
            this.mStateCache.setEndState(this.mEndState);
            return;
        }
        float f = Float.NaN;
        int n2 = this.mCurrentState;
        n = this.mBeginState;
        float f2 = 0.0f;
        if (n2 == n) {
            f = 0.0f;
        } else if (n2 == this.mEndState) {
            f = 1.0f;
        }
        this.mScene.setTransition((MotionScene.Transition)object);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.rebuildScene();
        if (!Float.isNaN(f)) {
            f2 = f;
        }
        this.mTransitionLastPosition = f2;
        if (Float.isNaN(f)) {
            object = new StringBuilder();
            ((StringBuilder)object).append(Debug.getLocation());
            ((StringBuilder)object).append(" transitionToStart ");
            Log.v((String)"MotionLayout", (String)((StringBuilder)object).toString());
            this.transitionToStart();
        } else {
            this.setProgress(f);
        }
    }

    public void setTransition(int n, int n2) {
        if (this.isAttachedToWindow()) {
            MotionScene motionScene = this.mScene;
            if (motionScene == null) return;
            this.mBeginState = n;
            this.mEndState = n2;
            motionScene.setTransition(n, n2);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(n), this.mScene.getConstraintSet(n2));
            this.rebuildScene();
            this.mTransitionLastPosition = 0.0f;
            this.transitionToStart();
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.setStartState(n);
        this.mStateCache.setEndState(n2);
    }

    protected void setTransition(MotionScene.Transition transition) {
        this.mScene.setTransition(transition);
        this.setState(TransitionState.SETUP);
        if (this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1.0f;
            this.mTransitionPosition = 1.0f;
            this.mTransitionGoalPosition = 1.0f;
        } else {
            this.mTransitionLastPosition = 0.0f;
            this.mTransitionPosition = 0.0f;
            this.mTransitionGoalPosition = 0.0f;
        }
        long l = transition.isTransitionFlag(1) ? -1L : this.getNanoTime();
        this.mTransitionLastTime = l;
        int n = this.mScene.getStartId();
        int n2 = this.mScene.getEndId();
        if (n == this.mBeginState && n2 == this.mEndState) {
            return;
        }
        this.mBeginState = n;
        this.mEndState = n2;
        this.mScene.setTransition(n, n2);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        this.rebuildScene();
    }

    public void setTransitionDuration(int n) {
        MotionScene motionScene = this.mScene;
        if (motionScene == null) {
            Log.e((String)"MotionLayout", (String)"MotionScene not defined");
            return;
        }
        motionScene.setDuration(n);
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.mTransitionListener = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.setTransitionState(bundle);
        if (!this.isAttachedToWindow()) return;
        this.mStateCache.apply();
    }

    public String toString() {
        Context context = this.getContext();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Debug.getName((Context)context, (int)this.mBeginState));
        stringBuilder.append("->");
        stringBuilder.append(Debug.getName((Context)context, (int)this.mEndState));
        stringBuilder.append(" (pos:");
        stringBuilder.append(this.mTransitionLastPosition);
        stringBuilder.append(" Dpos/Dt:");
        stringBuilder.append(this.mLastVelocity);
        return stringBuilder.toString();
    }

    public void touchAnimateTo(int n, float f, float f2) {
        if (this.mScene == null) {
            return;
        }
        if (this.mTransitionLastPosition == f) {
            return;
        }
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = this.getNanoTime();
        this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        this.mTransitionGoalPosition = f;
        this.mInTransition = true;
        if (n != 0 && n != 1 && n != 2) {
            if (n != 4) {
                if (n == 5) {
                    if (MotionLayout.willJump(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
                        this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                        this.mInterpolator = this.mDecelerateLogic;
                    } else {
                        this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
                        this.mLastVelocity = 0.0f;
                        n = this.mCurrentState;
                        this.mTransitionGoalPosition = f;
                        this.mCurrentState = n;
                        this.mInterpolator = this.mStopLogic;
                    }
                }
            } else {
                this.mDecelerateLogic.config(f2, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
                this.mInterpolator = this.mDecelerateLogic;
            }
        } else {
            if (n == 1) {
                f = 0.0f;
            } else if (n == 2) {
                f = 1.0f;
            }
            this.mStopLogic.config(this.mTransitionLastPosition, f, f2, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            n = this.mCurrentState;
            this.mTransitionGoalPosition = f;
            this.mCurrentState = n;
            this.mInterpolator = this.mStopLogic;
        }
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = this.getNanoTime();
        this.invalidate();
    }

    public void transitionToEnd() {
        this.animateTo(1.0f);
    }

    public void transitionToStart() {
        this.animateTo(0.0f);
    }

    public void transitionToState(int n) {
        if (this.isAttachedToWindow()) {
            this.transitionToState(n, -1, -1);
            return;
        }
        if (this.mStateCache == null) {
            this.mStateCache = new StateCache(this);
        }
        this.mStateCache.setEndState(n);
    }

    public void transitionToState(int n, int n2, int n3) {
        MotionScene motionScene = this.mScene;
        int n4 = n;
        if (motionScene != null) {
            n4 = n;
            if (motionScene.mStateSet != null) {
                n2 = this.mScene.mStateSet.convertToConstraintSet(this.mCurrentState, n, (float)n2, (float)n3);
                n4 = n;
                if (n2 != -1) {
                    n4 = n2;
                }
            }
        }
        if ((n = this.mCurrentState) == n4) {
            return;
        }
        if (this.mBeginState == n4) {
            this.animateTo(0.0f);
            return;
        }
        if (this.mEndState == n4) {
            this.animateTo(1.0f);
            return;
        }
        this.mEndState = n4;
        if (n != -1) {
            this.setTransition(n, n4);
            this.animateTo(1.0f);
            this.mTransitionLastPosition = 0.0f;
            this.transitionToEnd();
            return;
        }
        n3 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = 1.0f;
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mTransitionLastTime = this.getNanoTime();
        this.mAnimationStartTime = this.getNanoTime();
        this.mTransitionInstantly = false;
        this.mInterpolator = null;
        this.mTransitionDuration = (float)this.mScene.getDuration() / 1000.0f;
        this.mBeginState = -1;
        this.mScene.setTransition(-1, this.mEndState);
        this.mScene.getStartId();
        int n5 = this.getChildCount();
        this.mFrameArrayList.clear();
        for (n = 0; n < n5; ++n) {
            motionScene = this.getChildAt(n);
            MotionController motionController = new MotionController((View)motionScene);
            this.mFrameArrayList.put((View)motionScene, motionController);
        }
        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, null, this.mScene.getConstraintSet(n4));
        this.rebuildScene();
        this.mModel.build();
        this.computeCurrentPositions();
        n2 = this.getWidth();
        n4 = this.getHeight();
        for (n = 0; n < n5; ++n) {
            motionScene = this.mFrameArrayList.get(this.getChildAt(n));
            this.mScene.getKeyFrames((MotionController)motionScene);
            motionScene.setup(n2, n4, this.mTransitionDuration, this.getNanoTime());
        }
        float f = this.mScene.getStaggered();
        if (f != 0.0f) {
            float f2;
            float f3 = Float.MAX_VALUE;
            float f4 = -3.4028235E38f;
            n2 = 0;
            while (true) {
                if (n2 >= n5) break;
                motionScene = this.mFrameArrayList.get(this.getChildAt(n2));
                f2 = motionScene.getFinalX();
                f2 = motionScene.getFinalY() + f2;
                f3 = Math.min(f3, f2);
                f4 = Math.max(f4, f2);
                ++n2;
            }
            for (n = n3; n < n5; ++n) {
                motionScene = this.mFrameArrayList.get(this.getChildAt(n));
                float f5 = motionScene.getFinalX();
                f2 = motionScene.getFinalY();
                motionScene.mStaggerScale = 1.0f / (1.0f - f);
                motionScene.mStaggerOffset = f - (f5 + f2 - f3) * f / (f4 - f3);
            }
        }
        this.mTransitionPosition = 0.0f;
        this.mTransitionLastPosition = 0.0f;
        this.mInTransition = true;
        this.invalidate();
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.rebuildScene();
    }

    public void updateState(int n, ConstraintSet constraintSet) {
        MotionScene motionScene = this.mScene;
        if (motionScene != null) {
            motionScene.setConstraintSet(n, constraintSet);
        }
        this.updateState();
        if (this.mCurrentState != n) return;
        constraintSet.applyTo((ConstraintLayout)this);
    }
}
