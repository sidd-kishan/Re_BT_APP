/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.utils.Oscillator
 *  androidx.constraintlayout.widget.ConstraintAttribute
 *  androidx.constraintlayout.widget.ConstraintAttribute$AttributeType
 */
package androidx.constraintlayout.motion.widget;

import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.util.HashMap;

static class KeyCycleOscillator.CycleOscillator {
    private static final String TAG = "CycleOscillator";
    static final int UNSET = -1;
    CurveFit mCurveFit;
    public HashMap<String, ConstraintAttribute> mCustomConstraints;
    float[] mOffset;
    Oscillator mOscillator = new Oscillator();
    float mPathLength;
    float[] mPeriod;
    double[] mPosition;
    float[] mScale;
    double[] mSplineSlopeCache;
    double[] mSplineValueCache;
    float[] mValues;
    private final int mVariesBy;
    int mWaveShape;

    KeyCycleOscillator.CycleOscillator(int n, int n2, int n3) {
        this.mCustomConstraints = new HashMap();
        this.mWaveShape = n;
        this.mVariesBy = n2;
        this.mOscillator.setType(n);
        this.mValues = new float[n3];
        this.mPosition = new double[n3];
        this.mPeriod = new float[n3];
        this.mOffset = new float[n3];
        this.mScale = new float[n3];
    }

    private ConstraintAttribute get(String string, ConstraintAttribute.AttributeType object) {
        if (this.mCustomConstraints.containsKey(string)) {
            if ((string = this.mCustomConstraints.get(string)).getType() == object) return string;
            object = new StringBuilder();
            ((StringBuilder)object).append("ConstraintAttribute is already a ");
            ((StringBuilder)object).append(string.getType().name());
            throw new IllegalArgumentException(((StringBuilder)object).toString());
        }
        object = new ConstraintAttribute(string, (ConstraintAttribute.AttributeType)object);
        this.mCustomConstraints.put(string, (ConstraintAttribute)object);
        string = object;
        return string;
    }

    public double getSlope(float f) {
        double d;
        Object object = this.mCurveFit;
        if (object != null) {
            d = f;
            object.getSlope(d, this.mSplineSlopeCache);
            this.mCurveFit.getPos(d, this.mSplineValueCache);
        } else {
            object = this.mSplineSlopeCache;
            object[0] = (CurveFit)0.0;
            object[1] = (CurveFit)0.0;
        }
        object = this.mOscillator;
        double d2 = f;
        d = object.getValue(d2);
        d2 = this.mOscillator.getSlope(d2);
        object = this.mSplineSlopeCache;
        return (double)(object[0] + d * object[1] + d2 * this.mSplineValueCache[1]);
    }

    public double getValues(float f) {
        Object object = this.mCurveFit;
        if (object != null) {
            object.getPos((double)f, this.mSplineValueCache);
        } else {
            object = this.mSplineValueCache;
            object[0] = (CurveFit)((double)this.mOffset[0]);
            object[1] = (CurveFit)((double)this.mValues[0]);
        }
        return this.mSplineValueCache[0] + this.mOscillator.getValue((double)f) * this.mSplineValueCache[1];
    }

    public void setPoint(int n, int n2, float f, float f2, float f3) {
        double[] dArray = this.mPosition;
        double d = n2;
        Double.isNaN(d);
        dArray[n] = d / 100.0;
        this.mPeriod[n] = f;
        this.mOffset[n] = f2;
        this.mValues[n] = f3;
    }

    public void setup(float f) {
        int n;
        this.mPathLength = f;
        double[][] dArray = new double[this.mPosition.length][2];
        Object[] objectArray = this.mValues;
        this.mSplineValueCache = new double[objectArray.length + 1];
        this.mSplineSlopeCache = new double[objectArray.length + 1];
        if (this.mPosition[0] > 0.0) {
            this.mOscillator.addPoint(0.0, this.mPeriod[0]);
        }
        if ((objectArray = (Object[])this.mPosition)[n = objectArray.length - 1] < 1.0) {
            this.mOscillator.addPoint(1.0, this.mPeriod[n]);
        }
        for (n = 0; n < dArray.length; ++n) {
            dArray[n][0] = this.mOffset[n];
            for (int i = 0; i < (objectArray = this.mValues).length; ++i) {
                dArray[i][1] = objectArray[i];
            }
            this.mOscillator.addPoint(this.mPosition[n], this.mPeriod[n]);
        }
        this.mOscillator.normalize();
        objectArray = this.mPosition;
        this.mCurveFit = objectArray.length > 1 ? CurveFit.get((int)0, (double[])objectArray, (double[][])dArray) : null;
    }
}
