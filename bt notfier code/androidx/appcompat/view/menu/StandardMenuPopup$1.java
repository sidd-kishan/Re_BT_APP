/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.appcompat.view.menu.StandardMenuPopup
 */
package androidx.appcompat.view.menu;

import android.view.View;
import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.StandardMenuPopup;

class StandardMenuPopup.1
implements ViewTreeObserver.OnGlobalLayoutListener {
    final StandardMenuPopup this$0;

    StandardMenuPopup.1(StandardMenuPopup standardMenuPopup) {
        this.this$0 = standardMenuPopup;
    }

    public void onGlobalLayout() {
        if (!this.this$0.isShowing()) return;
        if (this.this$0.mPopup.isModal()) return;
        View view = this.this$0.mShownAnchorView;
        if (view != null && view.isShown()) {
            this.this$0.mPopup.show();
        } else {
            this.this$0.dismiss();
        }
    }
}
