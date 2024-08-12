/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.graphics.drawable.Drawable
 *  android.os.Parcelable
 *  android.util.SparseBooleanArray
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  androidx.appcompat.R$layout
 *  androidx.appcompat.view.ActionBarPolicy
 *  androidx.appcompat.view.menu.ActionMenuItemView
 *  androidx.appcompat.view.menu.ActionMenuItemView$PopupCallback
 *  androidx.appcompat.view.menu.BaseMenuPresenter
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$ItemInvoker
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuView
 *  androidx.appcompat.view.menu.MenuView$ItemView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.ActionMenuPresenter$ActionButtonSubmenu
 *  androidx.appcompat.widget.ActionMenuPresenter$ActionMenuPopupCallback
 *  androidx.appcompat.widget.ActionMenuPresenter$OpenOverflowRunnable
 *  androidx.appcompat.widget.ActionMenuPresenter$OverflowMenuButton
 *  androidx.appcompat.widget.ActionMenuPresenter$OverflowPopup
 *  androidx.appcompat.widget.ActionMenuPresenter$PopupPresenterCallback
 *  androidx.appcompat.widget.ActionMenuPresenter$SavedState
 *  androidx.appcompat.widget.ActionMenuView
 *  androidx.core.view.ActionProvider$SubUiVisibilityListener
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.BaseMenuPresenter;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionMenuPresenter;
import androidx.appcompat.widget.ActionMenuView;
import androidx.core.view.ActionProvider;
import java.util.ArrayList;

class ActionMenuPresenter
extends BaseMenuPresenter
implements ActionProvider.SubUiVisibilityListener {
    private static final String TAG = "ActionMenuPresenter";
    private final SparseBooleanArray mActionButtonGroups = new SparseBooleanArray();
    ActionButtonSubmenu mActionButtonPopup;
    private int mActionItemWidthLimit;
    private boolean mExpandedActionViewsExclusive;
    private int mMaxItems;
    private boolean mMaxItemsSet;
    private int mMinCellSize;
    int mOpenSubMenuId;
    OverflowMenuButton mOverflowButton;
    OverflowPopup mOverflowPopup;
    private Drawable mPendingOverflowIcon;
    private boolean mPendingOverflowIconSet;
    private ActionMenuPopupCallback mPopupCallback;
    final PopupPresenterCallback mPopupPresenterCallback = new PopupPresenterCallback(this);
    OpenOverflowRunnable mPostedOpenRunnable;
    private boolean mReserveOverflow;
    private boolean mReserveOverflowSet;
    private boolean mStrictWidthLimit;
    private int mWidthLimit;
    private boolean mWidthLimitSet;

    public ActionMenuPresenter(Context context) {
        super(context, R.layout.abc_action_menu_layout, R.layout.abc_action_menu_item_layout);
    }

    static /* synthetic */ MenuBuilder access$000(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    static /* synthetic */ MenuBuilder access$100(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    static /* synthetic */ MenuView access$200(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenuView;
    }

    static /* synthetic */ MenuBuilder access$300(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    static /* synthetic */ MenuBuilder access$400(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    static /* synthetic */ MenuBuilder access$500(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenu;
    }

    static /* synthetic */ MenuView access$600(ActionMenuPresenter actionMenuPresenter) {
        return actionMenuPresenter.mMenuView;
    }

    private View findViewForItem(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup)this.mMenuView;
        if (viewGroup == null) {
            return null;
        }
        int n = viewGroup.getChildCount();
        int n2 = 0;
        while (n2 < n) {
            View view = viewGroup.getChildAt(n2);
            if (view instanceof MenuView.ItemView && ((MenuView.ItemView)view).getItemData() == menuItem) {
                return view;
            }
            ++n2;
        }
        return null;
    }

    public void bindItemView(MenuItemImpl menuItemImpl, MenuView.ItemView itemView) {
        itemView.initialize(menuItemImpl, 0);
        menuItemImpl = (ActionMenuView)this.mMenuView;
        itemView = (ActionMenuItemView)itemView;
        itemView.setItemInvoker((MenuBuilder.ItemInvoker)menuItemImpl);
        if (this.mPopupCallback == null) {
            this.mPopupCallback = new ActionMenuPopupCallback(this);
        }
        itemView.setPopupCallback((ActionMenuItemView.PopupCallback)this.mPopupCallback);
    }

    public boolean dismissPopupMenus() {
        return this.hideOverflowMenu() | this.hideSubMenus();
    }

    public boolean filterLeftoverView(ViewGroup viewGroup, int n) {
        if (viewGroup.getChildAt(n) != this.mOverflowButton) return super.filterLeftoverView(viewGroup, n);
        return false;
    }

    /*
     * Unable to fully structure code
     */
    public boolean flagActionItems() {
        block34: {
            block35: {
                if (this.mMenu != null) {
                    var17_1 = this.mMenu.getVisibleItems();
                    var4_2 = var17_1.size();
                } else {
                    var17_1 = null;
                    var4_2 = 0;
                }
                var1_3 = this.mMaxItems;
                var10_4 = this.mActionItemWidthLimit;
                var11_5 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                var18_6 = (ViewGroup)this.mMenuView;
                var6_8 = 0;
                var3_9 = 0;
                var5_10 = 0;
                for (var2_7 = 0; var2_7 < var4_2; ++var2_7) {
                    var19_12 = (MenuItemImpl)var17_1.get(var2_7);
                    if (var19_12.requiresActionButton()) {
                        ++var3_9;
                    } else if (var19_12.requestsActionButton()) {
                        ++var5_10;
                    } else {
                        var6_8 = 1;
                    }
                    var7_11 = var1_3;
                    if (this.mExpandedActionViewsExclusive) {
                        var7_11 = var1_3;
                        if (var19_12.isActionViewExpanded()) {
                            var7_11 = 0;
                        }
                    }
                    var1_3 = var7_11;
                }
                var2_7 = var1_3;
                if (!this.mReserveOverflow) break block34;
                if (var6_8 != 0) break block35;
                var2_7 = var1_3;
                if (var5_10 + var3_9 <= var1_3) break block34;
            }
            var2_7 = var1_3 - 1;
        }
        var1_3 = var2_7 - var3_9;
        var19_12 = this.mActionButtonGroups;
        var19_12.clear();
        if (this.mStrictWidthLimit) {
            var2_7 = this.mMinCellSize;
            var3_9 = var10_4 / var2_7;
            var8_13 = var2_7 + var10_4 % var2_7 / var3_9;
        } else {
            var8_13 = 0;
            var3_9 = 0;
        }
        var9_14 = 0;
        var2_7 = 0;
        var6_8 = var10_4;
        var10_4 = var4_2;
        while (var9_14 < var10_4) {
            block36: {
                var20_20 = (MenuItemImpl)var17_1.get(var9_14);
                if (!var20_20.requiresActionButton()) break block36;
                var21_21 = this.getItemView(var20_20, null, var18_6);
                if (this.mStrictWidthLimit) {
                    var3_9 -= ActionMenuView.measureChildForCells((View)var21_21, (int)var8_13, (int)var3_9, (int)var11_5, (int)0);
                } else {
                    var21_21.measure(var11_5, var11_5);
                }
                var5_10 = var21_21.getMeasuredWidth();
                var7_11 = var6_8 - var5_10;
                var4_2 = var2_7;
                if (var2_7 == 0) {
                    var4_2 = var5_10;
                }
                if ((var2_7 = var20_20.getGroupId()) != 0) {
                    var19_12.put(var2_7, true);
                }
                var20_20.setIsActionButton(true);
                ** GOTO lbl123
            }
            if (var20_20.requestsActionButton()) {
                var12_15 = var20_20.getGroupId();
                var16_19 = var19_12.get(var12_15);
                var13_16 = !(var1_3 <= 0 && var16_19 == false || var6_8 <= 0 || this.mStrictWidthLimit != false && var3_9 <= 0) ? 1 : 0;
                var15_18 = var13_16;
                var14_17 = var13_16;
                var7_11 = var6_8;
                var5_10 = var3_9;
                var4_2 = var2_7;
                if (var13_16 != 0) {
                    var21_21 = this.getItemView(var20_20, null, var18_6);
                    if (this.mStrictWidthLimit) {
                        var5_10 = ActionMenuView.measureChildForCells((View)var21_21, (int)var8_13, (int)var3_9, (int)var11_5, (int)0);
                        var3_9 = var4_2 = var3_9 - var5_10;
                        if (var5_10 == 0) {
                            var15_18 = 0;
                            var3_9 = var4_2;
                        }
                    } else {
                        var21_21.measure(var11_5, var11_5);
                    }
                    var5_10 = var21_21.getMeasuredWidth();
                    var7_11 = var6_8 - var5_10;
                    var4_2 = var2_7;
                    if (var2_7 == 0) {
                        var4_2 = var5_10;
                    }
                    var2_7 = (this.mStrictWidthLimit != false ? var7_11 >= 0 : var7_11 + var4_2 > 0) ? 1 : 0;
                    var14_17 = var15_18 & var2_7;
                    var5_10 = var3_9;
                }
                if (var14_17 != 0 && var12_15 != 0) {
                    var19_12.put(var12_15, true);
                    var2_7 = var1_3;
                } else {
                    var2_7 = var1_3;
                    if (var16_19) {
                        var19_12.put(var12_15, false);
                        var3_9 = 0;
                        while (true) {
                            var2_7 = var1_3;
                            if (var3_9 >= var9_14) break;
                            var21_21 = (MenuItemImpl)var17_1.get(var3_9);
                            var2_7 = var1_3;
                            if (var21_21.getGroupId() == var12_15) {
                                var2_7 = var1_3;
                                if (var21_21.isActionButton()) {
                                    var2_7 = var1_3 + 1;
                                }
                                var21_21.setIsActionButton(false);
                            }
                            ++var3_9;
                            var1_3 = var2_7;
                        }
                    }
                }
                var1_3 = var2_7;
                if (var14_17 != 0) {
                    var1_3 = var2_7 - 1;
                }
                var20_20.setIsActionButton((boolean)var14_17);
                var3_9 = var5_10;
lbl123:
                // 2 sources

                var6_8 = var7_11;
                var2_7 = var4_2;
            } else {
                var20_20.setIsActionButton(false);
            }
            ++var9_14;
        }
        return true;
    }

    public View getItemView(MenuItemImpl menuItemImpl, View view, ViewGroup viewGroup) {
        View view2 = menuItemImpl.getActionView();
        if (view2 == null || menuItemImpl.hasCollapsibleActionView()) {
            view2 = super.getItemView(menuItemImpl, view, viewGroup);
        }
        int n = menuItemImpl.isActionViewExpanded() ? 8 : 0;
        view2.setVisibility(n);
        menuItemImpl = (ActionMenuView)viewGroup;
        view = view2.getLayoutParams();
        if (menuItemImpl.checkLayoutParams((ViewGroup.LayoutParams)view)) return view2;
        view2.setLayoutParams((ViewGroup.LayoutParams)menuItemImpl.generateLayoutParams((ViewGroup.LayoutParams)view));
        return view2;
    }

    public MenuView getMenuView(ViewGroup viewGroup) {
        MenuView menuView = this.mMenuView;
        if (menuView == (viewGroup = super.getMenuView(viewGroup))) return viewGroup;
        ((ActionMenuView)viewGroup).setPresenter(this);
        return viewGroup;
    }

    public Drawable getOverflowIcon() {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            return overflowMenuButton.getDrawable();
        }
        if (!this.mPendingOverflowIconSet) return null;
        return this.mPendingOverflowIcon;
    }

    public boolean hideOverflowMenu() {
        if (this.mPostedOpenRunnable != null && this.mMenuView != null) {
            ((View)this.mMenuView).removeCallbacks((Runnable)this.mPostedOpenRunnable);
            this.mPostedOpenRunnable = null;
            return true;
        }
        OverflowPopup overflowPopup = this.mOverflowPopup;
        if (overflowPopup == null) return false;
        overflowPopup.dismiss();
        return true;
    }

    public boolean hideSubMenus() {
        ActionButtonSubmenu actionButtonSubmenu = this.mActionButtonPopup;
        if (actionButtonSubmenu == null) return false;
        actionButtonSubmenu.dismiss();
        return true;
    }

    public void initForMenu(Context context, MenuBuilder menuBuilder) {
        super.initForMenu(context, menuBuilder);
        menuBuilder = context.getResources();
        context = ActionBarPolicy.get((Context)context);
        if (!this.mReserveOverflowSet) {
            this.mReserveOverflow = context.showsOverflowMenuButton();
        }
        if (!this.mWidthLimitSet) {
            this.mWidthLimit = context.getEmbeddedMenuWidthLimit();
        }
        if (!this.mMaxItemsSet) {
            this.mMaxItems = context.getMaxActionButtons();
        }
        int n = this.mWidthLimit;
        if (this.mReserveOverflow) {
            if (this.mOverflowButton == null) {
                context = new OverflowMenuButton(this, this.mSystemContext);
                this.mOverflowButton = context;
                if (this.mPendingOverflowIconSet) {
                    context.setImageDrawable(this.mPendingOverflowIcon);
                    this.mPendingOverflowIcon = null;
                    this.mPendingOverflowIconSet = false;
                }
                int n2 = View.MeasureSpec.makeMeasureSpec((int)0, (int)0);
                this.mOverflowButton.measure(n2, n2);
            }
            n -= this.mOverflowButton.getMeasuredWidth();
        } else {
            this.mOverflowButton = null;
        }
        this.mActionItemWidthLimit = n;
        this.mMinCellSize = (int)(menuBuilder.getDisplayMetrics().density * 56.0f);
    }

    public boolean isOverflowMenuShowPending() {
        boolean bl = this.mPostedOpenRunnable != null || this.isOverflowMenuShowing();
        return bl;
    }

    public boolean isOverflowMenuShowing() {
        OverflowPopup overflowPopup = this.mOverflowPopup;
        boolean bl = overflowPopup != null && overflowPopup.isShowing();
        return bl;
    }

    public boolean isOverflowReserved() {
        return this.mReserveOverflow;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
        this.dismissPopupMenus();
        super.onCloseMenu(menuBuilder, bl);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (!this.mMaxItemsSet) {
            this.mMaxItems = ActionBarPolicy.get((Context)this.mContext).getMaxActionButtons();
        }
        if (this.mMenu == null) return;
        this.mMenu.onItemsChanged(true);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            return;
        }
        parcelable = (SavedState)parcelable;
        if (parcelable.openSubMenuId <= 0) return;
        parcelable = this.mMenu.findItem(parcelable.openSubMenuId);
        if (parcelable == null) return;
        this.onSubMenuSelected((SubMenuBuilder)parcelable.getSubMenu());
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState();
        savedState.openSubMenuId = this.mOpenSubMenuId;
        return savedState;
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        boolean bl = subMenuBuilder.hasVisibleItems();
        boolean bl2 = false;
        if (!bl) {
            return false;
        }
        SubMenuBuilder subMenuBuilder2 = subMenuBuilder;
        while (subMenuBuilder2.getParentMenu() != this.mMenu) {
            subMenuBuilder2 = (SubMenuBuilder)subMenuBuilder2.getParentMenu();
        }
        if ((subMenuBuilder2 = this.findViewForItem(subMenuBuilder2.getItem())) == null) {
            return false;
        }
        this.mOpenSubMenuId = subMenuBuilder.getItem().getItemId();
        int n = subMenuBuilder.size();
        int n2 = 0;
        while (true) {
            bl = bl2;
            if (n2 >= n) break;
            MenuItem menuItem = subMenuBuilder.getItem(n2);
            if (menuItem.isVisible() && menuItem.getIcon() != null) {
                bl = true;
                break;
            }
            ++n2;
        }
        subMenuBuilder2 = new ActionButtonSubmenu(this, this.mContext, subMenuBuilder, (View)subMenuBuilder2);
        this.mActionButtonPopup = subMenuBuilder2;
        subMenuBuilder2.setForceShowIcon(bl);
        this.mActionButtonPopup.show();
        super.onSubMenuSelected(subMenuBuilder);
        return true;
    }

    public void onSubUiVisibilityChanged(boolean bl) {
        if (bl) {
            super.onSubMenuSelected(null);
        } else {
            if (this.mMenu == null) return;
            this.mMenu.close(false);
        }
    }

    public void setExpandedActionViewsExclusive(boolean bl) {
        this.mExpandedActionViewsExclusive = bl;
    }

    public void setItemLimit(int n) {
        this.mMaxItems = n;
        this.mMaxItemsSet = true;
    }

    public void setMenuView(ActionMenuView actionMenuView) {
        this.mMenuView = actionMenuView;
        actionMenuView.initialize(this.mMenu);
    }

    public void setOverflowIcon(Drawable drawable) {
        OverflowMenuButton overflowMenuButton = this.mOverflowButton;
        if (overflowMenuButton != null) {
            overflowMenuButton.setImageDrawable(drawable);
        } else {
            this.mPendingOverflowIconSet = true;
            this.mPendingOverflowIcon = drawable;
        }
    }

    public void setReserveOverflow(boolean bl) {
        this.mReserveOverflow = bl;
        this.mReserveOverflowSet = true;
    }

    public void setWidthLimit(int n, boolean bl) {
        this.mWidthLimit = n;
        this.mStrictWidthLimit = bl;
        this.mWidthLimitSet = true;
    }

    public boolean shouldIncludeItem(int n, MenuItemImpl menuItemImpl) {
        return menuItemImpl.isActionButton();
    }

    public boolean showOverflowMenu() {
        if (!this.mReserveOverflow) return false;
        if (this.isOverflowMenuShowing()) return false;
        if (this.mMenu == null) return false;
        if (this.mMenuView == null) return false;
        if (this.mPostedOpenRunnable != null) return false;
        if (this.mMenu.getNonActionItems().isEmpty()) return false;
        this.mPostedOpenRunnable = new OpenOverflowRunnable(this, new OverflowPopup(this, this.mContext, this.mMenu, (View)this.mOverflowButton, true));
        ((View)this.mMenuView).post((Runnable)this.mPostedOpenRunnable);
        return true;
    }

    public void updateMenuView(boolean bl) {
        int n;
        int n2;
        super.updateMenuView(bl);
        ((View)this.mMenuView).requestLayout();
        Object object = this.mMenu;
        int n3 = 0;
        if (object != null) {
            ArrayList arrayList = this.mMenu.getActionItems();
            n2 = arrayList.size();
            for (n = 0; n < n2; ++n) {
                object = ((MenuItemImpl)arrayList.get(n)).getSupportActionProvider();
                if (object == null) continue;
                object.setSubUiVisibilityListener((ActionProvider.SubUiVisibilityListener)this);
            }
        }
        object = this.mMenu != null ? this.mMenu.getNonActionItems() : null;
        n = n3;
        if (this.mReserveOverflow) {
            n = n3;
            if (object != null) {
                n2 = ((ArrayList)object).size();
                if (n2 == 1) {
                    n = ((MenuItemImpl)((ArrayList)object).get(0)).isActionViewExpanded() ^ 1;
                } else {
                    n = n3;
                    if (n2 > 0) {
                        n = 1;
                    }
                }
            }
        }
        if (n != 0) {
            if (this.mOverflowButton == null) {
                this.mOverflowButton = new OverflowMenuButton(this, this.mSystemContext);
            }
            if ((object = (ViewGroup)this.mOverflowButton.getParent()) != this.mMenuView) {
                if (object != null) {
                    object.removeView((View)this.mOverflowButton);
                }
                object = (ActionMenuView)this.mMenuView;
                object.addView((View)this.mOverflowButton, (ViewGroup.LayoutParams)object.generateOverflowButtonLayoutParams());
            }
        } else {
            object = this.mOverflowButton;
            if (object != null && object.getParent() == this.mMenuView) {
                ((ViewGroup)this.mMenuView).removeView((View)this.mOverflowButton);
            }
        }
        ((ActionMenuView)this.mMenuView).setOverflowReserved(this.mReserveOverflow);
    }
}
