/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  androidx.constraintlayout.motion.widget.Debug
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyCycle$Loader
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.ConstraintAttribute$AttributeType
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyCycle;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
public class KeyCycle
extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
    private float mAlpha;
    private int mCurveFit = 0;
    private float mElevation;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing = null;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset = 0.0f;
    private float mWavePeriod = Float.NaN;
    private int mWaveShape = -1;
    private int mWaveVariesBy = -1;

    public KeyCycle() {
        this.mProgress = Float.NaN;
        this.mAlpha = Float.NaN;
        this.mElevation = Float.NaN;
        this.mRotation = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mRotationX = Float.NaN;
        this.mRotationY = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mType = 4;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$1000(KeyCycle keyCycle) {
        return keyCycle.mRotationX;
    }

    static /* synthetic */ float access$1002(KeyCycle keyCycle, float f) {
        keyCycle.mRotationX = f;
        return f;
    }

    static /* synthetic */ String access$102(KeyCycle keyCycle, String string) {
        keyCycle.mTransitionEasing = string;
        return string;
    }

    static /* synthetic */ float access$1100(KeyCycle keyCycle) {
        return keyCycle.mRotationY;
    }

    static /* synthetic */ float access$1102(KeyCycle keyCycle, float f) {
        keyCycle.mRotationY = f;
        return f;
    }

    static /* synthetic */ float access$1200(KeyCycle keyCycle) {
        return keyCycle.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1202(KeyCycle keyCycle, float f) {
        keyCycle.mTransitionPathRotate = f;
        return f;
    }

    static /* synthetic */ float access$1300(KeyCycle keyCycle) {
        return keyCycle.mScaleX;
    }

    static /* synthetic */ float access$1302(KeyCycle keyCycle, float f) {
        keyCycle.mScaleX = f;
        return f;
    }

    static /* synthetic */ float access$1400(KeyCycle keyCycle) {
        return keyCycle.mScaleY;
    }

    static /* synthetic */ float access$1402(KeyCycle keyCycle, float f) {
        keyCycle.mScaleY = f;
        return f;
    }

    static /* synthetic */ float access$1500(KeyCycle keyCycle) {
        return keyCycle.mTranslationX;
    }

    static /* synthetic */ float access$1502(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationX = f;
        return f;
    }

    static /* synthetic */ float access$1600(KeyCycle keyCycle) {
        return keyCycle.mTranslationY;
    }

    static /* synthetic */ float access$1602(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationY = f;
        return f;
    }

    static /* synthetic */ float access$1700(KeyCycle keyCycle) {
        return keyCycle.mTranslationZ;
    }

    static /* synthetic */ float access$1702(KeyCycle keyCycle, float f) {
        keyCycle.mTranslationZ = f;
        return f;
    }

    static /* synthetic */ float access$1800(KeyCycle keyCycle) {
        return keyCycle.mProgress;
    }

    static /* synthetic */ float access$1802(KeyCycle keyCycle, float f) {
        keyCycle.mProgress = f;
        return f;
    }

    static /* synthetic */ int access$200(KeyCycle keyCycle) {
        return keyCycle.mCurveFit;
    }

    static /* synthetic */ int access$202(KeyCycle keyCycle, int n) {
        keyCycle.mCurveFit = n;
        return n;
    }

    static /* synthetic */ int access$300(KeyCycle keyCycle) {
        return keyCycle.mWaveShape;
    }

    static /* synthetic */ int access$302(KeyCycle keyCycle, int n) {
        keyCycle.mWaveShape = n;
        return n;
    }

    static /* synthetic */ float access$400(KeyCycle keyCycle) {
        return keyCycle.mWavePeriod;
    }

    static /* synthetic */ float access$402(KeyCycle keyCycle, float f) {
        keyCycle.mWavePeriod = f;
        return f;
    }

    static /* synthetic */ float access$500(KeyCycle keyCycle) {
        return keyCycle.mWaveOffset;
    }

    static /* synthetic */ float access$502(KeyCycle keyCycle, float f) {
        keyCycle.mWaveOffset = f;
        return f;
    }

    static /* synthetic */ int access$600(KeyCycle keyCycle) {
        return keyCycle.mWaveVariesBy;
    }

    static /* synthetic */ int access$602(KeyCycle keyCycle, int n) {
        keyCycle.mWaveVariesBy = n;
        return n;
    }

    static /* synthetic */ float access$700(KeyCycle keyCycle) {
        return keyCycle.mAlpha;
    }

    static /* synthetic */ float access$702(KeyCycle keyCycle, float f) {
        keyCycle.mAlpha = f;
        return f;
    }

    static /* synthetic */ float access$800(KeyCycle keyCycle) {
        return keyCycle.mElevation;
    }

    static /* synthetic */ float access$802(KeyCycle keyCycle, float f) {
        keyCycle.mElevation = f;
        return f;
    }

    static /* synthetic */ float access$900(KeyCycle keyCycle) {
        return keyCycle.mRotation;
    }

    static /* synthetic */ float access$902(KeyCycle keyCycle, float f) {
        keyCycle.mRotation = f;
        return f;
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        Iterator<String> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            String string = iterator.next();
            if (string.startsWith("CUSTOM")) {
                String string2 = string.substring(7);
                if ((string2 = (ConstraintAttribute)this.mCustomConstraints.get(string2)) == null || string2.getType() != ConstraintAttribute.AttributeType.FLOAT_TYPE) continue;
                hashMap.get(string).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, string2.getValueToInterpolate(), (ConstraintAttribute)string2);
                continue;
            }
            float f = this.getValue(string);
            if (Float.isNaN(f)) continue;
            hashMap.get(string).setPoint(this.mFramePosition, this.mWaveShape, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, f);
        }
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("add ");
        ((StringBuilder)object).append(hashMap.size());
        ((StringBuilder)object).append(" values");
        Debug.logStack((String)"KeyCycle", (String)((StringBuilder)object).toString(), (int)2);
        object = hashMap.keySet().iterator();
        block30: while (object.hasNext()) {
            String string = (String)object.next();
            Object object2 = hashMap.get(string);
            int n = -1;
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 156108012: {
                    if (!string.equals("waveOffset")) break;
                    n = 11;
                    break;
                }
                case 92909918: {
                    if (!string.equals("alpha")) break;
                    n = 0;
                    break;
                }
                case 37232917: {
                    if (!string.equals("transitionPathRotate")) break;
                    n = 5;
                    break;
                }
                case -4379043: {
                    if (!string.equals("elevation")) break;
                    n = 1;
                    break;
                }
                case -40300674: {
                    if (!string.equals("rotation")) break;
                    n = 2;
                    break;
                }
                case -908189617: {
                    if (!string.equals("scaleY")) break;
                    n = 7;
                    break;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 6;
                    break;
                }
                case -1001078227: {
                    if (!string.equals("progress")) break;
                    n = 12;
                    break;
                }
                case -1225497655: {
                    if (!string.equals("translationZ")) break;
                    n = 10;
                    break;
                }
                case -1225497656: {
                    if (!string.equals("translationY")) break;
                    n = 9;
                    break;
                }
                case -1225497657: {
                    if (!string.equals("translationX")) break;
                    n = 8;
                    break;
                }
                case -1249320805: {
                    if (!string.equals("rotationY")) break;
                    n = 4;
                    break;
                }
                case -1249320806: {
                    if (!string.equals("rotationX")) break;
                    n = 3;
                }
            }
            switch (n) {
                default: {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("WARNING KeyCycle UNKNOWN  ");
                    ((StringBuilder)object2).append(string);
                    Log.v((String)"KeyCycle", (String)((StringBuilder)object2).toString());
                    continue block30;
                }
                case 12: {
                    object2.setPoint(this.mFramePosition, this.mProgress);
                    continue block30;
                }
                case 11: {
                    object2.setPoint(this.mFramePosition, this.mWaveOffset);
                    continue block30;
                }
                case 10: {
                    object2.setPoint(this.mFramePosition, this.mTranslationZ);
                    continue block30;
                }
                case 9: {
                    object2.setPoint(this.mFramePosition, this.mTranslationY);
                    continue block30;
                }
                case 8: {
                    object2.setPoint(this.mFramePosition, this.mTranslationX);
                    continue block30;
                }
                case 7: {
                    object2.setPoint(this.mFramePosition, this.mScaleY);
                    continue block30;
                }
                case 6: {
                    object2.setPoint(this.mFramePosition, this.mScaleX);
                    continue block30;
                }
                case 5: {
                    object2.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                    continue block30;
                }
                case 4: {
                    object2.setPoint(this.mFramePosition, this.mRotationY);
                    continue block30;
                }
                case 3: {
                    object2.setPoint(this.mFramePosition, this.mRotationX);
                    continue block30;
                }
                case 2: {
                    object2.setPoint(this.mFramePosition, this.mRotation);
                    continue block30;
                }
                case 1: {
                    object2.setPoint(this.mFramePosition, this.mElevation);
                    continue block30;
                }
                case 0: 
            }
            object2.setPoint(this.mFramePosition, this.mAlpha);
        }
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
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add("transitionPathRotate");
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

    public float getValue(String string) {
        int n;
        block30: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 156108012: {
                    if (!string.equals("waveOffset")) break;
                    n = 11;
                    break block30;
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
                    n = 7;
                    break block30;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 6;
                    break block30;
                }
                case -1001078227: {
                    if (!string.equals("progress")) break;
                    n = 12;
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
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("WARNING! KeyCycle UNKNOWN  ");
                stringBuilder.append(string);
                Log.v((String)"KeyCycle", (String)stringBuilder.toString());
                return Float.NaN;
            }
            case 12: {
                return this.mProgress;
            }
            case 11: {
                return this.mWaveOffset;
            }
            case 10: {
                return this.mTranslationZ;
            }
            case 9: {
                return this.mTranslationY;
            }
            case 8: {
                return this.mTranslationX;
            }
            case 7: {
                return this.mScaleY;
            }
            case 6: {
                return this.mScaleX;
            }
            case 5: {
                return this.mTransitionPathRotate;
            }
            case 4: {
                return this.mRotationY;
            }
            case 3: {
                return this.mRotationX;
            }
            case 2: {
                return this.mRotation;
            }
            case 1: {
                return this.mElevation;
            }
            case 0: 
        }
        return this.mAlpha;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.access$000((KeyCycle)this, (TypedArray)context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    public void setValue(String string, Object object) {
        int n;
        block36: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1317633238: {
                    if (!string.equals("mTranslationZ")) break;
                    n = 13;
                    break block36;
                }
                case 579057826: {
                    if (!string.equals("curveFit")) break;
                    n = 1;
                    break block36;
                }
                case 184161818: {
                    if (!string.equals("wavePeriod")) break;
                    n = 14;
                    break block36;
                }
                case 156108012: {
                    if (!string.equals("waveOffset")) break;
                    n = 15;
                    break block36;
                }
                case 92909918: {
                    if (!string.equals("alpha")) break;
                    n = 0;
                    break block36;
                }
                case 37232917: {
                    if (!string.equals("transitionPathRotate")) break;
                    n = 10;
                    break block36;
                }
                case -4379043: {
                    if (!string.equals("elevation")) break;
                    n = 2;
                    break block36;
                }
                case -40300674: {
                    if (!string.equals("rotation")) break;
                    n = 4;
                    break block36;
                }
                case -908189617: {
                    if (!string.equals("scaleY")) break;
                    n = 8;
                    break block36;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 7;
                    break block36;
                }
                case -1001078227: {
                    if (!string.equals("progress")) break;
                    n = 3;
                    break block36;
                }
                case -1225497656: {
                    if (!string.equals("translationY")) break;
                    n = 12;
                    break block36;
                }
                case -1225497657: {
                    if (!string.equals("translationX")) break;
                    n = 11;
                    break block36;
                }
                case -1249320805: {
                    if (!string.equals("rotationY")) break;
                    n = 6;
                    break block36;
                }
                case -1249320806: {
                    if (!string.equals("rotationX")) break;
                    n = 5;
                    break block36;
                }
                case -1812823328: {
                    if (!string.equals("transitionEasing")) break;
                    n = 9;
                    break block36;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                break;
            }
            case 15: {
                this.mWaveOffset = this.toFloat(object);
                break;
            }
            case 14: {
                this.mWavePeriod = this.toFloat(object);
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
