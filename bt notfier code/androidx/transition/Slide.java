/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.animation.AccelerateInterpolator
 *  android.view.animation.DecelerateInterpolator
 *  androidx.core.content.res.TypedArrayUtils
 *  androidx.transition.SidePropagation
 *  androidx.transition.Slide$CalculateSlide
 *  androidx.transition.Styleable
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
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.SidePropagation;
import androidx.transition.Slide;
import androidx.transition.Styleable;
import androidx.transition.Transition;
import androidx.transition.TransitionPropagation;
import androidx.transition.TransitionValues;
import androidx.transition.TranslationAnimationCreator;
import androidx.transition.Visibility;
import org.xmlpull.v1.XmlPullParser;

public class Slide
extends Visibility {
    private static final String PROPNAME_SCREEN_POSITION = "android:slide:screenPosition";
    private static final TimeInterpolator sAccelerate;
    private static final CalculateSlide sCalculateBottom;
    private static final CalculateSlide sCalculateEnd;
    private static final CalculateSlide sCalculateLeft;
    private static final CalculateSlide sCalculateRight;
    private static final CalculateSlide sCalculateStart;
    private static final CalculateSlide sCalculateTop;
    private static final TimeInterpolator sDecelerate;
    private CalculateSlide mSlideCalculator = sCalculateBottom;
    private int mSlideEdge = 80;

    static {
        sDecelerate = new DecelerateInterpolator();
        sAccelerate = new AccelerateInterpolator();
        sCalculateLeft = new /* Unavailable Anonymous Inner Class!! */;
        sCalculateStart = new /* Unavailable Anonymous Inner Class!! */;
        sCalculateTop = new /* Unavailable Anonymous Inner Class!! */;
        sCalculateRight = new /* Unavailable Anonymous Inner Class!! */;
        sCalculateEnd = new /* Unavailable Anonymous Inner Class!! */;
        sCalculateBottom = new /* Unavailable Anonymous Inner Class!! */;
    }

    public Slide() {
        this.setSlideEdge(80);
    }

    public Slide(int n) {
        this.setSlideEdge(n);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        context = context.obtainStyledAttributes(attributeSet, Styleable.SLIDE);
        int n = TypedArrayUtils.getNamedInt((TypedArray)context, (XmlPullParser)((XmlPullParser)((Object)attributeSet)), (String)"slideEdge", (int)0, (int)80);
        context.recycle();
        this.setSlideEdge(n);
    }

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        int[] nArray = new int[2];
        view.getLocationOnScreen(nArray);
        transitionValues.values.put(PROPNAME_SCREEN_POSITION, nArray);
    }

    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        this.captureValues(transitionValues);
    }

    public int getSlideEdge() {
        return this.mSlideEdge;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues object, TransitionValues transitionValues) {
        if (transitionValues == null) {
            return null;
        }
        object = (int[])transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        float f = view.getTranslationX();
        float f2 = view.getTranslationY();
        float f3 = this.mSlideCalculator.getGoneX(viewGroup, view);
        float f4 = this.mSlideCalculator.getGoneY(viewGroup, view);
        return TranslationAnimationCreator.createAnimation((View)view, (TransitionValues)transitionValues, (int)object[0], (int)object[1], (float)f3, (float)f4, (float)f, (float)f2, (TimeInterpolator)sDecelerate, (Transition)this);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues object) {
        if (transitionValues == null) {
            return null;
        }
        object = (int[])transitionValues.values.get(PROPNAME_SCREEN_POSITION);
        float f = view.getTranslationX();
        float f2 = view.getTranslationY();
        float f3 = this.mSlideCalculator.getGoneX(viewGroup, view);
        float f4 = this.mSlideCalculator.getGoneY(viewGroup, view);
        return TranslationAnimationCreator.createAnimation((View)view, (TransitionValues)transitionValues, (int)object[0], (int)object[1], (float)f, (float)f2, (float)f3, (float)f4, (TimeInterpolator)sAccelerate, (Transition)this);
    }

    public void setSlideEdge(int n) {
        if (n != 3) {
            if (n != 5) {
                if (n != 48) {
                    if (n != 80) {
                        if (n != 0x800003) {
                            if (n != 0x800005) throw new IllegalArgumentException("Invalid slide direction");
                            this.mSlideCalculator = sCalculateEnd;
                        } else {
                            this.mSlideCalculator = sCalculateStart;
                        }
                    } else {
                        this.mSlideCalculator = sCalculateBottom;
                    }
                } else {
                    this.mSlideCalculator = sCalculateTop;
                }
            } else {
                this.mSlideCalculator = sCalculateRight;
            }
        } else {
            this.mSlideCalculator = sCalculateLeft;
        }
        this.mSlideEdge = n;
        SidePropagation sidePropagation = new SidePropagation();
        sidePropagation.setSide(n);
        this.setPropagation((TransitionPropagation)sidePropagation);
    }
}
