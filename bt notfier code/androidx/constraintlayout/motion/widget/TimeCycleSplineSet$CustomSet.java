/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.View
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 *  androidx.constraintlayout.widget.ConstraintAttribute
 */
package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;

static class TimeCycleSplineSet.CustomSet
extends TimeCycleSplineSet {
    String mAttributeName;
    float[] mCache;
    SparseArray<ConstraintAttribute> mConstraintAttributeList;
    float[] mTempValues;
    SparseArray<float[]> mWaveProperties = new SparseArray();

    public TimeCycleSplineSet.CustomSet(String string, SparseArray<ConstraintAttribute> sparseArray) {
        this.mAttributeName = string.split(",")[1];
        this.mConstraintAttributeList = sparseArray;
    }

    public void setPoint(int n, float f, float f2, int n2, float f3) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
    }

    public void setPoint(int n, ConstraintAttribute constraintAttribute, float f, int n2, float f2) {
        this.mConstraintAttributeList.append(n, (Object)constraintAttribute);
        this.mWaveProperties.append(n, (Object)new float[]{f, f2});
        this.mWaveShape = Math.max(this.mWaveShape, n2);
    }

    public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
        this.mCurveFit.getPos((double)f, this.mTempValues);
        float[] fArray = this.mTempValues;
        float f2 = fArray[fArray.length - 2];
        float f3 = fArray[fArray.length - 1];
        long l2 = this.last_time;
        if (Float.isNaN(this.last_cycle)) {
            this.last_cycle = keyCache.getFloatValue((Object)view, this.mAttributeName, 0);
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = 0.0f;
            }
        }
        double d = this.last_cycle;
        double d2 = l - l2;
        Double.isNaN(d2);
        double d3 = f2;
        Double.isNaN(d3);
        Double.isNaN(d);
        this.last_cycle = (float)((d + d2 * 1.0E-9 * d3) % 1.0);
        this.last_time = l;
        f = this.calcWave(this.last_cycle);
        this.mContinue = false;
        int n = 0;
        while (true) {
            if (n >= this.mCache.length) {
                ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).setInterpolatedValue(view, this.mCache);
                if (f2 == 0.0f) return this.mContinue;
                this.mContinue = true;
                return this.mContinue;
            }
            boolean bl = this.mContinue;
            boolean bl2 = (double)this.mTempValues[n] != 0.0;
            this.mContinue = bl | bl2;
            this.mCache[n] = this.mTempValues[n] * f + f3;
            ++n;
        }
    }

    public void setup(int n) {
        int n2 = this.mConstraintAttributeList.size();
        int n3 = ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).noOfInterpValues();
        double[] dArray = new double[n2];
        int n4 = n3 + 2;
        this.mTempValues = new float[n4];
        this.mCache = new float[n3];
        double[][] dArray2 = new double[n2][n4];
        n4 = 0;
        while (true) {
            if (n4 >= n2) {
                this.mCurveFit = CurveFit.get((int)n, (double[])dArray, (double[][])dArray2);
                return;
            }
            int n5 = this.mConstraintAttributeList.keyAt(n4);
            Object object = (ConstraintAttribute)this.mConstraintAttributeList.valueAt(n4);
            float[] fArray = (float[])this.mWaveProperties.valueAt(n4);
            double d = n5;
            Double.isNaN(d);
            dArray[n4] = d * 0.01;
            object.getValuesToInterpolate(this.mTempValues);
            for (n5 = 0; n5 < ((ConstraintAttribute)(object = (Object)this.mTempValues)).length; ++n5) {
                dArray2[n4][n5] = (double)object[n5];
            }
            dArray2[n4][n3] = fArray[0];
            dArray2[n4][n3 + 1] = fArray[1];
            ++n4;
        }
    }
}
