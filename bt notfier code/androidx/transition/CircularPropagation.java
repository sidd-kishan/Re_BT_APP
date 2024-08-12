/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewGroup
 *  androidx.transition.Transition
 *  androidx.transition.TransitionValues
 *  androidx.transition.VisibilityPropagation
 */
package androidx.transition;

import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.VisibilityPropagation;

public class CircularPropagation
extends VisibilityPropagation {
    private float mPropagationSpeed = 3.0f;

    private static float distance(float f, float f2, float f3, float f4) {
        f = f3 - f;
        f2 = f4 - f2;
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    public long getStartDelay(ViewGroup viewGroup, Transition transition, TransitionValues object, TransitionValues transitionValues) {
        long l;
        int n;
        int n2;
        int n3;
        if (object == null && transitionValues == null) {
            return 0L;
        }
        if (transitionValues != null && this.getViewVisibility((TransitionValues)object) != 0) {
            n3 = 1;
            object = transitionValues;
        } else {
            n3 = -1;
        }
        int n4 = this.getViewX((TransitionValues)object);
        int n5 = this.getViewY((TransitionValues)object);
        object = transition.getEpicenter();
        if (object != null) {
            n2 = object.centerX();
            n = object.centerY();
        } else {
            object = new int[2];
            viewGroup.getLocationOnScreen((int[])object);
            n2 = Math.round((float)(object[0] + viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            n = Math.round((float)(object[1] + viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
        }
        float f = CircularPropagation.distance(n4, n5, n2, n) / CircularPropagation.distance(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long l2 = l = transition.getDuration();
        if (l >= 0L) return Math.round((float)(l2 * (long)n3) / this.mPropagationSpeed * f);
        l2 = 300L;
        return Math.round((float)(l2 * (long)n3) / this.mPropagationSpeed * f);
    }

    public void setPropagationSpeed(float f) {
        if (f == 0.0f) throw new IllegalArgumentException("propagationSpeed may not be 0");
        this.mPropagationSpeed = f;
    }
}
