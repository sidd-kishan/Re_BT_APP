/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  androidx.appcompat.view.menu.CascadingMenuPopup
 *  androidx.appcompat.view.menu.CascadingMenuPopup$CascadingMenuInfo
 */
package androidx.appcompat.view.menu;

import android.view.ViewTreeObserver;
import androidx.appcompat.view.menu.CascadingMenuPopup;

class CascadingMenuPopup.1
implements ViewTreeObserver.OnGlobalLayoutListener {
    final CascadingMenuPopup this$0;

    CascadingMenuPopup.1(CascadingMenuPopup cascadingMenuPopup) {
        this.this$0 = cascadingMenuPopup;
    }

    public void onGlobalLayout() {
        if (!this.this$0.isShowing()) return;
        if (this.this$0.mShowingMenus.size() <= 0) return;
        if (((CascadingMenuPopup.CascadingMenuInfo)this.this$0.mShowingMenus.get((int)0)).window.isModal()) return;
        Object object = this.this$0.mShownAnchorView;
        if (object != null && object.isShown()) {
            object = this.this$0.mShowingMenus.iterator();
            while (object.hasNext()) {
                ((CascadingMenuPopup.CascadingMenuInfo)object.next()).window.show();
            }
            return;
        }
        this.this$0.dismiss();
    }
}
