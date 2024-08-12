/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Menu
 *  android.view.View
 *  android.view.Window$Callback
 *  androidx.appcompat.app.ToolbarActionBar
 *  androidx.appcompat.view.WindowCallbackWrapper
 */
package androidx.appcompat.app;

import android.view.Menu;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.view.WindowCallbackWrapper;

private class ToolbarActionBar.ToolbarCallbackWrapper
extends WindowCallbackWrapper {
    final ToolbarActionBar this$0;

    public ToolbarActionBar.ToolbarCallbackWrapper(ToolbarActionBar toolbarActionBar, Window.Callback callback) {
        this.this$0 = toolbarActionBar;
        super(callback);
    }

    public View onCreatePanelView(int n) {
        if (n != 0) return super.onCreatePanelView(n);
        return new View(this.this$0.mDecorToolbar.getContext());
    }

    public boolean onPreparePanel(int n, View view, Menu menu) {
        boolean bl = super.onPreparePanel(n, view, menu);
        if (!bl) return bl;
        if (this.this$0.mToolbarMenuPrepared) return bl;
        this.this$0.mDecorToolbar.setMenuPrepared();
        this.this$0.mToolbarMenuPrepared = true;
        return bl;
    }
}
