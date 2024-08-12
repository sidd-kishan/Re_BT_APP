/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.app.ToolbarActionBar
 *  androidx.appcompat.widget.Toolbar$OnMenuItemClickListener
 */
package androidx.appcompat.app;

import android.view.MenuItem;
import androidx.appcompat.app.ToolbarActionBar;
import androidx.appcompat.widget.Toolbar;

class ToolbarActionBar.2
implements Toolbar.OnMenuItemClickListener {
    final ToolbarActionBar this$0;

    ToolbarActionBar.2(ToolbarActionBar toolbarActionBar) {
        this.this$0 = toolbarActionBar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        return this.this$0.mWindowCallback.onMenuItemSelected(0, menuItem);
    }
}
