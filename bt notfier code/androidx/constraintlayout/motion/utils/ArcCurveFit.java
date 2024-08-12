/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.constraintlayout.motion.utils.ArcCurveFit$Arc
 *  androidx.constraintlayout.motion.utils.CurveFit
 */
package androidx.constraintlayout.motion.utils;

import androidx.constraintlayout.motion.utils.ArcCurveFit;
import androidx.constraintlayout.motion.utils.CurveFit;

class ArcCurveFit
extends CurveFit {
    public static final int ARC_START_FLIP = 3;
    public static final int ARC_START_HORIZONTAL = 2;
    public static final int ARC_START_LINEAR = 0;
    public static final int ARC_START_VERTICAL = 1;
    private static final int START_HORIZONTAL = 2;
    private static final int START_LINEAR = 3;
    private static final int START_VERTICAL = 1;
    Arc[] mArcs;
    private final double[] mTime;

    public ArcCurveFit(int[] nArray, double[] dArray, double[][] dArray2) {
        this.mTime = dArray;
        this.mArcs = new Arc[dArray.length - 1];
        int n = 0;
        int n2 = 1;
        int n3 = 1;
        while (n < this.mArcs.length) {
            int n4 = nArray[n];
            if (n4 != 0) {
                if (n4 != 1) {
                    if (n4 != 2) {
                        if (n4 == 3) {
                            n2 = n2 == 1 ? 2 : 1;
                            n3 = n2;
                        }
                    } else {
                        n2 = 2;
                        n3 = 2;
                    }
                } else {
                    n2 = 1;
                    n3 = 1;
                }
            } else {
                n3 = 3;
            }
            Arc[] arcArray = this.mArcs;
            double d = dArray[n];
            n4 = n + 1;
            arcArray[n] = new Arc(n3, d, dArray[n4], dArray2[n][0], dArray2[n][1], dArray2[n4][0], dArray2[n4][1]);
            n = n4;
        }
    }

    public double getPos(double d, int n) {
        int n2;
        double d2;
        block6: {
            Arc[] arcArray = this.mArcs;
            int n3 = 0;
            if (d < arcArray[0].mTime1) {
                d2 = this.mArcs[0].mTime1;
                n2 = n3;
            } else {
                arcArray = this.mArcs;
                n2 = n3;
                d2 = d;
                if (d > arcArray[arcArray.length - 1].mTime2) {
                    arcArray = this.mArcs;
                    d2 = arcArray[arcArray.length - 1].mTime2;
                    n2 = n3;
                }
            }
            while (n2 < (arcArray = this.mArcs).length) {
                if (d2 <= arcArray[n2].mTime2) {
                    if (this.mArcs[n2].linear) {
                        if (n != 0) return this.mArcs[n2].getLinearY(d2);
                        return this.mArcs[n2].getLinearX(d2);
                    }
                    break block6;
                }
                ++n2;
            }
            return Double.NaN;
        }
        this.mArcs[n2].setPoint(d2);
        if (n != 0) return this.mArcs[n2].getY();
        return this.mArcs[n2].getX();
    }

    public void getPos(double d, double[] dArray) {
        int n;
        block5: {
            double d2 = d;
            if (d < this.mArcs[0].mTime1) {
                d2 = this.mArcs[0].mTime1;
            }
            Arc[] arcArray = this.mArcs;
            d = d2;
            if (d2 > arcArray[arcArray.length - 1].mTime2) {
                arcArray = this.mArcs;
                d = arcArray[arcArray.length - 1].mTime2;
            }
            n = 0;
            while (n < (arcArray = this.mArcs).length) {
                if (d <= arcArray[n].mTime2) {
                    if (this.mArcs[n].linear) {
                        dArray[0] = this.mArcs[n].getLinearX(d);
                        dArray[1] = this.mArcs[n].getLinearY(d);
                        return;
                    }
                    break block5;
                }
                ++n;
            }
            return;
        }
        this.mArcs[n].setPoint(d);
        dArray[0] = this.mArcs[n].getX();
        dArray[1] = this.mArcs[n].getY();
    }

    public void getPos(double d, float[] fArray) {
        int n;
        double d2;
        block6: {
            Arc[] arcArray;
            if (d < this.mArcs[0].mTime1) {
                d2 = this.mArcs[0].mTime1;
            } else {
                arcArray = this.mArcs;
                d2 = d;
                if (d > arcArray[arcArray.length - 1].mTime2) {
                    arcArray = this.mArcs;
                    d2 = arcArray[arcArray.length - 1].mTime2;
                }
            }
            n = 0;
            while (n < (arcArray = this.mArcs).length) {
                if (d2 <= arcArray[n].mTime2) {
                    if (this.mArcs[n].linear) {
                        fArray[0] = (float)this.mArcs[n].getLinearX(d2);
                        fArray[1] = (float)this.mArcs[n].getLinearY(d2);
                        return;
                    }
                    break block6;
                }
                ++n;
            }
            return;
        }
        this.mArcs[n].setPoint(d2);
        fArray[0] = (float)this.mArcs[n].getX();
        fArray[1] = (float)this.mArcs[n].getY();
    }

    public double getSlope(double d, int n) {
        int n2;
        block5: {
            Arc[] arcArray = this.mArcs;
            int n3 = 0;
            double d2 = d;
            if (d < arcArray[0].mTime1) {
                d2 = this.mArcs[0].mTime1;
            }
            arcArray = this.mArcs;
            n2 = n3;
            d = d2;
            if (d2 > arcArray[arcArray.length - 1].mTime2) {
                arcArray = this.mArcs;
                d = arcArray[arcArray.length - 1].mTime2;
                n2 = n3;
            }
            while (n2 < (arcArray = this.mArcs).length) {
                if (d <= arcArray[n2].mTime2) {
                    if (this.mArcs[n2].linear) {
                        if (n != 0) return this.mArcs[n2].getLinearDY(d);
                        return this.mArcs[n2].getLinearDX(d);
                    }
                    break block5;
                }
                ++n2;
            }
            return Double.NaN;
        }
        this.mArcs[n2].setPoint(d);
        if (n != 0) return this.mArcs[n2].getDY();
        return this.mArcs[n2].getDX();
    }

    public void getSlope(double d, double[] dArray) {
        int n;
        double d2;
        block6: {
            Arc[] arcArray;
            if (d < this.mArcs[0].mTime1) {
                d2 = this.mArcs[0].mTime1;
            } else {
                arcArray = this.mArcs;
                d2 = d;
                if (d > arcArray[arcArray.length - 1].mTime2) {
                    arcArray = this.mArcs;
                    d2 = arcArray[arcArray.length - 1].mTime2;
                }
            }
            n = 0;
            while (n < (arcArray = this.mArcs).length) {
                if (d2 <= arcArray[n].mTime2) {
                    if (this.mArcs[n].linear) {
                        dArray[0] = this.mArcs[n].getLinearDX(d2);
                        dArray[1] = this.mArcs[n].getLinearDY(d2);
                        return;
                    }
                    break block6;
                }
                ++n;
            }
            return;
        }
        this.mArcs[n].setPoint(d2);
        dArray[0] = this.mArcs[n].getDX();
        dArray[1] = this.mArcs[n].getDY();
    }

    public double[] getTimePoints() {
        return this.mTime;
    }
}
