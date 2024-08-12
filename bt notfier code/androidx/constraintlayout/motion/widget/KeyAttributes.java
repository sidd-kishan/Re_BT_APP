/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyAttributes$Loader
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.motion.widget.SplineSet$CustomSet
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyAttributes;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/*
 * Exception performing whole class analysis ignored.
 */
public class KeyAttributes
extends Key {
    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private float mAlpha = Float.NaN;
    private int mCurveFit = -1;
    private float mElevation = Float.NaN;
    private float mPivotX;
    private float mPivotY;
    private float mProgress;
    private float mRotation = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private boolean mVisibility = false;

    public KeyAttributes() {
        this.mPivotX = Float.NaN;
        this.mPivotY = Float.NaN;
        this.mTransitionPathRotate = Float.NaN;
        this.mScaleX = Float.NaN;
        this.mScaleY = Float.NaN;
        this.mTranslationX = Float.NaN;
        this.mTranslationY = Float.NaN;
        this.mTranslationZ = Float.NaN;
        this.mProgress = Float.NaN;
        this.mType = 1;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$000(KeyAttributes keyAttributes) {
        return keyAttributes.mAlpha;
    }

    static /* synthetic */ float access$002(KeyAttributes keyAttributes, float f) {
        keyAttributes.mAlpha = f;
        return f;
    }

    static /* synthetic */ float access$100(KeyAttributes keyAttributes) {
        return keyAttributes.mElevation;
    }

    static /* synthetic */ float access$1000(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleY;
    }

    static /* synthetic */ float access$1002(KeyAttributes keyAttributes, float f) {
        keyAttributes.mScaleY = f;
        return f;
    }

    static /* synthetic */ float access$102(KeyAttributes keyAttributes, float f) {
        keyAttributes.mElevation = f;
        return f;
    }

    static /* synthetic */ float access$1100(KeyAttributes keyAttributes) {
        return keyAttributes.mTransitionPathRotate;
    }

    static /* synthetic */ float access$1102(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTransitionPathRotate = f;
        return f;
    }

    static /* synthetic */ float access$1200(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationX;
    }

    static /* synthetic */ float access$1202(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationX = f;
        return f;
    }

    static /* synthetic */ float access$1300(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationY;
    }

    static /* synthetic */ float access$1302(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationY = f;
        return f;
    }

    static /* synthetic */ float access$1400(KeyAttributes keyAttributes) {
        return keyAttributes.mTranslationZ;
    }

    static /* synthetic */ float access$1402(KeyAttributes keyAttributes, float f) {
        keyAttributes.mTranslationZ = f;
        return f;
    }

    static /* synthetic */ float access$1500(KeyAttributes keyAttributes) {
        return keyAttributes.mProgress;
    }

    static /* synthetic */ float access$1502(KeyAttributes keyAttributes, float f) {
        keyAttributes.mProgress = f;
        return f;
    }

    static /* synthetic */ float access$200(KeyAttributes keyAttributes) {
        return keyAttributes.mRotation;
    }

    static /* synthetic */ float access$202(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotation = f;
        return f;
    }

    static /* synthetic */ int access$300(KeyAttributes keyAttributes) {
        return keyAttributes.mCurveFit;
    }

    static /* synthetic */ int access$302(KeyAttributes keyAttributes, int n) {
        keyAttributes.mCurveFit = n;
        return n;
    }

    static /* synthetic */ float access$400(KeyAttributes keyAttributes) {
        return keyAttributes.mScaleX;
    }

    static /* synthetic */ float access$402(KeyAttributes keyAttributes, float f) {
        keyAttributes.mScaleX = f;
        return f;
    }

    static /* synthetic */ float access$500(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationX;
    }

    static /* synthetic */ float access$502(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotationX = f;
        return f;
    }

    static /* synthetic */ float access$600(KeyAttributes keyAttributes) {
        return keyAttributes.mRotationY;
    }

    static /* synthetic */ float access$602(KeyAttributes keyAttributes, float f) {
        keyAttributes.mRotationY = f;
        return f;
    }

    static /* synthetic */ float access$700(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotX;
    }

    static /* synthetic */ float access$702(KeyAttributes keyAttributes, float f) {
        keyAttributes.mPivotX = f;
        return f;
    }

    static /* synthetic */ float access$800(KeyAttributes keyAttributes) {
        return keyAttributes.mPivotY;
    }

    static /* synthetic */ float access$802(KeyAttributes keyAttributes, float f) {
        keyAttributes.mPivotY = f;
        return f;
    }

    static /* synthetic */ String access$902(KeyAttributes keyAttributes, String string) {
        keyAttributes.mTransitionEasing = string;
        return string;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
        Iterator<String> iterator = hashMap.keySet().iterator();
        block32: while (iterator.hasNext()) {
            int n;
            Object object;
            String string;
            block34: {
                string = iterator.next();
                object = hashMap.get(string);
                boolean bl = string.startsWith("CUSTOM");
                n = 7;
                if (bl) {
                    string = string.substring(7);
                    if ((string = (ConstraintAttribute)this.mCustomConstraints.get(string)) == null) continue;
                    ((SplineSet.CustomSet)object).setPoint(this.mFramePosition, (ConstraintAttribute)string);
                    continue;
                }
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 92909918: {
                        if (!string.equals("alpha")) break;
                        n = 0;
                        break block34;
                    }
                    case 37232917: {
                        if (!string.equals("transitionPathRotate")) break;
                        break block34;
                    }
                    case -4379043: {
                        if (!string.equals("elevation")) break;
                        n = 1;
                        break block34;
                    }
                    case -40300674: {
                        if (!string.equals("rotation")) break;
                        n = 2;
                        break block34;
                    }
                    case -760884509: {
                        if (!string.equals("transformPivotY")) break;
                        n = 6;
                        break block34;
                    }
                    case -760884510: {
                        if (!string.equals("transformPivotX")) break;
                        n = 5;
                        break block34;
                    }
                    case -908189617: {
                        if (!string.equals("scaleY")) break;
                        n = 9;
                        break block34;
                    }
                    case -908189618: {
                        if (!string.equals("scaleX")) break;
                        n = 8;
                        break block34;
                    }
                    case -1001078227: {
                        if (!string.equals("progress")) break;
                        n = 13;
                        break block34;
                    }
                    case -1225497655: {
                        if (!string.equals("translationZ")) break;
                        n = 12;
                        break block34;
                    }
                    case -1225497656: {
                        if (!string.equals("translationY")) break;
                        n = 11;
                        break block34;
                    }
                    case -1225497657: {
                        if (!string.equals("translationX")) break;
                        n = 10;
                        break block34;
                    }
                    case -1249320805: {
                        if (!string.equals("rotationY")) break;
                        n = 4;
                        break block34;
                    }
                    case -1249320806: {
                        if (!string.equals("rotationX")) break;
                        n = 3;
                        break block34;
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
                    Log.v((String)"KeyAttributes", (String)((StringBuilder)object).toString());
                    continue block32;
                }
                case 13: {
                    if (Float.isNaN(this.mProgress)) continue block32;
                    object.setPoint(this.mFramePosition, this.mProgress);
                    continue block32;
                }
                case 12: {
                    if (Float.isNaN(this.mTranslationZ)) continue block32;
                    object.setPoint(this.mFramePosition, this.mTranslationZ);
                    continue block32;
                }
                case 11: {
                    if (Float.isNaN(this.mTranslationY)) continue block32;
                    object.setPoint(this.mFramePosition, this.mTranslationY);
                    continue block32;
                }
                case 10: {
                    if (Float.isNaN(this.mTranslationX)) continue block32;
                    object.setPoint(this.mFramePosition, this.mTranslationX);
                    continue block32;
                }
                case 9: {
                    if (Float.isNaN(this.mScaleY)) continue block32;
                    object.setPoint(this.mFramePosition, this.mScaleY);
                    continue block32;
                }
                case 8: {
                    if (Float.isNaN(this.mScaleX)) continue block32;
                    object.setPoint(this.mFramePosition, this.mScaleX);
                    continue block32;
                }
                case 7: {
                    if (Float.isNaN(this.mTransitionPathRotate)) continue block32;
                    object.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                    continue block32;
                }
                case 6: {
                    if (Float.isNaN(this.mRotationY)) continue block32;
                    object.setPoint(this.mFramePosition, this.mPivotY);
                    continue block32;
                }
                case 5: {
                    if (Float.isNaN(this.mRotationX)) continue block32;
                    object.setPoint(this.mFramePosition, this.mPivotX);
                    continue block32;
                }
                case 4: {
                    if (Float.isNaN(this.mRotationY)) continue block32;
                    object.setPoint(this.mFramePosition, this.mRotationY);
                    continue block32;
                }
                case 3: {
                    if (Float.isNaN(this.mRotationX)) continue block32;
                    object.setPoint(this.mFramePosition, this.mRotationX);
                    continue block32;
                }
                case 2: {
                    if (Float.isNaN(this.mRotation)) continue block32;
                    object.setPoint(this.mFramePosition, this.mRotation);
                    continue block32;
                }
                case 1: {
                    if (Float.isNaN(this.mElevation)) continue block32;
                    object.setPoint(this.mFramePosition, this.mElevation);
                    continue block32;
                }
                case 0: 
            }
            if (Float.isNaN(this.mAlpha)) continue;
            object.setPoint(this.mFramePosition, this.mAlpha);
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
        if (!Float.isNaN(this.mPivotX)) {
            hashSet.add("transformPivotX");
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashSet.add("transformPivotY");
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

    int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read((KeyAttributes)this, (TypedArray)context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
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
        if (!Float.isNaN(this.mPivotX)) {
            hashMap.put("transformPivotX", this.mCurveFit);
        }
        if (!Float.isNaN(this.mPivotY)) {
            hashMap.put("transformPivotY", this.mCurveFit);
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
        if (!Float.isNaN(this.mScaleY)) {
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
        block38: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 1941332754: {
                    if (!string.equals("visibility")) break;
                    n = 12;
                    break block38;
                }
                case 1317633238: {
                    if (!string.equals("mTranslationZ")) break;
                    n = 16;
                    break block38;
                }
                case 579057826: {
                    if (!string.equals("curveFit")) break;
                    n = 1;
                    break block38;
                }
                case 92909918: {
                    if (!string.equals("alpha")) break;
                    n = 0;
                    break block38;
                }
                case 37232917: {
                    if (!string.equals("transitionPathRotate")) break;
                    n = 13;
                    break block38;
                }
                case -4379043: {
                    if (!string.equals("elevation")) break;
                    n = 2;
                    break block38;
                }
                case -40300674: {
                    if (!string.equals("rotation")) break;
                    n = 4;
                    break block38;
                }
                case -908189617: {
                    if (!string.equals("scaleY")) break;
                    n = 10;
                    break block38;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 9;
                    break block38;
                }
                case -987906985: {
                    if (!string.equals("pivotY")) break;
                    n = 8;
                    break block38;
                }
                case -987906986: {
                    if (!string.equals("pivotX")) break;
                    n = 7;
                    break block38;
                }
                case -1225497656: {
                    if (!string.equals("translationY")) break;
                    n = 15;
                    break block38;
                }
                case -1225497657: {
                    if (!string.equals("translationX")) break;
                    n = 14;
                    break block38;
                }
                case -1249320805: {
                    if (!string.equals("rotationY")) break;
                    n = 6;
                    break block38;
                }
                case -1249320806: {
                    if (!string.equals("rotationX")) break;
                    n = 5;
                    break block38;
                }
                case -1812823328: {
                    if (!string.equals("transitionEasing")) break;
                    n = 11;
                    break block38;
                }
                case -1913008125: {
                    if (!string.equals("motionProgress")) break;
                    n = 3;
                    break block38;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                break;
            }
            case 16: {
                this.mTranslationZ = this.toFloat(object);
                break;
            }
            case 15: {
                this.mTranslationY = this.toFloat(object);
                break;
            }
            case 14: {
                this.mTranslationX = this.toFloat(object);
                break;
            }
            case 13: {
                this.mTransitionPathRotate = this.toFloat(object);
                break;
            }
            case 12: {
                this.mVisibility = this.toBoolean(object);
                break;
            }
            case 11: {
                this.mTransitionEasing = object.toString();
                break;
            }
            case 10: {
                this.mScaleY = this.toFloat(object);
                break;
            }
            case 9: {
                this.mScaleX = this.toFloat(object);
                break;
            }
            case 8: {
                this.mPivotY = this.toFloat(object);
                break;
            }
            case 7: {
                this.mPivotX = this.toFloat(object);
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
