/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  androidx.appcompat.R$attr
 *  androidx.appcompat.view.menu.MenuBuilder
 *  androidx.appcompat.view.menu.MenuPopupHelper
 *  androidx.appcompat.view.menu.MenuPresenter$Callback
 *  androidx.appcompat.widget.ActionMenuPresenter
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.ActionMenuPresenter;

/*
 * Exception performing whole class analysis ignored.
 */
private class ActionMenuPresenter.OverflowPopup
extends MenuPopupHelper {
    final ActionMenuPresenter this$0;

    public ActionMenuPresenter.OverflowPopup(ActionMenuPresenter actionMenuPresenter, Context context, MenuBuilder menuBuilder, View view, boolean bl) {
        this.this$0 = actionMenuPresenter;
        super(context, menuBuilder, view, bl, R.attr.actionOverflowMenuStyle);
        this.setGravity(0x800005);
        this.setPresenterCallback((MenuPresenter.Callback)actionMenuPresenter.mPopupPresenterCallback);
    }

    protected void onDismiss() {
        if (ActionMenuPresenter.access$000((ActionMenuPresenter)this.this$0) != null) {
            ActionMenuPresenter.access$100((ActionMenuPresenter)this.this$0).close();
        }
        this.this$0.mOverflowPopup = null;
        super.onDismiss();
    }
}
