/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.widget.ActionMenuView$OnMenuItemClickListener
 *  androidx.appcompat.widget.Toolbar
 */
package androidx.appcompat.widget;

import android.view.MenuItem;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

class Toolbar.1
implements ActionMenuView.OnMenuItemClickListener {
    final Toolbar this$0;

    Toolbar.1(Toolbar toolbar) {
        this.this$0 = toolbar;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.this$0.mOnMenuItemClickListener == null) return false;
        return this.this$0.mOnMenuItemClickListener.onMenuItemClick(menuItem);
    }
}
