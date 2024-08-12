/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.motion.widget.Debug
 *  androidx.constraintlayout.motion.widget.Key
 *  androidx.constraintlayout.motion.widget.KeyTrigger$Loader
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.Debug;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.KeyTrigger;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

/*
 * Exception performing whole class analysis ignored.
 */
public class KeyTrigger
extends Key {
    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    RectF mCollisionRect;
    private String mCross = null;
    private int mCurveFit = -1;
    private Method mFireCross;
    private boolean mFireCrossReset = true;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset = true;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset = true;
    private float mFireThreshold;
    private String mNegativeCross = null;
    private String mPositiveCross = null;
    private boolean mPostLayout = false;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView = null;
    private int mTriggerID;
    private int mTriggerReceiver = UNSET;
    float mTriggerSlack = 0.1f;

    public KeyTrigger() {
        this.mTriggerID = UNSET;
        this.mTriggerCollisionId = UNSET;
        this.mFireThreshold = Float.NaN;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    static /* synthetic */ float access$002(KeyTrigger keyTrigger, float f) {
        keyTrigger.mFireThreshold = f;
        return f;
    }

    static /* synthetic */ String access$102(KeyTrigger keyTrigger, String string) {
        keyTrigger.mNegativeCross = string;
        return string;
    }

    static /* synthetic */ String access$202(KeyTrigger keyTrigger, String string) {
        keyTrigger.mPositiveCross = string;
        return string;
    }

    static /* synthetic */ String access$302(KeyTrigger keyTrigger, String string) {
        keyTrigger.mCross = string;
        return string;
    }

    static /* synthetic */ int access$400(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerID;
    }

    static /* synthetic */ int access$402(KeyTrigger keyTrigger, int n) {
        keyTrigger.mTriggerID = n;
        return n;
    }

    static /* synthetic */ int access$500(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerCollisionId;
    }

    static /* synthetic */ int access$502(KeyTrigger keyTrigger, int n) {
        keyTrigger.mTriggerCollisionId = n;
        return n;
    }

    static /* synthetic */ boolean access$600(KeyTrigger keyTrigger) {
        return keyTrigger.mPostLayout;
    }

    static /* synthetic */ boolean access$602(KeyTrigger keyTrigger, boolean bl) {
        keyTrigger.mPostLayout = bl;
        return bl;
    }

    static /* synthetic */ int access$700(KeyTrigger keyTrigger) {
        return keyTrigger.mTriggerReceiver;
    }

    static /* synthetic */ int access$702(KeyTrigger keyTrigger, int n) {
        keyTrigger.mTriggerReceiver = n;
        return n;
    }

    private void setUpRect(RectF rectF, View view, boolean bl) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (!bl) return;
        view.getMatrix().mapRect(rectF);
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    /*
     * Unable to fully structure code
     */
    public void conditionallyFire(float var1_1, View var2_2) {
        block37: {
            block43: {
                block42: {
                    block41: {
                        block40: {
                            block39: {
                                block38: {
                                    block35: {
                                        block36: {
                                            var5_3 = this.mTriggerCollisionId;
                                            var6_4 = KeyTrigger.UNSET;
                                            var7_5 = true;
                                            if (var5_3 == var6_4) break block35;
                                            if (this.mTriggerCollisionView == null) {
                                                this.mTriggerCollisionView = ((ViewGroup)var2_2.getParent()).findViewById(this.mTriggerCollisionId);
                                            }
                                            this.setUpRect(this.mCollisionRect, this.mTriggerCollisionView, this.mPostLayout);
                                            this.setUpRect(this.mTargetRect, var2_2, this.mPostLayout);
                                            if (!this.mCollisionRect.intersect(this.mTargetRect)) break block36;
                                            if (this.mFireCrossReset) {
                                                this.mFireCrossReset = false;
                                                var5_3 = 1;
                                            } else {
                                                var5_3 = 0;
                                            }
                                            if (this.mFirePositiveReset) {
                                                this.mFirePositiveReset = false;
                                                var7_5 = true;
                                            } else {
                                                var7_5 = false;
                                            }
                                            this.mFireNegativeReset = true;
                                            var6_4 = 0;
                                            break block37;
                                        }
                                        if (!this.mFireCrossReset) {
                                            this.mFireCrossReset = true;
                                            var5_3 = 1;
                                        } else {
                                            var5_3 = 0;
                                        }
                                        if (this.mFireNegativeReset) {
                                            this.mFireNegativeReset = false;
                                            var6_4 = 1;
                                        } else {
                                            var6_4 = 0;
                                        }
                                        this.mFirePositiveReset = true;
                                        ** GOTO lbl72
                                    }
                                    if (!this.mFireCrossReset) break block38;
                                    var3_6 = this.mFireThreshold;
                                    if (!((var1_1 - var3_6) * (this.mFireLastPos - var3_6) < 0.0f)) break block39;
                                    this.mFireCrossReset = false;
                                    var5_3 = 1;
                                    break block40;
                                }
                                if (Math.abs(var1_1 - this.mFireThreshold) > this.mTriggerSlack) {
                                    this.mFireCrossReset = true;
                                }
                            }
                            var5_3 = 0;
                        }
                        if (!this.mFireNegativeReset) break block41;
                        var4_7 = this.mFireThreshold;
                        var3_6 = var1_1 - var4_7;
                        if (!((this.mFireLastPos - var4_7) * var3_6 < 0.0f) || !(var3_6 < 0.0f)) break block42;
                        this.mFireNegativeReset = false;
                        var6_4 = 1;
                        break block43;
                    }
                    if (Math.abs(var1_1 - this.mFireThreshold) > this.mTriggerSlack) {
                        this.mFireNegativeReset = true;
                    }
                }
                var6_4 = 0;
            }
            if (this.mFirePositiveReset) {
                var4_7 = this.mFireThreshold;
                var3_6 = var1_1 - var4_7;
                if ((this.mFireLastPos - var4_7) * var3_6 < 0.0f && var3_6 > 0.0f) {
                    this.mFirePositiveReset = false;
                } else {
                    var7_5 = false;
                }
            } else {
                if (Math.abs(var1_1 - this.mFireThreshold) > this.mTriggerSlack) {
                    this.mFirePositiveReset = true;
                }
lbl72:
                // 4 sources

                var7_5 = false;
            }
        }
        this.mFireLastPos = var1_1;
        if (var6_4 != 0 || var5_3 != 0 || var7_5) {
            ((MotionLayout)var2_2.getParent()).fireTrigger(this.mTriggerID, var7_5, var1_1);
        }
        if (this.mTriggerReceiver != KeyTrigger.UNSET) {
            var2_2 = ((MotionLayout)var2_2.getParent()).findViewById(this.mTriggerReceiver);
        }
        if (var6_4 != 0 && this.mNegativeCross != null) {
            if (this.mFireNegativeCross == null) {
                try {
                    this.mFireNegativeCross = var2_2.getClass().getMethod(this.mNegativeCross, new Class[0]);
                }
                catch (NoSuchMethodException var8_8) {
                    var8_9 = new StringBuilder();
                    var8_9.append("Could not find method \"");
                    var8_9.append(this.mNegativeCross);
                    var8_9.append("\"on class ");
                    var8_9.append(var2_2.getClass().getSimpleName());
                    var8_9.append(" ");
                    var8_9.append(Debug.getName((View)var2_2));
                    Log.e((String)"KeyTrigger", (String)var8_9.toString());
                }
            }
            try {
                this.mFireNegativeCross.invoke(var2_2, new Object[0]);
            }
            catch (Exception var8_10) {
                var8_9 = new StringBuilder();
                var8_9.append("Exception in call \"");
                var8_9.append(this.mNegativeCross);
                var8_9.append("\"on class ");
                var8_9.append(var2_2.getClass().getSimpleName());
                var8_9.append(" ");
                var8_9.append(Debug.getName((View)var2_2));
                Log.e((String)"KeyTrigger", (String)var8_9.toString());
            }
        }
        if (var7_5 && this.mPositiveCross != null) {
            if (this.mFirePositiveCross == null) {
                try {
                    this.mFirePositiveCross = var2_2.getClass().getMethod(this.mPositiveCross, new Class[0]);
                }
                catch (NoSuchMethodException var8_11) {
                    var8_9 = new StringBuilder();
                    var8_9.append("Could not find method \"");
                    var8_9.append(this.mPositiveCross);
                    var8_9.append("\"on class ");
                    var8_9.append(var2_2.getClass().getSimpleName());
                    var8_9.append(" ");
                    var8_9.append(Debug.getName((View)var2_2));
                    Log.e((String)"KeyTrigger", (String)var8_9.toString());
                }
            }
            try {
                this.mFirePositiveCross.invoke(var2_2, new Object[0]);
            }
            catch (Exception var8_12) {
                var8_9 = new StringBuilder();
                var8_9.append("Exception in call \"");
                var8_9.append(this.mPositiveCross);
                var8_9.append("\"on class ");
                var8_9.append(var2_2.getClass().getSimpleName());
                var8_9.append(" ");
                var8_9.append(Debug.getName((View)var2_2));
                Log.e((String)"KeyTrigger", (String)var8_9.toString());
            }
        }
        if (var5_3 == 0) return;
        if (this.mCross == null) return;
        if (this.mFireCross == null) {
            try {
                this.mFireCross = var2_2.getClass().getMethod(this.mCross, new Class[0]);
            }
            catch (NoSuchMethodException var8_13) {
                var8_9 = new StringBuilder();
                var8_9.append("Could not find method \"");
                var8_9.append(this.mCross);
                var8_9.append("\"on class ");
                var8_9.append(var2_2.getClass().getSimpleName());
                var8_9.append(" ");
                var8_9.append(Debug.getName((View)var2_2));
                Log.e((String)"KeyTrigger", (String)var8_9.toString());
            }
        }
        try {
            this.mFireCross.invoke(var2_2, new Object[0]);
        }
        catch (Exception var8_14) {
            var8_15 = new StringBuilder();
            var8_15.append("Exception in call \"");
            var8_15.append(this.mCross);
            var8_15.append("\"on class ");
            var8_15.append(var2_2.getClass().getSimpleName());
            var8_15.append(" ");
            var8_15.append(Debug.getName((View)var2_2));
            Log.e((String)"KeyTrigger", (String)var8_15.toString());
        }
    }

    public void getAttributeNames(HashSet<String> hashSet) {
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.read((KeyTrigger)this, (TypedArray)context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), (Context)context);
    }

    public void setValue(String string, Object object) {
    }
}
