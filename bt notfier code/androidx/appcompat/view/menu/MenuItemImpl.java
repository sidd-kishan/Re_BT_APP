/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.ActionProvider
 *  android.view.ContextMenu$ContextMenuInfo
 *  android.view.KeyEvent
 *  android.view.LayoutInflater
 *  android.view.MenuItem
 *  android.view.MenuItem$OnActionExpandListener
 *  android.view.MenuItem$OnMenuItemClickListener
 *  android.view.SubMenu
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewDebug$CapturedViewProperty
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  androidx.appcompat.R$string
 *  androidx.appcompat.content.res.AppCompatResources
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuView$ItemView
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.core.graphics.drawable.DrawableCompat
 *  androidx.core.internal.view.SupportMenuItem
 *  androidx.core.view.ActionProvider
 *  androidx.core.view.ActionProvider$VisibilityListener
 */
package androidx.appcompat.view.menu;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.internal.view.SupportMenuItem;
import androidx.core.view.ActionProvider;

public final class MenuItemImpl
implements SupportMenuItem {
    private static final int CHECKABLE = 1;
    private static final int CHECKED = 2;
    private static final int ENABLED = 16;
    private static final int EXCLUSIVE = 4;
    private static final int HIDDEN = 8;
    private static final int IS_ACTION = 32;
    static final int NO_ICON = 0;
    private static final int SHOW_AS_ACTION_MASK = 3;
    private static final String TAG = "MenuItemImpl";
    private androidx.core.view.ActionProvider mActionProvider;
    private View mActionView;
    private final int mCategoryOrder;
    private MenuItem.OnMenuItemClickListener mClickListener;
    private CharSequence mContentDescription;
    private int mFlags = 16;
    private final int mGroup;
    private boolean mHasIconTint = false;
    private boolean mHasIconTintMode = false;
    private Drawable mIconDrawable;
    private int mIconResId = 0;
    private ColorStateList mIconTintList = null;
    private PorterDuff.Mode mIconTintMode = null;
    private final int mId;
    private Intent mIntent;
    private boolean mIsActionViewExpanded = false;
    private Runnable mItemCallback;
    MenuBuilder mMenu;
    private ContextMenu.ContextMenuInfo mMenuInfo;
    private boolean mNeedToApplyIconTint = false;
    private MenuItem.OnActionExpandListener mOnActionExpandListener;
    private final int mOrdering;
    private char mShortcutAlphabeticChar;
    private int mShortcutAlphabeticModifiers = 4096;
    private char mShortcutNumericChar;
    private int mShortcutNumericModifiers = 4096;
    private int mShowAsAction = 0;
    private SubMenuBuilder mSubMenu;
    private CharSequence mTitle;
    private CharSequence mTitleCondensed;
    private CharSequence mTooltipText;

    MenuItemImpl(MenuBuilder menuBuilder, int n, int n2, int n3, int n4, CharSequence charSequence, int n5) {
        this.mMenu = menuBuilder;
        this.mId = n2;
        this.mGroup = n;
        this.mCategoryOrder = n3;
        this.mOrdering = n4;
        this.mTitle = charSequence;
        this.mShowAsAction = n5;
    }

    private static void appendModifier(StringBuilder stringBuilder, int n, int n2, String string) {
        if ((n & n2) != n2) return;
        stringBuilder.append(string);
    }

    private Drawable applyIconTintIfNecessary(Drawable drawable) {
        Drawable drawable2 = drawable;
        if (drawable == null) return drawable2;
        drawable2 = drawable;
        if (!this.mNeedToApplyIconTint) return drawable2;
        if (!this.mHasIconTint) {
            drawable2 = drawable;
            if (!this.mHasIconTintMode) return drawable2;
        }
        drawable2 = DrawableCompat.wrap((Drawable)drawable).mutate();
        if (this.mHasIconTint) {
            DrawableCompat.setTintList((Drawable)drawable2, (ColorStateList)this.mIconTintList);
        }
        if (this.mHasIconTintMode) {
            DrawableCompat.setTintMode((Drawable)drawable2, (PorterDuff.Mode)this.mIconTintMode);
        }
        this.mNeedToApplyIconTint = false;
        return drawable2;
    }

    public void actionFormatChanged() {
        this.mMenu.onItemActionRequestChanged(this);
    }

    public boolean collapseActionView() {
        if ((this.mShowAsAction & 8) == 0) {
            return false;
        }
        if (this.mActionView == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener == null) return this.mMenu.collapseItemActionView(this);
        if (!onActionExpandListener.onMenuItemActionCollapse((MenuItem)this)) return false;
        return this.mMenu.collapseItemActionView(this);
    }

    public boolean expandActionView() {
        if (!this.hasCollapsibleActionView()) {
            return false;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.mOnActionExpandListener;
        if (onActionExpandListener == null) return this.mMenu.expandItemActionView(this);
        if (!onActionExpandListener.onMenuItemActionExpand((MenuItem)this)) return false;
        return this.mMenu.expandItemActionView(this);
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        View view = this.mActionView;
        if (view != null) {
            return view;
        }
        view = this.mActionProvider;
        if (view == null) return null;
        this.mActionView = view = view.onCreateActionView((MenuItem)this);
        return view;
    }

    public int getAlphabeticModifiers() {
        return this.mShortcutAlphabeticModifiers;
    }

    public char getAlphabeticShortcut() {
        return this.mShortcutAlphabeticChar;
    }

    Runnable getCallback() {
        return this.mItemCallback;
    }

    public CharSequence getContentDescription() {
        return this.mContentDescription;
    }

    public int getGroupId() {
        return this.mGroup;
    }

    public Drawable getIcon() {
        Drawable drawable = this.mIconDrawable;
        if (drawable != null) {
            return this.applyIconTintIfNecessary(drawable);
        }
        if (this.mIconResId == 0) return null;
        drawable = AppCompatResources.getDrawable((Context)this.mMenu.getContext(), (int)this.mIconResId);
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        return this.applyIconTintIfNecessary(drawable);
    }

    public ColorStateList getIconTintList() {
        return this.mIconTintList;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.mIconTintMode;
    }

    public Intent getIntent() {
        return this.mIntent;
    }

    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.mId;
    }

    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.mMenuInfo;
    }

    public int getNumericModifiers() {
        return this.mShortcutNumericModifiers;
    }

    public char getNumericShortcut() {
        return this.mShortcutNumericChar;
    }

    public int getOrder() {
        return this.mCategoryOrder;
    }

    public int getOrdering() {
        return this.mOrdering;
    }

    char getShortcut() {
        char c = this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticChar : this.mShortcutNumericChar;
        return c;
    }

    String getShortcutLabel() {
        char c = this.getShortcut();
        if (c == '\u0000') {
            return "";
        }
        Resources resources = this.mMenu.getContext().getResources();
        StringBuilder stringBuilder = new StringBuilder();
        if (ViewConfiguration.get((Context)this.mMenu.getContext()).hasPermanentMenuKey()) {
            stringBuilder.append(resources.getString(R.string.abc_prepend_shortcut_label));
        }
        int n = this.mMenu.isQwertyMode() ? this.mShortcutAlphabeticModifiers : this.mShortcutNumericModifiers;
        MenuItemImpl.appendModifier(stringBuilder, n, 65536, resources.getString(R.string.abc_menu_meta_shortcut_label));
        MenuItemImpl.appendModifier(stringBuilder, n, 4096, resources.getString(R.string.abc_menu_ctrl_shortcut_label));
        MenuItemImpl.appendModifier(stringBuilder, n, 2, resources.getString(R.string.abc_menu_alt_shortcut_label));
        MenuItemImpl.appendModifier(stringBuilder, n, 1, resources.getString(R.string.abc_menu_shift_shortcut_label));
        MenuItemImpl.appendModifier(stringBuilder, n, 4, resources.getString(R.string.abc_menu_sym_shortcut_label));
        MenuItemImpl.appendModifier(stringBuilder, n, 8, resources.getString(R.string.abc_menu_function_shortcut_label));
        if (c != '\b') {
            if (c != '\n') {
                if (c != ' ') {
                    stringBuilder.append(c);
                } else {
                    stringBuilder.append(resources.getString(R.string.abc_menu_space_shortcut_label));
                }
            } else {
                stringBuilder.append(resources.getString(R.string.abc_menu_enter_shortcut_label));
            }
        } else {
            stringBuilder.append(resources.getString(R.string.abc_menu_delete_shortcut_label));
        }
        return stringBuilder.toString();
    }

    public SubMenu getSubMenu() {
        return this.mSubMenu;
    }

    public androidx.core.view.ActionProvider getSupportActionProvider() {
        return this.mActionProvider;
    }

    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.mTitle;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.mTitleCondensed;
        if (charSequence == null) {
            charSequence = this.mTitle;
        }
        CharSequence charSequence2 = charSequence;
        if (Build.VERSION.SDK_INT >= 18) return charSequence2;
        charSequence2 = charSequence;
        if (charSequence == null) return charSequence2;
        charSequence2 = charSequence;
        if (charSequence instanceof String) return charSequence2;
        charSequence2 = charSequence.toString();
        return charSequence2;
    }

    CharSequence getTitleForItemView(MenuView.ItemView object) {
        object = object != null && object.prefersCondensedTitle() ? this.getTitleCondensed() : this.getTitle();
        return object;
    }

    public CharSequence getTooltipText() {
        return this.mTooltipText;
    }

    public boolean hasCollapsibleActionView() {
        androidx.core.view.ActionProvider actionProvider;
        boolean bl;
        int n = this.mShowAsAction;
        boolean bl2 = bl = false;
        if ((n & 8) == 0) return bl2;
        if (this.mActionView == null && (actionProvider = this.mActionProvider) != null) {
            this.mActionView = actionProvider.onCreateActionView((MenuItem)this);
        }
        bl2 = bl;
        if (this.mActionView == null) return bl2;
        bl2 = true;
        return bl2;
    }

    public boolean hasSubMenu() {
        boolean bl = this.mSubMenu != null;
        return bl;
    }

    public boolean invoke() {
        Object object = this.mClickListener;
        if (object != null && object.onMenuItemClick((MenuItem)this)) {
            return true;
        }
        object = this.mMenu;
        if (object.dispatchMenuItemSelected((MenuBuilder)object, (MenuItem)this)) {
            return true;
        }
        object = this.mItemCallback;
        if (object != null) {
            object.run();
            return true;
        }
        if (this.mIntent != null) {
            try {
                this.mMenu.getContext().startActivity(this.mIntent);
                return true;
            }
            catch (ActivityNotFoundException activityNotFoundException) {
                Log.e((String)TAG, (String)"Can't find activity to handle intent; ignoring", (Throwable)activityNotFoundException);
            }
        }
        if ((object = this.mActionProvider) == null) return false;
        if (!object.onPerformDefaultAction()) return false;
        return true;
    }

    public boolean isActionButton() {
        boolean bl = (this.mFlags & 0x20) == 32;
        return bl;
    }

    public boolean isActionViewExpanded() {
        return this.mIsActionViewExpanded;
    }

    public boolean isCheckable() {
        int n = this.mFlags;
        boolean bl = true;
        if ((n & 1) == 1) return bl;
        bl = false;
        return bl;
    }

    public boolean isChecked() {
        boolean bl = (this.mFlags & 2) == 2;
        return bl;
    }

    public boolean isEnabled() {
        boolean bl = (this.mFlags & 0x10) != 0;
        return bl;
    }

    public boolean isExclusiveCheckable() {
        boolean bl = (this.mFlags & 4) != 0;
        return bl;
    }

    public boolean isVisible() {
        androidx.core.view.ActionProvider actionProvider = this.mActionProvider;
        boolean bl = true;
        boolean bl2 = true;
        if (actionProvider != null && actionProvider.overridesItemVisibility()) {
            bl = (this.mFlags & 8) == 0 && this.mActionProvider.isVisible() ? bl2 : false;
            return bl;
        }
        if ((this.mFlags & 8) == 0) return bl;
        bl = false;
        return bl;
    }

    public boolean requestsActionButton() {
        int n = this.mShowAsAction;
        boolean bl = true;
        if ((n & 1) == 1) return bl;
        bl = false;
        return bl;
    }

    public boolean requiresActionButton() {
        boolean bl = (this.mShowAsAction & 2) == 2;
        return bl;
    }

    public boolean requiresOverflow() {
        boolean bl = !this.requiresActionButton() && !this.requestsActionButton();
        return bl;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public SupportMenuItem setActionView(int n) {
        Context context = this.mMenu.getContext();
        this.setActionView(LayoutInflater.from((Context)context).inflate(n, (ViewGroup)new LinearLayout(context), false));
        return this;
    }

    public SupportMenuItem setActionView(View view) {
        int n;
        this.mActionView = view;
        this.mActionProvider = null;
        if (view != null && view.getId() == -1 && (n = this.mId) > 0) {
            view.setId(n);
        }
        this.mMenu.onItemActionRequestChanged(this);
        return this;
    }

    public void setActionViewExpanded(boolean bl) {
        this.mIsActionViewExpanded = bl;
        this.mMenu.onItemsChanged(false);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.mShortcutAlphabeticChar == c) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c, int n) {
        if (this.mShortcutAlphabeticChar == c && this.mShortcutAlphabeticModifiers == n) {
            return this;
        }
        this.mShortcutAlphabeticChar = Character.toLowerCase(c);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState((int)n);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setCallback(Runnable runnable) {
        this.mItemCallback = runnable;
        return this;
    }

    public MenuItem setCheckable(boolean bl) {
        int n;
        int n2 = this.mFlags;
        this.mFlags = n = bl | n2 & 0xFFFFFFFE;
        if (n2 == n) return this;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setChecked(boolean bl) {
        if ((this.mFlags & 4) != 0) {
            this.mMenu.setExclusiveItemChecked((MenuItem)this);
        } else {
            this.setCheckedInt(bl);
        }
        return this;
    }

    void setCheckedInt(boolean bl) {
        int n = this.mFlags;
        int n2 = bl ? 2 : 0;
        this.mFlags = n2 |= n & 0xFFFFFFFD;
        if (n == n2) return;
        this.mMenu.onItemsChanged(false);
    }

    public SupportMenuItem setContentDescription(CharSequence charSequence) {
        this.mContentDescription = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setEnabled(boolean bl) {
        this.mFlags = bl ? (this.mFlags |= 0x10) : (this.mFlags &= 0xFFFFFFEF);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setExclusiveCheckable(boolean bl) {
        int n = this.mFlags;
        int n2 = bl ? 4 : 0;
        this.mFlags = n2 | n & 0xFFFFFFFB;
    }

    public MenuItem setIcon(int n) {
        this.mIconDrawable = null;
        this.mIconResId = n;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.mIconResId = 0;
        this.mIconDrawable = drawable;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.mIconTintList = colorStateList;
        this.mHasIconTint = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.mIconTintMode = mode;
        this.mHasIconTintMode = true;
        this.mNeedToApplyIconTint = true;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.mIntent = intent;
        return this;
    }

    public void setIsActionButton(boolean bl) {
        this.mFlags = bl ? (this.mFlags |= 0x20) : (this.mFlags &= 0xFFFFFFDF);
    }

    void setMenuInfo(ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.mMenuInfo = contextMenuInfo;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.mShortcutNumericChar == c) {
            return this;
        }
        this.mShortcutNumericChar = c;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setNumericShortcut(char c, int n) {
        if (this.mShortcutNumericChar == c && this.mShortcutNumericModifiers == n) {
            return this;
        }
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState((int)n);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.mOnActionExpandListener = onActionExpandListener;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.mClickListener = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.mShortcutNumericChar = c;
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setShortcut(char c, char c2, int n, int n2) {
        this.mShortcutNumericChar = c;
        this.mShortcutNumericModifiers = KeyEvent.normalizeMetaState((int)n);
        this.mShortcutAlphabeticChar = Character.toLowerCase(c2);
        this.mShortcutAlphabeticModifiers = KeyEvent.normalizeMetaState((int)n2);
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public void setShowAsAction(int n) {
        int n2 = n & 3;
        if (n2 != 0 && n2 != 1) {
            if (n2 != 2) throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.mShowAsAction = n;
        this.mMenu.onItemActionRequestChanged(this);
    }

    public SupportMenuItem setShowAsActionFlags(int n) {
        this.setShowAsAction(n);
        return this;
    }

    public void setSubMenu(SubMenuBuilder subMenuBuilder) {
        this.mSubMenu = subMenuBuilder;
        subMenuBuilder.setHeaderTitle(this.getTitle());
    }

    public SupportMenuItem setSupportActionProvider(androidx.core.view.ActionProvider actionProvider) {
        androidx.core.view.ActionProvider actionProvider2 = this.mActionProvider;
        if (actionProvider2 != null) {
            actionProvider2.reset();
        }
        this.mActionView = null;
        this.mActionProvider = actionProvider;
        this.mMenu.onItemsChanged(true);
        actionProvider = this.mActionProvider;
        if (actionProvider == null) return this;
        actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)new /* Unavailable Anonymous Inner Class!! */);
        return this;
    }

    public MenuItem setTitle(int n) {
        return this.setTitle(this.mMenu.getContext().getString(n));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.mTitle = charSequence;
        this.mMenu.onItemsChanged(false);
        SubMenuBuilder subMenuBuilder = this.mSubMenu;
        if (subMenuBuilder == null) return this;
        subMenuBuilder.setHeaderTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.mTitleCondensed = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public SupportMenuItem setTooltipText(CharSequence charSequence) {
        this.mTooltipText = charSequence;
        this.mMenu.onItemsChanged(false);
        return this;
    }

    public MenuItem setVisible(boolean bl) {
        if (!this.setVisibleInt(bl)) return this;
        this.mMenu.onItemVisibleChanged(this);
        return this;
    }

    boolean setVisibleInt(boolean bl) {
        int n = this.mFlags;
        boolean bl2 = false;
        int n2 = bl ? 0 : 8;
        this.mFlags = n2 |= n & 0xFFFFFFF7;
        bl = bl2;
        if (n == n2) return bl;
        bl = true;
        return bl;
    }

    public boolean shouldShowIcon() {
        return this.mMenu.getOptionalIconsVisible();
    }

    boolean shouldShowShortcut() {
        boolean bl = this.mMenu.isShortcutsVisible() && this.getShortcut() != '\u0000';
        return bl;
    }

    public boolean showsTextAsAction() {
        boolean bl = (this.mShowAsAction & 4) == 4;
        return bl;
    }

    public String toString() {
        CharSequence charSequence = this.mTitle;
        charSequence = charSequence != null ? charSequence.toString() : null;
        return charSequence;
    }
}
