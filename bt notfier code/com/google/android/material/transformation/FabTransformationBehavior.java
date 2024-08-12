/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TypeEvaluator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Property
 *  android.view.View
 *  android.view.ViewAnimationUtils
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$id
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.animation.AnimatorSetCompat
 *  com.google.android.material.animation.ArgbEvaluatorCompat
 *  com.google.android.material.animation.ChildrenAlphaProperty
 *  com.google.android.material.animation.DrawableAlphaProperty
 *  com.google.android.material.animation.MotionTiming
 *  com.google.android.material.animation.Positioning
 *  com.google.android.material.circularreveal.CircularRevealCompat
 *  com.google.android.material.circularreveal.CircularRevealHelper
 *  com.google.android.material.circularreveal.CircularRevealWidget
 *  com.google.android.material.circularreveal.CircularRevealWidget$CircularRevealScrimColorProperty
 *  com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.math.MathUtils
 *  com.google.android.material.transformation.ExpandableTransformationBehavior
 *  com.google.android.material.transformation.FabTransformationBehavior$FabTransformationSpec
 *  com.google.android.material.transformation.TransformationChildCard
 *  com.google.android.material.transformation.TransformationChildLayout
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.animation.ChildrenAlphaProperty;
import com.google.android.material.animation.DrawableAlphaProperty;
import com.google.android.material.animation.MotionTiming;
import com.google.android.material.animation.Positioning;
import com.google.android.material.circularreveal.CircularRevealCompat;
import com.google.android.material.circularreveal.CircularRevealHelper;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.math.MathUtils;
import com.google.android.material.transformation.ExpandableTransformationBehavior;
import com.google.android.material.transformation.FabTransformationBehavior;
import com.google.android.material.transformation.TransformationChildCard;
import com.google.android.material.transformation.TransformationChildLayout;
import java.util.ArrayList;
import java.util.List;

public abstract class FabTransformationBehavior
extends ExpandableTransformationBehavior {
    private final int[] tmpArray;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();

    public FabTransformationBehavior() {
        this.tmpArray = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.tmpArray = new int[2];
    }

    private ViewGroup calculateChildContentContainer(View view) {
        View view2 = view.findViewById(R.id.mtrl_child_content_container);
        if (view2 != null) {
            return this.toViewGroupOrNull(view2);
        }
        if (view instanceof TransformationChildLayout) return this.toViewGroupOrNull(((ViewGroup)view).getChildAt(0));
        if (!(view instanceof TransformationChildCard)) return this.toViewGroupOrNull(view);
        return this.toViewGroupOrNull(((ViewGroup)view).getChildAt(0));
    }

    private void calculateChildVisibleBoundsAtEndOfExpansion(View view, FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, MotionTiming motionTiming2, float f, float f2, float f3, float f4, RectF rectF) {
        f = this.calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming, f, f3);
        f2 = this.calculateValueOfAnimationAtEndOfExpansion(fabTransformationSpec, motionTiming2, f2, f4);
        motionTiming = this.tmpRect;
        view.getWindowVisibleDisplayFrame((Rect)motionTiming);
        fabTransformationSpec = this.tmpRectF1;
        fabTransformationSpec.set((Rect)motionTiming);
        motionTiming = this.tmpRectF2;
        this.calculateWindowBounds(view, (RectF)motionTiming);
        motionTiming.offset(f, f2);
        motionTiming.intersect((RectF)fabTransformationSpec);
        rectF.set((RectF)motionTiming);
    }

    private float calculateRevealCenterX(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        this.calculateWindowBounds(view, rectF);
        this.calculateWindowBounds(view2, rectF2);
        rectF2.offset(-this.calculateTranslationX(view, view2, positioning), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float calculateRevealCenterY(View view, View view2, Positioning positioning) {
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        this.calculateWindowBounds(view, rectF);
        this.calculateWindowBounds(view2, rectF2);
        rectF2.offset(0.0f, -this.calculateTranslationY(view, view2, positioning));
        return rectF.centerY() - rectF2.top;
    }

    private float calculateTranslationX(View view, View view2, Positioning positioning) {
        float f;
        block3: {
            float f2;
            block4: {
                RectF rectF;
                RectF rectF2;
                block0: {
                    block1: {
                        block2: {
                            rectF2 = this.tmpRectF1;
                            rectF = this.tmpRectF2;
                            this.calculateWindowBounds(view, rectF2);
                            this.calculateWindowBounds(view2, rectF);
                            int n = positioning.gravity & 7;
                            if (n == 1) break block0;
                            if (n == 3) break block1;
                            if (n == 5) break block2;
                            f = 0.0f;
                            break block3;
                        }
                        f = rectF.right;
                        f2 = rectF2.right;
                        break block4;
                    }
                    f = rectF.left;
                    f2 = rectF2.left;
                    break block4;
                }
                f = rectF.centerX();
                f2 = rectF2.centerX();
            }
            f -= f2;
        }
        return f + positioning.xAdjustment;
    }

    private float calculateTranslationY(View view, View view2, Positioning positioning) {
        float f;
        block3: {
            float f2;
            block4: {
                RectF rectF;
                RectF rectF2;
                block0: {
                    block1: {
                        block2: {
                            rectF2 = this.tmpRectF1;
                            rectF = this.tmpRectF2;
                            this.calculateWindowBounds(view, rectF2);
                            this.calculateWindowBounds(view2, rectF);
                            int n = positioning.gravity & 0x70;
                            if (n == 16) break block0;
                            if (n == 48) break block1;
                            if (n == 80) break block2;
                            f = 0.0f;
                            break block3;
                        }
                        f = rectF.bottom;
                        f2 = rectF2.bottom;
                        break block4;
                    }
                    f = rectF.top;
                    f2 = rectF2.top;
                    break block4;
                }
                f = rectF.centerY();
                f2 = rectF2.centerY();
            }
            f -= f2;
        }
        return f + positioning.yAdjustment;
    }

    private float calculateValueOfAnimationAtEndOfExpansion(FabTransformationSpec fabTransformationSpec, MotionTiming motionTiming, float f, float f2) {
        long l = motionTiming.getDelay();
        long l2 = motionTiming.getDuration();
        fabTransformationSpec = fabTransformationSpec.timings.getTiming("expansion");
        float f3 = (float)(fabTransformationSpec.getDelay() + fabTransformationSpec.getDuration() + 17L - l) / (float)l2;
        return AnimationUtils.lerp((float)f, (float)f2, (float)motionTiming.getInterpolator().getInterpolation(f3));
    }

    private void calculateWindowBounds(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, (float)view.getWidth(), (float)view.getHeight());
        int[] nArray = this.tmpArray;
        view.getLocationInWindow(nArray);
        rectF.offsetTo((float)nArray[0], (float)nArray[1]);
        rectF.offset((float)((int)(-view.getTranslationX())), (float)((int)(-view.getTranslationY())));
    }

    private void createChildrenFadeAnimation(View view, View view2, boolean bl, boolean bl2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(view2 instanceof ViewGroup)) {
            return;
        }
        if (view2 instanceof CircularRevealWidget && CircularRevealHelper.STRATEGY == 0) {
            return;
        }
        view = this.calculateChildContentContainer(view2);
        if (view == null) {
            return;
        }
        if (bl) {
            if (!bl2) {
                ChildrenAlphaProperty.CHILDREN_ALPHA.set((Object)view, (Object)Float.valueOf(0.0f));
            }
            view = ObjectAnimator.ofFloat((Object)view, (Property)ChildrenAlphaProperty.CHILDREN_ALPHA, (float[])new float[]{1.0f});
        } else {
            view = ObjectAnimator.ofFloat((Object)view, (Property)ChildrenAlphaProperty.CHILDREN_ALPHA, (float[])new float[]{0.0f});
        }
        fabTransformationSpec.timings.getTiming("contentFade").apply((Animator)view);
        list.add((Animator)view);
    }

    private void createColorAnimation(View view, View view2, boolean bl, boolean bl2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(view2 instanceof CircularRevealWidget)) {
            return;
        }
        view2 = (CircularRevealWidget)view2;
        int n = this.getBackgroundTint(view);
        if (bl) {
            if (!bl2) {
                view2.setCircularRevealScrimColor(n);
            }
            view = ObjectAnimator.ofInt((Object)view2, (Property)CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, (int[])new int[]{0xFFFFFF & n});
        } else {
            view = ObjectAnimator.ofInt((Object)view2, (Property)CircularRevealWidget.CircularRevealScrimColorProperty.CIRCULAR_REVEAL_SCRIM_COLOR, (int[])new int[]{n});
        }
        view.setEvaluator((TypeEvaluator)ArgbEvaluatorCompat.getInstance());
        fabTransformationSpec.timings.getTiming("color").apply((Animator)view);
        list.add((Animator)view);
    }

    private void createElevationAnimation(View view, View view2, boolean bl, boolean bl2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        float f = ViewCompat.getElevation((View)view2) - ViewCompat.getElevation((View)view);
        if (bl) {
            if (!bl2) {
                view2.setTranslationZ(-f);
            }
            view = ObjectAnimator.ofFloat((Object)view2, (Property)View.TRANSLATION_Z, (float[])new float[]{0.0f});
        } else {
            view = ObjectAnimator.ofFloat((Object)view2, (Property)View.TRANSLATION_Z, (float[])new float[]{-f});
        }
        fabTransformationSpec.timings.getTiming("elevation").apply((Animator)view);
        list.add((Animator)view);
    }

    private void createExpansionAnimation(View view, View view2, boolean bl, boolean bl2, FabTransformationSpec fabTransformationSpec, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(view2 instanceof CircularRevealWidget)) {
            return;
        }
        CircularRevealWidget circularRevealWidget = (CircularRevealWidget)view2;
        float f3 = this.calculateRevealCenterX(view, view2, fabTransformationSpec.positioning);
        float f4 = this.calculateRevealCenterY(view, view2, fabTransformationSpec.positioning);
        ((FloatingActionButton)view).getContentRect(this.tmpRect);
        float f5 = (float)this.tmpRect.width() / 2.0f;
        MotionTiming motionTiming = fabTransformationSpec.timings.getTiming("expansion");
        if (bl) {
            if (!bl2) {
                circularRevealWidget.setRevealInfo(new CircularRevealWidget.RevealInfo(f3, f4, f5));
            }
            if (bl2) {
                f5 = circularRevealWidget.getRevealInfo().radius;
            }
            view = CircularRevealCompat.createCircularReveal((CircularRevealWidget)circularRevealWidget, (float)f3, (float)f4, (float)MathUtils.distanceToFurthestCorner((float)f3, (float)f4, (float)0.0f, (float)0.0f, (float)f, (float)f2));
            view.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            this.createPreFillRadialExpansion(view2, motionTiming.getDelay(), (int)f3, (int)f4, f5, list);
        } else {
            f = circularRevealWidget.getRevealInfo().radius;
            view = CircularRevealCompat.createCircularReveal((CircularRevealWidget)circularRevealWidget, (float)f3, (float)f4, (float)f5);
            long l = motionTiming.getDelay();
            int n = (int)f3;
            int n2 = (int)f4;
            this.createPreFillRadialExpansion(view2, l, n, n2, f, list);
            this.createPostFillRadialExpansion(view2, motionTiming.getDelay(), motionTiming.getDuration(), fabTransformationSpec.timings.getTotalDuration(), n, n2, f5, list);
        }
        motionTiming.apply((Animator)view);
        list.add((Animator)view);
        list2.add(CircularRevealCompat.createCircularRevealListener((CircularRevealWidget)circularRevealWidget));
    }

    private void createIconFadeAnimation(View view, View view2, boolean bl, boolean bl2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> list2) {
        if (!(view2 instanceof CircularRevealWidget)) return;
        if (!(view instanceof ImageView)) return;
        CircularRevealWidget circularRevealWidget = (CircularRevealWidget)view2;
        Drawable drawable = ((ImageView)view).getDrawable();
        if (drawable == null) {
            return;
        }
        drawable.mutate();
        if (bl) {
            if (!bl2) {
                drawable.setAlpha(255);
            }
            view = ObjectAnimator.ofInt((Object)drawable, (Property)DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, (int[])new int[]{0});
        } else {
            view = ObjectAnimator.ofInt((Object)drawable, (Property)DrawableAlphaProperty.DRAWABLE_ALPHA_COMPAT, (int[])new int[]{255});
        }
        view.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        fabTransformationSpec.timings.getTiming("iconFade").apply((Animator)view);
        list.add((Animator)view);
        list2.add((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void createPostFillRadialExpansion(View view, long l, long l2, long l3, int n, int n2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21) return;
        if ((l += l2) >= l3) return;
        view = ViewAnimationUtils.createCircularReveal((View)view, (int)n, (int)n2, (float)f, (float)f);
        view.setStartDelay(l);
        view.setDuration(l3 - l);
        list.add((Animator)view);
    }

    private void createPreFillRadialExpansion(View view, long l, int n, int n2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21) return;
        if (l <= 0L) return;
        view = ViewAnimationUtils.createCircularReveal((View)view, (int)n, (int)n2, (float)f, (float)f);
        view.setStartDelay(0L);
        view.setDuration(l);
        list.add((Animator)view);
    }

    private void createTranslationAnimation(View view, View view2, boolean bl, boolean bl2, FabTransformationSpec fabTransformationSpec, List<Animator> list, List<Animator.AnimatorListener> motionTiming, RectF rectF) {
        float f = this.calculateTranslationX(view, view2, fabTransformationSpec.positioning);
        float f2 = this.calculateTranslationY(view, view2, fabTransformationSpec.positioning);
        if (f != 0.0f && f2 != 0.0f) {
            if (bl && f2 < 0.0f || !bl && f2 > 0.0f) {
                view = fabTransformationSpec.timings.getTiming("translationXCurveUpwards");
                motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveUpwards");
            } else {
                view = fabTransformationSpec.timings.getTiming("translationXCurveDownwards");
                motionTiming = fabTransformationSpec.timings.getTiming("translationYCurveDownwards");
            }
        } else {
            view = fabTransformationSpec.timings.getTiming("translationXLinear");
            motionTiming = fabTransformationSpec.timings.getTiming("translationYLinear");
        }
        if (bl) {
            if (!bl2) {
                view2.setTranslationX(-f);
                view2.setTranslationY(-f2);
            }
            ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)view2, (Property)View.TRANSLATION_X, (float[])new float[]{0.0f});
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)view2, (Property)View.TRANSLATION_Y, (float[])new float[]{0.0f});
            this.calculateChildVisibleBoundsAtEndOfExpansion(view2, fabTransformationSpec, (MotionTiming)view, motionTiming, -f, -f2, 0.0f, 0.0f, rectF);
            view2 = objectAnimator;
            fabTransformationSpec = objectAnimator2;
        } else {
            rectF = ObjectAnimator.ofFloat((Object)view2, (Property)View.TRANSLATION_X, (float[])new float[]{-f});
            fabTransformationSpec = ObjectAnimator.ofFloat((Object)view2, (Property)View.TRANSLATION_Y, (float[])new float[]{-f2});
            view2 = rectF;
        }
        view.apply((Animator)view2);
        motionTiming.apply((Animator)fabTransformationSpec);
        list.add((Animator)view2);
        list.add((Animator)fabTransformationSpec);
    }

    private int getBackgroundTint(View view) {
        ColorStateList colorStateList = ViewCompat.getBackgroundTintList((View)view);
        if (colorStateList == null) return 0;
        return colorStateList.getColorForState(view.getDrawableState(), colorStateList.getDefaultColor());
    }

    private ViewGroup toViewGroupOrNull(View view) {
        if (!(view instanceof ViewGroup)) return null;
        return (ViewGroup)view;
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        boolean bl;
        if (view.getVisibility() == 8) throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        boolean bl2 = view2 instanceof FloatingActionButton;
        boolean bl3 = bl = false;
        if (!bl2) return bl3;
        int n = ((FloatingActionButton)view2).getExpandedComponentIdHint();
        if (n != 0) {
            bl3 = bl;
            if (n != view.getId()) return bl3;
        }
        bl3 = true;
        return bl3;
    }

    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges != 0) return;
        layoutParams.dodgeInsetEdges = 80;
    }

    protected AnimatorSet onCreateExpandedStateChangeAnimation(View view, View view2, boolean bl, boolean bl2) {
        FabTransformationSpec fabTransformationSpec = this.onCreateMotionSpec(view2.getContext(), bl);
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        ArrayList<Animator.AnimatorListener> arrayList2 = new ArrayList<Animator.AnimatorListener>();
        if (Build.VERSION.SDK_INT >= 21) {
            this.createElevationAnimation(view, view2, bl, bl2, fabTransformationSpec, arrayList, arrayList2);
        }
        RectF rectF = this.tmpRectF1;
        this.createTranslationAnimation(view, view2, bl, bl2, fabTransformationSpec, arrayList, arrayList2, rectF);
        float f = rectF.width();
        float f2 = rectF.height();
        this.createIconFadeAnimation(view, view2, bl, bl2, fabTransformationSpec, arrayList, arrayList2);
        this.createExpansionAnimation(view, view2, bl, bl2, fabTransformationSpec, f, f2, arrayList, arrayList2);
        this.createColorAnimation(view, view2, bl, bl2, fabTransformationSpec, arrayList, arrayList2);
        this.createChildrenFadeAnimation(view, view2, bl, bl2, fabTransformationSpec, arrayList, arrayList2);
        fabTransformationSpec = new AnimatorSet();
        AnimatorSetCompat.playTogether((AnimatorSet)fabTransformationSpec, arrayList);
        fabTransformationSpec.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        int n = 0;
        int n2 = arrayList2.size();
        while (n < n2) {
            fabTransformationSpec.addListener((Animator.AnimatorListener)arrayList2.get(n));
            ++n;
        }
        return fabTransformationSpec;
    }

    protected abstract FabTransformationSpec onCreateMotionSpec(Context var1, boolean var2);
}
