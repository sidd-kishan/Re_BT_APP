/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.widget.PopupWindow$OnDismissListener
 *  androidx.appcompat.view.menu.MenuPopupHelper
 */
package androidx.appcompat.view.menu;

import android.widget.PopupWindow;
import androidx.appcompat.view.menu.MenuPopupHelper;

class MenuPopupHelper.1
implements PopupWindow.OnDismissListener {
    final MenuPopupHelper this$0;

    MenuPopupHelper.1(MenuPopupHelper menuPopupHelper) {
        this.this$0 = menuPopupHelper;
    }

    public void onDismiss() {
        this.this$0.onDismiss();
    }
}
