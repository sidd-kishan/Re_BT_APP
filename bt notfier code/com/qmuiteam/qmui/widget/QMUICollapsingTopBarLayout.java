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
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  androidx.core.content.ContextCompat
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.appbar.AppBarLayout
 *  com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener
 *  com.qmuiteam.qmui.QMUIInterpolatorStaticHolder
 *  com.qmuiteam.qmui.R$id
 *  com.qmuiteam.qmui.R$style
 *  com.qmuiteam.qmui.R$styleable
 *  com.qmuiteam.qmui.util.QMUICollapsingTextHelper
 *  com.qmuiteam.qmui.util.QMUILangHelper
 *  com.qmuiteam.qmui.util.QMUIViewHelper
 *  com.qmuiteam.qmui.util.QMUIViewOffsetHelper
 *  com.qmuiteam.qmui.widget.IWindowInsetLayout
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout$LayoutParams
 *  com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout$OffsetUpdateListener
 *  com.qmuiteam.qmui.widget.QMUITopBar
 */
package com.qmuiteam.qmui.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.AppBarLayout;
import com.qmuiteam.qmui.QMUIInterpolatorStaticHolder;
import com.qmuiteam.qmui.R;
import com.qmuiteam.qmui.util.QMUICollapsingTextHelper;
import com.qmuiteam.qmui.util.QMUILangHelper;
import com.qmuiteam.qmui.util.QMUIViewHelper;
import com.qmuiteam.qmui.util.QMUIViewOffsetHelper;
import com.qmuiteam.qmui.widget.IWindowInsetLayout;
import com.qmuiteam.qmui.widget.QMUICollapsingTopBarLayout;
import com.qmuiteam.qmui.widget.QMUITopBar;

public class QMUICollapsingTopBarLayout
extends FrameLayout
implements IWindowInsetLayout {
    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    final QMUICollapsingTextHelper mCollapsingTextHelper;
    private boolean mCollapsingTitleEnabled;
    private Drawable mContentScrim;
    int mCurrentOffset;
    private int mExpandedMarginBottom;
    private int mExpandedMarginEnd;
    private int mExpandedMarginStart;
    private int mExpandedMarginTop;
    Object mLastInsets;
    private AppBarLayout.OnOffsetChangedListener mOnOffsetChangedListener;
    private boolean mRefreshToolbar = true;
    private int mScrimAlpha;
    private long mScrimAnimationDuration;
    private ValueAnimator mScrimAnimator;
    private ValueAnimator.AnimatorUpdateListener mScrimUpdateListener;
    private int mScrimVisibleHeightTrigger = -1;
    private boolean mScrimsAreShown;
    Drawable mStatusBarScrim;
    private final Rect mTmpRect = new Rect();
    private QMUITopBar mTopBar;
    private View mTopBarDirectChild;
    private int mTopBarId;

    public QMUICollapsingTopBarLayout(Context context) {
        this(context, null);
    }

    public QMUICollapsingTopBarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QMUICollapsingTopBarLayout(Context context, AttributeSet attributeSet, int n) {
        super(context, attributeSet, n);
        QMUICollapsingTextHelper qMUICollapsingTextHelper;
        this.mCollapsingTextHelper = qMUICollapsingTextHelper = new QMUICollapsingTextHelper((View)this);
        qMUICollapsingTextHelper.setTextSizeInterpolator(QMUIInterpolatorStaticHolder.DECELERATE_INTERPOLATOR);
        QMUIViewHelper.checkAppCompatTheme((Context)context);
        context = context.obtainStyledAttributes(attributeSet, R.styleable.QMUICollapsingTopBarLayout, n, 0);
        this.mCollapsingTextHelper.setExpandedTextGravity(context.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleGravity, 81));
        this.mCollapsingTextHelper.setCollapsedTextGravity(context.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleGravity, 8388627));
        this.mExpandedMarginBottom = n = context.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMargin, 0);
        this.mExpandedMarginEnd = n;
        this.mExpandedMarginTop = n;
        this.mExpandedMarginStart = n;
        if (context.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart)) {
            this.mExpandedMarginStart = context.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginStart, 0);
        }
        if (context.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd)) {
            this.mExpandedMarginEnd = context.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginEnd, 0);
        }
        if (context.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop)) {
            this.mExpandedMarginTop = context.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginTop, 0);
        }
        if (context.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom)) {
            this.mExpandedMarginBottom = context.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleMarginBottom, 0);
        }
        this.mCollapsingTitleEnabled = context.getBoolean(R.styleable.QMUICollapsingTopBarLayout_qmui_titleEnabled, true);
        this.setTitle(context.getText(R.styleable.QMUICollapsingTopBarLayout_qmui_title));
        this.mCollapsingTextHelper.setExpandedTextAppearance(R.style.QMUI_CollapsingTopBarLayoutExpanded);
        this.mCollapsingTextHelper.setCollapsedTextAppearance(R.style.QMUI_CollapsingTopBarLayoutCollapsed);
        if (context.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance)) {
            this.mCollapsingTextHelper.setExpandedTextAppearance(context.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_expandedTitleTextAppearance, 0));
        }
        if (context.hasValue(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance)) {
            this.mCollapsingTextHelper.setCollapsedTextAppearance(context.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_collapsedTitleTextAppearance, 0));
        }
        this.mScrimVisibleHeightTrigger = context.getDimensionPixelSize(R.styleable.QMUICollapsingTopBarLayout_qmui_scrimVisibleHeightTrigger, -1);
        this.mScrimAnimationDuration = context.getInt(R.styleable.QMUICollapsingTopBarLayout_qmui_scrimAnimationDuration, 600);
        this.setContentScrim(context.getDrawable(R.styleable.QMUICollapsingTopBarLayout_qmui_contentScrim));
        this.setStatusBarScrim(context.getDrawable(R.styleable.QMUICollapsingTopBarLayout_qmui_statusBarScrim));
        this.mTopBarId = context.getResourceId(R.styleable.QMUICollapsingTopBarLayout_qmui_topBarId, -1);
        context.recycle();
        this.setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    static /* synthetic */ WindowInsetsCompat access$000(QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout, WindowInsetsCompat windowInsetsCompat) {
        return qMUICollapsingTopBarLayout.setWindowInsets(windowInsetsCompat);
    }

    static /* synthetic */ int access$100(QMUICollapsingTopBarLayout qMUICollapsingTopBarLayout) {
        return qMUICollapsingTopBarLayout.getWindowInsetTop();
    }

    private void animateScrim(int n) {
        this.ensureToolbar();
        ValueAnimator valueAnimator = this.mScrimAnimator;
        if (valueAnimator == null) {
            this.mScrimAnimator = valueAnimator = new ValueAnimator();
            valueAnimator.setDuration(this.mScrimAnimationDuration);
            ValueAnimator valueAnimator2 = this.mScrimAnimator;
            valueAnimator = n > this.mScrimAlpha ? QMUIInterpolatorStaticHolder.FAST_OUT_LINEAR_IN_INTERPOLATOR : QMUIInterpolatorStaticHolder.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            valueAnimator2.setInterpolator((TimeInterpolator)valueAnimator);
            this.mScrimAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)new /* Unavailable Anonymous Inner Class!! */);
            valueAnimator = this.mScrimUpdateListener;
            if (valueAnimator != null) {
                this.mScrimAnimator.addUpdateListener((ValueAnimator.AnimatorUpdateListener)valueAnimator);
            }
        } else if (valueAnimator.isRunning()) {
            this.mScrimAnimator.cancel();
        }
        this.mScrimAnimator.setIntValues(new int[]{this.mScrimAlpha, n});
        this.mScrimAnimator.start();
    }

    private void ensureToolbar() {
        QMUITopBar qMUITopBar;
        if (!this.mRefreshToolbar) {
            return;
        }
        Object var4_1 = null;
        this.mTopBar = null;
        this.mTopBarDirectChild = null;
        int n = this.mTopBarId;
        if (n != -1) {
            this.mTopBar = qMUITopBar = (QMUITopBar)this.findViewById(n);
            if (qMUITopBar != null) {
                this.mTopBarDirectChild = this.findDirectChild((View)qMUITopBar);
            }
        }
        if (this.mTopBar == null) {
            int n2 = this.getChildCount();
            n = 0;
            while (true) {
                qMUITopBar = var4_1;
                if (n >= n2 || (qMUITopBar = this.getChildAt(n)) instanceof QMUITopBar) break;
                ++n;
            }
            this.mTopBar = qMUITopBar;
        }
        this.mRefreshToolbar = false;
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

    static QMUIViewOffsetHelper getViewOffsetHelper(View view) {
        QMUIViewOffsetHelper qMUIViewOffsetHelper;
        QMUIViewOffsetHelper qMUIViewOffsetHelper2 = qMUIViewOffsetHelper = (QMUIViewOffsetHelper)view.getTag(R.id.qmui_view_offset_helper);
        if (qMUIViewOffsetHelper != null) return qMUIViewOffsetHelper2;
        qMUIViewOffsetHelper2 = new QMUIViewOffsetHelper(view);
        view.setTag(R.id.qmui_view_offset_helper, (Object)qMUIViewOffsetHelper2);
        return qMUIViewOffsetHelper2;
    }

    private int getWindowInsetTop() {
        Object object = this.mLastInsets;
        if (object == null) return 0;
        if (object instanceof WindowInsetsCompat) {
            return ((WindowInsetsCompat)object).getSystemWindowInsetTop();
        }
        if (!(object instanceof Rect)) return 0;
        return ((Rect)object).top;
    }

    private boolean isToolbarChild(View view) {
        View view2 = this.mTopBarDirectChild;
        boolean bl = true;
        if (view2 != null && view2 != this ? view == view2 : view == this.mTopBar) return bl;
        bl = false;
        return bl;
    }

    private WindowInsetsCompat setWindowInsets(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = windowInsetsCompat;
        if (Build.VERSION.SDK_INT < 21) return windowInsetsCompat2;
        windowInsetsCompat2 = windowInsetsCompat;
        if (!this.applySystemWindowInsets21(windowInsetsCompat)) return windowInsetsCompat2;
        windowInsetsCompat2 = windowInsetsCompat.consumeSystemWindowInsets();
        return windowInsetsCompat2;
    }

    public boolean applySystemWindowInsets19(Rect rect) {
        if (!ViewCompat.getFitsSystemWindows((View)this)) {
            rect = null;
        }
        if (QMUILangHelper.objectEquals((Object)this.mLastInsets, (Object)rect)) return true;
        this.mLastInsets = rect;
        this.requestLayout();
        return true;
    }

    public boolean applySystemWindowInsets21(Object object) {
        if (!ViewCompat.getFitsSystemWindows((View)this)) {
            object = null;
        }
        if (QMUILangHelper.objectEquals((Object)this.mLastInsets, (Object)object)) return true;
        this.mLastInsets = object;
        this.requestLayout();
        return true;
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        this.ensureToolbar();
        if (this.mTopBar == null && (drawable = this.mContentScrim) != null && this.mScrimAlpha > 0) {
            drawable.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
        }
        if (this.mCollapsingTitleEnabled) {
            this.mCollapsingTextHelper.draw(canvas);
        }
        if (this.mStatusBarScrim == null) return;
        if (this.mScrimAlpha <= 0) return;
        int n = this.getWindowInsetTop();
        if (n <= 0) return;
        this.mStatusBarScrim.setBounds(0, -this.mCurrentOffset, this.getWidth(), n - this.mCurrentOffset);
        this.mStatusBarScrim.mutate().setAlpha(this.mScrimAlpha);
        this.mStatusBarScrim.draw(canvas);
    }

    protected boolean drawChild(Canvas canvas, View view, long l) {
        boolean bl;
        Drawable drawable = this.mContentScrim;
        boolean bl2 = true;
        if (drawable != null && this.mScrimAlpha > 0 && this.isToolbarChild(view)) {
            this.mContentScrim.mutate().setAlpha(this.mScrimAlpha);
            this.mContentScrim.draw(canvas);
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
        Drawable drawable = this.mStatusBarScrim;
        boolean bl2 = bl = false;
        if (drawable != null) {
            bl2 = bl;
            if (drawable.isStateful()) {
                bl2 = false | drawable.setState(nArray);
            }
        }
        drawable = this.mContentScrim;
        bl = bl2;
        if (drawable != null) {
            bl = bl2;
            if (drawable.isStateful()) {
                bl = bl2 | drawable.setState(nArray);
            }
        }
        drawable = this.mCollapsingTextHelper;
        bl2 = bl;
        if (drawable != null) {
            bl2 = bl | drawable.setState(nArray);
        }
        if (!bl2) return;
        this.invalidate();
    }

    protected boolean fitSystemWindows(Rect rect) {
        return this.applySystemWindowInsets19(rect);
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
        return this.mCollapsingTextHelper.getCollapsedTextGravity();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.mCollapsingTextHelper.getCollapsedTypeface();
    }

    public Drawable getContentScrim() {
        return this.mContentScrim;
    }

    public int getExpandedTitleGravity() {
        return this.mCollapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.mExpandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.mExpandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.mExpandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.mExpandedMarginTop;
    }

    public Typeface getExpandedTitleTypeface() {
        return this.mCollapsingTextHelper.getExpandedTypeface();
    }

    final int getMaxOffsetForPinChild(View view, boolean bl) {
        int n = view.getTop();
        if (!bl) {
            n = QMUICollapsingTopBarLayout.getViewOffsetHelper(view).getLayoutTop();
        }
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        return this.getHeight() - n - view.getHeight() - layoutParams.bottomMargin;
    }

    int getScrimAlpha() {
        return this.mScrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.mScrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int n = this.mScrimVisibleHeightTrigger;
        if (n >= 0) {
            return n;
        }
        n = this.getWindowInsetTop();
        int n2 = ViewCompat.getMinimumHeight((View)this);
        if (n2 <= 0) return this.getHeight() / 3;
        return Math.min(n2 * 2 + n, this.getHeight());
    }

    public Drawable getStatusBarScrim() {
        return this.mStatusBarScrim;
    }

    public CharSequence getTitle() {
        CharSequence charSequence = this.mCollapsingTitleEnabled ? this.mCollapsingTextHelper.getText() : null;
        return charSequence;
    }

    public boolean isTitleEnabled() {
        return this.mCollapsingTitleEnabled;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent viewParent = this.getParent();
        if (!(viewParent instanceof AppBarLayout)) return;
        ViewCompat.setFitsSystemWindows((View)this, (boolean)ViewCompat.getFitsSystemWindows((View)((View)viewParent)));
        if (this.mOnOffsetChangedListener == null) {
            this.mOnOffsetChangedListener = new OffsetUpdateListener(this);
        }
        ((AppBarLayout)viewParent).addOnOffsetChangedListener(this.mOnOffsetChangedListener);
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onDetachedFromWindow() {
        ViewParent viewParent = this.getParent();
        AppBarLayout.OnOffsetChangedListener onOffsetChangedListener = this.mOnOffsetChangedListener;
        if (onOffsetChangedListener != null && viewParent instanceof AppBarLayout) {
            ((AppBarLayout)viewParent).removeOnOffsetChangedListener(onOffsetChangedListener);
        }
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5;
        super.onLayout(bl, n, n2, n3, n4);
        Object object = this.mLastInsets;
        int n6 = 0;
        if (object != null) {
            int n7 = this.getWindowInsetTop();
            int n8 = this.getChildCount();
            for (n5 = 0; n5 < n8; ++n5) {
                object = this.getChildAt(n5);
                if (!ViewCompat.getFitsSystemWindows((View)object) || object.getTop() >= n7) continue;
                ViewCompat.offsetTopAndBottom((View)object, (int)n7);
            }
        }
        if (this.mCollapsingTitleEnabled) {
            object = this.mTopBarDirectChild;
            if (object == null) {
                object = this.mTopBar;
            }
            n5 = this.getMaxOffsetForPinChild((View)object, true);
            QMUIViewHelper.getDescendantRect((ViewGroup)this, (View)this.mTopBar, (Rect)this.mTmpRect);
            object = this.mTopBar.getTitleContainerRect();
            this.mCollapsingTextHelper.setCollapsedBounds(this.mTmpRect.left + ((Rect)object).left, this.mTmpRect.top + n5 + ((Rect)object).top, this.mTmpRect.left + ((Rect)object).right, this.mTmpRect.top + n5 + ((Rect)object).bottom);
            this.mCollapsingTextHelper.setExpandedBounds(this.mExpandedMarginStart, this.mTmpRect.top + this.mExpandedMarginTop, n3 - n - this.mExpandedMarginEnd, n4 - n2 - this.mExpandedMarginBottom);
            this.mCollapsingTextHelper.recalculate();
        }
        n2 = this.getChildCount();
        for (n = n6; n < n2; ++n) {
            QMUICollapsingTopBarLayout.getViewOffsetHelper(this.getChildAt(n)).onViewLayout();
        }
        if (this.mTopBar != null) {
            if (this.mCollapsingTitleEnabled && TextUtils.isEmpty((CharSequence)this.mCollapsingTextHelper.getText())) {
                this.mCollapsingTextHelper.setText(this.mTopBar.getTitle());
            }
            if ((object = this.mTopBarDirectChild) != null && object != this) {
                this.setMinimumHeight(QMUICollapsingTopBarLayout.getHeightWithMargins((View)object));
            } else {
                this.setMinimumHeight(QMUICollapsingTopBarLayout.getHeightWithMargins((View)this.mTopBar));
            }
        }
        this.updateScrimVisibility();
    }

    protected void onMeasure(int n, int n2) {
        this.ensureToolbar();
        super.onMeasure(n, n2);
    }

    protected void onSizeChanged(int n, int n2, int n3, int n4) {
        super.onSizeChanged(n, n2, n3, n4);
        Drawable drawable = this.mContentScrim;
        if (drawable == null) return;
        drawable.setBounds(0, 0, n, n2);
    }

    public void setCollapsedTitleGravity(int n) {
        this.mCollapsingTextHelper.setCollapsedTextGravity(n);
    }

    public void setCollapsedTitleTextAppearance(int n) {
        this.mCollapsingTextHelper.setCollapsedTextAppearance(n);
    }

    public void setCollapsedTitleTextColor(int n) {
        this.setCollapsedTitleTextColor(ColorStateList.valueOf((int)n));
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.mCollapsingTextHelper.setCollapsedTextColor(colorStateList);
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setCollapsedTypeface(typeface);
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.mContentScrim;
        if (drawable2 == drawable) return;
        Drawable drawable3 = null;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable3 = drawable.mutate();
        }
        this.mContentScrim = drawable3;
        if (drawable3 != null) {
            drawable3.setBounds(0, 0, this.getWidth(), this.getHeight());
            this.mContentScrim.setCallback((Drawable.Callback)this);
            this.mContentScrim.setAlpha(this.mScrimAlpha);
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
        this.mCollapsingTextHelper.setExpandedTextGravity(n);
    }

    public void setExpandedTitleMargin(int n, int n2, int n3, int n4) {
        this.mExpandedMarginStart = n;
        this.mExpandedMarginTop = n2;
        this.mExpandedMarginEnd = n3;
        this.mExpandedMarginBottom = n4;
        this.requestLayout();
    }

    public void setExpandedTitleMarginBottom(int n) {
        this.mExpandedMarginBottom = n;
        this.requestLayout();
    }

    public void setExpandedTitleMarginEnd(int n) {
        this.mExpandedMarginEnd = n;
        this.requestLayout();
    }

    public void setExpandedTitleMarginStart(int n) {
        this.mExpandedMarginStart = n;
        this.requestLayout();
    }

    public void setExpandedTitleMarginTop(int n) {
        this.mExpandedMarginTop = n;
        this.requestLayout();
    }

    public void setExpandedTitleTextAppearance(int n) {
        this.mCollapsingTextHelper.setExpandedTextAppearance(n);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        this.mCollapsingTextHelper.setExpandedTextColor(colorStateList);
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        this.mCollapsingTextHelper.setExpandedTypeface(typeface);
    }

    void setScrimAlpha(int n) {
        QMUITopBar qMUITopBar;
        if (n == this.mScrimAlpha) return;
        if (this.mContentScrim != null && (qMUITopBar = this.mTopBar) != null) {
            ViewCompat.postInvalidateOnAnimation((View)qMUITopBar);
        }
        this.mScrimAlpha = n;
        ViewCompat.postInvalidateOnAnimation((View)this);
    }

    public void setScrimAnimationDuration(long l) {
        this.mScrimAnimationDuration = l;
    }

    public void setScrimUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        ValueAnimator.AnimatorUpdateListener animatorUpdateListener2 = this.mScrimUpdateListener;
        if (animatorUpdateListener2 == animatorUpdateListener) return;
        ValueAnimator valueAnimator = this.mScrimAnimator;
        if (valueAnimator == null) {
            this.mScrimUpdateListener = animatorUpdateListener;
        } else {
            if (animatorUpdateListener2 != null) {
                valueAnimator.removeUpdateListener(animatorUpdateListener2);
            }
            this.mScrimUpdateListener = animatorUpdateListener;
            if (animatorUpdateListener == null) return;
            this.mScrimAnimator.addUpdateListener(animatorUpdateListener);
        }
    }

    public void setScrimVisibleHeightTrigger(int n) {
        if (this.mScrimVisibleHeightTrigger == n) return;
        this.mScrimVisibleHeightTrigger = n;
        this.updateScrimVisibility();
    }

    public void setScrimsShown(boolean bl) {
        boolean bl2 = ViewCompat.isLaidOut((View)this) && !this.isInEditMode();
        this.setScrimsShown(bl, bl2);
    }

    public void setScrimsShown(boolean bl, boolean bl2) {
        if (this.mScrimsAreShown == bl) return;
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
        this.mScrimsAreShown = bl;
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.mStatusBarScrim;
        if (drawable2 == drawable) return;
        Drawable drawable3 = null;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        if (drawable != null) {
            drawable3 = drawable.mutate();
        }
        this.mStatusBarScrim = drawable3;
        if (drawable3 != null) {
            if (drawable3.isStateful()) {
                this.mStatusBarScrim.setState(this.getDrawableState());
            }
            DrawableCompat.setLayoutDirection((Drawable)this.mStatusBarScrim, (int)ViewCompat.getLayoutDirection((View)this));
            drawable = this.mStatusBarScrim;
            boolean bl = this.getVisibility() == 0;
            drawable.setVisible(bl, false);
            this.mStatusBarScrim.setCallback((Drawable.Callback)this);
            this.mStatusBarScrim.setAlpha(this.mScrimAlpha);
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
        this.mCollapsingTextHelper.setText(charSequence);
    }

    public void setTitleEnabled(boolean bl) {
        if (bl == this.mCollapsingTitleEnabled) return;
        this.mCollapsingTitleEnabled = bl;
        this.requestLayout();
    }

    public void setVisibility(int n) {
        super.setVisibility(n);
        boolean bl = n == 0;
        Drawable drawable = this.mStatusBarScrim;
        if (drawable != null && drawable.isVisible() != bl) {
            this.mStatusBarScrim.setVisible(bl, false);
        }
        if ((drawable = this.mContentScrim) == null) return;
        if (drawable.isVisible() == bl) return;
        this.mContentScrim.setVisible(bl, false);
    }

    final void updateScrimVisibility() {
        if (this.mContentScrim == null) {
            if (this.mStatusBarScrim == null) return;
        }
        boolean bl = this.getHeight() + this.mCurrentOffset < this.getScrimVisibleHeightTrigger();
        this.setScrimsShown(bl);
    }

    protected boolean verifyDrawable(Drawable drawable) {
        boolean bl = super.verifyDrawable(drawable) || drawable == this.mContentScrim || drawable == this.mStatusBarScrim;
        return bl;
    }
}
