/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.util.Log
 *  android.view.Menu
 *  android.view.MenuItem
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  androidx.appcompat.R$styleable
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.SupportMenuInflater$InflatedOnMenuItemClickListener
 *  androidx.appcompat.view.menu.MenuItemImpl
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 *  androidx.appcompat.widget.DrawableUtils
 *  androidx.appcompat.widget.TintTypedArray
 *  androidx.core.view.ActionProvider
 *  androidx.core.view.MenuItemCompat
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.appcompat.widget.DrawableUtils;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.view.ActionProvider;
import androidx.core.view.MenuItemCompat;

private class SupportMenuInflater.MenuState {
    private static final int defaultGroupId = 0;
    private static final int defaultItemCategory = 0;
    private static final int defaultItemCheckable = 0;
    private static final boolean defaultItemChecked = false;
    private static final boolean defaultItemEnabled = true;
    private static final int defaultItemId = 0;
    private static final int defaultItemOrder = 0;
    private static final boolean defaultItemVisible = true;
    private int groupCategory;
    private int groupCheckable;
    private boolean groupEnabled;
    private int groupId;
    private int groupOrder;
    private boolean groupVisible;
    ActionProvider itemActionProvider;
    private String itemActionProviderClassName;
    private String itemActionViewClassName;
    private int itemActionViewLayout;
    private boolean itemAdded;
    private int itemAlphabeticModifiers;
    private char itemAlphabeticShortcut;
    private int itemCategoryOrder;
    private int itemCheckable;
    private boolean itemChecked;
    private CharSequence itemContentDescription;
    private boolean itemEnabled;
    private int itemIconResId;
    private ColorStateList itemIconTintList;
    private PorterDuff.Mode itemIconTintMode;
    private int itemId;
    private String itemListenerMethodName;
    private int itemNumericModifiers;
    private char itemNumericShortcut;
    private int itemShowAsAction;
    private CharSequence itemTitle;
    private CharSequence itemTitleCondensed;
    private CharSequence itemTooltipText;
    private boolean itemVisible;
    private Menu menu;
    final SupportMenuInflater this$0;

    public SupportMenuInflater.MenuState(SupportMenuInflater supportMenuInflater, Menu menu) {
        this.this$0 = supportMenuInflater;
        this.itemIconTintList = null;
        this.itemIconTintMode = null;
        this.menu = menu;
        this.resetGroup();
    }

    private char getShortcut(String string) {
        if (string != null) return string.charAt(0);
        return '\u0000';
    }

    private <T> T newInstance(String string, Class<?>[] object, Object[] objectArray) {
        try {
            object = Class.forName(string, false, this.this$0.mContext.getClassLoader()).getConstructor((Class<?>)object);
            object.setAccessible(true);
            object = object.newInstance(objectArray);
        }
        catch (Exception exception) {
            object = new StringBuilder();
            object.append("Cannot instantiate class: ");
            object.append(string);
            Log.w((String)"SupportMenuInflater", (String)object.toString(), (Throwable)exception);
            return null;
        }
        return (T)object;
    }

    private void setItem(MenuItem menuItem) {
        Object object = menuItem.setChecked(this.itemChecked).setVisible(this.itemVisible).setEnabled(this.itemEnabled);
        int n = this.itemCheckable;
        boolean bl = false;
        boolean bl2 = n >= 1;
        object.setCheckable(bl2).setTitleCondensed(this.itemTitleCondensed).setIcon(this.itemIconResId);
        n = this.itemShowAsAction;
        if (n >= 0) {
            menuItem.setShowAsAction(n);
        }
        if (this.itemListenerMethodName != null) {
            if (this.this$0.mContext.isRestricted()) throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
            menuItem.setOnMenuItemClickListener((MenuItem.OnMenuItemClickListener)new SupportMenuInflater.InflatedOnMenuItemClickListener(this.this$0.getRealOwner(), this.itemListenerMethodName));
        }
        if (this.itemCheckable >= 2) {
            if (menuItem instanceof MenuItemImpl) {
                ((MenuItemImpl)menuItem).setExclusiveCheckable(true);
            } else if (menuItem instanceof MenuItemWrapperICS) {
                ((MenuItemWrapperICS)menuItem).setExclusiveCheckable(true);
            }
        }
        if ((object = this.itemActionViewClassName) != null) {
            menuItem.setActionView((View)this.newInstance((String)object, SupportMenuInflater.ACTION_VIEW_CONSTRUCTOR_SIGNATURE, this.this$0.mActionViewConstructorArguments));
            bl = true;
        }
        if ((n = this.itemActionViewLayout) > 0) {
            if (!bl) {
                menuItem.setActionView(n);
            } else {
                Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
            }
        }
        if ((object = this.itemActionProvider) != null) {
            MenuItemCompat.setActionProvider((MenuItem)menuItem, (ActionProvider)object);
        }
        MenuItemCompat.setContentDescription((MenuItem)menuItem, (CharSequence)this.itemContentDescription);
        MenuItemCompat.setTooltipText((MenuItem)menuItem, (CharSequence)this.itemTooltipText);
        MenuItemCompat.setAlphabeticShortcut((MenuItem)menuItem, (char)this.itemAlphabeticShortcut, (int)this.itemAlphabeticModifiers);
        MenuItemCompat.setNumericShortcut((MenuItem)menuItem, (char)this.itemNumericShortcut, (int)this.itemNumericModifiers);
        object = this.itemIconTintMode;
        if (object != null) {
            MenuItemCompat.setIconTintMode((MenuItem)menuItem, (PorterDuff.Mode)object);
        }
        if ((object = this.itemIconTintList) == null) return;
        MenuItemCompat.setIconTintList((MenuItem)menuItem, (ColorStateList)object);
    }

    public void addItem() {
        this.itemAdded = true;
        this.setItem(this.menu.add(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle));
    }

    public SubMenu addSubMenuItem() {
        this.itemAdded = true;
        SubMenu subMenu = this.menu.addSubMenu(this.groupId, this.itemId, this.itemCategoryOrder, this.itemTitle);
        this.setItem(subMenu.getItem());
        return subMenu;
    }

    public boolean hasAddedItem() {
        return this.itemAdded;
    }

    public void readGroup(AttributeSet attributeSet) {
        attributeSet = this.this$0.mContext.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
        this.groupId = attributeSet.getResourceId(R.styleable.MenuGroup_android_id, 0);
        this.groupCategory = attributeSet.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
        this.groupOrder = attributeSet.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
        this.groupCheckable = attributeSet.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
        this.groupVisible = attributeSet.getBoolean(R.styleable.MenuGroup_android_visible, true);
        this.groupEnabled = attributeSet.getBoolean(R.styleable.MenuGroup_android_enabled, true);
        attributeSet.recycle();
    }

    public void readItem(AttributeSet object) {
        TintTypedArray tintTypedArray = TintTypedArray.obtainStyledAttributes((Context)this.this$0.mContext, (AttributeSet)object, (int[])R.styleable.MenuItem);
        this.itemId = tintTypedArray.getResourceId(R.styleable.MenuItem_android_id, 0);
        this.itemCategoryOrder = tintTypedArray.getInt(R.styleable.MenuItem_android_menuCategory, this.groupCategory) & 0xFFFF0000 | tintTypedArray.getInt(R.styleable.MenuItem_android_orderInCategory, this.groupOrder) & 0xFFFF;
        this.itemTitle = tintTypedArray.getText(R.styleable.MenuItem_android_title);
        this.itemTitleCondensed = tintTypedArray.getText(R.styleable.MenuItem_android_titleCondensed);
        this.itemIconResId = tintTypedArray.getResourceId(R.styleable.MenuItem_android_icon, 0);
        this.itemAlphabeticShortcut = this.getShortcut(tintTypedArray.getString(R.styleable.MenuItem_android_alphabeticShortcut));
        this.itemAlphabeticModifiers = tintTypedArray.getInt(R.styleable.MenuItem_alphabeticModifiers, 4096);
        this.itemNumericShortcut = this.getShortcut(tintTypedArray.getString(R.styleable.MenuItem_android_numericShortcut));
        this.itemNumericModifiers = tintTypedArray.getInt(R.styleable.MenuItem_numericModifiers, 4096);
        this.itemCheckable = tintTypedArray.hasValue(R.styleable.MenuItem_android_checkable) ? (int)(tintTypedArray.getBoolean(R.styleable.MenuItem_android_checkable, false) ? 1 : 0) : this.groupCheckable;
        this.itemChecked = tintTypedArray.getBoolean(R.styleable.MenuItem_android_checked, false);
        this.itemVisible = tintTypedArray.getBoolean(R.styleable.MenuItem_android_visible, this.groupVisible);
        this.itemEnabled = tintTypedArray.getBoolean(R.styleable.MenuItem_android_enabled, this.groupEnabled);
        this.itemShowAsAction = tintTypedArray.getInt(R.styleable.MenuItem_showAsAction, -1);
        this.itemListenerMethodName = tintTypedArray.getString(R.styleable.MenuItem_android_onClick);
        this.itemActionViewLayout = tintTypedArray.getResourceId(R.styleable.MenuItem_actionLayout, 0);
        this.itemActionViewClassName = tintTypedArray.getString(R.styleable.MenuItem_actionViewClass);
        this.itemActionProviderClassName = object = tintTypedArray.getString(R.styleable.MenuItem_actionProviderClass);
        boolean bl = object != null;
        if (bl && this.itemActionViewLayout == 0 && this.itemActionViewClassName == null) {
            this.itemActionProvider = (ActionProvider)this.newInstance(this.itemActionProviderClassName, SupportMenuInflater.ACTION_PROVIDER_CONSTRUCTOR_SIGNATURE, this.this$0.mActionProviderConstructorArguments);
        } else {
            if (bl) {
                Log.w((String)"SupportMenuInflater", (String)"Ignoring attribute 'actionProviderClass'. Action view already specified.");
            }
            this.itemActionProvider = null;
        }
        this.itemContentDescription = tintTypedArray.getText(R.styleable.MenuItem_contentDescription);
        this.itemTooltipText = tintTypedArray.getText(R.styleable.MenuItem_tooltipText);
        this.itemIconTintMode = tintTypedArray.hasValue(R.styleable.MenuItem_iconTintMode) ? DrawableUtils.parseTintMode((int)tintTypedArray.getInt(R.styleable.MenuItem_iconTintMode, -1), (PorterDuff.Mode)this.itemIconTintMode) : null;
        this.itemIconTintList = tintTypedArray.hasValue(R.styleable.MenuItem_iconTint) ? tintTypedArray.getColorStateList(R.styleable.MenuItem_iconTint) : null;
        tintTypedArray.recycle();
        this.itemAdded = false;
    }

    public void resetGroup() {
        this.groupId = 0;
        this.groupCategory = 0;
        this.groupOrder = 0;
        this.groupCheckable = 0;
        this.groupVisible = true;
        this.groupEnabled = true;
    }
}
