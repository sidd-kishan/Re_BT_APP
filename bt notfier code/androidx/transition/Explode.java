/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  androidx.transition.CircularPropagation
 *  androidx.transition.R$id
 *  androidx.transition.Transition
 *  androidx.transition.TransitionPropagation
 *  androidx.transition.TransitionValues
 *  androidx.transition.TranslationAnimationCreator
 *  androidx.transition.Visibility
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.transition.CircularPropagation;
import androidx.transition.R;
import androidx.transition.Transition;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator;
import androidx.transition.Visibility;

public class Explode
extends Visibility {
    private static final String PROPNAME_SCREEN_BOUNDS = "android:explode:screenBounds";
    private static final TimeInterpolator sAccelerate;
    private static final TimeInterpolator sDecelerate;
    private int[] mTempLoc = new int[2];

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
    }

    public Explode() {
        this.setPropagation((TransitionPropagation)new CircularPropagation());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setPropagation((TransitionPropagation)new CircularPropagation());
    }

    private static float calculateDistance(float f, float f2) {
        return (float)Math.sqrt(f * f + f2 * f2);
    }

    private static float calculateMaxDistance(View view, int n, int n2) {
        n = Math.max(n, view.getWidth() - n);
        n2 = Math.max(n2, view.getHeight() - n2);
        return Explode.calculateDistance(n, n2);
    }

    private void calculateOut(View view, Rect rect, int[] nArray) {
        int n;
        int n2;
        view.getLocationOnScreen(this.mTempLoc);
        Object object = this.mTempLoc;
        int n3 = object[0];
        int n4 = object[1];
        object = this.getEpicenter();
        if (object == null) {
            n2 = view.getWidth() / 2 + n3 + Math.round(view.getTranslationX());
            n = view.getHeight() / 2 + n4 + Math.round(view.getTranslationY());
        } else {
            n2 = object.centerX();
            n = object.centerY();
        }
        int n5 = rect.centerX();
        int n6 = rect.centerY();
        float f = n5 - n2;
        float f2 = n6 - n;
        float f3 = f;
        float f4 = f2;
        if (f == 0.0f) {
            f3 = f;
            f4 = f2;
            if (f2 == 0.0f) {
                f3 = (float)(Math.random() * 2.0) - 1.0f;
                f4 = (float)(Math.random() * 2.0) - 1.0f;
            }
        }
        f = Explode.calculateDistance(f3, f4);
        f3 /= f;
        f4 /= f;
        f = Explode.calculateMaxDistance(view, n2 - n3, n - n4);
        nArray[0] = Math.round(f3 * f);
        nArray[1] = Math.round(f * f4);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.mTempLoc);
        int[] nArray = this.mTempLoc;
        int n = nArray[0];
        int n2 = nArray[1];
        int n3 = view.getWidth();
        int n4 = view.getHeight();
        transitionValues.values.put(PROPNAME_SCREEN_BOUNDS, new Rect(n, n2, n3 + n, n4 + n2));
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public Animator onAppear(ViewGroup object, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        transitionValues = (Rect)transitionValues2.values.get(PROPNAME_SCREEN_BOUNDS);
        float f = view.getTranslationX();
        float f2 = view.getTranslationY();
        this.calculateOut((View)object, (Rect)transitionValues, this.mTempLoc);
        object = this.mTempLoc;
        float f3 = (float)object[0];
        float f4 = (float)object[1];
        return TranslationAnimationCreator.createAnimation((View)view, (TransitionValues)transitionValues2, (int)transitionValues.left, (int)transitionValues.top, (float)(f + f3), (float)(f2 + f4), (float)f, (float)f2, (TimeInterpolator)sDecelerate, (Transition)this);
    }

    public Animator onDisappear(ViewGroup object, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        transitionValues2 = (Rect)transitionValues.values.get(PROPNAME_SCREEN_BOUNDS);
        int n = transitionValues2.left;
        int n2 = transitionValues2.top;
        float f3 = view.getTranslationX();
        float f4 = view.getTranslationY();
        int[] nArray = (int[])transitionValues.view.getTag(R.id.transition_position);
        if (nArray != null) {
            f2 = (float)(nArray[0] - transitionValues2.left) + f3;
            f = (float)(nArray[1] - transitionValues2.top) + f4;
            transitionValues2.offsetTo(nArray[0], nArray[1]);
        } else {
            f2 = f3;
            f = f4;
        }
        this.calculateOut((View)object, (Rect)transitionValues2, this.mTempLoc);
        object = this.mTempLoc;
        return TranslationAnimationCreator.createAnimation((View)view, (TransitionValues)transitionValues, (int)n, (int)n2, (float)f3, (float)f4, (float)(f2 + (float)object[0]), (float)(f + (float)object[1]), (TimeInterpolator)sAccelerate, (Transition)this);
    }
}
