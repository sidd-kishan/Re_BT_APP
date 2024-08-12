/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  androidx.constraintlayout.motion.utils.Easing$CubicEasing
 */
package androidx.constraintlayout.motion.utils;

import android.util.Log;
import androidx.constraintlayout.motion.utils.Easing;
import java.util.Arrays;

public class Easing {
    private static final String ACCELERATE = "cubic(0.4, 0.05, 0.8, 0.7)";
    private static final String ACCELERATE_NAME = "accelerate";
    private static final String DECELERATE = "cubic(0.0, 0.0, 0.2, 0.95)";
    private static final String DECELERATE_NAME = "decelerate";
    private static final String LINEAR = "cubic(1, 1, 0, 0)";
    private static final String LINEAR_NAME = "linear";
    public static String[] NAMED_EASING;
    private static final String STANDARD = "cubic(0.4, 0.0, 0.2, 1)";
    private static final String STANDARD_NAME = "standard";
    static Easing sDefault;
    String str = "identity";

    static {
        sDefault = new Easing();
        NAMED_EASING = new String[]{STANDARD_NAME, ACCELERATE_NAME, DECELERATE_NAME, LINEAR_NAME};
    }

    public static Easing getInterpolator(String charSequence) {
        if (charSequence == null) {
            return null;
        }
        if (((String)charSequence).startsWith("cubic")) {
            return new CubicEasing((String)charSequence);
        }
        int n = -1;
        switch (((String)charSequence).hashCode()) {
            default: {
                break;
            }
            case 1312628413: {
                if (!((String)charSequence).equals(STANDARD_NAME)) break;
                n = 0;
                break;
            }
            case -1102672091: {
                if (!((String)charSequence).equals(LINEAR_NAME)) break;
                n = 3;
                break;
            }
            case -1263948740: {
                if (!((String)charSequence).equals(DECELERATE_NAME)) break;
                n = 2;
                break;
            }
            case -1354466595: {
                if (!((String)charSequence).equals(ACCELERATE_NAME)) break;
                n = 1;
            }
        }
        if (n == 0) return new CubicEasing(STANDARD);
        if (n == 1) return new CubicEasing(ACCELERATE);
        if (n == 2) return new CubicEasing(DECELERATE);
        if (n == 3) return new CubicEasing(LINEAR);
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("transitionEasing syntax error syntax:transitionEasing=\"cubic(1.0,0.5,0.0,0.6)\" or ");
        ((StringBuilder)charSequence).append(Arrays.toString(NAMED_EASING));
        Log.e((String)"ConstraintSet", (String)((StringBuilder)charSequence).toString());
        return sDefault;
    }

    public double get(double d) {
        return d;
    }

    public double getDiff(double d) {
        return 1.0;
    }

    public String toString() {
        return this.str;
    }
}
