/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorInflater
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Log
 *  androidx.collection.SimpleArrayMap
 *  com.google.android.material.animation.MotionTiming
 */
package com.google.android.material.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import androidx.collection.SimpleArrayMap;
import com.google.android.material.animation.MotionTiming;
import java.util.ArrayList;
import java.util.List;

public class MotionSpec {
    private static final String TAG = "MotionSpec";
    private final SimpleArrayMap<String, MotionTiming> timings = new SimpleArrayMap();

    private static void addTimingFromAnimator(MotionSpec object, Animator animator) {
        if (animator instanceof ObjectAnimator) {
            animator = (ObjectAnimator)animator;
            ((MotionSpec)object).setTiming(animator.getPropertyName(), MotionTiming.createFromAnimator((ValueAnimator)animator));
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Animator must be an ObjectAnimator: ");
        ((StringBuilder)object).append(animator);
        throw new IllegalArgumentException(((StringBuilder)object).toString());
    }

    public static MotionSpec createFromAttribute(Context context, TypedArray typedArray, int n) {
        if (!typedArray.hasValue(n)) return null;
        if ((n = typedArray.getResourceId(n, 0)) == 0) return null;
        return MotionSpec.createFromResource(context, n);
    }

    public static MotionSpec createFromResource(Context object, int n) {
        try {
            Animator animator = AnimatorInflater.loadAnimator((Context)object, (int)n);
            if (animator instanceof AnimatorSet) {
                return MotionSpec.createSpecFromAnimators(((AnimatorSet)animator).getChildAnimations());
            }
            if (animator == null) return null;
            object = new ArrayList();
            object.add(animator);
            object = MotionSpec.createSpecFromAnimators((List<Animator>)object);
            return object;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Can't load animation resource ID #0x");
            ((StringBuilder)object).append(Integer.toHexString(n));
            Log.w((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)exception);
            return null;
        }
    }

    private static MotionSpec createSpecFromAnimators(List<Animator> list) {
        MotionSpec motionSpec = new MotionSpec();
        int n = list.size();
        int n2 = 0;
        while (n2 < n) {
            MotionSpec.addTimingFromAnimator(motionSpec, list.get(n2));
            ++n2;
        }
        return motionSpec;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) return false;
        if (this.getClass() != object.getClass()) {
            return false;
        }
        object = (MotionSpec)object;
        return this.timings.equals(((MotionSpec)object).timings);
    }

    public MotionTiming getTiming(String string) {
        if (!this.hasTiming(string)) throw new IllegalArgumentException();
        return (MotionTiming)this.timings.get((Object)string);
    }

    public long getTotalDuration() {
        int n = this.timings.size();
        long l = 0L;
        int n2 = 0;
        while (n2 < n) {
            MotionTiming motionTiming = (MotionTiming)this.timings.valueAt(n2);
            l = Math.max(l, motionTiming.getDelay() + motionTiming.getDuration());
            ++n2;
        }
        return l;
    }

    public boolean hasTiming(String string) {
        boolean bl = this.timings.get((Object)string) != null;
        return bl;
    }

    public int hashCode() {
        return this.timings.hashCode();
    }

    public void setTiming(String string, MotionTiming motionTiming) {
        this.timings.put((Object)string, (Object)motionTiming);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('\n');
        stringBuilder.append(this.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" timings: ");
        stringBuilder.append(this.timings);
        stringBuilder.append("}\n");
        return stringBuilder.toString();
    }
}
