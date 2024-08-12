/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.util.SparseArray
 *  android.view.View
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$AlphaSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$CustomSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ElevationSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$PathRotate
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ProgressSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationSet
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationXset
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$RotationYset
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ScaleXset
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$ScaleYset
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$Sort
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationXset
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationYset
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet$TranslationZset
 *  androidx.constraintlayout.widget.ConstraintAttribute
 */
package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.text.DecimalFormat;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class TimeCycleSplineSet {
    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = (float)Math.PI * 2;
    private int count;
    float last_cycle;
    long last_time;
    private float[] mCache;
    protected boolean mContinue = false;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[][] mValues = new float[10][3];
    protected int mWaveShape = 0;

    public TimeCycleSplineSet() {
        this.mCache = new float[3];
        this.last_cycle = Float.NaN;
    }

    static TimeCycleSplineSet makeCustomSpline(String string, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(string, sparseArray);
    }

    static TimeCycleSplineSet makeSpline(String string, long l) {
        int n;
        block28: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 92909918: {
                    if (!string.equals("alpha")) break;
                    n = 0;
                    break block28;
                }
                case 37232917: {
                    if (!string.equals("transitionPathRotate")) break;
                    n = 5;
                    break block28;
                }
                case -4379043: {
                    if (!string.equals("elevation")) break;
                    n = 1;
                    break block28;
                }
                case -40300674: {
                    if (!string.equals("rotation")) break;
                    n = 2;
                    break block28;
                }
                case -908189617: {
                    if (!string.equals("scaleY")) break;
                    n = 7;
                    break block28;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 6;
                    break block28;
                }
                case -1001078227: {
                    if (!string.equals("progress")) break;
                    n = 11;
                    break block28;
                }
                case -1225497655: {
                    if (!string.equals("translationZ")) break;
                    n = 10;
                    break block28;
                }
                case -1225497656: {
                    if (!string.equals("translationY")) break;
                    n = 9;
                    break block28;
                }
                case -1225497657: {
                    if (!string.equals("translationX")) break;
                    n = 8;
                    break block28;
                }
                case -1249320805: {
                    if (!string.equals("rotationY")) break;
                    n = 4;
                    break block28;
                }
                case -1249320806: {
                    if (!string.equals("rotationX")) break;
                    n = 3;
                    break block28;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return null;
            }
            case 11: {
                string = new ProgressSet();
                break;
            }
            case 10: {
                string = new TranslationZset();
                break;
            }
            case 9: {
                string = new TranslationYset();
                break;
            }
            case 8: {
                string = new TranslationXset();
                break;
            }
            case 7: {
                string = new ScaleYset();
                break;
            }
            case 6: {
                string = new ScaleXset();
                break;
            }
            case 5: {
                string = new PathRotate();
                break;
            }
            case 4: {
                string = new RotationYset();
                break;
            }
            case 3: {
                string = new RotationXset();
                break;
            }
            case 2: {
                string = new RotationSet();
                break;
            }
            case 1: {
                string = new ElevationSet();
                break;
            }
            case 0: {
                string = new AlphaSet();
            }
        }
        ((TimeCycleSplineSet)((Object)string)).setStartTime(l);
        return string;
    }

    /*
     * Enabled force condition propagation
     */
    protected float calcWave(float f) {
        switch (this.mWaveShape) {
            default: {
                return (float)Math.sin(f * VAL_2PI);
            }
            case 6: {
                f = 1.0f - Math.abs(f * 4.0f % 4.0f - 2.0f);
                f *= f;
                return 1.0f - f;
            }
            case 5: {
                return (float)Math.cos(f * VAL_2PI);
            }
            case 4: {
                f = (f * 2.0f + 1.0f) % 2.0f;
                return 1.0f - f;
            }
            case 3: {
                return (f * 2.0f + 1.0f) % 2.0f - 1.0f;
            }
            case 2: {
                f = Math.abs(f);
                return 1.0f - f;
            }
            case 1: 
        }
        return Math.signum(f * VAL_2PI);
    }

    public float get(float f, long l, View view, KeyCache keyCache) {
        float f2;
        this.mCurveFit.getPos((double)f, this.mCache);
        float[] fArray = this.mCache;
        boolean bl = true;
        f = fArray[1];
        if (f == 0.0f) {
            this.mContinue = false;
            return fArray[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            this.last_cycle = f2 = keyCache.getFloatValue((Object)view, this.mType, 0);
            if (Float.isNaN(f2)) {
                this.last_cycle = 0.0f;
            }
        }
        long l2 = this.last_time;
        double d = this.last_cycle;
        double d2 = l - l2;
        Double.isNaN(d2);
        double d3 = f;
        Double.isNaN(d3);
        Double.isNaN(d);
        this.last_cycle = f2 = (float)((d + d2 * 1.0E-9 * d3) % 1.0);
        keyCache.setFloatValue((Object)view, this.mType, 0, f2);
        this.last_time = l;
        float f3 = this.mCache[0];
        f2 = this.calcWave(this.last_cycle);
        float f4 = this.mCache[2];
        boolean bl2 = bl;
        if (f3 == 0.0f) {
            bl2 = f != 0.0f ? bl : false;
        }
        this.mContinue = bl2;
        return f2 * f3 + f4;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public void setPoint(int n, float f, float f2, int n2, float f3) {
        Object object = this.mTimePoints;
        int n3 = this.count++;
        object[n3] = n;
        object = this.mValues;
        object[n3][0] = f;
        object[n3][1] = f2;
        object[n3][2] = f3;
        this.mWaveShape = Math.max(this.mWaveShape, n2);
    }

    public abstract boolean setProperty(View var1, float var2, long var3, KeyCache var5);

    protected void setStartTime(long l) {
        this.last_time = l;
    }

    public void setType(String string) {
        this.mType = string;
    }

    public void setup(int n) {
        int n2;
        Object object;
        int n3 = this.count;
        if (n3 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error no points added to ");
            stringBuilder.append(this.mType);
            Log.e((String)"SplineSet", (String)stringBuilder.toString());
            return;
        }
        Sort.doubleQuickSort((int[])this.mTimePoints, (float[][])this.mValues, (int)0, (int)(n3 - 1));
        n3 = 0;
        for (int i = 1; i < ((int[])(object = this.mTimePoints)).length; ++i) {
            n2 = n3;
            if (object[i] != object[i - 1]) {
                n2 = n3 + 1;
            }
            n3 = n2;
        }
        n2 = n3;
        if (n3 == 0) {
            n2 = 1;
        }
        double[] dArray = new double[n2];
        object = new double[n2][3];
        n3 = 0;
        n2 = 0;
        while (true) {
            Object object2;
            if (n3 >= this.count) {
                this.mCurveFit = CurveFit.get((int)n, (double[])dArray, (double[][])object);
                return;
            }
            if (n3 <= 0 || (object2 = this.mTimePoints)[n3] != object2[n3 - 1]) {
                double d = this.mTimePoints[n3];
                Double.isNaN(d);
                dArray[n2] = d * 0.01;
                int n4 = object[n2];
                object2 = this.mValues;
                n4[0] = (double)object2[n3][0];
                object[n2][1] = (double)object2[n3][1];
                object[n2][2] = (double)object2[n3][2];
                ++n2;
            }
            ++n3;
        }
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        int n = 0;
        while (n < this.count) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("[");
            stringBuilder.append(this.mTimePoints[n]);
            stringBuilder.append(" , ");
            stringBuilder.append(decimalFormat.format(this.mValues[n]));
            stringBuilder.append("] ");
            string = stringBuilder.toString();
            ++n;
        }
        return string;
    }
}
