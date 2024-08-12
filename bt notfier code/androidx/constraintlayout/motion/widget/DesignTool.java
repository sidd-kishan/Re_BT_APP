/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyPositionBase
 *  androidx.constraintlayout.motion.widget.MotionController
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.MotionScene
 *  androidx.constraintlayout.motion.widget.ProxyInterface
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.R$id
 */
package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.motion.widget.MotionController;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.motion.widget.ProxyInterface;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.io.PrintStream;
import java.io.Serializable;
import java.util.HashMap;

public class DesignTool
implements ProxyInterface {
    private static final boolean DEBUG = false;
    private static final String TAG = "DesignTool";
    static final HashMap<Pair<Integer, Integer>, String> allAttributes = new HashMap();
    static final HashMap<String, String> allMargins = new HashMap();
    private String mLastEndState = null;
    private int mLastEndStateId = -1;
    private String mLastStartState = null;
    private int mLastStartStateId = -1;
    private final MotionLayout mMotionLayout;
    private MotionScene mSceneCache;

    static {
        Serializable serializable = allAttributes;
        Integer n = 4;
        ((HashMap)serializable).put((Pair<Integer, Integer>)Pair.create((Object)n, (Object)n), (String)"layout_constraintBottom_toBottomOf");
        HashMap<Pair<Integer, Integer>, String> hashMap = allAttributes;
        serializable = Integer.valueOf(3);
        hashMap.put((Pair<Integer, Integer>)Pair.create((Object)n, serializable), "layout_constraintBottom_toTopOf");
        allAttributes.put((Pair<Integer, Integer>)Pair.create(serializable, (Object)n), "layout_constraintTop_toBottomOf");
        allAttributes.put((Pair<Integer, Integer>)Pair.create(serializable, serializable), "layout_constraintTop_toTopOf");
        serializable = allAttributes;
        n = 6;
        ((HashMap)serializable).put((Pair<Integer, Integer>)Pair.create((Object)n, (Object)n), (String)"layout_constraintStart_toStartOf");
        hashMap = allAttributes;
        serializable = Integer.valueOf(7);
        hashMap.put((Pair<Integer, Integer>)Pair.create((Object)n, (Object)serializable), "layout_constraintStart_toEndOf");
        allAttributes.put((Pair<Integer, Integer>)Pair.create((Object)serializable, (Object)n), "layout_constraintEnd_toStartOf");
        allAttributes.put((Pair<Integer, Integer>)Pair.create((Object)serializable, (Object)serializable), "layout_constraintEnd_toEndOf");
        serializable = allAttributes;
        n = 1;
        ((HashMap)serializable).put(Pair.create((Object)n, (Object)n), "layout_constraintLeft_toLeftOf");
        hashMap = allAttributes;
        serializable = Integer.valueOf(2);
        hashMap.put((Pair<Integer, Integer>)Pair.create((Object)n, (Object)serializable), "layout_constraintLeft_toRightOf");
        allAttributes.put((Pair<Integer, Integer>)Pair.create((Object)serializable, (Object)serializable), "layout_constraintRight_toRightOf");
        allAttributes.put((Pair<Integer, Integer>)Pair.create((Object)serializable, (Object)n), "layout_constraintRight_toLeftOf");
        serializable = allAttributes;
        n = 5;
        ((HashMap)serializable).put(Pair.create((Object)n, (Object)n), "layout_constraintBaseline_toBaselineOf");
        allMargins.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        allMargins.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        allMargins.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        allMargins.put("layout_constraintTop_toTopOf", "layout_marginTop");
        allMargins.put("layout_constraintStart_toStartOf", "layout_marginStart");
        allMargins.put("layout_constraintStart_toEndOf", "layout_marginStart");
        allMargins.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        allMargins.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        allMargins.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        allMargins.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        allMargins.put("layout_constraintRight_toRightOf", "layout_marginRight");
        allMargins.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.mMotionLayout = motionLayout;
    }

    private static void Connect(int n, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int n2, int n3) {
        String string = allAttributes.get(Pair.create((Object)n2, (Object)n3));
        String string2 = hashMap.get(string);
        if (string2 == null) return;
        n = (string = allMargins.get(string)) != null ? DesignTool.GetPxFromDp(n, hashMap.get(string)) : 0;
        int n4 = Integer.parseInt(string2);
        constraintSet.connect(view.getId(), n2, n4, n3, n);
    }

    private static int GetPxFromDp(int n, String string) {
        if (string == null) {
            return 0;
        }
        int n2 = string.indexOf(100);
        if (n2 != -1) return (int)((float)(Integer.valueOf(string.substring(0, n2)) * n) / 160.0f);
        return 0;
    }

    private static void SetAbsolutePositions(int n, ConstraintSet constraintSet, View view, HashMap<String, String> object) {
        String string = ((HashMap)object).get("layout_editor_absoluteX");
        if (string != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), DesignTool.GetPxFromDp(n, string));
        }
        if ((object = ((HashMap)object).get("layout_editor_absoluteY")) == null) return;
        constraintSet.setEditorAbsoluteY(view.getId(), DesignTool.GetPxFromDp(n, (String)object));
    }

    private static void SetBias(ConstraintSet constraintSet, View view, HashMap<String, String> object, int n) {
        String string = n == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias";
        object = ((HashMap)object).get(string);
        if (object == null) return;
        if (n == 0) {
            constraintSet.setHorizontalBias(view.getId(), Float.parseFloat((String)object));
        } else {
            if (n != 1) return;
            constraintSet.setVerticalBias(view.getId(), Float.parseFloat((String)object));
        }
    }

    private static void SetDimensions(int n, ConstraintSet constraintSet, View view, HashMap<String, String> object, int n2) {
        String string = n2 == 1 ? "layout_height" : "layout_width";
        object = ((HashMap)object).get(string);
        if (object == null) return;
        int n3 = -2;
        if (!((String)object).equalsIgnoreCase("wrap_content")) {
            n3 = DesignTool.GetPxFromDp(n, (String)object);
        }
        if (n2 == 0) {
            constraintSet.constrainWidth(view.getId(), n3);
        } else {
            constraintSet.constrainHeight(view.getId(), n3);
        }
    }

    public int designAccess(int n, String string, Object object, float[] object2, int n2, float[] fArray, int n3) {
        object = (View)object;
        if (n != 0) {
            if (this.mMotionLayout.mScene == null) {
                return -1;
            }
            if (object == null) return -1;
            object2 = (MotionController)this.mMotionLayout.mFrameArrayList.get(object);
            object = object2;
            if (object2 == null) {
                return -1;
            }
        } else {
            object = null;
        }
        if (n == 0) return 1;
        if (n == 1) {
            n = this.mMotionLayout.mScene.getDuration() / 16;
            object.buildPath(fArray, n);
            return n;
        }
        if (n == 2) {
            n = this.mMotionLayout.mScene.getDuration() / 16;
            object.buildKeyFrames(fArray, null);
            return n;
        }
        if (n != 3) {
            return -1;
        }
        n = this.mMotionLayout.mScene.getDuration() / 16;
        return object.getAttributeValues(string, fArray, n3);
    }

    public void disableAutoTransition(boolean bl) {
        this.mMotionLayout.disableAutoTransition(bl);
    }

    public void dumpConstraintSet(String string) {
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        int n = this.mMotionLayout.lookUpConstraintId(string);
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" dumping  ");
        stringBuilder.append(string);
        stringBuilder.append(" (");
        stringBuilder.append(n);
        stringBuilder.append(")");
        printStream.println(stringBuilder.toString());
        try {
            this.mMotionLayout.mScene.getConstraintSet(n).dump(this.mMotionLayout.mScene, new int[0]);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object object, float[] fArray) {
        if (this.mMotionLayout.mScene == null) {
            return -1;
        }
        int n = this.mMotionLayout.mScene.getDuration() / 16;
        if ((object = (MotionController)this.mMotionLayout.mFrameArrayList.get(object)) == null) {
            return 0;
        }
        object.buildKeyFrames(fArray, null);
        return n;
    }

    public int getAnimationPath(Object object, float[] fArray, int n) {
        if (this.mMotionLayout.mScene == null) {
            return -1;
        }
        if ((object = (MotionController)this.mMotionLayout.mFrameArrayList.get(object)) == null) {
            return 0;
        }
        object.buildPath(fArray, n);
        return n;
    }

    public void getAnimationRectangles(Object object, float[] fArray) {
        if (this.mMotionLayout.mScene == null) {
            return;
        }
        int n = this.mMotionLayout.mScene.getDuration() / 16;
        if ((object = (MotionController)this.mMotionLayout.mFrameArrayList.get(object)) == null) {
            return;
        }
        object.buildRectangles(fArray, n);
    }

    public String getEndState() {
        int n = this.mMotionLayout.getEndState();
        if (this.mLastEndStateId == n) {
            return this.mLastEndState;
        }
        String string = this.mMotionLayout.getConstraintSetNames(n);
        if (string == null) return string;
        this.mLastEndState = string;
        this.mLastEndStateId = n;
        return string;
    }

    public int getKeyFrameInfo(Object object, int n, int[] nArray) {
        if ((object = (MotionController)this.mMotionLayout.mFrameArrayList.get((View)object)) != null) return object.getKeyFrameInfo(n, nArray);
        return 0;
    }

    public float getKeyFramePosition(Object object, int n, float f, float f2) {
        return ((MotionController)this.mMotionLayout.mFrameArrayList.get((View)object)).getKeyFrameParameter(n, f, f2);
    }

    public int getKeyFramePositions(Object object, int[] nArray, float[] fArray) {
        if ((object = (MotionController)this.mMotionLayout.mFrameArrayList.get((View)object)) != null) return object.getkeyFramePositions(nArray, fArray);
        return 0;
    }

    public Object getKeyframe(int n, int n2, int n3) {
        if (this.mMotionLayout.mScene != null) return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), n, n2, n3);
        return null;
    }

    public Object getKeyframe(Object object, int n, int n2) {
        if (this.mMotionLayout.mScene == null) {
            return null;
        }
        int n3 = ((View)object).getId();
        return this.mMotionLayout.mScene.getKeyFrame(this.mMotionLayout.getContext(), n, n3, n2);
    }

    public Object getKeyframeAtLocation(Object object, float f, float f2) {
        View view = (View)object;
        if (this.mMotionLayout.mScene == null) {
            return -1;
        }
        if (view == null) return null;
        object = (MotionController)this.mMotionLayout.mFrameArrayList.get(view);
        if (object == null) {
            return null;
        }
        view = (ViewGroup)view.getParent();
        return object.getPositionKeyframe(view.getWidth(), view.getHeight(), f, f2);
    }

    public Boolean getPositionKeyframe(Object object, Object object2, float f, float f2, String[] stringArray, float[] fArray) {
        if (!(object instanceof KeyPositionBase)) return false;
        object = (KeyPositionBase)object;
        HashMap hashMap = this.mMotionLayout.mFrameArrayList;
        object2 = (View)object2;
        ((MotionController)hashMap.get(object2)).positionKeyframe((View)object2, (KeyPositionBase)object, f, f2, stringArray, fArray);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
        return true;
    }

    public float getProgress() {
        return this.mMotionLayout.getProgress();
    }

    public String getStartState() {
        int n = this.mMotionLayout.getStartState();
        if (this.mLastStartStateId == n) {
            return this.mLastStartState;
        }
        String string = this.mMotionLayout.getConstraintSetNames(n);
        if (string == null) return this.mMotionLayout.getConstraintSetNames(n);
        this.mLastStartState = string;
        this.mLastStartStateId = n;
        return this.mMotionLayout.getConstraintSetNames(n);
    }

    public String getState() {
        if (this.mLastStartState == null) return this.mLastStartState;
        if (this.mLastEndState == null) return this.mLastStartState;
        float f = this.getProgress();
        if (f <= 0.01f) {
            return this.mLastStartState;
        }
        if (!(f >= 0.99f)) return this.mLastStartState;
        return this.mLastEndState;
    }

    public long getTransitionTimeMs() {
        return this.mMotionLayout.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        boolean bl = this.mLastStartState != null && this.mLastEndState != null;
        return bl;
    }

    public void setAttributes(int n, String string, Object object, Object object2) {
        object = (View)object;
        object2 = (HashMap)object2;
        int n2 = this.mMotionLayout.lookUpConstraintId(string);
        if ((string = this.mMotionLayout.mScene.getConstraintSet(n2)) == null) {
            return;
        }
        string.clear(object.getId());
        DesignTool.SetDimensions(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 0);
        DesignTool.SetDimensions(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 1);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 6, 6);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 6, 7);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 7, 7);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 7, 6);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 1, 1);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 1, 2);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 2, 2);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 2, 1);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 3, 3);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 3, 4);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 4, 3);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 4, 4);
        DesignTool.Connect(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 5, 5);
        DesignTool.SetBias((ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 0);
        DesignTool.SetBias((ConstraintSet)string, (View)object, (HashMap<String, String>)object2, 1);
        DesignTool.SetAbsolutePositions(n, (ConstraintSet)string, (View)object, (HashMap<String, String>)object2);
        this.mMotionLayout.updateState(n2, (ConstraintSet)string);
        this.mMotionLayout.requestLayout();
    }

    public void setKeyFrame(Object object, int n, String string, Object object2) {
        if (this.mMotionLayout.mScene == null) return;
        this.mMotionLayout.mScene.setKeyframe((View)object, n, string, object2);
        this.mMotionLayout.mTransitionGoalPosition = (float)n / 100.0f;
        this.mMotionLayout.mTransitionLastPosition = 0.0f;
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
    }

    public boolean setKeyFramePosition(Object object, int n, int n2, float f, float f2) {
        if (this.mMotionLayout.mScene == null) return false;
        MotionController motionController = (MotionController)this.mMotionLayout.mFrameArrayList.get(object);
        n = (int)(this.mMotionLayout.mTransitionPosition * 100.0f);
        if (motionController == null) return false;
        MotionScene motionScene = this.mMotionLayout.mScene;
        if (!motionScene.hasKeyFramePosition((View)(object = (View)object), n)) return false;
        float f3 = motionController.getKeyFrameParameter(2, f, f2);
        f = motionController.getKeyFrameParameter(5, f, f2);
        this.mMotionLayout.mScene.setKeyframe((View)object, n, "motion:percentX", (Object)Float.valueOf(f3));
        this.mMotionLayout.mScene.setKeyframe((View)object, n, "motion:percentY", (Object)Float.valueOf(f));
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.invalidate();
        return true;
    }

    public void setKeyframe(Object object, String string, Object object2) {
        if (!(object instanceof Key)) return;
        ((Key)object).setValue(string, object2);
        this.mMotionLayout.rebuildScene();
        this.mMotionLayout.mInTransition = true;
    }

    public void setState(String string) {
        String string2 = string;
        if (string == null) {
            string2 = "motion_base";
        }
        if (this.mLastStartState == string2) {
            return;
        }
        this.mLastStartState = string2;
        this.mLastEndState = null;
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        int n = string2 != null ? this.mMotionLayout.lookUpConstraintId(string2) : R.id.motion_base;
        this.mLastStartStateId = n;
        if (n != 0) {
            if (n == this.mMotionLayout.getStartState()) {
                this.mMotionLayout.setProgress(0.0f);
            } else if (n == this.mMotionLayout.getEndState()) {
                this.mMotionLayout.setProgress(1.0f);
            } else {
                this.mMotionLayout.transitionToState(n);
                this.mMotionLayout.setProgress(1.0f);
            }
        }
        this.mMotionLayout.requestLayout();
    }

    public void setToolPosition(float f) {
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        this.mMotionLayout.setProgress(f);
        this.mMotionLayout.evaluate(true);
        this.mMotionLayout.requestLayout();
        this.mMotionLayout.invalidate();
    }

    public void setTransition(String string, String string2) {
        if (this.mMotionLayout.mScene == null) {
            this.mMotionLayout.mScene = this.mSceneCache;
        }
        int n = this.mMotionLayout.lookUpConstraintId(string);
        int n2 = this.mMotionLayout.lookUpConstraintId(string2);
        this.mMotionLayout.setTransition(n, n2);
        this.mLastStartStateId = n;
        this.mLastEndStateId = n2;
        this.mLastStartState = string;
        this.mLastEndState = string2;
    }

    public void setViewDebug(Object object, int n) {
        if ((object = (MotionController)this.mMotionLayout.mFrameArrayList.get(object)) == null) return;
        object.setDrawPath(n);
        this.mMotionLayout.invalidate();
    }
}
