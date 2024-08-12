/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPopupHelper
 *  androidx.appcompat.view.menu.SubMenuBuilder
 *  androidx.appcompat.widget.ActionBarContextView
 */
package androidx.appcompat.view;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import androidx.appcompat.widget.ActionBarContextView;
import java.lang.ref.WeakReference;

public class StandaloneActionMode
extends ActionMode
implements MenuBuilder.Callback {
    private ActionMode.Callback mCallback;
    private Context mContext;
    private ActionBarContextView mContextView;
    private WeakReference<View> mCustomView;
    private boolean mFinished;
    private boolean mFocusable;
    private MenuBuilder mMenu;

    public StandaloneActionMode(Context context, ActionBarContextView actionBarContextView, ActionMode.Callback callback, boolean bl) {
        this.mContext = context;
        this.mContextView = actionBarContextView;
        this.mCallback = callback;
        context = new MenuBuilder(actionBarContextView.getContext()).setDefaultShowAsAction(1);
        this.mMenu = context;
        context.setCallback((MenuBuilder.Callback)this);
        this.mFocusable = bl;
    }

    public void finish() {
        if (this.mFinished) {
            return;
        }
        this.mFinished = true;
        this.mContextView.sendAccessibilityEvent(32);
        this.mCallback.onDestroyActionMode((ActionMode)this);
    }

    public View getCustomView() {
        Object object = this.mCustomView;
        object = object != null ? (View)object.get() : null;
        return object;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContextView.getContext());
    }

    public CharSequence getSubtitle() {
        return this.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.mContextView.getTitle();
    }

    public void invalidate() {
        this.mCallback.onPrepareActionMode((ActionMode)this, (Menu)this.mMenu);
    }

    public boolean isTitleOptional() {
        return this.mContextView.isTitleOptional();
    }

    public boolean isUiFocusable() {
        return this.mFocusable;
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        return this.mCallback.onActionItemClicked((ActionMode)this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        this.invalidate();
        this.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.mContextView.getContext(), (MenuBuilder)subMenuBuilder).show();
        return true;
    }

    public void setCustomView(View object) {
        this.mContextView.setCustomView(object);
        object = object != null ? new WeakReference<View>((View)object) : null;
        this.mCustomView = object;
    }

    public void setSubtitle(int n) {
        this.setSubtitle(this.mContext.getString(n));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(int n) {
        this.setTitle(this.mContext.getString(n));
    }

    public void setTitle(CharSequence charSequence) {
        this.mContextView.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean bl) {
        super.setTitleOptionalHint(bl);
        this.mContextView.setTitleOptional(bl);
    }
}
