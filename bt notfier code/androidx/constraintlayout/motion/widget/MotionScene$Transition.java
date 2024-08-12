/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Xml
 *  androidx.constraintlayout.motion.widget.KeyFrames
 *  androidx.constraintlayout.motion.widget.MotionScene
 *  androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick
 *  androidx.constraintlayout.motion.widget.TouchResponse
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.constraintlayout.motion.widget.KeyFrames;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.TouchResponse;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/*
 * Exception performing whole class analysis ignored.
 */
public static class MotionScene.Transition {
    public static final int AUTO_ANIMATE_TO_END = 4;
    public static final int AUTO_ANIMATE_TO_START = 3;
    public static final int AUTO_JUMP_TO_END = 2;
    public static final int AUTO_JUMP_TO_START = 1;
    public static final int AUTO_NONE = 0;
    static final int TRANSITION_FLAG_FIRST_DRAW = 1;
    private int mAutoTransition = 0;
    private int mConstraintSetEnd = -1;
    private int mConstraintSetStart = -1;
    private int mDefaultInterpolator = 0;
    private int mDefaultInterpolatorID = -1;
    private String mDefaultInterpolatorString = null;
    private boolean mDisable = false;
    private int mDuration = 400;
    private int mId = -1;
    private boolean mIsAbstract = false;
    private ArrayList<KeyFrames> mKeyFramesList = new ArrayList();
    private int mLayoutDuringTransition = 0;
    private final MotionScene mMotionScene;
    private ArrayList<TransitionOnClick> mOnClicks = new ArrayList();
    private int mPathMotionArc = -1;
    private float mStagger = 0.0f;
    private TouchResponse mTouchResponse = null;
    private int mTransitionFlags = 0;

    public MotionScene.Transition(int n, MotionScene motionScene, int n2, int n3) {
        this.mId = n;
        this.mMotionScene = motionScene;
        this.mConstraintSetStart = n2;
        this.mConstraintSetEnd = n3;
        this.mDuration = MotionScene.access$900((MotionScene)motionScene);
        this.mLayoutDuringTransition = MotionScene.access$1000((MotionScene)motionScene);
    }

    MotionScene.Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
        this.mDuration = MotionScene.access$900((MotionScene)motionScene);
        this.mLayoutDuringTransition = MotionScene.access$1000((MotionScene)motionScene);
        this.mMotionScene = motionScene;
        this.fillFromAttributeList(motionScene, context, Xml.asAttributeSet((XmlPullParser)xmlPullParser));
    }

    MotionScene.Transition(MotionScene motionScene, MotionScene.Transition transition) {
        this.mMotionScene = motionScene;
        if (transition == null) return;
        this.mPathMotionArc = transition.mPathMotionArc;
        this.mDefaultInterpolator = transition.mDefaultInterpolator;
        this.mDefaultInterpolatorString = transition.mDefaultInterpolatorString;
        this.mDefaultInterpolatorID = transition.mDefaultInterpolatorID;
        this.mDuration = transition.mDuration;
        this.mKeyFramesList = transition.mKeyFramesList;
        this.mStagger = transition.mStagger;
        this.mLayoutDuringTransition = transition.mLayoutDuringTransition;
    }

    static /* synthetic */ int access$000(MotionScene.Transition transition) {
        return transition.mConstraintSetEnd;
    }

    static /* synthetic */ int access$002(MotionScene.Transition transition, int n) {
        transition.mConstraintSetEnd = n;
        return n;
    }

    static /* synthetic */ int access$100(MotionScene.Transition transition) {
        return transition.mConstraintSetStart;
    }

    static /* synthetic */ int access$102(MotionScene.Transition transition, int n) {
        transition.mConstraintSetStart = n;
        return n;
    }

    static /* synthetic */ boolean access$1200(MotionScene.Transition transition) {
        return transition.mIsAbstract;
    }

    static /* synthetic */ ArrayList access$1300(MotionScene.Transition transition) {
        return transition.mKeyFramesList;
    }

    static /* synthetic */ int access$1400(MotionScene.Transition transition) {
        return transition.mDefaultInterpolator;
    }

    static /* synthetic */ String access$1500(MotionScene.Transition transition) {
        return transition.mDefaultInterpolatorString;
    }

    static /* synthetic */ int access$1600(MotionScene.Transition transition) {
        return transition.mDefaultInterpolatorID;
    }

    static /* synthetic */ int access$1700(MotionScene.Transition transition) {
        return transition.mDuration;
    }

    static /* synthetic */ int access$1800(MotionScene.Transition transition) {
        return transition.mPathMotionArc;
    }

    static /* synthetic */ float access$1900(MotionScene.Transition transition) {
        return transition.mStagger;
    }

    static /* synthetic */ TouchResponse access$200(MotionScene.Transition transition) {
        return transition.mTouchResponse;
    }

    static /* synthetic */ TouchResponse access$202(MotionScene.Transition transition, TouchResponse touchResponse) {
        transition.mTouchResponse = touchResponse;
        return touchResponse;
    }

    static /* synthetic */ int access$300(MotionScene.Transition transition) {
        return transition.mId;
    }

    static /* synthetic */ ArrayList access$400(MotionScene.Transition transition) {
        return transition.mOnClicks;
    }

    static /* synthetic */ boolean access$500(MotionScene.Transition transition) {
        return transition.mDisable;
    }

    static /* synthetic */ int access$600(MotionScene.Transition transition) {
        return transition.mAutoTransition;
    }

    static /* synthetic */ MotionScene access$700(MotionScene.Transition transition) {
        return transition.mMotionScene;
    }

    private void fill(MotionScene motionScene, Context context, TypedArray typedArray) {
        int n = typedArray.getIndexCount();
        int n2 = 0;
        while (true) {
            Object object;
            if (n2 >= n) {
                if (this.mConstraintSetStart != -1) return;
                this.mIsAbstract = true;
                return;
            }
            int n3 = typedArray.getIndex(n2);
            if (n3 == R.styleable.Transition_constraintSetEnd) {
                this.mConstraintSetEnd = typedArray.getResourceId(n3, this.mConstraintSetEnd);
                if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                    object = new ConstraintSet();
                    object.load(context, this.mConstraintSetEnd);
                    MotionScene.access$1100((MotionScene)motionScene).append(this.mConstraintSetEnd, object);
                }
            } else if (n3 == R.styleable.Transition_constraintSetStart) {
                this.mConstraintSetStart = typedArray.getResourceId(n3, this.mConstraintSetStart);
                if ("layout".equals(context.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                    object = new ConstraintSet();
                    object.load(context, this.mConstraintSetStart);
                    MotionScene.access$1100((MotionScene)motionScene).append(this.mConstraintSetStart, object);
                }
            } else if (n3 == R.styleable.Transition_motionInterpolator) {
                object = typedArray.peekValue(n3);
                if (((TypedValue)object).type == 1) {
                    this.mDefaultInterpolatorID = n3 = typedArray.getResourceId(n3, -1);
                    if (n3 != -1) {
                        this.mDefaultInterpolator = -2;
                    }
                } else if (((TypedValue)object).type == 3) {
                    this.mDefaultInterpolatorString = object = typedArray.getString(n3);
                    if (((String)object).indexOf("/") > 0) {
                        this.mDefaultInterpolatorID = typedArray.getResourceId(n3, -1);
                        this.mDefaultInterpolator = -2;
                    } else {
                        this.mDefaultInterpolator = -1;
                    }
                } else {
                    this.mDefaultInterpolator = typedArray.getInteger(n3, this.mDefaultInterpolator);
                }
            } else if (n3 == R.styleable.Transition_duration) {
                this.mDuration = typedArray.getInt(n3, this.mDuration);
            } else if (n3 == R.styleable.Transition_staggered) {
                this.mStagger = typedArray.getFloat(n3, this.mStagger);
            } else if (n3 == R.styleable.Transition_autoTransition) {
                this.mAutoTransition = typedArray.getInteger(n3, this.mAutoTransition);
            } else if (n3 == R.styleable.Transition_android_id) {
                this.mId = typedArray.getResourceId(n3, this.mId);
            } else if (n3 == R.styleable.Transition_transitionDisable) {
                this.mDisable = typedArray.getBoolean(n3, this.mDisable);
            } else if (n3 == R.styleable.Transition_pathMotionArc) {
                this.mPathMotionArc = typedArray.getInteger(n3, -1);
            } else if (n3 == R.styleable.Transition_layoutDuringTransition) {
                this.mLayoutDuringTransition = typedArray.getInteger(n3, 0);
            } else if (n3 == R.styleable.Transition_transitionFlags) {
                this.mTransitionFlags = typedArray.getInteger(n3, 0);
            }
            ++n2;
        }
    }

    private void fillFromAttributeList(MotionScene motionScene, Context context, AttributeSet attributeSet) {
        attributeSet = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
        this.fill(motionScene, context, (TypedArray)attributeSet);
        attributeSet.recycle();
    }

    public void addOnClick(Context context, XmlPullParser xmlPullParser) {
        this.mOnClicks.add(new TransitionOnClick(context, this, xmlPullParser));
    }

    public String debugString(Context object) {
        String string = this.mConstraintSetStart == -1 ? "null" : object.getResources().getResourceEntryName(this.mConstraintSetStart);
        if (this.mConstraintSetEnd == -1) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(" -> null");
            object = ((StringBuilder)object).toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append(" -> ");
            stringBuilder.append(object.getResources().getResourceEntryName(this.mConstraintSetEnd));
            object = stringBuilder.toString();
        }
        return object;
    }

    public int getAutoTransition() {
        return this.mAutoTransition;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getEndConstraintSetId() {
        return this.mConstraintSetEnd;
    }

    public int getId() {
        return this.mId;
    }

    public List<KeyFrames> getKeyFrameList() {
        return this.mKeyFramesList;
    }

    public int getLayoutDuringTransition() {
        return this.mLayoutDuringTransition;
    }

    public List<TransitionOnClick> getOnClickList() {
        return this.mOnClicks;
    }

    public int getPathMotionArc() {
        return this.mPathMotionArc;
    }

    public float getStagger() {
        return this.mStagger;
    }

    public int getStartConstraintSetId() {
        return this.mConstraintSetStart;
    }

    public TouchResponse getTouchResponse() {
        return this.mTouchResponse;
    }

    public boolean isEnabled() {
        return this.mDisable ^ true;
    }

    public boolean isTransitionFlag(int n) {
        boolean bl = (n & this.mTransitionFlags) != 0;
        return bl;
    }

    public void setAutoTransition(int n) {
        this.mAutoTransition = n;
    }

    public void setDuration(int n) {
        this.mDuration = n;
    }

    public void setEnable(boolean bl) {
        this.mDisable = bl ^ true;
    }

    public void setPathMotionArc(int n) {
        this.mPathMotionArc = n;
    }

    public void setStagger(float f) {
        this.mStagger = f;
    }
}
