/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.view.View
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.Toolbar$LayoutParams
 *  androidx.coordinatorlayout.widget.CoordinatorLayout
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$AttachedBehavior
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.ViewCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$dimen
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.bottomappbar.BottomAppBar$Behavior
 *  com.google.android.material.bottomappbar.BottomAppBar$SavedState
 *  com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment
 *  com.google.android.material.floatingactionbutton.FloatingActionButton
 *  com.google.android.material.internal.ThemeEnforcement
 *  com.google.android.material.resources.MaterialResources
 *  com.google.android.material.shape.EdgeTreatment
 *  com.google.android.material.shape.MaterialShapeDrawable
 *  com.google.android.material.shape.ShapePathModel
 */
package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapePathModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar
extends Toolbar
implements CoordinatorLayout.AttachedBehavior {
    private static final long ANIMATION_DURATION = 300L;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    private Animator attachAnimator;
    private int fabAlignmentMode;
    AnimatorListenerAdapter fabAnimationListener = new /* Unavailable Anonymous Inner Class!! */;
    private boolean fabAttached = true;
    private final int fabOffsetEndMode;
    private boolean hideOnScroll;
    private final MaterialShapeDrawable materialShapeDrawable;
    private Animator menuAnimator;
    private Animator modeAnimator;
    private final BottomAppBarTopEdgeTreatment topEdgeTreatment;

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        attributeSet = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.BottomAppBar, (int)n, (int)R.style.Widget_MaterialComponents_BottomAppBar, (int[])new int[0]);
        context = MaterialResources.getColorStateList((Context)context, (TypedArray)attributeSet, (int)R.styleable.BottomAppBar_backgroundTint);
        float f = attributeSet.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float f2 = attributeSet.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float f3 = attributeSet.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = attributeSet.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.hideOnScroll = attributeSet.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        attributeSet.recycle();
        this.fabOffsetEndMode = this.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.topEdgeTreatment = new BottomAppBarTopEdgeTreatment(f, f2, f3);
        attributeSet = new ShapePathModel();
        attributeSet.setTopEdge((EdgeTreatment)this.topEdgeTreatment);
        attributeSet = new MaterialShapeDrawable((ShapePathModel)attributeSet);
        this.materialShapeDrawable = attributeSet;
        attributeSet.setShadowEnabled(true);
        this.materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        DrawableCompat.setTintList((Drawable)this.materialShapeDrawable, (ColorStateList)context);
        ViewCompat.setBackground((View)this, (Drawable)this.materialShapeDrawable);
    }

    static /* synthetic */ Animator access$002(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.modeAnimator = animator;
        return animator;
    }

    static /* synthetic */ BottomAppBarTopEdgeTreatment access$100(BottomAppBar bottomAppBar) {
        return bottomAppBar.topEdgeTreatment;
    }

    static /* synthetic */ void access$1000(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        bottomAppBar.addFabAnimationListeners(floatingActionButton);
    }

    static /* synthetic */ FloatingActionButton access$1100(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentFab();
    }

    static /* synthetic */ boolean access$1200(BottomAppBar bottomAppBar) {
        return bottomAppBar.isAnimationRunning();
    }

    static /* synthetic */ void access$1300(BottomAppBar bottomAppBar) {
        bottomAppBar.setCutoutState();
    }

    static /* synthetic */ float access$1400(BottomAppBar bottomAppBar) {
        return bottomAppBar.getFabTranslationY();
    }

    static /* synthetic */ MaterialShapeDrawable access$200(BottomAppBar bottomAppBar) {
        return bottomAppBar.materialShapeDrawable;
    }

    static /* synthetic */ Animator access$302(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.menuAnimator = animator;
        return animator;
    }

    static /* synthetic */ void access$400(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int n, boolean bl) {
        bottomAppBar.translateActionMenuView(actionMenuView, n, bl);
    }

    static /* synthetic */ Animator access$502(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.attachAnimator = animator;
        return animator;
    }

    static /* synthetic */ boolean access$600(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAttached;
    }

    static /* synthetic */ void access$700(BottomAppBar bottomAppBar, boolean bl) {
        bottomAppBar.maybeAnimateAttachChange(bl);
    }

    static /* synthetic */ int access$800(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAlignmentMode;
    }

    static /* synthetic */ void access$900(BottomAppBar bottomAppBar, int n, boolean bl) {
        bottomAppBar.maybeAnimateMenuView(n, bl);
    }

    private void addFabAnimationListeners(FloatingActionButton floatingActionButton) {
        this.removeFabAnimationListeners(floatingActionButton);
        floatingActionButton.addOnHideAnimationListener((Animator.AnimatorListener)this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener((Animator.AnimatorListener)this.fabAnimationListener);
    }

    private void cancelAnimations() {
        Animator animator = this.attachAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if ((animator = this.menuAnimator) != null) {
            animator.cancel();
        }
        if ((animator = this.modeAnimator) == null) return;
        animator.cancel();
    }

    private void createCradleShapeAnimation(boolean bl, List<Animator> list) {
        if (bl) {
            this.topEdgeTreatment.setHorizontalOffset(this.getFabTranslationX());
        }
        float f = this.materialShapeDrawable.getInterpolation();
        float f2 = bl ? 1.0f : 0.0f;
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{f, f2});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.setDuration(300L);
        list.add((Animator)valueAnimator);
    }

    private void createCradleTranslationAnimation(int n, List<Animator> list) {
        if (!this.fabAttached) {
            return;
        }
        ValueAnimator valueAnimator = ValueAnimator.ofFloat((float[])new float[]{this.topEdgeTreatment.getHorizontalOffset(), this.getFabTranslationX(n)});
        valueAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        valueAnimator.setDuration(300L);
        list.add((Animator)valueAnimator);
    }

    private void createFabTranslationXAnimation(int n, List<Animator> list) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)this.findDependentFab(), (String)"translationX", (float[])new float[]{this.getFabTranslationX(n)});
        objectAnimator.setDuration(300L);
        list.add((Animator)objectAnimator);
    }

    private void createFabTranslationYAnimation(boolean bl, List<Animator> list) {
        FloatingActionButton floatingActionButton = this.findDependentFab();
        if (floatingActionButton == null) {
            return;
        }
        floatingActionButton = ObjectAnimator.ofFloat((Object)floatingActionButton, (String)"translationY", (float[])new float[]{this.getFabTranslationY(bl)});
        floatingActionButton.setDuration(300L);
        list.add((Animator)floatingActionButton);
    }

    private void createMenuViewTranslationAnimation(int n, boolean bl, List<Animator> list) {
        ActionMenuView actionMenuView = this.getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat((Object)actionMenuView, (String)"alpha", (float[])new float[]{1.0f});
        if (!this.fabAttached && (!bl || !this.isVisibleFab()) || this.fabAlignmentMode != 1 && n != 1) {
            if (!(actionMenuView.getAlpha() < 1.0f)) return;
            list.add((Animator)objectAnimator);
        } else {
            ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat((Object)actionMenuView, (String)"alpha", (float[])new float[]{0.0f});
            objectAnimator2.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
            actionMenuView = new AnimatorSet();
            actionMenuView.setDuration(150L);
            actionMenuView.playSequentially(new Animator[]{objectAnimator2, objectAnimator});
            list.add((Animator)actionMenuView);
        }
    }

    private FloatingActionButton findDependentFab() {
        View view;
        if (!(this.getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        Iterator iterator = ((CoordinatorLayout)this.getParent()).getDependents((View)this).iterator();
        do {
            if (!iterator.hasNext()) return null;
        } while (!((view = (View)iterator.next()) instanceof FloatingActionButton));
        return (FloatingActionButton)view;
    }

    private ActionMenuView getActionMenuView() {
        int n = 0;
        while (n < this.getChildCount()) {
            View view = this.getChildAt(n);
            if (view instanceof ActionMenuView) {
                return (ActionMenuView)view;
            }
            ++n;
        }
        return null;
    }

    private float getFabTranslationX() {
        return this.getFabTranslationX(this.fabAlignmentMode);
    }

    private int getFabTranslationX(int n) {
        int n2 = ViewCompat.getLayoutDirection((View)this);
        int n3 = 0;
        int n4 = 1;
        n2 = n2 == 1 ? 1 : 0;
        if (n != 1) return n3;
        n3 = this.getMeasuredWidth() / 2;
        int n5 = this.fabOffsetEndMode;
        n = n4;
        if (n2 != 0) {
            n = -1;
        }
        n3 = (n3 - n5) * n;
        return n3;
    }

    private float getFabTranslationY() {
        return this.getFabTranslationY(this.fabAttached);
    }

    private float getFabTranslationY(boolean bl) {
        float f;
        FloatingActionButton floatingActionButton = this.findDependentFab();
        if (floatingActionButton == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        floatingActionButton.getContentRect(rect);
        float f2 = f = (float)rect.height();
        if (f == 0.0f) {
            f2 = floatingActionButton.getMeasuredHeight();
        }
        f = floatingActionButton.getHeight() - rect.bottom;
        float f3 = floatingActionButton.getHeight() - rect.height();
        f2 = -this.getCradleVerticalOffset() + f2 / 2.0f + f;
        float f4 = floatingActionButton.getPaddingBottom();
        f = -this.getMeasuredHeight();
        if (bl) return f + f2;
        f2 = f3 - f4;
        return f + f2;
    }

    private boolean isAnimationRunning() {
        Animator animator = this.attachAnimator;
        boolean bl = animator != null && animator.isRunning() || (animator = this.menuAnimator) != null && animator.isRunning() || (animator = this.modeAnimator) != null && animator.isRunning();
        return bl;
    }

    private boolean isVisibleFab() {
        FloatingActionButton floatingActionButton = this.findDependentFab();
        boolean bl = floatingActionButton != null && floatingActionButton.isOrWillBeShown();
        return bl;
    }

    private void maybeAnimateAttachChange(boolean bl) {
        if (!ViewCompat.isLaidOut((View)this)) {
            return;
        }
        Animator animator = this.attachAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        boolean bl2 = bl && this.isVisibleFab();
        this.createCradleShapeAnimation(bl2, arrayList);
        this.createFabTranslationYAnimation(bl, arrayList);
        animator = new AnimatorSet();
        animator.playTogether(arrayList);
        this.attachAnimator = animator;
        animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.attachAnimator.start();
    }

    private void maybeAnimateMenuView(int n, boolean bl) {
        if (!ViewCompat.isLaidOut((View)this)) {
            return;
        }
        Animator animator = this.menuAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        if (!this.isVisibleFab()) {
            n = 0;
            bl = false;
        }
        this.createMenuViewTranslationAnimation(n, bl, arrayList);
        animator = new AnimatorSet();
        animator.playTogether(arrayList);
        this.menuAnimator = animator;
        animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int n) {
        if (this.fabAlignmentMode == n) return;
        if (!ViewCompat.isLaidOut((View)this)) return;
        Animator animator = this.modeAnimator;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList<Animator> arrayList = new ArrayList<Animator>();
        this.createCradleTranslationAnimation(n, arrayList);
        this.createFabTranslationXAnimation(n, arrayList);
        animator = new AnimatorSet();
        animator.playTogether(arrayList);
        this.modeAnimator = animator;
        animator.addListener((Animator.AnimatorListener)new /* Unavailable Anonymous Inner Class!! */);
        this.modeAnimator.start();
    }

    private void removeFabAnimationListeners(FloatingActionButton floatingActionButton) {
        floatingActionButton.removeOnHideAnimationListener((Animator.AnimatorListener)this.fabAnimationListener);
        floatingActionButton.removeOnShowAnimationListener((Animator.AnimatorListener)this.fabAnimationListener);
    }

    private void setCutoutState() {
        this.topEdgeTreatment.setHorizontalOffset(this.getFabTranslationX());
        FloatingActionButton floatingActionButton = this.findDependentFab();
        MaterialShapeDrawable materialShapeDrawable = this.materialShapeDrawable;
        float f = this.fabAttached && this.isVisibleFab() ? 1.0f : 0.0f;
        materialShapeDrawable.setInterpolation(f);
        if (floatingActionButton != null) {
            floatingActionButton.setTranslationY(this.getFabTranslationY());
            floatingActionButton.setTranslationX(this.getFabTranslationX());
        }
        if ((floatingActionButton = this.getActionMenuView()) == null) return;
        floatingActionButton.setAlpha(1.0f);
        if (!this.isVisibleFab()) {
            this.translateActionMenuView((ActionMenuView)floatingActionButton, 0, false);
        } else {
            this.translateActionMenuView((ActionMenuView)floatingActionButton, this.fabAlignmentMode, this.fabAttached);
        }
    }

    private void translateActionMenuView(ActionMenuView actionMenuView, int n, boolean bl) {
        int n2 = ViewCompat.getLayoutDirection((View)this) == 1 ? 1 : 0;
        int n3 = 0;
        for (int i = 0; i < this.getChildCount(); ++i) {
            View view = this.getChildAt(i);
            boolean bl2 = view.getLayoutParams() instanceof Toolbar.LayoutParams && (((Toolbar.LayoutParams)view.getLayoutParams()).gravity & 0x800007) == 0x800003;
            int n4 = n3;
            if (bl2) {
                n4 = n2 != 0 ? view.getLeft() : view.getRight();
                n4 = Math.max(n3, n4);
            }
            n3 = n4;
        }
        n2 = n2 != 0 ? actionMenuView.getRight() : actionMenuView.getLeft();
        float f = n == 1 && bl ? (float)(n3 - n2) : 0.0f;
        actionMenuView.setTranslationX(f);
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public float getCradleVerticalOffset() {
        return this.topEdgeTreatment.getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public float getFabCradleMargin() {
        return this.topEdgeTreatment.getFabCradleMargin();
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.topEdgeTreatment.getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        this.cancelAnimations();
        this.setCutoutState();
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        parcelable = (SavedState)parcelable;
        super.onRestoreInstanceState(parcelable.getSuperState());
        this.fabAlignmentMode = parcelable.fabAlignmentMode;
        this.fabAttached = parcelable.fabAttached;
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void replaceMenu(int n) {
        this.getMenu().clear();
        this.inflateMenu(n);
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.setTintList((Drawable)this.materialShapeDrawable, (ColorStateList)colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f == this.getCradleVerticalOffset()) return;
        this.topEdgeTreatment.setCradleVerticalOffset(f);
        this.materialShapeDrawable.invalidateSelf();
    }

    public void setFabAlignmentMode(int n) {
        this.maybeAnimateModeChange(n);
        this.maybeAnimateMenuView(n, this.fabAttached);
        this.fabAlignmentMode = n;
    }

    public void setFabCradleMargin(float f) {
        if (f == this.getFabCradleMargin()) return;
        this.topEdgeTreatment.setFabCradleMargin(f);
        this.materialShapeDrawable.invalidateSelf();
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f == this.getFabCradleRoundedCornerRadius()) return;
        this.topEdgeTreatment.setFabCradleRoundedCornerRadius(f);
        this.materialShapeDrawable.invalidateSelf();
    }

    void setFabDiameter(int n) {
        float f = n;
        if (f == this.topEdgeTreatment.getFabDiameter()) return;
        this.topEdgeTreatment.setFabDiameter(f);
        this.materialShapeDrawable.invalidateSelf();
    }

    public void setHideOnScroll(boolean bl) {
        this.hideOnScroll = bl;
    }

    public void setSubtitle(CharSequence charSequence) {
    }

    public void setTitle(CharSequence charSequence) {
    }
}
