/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.view.MenuItem
 *  androidx.appcompat.view.menu.CascadingMenuPopup
 *  androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.widget.MenuItemHoverListener
 */
package androidx.appcompat.view.menu;

import android.os.Handler;
import android.os.SystemClock;
import android.view.MenuItem;
import androidx.appcompat.view.menu.CascadingMenuPopup;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.MenuItemHoverListener;

class CascadingMenuPopup.3
implements MenuItemHoverListener {
    final CascadingMenuPopup this$0;

    CascadingMenuPopup.3(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    public void onItemHoverEnter(MenuBuilder menuBuilder, MenuItem menuItem) {
        int n;
        CascadingMenuPopup.CascadingMenuInfo cascadingMenuInfo;
        block4: {
            Handler handler = this.this$0.mSubMenuHoverHandler;
            cascadingMenuInfo = null;
            handler.removeCallbacksAndMessages(null);
            int n2 = this.this$0.mShowingMenus.size();
            for (n = 0; n < n2; ++n) {
                if (menuBuilder != ((CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get((int)n)).menu) {
                    continue;
                }
                break block4;
            }
            n = -1;
        }
        if (n == -1) {
            return;
        }
        if (++n < this.this$0.mShowingMenus.size()) {
            cascadingMenuInfo = (CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get(n);
        }
        menuItem = new /* Unavailable Anonymous Inner Class!! */;
        long l = SystemClock.uptimeMillis();
        this.this$0.mSubMenuHoverHandler.postAtTime((Runnable)menuItem, (Object)menuBuilder, l + 200L);
    }

    public void onItemHoverExit(MenuBuilder menuBuilder, MenuItem menuItem) {
        this.this$0.mSubMenuHoverHandler.removeCallbacksAndMessages((Object)menuBuilder);
    }
}
