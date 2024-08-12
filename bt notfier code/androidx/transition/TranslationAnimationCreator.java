/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ObjectAnimator
 *  android.animation.PropertyValuesHolder
 *  android.animation.TimeInterpolator
 *  android.util.Property
 *  android.view.View
 *  androidx.transition.AnimatorUtils
 *  androidx.transition.R$id
 *  androidx.transition.Transition
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionValues
 *  androidx.transition.TranslationAnimationCreator$TransitionPositionListener
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.util.Property;
import android.view.View;
import androidx.transition.AnimatorUtils;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator;

class TranslationAnimationCreator {
    private TranslationAnimationCreator() {
    }

    static Animator createAnimation(View view, TransitionValues transitionValues, int n, int n2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator, Transition transition) {
        float f5 = view.getTranslationX();
        float f6 = view.getTranslationY();
        Object object = (int[])transitionValues.view.getTag(R.id.transition_position);
        if (object != null) {
            f = (float)(object[0] - n) + f5;
            f2 = (float)(object[1] - n2) + f6;
        }
        int n3 = Math.round(f - f5);
        int n4 = Math.round(f2 - f6);
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        object = ObjectAnimator.ofPropertyValuesHolder((Object)view, (PropertyValuesHolder[])new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat((Property)View.TRANSLATION_X, (float[])new float[]{f, f3}), PropertyValuesHolder.ofFloat((Property)View.TRANSLATION_Y, (float[])new float[]{f2, f4})});
        view = new TransitionPositionListener(view, transitionValues.view, n + n3, n2 + n4, f5, f6);
        transition.addListener((Transition.TransitionListener)view);
        object.addListener((Animator.AnimatorListener)view);
        AnimatorUtils.addPauseListener((Animator)object, (AnimatorListenerAdapter)view);
        object.setInterpolator(timeInterpolator);
        return object;
    }
}
