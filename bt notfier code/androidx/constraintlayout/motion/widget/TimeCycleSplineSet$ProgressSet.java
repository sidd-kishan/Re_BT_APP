/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCache
 *  androidx.constraintlayout.motion.widget.MotionLayout
 *  androidx.constraintlayout.motion.widget.TimeCycleSplineSet
 */
package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCache;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.TimeCycleSplineSet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

static class TimeCycleSplineSet.ProgressSet
extends TimeCycleSplineSet {
    boolean mNoMethod = false;

    TimeCycleSplineSet.ProgressSet() {
    }

    public boolean setProperty(View view, float f, long l, KeyCache keyCache) {
        if (view instanceof MotionLayout) {
            ((MotionLayout)view).setProgress(this.get(f, l, view, keyCache));
        } else {
            if (this.mNoMethod) {
                return false;
            }
            Method method = null;
            try {
                Method method2;
                method = method2 = view.getClass().getMethod("setProgress", Float.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.mNoMethod = true;
            }
            if (method == null) return this.mContinue;
            try {
                method.invoke(view, Float.valueOf(this.get(f, l, view, keyCache)));
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.e((String)"SplineSet", (String)"unable to setProgress", (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)"SplineSet", (String)"unable to setProgress", (Throwable)illegalAccessException);
            }
        }
        return this.mContinue;
    }
}
