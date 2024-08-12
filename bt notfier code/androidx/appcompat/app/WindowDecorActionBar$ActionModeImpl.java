/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.Menu
 *  android.view.MenuInflater
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.appcompat.app.WindowDecorActionBar
 *  androidx.appcompat.view.ActionMode
 *  androidx.appcompat.view.ActionMode$Callback
 *  androidx.appcompat.view.SupportMenuInflater
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuBuilder$Callback
 *  androidx.appcompat.view.menu.MenuPopupHelper
 *  androidx.appcompat.view.menu.SubMenuBuilder
 */
package androidx.appcompat.app;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.WindowDecorActionBar;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.SubMenuBuilder;
import java.lang.ref.WeakReference;

/*
 * Exception performing whole class analysis ignored.
 */
public class WindowDecorActionBar.ActionModeImpl
extends ActionMode
implements MenuBuilder.Callback {
    private final Context mActionModeContext;
    private ActionMode.Callback mCallback;
    private WeakReference<View> mCustomView;
    private final MenuBuilder mMenu;
    final WindowDecorActionBar this$0;

    public WindowDecorActionBar.ActionModeImpl(WindowDecorActionBar windowDecorActionBar, Context context, ActionMode.Callback callback) {
        this.this$0 = windowDecorActionBar;
        this.mActionModeContext = context;
        this.mCallback = callback;
        windowDecorActionBar = new MenuBuilder(context).setDefaultShowAsAction(1);
        this.mMenu = windowDecorActionBar;
        windowDecorActionBar.setCallback((MenuBuilder.Callback)this);
    }

    public boolean dispatchOnCreate() {
        this.mMenu.stopDispatchingItemsChanged();
        try {
            boolean bl = this.mCallback.onCreateActionMode((ActionMode)this, (Menu)this.mMenu);
            return bl;
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }

    public void finish() {
        if (this.this$0.mActionMode != this) {
            return;
        }
        if (!WindowDecorActionBar.checkShowingFlags((boolean)this.this$0.mHiddenByApp, (boolean)this.this$0.mHiddenBySystem, (boolean)false)) {
            this.this$0.mDeferredDestroyActionMode = this;
            this.this$0.mDeferredModeDestroyCallback = this.mCallback;
        } else {
            this.mCallback.onDestroyActionMode((ActionMode)this);
        }
        this.mCallback = null;
        this.this$0.animateToMode(false);
        this.this$0.mContextView.closeMode();
        this.this$0.mDecorToolbar.getViewGroup().sendAccessibilityEvent(32);
        this.this$0.mOverlayLayout.setHideOnContentScrollEnabled(this.this$0.mHideOnContentScroll);
        this.this$0.mActionMode = null;
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
        return new SupportMenuInflater(this.mActionModeContext);
    }

    public CharSequence getSubtitle() {
        return this.this$0.mContextView.getSubtitle();
    }

    public CharSequence getTitle() {
        return this.this$0.mContextView.getTitle();
    }

    public void invalidate() {
        if (this.this$0.mActionMode != this) {
            return;
        }
        this.mMenu.stopDispatchingItemsChanged();
        try {
            this.mCallback.onPrepareActionMode((ActionMode)this, (Menu)this.mMenu);
            return;
        }
        finally {
            this.mMenu.startDispatchingItemsChanged();
        }
    }

    public boolean isTitleOptional() {
        return this.this$0.mContextView.isTitleOptional();
    }

    public void onCloseMenu(MenuBuilder menuBuilder, boolean bl) {
    }

    public void onCloseSubMenu(SubMenuBuilder subMenuBuilder) {
    }

    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
        menuBuilder = this.mCallback;
        if (menuBuilder == null) return false;
        return menuBuilder.onActionItemClicked((ActionMode)this, menuItem);
    }

    public void onMenuModeChange(MenuBuilder menuBuilder) {
        if (this.mCallback == null) {
            return;
        }
        this.invalidate();
        this.this$0.mContextView.showOverflowMenu();
    }

    public boolean onSubMenuSelected(SubMenuBuilder subMenuBuilder) {
        if (this.mCallback == null) {
            return false;
        }
        if (!subMenuBuilder.hasVisibleItems()) {
            return true;
        }
        new MenuPopupHelper(this.this$0.getThemedContext(), (MenuBuilder)subMenuBuilder).show();
        return true;
    }

    public void setCustomView(View view) {
        this.this$0.mContextView.setCustomView(view);
        this.mCustomView = new WeakReference<View>(view);
    }

    public void setSubtitle(int n) {
        this.setSubtitle(this.this$0.mContext.getResources().getString(n));
    }

    public void setSubtitle(CharSequence charSequence) {
        this.this$0.mContextView.setSubtitle(charSequence);
    }

    public void setTitle(int n) {
        this.setTitle(this.this$0.mContext.getResources().getString(n));
    }

    public void setTitle(CharSequence charSequence) {
        this.this$0.mContextView.setTitle(charSequence);
    }

    public void setTitleOptionalHint(boolean bl) {
        super.setTitleOptionalHint(bl);
        this.this$0.mContextView.setTitleOptional(bl);
    }
}
