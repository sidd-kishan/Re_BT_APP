/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.Typeface
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$Callback
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.appcompat.R$style
 *  androidx.appcompat.widget.Toolbar
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.util.ObjectsCompat
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.R$id
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.animation.AnimationUtils
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener
 *  com.google.android.material.appbar.CollapsingToolbarLayout$LayoutParams
 *  com.google.android.material.appbar.CollapsingToolbarLayout$OffsetUpdateListener
 *  com.google.android.material.appbar.ViewOffsetHelper
 *  com.google.android.material.internal.CollapsingTextHelper
 *  com.google.android.material.internal.DescendantOffsetUtils
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.R;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.appbar.ViewOffsetHelper;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;

public class CollapsingToolbarLayout
extends FrameLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    WindowInsetsCompat lastInsets;
    private AppBarLayout.OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar = true;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger = -1;
    private boolean scrimsAreShown;
    Drawable statusBarScrim;
    private final Rect tmpRect = new Rect();
    private Toolbar toolbar;
    private View toolbarDirectChild;
    private int toolbarId;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        CollapsingTextHelper collapsingTextHelper;
        this.collapsingTextHelper = collapsingTextHelper = new CollapsingTextHelper((View)this);
        collapsingTextHelper.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        context = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.CollapsingToolbarLayout, (int)n, (int)R.style.Widget_Design_CollapsingToolbar, (int[])new int[0]);
        this.collapsingTextHelper.setExpandedTextGravity(context.getInt(R.styleable.CollapsingToolbarLayout_expandedTitleGravity, 8388691));
        this.collapsingTextHelper.setCollapsedTextGravity(context.getInt(R.styleable.CollapsingToolbarLayout_collapsedTitleGravity, 8388627));
        this.expandedMarginBottom = n = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginEnd = n;
        this.expandedMarginTop = n;
        this.expandedMarginStart = n;
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.expandedMarginStart = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.expandedMarginEnd = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.expandedMarginTop = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.expandedMarginBottom = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }
        this.collapsingTitleEnabled = context.getBoolean(R.styleable.CollapsingToolbarLayout_titleEnabled, true);
        this.setTitle(context.getText(R.styleable.CollapsingToolbarLayout_title));
        this.collapsingTextHelper.setExpandedTextAppearance(R.style.TextAppearance_Design_CollapsingToolbar_Expanded);
        this.collapsingTextHelper.setCollapsedTextAppearance(R.style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            this.collapsingTextHelper.setExpandedTextAppearance(context.getResourceId(R.styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }
        if (context.hasValue(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            this.collapsingTextHelper.setCollapsedTextAppearance(context.getResourceId(R.styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }
        this.scrimVisibleHeightTrigger = context.getDimensionPixelSize(R.styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, -1);
        this.scrimAnimationDuration = context.getInt(R.styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600);
        this.setContentScrim(context.getDrawable(R.styleable.CollapsingToolbarLayout_contentScrim));
        this.setStatusBarScrim(context.getDrawable(R.styleable.CollapsingToolbarLayout_statusBarScrim));
        this.toolbarId = context.getResourceId(R.styleable.CollapsingToolbarLayout_toolbarId, -1);
        context.recycle();
        this.setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private void animateScrim(int n) {
        this.ensureToolbar();
        ValueAnimator valueAnimator = this.scrimAnimator;
        if (valueAnimator == null) {
            this.scrimAnimator = valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(this.scrimAnimationDuration);
            ValueAnimator valueAnimator2 = this.scrimAnimator;
            valueAnimator = n > this.scrimAlpha ? AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR : AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            valueAnimator2.setInterpolator((TimeInterpolator)valueAnimator);
            this.scrimAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
        } else if (valueAnimator.isRunning()) {
            this.scrimAnimator.cancel();
        }
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, n});
        this.scrimAnimator.start();
    }

    private void ensureToolbar() {
        Toolbar toolbar;
        if (!this.refreshToolbar) {
            return;
        }
        Object var4_1 = null;
        this.toolbar = null;
        this.toolbarDirectChild = null;
        int n = this.toolbarId;
        if (n != -1) {
            this.toolbar = toolbar = (Toolbar)this.findViewById(n);
            if (toolbar != null) {
                this.toolbarDirectChild = this.findDirectChild((View)toolbar);
            }
        }
        if (this.toolbar == null) {
            int n2 = this.getChildCount();
            n = 0;
            while (true) {
                toolbar = var4_1;
                if (n >= n2 || (toolbar = this.getChildAt(n)) instanceof Toolbar) break;
                ++n;
            }
            this.toolbar = toolbar;
        }
        this.updateDummyView();
        this.refreshToolbar = false;
    }

    private View findDirectChild(View view) {
        ViewParent viewParent = view.getParent();
        View view2 = view;
        view = viewParent;
        while (view != this) {
            if (view == null) return view2;
            if (view instanceof View) {
                view2 = view;
            }
            view = view.getParent();
        }
        return view2;
    }

    private static int getHeightWithMargins(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return view.getHeight();
        layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
        return view.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    static ViewOffsetHelper getViewOffsetHelper(View view) {
        ViewOffsetHelper viewOffsetHelper;
        ViewOffsetHelper viewOffsetHelper2 = viewOffsetHelper = (ViewOffsetHelper)view.getTag(R.id.view_offset_helper);
        if (viewOffsetHelper != null) return viewOffsetHelper2;
        viewOffsetHelper2 = new ViewOffsetHelper(view);
        view.setTag(R.id.view_offset_helper, (Object)viewOffsetHelper2);
        return viewOffsetHelper2;
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.toolbarDirectChild;
        boolean bl = true;
        if (view2 != null && view2 != this ? view == view2 : view == this.toolbar) return bl;
        bl = false;
        return bl;
    }

    private void updateContentDescriptionFromTitle() {
        this.setContentDescription(this.getTitle());
    }

    private void updateDummyView() {
        View view;
        if (!this.collapsingTitleEnabled && (view = this.dummyView) != null && (view = view.getParent()) instanceof ViewGroup) {
            ((ViewGroup)view).removeView(this.dummyView);
        }
        if (!this.collapsingTitleEnabled) return;
        if (this.toolbar == null) return;
        if (this.dummyView == null) {
            this.dummyView = new View(this.getContext());
        }
        if (this.dummyView.getParent() != null) return;
        this.toolbar.addView(this.dummyView, -1, -1);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        this.ensureToolbar();
        if (this.toolbar == null && (drawable = this.contentScrim) != null && this.scrimAlpha > 0) {
            drawable.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
        }
        if (this.collapsingTitleEnabled && this.drawCollapsingTitle) {
            this.collapsingTextHelper.draw(canvas);
        }
        if (this.statusBarScrim == null) return;
        if (this.scrimAlpha <= 0) return;
        drawable = this.lastInsets;
        int n = drawable != null ? drawable.getSystemWindowInsetTop() : 0;
        if (n <= 0) return;
        this.statusBarScrim.setBounds(0, -this.currentOffset, this.getWidth(), n - this.currentOffset);
        this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
        this.statusBarScrim.draw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        boolean bl;
        Drawable drawable = this.contentScrim;
        boolean bl2 = true;
        if (drawable != null && this.scrimAlpha > 0 && this.isToolbarChild(view)) {
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(canvas);
            bl = true;
        } else {
            bl = false;
        }
        boolean bl3 = bl2;
        if (super.drawChild(canvas, view, l)) return bl3;
        bl3 = bl ? bl2 : false;
        return bl3;
    }

    protected void drawableStateChanged() {
        boolean bl;
        super.drawableStateChanged();
        int[] nArray = this.getDrawableState();
        Drawable drawable = this.statusBarScrim;
        boolean bl2 = bl = false;
        if (drawable != null) {
            bl2 = bl;
            if (drawable.isStateful()) {
                bl2 = false | drawable.setState(nArray);
            }
        }
        drawable = this.contentScrim;
        bl = bl2;
        if (drawable != null) {
            bl = bl2;
            if (drawable.isStateful()) {
                bl = bl2 | drawable.setState(nArray);
            }
        }
        drawable = this.collapsingTextHelper;
        bl2 = bl;
        if (drawable != null) {
            bl2 = bl | drawable.setState(nArray);
        }
        if (!bl2) return;
        this.invalidate();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    public FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected FrameLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    final int getMaxOffsetForPinChild(View view) {
        ViewOffsetHelper viewOffsetHelper = CollapsingToolbarLayout.getViewOffsetHelper(view);
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        return this.getHeight() - viewOffsetHelper.getLayoutTop() - view.getHeight() - layoutParams.bottomMargin;
    }

    int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int n = this.scrimVisibleHeightTrigger;
        if (n >= 0) {
            return n;
        }
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        n = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        int n2 = ViewCompat.getMinimumHeight((View)this);
        if (n2 <= 0) return this.getHeight() / 3;
        return Math.min(n2 * 2 + n, this.getHeight());
    }

    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public CharSequence getTitle() {
        CharSequence charSequence = this.collapsingTitleEnabled ? this.collapsingTextHelper.getText() : null;
        return charSequence;
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent viewParent = this.getParent();
        if (!(viewParent instanceof AppBarLayout)) return;
        ViewCompat.setFitsSystemWindows((View)this, (boolean)ViewCompat.getFitsSystemWindows((View)((View)viewParent)));
        if (this.onOffsetChangedListener == null) {
            this.onOffsetChangedListener = new OffsetUpdateListener(this);
        }
        ((AppBarLayout)viewParent).addOnOffsetChangedListener(this.onOffsetChangedListener);
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onDetachedFromWindow() {
        ViewParent viewParent = this.getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.onOffsetChangedListener;
        if (onOffsetChangedListener != null && viewParent instanceof AppBarLayout) {
            ((AppBarLayout)viewParent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        int n7;
        super.onLayout(bl, n, n2, n3, n4);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int n8 = 0;
        if (windowInsetsCompat != null) {
            n7 = windowInsetsCompat.getSystemWindowInsetTop();
            n6 = this.getChildCount();
            for (n5 = 0; n5 < n6; ++n5) {
                windowInsetsCompat = this.getChildAt(n5);
                if (ViewCompat.getFitsSystemWindows((View)windowInsetsCompat) || windowInsetsCompat.getTop() >= n7) continue;
                ViewCompat.offsetTopAndBottom((View)windowInsetsCompat, (int)n7);
            }
        }
        if (this.collapsingTitleEnabled && (windowInsetsCompat = this.dummyView) != null) {
            bl = ViewCompat.isAttachedToWindow((View)windowInsetsCompat);
            n5 = 1;
            bl = bl && this.dummyView.getVisibility() == 0;
            this.drawCollapsingTitle = bl;
            if (bl) {
                if (ViewCompat.getLayoutDirection((View)this) != 1) {
                    n5 = 0;
                }
                windowInsetsCompat = this.toolbarDirectChild;
                if (windowInsetsCompat == null) {
                    windowInsetsCompat = this.toolbar;
                }
                int n9 = this.getMaxOffsetForPinChild((View)windowInsetsCompat);
                DescendantOffsetUtils.getDescendantRect((ViewGroup)this, (View)this.dummyView, (Rect)this.tmpRect);
                windowInsetsCompat = this.collapsingTextHelper;
                int n10 = this.tmpRect.left;
                n7 = n5 != 0 ? this.toolbar.getTitleMarginEnd() : this.toolbar.getTitleMarginStart();
                int n11 = this.tmpRect.top;
                int n12 = this.toolbar.getTitleMarginTop();
                int n13 = this.tmpRect.right;
                n6 = n5 != 0 ? this.toolbar.getTitleMarginStart() : this.toolbar.getTitleMarginEnd();
                windowInsetsCompat.setCollapsedBounds(n10 + n7, n11 + n9 + n12, n13 + n6, this.tmpRect.bottom + n9 - this.toolbar.getTitleMarginBottom());
                windowInsetsCompat = this.collapsingTextHelper;
                n7 = n5 != 0 ? this.expandedMarginEnd : this.expandedMarginStart;
                n10 = this.tmpRect.top;
                n6 = this.expandedMarginTop;
                n5 = n5 != 0 ? this.expandedMarginStart : this.expandedMarginEnd;
                windowInsetsCompat.setExpandedBounds(n7, n10 + n6, n3 - n - n5, n4 - n2 - this.expandedMarginBottom);
                this.collapsingTextHelper.recalculate();
            }
        }
        n2 = this.getChildCount();
        for (n = n8; n < n2; ++n) {
            CollapsingToolbarLayout.getViewOffsetHelper(this.getChildAt(n)).onViewLayout();
        }
        if (this.toolbar != null) {
            if (this.collapsingTitleEnabled && TextUtils.isEmpty((CharSequence)this.collapsingTextHelper.getText())) {
                this.setTitle(this.toolbar.getTitle());
            }
            if ((windowInsetsCompat = this.toolbarDirectChild) != null && windowInsetsCompat != this) {
                this.setMinimumHeight(CollapsingToolbarLayout.getHeightWithMargins((View)windowInsetsCompat));
            } else {
                this.setMinimumHeight(CollapsingToolbarLayout.getHeightWithMargins((View)this.toolbar));
            }
        }
        this.updateScrimVisibility();
    }

    protected void onMeasure(int n, int n2) {
        this.ensureToolbar();
        super.onMeasure(n, n2);
        int n3 = View.MeasureSpec.getMode((int)n2);
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        n2 = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        if (n3 != 0) return;
        if (n2 <= 0) return;
        super.onMeasure(n, View.MeasureSpec.makeMeasureSpec((int)(this.getMeasuredHeight() + n2), (int)0x40000000));
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        Drawable drawable = this.contentScrim;
        if (drawable == null) return;
        drawable.setBounds(0, 0, n, n2);
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        Object object = ViewCompat.getFitsSystemWindows((View)this) ? windowInsetsCompat : null;
        if (ObjectsCompat.equals((Object)this.lastInsets, (Object)object)) return windowInsetsCompat.consumeSystemWindowInsets();
        this.lastInsets = object;
        this.requestLayout();
        return windowInsetsCompat.consumeSystemWindowInsets();
    }

    public void setCollapsedTitleGravity(int n) {
        this.collapsingTextHelper.setCollapsedTextGravity(n);
    }

    public void setCollapsedTitleTextAppearance(int n) {
        this.collapsingTextHelper.setCollapsedTextAppearance(n);
    }

    public void setCollapsedTitleTextColor(int n) {
        this.setCollapsedTitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.collapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.collapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.contentScrim;
        if (drawable2 == drawable) return;
        Drawable drawable3 = null;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable3 = drawable.mutate();
        }
        this.contentScrim = drawable3;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.contentScrim.setCallback((Drawable.Callback)this);
            this.contentScrim.setAlpha(this.scrimAlpha);
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public void setContentScrimColor(int n) {
        this.setContentScrim((Drawable)new ColorDrawable(n));
    }

    public void setContentScrimResource(int n) {
        this.setContentScrim(ContextCompat.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setExpandedTitleColor(int n) {
        this.setExpandedTitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setExpandedTitleGravity(int n) {
        this.collapsingTextHelper.setExpandedTextGravity(n);
    }

    public void setExpandedTitleMargin(int n, int n2, int n3, int n4) {
        this.expandedMarginStart = n;
        this.expandedMarginTop = n2;
        this.expandedMarginEnd = n3;
        this.expandedMarginBottom = n4;
        this.requestLayout();
    }

    public void setExpandedTitleMarginBottom(int n) {
        this.expandedMarginBottom = n;
        this.requestLayout();
    }

    public void setExpandedTitleMarginEnd(int n) {
        this.expandedMarginEnd = n;
        this.requestLayout();
    }

    public void setExpandedTitleMarginStart(int n) {
        this.expandedMarginStart = n;
        this.requestLayout();
    }

    public void setExpandedTitleMarginTop(int n) {
        this.expandedMarginTop = n;
        this.requestLayout();
    }

    public void setExpandedTitleTextAppearance(int n) {
        this.collapsingTextHelper.setExpandedTextAppearance(n);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.collapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.collapsingTextHelper.setExpandedTypeface(typeface);
    }

    void setScrimAlpha(int n) {
        Toolbar toolbar;
        if (n == this.scrimAlpha) return;
        if (this.contentScrim != null && (toolbar = this.toolbar) != null) {
            ViewCompat.postInvalidateOnAnimation((View)toolbar);
        }
        this.scrimAlpha = n;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public void setScrimAnimationDuration(long l) {
        this.scrimAnimationDuration = l;
    }

    public void setScrimVisibleHeightTrigger(int n) {
        if (this.scrimVisibleHeightTrigger == n) return;
        this.scrimVisibleHeightTrigger = n;
        this.updateScrimVisibility();
    }

    public void setScrimsShown(boolean bl) {
        boolean bl2 = ViewCompat.isLaidOut((View)this) && !this.isInEditMode();
        this.setScrimsShown(bl, bl2);
    }

    public void setScrimsShown(boolean bl, boolean bl2) {
        if (this.scrimsAreShown == bl) return;
        int n = 255;
        if (bl2) {
            if (!bl) {
                n = 0;
            }
            this.animateScrim(n);
        } else {
            if (!bl) {
                n = 0;
            }
            this.setScrimAlpha(n);
        }
        this.scrimsAreShown = bl;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.statusBarScrim;
        if (drawable2 == drawable) return;
        Drawable drawable3 = null;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable3 = drawable.mutate();
        }
        this.statusBarScrim = drawable3;
        if (drawable3 != null) {
            if (drawable3.isStateful()) {
                this.statusBarScrim.setState(this.getDrawableState());
            }
            DrawableCompat.setLayoutDirection((Drawable)this.statusBarScrim, (int)ViewCompat.getLayoutDirection((View)this));
            drawable = this.statusBarScrim;
            boolean bl = this.getVisibility() == 0;
            drawable.setVisible(bl, false);
            this.statusBarScrim.setCallback((Drawable.Callback)this);
            this.statusBarScrim.setAlpha(this.scrimAlpha);
        }
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public void setStatusBarScrimColor(int n) {
        this.setStatusBarScrim((Drawable)new ColorDrawable(n));
    }

    public void setStatusBarScrimResource(int n) {
        this.setStatusBarScrim(ContextCompat.getDrawable((Context)this.getContext(), (int)n));
    }

    public void setTitle(CharSequence charSequence) {
        this.collapsingTextHelper.setText(charSequence);
        this.updateContentDescriptionFromTitle();
    }

    public void setTitleEnabled(boolean bl) {
        if (bl == this.collapsingTitleEnabled) return;
        this.collapsingTitleEnabled = bl;
        this.updateContentDescriptionFromTitle();
        this.updateDummyView();
        this.requestLayout();
    }

    public void setVisibility(int n) {
        super.setVisibility(n);
        boolean bl = n == 0;
        Drawable drawable = this.statusBarScrim;
        if (drawable != null && drawable.isVisible() != bl) {
            this.statusBarScrim.setVisible(bl, false);
        }
        if ((drawable = this.contentScrim) == null) return;
        if (drawable.isVisible() == bl) return;
        this.contentScrim.setVisible(bl, false);
    }

    final void updateScrimVisibility() {
        if (this.contentScrim == null) {
            if (this.statusBarScrim == null) return;
        }
        boolean bl = this.getHeight() + this.currentOffset < this.getScrimVisibleHeightTrigger();
        this.setScrimsShown(bl);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean bl = super.verifyDrawable(drawable) || drawable == this.contentScrim || drawable == this.statusBarScrim;
        return bl;
    }
}
