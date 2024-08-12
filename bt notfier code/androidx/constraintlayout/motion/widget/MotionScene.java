/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.RectF
 *  android.util.Log
 *  android.util.SparseArray
 *  android.util.SparseIntArray
 *  android.util.Xml
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateDecelerateInterpolator
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.AnimationUtils
 *  android.view.animation.AnticipateInterpolator
 *  android.view.animation.BounceInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  androidx.constraintlayout.motion.widget.Debug
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyFrames
 *  androidx.constraintlayout.motion.widget.MotionController
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker
 *  androidx.constraintlayout.motion.widget.MotionLayout$TransitionState
 *  androidx.constraintlayout.motion.widget.MotionScene$Transition
 *  androidx.constraintlayout.motion.widget.MotionScene$Transition$TransitionOnClick
 *  androidx.constraintlayout.widget.ConstraintLayout
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$id
 *  androidx.constraintlayout.widget.R$styleable
 *  androidx.constraintlayout.widget.StateSet
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyFrames;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;

/*
 * Exception performing whole class analysis ignored.
 */
public class MotionScene {
    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private boolean DEBUG_DESKTOP = false;
    private ArrayList<Transition> mAbstractTransitionList;
    private HashMap<String, Integer> mConstraintSetIdMap;
    private SparseArray<ConstraintSet> mConstraintSetMap;
    Transition mCurrentTransition = null;
    private int mDefaultDuration = 400;
    private Transition mDefaultTransition = null;
    private SparseIntArray mDeriveMap;
    private boolean mDisableAutoTransition = false;
    private boolean mIgnoreTouch = false;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private int mLayoutDuringTransition = 0;
    private final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion = false;
    private boolean mRtl;
    StateSet mStateSet = null;
    private ArrayList<Transition> mTransitionList = new ArrayList();
    private MotionLayout.MotionTracker mVelocityTracker;

    MotionScene(Context context, MotionLayout motionLayout, int n) {
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.mMotionLayout = motionLayout;
        this.load(context, n);
        this.mConstraintSetMap.put(R.id.motion_base, (Object)new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", R.id.motion_base);
    }

    public MotionScene(MotionLayout motionLayout) {
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.mMotionLayout = motionLayout;
    }

    static /* synthetic */ int access$1000(MotionScene motionScene) {
        return motionScene.mLayoutDuringTransition;
    }

    static /* synthetic */ SparseArray access$1100(MotionScene motionScene) {
        return motionScene.mConstraintSetMap;
    }

    static /* synthetic */ MotionLayout access$800(MotionScene motionScene) {
        return motionScene.mMotionLayout;
    }

    static /* synthetic */ int access$900(MotionScene motionScene) {
        return motionScene.mDefaultDuration;
    }

    private int getId(Context object, String string) {
        int n;
        int n2;
        if (string.contains("/")) {
            CharSequence charSequence = string.substring(string.indexOf(47) + 1);
            n = n2 = object.getResources().getIdentifier((String)charSequence, "id", object.getPackageName());
            if (this.DEBUG_DESKTOP) {
                object = System.out;
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("id getMap res = ");
                ((StringBuilder)charSequence).append(n2);
                ((PrintStream)object).println(((StringBuilder)charSequence).toString());
                n = n2;
            }
        } else {
            n = -1;
        }
        n2 = n;
        if (n != -1) return n2;
        if (string != null && string.length() > 1) {
            n2 = Integer.parseInt(string.substring(1));
        } else {
            Log.e((String)"MotionScene", (String)"error in parsing id");
            n2 = n;
        }
        return n2;
    }

    private int getIndex(Transition object) {
        int n = Transition.access$300((Transition)object);
        if (n == -1) {
            object = new IllegalArgumentException("The transition must have an id");
            throw object;
        }
        int n2 = 0;
        while (n2 < this.mTransitionList.size()) {
            if (Transition.access$300((Transition)this.mTransitionList.get(n2)) == n) {
                return n2;
            }
            ++n2;
        }
        return -1;
    }

    private int getRealID(int n) {
        StateSet stateSet = this.mStateSet;
        if (stateSet == null) return n;
        int n2 = stateSet.stateGetConstraintID(n, -1, -1);
        if (n2 == -1) return n;
        return n2;
    }

    private boolean hasCycleDependency(int n) {
        int n2 = this.mDeriveMap.get(n);
        int n3 = this.mDeriveMap.size();
        while (n2 > 0) {
            if (n2 == n) {
                return true;
            }
            if (n3 < 0) {
                return true;
            }
            n2 = this.mDeriveMap.get(n2);
            --n3;
        }
        return false;
    }

    private boolean isProcessingTouch() {
        boolean bl = this.mVelocityTracker != null;
        return bl;
    }

    /*
     * Exception decompiling
     */
    private void load(Context var1_1, int var2_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Started 2 blocks at once
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.getStartingBlocks(Op04StructuredStatement.java:412)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:487)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Unable to fully structure code
     */
    private void parseConstraintSet(Context var1_1, XmlPullParser var2_2) {
        var11_3 = new ConstraintSet();
        var11_3.setForceId(false);
        var7_4 = var2_2.getAttributeCount();
        var6_6 = -1;
        var5_7 = -1;
        for (var4_5 = 0; var4_5 < var7_4; ++var4_5) {
            block8: {
                block7: {
                    var9_10 = var2_2.getAttributeName(var4_5);
                    var12_12 = var2_2.getAttributeValue(var4_5);
                    if (this.DEBUG_DESKTOP) {
                        var10_11 = System.out;
                        var8_9 = new StringBuilder();
                        var8_9.append("id string = ");
                        var8_9.append(var12_12);
                        var10_11.println(var8_9.toString());
                    }
                    if ((var3_8 = var9_10.hashCode()) == -1496482599) break block7;
                    if (var3_8 != 3355 || !var9_10.equals("id")) ** GOTO lbl-1000
                    var3_8 = 0;
                    break block8;
                }
                if (var9_10.equals("deriveConstraintsFrom")) {
                    var3_8 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var3_8 = -1;
                }
            }
            if (var3_8 != 0) {
                if (var3_8 != 1) continue;
                var5_7 = this.getId(var1_1, var12_12);
                continue;
            }
            var6_6 = this.getId(var1_1, var12_12);
            this.mConstraintSetIdMap.put(MotionScene.stripID(var12_12), var6_6);
        }
        if (var6_6 == -1) return;
        if (this.mMotionLayout.mDebugPath != 0) {
            var11_3.setValidateOnParse(true);
        }
        var11_3.load(var1_1, var2_2);
        if (var5_7 != -1) {
            this.mDeriveMap.put(var6_6, var5_7);
        }
        this.mConstraintSetMap.put(var6_6, (Object)var11_3);
    }

    private void parseMotionSceneTags(Context context, XmlPullParser xmlPullParser) {
        context = context.obtainStyledAttributes(Xml.asAttributeSet((XmlPullParser)xmlPullParser), R.styleable.MotionScene);
        int n = context.getIndexCount();
        int n2 = 0;
        while (true) {
            if (n2 >= n) {
                context.recycle();
                return;
            }
            int n3 = context.getIndex(n2);
            if (n3 == R.styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = context.getInt(n3, this.mDefaultDuration);
            } else if (n3 == R.styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = context.getInteger(n3, 0);
            }
            ++n2;
        }
    }

    private void readConstraintChain(int n) {
        int n2 = this.mDeriveMap.get(n);
        if (n2 <= 0) return;
        this.readConstraintChain(this.mDeriveMap.get(n));
        Object object = (ConstraintSet)this.mConstraintSetMap.get(n);
        ConstraintSet constraintSet = (ConstraintSet)this.mConstraintSetMap.get(n2);
        if (constraintSet == null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("ERROR! invalid deriveConstraintsFrom: @id/");
            ((StringBuilder)object).append(Debug.getName((Context)this.mMotionLayout.getContext(), (int)n2));
            Log.e((String)"MotionScene", (String)((StringBuilder)object).toString());
            return;
        }
        object.readFallback(constraintSet);
        this.mDeriveMap.put(n, -1);
    }

    public static String stripID(String string) {
        if (string == null) {
            return "";
        }
        int n = string.indexOf(47);
        if (n >= 0) return string.substring(n + 1);
        return string;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public void addOnClickListeners(MotionLayout var1_1, int var2_2) {
        for (Object var4_4 : this.mTransitionList) {
            if (Transition.access$400((Transition)var4_4).size() <= 0) continue;
            var4_4 = Transition.access$400((Transition)var4_4).iterator();
            while (var4_4.hasNext()) {
                ((Transition.TransitionOnClick)var4_4.next()).removeOnClickListeners(var1_1);
            }
        }
        for (Object var4_4 : this.mAbstractTransitionList) {
            if (Transition.access$400((Transition)var4_4).size() <= 0) continue;
            var4_4 = Transition.access$400((Transition)var4_4).iterator();
            while (var4_4.hasNext()) {
                ((Transition.TransitionOnClick)var4_4.next()).removeOnClickListeners(var1_1);
            }
        }
        for (Transition var5_5 : this.mTransitionList) {
            if (Transition.access$400((Transition)var5_5).size() <= 0) continue;
            var3_3 = Transition.access$400((Transition)var5_5).iterator();
            while (var3_3.hasNext()) {
                ((Transition.TransitionOnClick)var3_3.next()).addOnClickListeners(var1_1, var2_2, var5_5);
            }
        }
        var4_4 = this.mAbstractTransitionList.iterator();
        block6: while (true) {
            if (var4_4.hasNext() == false) return;
            var5_5 = (Transition)var4_4.next();
            if (Transition.access$400((Transition)var5_5).size() <= 0) continue;
            var3_3 = Transition.access$400((Transition)var5_5).iterator();
            while (true) {
                if (var3_3.hasNext()) ** break;
                continue block6;
                ((Transition.TransitionOnClick)var3_3.next()).addOnClickListeners(var1_1, var2_2, var5_5);
            }
            break;
        }
    }

    public void addTransition(Transition transition) {
        int n = this.getIndex(transition);
        if (n == -1) {
            this.mTransitionList.add(transition);
        } else {
            this.mTransitionList.set(n, transition);
        }
    }

    boolean autoTransition(MotionLayout motionLayout, int n) {
        Transition transition;
        block9: {
            if (this.isProcessingTouch()) {
                return false;
            }
            if (this.mDisableAutoTransition) {
                return false;
            }
            Iterator<Transition> iterator = this.mTransitionList.iterator();
            while (iterator.hasNext()) {
                transition = iterator.next();
                if (Transition.access$600((Transition)transition) == 0 || this.mCurrentTransition == transition) continue;
                if (n == Transition.access$100((Transition)transition) && (Transition.access$600((Transition)transition) == 4 || Transition.access$600((Transition)transition) == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(transition);
                    if (Transition.access$600((Transition)transition) == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    } else {
                        motionLayout.setProgress(1.0f);
                        motionLayout.evaluate(true);
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                        motionLayout.onNewStateAttachHandlers();
                    }
                    return true;
                }
                if (n != Transition.access$000((Transition)transition) || Transition.access$600((Transition)transition) != 3 && Transition.access$600((Transition)transition) != 1) {
                    continue;
                }
                break block9;
            }
            return false;
        }
        motionLayout.setState(MotionLayout.TransitionState.FINISHED);
        motionLayout.setTransition(transition);
        if (Transition.access$600((Transition)transition) == 3) {
            motionLayout.transitionToStart();
            motionLayout.setState(MotionLayout.TransitionState.SETUP);
            motionLayout.setState(MotionLayout.TransitionState.MOVING);
        } else {
            motionLayout.setProgress(0.0f);
            motionLayout.evaluate(true);
            motionLayout.setState(MotionLayout.TransitionState.SETUP);
            motionLayout.setState(MotionLayout.TransitionState.MOVING);
            motionLayout.setState(MotionLayout.TransitionState.FINISHED);
            motionLayout.onNewStateAttachHandlers();
        }
        return true;
    }

    public Transition bestTransitionFor(int n, float f, float f2, MotionEvent motionEvent) {
        if (n == -1) return this.mCurrentTransition;
        Transition transition = this.getTransitionsWithState(n);
        float f3 = 0.0f;
        Transition transition2 = null;
        RectF rectF = new RectF();
        Iterator<Transition> iterator = transition.iterator();
        while (iterator.hasNext()) {
            transition = iterator.next();
            if (Transition.access$500((Transition)transition) || Transition.access$200((Transition)transition) == null) continue;
            Transition.access$200((Transition)transition).setRTL(this.mRtl);
            RectF rectF2 = Transition.access$200((Transition)transition).getTouchRegion((ViewGroup)this.mMotionLayout, rectF);
            if (rectF2 != null && motionEvent != null && !rectF2.contains(motionEvent.getX(), motionEvent.getY()) || (rectF2 = Transition.access$200((Transition)transition).getTouchRegion((ViewGroup)this.mMotionLayout, rectF)) != null && motionEvent != null && !rectF2.contains(motionEvent.getX(), motionEvent.getY())) continue;
            float f4 = Transition.access$200((Transition)transition).dot(f, f2);
            float f5 = Transition.access$000((Transition)transition) == n ? -1.0f : 1.1f;
            if (!((f5 = f4 * f5) > f3)) continue;
            transition2 = transition;
            f3 = f5;
        }
        return transition2;
    }

    public void disableAutoTransition(boolean bl) {
        this.mDisableAutoTransition = bl;
    }

    public int gatPathMotionArc() {
        Transition transition = this.mCurrentTransition;
        int n = transition != null ? Transition.access$1800((Transition)transition) : -1;
        return n;
    }

    ConstraintSet getConstraintSet(int n) {
        return this.getConstraintSet(n, -1, -1);
    }

    ConstraintSet getConstraintSet(int n, int n2, int n3) {
        Object object;
        if (this.DEBUG_DESKTOP) {
            PrintStream printStream = System.out;
            object = new StringBuilder();
            ((StringBuilder)object).append("id ");
            ((StringBuilder)object).append(n);
            printStream.println(((StringBuilder)object).toString());
            printStream = System.out;
            object = new StringBuilder();
            ((StringBuilder)object).append("size ");
            ((StringBuilder)object).append(this.mConstraintSetMap.size());
            printStream.println(((StringBuilder)object).toString());
        }
        object = this.mStateSet;
        int n4 = n;
        if (object != null) {
            n2 = object.stateGetConstraintID(n, n2, n3);
            n4 = n;
            if (n2 != -1) {
                n4 = n2;
            }
        }
        if (this.mConstraintSetMap.get(n4) != null) return (ConstraintSet)this.mConstraintSetMap.get(n4);
        object = new StringBuilder();
        ((StringBuilder)object).append("Warning could not find ConstraintSet id/");
        ((StringBuilder)object).append(Debug.getName((Context)this.mMotionLayout.getContext(), (int)n4));
        ((StringBuilder)object).append(" In MotionScene");
        Log.e((String)"MotionScene", (String)((StringBuilder)object).toString());
        object = this.mConstraintSetMap;
        return (ConstraintSet)object.get(object.keyAt(0));
    }

    public ConstraintSet getConstraintSet(Context context, String string) {
        Appendable appendable;
        Object object;
        if (this.DEBUG_DESKTOP) {
            object = System.out;
            appendable = new StringBuilder();
            ((StringBuilder)appendable).append("id ");
            ((StringBuilder)appendable).append(string);
            ((PrintStream)object).println(((StringBuilder)appendable).toString());
            appendable = System.out;
            object = new StringBuilder();
            ((StringBuilder)object).append("size ");
            ((StringBuilder)object).append(this.mConstraintSetMap.size());
            ((PrintStream)appendable).println(((StringBuilder)object).toString());
        }
        int n = 0;
        while (n < this.mConstraintSetMap.size()) {
            int n2 = this.mConstraintSetMap.keyAt(n);
            object = context.getResources().getResourceName(n2);
            if (this.DEBUG_DESKTOP) {
                PrintStream printStream = System.out;
                appendable = new StringBuilder();
                ((StringBuilder)appendable).append("Id for <");
                ((StringBuilder)appendable).append(n);
                ((StringBuilder)appendable).append("> is <");
                ((StringBuilder)appendable).append((String)object);
                ((StringBuilder)appendable).append("> looking for <");
                ((StringBuilder)appendable).append(string);
                ((StringBuilder)appendable).append(">");
                printStream.println(((StringBuilder)appendable).toString());
            }
            if (string.equals(object)) {
                return (ConstraintSet)this.mConstraintSetMap.get(n2);
            }
            ++n;
        }
        return null;
    }

    public int[] getConstraintSetIds() {
        int n = this.mConstraintSetMap.size();
        int[] nArray = new int[n];
        int n2 = 0;
        while (n2 < n) {
            nArray[n2] = this.mConstraintSetMap.keyAt(n2);
            ++n2;
        }
        return nArray;
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return this.mDefaultDuration;
        return Transition.access$1700((Transition)transition);
    }

    int getEndId() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) return Transition.access$000((Transition)transition);
        return -1;
    }

    public Interpolator getInterpolator() {
        int n = Transition.access$1400((Transition)this.mCurrentTransition);
        if (n == -2) return AnimationUtils.loadInterpolator((Context)this.mMotionLayout.getContext(), (int)Transition.access$1600((Transition)this.mCurrentTransition));
        if (n == -1) return new /* Unavailable Anonymous Inner Class!! */;
        if (n == 0) return new AccelerateDecelerateInterpolator();
        if (n == 1) return new AccelerateInterpolator();
        if (n == 2) return new DecelerateInterpolator();
        if (n == 4) return new AnticipateInterpolator();
        if (n == 5) return new BounceInterpolator();
        return null;
    }

    /*
     * Exception decompiling
     */
    Key getKeyFrame(Context var1_1, int var2_2, int var3_3, int var4_4) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [0[DOLOOP]], but top level block is 2[DOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompile(CFRDecompiler.java:91)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:122)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.decompileSaveAll(ResourceDecompiling.java:262)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$decompileSaveAll$0(ResourceDecompiling.java:127)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void getKeyFrames(MotionController motionController) {
        Object object = this.mCurrentTransition;
        if (object == null) {
            object = this.mDefaultTransition;
            if (object == null) return;
            object = Transition.access$1300((Transition)object).iterator();
            while (object.hasNext()) {
                ((KeyFrames)object.next()).addFrames(motionController);
            }
            return;
        }
        object = Transition.access$1300((Transition)object).iterator();
        while (object.hasNext()) {
            ((KeyFrames)object.next()).addFrames(motionController);
        }
    }

    float getMaxAcceleration() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return 0.0f;
        if (Transition.access$200((Transition)transition) == null) return 0.0f;
        return Transition.access$200((Transition)this.mCurrentTransition).getMaxAcceleration();
    }

    float getMaxVelocity() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return 0.0f;
        if (Transition.access$200((Transition)transition) == null) return 0.0f;
        return Transition.access$200((Transition)this.mCurrentTransition).getMaxVelocity();
    }

    boolean getMoveWhenScrollAtTop() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return false;
        if (Transition.access$200((Transition)transition) == null) return false;
        return Transition.access$200((Transition)this.mCurrentTransition).getMoveWhenScrollAtTop();
    }

    public float getPathPercent(View view, int n) {
        return 0.0f;
    }

    float getProgressDirection(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return 0.0f;
        if (Transition.access$200((Transition)transition) == null) return 0.0f;
        return Transition.access$200((Transition)this.mCurrentTransition).getProgressDirection(f, f2);
    }

    public float getStaggered() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return 0.0f;
        return Transition.access$1900((Transition)transition);
    }

    int getStartId() {
        Transition transition = this.mCurrentTransition;
        if (transition != null) return Transition.access$100((Transition)transition);
        return -1;
    }

    public Transition getTransitionById(int n) {
        Transition transition;
        Iterator<Transition> iterator = this.mTransitionList.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (Transition.access$300((Transition)(transition = iterator.next())) != n);
        return transition;
    }

    int getTransitionDirection(int n) {
        Iterator<Transition> iterator = this.mTransitionList.iterator();
        do {
            if (!iterator.hasNext()) return 1;
        } while (Transition.access$100((Transition)iterator.next()) != n);
        return 0;
    }

    public List<Transition> getTransitionsWithState(int n) {
        n = this.getRealID(n);
        ArrayList<Transition> arrayList = new ArrayList<Transition>();
        Iterator<Transition> iterator = this.mTransitionList.iterator();
        while (iterator.hasNext()) {
            Transition transition = iterator.next();
            if (Transition.access$100((Transition)transition) != n && Transition.access$000((Transition)transition) != n) continue;
            arrayList.add(transition);
        }
        return arrayList;
    }

    boolean hasKeyFramePosition(View view, int n) {
        Object object = this.mCurrentTransition;
        if (object == null) {
            return false;
        }
        object = Transition.access$1300((Transition)object).iterator();
        block0: while (true) {
            if (!object.hasNext()) return false;
            Iterator iterator = ((KeyFrames)object.next()).getKeyFramesForView(view.getId()).iterator();
            do {
                if (!iterator.hasNext()) continue block0;
            } while (((Key)iterator.next()).mFramePosition != n);
            break;
        }
        return true;
    }

    public int lookUpConstraintId(String string) {
        return this.mConstraintSetIdMap.get(string);
    }

    public String lookUpConstraintName(int n) {
        Map.Entry<String, Integer> entry;
        Iterator<Map.Entry<String, Integer>> iterator = this.mConstraintSetIdMap.entrySet().iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while ((entry = iterator.next()).getValue() != n);
        return entry.getKey();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
    }

    void processScrollMove(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return;
        if (Transition.access$200((Transition)transition) == null) return;
        Transition.access$200((Transition)this.mCurrentTransition).scrollMove(f, f2);
    }

    void processScrollUp(float f, float f2) {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return;
        if (Transition.access$200((Transition)transition) == null) return;
        Transition.access$200((Transition)this.mCurrentTransition).scrollUp(f, f2);
    }

    void processTouchEvent(MotionEvent motionEvent, int n, MotionLayout motionLayout) {
        RectF rectF = new RectF();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = this.mMotionLayout.obtainVelocityTracker();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (n != -1) {
            int n2 = motionEvent.getAction();
            boolean bl = false;
            if (n2 != 0) {
                if (n2 == 2 && !this.mIgnoreTouch) {
                    MotionEvent motionEvent2;
                    float f = motionEvent.getRawY() - this.mLastTouchY;
                    float f2 = motionEvent.getRawX() - this.mLastTouchX;
                    if ((double)f2 == 0.0) {
                        if ((double)f == 0.0) return;
                    }
                    if ((motionEvent2 = this.mLastTouchDown) == null) {
                        return;
                    }
                    if ((motionEvent2 = this.bestTransitionFor(n, f2, f, motionEvent2)) != null) {
                        motionLayout.setTransition((Transition)motionEvent2);
                        rectF = Transition.access$200((Transition)this.mCurrentTransition).getTouchRegion((ViewGroup)this.mMotionLayout, rectF);
                        boolean bl2 = bl;
                        if (rectF != null) {
                            bl2 = bl;
                            if (!rectF.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                                bl2 = true;
                            }
                        }
                        this.mMotionOutsideRegion = bl2;
                        Transition.access$200((Transition)this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                    }
                }
            } else {
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
                this.mLastTouchDown = motionEvent;
                this.mIgnoreTouch = false;
                if (Transition.access$200((Transition)this.mCurrentTransition) == null) return;
                motionEvent = Transition.access$200((Transition)this.mCurrentTransition).getLimitBoundsTo((ViewGroup)this.mMotionLayout, rectF);
                if (motionEvent != null && !motionEvent.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                    this.mLastTouchDown = null;
                    this.mIgnoreTouch = true;
                    return;
                }
                motionEvent = Transition.access$200((Transition)this.mCurrentTransition).getTouchRegion((ViewGroup)this.mMotionLayout, rectF);
                this.mMotionOutsideRegion = motionEvent != null && !motionEvent.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY());
                Transition.access$200((Transition)this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
                return;
            }
        }
        if (this.mIgnoreTouch) {
            return;
        }
        rectF = this.mCurrentTransition;
        if (rectF != null && Transition.access$200((Transition)rectF) != null && !this.mMotionOutsideRegion) {
            Transition.access$200((Transition)this.mCurrentTransition).processTouchEvent(motionEvent, this.mVelocityTracker, n, this);
        }
        this.mLastTouchX = motionEvent.getRawX();
        this.mLastTouchY = motionEvent.getRawY();
        if (motionEvent.getAction() != 1) return;
        motionEvent = this.mVelocityTracker;
        if (motionEvent == null) return;
        motionEvent.recycle();
        this.mVelocityTracker = null;
        if (motionLayout.mCurrentState == -1) return;
        this.autoTransition(motionLayout, motionLayout.mCurrentState);
    }

    void readFallback(MotionLayout motionLayout) {
        int n = 0;
        int n2 = 0;
        while (true) {
            int n3 = n;
            if (n2 >= this.mConstraintSetMap.size()) {
                while (n3 < this.mConstraintSetMap.size()) {
                    ((ConstraintSet)this.mConstraintSetMap.valueAt(n3)).readFallback((ConstraintLayout)motionLayout);
                    ++n3;
                }
                return;
            }
            n3 = this.mConstraintSetMap.keyAt(n2);
            if (this.hasCycleDependency(n3)) {
                Log.e((String)"MotionScene", (String)"Cannot be derived from yourself");
                return;
            }
            this.readConstraintChain(n3);
            ++n2;
        }
    }

    public void removeTransition(Transition transition) {
        int n = this.getIndex(transition);
        if (n == -1) return;
        this.mTransitionList.remove(n);
    }

    public void setConstraintSet(int n, ConstraintSet constraintSet) {
        this.mConstraintSetMap.put(n, (Object)constraintSet);
    }

    public void setDuration(int n) {
        Transition transition = this.mCurrentTransition;
        if (transition != null) {
            transition.setDuration(n);
        } else {
            this.mDefaultDuration = n;
        }
    }

    public void setKeyframe(View view, int n, String string, Object object) {
        Object object2 = this.mCurrentTransition;
        if (object2 == null) {
            return;
        }
        Iterator iterator = Transition.access$1300((Transition)object2).iterator();
        block0: while (iterator.hasNext()) {
            object2 = ((KeyFrames)iterator.next()).getKeyFramesForView(view.getId()).iterator();
            while (true) {
                if (!object2.hasNext()) continue block0;
                if (((Key)object2.next()).mFramePosition != n) continue;
                float f = object != null ? ((Float)object).floatValue() : 0.0f;
                string.equalsIgnoreCase("app:PerpendicularPath_percent");
            }
            break;
        }
        return;
    }

    public void setRtl(boolean bl) {
        this.mRtl = bl;
        Transition transition = this.mCurrentTransition;
        if (transition == null) return;
        if (Transition.access$200((Transition)transition) == null) return;
        Transition.access$200((Transition)this.mCurrentTransition).setRTL(this.mRtl);
    }

    void setTransition(int n, int n2) {
        int n3;
        int n4;
        Object object;
        block6: {
            block5: {
                block4: {
                    object = this.mStateSet;
                    if (object == null) break block4;
                    n4 = object.stateGetConstraintID(n, -1, -1);
                    if (n4 == -1) {
                        n4 = n;
                    }
                    int n5 = this.mStateSet.stateGetConstraintID(n2, -1, -1);
                    n3 = n4;
                    if (n5 == -1) break block5;
                    n3 = n4;
                    n4 = n5;
                    break block6;
                }
                n3 = n;
            }
            n4 = n2;
        }
        for (Transition transition : this.mTransitionList) {
            if ((Transition.access$000((Transition)transition) != n4 || Transition.access$100((Transition)transition) != n3) && (Transition.access$000((Transition)transition) != n2 || Transition.access$100((Transition)transition) != n)) continue;
            this.mCurrentTransition = transition;
            if (transition == null) return;
            if (Transition.access$200((Transition)transition) == null) return;
            Transition.access$200((Transition)this.mCurrentTransition).setRTL(this.mRtl);
            return;
        }
        object = this.mDefaultTransition;
        for (Transition transition : this.mAbstractTransitionList) {
            if (Transition.access$000((Transition)transition) != n2) continue;
            object = transition;
        }
        object = new Transition(this, (Transition)object);
        Transition.access$102((Transition)object, (int)n3);
        Transition.access$002((Transition)object, (int)n4);
        if (n3 != -1) {
            this.mTransitionList.add((Transition)object);
        }
        this.mCurrentTransition = object;
    }

    public void setTransition(Transition transition) {
        this.mCurrentTransition = transition;
        if (transition == null) return;
        if (Transition.access$200((Transition)transition) == null) return;
        Transition.access$200((Transition)this.mCurrentTransition).setRTL(this.mRtl);
    }

    void setupTouch() {
        Transition transition = this.mCurrentTransition;
        if (transition == null) return;
        if (Transition.access$200((Transition)transition) == null) return;
        Transition.access$200((Transition)this.mCurrentTransition).setupTouch();
    }

    boolean supportTouch() {
        boolean bl;
        Transition transition;
        block1: {
            transition = this.mTransitionList.iterator();
            do {
                boolean bl2 = transition.hasNext();
                bl = true;
                if (!bl2) break block1;
            } while (Transition.access$200((Transition)transition.next()) == null);
            return true;
        }
        transition = this.mCurrentTransition;
        if (transition != null && Transition.access$200((Transition)transition) != null) return bl;
        bl = false;
        return bl;
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        boolean bl = motionLayout == this.mMotionLayout && motionLayout.mScene == this;
        return bl;
    }
}
