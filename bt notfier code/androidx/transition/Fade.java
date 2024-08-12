/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.ObjectAnimator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.transition.Fade$FadeAnimatorListener
 *  androidx.transition.Styleable
 *  androidx.transition.Transition$TransitionListener
 *  androidx.transition.TransitionValues
 *  androidx.transition.ViewUtils
 *  androidx.transition.Visibility
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.Fade;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionValues;
import androidx.transition.ViewUtils;
import androidx.transition.Visibility;
import org.xmlpull.v1.XmlPullParser;

public class Fade
extends Visibility {
    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public Fade() {
    }

    public Fade(int n) {
        this.setMode(n);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.FADE);
        this.setMode(TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)((XmlResourceParser)attributeSet), (String)"fadingMode", (int)0, (int)this.getMode()));
        context.recycle();
    }

    private Animator createAnimation(View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        ViewUtils.setTransitionAlpha((View)view, (float)f);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view, (Property)ViewUtils.TRANSITION_ALPHA, (float[])new float[]{f2});
        objectAnimator.addListener((Animator.AnimatorListener)new FadeAnimatorListener(view));
        this.addListener((Transition.TransitionListener)new /* Unavailable Anonymous Inner Class!! */);
        return objectAnimator;
    }

    private static float getStartAlpha(TransitionValues object, float f) {
        float f2 = f;
        if (object == null) return f2;
        object = (Float)((TransitionValues)object).values.get(PROPNAME_TRANSITION_ALPHA);
        f2 = f;
        if (object == null) return f2;
        f2 = ((Float)object).floatValue();
        return f2;
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        transitionValues.values.put(PROPNAME_TRANSITION_ALPHA, Float.valueOf(ViewUtils.getTransitionAlpha((View)transitionValues.view)));
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f = 0.0f;
        float f2 = Fade.getStartAlpha(transitionValues, 0.0f);
        if (f2 == 1.0f) return this.createAnimation(view, f, 1.0f);
        f = f2;
        return this.createAnimation(view, f, 1.0f);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        ViewUtils.saveNonTransitionAlpha((View)view);
        return this.createAnimation(view, Fade.getStartAlpha(transitionValues, 1.0f), 0.0f);
    }
}
