/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.view.ViewCompat
 *  androidx.transition.RectEvaluator
 *  androidx.transition.Transition
 *  androidx.transition.TransitionValues
 *  androidx.transition.ViewUtils
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.transition.RectEvaluator;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;

public class ChangeClipBounds
extends Transition {
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties = new String[]{"android:clipBounds:clip"};

    public ChangeClipBounds() {
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        if (view.getVisibility() == 8) {
            return;
        }
        Rect rect = ViewCompat.getClipBounds((View)view);
        transitionValues.values.put(PROPNAME_CLIP, rect);
        if (rect != null) return;
        rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        transitionValues.values.put(PROPNAME_BOUNDS, rect);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        this.captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        Rect rect = null;
        viewGroup = rect;
        if (transitionValues == null) return viewGroup;
        viewGroup = rect;
        if (transitionValues2 == null) return viewGroup;
        viewGroup = rect;
        if (!transitionValues.values.containsKey(PROPNAME_CLIP)) return viewGroup;
        if (!transitionValues2.values.containsKey(PROPNAME_CLIP)) {
            viewGroup = rect;
        } else {
            rect = (Rect)transitionValues.values.get(PROPNAME_CLIP);
            Rect rect2 = (Rect)transitionValues2.values.get(PROPNAME_CLIP);
            boolean bl = rect2 == null;
            if (rect == null && rect2 == null) {
                return null;
            }
            if (rect == null) {
                viewGroup = (Rect)transitionValues.values.get(PROPNAME_BOUNDS);
                transitionValues = rect2;
            } else {
                viewGroup = rect;
                transitionValues = rect2;
                if (rect2 == null) {
                    transitionValues = (Rect)transitionValues2.values.get(PROPNAME_BOUNDS);
                    viewGroup = rect;
                }
            }
            if (viewGroup.equals((Object)transitionValues)) {
                return null;
            }
            ViewCompat.setClipBounds((View)transitionValues2.view, (Rect)viewGroup);
            rect = new RectEvaluator(new Rect());
            transitionValues = ObjectAnimator.ofObject((Object)transitionValues2.view, (Property)ViewUtils.CLIP_BOUNDS, (TypeEvaluator)rect, (Object[])new Rect[]{viewGroup, transitionValues});
            viewGroup = transitionValues;
            if (!bl) return viewGroup;
            transitionValues.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            viewGroup = transitionValues;
        }
        return viewGroup;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }
}
