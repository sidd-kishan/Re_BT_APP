/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.SparseArray
 *  android.view.View
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.widget.SplineSet
 *  androidx.constraintlayout.widget.ConstraintAttribute
 */
package androidx.constraintlayout.motion.widget;

import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.SplineSet;
import androidx.constraintlayout.widget.ConstraintAttribute;

static class SplineSet.CustomSet
extends SplineSet {
    String mAttributeName;
    SparseArray<ConstraintAttribute> mConstraintAttributeList;
    float[] mTempValues;

    public SplineSet.CustomSet(String string, SparseArray<ConstraintAttribute> sparseArray) {
        this.mAttributeName = string.split(",")[1];
        this.mConstraintAttributeList = sparseArray;
    }

    public void setPoint(int n, float f) {
        throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
    }

    public void setPoint(int n, ConstraintAttribute constraintAttribute) {
        this.mConstraintAttributeList.append(n, (Object)constraintAttribute);
    }

    public void setProperty(View view, float f) {
        this.mCurveFit.getPos((double)f, this.mTempValues);
        ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).setInterpolatedValue(view, this.mTempValues);
    }

    public void setup(int n) {
        int n2 = this.mConstraintAttributeList.size();
        int n3 = ((ConstraintAttribute)this.mConstraintAttributeList.valueAt(0)).noOfInterpValues();
        double[] dArray = new double[n2];
        this.mTempValues = new float[n3];
        double[][] dArray2 = new double[n2][n3];
        n3 = 0;
        while (true) {
            if (n3 >= n2) {
                this.mCurveFit = CurveFit.get((int)n, (double[])dArray, (double[][])dArray2);
                return;
            }
            int n4 = this.mConstraintAttributeList.keyAt(n3);
            Object object = (ConstraintAttribute)this.mConstraintAttributeList.valueAt(n3);
            double d = n4;
            Double.isNaN(d);
            dArray[n3] = d * 0.01;
            object.getValuesToInterpolate(this.mTempValues);
            for (n4 = 0; n4 < ((ConstraintAttribute)(object = (Object)this.mTempValues)).length; ++n4) {
                dArray2[n3][n4] = (double)object[n4];
            }
            ++n3;
        }
    }
}
