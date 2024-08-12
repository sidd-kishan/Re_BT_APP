/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.CascadingMenuPopup$3
 *  androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo
 *  androidx.appcompat.view.menu.MenuBuilder
 */
package androidx.appcompat.view.menu;

import android.view.MenuItem;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;

class CascadingMenuPopup.1
implements Runnable {
    final CascadingMenuPopup.3 this$1;
    final MenuItem val$item;
    final MenuBuilder val$menu;
    final CascadingMenuPopup.CascadingMenuInfo val$nextInfo;

    CascadingMenuPopup.1(CascadingMenuPopup.3 var1_1, CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo, MenuItem menuItem, MenuBuilder menuBuilder) {
        this.this$1 = var1_1;
        this.val$nextInfo = cascadingMenuInfo;
        this.val$item = menuItem;
        this.val$menu = menuBuilder;
    }

    @Override
    public void run() {
        if (this.val$nextInfo != null) {
            this.this$1.this$0.mShouldCloseImmediately = true;
            this.val$nextInfo.menu.close(false);
            this.this$1.this$0.mShouldCloseImmediately = false;
        }
        if (!this.val$item.isEnabled()) return;
        if (!this.val$item.hasSubMenu()) return;
        this.val$menu.performItemAction(this.val$item, 4);
    }
}
