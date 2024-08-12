/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyTimeCycle$Loader
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$CustomSet
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyTimeCycle;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
public class KeyTimeCycle
extends Key {
    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha = Float.NaN;
    private int mCurveFit = -1;
    private float mElevation = Float.NaN;
    private float mProgress;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate = Float.NaN;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset = 0.0f;
    private float mWavePeriod;
    private int mWaveShape = 0;

    public KeyTimeCycle() {
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mWavePeriod = Float.NaN;
        this.mType = 3;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$000(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mAlpha;
    }

    static /* synthetic */ float access$002(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mAlpha = f;
        return f;
    }

    static /* synthetic */ float access$100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mElevation;
    }

    static /* synthetic */ String access$1002(KeyTimeCycle keyTimeCycle, String string) {
        keyTimeCycle.mTransitionEasing = string;
        return string;
    }

    static /* synthetic */ float access$102(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mElevation = f;
        return f;
    }

    static /* synthetic */ float access$1100(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleY;
    }

    static /* synthetic */ float access$1102(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mScaleY = f;
        return f;
    }

    static /* synthetic */ float access$1200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1202(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTransitionPathRotate = f;
        return f;
    }

    static /* synthetic */ float access$1300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationX;
    }

    static /* synthetic */ float access$1302(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationX = f;
        return f;
    }

    static /* synthetic */ float access$1400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationY;
    }

    static /* synthetic */ float access$1402(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationY = f;
        return f;
    }

    static /* synthetic */ float access$1500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mTranslationZ;
    }

    static /* synthetic */ float access$1502(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mTranslationZ = f;
        return f;
    }

    static /* synthetic */ float access$1600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mProgress;
    }

    static /* synthetic */ float access$1602(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mProgress = f;
        return f;
    }

    static /* synthetic */ float access$200(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotation;
    }

    static /* synthetic */ float access$202(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotation = f;
        return f;
    }

    static /* synthetic */ int access$300(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mCurveFit;
    }

    static /* synthetic */ int access$302(KeyTimeCycle keyTimeCycle, int n) {
        keyTimeCycle.mCurveFit = n;
        return n;
    }

    static /* synthetic */ int access$400(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveShape;
    }

    static /* synthetic */ int access$402(KeyTimeCycle keyTimeCycle, int n) {
        keyTimeCycle.mWaveShape = n;
        return n;
    }

    static /* synthetic */ float access$500(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWavePeriod;
    }

    static /* synthetic */ float access$502(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mWavePeriod = f;
        return f;
    }

    static /* synthetic */ float access$600(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mWaveOffset;
    }

    static /* synthetic */ float access$602(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mWaveOffset = f;
        return f;
    }

    static /* synthetic */ float access$700(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mScaleX;
    }

    static /* synthetic */ float access$702(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mScaleX = f;
        return f;
    }

    static /* synthetic */ float access$800(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationX;
    }

    static /* synthetic */ float access$802(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotationX = f;
        return f;
    }

    static /* synthetic */ float access$900(KeyTimeCycle keyTimeCycle) {
        return keyTimeCycle.mRotationY;
    }

    static /* synthetic */ float access$902(KeyTimeCycle keyTimeCycle, float f) {
        keyTimeCycle.mRotationY = f;
        return f;
    }

    public void addTimeValues(HashMap<String, TimeCycleSplineSet> hashMap) {
        Iterator<String> iterator = hashMap.keySet().iterator();
        block28: while (iterator.hasNext()) {
            int n;
            Object object;
            String string;
            block30: {
                string = iterator.next();
                object = hashMap.get(string);
                boolean bl = string.startsWith("CUSTOM");
                n = 7;
                if (bl) {
                    string = string.substring(7);
                    if ((string = (ConstraintAttribute)this.mCustomConstraints.get(string)) == null) continue;
                    ((TimeCycleSplineSet.CustomSet)object).setPoint(this.mFramePosition, (ConstraintAttribute)string, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue;
                }
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 92909918: {
                        if (!string.equals("alpha")) break;
                        n = 0;
                        break block30;
                    }
                    case 37232917: {
                        if (!string.equals("transitionPathRotate")) break;
                        n = 5;
                        break block30;
                    }
                    case -4379043: {
                        if (!string.equals("elevation")) break;
                        n = 1;
                        break block30;
                    }
                    case -40300674: {
                        if (!string.equals("rotation")) break;
                        n = 2;
                        break block30;
                    }
                    case -908189617: {
                        if (!string.equals("scaleY")) break;
                        break block30;
                    }
                    case -908189618: {
                        if (!string.equals("scaleX")) break;
                        n = 6;
                        break block30;
                    }
                    case -1001078227: {
                        if (!string.equals("progress")) break;
                        n = 11;
                        break block30;
                    }
                    case -1225497655: {
                        if (!string.equals("translationZ")) break;
                        n = 10;
                        break block30;
                    }
                    case -1225497656: {
                        if (!string.equals("translationY")) break;
                        n = 9;
                        break block30;
                    }
                    case -1225497657: {
                        if (!string.equals("translationX")) break;
                        n = 8;
                        break block30;
                    }
                    case -1249320805: {
                        if (!string.equals("rotationY")) break;
                        n = 4;
                        break block30;
                    }
                    case -1249320806: {
                        if (!string.equals("rotationX")) break;
                        n = 3;
                        break block30;
                    }
                }
                n = -1;
            }
            switch (n) {
                default: {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("UNKNOWN addValues \"");
                    ((StringBuilder)object).append(string);
                    ((StringBuilder)object).append("\"");
                    Log.e((String)"KeyTimeCycles", (String)((StringBuilder)object).toString());
                    continue block28;
                }
                case 11: {
                    if (Float.isNaN(this.mProgress)) continue block28;
                    object.setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 10: {
                    if (Float.isNaN(this.mTranslationZ)) continue block28;
                    object.setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 9: {
                    if (Float.isNaN(this.mTranslationY)) continue block28;
                    object.setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 8: {
                    if (Float.isNaN(this.mTranslationX)) continue block28;
                    object.setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 7: {
                    if (Float.isNaN(this.mScaleY)) continue block28;
                    object.setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 6: {
                    if (Float.isNaN(this.mScaleX)) continue block28;
                    object.setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 5: {
                    if (Float.isNaN(this.mTransitionPathRotate)) continue block28;
                    object.setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 4: {
                    if (Float.isNaN(this.mRotationY)) continue block28;
                    object.setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 3: {
                    if (Float.isNaN(this.mRotationX)) continue block28;
                    object.setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 2: {
                    if (Float.isNaN(this.mRotation)) continue block28;
                    object.setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 1: {
                    if (Float.isNaN(this.mElevation)) continue block28;
                    object.setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                    continue block28;
                }
                case 0: 
            }
            if (Float.isNaN(this.mAlpha)) continue;
            object.setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mProgress)) {
            hashSet.add("progress");
        }
        if (this.mCustomConstraints.size() <= 0) return;
        Iterator iterator = this.mCustomConstraints.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CUSTOM,");
            stringBuilder.append(string);
            hashSet.add(stringBuilder.toString());
        }
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read((KeyTimeCycle)this, (TypedArray)context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.mCurveFit == -1) {
            return;
        }
        if (!Float.isNaN(this.mAlpha)) {
            hashMap.put("alpha", this.mCurveFit);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashMap.put("elevation", this.mCurveFit);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashMap.put("rotation", this.mCurveFit);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashMap.put("rotationX", this.mCurveFit);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashMap.put("rotationY", this.mCurveFit);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashMap.put("translationX", this.mCurveFit);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashMap.put("translationY", this.mCurveFit);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashMap.put("translationZ", this.mCurveFit);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashMap.put("transitionPathRotate", this.mCurveFit);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put("scaleX", this.mCurveFit);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashMap.put("scaleY", this.mCurveFit);
        }
        if (!Float.isNaN(this.mProgress)) {
            hashMap.put("progress", this.mCurveFit);
        }
        if (this.mCustomConstraints.size() <= 0) return;
        Iterator iterator = this.mCustomConstraints.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("CUSTOM,");
            stringBuilder.append(string);
            hashMap.put(stringBuilder.toString(), this.mCurveFit);
        }
    }

    public void setValue(String string, Object object) {
        int n;
        block32: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1317633238: {
                    if (!string.equals("mTranslationZ")) break;
                    n = 13;
                    break block32;
                }
                case 579057826: {
                    if (!string.equals("curveFit")) break;
                    n = 1;
                    break block32;
                }
                case 92909918: {
                    if (!string.equals("alpha")) break;
                    n = 0;
                    break block32;
                }
                case 37232917: {
                    if (!string.equals("transitionPathRotate")) break;
                    n = 10;
                    break block32;
                }
                case -4379043: {
                    if (!string.equals("elevation")) break;
                    n = 2;
                    break block32;
                }
                case -40300674: {
                    if (!string.equals("rotation")) break;
                    n = 4;
                    break block32;
                }
                case -908189617: {
                    if (!string.equals("scaleY")) break;
                    n = 8;
                    break block32;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 7;
                    break block32;
                }
                case -1001078227: {
                    if (!string.equals("progress")) break;
                    n = 3;
                    break block32;
                }
                case -1225497656: {
                    if (!string.equals("translationY")) break;
                    n = 12;
                    break block32;
                }
                case -1225497657: {
                    if (!string.equals("translationX")) break;
                    n = 11;
                    break block32;
                }
                case -1249320805: {
                    if (!string.equals("rotationY")) break;
                    n = 6;
                    break block32;
                }
                case -1249320806: {
                    if (!string.equals("rotationX")) break;
                    n = 5;
                    break block32;
                }
                case -1812823328: {
                    if (!string.equals("transitionEasing")) break;
                    n = 9;
                    break block32;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                break;
            }
            case 13: {
                this.mTranslationZ = this.toFloat(object);
                break;
            }
            case 12: {
                this.mTranslationY = this.toFloat(object);
                break;
            }
            case 11: {
                this.mTranslationX = this.toFloat(object);
                break;
            }
            case 10: {
                this.mTransitionPathRotate = this.toFloat(object);
                break;
            }
            case 9: {
                this.mTransitionEasing = object.toString();
                break;
            }
            case 8: {
                this.mScaleY = this.toFloat(object);
                break;
            }
            case 7: {
                this.mScaleX = this.toFloat(object);
                break;
            }
            case 6: {
                this.mRotationY = this.toFloat(object);
                break;
            }
            case 5: {
                this.mRotationX = this.toFloat(object);
                break;
            }
            case 4: {
                this.mRotation = this.toFloat(object);
                break;
            }
            case 3: {
                this.mProgress = this.toFloat(object);
                break;
            }
            case 2: {
                this.mElevation = this.toFloat(object);
                break;
            }
            case 1: {
                this.mCurveFit = this.toInt(object);
                break;
            }
            case 0: {
                this.mAlpha = this.toFloat(object);
            }
        }
    }
}
