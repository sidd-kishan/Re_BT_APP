/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.RectF
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.utils.Easing
 *  androidx.constraintlayout.motion.utils.VelocityMatrix
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyAttributes
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.KeyCycle
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$PathRotateSet
 *  androidx.constraintlayout.motion.widget.KeyPosition
 *  androidx.constraintlayout.motion.widget.KeyPositionBase
 *  androidx.constraintlayout.motion.widget.KeyTimeCycle
 *  androidx.constraintlayout.motion.widget.KeyTrigger
 *  androidx.constraintlayout.motion.widget.MotionConstrainedPoint
 *  androidx.constraintlayout.motion.widget.MotionPaths
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.motion.widget.SplineSet$PathRotate
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate
 *  androidx.constraintlayout.solver.widgets.ConstraintWidget
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.ConstraintLayout$LayoutParams
 *  androidx.constraintlayout.widget.ConstraintSet
 *  androidx.constraintlayout.widget.ConstraintSet$Constraint
 */
package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionConstrainedPoint;
import androidx.constraintlayout.motion.widget.MotionPaths;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    private int MAX_DIMENSION = 4;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap<String, SplineSet> mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType = -1;
    private HashMap<String, KeyCycleOscillator> mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList<Key> mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList<MotionPaths> mMotionPaths;
    float mMotionStagger;
    private int mPathMotionArc;
    private CurveFit[] mSpline;
    float mStaggerOffset = 0.0f;
    float mStaggerScale = 1.0f;
    private MotionPaths mStartMotionPath = new MotionPaths();
    private MotionConstrainedPoint mStartPoint;
    private HashMap<String, TimeCycleSplineSet> mTimeCycleAttributesMap;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    MotionController(View view) {
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = Float.NaN;
        this.mValuesBuff = new float[4];
        this.mMotionPaths = new ArrayList();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList();
        this.mPathMotionArc = Key.UNSET;
        this.setView(view);
    }

    private float getAdjustedPosition(float f, float[] fArray) {
        float f2;
        float f3;
        float f4 = 0.0f;
        float f5 = 1.0f;
        if (fArray != null) {
            fArray[0] = 1.0f;
            f3 = f;
        } else {
            f3 = f;
            if ((double)this.mStaggerScale != 1.0) {
                f2 = f;
                if (f < this.mStaggerOffset) {
                    f2 = 0.0f;
                }
                f = this.mStaggerOffset;
                f3 = f2;
                if (f2 > f) {
                    f3 = f2;
                    if ((double)f2 < 1.0) {
                        f3 = (f2 - f) * this.mStaggerScale;
                    }
                }
            }
        }
        Easing easing = this.mStartMotionPath.mKeyFrameEasing;
        f = Float.NaN;
        Iterator<MotionPaths> iterator = this.mMotionPaths.iterator();
        f2 = f4;
        while (iterator.hasNext()) {
            MotionPaths motionPaths = iterator.next();
            if (motionPaths.mKeyFrameEasing == null) continue;
            if (motionPaths.time < f3) {
                easing = motionPaths.mKeyFrameEasing;
                f2 = motionPaths.time;
                continue;
            }
            if (!Float.isNaN(f)) continue;
            f = motionPaths.time;
        }
        f4 = f3;
        if (easing == null) return f4;
        if (Float.isNaN(f)) {
            f = f5;
        }
        double d = (f3 - f2) / (f -= f2);
        f4 = f = (float)easing.get(d) * f + f2;
        if (fArray == null) return f4;
        fArray[0] = (float)easing.getDiff(d);
        f4 = f;
        return f4;
    }

    private float getPreCycleDistance() {
        float[] fArray = new float[2];
        float f = 1.0f / (float)99;
        double d = 0.0;
        double d2 = 0.0;
        int n = 0;
        float f2 = 0.0f;
        while (n < 100) {
            float f3 = (float)n * f;
            double d3 = f3;
            Easing easing = this.mStartMotionPath.mKeyFrameEasing;
            float f4 = Float.NaN;
            Iterator<MotionPaths> iterator = this.mMotionPaths.iterator();
            float f5 = 0.0f;
            while (iterator.hasNext()) {
                MotionPaths motionPaths = iterator.next();
                if (motionPaths.mKeyFrameEasing == null) continue;
                if (motionPaths.time < f3) {
                    easing = motionPaths.mKeyFrameEasing;
                    f5 = motionPaths.time;
                    continue;
                }
                if (!Float.isNaN(f4)) continue;
                f4 = motionPaths.time;
            }
            if (easing != null) {
                float f6 = f4;
                if (Float.isNaN(f4)) {
                    f6 = 1.0f;
                }
                f4 = f6 - f5;
                d3 = (float)easing.get((double)((f3 - f5) / f4)) * f4 + f5;
            }
            this.mSpline[0].getPos(d3, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, 0);
            f4 = f2;
            if (n > 0) {
                d3 = f2;
                double d4 = fArray[1];
                Double.isNaN(d4);
                double d5 = fArray[0];
                Double.isNaN(d5);
                d2 = Math.hypot(d2 - d4, d - d5);
                Double.isNaN(d3);
                f4 = (float)(d3 + d2);
            }
            d = fArray[0];
            d2 = fArray[1];
            ++n;
            f2 = f4;
        }
        return f2;
    }

    private void insertKey(MotionPaths motionPaths) {
        int n = Collections.binarySearch(this.mMotionPaths, motionPaths);
        if (n == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" KeyPath positon \"");
            stringBuilder.append(motionPaths.position);
            stringBuilder.append("\" outside of range");
            Log.e((String)TAG, (String)stringBuilder.toString());
        }
        this.mMotionPaths.add(-n - 1, motionPaths);
    }

    private void readView(MotionPaths motionPaths) {
        motionPaths.setBounds((float)((int)this.mView.getX()), (float)((int)this.mView.getY()), (float)this.mView.getWidth(), (float)this.mView.getHeight());
    }

    void addKey(Key key) {
        this.mKeyList.add(key);
    }

    void addKeys(ArrayList<Key> arrayList) {
        this.mKeyList.addAll(arrayList);
    }

    void buildBounds(float[] fArray, int n) {
        float f = 1.0f / (float)(n - 1);
        Object object = this.mAttributesMap;
        if (object != null) {
            object = object.get("translationX");
        }
        object = this.mAttributesMap;
        if (object != null) {
            object = (SplineSet)object.get("translationY");
        }
        object = this.mCycleMap;
        if (object != null) {
            object = (KeyCycleOscillator)object.get("translationX");
        }
        object = this.mCycleMap;
        if (object != null) {
            object = (KeyCycleOscillator)object.get("translationY");
        }
        int n2 = 0;
        while (n2 < n) {
            float f2 = (float)n2 * f;
            float f3 = this.mStaggerScale;
            float f4 = 0.0f;
            float f5 = f2;
            if (f3 != 1.0f) {
                f3 = f2;
                if (f2 < this.mStaggerOffset) {
                    f3 = 0.0f;
                }
                f2 = this.mStaggerOffset;
                f5 = f3;
                if (f3 > f2) {
                    f5 = f3;
                    if ((double)f3 < 1.0) {
                        f5 = (f3 - f2) * this.mStaggerScale;
                    }
                }
            }
            double d = f5;
            object = this.mStartMotionPath.mKeyFrameEasing;
            f3 = Float.NaN;
            CurveFit curveFit = this.mMotionPaths.iterator();
            f2 = f4;
            while (curveFit.hasNext()) {
                MotionPaths motionPaths = curveFit.next();
                if (motionPaths.mKeyFrameEasing == null) continue;
                if (motionPaths.time < f5) {
                    object = motionPaths.mKeyFrameEasing;
                    f2 = motionPaths.time;
                    continue;
                }
                if (!Float.isNaN(f3)) continue;
                f3 = motionPaths.time;
            }
            if (object != null) {
                f4 = f3;
                if (Float.isNaN(f3)) {
                    f4 = 1.0f;
                }
                f3 = f4 - f2;
                d = (float)object.get((double)((f5 - f2) / f3)) * f3 + f2;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            curveFit = this.mArcSpline;
            if (curveFit != null && ((SplineSet)(object = (Object)this.mInterpolateData)).length > 0) {
                curveFit.getPos(d, (double[])object);
            }
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArray, n2 * 2);
            ++n2;
        }
    }

    int buildKeyBounds(float[] fArray, int[] nArray) {
        int n;
        if (fArray == null) return 0;
        double[] dArray = this.mSpline[0].getTimePoints();
        if (nArray != null) {
            Iterator<MotionPaths> iterator = this.mMotionPaths.iterator();
            n = 0;
            while (iterator.hasNext()) {
                nArray[n] = iterator.next().mMode;
                ++n;
            }
        }
        n = 0;
        int n2 = 0;
        while (n < dArray.length) {
            this.mSpline[0].getPos(dArray[n], this.mInterpolateData);
            this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, fArray, n2);
            n2 += 2;
            ++n;
        }
        return n2 / 2;
    }

    int buildKeyFrames(float[] fArray, int[] nArray) {
        int n;
        if (fArray == null) return 0;
        double[] dArray = this.mSpline[0].getTimePoints();
        if (nArray != null) {
            Iterator<MotionPaths> iterator = this.mMotionPaths.iterator();
            n = 0;
            while (iterator.hasNext()) {
                nArray[n] = iterator.next().mMode;
                ++n;
            }
        }
        n = 0;
        int n2 = 0;
        while (n < dArray.length) {
            this.mSpline[0].getPos(dArray[n], this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, n2);
            n2 += 2;
            ++n;
        }
        return n2 / 2;
    }

    void buildPath(float[] fArray, int n) {
        float f = 1.0f / (float)(n - 1);
        Object object = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        object = object == null ? null : object.get("translationX");
        Object object2 = this.mAttributesMap;
        object2 = object2 == null ? null : object2.get("translationY");
        Object object3 = this.mCycleMap;
        object3 = object3 == null ? null : object3.get("translationX");
        Easing easing = this.mCycleMap;
        if (easing != null) {
            keyCycleOscillator = easing.get("translationY");
        }
        int n2 = 0;
        while (n2 < n) {
            Object object4;
            float f2 = (float)n2 * f;
            float f3 = this.mStaggerScale;
            float f4 = 0.0f;
            float f5 = f2;
            if (f3 != 1.0f) {
                f3 = f2;
                if (f2 < this.mStaggerOffset) {
                    f3 = 0.0f;
                }
                f2 = this.mStaggerOffset;
                f5 = f3;
                if (f3 > f2) {
                    f5 = f3;
                    if ((double)f3 < 1.0) {
                        f5 = (f3 - f2) * this.mStaggerScale;
                    }
                }
            }
            double d = f5;
            easing = this.mStartMotionPath.mKeyFrameEasing;
            f3 = Float.NaN;
            Object object5 = this.mMotionPaths.iterator();
            f2 = f4;
            while (object5.hasNext()) {
                MotionPaths motionPaths = object5.next();
                object4 = easing;
                float f6 = f2;
                f4 = f3;
                if (motionPaths.mKeyFrameEasing != null) {
                    if (motionPaths.time < f5) {
                        object4 = motionPaths.mKeyFrameEasing;
                        f6 = motionPaths.time;
                        f4 = f3;
                    } else {
                        object4 = easing;
                        f6 = f2;
                        f4 = f3;
                        if (Float.isNaN(f3)) {
                            f4 = motionPaths.time;
                            f6 = f2;
                            object4 = easing;
                        }
                    }
                }
                easing = object4;
                f2 = f6;
                f3 = f4;
            }
            if (easing != null) {
                f4 = f3;
                if (Float.isNaN(f3)) {
                    f4 = 1.0f;
                }
                f3 = f4 - f2;
                d = (float)easing.get((double)((f5 - f2) / f3)) * f3 + f2;
            }
            this.mSpline[0].getPos(d, this.mInterpolateData);
            easing = this.mArcSpline;
            if (easing != null && ((Easing)(object4 = (Object)this.mInterpolateData)).length > 0) {
                easing.getPos(d, (double[])object4);
            }
            easing = this.mStartMotionPath;
            object5 = this.mInterpolateVariables;
            object4 = this.mInterpolateData;
            int n3 = n2 * 2;
            easing.getCenter((int[])object5, (double[])object4, fArray, n3);
            if (object3 != null) {
                fArray[n3] = fArray[n3] + object3.get(f5);
            } else if (object != null) {
                fArray[n3] = fArray[n3] + object.get(f5);
            }
            if (keyCycleOscillator != null) {
                fArray[++n3] = fArray[n3] + keyCycleOscillator.get(f5);
            } else if (object2 != null) {
                fArray[++n3] = fArray[n3] + object2.get(f5);
            }
            ++n2;
        }
    }

    void buildRect(float f, float[] fArray, int n) {
        f = this.getAdjustedPosition(f, null);
        this.mSpline[0].getPos((double)f, this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArray, n);
    }

    void buildRectangles(float[] fArray, int n) {
        float f = 1.0f / (float)(n - 1);
        int n2 = 0;
        while (n2 < n) {
            float f2 = this.getAdjustedPosition((float)n2 * f, null);
            this.mSpline[0].getPos((double)f2, this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, fArray, n2 * 8);
            ++n2;
        }
    }

    int getAttributeValues(String string, float[] fArray, int n) {
        if ((string = this.mAttributesMap.get(string)) == null) {
            return -1;
        }
        n = 0;
        while (n < fArray.length) {
            fArray[n] = string.get((float)(n / (fArray.length - 1)));
            ++n;
        }
        return fArray.length;
    }

    void getDpDt(float f, float f2, float f3, float[] fArray) {
        double[] dArray;
        f = this.getAdjustedPosition(f, this.mVelocity);
        CurveFit curveFit = this.mSpline;
        if (curveFit == null) {
            float f4 = this.mEndMotionPath.x - this.mStartMotionPath.x;
            float f5 = this.mEndMotionPath.y - this.mStartMotionPath.y;
            float f6 = this.mEndMotionPath.width;
            float f7 = this.mStartMotionPath.width;
            f = this.mEndMotionPath.height;
            float f8 = this.mStartMotionPath.height;
            fArray[0] = f4 * (1.0f - f2) + (f6 - f7 + f4) * f2;
            fArray[1] = f5 * (1.0f - f3) + (f - f8 + f5) * f3;
            return;
        }
        curveFit = curveFit[0];
        double d = f;
        curveFit.getSlope(d, this.mInterpolateVelocity);
        this.mSpline[0].getPos(d, this.mInterpolateData);
        f = this.mVelocity[0];
        for (int i = 0; i < (dArray = this.mInterpolateVelocity).length; ++i) {
            double d2 = dArray[i];
            double d3 = f;
            Double.isNaN(d3);
            dArray[i] = d2 * d3;
        }
        curveFit = this.mArcSpline;
        if (curveFit != null) {
            dArray = this.mInterpolateData;
            if (dArray.length <= 0) return;
            curveFit.getPos(d, dArray);
            this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
            this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            return;
        }
        this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, dArray, this.mInterpolateData);
    }

    public int getDrawPath() {
        int n = this.mStartMotionPath.mDrawPath;
        Iterator<MotionPaths> iterator = this.mMotionPaths.iterator();
        while (iterator.hasNext()) {
            n = Math.max(n, iterator.next().mDrawPath);
        }
        return Math.max(n, this.mEndMotionPath.mDrawPath);
    }

    float getFinalX() {
        return this.mEndMotionPath.x;
    }

    float getFinalY() {
        return this.mEndMotionPath.y;
    }

    MotionPaths getKeyFrame(int n) {
        return this.mMotionPaths.get(n);
    }

    public int getKeyFrameInfo(int n, int[] nArray) {
        float[] fArray = new float[2];
        Iterator<Key> iterator = this.mKeyList.iterator();
        int n2 = 0;
        int n3 = 0;
        while (iterator.hasNext()) {
            Key key = iterator.next();
            if (key.mType != n && n == -1) continue;
            nArray[n3] = 0;
            int n4 = n3 + 1;
            nArray[n4] = key.mType;
            nArray[++n4] = key.mFramePosition;
            float f = (float)key.mFramePosition / 100.0f;
            this.mSpline[0].getPos((double)f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, 0);
            nArray[++n4] = Float.floatToIntBits(fArray[0]);
            int n5 = n4 + 1;
            nArray[n5] = Float.floatToIntBits(fArray[1]);
            n4 = n5;
            if (key instanceof KeyPosition) {
                key = (KeyPosition)key;
                n4 = n5 + 1;
                nArray[n4] = key.mPositionType;
                nArray[++n4] = Float.floatToIntBits(key.mPercentX);
                nArray[++n4] = Float.floatToIntBits(key.mPercentY);
            }
            nArray[n3] = ++n4 - n3;
            ++n2;
            n3 = n4;
        }
        return n2;
    }

    float getKeyFrameParameter(int n, float f, float f2) {
        float f3 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float f4 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float f5 = this.mStartMotionPath.x;
        float f6 = this.mStartMotionPath.width / 2.0f;
        float f7 = this.mStartMotionPath.y;
        float f8 = this.mStartMotionPath.height / 2.0f;
        float f9 = (float)Math.hypot(f3, f4);
        if ((double)f9 < 1.0E-7) {
            return Float.NaN;
        }
        if ((float)Math.hypot(f -= f5 + f6, f7 = f2 - (f7 + f8)) == 0.0f) {
            return 0.0f;
        }
        f2 = f * f3 + f7 * f4;
        if (n == 0) return f2 / f9;
        if (n == 1) return (float)Math.sqrt(f9 * f9 - f2 * f2);
        if (n == 2) return f / f3;
        if (n == 3) return f7 / f3;
        if (n == 4) return f / f4;
        if (n == 5) return f7 / f4;
        return 0.0f;
    }

    KeyPositionBase getPositionKeyframe(int n, int n2, float f, float f2) {
        Key key;
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.x;
        rectF.top = this.mStartMotionPath.y;
        rectF.right = rectF.left + this.mStartMotionPath.width;
        rectF.bottom = rectF.top + this.mStartMotionPath.height;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.x;
        rectF2.top = this.mEndMotionPath.y;
        rectF2.right = rectF2.left + this.mEndMotionPath.width;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.height;
        Iterator<Key> iterator = this.mKeyList.iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!((key = iterator.next()) instanceof KeyPositionBase) || !(key = (KeyPositionBase)key).intersects(n, n2, rectF, rectF2, f, f2));
        return key;
    }

    void getPostLayoutDvDp(float f, int n, int n2, float f2, float f3, float[] fArray) {
        float f4 = this.getAdjustedPosition(f, this.mVelocity);
        Object object = this.mAttributesMap;
        KeyCycleOscillator keyCycleOscillator = null;
        object = object == null ? null : object.get("translationX");
        Object object2 = this.mAttributesMap;
        object2 = object2 == null ? null : object2.get("translationY");
        Object object3 = this.mAttributesMap;
        object3 = object3 == null ? null : object3.get("rotation");
        Object object4 = this.mAttributesMap;
        object4 = object4 == null ? null : object4.get("scaleX");
        Object object5 = this.mAttributesMap;
        object5 = object5 == null ? null : object5.get("scaleY");
        Object object6 = this.mCycleMap;
        object6 = object6 == null ? null : object6.get("translationX");
        Object object7 = this.mCycleMap;
        object7 = object7 == null ? null : object7.get("translationY");
        Object object8 = this.mCycleMap;
        object8 = object8 == null ? null : object8.get("rotation");
        Object object9 = this.mCycleMap;
        object9 = object9 == null ? null : object9.get("scaleX");
        VelocityMatrix velocityMatrix = this.mCycleMap;
        if (velocityMatrix != null) {
            keyCycleOscillator = velocityMatrix.get("scaleY");
        }
        velocityMatrix = new VelocityMatrix();
        velocityMatrix.clear();
        velocityMatrix.setRotationVelocity(object3, f4);
        velocityMatrix.setTranslationVelocity(object, object2, f4);
        velocityMatrix.setScaleVelocity(object4, object5, f4);
        velocityMatrix.setRotationVelocity(object8, f4);
        velocityMatrix.setTranslationVelocity(object6, object7, f4);
        velocityMatrix.setScaleVelocity(object9, keyCycleOscillator, f4);
        CurveFit[] curveFitArray = this.mArcSpline;
        if (curveFitArray != null) {
            object = this.mInterpolateData;
            if (((SplineSet)object).length > 0) {
                double d = f4;
                curveFitArray.getPos(d, (double[])object);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
                this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
            }
            velocityMatrix.applyTransform(f2, f3, n, n2, fArray);
            return;
        }
        curveFitArray = this.mSpline;
        int n3 = 0;
        if (curveFitArray == null) {
            float f5 = this.mEndMotionPath.x - this.mStartMotionPath.x;
            float f6 = this.mEndMotionPath.y - this.mStartMotionPath.y;
            f = this.mEndMotionPath.width;
            float f7 = this.mStartMotionPath.width;
            float f8 = this.mEndMotionPath.height;
            float f9 = this.mStartMotionPath.height;
            fArray[0] = f5 * (1.0f - f2) + (f - f7 + f5) * f2;
            fArray[1] = f6 * (1.0f - f3) + (f8 - f9 + f6) * f3;
            velocityMatrix.clear();
            velocityMatrix.setRotationVelocity(object3, f4);
            velocityMatrix.setTranslationVelocity(object, object2, f4);
            velocityMatrix.setScaleVelocity(object4, object5, f4);
            velocityMatrix.setRotationVelocity(object8, f4);
            velocityMatrix.setTranslationVelocity(object6, object7, f4);
            velocityMatrix.setScaleVelocity(object9, keyCycleOscillator, f4);
            velocityMatrix.applyTransform(f2, f3, n, n2, fArray);
            return;
        }
        f = this.getAdjustedPosition(f4, this.mVelocity);
        object = this.mSpline[0];
        Object object10 = f;
        object.getSlope(object10, this.mInterpolateVelocity);
        this.mSpline[0].getPos(object10, this.mInterpolateData);
        f = this.mVelocity[0];
        while (true) {
            if (n3 >= ((SplineSet)(object = (Object)this.mInterpolateVelocity)).length) {
                this.mStartMotionPath.setDpDt(f2, f3, fArray, this.mInterpolateVariables, (double[])object, this.mInterpolateData);
                velocityMatrix.applyTransform(f2, f3, n, n2, fArray);
                return;
            }
            object10 = object[n3];
            double d = f;
            Double.isNaN(d);
            object[n3] = (SplineSet)(object10 * d);
            ++n3;
        }
    }

    float getStartX() {
        return this.mStartMotionPath.x;
    }

    float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getkeyFramePositions(int[] nArray, float[] fArray) {
        Iterator<Key> iterator = this.mKeyList.iterator();
        int n = 0;
        int n2 = 0;
        while (iterator.hasNext()) {
            Key key = iterator.next();
            nArray[n] = key.mFramePosition + key.mType * 1000;
            float f = (float)key.mFramePosition / 100.0f;
            this.mSpline[0].getPos((double)f, this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, fArray, n2);
            n2 += 2;
            ++n;
        }
        return n;
    }

    boolean interpolate(View view, float f, long l, KeyCache object) {
        boolean bl;
        int n;
        TimeCycleSplineSet timeCycleSplineSet2;
        Object object2;
        boolean bl2;
        float f2 = this.getAdjustedPosition(f, null);
        KeyCycleOscillator keyCycleOscillator = this.mAttributesMap;
        if (keyCycleOscillator != null) {
            keyCycleOscillator = keyCycleOscillator.values().iterator();
            while (keyCycleOscillator.hasNext()) {
                ((SplineSet)keyCycleOscillator.next()).setProperty(view, f2);
            }
        }
        if ((keyCycleOscillator = this.mTimeCycleAttributesMap) == null) {
            keyCycleOscillator = null;
            bl2 = false;
        } else {
            object2 = keyCycleOscillator.values().iterator();
            keyCycleOscillator = null;
            bl2 = false;
            while (object2.hasNext()) {
                timeCycleSplineSet2 = (TimeCycleSplineSet)object2.next();
                if (timeCycleSplineSet2 instanceof TimeCycleSplineSet.PathRotate) {
                    keyCycleOscillator = (TimeCycleSplineSet.PathRotate)timeCycleSplineSet2;
                    continue;
                }
                bl2 |= timeCycleSplineSet2.setProperty(view, f2, l, (KeyCache)object);
            }
        }
        if ((object2 = this.mSpline) != null) {
            object2 = object2[0];
            double d = f2;
            object2.getPos(d, this.mInterpolateData);
            this.mSpline[0].getSlope(d, this.mInterpolateVelocity);
            timeCycleSplineSet2 = this.mArcSpline;
            if (timeCycleSplineSet2 != null && ((CurveFit)(object2 = (Object)this.mInterpolateData)).length > 0) {
                timeCycleSplineSet2.getPos(d, (double[])object2);
                this.mArcSpline.getSlope(d, this.mInterpolateVelocity);
            }
            this.mStartMotionPath.setView(view, this.mInterpolateVariables, this.mInterpolateData, this.mInterpolateVelocity, null);
            object2 = this.mAttributesMap;
            if (object2 != null) {
                for (TimeCycleSplineSet timeCycleSplineSet2 : object2.values()) {
                    if (!(timeCycleSplineSet2 instanceof SplineSet.PathRotate)) continue;
                    timeCycleSplineSet2 = (SplineSet.PathRotate)timeCycleSplineSet2;
                    double[] dArray = this.mInterpolateVelocity;
                    timeCycleSplineSet2.setPathRotate(view, f2, dArray[0], dArray[1]);
                }
            }
            if (keyCycleOscillator != null) {
                object2 = this.mInterpolateVelocity;
                bl2 = keyCycleOscillator.setPathRotate(view, (KeyCache)object, f2, l, (double)object2[0], (double)object2[1]) | bl2;
            }
            for (n = 1; n < ((CurveFit[])(object = this.mSpline)).length; ++n) {
                object[n].getPos(d, this.mValuesBuff);
                ((ConstraintAttribute)this.mStartMotionPath.attributes.get(this.mAttributeNames[n - 1])).setInterpolatedValue(view, this.mValuesBuff);
            }
            if (this.mStartPoint.mVisibilityMode == 0) {
                if (f2 <= 0.0f) {
                    view.setVisibility(this.mStartPoint.visibility);
                } else if (f2 >= 1.0f) {
                    view.setVisibility(this.mEndPoint.visibility);
                } else if (this.mEndPoint.visibility != this.mStartPoint.visibility) {
                    view.setVisibility(0);
                }
            }
            bl = bl2;
            if (this.mKeyTriggers != null) {
                n = 0;
                while (true) {
                    object = this.mKeyTriggers;
                    bl = bl2;
                    if (n < ((Object)object).length) {
                        object[n].conditionallyFire(f2, view);
                        ++n;
                        continue;
                    }
                    break;
                }
            }
        } else {
            float f3 = this.mStartMotionPath.x;
            float f4 = this.mEndMotionPath.x;
            float f5 = this.mStartMotionPath.x;
            float f6 = this.mStartMotionPath.y;
            float f7 = this.mEndMotionPath.y;
            float f8 = this.mStartMotionPath.y;
            float f9 = this.mStartMotionPath.width;
            float f10 = this.mEndMotionPath.width;
            f = this.mStartMotionPath.width;
            float f11 = this.mStartMotionPath.height;
            float f12 = this.mEndMotionPath.height;
            float f13 = this.mStartMotionPath.height;
            f4 = f3 + (f4 - f5) * f2 + 0.5f;
            int n2 = (int)f4;
            f8 = f6 + (f7 - f8) * f2 + 0.5f;
            n = (int)f8;
            int n3 = (int)(f4 + (f9 + (f10 - f) * f2));
            int n4 = (int)(f8 + (f11 + (f12 - f13) * f2));
            if (this.mEndMotionPath.width != this.mStartMotionPath.width || this.mEndMotionPath.height != this.mStartMotionPath.height) {
                view.measure(View.MeasureSpec.makeMeasureSpec((int)(n3 - n2), (int)0x40000000), View.MeasureSpec.makeMeasureSpec((int)(n4 - n), (int)0x40000000));
            }
            view.layout(n2, n, n3, n4);
            bl = bl2;
        }
        if ((object = this.mCycleMap) == null) return bl;
        object = ((HashMap)object).values().iterator();
        while (object.hasNext()) {
            keyCycleOscillator = (KeyCycleOscillator)object.next();
            if (keyCycleOscillator instanceof KeyCycleOscillator.PathRotateSet) {
                keyCycleOscillator = (KeyCycleOscillator.PathRotateSet)keyCycleOscillator;
                object2 = this.mInterpolateVelocity;
                keyCycleOscillator.setPathRotate(view, f2, (double)object2[0], (double)object2[1]);
                continue;
            }
            keyCycleOscillator.setProperty(view, f2);
        }
        return bl;
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View view, KeyPositionBase keyPositionBase, float f, float f2, String[] stringArray, float[] fArray) {
        RectF rectF = new RectF();
        rectF.left = this.mStartMotionPath.x;
        rectF.top = this.mStartMotionPath.y;
        rectF.right = rectF.left + this.mStartMotionPath.width;
        rectF.bottom = rectF.top + this.mStartMotionPath.height;
        RectF rectF2 = new RectF();
        rectF2.left = this.mEndMotionPath.x;
        rectF2.top = this.mEndMotionPath.y;
        rectF2.right = rectF2.left + this.mEndMotionPath.width;
        rectF2.bottom = rectF2.top + this.mEndMotionPath.height;
        keyPositionBase.positionAttributes(view, rectF, rectF2, f, f2, stringArray, fArray);
    }

    public void setDrawPath(int n) {
        this.mStartMotionPath.mDrawPath = n;
    }

    void setEndState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        this.mEndMotionPath.time = 1.0f;
        this.mEndMotionPath.position = 1.0f;
        this.readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds((float)constraintWidget.getX(), (float)constraintWidget.getY(), (float)constraintWidget.getWidth(), (float)constraintWidget.getHeight());
        this.mEndMotionPath.applyParameters(constraintSet.getParameters(this.mId));
        this.mEndPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setPathMotionArc(int n) {
        this.mPathMotionArc = n;
    }

    void setStartCurrentState(View view) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.mStartMotionPath.setBounds(view.getX(), view.getY(), (float)view.getWidth(), (float)view.getHeight());
        this.mStartPoint.setState(view);
    }

    void setStartState(ConstraintWidget constraintWidget, ConstraintSet constraintSet) {
        this.mStartMotionPath.time = 0.0f;
        this.mStartMotionPath.position = 0.0f;
        this.readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds((float)constraintWidget.getX(), (float)constraintWidget.getY(), (float)constraintWidget.getWidth(), (float)constraintWidget.getHeight());
        ConstraintSet.Constraint constraint = constraintSet.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(constraint);
        this.mMotionStagger = constraint.motion.mMotionStagger;
        this.mStartPoint.setState(constraintWidget, constraintSet, this.mId);
    }

    public void setView(View view) {
        this.mView = view;
        this.mId = view.getId();
        if (!((view = view.getLayoutParams()) instanceof ConstraintLayout.LayoutParams)) return;
        this.mConstraintTag = ((ConstraintLayout.LayoutParams)view).getConstraintTag();
    }

    public void setup(int n, int n2, float f, long l) {
        int n3;
        int n4;
        Object object;
        Object object2;
        Object object3;
        Object object42;
        Object object5;
        Object object62;
        HashSet hashSet;
        Object object72;
        Object object8;
        block52: {
            Key key;
            block47: {
                new HashSet();
                object8 = new HashSet();
                object72 = new HashSet();
                hashSet = new HashSet();
                object62 = new HashMap();
                if (this.mPathMotionArc != Key.UNSET) {
                    this.mStartMotionPath.mPathMotionArc = this.mPathMotionArc;
                }
                this.mStartPoint.different(this.mEndPoint, object72);
                object5 = this.mKeyList;
                if (object5 == null) {
                    object42 = null;
                } else {
                    object3 = ((ArrayList)object5).iterator();
                    object5 = null;
                    while (true) {
                        object42 = object5;
                        if (!object3.hasNext()) break;
                        object2 = object3.next();
                        if (object2 instanceof KeyPosition) {
                            object42 = (KeyPosition)object2;
                            this.insertKey(new MotionPaths(n, n2, object42, this.mStartMotionPath, this.mEndMotionPath));
                            if (object42.mCurveFit == Key.UNSET) continue;
                            this.mCurveFitType = object42.mCurveFit;
                            continue;
                        }
                        if (object2 instanceof KeyCycle) {
                            object2.getAttributeNames(hashSet);
                            continue;
                        }
                        if (object2 instanceof KeyTimeCycle) {
                            object2.getAttributeNames((HashSet)object8);
                            continue;
                        }
                        if (object2 instanceof KeyTrigger) {
                            object42 = object5;
                            if (object5 == null) {
                                object42 = new ArrayList();
                            }
                            object42.add((KeyTrigger)object2);
                            object5 = object42;
                            continue;
                        }
                        object2.setInterpolation(object62);
                        object2.getAttributeNames(object72);
                    }
                }
                if (object42 != null) {
                    this.mKeyTriggers = object42.toArray(new KeyTrigger[0]);
                }
                if (object72.isEmpty()) break block47;
                this.mAttributesMap = new HashMap();
                object3 = object72.iterator();
                while (true) {
                    block51: {
                        SparseArray sparseArray;
                        block50: {
                            block48: {
                                block49: {
                                    if (!object3.hasNext()) break block48;
                                    object42 = (String)object3.next();
                                    if (!object42.startsWith("CUSTOM,")) break block49;
                                    sparseArray = new SparseArray();
                                    object5 = object42.split(",")[1];
                                    key = this.mKeyList.iterator();
                                    break block50;
                                }
                                object5 = SplineSet.makeSpline(object42);
                                break block51;
                            }
                            object5 = this.mKeyList;
                            if (object5 != null) {
                                object5 = ((ArrayList)object5).iterator();
                                while (object5.hasNext()) {
                                    object42 = (Key)object5.next();
                                    if (!(object42 instanceof KeyAttributes)) continue;
                                    object42.addValues(this.mAttributesMap);
                                }
                            }
                            this.mStartPoint.addValues(this.mAttributesMap, 0);
                            this.mEndPoint.addValues(this.mAttributesMap, 100);
                            object42 = this.mAttributesMap.keySet().iterator();
                            break;
                        }
                        while (key.hasNext()) {
                            object2 = key.next();
                            if (object2.mCustomConstraints == null || (object = (ConstraintAttribute)object2.mCustomConstraints.get(object5)) == null) continue;
                            sparseArray.append(object2.mFramePosition, object);
                        }
                        object5 = SplineSet.makeCustomSpline((String)object42, (SparseArray)sparseArray);
                    }
                    if (object5 == null) continue;
                    object5.setType((String)object42);
                    this.mAttributesMap.put((String)object42, (SplineSet)object5);
                }
                while (object42.hasNext()) {
                    object5 = (String)object42.next();
                    n = ((HashMap)object62).containsKey(object5) ? (Integer)((HashMap)object62).get(object5) : 0;
                    this.mAttributesMap.get(object5).setup(n);
                }
            }
            if (((HashSet)object8).isEmpty()) break block52;
            if (this.mTimeCycleAttributesMap == null) {
                this.mTimeCycleAttributesMap = new HashMap();
            }
            object42 = ((HashSet)object8).iterator();
            while (true) {
                block56: {
                    block55: {
                        block53: {
                            block54: {
                                if (!object42.hasNext()) break block53;
                                object8 = (String)object42.next();
                                if (this.mTimeCycleAttributesMap.containsKey(object8)) continue;
                                if (!((String)object8).startsWith("CUSTOM,")) break block54;
                                object = new SparseArray();
                                object2 = ((String)object8).split(",")[1];
                                object5 = this.mKeyList.iterator();
                                break block55;
                            }
                            object5 = TimeCycleSplineSet.makeSpline((String)object8, (long)l);
                            break block56;
                        }
                        object5 = this.mKeyList;
                        if (object5 != null) {
                            object42 = ((ArrayList)object5).iterator();
                            while (object42.hasNext()) {
                                object5 = (Key)object42.next();
                                if (!(object5 instanceof KeyTimeCycle)) continue;
                                ((KeyTimeCycle)object5).addTimeValues(this.mTimeCycleAttributesMap);
                            }
                        }
                        object42 = this.mTimeCycleAttributesMap.keySet().iterator();
                        break;
                    }
                    while (object5.hasNext()) {
                        key = (Key)object5.next();
                        if (key.mCustomConstraints == null || (object3 = (ConstraintAttribute)key.mCustomConstraints.get(object2)) == null) continue;
                        object.append(key.mFramePosition, object3);
                    }
                    object5 = TimeCycleSplineSet.makeCustomSpline((String)object8, (SparseArray)object);
                }
                if (object5 == null) continue;
                object5.setType((String)object8);
                this.mTimeCycleAttributesMap.put((String)object8, (TimeCycleSplineSet)object5);
            }
            while (object42.hasNext()) {
                object5 = (String)object42.next();
                n = ((HashMap)object62).containsKey(object5) ? (Integer)((HashMap)object62).get(object5) : 0;
                this.mTimeCycleAttributesMap.get(object5).setup(n);
            }
        }
        int n5 = this.mMotionPaths.size() + 2;
        object8 = new MotionPaths[n5];
        object8[0] = this.mStartMotionPath;
        object8[n5 - 1] = this.mEndMotionPath;
        if (this.mMotionPaths.size() > 0 && this.mCurveFitType == -1) {
            this.mCurveFitType = 0;
        }
        object5 = this.mMotionPaths.iterator();
        n = 1;
        while (object5.hasNext()) {
            object8[n] = (MotionPaths)object5.next();
            ++n;
        }
        object5 = new HashSet();
        for (Object object62 : this.mEndMotionPath.attributes.keySet()) {
            if (!this.mStartMotionPath.attributes.containsKey(object62)) continue;
            object42 = new StringBuilder();
            object42.append("CUSTOM,");
            object42.append((String)object62);
            if (object72.contains(object42.toString())) continue;
            ((HashSet)object5).add(object62);
        }
        object5 = ((AbstractCollection)object5).toArray(new String[0]);
        this.mAttributeNames = object5;
        this.mAttributeInterpCount = new int[((Object)object5).length];
        n = 0;
        while (true) {
            if (n < ((Object)(object5 = this.mAttributeNames)).length) {
                object5 = object5[n];
                this.mAttributeInterpCount[n] = 0;
            } else {
                boolean bl = ((MotionPaths)object8[0]).mPathMotionArc != Key.UNSET;
                n4 = 18 + this.mAttributeNames.length;
                object42 = new boolean[n4];
                for (n = 1; n < n5; ++n) {
                    object8[n].different((MotionPaths)object8[n - 1], (boolean[])object42, this.mAttributeNames, bl);
                }
                n2 = 0;
                for (n = 1; n < n4; ++n) {
                    n3 = n2;
                    if (object42[n] != false) {
                        n3 = n2 + 1;
                    }
                    n2 = n3;
                }
                object5 = new int[n2];
                this.mInterpolateVariables = (int[])object5;
                this.mInterpolateData = new double[((SplineSet)object5).length];
                this.mInterpolateVelocity = new double[((SplineSet)object5).length];
                n = 0;
                for (n3 = 1; n3 < n4; ++n3) {
                    n2 = n;
                    if (object42[n3] != false) {
                        this.mInterpolateVariables[n] = n3;
                        n2 = n + 1;
                    }
                    n = n2;
                }
                object3 = new double[n5][this.mInterpolateVariables.length];
                object2 = new double[n5];
                for (n = 0; n < n5; ++n) {
                    object8[n].fillStandard((double[])object3[n], this.mInterpolateVariables);
                    object2[n] = (Key)((double)((MotionPaths)object8[n]).time);
                }
                break;
            }
            for (n2 = 0; n2 < n5; ++n2) {
                if (!((MotionPaths)object8[n2]).attributes.containsKey(object5)) continue;
                object42 = this.mAttributeInterpCount;
                object42[n] = object42[n] + ((ConstraintAttribute)((MotionPaths)object8[n2]).attributes.get(object5)).noOfInterpValues();
                break;
            }
            ++n;
        }
        for (n = 0; n < ((SplineSet)(object5 = (Object)this.mInterpolateVariables)).length; ++n) {
            if (object5[n] >= MotionPaths.names.length) continue;
            object5 = new StringBuilder();
            ((StringBuilder)object5).append(MotionPaths.names[this.mInterpolateVariables[n]]);
            ((StringBuilder)object5).append(" [");
            object5 = ((StringBuilder)object5).toString();
            for (n2 = 0; n2 < n5; ++n2) {
                object42 = new StringBuilder();
                object42.append((String)object5);
                object42.append((double)object3[n2][n]);
                object5 = object42.toString();
            }
        }
        this.mSpline = new CurveFit[this.mAttributeNames.length + 1];
        n = 0;
        while (n < ((String[])(object42 = this.mAttributeNames)).length) {
            object5 = null;
            object = object42[n];
            object42 = null;
            n2 = 0;
            for (n3 = 0; n3 < n5; ++n3) {
                object72 = object5;
                object62 = object42;
                n4 = n2;
                if (object8[n3].hasCustomData((String)object)) {
                    object72 = object5;
                    if (object5 == null) {
                        object42 = new double[n5];
                        object72 = new double[n5][object8[n3].getCustomDataCount((String)object)];
                    }
                    object42[n2] = (double)((MotionPaths)object8[n3]).time;
                    object8[n3].getCustomData((String)object, (double[])object72[n2], 0);
                    n4 = n2 + 1;
                    object62 = object42;
                }
                object5 = object72;
                object42 = object62;
                n2 = n4;
            }
            object42 = Arrays.copyOf((double[])object42, n2);
            object5 = (double[][])Arrays.copyOf(object5, n2);
            object72 = this.mSpline;
            object72[++n] = CurveFit.get((int)this.mCurveFitType, (double[])object42, (double[][])object5);
        }
        this.mSpline[0] = CurveFit.get((int)this.mCurveFitType, (double[])object2, (double[][])object3);
        if (((MotionPaths)object8[0]).mPathMotionArc != Key.UNSET) {
            object42 = new int[n5];
            object72 = new double[n5];
            object5 = new double[n5][2];
            for (n = 0; n < n5; ++n) {
                object42[n] = ((MotionPaths)object8[n]).mPathMotionArc;
                object72[n] = (SplineSet)((double)((MotionPaths)object8[n]).time);
                object5[n][0] = (double)((MotionPaths)object8[n]).x;
                object5[n][1] = (double)((MotionPaths)object8[n]).y;
            }
            this.mArcSpline = CurveFit.getArc((int[])object42, (double[])object72, (double[][])object5);
        }
        f = Float.NaN;
        this.mCycleMap = new HashMap();
        if (this.mKeyList == null) return;
        for (Object object72 : hashSet) {
            object5 = KeyCycleOscillator.makeSpline((String)object72);
            if (object5 == null) continue;
            float f2 = f;
            if (object5.variesByPath()) {
                f2 = f;
                if (Float.isNaN(f)) {
                    f2 = this.getPreCycleDistance();
                }
            }
            object5.setType((String)object72);
            this.mCycleMap.put((String)object72, (KeyCycleOscillator)object5);
            f = f2;
        }
        for (Object object42 : this.mKeyList) {
            if (!(object42 instanceof KeyCycle)) continue;
            ((KeyCycle)object42).addCycleValues(this.mCycleMap);
        }
        object5 = this.mCycleMap.values().iterator();
        while (object5.hasNext()) {
            ((KeyCycleOscillator)object5.next()).setup(f);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" start: x: ");
        stringBuilder.append(this.mStartMotionPath.x);
        stringBuilder.append(" y: ");
        stringBuilder.append(this.mStartMotionPath.y);
        stringBuilder.append(" end: x: ");
        stringBuilder.append(this.mEndMotionPath.x);
        stringBuilder.append(" y: ");
        stringBuilder.append(this.mEndMotionPath.y);
        return stringBuilder.toString();
    }
}
