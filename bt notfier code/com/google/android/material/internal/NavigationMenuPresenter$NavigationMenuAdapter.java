/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.util.SparseArray
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.core.view.ViewCompat
 *  androidx.recyclerview.widget.RecyclerView$Adapter
 *  com.google.android.material.internal.NavigationMenuItemView
 *  com.google.android.material.internal.NavigationMenuPresenter
 *  com.google.android.material.internal.NavigationMenuPresenter$HeaderViewHolder
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuHeaderItem
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuItem
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuSeparatorItem
 *  com.google.android.material.internal.NavigationMenuPresenter$NavigationMenuTextItem
 *  com.google.android.material.internal.NavigationMenuPresenter$NormalViewHolder
 *  com.google.android.material.internal.NavigationMenuPresenter$SeparatorViewHolder
 *  com.google.android.material.internal.NavigationMenuPresenter$SubheaderViewHolder
 *  com.google.android.material.internal.NavigationMenuPresenter$ViewHolder
 *  com.google.android.material.internal.ParcelableSparseArray
 */
package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.internal.NavigationMenuItemView;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ParcelableSparseArray;
import java.util.ArrayList;

private class NavigationMenuPresenter.NavigationMenuAdapter
extends RecyclerView.Adapter<NavigationMenuPresenter.ViewHolder> {
    private static final String STATE_ACTION_VIEWS = "android:menu:action_views";
    private static final String STATE_CHECKED_ITEM = "android:menu:checked";
    private static final int VIEW_TYPE_HEADER = 3;
    private static final int VIEW_TYPE_NORMAL = 0;
    private static final int VIEW_TYPE_SEPARATOR = 2;
    private static final int VIEW_TYPE_SUBHEADER = 1;
    private MenuItemImpl checkedItem;
    private final ArrayList<NavigationMenuPresenter.NavigationMenuItem> items;
    final NavigationMenuPresenter this$0;
    private boolean updateSuspended;

    NavigationMenuPresenter.NavigationMenuAdapter(NavigationMenuPresenter navigationMenuPresenter) {
        this.this$0 = navigationMenuPresenter;
        this.items = new ArrayList();
        this.prepareMenuItems();
    }

    private void appendTransparentIconIfMissing(int n, int n2) {
        while (n < n2) {
            ((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get((int)n)).needsEmptyIcon = true;
            ++n;
        }
    }

    private void prepareMenuItems() {
        if (this.updateSuspended) {
            return;
        }
        this.updateSuspended = true;
        this.items.clear();
        this.items.add((NavigationMenuPresenter.NavigationMenuItem)new NavigationMenuPresenter.NavigationMenuHeaderItem());
        int n = -1;
        int n2 = this.this$0.menu.getVisibleItems().size();
        int n3 = 0;
        boolean bl = false;
        int n4 = 0;
        while (true) {
            NavigationMenuPresenter.NavigationMenuTextItem navigationMenuTextItem;
            int n5;
            int n6;
            boolean bl2;
            int n7;
            if (n3 >= n2) {
                this.updateSuspended = false;
                return;
            }
            MenuItemImpl menuItemImpl = (MenuItemImpl)this.this$0.menu.getVisibleItems().get(n3);
            if (menuItemImpl.isChecked()) {
                this.setCheckedItem(menuItemImpl);
            }
            if (menuItemImpl.isCheckable()) {
                menuItemImpl.setExclusiveCheckable(false);
            }
            if (menuItemImpl.hasSubMenu()) {
                SubMenu subMenu = menuItemImpl.getSubMenu();
                n7 = n;
                bl2 = bl;
                n6 = n4;
                if (subMenu.hasVisibleItems()) {
                    if (n3 != 0) {
                        this.items.add((NavigationMenuPresenter.NavigationMenuItem)new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.this$0.paddingSeparator, 0));
                    }
                    this.items.add((NavigationMenuPresenter.NavigationMenuItem)new NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl));
                    int n8 = this.items.size();
                    int n9 = subMenu.size();
                    n5 = 0;
                    for (n7 = 0; n7 < n9; ++n7) {
                        navigationMenuTextItem = (MenuItemImpl)subMenu.getItem(n7);
                        n6 = n5;
                        if (navigationMenuTextItem.isVisible()) {
                            n6 = n5;
                            if (n5 == 0) {
                                n6 = n5;
                                if (navigationMenuTextItem.getIcon() != null) {
                                    n6 = 1;
                                }
                            }
                            if (navigationMenuTextItem.isCheckable()) {
                                navigationMenuTextItem.setExclusiveCheckable(false);
                            }
                            if (menuItemImpl.isChecked()) {
                                this.setCheckedItem(menuItemImpl);
                            }
                            this.items.add((NavigationMenuPresenter.NavigationMenuItem)new NavigationMenuPresenter.NavigationMenuTextItem((MenuItemImpl)navigationMenuTextItem));
                        }
                        n5 = n6;
                    }
                    n7 = n;
                    bl2 = bl;
                    n6 = n4;
                    if (n5 != 0) {
                        this.appendTransparentIconIfMissing(n8, this.items.size());
                        n7 = n;
                        bl2 = bl;
                        n6 = n4;
                    }
                }
            } else {
                n7 = menuItemImpl.getGroupId();
                if (n7 != n) {
                    n4 = this.items.size();
                    bl = menuItemImpl.getIcon() != null;
                    bl2 = bl;
                    n5 = n4;
                    if (n3 != 0) {
                        n5 = n4 + 1;
                        this.items.add((NavigationMenuPresenter.NavigationMenuItem)new NavigationMenuPresenter.NavigationMenuSeparatorItem(this.this$0.paddingSeparator, this.this$0.paddingSeparator));
                        bl2 = bl;
                    }
                } else {
                    bl2 = bl;
                    n5 = n4;
                    if (!bl) {
                        bl2 = bl;
                        n5 = n4;
                        if (menuItemImpl.getIcon() != null) {
                            this.appendTransparentIconIfMissing(n4, this.items.size());
                            bl2 = true;
                            n5 = n4;
                        }
                    }
                }
                navigationMenuTextItem = new NavigationMenuPresenter.NavigationMenuTextItem(menuItemImpl);
                navigationMenuTextItem.needsEmptyIcon = bl2;
                this.items.add((NavigationMenuPresenter.NavigationMenuItem)navigationMenuTextItem);
                n6 = n5;
            }
            ++n3;
            n = n7;
            bl = bl2;
            n4 = n6;
        }
    }

    public Bundle createInstanceState() {
        Bundle bundle = new Bundle();
        Object object = this.checkedItem;
        if (object != null) {
            bundle.putInt(STATE_CHECKED_ITEM, object.getItemId());
        }
        SparseArray sparseArray = new SparseArray();
        int n = 0;
        int n2 = this.items.size();
        while (true) {
            MenuItemImpl menuItemImpl;
            if (n >= n2) {
                bundle.putSparseParcelableArray(STATE_ACTION_VIEWS, sparseArray);
                return bundle;
            }
            object = this.items.get(n);
            if (object instanceof NavigationMenuPresenter.NavigationMenuTextItem && (object = (menuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)object).getMenuItem()) != null ? menuItemImpl.getActionView() : null) != null) {
                ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
                object.saveHierarchyState((SparseArray)parcelableSparseArray);
                sparseArray.put(menuItemImpl.getItemId(), (Object)parcelableSparseArray);
            }
            ++n;
        }
    }

    public MenuItemImpl getCheckedItem() {
        return this.checkedItem;
    }

    public int getItemCount() {
        return this.items.size();
    }

    public long getItemId(int n) {
        return n;
    }

    public int getItemViewType(int n) {
        NavigationMenuPresenter.NavigationMenuItem navigationMenuItem = this.items.get(n);
        if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuSeparatorItem) {
            return 2;
        }
        if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuHeaderItem) {
            return 3;
        }
        if (!(navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem)) throw new RuntimeException("Unknown item type.");
        if (!((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).getMenuItem().hasSubMenu()) return 0;
        return 1;
    }

    public void onBindViewHolder(NavigationMenuPresenter.ViewHolder object, int n) {
        int n2 = this.getItemViewType(n);
        if (n2 != 0) {
            if (n2 != 1) {
                if (n2 != 2) return;
                NavigationMenuPresenter.NavigationMenuSeparatorItem navigationMenuSeparatorItem = (NavigationMenuPresenter.NavigationMenuSeparatorItem)this.items.get(n);
                object.itemView.setPadding(0, navigationMenuSeparatorItem.getPaddingTop(), 0, navigationMenuSeparatorItem.getPaddingBottom());
            } else {
                ((TextView)object.itemView).setText(((NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(n)).getMenuItem().getTitle());
            }
        } else {
            NavigationMenuItemView navigationMenuItemView = (NavigationMenuItemView)object.itemView;
            navigationMenuItemView.setIconTintList(this.this$0.iconTintList);
            if (this.this$0.textAppearanceSet) {
                navigationMenuItemView.setTextAppearance(this.this$0.textAppearance);
            }
            if (this.this$0.textColor != null) {
                navigationMenuItemView.setTextColor(this.this$0.textColor);
            }
            object = this.this$0.itemBackground != null ? this.this$0.itemBackground.getConstantState().newDrawable() : null;
            ViewCompat.setBackground((View)navigationMenuItemView, (Drawable)object);
            object = (NavigationMenuPresenter.NavigationMenuTextItem)this.items.get(n);
            navigationMenuItemView.setNeedsEmptyIcon(object.needsEmptyIcon);
            navigationMenuItemView.setHorizontalPadding(this.this$0.itemHorizontalPadding);
            navigationMenuItemView.setIconPadding(this.this$0.itemIconPadding);
            navigationMenuItemView.initialize(object.getMenuItem(), 0);
        }
    }

    public NavigationMenuPresenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int n) {
        if (n == 0) return new NavigationMenuPresenter.NormalViewHolder(this.this$0.layoutInflater, viewGroup, this.this$0.onClickListener);
        if (n == 1) return new NavigationMenuPresenter.SubheaderViewHolder(this.this$0.layoutInflater, viewGroup);
        if (n == 2) return new NavigationMenuPresenter.SeparatorViewHolder(this.this$0.layoutInflater, viewGroup);
        if (n == 3) return new NavigationMenuPresenter.HeaderViewHolder((View)this.this$0.headerLayout);
        return null;
    }

    public void onViewRecycled(NavigationMenuPresenter.ViewHolder viewHolder) {
        if (!(viewHolder instanceof NavigationMenuPresenter.NormalViewHolder)) return;
        ((NavigationMenuItemView)viewHolder.itemView).recycle();
    }

    public void restoreInstanceState(Bundle bundle) {
        NavigationMenuPresenter.NavigationMenuItem navigationMenuItem;
        int n;
        int n2;
        int n3 = 0;
        int n4 = bundle.getInt(STATE_CHECKED_ITEM, 0);
        if (n4 != 0) {
            this.updateSuspended = true;
            n2 = this.items.size();
            for (n = 0; n < n2; ++n) {
                navigationMenuItem = this.items.get(n);
                if (!(navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem) || (navigationMenuItem = ((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).getMenuItem()) == null || navigationMenuItem.getItemId() != n4) continue;
                this.setCheckedItem((MenuItemImpl)navigationMenuItem);
                break;
            }
            this.updateSuspended = false;
            this.prepareMenuItems();
        }
        if ((bundle = bundle.getSparseParcelableArray(STATE_ACTION_VIEWS)) == null) return;
        n2 = this.items.size();
        n = n3;
        while (n < n2) {
            MenuItemImpl menuItemImpl;
            navigationMenuItem = this.items.get(n);
            if (navigationMenuItem instanceof NavigationMenuPresenter.NavigationMenuTextItem && (menuItemImpl = ((NavigationMenuPresenter.NavigationMenuTextItem)navigationMenuItem).getMenuItem()) != null && (navigationMenuItem = menuItemImpl.getActionView()) != null && (menuItemImpl = (ParcelableSparseArray)bundle.get(menuItemImpl.getItemId())) != null) {
                navigationMenuItem.restoreHierarchyState((SparseArray)menuItemImpl);
            }
            ++n;
        }
    }

    public void setCheckedItem(MenuItemImpl menuItemImpl) {
        if (this.checkedItem == menuItemImpl) return;
        if (!menuItemImpl.isCheckable()) return;
        MenuItemImpl menuItemImpl2 = this.checkedItem;
        if (menuItemImpl2 != null) {
            menuItemImpl2.setChecked(false);
        }
        this.checkedItem = menuItemImpl;
        menuItemImpl.setChecked(true);
    }

    public void setUpdateSuspended(boolean bl) {
        this.updateSuspended = bl;
    }

    public void update() {
        this.prepareMenuItems();
        this.notifyDataSetChanged();
    }
}
