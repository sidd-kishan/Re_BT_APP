/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  android.view.View
 *  android.view.View$OnClickListener
 *  androidx.appcompat.view.menu.ActionMenuItem
 *  androidx.appcompat.widget.ToolbarWidgetWrapper
 */
package androidx.appcompat.widget;

import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItem;
import androidx.appcompat.widget.ToolbarWidgetWrapper;

class ToolbarWidgetWrapper.1
implements View.OnClickListener {
    final ActionMenuItem mNavItem;
    final ToolbarWidgetWrapper this$0;

    ToolbarWidgetWrapper.1(ToolbarWidgetWrapper toolbarWidgetWrapper) {
        this.this$0 = toolbarWidgetWrapper;
        this.mNavItem = new ActionMenuItem(this.this$0.mToolbar.getContext(), 0, 16908332, 0, 0, this.this$0.mTitle);
    }

    public void onClick(View view) {
        if (this.this$0.mWindowCallback == null) return;
        if (!this.this$0.mMenuPrepared) return;
        this.this$0.mWindowCallback.onMenuItemSelected(0, (MenuItem)this.mNavItem);
    }
}
