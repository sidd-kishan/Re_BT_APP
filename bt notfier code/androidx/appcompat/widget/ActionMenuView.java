/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.view.ContextThemeWrapper
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityEvent
 *  androidx.appcompat.view.menu.ActionMenuItemView
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuBuilder$ItemInvoker
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuPresenter
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuView$ActionMenuChildView
 *  androidx.appcompat.widget.ActionMenuView$ActionMenuPresenterCallback
 *  androidx.appcompat.widget.ActionMenuView$LayoutParams
 *  androidx.appcompat.widget.ActionMenuView$MenuBuilderCallback
 *  androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener
 *  androidx.appcompat.widget.LinearLayoutCompat
 *  androidx.appcompat.widget.ViewUtils
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.appcompat.widget.ViewUtils;

public class ActionMenuView
extends LinearLayoutCompat
implements MenuBuilder.ItemInvoker,
MenuView {
    static final int GENERATED_ITEM_PADDING = 4;
    static final int MIN_CELL_SIZE = 56;
    private static final String TAG = "ActionMenuView";
    private MenuPresenter.Callback mActionMenuPresenterCallback;
    private boolean mFormatItems;
    private int mFormatItemsWidth;
    private int mGeneratedItemPadding;
    private MenuBuilder mMenu;
    MenuBuilder.Callback mMenuBuilderCallback;
    private int mMinCellSize;
    OnMenuItemClickListener mOnMenuItemClickListener;
    private Context mPopupContext;
    private int mPopupTheme;
    private ActionMenuPresenter mPresenter;
    private boolean mReserveOverflow;

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.mMinCellSize = (int)(56.0f * f);
        this.mGeneratedItemPadding = (int)(f * 4.0f);
        this.mPopupContext = context;
        this.mPopupTheme = 0;
    }

    static int measureChildForCells(View view, int n, int n2, int n3, int n4) {
        LayoutParams layoutParams = (LayoutParams)view.getLayoutParams();
        int n5 = View.MeasureSpec.makeMeasureSpec((int)(View.MeasureSpec.getSize((int)n3) - n4), (int)View.MeasureSpec.getMode((int)n3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView)view : null;
        boolean bl = true;
        n3 = actionMenuItemView != null && actionMenuItemView.hasText() ? 1 : 0;
        n4 = 2;
        if (n2 > 0 && (n3 == 0 || n2 >= 2)) {
            int n6;
            view.measure(View.MeasureSpec.makeMeasureSpec((int)(n2 * n), (int)Integer.MIN_VALUE), n5);
            int n7 = view.getMeasuredWidth();
            n2 = n6 = n7 / n;
            if (n7 % n != 0) {
                n2 = n6 + 1;
            }
            if (n3 != 0 && n2 < 2) {
                n2 = n4;
            }
        } else {
            n2 = 0;
        }
        if (layoutParams.isOverflowButton || n3 == 0) {
            bl = false;
        }
        layoutParams.expandable = bl;
        layoutParams.cellsUsed = n2;
        view.measure(View.MeasureSpec.makeMeasureSpec((int)(n * n2), (int)0x40000000), n5);
        return n2;
    }

    /*
     * Unable to fully structure code
     */
    private void onMeasureExactFormat(int var1_1, int var2_2) {
        block36: {
            var12_3 = View.MeasureSpec.getMode((int)var2_2);
            var7_4 = View.MeasureSpec.getSize((int)var1_1);
            var6_5 = View.MeasureSpec.getSize((int)var2_2);
            var1_1 = this.getPaddingLeft();
            var5_6 = this.getPaddingRight();
            var13_7 = this.getPaddingTop() + this.getPaddingBottom();
            var19_8 = ActionMenuView.getChildMeasureSpec((int)var2_2, (int)var13_7, (int)-2);
            var14_9 = var7_4 - (var1_1 + var5_6);
            var2_2 = this.mMinCellSize;
            if ((var1_1 = var14_9 / var2_2) == 0) {
                this.setMeasuredDimension(var14_9, 0);
                return;
            }
            var21_10 = var2_2 + var14_9 % var2_2 / var1_1;
            var20_11 = this.getChildCount();
            var5_6 = 0;
            var7_4 = 0;
            var11_13 = 0;
            var10_14 = 0;
            var8_15 = 0;
            var23_16 = 0L;
            for (var9_12 = 0; var9_12 < var20_11; ++var9_12) {
                var31_20 = this.getChildAt(var9_12);
                if (var31_20.getVisibility() == 8) {
                    var2_2 = var8_15;
                } else {
                    var22_19 = var31_20 instanceof ActionMenuItemView;
                    ++var11_13;
                    if (var22_19) {
                        var2_2 = this.mGeneratedItemPadding;
                        var31_20.setPadding(var2_2, 0, var2_2, 0);
                    }
                    var32_17 = (LayoutParams)var31_20.getLayoutParams();
                    var32_17.expanded = false;
                    var32_17.extraPixels = 0;
                    var32_17.cellsUsed = 0;
                    var32_17.expandable = false;
                    var32_17.leftMargin = 0;
                    var32_17.rightMargin = 0;
                    var22_19 = var22_19 != false && ((ActionMenuItemView)var31_20).hasText() != false;
                    var32_17.preventEdgeOffset = var22_19;
                    var2_2 = var32_17.isOverflowButton != false ? 1 : var1_1;
                    var15_18 = ActionMenuView.measureChildForCells(var31_20, var21_10, var2_2, var19_8, var13_7);
                    var10_14 = Math.max(var10_14, var15_18);
                    var2_2 = var8_15;
                    if (var32_17.expandable) {
                        var2_2 = var8_15 + 1;
                    }
                    if (var32_17.isOverflowButton) {
                        var7_4 = 1;
                    }
                    var1_1 -= var15_18;
                    var5_6 = Math.max(var5_6, var31_20.getMeasuredHeight());
                    if (var15_18 == 1) {
                        var23_16 |= (long)(1 << var9_12);
                    }
                }
                var8_15 = var2_2;
            }
            var9_12 = var7_4 != 0 && var11_13 == 2 ? 1 : 0;
            var2_2 = 0;
            var13_7 = var1_1;
            var15_18 = var9_12;
            var9_12 = var14_9;
            while (true) {
                block37: {
                    if (var8_15 > 0 && var13_7 > 0) break block37;
                    var1_1 = var2_2;
                    var2_2 = var5_6;
                    ** GOTO lbl-1000
                }
                var17_22 = 0;
                var14_9 = 0x7FFFFFFF;
                var27_25 = 0L;
                for (var16_21 = 0; var16_21 < var20_11; ++var16_21) {
                    var31_20 = (LayoutParams)this.getChildAt(var16_21).getLayoutParams();
                    if (!var31_20.expandable) {
                        var1_1 = var17_22;
                        var18_23 = var14_9;
                        var25_24 = var27_25;
                    } else if (var31_20.cellsUsed < var14_9) {
                        var18_23 = var31_20.cellsUsed;
                        var25_24 = 1L << var16_21;
                        var1_1 = 1;
                    } else {
                        var1_1 = var17_22;
                        var18_23 = var14_9;
                        var25_24 = var27_25;
                        if (var31_20.cellsUsed == var14_9) {
                            var1_1 = var17_22 + 1;
                            var25_24 = var27_25 | 1L << var16_21;
                            var18_23 = var14_9;
                        }
                    }
                    var17_22 = var1_1;
                    var14_9 = var18_23;
                    var27_25 = var25_24;
                }
                var1_1 = var2_2;
                var2_2 = var5_6;
                var23_16 |= var27_25;
                if (var17_22 <= var13_7) {
                } else lbl-1000:
                // 2 sources

                {
                    var5_6 = var7_4 == 0 && var11_13 == 1 ? 1 : 0;
                    if (var13_7 > 0 && var23_16 != 0L && (var13_7 < var11_13 - 1 || var5_6 != 0 || var10_14 > 1)) {
                        var4_27 = Long.bitCount(var23_16);
                        if (var5_6 == 0) {
                            var3_28 = var4_27;
                            if ((var23_16 & 1L) != 0L) {
                                var3_28 = var4_27;
                                if (!((LayoutParams)this.getChildAt((int)0).getLayoutParams()).preventEdgeOffset) {
                                    var3_28 = var4_27 - 0.5f;
                                }
                            }
                            var5_6 = var20_11 - 1;
                            var4_27 = var3_28;
                            if ((var23_16 & (long)(1 << var5_6)) != 0L) {
                                var4_27 = var3_28;
                                if (!((LayoutParams)this.getChildAt((int)var5_6).getLayoutParams()).preventEdgeOffset) {
                                    var4_27 = var3_28 - 0.5f;
                                }
                            }
                        }
                        break;
                    }
                    var8_15 = var1_1;
                    break block36;
                }
                for (var1_1 = 0; var1_1 < var20_11; ++var1_1) {
                    var31_20 = this.getChildAt(var1_1);
                    var32_17 = (LayoutParams)var31_20.getLayoutParams();
                    var29_26 = 1 << var1_1;
                    if ((var27_25 & var29_26) == 0L) {
                        var25_24 = var23_16;
                        if (var32_17.cellsUsed == var14_9 + 1) {
                            var25_24 = var23_16 | var29_26;
                        }
                        var23_16 = var25_24;
                        continue;
                    }
                    if (var15_18 != 0 && var32_17.preventEdgeOffset && var13_7 == 1) {
                        var5_6 = this.mGeneratedItemPadding;
                        var31_20.setPadding(var5_6 + var21_10, 0, var5_6, 0);
                    }
                    ++var32_17.cellsUsed;
                    var32_17.expanded = true;
                    --var13_7;
                }
                var5_6 = var2_2;
                var2_2 = 1;
            }
            var5_6 = var4_27 > 0.0f ? (int)((float)(var13_7 * var21_10) / var4_27) : 0;
            var7_4 = 0;
            while (true) {
                block39: {
                    block40: {
                        block38: {
                            var8_15 = var1_1;
                            if (var7_4 >= var20_11) break;
                            if ((var23_16 & (long)(1 << var7_4)) != 0L) break block38;
                            var8_15 = var1_1;
                            break block39;
                        }
                        var31_20 = this.getChildAt(var7_4);
                        var32_17 = (LayoutParams)var31_20.getLayoutParams();
                        if (!(var31_20 instanceof ActionMenuItemView)) break block40;
                        var32_17.extraPixels = var5_6;
                        var32_17.expanded = true;
                        if (var7_4 == 0 && !var32_17.preventEdgeOffset) {
                            var32_17.leftMargin = -var5_6 / 2;
                        }
                        ** GOTO lbl157
                    }
                    if (var32_17.isOverflowButton) {
                        var32_17.extraPixels = var5_6;
                        var32_17.expanded = true;
                        var32_17.rightMargin = -var5_6 / 2;
lbl157:
                        // 2 sources

                        var8_15 = 1;
                    } else {
                        if (var7_4 != 0) {
                            var32_17.leftMargin = var5_6 / 2;
                        }
                        var8_15 = var1_1;
                        if (var7_4 != var20_11 - 1) {
                            var32_17.rightMargin = var5_6 / 2;
                            var8_15 = var1_1;
                        }
                    }
                }
                ++var7_4;
                var1_1 = var8_15;
            }
        }
        if (var8_15 != 0) {
            for (var1_1 = 0; var1_1 < var20_11; ++var1_1) {
                var31_20 = this.getChildAt(var1_1);
                var32_17 = (LayoutParams)var31_20.getLayoutParams();
                if (!var32_17.expanded) continue;
                var31_20.measure(View.MeasureSpec.makeMeasureSpec((int)(var32_17.cellsUsed * var21_10 + var32_17.extraPixels), (int)0x40000000), var19_8);
            }
        }
        if (var12_3 == 0x40000000) {
            var2_2 = var6_5;
        }
        this.setMeasuredDimension(var9_12, var2_2);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dismissPopupMenus() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        if (actionMenuPresenter == null) return;
        actionMenuPresenter.dismissPopupMenus();
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(this.getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) return this.generateDefaultLayoutParams();
        layoutParams = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams)layoutParams) : new LayoutParams(layoutParams);
        if (layoutParams.gravity > 0) return layoutParams;
        layoutParams.gravity = 16;
        return layoutParams;
    }

    public LayoutParams generateOverflowButtonLayoutParams() {
        LayoutParams layoutParams = this.generateDefaultLayoutParams();
        layoutParams.isOverflowButton = true;
        return layoutParams;
    }

    public Menu getMenu() {
        MenuBuilder menuBuilder;
        if (this.mMenu != null) return this.mMenu;
        Context context = this.getContext();
        this.mMenu = menuBuilder = new MenuBuilder(context);
        menuBuilder.setCallback((MenuBuilder.Callback)new MenuBuilderCallback(this));
        context = new ActionMenuPresenter(context);
        this.mPresenter = context;
        context.setReserveOverflow(true);
        menuBuilder = this.mPresenter;
        context = this.mActionMenuPresenterCallback;
        if (context == null) {
            context = new ActionMenuPresenterCallback();
        }
        menuBuilder.setCallback((MenuPresenter.Callback)context);
        this.mMenu.addMenuPresenter((MenuPresenter)this.mPresenter, this.mPopupContext);
        this.mPresenter.setMenuView(this);
        return this.mMenu;
    }

    public Drawable getOverflowIcon() {
        this.getMenu();
        return this.mPresenter.getOverflowIcon();
    }

    public int getPopupTheme() {
        return this.mPopupTheme;
    }

    public int getWindowAnimations() {
        return 0;
    }

    protected boolean hasSupportDividerBeforeChildAt(int n) {
        boolean bl = false;
        if (n == 0) {
            return false;
        }
        View view = this.getChildAt(n - 1);
        View view2 = this.getChildAt(n);
        boolean bl2 = bl;
        if (n < this.getChildCount()) {
            bl2 = bl;
            if (view instanceof ActionMenuChildView) {
                bl2 = false | ((ActionMenuChildView)view).needsDividerAfter();
            }
        }
        bl = bl2;
        if (n <= 0) return bl;
        bl = bl2;
        if (!(view2 instanceof ActionMenuChildView)) return bl;
        bl = bl2 | ((ActionMenuChildView)view2).needsDividerBefore();
        return bl;
    }

    public boolean hideOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        boolean bl = actionMenuPresenter != null && actionMenuPresenter.hideOverflowMenu();
        return bl;
    }

    public void initialize(MenuBuilder menuBuilder) {
        this.mMenu = menuBuilder;
    }

    public boolean invokeItem(MenuItemImpl menuItemImpl) {
        return this.mMenu.performItemAction((MenuItem)menuItemImpl, 0);
    }

    public boolean isOverflowMenuShowPending() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        boolean bl = actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowPending();
        return bl;
    }

    public boolean isOverflowMenuShowing() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        boolean bl = actionMenuPresenter != null && actionMenuPresenter.isOverflowMenuShowing();
        return bl;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        configuration = this.mPresenter;
        if (configuration == null) return;
        configuration.updateMenuView(false);
        if (!this.mPresenter.isOverflowMenuShowing()) return;
        this.mPresenter.hideOverflowMenu();
        this.mPresenter.showOverflowMenu();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.dismissPopupMenus();
    }

    protected void onLayout(boolean bl, int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        View view;
        View view2;
        if (!this.mFormatItems) {
            super.onLayout(bl, n, n2, n3, n4);
            return;
        }
        int n7 = this.getChildCount();
        int n8 = (n4 - n2) / 2;
        int n9 = this.getDividerWidth();
        int n10 = n3 - n;
        n = n10 - this.getPaddingRight() - this.getPaddingLeft();
        bl = ViewUtils.isLayoutRtl((View)this);
        n4 = 0;
        n3 = 0;
        for (n2 = 0; n2 < n7; ++n2) {
            view2 = this.getChildAt(n2);
            if (view2.getVisibility() == 8) continue;
            view = (LayoutParams)view2.getLayoutParams();
            if (view.isOverflowButton) {
                n4 = n6 = view2.getMeasuredWidth();
                if (this.hasSupportDividerBeforeChildAt(n2)) {
                    n4 = n6 + n9;
                }
                int n11 = view2.getMeasuredHeight();
                if (bl) {
                    n5 = this.getPaddingLeft() + view.leftMargin;
                    n6 = n5 + n4;
                } else {
                    n6 = this.getWidth() - this.getPaddingRight() - view.rightMargin;
                    n5 = n6 - n4;
                }
                int n12 = n8 - n11 / 2;
                view2.layout(n5, n12, n6, n11 + n12);
                n -= n4;
                n4 = 1;
                continue;
            }
            n -= view2.getMeasuredWidth() + view.leftMargin + view.rightMargin;
            this.hasSupportDividerBeforeChildAt(n2);
            ++n3;
        }
        if (n7 == 1 && n4 == 0) {
            view = this.getChildAt(0);
            n2 = view.getMeasuredWidth();
            n = view.getMeasuredHeight();
            n3 = n10 / 2 - n2 / 2;
            n4 = n8 - n / 2;
            view.layout(n3, n4, n2 + n3, n + n4);
            return;
        }
        n2 = n3 - (n4 ^ 1);
        n = n2 > 0 ? (n /= n2) : 0;
        n4 = Math.max(0, n);
        if (bl) {
            n3 = this.getWidth() - this.getPaddingRight();
            n = 0;
            while (n < n7) {
                view2 = this.getChildAt(n);
                view = (LayoutParams)view2.getLayoutParams();
                n2 = n3;
                if (view2.getVisibility() != 8) {
                    if (view.isOverflowButton) {
                        n2 = n3;
                    } else {
                        n2 = view2.getMeasuredWidth();
                        n5 = view2.getMeasuredHeight();
                        n6 = n8 - n5 / 2;
                        view2.layout((n3 -= view.rightMargin) - n2, n6, n3, n5 + n6);
                        n2 = n3 - (n2 + view.leftMargin + n4);
                    }
                }
                ++n;
                n3 = n2;
            }
            return;
        }
        n2 = this.getPaddingLeft();
        n = 0;
        while (n < n7) {
            view = this.getChildAt(n);
            view2 = (LayoutParams)view.getLayoutParams();
            n3 = n2;
            if (view.getVisibility() != 8) {
                if (view2.isOverflowButton) {
                    n3 = n2;
                } else {
                    n6 = n2 + view2.leftMargin;
                    n2 = view.getMeasuredWidth();
                    n3 = view.getMeasuredHeight();
                    n5 = n8 - n3 / 2;
                    view.layout(n6, n5, n6 + n2, n3 + n5);
                    n3 = n6 + (n2 + view2.rightMargin + n4);
                }
            }
            ++n;
            n2 = n3;
        }
    }

    protected void onMeasure(int n, int n2) {
        MenuBuilder menuBuilder;
        boolean bl = this.mFormatItems;
        boolean bl2 = View.MeasureSpec.getMode((int)n) == 0x40000000;
        this.mFormatItems = bl2;
        if (bl != bl2) {
            this.mFormatItemsWidth = 0;
        }
        int n3 = View.MeasureSpec.getSize((int)n);
        if (this.mFormatItems && (menuBuilder = this.mMenu) != null && n3 != this.mFormatItemsWidth) {
            this.mFormatItemsWidth = n3;
            menuBuilder.onItemsChanged(true);
        }
        int n4 = this.getChildCount();
        if (this.mFormatItems && n4 > 0) {
            this.onMeasureExactFormat(n, n2);
        } else {
            for (n3 = 0; n3 < n4; ++n3) {
                menuBuilder = (LayoutParams)this.getChildAt(n3).getLayoutParams();
                menuBuilder.rightMargin = 0;
                menuBuilder.leftMargin = 0;
            }
            super.onMeasure(n, n2);
        }
    }

    public MenuBuilder peekMenu() {
        return this.mMenu;
    }

    public void setExpandedActionViewsExclusive(boolean bl) {
        this.mPresenter.setExpandedActionViewsExclusive(bl);
    }

    public void setMenuCallbacks(MenuPresenter.Callback callback, MenuBuilder.Callback callback2) {
        this.mActionMenuPresenterCallback = callback;
        this.mMenuBuilderCallback = callback2;
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mOnMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOverflowIcon(Drawable drawable) {
        this.getMenu();
        this.mPresenter.setOverflowIcon(drawable);
    }

    public void setOverflowReserved(boolean bl) {
        this.mReserveOverflow = bl;
    }

    public void setPopupTheme(int n) {
        if (this.mPopupTheme == n) return;
        this.mPopupTheme = n;
        this.mPopupContext = n == 0 ? this.getContext() : new ContextThemeWrapper(this.getContext(), n);
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.mPresenter = actionMenuPresenter;
        actionMenuPresenter.setMenuView(this);
    }

    public boolean showOverflowMenu() {
        ActionMenuPresenter actionMenuPresenter = this.mPresenter;
        boolean bl = actionMenuPresenter != null && actionMenuPresenter.showOverflowMenu();
        return bl;
    }
}
