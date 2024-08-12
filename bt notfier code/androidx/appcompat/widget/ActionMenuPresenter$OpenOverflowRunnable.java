/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  androidx.appcompat.widget.ActionMenuPresenter
 *  androidx.appcompat.widget.ActionMenuPresenter$OverflowPopup
 */
package androidx.appcompat.widget;

import android.view.View;
import androidx.appcompat.widget.ActionMenuPresenter;

/*
 * Exception performing whole class analysis ignored.
 */
private class ActionMenuPresenter.OpenOverflowRunnable
implements Runnable {
    private ActionMenuPresenter.OverflowPopup mPopup;
    final ActionMenuPresenter this$0;

    public ActionMenuPresenter.OpenOverflowRunnable(ActionMenuPresenter actionMenuPresenter, ActionMenuPresenter.OverflowPopup overflowPopup) {
        this.this$0 = actionMenuPresenter;
        this.mPopup = overflowPopup;
    }

    @Override
    public void run() {
        View view;
        if (ActionMenuPresenter.access$400((ActionMenuPresenter)this.this$0) != null) {
            ActionMenuPresenter.access$500((ActionMenuPresenter)this.this$0).changeMenuMode();
        }
        if ((view = (View)ActionMenuPresenter.access$600((ActionMenuPresenter)this.this$0)) != null && view.getWindowToken() != null && this.mPopup.tryShow()) {
            this.this$0.mOverflowPopup = this.mPopup;
        }
        this.this$0.mPostedOpenRunnable = null;
    }
}
