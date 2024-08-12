/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.graphics.RectF
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.constraintlayout.motion.widget.KeyPosition$Loader
 *  androidx.constraintlayout.motion.widget.KeyPositionBase
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.widget.R$styleable
 */
package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.KeyPosition;
import androidx.constraintlayout.motion.widget.KeyPositionBase;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/*
 * Exception performing whole class analysis ignored.
 */
public class KeyPosition
extends KeyPositionBase {
    static final int KEY_TYPE = 2;
    static final String NAME = "KeyPosition";
    private static final String PERCENT_X = "percentX";
    private static final String PERCENT_Y = "percentY";
    private static final String TAG = "KeyPosition";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    float mAltPercentX;
    float mAltPercentY;
    private float mCalculatedPositionX;
    private float mCalculatedPositionY;
    int mDrawPath = 0;
    int mPathMotionArc = UNSET;
    float mPercentHeight;
    float mPercentWidth = Float.NaN;
    float mPercentX;
    float mPercentY;
    int mPositionType = 0;
    String mTransitionEasing = null;

    public KeyPosition() {
        this.mPercentHeight = Float.NaN;
        this.mPercentX = Float.NaN;
        this.mPercentY = Float.NaN;
        this.mAltPercentX = Float.NaN;
        this.mAltPercentY = Float.NaN;
        this.mCalculatedPositionX = Float.NaN;
        this.mCalculatedPositionY = Float.NaN;
        this.mType = 2;
    }

    private void calcCartesianPosition(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        boolean bl = Float.isNaN(this.mPercentX);
        float f7 = 0.0f;
        f3 = bl ? 0.0f : this.mPercentX;
        f4 = Float.isNaN(this.mAltPercentY) ? 0.0f : this.mAltPercentY;
        float f8 = Float.isNaN(this.mPercentY) ? 0.0f : this.mPercentY;
        if (!Float.isNaN(this.mAltPercentX)) {
            f7 = this.mAltPercentX;
        }
        this.mCalculatedPositionX = (int)(f + f3 * f5 + f7 * f6);
        this.mCalculatedPositionY = (int)(f2 + f5 * f4 + f6 * f8);
    }

    private void calcPathPosition(float f, float f2, float f3, float f4) {
        float f5 = f4 - f2;
        float f6 = -f5;
        f4 = this.mPercentX;
        float f7 = this.mPercentY;
        this.mCalculatedPositionX = f + (f3 -= f) * f4 + f6 * f7;
        this.mCalculatedPositionY = f2 + f5 * f4 + f3 * f7;
    }

    private void calcScreenPosition(int n, int n2) {
        float f = n - 0;
        float f2 = this.mPercentX;
        float f3 = 0.0f;
        this.mCalculatedPositionX = f * f2 + f3;
        this.mCalculatedPositionY = (float)(n2 - 0) * f2 + f3;
    }

    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    void calcPosition(int n, int n2, float f, float f2, float f3, float f4) {
        int n3 = this.mPositionType;
        if (n3 == 1) {
            this.calcPathPosition(f, f2, f3, f4);
            return;
        }
        if (n3 != 2) {
            this.calcCartesianPosition(f, f2, f3, f4);
            return;
        }
        this.calcScreenPosition(n, n2);
    }

    float getPositionX() {
        return this.mCalculatedPositionX;
    }

    float getPositionY() {
        return this.mCalculatedPositionY;
    }

    public boolean intersects(int n, int n2, RectF rectF, RectF rectF2, float f, float f2) {
        this.calcPosition(n, n2, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        if (!(Math.abs(f - this.mCalculatedPositionX) < 20.0f)) return false;
        if (!(Math.abs(f2 - this.mCalculatedPositionY) < 20.0f)) return false;
        return true;
    }

    public void load(Context context, AttributeSet attributeSet) {
        Loader.access$000((KeyPosition)this, (TypedArray)context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] stringArray, float[] fArray) {
        int n = this.mPositionType;
        if (n == 1) {
            this.positionPathAttributes(rectF, rectF2, f, f2, stringArray, fArray);
            return;
        }
        if (n != 2) {
            this.positionCartAttributes(rectF, rectF2, f, f2, stringArray, fArray);
            return;
        }
        this.positionScreenAttributes(view, rectF, rectF2, f, f2, stringArray, fArray);
    }

    void positionCartAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] stringArray, float[] fArray) {
        float f3 = rectF.centerX();
        float f4 = rectF.centerY();
        float f5 = rectF2.centerX();
        float f6 = rectF2.centerY();
        f5 -= f3;
        f6 -= f4;
        if (stringArray[0] != null) {
            if ("percentX".equals(stringArray[0])) {
                fArray[0] = (f - f3) / f5;
                fArray[1] = (f2 - f4) / f6;
            } else {
                fArray[1] = (f - f3) / f5;
                fArray[0] = (f2 - f4) / f6;
            }
        } else {
            stringArray[0] = "percentX";
            fArray[0] = (f - f3) / f5;
            stringArray[1] = "percentY";
            fArray[1] = (f2 - f4) / f6;
        }
    }

    void positionPathAttributes(RectF rectF, RectF rectF2, float f, float f2, String[] stringArray, float[] fArray) {
        float f3 = rectF.centerX();
        float f4 = rectF.centerY();
        float f5 = rectF2.centerX();
        float f6 = rectF2.centerY();
        float f7 = f6 - f4;
        if ((double)(f6 = (float)Math.hypot(f5 -= f3, f7)) < 1.0E-4) {
            System.out.println("distance ~ 0");
            fArray[0] = 0.0f;
            fArray[1] = 0.0f;
            return;
        }
        f3 = f - f3;
        f = ((f5 /= f6) * (f2 -= f4) - f3 * (f7 /= f6)) / f6;
        f2 = (f5 * f3 + f7 * f2) / f6;
        if (stringArray[0] != null) {
            if (!"percentX".equals(stringArray[0])) return;
            fArray[0] = f2;
            fArray[1] = f;
        } else {
            stringArray[0] = "percentX";
            stringArray[1] = "percentY";
            fArray[0] = f2;
            fArray[1] = f;
        }
    }

    void positionScreenAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] stringArray, float[] fArray) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        view = (ViewGroup)view.getParent();
        int n = view.getWidth();
        int n2 = view.getHeight();
        if (stringArray[0] != null) {
            if ("percentX".equals(stringArray[0])) {
                fArray[0] = f / (float)n;
                fArray[1] = f2 / (float)n2;
            } else {
                fArray[1] = f / (float)n;
                fArray[0] = f2 / (float)n2;
            }
        } else {
            stringArray[0] = "percentX";
            fArray[0] = f / (float)n;
            stringArray[1] = "percentY";
            fArray[1] = f2 / (float)n2;
        }
    }

    public void setValue(String string, Object object) {
        int n;
        block18: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 428090548: {
                    if (!string.equals("percentY")) break;
                    n = 6;
                    break block18;
                }
                case 428090547: {
                    if (!string.equals("percentX")) break;
                    n = 5;
                    break block18;
                }
                case -200259324: {
                    if (!string.equals("sizePercent")) break;
                    n = 4;
                    break block18;
                }
                case -827014263: {
                    if (!string.equals("drawPath")) break;
                    n = 1;
                    break block18;
                }
                case -1017587252: {
                    if (!string.equals("percentHeight")) break;
                    n = 3;
                    break block18;
                }
                case -1127236479: {
                    if (!string.equals("percentWidth")) break;
                    n = 2;
                    break block18;
                }
                case -1812823328: {
                    if (!string.equals("transitionEasing")) break;
                    n = 0;
                    break block18;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                break;
            }
            case 6: {
                this.mPercentY = this.toFloat(object);
                break;
            }
            case 5: {
                this.mPercentX = this.toFloat(object);
                break;
            }
            case 4: {
                float f;
                this.mPercentWidth = f = this.toFloat(object);
                this.mPercentHeight = f;
                break;
            }
            case 3: {
                this.mPercentHeight = this.toFloat(object);
                break;
            }
            case 2: {
                this.mPercentWidth = this.toFloat(object);
                break;
            }
            case 1: {
                this.mDrawPath = this.toInt(object);
                break;
            }
            case 0: {
                this.mTransitionEasing = object.toString();
            }
        }
    }
}
