/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.AnimatorListenerAdapter
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.TypedArray
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.os.Parcelable
 *  android.util.SparseArray
 *  android.view.Menu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewPropertyAnimator
 *  android.view.Window$Callback
 *  android.view.WindowInsets
 *  android.widget.OverScroller
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.R$id
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.widget.ActionBarContainer
 *  androidx.appcompat.widget.ActionBarOverlayLayout$ActionBarVisibilityCallback
 *  androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams
 *  androidx.appcompat.widget.ContentFrameLayout
 *  androidx.appcompat.widget.DecorContentParent
 *  androidx.appcompat.widget.DecorToolbar
 *  androidx.appcompat.widget.Toolbar
 *  androidx.appcompat.widget.ViewUtils
 *  androidx.core.graphics.Insets
 *  androidx.core.view.NestedScrollingParent
 *  androidx.core.view.NestedScrollingParent2
 *  androidx.core.view.NestedScrollingParent3
 *  androidx.core.view.NestedScrollingParentHelper
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  androidx.core.view.WindowInsetsCompat$Builder
 */
package androidx.appcompat.widget;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.OverScroller;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.appcompat.widget.ActionBarOverlayLayout;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.DecorContentParent;
import androidx.appcompat.widget.DecorToolbar;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewUtils;
import androidx.core.graphics.Insets;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParent2;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActionBarOverlayLayout
extends ViewGroup
implements DecorContentParent,
NestedScrollingParent,
NestedScrollingParent2,
NestedScrollingParent3 {
    private static final int ACTION_BAR_ANIMATE_DELAY = 600;
    static final int[] ATTRS = new int[]{R.attr.actionBarSize, 16842841};
    private static final String TAG = "ActionBarOverlayLayout";
    private int mActionBarHeight;
    ActionBarContainer mActionBarTop;
    private ActionBarVisibilityCallback mActionBarVisibilityCallback;
    private final Runnable mAddActionBarHideOffset;
    boolean mAnimatingForFling;
    private final Rect mBaseContentInsets = new Rect();
    private WindowInsetsCompat mBaseInnerInsets;
    private final Rect mBaseInnerInsetsRect;
    private ContentFrameLayout mContent;
    private final Rect mContentInsets;
    ViewPropertyAnimator mCurrentActionBarTopAnimator;
    private DecorToolbar mDecorToolbar;
    private OverScroller mFlingEstimator;
    private boolean mHasNonEmbeddedTabs;
    private boolean mHideOnContentScroll;
    private int mHideOnContentScrollReference;
    private boolean mIgnoreWindowContentOverlay;
    private WindowInsetsCompat mInnerInsets;
    private final Rect mInnerInsetsRect;
    private final Rect mLastBaseContentInsets = new Rect();
    private WindowInsetsCompat mLastBaseInnerInsets;
    private final Rect mLastBaseInnerInsetsRect;
    private WindowInsetsCompat mLastInnerInsets;
    private final Rect mLastInnerInsetsRect;
    private int mLastSystemUiVisibility;
    private boolean mOverlayMode;
    private final NestedScrollingParentHelper mParentHelper;
    private final Runnable mRemoveActionBarHideOffset;
    final AnimatorListenerAdapter mTopAnimatorListener;
    private Drawable mWindowContentOverlay;
    private int mWindowVisibility = 0;

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContentInsets = new Rect();
        this.mBaseInnerInsetsRect = new Rect();
        this.mLastBaseInnerInsetsRect = new Rect();
        this.mInnerInsetsRect = new Rect();
        this.mLastInnerInsetsRect = new Rect();
        this.mBaseInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mLastBaseInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mLastInnerInsets = WindowInsetsCompat.CONSUMED;
        this.mTopAnimatorListener = new /* Unavailable Anonymous Inner Class!! */;
        this.mRemoveActionBarHideOffset = new /* Unavailable Anonymous Inner Class!! */;
        this.mAddActionBarHideOffset = new /* Unavailable Anonymous Inner Class!! */;
        this.init(context);
        this.mParentHelper = new NestedScrollingParentHelper((ViewGroup)this);
    }

    private void addActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mAddActionBarHideOffset.run();
    }

    private boolean applyInsets(View view, Rect rect, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        boolean bl5;
        view = (LayoutParams)view.getLayoutParams();
        boolean bl6 = true;
        if (bl && view.leftMargin != rect.left) {
            view.leftMargin = rect.left;
            bl5 = true;
        } else {
            bl5 = false;
        }
        bl = bl5;
        if (bl2) {
            bl = bl5;
            if (view.topMargin != rect.top) {
                view.topMargin = rect.top;
                bl = true;
            }
        }
        bl2 = bl;
        if (bl4) {
            bl2 = bl;
            if (view.rightMargin != rect.right) {
                view.rightMargin = rect.right;
                bl2 = true;
            }
        }
        if (bl3 && view.bottomMargin != rect.bottom) {
            view.bottomMargin = rect.bottom;
            bl = bl6;
        } else {
            bl = bl2;
        }
        return bl;
    }

    private DecorToolbar getDecorToolbar(View view) {
        if (view instanceof DecorToolbar) {
            return (DecorToolbar)view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar)view).getWrapper();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Can't make a decor toolbar out of ");
        stringBuilder.append(view.getClass().getSimpleName());
        throw new IllegalStateException(stringBuilder.toString());
    }

    private void init(Context context) {
        Drawable drawable;
        TypedArray typedArray = this.getContext().getTheme().obtainStyledAttributes(ATTRS);
        boolean bl = false;
        this.mActionBarHeight = typedArray.getDimensionPixelSize(0, 0);
        this.mWindowContentOverlay = drawable = typedArray.getDrawable(1);
        boolean bl2 = drawable == null;
        this.setWillNotDraw(bl2);
        typedArray.recycle();
        bl2 = bl;
        if (context.getApplicationInfo().targetSdkVersion < 19) {
            bl2 = true;
        }
        this.mIgnoreWindowContentOverlay = bl2;
        this.mFlingEstimator = new OverScroller(context);
    }

    private void postAddActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(this.mAddActionBarHideOffset, 600L);
    }

    private void postRemoveActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.postDelayed(this.mRemoveActionBarHideOffset, 600L);
    }

    private void removeActionBarHideOffset() {
        this.haltActionBarHideOffsetAnimations();
        this.mRemoveActionBarHideOffset.run();
    }

    private boolean shouldHideActionBarOnFling(float f) {
        this.mFlingEstimator.fling(0, 0, 0, (int)f, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        boolean bl = this.mFlingEstimator.getFinalY() > this.mActionBarTop.getHeight();
        return bl;
    }

    public boolean canShowOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.canShowOverflowMenu();
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopups() {
        this.pullChildren();
        this.mDecorToolbar.dismissPopupMenus();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.mWindowContentOverlay == null) return;
        if (this.mIgnoreWindowContentOverlay) return;
        int n = this.mActionBarTop.getVisibility() == 0 ? (int)((float)this.mActionBarTop.getBottom() + this.mActionBarTop.getTranslationY() + 0.5f) : 0;
        this.mWindowContentOverlay.setBounds(0, n, this.getWidth(), this.mWindowContentOverlay.getIntrinsicHeight() + n);
        this.mWindowContentOverlay.draw(canvas);
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            return super.fitSystemWindows(rect);
        }
        this.pullChildren();
        boolean bl = this.applyInsets((View)this.mActionBarTop, rect, true, true, false, true);
        this.mBaseInnerInsetsRect.set(rect);
        ViewUtils.computeFitSystemWindows((View)this, (Rect)this.mBaseInnerInsetsRect, (Rect)this.mBaseContentInsets);
        if (!this.mLastBaseInnerInsetsRect.equals((Object)this.mBaseInnerInsetsRect)) {
            this.mLastBaseInnerInsetsRect.set(this.mBaseInnerInsetsRect);
            bl = true;
        }
        if (!this.mLastBaseContentInsets.equals((Object)this.mBaseContentInsets)) {
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
            bl = true;
        }
        if (!bl) return true;
        this.requestLayout();
        return true;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    public int getActionBarHideOffset() {
        ActionBarContainer actionBarContainer = this.mActionBarTop;
        int n = actionBarContainer != null ? -((int)actionBarContainer.getTranslationY()) : 0;
        return n;
    }

    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    public CharSequence getTitle() {
        this.pullChildren();
        return this.mDecorToolbar.getTitle();
    }

    void haltActionBarHideOffsetAnimations() {
        this.removeCallbacks(this.mRemoveActionBarHideOffset);
        this.removeCallbacks(this.mAddActionBarHideOffset);
        ViewPropertyAnimator viewPropertyAnimator = this.mCurrentActionBarTopAnimator;
        if (viewPropertyAnimator == null) return;
        viewPropertyAnimator.cancel();
    }

    public boolean hasIcon() {
        this.pullChildren();
        return this.mDecorToolbar.hasIcon();
    }

    public boolean hasLogo() {
        this.pullChildren();
        return this.mDecorToolbar.hasLogo();
    }

    public boolean hideOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.hideOverflowMenu();
    }

    public void initFeature(int n) {
        this.pullChildren();
        if (n != 2) {
            if (n != 5) {
                if (n != 109) return;
                this.setOverlayMode(true);
            } else {
                this.mDecorToolbar.initIndeterminateProgress();
            }
        } else {
            this.mDecorToolbar.initProgress();
        }
    }

    public boolean isHideOnContentScrollEnabled() {
        return this.mHideOnContentScroll;
    }

    public boolean isInOverlayMode() {
        return this.mOverlayMode;
    }

    public boolean isOverflowMenuShowPending() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowPending();
    }

    public boolean isOverflowMenuShowing() {
        this.pullChildren();
        return this.mDecorToolbar.isOverflowMenuShowing();
    }

    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        this.pullChildren();
        windowInsets = WindowInsetsCompat.toWindowInsetsCompat((WindowInsets)windowInsets, (View)this);
        Rect rect = new Rect(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        boolean bl = this.applyInsets((View)this.mActionBarTop, rect, true, true, false, true);
        ViewCompat.computeSystemWindowInsets((View)this, (WindowInsetsCompat)windowInsets, (Rect)this.mBaseContentInsets);
        rect = windowInsets.inset(this.mBaseContentInsets.left, this.mBaseContentInsets.top, this.mBaseContentInsets.right, this.mBaseContentInsets.bottom);
        this.mBaseInnerInsets = rect;
        boolean bl2 = this.mLastBaseInnerInsets.equals((Object)rect);
        boolean bl3 = true;
        if (!bl2) {
            this.mLastBaseInnerInsets = this.mBaseInnerInsets;
            bl = true;
        }
        if (!this.mLastBaseContentInsets.equals((Object)this.mBaseContentInsets)) {
            this.mLastBaseContentInsets.set(this.mBaseContentInsets);
            bl = bl3;
        }
        if (!bl) return windowInsets.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
        this.requestLayout();
        return windowInsets.consumeDisplayCutout().consumeSystemWindowInsets().consumeStableInsets().toWindowInsets();
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.init(this.getContext());
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.haltActionBarHideOffsetAnimations();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        n4 = this.getChildCount();
        n2 = this.getPaddingLeft();
        n3 = this.getPaddingTop();
        n = 0;
        while (n < n4) {
            View view = this.getChildAt(n);
            if (view.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
                int n5 = view.getMeasuredWidth();
                int n6 = view.getMeasuredHeight();
                int n7 = layoutParams.leftMargin + n2;
                int n8 = layoutParams.topMargin + n3;
                view.layout(n7, n8, n5 + n7, n6 + n8);
            }
            ++n;
        }
    }

    protected void onMeasure(int n, int n2) {
        int n3;
        int n4;
        this.pullChildren();
        this.measureChildWithMargins((View)this.mActionBarTop, n, 0, n2, 0);
        LayoutParams layoutParams = (LayoutParams)this.mActionBarTop.getLayoutParams();
        int n5 = Math.max(0, this.mActionBarTop.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        int n6 = Math.max(0, this.mActionBarTop.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        int n7 = View.combineMeasuredStates((int)0, (int)this.mActionBarTop.getMeasuredState());
        int n8 = (ViewCompat.getWindowSystemUiVisibility((View)this) & 0x100) != 0 ? 1 : 0;
        if (n8 != 0) {
            n3 = n4 = this.mActionBarHeight;
            if (this.mHasNonEmbeddedTabs) {
                n3 = n4;
                if (this.mActionBarTop.getTabContainer() != null) {
                    n3 = n4 + this.mActionBarHeight;
                }
            }
        } else {
            n3 = this.mActionBarTop.getVisibility() != 8 ? this.mActionBarTop.getMeasuredHeight() : 0;
        }
        this.mContentInsets.set(this.mBaseContentInsets);
        if (Build.VERSION.SDK_INT >= 21) {
            this.mInnerInsets = this.mBaseInnerInsets;
        } else {
            this.mInnerInsetsRect.set(this.mBaseInnerInsetsRect);
        }
        if (!this.mOverlayMode && n8 == 0) {
            layoutParams = this.mContentInsets;
            layoutParams.top += n3;
            layoutParams = this.mContentInsets;
            layoutParams.bottom += 0;
            if (Build.VERSION.SDK_INT >= 21) {
                this.mInnerInsets = this.mInnerInsets.inset(0, n3, 0, 0);
            }
        } else if (Build.VERSION.SDK_INT >= 21) {
            layoutParams = Insets.of((int)this.mInnerInsets.getSystemWindowInsetLeft(), (int)(this.mInnerInsets.getSystemWindowInsetTop() + n3), (int)this.mInnerInsets.getSystemWindowInsetRight(), (int)(this.mInnerInsets.getSystemWindowInsetBottom() + 0));
            this.mInnerInsets = new WindowInsetsCompat.Builder(this.mInnerInsets).setSystemWindowInsets((Insets)layoutParams).build();
        } else {
            layoutParams = this.mInnerInsetsRect;
            layoutParams.top += n3;
            layoutParams = this.mInnerInsetsRect;
            layoutParams.bottom += 0;
        }
        this.applyInsets((View)this.mContent, this.mContentInsets, true, true, true, true);
        if (Build.VERSION.SDK_INT >= 21 && !this.mLastInnerInsets.equals((Object)this.mInnerInsets)) {
            layoutParams = this.mInnerInsets;
            this.mLastInnerInsets = layoutParams;
            ViewCompat.dispatchApplyWindowInsets((View)this.mContent, (WindowInsetsCompat)layoutParams);
        } else if (Build.VERSION.SDK_INT < 21 && !this.mLastInnerInsetsRect.equals((Object)this.mInnerInsetsRect)) {
            this.mLastInnerInsetsRect.set(this.mInnerInsetsRect);
            this.mContent.dispatchFitSystemWindows(this.mInnerInsetsRect);
        }
        this.measureChildWithMargins((View)this.mContent, n, 0, n2, 0);
        layoutParams = (LayoutParams)this.mContent.getLayoutParams();
        n3 = Math.max(n5, this.mContent.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
        n6 = Math.max(n6, this.mContent.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin);
        n4 = View.combineMeasuredStates((int)n7, (int)this.mContent.getMeasuredState());
        n7 = this.getPaddingLeft();
        n8 = this.getPaddingRight();
        n6 = Math.max(n6 + (this.getPaddingTop() + this.getPaddingBottom()), this.getSuggestedMinimumHeight());
        this.setMeasuredDimension(View.resolveSizeAndState((int)Math.max(n3 + (n7 + n8), this.getSuggestedMinimumWidth()), (int)n, (int)n4), View.resolveSizeAndState((int)n6, (int)n2, (int)(n4 << 16)));
    }

    public boolean onNestedFling(View view, float f, float f2, boolean bl) {
        if (!this.mHideOnContentScroll) return false;
        if (!bl) {
            return false;
        }
        if (this.shouldHideActionBarOnFling(f2)) {
            this.addActionBarHideOffset();
        } else {
            this.removeActionBarHideOffset();
        }
        this.mAnimatingForFling = true;
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray) {
    }

    public void onNestedPreScroll(View view, int n, int n2, int[] nArray, int n3) {
        if (n3 != 0) return;
        this.onNestedPreScroll(view, n, n2, nArray);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4) {
        this.mHideOnContentScrollReference = n = this.mHideOnContentScrollReference + n2;
        this.setActionBarHideOffset(n);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5) {
        if (n5 != 0) return;
        this.onNestedScroll(view, n, n2, n3, n4);
    }

    public void onNestedScroll(View view, int n, int n2, int n3, int n4, int n5, int[] nArray) {
        this.onNestedScroll(view, n, n2, n3, n4, n5);
    }

    public void onNestedScrollAccepted(View view, View view2, int n) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, n);
        this.mHideOnContentScrollReference = this.getActionBarHideOffset();
        this.haltActionBarHideOffsetAnimations();
        view = this.mActionBarVisibilityCallback;
        if (view == null) return;
        view.onContentScrollStarted();
    }

    public void onNestedScrollAccepted(View view, View view2, int n, int n2) {
        if (n2 != 0) return;
        this.onNestedScrollAccepted(view, view2, n);
    }

    public boolean onStartNestedScroll(View view, View view2, int n) {
        if ((n & 2) == 0) return false;
        if (this.mActionBarTop.getVisibility() == 0) return this.mHideOnContentScroll;
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int n, int n2) {
        boolean bl = n2 == 0 && this.onStartNestedScroll(view, view2, n);
        return bl;
    }

    public void onStopNestedScroll(View view) {
        if (this.mHideOnContentScroll && !this.mAnimatingForFling) {
            if (this.mHideOnContentScrollReference <= this.mActionBarTop.getHeight()) {
                this.postRemoveActionBarHideOffset();
            } else {
                this.postAddActionBarHideOffset();
            }
        }
        if ((view = this.mActionBarVisibilityCallback) == null) return;
        view.onContentScrollStopped();
    }

    public void onStopNestedScroll(View view, int n) {
        if (n != 0) return;
        this.onStopNestedScroll(view);
    }

    @Deprecated
    public void onWindowSystemUiVisibilityChanged(int n) {
        ActionBarVisibilityCallback actionBarVisibilityCallback;
        if (Build.VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(n);
        }
        this.pullChildren();
        int n2 = this.mLastSystemUiVisibility;
        this.mLastSystemUiVisibility = n;
        boolean bl = false;
        boolean bl2 = (n & 4) == 0;
        if ((n & 0x100) != 0) {
            bl = true;
        }
        if ((actionBarVisibilityCallback = this.mActionBarVisibilityCallback) != null) {
            actionBarVisibilityCallback.enableContentAnimations(bl ^ true);
            if (!bl2 && bl) {
                this.mActionBarVisibilityCallback.hideForSystem();
            } else {
                this.mActionBarVisibilityCallback.showForSystem();
            }
        }
        if (((n2 ^ n) & 0x100) == 0) return;
        if (this.mActionBarVisibilityCallback == null) return;
        ViewCompat.requestApplyInsets((View)this);
    }

    protected void onWindowVisibilityChanged(int n) {
        super.onWindowVisibilityChanged(n);
        this.mWindowVisibility = n;
        ActionBarVisibilityCallback actionBarVisibilityCallback = this.mActionBarVisibilityCallback;
        if (actionBarVisibilityCallback == null) return;
        actionBarVisibilityCallback.onWindowVisibilityChanged(n);
    }

    void pullChildren() {
        if (this.mContent != null) return;
        this.mContent = (ContentFrameLayout)this.findViewById(R.id.action_bar_activity_content);
        this.mActionBarTop = (ActionBarContainer)this.findViewById(R.id.action_bar_container);
        this.mDecorToolbar = this.getDecorToolbar(this.findViewById(R.id.action_bar));
    }

    public void restoreToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.pullChildren();
        this.mDecorToolbar.restoreHierarchyState(sparseArray);
    }

    public void saveToolbarHierarchyState(SparseArray<Parcelable> sparseArray) {
        this.pullChildren();
        this.mDecorToolbar.saveHierarchyState(sparseArray);
    }

    public void setActionBarHideOffset(int n) {
        this.haltActionBarHideOffsetAnimations();
        n = Math.max(0, Math.min(n, this.mActionBarTop.getHeight()));
        this.mActionBarTop.setTranslationY((float)(-n));
    }

    public void setActionBarVisibilityCallback(ActionBarVisibilityCallback actionBarVisibilityCallback) {
        this.mActionBarVisibilityCallback = actionBarVisibilityCallback;
        if (this.getWindowToken() == null) return;
        this.mActionBarVisibilityCallback.onWindowVisibilityChanged(this.mWindowVisibility);
        int n = this.mLastSystemUiVisibility;
        if (n == 0) return;
        this.onWindowSystemUiVisibilityChanged(n);
        ViewCompat.requestApplyInsets((View)this);
    }

    public void setHasNonEmbeddedTabs(boolean bl) {
        this.mHasNonEmbeddedTabs = bl;
    }

    public void setHideOnContentScrollEnabled(boolean bl) {
        if (bl == this.mHideOnContentScroll) return;
        this.mHideOnContentScroll = bl;
        if (bl) return;
        this.haltActionBarHideOffsetAnimations();
        this.setActionBarHideOffset(0);
    }

    public void setIcon(int n) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(n);
    }

    public void setIcon(Drawable drawable) {
        this.pullChildren();
        this.mDecorToolbar.setIcon(drawable);
    }

    public void setLogo(int n) {
        this.pullChildren();
        this.mDecorToolbar.setLogo(n);
    }

    public void setMenu(Menu menu, MenuPresenter.Callback callback) {
        this.pullChildren();
        this.mDecorToolbar.setMenu(menu, callback);
    }

    public void setMenuPrepared() {
        this.pullChildren();
        this.mDecorToolbar.setMenuPrepared();
    }

    public void setOverlayMode(boolean bl) {
        this.mOverlayMode = bl;
        bl = bl && this.getContext().getApplicationInfo().targetSdkVersion < 19;
        this.mIgnoreWindowContentOverlay = bl;
    }

    public void setShowingForActionMode(boolean bl) {
    }

    public void setUiOptions(int n) {
    }

    public void setWindowCallback(Window.Callback callback) {
        this.pullChildren();
        this.mDecorToolbar.setWindowCallback(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        this.pullChildren();
        this.mDecorToolbar.setWindowTitle(charSequence);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean showOverflowMenu() {
        this.pullChildren();
        return this.mDecorToolbar.showOverflowMenu();
    }
}
