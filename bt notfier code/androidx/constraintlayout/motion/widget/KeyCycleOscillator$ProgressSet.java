/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  androidx.constraintlayout.motion.widget.KeyCycleOscillator
 *  androidx.constraintlayout.motion.widget.MotionLayout
 */
package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

static class KeyCycleOscillator.ProgressSet
extends KeyCycleOscillator {
    boolean mNoMethod = false;

    KeyCycleOscillator.ProgressSet() {
    }

    public void setProperty(View view, float f) {
        if (view instanceof MotionLayout) {
            ((MotionLayout)view).setProgress(this.get(f));
        } else {
            if (this.mNoMethod) {
                return;
            }
            Method method = null;
            try {
                Method method2;
                method = method2 = view.getClass().getMethod("setProgress", Float.TYPE);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                this.mNoMethod = true;
            }
            if (method == null) return;
            try {
                method.invoke(view, Float.valueOf(this.get(f)));
            }
            catch (InvocationTargetException invocationTargetException) {
                Log.e((String)"KeyCycleOscillator", (String)"unable to setProgress", (Throwable)invocationTargetException);
            }
            catch (IllegalAccessException illegalAccessException) {
                Log.e((String)"KeyCycleOscillator", (String)"unable to setProgress", (Throwable)illegalAccessException);
            }
        }
    }
}
