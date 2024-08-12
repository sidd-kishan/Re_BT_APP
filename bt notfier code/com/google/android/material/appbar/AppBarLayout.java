/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  androidx.coordinatorlayout.widget.CoordinatorLayout$DefaultBehavior
 *  androidx.core.util.ObjectsCompat
 *  androidx.core.view.OnApplyWindowInsetsListener
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.WindowInsetsCompat
 *  com.google.android.material.R$attr
 *  com.google.android.material.R$style
 *  com.google.android.material.R$styleable
 *  com.google.android.material.appbar.AppBarLayout$BaseOnOffsetChangedListener
 *  com.google.android.material.appbar.AppBarLayout$Behavior
 *  com.google.android.material.appbar.AppBarLayout$LayoutParams
 *  com.google.android.material.appbar.AppBarLayout$OnOffsetChangedListener
 *  com.google.android.material.appbar.ViewUtilsLollipop
 *  com.google.android.material.internal.ThemeEnforcement
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.ViewUtilsLollipop;
import com.google.android.material.internal.ThemeEnforcement;
import java.util.ArrayList;
import java.util.List;

@CoordinatorLayout.DefaultBehavior(value=Behavior.class)
public class AppBarLayout
extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private int downPreScrollRange = -1;
    private int downScrollRange = -1;
    private boolean haveChildWithInterpolator;
    private WindowInsetsCompat lastInsets;
    private boolean liftOnScroll;
    private boolean liftable;
    private boolean liftableOverride;
    private boolean lifted;
    private List<BaseOnOffsetChangedListener> listeners;
    private int pendingAction = 0;
    private int[] tmpStatesArray;
    private int totalScrollRange = -1;

    public AppBarLayout(Context context) {
        this(context, null);
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.setBoundsViewOutlineProvider((View)this);
            ViewUtilsLollipop.setStateListAnimatorFromAttrs((View)this, (AttributeSet)attributeSet, (int)0, (int)R.style.Widget_Design_AppBarLayout);
        }
        context = ThemeEnforcement.obtainStyledAttributes((Context)context, (AttributeSet)attributeSet, (int[])R.styleable.AppBarLayout, (int)0, (int)R.style.Widget_Design_AppBarLayout, (int[])new int[0]);
        ViewCompat.setBackground((View)this, (Drawable)context.getDrawable(R.styleable.AppBarLayout_android_background));
        if (context.hasValue(R.styleable.AppBarLayout_expanded)) {
            this.setExpanded(context.getBoolean(R.styleable.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && context.hasValue(R.styleable.AppBarLayout_elevation)) {
            ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator((View)this, (float)context.getDimensionPixelSize(R.styleable.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (context.hasValue(R.styleable.AppBarLayout_android_keyboardNavigationCluster)) {
                this.setKeyboardNavigationCluster(context.getBoolean(R.styleable.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (context.hasValue(R.styleable.AppBarLayout_android_touchscreenBlocksFocus)) {
                this.setTouchscreenBlocksFocus(context.getBoolean(R.styleable.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.liftOnScroll = context.getBoolean(R.styleable.AppBarLayout_liftOnScroll, false);
        context.recycle();
        ViewCompat.setOnApplyWindowInsetsListener((View)this, (OnApplyWindowInsetsListener)new /* Unavailable Anonymous Inner Class!! */);
    }

    private boolean hasCollapsibleChild() {
        int n = this.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            if (((LayoutParams)this.getChildAt(n2).getLayoutParams()).isCollapsible()) {
                return true;
            }
            ++n2;
        }
        return false;
    }

    private void invalidateScrollRanges() {
        this.totalScrollRange = -1;
        this.downPreScrollRange = -1;
        this.downScrollRange = -1;
    }

    private void setExpanded(boolean bl, boolean bl2, boolean bl3) {
        int n = bl ? 1 : 2;
        int n2 = 0;
        int n3 = bl2 ? 4 : 0;
        if (bl3) {
            n2 = 8;
        }
        this.pendingAction = n | n3 | n2;
        this.requestLayout();
    }

    private boolean setLiftableState(boolean bl) {
        if (this.liftable == bl) return false;
        this.liftable = bl;
        this.refreshDrawableState();
        return true;
    }

    public void addOnOffsetChangedListener(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        if (this.listeners == null) {
            this.listeners = new ArrayList<BaseOnOffsetChangedListener>();
        }
        if (baseOnOffsetChangedListener == null) return;
        if (this.listeners.contains(baseOnOffsetChangedListener)) return;
        this.listeners.add(baseOnOffsetChangedListener);
    }

    public void addOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        this.addOnOffsetChangedListener((BaseOnOffsetChangedListener)onOffsetChangedListener);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void dispatchOffsetUpdates(int n) {
        BaseOnOffsetChangedListener baseOnOffsetChangedListener = this.listeners;
        if (baseOnOffsetChangedListener == null) return;
        int n2 = 0;
        int n3 = baseOnOffsetChangedListener.size();
        while (n2 < n3) {
            baseOnOffsetChangedListener = this.listeners.get(n2);
            if (baseOnOffsetChangedListener != null) {
                baseOnOffsetChangedListener.onOffsetChanged(this, n);
            }
            ++n2;
        }
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && layoutParams instanceof LinearLayout.LayoutParams) {
            return new LayoutParams((LinearLayout.LayoutParams)layoutParams);
        }
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) return new LayoutParams(layoutParams);
        return new LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
    }

    int getDownNestedPreScrollRange() {
        int n = this.downPreScrollRange;
        if (n != -1) {
            return n;
        }
        int n2 = 0;
        for (int i = this.getChildCount() - 1; i >= 0; --i) {
            View view = this.getChildAt(i);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n3 = view.getMeasuredHeight();
            n = layoutParams.scrollFlags;
            if ((n & 5) == 5) {
                n2 += layoutParams.topMargin + layoutParams.bottomMargin;
                if ((n & 8) != 0) {
                    n = n2 + ViewCompat.getMinimumHeight((View)view);
                } else {
                    n = (n & 2) != 0 ? ViewCompat.getMinimumHeight((View)view) : this.getTopInset();
                    n = n2 + (n3 - n);
                }
            } else {
                n = n2;
                if (n2 > 0) break;
            }
            n2 = n;
        }
        this.downPreScrollRange = n = Math.max(0, n2);
        return n;
    }

    int getDownNestedScrollRange() {
        int n;
        int n2 = this.downScrollRange;
        if (n2 != -1) {
            return n2;
        }
        int n3 = this.getChildCount();
        int n4 = 0;
        n2 = 0;
        while (true) {
            n = n2;
            if (n4 >= n3) break;
            View view = this.getChildAt(n4);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n5 = view.getMeasuredHeight();
            int n6 = layoutParams.topMargin;
            int n7 = layoutParams.bottomMargin;
            int n8 = layoutParams.scrollFlags;
            n = n2;
            if ((n8 & 1) == 0) break;
            n2 += n5 + (n6 + n7);
            if ((n8 & 2) != 0) {
                n = n2 - (ViewCompat.getMinimumHeight((View)view) + this.getTopInset());
                break;
            }
            ++n4;
        }
        this.downScrollRange = n2 = Math.max(0, n);
        return n2;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int n = this.getTopInset();
        int n2 = ViewCompat.getMinimumHeight((View)this);
        if (n2 != 0) return n2 * 2 + n;
        n2 = this.getChildCount();
        n2 = n2 >= 1 ? ViewCompat.getMinimumHeight((View)this.getChildAt(n2 - 1)) : 0;
        if (n2 == 0) return this.getHeight() / 3;
        return n2 * 2 + n;
    }

    int getPendingAction() {
        return this.pendingAction;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.lastInsets;
        int n = windowInsetsCompat != null ? windowInsetsCompat.getSystemWindowInsetTop() : 0;
        return n;
    }

    public final int getTotalScrollRange() {
        int n;
        int n2 = this.totalScrollRange;
        if (n2 != -1) {
            return n2;
        }
        int n3 = this.getChildCount();
        int n4 = 0;
        n2 = 0;
        while (true) {
            n = n2;
            if (n4 >= n3) break;
            View view = this.getChildAt(n4);
            LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
            int n5 = view.getMeasuredHeight();
            int n6 = layoutParams.scrollFlags;
            n = n2;
            if ((n6 & 1) == 0) break;
            n2 += n5 + layoutParams.topMargin + layoutParams.bottomMargin;
            if ((n6 & 2) != 0) {
                n = n2 - ViewCompat.getMinimumHeight((View)view);
                break;
            }
            ++n4;
        }
        this.totalScrollRange = n2 = Math.max(0, n - this.getTopInset());
        return n2;
    }

    int getUpNestedPreScrollRange() {
        return this.getTotalScrollRange();
    }

    boolean hasChildWithInterpolator() {
        return this.haveChildWithInterpolator;
    }

    boolean hasScrollableChildren() {
        boolean bl = this.getTotalScrollRange() != 0;
        return bl;
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    protected int[] onCreateDrawableState(int n) {
        if (this.tmpStatesArray == null) {
            this.tmpStatesArray = new int[4];
        }
        int[] nArray = this.tmpStatesArray;
        int[] nArray2 = super.onCreateDrawableState(n + nArray.length);
        n = this.liftable ? R.attr.state_liftable : -R.attr.state_liftable;
        nArray[0] = n;
        n = this.liftable && this.lifted ? R.attr.state_lifted : -R.attr.state_lifted;
        nArray[1] = n;
        n = this.liftable ? R.attr.state_collapsible : -R.attr.state_collapsible;
        nArray[2] = n;
        n = this.liftable && this.lifted ? R.attr.state_collapsed : -R.attr.state_collapsed;
        nArray[3] = n;
        return AppBarLayout.mergeDrawableStates((int[])nArray2, (int[])nArray);
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        super.onLayout(bl, n, n2, n3, n4);
        this.invalidateScrollRanges();
        bl = false;
        this.haveChildWithInterpolator = false;
        n2 = this.getChildCount();
        for (n = 0; n < n2; ++n) {
            if (((LayoutParams)this.getChildAt(n).getLayoutParams()).getScrollInterpolator() == null) continue;
            this.haveChildWithInterpolator = true;
            break;
        }
        if (this.liftableOverride) return;
        if (this.liftOnScroll || this.hasCollapsibleChild()) {
            bl = true;
        }
        this.setLiftableState(bl);
    }

    protected void onMeasure(int n, int n2) {
        super.onMeasure(n, n2);
        this.invalidateScrollRanges();
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        Object object = ViewCompat.getFitsSystemWindows((View)this) ? windowInsetsCompat : null;
        if (ObjectsCompat.equals((Object)this.lastInsets, (Object)object)) return windowInsetsCompat;
        this.lastInsets = object;
        this.invalidateScrollRanges();
        return windowInsetsCompat;
    }

    public void removeOnOffsetChangedListener(BaseOnOffsetChangedListener baseOnOffsetChangedListener) {
        List<BaseOnOffsetChangedListener> list = this.listeners;
        if (list == null) return;
        if (baseOnOffsetChangedListener == null) return;
        list.remove(baseOnOffsetChangedListener);
    }

    public void removeOnOffsetChangedListener(OnOffsetChangedListener onOffsetChangedListener) {
        this.removeOnOffsetChangedListener((BaseOnOffsetChangedListener)onOffsetChangedListener);
    }

    void resetPendingAction() {
        this.pendingAction = 0;
    }

    public void setExpanded(boolean bl) {
        this.setExpanded(bl, ViewCompat.isLaidOut((View)this));
    }

    public void setExpanded(boolean bl, boolean bl2) {
        this.setExpanded(bl, bl2, true);
    }

    public void setLiftOnScroll(boolean bl) {
        this.liftOnScroll = bl;
    }

    public boolean setLiftable(boolean bl) {
        this.liftableOverride = true;
        return this.setLiftableState(bl);
    }

    public boolean setLifted(boolean bl) {
        return this.setLiftedState(bl);
    }

    boolean setLiftedState(boolean bl) {
        if (this.lifted == bl) return false;
        this.lifted = bl;
        this.refreshDrawableState();
        return true;
    }

    public void setOrientation(int n) {
        if (n != 1) throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        super.setOrientation(n);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT < 21) return;
        ViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator((View)this, (float)f);
    }
}
