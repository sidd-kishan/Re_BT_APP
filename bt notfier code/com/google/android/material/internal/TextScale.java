/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.transition.Transition
 *  androidx.transition.TransitionValues
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;

public class TextScale
extends Transition {
    private static final String PROPNAME_SCALE = "android:textscale:scale";

    private void captureValues(TransitionValues transitionValues) {
        if (!(transitionValues.view instanceof TextView)) return;
        TextView textView = (TextView)transitionValues.view;
        transitionValues.values.put(PROPNAME_SCALE, Float.valueOf(textView.getScaleX()));
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup object, TransitionValues object2, TransitionValues object3) {
        TextView textView = null;
        object = textView;
        if (object2 == null) return object;
        object = textView;
        if (object3 == null) return object;
        object = textView;
        if (!(((TransitionValues)object2).view instanceof TextView)) return object;
        if (!(object3.view instanceof TextView)) {
            object = textView;
        } else {
            textView = (TextView)object3.view;
            object = ((TransitionValues)object2).values;
            object2 = object3.values;
            object3 = object.get(PROPNAME_SCALE);
            float f = 1.0f;
            float f2 = object3 != null ? ((Float)object.get(PROPNAME_SCALE)).floatValue() : 1.0f;
            if (object2.get(PROPNAME_SCALE) != null) {
                f = ((Float)object2.get(PROPNAME_SCALE)).floatValue();
            }
            if (f2 == f) {
                return null;
            }
            object = ValueAnimator.ofFloat((float[])new float[]{f2, f});
            object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        }
        return object;
    }
}
