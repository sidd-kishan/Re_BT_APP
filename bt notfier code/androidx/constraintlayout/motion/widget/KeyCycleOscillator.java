/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.constraintlayout.motion.utils.CurveFit
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$AlphaSet
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$CustomSet
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$CycleOscillator
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$ElevationSet
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$PathRotateSet
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$ProgressSet
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$RotationSet
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$RotationXset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$RotationYset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$ScaleXset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$ScaleYset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$TranslationXset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$TranslationYset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$TranslationZset
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator$WavePoint
 *  androidx.constraintlayout.widget.ConstraintAttribute
 */
package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public abstract class KeyCycleOscillator {
    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy = 0;
    ArrayList<WavePoint> mWavePoints = new ArrayList();
    private int mWaveShape = 0;

    static KeyCycleOscillator makeSpline(String string) {
        if (string.startsWith("CUSTOM")) {
            return new CustomSet();
        }
        int n = -1;
        switch (string.hashCode()) {
            default: {
                break;
            }
            case 156108012: {
                if (!string.equals("waveOffset")) break;
                n = 8;
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
            case -797520672: {
                if (!string.equals("waveVariesBy")) break;
                n = 9;
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
                n = 13;
                break;
            }
            case -1225497655: {
                if (!string.equals("translationZ")) break;
                n = 12;
                break;
            }
            case -1225497656: {
                if (!string.equals("translationY")) break;
                n = 11;
                break;
            }
            case -1225497657: {
                if (!string.equals("translationX")) break;
                n = 10;
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
                return null;
            }
            case 13: {
                return new ProgressSet();
            }
            case 12: {
                return new TranslationZset();
            }
            case 11: {
                return new TranslationYset();
            }
            case 10: {
                return new TranslationXset();
            }
            case 9: {
                return new AlphaSet();
            }
            case 8: {
                return new AlphaSet();
            }
            case 7: {
                return new ScaleYset();
            }
            case 6: {
                return new ScaleXset();
            }
            case 5: {
                return new PathRotateSet();
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
        return (float)this.mCycleOscillator.getValues(f);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float f) {
        return (float)this.mCycleOscillator.getSlope(f);
    }

    public void setPoint(int n, int n2, int n3, float f, float f2, float f3) {
        this.mWavePoints.add(new WavePoint(n, f, f2, f3));
        if (n3 != -1) {
            this.mVariesBy = n3;
        }
        this.mWaveShape = n2;
    }

    public void setPoint(int n, int n2, int n3, float f, float f2, float f3, ConstraintAttribute constraintAttribute) {
        this.mWavePoints.add(new WavePoint(n, f, f2, f3));
        if (n3 != -1) {
            this.mVariesBy = n3;
        }
        this.mWaveShape = n2;
        this.mCustom = constraintAttribute;
    }

    public abstract void setProperty(View var1, float var2);

    public void setType(String string) {
        this.mType = string;
    }

    public void setup(float f) {
        int n = this.mWavePoints.size();
        if (n == 0) {
            return;
        }
        Collections.sort(this.mWavePoints, new /* Unavailable Anonymous Inner Class!! */);
        double[] dArray = new double[n];
        double[][] dArray2 = new double[n][2];
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, n);
        Iterator<WavePoint> iterator = this.mWavePoints.iterator();
        n = 0;
        while (true) {
            if (!iterator.hasNext()) {
                this.mCycleOscillator.setup(f);
                this.mCurveFit = CurveFit.get((int)0, (double[])dArray, (double[][])dArray2);
                return;
            }
            WavePoint wavePoint = iterator.next();
            double d = wavePoint.mPeriod;
            Double.isNaN(d);
            dArray[n] = d * 0.01;
            dArray2[n][0] = wavePoint.mValue;
            dArray2[n][1] = wavePoint.mOffset;
            this.mCycleOscillator.setPoint(n, wavePoint.mPosition, wavePoint.mPeriod, wavePoint.mOffset, wavePoint.mValue);
            ++n;
        }
    }

    public String toString() {
        String string = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        Iterator<WavePoint> iterator = this.mWavePoints.iterator();
        while (iterator.hasNext()) {
            WavePoint wavePoint = iterator.next();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("[");
            stringBuilder.append(wavePoint.mPosition);
            stringBuilder.append(" , ");
            stringBuilder.append(decimalFormat.format(wavePoint.mValue));
            stringBuilder.append("] ");
            string = stringBuilder.toString();
        }
        return string;
    }

    public boolean variesByPath() {
        int n = this.mVariesBy;
        boolean bl = true;
        if (n == 1) return bl;
        bl = false;
        return bl;
    }
}
