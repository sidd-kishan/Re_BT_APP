/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ActionProvider
 *  android.view.ActionProvider$VisibilityListener
 *  android.view.MenuItem
 *  android.view.View
 *  androidx.appcompat.view.menu.MenuItemWrapperICS
 *  androidx.appcompat.view.menu.MenuItemWrapperICS$ActionProviderWrapper
 *  androidx.core.view.ActionProvider$VisibilityListener
 */
package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.ActionProvider;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.MenuItemWrapperICS;
import androidx.core.view.ActionProvider;

private class MenuItemWrapperICS.ActionProviderWrapperJB
extends MenuItemWrapperICS.ActionProviderWrapper
implements ActionProvider.VisibilityListener {
    private ActionProvider.VisibilityListener mListener;
    final MenuItemWrapperICS this$0;

    MenuItemWrapperICS.ActionProviderWrapperJB(MenuItemWrapperICS menuItemWrapperICS, Context context, ActionProvider actionProvider) {
        this.this$0 = menuItemWrapperICS;
        super(menuItemWrapperICS, context, actionProvider);
    }

    public boolean isVisible() {
        return this.mInner.isVisible();
    }

    public void onActionProviderVisibilityChanged(boolean bl) {
        ActionProvider.VisibilityListener visibilityListener = this.mListener;
        if (visibilityListener == null) return;
        visibilityListener.onActionProviderVisibilityChanged(bl);
    }

    public View onCreateActionView(MenuItem menuItem) {
        return this.mInner.onCreateActionView(menuItem);
    }

    public boolean overridesItemVisibility() {
        return this.mInner.overridesItemVisibility();
    }

    public void refreshVisibility() {
        this.mInner.refreshVisibility();
    }

    public void setVisibilityListener(ActionProvider.VisibilityListener object) {
        this.mListener = object;
        ActionProvider actionProvider = this.mInner;
        object = object != null ? this : null;
        actionProvider.setVisibilityListener((ActionProvider.VisibilityListener)object);
    }
}
