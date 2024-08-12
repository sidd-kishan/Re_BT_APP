/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.View
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.widget.SplineSet$AlphaSet
 *  androidx.constraintlayout.motion.widget.SplineSet$CustomSet
 *  androidx.constraintlayout.motion.widget.SplineSet$ElevationSet
 *  androidx.constraintlayout.motion.widget.SplineSet$PathRotate
 *  androidx.constraintlayout.motion.widget.SplineSet$PivotXset
 *  androidx.constraintlayout.motion.widget.SplineSet$PivotYset
 *  androidx.constraintlayout.motion.widget.SplineSet$ProgressSet
 *  androidx.constraintlayout.motion.widget.SplineSet$RotationSet
 *  androidx.constraintlayout.motion.widget.SplineSet$RotationXset
 *  androidx.constraintlayout.motion.widget.SplineSet$RotationYset
 *  androidx.constraintlayout.motion.widget.SplineSet$ScaleXset
 *  androidx.constraintlayout.motion.widget.SplineSet$ScaleYset
 *  androidx.constraintlayout.motion.widget.SplineSet$Sort
 *  androidx.constraintlayout.motion.widget.SplineSet$TranslationXset
 *  androidx.constraintlayout.motion.widget.SplineSet$TranslationYset
 *  androidx.constraintlayout.motion.widget.SplineSet$TranslationZset
 *  androidx.constraintlayout.widget.ConstraintAttribute
 */
package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.text.DecimalFormat;
import java.util.Arrays;

/*
 * Exception performing whole class analysis ignored.
 */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints = new int[10];
    private String mType;
    protected float[] mValues = new float[10];

    static SplineSet makeCustomSpline(String string, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(string, sparseArray);
    }

    static SplineSet makeSpline(String string) {
        int n;
        block36: {
            switch (string.hashCode()) {
                default: {
                    break;
                }
                case 156108012: {
                    if (!string.equals("waveOffset")) break;
                    n = 10;
                    break block36;
                }
                case 92909918: {
                    if (!string.equals("alpha")) break;
                    n = 0;
                    break block36;
                }
                case 37232917: {
                    if (!string.equals("transitionPathRotate")) break;
                    n = 7;
                    break block36;
                }
                case -4379043: {
                    if (!string.equals("elevation")) break;
                    n = 1;
                    break block36;
                }
                case -40300674: {
                    if (!string.equals("rotation")) break;
                    n = 2;
                    break block36;
                }
                case -760884509: {
                    if (!string.equals("transformPivotY")) break;
                    n = 6;
                    break block36;
                }
                case -760884510: {
                    if (!string.equals("transformPivotX")) break;
                    n = 5;
                    break block36;
                }
                case -797520672: {
                    if (!string.equals("waveVariesBy")) break;
                    n = 11;
                    break block36;
                }
                case -908189617: {
                    if (!string.equals("scaleY")) break;
                    n = 9;
                    break block36;
                }
                case -908189618: {
                    if (!string.equals("scaleX")) break;
                    n = 8;
                    break block36;
                }
                case -1001078227: {
                    if (!string.equals("progress")) break;
                    n = 15;
                    break block36;
                }
                case -1225497655: {
                    if (!string.equals("translationZ")) break;
                    n = 14;
                    break block36;
                }
                case -1225497656: {
                    if (!string.equals("translationY")) break;
                    n = 13;
                    break block36;
                }
                case -1225497657: {
                    if (!string.equals("translationX")) break;
                    n = 12;
                    break block36;
                }
                case -1249320805: {
                    if (!string.equals("rotationY")) break;
                    n = 4;
                    break block36;
                }
                case -1249320806: {
                    if (!string.equals("rotationX")) break;
                    n = 3;
                    break block36;
                }
            }
            n = -1;
        }
        switch (n) {
            default: {
                return null;
            }
            case 15: {
                return new ProgressSet();
            }
            case 14: {
                return new TranslationZset();
            }
            case 13: {
                return new TranslationYset();
            }
            case 12: {
                return new TranslationXset();
            }
            case 11: {
                return new AlphaSet();
            }
            case 10: {
                return new AlphaSet();
            }
            case 9: {
                return new ScaleYset();
            }
            case 8: {
                return new ScaleXset();
            }
            case 7: {
                return new PathRotate();
            }
            case 6: {
                return new PivotYset();
            }
            case 5: {
                return new PivotXset();
            }
            case 4: {
                return new RotationYset();
            }
            case 3: {
                return new RotationXset();
            }
            case 2: {
                return new RotationSet();
            }
            case 1: {
                return new ElevationSet();
            }
            case 0: 
        }
        return new AlphaSet();
    }

    public float get(float f) {
        return (float)this.mCurveFit.getPos((double)f, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float)this.mCurveFit.getSlope((double)f, 0);
    }

    public void setPoint(int n, float f) {
        Object[] objectArray = this.mTimePoints;
        if (objectArray.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(objectArray, objectArray.length * 2);
            objectArray = this.mValues;
            this.mValues = Arrays.copyOf((float[])objectArray, objectArray.length * 2);
        }
        objectArray = this.mTimePoints;
        int n2 = this.count;
        objectArray[n2] = n;
        this.mValues[n2] = f;
        this.count = n2 + 1;
    }

    public abstract void setProperty(View var1, float var2);

    public void setType(String string) {
        this.mType = string;
    }

    public void setup(int n) {
        int[] nArray;
        int n2;
        int n3 = this.count;
        if (n3 == 0) {
            return;
        }
        Sort.doubleQuickSort((int[])this.mTimePoints, (float[])this.mValues, (int)0, (int)(n3 - 1));
        int n4 = 1;
        for (n2 = 1; n2 < this.count; ++n2) {
            nArray = this.mTimePoints;
            n3 = n4;
            if (nArray[n2 - 1] != nArray[n2]) {
                n3 = n4 + 1;
            }
            n4 = n3;
        }
        double[] dArray = new double[n4];
        double[][] dArray2 = new double[n4][1];
        n3 = 0;
        n2 = 0;
        while (true) {
            if (n3 >= this.count) {
                this.mCurveFit = CurveFit.get((int)n, (double[])dArray, (double[][])dArray2);
                return;
            }
            if (n3 <= 0 || (nArray = this.mTimePoints)[n3] != nArray[n3 - 1]) {
                double d = this.mTimePoints[n3];
                Double.isNaN(d);
                dArray[n2] = d * 0.01;
                dArray2[n2][0] = this.mValues[n3];
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
