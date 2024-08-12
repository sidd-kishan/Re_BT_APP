/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.transition.Transition
 *  androidx.transition.TransitionUtils
 *  androidx.transition.TransitionValues
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.TransitionUtils;
import androidx.transition.TransitionValues;

public class ChangeScroll
extends Transition {
    private static final String[] PROPERTIES = new String[]{"android:changeScroll:x", "android:changeScroll:y"};
    private static final String PROPNAME_SCROLL_X = "android:changeScroll:x";
    private static final String PROPNAME_SCROLL_Y = "android:changeScroll:y";

    public ChangeScroll() {
    }

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_SCROLL_X, transitionValues.view.getScrollX());
        transitionValues.values.put(PROPNAME_SCROLL_Y, transitionValues.view.getScrollY());
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view = null;
        Object var8_5 = null;
        viewGroup = view;
        if (transitionValues == null) return viewGroup;
        if (transitionValues2 == null) {
            viewGroup = view;
        } else {
            view = transitionValues2.view;
            int n = (Integer)transitionValues.values.get(PROPNAME_SCROLL_X);
            int n2 = (Integer)transitionValues2.values.get(PROPNAME_SCROLL_X);
            int n3 = (Integer)transitionValues.values.get(PROPNAME_SCROLL_Y);
            int n4 = (Integer)transitionValues2.values.get(PROPNAME_SCROLL_Y);
            if (n != n2) {
                view.setScrollX(n);
                viewGroup = ObjectAnimator.ofInt((Object)view, (String)"scrollX", (int[])new int[]{n, n2});
            } else {
                viewGroup = null;
            }
            transitionValues = var8_5;
            if (n3 != n4) {
                view.setScrollY(n3);
                transitionValues = ObjectAnimator.ofInt((Object)view, (String)"scrollY", (int[])new int[]{n3, n4});
            }
            viewGroup = TransitionUtils.mergeAnimators((Animator)viewGroup, (Animator)transitionValues);
        }
        return viewGroup;
    }

    public String[] getTransitionProperties() {
        return PROPERTIES;
    }
}
